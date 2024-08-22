package fe.th.de;

import fe.th.de.rrr.fe;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public abstract class nn {

    public class ad extends nn {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ File f5213ad;
        public final /* synthetic */ when qw;

        public ad(when when, File file) {
            this.qw = when;
            this.f5213ad = file;
        }

        public when ad() {
            return this.qw;
        }

        public long qw() {
            return this.f5213ad.length();
        }

        public void yj(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(this.f5213ad);
                bufferedSink.writeAll(source);
            } finally {
                fe.yj(source);
            }
        }
    }

    public class qw extends nn {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f5214ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ byte[] f5215de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ int f5216fe;
        public final /* synthetic */ when qw;

        public qw(when when, int i2, byte[] bArr, int i3) {
            this.qw = when;
            this.f5214ad = i2;
            this.f5215de = bArr;
            this.f5216fe = i3;
        }

        public when ad() {
            return this.qw;
        }

        public long qw() {
            return (long) this.f5214ad;
        }

        public void yj(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.f5215de, this.f5216fe, this.f5214ad);
        }
    }

    public static nn de(when when, File file) {
        if (file != null) {
            return new ad(when, file);
        }
        throw new NullPointerException("file == null");
    }

    public static nn fe(when when, String str) {
        Charset charset = fe.f5257i;
        if (when != null && (charset = when.qw()) == null) {
            charset = fe.f5257i;
            when = when.fe(when + "; charset=utf-8");
        }
        return rg(when, str.getBytes(charset));
    }

    public static nn rg(when when, byte[] bArr) {
        return th(when, bArr, 0, bArr.length);
    }

    public static nn th(when when, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            fe.th((long) bArr.length, (long) i2, (long) i3);
            return new qw(when, i3, bArr, i2);
        }
        throw new NullPointerException("content == null");
    }

    public abstract when ad();

    public abstract long qw() throws IOException;

    public abstract void yj(BufferedSink bufferedSink) throws IOException;
}
