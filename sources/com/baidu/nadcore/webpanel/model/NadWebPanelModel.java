package com.baidu.nadcore.webpanel.model;

public class NadWebPanelModel {
    private AdData adData;
    private String adInvokeFlag = null;
    private String adName = null;
    private boolean adjustStatusBar = true;
    private boolean autoPopup = false;
    private long chargeDelayTime = -1;
    private String chargeUrl;
    private boolean displayBackGroundMask = false;
    private String ext;
    private boolean forbidClosePanel = false;
    private boolean forbidMoveFollowHand = false;
    private boolean forbidMoveUpFollowHand = false;
    private int heightCalculateMode;
    private double heightRatio;
    private boolean hideSceneHideNavigation = false;
    private boolean isRewardVideo = false;
    private String logSwitch;
    private String lpOrgType = null;
    private String lpRealUrl = null;
    private String overrideLoadingMap = null;
    private String panelControl;
    private boolean panelDismissControlByH5 = true;
    private String panelType = "0";
    private String sdkScript;
    private boolean showDownArrow = false;
    private boolean showExpandIconView = false;
    private boolean showTopRightIcon = false;
    private boolean subscribeH5CallBack = false;
    private boolean topBlankClickDisable = false;
    private String url;

    private NadWebPanelModel() {
    }

    public NadWebPanelModel(String url2, double heightRatio2, int heightCalculateMode2, String ext2) {
        this.url = url2;
        this.heightRatio = heightRatio2;
        this.heightCalculateMode = heightCalculateMode2;
        this.ext = ext2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public double getHeightRatio() {
        return this.heightRatio;
    }

    public void setHeightRatio(double heightRatio2) {
        this.heightRatio = heightRatio2;
    }

    public int getHeightCalculateMode() {
        return this.heightCalculateMode;
    }

    public void setHeightCalculateMode(int heightCalculateMode2) {
        this.heightCalculateMode = heightCalculateMode2;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String ext2) {
        this.ext = ext2;
    }

    public AdData getAdData() {
        return this.adData;
    }

    public void setAdData(AdData adData2) {
        this.adData = adData2;
    }

    public String getSdkScript() {
        return this.sdkScript;
    }

    public void setSdkScript(String sdkScript2) {
        this.sdkScript = sdkScript2;
    }

    public String getLogSwitch() {
        return this.logSwitch;
    }

    public void setLogSwitch(String logSwitch2) {
        this.logSwitch = logSwitch2;
    }

    public boolean isAdjustStatusBar() {
        return this.adjustStatusBar;
    }

    public void setAdjustStatusBar(boolean adjustStatusBar2) {
        this.adjustStatusBar = adjustStatusBar2;
    }

    public boolean isHideSceneHideNavigation() {
        return this.hideSceneHideNavigation;
    }

    public void setHideSceneHideNavigation(boolean hideSceneHideNavigation2) {
        this.hideSceneHideNavigation = hideSceneHideNavigation2;
    }

    public boolean isDisplayBackGroundMask() {
        return this.displayBackGroundMask;
    }

    public void setDisplayBackGroundMask(boolean displayBackGroundMask2) {
        this.displayBackGroundMask = displayBackGroundMask2;
    }

    public boolean isPanelDismissControlByH5() {
        return this.panelDismissControlByH5;
    }

    public void setPanelDismissControlByH5(boolean panelDismissControlByH52) {
        this.panelDismissControlByH5 = panelDismissControlByH52;
    }

    public void setSubscribeH5CallBack(boolean subscribeH5CallBack2) {
        this.subscribeH5CallBack = subscribeH5CallBack2;
    }

    public boolean isSubscribeH5CallBack() {
        return this.subscribeH5CallBack;
    }

    public String getChargeUrl() {
        return this.chargeUrl;
    }

    public void setChargeUrl(String chargeUrl2) {
        this.chargeUrl = chargeUrl2;
    }

    public String getPanelControl() {
        return this.panelControl;
    }

    public void setPanelControl(String panelControl2) {
        this.panelControl = panelControl2;
    }

    public boolean isTopBlankClickDisable() {
        return this.topBlankClickDisable;
    }

    public void setTopBlankClickDisable(boolean topBlankClickDisable2) {
        this.topBlankClickDisable = topBlankClickDisable2;
    }

    public boolean isShowTopRightIcon() {
        return this.showTopRightIcon;
    }

    public void setShowTopRightIcon(boolean showTopRightIcon2) {
        this.showTopRightIcon = showTopRightIcon2;
    }

    public boolean isShowDownArrow() {
        return this.showDownArrow;
    }

    public void setShowDownArrow(boolean showDownArrow2) {
        this.showDownArrow = showDownArrow2;
    }

    public boolean isShowExpandIconView() {
        return this.showExpandIconView;
    }

    public void setShowExpandIconView(boolean showExpandIconView2) {
        this.showExpandIconView = showExpandIconView2;
    }

    public boolean isForbidClosePanel() {
        return this.forbidClosePanel;
    }

    public void setForbidClosePanel(boolean forbidBackBtnClose) {
        this.forbidClosePanel = forbidBackBtnClose;
    }

    public boolean isForbidMoveFollowHand() {
        return this.forbidMoveFollowHand;
    }

    public void setForbidMoveFollowHand(boolean forbidMoveFollowHand2) {
        this.forbidMoveFollowHand = forbidMoveFollowHand2;
    }

    public boolean isForbidMoveUpFollowHand() {
        return this.forbidMoveUpFollowHand;
    }

    public void setForbidMoveUpFollowHand(boolean forbidMoveUpFollowHand2) {
        this.forbidMoveUpFollowHand = forbidMoveUpFollowHand2;
    }

    public boolean isRewardVideo() {
        return this.isRewardVideo;
    }

    public void setRewardVideo(boolean isRewardVideo2) {
        this.isRewardVideo = isRewardVideo2;
    }

    public String getLpRealUrl() {
        return this.lpRealUrl;
    }

    public void setLpRealUrl(String lpRealUrl2) {
        this.lpRealUrl = lpRealUrl2;
    }

    public String getLpOrgType() {
        return this.lpOrgType;
    }

    public void setLpOrgType(String lpOrgType2) {
        this.lpOrgType = lpOrgType2;
    }

    public String getAdInvokeFlag() {
        return this.adInvokeFlag;
    }

    public void setAdInvokeFlag(String adInvokeFlag2) {
        this.adInvokeFlag = adInvokeFlag2;
    }

    public void setAutoPopup(boolean autoPopup2) {
        this.autoPopup = autoPopup2;
    }

    public boolean getAutoPopup() {
        return this.autoPopup;
    }

    public void setChargeDelayTime(long chargeDelayTime2) {
        this.chargeDelayTime = chargeDelayTime2;
    }

    public long getChargeDelayTime() {
        return this.chargeDelayTime;
    }

    public void setPanelType(String panelType2) {
        this.panelType = panelType2;
    }

    public String getPanelType() {
        return this.panelType;
    }

    public void setOverrideLoadingMap(String overrideLoadingMap2) {
        this.overrideLoadingMap = overrideLoadingMap2;
    }

    public String getOverrideLoadingMap() {
        return this.overrideLoadingMap;
    }

    public void setAdName(String adName2) {
        this.adName = adName2;
    }

    public String getAdName() {
        return this.adName;
    }
}
