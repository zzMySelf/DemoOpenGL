package com.baidu.searchbox.download.center.ui.fusion;

import android.content.Context;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.io.StreamUtils;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.EventControlInfoForStart;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.ui.UniversalLoadingDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/download/center/ui/fusion/FileManagerActivity$handleMarketLinkData$1$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lorg/json/JSONObject;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "dataJson", "i", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileManagerActivity.kt */
public final class FileManagerActivity$handleMarketLinkData$1$responseCallback$1 extends ResponseCallback<JSONObject> {
    final /* synthetic */ UniversalLoadingDialog $loadingDialog;
    final /* synthetic */ FileManagerActivity this$0;

    FileManagerActivity$handleMarketLinkData$1$responseCallback$1(FileManagerActivity $receiver, UniversalLoadingDialog $loadingDialog2) {
        this.this$0 = $receiver;
        this.$loadingDialog = $loadingDialog2;
    }

    public JSONObject parseResponse(Response response, int i2) throws Exception {
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        String json = StreamUtils.streamToString(body.byteStream());
        if (FileManagerActivityKt.DEBUG) {
            Log.i("FileManagerActivity", "ResultData json:" + json);
        }
        FileManagerActivity fileManagerActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        return fileManagerActivity.getPkgJsonData(json);
    }

    public void onSuccess(JSONObject dataJson, int i2) {
        this.$loadingDialog.dismiss();
        if (dataJson == null || dataJson.length() == 0) {
            this.this$0.requestMarketDownloadInfoFailUBC();
            FileManagerActivity fileManagerActivity = this.this$0;
            UniversalToast.makeText((Context) fileManagerActivity, (CharSequence) fileManagerActivity.getResources().getString(R.string.download_load_resource_fail)).show();
            return;
        }
        FileManagerActivity fileManagerActivity2 = this.this$0;
        String optString = dataJson.optString("sname");
        Intrinsics.checkNotNullExpressionValue(optString, "dataJson.optString(Downl…ts.DOWNLOAD_MARKET_SNAME)");
        String optString2 = dataJson.optString("download_url");
        Intrinsics.checkNotNullExpressionValue(optString2, "dataJson.optString(Downl…LOAD_MARKET_DOWNLOAD_URL)");
        String optString3 = dataJson.optString("icon");
        Intrinsics.checkNotNullExpressionValue(optString3, "dataJson.optString(Downl…nts.DOWNLOAD_MARKET_ICON)");
        String optString4 = dataJson.optString("versioncode");
        Intrinsics.checkNotNullExpressionValue(optString4, "dataJson.optString(Downl…NLOAD_MARKET_VERSIONCODE)");
        DownloadParams params = fileManagerActivity2.initDownloadParams(optString, optString2, optString3, optString4);
        DownloadUnifiedManager instance = DownloadUnifiedManager.getInstance();
        FileManagerActivity fileManagerActivity3 = this.this$0;
        instance.startDownload(fileManagerActivity3, "market", params, (IDownloadListener) null, (EventControlInfoForStart) null, new FileManagerActivity$handleMarketLinkData$1$responseCallback$1$$ExternalSyntheticLambda0(fileManagerActivity3));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m17536onSuccess$lambda0(FileManagerActivity this$02, int type, EventCallback.EventBackInfo info) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        if (type == 1) {
            this$02.refreshRecentDownload();
        }
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.this$0.requestMarketDownloadInfoFailUBC();
        this.$loadingDialog.dismiss();
        FileManagerActivity fileManagerActivity = this.this$0;
        UniversalToast.makeText((Context) fileManagerActivity, (CharSequence) fileManagerActivity.getResources().getString(R.string.download_load_resource_fail)).show();
    }
}
