package com.baidu.searchbox.http.okurlconnection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Headers;

public final class JavaNetHeaders {
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {
        public int compare(String a2, String b2) {
            if (a2 == b2) {
                return 0;
            }
            if (a2 == null) {
                return -1;
            }
            if (b2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(a2, b2);
        }
    };

    private JavaNetHeaders() {
    }

    public static Map<String, List<String>> toMultimap(Headers headers, String valueForNullKey) {
        Map<String, List<String>> result = new TreeMap<>(FIELD_NAME_COMPARATOR);
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String fieldName = headers.name(i2);
            String value = headers.value(i2);
            List<String> allValues = new ArrayList<>();
            List<String> otherValues = result.get(fieldName);
            if (otherValues != null) {
                allValues.addAll(otherValues);
            }
            allValues.add(value);
            result.put(fieldName, Collections.unmodifiableList(allValues));
        }
        if (valueForNullKey != null) {
            result.put((Object) null, Collections.unmodifiableList(Collections.singletonList(valueForNullKey)));
        }
        return Collections.unmodifiableMap(result);
    }
}
