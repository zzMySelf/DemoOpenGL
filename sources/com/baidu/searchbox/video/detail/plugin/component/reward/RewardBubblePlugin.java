package com.baidu.searchbox.video.detail.plugin.component.reward;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.reward.BoxRewardManager;
import com.baidu.searchbox.reward.OnGuideListener;
import com.baidu.searchbox.video.detail.core.plugin.PluginAdapter;
import com.baidu.searchbox.video.detail.export.IVideoUiThreadUtils;
import com.baidu.searchbox.video.detail.plugin.component.author.model.AuthorModel;
import com.baidu.searchbox.video.detail.plugin.component.reward.service.IRewardBubbleService;
import com.baidu.searchbox.video.detail.plugin.component.reward.service.RewardBubbleService;
import com.baidu.searchbox.video.detail.plugin.component.right.model.ButtonType;
import com.baidu.searchbox.video.detail.plugin.component.right.model.VideoDetailInfoModel;
import com.baidu.searchbox.video.detail.plugin.component.right.service.IDetailModelService;
import com.baidu.searchbox.video.detail.plugin.component.right.ui.VideoDetailDownloadView;
import com.baidu.searchbox.video.detail.plugin.service.IDownloadInnerService;
import com.baidu.searchbox.video.detail.plugin.service.author.IAuthorService;
import com.baidu.searchbox.video.detail.service.IPlayerService;
import com.baidu.searchbox.video.detail.utils.VideoDetailGuideManager;
import com.baidu.searchbox.video.widget.RewardPopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J2\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0002J4\u0010$\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/reward/RewardBubblePlugin;", "Lcom/baidu/searchbox/video/detail/core/plugin/PluginAdapter;", "()V", "hasRequested", "", "lastDismissTime", "", "rewardPopupWindow", "Lcom/baidu/searchbox/video/widget/RewardPopupWindow;", "getRewardPopupWindow", "()Lcom/baidu/searchbox/video/widget/RewardPopupWindow;", "rewardPopupWindow$delegate", "Lkotlin/Lazy;", "dismissRewardBubble", "", "getDetailModel", "Lcom/baidu/searchbox/video/detail/plugin/component/right/model/VideoDetailInfoModel;", "getDisplayPercent", "", "handleMessage", "message", "Landroid/os/Message;", "injectService", "onCreate", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "showRewardBubble", "anchorView", "Landroid/view/View;", "toast", "", "rightEmojiID", "xOff", "yOff", "showRewardBubbleIfNeed", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardBubblePlugin.kt */
public final class RewardBubblePlugin extends PluginAdapter {
    private boolean hasRequested;
    private long lastDismissTime;
    private final Lazy rewardPopupWindow$delegate = LazyKt.lazy(new RewardBubblePlugin$rewardPopupWindow$2(this));

    private final RewardPopupWindow getRewardPopupWindow() {
        return (RewardPopupWindow) this.rewardPopupWindow$delegate.getValue();
    }

