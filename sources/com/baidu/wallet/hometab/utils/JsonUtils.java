package com.baidu.wallet.hometab.utils;

import dalvik.system.PathClassLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class JsonUtils {
    private static final boolean DEBUG = false;

    private JsonUtils() {
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return Encoder.serialize(new JSONStringer(), obj).toString();
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) throws JSONException {
        if (clazz == null || jsonStr == null || jsonStr.length() == 0) {
            return null;
        }
        if (DataType.isArray(clazz) || DataType.isCollection(clazz)) {
            return Decoder.deserialize(new JSONArray(jsonStr), clazz);
        }
        return Decoder.deserialize(new JSONObject(jsonStr), clazz);
    }

    private static class Encoder {
        private Encoder() {
        }

        public static JSONStringer serialize(JSONStringer js, Object obj) {
            if (DataType.isNull(obj)) {
                serializeNull(js);
            } else {
                Class<?> clazz = obj.getClass();
                if (DataType.isRaw(clazz)) {
                    serializeRaw(js, obj);
                } else if (DataType.isArray(clazz)) {
                    serializeArray(js, obj);
                } else if (DataType.isCollection(clazz)) {
                    serializeCollection(js, (Collection) obj);
                } else if (DataType.isMap(clazz)) {
                    serializeMap(js, (Map) obj);
                } else {
                    serializeObject(js, obj);
                }
            }
            return js;
        }

        private static void serializeNull(JSONStringer js) {
            try {
                js.value((Object) null);
            } catch (JSONException e2) {
            }
        }

        private static void serializeRaw(JSONStringer js, Object obj) {
            try {
                js.value(obj);
            } catch (JSONException e2) {
            }
        }

        private static JSONStringer serializeArray(JSONStringer js, Object array) {
            try {
                js.array();
                for (int i2 = 0; i2 < Array.getLength(array); i2++) {
                    serialize(js, Array.get(array, i2));
                }
                js.endArray();
            } catch (Exception e2) {
            }
            return js;
        }

        private static void serializeCollection(JSONStringer js, Collection<?> collection) {
            try {
                js.array();
                for (Object o : collection) {
                    serialize(js, o);
                }
                js.endArray();
            } catch (Exception e2) {
            }
        }

        private static void serializeMap(JSONStringer js, Map<?, ?> map) {
            try {
                js.object();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    js.key(entry.getKey());
                    serialize(js, entry.getValue());
                }
                js.endObject();
            } catch (Exception e2) {
            }
        }

        private static void serializeObject(JSONStringer js, Object obj) {
            try {
                js.object();
                serializeObject(js, obj.getClass(), obj);
                js.endObject();
            } catch (Exception e2) {
            }
        }

        private static void serializeObject(JSONStringer js, Class<?> clazz, Object obj) {
            if (clazz != null) {
                serializeObject(js, clazz.getSuperclass(), obj);
                for (Field field : clazz.getDeclaredFields()) {
                    if (!ClassLoader.class.isAssignableFrom(field.getType()) && !PathClassLoader.class.isAssignableFrom(field.getType()) && !Class.class.isAssignableFrom(field.getType())) {
                        try {
                            field.setAccessible(true);
                            Object fieldVal = field.get(obj);
                            if (Date.class.isAssignableFrom(field.getType())) {
                                fieldVal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format((Date) fieldVal);
                            }
                            js.key(field.getName());
                            serialize(js, fieldVal);
                        } catch (Exception e2) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class Decoder {
        private Decoder() {
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class, java.lang.Class<T>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <T> T deserialize(org.json.JSONArray r2, java.lang.Class<T> r3) throws org.json.JSONException {
            /*
                if (r3 == 0) goto L_0x0027
                boolean r0 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isNull(r2)
                if (r0 == 0) goto L_0x0009
                goto L_0x0027
            L_0x0009:
                r0 = 0
                boolean r1 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isArray(r3)
                if (r1 == 0) goto L_0x0019
                java.lang.Class r1 = r3.getComponentType()
                java.lang.Object[] r0 = deserializeArray(r2, r1)
                goto L_0x0024
            L_0x0019:
                boolean r1 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isCollection(r3)
                if (r1 == 0) goto L_0x0024
                java.lang.Object r0 = deserializeCollection(r2, r3)
                goto L_0x0025
            L_0x0024:
            L_0x0025:
                r1 = r0
                return r1
            L_0x0027:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.hometab.utils.JsonUtils.Decoder.deserialize(org.json.JSONArray, java.lang.Class):java.lang.Object");
        }

        public static <T> T deserialize(JSONObject jo, Class<T> clazz) throws JSONException {
            if (clazz == null || DataType.isNull(jo)) {
                return null;
            }
            T obj = newInstance(clazz);
            if (obj != null) {
                if (DataType.isMap(clazz)) {
                    deserializeMap(obj, jo);
                } else {
                    deserializeObject(jo, clazz, obj);
                }
            }
            return obj;
        }

        private static void deserializeObject(JSONObject jo, Class<?> clazz, Object obj) {
            if (clazz != null) {
                deserializeObject(jo, clazz.getSuperclass(), obj);
                for (Field field : clazz.getDeclaredFields()) {
                    deserializeField(jo, obj, field);
                }
            }
        }

        private static void deserializeField(JSONObject jo, Object obj, Field field) {
            Class<?> clazz = field.getType();
            String name = field.getName();
            Object o = null;
            try {
                if (!DataType.isRaw(clazz)) {
                    if (!DataType.isArray(clazz)) {
                        if (!DataType.isCollection(clazz)) {
                            if (DataType.isJSONObject(clazz)) {
                                o = jo.opt(name);
                            } else if (DataType.isObject(clazz)) {
                                o = deserialize(jo.optJSONObject(name), clazz);
                            } else if (DataType.isMap(clazz)) {
                                o = deserializeMap(new HashMap<>(), jo.optJSONObject(name));
                            } else {
                                throw new Exception("unknow type!");
                            }
                        }
                    }
                    o = deserialize(jo.optJSONArray(name), clazz);
                } else if (Integer.TYPE.isAssignableFrom(clazz)) {
                    try {
                        o = Integer.valueOf(jo.getInt(name));
                    } catch (JSONException e2) {
                    }
                } else if (Long.TYPE.isAssignableFrom(clazz)) {
                    try {
                        o = Long.valueOf(jo.getLong(name));
                    } catch (JSONException e3) {
                    }
                } else {
                    if (!Float.TYPE.isAssignableFrom(clazz)) {
                        if (!Double.TYPE.isAssignableFrom(clazz)) {
                            if (DataType.isBoolean(clazz)) {
                                try {
                                    o = Boolean.valueOf(jo.getBoolean(name));
                                } catch (JSONException e4) {
                                }
                            } else {
                                o = jo.opt(name);
                            }
                        }
                    }
                    try {
                        o = Double.valueOf(jo.getDouble(name));
                    } catch (JSONException e5) {
                    }
                }
                setFiedlValue(obj, field, o);
            } catch (Exception e6) {
            }
        }

        private static void setFiedlValue(Object obj, Field field, Object value) {
            if (obj != null && field != null && value != null && !"".equals(value)) {
                try {
                    Class<?> type = field.getType();
                    field.setAccessible(true);
                    if (Date.class.isAssignableFrom(type)) {
                        field.set(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(value.toString()));
                    } else {
                        field.set(obj, value);
                    }
                } catch (Exception e2) {
                }
            }
        }

        private static Map<String, Object> deserializeMap(Map<String, Object> map, JSONObject jo) {
            try {
                Iterator<String> keyIter = jo.keys();
                while (keyIter.hasNext()) {
                    String key = keyIter.next();
                    map.put(key, jo.get(key));
                }
                return map;
            } catch (JSONException e2) {
                return null;
            }
        }

        private static <T> T[] deserializeArray(JSONArray ja, Class<T> clazz) {
            if (DataType.isNull(ja) || clazz == null) {
                return null;
            }
            int len = ja.length();
            T[] array = (Object[]) Array.newInstance(clazz, len);
            boolean itemIsJSONArray = DataType.isArray(clazz) || DataType.isCollection(clazz);
            int i2 = 0;
            while (i2 < len) {
                try {
                    array[i2] = deserializeJSONArray(ja, i2, clazz, itemIsJSONArray);
                    i2++;
                } catch (JSONException e2) {
                }
            }
            return array;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Class} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <T> T deserializeCollection(org.json.JSONArray r7, java.lang.Class<T> r8) throws org.json.JSONException {
            /*
                boolean r0 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isNull(r7)
                r1 = 0
                if (r0 != 0) goto L_0x0055
                boolean r0 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isCollection(r8)
                if (r0 != 0) goto L_0x000e
                goto L_0x0055
            L_0x000e:
                r0 = 0
                java.lang.reflect.Type r2 = r8.getGenericSuperclass()
                boolean r3 = r2 instanceof java.lang.reflect.ParameterizedType
                r4 = 0
                if (r3 == 0) goto L_0x0029
                r3 = r2
                java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
                java.lang.reflect.Type[] r5 = r3.getActualTypeArguments()
                if (r5 == 0) goto L_0x0029
                int r6 = r5.length
                if (r6 <= 0) goto L_0x0029
                r6 = r5[r4]
                r0 = r6
                java.lang.Class r0 = (java.lang.Class) r0
            L_0x0029:
                if (r0 != 0) goto L_0x002c
                return r1
            L_0x002c:
                java.lang.Object r1 = newInstance(r8)
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r3 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isArray(r0)
                if (r3 != 0) goto L_0x003e
                boolean r3 = com.baidu.wallet.hometab.utils.JsonUtils.DataType.isCollection(r0)
                if (r3 == 0) goto L_0x003f
            L_0x003e:
                r4 = 1
            L_0x003f:
                r3 = r4
                r4 = 0
            L_0x0041:
                int r5 = r7.length()     // Catch:{ JSONException -> 0x0052 }
                if (r4 >= r5) goto L_0x0051
                java.lang.Object r5 = deserializeJSONArray(r7, r4, r0, r3)     // Catch:{ JSONException -> 0x0052 }
                r1.add(r5)     // Catch:{ JSONException -> 0x0052 }
                int r4 = r4 + 1
                goto L_0x0041
            L_0x0051:
                goto L_0x0053
            L_0x0052:
                r4 = move-exception
            L_0x0053:
                r4 = r1
                return r4
            L_0x0055:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.hometab.utils.JsonUtils.Decoder.deserializeCollection(org.json.JSONArray, java.lang.Class):java.lang.Object");
        }

        private static <T> T deserializeJSONArray(JSONArray ja, int index, Class<T> clazz, boolean isJSONArray) throws JSONException {
            if (isJSONArray) {
                return deserialize(ja.getJSONArray(index), clazz);
            }
            if (ja.get(index) instanceof JSONObject) {
                return deserialize(ja.getJSONObject(index), clazz);
            }
            return ja.get(index);
        }

        private static <T> T newInstance(Class<T> clazz) throws JSONException {
            if (clazz == null) {
                return null;
            }
            if (!clazz.isInterface()) {
                try {
                    return clazz.newInstance();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else if (clazz.equals(Map.class)) {
                return new HashMap();
            } else {
                if (clazz.equals(List.class)) {
                    return new ArrayList();
                }
                if (clazz.equals(Set.class)) {
                    return new HashSet();
                }
                throw new JSONException("unknown interface: " + clazz);
            }
        }
    }

    public static class DataType {
        public static boolean isNull(Object obj) {
            if (obj instanceof JSONObject) {
                return JSONObject.NULL.equals(obj);
            }
            return obj == null;
        }

        public static boolean isBoolean(Class<?> clazz) {
            return clazz != null && (Boolean.TYPE.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz));
        }

        public static boolean isNumber(Class<?> clazz) {
            return clazz != null && (Byte.TYPE.isAssignableFrom(clazz) || Short.TYPE.isAssignableFrom(clazz) || Integer.TYPE.isAssignableFrom(clazz) || Long.TYPE.isAssignableFrom(clazz) || Float.TYPE.isAssignableFrom(clazz) || Double.TYPE.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz));
        }

        public static boolean isString(Class<?> clazz) {
            return clazz != null && (String.class.isAssignableFrom(clazz) || Character.TYPE.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz));
        }

        public static boolean isRaw(Class<?> clazz) {
            return isBoolean(clazz) || isNumber(clazz) || isString(clazz);
        }

        public static boolean isObject(Class<?> clazz) {
            return clazz != null && !isRaw(clazz) && !isArray(clazz) && !isCollection(clazz) && !isMap(clazz) && !isJSONObject(clazz);
        }

        public static boolean isArray(Class<?> clazz) {
            return clazz != null && clazz.isArray();
        }

        public static boolean isCollection(Class<?> clazz) {
            return clazz != null && Collection.class.isAssignableFrom(clazz);
        }

        public static boolean isMap(Class<?> clazz) {
            return clazz != null && Map.class.isAssignableFrom(clazz);
        }

        public static boolean isJSONObject(Class<?> clazz) {
            return clazz != null && JSONObject.class.isAssignableFrom(clazz);
        }
    }
}
