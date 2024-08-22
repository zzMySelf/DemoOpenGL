package fe.pf.qw.rg;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

public class rg implements Closeable, Elf {

    /* renamed from: ad  reason: collision with root package name */
    public final FileChannel f4644ad;

    public rg(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f4644ad = new FileInputStream(file).getChannel();
    }

    public void close() throws IOException {
        this.f4644ad.close();
    }

    public Elf.ad de() throws IOException {
        this.f4644ad.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m294switch(allocate, 0) == 1179403647) {
            short th2 = th(allocate, 4);
            boolean z = th(allocate, 5) == 2;
            if (th2 == 1) {
                return new de(z, this);
            }
            if (th2 == 2) {
                return new fe(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> fe() throws IOException {
        long j;
        this.f4644ad.position(0);
        ArrayList arrayList = new ArrayList();
        Elf.ad de2 = de();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(de2.qw ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) de2.f4380rg;
        int i2 = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = de2.de(0).qw;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            Elf.de ad2 = de2.ad(j3);
            if (ad2.qw == 2) {
                j = ad2.f4382ad;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList<Long> arrayList2 = new ArrayList<>();
        long j4 = 0;
        while (true) {
            Elf.qw qw = de2.qw(j, i2);
            long j5 = j;
            long j6 = qw.qw;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(qw.f4385ad));
            } else if (j6 == 5) {
                j4 = qw.f4385ad;
            }
            i2++;
            if (qw.qw == 0) {
                break;
            }
            j = j5;
        }
        if (j4 != 0) {
            long qw2 = qw(de2, j2, j4);
            for (Long longValue : arrayList2) {
                arrayList.add(pf(allocate, longValue.longValue() + qw2));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    public String pf(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short th2 = th(byteBuffer, j);
            if (th2 == 0) {
                return sb.toString();
            }
            sb.append((char) th2);
            j = j2;
        }
    }

    public final long qw(Elf.ad adVar, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            Elf.de ad2 = adVar.ad(j3);
            if (ad2.qw == 1) {
                long j4 = ad2.f4383de;
                if (j4 <= j2 && j2 <= ad2.f4384fe + j4) {
                    return (j2 - j4) + ad2.f4382ad;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public void rg(ByteBuffer byteBuffer, long j, int i2) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        long j2 = 0;
        while (j2 < ((long) i2)) {
            int read = this.f4644ad.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }

    /* renamed from: switch  reason: not valid java name */
    public long m294switch(ByteBuffer byteBuffer, long j) throws IOException {
        rg(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public short th(ByteBuffer byteBuffer, long j) throws IOException {
        rg(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public long uk(ByteBuffer byteBuffer, long j) throws IOException {
        rg(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public int yj(ByteBuffer byteBuffer, long j) throws IOException {
        rg(byteBuffer, j, 2);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }
}
