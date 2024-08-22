package com.baidu.talos.core.data;

import android.os.Bundle;
import com.baidu.talos.TalosAdapterManager;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class Arguments {
    private static final boolean DEBUG = TalosAdapterManager.getHostConfig().isDebug();

    public static ParamArray createArray() {
        return new ParamArrayImpl();
    }

    public static ParamMap createMap() {
        return new ParamMapImpl();
    }

    public static ParamMap makeParamMap(Map<String, Object> objects) {
        ParamMap paramMap = new ParamMapImpl();
        if (objects == null) {
            return paramMap;
        }
        for (Map.Entry<String, Object> entry : objects.entrySet()) {
            addEntry(paramMap, entry.getKey(), entry.getValue());
        }
        return paramMap;
    }

    public static ParamMap makeParamMap(Bundle bundle) {
        ParamMap paramMap = new ParamMapImpl();
        if (bundle == null) {
            return paramMap;
        }
        for (String key : bundle.keySet()) {
            addEntry(paramMap, key, bundle.get(key));
        }
        return paramMap;
    }

    private static void addEntry(ParamMap paramMap, String key, Object value) {
        Object value2 = makeParamObject(value);
        if (value2 == null) {
            paramMap.putNull(key);
        } else if (value2 instanceof Boolean) {
            paramMap.putBoolean(key, ((Boolean) value2).booleanValue());
        } else if (value2 instanceof Integer) {
            paramMap.putInteger(key, (Integer) value2);
        } else if (value2 instanceof Long) {
            paramMap.putLong(key, (Long) value2);
        } else if (value2 instanceof Double) {
            paramMap.putDouble(key, (Double) value2);
        } else if (value2 instanceof String) {
            paramMap.putString(key, (String) value2);
        } else if (value2 instanceof ParamArray) {
            paramMap.putArray(key, (ParamArray) value2);
        } else if (value2 instanceof ParamMap) {
            paramMap.putMap(key, (ParamMap) value2);
        } else if (!DEBUG) {
            paramMap.putNull(key);
        } else {
            throw new IllegalArgumentException("Could not convert " + value2.getClass());
        }
    }

    private static Object makeParamObject(Object object) {
        if (object == null) {
            return null;
        }
        if ((object instanceof Float) || (object instanceof Byte) || (object instanceof Short)) {
            return Double.valueOf(((Number) object).doubleValue());
        }
        if (object.getClass().isArray()) {
            return makeParamArray(object);
        }
        if (object instanceof List) {
            return makeParamArray((List) object);
        }
        if (object instanceof Map) {
            return makeParamMap((Map<String, Object>) (Map) object);
        }
        if (object instanceof Bundle) {
            return makeParamMap((Bundle) object);
        }
        return object;
    }

    public static ParamArray makeParamArray(List objects) {
        ParamArray paramArray = new ParamArrayImpl();
        if (objects == null) {
            return paramArray;
        }
        for (Object elem : objects) {
            Object elem2 = makeParamObject(elem);
            if (elem2 == null) {
                paramArray.pushNull();
            } else if (elem2 instanceof Boolean) {
                paramArray.pushBoolean(((Boolean) elem2).booleanValue());
            } else if (elem2 instanceof Integer) {
                paramArray.pushInteger(((Integer) elem2).intValue());
            } else if (elem2 instanceof Long) {
                paramArray.pushLong(((Long) elem2).longValue());
            } else if (elem2 instanceof Double) {
                paramArray.pushDouble(((Double) elem2).doubleValue());
            } else if (elem2 instanceof String) {
                paramArray.pushString((String) elem2);
            } else if (elem2 instanceof ParamArray) {
                paramArray.pushArray((ParamArray) elem2);
            } else if (elem2 instanceof ParamMap) {
                paramArray.pushMap((ParamMap) elem2);
            } else if (DEBUG) {
                throw new IllegalArgumentException("Could not convert " + elem2.getClass());
            }
        }
        return paramArray;
    }

    private static <T> ParamArray makeParamArray(final Object objects) {
        if (objects == null) {
            return new ParamArrayImpl();
        }
        return makeParamArray((List) new AbstractList() {
            public int size() {
                return Array.getLength(objects);
            }

            public Object get(int index) {
                return Array.get(objects, index);
            }
        });
    }

    public static List<Object> toListRecursion(ParamArray paramArray) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (paramArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < paramArray.size(); i2++) {
            switch (AnonymousClass2.$SwitchMap$com$baidu$talos$core$data$ParamType[paramArray.getType(i2).ordinal()]) {
                case 1:
                    arrayList.add((Object) null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(paramArray.getBoolean(i2)));
                    break;
                case 3:
                    arrayList.add(paramArray.getObject(i2));
                    break;
                case 4:
                    arrayList.add(paramArray.getString(i2));
                    break;
                case 5:
                    arrayList.add(toMapRecursion(paramArray.getMap(i2)));
                    break;
                case 6:
                    arrayList.add(toListRecursion(paramArray.getArray(i2)));
                    break;
                default:
                    if (!TalosAdapterManager.getHostConfig().isDebug()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Could not convert object at index: " + i2 + ".");
                    }
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.talos.core.data.Arguments$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$talos$core$data$ParamType;

        static {
            int[] iArr = new int[ParamType.values().length];
            $SwitchMap$com$baidu$talos$core$data$ParamType = iArr;
            try {
                iArr[ParamType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$data$ParamType[ParamType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$data$ParamType[ParamType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$data$ParamType[ParamType.String.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$data$ParamType[ParamType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$talos$core$data$ParamType[ParamType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static Map<String, Object> toMapRecursion(ParamMap paramMap) {
        Map<String, Object> hashMap = new HashMap<>();
        if (paramMap == null) {
            return hashMap;
        }
        ParamMapKeySetIterator iterator = paramMap.keySetIterator();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            switch (AnonymousClass2.$SwitchMap$com$baidu$talos$core$data$ParamType[paramMap.getType(key).ordinal()]) {
                case 1:
                    hashMap.put(key, (Object) null);
                    break;
                case 2:
                    hashMap.put(key, Boolean.valueOf(paramMap.getBoolean(key)));
                    break;
                case 3:
                    hashMap.put(key, paramMap.getObject(key));
                    break;
                case 4:
                    hashMap.put(key, paramMap.getString(key));
                    break;
                case 5:
                    hashMap.put(key, toMapRecursion(paramMap.getMap(key)));
                    break;
                case 6:
                    hashMap.put(key, toListRecursion(paramMap.getArray(key)));
                    break;
                default:
                    if (!TalosAdapterManager.getHostConfig().isDebug()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Could not convert object with key: " + key + ".");
                    }
            }
        }
        return hashMap;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString();
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj).toString();
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj).toString();
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short)) {
                if (!(obj instanceof String)) {
                    if (obj instanceof ParamArray) {
                        return new JSONArray(toListRecursion((ParamArray) obj)).toString();
                    }
                    if (obj instanceof ParamMap) {
                        return new JSONObject(toMapRecursion((ParamMap) obj)).toString();
                    }
                    return null;
                }
            }
            return String.valueOf(obj);
        } catch (Exception e2) {
        }
    }

    public static JSONObject paramMapToJSON(ParamMap paramMap) {
        if (paramMap == null) {
            return null;
        }
        try {
            return new JSONObject(toMapRecursion(paramMap));
        } catch (Throwable th2) {
            return null;
        }
    }
}
