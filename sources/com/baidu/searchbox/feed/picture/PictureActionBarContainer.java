package com.baidu.searchbox.feed.picture;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.datachannel.Registry;
import com.baidu.searchbox.feed.PictureBaseActivity;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.model.FeedPhotoModel;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.picture.PictureActionBar;
import com.baidu.searchbox.feed.picture.interfaces.IView;
import com.baidu.searchbox.feed.utils.PictureJsonUtils;
import com.baidu.searchbox.feed.widget.FeedBubbleManager;
import com.baidu.searchbox.lightbrowser.model.BaseDislikeData;
import com.baidu.searchbox.lightbrowser.model.PageReportData;
import com.baidu.searchbox.picture.R;

public class PictureActionBarContainer {
    /* access modifiers changed from: private */
    public boolean mCloseLiveAni = false;
    private DislikeListener mDislikeListener;
    /* access modifiers changed from: private */
    public Activity mHostActivity;
    private boolean mIsPolitical = false;
    private FeedPhotoModel mModel;
    private PageReportData mPageReportData;
    private PictureActionBar mPictureActionBar;
    private String mSlog;

    public interface DislikeListener {
        boolean handleDislike();
    }

    public View onCreateView(Activity activity, ViewGroup viewGroup) {
        return onCreateView(activity, viewGroup, 0);
    }

    public View onCreateView(Activity activity, ViewGroup viewGroup, int barStyle) {
        this.mHostActivity = activity;
        PictureActionBar pictureActionBar = new PictureActionBar((Context) activity, barStyle);
        this.mPictureActionBar = pictureActionBar;
        pictureActionBar.setOnButtonClickListener(new OnButtonClickListenerImpl());
        if (viewGroup != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            viewGroup.addView(this.mPictureActionBar, layoutParams);
        }
        if (activity instanceof PictureBaseActivity) {
            Registry.registerNAReceiver((String) null, (String) null, "com.baidu.channel.feed.assistmessage", new NAReceiverCallback() {
                public void onReceive(String action, String params) {
                    boolean unused = PictureActionBarContainer.this.mCloseLiveAni = PictureJsonUtils.processExtraInfoParse(params);
                }
            });
        }
        return this.mPictureActionBar;
    }

    public void onNightModeChanged(boolean isNightMode) {
        PictureActionBar pictureActionBar = this.mPictureActionBar;
        if (pictureActionBar != null) {
            pictureActionBar.onNightModeChanged(isNightMode);
        }
    }

    public void onDestroy() {
        PictureActionBar pictureActionBar = this.mPictureActionBar;
        if (pictureActionBar != null) {
            pictureActionBar.getUserInfoView().releaseLiveAni();
        }
        Registry.unregisterReceiver((String) null, (String) null, "com.baidu.channel.feed.assistmessage");
    }

    public void updateView(FeedPhotoModel data) {
        if (data != null) {
            this.mModel = data;
            this.mPictureActionBar.configBjhView(data);
            configPoliticalView();
            this.mPageReportData = data.reportData;
            FeedBubbleManager.getInstance().showBubbleIfNeeded(this.mPictureActionBar.findViewById(R.id.picture_menu_button));
        }
    }

