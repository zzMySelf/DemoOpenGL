package com.baidu.wallet.lightapp.business.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.io.File;
import java.util.HashMap;

public class a {
    public static void a(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        String str3;
        try {
            HashMap hashMap = (HashMap) JsonUtils.fromJson(str, HashMap.class);
            String str4 = (String) hashMap.get("script_name");
            String path = context.getFilesDir().getPath();
            File[] listFiles = new File(path + "/dxm_rpa/" + str4).listFiles();
            if (listFiles == null || listFiles.length != 1) {
                str3 = path + "/dxm_rpa/" + str4 + "/" + str4 + ".side";
            } else {
                str3 = listFiles[0].getPath();
            }
            "文件的绝对路径:" + str3;
            File file = new File(str3);
            if (TextUtils.isEmpty(str4)) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数错误", "#callAutomatedSubmissionFail");
            } else if (!file.exists()) {
                LightappUtils.onError(iLightappInvokerCallback, str2, "10003", "未匹配到配置文件", "#callAutomatedSubmissionFail");
            } else if (LocalRouter.getInstance(context).isProviderExisted("rpaAutomationProvider")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("rpaAutomationProvider").action("rpaAutomationProcess").data(hashMap), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        if (i2 != 0) {
                            try {
                                LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(1);
                                lightAppCommonModel.cnt.errCode = i2 + "";
                                lightAppCommonModel.cnt.des = (String) hashMap.get("errorMsg");
                                lightAppCommonModel.cnt.data = (HashMap) JsonUtils.fromJson((String) hashMap.get("value"), HashMap.class);
                                ILightappInvokerCallback.this.onResult(1, lightAppCommonModel.toJson());
                            } catch (Exception e) {
                                e.printStackTrace();
                                LightappUtils.onError(ILightappInvokerCallback.this, str2, i2 + "", "内部异常", "#callAutomatedSubmissionFail");
                            }
                        } else if (hashMap != null) {
                            Object obj = hashMap.get("value");
                            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                                try {
                                    LightAppCommonModel lightAppCommonModel2 = new LightAppCommonModel(0);
                                    lightAppCommonModel2.cnt.errCode = String.valueOf(0);
                                    lightAppCommonModel2.cnt.des = "成功";
                                    lightAppCommonModel2.cnt.data = (HashMap) JsonUtils.fromJson((String) obj, HashMap.class);
                                    ILightappInvokerCallback.this.onResult(0, lightAppCommonModel2.toJson());
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    LightappUtils.onError(ILightappInvokerCallback.this, str2, i2 + "", "" + ((String) hashMap.get("errorMsg")), "#callAutomatedSubmissionFail");
                                }
                            }
                        }
                    }
                });
            } else {
                LightappUtils.onError(iLightappInvokerCallback, str2, "10004", "没有找到对应的方法", "#callAutomatedSubmissionFail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, "10003", "未匹配到配置文件", "#callAutomatedSubmissionFail");
        }
    }
}
