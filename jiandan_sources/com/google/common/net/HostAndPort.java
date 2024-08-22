package com.google.common.net;

import com.google.android.material.badge.BadgeDrawable;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
@Immutable
@Beta
public final class HostAndPort implements Serializable {
    public static final int NO_PORT = -1;
    public static final long serialVersionUID = 0;
    public final boolean hasBracketlessColons;
    public final String host;
    public final int port;

    public HostAndPort(String str, int i2, boolean z) {
        this.host = str;
        this.port = i2;
        this.hasBracketlessColons = z;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", (Object) str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i2) {
        Preconditions.checkArgument(isValidPort(i2), "Port out of range: %s", i2);
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", (Object) str);
        return new HostAndPort(fromString.host, i2, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        Preconditions.checkNotNull(str);
        int i2 = -1;
        boolean z = false;
        if (str.startsWith("[")) {
            String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
            str2 = hostAndPortFromBracketedHost[0];
            str3 = hostAndPortFromBracketedHost[1];
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                int i3 = indexOf + 1;
                if (str.indexOf(58, i3) == -1) {
                    str2 = str.substring(0, indexOf);
                    str3 = str.substring(i3);
                }
            }
            if (indexOf >= 0) {
                z = true;
            }
            str3 = null;
            str2 = str;
        }
        if (!Strings.isNullOrEmpty(str3)) {
            Preconditions.checkArgument(!str3.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX), "Unparseable port number: %s", (Object) str);
            try {
                i2 = Integer.parseInt(str3);
                Preconditions.checkArgument(isValidPort(i2), "Port number out of range: %s", (Object) str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new HostAndPort(str2, i2, z);
    }

    public static String[] getHostAndPortFromBracketedHost(String str) {
        Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", (Object) str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        Preconditions.checkArgument(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", (Object) str);
        String substring = str.substring(1, lastIndexOf);
        int i2 = lastIndexOf + 1;
        if (i2 == str.length()) {
            return new String[]{substring, ""};
        }
        Preconditions.checkArgument(str.charAt(i2) == ':', "Only a colon may follow a close bracket: %s", (Object) str);
        int i3 = lastIndexOf + 2;
        for (int i4 = i3; i4 < str.length(); i4++) {
            Preconditions.checkArgument(Character.isDigit(str.charAt(i4)), "Port must be numeric: %s", (Object) str);
        }
        return new String[]{substring, str.substring(i3)};
    }

    public static boolean isValidPort(int i2) {
        return i2 >= 0 && i2 <= 65535;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        if (!Objects.equal(this.host, hostAndPort.host) || this.port != hostAndPort.port) {
            return false;
        }
        return true;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i2) {
        return hasPort() ? this.port : i2;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", (Object) this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.host);
            sb.append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(':');
            sb.append(this.port);
        }
        return sb.toString();
    }

    public HostAndPort withDefaultPort(int i2) {
        Preconditions.checkArgument(isValidPort(i2));
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(this.host, i2, this.hasBracketlessColons);
    }
}
