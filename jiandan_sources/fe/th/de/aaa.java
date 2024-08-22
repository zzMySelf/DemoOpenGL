package fe.th.de;

import fe.th.de.rrr.fe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

public abstract class aaa implements Closeable {

    public class qw extends aaa {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ when f5121ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f5122th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ BufferedSource f5123yj;

        public qw(when when, long j, BufferedSource bufferedSource) {
            this.f5121ad = when;
            this.f5122th = j;
            this.f5123yj = bufferedSource;
        }

        public long fe() {
            return this.f5122th;
        }

        public when rg() {
            return this.f5121ad;
        }

        public BufferedSource uk() {
            return this.f5123yj;
        }
    }

    public static aaa th(when when, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new qw(when, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }

    public static aaa yj(when when, byte[] bArr) {
        return th(when, (long) bArr.length, new Buffer().write(bArr));
    }

    public void close() {
        fe.yj(uk());
    }

    public final Charset de() {
        when rg2 = rg();
        return rg2 != null ? rg2.ad(fe.f5257i) : fe.f5257i;
    }

    public abstract long fe();

    public final String pf() throws IOException {
        BufferedSource uk2 = uk();
        try {
            return uk2.readString(fe.de(uk2, de()));
        } finally {
            fe.yj(uk2);
        }
    }

    public final InputStream qw() {
        return uk().inputStream();
    }

    public abstract when rg();

    public abstract BufferedSource uk();
}
