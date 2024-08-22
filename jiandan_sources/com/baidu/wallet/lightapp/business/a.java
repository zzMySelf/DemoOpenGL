package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.business.c;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static C0157a a = new C0157a();

    public static void a(final Context context, final String str, String[] strArr, final String[] strArr2) {
        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "findConfigImpactJsFiles hookUrl=" + str + "; targetConfig=" + Arrays.toString(strArr) + " ; targetKeys=" + Arrays.toString(strArr2));
        if (TextUtils.isEmpty(str) || str.equals(a.a)) {
            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "findConfigImpactJsFiles 已下载过" + str);
        } else if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
            final HashMap hashMap = new HashMap();
            c.a(str, context, strArr, (c.a) new c.a() {
                public void a(String[] strArr) {
                    LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "onLoadComplete files.length=" + strArr.length + "\tconfigFiles:" + Arrays.toString(strArr));
                    if (strArr != null && strArr.length != 0) {
                        HashSet hashSet = new HashSet();
                        for (String str : strArr2) {
                            if (!TextUtils.isEmpty(str)) {
                                for (String str2 : strArr) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            JSONArray optJSONArray = new JSONObject(str2).optJSONArray(str);
                                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                                int length = optJSONArray.length();
                                                String[] strArr2 = new String[length];
                                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                                    strArr2[i2] = String.valueOf(optJSONArray.get(i2));
                                                }
                                                if (length > 0) {
                                                    hashMap.put(str, strArr2);
                                                    hashSet.addAll(new HashSet(Arrays.asList(strArr2)));
                                                }
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            int size = hashSet.size();
                            final String[] strArr3 = new String[size];
                            hashSet.toArray(strArr3);
                            if (size > 0) {
                                c.a(SdkInitResponse.getInstance().getJsHookURl(context), context, strArr3, (c.a) new c.a() {
                                    public void a(String[] strArr) {
                                        if (strArr == null && strArr.length == 0) {
                                            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "获取到的js文件为空");
                                            return;
                                        }
                                        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "成功获取到js文件");
                                        C0157a aVar = a.a;
                                        AnonymousClass1 r1 = AnonymousClass1.this;
                                        aVar.a(str, hashMap, strArr3, strArr);
                                    }
                                });
                            }
                        }
                    }
                }
            });
        }
    }

    public static String[] b(String str) {
        if (!TextUtils.isEmpty(str) && a.b != null && a.b.size() > 0) {
            return (String[]) a.b.get(str);
        }
        return null;
    }

    /* renamed from: com.baidu.wallet.lightapp.business.a$a  reason: collision with other inner class name */
    public static class C0157a {
        public String a;
        public HashMap b;
        public String[] c;
        public String[] d;

        public String toString() {
            return "hookUrl=" + this.a + "\n\t" + "toAddKeyVauleMap=" + this.b.toString() + "\n\t" + "toAddJsFilesName=" + Arrays.toString(this.c) + "\n\t" + "toAddJsFilesContent=" + Arrays.toString(this.d);
        }

        /* access modifiers changed from: private */
        public void a(String str, HashMap hashMap, String[] strArr, String[] strArr2) {
            this.a = str;
            this.b = hashMap;
            this.c = strArr;
            this.d = strArr2;
            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "updateImpact\n" + toString());
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && a.c != null && a.d != null && a.c.length == a.d.length && a.c != null && a.c.length > 0) {
            for (int i2 = 0; i2 < a.c.length; i2++) {
                if (str.equals(a.c[i2])) {
                    return a.d[i2];
                }
            }
        }
        return null;
    }
}
