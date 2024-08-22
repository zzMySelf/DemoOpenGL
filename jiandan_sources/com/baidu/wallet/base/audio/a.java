package com.baidu.wallet.base.audio;

import com.baidu.pass.permissions.PermissionsHelperActivity;
import com.baidu.wallet.base.audio.AudioRecorder;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Observable;
import java.util.Observer;

public class a implements Observer {
    public AudioRecorder a;
    public FileOutputStream b;
    public File c = new File("/sdcard/cu.wav");
    public b d;
    public int e;

    public a(AudioRecorder audioRecorder) {
        this.a = audioRecorder;
    }

    public void update(Observable observable, Object obj) {
        if (observable == this.a) {
            if (obj instanceof AudioRecorder.State) {
                AudioRecorder.State state = (AudioRecorder.State) obj;
                if (AudioRecorder.State.OPEN == state) {
                    this.e = 0;
                    try {
                        this.b = new FileOutputStream(this.c);
                        FileInputStream fileInputStream = new FileInputStream(this.c);
                        b.a((InputStream) fileInputStream).a();
                        fileInputStream.close();
                        b a2 = b.a(1, 16, PermissionsHelperActivity.e, 0);
                        this.d = a2;
                        a2.a((OutputStream) this.b);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (AudioRecorder.State.STOP == state) {
                    try {
                        this.b.close();
                        this.d = b.a(1, 16, PermissionsHelperActivity.e, this.e);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.c, "rw");
                        this.d.a((DataOutput) randomAccessFile);
                        this.d.a();
                        randomAccessFile.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    this.b = null;
                }
            } else if ((obj instanceof Buffer) && this.b != null) {
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    this.e += byteBuffer.remaining();
                    this.b.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
