package fe.th.de.rrr.i;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.u.i;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import fe.th.de.Cif;
import fe.th.de.aaa;
import fe.th.de.ddd;
import fe.th.de.ggg;
import fe.th.de.mmm;
import fe.th.de.pf;
import fe.th.de.rrr.uk.o;
import fe.th.de.rrr.uk.uk;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class qw implements HttpCodec {

    /* renamed from: ad  reason: collision with root package name */
    public final fe.th.de.rrr.yj.th f5266ad;

    /* renamed from: de  reason: collision with root package name */
    public final BufferedSource f5267de;

    /* renamed from: fe  reason: collision with root package name */
    public final BufferedSink f5268fe;
    public final ggg qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f5269rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public long f5270th = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    public abstract class ad implements Source {

        /* renamed from: ad  reason: collision with root package name */
        public final ForwardingTimeout f5271ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f5272th;

        /* renamed from: yj  reason: collision with root package name */
        public long f5274yj;

        public ad() {
            this.f5271ad = new ForwardingTimeout(qw.this.f5267de.timeout());
            this.f5274yj = 0;
        }

        public final void qw(boolean z, IOException iOException) throws IOException {
            qw qwVar = qw.this;
            int i2 = qwVar.f5269rg;
            if (i2 != 6) {
                if (i2 == 5) {
                    qwVar.fe(this.f5271ad);
                    qw qwVar2 = qw.this;
                    qwVar2.f5269rg = 6;
                    fe.th.de.rrr.yj.th thVar = qwVar2.f5266ad;
                    if (thVar != null) {
                        thVar.qqq(!z, qwVar2, this.f5274yj, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + qw.this.f5269rg);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = qw.this.f5267de.read(buffer, j);
                if (read > 0) {
                    this.f5274yj += read;
                }
                return read;
            } catch (IOException e) {
                qw(false, e);
                throw e;
            }
        }

        public Timeout timeout() {
            return this.f5271ad;
        }
    }

    public final class de implements Sink {

        /* renamed from: ad  reason: collision with root package name */
        public final ForwardingTimeout f5275ad = new ForwardingTimeout(qw.this.f5268fe.timeout());

        /* renamed from: th  reason: collision with root package name */
        public boolean f5276th;

        public de() {
        }

        public synchronized void close() throws IOException {
            if (!this.f5276th) {
                this.f5276th = true;
                qw.this.f5268fe.writeUtf8("0\r\n\r\n");
                qw.this.fe(this.f5275ad);
                qw.this.f5269rg = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f5276th) {
                qw.this.f5268fe.flush();
            }
        }

        public Timeout timeout() {
            return this.f5275ad;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.f5276th) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                qw.this.f5268fe.writeHexadecimalUnsignedLong(j);
                qw.this.f5268fe.writeUtf8("\r\n");
                qw.this.f5268fe.write(buffer, j);
                qw.this.f5268fe.writeUtf8("\r\n");
            }
        }
    }

    public class fe extends ad {

        /* renamed from: i  reason: collision with root package name */
        public final Cif f5278i;

        /* renamed from: o  reason: collision with root package name */
        public long f5279o = -1;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f5280pf = true;

        public fe(Cif ifVar) {
            super();
            this.f5278i = ifVar;
        }

        public void close() throws IOException {
            if (!this.f5272th) {
                if (this.f5280pf && !fe.th.de.rrr.fe.ggg(this, 100, TimeUnit.MILLISECONDS)) {
                    qw(false, (IOException) null);
                }
                this.f5272th = true;
            }
        }

        public final void de() throws IOException {
            if (this.f5279o != -1) {
                qw.this.f5267de.readUtf8LineStrict();
            }
            try {
                this.f5279o = qw.this.f5267de.readHexadecimalUnsignedLong();
                String trim = qw.this.f5267de.readUtf8LineStrict().trim();
                if (this.f5279o < 0 || (!trim.isEmpty() && !trim.startsWith(i.b))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f5279o + trim + "\"");
                } else if (this.f5279o == 0) {
                    this.f5280pf = false;
                    fe.th.de.rrr.uk.fe.rg(qw.this.qw.uk(), this.f5278i, qw.this.pf());
                    qw(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f5272th) {
                throw new IllegalStateException("closed");
            } else if (!this.f5280pf) {
                return -1;
            } else {
                long j2 = this.f5279o;
                if (j2 == 0 || j2 == -1) {
                    de();
                    if (!this.f5280pf) {
                        return -1;
                    }
                }
                long read = super.read(buffer, Math.min(j, this.f5279o));
                if (read != -1) {
                    this.f5279o -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                qw(false, protocolException);
                throw protocolException;
            }
        }
    }

    public final class rg implements Sink {

        /* renamed from: ad  reason: collision with root package name */
        public final ForwardingTimeout f5281ad = new ForwardingTimeout(qw.this.f5268fe.timeout());

        /* renamed from: th  reason: collision with root package name */
        public boolean f5282th;

        /* renamed from: yj  reason: collision with root package name */
        public long f5284yj;

        public rg(long j) {
            this.f5284yj = j;
        }

        public void close() throws IOException {
            if (!this.f5282th) {
                this.f5282th = true;
                if (this.f5284yj <= 0) {
                    qw.this.fe(this.f5281ad);
                    qw.this.f5269rg = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() throws IOException {
            if (!this.f5282th) {
                qw.this.f5268fe.flush();
            }
        }

        public Timeout timeout() {
            return this.f5281ad;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.f5282th) {
                fe.th.de.rrr.fe.th(buffer.size(), 0, j);
                if (j <= this.f5284yj) {
                    qw.this.f5268fe.write(buffer, j);
                    this.f5284yj -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f5284yj + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }
    }

    public class th extends ad {

        /* renamed from: i  reason: collision with root package name */
        public long f5285i;

        public th(qw qwVar, long j) throws IOException {
            super();
            this.f5285i = j;
            if (j == 0) {
                qw(true, (IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.f5272th) {
                if (this.f5285i != 0 && !fe.th.de.rrr.fe.ggg(this, 100, TimeUnit.MILLISECONDS)) {
                    qw(false, (IOException) null);
                }
                this.f5272th = true;
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.f5272th) {
                long j2 = this.f5285i;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.f5285i - read;
                    this.f5285i = j3;
                    if (j3 == 0) {
                        qw(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                qw(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    public class yj extends ad {

        /* renamed from: i  reason: collision with root package name */
        public boolean f5286i;

        public yj(qw qwVar) {
            super();
        }

        public void close() throws IOException {
            if (!this.f5272th) {
                if (!this.f5286i) {
                    qw(false, (IOException) null);
                }
                this.f5272th = true;
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f5272th) {
                throw new IllegalStateException("closed");
            } else if (this.f5286i) {
                return -1;
            } else {
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.f5286i = true;
                qw(true, (IOException) null);
                return -1;
            }
        }
    }

    public qw(ggg ggg, fe.th.de.rrr.yj.th thVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.qw = ggg;
        this.f5266ad = thVar;
        this.f5267de = bufferedSource;
        this.f5268fe = bufferedSink;
    }

    public void ad(ddd ddd) throws IOException {
        m348if(ddd.fe(), uk.qw(ddd, this.f5266ad.fe().route().ad().type()));
    }

    public void cancel() {
        fe.th.de.rrr.yj.de fe2 = this.f5266ad.fe();
        if (fe2 != null) {
            fe2.de();
        }
    }

    public Sink de(ddd ddd, long j) {
        if ("chunked".equalsIgnoreCase(ddd.de("Transfer-Encoding"))) {
            return rg();
        }
        if (j != -1) {
            return yj(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void fe(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public void finishRequest() throws IOException {
        this.f5268fe.flush();
    }

    public void flushRequest() throws IOException {
        this.f5268fe.flush();
    }

    public Source i() throws IOException {
        if (this.f5269rg == 4) {
            fe.th.de.rrr.yj.th thVar = this.f5266ad;
            if (thVar != null) {
                this.f5269rg = 5;
                thVar.ppp();
                return new yj(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f5269rg);
    }

    /* renamed from: if  reason: not valid java name */
    public void m348if(pf pfVar, String str) throws IOException {
        if (this.f5269rg == 0) {
            this.f5268fe.writeUtf8(str).writeUtf8("\r\n");
            int yj2 = pfVar.yj();
            for (int i2 = 0; i2 < yj2; i2++) {
                this.f5268fe.writeUtf8(pfVar.rg(i2)).writeUtf8(": ").writeUtf8(pfVar.uk(i2)).writeUtf8("\r\n");
            }
            this.f5268fe.writeUtf8("\r\n");
            this.f5269rg = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f5269rg);
    }

    public final String o() throws IOException {
        String readUtf8LineStrict = this.f5267de.readUtf8LineStrict(this.f5270th);
        this.f5270th -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public pf pf() throws IOException {
        pf.qw qwVar = new pf.qw();
        while (true) {
            String o2 = o();
            if (o2.length() == 0) {
                return qwVar.rg();
            }
            fe.th.de.rrr.qw.qw.qw(qwVar, o2);
        }
    }

    public aaa qw(mmm mmm) throws IOException {
        fe.th.de.rrr.yj.th thVar = this.f5266ad;
        thVar.f5519th.responseBodyStart(thVar.f5518rg);
        String yj2 = mmm.yj("Content-Type");
        if (!fe.th.de.rrr.uk.fe.de(mmm)) {
            return new fe.th.de.rrr.uk.yj(yj2, 0, Okio.buffer(uk(0)));
        }
        if ("chunked".equalsIgnoreCase(mmm.yj("Transfer-Encoding"))) {
            return new fe.th.de.rrr.uk.yj(yj2, -1, Okio.buffer(th(mmm.nn().uk())));
        }
        long ad2 = fe.th.de.rrr.uk.fe.ad(mmm);
        if (ad2 != -1) {
            return new fe.th.de.rrr.uk.yj(yj2, ad2, Okio.buffer(uk(ad2)));
        }
        return new fe.th.de.rrr.uk.yj(yj2, -1, Okio.buffer(i()));
    }

    public mmm.qw readResponseHeaders(boolean z) throws IOException {
        int i2 = this.f5269rg;
        if (i2 == 1 || i2 == 3) {
            try {
                o ad2 = o.ad(o());
                mmm.qw qwVar = new mmm.qw();
                qwVar.when(ad2.qw);
                qwVar.yj(ad2.f5474ad);
                qwVar.pf(ad2.f5475de);
                qwVar.o(pf());
                if (z && ad2.f5474ad == 100) {
                    return null;
                }
                if (ad2.f5474ad == 100) {
                    this.f5269rg = 3;
                    return qwVar;
                }
                this.f5269rg = 4;
                return qwVar;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f5266ad);
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f5269rg);
        }
    }

    public Sink rg() {
        if (this.f5269rg == 1) {
            this.f5269rg = 2;
            return new de();
        }
        throw new IllegalStateException("state: " + this.f5269rg);
    }

    public Source th(Cif ifVar) throws IOException {
        if (this.f5269rg == 4) {
            this.f5269rg = 5;
            return new fe(ifVar);
        }
        throw new IllegalStateException("state: " + this.f5269rg);
    }

    public Source uk(long j) throws IOException {
        if (this.f5269rg == 4) {
            this.f5269rg = 5;
            return new th(this, j);
        }
        throw new IllegalStateException("state: " + this.f5269rg);
    }

    public Sink yj(long j) {
        if (this.f5269rg == 1) {
            this.f5269rg = 2;
            return new rg(j);
        }
        throw new IllegalStateException("state: " + this.f5269rg);
    }
}
