package fe.qw.qw.ppp.l;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonDataException;
import com.airbnb.lottie.parser.moshi.JsonEncodingException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.CharUtils;

public final class ad extends JsonReader {
    public static final ByteString aaa = ByteString.encodeUtf8("*/");
    public static final ByteString ddd = ByteString.encodeUtf8("\"\\");
    public static final ByteString mmm = ByteString.encodeUtf8("\n\r");
    public static final ByteString nn = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString xxx = ByteString.encodeUtf8("'\\");
    public int ggg;

    /* renamed from: if  reason: not valid java name */
    public final BufferedSource f111if;
    public long ppp;

    /* renamed from: switch  reason: not valid java name */
    public final Buffer f112switch;
    @Nullable
    public String vvv;
    public int when = 0;

    public ad(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f111if = bufferedSource;
            this.f112switch = bufferedSource.buffer();
            xxx(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    public final boolean a(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (!(i2 == 47 || i2 == 61)) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        eee();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.f112switch.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.f111if.request(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        eee();
        r3 = r6.f112switch.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.f112switch.readByte();
        r6.f112switch.readByte();
        k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.f112switch.readByte();
        r6.f112switch.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (j() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        qqq("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        eee();
        k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            okio.BufferedSource r2 = r6.f111if
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.f112switch
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L_0x0080
            r2 = 32
            if (r1 == r2) goto L_0x0080
            r2 = 13
            if (r1 == r2) goto L_0x0080
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            okio.Buffer r2 = r6.f112switch
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.f111if
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.eee()
            okio.Buffer r3 = r6.f112switch
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.f112switch
            r1.readByte()
            okio.Buffer r1 = r6.f112switch
            r1.readByte()
            r6.k()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.f112switch
            r1.readByte()
            okio.Buffer r1 = r6.f112switch
            r1.readByte()
            boolean r1 = r6.j()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            r6.qqq(r7)
            r7 = 0
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.eee()
            r6.k()
            goto L_0x0001
        L_0x007f:
            return r1
        L_0x0080:
            r1 = r3
            goto L_0x0002
        L_0x0082:
            if (r7 != 0) goto L_0x0086
            r7 = -1
            return r7
        L_0x0086:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.ppp.l.ad.b(boolean):int");
    }

    public final String c(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f111if.indexOfElement(byteString);
            if (indexOfElement == -1) {
                qqq("Unterminated string");
                throw null;
            } else if (this.f112switch.getByte(indexOfElement) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f112switch.readUtf8(indexOfElement));
                this.f112switch.readByte();
                sb.append(g());
            } else if (sb == null) {
                String readUtf8 = this.f112switch.readUtf8(indexOfElement);
                this.f112switch.readByte();
                return readUtf8;
            } else {
                sb.append(this.f112switch.readUtf8(indexOfElement));
                this.f112switch.readByte();
                return sb.toString();
            }
        }
    }

    public void close() throws IOException {
        this.when = 0;
        this.f630th[0] = 8;
        this.f627ad = 1;
        this.f112switch.clear();
        this.f111if.close();
    }

    public final String d() throws IOException {
        long indexOfElement = this.f111if.indexOfElement(nn);
        return indexOfElement != -1 ? this.f112switch.readUtf8(indexOfElement) : this.f112switch.readUtf8();
    }

    public int ddd(JsonReader.qw qwVar) throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return tt(this.vvv, qwVar);
        }
        int select = this.f111if.select(qwVar.f633ad);
        if (select != -1) {
            this.when = 0;
            this.f632yj[this.f627ad - 1] = qwVar.qw[select];
            return select;
        }
        String str = this.f632yj[this.f627ad - 1];
        String when2 = when();
        int tt = tt(when2, qwVar);
        if (tt == -1) {
            this.when = 15;
            this.vvv = when2;
            this.f632yj[this.f627ad - 1] = str;
        }
        return tt;
    }

    public void de() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 3) {
            xxx(1);
            this.f631uk[this.f627ad - 1] = 0;
            this.when = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + vvv() + " at path " + getPath());
    }

    public final int e() throws IOException {
        String str;
        String str2;
        int i2;
        byte b = this.f112switch.getByte(0);
        if (b == 116 || b == 84) {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (b == 102 || b == 70) {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (b != 110 && b != 78) {
            return 0;
        } else {
            i2 = 7;
            str2 = StringUtil.NULL_STRING;
            str = "NULL";
        }
        int length = str2.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f111if.request((long) i4)) {
                return 0;
            }
            byte b2 = this.f112switch.getByte((long) i3);
            if (b2 != str2.charAt(i3) && b2 != str.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f111if.request((long) (length + 1)) && a(this.f112switch.getByte((long) length))) {
            return 0;
        }
        this.f112switch.skip((long) length);
        this.when = i2;
        return i2;
    }

    public final void eee() throws IOException {
        if (!this.f628i) {
            qqq("Use JsonReader.setLenient(true) to accept malformed JSON");
            throw null;
        }
    }

    public final int f() throws IOException {
        byte b;
        boolean z = true;
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        char c = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.f111if.request((long) i4)) {
                break;
            }
            b = this.f112switch.getByte((long) i3);
            if (b != 43) {
                if (b != 69 && b != 101) {
                    if (b != 45) {
                        if (b != 46) {
                            if (b >= 48 && b <= 57) {
                                if (c == z || c == 0) {
                                    j = (long) (-(b - 48));
                                    i2 = 0;
                                    c = 2;
                                } else {
                                    if (c == 2) {
                                        if (j == 0) {
                                            return i2;
                                        }
                                        long j2 = (10 * j) - ((long) (b - 48));
                                        int i5 = (j > com.google.gson.stream.JsonReader.MIN_INCOMPLETE_INTEGER ? 1 : (j == com.google.gson.stream.JsonReader.MIN_INCOMPLETE_INTEGER ? 0 : -1));
                                        z2 &= i5 > 0 || (i5 == 0 && j2 < j);
                                        j = j2;
                                    } else if (c == 3) {
                                        i2 = 0;
                                        c = 4;
                                    } else if (c == 5 || c == 6) {
                                        i2 = 0;
                                        c = 7;
                                    }
                                    i2 = 0;
                                }
                            }
                        } else if (c != 2) {
                            return i2;
                        } else {
                            c = 3;
                        }
                    } else if (c == 0) {
                        c = 1;
                        z3 = true;
                    } else if (c != 5) {
                        return i2;
                    }
                    i3 = i4;
                    z = true;
                } else if (c != 2 && c != 4) {
                    return i2;
                } else {
                    c = 5;
                    i3 = i4;
                    z = true;
                }
            } else if (c != 5) {
                return i2;
            }
            c = 6;
            i3 = i4;
            z = true;
        }
        if (a(b)) {
            return 0;
        }
        if (c == 2 && z2 && ((j != Long.MIN_VALUE || z3) && (j != 0 || !z3))) {
            if (!z3) {
                j = -j;
            }
            this.ppp = j;
            this.f112switch.skip((long) i3);
            this.when = 16;
            return 16;
        } else if (c != 2 && c != 4 && c != 7) {
            return 0;
        } else {
            this.ggg = i3;
            this.when = 17;
            return 17;
        }
    }

    public void fe() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 1) {
            xxx(3);
            this.when = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + vvv() + " at path " + getPath());
    }

    public final char g() throws IOException {
        int i2;
        int i3;
        if (this.f111if.request(1)) {
            byte readByte = this.f112switch.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return CharUtils.CR;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.f628i) {
                    return (char) readByte;
                }
                qqq("Invalid escape sequence: \\" + ((char) readByte));
                throw null;
            } else if (this.f111if.request(4)) {
                char c = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    byte b = this.f112switch.getByte((long) i4);
                    char c2 = (char) (c << 4);
                    if (b < 48 || b > 57) {
                        if (b >= 97 && b <= 102) {
                            i2 = b - 97;
                        } else if (b < 65 || b > 70) {
                            qqq("\\u" + this.f112switch.readUtf8(4));
                            throw null;
                        } else {
                            i2 = b - 65;
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = b - 48;
                    }
                    c = (char) (c2 + i3);
                }
                this.f112switch.skip(4);
                return c;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            qqq("Unterminated escape sequence");
            throw null;
        }
    }

    public final void h(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f111if.indexOfElement(byteString);
            if (indexOfElement == -1) {
                qqq("Unterminated string");
                throw null;
            } else if (this.f112switch.getByte(indexOfElement) == 92) {
                this.f112switch.skip(indexOfElement + 1);
                g();
            } else {
                this.f112switch.skip(indexOfElement + 1);
                return;
            }
        }
    }

    public final boolean j() throws IOException {
        long indexOf = this.f111if.indexOf(aaa);
        boolean z = indexOf != -1;
        Buffer buffer = this.f112switch;
        buffer.skip(z ? indexOf + ((long) aaa.size()) : buffer.size());
        return z;
    }

    public final void k() throws IOException {
        long indexOfElement = this.f111if.indexOfElement(mmm);
        Buffer buffer = this.f112switch;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    public final void l() throws IOException {
        long indexOfElement = this.f111if.indexOfElement(nn);
        Buffer buffer = this.f112switch;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public void mmm() throws IOException {
        if (!this.f629o) {
            int i2 = 0;
            do {
                int i3 = this.when;
                if (i3 == 0) {
                    i3 = rrr();
                }
                if (i3 == 3) {
                    xxx(1);
                } else if (i3 == 1) {
                    xxx(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.f627ad--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + vvv() + " at path " + getPath());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.f627ad--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + vvv() + " at path " + getPath());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        l();
                    } else if (i3 == 9 || i3 == 13) {
                        h(ddd);
                    } else if (i3 == 8 || i3 == 12) {
                        h(xxx);
                    } else if (i3 == 17) {
                        this.f112switch.skip((long) this.ggg);
                    } else if (i3 == 18) {
                        throw new JsonDataException("Expected a value but was " + vvv() + " at path " + getPath());
                    }
                    this.when = 0;
                }
                i2++;
                this.when = 0;
            } while (i2 != 0);
            int[] iArr = this.f631uk;
            int i4 = this.f627ad;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.f632yj[i4 - 1] = StringUtil.NULL_STRING;
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + vvv() + " at " + getPath());
    }

    public void nn() throws IOException {
        if (!this.f629o) {
            int i2 = this.when;
            if (i2 == 0) {
                i2 = rrr();
            }
            if (i2 == 14) {
                l();
            } else if (i2 == 13) {
                h(ddd);
            } else if (i2 == 12) {
                h(xxx);
            } else if (i2 != 15) {
                throw new JsonDataException("Expected a name but was " + vvv() + " at path " + getPath());
            }
            this.when = 0;
            this.f632yj[this.f627ad - 1] = StringUtil.NULL_STRING;
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + vvv() + " at " + getPath());
    }

    public double pf() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 16) {
            this.when = 0;
            int[] iArr = this.f631uk;
            int i3 = this.f627ad - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.ppp;
        }
        if (i2 == 17) {
            this.vvv = this.f112switch.readUtf8((long) this.ggg);
        } else if (i2 == 9) {
            this.vvv = c(ddd);
        } else if (i2 == 8) {
            this.vvv = c(xxx);
        } else if (i2 == 10) {
            this.vvv = d();
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a double but was " + vvv() + " at path " + getPath());
        }
        this.when = 11;
        try {
            double parseDouble = Double.parseDouble(this.vvv);
            if (this.f628i || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.vvv = null;
                this.when = 0;
                int[] iArr2 = this.f631uk;
                int i4 = this.f627ad - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.vvv + " at path " + getPath());
        }
    }

    public String ppp() throws IOException {
        String str;
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 10) {
            str = d();
        } else if (i2 == 9) {
            str = c(ddd);
        } else if (i2 == 8) {
            str = c(xxx);
        } else if (i2 == 11) {
            str = this.vvv;
            this.vvv = null;
        } else if (i2 == 16) {
            str = Long.toString(this.ppp);
        } else if (i2 == 17) {
            str = this.f112switch.readUtf8((long) this.ggg);
        } else {
            throw new JsonDataException("Expected a string but was " + vvv() + " at path " + getPath());
        }
        this.when = 0;
        int[] iArr = this.f631uk;
        int i3 = this.f627ad - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public void rg() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 4) {
            int i3 = this.f627ad - 1;
            this.f627ad = i3;
            int[] iArr = this.f631uk;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.when = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + vvv() + " at path " + getPath());
    }

    public final int rrr() throws IOException {
        int[] iArr = this.f630th;
        int i2 = this.f627ad;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int b = b(true);
            this.f112switch.readByte();
            if (b != 44) {
                if (b == 59) {
                    eee();
                } else if (b == 93) {
                    this.when = 4;
                    return 4;
                } else {
                    qqq("Unterminated array");
                    throw null;
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            this.f630th[this.f627ad - 1] = 4;
            if (i3 == 5) {
                int b2 = b(true);
                this.f112switch.readByte();
                if (b2 != 44) {
                    if (b2 == 59) {
                        eee();
                    } else if (b2 == 125) {
                        this.when = 2;
                        return 2;
                    } else {
                        qqq("Unterminated object");
                        throw null;
                    }
                }
            }
            int b3 = b(true);
            if (b3 == 34) {
                this.f112switch.readByte();
                this.when = 13;
                return 13;
            } else if (b3 == 39) {
                this.f112switch.readByte();
                eee();
                this.when = 12;
                return 12;
            } else if (b3 != 125) {
                eee();
                if (a((char) b3)) {
                    this.when = 14;
                    return 14;
                }
                qqq("Expected name");
                throw null;
            } else if (i3 != 5) {
                this.f112switch.readByte();
                this.when = 2;
                return 2;
            } else {
                qqq("Expected name");
                throw null;
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int b4 = b(true);
            this.f112switch.readByte();
            if (b4 != 58) {
                if (b4 == 61) {
                    eee();
                    if (this.f111if.request(1) && this.f112switch.getByte(0) == 62) {
                        this.f112switch.readByte();
                    }
                } else {
                    qqq("Expected ':'");
                    throw null;
                }
            }
        } else if (i3 == 6) {
            iArr[i2 - 1] = 7;
        } else if (i3 == 7) {
            if (b(false) == -1) {
                this.when = 18;
                return 18;
            }
            eee();
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int b5 = b(true);
        if (b5 == 34) {
            this.f112switch.readByte();
            this.when = 9;
            return 9;
        } else if (b5 != 39) {
            if (!(b5 == 44 || b5 == 59)) {
                if (b5 == 91) {
                    this.f112switch.readByte();
                    this.when = 3;
                    return 3;
                } else if (b5 != 93) {
                    if (b5 != 123) {
                        int e = e();
                        if (e != 0) {
                            return e;
                        }
                        int f = f();
                        if (f != 0) {
                            return f;
                        }
                        if (a(this.f112switch.getByte(0))) {
                            eee();
                            this.when = 10;
                            return 10;
                        }
                        qqq("Expected value");
                        throw null;
                    }
                    this.f112switch.readByte();
                    this.when = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f112switch.readByte();
                    this.when = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                eee();
                this.when = 7;
                return 7;
            }
            qqq("Unexpected value");
            throw null;
        } else {
            eee();
            this.f112switch.readByte();
            this.when = 8;
            return 8;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public int m237switch() throws IOException {
        String str;
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 16) {
            long j = this.ppp;
            int i3 = (int) j;
            if (j == ((long) i3)) {
                this.when = 0;
                int[] iArr = this.f631uk;
                int i4 = this.f627ad - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new JsonDataException("Expected an int but was " + this.ppp + " at path " + getPath());
        }
        if (i2 == 17) {
            this.vvv = this.f112switch.readUtf8((long) this.ggg);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                str = c(ddd);
            } else {
                str = c(xxx);
            }
            this.vvv = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.when = 0;
                int[] iArr2 = this.f631uk;
                int i5 = this.f627ad - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected an int but was " + vvv() + " at path " + getPath());
        }
        this.when = 11;
        try {
            double parseDouble = Double.parseDouble(this.vvv);
            int i6 = (int) parseDouble;
            if (((double) i6) == parseDouble) {
                this.vvv = null;
                this.when = 0;
                int[] iArr3 = this.f631uk;
                int i7 = this.f627ad - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.vvv + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.vvv + " at path " + getPath());
        }
    }

    public void th() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 2) {
            int i3 = this.f627ad - 1;
            this.f627ad = i3;
            this.f632yj[i3] = null;
            int[] iArr = this.f631uk;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.when = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + vvv() + " at path " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.f111if + ")";
    }

    public final int tt(String str, JsonReader.qw qwVar) {
        int length = qwVar.qw.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(qwVar.qw[i2])) {
                this.when = 0;
                this.f632yj[this.f627ad - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    public boolean uk() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 5) {
            this.when = 0;
            int[] iArr = this.f631uk;
            int i3 = this.f627ad - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.when = 0;
            int[] iArr2 = this.f631uk;
            int i4 = this.f627ad - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + vvv() + " at path " + getPath());
        }
    }

    public JsonReader.Token vvv() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        switch (i2) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String when() throws IOException {
        String str;
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        if (i2 == 14) {
            str = d();
        } else if (i2 == 13) {
            str = c(ddd);
        } else if (i2 == 12) {
            str = c(xxx);
        } else if (i2 == 15) {
            str = this.vvv;
        } else {
            throw new JsonDataException("Expected a name but was " + vvv() + " at path " + getPath());
        }
        this.when = 0;
        this.f632yj[this.f627ad - 1] = str;
        return str;
    }

    public boolean yj() throws IOException {
        int i2 = this.when;
        if (i2 == 0) {
            i2 = rrr();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }
}
