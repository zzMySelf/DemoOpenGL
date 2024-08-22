package fe.th.de.rrr.o;

import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.x.d;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.apollon.restnet.http.b;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.common.primitives.SignedBytes;
import fe.th.de.rrr.fe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static final Map<ByteString, Integer> f5310ad = ad();
    public static final qw[] qw = {new qw(qw.f5345i, ""), new qw(qw.f5347th, (String) ShareTarget.METHOD_GET), new qw(qw.f5347th, "POST"), new qw(qw.f5349yj, "/"), new qw(qw.f5349yj, "/index.html"), new qw(qw.f5348uk, "http"), new qw(qw.f5348uk, "https"), new qw(qw.f5346rg, "200"), new qw(qw.f5346rg, "204"), new qw(qw.f5346rg, "206"), new qw(qw.f5346rg, "304"), new qw(qw.f5346rg, "400"), new qw(qw.f5346rg, "404"), new qw(qw.f5346rg, "500"), new qw("accept-charset", ""), new qw("accept-encoding", "gzip, deflate"), new qw("accept-language", ""), new qw("accept-ranges", ""), new qw((String) LightappBusinessClient.ACCEPT_MESSAGE_CB, ""), new qw("access-control-allow-origin", ""), new qw("age", ""), new qw("allow", ""), new qw("authorization", ""), new qw("cache-control", ""), new qw("content-disposition", ""), new qw("content-encoding", ""), new qw("content-language", ""), new qw("content-length", ""), new qw("content-location", ""), new qw("content-range", ""), new qw((String) e.f, ""), new qw("cookie", ""), new qw("date", ""), new qw("etag", ""), new qw("expect", ""), new qw("expires", ""), new qw("from", ""), new qw("host", ""), new qw("if-match", ""), new qw("if-modified-since", ""), new qw("if-none-match", ""), new qw("if-range", ""), new qw("if-unmodified-since", ""), new qw("last-modified", ""), new qw((String) ActionJsonData.TAG_LINK, ""), new qw((String) b.c.j, ""), new qw("max-forwards", ""), new qw("proxy-authenticate", ""), new qw("proxy-authorization", ""), new qw("range", ""), new qw("referer", ""), new qw((String) d.w, ""), new qw("retry-after", ""), new qw("server", ""), new qw("set-cookie", ""), new qw("strict-transport-security", ""), new qw((String) Http2ExchangeCodec.TRANSFER_ENCODING, ""), new qw("user-agent", ""), new qw("vary", ""), new qw("via", ""), new qw("www-authenticate", "")};

    /* renamed from: fe.th.de.rrr.o.ad$ad  reason: collision with other inner class name */
    public static final class C0224ad {

        /* renamed from: ad  reason: collision with root package name */
        public final boolean f5311ad;

        /* renamed from: de  reason: collision with root package name */
        public int f5312de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f5313fe;

        /* renamed from: i  reason: collision with root package name */
        public int f5314i;
        public final Buffer qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f5315rg;

        /* renamed from: th  reason: collision with root package name */
        public qw[] f5316th;

        /* renamed from: uk  reason: collision with root package name */
        public int f5317uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f5318yj;

        public C0224ad(Buffer buffer) {
            this(4096, true, buffer);
        }

        public final void ad() {
            Arrays.fill(this.f5316th, (Object) null);
            this.f5318yj = this.f5316th.length - 1;
            this.f5317uk = 0;
            this.f5314i = 0;
        }

        public final int de(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f5316th.length;
                while (true) {
                    length--;
                    if (length < this.f5318yj || i2 <= 0) {
                        qw[] qwVarArr = this.f5316th;
                        int i4 = this.f5318yj;
                        System.arraycopy(qwVarArr, i4 + 1, qwVarArr, i4 + 1 + i3, this.f5317uk);
                        qw[] qwVarArr2 = this.f5316th;
                        int i5 = this.f5318yj;
                        Arrays.fill(qwVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                        this.f5318yj += i3;
                    } else {
                        qw[] qwVarArr3 = this.f5316th;
                        i2 -= qwVarArr3[length].f5351de;
                        this.f5314i -= qwVarArr3[length].f5351de;
                        this.f5317uk--;
                        i3++;
                    }
                }
                qw[] qwVarArr4 = this.f5316th;
                int i42 = this.f5318yj;
                System.arraycopy(qwVarArr4, i42 + 1, qwVarArr4, i42 + 1 + i3, this.f5317uk);
                qw[] qwVarArr22 = this.f5316th;
                int i52 = this.f5318yj;
                Arrays.fill(qwVarArr22, i52 + 1, i52 + 1 + i3, (Object) null);
                this.f5318yj += i3;
            }
            return i3;
        }

        public final void fe(qw qwVar) {
            int i2 = qwVar.f5351de;
            int i3 = this.f5315rg;
            if (i2 > i3) {
                ad();
                return;
            }
            de((this.f5314i + i2) - i3);
            int i4 = this.f5317uk + 1;
            qw[] qwVarArr = this.f5316th;
            if (i4 > qwVarArr.length) {
                qw[] qwVarArr2 = new qw[(qwVarArr.length * 2)];
                System.arraycopy(qwVarArr, 0, qwVarArr2, qwVarArr.length, qwVarArr.length);
                this.f5318yj = this.f5316th.length - 1;
                this.f5316th = qwVarArr2;
            }
            int i5 = this.f5318yj;
            this.f5318yj = i5 - 1;
            this.f5316th[i5] = qwVar;
            this.f5317uk++;
            this.f5314i += i2;
        }

        public final void qw() {
            int i2 = this.f5315rg;
            int i3 = this.f5314i;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                ad();
            } else {
                de(i3 - i2);
            }
        }

        public void rg(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.f5315rg;
            if (i3 != min) {
                if (min < i3) {
                    this.f5312de = Math.min(this.f5312de, min);
                }
                this.f5313fe = true;
                this.f5315rg = min;
                qw();
            }
        }

        public void th(ByteString byteString) throws IOException {
            if (!this.f5311ad || i.th().rg(byteString) >= byteString.size()) {
                uk(byteString.size(), 127, 0);
                this.qw.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            i.th().fe(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            uk(readByteString.size(), 127, 128);
            this.qw.write(readByteString);
        }

        public void uk(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.qw.writeByte(i2 | i4);
                return;
            }
            this.qw.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.qw.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.qw.writeByte(i5);
        }

        public void yj(List<qw> list) throws IOException {
            int i2;
            int i3;
            if (this.f5313fe) {
                int i4 = this.f5312de;
                if (i4 < this.f5315rg) {
                    uk(i4, 31, 32);
                }
                this.f5313fe = false;
                this.f5312de = Integer.MAX_VALUE;
                uk(this.f5315rg, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                qw qwVar = list.get(i5);
                ByteString asciiLowercase = qwVar.qw.toAsciiLowercase();
                ByteString byteString = qwVar.f5350ad;
                Integer num = ad.f5310ad.get(asciiLowercase);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (fe.vvv(ad.qw[i3 - 1].f5350ad, byteString)) {
                            i2 = i3;
                        } else if (fe.vvv(ad.qw[i3].f5350ad, byteString)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.f5318yj + 1;
                    int length = this.f5316th.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (fe.vvv(this.f5316th[i6].qw, asciiLowercase)) {
                            if (fe.vvv(this.f5316th[i6].f5350ad, byteString)) {
                                i3 = ad.qw.length + (i6 - this.f5318yj);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.f5318yj) + ad.qw.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    uk(i3, 127, 128);
                } else if (i2 == -1) {
                    this.qw.writeByte(64);
                    th(asciiLowercase);
                    th(byteString);
                    fe(qwVar);
                } else if (!asciiLowercase.startsWith(qw.f5344fe) || qw.f5345i.equals(asciiLowercase)) {
                    uk(i2, 63, 64);
                    th(byteString);
                    fe(qwVar);
                } else {
                    uk(i2, 15, 0);
                    th(byteString);
                }
            }
        }

        public C0224ad(int i2, boolean z, Buffer buffer) {
            this.f5312de = Integer.MAX_VALUE;
            qw[] qwVarArr = new qw[8];
            this.f5316th = qwVarArr;
            this.f5318yj = qwVarArr.length - 1;
            this.f5317uk = 0;
            this.f5314i = 0;
            this.f5315rg = i2;
            this.f5311ad = z;
            this.qw = buffer;
        }
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final BufferedSource f5319ad;

        /* renamed from: de  reason: collision with root package name */
        public final int f5320de;

        /* renamed from: fe  reason: collision with root package name */
        public int f5321fe;
        public final List<qw> qw;

        /* renamed from: rg  reason: collision with root package name */
        public qw[] f5322rg;

        /* renamed from: th  reason: collision with root package name */
        public int f5323th;

        /* renamed from: uk  reason: collision with root package name */
        public int f5324uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f5325yj;

        public qw(int i2, Source source) {
            this(i2, i2, source);
        }

        public final void ad() {
            Arrays.fill(this.f5322rg, (Object) null);
            this.f5323th = this.f5322rg.length - 1;
            this.f5325yj = 0;
            this.f5324uk = 0;
        }

        public final int de(int i2) {
            return this.f5323th + 1 + i2;
        }

        public final int fe(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f5322rg.length;
                while (true) {
                    length--;
                    if (length < this.f5323th || i2 <= 0) {
                        qw[] qwVarArr = this.f5322rg;
                        int i4 = this.f5323th;
                        System.arraycopy(qwVarArr, i4 + 1, qwVarArr, i4 + 1 + i3, this.f5325yj);
                        this.f5323th += i3;
                    } else {
                        qw[] qwVarArr2 = this.f5322rg;
                        i2 -= qwVarArr2[length].f5351de;
                        this.f5324uk -= qwVarArr2[length].f5351de;
                        this.f5325yj--;
                        i3++;
                    }
                }
                qw[] qwVarArr3 = this.f5322rg;
                int i42 = this.f5323th;
                System.arraycopy(qwVarArr3, i42 + 1, qwVarArr3, i42 + 1 + i3, this.f5325yj);
                this.f5323th += i3;
            }
            return i3;
        }

        public final void ggg(int i2) throws IOException {
            this.qw.add(new qw(th(i2), o()));
        }

        public final int i() throws IOException {
            return this.f5319ad.readByte() & 255;
        }

        /* renamed from: if  reason: not valid java name */
        public final void m351if(int i2) throws IOException {
            if (uk(i2)) {
                this.qw.add(ad.qw[i2]);
                return;
            }
            int de2 = de(i2 - ad.qw.length);
            if (de2 >= 0) {
                qw[] qwVarArr = this.f5322rg;
                if (de2 < qwVarArr.length) {
                    this.qw.add(qwVarArr[de2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        public ByteString o() throws IOException {
            int i2 = i();
            boolean z = (i2 & 128) == 128;
            int i3 = m352switch(i2, 127);
            if (z) {
                return ByteString.of(i.th().de(this.f5319ad.readByteArray((long) i3)));
            }
            return this.f5319ad.readByteString((long) i3);
        }

        public void pf() throws IOException {
            while (!this.f5319ad.exhausted()) {
                byte readByte = this.f5319ad.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    m351if(m352switch(readByte, 127) - 1);
                } else if (readByte == 64) {
                    ppp();
                } else if ((readByte & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    when(m352switch(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int i2 = m352switch(readByte, 31);
                    this.f5321fe = i2;
                    if (i2 < 0 || i2 > this.f5320de) {
                        throw new IOException("Invalid dynamic table size update " + this.f5321fe);
                    }
                    qw();
                } else if (readByte == 16 || readByte == 0) {
                    vvv();
                } else {
                    ggg(m352switch(readByte, 15) - 1);
                }
            }
        }

        public final void ppp() throws IOException {
            ByteString o2 = o();
            ad.qw(o2);
            yj(-1, new qw(o2, o()));
        }

        public final void qw() {
            int i2 = this.f5321fe;
            int i3 = this.f5324uk;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                ad();
            } else {
                fe(i3 - i2);
            }
        }

        public List<qw> rg() {
            ArrayList arrayList = new ArrayList(this.qw);
            this.qw.clear();
            return arrayList;
        }

        /* renamed from: switch  reason: not valid java name */
        public int m352switch(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int i6 = i();
                if ((i6 & 128) == 0) {
                    return i3 + (i6 << i5);
                }
                i3 += (i6 & 127) << i5;
                i5 += 7;
            }
        }

        public final ByteString th(int i2) throws IOException {
            if (uk(i2)) {
                return ad.qw[i2].qw;
            }
            int de2 = de(i2 - ad.qw.length);
            if (de2 >= 0) {
                qw[] qwVarArr = this.f5322rg;
                if (de2 < qwVarArr.length) {
                    return qwVarArr[de2].qw;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        public final boolean uk(int i2) {
            return i2 >= 0 && i2 <= ad.qw.length - 1;
        }

        public final void vvv() throws IOException {
            ByteString o2 = o();
            ad.qw(o2);
            this.qw.add(new qw(o2, o()));
        }

        public final void when(int i2) throws IOException {
            yj(-1, new qw(th(i2), o()));
        }

        public final void yj(int i2, qw qwVar) {
            this.qw.add(qwVar);
            int i3 = qwVar.f5351de;
            if (i2 != -1) {
                i3 -= this.f5322rg[de(i2)].f5351de;
            }
            int i4 = this.f5321fe;
            if (i3 > i4) {
                ad();
                return;
            }
            int fe2 = fe((this.f5324uk + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f5325yj + 1;
                qw[] qwVarArr = this.f5322rg;
                if (i5 > qwVarArr.length) {
                    qw[] qwVarArr2 = new qw[(qwVarArr.length * 2)];
                    System.arraycopy(qwVarArr, 0, qwVarArr2, qwVarArr.length, qwVarArr.length);
                    this.f5323th = this.f5322rg.length - 1;
                    this.f5322rg = qwVarArr2;
                }
                int i6 = this.f5323th;
                this.f5323th = i6 - 1;
                this.f5322rg[i6] = qwVar;
                this.f5325yj++;
            } else {
                this.f5322rg[i2 + de(i2) + fe2] = qwVar;
            }
            this.f5324uk += i3;
        }

        public qw(int i2, int i3, Source source) {
            this.qw = new ArrayList();
            qw[] qwVarArr = new qw[8];
            this.f5322rg = qwVarArr;
            this.f5323th = qwVarArr.length - 1;
            this.f5325yj = 0;
            this.f5324uk = 0;
            this.f5320de = i2;
            this.f5321fe = i3;
            this.f5319ad = Okio.buffer(source);
        }
    }

    public static Map<ByteString, Integer> ad() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(qw.length);
        int i2 = 0;
        while (true) {
            qw[] qwVarArr = qw;
            if (i2 >= qwVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(qwVarArr[i2].qw)) {
                linkedHashMap.put(qw[i2].qw, Integer.valueOf(i2));
            }
            i2++;
        }
    }

    public static ByteString qw(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i2 = 0;
        while (i2 < size) {
            byte b = byteString.getByte(i2);
            if (b < 65 || b > 90) {
                i2++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
