package com.baidu.wallet.core.lollipop.json;

import com.google.zxing.client.result.ResultParser;
import org.apache.commons.lang3.CharUtils;

public class JSONTokener {
    public final String in;
    public int pos;

    public JSONTokener(String str) {
        if (str != null && str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
            str = str.substring(1);
        }
        this.in = str;
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (c < 'A' || c > 'F') {
            c2 = 'a';
            if (c < 'a' || c > 'f') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    private int nextCleanInternal() throws JSONException {
        while (this.pos < this.in.length()) {
            String str = this.in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (!(charAt == 9 || charAt == 10 || charAt == 13 || charAt == ' ')) {
                if (charAt == '#') {
                    skipToEndOfLine();
                } else if (charAt != '/' || this.pos == this.in.length()) {
                    return charAt;
                } else {
                    char charAt2 = this.in.charAt(this.pos);
                    if (charAt2 == '*') {
                        int i3 = this.pos + 1;
                        this.pos = i3;
                        int indexOf = this.in.indexOf("*/", i3);
                        if (indexOf != -1) {
                            this.pos = indexOf + 2;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (charAt2 != '/') {
                        return charAt;
                    } else {
                        this.pos++;
                        skipToEndOfLine();
                    }
                }
            }
        }
        return -1;
    }

    private String nextToInternal(String str) {
        int i2 = this.pos;
        while (this.pos < this.in.length()) {
            char charAt = this.in.charAt(this.pos);
            if (charAt == 13 || charAt == 10 || str.indexOf(charAt) != -1) {
                return this.in.substring(i2, this.pos);
            }
            this.pos++;
        }
        return this.in.substring(i2);
    }

    private JSONArray readArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal != -1) {
                if (nextCleanInternal == 44 || nextCleanInternal == 59) {
                    jSONArray.put((Object) null);
                } else if (nextCleanInternal != 93) {
                    this.pos--;
                    jSONArray.put(nextValue());
                    int nextCleanInternal2 = nextCleanInternal();
                    if (!(nextCleanInternal2 == 44 || nextCleanInternal2 == 59)) {
                        if (nextCleanInternal2 == 93) {
                            return jSONArray;
                        }
                        throw syntaxError("Unterminated array");
                    }
                } else {
                    if (z) {
                        jSONArray.put((Object) null);
                    }
                    return jSONArray;
                }
                z = true;
            } else {
                throw syntaxError("Unterminated array");
            }
        }
    }

    private char readEscapeCharacter() throws JSONException {
        String str = this.in;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char charAt = str.charAt(i2);
        if (charAt == 'b') {
            return 8;
        }
        if (charAt == 'f') {
            return 12;
        }
        if (charAt == 'n') {
            return 10;
        }
        if (charAt == 'r') {
            return CharUtils.CR;
        }
        if (charAt == 't') {
            return 9;
        }
        if (charAt != 'u') {
            return charAt;
        }
        if (this.pos + 4 <= this.in.length()) {
            String str2 = this.in;
            int i3 = this.pos;
            String substring = str2.substring(i3, i3 + 4);
            this.pos += 4;
            return (char) Integer.parseInt(substring, 16);
        }
        throw syntaxError("Unterminated escape sequence");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0087 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object readLiteral() throws com.baidu.wallet.core.lollipop.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "{}[]/\\:,=;# \t\f"
            java.lang.String r0 = r6.nextToInternal(r0)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = "null"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0017
            java.lang.Object r0 = com.baidu.wallet.core.lollipop.json.JSONObject.NULL
            return r0
        L_0x0017:
            java.lang.String r1 = "true"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0022
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0022:
            java.lang.String r1 = "false"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x002d
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        L_0x002d:
            r1 = 46
            int r1 = r0.indexOf(r1)
            r2 = -1
            if (r1 != r2) goto L_0x0087
            r1 = 10
            java.lang.String r2 = "0x"
            boolean r2 = r0.startsWith(r2)
            if (r2 != 0) goto L_0x0063
            java.lang.String r2 = "0X"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x0049
            goto L_0x0063
        L_0x0049:
            java.lang.String r2 = "0"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x005f
            int r2 = r0.length()
            r3 = 1
            if (r2 <= r3) goto L_0x005f
            java.lang.String r1 = r0.substring(r3)
            r2 = 8
            goto L_0x006a
        L_0x005f:
            r1 = r0
            r2 = 10
            goto L_0x006a
        L_0x0063:
            r1 = 2
            java.lang.String r1 = r0.substring(r1)
            r2 = 16
        L_0x006a:
            long r1 = java.lang.Long.parseLong(r1, r2)     // Catch:{ NumberFormatException -> 0x0087 }
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0082
            r3 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0082
            int r2 = (int) r1     // Catch:{ NumberFormatException -> 0x0087 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0087 }
            return r0
        L_0x0082:
            java.lang.Long r0 = java.lang.Long.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0087 }
            return r0
        L_0x0087:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ NumberFormatException -> 0x008b }
        L_0x008b:
            return r0
        L_0x008c:
            java.lang.String r0 = "Expected literal value"
            com.baidu.wallet.core.lollipop.json.JSONException r0 = r6.syntaxError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.lollipop.json.JSONTokener.readLiteral():java.lang.Object");
    }

    private JSONObject readObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return jSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            if (nextValue instanceof String) {
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 == 58 || nextCleanInternal2 == 61) {
                    if (this.pos < this.in.length() && this.in.charAt(this.pos) == '>') {
                        this.pos++;
                    }
                    jSONObject.put((String) nextValue, nextValue());
                    int nextCleanInternal3 = nextCleanInternal();
                    if (nextCleanInternal3 != 44 && nextCleanInternal3 != 59) {
                        if (nextCleanInternal3 == 125) {
                            return jSONObject;
                        }
                        throw syntaxError("Unterminated object");
                    }
                } else {
                    throw syntaxError("Expected ':' after " + nextValue);
                }
            } else if (nextValue == null) {
                throw syntaxError("Names cannot be null");
            } else {
                throw syntaxError("Names must be strings, but " + nextValue + " is of type " + nextValue.getClass().getName());
            }
        }
    }

    private void skipToEndOfLine() {
        while (this.pos < this.in.length()) {
            char charAt = this.in.charAt(this.pos);
            if (charAt == 13 || charAt == 10) {
                this.pos++;
                return;
            }
            this.pos++;
        }
    }

    public void back() {
        int i2 = this.pos - 1;
        this.pos = i2;
        if (i2 == -1) {
            this.pos = 0;
        }
    }

    public boolean more() {
        return this.pos < this.in.length();
    }

    public char next() {
        if (this.pos >= this.in.length()) {
            return 0;
        }
        String str = this.in;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return str.charAt(i2);
    }

    public char nextClean() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            return 0;
        }
        return (char) nextCleanInternal;
    }

    public String nextString(char c) throws JSONException {
        int i2 = this.pos;
        StringBuilder sb = null;
        while (this.pos < this.in.length()) {
            String str = this.in;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == c) {
                if (sb == null) {
                    return this.in.substring(i2, this.pos - 1);
                }
                sb.append(this.in, i2, this.pos - 1);
                return sb.toString();
            } else if (charAt == '\\') {
                if (this.pos != this.in.length()) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.in, i2, this.pos - 1);
                    sb.append(readEscapeCharacter());
                    i2 = this.pos;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
        }
        throw syntaxError("Unterminated string");
    }

    public String nextTo(String str) {
        if (str != null) {
            return nextToInternal(str).trim();
        }
        throw new NullPointerException("excluded == null");
    }

    public Object nextValue() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            throw syntaxError("End of input");
        } else if (nextCleanInternal == 34 || nextCleanInternal == 39) {
            return nextString((char) nextCleanInternal);
        } else {
            if (nextCleanInternal == 91) {
                return readArray();
            }
            if (nextCleanInternal == 123) {
                return readObject();
            }
            this.pos--;
            return readLiteral();
        }
    }

    public void skipPast(String str) {
        int indexOf = this.in.indexOf(str, this.pos);
        this.pos = indexOf == -1 ? this.in.length() : str.length() + indexOf;
    }

    public char skipTo(char c) {
        int indexOf = this.in.indexOf(c, this.pos);
        if (indexOf == -1) {
            return 0;
        }
        this.pos = indexOf;
        return c;
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + this);
    }

    public String toString() {
        return " at character " + this.pos + " of " + this.in;
    }

    public char next(char c) throws JSONException {
        char next = next();
        if (next == c) {
            return next;
        }
        throw syntaxError("Expected " + c + " but was " + next);
    }

    public String nextTo(char c) {
        return nextToInternal(String.valueOf(c)).trim();
    }

    public String next(int i2) throws JSONException {
        if (this.pos + i2 <= this.in.length()) {
            String str = this.in;
            int i3 = this.pos;
            String substring = str.substring(i3, i3 + i2);
            this.pos += i2;
            return substring;
        }
        throw syntaxError(i2 + " is out of bounds");
    }
}
