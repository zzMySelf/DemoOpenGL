package fe.th.de.rrr.o;

import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import com.google.common.base.Ascii;
import fe.th.de.rrr.fe;
import fe.th.de.rrr.o.ad;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class th implements Closeable {

    /* renamed from: i  reason: collision with root package name */
    public static final Logger f5401i = Logger.getLogger(de.class.getName());

    /* renamed from: ad  reason: collision with root package name */
    public final BufferedSource f5402ad;

    /* renamed from: th  reason: collision with root package name */
    public final qw f5403th;

    /* renamed from: uk  reason: collision with root package name */
    public final ad.qw f5404uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f5405yj;

    public interface ad {
        void ackSettings();

        void ad(int i2, ErrorCode errorCode, ByteString byteString);

        void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void de(boolean z, o oVar);

        void headers(boolean z, int i2, int i3, List<qw> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<qw> list) throws IOException;

        void qw(int i2, ErrorCode errorCode);

        void windowUpdate(int i2, long j);
    }

    public static final class qw implements Source {

        /* renamed from: ad  reason: collision with root package name */
        public final BufferedSource f5406ad;

        /* renamed from: i  reason: collision with root package name */
        public int f5407i;

        /* renamed from: o  reason: collision with root package name */
        public short f5408o;

        /* renamed from: th  reason: collision with root package name */
        public int f5409th;

        /* renamed from: uk  reason: collision with root package name */
        public int f5410uk;

        /* renamed from: yj  reason: collision with root package name */
        public byte f5411yj;

        public qw(BufferedSource bufferedSource) {
            this.f5406ad = bufferedSource;
        }

        public void close() throws IOException {
        }

        public final void qw() throws IOException {
            int i2 = this.f5410uk;
            int pf2 = th.pf(this.f5406ad);
            this.f5407i = pf2;
            this.f5409th = pf2;
            byte readByte = (byte) (this.f5406ad.readByte() & 255);
            this.f5411yj = (byte) (this.f5406ad.readByte() & 255);
            if (th.f5401i.isLoggable(Level.FINE)) {
                th.f5401i.fine(de.ad(true, this.f5410uk, this.f5409th, readByte, this.f5411yj));
            }
            int readInt = this.f5406ad.readInt() & Integer.MAX_VALUE;
            this.f5410uk = readInt;
            if (readByte != 9) {
                de.fe("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt != i2) {
                de.fe("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i2 = this.f5407i;
                if (i2 == 0) {
                    this.f5406ad.skip((long) this.f5408o);
                    this.f5408o = 0;
                    if ((this.f5411yj & 4) != 0) {
                        return -1;
                    }
                    qw();
                } else {
                    long read = this.f5406ad.read(buffer, Math.min(j, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.f5407i = (int) (((long) this.f5407i) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.f5406ad.timeout();
        }
    }

    public th(BufferedSource bufferedSource, boolean z) {
        this.f5402ad = bufferedSource;
        this.f5405yj = z;
        qw qwVar = new qw(bufferedSource);
        this.f5403th = qwVar;
        this.f5404uk = new ad.qw(4096, qwVar);
    }

    public static int pf(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << Ascii.DLE) | ((bufferedSource.readByte() & 255) << 8);
    }

    public static int qw(int i2, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        de.fe("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }

    public void close() throws IOException {
        this.f5402ad.close();
    }

    public final void ddd(ad adVar, int i2, byte b, int i3) throws IOException {
        if (i2 == 4) {
            long readInt = ((long) this.f5402ad.readInt()) & 2147483647L;
            if (readInt != 0) {
                adVar.windowUpdate(i3, readInt);
                return;
            }
            de.fe("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        de.fe("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        throw null;
    }

    public boolean de(boolean z, ad adVar) throws IOException {
        try {
            this.f5402ad.require(9);
            int pf2 = pf(this.f5402ad);
            if (pf2 < 0 || pf2 > 16384) {
                de.fe("FRAME_SIZE_ERROR: %s", Integer.valueOf(pf2));
                throw null;
            }
            byte readByte = (byte) (this.f5402ad.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f5402ad.readByte() & 255);
                int readInt = this.f5402ad.readInt() & Integer.MAX_VALUE;
                if (f5401i.isLoggable(Level.FINE)) {
                    f5401i.fine(de.ad(true, readInt, pf2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        rg(adVar, pf2, readByte2, readInt);
                        break;
                    case 1:
                        uk(adVar, pf2, readByte2, readInt);
                        break;
                    case 2:
                        ppp(adVar, pf2, readByte2, readInt);
                        break;
                    case 3:
                        vvv(adVar, pf2, readByte2, readInt);
                        break;
                    case 4:
                        xxx(adVar, pf2, readByte2, readInt);
                        break;
                    case 5:
                        ggg(adVar, pf2, readByte2, readInt);
                        break;
                    case 6:
                        m354switch(adVar, pf2, readByte2, readInt);
                        break;
                    case 7:
                        th(adVar, pf2, readByte2, readInt);
                        break;
                    case 8:
                        ddd(adVar, pf2, readByte2, readInt);
                        break;
                    default:
                        this.f5402ad.skip((long) pf2);
                        break;
                }
                return true;
            }
            de.fe("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    public void fe(ad adVar) throws IOException {
        if (!this.f5405yj) {
            ByteString readByteString = this.f5402ad.readByteString((long) de.qw.size());
            if (f5401i.isLoggable(Level.FINE)) {
                f5401i.fine(fe.xxx("<< CONNECTION %s", readByteString.hex()));
            }
            if (!de.qw.equals(readByteString)) {
                de.fe("Expected a connection header but was %s", readByteString.utf8());
                throw null;
            }
        } else if (!de(true, adVar)) {
            de.fe("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public final void ggg(ad adVar, int i2, byte b, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f5402ad.readByte() & 255);
            }
            adVar.pushPromise(i3, this.f5402ad.readInt() & Integer.MAX_VALUE, yj(qw(i2 - 4, b, s), s, b, i3));
            return;
        }
        de.fe("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    public final void ppp(ad adVar, int i2, byte b, int i3) throws IOException {
        if (i2 != 5) {
            de.fe("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            when(adVar, i3);
        } else {
            de.fe("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void rg(ad adVar, int i2, byte b, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f5402ad.readByte() & 255);
                }
                adVar.data(z2, i3, this.f5402ad, qw(i2, b, s));
                this.f5402ad.skip((long) s);
                return;
            }
            de.fe("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        de.fe("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m354switch(ad adVar, int i2, byte b, int i3) throws IOException {
        boolean z = false;
        if (i2 != 8) {
            de.fe("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f5402ad.readInt();
            int readInt2 = this.f5402ad.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            adVar.ping(z, readInt, readInt2);
        } else {
            de.fe("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void th(ad adVar, int i2, byte b, int i3) throws IOException {
        if (i2 < 8) {
            de.fe("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f5402ad.readInt();
            int readInt2 = this.f5402ad.readInt();
            int i4 = i2 - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i4 > 0) {
                    byteString = this.f5402ad.readByteString((long) i4);
                }
                adVar.ad(readInt, fromHttp2, byteString);
                return;
            }
            de.fe("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            de.fe("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void uk(ad adVar, int i2, byte b, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f5402ad.readByte() & 255);
            }
            if ((b & 32) != 0) {
                when(adVar, i3);
                i2 -= 5;
            }
            adVar.headers(z, i3, -1, yj(qw(i2, b, s), s, b, i3));
            return;
        }
        de.fe("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    public final void vvv(ad adVar, int i2, byte b, int i3) throws IOException {
        if (i2 != 4) {
            de.fe("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            int readInt = this.f5402ad.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                adVar.qw(i3, fromHttp2);
                return;
            }
            de.fe("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            de.fe("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void when(ad adVar, int i2) throws IOException {
        int readInt = this.f5402ad.readInt();
        adVar.priority(i2, readInt & Integer.MAX_VALUE, (this.f5402ad.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    public final void xxx(ad adVar, int i2, byte b, int i3) throws IOException {
        if (i3 != 0) {
            de.fe("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b & 1) != 0) {
            if (i2 == 0) {
                adVar.ackSettings();
            } else {
                de.fe("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i2 % 6 == 0) {
            o oVar = new o();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short readShort = this.f5402ad.readShort() & UShort.MAX_VALUE;
                int readInt = this.f5402ad.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            de.fe("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        de.fe("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    de.fe("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                oVar.i(readShort, readInt);
            }
            adVar.de(false, oVar);
        } else {
            de.fe("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    public final List<qw> yj(int i2, short s, byte b, int i3) throws IOException {
        qw qwVar = this.f5403th;
        qwVar.f5407i = i2;
        qwVar.f5409th = i2;
        qwVar.f5408o = s;
        qwVar.f5411yj = b;
        qwVar.f5410uk = i3;
        this.f5404uk.pf();
        return this.f5404uk.rg();
    }
}
