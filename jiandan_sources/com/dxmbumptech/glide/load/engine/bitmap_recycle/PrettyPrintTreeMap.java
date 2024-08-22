package com.dxmbumptech.glide.load.engine.bitmap_recycle;

import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry entry : entrySet()) {
            sb.append(ExtendedMessageFormat.START_FE);
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