    public void onCreate() {
        super.onCreate();
        this.hasRequested = false;
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        this.hasRequested = false;
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(IRewardBubbleService.class, new RewardBubbleService(this));
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.LinearLayout] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            if (r7 != 0) goto L_0x0007
            return
        L_0x0007:
            int r0 = r7.what
            r1 = 7936(0x1f00, float:1.1121E-41)
            r2 = 0
            if (r0 != r1) goto L_0x00c1
            int r0 = r7.arg1
            r1 = 7937(0x1f01, float:1.1122E-41)
            if (r0 != r1) goto L_0x00b7
            int r8 = r7.arg2
            java.lang.Object r0 = r7.obj
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x001f
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0020
        L_0x001f:
            r0 = r2
        L_0x0020:
            r1 = 0
            if (r0 == 0) goto L_0x0028
            int r0 = r0.intValue()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            r9 = r0
            if (r8 <= 0) goto L_0x012a
            if (r9 <= 0) goto L_0x012a
            r0 = 1120403456(0x42c80000, float:100.0)
            float r3 = (float) r8
            float r3 = r3 * r0
            float r0 = (float) r9
            float r10 = r3 / r0
            int r11 = r17.getDisplayPercent()
            com.baidu.searchbox.video.detail.core.ComponentManager r0 = r6.mComponentManager
            java.lang.Class<com.baidu.searchbox.video.detail.service.IRightService> r3 = com.baidu.searchbox.video.detail.service.IRightService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r3)
            com.baidu.searchbox.video.detail.service.IRightService r0 = (com.baidu.searchbox.video.detail.service.IRightService) r0
            if (r0 == 0) goto L_0x004a
            android.view.View r0 = r0.getRootView()
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0052
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0053
        L_0x0052:
            r0 = r2
        L_0x0053:
            if (r0 != 0) goto L_0x0056
            return
        L_0x0056:
            r12 = r0
            r0 = 0
            r3 = 0
            int r4 = r12.getChildCount()
        L_0x005d:
            if (r3 >= r4) goto L_0x0080
            android.view.View r5 = r12.getChildAt(r3)
            boolean r5 = r5 instanceof com.baidu.searchbox.video.detail.plugin.component.right.ui.TopVideoInfoView
            if (r5 == 0) goto L_0x007d
            android.view.View r4 = r12.getChildAt(r3)
            if (r4 == 0) goto L_0x0075
            com.baidu.searchbox.video.detail.plugin.component.right.ui.TopVideoInfoView r4 = (com.baidu.searchbox.video.detail.plugin.component.right.ui.TopVideoInfoView) r4
            com.baidu.searchbox.video.detail.plugin.component.right.ui.TopInfoShareConfigLayout r0 = r4.getTopInfoShareConfigLayout()
            r13 = r0
            goto L_0x0081
        L_0x0075:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type com.baidu.searchbox.video.detail.plugin.component.right.ui.TopVideoInfoView"
            r1.<init>(r2)
            throw r1
        L_0x007d:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x0080:
            r13 = r0
        L_0x0081:
            if (r13 == 0) goto L_0x0089
            com.baidu.searchbox.video.detail.plugin.component.right.model.ButtonType r0 = com.baidu.searchbox.video.detail.plugin.component.right.model.ButtonType.REWARD
            android.widget.LinearLayout r2 = r13.getContainerByType(r0)
        L_0x0089:
            r14 = r2
            if (r13 == 0) goto L_0x0091
            boolean r0 = r13.isRewardButtonShowing()
            goto L_0x0092
        L_0x0091:
            r0 = r1
        L_0x0092:
            r15 = r0
            if (r13 == 0) goto L_0x0099
            boolean r1 = r13.isRewardButtonClicked()
        L_0x0099:
            r16 = r1
            if (r11 < 0) goto L_0x00b6
            float r0 = (float) r11
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00b6
            if (r15 == 0) goto L_0x00b6
            if (r16 == 0) goto L_0x00a7
            goto L_0x00b6
        L_0x00a7:
            r1 = r14
            android.view.View r1 = (android.view.View) r1
            r2 = 0
            int r3 = com.baidu.searchbox.video.detail.business.R.drawable.video_reward_peep
            r4 = 0
            r5 = 0
            r0 = r17
            r0.showRewardBubbleIfNeed(r1, r2, r3, r4, r5)
            goto L_0x012a
        L_0x00b6:
            return
        L_0x00b7:
            int r0 = r7.arg1
            r1 = 7938(0x1f02, float:1.1124E-41)
            if (r0 != r1) goto L_0x012a
            r17.dismissRewardBubble()
            goto L_0x012a
        L_0x00c1:
            int r0 = r7.what
            r1 = 40192(0x9d00, float:5.6321E-41)
            if (r0 != r1) goto L_0x011b
            int r0 = r7.arg1
            r1 = 40193(0x9d01, float:5.6322E-41)
            if (r0 != r1) goto L_0x012a
            com.baidu.searchbox.video.detail.core.ComponentManager r0 = r6.mComponentManager
            java.lang.Class<com.baidu.searchbox.video.detail.plugin.service.author.IAuthorService> r1 = com.baidu.searchbox.video.detail.plugin.service.author.IAuthorService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r1)
            com.baidu.searchbox.video.detail.plugin.service.author.IAuthorService r0 = (com.baidu.searchbox.video.detail.plugin.service.author.IAuthorService) r0
            if (r0 == 0) goto L_0x00e9
            com.baidu.searchbox.follow.view.AccountInfoAndFollowView r0 = r0.getAuthorView()
            if (r0 == 0) goto L_0x00e9
            android.view.View r0 = r0.getPortraitContainer()
            r1 = r0
            goto L_0x00ea
        L_0x00e9:
            r1 = r2
        L_0x00ea:
            java.lang.Object r0 = r7.obj
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x00f5
            java.lang.String r0 = (java.lang.String) r0
            r2 = r0
        L_0x00f5:
            int r3 = com.baidu.searchbox.video.detail.business.R.drawable.video_reward_pround
            android.content.Context r0 = r17.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r4 = com.baidu.searchbox.video.detail.business.R.dimen.dimen_4dp
            int r0 = r0.getDimensionPixelOffset(r4)
            int r4 = -r0
            android.content.Context r0 = r17.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r5 = com.baidu.searchbox.video.detail.business.R.dimen.dimen_4dp
            int r0 = r0.getDimensionPixelOffset(r5)
            int r5 = -r0
            r0 = r17
            r0.showRewardBubbleIfNeed(r1, r2, r3, r4, r5)
            goto L_0x012a
        L_0x011b:
            int r0 = r7.what
            r1 = 12032(0x2f00, float:1.686E-41)
            if (r0 != r1) goto L_0x012a
            int r0 = r7.arg1
            r1 = 12037(0x2f05, float:1.6867E-41)
            if (r0 != r1) goto L_0x012a
            r17.dismissRewardBubble()
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.detail.plugin.component.reward.RewardBubblePlugin.handleMessage(android.os.Message):void");
    }

    private final void showRewardBubbleIfNeed(View anchorView, String toast, int rightEmojiID, int xOff, int yOff) {
        String str;
        if (anchorView != null) {
            IPlayerService iPlayerService = (IPlayerService) this.mComponentManager.getService(IPlayerService.class);
            boolean z = false;
            if (!(iPlayerService != null && iPlayerService.isFullScreen()) && System.currentTimeMillis() - this.lastDismissTime >= TimeUnit.SECONDS.toMillis(1)) {
                CharSequence charSequence = toast;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z) {
                    showRewardBubble(anchorView, toast, rightEmojiID, xOff, yOff);
                } else if (!this.hasRequested && VideoDetailGuideManager.isGuideShowEnable()) {
                    this.hasRequested = true;
                    IAuthorService iAuthorService = (IAuthorService) this.mComponentManager.getService(IAuthorService.class);
                    String str2 = null;
                    AuthorModel authorModel = iAuthorService != null ? iAuthorService.getAuthorModel() : null;
                    IDownloadInnerService iDownloadInnerService = (IDownloadInnerService) this.mComponentManager.getService(IDownloadInnerService.class);
                    VideoDetailDownloadView.AppInfo appModel = iDownloadInnerService != null ? iDownloadInnerService.getAppModel() : null;
                    if (authorModel == null || (str = authorModel.mId) == null) {
                        str = appModel != null ? appModel.authorId : null;
                        if (str == null) {
                            str = "";
                        }
                    }
                    String authorId = str;
                    BoxRewardManager $this$showRewardBubbleIfNeed_u24lambda_u2d0 = (BoxRewardManager) ServiceManager.getService(BoxRewardManager.SERVICE_REFERENCE);
                    if ($this$showRewardBubbleIfNeed_u24lambda_u2d0 != null) {
                        Activity activity = (Activity) getContext();
                        OnGuideListener rewardBubblePlugin$showRewardBubbleIfNeed$1$1 = new RewardBubblePlugin$showRewardBubbleIfNeed$1$1($this$showRewardBubbleIfNeed_u24lambda_u2d0, this, anchorView, rightEmojiID, xOff, yOff);
                        VideoDetailInfoModel detailModel = getDetailModel();
                        if (detailModel != null) {
                            str2 = detailModel.mNid;
                        }
                        BoxRewardManager.DefaultImpls.guide$default($this$showRewardBubbleIfNeed_u24lambda_u2d0, activity, authorId, "feedvideo", "feedvideo_dashang", rewardBubblePlugin$showRewardBubbleIfNeed$1$1, str2, (String) null, 64, (Object) null);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showRewardBubble(View anchorView, String toast, int rightEmojiID, int xOff, int yOff) {
        IVideoUiThreadUtils.Impl.get().runOnUiThread(new RewardBubblePlugin$$ExternalSyntheticLambda0(toast, this, rightEmojiID, anchorView, xOff, yOff));
    }

    /* access modifiers changed from: private */
    /* renamed from: showRewardBubble$lambda-1  reason: not valid java name */
    public static final void m5378showRewardBubble$lambda1(String $toast, RewardBubblePlugin this$0, int $rightEmojiID, View $anchorView, int $xOff, int $yOff) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($anchorView, "$anchorView");
        CharSequence charSequence = $toast;
        if (!(charSequence == null || charSequence.length() == 0)) {
            this$0.getRewardPopupWindow().setContent($toast).setRightEmoji(ContextCompat.getDrawable(this$0.getContext(), $rightEmojiID)).showAsDropDown($anchorView, $xOff, $yOff);
        }
    }

    public final void dismissRewardBubble() {
        getRewardPopupWindow().dismiss();
        this.lastDismissTime = System.currentTimeMillis();
    }

    private final int getDisplayPercent() {
        VideoDetailInfoModel detailModel = getDetailModel();
        ArrayList interactBtnList = detailModel != null ? detailModel.mInteractBtnList : null;
        if (interactBtnList == null) {
            return -1;
        }
        Iterator<VideoDetailInfoModel.TopInfoInteractBtn> it = interactBtnList.iterator();
        while (it.hasNext()) {
            VideoDetailInfoModel.TopInfoInteractBtn btn = it.next();
            String name = ButtonType.REWARD.name();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual((Object) lowerCase, (Object) btn.mType)) {
                return btn.mDisplayPercent;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final VideoDetailInfoModel getDetailModel() {
        IDetailModelService iDetailModelService = (IDetailModelService) this.mComponentManager.getService(IDetailModelService.class);
        if (iDetailModelService != null) {
            return iDetailModelService.getDetailModel();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        getRewardPopupWindow().removeCallbacks();
    }
}
