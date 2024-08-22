package com.baidu.sapi2.outsdk;

import android.app.Application;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceOperationCallback;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.enums.Domain;
import java.util.HashMap;

public class PassBiometricCall {
    public void initPassBioSDK(final SapiConfiguration sapiConfiguration) {
        PassFaceRecogManager biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        if (biometric == null || biometric.getConfiguration() == null) {
            PassBiometricConfiguration build = new PassBiometricConfiguration.Builder((Application) sapiConfiguration.context.getApplicationContext()).setProductLineInfo(sapiConfiguration.tpl, sapiConfiguration.appId, sapiConfiguration.appSignKey).sofireSdkConfig(sapiConfiguration.sofireAppKey, sapiConfiguration.sofireSecKey, sapiConfiguration.sofireHostID).setProductLicenseInfo(sapiConfiguration.faceLincenseID, sapiConfiguration.faceLincenseFile).setRuntimeEnvironment(sapiConfiguration.environment == Domain.DOMAIN_QA ? "https://passport.qatest.baidu.com" : "https://passport.baidu.com").debug(sapiConfiguration.debug).setAgreeDangerousProtocol(sapiConfiguration.isAgreeDangerousProtocol()).setFaceResPaths(sapiConfiguration.faceResPaths).setUIOrientation(sapiConfiguration.getUIOrientation()).build();
            build.mCallBackFaceOption = new PassFaceOperationCallback() {
                public int callbackFaceCompressValue() {
                    SapiConfiguration.CallbackFaceOptionListerer callbackFaceOptionListerer = sapiConfiguration.mCallbackFaceOpt;
                    if (callbackFaceOptionListerer != null) {
                        return callbackFaceOptionListerer.callbackFaceCompressValue();
                    }
                    return -1;
                }

                public HashMap<String, Integer> faceGrayOptionMap() {
                    HashMap<String, Integer> hashMap = new HashMap<>();
                    SapiOptions.Gray gray = SapiContext.getInstance().getSapiOptions().gray;
                    boolean isMeetGray = gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_GRAY_ANDROID_FACE_COMPRESS).isMeetGray();
                    boolean isMeetGray2 = gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_GRAY_FACE_WIREFRAME).isMeetGray();
                    boolean isMeetGray3 = gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_GRAY_FACE_REQUEST_PERMISSION).isMeetGray();
                    hashMap.put(SapiOptions.Gray.KEY_GRAY_ANDROID_FACE_COMPRESS, Integer.valueOf(isMeetGray ? 1 : 0));
                    hashMap.put(SapiOptions.Gray.KEY_GRAY_FACE_WIREFRAME, Integer.valueOf(isMeetGray2 ? 1 : 0));
                    hashMap.put(SapiOptions.Gray.KEY_GRAY_FACE_REQUEST_PERMISSION, Integer.valueOf(isMeetGray3 ? 1 : 0));
                    return hashMap;
                }
            };
            if (biometric != null) {
                biometric.config(build);
            }
        }
    }

    public void setFaceModuleAgreeDangerousProtocol(boolean z) {
        PassFaceRecogManager biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        if (biometric != null && biometric.getConfiguration() != null) {
            biometric.setAgreeDangerousProtocol(z);
        }
    }
}
