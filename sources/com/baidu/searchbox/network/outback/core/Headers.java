package com.baidu.searchbox.network.outback.core;

import com.baidu.searchbox.network.outback.core.internal.HttpDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class Headers {
    private static final boolean DEBUG = false;
    private final String[] namesAndValues;

    Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] namesAndValues2) {
        this.namesAndValues = namesAndValues2;
    }

    public String get(String name) {
        return get(this.namesAndValues, name);
    }

    private static String get(String[] namesAndValues2, String name) {
        for (int i2 = namesAndValues2.length - 2; i2 >= 0; i2 -= 2) {
            if (name.equalsIgnoreCase(namesAndValues2[i2])) {
                return namesAndValues2[i2 + 1];
            }
        }
        return null;
    }

    public Date getDate(String name) {
        String value = get(name);
        if (value != null) {
            return HttpDate.parse(value);
        }
        return null;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public String name(int index) {
        return this.namesAndValues[index * 2];
    }

    public String value(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public Set<String> names() {
        TreeSet<String> result = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            result.add(name(i2));
        }
        return Collections.unmodifiableSet(result);
    }

    public List<String> values(String name) {
        List<String> result = null;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (name.equalsIgnoreCase(name(i2))) {
                if (result == null) {
                    result = new ArrayList<>(2);
                }
                result.add(value(i2));
            }
        }
        return result != null ? Collections.unmodifiableList(result) : Collections.emptyList();
    }

    public long byteCount() {
        String[] strArr = this.namesAndValues;
        long result = (long) (strArr.length * 2);
        int size = strArr.length;
        for (int i2 = 0; i2 < size; i2++) {
            result += (long) this.namesAndValues[i2].length();
        }
        return result;
    }

    public Builder newBuilder() {
        Builder result = new Builder();
        Collections.addAll(result.namesAndValues, this.namesAndValues);
        return result;
    }

    public boolean equals(Object other) {
        return (other instanceof Headers) && Arrays.equals(((Headers) other).namesAndValues, this.namesAndValues);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            result.append(name(i2)).append(": ").append(value(i2)).append("\n");
        }
        return result.toString();
    }

    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = name(i2).toLowerCase(Locale.US);
            List<String> values = result.get(name);
            if (values == null) {
                values = new ArrayList<>(2);
                result.put(name, values);
            }
            values.add(value(i2));
        }
        return result;
    }

    public static Headers of(String... namesAndValues2) {
        return of(true, namesAndValues2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.searchbox.network.outback.core.Headers of(boolean r5, java.lang.String... r6) {
        /*
            if (r5 == 0) goto L_0x0057
            if (r6 == 0) goto L_0x004e
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0046
            java.lang.Object r0 = r6.clone()
            r6 = r0
            java.lang.String[] r6 = (java.lang.String[]) r6
            r0 = 0
        L_0x0011:
            int r1 = r6.length
            if (r0 >= r1) goto L_0x002b
            r1 = r6[r0]
            if (r1 == 0) goto L_0x0023
            r1 = r6[r0]
            java.lang.String r1 = r1.trim()
            r6[r0] = r1
            int r0 = r0 + 1
            goto L_0x0011
        L_0x0023:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Headers cannot be null"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            r0 = 0
        L_0x002c:
            int r1 = r6.length
            if (r0 >= r1) goto L_0x0057
            r1 = r6[r0]
            int r2 = r0 + 1
            r2 = r6[r2]
            java.lang.String r3 = checkName(r1)
            r6[r0] = r3
            int r3 = r0 + 1
            java.lang.String r4 = checkValue(r2, r1)
            r6[r3] = r4
            int r0 = r0 + 2
            goto L_0x002c
        L_0x0046:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Expected alternating header names and values"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "namesAndValues == null"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            com.baidu.searchbox.network.outback.core.Headers r0 = new com.baidu.searchbox.network.outback.core.Headers
            r0.<init>((java.lang.String[]) r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.network.outback.core.Headers.of(boolean, java.lang.String[]):com.baidu.searchbox.network.outback.core.Headers");
    }

    public static Headers of(Map<String, String> headers) {
        if (headers != null) {
            String[] namesAndValues2 = new String[(headers.size() * 2)];
            int i2 = 0;
            for (Map.Entry<String, String> header : headers.entrySet()) {
                if (header.getKey() == null || header.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String name = header.getKey().trim();
                String value = header.getValue().trim();
                String legalName = checkName(name);
                String legalValue = checkValue(value, name);
                namesAndValues2[i2] = legalName;
                namesAndValues2[i2 + 1] = legalValue;
                i2 += 2;
            }
            return new Headers(namesAndValues2);
        }
        throw new NullPointerException("headers == null");
    }

    static String checkName(String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        } else if (!name.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int length = name.length();
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = name.charAt(i2);
                if (c2 <= ' ' || c2 >= 127) {
                    sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c2)}));
                } else {
                    sb.append(c2);
                }
            }
            return sb.toString();
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static String checkValue(String value, String name) {
        if (value != null) {
            StringBuilder sb = new StringBuilder();
            int length = value.length();
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = value.charAt(i2);
                if ((c2 > 31 || c2 == 9) && c2 < 127) {
                    sb.append(c2);
                } else {
                    sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c2)}));
                }
            }
            return sb.toString();
        }
        throw new NullPointerException("value for name " + name + " == null");
    }

    public static final class Builder {
        public final List<String> namesAndValues = new ArrayList(20);

        /* access modifiers changed from: package-private */
        public Builder addLenient(String line) {
            int index = line.indexOf(":", 1);
            if (index != -1) {
                return addLenient(line.substring(0, index), line.substring(index + 1));
            }
            if (line.startsWith(":")) {
                return addLenient("", line.substring(1));
            }
            return addLenient("", line);
        }

        /* access modifiers changed from: package-private */
        public Builder addLenient(String name, String value) {
            this.namesAndValues.add(name);
            this.namesAndValues.add(value.trim());
            return this;
        }

        public Builder add(String line) {
            int index = line.indexOf(":");
            if (index != -1) {
                return add(line.substring(0, index).trim(), line.substring(index + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + line);
        }

        public Builder add(String name, String value) {
            return addLenient(Headers.checkName(name), Headers.checkValue(value, name));
        }

        public Builder addUnsafeNonAscii(String name, String value) {
            Headers.checkName(name);
            return addLenient(name, value);
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                addLenient(headers.name(i2), headers.value(i2));
            }
            return this;
        }

        public Builder removeAll(String name) {
            int i2 = 0;
            while (i2 < this.namesAndValues.size()) {
                if (name.equalsIgnoreCase(this.namesAndValues.get(i2))) {
                    this.namesAndValues.remove(i2);
                    this.namesAndValues.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public Builder set(String name, String value) {
            String legalName = Headers.checkName(name);
            String legalValue = Headers.checkValue(value, name);
            removeAll(name);
            addLenient(legalName, legalValue);
            return this;
        }

        public String get(String name) {
            for (int i2 = this.namesAndValues.size() - 2; i2 >= 0; i2 -= 2) {
                if (name.equalsIgnoreCase(this.namesAndValues.get(i2))) {
                    return this.namesAndValues.get(i2 + 1);
                }
            }
            return null;
        }

        public Headers build() {
            return new Headers(this);
        }
    }
}
