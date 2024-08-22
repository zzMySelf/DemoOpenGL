package com.baidu.searchbox.feed.widget.feedflow;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.searchbox.feed.ioc.IFeedShare;
import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.template.statistic.FeedTemplateStatTable;
import com.baidu.searchbox.feed.template.statistic.IFeedTemplateStatistics;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.feed.util.FeedShareWrapper;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.lang.ref.WeakReference;

public class FeedForwardPopViewBuilder {
    public static final String COMMENT_FORWARD = "forward";
    public static final String DISLIKE_ACTION = "dislike";
    public static final String FAST_FORWARD = "akeyforward";
    public static final String RECOMMEND = "trusted";
    public static final String SHARE_MENU = "share";
    public FeedForwardPopupView feedForwardPopupView;
    /* access modifiers changed from: private */
    public FeedBaseModel mBaseModel;
    /* access modifiers changed from: private */
    public String mChannelId;
    protected final WeakReference<Context> mContextRef;
    /* access modifiers changed from: private */
    public String mExt;
    /* access modifiers changed from: private */
    public String mNid;
    /* access modifiers changed from: private */
    public final IPopView mPopupWindow;
    private boolean mRecommendLock = true;
    /* access modifiers changed from: private */
    public FeedBar.Trinity mTrinity;
    /* access modifiers changed from: private */
    public String mUbcFrom;
    /* access modifiers changed from: private */
    public String mUbcSource;

    public interface IPopView {
        void dismiss();

        boolean isShowing();

        void setHeight(int i2);

        void setWidth(int i2);

        void show(View view2);

        void show(int[] iArr);
    }

    public FeedForwardPopViewBuilder(Context context, FeedBar.Trinity trinity) {
        this.mContextRef = new WeakReference<>(context);
        this.mTrinity = trinity;
        this.mPopupWindow = buildPopup();
    }

    public void show(View anchorView) {
        IPopView iPopView = this.mPopupWindow;
        if (iPopView != null) {
            iPopView.show(anchorView);
            updateUi();
        }
    }

    public void show(int[] anchorPosition) {
        IPopView iPopView = this.mPopupWindow;
        if (iPopView != null) {
            iPopView.show(anchorPosition);
            updateUi();
        }
    }

    private void updateUi() {
        setFastForwardButton();
        setCommentForwardButton();
        setShareMenuButton();
    }

    public void setUbcParams(String source, String nid, String from, String ext) {
        this.mUbcSource = source;
        this.mNid = nid;
        this.mUbcFrom = from;
        if (!TextUtils.isEmpty(ext)) {
            this.mExt = ext;
        }
    }

    public void setFeedBaseModel(FeedBaseModel baseModel) {
        if (baseModel != null) {
            this.mBaseModel = baseModel;
            this.mChannelId = baseModel.runtimeStatus.channelId;
        }
    }

