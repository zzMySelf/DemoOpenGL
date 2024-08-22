package com.dxmpay.apollon.utils;

import com.dxmpay.apollon.ApollonConstants;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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

    public static class DataType {
        public static boolean isArray(Class<?> cls) {
            return cls != null && cls.isArray();
        }

        public static boolean isBoolean(Class<?> cls) {
            return cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls));
        }

        public static boolean isCollection(Class<?> cls) {
            return cls != null && Collection.class.isAssignableFrom(cls);
        }

        public static boolean isJSONObject(Class<?> cls) {
            return cls != null && JSONObject.class.isAssignableFrom(cls);
        }

        public static boolean isMap(Class<?> cls) {
            return cls != null && Map.class.isAssignableFrom(cls);
        }

        public static boolean isNull(Object obj) {
            if (obj instanceof JSONObject) {
                return JSONObject.NULL.equals(obj);
            }
            return obj == null;
        }

        public static boolean isNumber(Class<?> cls) {
            return cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls));
        }

        public static boolean isObject(Class<?> cls) {
            return cls != null && !isRaw(cls) && !isArray(cls) && !isCollection(cls) && !isMap(cls) && !isJSONObject(cls);
        }

        public static boolean isRaw(Class<?> cls) {
            return isBoolean(cls) || isNumber(cls) || isString(cls);
        }

        public static boolean isString(Class<?> cls) {
            return cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls));
        }
    }

    static {
        boolean z = ApollonConstants.DEBUG;
    }

    public static <T> T fromJson(String str, Class<T> cls) throws JSONException {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        if (DataType.isArray(cls) || DataType.isCollection(cls)) {
            return Decoder.deserialize(new JSONArray(str), cls);
        }
        return Decoder.deserialize(new JSONObject(str), cls);
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return Encoder.serialize(new JSONStringer(), obj).toString();
    }

    public static class Encoder {
        public static JSONStringer serialize(JSONStringer jSONStringer, Object obj) {
            if (DataType.isNull(obj)) {
                serializeNull(jSONStringer);
            } else {
                Class<?> cls = obj.getClass();
                if (DataType.isRaw(cls)) {
                    serializeRaw(jSONStringer, obj);
                } else if (DataType.isArray(cls)) {
                    serializeArray(jSONStringer, obj);
                } else if (DataType.isCollection(cls)) {
                    serializeCollection(jSONStringer, (Collection) obj);
                } else if (DataType.isMap(cls)) {
                    serializeMap(jSONStringer, (Map) obj);
                } else {
                    serializeObject(jSONStringer, obj);
                }
            }
            return jSONStringer;
        }

        public static JSONStringer serializeArray(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.array();
                for (int i2 = 0; i2 < Array.getLength(obj); i2++) {
                    serialize(jSONStringer, Array.get(obj, i2));
                }
                jSONStringer.endArray();
            } catch (Exception e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
            }
            return jSONStringer;
        }

        public static void serializeCollection(JSONStringer jSONStringer, Collection<?> collection) {
            try {
                jSONStringer.array();
                for (Object serialize : collection) {
                    serialize(jSONStringer, serialize);
                }
                jSONStringer.endArray();
            } catch (Exception e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
            }
        }

        public static void serializeMap(JSONStringer jSONStringer, Map<?, ?> map) {
            try {
                jSONStringer.object();
                for (Map.Entry next : map.entrySet()) {
                    jSONStringer.key((String) next.getKey());
                    serialize(jSONStringer, next.getValue());
                }
                jSONStringer.endObject();
            } catch (Exception e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
            }
        }

        public static void serializeNull(JSONStringer jSONStringer) {
            try {
                jSONStringer.value((Object) null);
            } catch (JSONException e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
            }
        }

        public static void serializeObject(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.object();
                serializeObject(jSONStringer, obj.getClass(), obj);
                jSONStringer.endObject();
            } catch (Exception e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
            }
        }

        public static void serializeRaw(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.value(obj);
            } catch (JSONException e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
            }
        }

        public static void serializeObject(JSONStringer jSONStringer, Class<?> cls, Object obj) {
            if (cls != null) {
                serializeObject(jSONStringer, cls.getSuperclass(), obj);
                for (Field field : cls.getDeclaredFields()) {
                    if (!ClassLoader.class.isAssignableFrom(field.getType()) && !PathClassLoader.class.isAssignableFrom(field.getType()) && !Class.class.isAssignableFrom(field.getType()) && !Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
                        try {
                            field.setAccessible(true);
                            Object obj2 = field.get(obj);
                            if (Date.class.isAssignableFrom(field.getType())) {
                                obj2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format((Date) obj2);
                            }
                            jSONStringer.key(field.getName());
                            serialize(jSONStringer, obj2);
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public static class Decoder {
        public static <T> T deserialize(JSONArray jSONArray, Class<T> cls) throws JSONException {
            if (cls == null || DataType.isNull(jSONArray)) {
                return null;
            }
            if (DataType.isArray(cls)) {
                return deserializeArray(jSONArray, cls.getComponentType());
            }
            if (DataType.isCollection(cls)) {
                return deserializeCollection(jSONArray, cls);
            }
            return null;
        }

        public static <T> T[] deserializeArray(JSONArray jSONArray, Class<T> cls) {
            if (DataType.isNull(jSONArray) || cls == null) {
                return null;
            }
            int length = jSONArray.length();
            T[] tArr = (Object[]) Array.newInstance(cls, length);
            int i2 = 0;
            boolean z = DataType.isArray(cls) || DataType.isCollection(cls);
            while (i2 < length) {
                try {
                    tArr[i2] = deserializeJSONArray(jSONArray, i2, cls, z);
                    i2++;
                } catch (JSONException e) {
                    LogUtil.e("JsonUtils", e.getMessage(), e);
                }
            }
            return tArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            r0 = ((java.lang.reflect.ParameterizedType) r0).getActualTypeArguments();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <T> T deserializeCollection(org.json.JSONArray r4, java.lang.Class<T> r5) throws org.json.JSONException {
            /*
                boolean r0 = com.dxmpay.apollon.utils.JsonUtils.DataType.isNull(r4)
                r1 = 0
                if (r0 != 0) goto L_0x005c
                boolean r0 = com.dxmpay.apollon.utils.JsonUtils.DataType.isCollection(r5)
                if (r0 != 0) goto L_0x000e
                goto L_0x005c
            L_0x000e:
                java.lang.reflect.Type r0 = r5.getGenericSuperclass()
                boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
                r3 = 0
                if (r2 == 0) goto L_0x0027
                java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
                java.lang.reflect.Type[] r0 = r0.getActualTypeArguments()
                if (r0 == 0) goto L_0x0027
                int r2 = r0.length
                if (r2 <= 0) goto L_0x0027
                r0 = r0[r3]
                java.lang.Class r0 = (java.lang.Class) r0
                goto L_0x0028
            L_0x0027:
                r0 = r1
            L_0x0028:
                if (r0 != 0) goto L_0x002b
                return r1
            L_0x002b:
                java.lang.Object r5 = newInstance(r5)
                java.util.Collection r5 = (java.util.Collection) r5
                boolean r1 = com.dxmpay.apollon.utils.JsonUtils.DataType.isArray(r0)
                if (r1 != 0) goto L_0x0040
                boolean r1 = com.dxmpay.apollon.utils.JsonUtils.DataType.isCollection(r0)
                if (r1 == 0) goto L_0x003e
                goto L_0x0040
            L_0x003e:
                r1 = 0
                goto L_0x0041
            L_0x0040:
                r1 = 1
            L_0x0041:
                int r2 = r4.length()     // Catch:{ JSONException -> 0x0051 }
                if (r3 >= r2) goto L_0x005b
                java.lang.Object r2 = deserializeJSONArray(r4, r3, r0, r1)     // Catch:{ JSONException -> 0x0051 }
                r5.add(r2)     // Catch:{ JSONException -> 0x0051 }
                int r3 = r3 + 1
                goto L_0x0041
            L_0x0051:
                r4 = move-exception
                java.lang.String r0 = r4.getMessage()
                java.lang.String r1 = "JsonUtils"
                com.dxmpay.apollon.utils.LogUtil.e(r1, r0, r4)
            L_0x005b:
                return r5
            L_0x005c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.JsonUtils.Decoder.deserializeCollection(org.json.JSONArray, java.lang.Class):java.lang.Object");
        }

        public static void deserializeField(JSONObject jSONObject, Object obj, Field field) {
            Class<?> type = field.getType();
            String name = field.getName();
            Object obj2 = null;
            try {
                if (!DataType.isRaw(type)) {
                    if (!DataType.isArray(type)) {
                        if (!DataType.isCollection(type)) {
                            if (DataType.isJSONObject(type)) {
                                obj2 = jSONObject.opt(name);
                            } else if (DataType.isObject(type)) {
                                obj2 = deserialize(jSONObject.optJSONObject(name), type);
                            } else if (DataType.isMap(type)) {
                                obj2 = deserializeMap(new HashMap(), jSONObject.optJSONObject(name));
                            } else {
                                throw new Exception("unknow type!");
                            }
                        }
                    }
                    obj2 = deserialize(jSONObject.optJSONArray(name), type);
                } else if (Integer.TYPE.isAssignableFrom(type)) {
                    try {
                        obj2 = Integer.valueOf(jSONObject.getInt(name));
                    } catch (JSONException e) {
                        LogUtil.e("JsonUtils", e.getMessage(), e);
                    }
                } else if (Long.TYPE.isAssignableFrom(type)) {
                    try {
                        obj2 = Long.valueOf(jSONObject.getLong(name));
                    } catch (JSONException e2) {
                        LogUtil.e("JsonUtils", e2.getMessage(), e2);
                    }
                } else {
                    if (!Float.TYPE.isAssignableFrom(type)) {
                        if (!Double.TYPE.isAssignableFrom(type)) {
                            if (DataType.isBoolean(type)) {
                                try {
                                    obj2 = Boolean.valueOf(jSONObject.getBoolean(name));
                                } catch (JSONException e3) {
                                    LogUtil.e("JsonUtils", e3.getMessage(), e3);
                                }
                            } else {
                                obj2 = jSONObject.opt(name);
                            }
                        }
                    }
                    try {
                        obj2 = Double.valueOf(jSONObject.getDouble(name));
                    } catch (JSONException e4) {
                        LogUtil.e("JsonUtils", e4.getMessage(), e4);
                    }
                }
                setFiedlValue(obj, field, obj2);
            } catch (Exception e5) {
                LogUtil.e("JsonUtils", e5.getMessage(), e5);
            }
        }

        public static <T> T deserializeJSONArray(JSONArray jSONArray, int i2, Class<T> cls, boolean z) throws JSONException {
            if (z) {
                return deserialize(jSONArray.getJSONArray(i2), cls);
            }
            if (jSONArray.get(i2) instanceof JSONObject) {
                return deserialize(jSONArray.getJSONObject(i2), cls);
            }
            return jSONArray.get(i2);
        }

        public static Map<String, Object> deserializeMap(Map<String, Object> map, JSONObject jSONObject) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    map.put(next, jSONObject.get(next));
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("map=" + map.toString());
                }
                return map;
            } catch (JSONException e) {
                LogUtil.e("JsonUtils", e.getMessage(), e);
                return null;
            }
        }

        public static void deserializeObject(JSONObject jSONObject, Class<?> cls, Object obj) {
            if (cls != null) {
                deserializeObject(jSONObject, cls.getSuperclass(), obj);
                for (Field field : cls.getDeclaredFields()) {
                    if (!Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
                        deserializeField(jSONObject, obj, field);
                    }
                }
            }
        }

        public static <T> T newInstance(Class<T> cls) throws JSONException {
            if (cls == null) {
                return null;
            }
            if (!cls.isInterface()) {
                try {
                    return cls.newInstance();
                } catch (Exception e) {
                    LogUtil.e("JsonUtils", e.getMessage(), e);
                    return null;
                }
            } else if (cls.equals(Map.class)) {
                return new HashMap();
            } else {
                if (cls.equals(List.class)) {
                    return new ArrayList();
                }
                if (cls.equals(Set.class)) {
                    return new HashSet();
                }
                throw new JSONException("unknown interface: " + cls);
            }
        }

        public static void setFiedlValue(Object obj, Field field, Object obj2) {
            if (obj != null && field != null && obj2 != null && !"".equals(obj2)) {
                try {
                    Class<?> type = field.getType();
                    field.setAccessible(true);
                    if (Date.class.isAssignableFrom(type)) {
                        field.set(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString()));
                    } else {
                        field.set(obj, obj2);
                    }
                } catch (Exception e) {
                    LogUtil.e("JsonUtils", e.getMessage(), e);
                }
            }
        }

        public static <T> T deserialize(JSONObject jSONObject, Class<T> cls) throws JSONException {
            if (cls == null || DataType.isNull(jSONObject)) {
                return null;
            }
            T newInstance = newInstance(cls);
            if (newInstance != null) {
                if (DataType.isMap(cls)) {
                    deserializeMap((Map) newInstance, jSONObject);
                } else {
                    deserializeObject(jSONObject, cls, newInstance);
                }
            }
            return newInstance;
        }
    }
}
