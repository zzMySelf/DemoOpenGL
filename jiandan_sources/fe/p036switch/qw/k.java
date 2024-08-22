package fe.p036switch.qw;

import android.os.Bundle;
import java.io.Serializable;
import java.util.Map;

/* renamed from: fe.switch.qw.k  reason: invalid package */
public class k {
    public static Bundle qw(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Short) {
                bundle.putShort(next, ((Short) obj).shortValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(next, ((Byte) obj).byteValue());
            } else if (obj instanceof Long) {
                bundle.putLong(next, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(next, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(next, (Serializable) obj);
            }
        }
        return bundle;
    }
}