    public void dismiss() {
        IPopView iPopView = this.mPopupWindow;
        if (iPopView != null && iPopView.isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    public void setFastForwardButton() {
        final Context context = (Context) this.mContextRef.get();
        if (context != null && this.mTrinity.fastForward != null) {
            if (!TextUtils.isEmpty(this.mTrinity.fastForward.text)) {
                this.feedForwardPopupView.fastForwardText.setText(this.mTrinity.fastForward.text);
            }
            this.feedForwardPopupView.fastForwardButton.setOnClickListener(new FastClickListener() {
                public void doOnClick(View view2) {
                    if (FeedForwardPopViewBuilder.this.mTrinity.fastForward != null && UnitedSchemeUtility.isUnitedScheme(FeedForwardPopViewBuilder.this.mTrinity.fastForward.schema)) {
                        FeedRouter.invoke(context, FeedForwardPopViewBuilder.this.mTrinity.fastForward.schema, true);
                        IFeedTemplateStatistics feedTempStat = FeedTemplateStatTable.getInstance().get(FeedForwardPopViewBuilder.this.mChannelId);
                        if (feedTempStat != null) {
                            feedTempStat.feedForwardPopItemClick(FeedForwardPopViewBuilder.FAST_FORWARD, FeedForwardPopViewBuilder.this.mUbcSource, FeedForwardPopViewBuilder.this.mNid, FeedForwardPopViewBuilder.this.mUbcFrom, FeedForwardPopViewBuilder.this.mExt, FeedForwardPopViewBuilder.this.mBaseModel);
                        }
                        FeedForwardPopViewBuilder.this.mPopupWindow.dismiss();
                    }
                }
            });
            this.feedForwardPopupView.fastForwardButton.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case 0:
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.fastForwardButton.setAlpha(0.2f);
                            return false;
                        case 1:
                        case 3:
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.fastForwardButton.setAlpha(1.0f);
                            return false;
                        default:
                            return false;
                    }
                }
            });
        }
    }

    public void setCommentForwardButton() {
        final Context context = (Context) this.mContextRef.get();
        if (context != null && this.mTrinity.forward != null) {
            if (!TextUtils.isEmpty(this.mTrinity.forward.text)) {
                this.feedForwardPopupView.forwardText.setText(this.mTrinity.forward.text);
            }
            this.feedForwardPopupView.forwardButton.setOnClickListener(new FastClickListener() {
                public void doOnClick(View v) {
                    String scheme = FeedForwardPopViewBuilder.this.mTrinity.forward.schema;
                    if (UnitedSchemeUtility.isUnitedScheme(scheme)) {
                        FeedRouter.invoke(context, scheme, true);
                        IFeedTemplateStatistics feedTempStat = FeedTemplateStatTable.getInstance().get(FeedForwardPopViewBuilder.this.mChannelId);
                        if (feedTempStat != null) {
                            feedTempStat.feedForwardPopItemClick("forward", FeedForwardPopViewBuilder.this.mUbcSource, FeedForwardPopViewBuilder.this.mNid, FeedForwardPopViewBuilder.this.mUbcFrom, FeedForwardPopViewBuilder.this.mExt, FeedForwardPopViewBuilder.this.mBaseModel);
                        }
                        FeedForwardPopViewBuilder.this.mPopupWindow.dismiss();
                    }
                }
            });
            this.feedForwardPopupView.forwardButton.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case 0:
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.forwardText.setAlpha(0.2f);
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.commentForwardIcon.setAlpha(0.2f);
                            return false;
                        case 1:
                        case 3:
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.forwardText.setAlpha(1.0f);
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.commentForwardIcon.setAlpha(1.0f);
                            return false;
                        default:
                            return false;
                    }
                }
            });
        }
    }

    public void setShareMenuButton() {
        final Context context = (Context) this.mContextRef.get();
        if (context != null && this.mTrinity.share != null) {
            if (!TextUtils.isEmpty(this.mTrinity.share.text)) {
                this.feedForwardPopupView.shareText.setText(this.mTrinity.share.text);
            }
            this.feedForwardPopupView.shareButton.setOnClickListener(new FastClickListener() {
                public void doOnClick(View v) {
                    FeedShareWrapper.callNativeShare(context, FeedForwardPopViewBuilder.this.mTrinity.share.url, FeedForwardPopViewBuilder.this.mTrinity.share.iconUrl, FeedForwardPopViewBuilder.this.mTrinity.share.title, FeedForwardPopViewBuilder.this.mTrinity.share.forwardSchema, (IFeedShare.IOnChildItemClickListener) null, FeedForwardPopViewBuilder.this.mNid);
                    IFeedTemplateStatistics feedTempStat = FeedTemplateStatTable.getInstance().get(FeedForwardPopViewBuilder.this.mChannelId);
                    if (feedTempStat != null) {
                        feedTempStat.feedForwardPopItemClick("share", FeedForwardPopViewBuilder.this.mUbcSource, FeedForwardPopViewBuilder.this.mNid, FeedForwardPopViewBuilder.this.mUbcFrom, FeedForwardPopViewBuilder.this.mExt, FeedForwardPopViewBuilder.this.mBaseModel);
                    }
                    FeedForwardPopViewBuilder.this.mPopupWindow.dismiss();
                }
            });
            this.feedForwardPopupView.shareButton.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case 0:
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.shareText.setAlpha(0.2f);
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.shareIcon.setAlpha(0.2f);
                            return false;
                        case 1:
                        case 3:
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.shareText.setAlpha(1.0f);
                            FeedForwardPopViewBuilder.this.feedForwardPopupView.shareIcon.setAlpha(1.0f);
                            return false;
                        default:
                            return false;
                    }
                }
            });
        }
    }

    public boolean isShowing() {
        IPopView iPopView = this.mPopupWindow;
        return iPopView != null && iPopView.isShowing();
    }

    public IPopView buildPopup() {
        Context ctx = (Context) this.mContextRef.get();
        if (ctx == null) {
            return null;
        }
        FeedForwardPopupView feedForwardPopupView2 = new FeedForwardPopupView(ctx);
        this.feedForwardPopupView = feedForwardPopupView2;
        return feedForwardPopupView2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        FeedForwardPopupView feedForwardPopupView2 = this.feedForwardPopupView;
        if (feedForwardPopupView2 != null) {
            feedForwardPopupView2.setOuterOnDismissListener(onDismissListener);
        }
    }
}
