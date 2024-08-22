package okhttp3;

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
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Headers {
    private final String[] namesAndValues;

    Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] namesAndValues2) {
        this.namesAndValues = namesAndValues2;
    }

    @Nullable
    public String get(String name) {
        return get(this.namesAndValues, name);
    }

    @Nullable
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
        if (result != null) {
            return Collections.unmodifiableList(result);
        }
        return Collections.emptyList();
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

    public boolean equals(@Nullable Object other) {
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

    private static String get(String[] namesAndValues2, String name) {
        for (int i2 = namesAndValues2.length - 2; i2 >= 0; i2 -= 2) {
            if (name.equalsIgnoreCase(namesAndValues2[i2])) {
                return namesAndValues2[i2 + 1];
            }
        }
        return null;
    }

    public static Headers of(String... namesAndValues2) {
        if (namesAndValues2 == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (namesAndValues2.length % 2 == 0) {
            String[] namesAndValues3 = (String[]) namesAndValues2.clone();
            int i2 = 0;
            while (i2 < namesAndValues3.length) {
                if (namesAndValues3[i2] != null) {
                    namesAndValues3[i2] = namesAndValues3[i2].trim();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i3 = 0; i3 < namesAndValues3.length; i3 += 2) {
                String name = namesAndValues3[i3];
                String value = namesAndValues3[i3 + 1];
                checkName(name);
                checkValue(value, name);
            }
            return new Headers(namesAndValues3);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
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
                checkName(name);
                checkValue(value, name);
                namesAndValues2[i2] = name;
                namesAndValues2[i2 + 1] = value;
                i2 += 2;
            }
            return new Headers(namesAndValues2);
        }
        throw new NullPointerException("headers == null");
    }

    static void checkName(String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        } else if (!name.isEmpty()) {
            int length = name.length();
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = name.charAt(i2);
                if (c2 <= ' ' || c2 >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(c2), Integer.valueOf(i2), name));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static void checkValue(String value, String name) {
        if (value != null) {
            int i2 = 0;
            int length = value.length();
            while (i2 < length) {
                char c2 = value.charAt(i2);
                if ((c2 > 31 || c2 == 9) && c2 < 127) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(c2), Integer.valueOf(i2), name, value));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + name + " == null");
    }

    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

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

        public Builder add(String line) {
            int index = line.indexOf(":");
            if (index != -1) {
                return add(line.substring(0, index).trim(), line.substring(index + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + line);
        }

        public Builder add(String name, String value) {
            Headers.checkName(name);
            Headers.checkValue(value, name);
            return addLenient(name, value);
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

        public Builder add(String name, Date value) {
            if (value != null) {
                add(name, HttpDate.format(value));
                return this;
            }
            throw new NullPointerException("value for name " + name + " == null");
        }

        public Builder set(String name, Date value) {
            if (value != null) {
                set(name, HttpDate.format(value));
                return this;
            }
            throw new NullPointerException("value for name " + name + " == null");
        }

        /* access modifiers changed from: package-private */
        public Builder addLenient(String name, String value) {
            this.namesAndValues.add(name);
            this.namesAndValues.add(value.trim());
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
            Headers.checkName(name);
            Headers.checkValue(value, name);
            removeAll(name);
            addLenient(name, value);
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
