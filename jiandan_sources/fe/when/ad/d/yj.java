package fe.when.ad.d;

import com.baidu.android.common.others.lang.StringUtil;
import com.itextpdf.text.io.MapFailedException;
import com.itextpdf.text.io.RandomAccessSource;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class yj implements RandomAccessSource {

    /* renamed from: ad  reason: collision with root package name */
    public final long f9331ad;

    /* renamed from: de  reason: collision with root package name */
    public final long f9332de;

    /* renamed from: fe  reason: collision with root package name */
    public ad f9333fe;
    public final FileChannel qw;

    public yj(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException(j + " is negative");
        } else if (j2 > 0) {
            this.qw = fileChannel;
            this.f9331ad = j;
            this.f9332de = j2;
            this.f9333fe = null;
        } else {
            throw new IllegalArgumentException(j2 + " is zero or negative");
        }
    }

    public static boolean de(IOException iOException) {
        return iOException.getMessage() != null && iOException.getMessage().indexOf("Map failed") >= 0;
    }

    public int ad(long j) throws IOException {
        ad adVar = this.f9333fe;
        if (adVar != null) {
            return adVar.ad(j);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    public void close() throws IOException {
        ad adVar = this.f9333fe;
        if (adVar != null) {
            adVar.close();
            this.f9333fe = null;
        }
    }

    public void fe() throws IOException {
        if (this.f9333fe == null) {
            if (this.qw.isOpen()) {
                try {
                    this.f9333fe = new ad(this.qw.map(FileChannel.MapMode.READ_ONLY, this.f9331ad, this.f9332de));
                } catch (IOException e) {
                    if (de(e)) {
                        throw new MapFailedException(e);
                    }
                    throw e;
                }
            } else {
                throw new IllegalStateException("Channel is closed");
            }
        }
    }

    public long length() {
        return this.f9332de;
    }

    public int qw(long j, byte[] bArr, int i2, int i3) throws IOException {
        ad adVar = this.f9333fe;
        if (adVar != null) {
            return adVar.qw(j, bArr, i2, i3);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    public String toString() {
        return yj.class.getName() + " (" + this.f9331ad + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f9332de + ")";
    }
}
