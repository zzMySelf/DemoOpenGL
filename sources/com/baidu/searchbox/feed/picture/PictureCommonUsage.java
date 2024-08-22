package com.baidu.searchbox.feed.picture;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.media.ImageUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.comment.BDCommentConstants;
import com.baidu.searchbox.comment.BDCommentDraftManager;
import com.baidu.searchbox.comment.CommentModuleManager;
import com.baidu.searchbox.comment.definition.BDCommentStatusCallback;
import com.baidu.searchbox.comment.definition.IBDCommentInputController;
import com.baidu.searchbox.comment.definition.ICommentInput;
import com.baidu.searchbox.comment.model.CommentModel;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.discovery.picture.ioc.IPictureYun;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.PictureBaseActivity;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.model.FeedPhotoModel;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.feed.picture.interfaces.AbstractPictureFeedUsage;
import com.baidu.searchbox.feed.util.FeedSessionManager;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.imagesearch.params.ImageSearchParams;
import com.baidu.searchbox.imagesearch.pyramid.ImageSearchInterface;
import com.baidu.searchbox.lightbrowser.ToolBarFrameworkRuntime;
import com.baidu.searchbox.picture.R;
import com.baidu.searchbox.picture.model.PictureInfo;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.socialshare.statistics.SharePageEnum;
import com.baidu.searchbox.socialshare.utils.ShareUtils;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.toolbar.CommonToolBar;
import com.baidu.searchbox.toolbar.OnCommonToolItemClickListener;
import com.baidu.ubc.UBCManager;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PictureCommonUsage {
    private static final String COMMENT_SOURCE = "atlas";
    private static final String FEED_ALBUM = "album";
    private static final String FEED_DETAIL = "detail";
    private static final String FEED_PIC = "pic";
    private static final String SHARE_USERINFO_CONTEXT = "context";
    /* access modifiers changed from: private */
    public Activity mActivity;
    private AbstractPictureFeedUsage mBrowseImpl;
    private boolean mCommentCloseStatus = false;
    private IBDCommentInputController mCommentInputController;
    private String mCommentNum;
    private String mContextJsonStr = "";
    private String mFlowSlog = "-1";
    private boolean mIsIconShowed;
    private String mSearchImgResultUrl;
    /* access modifiers changed from: private */
    public CommonToolBar mToolBar;
    private CommonMenu mToolBarMenu;

    public PictureCommonUsage(Activity activity, CommonToolBar toolBar, AbstractPictureFeedUsage browseImpl, CommonMenu toolBarMenu) {
        this.mActivity = activity;
        this.mToolBar = toolBar;
        this.mBrowseImpl = browseImpl;
        this.mToolBarMenu = toolBarMenu;
        this.mCommentInputController = CommentModuleManager.getCommentModule().getCommentInputController();
    }

    public void setIntentData(String flowSlog, String contextJsonStr) {
        this.mFlowSlog = flowSlog;
        this.mContextJsonStr = contextJsonStr;
    }

    public void setToolbarExtHandler() {
        CommonToolBar commonToolBar = this.mToolBar;
        if (commonToolBar != null) {
            commonToolBar.setCommonBarPhotoB();
            if (this.mToolBar.isShow(9)) {
                pictureShareUbc("show", "bar");
            }
        }
    }

    public HashMap<String, String> handleToolBarStat(BaseToolBarItem item) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("slog", this.mFlowSlog);
        hashMap.put("session_id", FeedSessionManager.getInstance().getSessionId());
        hashMap.put("click_id", FeedSessionManager.getInstance().getClickId());
        hashMap.put("guide", isShowBackPop() ? "1" : "0");
        switch (item.getItemId()) {
            case 7:
                hashMap.put("type", "icon_clk");
                hashMap.put("source", this.mToolBar.isSoFa() ? BDCommentStatisticHelper.COMMENT_SOFA_ICON : BDCommentStatisticHelper.COMMENT_OTHER_ICON);
                getCommentUBC(hashMap);
                break;
            case 10:
                hashMap.put("type", BDCommentStatisticHelper.TYPE_INPUT_BOX_CLK);
                getCommentUBC(hashMap);
                break;
        }
        return hashMap;
    }

    public void setSearchImgResultUrl(String url) {
        this.mSearchImgResultUrl = url;
    }

    public void preLoadCommentCache(int delayMillis) {
    }

    public void initCommonToolItemClickListener() {
        OnCommonToolItemClickListener onCommonToolItemClickListener = new OnCommonToolItemClickListener() {
            public boolean onItemClick(View v, BaseToolBarItem item) {
                switch (item.getItemId()) {
                    case 7:
                        if (PictureCommonUsage.this.mToolBar == null || !PictureCommonUsage.this.mToolBar.isSoFa()) {
                            PictureCommonUsage.this.onStartCommentPage(2);
                        } else {
                            FeedPhotoModel tmpModel = PictureCommonUsage.this.getPicModel();
                            if (tmpModel != null) {
                                String logId = "";
                                if (tmpModel.feedPhotoGuideModel != null) {
                                    logId = tmpModel.feedPhotoGuideModel.mLogId;
                                }
                                PictureCommonUsage.this.invokeNativeComment(tmpModel.nid, 0, tmpModel.topicId, "", "", tmpModel.commentBoxPlaceholder, "atlas", logId, tmpModel.commentConf);
                            }
                        }
                        return true;
                    case 9:
                        if (PictureCommonUsage.this.mActivity instanceof PictureBaseActivity) {
                            ((PictureBaseActivity) PictureCommonUsage.this.mActivity).dismissMenu();
                        }
                        PictureCommonUsage.this.onShareClick("all", "bar");
                        return true;
                    case 10:
                        FeedPhotoModel tmpModel2 = PictureCommonUsage.this.getPicModel();
                        if (tmpModel2 != null) {
                            String logId2 = "";
                            if (tmpModel2.feedPhotoGuideModel != null) {
                                logId2 = tmpModel2.feedPhotoGuideModel.mLogId;
                            }
                            BDCommentStatisticHelper.commentTransitionUBCEvent("", "", "atlas", "publish_call", tmpModel2.topicId, logId2, tmpModel2.nid);
                            PictureCommonUsage.this.invokeNativeComment(tmpModel2.nid, 0, tmpModel2.topicId, "", "", tmpModel2.commentBoxPlaceholder, "atlas", logId2, tmpModel2.commentConf);
                        }
                        return true;
                    default:
                        return false;
                }
            }
        };
        Activity activity = this.mActivity;
        if (activity instanceof PictureBaseActivity) {
            ((PictureBaseActivity) activity).setOnCommonToolItemClickListener(onCommonToolItemClickListener);
        }
    }

    private void getCommentUBC(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            hashMap.put("from", "comment");
            hashMap.put("page", "comment_list");
            hashMap.put("value", "atlas");
            boolean isInSearchSession = FeedRuntime.getFeedContext().isInSearchSession();
            if (isInSearchSession) {
                hashMap.put("origin", "search");
            } else {
                hashMap.put("origin", "feed");
            }
            FeedPhotoModel model = getPicModel();
            JSONObject extObject = new JSONObject();
            if (model != null) {
                try {
                    extObject.put("topicID", model.topicId);
                    extObject.put("logid", model.feedPhotoGuideModel == null ? "" : model.feedPhotoGuideModel.mLogId);
                    extObject.put("NID", model.nid);
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
            if (isInSearchSession) {
                extObject.put("s_session", FeedRuntime.getFeedContext().getSearchSession());
            }
            extObject.put("comment_num", this.mCommentNum);
            hashMap.put("ext", extObject.toString());
        }
    }

    public FeedPhotoModel getPicModel() {
        AbstractPictureFeedUsage abstractPictureFeedUsage = this.mBrowseImpl;
        if (abstractPictureFeedUsage instanceof PictureFeedUsage) {
            return ((PictureFeedUsage) abstractPictureFeedUsage).getPictureBrowseData();
        }
        return null;
    }

    private PictureInfo getShareContent() {
        AbstractPictureFeedUsage abstractPictureFeedUsage = this.mBrowseImpl;
        if (abstractPictureFeedUsage instanceof PictureFeedUsage) {
            return abstractPictureFeedUsage.getShareContent();
        }
        return null;
    }

    public void updateCommentUI(String number) {
        if (!TextUtils.isEmpty(number)) {
            this.mCommentNum = number;
            this.mToolBar.setVisible(7, true);
            this.mToolBar.setVisible(10, true);
            String numberToShow = FeedUtil.convertNumber(this.mActivity, (long) FeedUtil.convertStringToIntSafe(number));
            boolean isNumberToShowEmpty = TextUtils.isEmpty(numberToShow);
            this.mToolBar.setCommentsStatus(isNumberToShowEmpty ? this.mActivity.getResources().getString(R.string.feed_picture_common_sofa) : numberToShow);
            this.mToolBar.setSoFa(isNumberToShowEmpty);
            commentIconShowUBC(this.mCommentNum);
        }
    }

    private void commentIconShowUBC(String cmtNum) {
        CommonToolBar commonToolBar;
        FeedPhotoModel model;
        if (!this.mIsIconShowed && !TextUtils.isEmpty(cmtNum) && (commonToolBar = this.mToolBar) != null && commonToolBar.isShow(7) && (model = getPicModel()) != null) {
            BDCommentStatisticHelper.commentIconShowUBCEvent("comment_list", "atlas", this.mToolBar.isSoFa(), model.topicId, model.feedPhotoGuideModel == null ? "" : model.feedPhotoGuideModel.mLogId, model.nid, cmtNum);
            this.mIsIconShowed = true;
        }
    }

    public void closeComment() {
        if (!this.mCommentCloseStatus) {
            CommonToolBar commonToolBar = this.mToolBar;
            if (commonToolBar != null) {
                commonToolBar.setCloseCommentUIForAtlas();
            }
            this.mCommentCloseStatus = true;
        }
    }

    public void openComment() {
        if (this.mCommentCloseStatus) {
            CommonToolBar commonToolBar = this.mToolBar;
            if (commonToolBar != null) {
                commonToolBar.setOpenCommentUI();
            }
            this.mCommentCloseStatus = false;
        }
    }

    public void onShareClick(String mediaType, String entrance) {
        String str = entrance;
        AbstractPictureFeedUsage abstractPictureFeedUsage = this.mBrowseImpl;
        int i2 = 1;
        if (!(abstractPictureFeedUsage instanceof PictureFeedUsage)) {
            String str2 = mediaType;
        } else if (!TextUtils.isEmpty(abstractPictureFeedUsage.getShareUrl())) {
            FeedPhotoModel model = getPicModel();
            PictureInfo info = getShareContent();
            String title = "";
            String content = "";
            String iconUrl = "";
            if (info != null) {
                title = info.getTitle();
                content = info.getDescription();
                iconUrl = info.getUrl();
            }
            JSONObject userInfo = new JSONObject();
            JSONObject categoryInfo = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.mContextJsonStr)) {
                    userInfo.put("context", this.mContextJsonStr);
                }
                if (!TextUtils.isEmpty(this.mFlowSlog) && !"-1".equals(this.mFlowSlog)) {
                    userInfo.put("slog", this.mFlowSlog);
                    categoryInfo.put("slog", this.mFlowSlog);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONObject jsonObject = new JSONObject();
            if (model != null && !TextUtils.isEmpty(model.forwardSchema)) {
                try {
                    jsonObject.put("ugc_scheme", model.forwardSchema);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (model != null && !TextUtils.isEmpty(model.nid)) {
                try {
                    categoryInfo.put("nid", model.nid);
                    jsonObject.put("business_type", "feed");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            BDShare.getInstance().share(this.mActivity, (View) null, new BaiduShareContent.Builder().setTitle(title).setContent(ShareUtils.getShareContent(this.mActivity, title, content, false)).setLinkUrl(model == null ? "" : model.h5url).setShareType(1).setIconUrl(iconUrl).setSourcePage(SharePageEnum.OTHER).setSource("album").setMediaType(mediaType).setUserInfo(userInfo.toString()).setCategoryInfo(categoryInfo.toString()).setCategoryData(jsonObject.toString()).setShareEntrance(str).setShareExtPage("album").create());
            PictureStatisticUtil.shareStatistic(this.mContextJsonStr);
            pictureShareUbc("click", str);
        } else {
            String str3 = mediaType;
        }
        AbstractPictureFeedUsage abstractPictureFeedUsage2 = this.mBrowseImpl;
        if (abstractPictureFeedUsage2 != null) {
            Bitmap capture = null;
            View view2 = abstractPictureFeedUsage2.getCurrentShowView();
            if (view2 instanceof PictureBrowseView) {
                capture = ImageUtils.duplicateBitmap(((PictureBrowseView) view2).getImageViewBitmap());
                view2 = ((PictureBrowseView) view2).getZoomDraweeView();
            }
            if (view2 != null) {
                if (capture == null) {
                    capture = ShareUtils.getScreenShot(view2);
                }
                String title2 = "";
                String url = "";
                PictureInfo info2 = this.mBrowseImpl.getShareContent();
                if (info2 != null) {
                    title2 = info2.getTitle();
                    url = info2.getUrl();
                }
                BaiduShareContent.Builder source = new BaiduShareContent.Builder().setContent(ShareUtils.getShareContent(this.mActivity, title2, title2, false)).setLinkUrl(url).setImageBitmap(capture, false).setSourcePage(SharePageEnum.OTHER).setSource("image");
                if (capture != null) {
                    i2 = 3;
                }
                BDShare.getInstance().share(this.mActivity, (View) null, source.setShareType(i2).setShareEntrance(str).setShareExtPage("album").create());
            } else {
                return;
            }
        }
        PictureStatisticUtil.shareStatistic(this.mContextJsonStr);
        pictureShareUbc("click", str);
    }

    public HashMap<String, String> handleMenuStat(CommonMenuItem item) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("slog", this.mFlowSlog);
        hashMap.put("source", "album");
        return hashMap;
    }

    public void processLinkage(String type, FeedPhotoModel photoModel) {
        if (!TextUtils.isEmpty(photoModel.nid)) {
            LinkageData linkageData = new LinkageData();
            linkageData.nid = photoModel.nid;
            linkageData.type = type;
            linkageData.isUsed = false;
            linkageData.count = photoModel.commentNumText;
            FeedLinkageManager.getInstance("feed").addLinkage(linkageData);
        }
    }

    public void onStartCommentPage(int from) {
        PictureInfo info;
        String iconUrl = "";
        if (!NetWorkUtils.isNetworkConnected(this.mActivity)) {
            UniversalToast.makeText(FeedRuntime.getAppContext(), R.string.feed_picture_common_net_err_tip).setDuration(3).showToast();
        }
        FeedPhotoModel model = getPicModel();
        if (model != null) {
            String commentCmd = model.commentCommand;
            if (!TextUtils.isEmpty(commentCmd)) {
                try {
                    String url = new JSONObject(commentCmd).getString("url");
                    String shareTitle = iconUrl;
                    AbstractPictureFeedUsage abstractPictureFeedUsage = this.mBrowseImpl;
                    if (!(abstractPictureFeedUsage == null || (info = abstractPictureFeedUsage.getShareContent()) == null)) {
                        shareTitle = info.getTitle();
                        iconUrl = info.getUrl();
                    }
                    if (!TextUtils.isEmpty(model.nid)) {
                        String url2 = ((((url + "&nid=" + model.nid) + "&source=" + "atlas") + "&sharetitle=" + shareTitle) + "&iconUrl=" + URLEncoder.encode(iconUrl, "utf-8")) + "&clientFrom=" + String.valueOf(from);
                        if (!TextUtils.isEmpty(url2)) {
                            Router.invoke(this.mActivity, url2);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean isShowBackPop() {
        CommonToolBar commonToolBar = this.mToolBar;
        return commonToolBar != null && commonToolBar.isShowBackPop();
    }

    public void updateComment() {
        FeedPhotoModel tmpModel = getPicModel();
        if (tmpModel != null) {
            LinkageData ld = FeedLinkageManager.getInstance("feed").getLinkageByNidAndType(tmpModel.nid, "comment");
            if (this.mToolBar != null && ld != null) {
                updateCommentUI(ld.count);
                tmpModel.commentNumText = ld.count;
                this.mToolBar.setCommentInput(BDCommentDraftManager.getCompleteDraft(tmpModel.topicId));
            }
        }
    }

    public void clearCommentCacheByTopic() {
        FeedPhotoModel picModel = getPicModel();
    }

    public void onSearchImgClick(ImageSearchParams.ImageSearchSource source) {
        AbstractPictureFeedUsage abstractPictureFeedUsage = this.mBrowseImpl;
        String currentImgUrl = abstractPictureFeedUsage == null ? "" : abstractPictureFeedUsage.getCurrentUrl();
        AbstractPictureFeedUsage abstractPictureFeedUsage2 = this.mBrowseImpl;
        if (abstractPictureFeedUsage2 != null) {
            String shareUrl = abstractPictureFeedUsage2.getShareUrl();
        }
        if (TextUtils.isEmpty(currentImgUrl)) {
            UniversalToast.makeText(FeedRuntime.getAppContext(), com.baidu.searchbox.lightbrowser.base.R.string.img_url_is_empty).setDuration(2).show();
            return;
        }
        ImageSearchInterface imageSearchInterface = (ImageSearchInterface) ServiceManager.getService(ImageSearchInterface.SERVICE_REFERENCE);
        if (imageSearchInterface != null && !imageSearchInterface.loadImgSearchResult(this.mActivity, this.mSearchImgResultUrl, currentImgUrl, source)) {
            UniversalToast.makeText((Context) this.mActivity, com.baidu.searchbox.common.atlas.R.string.search_img_failed).setDuration(2).show();
        }
    }

    public ImageSearchParams.ImageSearchSource getImgSearchSource() {
        AbstractPictureFeedUsage abstractPictureFeedUsage = this.mBrowseImpl;
        boolean isShowDetail = true;
        if (abstractPictureFeedUsage == null || (abstractPictureFeedUsage.getCurrentUIMode() & 1) == 1) {
            isShowDetail = false;
        }
        if (isShowDetail) {
            return ImageSearchParams.ImageSearchSource.FEED_ALBUM_DETAIL;
        }
        return ImageSearchParams.ImageSearchSource.FEED_ALBUM_PIC;
    }

    public void onSaveBDCloud() {
        if (this.mBrowseImpl != null) {
            IPictureYun.Impl.get().doImageSaveJob(this.mActivity, this.mBrowseImpl.getCurrentUrl());
        } else {
            IPictureYun.Impl.get().showRequestError(this.mActivity);
        }
    }

    public void setIconShowed(boolean isIconShowed) {
        this.mIsIconShowed = isIconShowed;
    }

    public void invokeNativeComment(final String nid, int type, String topicId, String parentId, String rename, String placeholder, String source, String logid, String commentConf) {
        if (!TextUtils.isEmpty(topicId) && this.mCommentInputController != null) {
            Map<String, String> params = new HashMap<>();
            params.put("topic_id", topicId);
            params.put("parent_id", parentId);
            params.put("rename", rename);
            params.put("placeholder", placeholder);
            params.put(BDCommentConstants.KEY_COMMENT_INPUT_CONF, commentConf);
            params.put("slog", this.mFlowSlog);
            params.put("NID", nid);
            params.put("logid", logid);
            params.put("value", source);
            this.mCommentInputController.showBDComment(this.mActivity, type, params, (BDCommentStatusCallback) new BDCommentStatusCallback() {
                public void onCommentResult(String result, Map<String, String> map) {
                    ToolBarFrameworkRuntime.getToolBarFrameworkContext().processCommentLinkage(nid);
                    PictureCommonUsage.this.commentSuccess();
                }

                public void handleFakeComment(CommentModel commentModel, Map<String, String> map) {
                }

                public void onStoreDraft(ICommentInput.Draft draft) {
                    if (PictureCommonUsage.this.mToolBar != null) {
                        PictureCommonUsage.this.mToolBar.setCommentInput(draft.getCompleteDraft());
                    }
                }
            });
        }
    }

    public void setCommentOrientation(int orientation) {
        IBDCommentInputController iBDCommentInputController = this.mCommentInputController;
        if (iBDCommentInputController != null) {
            iBDCommentInputController.setOrientation(orientation);
        }
    }

    public void releaseCommentInput() {
        IBDCommentInputController iBDCommentInputController = this.mCommentInputController;
        if (iBDCommentInputController != null) {
            iBDCommentInputController.release();
        }
    }

    /* access modifiers changed from: private */
    public void commentSuccess() {
        updateComment();
        clearCommentCacheByTopic();
        onStartCommentPage(1);
    }

    public void pictureShareUbc(String type, String value) {
        String str;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", type);
            jsonObject.put("source", "album");
            if (!TextUtils.isEmpty(value)) {
                str = value;
            } else {
                str = "other";
            }
            jsonObject.put("value", str);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("6085", jsonObject);
    }
}
