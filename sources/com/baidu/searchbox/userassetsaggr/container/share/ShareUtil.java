package com.baidu.searchbox.userassetsaggr.container.share;

import android.app.Activity;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.boxshare.BoxShareManager;
import com.baidu.searchbox.boxshare.listener.OnBoxShareListenerAdapter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.userassetsaggr.container.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002\u001a(\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"SHARE_ERROR_CODE_CHECK_INVALID", "", "SHARE_ERROR_INFO_CHECK_INVALID", "", "getMissingUrlUBCExt", "shareModel", "Lcom/baidu/searchbox/userassetsaggr/container/share/ShareModel;", "getShareUBCExt", "handleCheckFail", "", "listener", "Lcom/baidu/searchbox/boxshare/listener/OnBoxShareListenerAdapter;", "shareUrl", "Lcom/baidu/searchbox/boxshare/BoxShareManager;", "activity", "Landroid/app/Activity;", "lib-favorHis-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareUtil.kt */
public final class ShareUtil {
    public static final int SHARE_ERROR_CODE_CHECK_INVALID = -1;
    public static final String SHARE_ERROR_INFO_CHECK_INVALID = "check_invalid";

    public static final BoxShareManager shareUrl(Activity activity, ShareModel shareModel) {
        Intrinsics.checkNotNullParameter(shareModel, "shareModel");
        return shareUrl$default(activity, shareModel, (OnBoxShareListenerAdapter) null, 4, (Object) null);
    }

    public static /* synthetic */ BoxShareManager shareUrl$default(Activity activity, ShareModel shareModel, OnBoxShareListenerAdapter onBoxShareListenerAdapter, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            onBoxShareListenerAdapter = null;
        }
        return shareUrl(activity, shareModel, onBoxShareListenerAdapter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r0 = r10.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.baidu.searchbox.boxshare.BoxShareManager shareUrl(android.app.Activity r10, com.baidu.searchbox.userassetsaggr.container.share.ShareModel r11, com.baidu.searchbox.boxshare.listener.OnBoxShareListenerAdapter r12) {
        /*
            java.lang.String r0 = "shareModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = com.baidu.android.util.android.ActivityUtils.isDestroyed(r10)
            r1 = 0
            if (r0 == 0) goto L_0x0011
            handleCheckFail(r12)
            return r1
        L_0x0011:
            if (r10 == 0) goto L_0x001e
            android.view.Window r0 = r10.getWindow()
            if (r0 == 0) goto L_0x001e
            android.view.View r0 = r0.getDecorView()
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            if (r0 != 0) goto L_0x0025
            handleCheckFail(r12)
            return r1
        L_0x0025:
            java.lang.String r2 = r11.getLinkUrl()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0038
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r2 = r4
            goto L_0x0039
        L_0x0038:
            r2 = r3
        L_0x0039:
            if (r2 != 0) goto L_0x00c7
            java.lang.String r2 = r11.getLinkUrl()
            java.lang.String r5 = "https"
            r6 = 2
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r2, r5, r4, r6, r1)
            if (r2 != 0) goto L_0x0055
            java.lang.String r2 = r11.getLinkUrl()
            java.lang.String r5 = "http"
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r2, r5, r4, r6, r1)
            if (r2 != 0) goto L_0x0055
            goto L_0x00c7
        L_0x0055:
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = new com.baidu.searchbox.boxshare.bean.ShareContent$Builder
            r1.<init>()
            java.lang.String r2 = r11.getTitle()
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = r1.setTitle(r2)
            java.lang.String r2 = r11.getContent()
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = r1.setContent(r2)
            java.lang.String r2 = r11.getLinkUrl()
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = r1.setLinkUrl(r2)
            java.lang.String r2 = "baiduhi"
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = r1.addRemoveMenuItem(r2)
            java.lang.String r2 = "baidu_friend"
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = r1.addRemoveMenuItem(r2)
            java.lang.String r2 = r11.getImageUrl()
            com.baidu.searchbox.boxshare.bean.ShareContent$Builder r1 = r1.setIconUrl(r2)
            com.baidu.searchbox.userassetsaggr.container.classify.ClassifyDataManager r2 = com.baidu.searchbox.userassetsaggr.container.classify.ClassifyDataManager.INSTANCE
            com.baidu.searchbox.userassetsaggr.container.classify.ClassifyViewPage r4 = r11.getPage()
            java.lang.String r5 = r11.getTplId()
            boolean r2 = r2.isVideoClassify(r4, r5)
            if (r2 == 0) goto L_0x00a3
            java.lang.String r2 = r11.getLinkUrl()
            r1.setVideoUrl(r2)
            r2 = 4
            r1.setShareType(r2)
            goto L_0x00a6
        L_0x00a3:
            r1.setShareType(r3)
        L_0x00a6:
            java.lang.String r2 = r11.getUbcSource()
            r1.setSource(r2)
            java.lang.String r2 = getShareUBCExt(r11)
            r1.setCategoryInfo(r2)
            com.baidu.pyramid.runtime.service.ServiceReference r2 = com.baidu.searchbox.boxshare.BoxShareManager.SERVICE_REFERENCE
            java.lang.Object r2 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r2)
            com.baidu.searchbox.boxshare.BoxShareManager r2 = (com.baidu.searchbox.boxshare.BoxShareManager) r2
            r2.setOnBoxShareListener(r12)
            com.baidu.searchbox.boxshare.bean.ShareContent r3 = r1.create()
            r2.share(r10, r0, r3)
            return r2
        L_0x00c7:
            java.lang.String r9 = getMissingUrlUBCExt(r11)
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = "share_fail"
            java.lang.String r8 = ""
            com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc.event(r4, r5, r6, r7, r8, r9)
            handleCheckFail(r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.userassetsaggr.container.share.ShareUtil.shareUrl(android.app.Activity, com.baidu.searchbox.userassetsaggr.container.share.ShareModel, com.baidu.searchbox.boxshare.listener.OnBoxShareListenerAdapter):com.baidu.searchbox.boxshare.BoxShareManager");
    }

    private static final String getShareUBCExt(ShareModel shareModel) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject ubcExt = new JSONObject();
            ubcExt.put("nid", shareModel.getUbcNid());
            obj = Result.m8971constructorimpl(ubcExt.toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    private static final String getMissingUrlUBCExt(ShareModel shareModel) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject ubcExt = new JSONObject();
            ubcExt.put("ukey", shareModel.getUbcNid());
            ubcExt.put("title", shareModel.getTitle());
            ubcExt.put("tplid", shareModel.getTplId());
            obj = Result.m8971constructorimpl(ubcExt.toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    static /* synthetic */ void handleCheckFail$default(OnBoxShareListenerAdapter onBoxShareListenerAdapter, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            onBoxShareListenerAdapter = null;
        }
        handleCheckFail(onBoxShareListenerAdapter);
    }

    private static final void handleCheckFail(OnBoxShareListenerAdapter listener) {
        UniversalToast.makeText(AppRuntime.getAppContext()).setText(AppRuntime.getAppContext().getResources().getString(R.string.user_assets_share_fail_tip)).show();
        if (listener != null) {
            listener.onFail(-1, SHARE_ERROR_INFO_CHECK_INVALID);
        }
    }
}
