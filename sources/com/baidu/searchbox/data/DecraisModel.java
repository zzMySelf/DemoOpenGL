package com.baidu.searchbox.data;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.statistics.ButtonSourceUtil;
import java.util.ArrayList;

public class DecraisModel implements NoProGuard {
    public static final int DEFAULT_RECOMMEND_APP = 1;
    public static final int GAMBLING_DOWNLOAD = 3;
    public static final String HJACK_BUDGET_TYPE_1 = "1";
    public static final String HJACK_BUDGET_TYPE_2 = "2";
    public static final int HJACK_POPUP_STYLE_NEW = 2;
    public static final int HJACK_POPUP_STYLE_OLD = 1;
    public static final int NORMAL_RECOMMEND_APP = 0;
    public static final int PRON_DOWNLOAD = 2;
    public String advItem;
    public String appInfoSource;
    public String appName;
    public String appsearchDownloadURL;
    public String authTagText;
    public String authorityUrl;
    public String budgetType;
    public String developerName;
    public String downloadBtnText;
    public String extraInfo;
    public String funcIntro;
    public int hjackPopupStyle = 1;
    public String hjackSid;
    public String iconUrl;
    public long imTimeSign;
    public boolean isDecrais;
    public String logInfo;
    public String needPopup = "0";
    public int noHjack;
    public String normalText;
    public String originAppName;
    public String originPkgName;
    public String originVersioncode;
    public String pkgName;
    public String privacyPolicyUrl;
    public ArrayList<RecommendAppInfo> recommendAppList;
    public String recommendTitle;
    public String safeDownloadFileName;
    public String safeDownloadUrl;
    public String safeTagText;
    public String safeTips;
    public ShowAppInfoModel showAppInfo;
    public String showDownloadProcess;
    public String source;
    public String sourceForBaiduboxapp;
    public String statisticInfo;
    public int strategyType = -1;
    public String testFlag;
    public String thirdBtnStyle = "0";
    public String version;

    public String toString() {
        return "iconUrl:" + ButtonSourceUtil.getDisplayString(this.iconUrl) + " appName:" + ButtonSourceUtil.getDisplayString(this.appName) + " isDecrais:" + ButtonSourceUtil.getDisplayString(Boolean.valueOf(this.isDecrais)) + " noHjack:" + ButtonSourceUtil.getDisplayString(Integer.valueOf(this.noHjack)) + " appsearchDownloadURL:" + ButtonSourceUtil.getDisplayString(this.appsearchDownloadURL) + " statisticInfo:" + ButtonSourceUtil.getDisplayString(this.statisticInfo) + " hjackSid:" + ButtonSourceUtil.getDisplayString(this.hjackSid) + " safeTips:" + ButtonSourceUtil.getDisplayString(this.safeTips) + " downloadBtnText:" + ButtonSourceUtil.getDisplayString(this.downloadBtnText) + " normalText:" + ButtonSourceUtil.getDisplayString(this.normalText) + " needPopup:" + ButtonSourceUtil.getDisplayString(this.needPopup) + " thirdBtnStyle:" + ButtonSourceUtil.getDisplayString(this.thirdBtnStyle) + " testFlag:" + ButtonSourceUtil.getDisplayString(this.testFlag) + " safeTagText:" + ButtonSourceUtil.getDisplayString(this.safeTagText) + " authTagText:" + ButtonSourceUtil.getDisplayString(this.authTagText) + " recommendTitle:" + ButtonSourceUtil.getDisplayString(this.recommendTitle) + " recommendAppList:" + ButtonSourceUtil.getDisplayString(this.recommendAppList) + " source:" + ButtonSourceUtil.getDisplayString(this.source) + " extraInfo:" + ButtonSourceUtil.getDisplayString(this.extraInfo) + " pkgName:" + ButtonSourceUtil.getDisplayString(this.pkgName) + " originPkgName:" + ButtonSourceUtil.getDisplayString(this.originPkgName) + " originAppName:" + ButtonSourceUtil.getDisplayString(this.originAppName) + " appInfoSource:" + ButtonSourceUtil.getDisplayString(this.appInfoSource) + " sourceForBaiduboxapp:" + ButtonSourceUtil.getDisplayString(this.sourceForBaiduboxapp) + " developerName:" + ButtonSourceUtil.getDisplayString(this.developerName) + " privacyPolicyUrl:" + ButtonSourceUtil.getDisplayString(this.privacyPolicyUrl) + " funcIntro:" + ButtonSourceUtil.getDisplayString(this.funcIntro) + " authorityUrl:" + ButtonSourceUtil.getDisplayString(this.authorityUrl) + " version:" + ButtonSourceUtil.getDisplayString(this.version) + " budgetType:" + ButtonSourceUtil.getDisplayString(this.budgetType) + " logInfo:" + ButtonSourceUtil.getDisplayString(this.logInfo) + " showAppInfo:" + ButtonSourceUtil.getDisplayString(this.showAppInfo) + " safeDownloadUrl:" + ButtonSourceUtil.getDisplayString(this.safeDownloadUrl) + " safeDownloadFileName:" + ButtonSourceUtil.getDisplayString(this.safeDownloadFileName) + " showDownloadProcess:" + ButtonSourceUtil.getDisplayString(this.showDownloadProcess) + " originVersioncode:" + ButtonSourceUtil.getDisplayString(this.originVersioncode) + " advItem:" + ButtonSourceUtil.getDisplayString(this.advItem) + " imTimeSign:" + ButtonSourceUtil.getDisplayString(Long.valueOf(this.imTimeSign));
    }
}
