package com.baidu.wallet.lightapp.ability;

import android.text.TextUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.ability.a.b;
import com.baidu.wallet.lightapp.ability.a.c;
import com.baidu.wallet.lightapp.ability.a.d;
import com.baidu.wallet.lightapp.ability.a.e;
import com.baidu.wallet.lightapp.ability.a.f;
import com.baidu.wallet.lightapp.ability.a.g;
import com.baidu.wallet.lightapp.ability.a.h;
import com.baidu.wallet.lightapp.ability.a.i;
import com.baidu.wallet.lightapp.ability.a.j;
import com.baidu.wallet.lightapp.ability.a.k;
import com.baidu.wallet.lightapp.ability.a.l;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityCommonModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel;
import com.baidu.wallet.lightapp.base.LightappConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NativeAbilityInvoker {
    public Map<String, a> a;

    public static class NativeAbilityInvokerCallback implements ILightappInvokerCallback {
        public ILightappInvokerCallback a;
        public ArrayList<String> b;

        public NativeAbilityInvokerCallback(ILightappInvokerCallback iLightappInvokerCallback, ArrayList<String> arrayList) {
            this.a = iLightappInvokerCallback;
            this.b = arrayList;
        }

        public void addStatics(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                this.b.add(str);
            }
        }

        public void onResult(int i2, String str) {
            ILightappInvokerCallback iLightappInvokerCallback = this.a;
            if (iLightappInvokerCallback == null) {
                return;
            }
            if (i2 == 0) {
                DXMSdkSAUtils.onEventWithValues("NA#invokeBdWalletNativeSuccess", this.b);
                this.a.onResult(i2, str);
            } else if (i2 != 1) {
                iLightappInvokerCallback.onResult(i2, str);
            } else {
                String str2 = "";
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                }
                if (this.b.size() >= 2) {
                    this.b.add(1, str);
                } else {
                    this.b.add(str);
                }
                try {
                    str2 = ((NativeAbilityCommonModel) JsonUtils.fromJson(str, NativeAbilityCommonModel.class)).cnt.errCode;
                } catch (Exception unused) {
                }
                this.b.add(str2);
                DXMSdkSAUtils.onEventWithValues("NA#invokeBdWalletNativeFail", this.b);
                this.a.onResult(i2, str);
            }
        }
    }

    public static class a {
        public static NativeAbilityInvoker a = new NativeAbilityInvoker();
    }

    public static NativeAbilityInvoker a() {
        return a.a;
    }

    public NativeAbilityInvoker() {
        this.a = new HashMap();
        a((a) new h());
        a((a) new e());
        a((a) new j());
        a((a) new c());
        a((a) new b());
        a((a) new i());
        a((a) new f());
        a((a) new k());
        a((a) new com.baidu.wallet.lightapp.ability.a.a());
        a((a) new d());
        a((a) new g());
        a((a) new l());
    }

    private void a(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.a()) && !this.a.containsKey(aVar.a())) {
            this.a.put(aVar.a(), aVar);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:11|12|13|(1:15)|16|17|18|19|20|21|(2:23|30)(2:24|31)) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        a(r8);
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d A[Catch:{ JSONException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[Catch:{ JSONException -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.app.Activity r5, java.lang.String r6, java.lang.String r7, com.baidu.wallet.api.ILightappInvokerCallback r8) {
        /*
            r4 = this;
            java.lang.String r0 = "method_name"
            if (r8 != 0) goto L_0x0005
            return
        L_0x0005:
            if (r5 == 0) goto L_0x0083
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L_0x000e
            goto L_0x0083
        L_0x000e:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007b }
            r1.<init>(r7)     // Catch:{ JSONException -> 0x007b }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x007b }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x007b }
            if (r2 == 0) goto L_0x0023
            r4.a((com.baidu.wallet.api.ILightappInvokerCallback) r8)     // Catch:{ JSONException -> 0x007b }
            return
        L_0x0023:
            java.lang.String r2 = ""
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007b }
            r3.<init>(r7)     // Catch:{ JSONException -> 0x007b }
            r3.remove(r0)     // Catch:{ Exception -> 0x0037 }
            int r0 = r3.length()     // Catch:{ Exception -> 0x0037 }
            if (r0 <= 0) goto L_0x0037
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x007b }
            r0.<init>()     // Catch:{ JSONException -> 0x007b }
            java.lang.String r3 = com.baidu.apollon.utils.CheckUtils.stripUrlParams(r6)     // Catch:{ Exception -> 0x0043 }
            r0.add(r3)     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            r0.add(r1)     // Catch:{ JSONException -> 0x007b }
            r0.add(r2)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r2 = "NA#invokeBdWalletNative"
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEventWithValues(r2, r0)     // Catch:{ JSONException -> 0x007b }
            com.baidu.wallet.lightapp.ability.NativeAbilityInvoker$NativeAbilityInvokerCallback r2 = new com.baidu.wallet.lightapp.ability.NativeAbilityInvoker$NativeAbilityInvokerCallback     // Catch:{ JSONException -> 0x007b }
            r2.<init>(r8, r0)     // Catch:{ JSONException -> 0x007b }
            java.util.Map<java.lang.String, com.baidu.wallet.lightapp.ability.a> r0 = r4.a     // Catch:{ JSONException -> 0x007b }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ JSONException -> 0x007b }
            com.baidu.wallet.lightapp.ability.a r0 = (com.baidu.wallet.lightapp.ability.a) r0     // Catch:{ JSONException -> 0x007b }
            if (r0 == 0) goto L_0x0061
            r0.a(r5, r7, r2, r6)     // Catch:{ JSONException -> 0x007b }
            goto L_0x0082
        L_0x0061:
            com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel r5 = new com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel     // Catch:{ JSONException -> 0x007b }
            r6 = 1
            r5.<init>(r6)     // Catch:{ JSONException -> 0x007b }
            com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel$Data r7 = r5.cnt     // Catch:{ JSONException -> 0x007b }
            java.lang.String r0 = "10004"
            r7.errCode = r0     // Catch:{ JSONException -> 0x007b }
            com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel$Data r7 = r5.cnt     // Catch:{ JSONException -> 0x007b }
            java.lang.String r0 = "没有找到对应的方法"
            r7.des = r0     // Catch:{ JSONException -> 0x007b }
            java.lang.String r5 = r5.toJson()     // Catch:{ JSONException -> 0x007b }
            r2.onResult(r6, r5)     // Catch:{ JSONException -> 0x007b }
            goto L_0x0082
        L_0x007b:
            r5 = move-exception
            r4.a((com.baidu.wallet.api.ILightappInvokerCallback) r8)
            r5.printStackTrace()
        L_0x0082:
            return
        L_0x0083:
            r4.a((com.baidu.wallet.api.ILightappInvokerCallback) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.ability.NativeAbilityInvoker.a(android.app.Activity, java.lang.String, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback):void");
    }

    private void a(ILightappInvokerCallback iLightappInvokerCallback) {
        NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
        NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
        data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
        data.des = "参数错误";
        iLightappInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
    }
}
