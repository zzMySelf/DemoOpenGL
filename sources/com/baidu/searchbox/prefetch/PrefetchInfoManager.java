package com.baidu.searchbox.prefetch;

import com.baidu.nadcore.tool.NadTool;
import com.baidu.searchbox.ad.lightbrowser.debugview.AdditionalDebugInfo;
import com.baidu.searchbox.ad.lightbrowser.debugview.IPrefetchInfoManager;
import com.baidu.searchbox.ad.lightbrowser.debugview.SplashAdditionalInfo;
import com.baidu.searchbox.ad.lightbrowser.splash.SplashConfig;
import com.baidu.searchbox.feed.ad.IPrefetchDebugView;
import com.baidu.searchbox.feed.ad.IPrefetchHtmlSwitch;
import java.text.DecimalFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/prefetch/PrefetchInfoManager;", "Lcom/baidu/searchbox/ad/lightbrowser/debugview/IPrefetchInfoManager;", "()V", "mAdditionalInfo", "Lcom/baidu/searchbox/ad/lightbrowser/debugview/SplashAdditionalInfo;", "getFeedPrefetchInfo", "", "getPrefetchInfo", "pageType", "", "additionalInfo", "Lcom/baidu/searchbox/ad/lightbrowser/debugview/AdditionalDebugInfo;", "getSplashPrefetchInfo", "ifNeedShowDebugView", "", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrefetchInfoManager.kt */
public final class PrefetchInfoManager implements IPrefetchInfoManager {
    private SplashAdditionalInfo mAdditionalInfo;

    public String getPrefetchInfo(int pageType, AdditionalDebugInfo additionalInfo) {
        if (additionalInfo instanceof SplashAdditionalInfo) {
            this.mAdditionalInfo = (SplashAdditionalInfo) additionalInfo;
        }
        switch (pageType) {
            case 0:
                return getFeedPrefetchInfo();
            case 1:
                return getSplashPrefetchInfo();
            default:
                return "";
        }
    }

    public boolean ifNeedShowDebugView() {
        IPrefetchDebugView iPrefetchDebugView = (IPrefetchDebugView) NadTool.get().select(IPrefetchDebugView.class);
        if (iPrefetchDebugView != null) {
            return iPrefetchDebugView.getPrefetchDebugViewSwitch();
        }
        return false;
    }

    private final String getSplashPrefetchInfo() {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$getSplashPrefetchInfo_u24lambda_u2d0 = sb;
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(" -- html：");
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(SplashConfig.getInstance().shouldPreloadHtml());
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(" -- 命中 ：%b");
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append("\n");
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(" -- 资源：");
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(SplashConfig.getInstance().shouldPreloadSource());
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(" -- 总数：");
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(SplashConfig.getInstance().getLocalResourceList().size());
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(" -- 命中数：%d");
        $this$getSplashPrefetchInfo_u24lambda_u2d0.append(" -- 命中率：%s");
        String formatStr = sb.toString();
        Intrinsics.checkNotNullExpressionValue(formatStr, "StringBuilder().apply {\n…%s\")\n        }.toString()");
        boolean isHtmlSuccess = false;
        Object sourceSuccessRateStr = "";
        int sourceCount = 0;
        SplashAdditionalInfo it = this.mAdditionalInfo;
        if (it != null) {
            isHtmlSuccess = SplashConfig.getInstance().isHtmlLocalFromLocal() == 1;
            Object format = new DecimalFormat("0.00%").format(((double) it.getSuccessSourceSize()) / ((double) it.getLocalSourceSize()));
            Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(\"0.00%\").format(sourceSuccessRate)");
            sourceSuccessRateStr = format;
            sourceCount = it.getLocalSourceSize();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format(formatStr, Arrays.copyOf(new Object[]{Boolean.valueOf(isHtmlSuccess), Integer.valueOf(sourceCount), sourceSuccessRateStr}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    private final String getFeedPrefetchInfo() {
        Pair pair;
        IPrefetchHtmlSwitch $this$getFeedPrefetchInfo_u24lambda_u2d2 = (IPrefetchHtmlSwitch) NadTool.get().select(IPrefetchHtmlSwitch.class);
        if ($this$getFeedPrefetchInfo_u24lambda_u2d2 != null) {
            pair = new Pair(Boolean.valueOf($this$getFeedPrefetchInfo_u24lambda_u2d2.getPrefetchHtmlSwitch()), Boolean.valueOf($this$getFeedPrefetchInfo_u24lambda_u2d2.getPrefetchHtmlResult()));
        } else {
            pair = new Pair(true, false);
        }
        Pair pair2 = pair;
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$getFeedPrefetchInfo_u24lambda_u2d4 = sb;
        $this$getFeedPrefetchInfo_u24lambda_u2d4.append("是否打开预加载开关：" + ((Boolean) pair2.getFirst()).booleanValue());
        $this$getFeedPrefetchInfo_u24lambda_u2d4.append("\n是否预加载：" + ((Boolean) pair2.getSecond()).booleanValue());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…d}\")\n        }.toString()");
        return sb2;
    }
}
