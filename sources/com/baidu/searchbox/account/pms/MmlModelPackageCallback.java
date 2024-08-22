package com.baidu.searchbox.account.pms;

import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.searchbox.account.IDownloadLibMmlCallback;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/account/pms/MmlModelPackageCallback;", "Lcom/baidu/searchbox/pms/callback/DefaultPackageCallback;", "callback", "Lcom/baidu/searchbox/account/IDownloadLibMmlCallback;", "(Lcom/baidu/searchbox/account/IDownloadLibMmlCallback;)V", "getCallback", "()Lcom/baidu/searchbox/account/IDownloadLibMmlCallback;", "callbackResult", "", "errorInfo", "Lcom/baidu/searchbox/pms/bean/ErrorInfo;", "onFetchError", "onResultData", "resultData", "Lcom/baidu/searchbox/pms/bean/ResultData;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MmlModelChannel.kt */
public final class MmlModelPackageCallback extends DefaultPackageCallback {
    private final IDownloadLibMmlCallback callback;

    public MmlModelPackageCallback(IDownloadLibMmlCallback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public final IDownloadLibMmlCallback getCallback() {
        return this.callback;
    }

    public void onResultData(ResultData resultData) {
        if (resultData == null) {
            LogUtils.d("resultData is null");
            callbackResult$default(this, (ErrorInfo) null, 1, (Object) null);
        } else if (!resultData.addList.isEmpty() || !resultData.updateList.isEmpty()) {
            List needDownloadList = new ArrayList();
            List<PackageInfo> list = resultData.addList;
            Intrinsics.checkNotNullExpressionValue(list, "resultData.addList");
            if (!list.isEmpty()) {
                List<PackageInfo> list2 = resultData.addList;
                Intrinsics.checkNotNullExpressionValue(list2, "resultData.addList");
                needDownloadList.addAll(list2);
            }
            List<PackageInfo> list3 = resultData.updateList;
            Intrinsics.checkNotNullExpressionValue(list3, "resultData.updateList");
            if (!list3.isEmpty()) {
                List<PackageInfo> list4 = resultData.updateList;
                Intrinsics.checkNotNullExpressionValue(list4, "resultData.updateList");
                needDownloadList.addAll(list4);
            }
            if (!needDownloadList.isEmpty()) {
                PmsManager.getInstance().download((List<PackageInfo>) needDownloadList, new DownloadOptions(), (DownloadCallback) new MmlModelPackageCallback$onResultData$1(this));
                return;
            }
            LogUtils.d("needDownloadList is null");
            callbackResult$default(this, (ErrorInfo) null, 1, (Object) null);
        } else {
            LogUtils.d("addList is empty and updateList is empty");
            callbackResult$default(this, (ErrorInfo) null, 1, (Object) null);
        }
    }

    public void onFetchError(ErrorInfo errorInfo) {
        callbackResult(errorInfo);
    }

    static /* synthetic */ void callbackResult$default(MmlModelPackageCallback mmlModelPackageCallback, ErrorInfo errorInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            errorInfo = null;
        }
        mmlModelPackageCallback.callbackResult(errorInfo);
    }

    /* access modifiers changed from: private */
    public final void callbackResult(ErrorInfo errorInfo) {
        IDownloadLibMmlCallback iDownloadLibMmlCallback = this.callback;
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$callbackResult_u24lambda_u2d0 = jSONObject;
        $this$callbackResult_u24lambda_u2d0.put("code", errorInfo != null ? errorInfo.code : -1);
        String str = errorInfo != null ? errorInfo.errorMsg : null;
        if (str == null) {
            str = "未知错误";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "errorInfo?.errorMsg ?: RESULT_FAIL_MSG");
        }
        $this$callbackResult_u24lambda_u2d0.put("msg", str);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …MSG)\n        }.toString()");
        iDownloadLibMmlCallback.onResult(jSONObject2);
    }
}
