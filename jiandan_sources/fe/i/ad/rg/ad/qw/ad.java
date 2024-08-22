package fe.i.ad.rg.ad.qw;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.paysdk.ui.WebViewActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ad {

    /* renamed from: fe.i.ad.rg.ad.qw.ad$ad  reason: collision with other inner class name */
    public static class C0190ad {
        public static final ad qw = new ad();
    }

    public static ad rg() {
        return C0190ad.qw;
    }

    public final void ad(Context context, String str, RouterCallback routerCallback) {
        try {
            String string = new JSONObject(str).getString("urlAddr");
            if (TextUtils.isEmpty(string)) {
                routerCallback.onResult(1, qw.qw(1, "urlAddr为空"));
                return;
            }
            LogUtil.d("DxmPayWebviewActions", string);
            WebViewActivity.setRouterCallback(routerCallback);
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("jump_url", string);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (JSONException e) {
            StatisticManager.onEventWithValue(StatServiceEvent.DXMPAY_WEBVIEW_ERROR, e.getMessage());
            LogUtil.logd("DxmPayWebviewActions", "openDxmpayWebview=" + e.getMessage());
            routerCallback.onResult(1, qw.qw(1, "url解析失败"));
        }
    }

    public void de(Context context, String str, String str2, RouterCallback routerCallback) {
        if (str.equals(EnterDxmPayServiceAction.DXMPAY_WEBVIEW_OPEN)) {
            StatisticManager.onEventWithValue(EnterDxmPayServiceAction.DXMPAY_WEBVIEW_OPEN, "");
            ad(context, str2, routerCallback);
        } else if (str.equals(EnterDxmPayServiceAction.DXMPAY_WEBVIEW_CLOSE)) {
            StatisticManager.onEventWithValue(EnterDxmPayServiceAction.DXMPAY_WEBVIEW_CLOSE, "");
            fe(routerCallback);
        }
    }

    public final void fe(RouterCallback routerCallback) {
        WebViewActivity.closeDxmpayWebviewActivity(routerCallback);
    }

    public void qw() {
        BdWalletUtils.putFunctionNameList(EnterDxmPayServiceAction.DXMPAY_WEBVIEW_OPEN, EnterDxmPayServiceAction.DXMPAY_WEBVIEW_CLOSE);
    }

    public ad() {
    }
}