    private void configPoliticalView() {
        if (this.mModel.isPolitical || this.mIsPolitical) {
            this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_DISLIKE, 8);
            this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_FEEDBACK, 8);
        }
    }

    /* access modifiers changed from: private */
    public void openMenu() {
        Activity activity = this.mHostActivity;
        if (activity instanceof IView) {
            ((IView) activity).openToolbarMenu();
        }
    }

    /* access modifiers changed from: private */
    public void openBjh() {
        FeedPhotoModel feedPhotoModel = this.mModel;
        if (feedPhotoModel != null) {
            Router.invoke(this.mHostActivity, feedPhotoModel.bjhCmd);
            PictureStatisticUtil.openBjhStatistic(this.mModel.nid, this.mModel.bjhId, this.mSlog);
            Activity activity = this.mHostActivity;
            if (activity instanceof IView) {
                IView iview = (IView) activity;
                PictureStatisticUtil.endPerformanceFlow(activity, this.mModel.nid, iview.getFirstUrl(), this.mSlog);
                iview.setEndFlowFlag(true);
                PictureStatisticUtil.startPerformanceFlow();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = com.baidu.searchbox.lightbrowser.model.BaseDislikeData.convert(r10.mModel.dislikeData, r10.mModel.nid, r10.mModel.tabId, r10.mModel.dislikeExt);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doDislike() {
        /*
            r10 = this;
            com.baidu.searchbox.feed.model.FeedPhotoModel r0 = r10.mModel
            if (r0 == 0) goto L_0x0049
            com.baidu.searchbox.feed.picture.PictureActionBar r0 = r10.mPictureActionBar
            if (r0 != 0) goto L_0x0009
            goto L_0x0049
        L_0x0009:
            com.baidu.searchbox.feed.picture.PictureActionBarContainer$DislikeListener r0 = r10.mDislikeListener
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.handleDislike()
            if (r0 == 0) goto L_0x0014
            return
        L_0x0014:
            com.baidu.searchbox.feed.model.FeedPhotoModel r0 = r10.mModel
            com.baidu.searchbox.lightbrowser.model.BaseDislikeData r0 = r0.dislikeData
            com.baidu.searchbox.feed.model.FeedPhotoModel r1 = r10.mModel
            java.lang.String r1 = r1.nid
            com.baidu.searchbox.feed.model.FeedPhotoModel r2 = r10.mModel
            java.lang.String r2 = r2.tabId
            com.baidu.searchbox.feed.model.FeedPhotoModel r3 = r10.mModel
            java.lang.String r3 = r3.dislikeExt
            com.baidu.searchbox.lightbrowser.model.PageBackData r0 = com.baidu.searchbox.lightbrowser.model.BaseDislikeData.convert(r0, r1, r2, r3)
            if (r0 == 0) goto L_0x0048
            android.app.Activity r1 = r10.mHostActivity
            android.content.Context r4 = r1.getApplicationContext()
            com.baidu.searchbox.feed.picture.PictureActionBar r5 = r10.mPictureActionBar
            r7 = 1
            com.baidu.searchbox.lightbrowser.model.PageReportData r1 = r10.mPageReportData
            if (r1 == 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            r8 = r1
            com.baidu.searchbox.feed.picture.PictureActionBarContainer$2 r9 = new com.baidu.searchbox.feed.picture.PictureActionBarContainer$2
            r9.<init>(r0)
            r6 = r0
            com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop r1 = com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop.makePopUp((android.content.Context) r4, (android.view.View) r5, (com.baidu.searchbox.lightbrowser.model.PageBackData) r6, (boolean) r7, (boolean) r8, (com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop.NotInterestCallback) r9)
            r1.show()
        L_0x0048:
            return
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.picture.PictureActionBarContainer.doDislike():void");
    }

    /* access modifiers changed from: private */
    public void doFeedBack() {
        FeedPhotoModel feedPhotoModel = this.mModel;
        if (feedPhotoModel != null && this.mPictureActionBar != null && BaseDislikeData.convert(feedPhotoModel.dislikeData, this.mModel.nid, this.mModel.tabId, this.mModel.dislikeExt) != null) {
            ((IView) this.mHostActivity).processDislikeReport("feedback");
        }
    }

    public void setActionBarStatus(int mode) {
        configTopPictureActionBar((mode & 16) == 16);
        if ((mode & 16) == 16 && (mode & 8) != 8) {
            this.mPictureActionBar.setVisibility(0);
        } else if ((mode & 2) == 2 || (mode & 1) == 1 || (mode & 8) == 8 || (mode & 32) == 32) {
            this.mPictureActionBar.setVisibility(8);
        } else {
            this.mPictureActionBar.setVisibility(0);
        }
    }

    public void resetPictureActionBarStatus(int mode) {
        if (this.mPictureActionBar.getAlpha() >= 1.0f) {
            return;
        }
        if ((mode & 2) == 2 || (mode & 32) == 32) {
            this.mPictureActionBar.setVisibility(8);
            return;
        }
        this.mPictureActionBar.setVisibility(0);
        this.mPictureActionBar.setAlpha(1.0f);
    }

    public void setActionBarAlpha(float alpha) {
        if (this.mPictureActionBar.getVisibility() == 0) {
            this.mPictureActionBar.setAlpha(alpha);
        }
    }

    public void onResume() {
        updatePictureActionBarState();
    }

    public void updatePictureActionBarState() {
        LinkageData data;
        PictureActionBar pictureActionBar;
        FeedPhotoModel feedPhotoModel = this.mModel;
        if (!(feedPhotoModel == null || feedPhotoModel.feedFollowInfoModel == null || (data = FeedLinkageManager.getInstance("feed").queryFollowLinkageData(this.mModel.feedFollowInfoModel.mThirdId, this.mModel.feedFollowInfoModel.mType)) == null || (pictureActionBar = this.mPictureActionBar) == null)) {
            pictureActionBar.updateFollowState(data.status);
        }
        PictureActionBar pictureActionBar2 = this.mPictureActionBar;
        if (pictureActionBar2 != null && this.mCloseLiveAni) {
            pictureActionBar2.updateUserInfoStatus();
        }
    }

    private class OnButtonClickListenerImpl implements PictureActionBar.OnButtonClickListener {
        private OnButtonClickListenerImpl() {
        }

        public void onClick(PictureActionBar.ButtonType itemType) {
            switch (AnonymousClass3.$SwitchMap$com$baidu$searchbox$feed$picture$PictureActionBar$ButtonType[itemType.ordinal()]) {
                case 1:
                    PictureActionBarContainer.this.openBjh();
                    return;
                case 2:
                    PictureActionBarContainer.this.doDislike();
                    return;
                case 3:
                    PictureActionBarContainer.this.openMenu();
                    return;
                case 4:
                    PictureActionBarContainer.this.doFeedBack();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.searchbox.feed.picture.PictureActionBarContainer$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$feed$picture$PictureActionBar$ButtonType;

        static {
            int[] iArr = new int[PictureActionBar.ButtonType.values().length];
            $SwitchMap$com$baidu$searchbox$feed$picture$PictureActionBar$ButtonType = iArr;
            try {
                iArr[PictureActionBar.ButtonType.TYPE_BJH.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$picture$PictureActionBar$ButtonType[PictureActionBar.ButtonType.TYPE_DISLIKE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$picture$PictureActionBar$ButtonType[PictureActionBar.ButtonType.TYPE_MENU.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feed$picture$PictureActionBar$ButtonType[PictureActionBar.ButtonType.TYPE_FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public void configTopPictureActionBar(boolean isAd) {
        PictureActionBar pictureActionBar = this.mPictureActionBar;
        if (pictureActionBar != null) {
            int i2 = 4;
            pictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_BJH, isAd ? 4 : 0);
            PictureActionBar pictureActionBar2 = this.mPictureActionBar;
            PictureActionBar.ButtonType buttonType = PictureActionBar.ButtonType.TYPE_FOLLOW;
            if (!isAd) {
                i2 = 0;
            }
            pictureActionBar2.setContentVisibility(buttonType, i2);
            this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_MENU, 0);
            FeedPhotoModel feedPhotoModel = this.mModel;
            if ((feedPhotoModel == null || !feedPhotoModel.isPolitical) && !this.mIsPolitical) {
                this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_FEEDBACK, 0);
                this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_DISLIKE, 0);
                return;
            }
            this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_DISLIKE, 8);
            this.mPictureActionBar.setContentVisibility(PictureActionBar.ButtonType.TYPE_FEEDBACK, 8);
        }
    }

    public void setDislikeListener(DislikeListener dislikeListener) {
        this.mDislikeListener = dislikeListener;
    }

    public void setSlog(String slog) {
        this.mSlog = slog;
    }

    public void setIsPolitical(boolean isPolitical) {
        this.mIsPolitical = isPolitical;
    }

    public void setVisibility(boolean flag) {
        PictureActionBar pictureActionBar = this.mPictureActionBar;
        if (pictureActionBar != null) {
            pictureActionBar.setVisibility(flag ? 0 : 4);
        }
    }

    public FeedPhotoModel getModel() {
        return this.mModel;
    }
}
