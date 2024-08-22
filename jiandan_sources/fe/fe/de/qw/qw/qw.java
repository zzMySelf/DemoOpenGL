package fe.fe.de.qw.qw;

import androidx.core.app.NotificationCompat;
import com.baidu.appsearch.update.patchupdate.d;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public byte[] f1789ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f1790de = false;

    /* renamed from: fe  reason: collision with root package name */
    public long f1791fe = 0;
    public ByteBuffer qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f1792rg = LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE;

    /* renamed from: th  reason: collision with root package name */
    public long f1793th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public int f1794uk = 0;

    /* renamed from: yj  reason: collision with root package name */
    public byte[] f1795yj = new byte[1048576];

    public qw() {
        ByteBuffer allocate = ByteBuffer.allocate(NotificationCompat.Builder.MAX_CHARSEQUENCE_LENGTH);
        this.qw = allocate;
        this.f1789ad = allocate.array();
    }

    public void ad(long j, int i2, d dVar, OutputStream outputStream) {
        dVar.a(j);
        while (i2 > 0) {
            this.qw.clear().limit(Math.min(this.qw.capacity(), i2));
            int i3 = dVar.m7if(this.qw);
            if (i3 != -1) {
                fe(this.qw.array(), 0, i3, outputStream);
                i2 -= i3;
            } else {
                throw new EOFException("in copy " + j + " " + i2);
            }
        }
    }

    public void de(OutputStream outputStream) {
        int i2 = this.f1794uk;
        if (i2 > 0) {
            outputStream.write(this.f1795yj, 0, i2);
            this.f1794uk = 0;
        }
        outputStream.flush();
    }

    public final void fe(byte[] bArr, int i2, int i3, OutputStream outputStream) {
        try {
            if (this.f1794uk + i3 >= this.f1795yj.length) {
                outputStream.write(this.f1795yj, 0, this.f1794uk);
                this.f1794uk = 0;
                System.arraycopy(bArr, 0, this.f1795yj, 0, i3);
                this.f1794uk = i3;
                return;
            }
            if (this.f1794uk == 0) {
                System.arraycopy(bArr, 0, this.f1795yj, 0, i3);
            } else {
                System.arraycopy(bArr, 0, this.f1795yj, this.f1794uk, i3);
            }
            this.f1794uk += i3;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void qw(int i2, InputStream inputStream, OutputStream outputStream) {
        while (i2 > 0) {
            int read = inputStream.read(this.f1789ad, 0, Math.min(this.f1789ad.length, i2));
            if (read != -1) {
                fe(this.f1789ad, 0, read, outputStream);
                i2 -= read;
            } else {
                throw new EOFException("cannot read " + i2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r1 = r0;
        r9 = r10.readInt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        r1 = r0;
        r9 = r10.readUnsignedShort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b9, code lost:
        r1 = r0;
        r9 = r10.readUnsignedByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        ad(r1, r9, r8, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rg(com.baidu.appsearch.update.patchupdate.d r8, java.io.InputStream r9, java.io.OutputStream r10) {
        /*
            r7 = this;
            java.io.DataOutputStream r6 = new java.io.DataOutputStream
            r6.<init>(r10)
            java.io.DataInputStream r10 = new java.io.DataInputStream
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r1 = 262144(0x40000, float:3.67342E-40)
            r0.<init>(r9, r1)
            r10.<init>(r0)
            int r9 = r10.readUnsignedByte()
            java.lang.String r0 = "magic string not found, aborting!"
            r1 = 209(0xd1, float:2.93E-43)
            if (r9 != r1) goto L_0x015c
            int r9 = r10.readUnsignedByte()
            r2 = 255(0xff, float:3.57E-43)
            if (r9 != r2) goto L_0x015c
            int r9 = r10.readUnsignedByte()
            if (r9 != r1) goto L_0x015c
            int r9 = r10.readUnsignedByte()
            if (r9 != r2) goto L_0x015c
            int r9 = r10.readUnsignedByte()
            r1 = 5
            if (r9 != r1) goto L_0x003e
            r9 = 1
            r7.f1790de = r9
            r9 = 243(0xf3, float:3.4E-43)
            r7.f1792rg = r9
            goto L_0x0041
        L_0x003e:
            r1 = 4
            if (r9 != r1) goto L_0x0156
        L_0x0041:
            r0 = 0
        L_0x0043:
            r7.f1793th = r0
            int r9 = r10.readUnsignedByte()
            if (r9 != 0) goto L_0x004f
            r7.de(r6)
            return
        L_0x004f:
            int r0 = r7.f1792rg
            if (r9 > r0) goto L_0x005b
        L_0x0053:
            r7.qw(r9, r10, r6)
        L_0x0056:
            long r0 = r7.f1793th
            long r2 = (long) r9
            long r0 = r0 + r2
            goto L_0x0043
        L_0x005b:
            switch(r9) {
                case 244: goto L_0x013f;
                case 245: goto L_0x0128;
                case 246: goto L_0x0111;
                case 247: goto L_0x010b;
                case 248: goto L_0x0105;
                case 249: goto L_0x00f0;
                case 250: goto L_0x00db;
                case 251: goto L_0x00c6;
                case 252: goto L_0x00ab;
                case 253: goto L_0x0097;
                case 254: goto L_0x0083;
                case 255: goto L_0x0075;
                default: goto L_0x005e;
            }
        L_0x005e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "command "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x0075:
            long r0 = r10.readLong()
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x0091
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x0091
        L_0x0083:
            int r9 = r10.readInt()
            long r0 = (long) r9
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x0091
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
        L_0x0091:
            r1 = r0
            int r9 = r10.readInt()
            goto L_0x00be
        L_0x0097:
            int r9 = r10.readInt()
            long r0 = (long) r9
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x00a5
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
        L_0x00a5:
            r1 = r0
            int r9 = r10.readUnsignedShort()
            goto L_0x00be
        L_0x00ab:
            int r9 = r10.readInt()
            long r0 = (long) r9
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x00b9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
        L_0x00b9:
            r1 = r0
            int r9 = r10.readUnsignedByte()
        L_0x00be:
            r0 = r7
            r3 = r9
            r4 = r8
            r5 = r6
            r0.ad(r1, r3, r4, r5)
            goto L_0x0056
        L_0x00c6:
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x00d5
            short r9 = r10.readShort()
            long r0 = (long) r9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x0091
        L_0x00d5:
            int r9 = r10.readUnsignedShort()
            long r0 = (long) r9
            goto L_0x0091
        L_0x00db:
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x00ea
            short r9 = r10.readShort()
            long r0 = (long) r9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x00a5
        L_0x00ea:
            int r9 = r10.readUnsignedShort()
            long r0 = (long) r9
            goto L_0x00a5
        L_0x00f0:
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x00ff
            short r9 = r10.readShort()
            long r0 = (long) r9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x00b9
        L_0x00ff:
            int r9 = r10.readUnsignedShort()
            long r0 = (long) r9
            goto L_0x00b9
        L_0x0105:
            int r9 = r10.readInt()
            goto L_0x0053
        L_0x010b:
            int r9 = r10.readUnsignedShort()
            goto L_0x0053
        L_0x0111:
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x0121
            byte r9 = r10.readByte()
            long r0 = (long) r9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x0091
        L_0x0121:
            int r9 = r10.readUnsignedByte()
            long r0 = (long) r9
            goto L_0x0091
        L_0x0128:
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x0138
            byte r9 = r10.readByte()
            long r0 = (long) r9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x00a5
        L_0x0138:
            int r9 = r10.readUnsignedByte()
            long r0 = (long) r9
            goto L_0x00a5
        L_0x013f:
            boolean r9 = r7.f1790de
            if (r9 == 0) goto L_0x014f
            byte r9 = r10.readByte()
            long r0 = (long) r9
            long r2 = r7.f1791fe
            long r0 = r0 + r2
            r7.f1791fe = r0
            goto L_0x00b9
        L_0x014f:
            int r9 = r10.readUnsignedByte()
            long r0 = (long) r9
            goto L_0x00b9
        L_0x0156:
            com.baidu.appsearch.update.patchupdate.b r8 = new com.baidu.appsearch.update.patchupdate.b
            r8.<init>(r0)
            throw r8
        L_0x015c:
            com.baidu.appsearch.update.patchupdate.b r8 = new com.baidu.appsearch.update.patchupdate.b
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.de.qw.qw.qw.rg(com.baidu.appsearch.update.patchupdate.d, java.io.InputStream, java.io.OutputStream):void");
    }

    public void th(File file, File file2, File file3) {
        ad adVar = new ad(new RandomAccessFile(file, "r"));
        FileInputStream fileInputStream = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            rg(adVar, fileInputStream, fileOutputStream);
            adVar.close();
            fileInputStream.close();
            fileOutputStream.close();
            file3.length();
        } catch (IOException e) {
            throw e;
        } catch (Throwable th2) {
            adVar.close();
            fileInputStream.close();
            fileOutputStream.close();
            file3.length();
            throw th2;
        }
    }
}
