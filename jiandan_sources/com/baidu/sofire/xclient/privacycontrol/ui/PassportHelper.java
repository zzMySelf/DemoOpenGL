package com.baidu.sofire.xclient.privacycontrol.ui;

import android.content.Context;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.DoubleListCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.DoubleListDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import java.util.HashMap;

public class PassportHelper {
    public static String getPassportUid() {
        try {
            return SapiAccountManager.getInstance().getSession().uid;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void gotoPassDoubleListPage(Context context) {
        DoubleListDTO doubleListDTO = new DoubleListDTO();
        doubleListDTO.extraParams = new HashMap<>();
        PassportSDK.getInstance().loadDoubleListActivity(context, doubleListDTO, (DoubleListCallback) null);
    }

    public static void gotoUserCenter() {
        try {
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            accountCenterDTO.handleLogin = false;
            PassportSDK.getInstance().loadAccountCenter((AccountCenterCallback) null, accountCenterDTO);
        } catch (Throwable unused) {
        }
    }

    public static boolean isPassLogin() {
        return SapiAccountManager.getInstance().isLogin();
    }

    public static void login(Context context, IDoubleListCallBack iDoubleListCallBack) {
        PassportSDK instance = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.isWithYouthStyle = false;
        instance.startLogin(context, new PassWebAuthListener(iDoubleListCallBack), webLoginDTO);
    }
}
