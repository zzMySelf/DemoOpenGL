package com.temp.searchbox.v8engine.net;

import com.temp.searchbox.v8engine.net.io.Buffer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class HttpUrl {
    static final String FRAGMENT_ENCODE_SET = "";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    final String host;
    private final String password;
    final int port;
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    HttpUrl(Builder builder) {
        List<String> list;
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        String str = null;
        if (builder.encodedQueryNamesAndValues != null) {
            list = percentDecode(builder.encodedQueryNamesAndValues, true);
        } else {
            list = null;
        }
        this.queryNamesAndValues = list;
        this.fragment = builder.encodedFragment != null ? percentDecode(builder.encodedFragment, false) : str;
        this.url = builder.toString();
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return "https".equals(this.scheme);
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int usernameStart = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(usernameStart, Util.delimiterOffset(str, usernameStart, str.length(), ":@"));
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int passwordEnd = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, passwordEnd);
    }

    public String host() {
        return this.host;
    }

    public static int defaultPort(String scheme2) {
        if ("http".equals(scheme2)) {
            return 80;
        }
        if ("https".equals(scheme2)) {
            return 443;
        }
        return -1;
    }

    static void pathSegmentsToString(StringBuilder out, List<String> pathSegments) {
        int size = pathSegments.size();
        for (int i2 = 0; i2 < size; i2++) {
            out.append('/');
            out.append(pathSegments.get(i2));
        }
    }

    public List<String> encodedPathSegments() {
        int pathStart = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int pathEnd = Util.delimiterOffset(str, pathStart, str.length(), "?#");
        List<String> result = new ArrayList<>();
        int i2 = pathStart;
        while (i2 < pathEnd) {
            int i3 = i2 + 1;
            int segmentEnd = Util.delimiterOffset(this.url, i3, pathEnd, '/');
            result.add(this.url.substring(i3, segmentEnd));
            i2 = segmentEnd;
        }
        return result;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int queryStart = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(queryStart, Util.delimiterOffset(str, queryStart, str.length(), '#'));
    }

    public static void namesAndValuesToQueryString(StringBuilder out, List<String> namesAndValues) {
        int size = namesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String name = namesAndValues.get(i2);
            String value = namesAndValues.get(i2 + 1);
            if (i2 > 0) {
                out.append('&');
            }
            out.append(name);
            if (value != null) {
                out.append('=');
                out.append(value);
            }
        }
    }

    static List<String> queryStringToNamesAndValues(String encodedQuery) {
        List<String> result = new ArrayList<>();
        int pos = 0;
        while (pos <= encodedQuery.length()) {
            int ampersandOffset = encodedQuery.indexOf(38, pos);
            if (ampersandOffset == -1) {
                ampersandOffset = encodedQuery.length();
            }
            int equalsOffset = encodedQuery.indexOf(61, pos);
            if (equalsOffset == -1 || equalsOffset > ampersandOffset) {
                result.add(encodedQuery.substring(pos, ampersandOffset));
                result.add((Object) null);
            } else {
                result.add(encodedQuery.substring(pos, equalsOffset));
                result.add(encodedQuery.substring(equalsOffset + 1, ampersandOffset));
            }
            pos = ampersandOffset + 1;
        }
        return result;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        namesAndValuesToQueryString(result, this.queryNamesAndValues);
        return result.toString();
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String fragment() {
        return this.fragment;
    }

    public HttpUrl resolve(String link) {
        Builder builder = newBuilder(link);
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    public Builder newBuilder() {
        Builder result = new Builder();
        result.scheme = this.scheme;
        result.encodedUsername = encodedUsername();
        result.encodedPassword = encodedPassword();
        result.host = this.host;
        result.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        result.encodedPathSegments.clear();
        result.encodedPathSegments.addAll(encodedPathSegments());
        result.encodedQuery(encodedQuery());
        result.encodedFragment = encodedFragment();
        return result;
    }

    public Builder newBuilder(String link) {
        try {
            return new Builder().parse(this, link);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public static HttpUrl parse(String url2) {
        try {
            return get(url2);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public static HttpUrl get(String url2) {
        return new Builder().parse((HttpUrl) null, url2).build();
    }

    public static HttpUrl get(URL url2) {
        return parse(url2.toString());
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public boolean equals(Object other) {
        return (other instanceof HttpUrl) && ((HttpUrl) other).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public static final class Builder {
        static final String INVALID_HOST = "Invalid URL host";
        String encodedFragment;
        String encodedPassword = "";
        final List<String> encodedPathSegments;
        List<String> encodedQueryNamesAndValues;
        String encodedUsername = "";
        String host;
        int port = -1;
        String scheme;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public Builder scheme(String scheme2) {
            if (scheme2 != null) {
                if (scheme2.equalsIgnoreCase("http")) {
                    this.scheme = "http";
                } else if (scheme2.equalsIgnoreCase("https")) {
                    this.scheme = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme2);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public Builder addQueryParameter(String name, String value) {
            String str;
            if (name != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(name, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                List<String> list = this.encodedQueryNamesAndValues;
                if (value != null) {
                    str = HttpUrl.canonicalize(value, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true);
                } else {
                    str = null;
                }
                list.add(str);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public Builder host(String host2) {
            if (host2 != null) {
                String encoded = canonicalizeHost(host2, 0, host2.length());
                if (encoded != null) {
                    this.host = encoded;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + host2);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public int effectivePort() {
            int i2 = this.port;
            return i2 != -1 ? i2 : HttpUrl.defaultPort(this.scheme);
        }

        public Builder query(String query) {
            List<String> list;
            if (query != null) {
                list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(query, HttpUrl.QUERY_ENCODE_SET, false, false, true, true));
            } else {
                list = null;
            }
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public Builder encodedQuery(String encodedQuery) {
            List<String> list;
            if (encodedQuery != null) {
                list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(encodedQuery, HttpUrl.QUERY_ENCODE_SET, true, false, true, true));
            } else {
                list = null;
            }
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public Builder fragment(String fragment) {
            String str;
            if (fragment != null) {
                str = HttpUrl.canonicalize(fragment, "", false, false, false, false);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(this.scheme);
            result.append("://");
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                result.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    result.append(AbstractJsonLexerKt.COLON);
                    result.append(this.encodedPassword);
                }
                result.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                result.append(AbstractJsonLexerKt.BEGIN_LIST);
                result.append(this.host);
                result.append(AbstractJsonLexerKt.END_LIST);
            } else {
                result.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                result.append(AbstractJsonLexerKt.COLON);
                result.append(effectivePort);
            }
            HttpUrl.pathSegmentsToString(result, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                result.append('?');
                HttpUrl.namesAndValuesToQueryString(result, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                result.append('#');
                result.append(this.encodedFragment);
            }
            return result.toString();
        }

        /* access modifiers changed from: package-private */
        public Builder parse(HttpUrl base, String input) {
            char c2;
            int pos;
            int c3;
            int i2;
            char c4;
            int componentDelimiterOffset;
            String str;
            HttpUrl httpUrl = base;
            String str2 = input;
            int pos2 = Util.skipLeadingAsciiWhitespace(str2, 0, input.length());
            int limit = Util.skipTrailingAsciiWhitespace(str2, pos2, input.length());
            int schemeDelimiterOffset = schemeDelimiterOffset(str2, pos2, limit);
            int i3 = -1;
            if (schemeDelimiterOffset != -1) {
                if (input.regionMatches(true, pos2, "https:", 0, 6)) {
                    this.scheme = "https";
                    pos2 += "https:".length();
                } else if (input.regionMatches(true, pos2, "http:", 0, 5)) {
                    this.scheme = "http";
                    pos2 += "http:".length();
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, schemeDelimiterOffset) + "'");
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount = slashCount(str2, pos2, limit);
            char c5 = '#';
            if (slashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.scheme)) {
                int pos3 = pos2 + slashCount;
                boolean hasUsername = false;
                boolean hasPassword = false;
                while (true) {
                    int componentDelimiterOffset2 = Util.delimiterOffset(str2, pos3, limit, "@/\\?#");
                    if (componentDelimiterOffset2 != limit) {
                        c3 = str2.charAt(componentDelimiterOffset2);
                    } else {
                        c3 = i3;
                    }
                    switch (c3) {
                        case -1:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int componentDelimiterOffset3 = componentDelimiterOffset2;
                            int i4 = pos3;
                            c2 = c5;
                            int portColonOffset = portColonOffset(str2, pos3, componentDelimiterOffset3);
                            if (portColonOffset + 1 < componentDelimiterOffset3) {
                                this.host = canonicalizeHost(str2, pos3, portColonOffset);
                                int parsePort = parsePort(str2, portColonOffset + 1, componentDelimiterOffset3);
                                this.port = parsePort;
                                if (parsePort == -1) {
                                    throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(portColonOffset + 1, componentDelimiterOffset3) + '\"');
                                }
                            } else {
                                this.host = canonicalizeHost(str2, pos3, portColonOffset);
                                this.port = HttpUrl.defaultPort(this.scheme);
                            }
                            if (this.host != null) {
                                pos2 = componentDelimiterOffset3;
                                break;
                            } else {
                                throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(pos3, portColonOffset) + '\"');
                            }
                        case 64:
                            if (!hasPassword) {
                                int passwordColonOffset = Util.delimiterOffset(str2, pos3, componentDelimiterOffset2, (char) AbstractJsonLexerKt.COLON);
                                int passwordColonOffset2 = passwordColonOffset;
                                String str3 = "%40";
                                int componentDelimiterOffset4 = componentDelimiterOffset2;
                                int i5 = pos3;
                                c4 = c5;
                                String canonicalUsername = HttpUrl.canonicalize(input, pos3, passwordColonOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (hasUsername) {
                                    str = this.encodedUsername + str3 + canonicalUsername;
                                } else {
                                    str = canonicalUsername;
                                }
                                this.encodedUsername = str;
                                int componentDelimiterOffset5 = componentDelimiterOffset4;
                                if (passwordColonOffset2 != componentDelimiterOffset5) {
                                    hasPassword = true;
                                    componentDelimiterOffset = componentDelimiterOffset5;
                                    String str4 = canonicalUsername;
                                    this.encodedPassword = HttpUrl.canonicalize(input, passwordColonOffset2 + 1, componentDelimiterOffset5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                } else {
                                    componentDelimiterOffset = componentDelimiterOffset5;
                                    String str5 = canonicalUsername;
                                }
                                hasUsername = true;
                            } else {
                                componentDelimiterOffset = componentDelimiterOffset2;
                                c4 = c5;
                                this.encodedPassword += "%40" + HttpUrl.canonicalize(input, pos3, componentDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            pos3 = componentDelimiterOffset + 1;
                            i2 = -1;
                            continue;
                        default:
                            int i6 = componentDelimiterOffset2;
                            c4 = c5;
                            i2 = i3;
                            continue;
                    }
                    c5 = c4;
                    i3 = i2;
                    HttpUrl httpUrl2 = base;
                }
            } else {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.encodedPathSegments());
                if (pos2 == limit || str2.charAt(pos2) == '#') {
                    encodedQuery(base.encodedQuery());
                }
                c2 = '#';
            }
            int pathDelimiterOffset = Util.delimiterOffset(str2, pos2, limit, "?#");
            resolvePath(str2, pos2, pathDelimiterOffset);
            int pos4 = pathDelimiterOffset;
            if (pos4 >= limit || str2.charAt(pos4) != '?') {
                pos = pos4;
            } else {
                int queryDelimiterOffset = Util.delimiterOffset(str2, pos4, limit, c2);
                int i7 = pos4;
                this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(input, pos4 + 1, queryDelimiterOffset, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, (Charset) null));
                pos = queryDelimiterOffset;
            }
            if (pos >= limit || str2.charAt(pos) != c2) {
            } else {
                int i8 = pos;
                this.encodedFragment = HttpUrl.canonicalize(input, pos + 1, limit, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        private void resolvePath(String input, int pos, int limit) {
            if (pos != limit) {
                char c2 = input.charAt(pos);
                if (c2 == '/' || c2 == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    pos++;
                } else {
                    List<String> list = this.encodedPathSegments;
                    list.set(list.size() - 1, "");
                }
                int i2 = pos;
                while (i2 < limit) {
                    int pathSegmentDelimiterOffset = Util.delimiterOffset(input, i2, limit, "/\\");
                    boolean segmentHasTrailingSlash = pathSegmentDelimiterOffset < limit;
                    push(input, i2, pathSegmentDelimiterOffset, segmentHasTrailingSlash, true);
                    i2 = pathSegmentDelimiterOffset;
                    if (segmentHasTrailingSlash) {
                        i2++;
                    }
                }
            }
        }

        private void push(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String segment = HttpUrl.canonicalize(input, pos, limit, HttpUrl.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, true, (Charset) null);
            if (!isDot(segment)) {
                if (isDotDot(segment)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, segment);
                } else {
                    this.encodedPathSegments.add(segment);
                }
                if (addTrailingSlash) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private boolean isDot(String input) {
            return ".".equals(input) || "%2e".equalsIgnoreCase(input);
        }

        private boolean isDotDot(String input) {
            return "..".equals(input) || "%2e.".equalsIgnoreCase(input) || ".%2e".equalsIgnoreCase(input) || "%2e%2e".equalsIgnoreCase(input);
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (!list.remove(list.size() - 1).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private static int schemeDelimiterOffset(String input, int pos, int limit) {
            if (limit - pos < 2) {
                return -1;
            }
            char c0 = input.charAt(pos);
            if ((c0 < 'a' || c0 > 'z') && (c0 < 'A' || c0 > 'Z')) {
                return -1;
            }
            int i2 = pos + 1;
            while (i2 < limit) {
                char c2 = input.charAt(i2);
                if ((c2 >= 'a' && c2 <= 'z') || ((c2 >= 'A' && c2 <= 'Z') || ((c2 >= '0' && c2 <= '9') || c2 == '+' || c2 == '-' || c2 == '.'))) {
                    i2++;
                } else if (c2 == ':') {
                    return i2;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        private static int slashCount(String input, int pos, int limit) {
            int slashCount = 0;
            while (pos < limit) {
                char c2 = input.charAt(pos);
                if (c2 != '\\' && c2 != '/') {
                    break;
                }
                slashCount++;
                pos++;
            }
            return slashCount;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
            if (r0 >= r5) goto L_0x0019;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int portColonOffset(java.lang.String r3, int r4, int r5) {
            /*
                r0 = r4
            L_0x0001:
                if (r0 >= r5) goto L_0x001c
                char r1 = r3.charAt(r0)
                switch(r1) {
                    case 58: goto L_0x0018;
                    case 91: goto L_0x000b;
                    default: goto L_0x000a;
                }
            L_0x000a:
                goto L_0x0019
            L_0x000b:
                int r0 = r0 + 1
                if (r0 >= r5) goto L_0x0019
                char r1 = r3.charAt(r0)
                r2 = 93
                if (r1 != r2) goto L_0x000b
                goto L_0x0019
            L_0x0018:
                return r0
            L_0x0019:
                int r0 = r0 + 1
                goto L_0x0001
            L_0x001c:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.temp.searchbox.v8engine.net.HttpUrl.Builder.portColonOffset(java.lang.String, int, int):int");
        }

        private static String canonicalizeHost(String input, int pos, int limit) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(input, pos, limit, false));
        }

        private static int parsePort(String input, int pos, int limit) {
            try {
                int i2 = Integer.parseInt(HttpUrl.canonicalize(input, pos, limit, "", false, false, false, true, (Charset) null));
                if (i2 <= 0 || i2 > 65535) {
                    return -1;
                }
                return i2;
            } catch (NumberFormatException e2) {
                return -1;
            }
        }
    }

    static String percentDecode(String encoded, boolean plusIsSpace) {
        return percentDecode(encoded, 0, encoded.length(), plusIsSpace);
    }

    private List<String> percentDecode(List<String> list, boolean plusIsSpace) {
        int size = list.size();
        List<String> result = new ArrayList<>(size);
        for (int i2 = 0; i2 < size; i2++) {
            String s = list.get(i2);
            result.add(s != null ? percentDecode(s, plusIsSpace) : null);
        }
        return Collections.unmodifiableList(result);
    }

    static String percentDecode(String encoded, int pos, int limit, boolean plusIsSpace) {
        for (int i2 = pos; i2 < limit; i2++) {
            char c2 = encoded.charAt(i2);
            if (c2 == '%' || (c2 == '+' && plusIsSpace)) {
                Buffer out = new Buffer();
                out.writeUtf8(encoded, pos, i2);
                percentDecode(out, encoded, i2, limit, plusIsSpace);
                return out.readUtf8();
            }
        }
        return encoded.substring(pos, limit);
    }

    static void percentDecode(Buffer out, String encoded, int pos, int limit, boolean plusIsSpace) {
        int i2 = pos;
        while (i2 < limit) {
            int codePoint = encoded.codePointAt(i2);
            if (codePoint == 37 && i2 + 2 < limit) {
                int d1 = Util.decodeHexDigit(encoded.charAt(i2 + 1));
                int d2 = Util.decodeHexDigit(encoded.charAt(i2 + 2));
                if (!(d1 == -1 || d2 == -1)) {
                    out.writeByte((d1 << 4) + d2);
                    i2 += 2;
                    i2 += Character.charCount(codePoint);
                }
            } else if (codePoint == 43 && plusIsSpace) {
                out.writeByte(32);
                i2 += Character.charCount(codePoint);
            }
            out.writeUtf8CodePoint(codePoint);
            i2 += Character.charCount(codePoint);
        }
    }

    static boolean percentEncoded(String encoded, int pos, int limit) {
        return pos + 2 < limit && encoded.charAt(pos) == '%' && Util.decodeHexDigit(encoded.charAt(pos + 1)) != -1 && Util.decodeHexDigit(encoded.charAt(pos + 2)) != -1;
    }

    static String canonicalize(String input, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean asciiOnly, Charset charset) {
        String str = input;
        int i2 = limit;
        int i3 = pos;
        while (i3 < i2) {
            int codePoint = str.codePointAt(i3);
            if (codePoint < 32 || codePoint == 127) {
                String str2 = encodeSet;
            } else if (codePoint >= 128 && asciiOnly) {
                String str3 = encodeSet;
            } else if (encodeSet.indexOf(codePoint) == -1 && ((codePoint != 37 || (alreadyEncoded && (!strict || percentEncoded(str, i3, i2)))) && (codePoint != 43 || !plusIsSpace))) {
                i3 += Character.charCount(codePoint);
            }
            Buffer buffer = new Buffer();
            Buffer out = buffer;
            out.writeUtf8(str, pos, i3);
            canonicalize(buffer, input, i3, limit, encodeSet, alreadyEncoded, strict, plusIsSpace, asciiOnly, charset);
            return out.readUtf8();
        }
        String str4 = encodeSet;
        return input.substring(pos, limit);
    }

    static void canonicalize(Buffer out, String input, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean asciiOnly, Charset charset) {
        Buffer buffer = out;
        String str = input;
        int i2 = limit;
        Charset charset2 = charset;
        Buffer encodedCharBuffer = null;
        int i3 = pos;
        while (i3 < i2) {
            int codePoint = input.codePointAt(i3);
            if (alreadyEncoded && (codePoint == 9 || codePoint == 10 || codePoint == 12 || codePoint == 13)) {
                String str2 = encodeSet;
            } else if (codePoint != 43 || !plusIsSpace) {
                if (codePoint < 32 || codePoint == 127) {
                    String str3 = encodeSet;
                } else if (codePoint >= 128 && asciiOnly) {
                    String str4 = encodeSet;
                } else if (encodeSet.indexOf(codePoint) == -1 && (codePoint != 37 || (alreadyEncoded && (!strict || percentEncoded(input, i3, limit))))) {
                    out.writeUtf8CodePoint(codePoint);
                }
                if (encodedCharBuffer == null) {
                    encodedCharBuffer = new Buffer();
                }
                if (charset2 == null || charset2.equals(Util.UTF_8)) {
                    encodedCharBuffer.writeUtf8CodePoint(codePoint);
                } else {
                    encodedCharBuffer.writeString(input, i3, Character.charCount(codePoint) + i3, charset2);
                }
                while (!encodedCharBuffer.exhausted()) {
                    int b2 = encodedCharBuffer.readByte() & 255;
                    out.writeByte(37);
                    char[] cArr = HEX_DIGITS;
                    out.writeByte((int) cArr[(b2 >> 4) & 15]);
                    out.writeByte((int) cArr[b2 & 15]);
                }
            } else {
                out.writeUtf8(alreadyEncoded ? "+" : "%2B");
                String str5 = encodeSet;
            }
            i3 += Character.charCount(codePoint);
        }
        String str6 = encodeSet;
    }

    static String canonicalize(String input, String encodeSet, boolean alreadyEncoded, boolean strict, boolean plusIsSpace, boolean asciiOnly) {
        return canonicalize(input, 0, input.length(), encodeSet, alreadyEncoded, strict, plusIsSpace, asciiOnly, (Charset) null);
    }
}
