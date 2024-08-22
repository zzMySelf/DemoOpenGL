package com.baidu.searchbox.boxshare.bean;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.searchbox.boxshare.constants.SharePageEnum;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareContent {
    public static final String CUSTOM_CHANNEL_POST_CARD_IMG = "post_card_img";
    private static final int CUSTOM_DEFAULT_POSITION = 15;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "BaiduShareContent";
    /* access modifiers changed from: private */
    public boolean hideSharePanelAnim;
    /* access modifiers changed from: private */
    public boolean isSDKShowToast;
    /* access modifiers changed from: private */
    public boolean isScreenShot;
    /* access modifiers changed from: private */
    public boolean isWeixinOnly;
    /* access modifiers changed from: private */
    public String mAppId;
    /* access modifiers changed from: private */
    public String mAudioUrl;
    /* access modifiers changed from: private */
    public List<MenuTypeWrapper> mBDMenuItems;
    /* access modifiers changed from: private */
    public BannerOperationData mBannerOperationData;
    /* access modifiers changed from: private */
    public String mBusinessInvokeScheme;
    /* access modifiers changed from: private */
    public String mCategoryData;
    /* access modifiers changed from: private */
    public String mCategoryInfo;
    /* access modifiers changed from: private */
    public String mCommandData;
    /* access modifiers changed from: private */
    public String mContent;
    /* access modifiers changed from: private */
    public List<CustomItem> mCustomItems;
    /* access modifiers changed from: private */
    public String mEntrance;
    /* access modifiers changed from: private */
    public String mExtPage;
    /* access modifiers changed from: private */
    public List<String> mFileShareLists;
    /* access modifiers changed from: private */
    public Map<String, String> mFunctionTips;
    /* access modifiers changed from: private */
    public String mHotResourceAnimeConfig;
    /* access modifiers changed from: private */
    public Bitmap mIconBitmap;
    /* access modifiers changed from: private */
    public byte[] mIconBytes;
    /* access modifiers changed from: private */
    public boolean mIconNeedRecycle;
    /* access modifiers changed from: private */
    public String mIconUrl;
    /* access modifiers changed from: private */
    public String mIconUrlSmall;
    /* access modifiers changed from: private */
    public Bitmap mImageBitmap;
    /* access modifiers changed from: private */
    public byte[] mImageBytes;
    /* access modifiers changed from: private */
    public boolean mImageNeedRecycle;
    /* access modifiers changed from: private */
    public int mImagePreviewHeight;
    /* access modifiers changed from: private */
    public int mImagePreviewWidth;
    /* access modifiers changed from: private */
    public String mImageUrl;
    /* access modifiers changed from: private */
    public String mLinkUrl;
    /* access modifiers changed from: private */
    public String mMenuItem;
    /* access modifiers changed from: private */
    public boolean mNeedImagePreview;
    /* access modifiers changed from: private */
    public String mPanel;
    /* access modifiers changed from: private */
    public String mPanelStyle;
    /* access modifiers changed from: private */
    public int mPanelXOffset;
    /* access modifiers changed from: private */
    public String mPosterShareTalosData;
    /* access modifiers changed from: private */
    public List<String> mRemoveMenuItems;
    /* access modifiers changed from: private */
    public int mShareType;
    /* access modifiers changed from: private */
    public String mSource;
    /* access modifiers changed from: private */
    public SharePageEnum mSourcePage;
    /* access modifiers changed from: private */
    public String mStrategyInfo;
    /* access modifiers changed from: private */
    public String mSystemShareIntentType;
    /* access modifiers changed from: private */
    public String mTalosLiteData;
    /* access modifiers changed from: private */
    public String mTextContent;
    /* access modifiers changed from: private */
    public String mTheme;
    /* access modifiers changed from: private */
    public String mTitle;
    /* access modifiers changed from: private */
    public boolean mUseSystemToast;
    /* access modifiers changed from: private */
    public String mUserInfo;
    /* access modifiers changed from: private */
    public String mVideoUrl;
    /* access modifiers changed from: private */
    public String mWeiboTopic;

    private ShareContent() {
        this.mSource = "other";
        this.mShareType = 1;
        this.mPanelStyle = "0";
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public byte[] getImageBytes() {
        return this.mImageBytes;
    }

    public Bitmap getImageBitmap() {
        return this.mImageBitmap;
    }

    public boolean isImageNeedRecycle() {
        return this.mImageNeedRecycle;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getPanelStyle() {
        return this.mPanelStyle;
    }

    public String getIconUrlSmall() {
        return this.mIconUrlSmall;
    }

    public byte[] getIconBytes() {
        return this.mIconBytes;
    }

    public Bitmap getIconBitmap() {
        return this.mIconBitmap;
    }

    public boolean isIconNeedRecycle() {
        return this.mIconNeedRecycle;
    }

    public boolean isWeixinOnly() {
        return this.isWeixinOnly;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getWeiboTopic() {
        return this.mWeiboTopic;
    }

    public List<MenuTypeWrapper> getBDMenuItem() {
        return this.mBDMenuItems;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public String getTextContent() {
        return this.mTextContent;
    }

    public boolean isSDKShowToast() {
        return this.isSDKShowToast;
    }

    public String getLinkUrl() {
        String str;
        if (this.mShareType == 4 && (str = this.mVideoUrl) != null) {
            this.mLinkUrl = str;
        }
        return this.mLinkUrl;
    }

    public void setLinkUrl(String url) {
        this.mLinkUrl = url;
    }

    public String getMenuItem() {
        if (TextUtils.isEmpty(this.mMenuItem)) {
            this.mMenuItem = "all";
        }
        return this.mMenuItem;
    }

    public void setMenuItem(String menuItem) {
        this.mMenuItem = menuItem;
    }

    public String getSource() {
        if (TextUtils.isEmpty(this.mSource)) {
            this.mSource = "other";
        }
        return this.mSource;
    }

    public void setSource(String source) {
        this.mSource = source;
    }

    public String getPanel() {
        return this.mPanel;
    }

    public int getShareType() {
        return this.mShareType;
    }

    public void setShareType(int shareType) {
        this.mShareType = shareType;
    }

    public List<CustomItem> getCustomItems() {
        return this.mCustomItems;
    }

    public String getAudioUrl() {
        return this.mAudioUrl;
    }

    public SharePageEnum getSourcePage() {
        if (this.mSourcePage == null) {
            this.mSourcePage = SharePageEnum.OTHER;
        }
        return this.mSourcePage;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getResID(java.lang.String r2) {
        /*
            r0 = -1
            int r1 = r2.hashCode()
            switch(r1) {
                case 1212778195: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0014
        L_0x0009:
            java.lang.String r1 = "post_card_img"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0015
        L_0x0014:
            r1 = -1
        L_0x0015:
            switch(r1) {
                case 0: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x001b
        L_0x0019:
            int r0 = com.baidu.searchbox.socialshareinterface.R.drawable.bdsocialshare_menu_item_post_card_img
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.boxshare.bean.ShareContent.getResID(java.lang.String):int");
    }

    public void setSourcePage(SharePageEnum pageEnum) {
        this.mSourcePage = pageEnum;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public String getTheme() {
        return this.mTheme;
    }

    public String getUserInfo() {
        return this.mUserInfo;
    }

    public String getCategoryInfo() {
        return this.mCategoryInfo;
    }

    public String getCategoryData() {
        return this.mCategoryData;
    }

    public void setCategoryData(String categoryData) {
        this.mCategoryData = categoryData;
    }

    public boolean isScreenShot() {
        return this.isScreenShot;
    }

    public String getmCommandData() {
        return this.mCommandData;
    }

    public List<String> getRemoveMenuItems() {
        return this.mRemoveMenuItems;
    }

    public List<String> getFileShareLists() {
        return this.mFileShareLists;
    }

    public Map<String, String> getFunctionTips() {
        return this.mFunctionTips;
    }

    public void setFunctionTips(Map<String, String> functionTips) {
        this.mFunctionTips = functionTips;
    }

    public String getBusinessInvokeScheme() {
        return this.mBusinessInvokeScheme;
    }

    public void setBusinessInvokeScheme(String businessInvokeScheme) {
        this.mBusinessInvokeScheme = businessInvokeScheme;
    }

    public String getStrategyInfo() {
        return this.mStrategyInfo;
    }

    public void setStrategyInfo(String strategyInfo) {
        this.mStrategyInfo = strategyInfo;
    }

    public boolean isNeedImagePreview() {
        return this.mNeedImagePreview;
    }

    public void setNeedImagePreview(boolean needImagePreview) {
        this.mNeedImagePreview = needImagePreview;
    }

    public int getImagePreviewHeight() {
        return this.mImagePreviewHeight;
    }

    public void setImagePreviewHeight(int imagePreviewHeight) {
        this.mImagePreviewHeight = imagePreviewHeight;
    }

    public int getImagePreviewWidth() {
        return this.mImagePreviewWidth;
    }

    public void setImagePreviewWidth(int imagePreviewWidth) {
        this.mImagePreviewWidth = imagePreviewWidth;
    }

    public String getExtPage() {
        return this.mExtPage;
    }

    public void setExtPage(String extPage) {
        this.mExtPage = extPage;
    }

    public String getEntrance() {
        return this.mEntrance;
    }

    public void setEntrance(String entrance) {
        this.mEntrance = entrance;
    }

    public String getTalosLiteData() {
        return this.mTalosLiteData;
    }

    public void setTalosLiteData(String talosLiteData) {
        this.mTalosLiteData = talosLiteData;
    }

    public BannerOperationData getBannerOperationData() {
        return this.mBannerOperationData;
    }

    public String getHotResourceAnimeConfig() {
        return this.mHotResourceAnimeConfig;
    }

    public void setBannerOperationData(BannerOperationData bannerOperationData) {
        this.mBannerOperationData = bannerOperationData;
    }

    public boolean hideSharePanelAnim() {
        return this.hideSharePanelAnim;
    }

    public String getSystemShareIntentType() {
        return this.mSystemShareIntentType;
    }

    public void setSystemShareIntentType(String systemShareIntentType) {
        this.mSystemShareIntentType = systemShareIntentType;
    }

    public String getPosterTalosData() {
        return this.mPosterShareTalosData;
    }

    public boolean isUseSystemToast() {
        return this.mUseSystemToast;
    }

    public void setUseSystemToast(boolean useSystemToast) {
        this.mUseSystemToast = useSystemToast;
    }

    public int getPanelXOffset() {
        return this.mPanelXOffset;
    }

    public static class Builder {
        private boolean hideSharePanelAnim;
        private boolean isSDKShowToast = true;
        private boolean isScreenShot;
        private boolean isWeixinOnly;
        private String mAppId;
        private String mAudioUrl;
        private List<MenuTypeWrapper> mBDMenuItems = new ArrayList();
        private BannerOperationData mBannerOperationData;
        private String mBusinessInvokeScheme;
        private String mCategoryData;
        private String mCategoryInfo;
        private String mCommand;
        private String mContent;
        private List<CustomItem> mCustomItems = new ArrayList();
        private String mEntrance;
        private String mExtPage;
        private List<String> mFileShareLists;
        private Map<String, String> mFunctionTips = new HashMap();
        private String mHotResourceAnimConfig;
        private Bitmap mIconBitmap;
        private byte[] mIconBytes;
        private boolean mIconNeedRecycle;
        private String mIconUrl;
        private String mIconUrlSmall;
        private Bitmap mImageBitmap;
        private byte[] mImageBytes;
        private boolean mImageNeedRecycle;
        private int mImagePreviewHeight;
        private int mImagePreviewWidth;
        private String mImageUrl;
        private String mLinkUrl;
        private String mMenuItem;
        private boolean mNeedImagePreview;
        private String mPanel;
        private String mPanelStyle = "0";
        private int mPanelXOffset;
        private String mPosterShareTalosData;
        private List<String> mRemoveMenuItems = new ArrayList();
        private int mShareType;
        private String mSource;
        private SharePageEnum mSourcePage;
        private String mStrategyInfo;
        private String mSystemShareIntentType;
        private String mTalosLiteData;
        private String mTextContent;
        private String mTheme;
        private String mTitle;
        private boolean mUseSystemToast;
        private String mUserInfo;
        private String mVideoUrl;
        private String mWeiboTopic;

        public Builder setTitle(String shareTitle) {
            this.mTitle = shareTitle;
            return this;
        }

        public Builder setContent(String shareContent) {
            this.mContent = shareContent;
            return this;
        }

        public Builder setPanelStyle(String style) {
            this.mPanelStyle = style;
            return this;
        }

        public Builder setLinkUrl(String linkUrl) {
            this.mLinkUrl = linkUrl;
            return this;
        }

        public Builder setMediaType(String menuType) {
            this.mMenuItem = menuType;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.mImageUrl = imageUrl;
            return this;
        }

        public Builder setImageBytes(byte[] bytes) {
            this.mImageBytes = bytes;
            return this;
        }

        public Builder setImageBitmap(Bitmap bitmap, boolean needRecycle) {
            this.mImageBitmap = bitmap;
            this.mImageNeedRecycle = needRecycle;
            return this;
        }

        public Builder setTextContent(String textShareContent) {
            this.mTextContent = textShareContent;
            return this;
        }

        public Builder setIconUrl(String iconUrl) {
            this.mIconUrl = iconUrl;
            return this;
        }

        public Builder setIconUrlSmall(String iconUrlSmall) {
            this.mIconUrlSmall = iconUrlSmall;
            return this;
        }

        public Builder setIconBytes(byte[] bytes) {
            this.mIconBytes = bytes;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap, boolean needRecycle) {
            this.mIconBitmap = bitmap;
            this.mIconNeedRecycle = needRecycle;
            return this;
        }

        public Builder setVideoUrl(String videoUrl) {
            this.mVideoUrl = videoUrl;
            return this;
        }

        public Builder setSource(String source) {
            this.mSource = source;
            return this;
        }

        public Builder setFileShareList(List<String> list) {
            this.mFileShareLists = list;
            return this;
        }

        public Builder addCustomShare(String plateFormName, String title, String content) {
            if (TextUtils.isEmpty(plateFormName) || TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
                return this;
            }
            for (int i2 = 0; i2 < this.mCustomItems.size(); i2++) {
                if (TextUtils.equals(this.mCustomItems.get(i2).getPlatformName(), plateFormName)) {
                    return this;
                }
            }
            CustomItem customItem = new CustomItem();
            customItem.setTitle(title);
            customItem.setContent(content);
            customItem.setPlatformName(plateFormName);
            this.mCustomItems.add(customItem);
            return this;
        }

        public Builder setAudioUrl(String audioUrl) {
            this.mAudioUrl = audioUrl;
            return this;
        }

        public Builder setShareType(int shareType) {
            this.mShareType = shareType;
            return this;
        }

        public Builder setSourcePage(SharePageEnum sharePage) {
            this.mSourcePage = sharePage;
            return this;
        }

        public Builder setTheme(String theme) {
            this.mTheme = theme;
            return this;
        }

        public Builder setUserInfo(String userInfo) {
            this.mUserInfo = userInfo;
            return this;
        }

        public Builder setCategoryInfo(String categoryInfo) {
            this.mCategoryInfo = categoryInfo;
            return this;
        }

        public Builder setScreenShot(boolean screenShot) {
            this.isScreenShot = screenShot;
            return this;
        }

        public Builder setCommandData(String commandData) {
            this.mCommand = commandData;
            return this;
        }

        public Builder setCategoryData(String categoryData) {
            this.mCategoryData = categoryData;
            return this;
        }

        public Builder setPanel(String panel) {
            this.mPanel = panel;
            return this;
        }

        public Builder setShowToast(boolean showToast) {
            this.isSDKShowToast = showToast;
            return this;
        }

        public Builder setWeiboTopic(String weiboTopic) {
            this.mWeiboTopic = weiboTopic;
            return this;
        }

        public Builder isWeixinOnly(boolean weixinOnly) {
            this.isWeixinOnly = weixinOnly;
            return this;
        }

        public Builder setHotResourceAnimeConfig(String hotResourceAnimeConfig) {
            this.mHotResourceAnimConfig = hotResourceAnimeConfig;
            return this;
        }

        public Builder addBDMenuItem(String iconUrl, String name, int position, boolean showTips, String identifier) {
            return addBDMenuItem(-1, iconUrl, name, position, showTips, identifier);
        }

        public Builder addBDMenuItem(int resId, String name, int position, boolean showTips, String identifier) {
            return addBDMenuItem(resId, (String) null, name, position, showTips, identifier);
        }

        private Builder addBDMenuItem(int resId, String iconUrl, String name, int position, boolean showTips, String identifier) {
            if ((resId < 0 && TextUtils.isEmpty(iconUrl)) || TextUtils.isEmpty(name) || position < 0) {
                return this;
            }
            for (int i2 = 0; i2 < this.mBDMenuItems.size(); i2++) {
                if (TextUtils.equals(name, this.mBDMenuItems.get(i2).getText())) {
                    return this;
                }
            }
            MenuTypeWrapper bdMenuItem = new MenuTypeWrapper();
            bdMenuItem.setText(name);
            bdMenuItem.setResId(resId);
            bdMenuItem.setPosition(position);
            bdMenuItem.setShowFunctionTips(showTips);
            bdMenuItem.setIdentifier(identifier);
            bdMenuItem.setIconUrl(iconUrl);
            this.mBDMenuItems.add(bdMenuItem);
            return this;
        }

        public Builder addRemoveMenuItem(String removeMenuItem) {
            if (!TextUtils.isEmpty(removeMenuItem)) {
                this.mRemoveMenuItems.add(removeMenuItem);
            }
            return this;
        }

        public Builder setAppID(String appID) {
            this.mAppId = appID;
            return this;
        }

        public Builder setBusinessInvokeScheme(String businessInvokeScheme) {
            this.mBusinessInvokeScheme = businessInvokeScheme;
            return this;
        }

        public Builder setStrategyInfo(String strategyInfo) {
            this.mStrategyInfo = strategyInfo;
            return this;
        }

        public Builder setNeedImagePreview(boolean needImagePreview) {
            this.mNeedImagePreview = needImagePreview;
            return this;
        }

        public Builder setImagePreviewHeight(int imagePreviewHeight) {
            this.mImagePreviewHeight = imagePreviewHeight;
            return this;
        }

        public Builder setImagePreviewWidth(int imagePreviewWidth) {
            this.mImagePreviewWidth = imagePreviewWidth;
            return this;
        }

        public Builder setShareEntrance(String entrance) {
            this.mEntrance = entrance;
            return this;
        }

        public Builder setShareExtPage(String extPage) {
            this.mExtPage = extPage;
            return this;
        }

        public Builder setTalosLiteData(String talosLiteData) {
            this.mTalosLiteData = talosLiteData;
            return this;
        }

        public Builder setBannerOperationData(BannerOperationData bannerOperationData) {
            this.mBannerOperationData = bannerOperationData;
            return this;
        }

        public Builder setHideSharePanelAnim(boolean hideSharePanelAnim2) {
            this.hideSharePanelAnim = hideSharePanelAnim2;
            return this;
        }

        public Builder setSystemShareIntentType(String systemShareIntentType) {
            this.mSystemShareIntentType = systemShareIntentType;
            return this;
        }

        public Builder setPosterTalosData(String posterTalosData) {
            this.mPosterShareTalosData = posterTalosData;
            return this;
        }

        public Builder setUseSystemToast(boolean useSystemToast) {
            this.mUseSystemToast = useSystemToast;
            return this;
        }

        public Builder setPanelXOffset(int xOffset) {
            this.mPanelXOffset = xOffset;
            return this;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0227, code lost:
            if (r0.equals("9") != false) goto L_0x025d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.baidu.searchbox.boxshare.bean.ShareContent.Builder parseH5JsonData(java.lang.String r20) throws org.json.JSONException {
            /*
                r19 = this;
                r6 = r19
                r7 = r20
                boolean r0 = com.baidu.searchbox.boxshare.bean.ShareContent.DEBUG
                if (r0 == 0) goto L_0x0022
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "H5JsonData: "
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r7)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "BaiduShareContent"
                android.util.Log.d(r1, r0)
            L_0x0022:
                boolean r0 = android.text.TextUtils.isEmpty(r20)
                if (r0 != 0) goto L_0x02db
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>(r7)
                r8 = r0
                int r0 = r8.length()
                if (r0 <= 0) goto L_0x02db
                java.lang.String r0 = "title"
                java.lang.String r0 = r8.optString(r0)
                r6.mTitle = r0
                java.lang.String r0 = "linkUrl"
                java.lang.String r1 = ""
                java.lang.String r0 = r8.optString(r0, r1)
                r6.mLinkUrl = r0
                java.lang.String r0 = "mediaType"
                java.lang.String r1 = "all"
                java.lang.String r0 = r8.optString(r0, r1)
                r6.mMenuItem = r0
                java.lang.String r0 = "content"
                java.lang.String r0 = r8.optString(r0)
                r6.mContent = r0
                java.lang.String r0 = "imageUrl"
                java.lang.String r0 = r8.optString(r0)
                r6.mImageUrl = r0
                java.lang.String r0 = "iconUrl"
                java.lang.String r0 = r8.optString(r0)
                r6.mIconUrl = r0
                java.lang.String r0 = "iconUrlSmall"
                java.lang.String r0 = r8.optString(r0)
                r6.mIconUrlSmall = r0
                java.lang.String r0 = "audioUrl"
                java.lang.String r0 = r8.optString(r0)
                r6.mAudioUrl = r0
                java.lang.String r0 = "videoUrl"
                java.lang.String r0 = r8.optString(r0)
                r6.mVideoUrl = r0
                java.lang.String r0 = "source"
                java.lang.String r0 = r8.optString(r0)
                r6.mSource = r0
                java.lang.String r0 = "pannel"
                java.lang.String r0 = r8.optString(r0)
                r6.mPanel = r0
                java.lang.String r0 = "theme"
                java.lang.String r0 = r8.optString(r0)
                r6.mTheme = r0
                java.lang.String r0 = "userInfo"
                java.lang.String r0 = r8.optString(r0)
                r6.mUserInfo = r0
                java.lang.String r0 = "categoryInfo"
                java.lang.String r0 = r8.optString(r0)
                r6.mCategoryInfo = r0
                java.lang.String r0 = "command"
                java.lang.String r0 = r8.optString(r0)
                r6.mCommand = r0
                java.lang.String r0 = "categoryData"
                java.lang.String r0 = r8.optString(r0)
                r6.mCategoryData = r0
                java.lang.String r0 = "isScreenShot"
                boolean r0 = r8.optBoolean(r0)
                r6.isScreenShot = r0
                java.lang.String r0 = "weiboTopic"
                java.lang.String r0 = r8.optString(r0)
                r6.mWeiboTopic = r0
                java.lang.String r0 = "textContent"
                java.lang.String r0 = r8.optString(r0)
                r6.mTextContent = r0
                com.baidu.searchbox.boxshare.bean.BannerOperationData r0 = com.baidu.searchbox.boxshare.bean.BannerOperationData.parseJsonData(r20)
                r6.mBannerOperationData = r0
                java.lang.String r0 = "panelStyle"
                java.lang.String r1 = "0"
                java.lang.String r0 = r8.optString(r0, r1)
                r6.mPanelStyle = r0
                java.lang.String r0 = "strategy_info"
                java.lang.String r0 = r8.optString(r0)
                r6.mStrategyInfo = r0
                java.lang.String r0 = "needPreview"
                java.lang.String r0 = r8.optString(r0)
                java.lang.String r9 = "1"
                boolean r0 = android.text.TextUtils.equals(r0, r9)
                r6.mNeedImagePreview = r0
                java.lang.String r0 = "previewHeight"
                int r0 = r8.optInt(r0)
                r6.mImagePreviewHeight = r0
                java.lang.String r0 = "previewWidth"
                int r0 = r8.optInt(r0)
                r6.mImagePreviewWidth = r0
                java.lang.String r0 = "entrance"
                java.lang.String r0 = r8.optString(r0)
                r6.mEntrance = r0
                java.lang.String r0 = "extPage"
                java.lang.String r0 = r8.optString(r0)
                r6.mExtPage = r0
                java.lang.String r0 = "talosLiteData"
                java.lang.String r0 = r8.optString(r0)
                r6.mTalosLiteData = r0
                java.lang.String r0 = "hotShareConfig"
                java.lang.String r0 = r8.optString(r0)
                r6.mHotResourceAnimConfig = r0
                java.lang.String r0 = "businessInvoke"
                java.lang.String r0 = r8.optString(r0)
                r6.mBusinessInvokeScheme = r0
                java.lang.String r0 = "hideSharePanelAnim"
                int r0 = r8.optInt(r0)
                r10 = 0
                r11 = 1
                if (r0 != r11) goto L_0x0150
                r0 = r11
                goto L_0x0151
            L_0x0150:
                r0 = r10
            L_0x0151:
                r6.hideSharePanelAnim = r0
                java.lang.String r0 = "systemShareIntentType"
                java.lang.String r0 = r8.optString(r0)
                r6.mSystemShareIntentType = r0
                java.lang.String r0 = "poster_taloslitedata"
                java.lang.String r0 = r8.optString(r0)
                r6.mPosterShareTalosData = r0
                java.lang.String r0 = "useSystemToast"
                java.lang.String r0 = r8.optString(r0)
                boolean r0 = android.text.TextUtils.equals(r0, r9)
                r6.mUseSystemToast = r0
                java.lang.String r0 = "panelXOffset"
                int r0 = r8.optInt(r0)
                r6.mPanelXOffset = r0
                java.lang.String r0 = "functionTips"
                org.json.JSONObject r12 = r8.optJSONObject(r0)
                if (r12 == 0) goto L_0x019d
                java.util.Iterator r0 = r12.keys()
            L_0x0187:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x019d
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                java.util.Map<java.lang.String, java.lang.String> r2 = r6.mFunctionTips
                java.lang.String r3 = r12.optString(r1)
                r2.put(r1, r3)
                goto L_0x0187
            L_0x019d:
                java.lang.String r0 = "customChannel"
                org.json.JSONArray r13 = r8.optJSONArray(r0)
                if (r13 == 0) goto L_0x01de
                r0 = 0
                r14 = r0
            L_0x01a7:
                int r0 = r13.length()
                if (r14 >= r0) goto L_0x01de
                org.json.JSONObject r15 = r13.getJSONObject(r14)
                java.lang.String r0 = "identifier"
                java.lang.String r16 = r15.optString(r0)
                java.lang.String r0 = "name"
                java.lang.String r17 = r15.optString(r0)
                java.lang.String r0 = "showFunctionTips"
                java.lang.String r5 = r15.optString(r0)
                int r1 = com.baidu.searchbox.boxshare.bean.ShareContent.getResID(r16)
                r3 = 15
                boolean r4 = android.text.TextUtils.equals(r5, r9)
                r0 = r19
                r2 = r17
                r18 = r5
                r5 = r16
                r0.addBDMenuItem((int) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (java.lang.String) r5)
                int r14 = r14 + 1
                goto L_0x01a7
            L_0x01de:
                java.lang.String r0 = "type"
                java.lang.String r0 = r8.optString(r0)
                r1 = -1
                int r2 = r0.hashCode()
                r3 = 5
                r4 = 4
                r5 = 3
                r14 = 9
                switch(r2) {
                    case -416447130: goto L_0x0251;
                    case 49: goto L_0x0249;
                    case 51: goto L_0x023f;
                    case 52: goto L_0x0235;
                    case 53: goto L_0x022a;
                    case 57: goto L_0x0221;
                    case 116079: goto L_0x0216;
                    case 3556653: goto L_0x020b;
                    case 100313435: goto L_0x0200;
                    case 112202875: goto L_0x01f4;
                    default: goto L_0x01f2;
                }
            L_0x01f2:
                goto L_0x025c
            L_0x01f4:
                java.lang.String r2 = "video"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = 7
                goto L_0x025d
            L_0x0200:
                java.lang.String r2 = "image"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = r3
                goto L_0x025d
            L_0x020b:
                java.lang.String r2 = "text"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = r11
                goto L_0x025d
            L_0x0216:
                java.lang.String r2 = "url"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = r5
                goto L_0x025d
            L_0x0221:
                java.lang.String r2 = "9"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                goto L_0x025d
            L_0x022a:
                java.lang.String r2 = "5"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = 8
                goto L_0x025d
            L_0x0235:
                java.lang.String r2 = "4"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = 6
                goto L_0x025d
            L_0x023f:
                java.lang.String r2 = "3"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = r4
                goto L_0x025d
            L_0x0249:
                boolean r0 = r0.equals(r9)
                if (r0 == 0) goto L_0x01f2
                r10 = 2
                goto L_0x025d
            L_0x0251:
                java.lang.String r2 = "screenshot"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x01f2
                r10 = r14
                goto L_0x025d
            L_0x025c:
                r10 = r1
            L_0x025d:
                switch(r10) {
                    case 0: goto L_0x026f;
                    case 1: goto L_0x026f;
                    case 2: goto L_0x026c;
                    case 3: goto L_0x026c;
                    case 4: goto L_0x0269;
                    case 5: goto L_0x0269;
                    case 6: goto L_0x0266;
                    case 7: goto L_0x0266;
                    case 8: goto L_0x0263;
                    case 9: goto L_0x0263;
                    default: goto L_0x0260;
                }
            L_0x0260:
                r6.mShareType = r11
                goto L_0x0272
            L_0x0263:
                r6.mShareType = r3
                goto L_0x0272
            L_0x0266:
                r6.mShareType = r4
                goto L_0x0272
            L_0x0269:
                r6.mShareType = r5
                goto L_0x0272
            L_0x026c:
                r6.mShareType = r11
                goto L_0x0272
            L_0x026f:
                r6.mShareType = r14
            L_0x0272:
                java.lang.String r0 = "wbtitle"
                java.lang.String r0 = r8.optString(r0)
                java.lang.String r1 = "wbcontent"
                java.lang.String r1 = r8.optString(r1)
                java.lang.String r2 = "sinaweibo"
                r6.addCustomShare(r2, r0, r1)
                java.lang.String r0 = "wxftitle"
                java.lang.String r0 = r8.optString(r0)
                java.lang.String r1 = "wxfcontent"
                java.lang.String r1 = r8.optString(r1)
                java.lang.String r2 = "weixin_friend"
                r6.addCustomShare(r2, r0, r1)
                java.lang.String r0 = "wxttitle"
                java.lang.String r0 = r8.optString(r0)
                java.lang.String r1 = "wxtcontent"
                java.lang.String r1 = r8.optString(r1)
                java.lang.String r2 = "weixin_timeline"
                r6.addCustomShare(r2, r0, r1)
                java.lang.String r0 = "qftitle"
                java.lang.String r0 = r8.optString(r0)
                java.lang.String r1 = "qfcontent"
                java.lang.String r1 = r8.optString(r1)
                java.lang.String r2 = "qqfriend"
                r6.addCustomShare(r2, r0, r1)
                java.lang.String r0 = "qztitle"
                java.lang.String r0 = r8.optString(r0)
                java.lang.String r1 = "qzcontent"
                java.lang.String r1 = r8.optString(r1)
                java.lang.String r2 = "qqdenglu"
                r6.addCustomShare(r2, r0, r1)
            L_0x02db:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.boxshare.bean.ShareContent.Builder.parseH5JsonData(java.lang.String):com.baidu.searchbox.boxshare.bean.ShareContent$Builder");
        }

        private void applyBaiduShareContent(ShareContent shareContent) {
            String unused = shareContent.mTitle = this.mTitle;
            String unused2 = shareContent.mContent = this.mContent;
            String unused3 = shareContent.mLinkUrl = this.mLinkUrl;
            String unused4 = shareContent.mTextContent = this.mTextContent;
            String unused5 = shareContent.mMenuItem = this.mMenuItem;
            Bitmap unused6 = shareContent.mIconBitmap = this.mIconBitmap;
            byte[] unused7 = shareContent.mIconBytes = this.mIconBytes;
            String unused8 = shareContent.mIconUrl = this.mIconUrl;
            String unused9 = shareContent.mIconUrlSmall = this.mIconUrlSmall;
            boolean unused10 = shareContent.mIconNeedRecycle = this.mIconNeedRecycle;
            Bitmap unused11 = shareContent.mImageBitmap = this.mImageBitmap;
            byte[] unused12 = shareContent.mImageBytes = this.mImageBytes;
            String unused13 = shareContent.mImageUrl = this.mImageUrl;
            boolean unused14 = shareContent.mImageNeedRecycle = this.mImageNeedRecycle;
            List unused15 = shareContent.mCustomItems = this.mCustomItems;
            String unused16 = shareContent.mAudioUrl = this.mAudioUrl;
            String unused17 = shareContent.mVideoUrl = this.mVideoUrl;
            int unused18 = shareContent.mShareType = this.mShareType;
            String unused19 = shareContent.mSource = this.mSource;
            SharePageEnum unused20 = shareContent.mSourcePage = this.mSourcePage;
            String unused21 = shareContent.mTheme = this.mTheme;
            String unused22 = shareContent.mUserInfo = this.mUserInfo;
            String unused23 = shareContent.mCategoryData = this.mCategoryData;
            String unused24 = shareContent.mCategoryInfo = this.mCategoryInfo;
            String unused25 = shareContent.mPanel = this.mPanel;
            boolean unused26 = shareContent.isScreenShot = this.isScreenShot;
            boolean unused27 = shareContent.isSDKShowToast = this.isSDKShowToast;
            String unused28 = shareContent.mCommandData = this.mCommand;
            String unused29 = shareContent.mWeiboTopic = this.mWeiboTopic;
            boolean unused30 = shareContent.isWeixinOnly = this.isWeixinOnly;
            List unused31 = shareContent.mBDMenuItems = this.mBDMenuItems;
            String unused32 = shareContent.mAppId = this.mAppId;
            List unused33 = shareContent.mFileShareLists = this.mFileShareLists;
            List unused34 = shareContent.mRemoveMenuItems = this.mRemoveMenuItems;
            Map unused35 = shareContent.mFunctionTips = this.mFunctionTips;
            String unused36 = shareContent.mPanelStyle = this.mPanelStyle;
            String unused37 = shareContent.mStrategyInfo = this.mStrategyInfo;
            boolean unused38 = shareContent.mNeedImagePreview = this.mNeedImagePreview;
            int unused39 = shareContent.mImagePreviewHeight = this.mImagePreviewHeight;
            int unused40 = shareContent.mImagePreviewWidth = this.mImagePreviewWidth;
            String unused41 = shareContent.mEntrance = this.mEntrance;
            String unused42 = shareContent.mExtPage = this.mExtPage;
            String unused43 = shareContent.mTalosLiteData = this.mTalosLiteData;
            String unused44 = shareContent.mBusinessInvokeScheme = this.mBusinessInvokeScheme;
            BannerOperationData unused45 = shareContent.mBannerOperationData = this.mBannerOperationData;
            String unused46 = shareContent.mHotResourceAnimeConfig = this.mHotResourceAnimConfig;
            boolean unused47 = shareContent.hideSharePanelAnim = this.hideSharePanelAnim;
            String unused48 = shareContent.mSystemShareIntentType = this.mSystemShareIntentType;
            String unused49 = shareContent.mPosterShareTalosData = this.mPosterShareTalosData;
            boolean unused50 = shareContent.mUseSystemToast = this.mUseSystemToast;
            int unused51 = shareContent.mPanelXOffset = this.mPanelXOffset;
        }

        public ShareContent create() {
            ShareContent shareContent = new ShareContent();
            applyBaiduShareContent(shareContent);
            return shareContent;
        }
    }
}
