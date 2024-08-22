package com.sdk.l;

import com.sdk.base.framework.bean.KInfo;
import com.sdk.f.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    public static final String a = "com.sdk.l.a";
    public static final boolean b = f.a;

    public static String a(Object obj) {
        try {
            Field[] declaredFields = Class.forName(obj.getClass().getName()).getDeclaredFields();
            JSONObject jSONObject = new JSONObject();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                String name = field.getName();
                if (!"serialVersionUID".equals(name)) {
                    Object obj2 = field.get(obj);
                    if (field.getType().equals(ArrayList.class)) {
                        JSONArray jSONArray = new JSONArray();
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                Object obj3 = arrayList.get(i2);
                                Class<?> cls = obj3.getClass();
                                if (cls.equals(KInfo.class)) {
                                    Field[] declaredFields2 = cls.getDeclaredFields();
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (Field field2 : declaredFields2) {
                                        field2.setAccessible(true);
                                        jSONObject2.put(field2.getName(), field2.get(obj3));
                                    }
                                    jSONArray.put(jSONObject2);
                                } else {
                                    jSONArray.put(obj3);
                                }
                            }
                        }
                        obj2 = jSONArray;
                    }
                    jSONObject.put(name, obj2);
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }
}
