package com.baidu.ar.audio;

import android.media.AudioRecord;
import com.baidu.ar.p.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;

class c {

    /* renamed from: i  reason: collision with root package name */
    private static final String f9126i = "c";

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f9127j = false;

    /* renamed from: a  reason: collision with root package name */
    private AudioRecord f9128a;

    /* renamed from: b  reason: collision with root package name */
    private AudioParams f9129b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f9130c = null;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<ByteBuffer> f9131d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f9132e = 0;

    /* renamed from: f  reason: collision with root package name */
    private a f9133f;

    /* renamed from: g  reason: collision with root package name */
    private VolumeListener f9134g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9135h = false;

    private void a(long j2) {
        if (j2 >= 20) {
            a(false);
        } else if (d.a(this.f9130c) != 0.0d) {
            a(true);
        } else {
            return;
        }
        this.f9135h = true;
    }

    private void a(long j2, int i2) {
        ByteBuffer byteBuffer = this.f9131d.get(this.f9132e);
        if (i2 == -3) {
            b.b(f9126i, "Audio read error");
        } else if (!(this.f9133f == null || byteBuffer == null || byteBuffer.capacity() < i2)) {
            if (this.f9129b.getAmplifyVolume() != 1.0f) {
                d.a(this.f9130c, (double) this.f9129b.getAmplifyVolume());
            }
            try {
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(this.f9130c, 0, i2);
                byteBuffer.flip();
                this.f9133f.onAudioFrameAvailable(byteBuffer, i2, j2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int i3 = this.f9132e + 1;
        this.f9132e = i3;
        this.f9132e = i3 % this.f9129b.getFrameBufferCount();
        if (this.f9134g != null) {
            this.f9134g.onRealtimeVolume((int) d.b(this.f9130c));
        }
    }

    private void a(boolean z) {
        a aVar = this.f9133f;
        if (aVar != null) {
            aVar.onAudioStart(z);
        }
    }

    private void b() {
        if (this.f9129b.getFrameSize() > 0) {
            if (this.f9131d == null) {
                this.f9131d = new ArrayList<>();
                for (int i2 = 0; i2 < this.f9129b.getFrameBufferCount(); i2++) {
                    this.f9131d.add(ByteBuffer.allocate(this.f9129b.getFrameSize()));
                }
            }
            this.f9132e = 0;
            if (this.f9130c == null) {
                this.f9130c = new byte[this.f9129b.getFrameSize()];
            }
            int i3 = 0;
            while (f9127j) {
                long nanoTime = System.nanoTime();
                AudioRecord audioRecord = this.f9128a;
                byte[] bArr = this.f9130c;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (!this.f9135h || this.f9129b == null) {
                    a((long) i3);
                    i3++;
                } else {
                    a(nanoTime, read);
                }
            }
            this.f9131d = null;
            this.f9130c = null;
            try {
                this.f9128a.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a aVar = this.f9133f;
            if (aVar != null) {
                aVar.onAudioStop(true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r5 = this;
            android.media.AudioRecord r0 = r5.f9128a
            int r0 = r0.getState()
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x003f
            android.media.AudioRecord r0 = r5.f9128a     // Catch:{ IllegalStateException -> 0x0033 }
            r0.startRecording()     // Catch:{ IllegalStateException -> 0x0033 }
            android.media.AudioRecord r0 = r5.f9128a     // Catch:{ IllegalStateException -> 0x0033 }
            int r0 = r0.getRecordingState()     // Catch:{ IllegalStateException -> 0x0033 }
            r3 = 3
            if (r0 != r3) goto L_0x0019
            goto L_0x0040
        L_0x0019:
            java.lang.String r1 = f9126i     // Catch:{ IllegalStateException -> 0x0033 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0033 }
            r3.<init>()     // Catch:{ IllegalStateException -> 0x0033 }
            java.lang.String r4 = "startAudioRecord state = "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IllegalStateException -> 0x0033 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ IllegalStateException -> 0x0033 }
            java.lang.String r0 = r0.toString()     // Catch:{ IllegalStateException -> 0x0033 }
            com.baidu.ar.p.b.b(r1, r0)     // Catch:{ IllegalStateException -> 0x0033 }
            goto L_0x003f
        L_0x0033:
            r0 = move-exception
            java.lang.String r1 = f9126i
            java.lang.String r3 = "startAudioRecord error!!!"
            com.baidu.ar.p.b.b(r1, r3)
            r0.printStackTrace()
        L_0x003f:
            r1 = r2
        L_0x0040:
            f9127j = r1
            if (r1 != 0) goto L_0x0066
            java.lang.String r0 = f9126i
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "startAudioRecord error!!! mAudioRecord.getState() = "
            java.lang.StringBuilder r1 = r1.append(r3)
            android.media.AudioRecord r3 = r5.f9128a
            int r3 = r3.getState()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.baidu.ar.p.b.b(r0, r1)
            r5.a((boolean) r2)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.audio.c.e():void");
    }

    public AudioParams a() {
        return this.f9129b;
    }

    public void a(AudioParams audioParams) {
        int minBufferSize = AudioRecord.getMinBufferSize(audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat());
        if (audioParams.getFrameSize() < minBufferSize) {
            audioParams.setAudioBufferSize(((minBufferSize / 1024) + 1) * 1024 * 2);
        }
        this.f9128a = new AudioRecord(audioParams.getAudioSource(), audioParams.getSampleRate(), audioParams.getChannelConfig(), audioParams.getAudioFormat(), audioParams.getAudioBufferSize());
        this.f9129b = audioParams;
        this.f9135h = false;
        a aVar = this.f9133f;
        if (aVar != null) {
            aVar.onAudioSetup(true);
        }
    }

    public void a(VolumeListener volumeListener) {
        this.f9134g = volumeListener;
    }

    public void a(a aVar) {
        this.f9133f = aVar;
    }

    public void c() {
        if (!f9127j) {
            this.f9128a.release();
            this.f9128a = null;
            a aVar = this.f9133f;
            if (aVar != null) {
                aVar.onAudioRelease();
            }
            this.f9133f = null;
            this.f9134g = null;
        }
    }

    public void d() {
        e();
        b();
    }

    public void f() {
        f9127j = false;
    }
}
