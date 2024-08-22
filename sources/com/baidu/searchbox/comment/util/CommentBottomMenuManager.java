package com.baidu.searchbox.comment.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.menu.bottomlist.BottomCustomMenuItem;
import com.baidu.android.common.menu.bottomlist.BottomListMenu;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.definition.BDCommentRequestCallback;
import com.baidu.searchbox.comment.definition.OnLoginStatusListener;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.model.CommentOperationData;
import com.baidu.searchbox.comment.net.BDCommentRequest;
import com.baidu.searchbox.comment.richtext.RichTextFormatter;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.comment.statistic.UBCModel;
import com.baidu.searchbox.comment.utils.CommentLoginUtils;
import com.baidu.searchbox.comment.view.commentshare.CommentSharePosterModel;
import com.baidu.searchbox.comment.view.commentshare.CommentSharePosterView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentBottomMenuManager {
    private static final String ITEM_COPY_SEARCH = "copy_search";
    private static final String ITEM_SHARE = "share";
    private BottomListMenu mBottomListMenu;
    /* access modifiers changed from: private */
    public BottomCommonMenuItemUtils mBottomMenuUtils = new BottomCommonMenuItemUtils();
    private CommentModel mCommentModel;
    /* access modifiers changed from: private */
    public Activity mContext;
    private boolean mEnableSelectText = false;
    /* access modifiers changed from: private */
    public EventCallback mEventCallback;
    private boolean mHideAuthorFavor = false;
    private boolean mIsMine = false;
    private int mPosition;
    /* access modifiers changed from: private */
    public ShareData mShareData;
    private UBCModel mUbcModel;

    public interface EventCallback {
        void handleAuthorFavor(CommentModel commentModel, int i2, boolean z);

        void handleBeforeShare();

        void handleBlacklist(boolean z, String str);

        void handleDeleteComment(boolean z, String str);

        void handleSelectText(String str);

        void onMenuDismiss();
    }

    public void show(Context activity, boolean enableSelectText) {
        if (!(activity instanceof FragmentActivity)) {
            EventCallback eventCallback = this.mEventCallback;
            if (eventCallback != null) {
                eventCallback.onMenuDismiss();
                return;
            }
            return;
        }
        this.mContext = (Activity) activity;
        this.mEnableSelectText = enableSelectText;
        updateMenusAndShow();
        doUBCStatistic("menu_show");
    }

    /* access modifiers changed from: private */
    public void doItemClick(Object item) {
        if (item instanceof CommentOperationData.AuthorFavorItem) {
            handleAuthorFavor(((CommentOperationData.AuthorFavorItem) item).isFavor());
        } else if (item instanceof CommentOperationData.ReportItem) {
            handleReport((CommentOperationData.ReportItem) item);
        } else if (item instanceof CommentOperationData.BlacklistItem) {
            if (CommentLoginUtils.isLogin()) {
                String tip = ((CommentOperationData.BlacklistItem) item).getTip();
                boolean delReply = TextUtils.equals(((CommentOperationData.BlacklistItem) item).getDelReply(), "1");
                EventCallback eventCallback = this.mEventCallback;
                if (eventCallback != null) {
                    eventCallback.handleBlacklist(delReply, tip);
                }
            } else {
                CommentLoginUtils.loginStatusEvent(this.mContext, (OnLoginStatusListener) null, 3, 0);
            }
            doUBCStatistic(BDCommentStatisticHelper.COMMENT_BOTTOM_DIALOG_MENU_BLIST_CLK);
        } else if (item instanceof CommentOperationData.DeleteItem) {
            boolean isSelf = ((CommentOperationData.DeleteItem) item).isSelf();
            String tip2 = ((CommentOperationData.DeleteItem) item).getTip();
            EventCallback eventCallback2 = this.mEventCallback;
            if (eventCallback2 != null) {
                eventCallback2.handleDeleteComment(isSelf, tip2);
            }
            doUBCStatistic(BDCommentStatisticHelper.COMMENT_BOTTOM_DIALOG_MENU_DELETE_CLK);
        } else if (!(item instanceof String)) {
        } else {
            if (TextUtils.equals((String) item, "share")) {
                handleShare();
            } else if (TextUtils.equals((String) item, "copy_search")) {
                handleCopySearch();
            }
        }
    }

    private void updateMenusAndShow() {
        this.mBottomMenuUtils.clear();
        CommentModel commentModel = this.mCommentModel;
        if (commentModel == null || commentModel.isShowDefaultBottomMenu()) {
            addShareData();
            addCopySearchData();
            showBottomListMenu();
            return;
        }
        BDCommentRequest.getLongClickOperation(this.mContext, this.mCommentModel.getTopicId(), this.mCommentModel.getReplyId(), new BDCommentRequestCallback<CommentOperationData>() {
            public void onCompleted(int status, CommentOperationData result, String errMsg) {
                if (status != 0 || result == null || !TextUtils.equals(result.getErrno(), "0")) {
                    boolean unused = CommentBottomMenuManager.this.addShareData();
                    boolean unused2 = CommentBottomMenuManager.this.addCopySearchData();
                } else {
                    CommentOperationData.AuthorFavorItem authorFavorItem = result.getAuthorFavorItem();
                    if (!CommentBottomMenuManager.this.isHideAuthorFavor() && authorFavorItem != null && !TextUtils.isEmpty(authorFavorItem.getText())) {
                        CommentBottomMenuManager.this.mBottomMenuUtils.put(authorFavorItem.getText(), authorFavorItem);
                    }
                    boolean unused3 = CommentBottomMenuManager.this.addShareData();
                    boolean unused4 = CommentBottomMenuManager.this.addCopySearchData();
                    CommentOperationData.BlacklistItem blacklistItem = result.getBlacklistItem();
                    if (blacklistItem != null && !TextUtils.isEmpty(blacklistItem.getText())) {
                        CommentBottomMenuManager.this.mBottomMenuUtils.put(blacklistItem.getText(), blacklistItem);
                    }
                    CommentOperationData.ReportItem reportItem = result.getReportItem();
                    if (reportItem != null && !TextUtils.isEmpty(reportItem.getText())) {
                        CommentBottomMenuManager.this.mBottomMenuUtils.put(reportItem.getText(), reportItem);
                    }
                    CommentOperationData.DeleteItem deleteItem = result.getDeleteItem();
                    if (deleteItem != null && !TextUtils.isEmpty(deleteItem.getText())) {
                        CommentBottomMenuManager.this.mBottomMenuUtils.put(deleteItem.getText(), deleteItem);
                    }
                }
                CommentBottomMenuManager.this.showBottomListMenu();
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean addShareData() {
        CommentModel commentModel;
        if (BDCommentUtil.isTeenagerMode() || (commentModel = this.mCommentModel) == null || TextUtils.isEmpty(commentModel.getReplyId()) || this.mCommentModel.isPkComment()) {
            return false;
        }
        this.mBottomMenuUtils.put(CommentRuntime.getAppContext().getResources().getString(R.string.comment_long_click_dialog_share), "share");
        return true;
    }

    /* access modifiers changed from: private */
    public boolean addCopySearchData() {
        CommentModel commentModel = this.mCommentModel;
        if (commentModel != null && commentModel.isPkComment()) {
            return false;
        }
        this.mBottomMenuUtils.put(CommentRuntime.getAppContext().getResources().getString(R.string.comment_long_click_dialog_copy_search), "copy_search");
        return true;
    }

    /* access modifiers changed from: private */
    public void showBottomListMenu() {
        BottomCommonMenuItemUtils bottomCommonMenuItemUtils;
        if (this.mContext == null || (bottomCommonMenuItemUtils = this.mBottomMenuUtils) == null || !bottomCommonMenuItemUtils.checkArgs()) {
            EventCallback eventCallback = this.mEventCallback;
            if (eventCallback != null) {
                eventCallback.onMenuDismiss();
                return;
            }
            return;
        }
        BottomListMenu bottomListMenu = new BottomListMenu(this.mContext.findViewById(16908290), "", this.mBottomMenuUtils.getCommonMenuItems(), (List<? extends BottomCustomMenuItem>) null, new BottomListMenu.ItemClickListener() {
            public void onItemClick(int id) {
                CommentBottomMenuManager commentBottomMenuManager = CommentBottomMenuManager.this;
                commentBottomMenuManager.doItemClick(commentBottomMenuManager.mBottomMenuUtils.getValue(id));
            }
        });
        this.mBottomListMenu = bottomListMenu;
        bottomListMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                if (CommentBottomMenuManager.this.mEventCallback != null) {
                    CommentBottomMenuManager.this.mEventCallback.onMenuDismiss();
                }
            }
        });
        this.mBottomListMenu.showView();
    }

    private void handleAuthorFavor(boolean isFavor) {
        EventCallback eventCallback = this.mEventCallback;
        if (eventCallback != null) {
            eventCallback.handleAuthorFavor(this.mCommentModel, this.mPosition, isFavor);
        }
        doUBCStatistic(BDCommentStatisticHelper.COMMENT_BOTTOM_DIALOG_MENU_STICK_CLK);
    }

    private void handleShare() {
        if (!BDCommentUtil.isFastClick()) {
            if (!BDCommentUtil.isAllowShare(this.mCommentModel)) {
                UniversalToast.makeText(CommentRuntime.getAppContext(), R.string.forbid_comment_share_hint).show();
                return;
            }
            handleCommentShare(this.mCommentModel);
            doUBCStatistic(BDCommentStatisticHelper.COMMENT_BOTTOM_DIALOG_MENU_SHARE_CLK);
        }
    }

    private void handleCommentShare(final CommentModel model) {
        if (model != null) {
            EventCallback eventCallback = this.mEventCallback;
            if (eventCallback != null) {
                eventCallback.handleBeforeShare();
            }
            if (this.mShareData != null) {
                CommentSharePosterView shareView = new CommentSharePosterView(CommentRuntime.getAppContext());
                shareView.setCallback(new Function1<Bitmap, Unit>() {
                    public Unit invoke(Bitmap bitmap) {
                        if (CommentBottomMenuManager.this.mContext == null || bitmap == null) {
                            return null;
                        }
                        JSONObject extParams = new JSONObject();
                        if (model.getVideoData() != null) {
                            try {
                                if (!TextUtils.isEmpty(CommentBottomMenuManager.this.mShareData.ubcShareSource)) {
                                    extParams.put(BDCommentStatisticHelper.UBC_COMMENT_AREA_SOURCE, CommentBottomMenuManager.this.mShareData.ubcShareSource);
                                }
                                extParams.put("is_video", "1");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        CommentRuntime.getCommentContext().commentShare(CommentBottomMenuManager.this.mContext, bitmap, CommentBottomMenuManager.this.mShareData.getTitle(), CommentBottomMenuManager.this.mShareData.iconUrl, model.getShareUrl(), 3, CommentBottomMenuManager.this.mShareData.strategyInfo, CommentBottomMenuManager.this.mShareData.nid, CommentBottomMenuManager.this.mShareData.replyId, CommentBottomMenuManager.this.mShareData.topicId, CommentBottomMenuManager.this.mShareData.needScreenshot, extParams);
                        return null;
                    }
                });
                shareView.bindData(this.mShareData.shareModel);
            }
        }
    }

    private void handleCopySearch() {
        String allComment;
        if (!BDCommentUtil.isFastClick()) {
            CommentModel commentModel = this.mCommentModel;
            if (!(commentModel == null || commentModel.getContent() == null)) {
                if (this.mEnableSelectText) {
                    StringBuilder allCommentSb = new RichTextFormatter(CommentRuntime.getAppContext()).formatContentForReply2Comment(this.mCommentModel);
                    if (allCommentSb != null) {
                        allComment = allCommentSb.toString();
                    } else {
                        allComment = this.mCommentModel.getContent();
                    }
                    if (this.mEventCallback != null && !TextUtils.isEmpty(allComment)) {
                        this.mEventCallback.handleSelectText(allComment);
                    }
                } else {
                    StringBuilder sb = new RichTextFormatter(CommentRuntime.getAppContext()).formatContentForReply2Comment(this.mCommentModel);
                    WrappedClipboardManager.newInstance(CommentRuntime.getAppContext()).setText(sb == null ? this.mCommentModel.getContent() : sb);
                    UniversalToast.makeText(CommentRuntime.getAppContext(), R.string.common_comment_already_copy).showToast();
                }
            }
            doUBCStatistic(BDCommentStatisticHelper.COMMENT_BOTTOM_DIALOG_MENU_COPY_CLK);
        }
    }

    private void handleReport(CommentOperationData.ReportItem item) {
        if (!BDCommentUtil.isFastClick()) {
            CommentDetailUtil.getInstance().reportOperate(this.mCommentModel, (FragmentActivity) this.mContext, this.mUbcModel, item);
            doUBCStatistic(BDCommentStatisticHelper.COMMENT_BOTTOM_DIALOG_MENU_REPORT_CLK);
        }
    }

    private void doUBCStatistic(String type) {
        UBCModel uBCModel;
        if (this.mCommentModel != null && (uBCModel = this.mUbcModel) != null) {
            BDCommentStatisticHelper.commentBottomDialogStatistics(uBCModel.getPage(), this.mUbcModel.getSource(), isBusinessAccount() ? "1" : "2", type, this.mUbcModel.getNID(), this.mCommentModel.getTopicId(), this.mUbcModel.getLogID());
        }
    }

    private boolean isBusinessAccount() {
        BoxAccount account;
        BoxAccountManager manager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (!manager.isLogin(2) || (account = manager.getBoxAccount()) == null) {
            return false;
        }
        String userType = account.getUserType();
        if (TextUtils.equals(userType, "1") || TextUtils.equals(userType, "2")) {
            return true;
        }
        return false;
    }

    public void setCommentModel(CommentModel commentModel, int position) {
        this.mCommentModel = commentModel;
        this.mPosition = position;
    }

    public void setIsMine(boolean isMine) {
        this.mIsMine = isMine;
    }

    public void setUbcModel(UBCModel ubcModel) {
        this.mUbcModel = ubcModel;
    }

    public void setShareData(ShareData shareData) {
        this.mShareData = shareData;
    }

    public void setEventCallback(EventCallback mEventCallback2) {
        this.mEventCallback = mEventCallback2;
    }

    public boolean isHideAuthorFavor() {
        return this.mHideAuthorFavor;
    }

    public void setHideAuthorFavor(boolean mHideAuthorFavor2) {
        this.mHideAuthorFavor = mHideAuthorFavor2;
    }

    public boolean isShowing() {
        BottomListMenu bottomListMenu = this.mBottomListMenu;
        return bottomListMenu != null && bottomListMenu.isShowing();
    }

    public void dismiss() {
        if (ActivityUtils.isDestroyed(this.mContext)) {
            this.mContext = null;
        }
        BottomListMenu bottomListMenu = this.mBottomListMenu;
        if (bottomListMenu != null && bottomListMenu.isShowing()) {
            this.mBottomListMenu.dismiss();
        }
    }

    public static class ShareData {
        /* access modifiers changed from: private */
        public String iconUrl;
        /* access modifiers changed from: private */
        public boolean needScreenshot;
        /* access modifiers changed from: private */
        public String nid;
        /* access modifiers changed from: private */
        public String replyId;
        /* access modifiers changed from: private */
        public CommentSharePosterModel shareModel;
        /* access modifiers changed from: private */
        public String strategyInfo;
        private String title;
        /* access modifiers changed from: private */
        public String topicId;
        public String ubcShareSource;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public void setIconUrl(String iconUrl2) {
            this.iconUrl = iconUrl2;
        }

        public String getStrategyInfo() {
            return this.strategyInfo;
        }

        public void setStrategyInfo(String strategyInfo2) {
            this.strategyInfo = strategyInfo2;
        }

        public CommentSharePosterModel getShareModel() {
            return this.shareModel;
        }

        public void setShareModel(CommentSharePosterModel shareModel2) {
            this.shareModel = shareModel2;
        }

        public String getNid() {
            return this.nid;
        }

        public void setNid(String nid2) {
            this.nid = nid2;
        }

        public String getTopicId() {
            return this.topicId;
        }

        public void setTopicId(String topicId2) {
            this.topicId = topicId2;
        }

        public String getReplyId() {
            return this.replyId;
        }

        public void setReplyId(String replyId2) {
            this.replyId = replyId2;
        }

        public boolean isNeedScreenshot() {
            return this.needScreenshot;
        }

        public void setNeedScreenshot(boolean needScreenshot2) {
            this.needScreenshot = needScreenshot2;
        }
    }
}
