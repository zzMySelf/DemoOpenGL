package fe.th.de;

import com.google.common.net.MediaType;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class when {

    /* renamed from: fe  reason: collision with root package name */
    public static final Pattern f5558fe = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: rg  reason: collision with root package name */
    public static final Pattern f5559rg = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: ad  reason: collision with root package name */
    public final String f5560ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f5561de;
    public final String qw;

    public when(String str, String str2, String str3, String str4) {
        this.qw = str;
        this.f5560ad = str2;
        this.f5561de = str4;
    }

    public static when de(String str) {
        Matcher matcher = f5558fe.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f5559rg.matcher(str);
            int end = matcher.end();
            while (end < str.length()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase(MediaType.CHARSET_ATTRIBUTE)) {
                        String group2 = matcher2.group(2);
                        if (group2 == null) {
                            group2 = matcher2.group(3);
                        } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                            group2 = group2.substring(1, group2.length() - 1);
                        }
                        if (str2 == null || group2.equalsIgnoreCase(str2)) {
                            str2 = group2;
                        } else {
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                        }
                    }
                    end = matcher2.end();
                } else {
                    throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
                }
            }
            return new when(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
    }

    public static when fe(String str) {
        try {
            return de(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public Charset ad(Charset charset) {
        try {
            return this.f5561de != null ? Charset.forName(this.f5561de) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof when) && ((when) obj).qw.equals(this.qw);
    }

    public int hashCode() {
        return this.qw.hashCode();
    }

    public Charset qw() {
        return ad((Charset) null);
    }

    public String rg() {
        return this.f5560ad;
    }

    public String toString() {
        return this.qw;
    }
}
