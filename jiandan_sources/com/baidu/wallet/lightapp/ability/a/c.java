package com.baidu.wallet.lightapp.ability.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityCallIDPhotoModel;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.ImageBase64Utils;
import java.io.File;

public class c extends b {
    public String a() {
        return LightappBusinessClient.METHOD_CALL_ID_PHOTOS;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.app.Activity r12, java.lang.String r13, com.baidu.wallet.api.ILightappInvokerCallback r14, java.lang.String r15) {
        /*
            r11 = this;
            java.lang.String r0 = "callIDPotos"
            com.baidu.apollon.utils.LogUtil.d(r0, r13)
            boolean r0 = com.baidu.apollon.utils.CheckUtils.isFastDoubleClick()
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            java.lang.String r0 = "type"
            int r0 = r11.a((java.lang.String) r13, (java.lang.String) r0)
            r1 = -1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0024 }
            r2.<init>(r13)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r3 = "quality"
            double r2 = r2.optDouble(r3)     // Catch:{ Exception -> 0x0024 }
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 * r4
            int r2 = (int) r2
            goto L_0x0029
        L_0x0024:
            r2 = move-exception
            r2.printStackTrace()
            r2 = -1
        L_0x0029:
            if (r2 <= 0) goto L_0x0032
            r3 = 40
            if (r3 >= r2) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r7 = r2
            goto L_0x0033
        L_0x0032:
            r7 = -1
        L_0x0033:
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 1
            if (r5 != r0) goto L_0x003b
        L_0x0039:
            r6 = -1
            goto L_0x004c
        L_0x003b:
            r6 = 2
            if (r6 != r0) goto L_0x0040
            r6 = 3
            goto L_0x004c
        L_0x0040:
            if (r4 != r0) goto L_0x0044
            r6 = 4
            goto L_0x004c
        L_0x0044:
            if (r3 != r0) goto L_0x0048
            r6 = 5
            goto L_0x004c
        L_0x0048:
            if (r2 != r0) goto L_0x0039
            r1 = 6
            r6 = 6
        L_0x004c:
            if (r6 <= 0) goto L_0x0062
            java.lang.String r0 = "showalbum"
            int r13 = r11.a((java.lang.String) r13, (java.lang.String) r0)
            if (r13 != r5) goto L_0x0058
            r10 = 1
            goto L_0x005a
        L_0x0058:
            r13 = 0
            r10 = 0
        L_0x005a:
            r4 = r11
            r5 = r12
            r8 = r14
            r9 = r15
            r4.a((android.content.Context) r5, (int) r6, (int) r7, (com.baidu.wallet.api.ILightappInvokerCallback) r8, (java.lang.String) r9, (boolean) r10)
            goto L_0x007d
        L_0x0062:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "参数非法 type:"
            r12.append(r13)
            r12.append(r6)
            java.lang.String r4 = r12.toString()
            java.lang.String r3 = "10001"
            java.lang.String r5 = "#callIDPotosFail"
            r0 = r11
            r1 = r14
            r2 = r15
            r0.a(r1, r2, r3, r4, r5)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.ability.a.c.a(android.app.Activity, java.lang.String, com.baidu.wallet.api.ILightappInvokerCallback, java.lang.String):void");
    }

    private void a(Context context, int i2, int i3, ILightappInvokerCallback iLightappInvokerCallback, String str, boolean z) {
        final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
        final int i4 = i3;
        final String str2 = str;
        final Context context2 = context;
        IdCardDetectionController.getInstance().startIdcarddetect(context, i2, false, new IdCardDetectionController.IIdCardDetectionListener() {
            public void onDetectFailed(int i2, String str) {
                if (i2 == -1) {
                    c cVar = c.this;
                    cVar.a(iLightappInvokerCallback2, str2, "10002", cVar.a(context2, "访问相机的权限"), "##callIDPotosFail");
                } else if (-2 == i2) {
                    c.this.a(iLightappInvokerCallback2, str2, "10005", "取消", "##callIDPotosFail");
                }
            }

            public void onDetectOK(Bundle bundle) {
                bundle.getInt("step");
                String string = bundle.getString("pic1");
                final String string2 = bundle.getString("pic2");
                final NativeAbilityCallIDPhotoModel nativeAbilityCallIDPhotoModel = new NativeAbilityCallIDPhotoModel(0);
                ImageBase64Utils instance = ImageBase64Utils.getInstance();
                final String str = string;
                final ImageBase64Utils imageBase64Utils = instance;
                AnonymousClass1 r1 = new ImageBase64Utils.ImageBase64Listener() {
                    public void onBase64Result(String str) {
                        nativeAbilityCallIDPhotoModel.cnt.front = str;
                        AnonymousClass1 r5 = new ImageBase64Utils.ImageBase64Listener() {
                            public void onBase64Result(String str) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                NativeAbilityCallIDPhotoModel nativeAbilityCallIDPhotoModel = nativeAbilityCallIDPhotoModel;
                                nativeAbilityCallIDPhotoModel.cnt.back = str;
                                iLightappInvokerCallback2.onResult(0, nativeAbilityCallIDPhotoModel.toJson());
                                try {
                                    if (str != null) {
                                        File file = new File(str);
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                                try {
                                    if (string2 != null) {
                                        File file2 = new File(string2);
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                }
                            }
                        };
                        ImageBase64Utils imageBase64Utils = imageBase64Utils;
                        String str2 = string2;
                        int i2 = i4;
                        if (i2 <= 0) {
                            i2 = 40;
                        }
                        imageBase64Utils.getImageBase64(str2, 640, i2, (ImageBase64Utils.ImageBase64Listener) r5);
                    }
                };
                int i2 = i4;
                if (i2 <= 0) {
                    i2 = 40;
                }
                instance.getImageBase64(string, 640, i2, (ImageBase64Utils.ImageBase64Listener) r1);
            }
        }, z);
    }
}
