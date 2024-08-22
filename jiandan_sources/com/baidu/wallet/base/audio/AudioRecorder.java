package com.baidu.wallet.base.audio;

import android.media.AudioRecord;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
import java.util.Observable;

public class AudioRecorder extends Observable implements Runnable {
    public AudioRecord a;
    public State b;
    public byte[] c;

    public enum State {
        INIT,
        OPEN,
        RUNNING,
        STOP,
        DESTROY
    }

    public static final class a {
        public static final AudioRecorder a = new AudioRecorder();
    }

    private void a(State state) {
        this.b = state;
        setChanged();
        notifyObservers(state);
    }

    public static AudioRecorder getInstance() {
        return a.a;
    }

    public void end() {
        if (State.RUNNING == this.b) {
            this.b = State.STOP;
        }
    }

    public State getState() {
        return this.b;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5) {
        if (this.b != null && State.DESTROY != this.b) {
            return false;
        }
        try {
            AudioRecord audioRecord = new AudioRecord(1, i2, i3, i4, i5);
            this.a = audioRecord;
            if (1 == audioRecord.getState()) {
                this.c = new byte[i5];
                a(State.INIT);
                return true;
            }
            throw new IllegalArgumentException("guaranteed format is (8000, mono, 16bit)");
        } catch (Exception unused) {
            return false;
        }
    }

    public void run() {
        AudioRecord audioRecord = this.a;
        if (audioRecord != null) {
            audioRecord.startRecording();
            ByteBuffer wrap = ByteBuffer.wrap(this.c);
            while (State.RUNNING == this.b) {
                LogUtil.d("AudioRecorder", "run" + this.b);
                wrap.clear();
                AudioRecord audioRecord2 = this.a;
                byte[] bArr = this.c;
                int read = audioRecord2.read(bArr, 0, bArr.length);
                if (read <= 0) {
                    break;
                }
                wrap.limit(read);
                setChanged();
                notifyObservers(wrap);
            }
            this.a.stop();
            a(State.STOP);
            this.a.release();
            this.a = null;
            a(State.DESTROY);
            deleteObservers();
            this.c = null;
        }
    }

    public void setState(State state) {
        this.b = state;
    }

    public AudioRecorder() {
        this.a = null;
        this.b = null;
    }
}
