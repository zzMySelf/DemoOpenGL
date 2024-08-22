package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public abstract class Uri implements Comparable<Uri> {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final char[] HEX_DIGITS = BinTools.hex.toCharArray();
    /* access modifiers changed from: private */
    public static final String NOT_CACHED = new String("NOT CACHED");
    private static final int NOT_CALCULATED = -2;
    private static final int NOT_FOUND = -1;

    private static abstract class AbstractHierarchicalUri extends Uri {
        private AbstractHierarchicalUri() {
            super();
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Uri.super.compareTo((Uri) obj);
        }

        /* access modifiers changed from: protected */
        public String parseAuthority() {
            String str;
            String str2;
            String encodedAuthority = getEncodedAuthority();
            if (encodedAuthority == null) {
                return null;
            }
            int lastIndexOf = encodedAuthority.lastIndexOf(64);
            int indexOf = encodedAuthority.indexOf(58, lastIndexOf);
            if (indexOf == -1) {
                str = encodedAuthority.substring(lastIndexOf + 1);
            } else {
                str = encodedAuthority.substring(lastIndexOf + 1, indexOf);
            }
            if (lastIndexOf != -1) {
                str2 = encodedAuthority.substring(0, lastIndexOf) + "@";
            } else {
                str2 = "";
            }
            String str3 = str2 + a.d(str);
            return indexOf != -1 ? str3 + encodedAuthority.substring(indexOf + 1) : str3;
        }
    }

    static abstract class AbstractPart {
        volatile String decoded;
        volatile String encoded;

        AbstractPart(String str, String str2) {
            this.encoded = str;
            this.decoded = str2;
        }
    }

    static class AuthorityPart extends AbstractPart {
        static final AuthorityPart EMPTY = new AuthorityPart("", "");
        static final AuthorityPart NULL = new AuthorityPart((String) null, (String) null);

        private AuthorityPart(String str, String str2) {
            super(str, str2);
        }

        static AuthorityPart from(String str, String str2) {
            if (str == null) {
                return NULL;
            }
            if (str.length() == 0) {
                return EMPTY;
            }
            return new AuthorityPart(str, str2);
        }

        static AuthorityPart fromEncoded(String str) {
            return from(str, Uri.NOT_CACHED);
        }

        /* access modifiers changed from: package-private */
        public String getEncoded() {
            if (this.encoded != Uri.NOT_CACHED) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded);
            this.encoded = encode;
            return encode;
        }
    }

    public static final class Builder {
        private Part fragment;
        private Part opaquePart;
        private PathPart path;
        private Part query;
        private String scheme;

        private boolean hasSchemeOrAuthority() {
            return this.scheme != null;
        }

        public Builder appendQueryParameter(String str, String str2) {
            this.opaquePart = null;
            String str3 = Uri.encode(str, (String) null) + "=" + Uri.encode(str2, (String) null);
            Part part = this.query;
            if (part == null) {
                this.query = Part.fromEncoded(str3);
                return this;
            }
            String encoded = part.getEncoded();
            if (encoded == null || encoded.length() == 0) {
                this.query = Part.fromEncoded(str3);
            } else {
                this.query = Part.fromEncoded(encoded + "&" + str3);
            }
            return this;
        }

        public Uri build() {
            PathPart pathPart;
            if (this.opaquePart == null) {
                PathPart pathPart2 = this.path;
                if (pathPart2 == null || pathPart2 == PathPart.NULL) {
                    pathPart = PathPart.EMPTY;
                } else if (hasSchemeOrAuthority()) {
                    pathPart = PathPart.makeAbsolute(pathPart2);
                } else {
                    pathPart = pathPart2;
                }
                return new HierarchicalUri(this.scheme, pathPart, this.query, this.fragment);
            } else if (this.scheme != null) {
                return new OpaqueUri(this.scheme, this.opaquePart, this.fragment);
            } else {
                throw new UnsupportedOperationException("An opaque URI must have a scheme.");
            }
        }

        /* access modifiers changed from: package-private */
        public Builder fragment(Part part) {
            this.fragment = part;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder path(PathPart pathPart) {
            this.opaquePart = null;
            this.path = pathPart;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder query(Part part) {
            this.opaquePart = null;
            this.query = part;
            return this;
        }

        public Builder scheme(String str) {
            this.scheme = str;
            return this;
        }

        public String toString() {
            return build().toString();
        }

        public Builder fragment(String str) {
            return fragment(Part.fromDecoded(str));
        }

        public Builder path(String str) {
            return path(PathPart.fromDecoded(str));
        }

        public Builder query(String str) {
            return query(Part.fromDecoded(str));
        }
    }

    private static class HierarchicalUri extends AbstractHierarchicalUri {
        private final AuthorityPart authority;
        private final Part fragment;
        private final PathPart path;
        private final Part query;
        private final String scheme;
        private volatile String uriString;

        private void appendSspTo(StringBuilder sb) {
            String parseAuthority = parseAuthority();
            if (parseAuthority != null) {
                sb.append("//").append(parseAuthority);
            }
            String encoded = this.path.getEncoded();
            if (encoded != null) {
                sb.append(encoded);
            }
            if (!this.query.isEmpty()) {
                sb.append('?').append(this.query.getEncoded());
            }
        }

        private String makeUriString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str).append(AbstractJsonLexerKt.COLON);
            }
            appendSspTo(sb);
            if (!this.fragment.isEmpty()) {
                sb.append('#').append(this.fragment.getEncoded());
            }
            return sb.toString();
        }

        public String getEncodedAuthority() {
            return this.authority.getEncoded();
        }

        public String getScheme() {
            return this.scheme;
        }

        public boolean isHierarchical() {
            return true;
        }

        public boolean isRelative() {
            return this.scheme == null;
        }

        public String toString() {
            if (this.uriString != Uri.NOT_CACHED) {
                return this.uriString;
            }
            String makeUriString = makeUriString();
            this.uriString = makeUriString;
            return makeUriString;
        }

        private HierarchicalUri(String str, PathPart pathPart, Part part, Part part2) {
            super();
            this.uriString = Uri.NOT_CACHED;
            this.scheme = str;
            this.authority = AuthorityPart.NULL;
            this.path = pathPart == null ? PathPart.NULL : pathPart;
            this.query = Part.nonNull(part);
            this.fragment = Part.nonNull(part2);
        }
    }

    private static class OpaqueUri extends Uri {
        private volatile String cachedString;
        private final Part fragment;
        private final String scheme;
        private final Part ssp;

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Uri.super.compareTo((Uri) obj);
        }

        public String getEncodedAuthority() {
            return null;
        }

        public String getEncodedSchemeSpecificPart() {
            return this.ssp.getEncoded();
        }

        public String getHost() {
            return null;
        }

        public String getPath() {
            return null;
        }

        public String getQuery() {
            return null;
        }

        public String getScheme() {
            return this.scheme;
        }

        public boolean isHierarchical() {
            return false;
        }

        public boolean isRelative() {
            return this.scheme == null;
        }

        public String toString() {
            if (this.cachedString != Uri.NOT_CACHED) {
                return this.cachedString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme).append(AbstractJsonLexerKt.COLON);
            sb.append(getEncodedSchemeSpecificPart());
            if (!this.fragment.isEmpty()) {
                sb.append('#').append(this.fragment.getEncoded());
            }
            String sb2 = sb.toString();
            this.cachedString = sb2;
            return sb2;
        }

        private OpaqueUri(String str, Part part, Part part2) {
            super();
            this.cachedString = Uri.NOT_CACHED;
            this.scheme = str;
            this.ssp = part;
            this.fragment = part2 == null ? Part.NULL : part2;
        }
    }

    static class Part extends AbstractPart {
        static final Part EMPTY = new EmptyPart("");
        static final Part NULL = new EmptyPart((String) null);

        private static class EmptyPart extends Part {
            public EmptyPart(String str) {
                super(str, str);
            }

            /* access modifiers changed from: package-private */
            public boolean isEmpty() {
                return true;
            }
        }

        static Part from(String str, String str2) {
            if (str == null) {
                return NULL;
            }
            if (str.length() == 0) {
                return EMPTY;
            }
            if (str2 == null) {
                return NULL;
            }
            if (str2.length() == 0) {
                return EMPTY;
            }
            return new Part(str, str2);
        }

        static Part fromDecoded(String str) {
            return from(Uri.NOT_CACHED, str);
        }

        static Part fromEncoded(String str) {
            return from(str, Uri.NOT_CACHED);
        }

        static Part nonNull(Part part) {
            return part == null ? NULL : part;
        }

        /* access modifiers changed from: package-private */
        public String getEncoded() {
            if (this.encoded != Uri.NOT_CACHED) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded);
            this.encoded = encode;
            return encode;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return false;
        }

        private Part(String str, String str2) {
            super(str, str2);
        }
    }

    static class PathPart extends AbstractPart {
        static final PathPart EMPTY = new PathPart("", "");
        static final PathPart NULL = new PathPart((String) null, (String) null);

        private PathPart(String str, String str2) {
            super(str, str2);
        }

        static PathPart from(String str, String str2) {
            if (str == null) {
                return NULL;
            }
            if (str.length() == 0) {
                return EMPTY;
            }
            return new PathPart(str, str2);
        }

        static PathPart fromDecoded(String str) {
            return from(Uri.NOT_CACHED, str);
        }

        static PathPart makeAbsolute(PathPart pathPart) {
            String str;
            boolean z = true;
            boolean z2 = pathPart.encoded != Uri.NOT_CACHED;
            String str2 = z2 ? pathPart.encoded : pathPart.decoded;
            if (str2 == null || str2.length() == 0 || str2.startsWith("/")) {
                return pathPart;
            }
            String access$200 = z2 ? "/" + pathPart.encoded : Uri.NOT_CACHED;
            if (pathPart.decoded == Uri.NOT_CACHED) {
                z = false;
            }
            if (z) {
                str = "/" + pathPart.decoded;
            } else {
                str = Uri.NOT_CACHED;
            }
            return new PathPart(access$200, str);
        }

        /* access modifiers changed from: package-private */
        public String getEncoded() {
            if (this.encoded != Uri.NOT_CACHED) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded, "/");
            this.encoded = encode;
            return encode;
        }
    }

    private static class StringUri extends AbstractHierarchicalUri {
        private AuthorityPart authority;
        private volatile int cachedSsi;
        private volatile String scheme;
        private final String uriString;

        private String encodeAuthority(String str) {
            String str2;
            String str3;
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int lastIndexOf = str.lastIndexOf(64);
            int indexOf = str.indexOf(58, lastIndexOf);
            if (indexOf == -1) {
                str2 = str.substring(lastIndexOf + 1);
            } else {
                str2 = str.substring(lastIndexOf + 1, indexOf);
            }
            if (lastIndexOf != -1) {
                str3 = Uri.encode(str.substring(0, lastIndexOf)) + "@";
            } else {
                str3 = "";
            }
            String str4 = str3 + a.d(str2);
            return indexOf != -1 ? str4 + str.substring(indexOf + 1) : str4;
        }

        private int findSchemeSeparator() {
            if (this.cachedSsi != -2) {
                return this.cachedSsi;
            }
            int indexOf = this.uriString.indexOf(58);
            this.cachedSsi = indexOf;
            return indexOf;
        }

        private AuthorityPart getAuthorityPart() {
            AuthorityPart authorityPart = this.authority;
            if (authorityPart != null) {
                return authorityPart;
            }
            AuthorityPart fromEncoded = AuthorityPart.fromEncoded(encodeAuthority(parseAuthority(this.uriString, findSchemeSeparator())));
            this.authority = fromEncoded;
            return fromEncoded;
        }

        static String parseAuthority(String str, int i2) {
            int length = str.length();
            int i3 = i2 + 2;
            if (length <= i3 || str.charAt(i2 + 1) != '/' || str.charAt(i3) != '/') {
                return null;
            }
            int i4 = i2 + 3;
            int i5 = i4;
            while (i5 < length) {
                char charAt = str.charAt(i5);
                if (charAt == '#' || charAt == '/' || charAt == '?' || charAt == '\\') {
                    break;
                }
                i5++;
            }
            return str.substring(i4, i5);
        }

        private String parseScheme() {
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator == -1) {
                return null;
            }
            return this.uriString.substring(0, findSchemeSeparator);
        }

        public String getEncodedAuthority() {
            return getAuthorityPart().getEncoded();
        }

        public String getScheme() {
            if (this.scheme != Uri.NOT_CACHED) {
                return this.scheme;
            }
            String parseScheme = parseScheme();
            this.scheme = parseScheme;
            return parseScheme;
        }

        public boolean isHierarchical() {
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator == -1) {
                return true;
            }
            int i2 = findSchemeSeparator + 1;
            if (this.uriString.length() == i2) {
                return false;
            }
            if (this.uriString.charAt(i2) == '/') {
                return true;
            }
            return false;
        }

        public boolean isRelative() {
            return findSchemeSeparator() == -1;
        }

        public String toString() {
            return this.uriString;
        }

        private StringUri(String str) {
            super();
            this.cachedSsi = -2;
            this.scheme = Uri.NOT_CACHED;
            if (str != null) {
                this.uriString = str;
                return;
            }
            throw new NullPointerException("uriString");
        }
    }

    public static String encode(String str) {
        return encode(str, (String) null);
    }

    private static boolean isAllowed(char c2, String str) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || !((c2 < '0' || c2 > '9') && "_-.*".indexOf(c2) == -1 && (str == null || str.indexOf(c2) == -1));
    }

    public static Uri parse(String str) {
        return new StringUri(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Uri)) {
            return false;
        }
        return toString().equals(((Uri) obj).toString());
    }

    public abstract String getEncodedAuthority();

    public abstract String getScheme();

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isAbsolute() {
        return !isRelative();
    }

    public abstract boolean isHierarchical();

    public boolean isOpaque() {
        return !isHierarchical();
    }

    public abstract boolean isRelative();

    public abstract String toString();

    private Uri() {
    }

    public static String encode(String str, String str2) {
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2;
            while (i3 < length && isAllowed(str.charAt(i3), str2)) {
                i3++;
            }
            if (i3 != length) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                if (i3 > i2) {
                    sb.append(str, i2, i3);
                }
                i2 = i3 + 1;
                while (i2 < length && !isAllowed(str.charAt(i2), str2)) {
                    i2++;
                }
                try {
                    byte[] bytes = str.substring(i3, i2).getBytes("UTF-8");
                    int length2 = bytes.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        sb.append('%');
                        char[] cArr = HEX_DIGITS;
                        sb.append(cArr[(bytes[i4] & 240) >> 4]);
                        sb.append(cArr[bytes[i4] & 15]);
                    }
                } catch (UnsupportedEncodingException e2) {
                    throw new AssertionError(e2);
                }
            } else if (i2 == 0) {
                return str;
            } else {
                if (sb == null) {
                    return "";
                }
                sb.append(str, i2, length);
                return sb.toString();
            }
        }
        return sb == null ? str : sb.toString();
    }

    public int compareTo(Uri uri) {
        return toString().compareTo(uri.toString());
    }
}
