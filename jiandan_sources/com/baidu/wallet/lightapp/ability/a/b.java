package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityTakePictureModel;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.ImageBase64Utils;
import org.json.JSONObject;

public class b extends com.baidu.wallet.lightapp.ability.b {
    public String a() {
        return LightappBusinessClient.METHOD_CALL_CAMERA;
    }

    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        String str3 = str;
        LogUtil.d(LightappBusinessClient.METHOD_CALL_CAMERA, str3);
        int a = a(str3, "type");
        if (1 == a) {
            try {
                i2 = (int) (new JSONObject(str3).optDouble("quality") * 100.0d);
            } catch (Exception e) {
                e.printStackTrace();
                i2 = -1;
            }
            final int i3 = (i2 <= 0 || 40 < i2) ? -1 : i2;
            final ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
            final Activity activity2 = activity;
            final String str4 = str2;
            IdCardDetectionController.getInstance().startIdcarddetect(activity, 6, false, new IdCardDetectionController.IIdCardDetectionListener() {
                public void onDetectFailed(int i2, String str) {
                    if (i2 == -1) {
                        NativeAbilityTakePictureModel nativeAbilityTakePictureModel = new NativeAbilityTakePictureModel(1);
                        NativeAbilityTakePictureModel.Data data = nativeAbilityTakePictureModel.cnt;
                        data.errCode = "10002";
                        data.des = PhoneUtils.getApplicationName(activity2) + "没有" + "访问相机的权限";
                        iLightappInvokerCallback2.onResult(1, nativeAbilityTakePictureModel.toJson());
                    } else if (i2 == -2) {
                        b.this.a(iLightappInvokerCallback2, str4, "10005", "取消", "#callCameraFail");
                    }
                }

                public void onDetectOK(Bundle bundle) {
                    if (bundle == null) {
                        ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback2;
                        if (iLightappInvokerCallback != null) {
                            iLightappInvokerCallback.onResult(1, "internal error");
                            return;
                        }
                        return;
                    }
                    String string = bundle.getString("pic1");
                    final NativeAbilityTakePictureModel nativeAbilityTakePictureModel = new NativeAbilityTakePictureModel(0);
                    AnonymousClass1 r1 = new ImageBase64Utils.ImageBase64Listener() {
                        public void onBase64Result(String str) {
                            NativeAbilityTakePictureModel nativeAbilityTakePictureModel = nativeAbilityTakePictureModel;
                            nativeAbilityTakePictureModel.cnt.image = str;
                            iLightappInvokerCallback2.onResult(0, nativeAbilityTakePictureModel.toJson());
                        }
                    };
                    ImageBase64Utils instance = ImageBase64Utils.getInstance();
                    int i2 = i3;
                    if (i2 > 0) {
                        instance.getImageBase64(string, -1, i2, (ImageBase64Utils.ImageBase64Listener) r1);
                    } else {
                        instance.getImageBase64(string, 640, 40, (ImageBase64Utils.ImageBase64Listener) r1);
                    }
                }
            }, false);
            return;
        }
        a(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + a, "#callCameraFail");
    }
}
