package org.json.alipay;

import com.baidu.search.basic.utils.SearchABTestUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f2934a;

    /* renamed from: b  reason: collision with root package name */
    public Reader f2935b;

    /* renamed from: c  reason: collision with root package name */
    public char f2936c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2937d;

    public c(Reader reader) {
        this.f2935b = !reader.markSupported() ? new BufferedReader(reader) : reader;
        this.f2937d = false;
        this.f2934a = 0;
    }

    public c(String str) {
        this((Reader) new StringReader(str));
    }

    private String a(int i2) {
        if (i2 == 0) {
            return "";
        }
        char[] cArr = new char[i2];
        int i3 = 0;
        if (this.f2937d) {
            this.f2937d = false;
            cArr[0] = this.f2936c;
            i3 = 1;
        }
        while (i3 < i2) {
            try {
                int read = this.f2935b.read(cArr, i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            } catch (IOException e2) {
                throw new JSONException((Throwable) e2);
            }
        }
        this.f2934a += i3;
        if (i3 >= i2) {
            this.f2936c = cArr[i2 - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i2;
        if (this.f2937d || (i2 = this.f2934a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f2934a = i2 - 1;
        this.f2937d = true;
    }

    public final char b() {
        if (this.f2937d) {
            this.f2937d = false;
            char c2 = this.f2936c;
            if (c2 != 0) {
                this.f2934a++;
            }
            return c2;
        }
        try {
            int read = this.f2935b.read();
            if (read <= 0) {
                this.f2936c = 0;
                return 0;
            }
            this.f2934a++;
            char c3 = (char) read;
            this.f2936c = c3;
            return c3;
        } catch (IOException e2) {
            throw new JSONException((Throwable) e2);
        }
    }

    public final char c() {
        char b2;
        char b3;
        char b4;
        while (true) {
            b2 = b();
            if (b2 == '/') {
                char b5 = b();
                if (b5 != '*') {
                    if (b5 == '/') {
                        do {
                            b4 = b();
                            if (b4 == 10 || b4 == 13) {
                                break;
                            }
                        } while (b4 != 0);
                    } else {
                        a();
                        return '/';
                    }
                } else {
                    while (true) {
                        char b6 = b();
                        if (b6 != 0) {
                            if (b6 == '*') {
                                if (b() == '/') {
                                    break;
                                }
                                a();
                            }
                        } else {
                            throw a("Unclosed comment");
                        }
                    }
                }
            } else if (b2 == '#') {
                do {
                    b3 = b();
                    if (b3 == 10 || b3 == 13) {
                        break;
                    }
                } while (b3 != 0);
            } else if (b2 == 0 || b2 > ' ') {
                return b2;
            }
        }
        return b2;
    }

    public final Object d() {
        String str;
        char c2 = c();
        if (c2 != '\"') {
            if (c2 != '[') {
                if (c2 == '{') {
                    a();
                    return new b(this);
                } else if (c2 != '\'') {
                    if (c2 != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c3 = c2;
                        while (c3 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c3) < 0) {
                            stringBuffer.append(c3);
                            c3 = b();
                        }
                        a();
                        String trim = stringBuffer.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        } else if (trim.equalsIgnoreCase("true")) {
                            return Boolean.TRUE;
                        } else {
                            if (trim.equalsIgnoreCase("false")) {
                                return Boolean.FALSE;
                            }
                            if (trim.equalsIgnoreCase("null")) {
                                return b.f2932a;
                            }
                            if ((c2 < '0' || c2 > '9') && c2 != '.' && c2 != '-' && c2 != '+') {
                                return trim;
                            }
                            if (c2 == '0') {
                                if (trim.length() <= 2 || (trim.charAt(1) != 'x' && trim.charAt(1) != 'X')) {
                                    return new Integer(Integer.parseInt(trim, 8));
                                }
                                try {
                                    return new Integer(Integer.parseInt(trim.substring(2), 16));
                                } catch (Exception e2) {
                                }
                            }
                            try {
                                return new Integer(trim);
                            } catch (Exception e3) {
                                try {
                                    return new Long(trim);
                                } catch (Exception e4) {
                                    try {
                                        return new Double(trim);
                                    } catch (Exception e5) {
                                        return trim;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            a();
            return new a(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char b2 = b();
            if (b2 != 0 && b2 != 10 && b2 != 13) {
                if (b2 == '\\') {
                    b2 = b();
                    if (b2 == 'b') {
                        stringBuffer2.append(8);
                    } else if (b2 == 'f') {
                        b2 = SearchABTestUtils.PREFETCH_FREQ_STRAT_NQE4;
                    } else if (b2 == 'n') {
                        stringBuffer2.append(10);
                    } else if (b2 != 'r') {
                        if (b2 == 'x') {
                            str = a(2);
                        } else if (b2 == 't') {
                            b2 = 9;
                        } else if (b2 == 'u') {
                            str = a(4);
                        }
                        b2 = (char) Integer.parseInt(str, 16);
                    } else {
                        stringBuffer2.append(13);
                    }
                } else if (b2 == c2) {
                    return stringBuffer2.toString();
                }
                stringBuffer2.append(b2);
            }
        }
        throw a("Unterminated string");
    }

    public final String toString() {
        return " at character " + this.f2934a;
    }
}
