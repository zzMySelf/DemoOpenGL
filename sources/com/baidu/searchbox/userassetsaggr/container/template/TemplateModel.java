package com.baidu.searchbox.userassetsaggr.container.template;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.favor.data.MoviesModel;
import com.baidu.searchbox.favor.data.PlayletModel;
import com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b3\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001a\u0010@\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001a\u0010B\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010;\"\u0004\bC\u0010=R\u001a\u0010D\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010;\"\u0004\bE\u0010=R\u001a\u0010F\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010;\"\u0004\bG\u0010=R\u001e\u0010H\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010N\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u001c\u0010]\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\u001c\u0010`\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\"\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u000f\"\u0004\be\u0010\u0011R\u001a\u0010f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\u001c\u0010i\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR\u001c\u0010l\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\u001c\u0010o\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001c\u0010r\u001a\u0004\u0018\u00010sX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR\u001c\u0010{\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0006\"\u0004\b}\u0010\bR\u001d\u0010~\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001d\u0010\u0001\u001a\u00020:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010;\"\u0005\b\u0001\u0010=R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u0006\"\u0005\b¡\u0001\u0010\bR\u001f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0006\"\u0005\b¤\u0001\u0010\b¨\u0006¦\u0001"}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/template/TemplateModel;", "", "()V", "baoInfo", "", "getBaoInfo", "()Ljava/lang/String;", "setBaoInfo", "(Ljava/lang/String;)V", "classifyType", "getClassifyType", "setClassifyType", "discountTag", "", "getDiscountTag", "()Ljava/util/List;", "setDiscountTag", "(Ljava/util/List;)V", "duration", "getDuration", "setDuration", "extra1", "getExtra1", "setExtra1", "favorMoviesModel", "Lcom/baidu/searchbox/favor/data/MoviesModel;", "getFavorMoviesModel", "()Lcom/baidu/searchbox/favor/data/MoviesModel;", "setFavorMoviesModel", "(Lcom/baidu/searchbox/favor/data/MoviesModel;)V", "favorNumber", "getFavorNumber", "setFavorNumber", "fromPage", "getFromPage", "setFromPage", "fullSource", "getFullSource", "setFullSource", "historyMoviesModel", "Lcom/baidu/searchbox/history/api/data/MoviesModel;", "getHistoryMoviesModel", "()Lcom/baidu/searchbox/history/api/data/MoviesModel;", "setHistoryMoviesModel", "(Lcom/baidu/searchbox/history/api/data/MoviesModel;)V", "iconLabel", "getIconLabel", "setIconLabel", "image", "getImage", "setImage", "imageCount", "", "getImageCount", "()I", "setImageCount", "(I)V", "isDeadLink", "", "()Z", "setDeadLink", "(Z)V", "isEditMode", "setEditMode", "isSelect", "setSelect", "isShowFeedback", "setShowFeedback", "isShowGuarantee", "setShowGuarantee", "isShowServiceRate", "setShowServiceRate", "itemPosition", "getItemPosition", "()Ljava/lang/Integer;", "setItemPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "originalSource", "getOriginalSource", "setOriginalSource", "originalTitle", "getOriginalTitle", "setOriginalTitle", "playletModel", "Lcom/baidu/searchbox/favor/data/PlayletModel;", "getPlayletModel", "()Lcom/baidu/searchbox/favor/data/PlayletModel;", "setPlayletModel", "(Lcom/baidu/searchbox/favor/data/PlayletModel;)V", "portrait", "getPortrait", "setPortrait", "price", "getPrice", "setPrice", "saleStatus", "getSaleStatus", "setSaleStatus", "saleTag", "getSaleTag", "setSaleTag", "serviceRateUrl", "getServiceRateUrl", "setServiceRateUrl", "shopName", "getShopName", "setShopName", "shopUrl", "getShopUrl", "setShopUrl", "similarUrl", "getSimilarUrl", "setSimilarUrl", "snifferNetDiskTaskModel", "Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskTaskModel;", "getSnifferNetDiskTaskModel", "()Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskTaskModel;", "setSnifferNetDiskTaskModel", "(Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskTaskModel;)V", "source", "getSource", "setSource", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "titleKeyWord", "getTitleKeyWord", "setTitleKeyWord", "totalTime", "getTotalTime", "setTotalTime", "ttsFlag", "getTtsFlag", "setTtsFlag", "ukey", "getUkey", "setUkey", "url", "getUrl", "setUrl", "userDesc", "getUserDesc", "setUserDesc", "userName", "getUserName", "setUserName", "videoAuthorName", "getVideoAuthorName", "setVideoAuthorName", "videoCoverFourRatioThree", "getVideoCoverFourRatioThree", "setVideoCoverFourRatioThree", "videoCoverThreeRatioFour", "getVideoCoverThreeRatioFour", "setVideoCoverThreeRatioFour", "videoPlayCount", "getVideoPlayCount", "setVideoPlayCount", "vipIcon", "getVipIcon", "setVipIcon", "getBottomDialogShowSource", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TemplateModel.kt */
public final class TemplateModel {
    private String baoInfo;
    private String classifyType;
    private List<String> discountTag;
    private String duration;
    private String extra1;
    private MoviesModel favorMoviesModel;
    private String favorNumber;
    private String fromPage;
    private String fullSource;
    private com.baidu.searchbox.history.api.data.MoviesModel historyMoviesModel;
    private String iconLabel;
    private String image;
    private int imageCount;
    private boolean isDeadLink;
    private boolean isEditMode;
    private boolean isSelect;
    private boolean isShowFeedback;
    private boolean isShowGuarantee;
    private boolean isShowServiceRate;
    private Integer itemPosition;
    private String originalSource;
    private String originalTitle;
    private PlayletModel playletModel;
    private String portrait;
    private String price;
    private String saleStatus;
    private List<String> saleTag;
    private String serviceRateUrl = "";
    private String shopName;
    private String shopUrl;
    private String similarUrl;
    private SnifferNetDiskTaskModel snifferNetDiskTaskModel;
    private String source;
    private String subTitle;
    private String title;
    private String titleKeyWord;
    private String totalTime = "0";
    private boolean ttsFlag;
    private String ukey;
    private String url;
    private String userDesc;
    private String userName;
    private String videoAuthorName;
    private String videoCoverFourRatioThree;
    private String videoCoverThreeRatioFour;
    private String videoPlayCount;
    private String vipIcon;

    public final String getUkey() {
        return this.ukey;
    }

    public final void setUkey(String str) {
        this.ukey = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final boolean isEditMode() {
        return this.isEditMode;
    }

    public final void setEditMode(boolean z) {
        this.isEditMode = z;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final boolean getTtsFlag() {
        return this.ttsFlag;
    }

    public final void setTtsFlag(boolean z) {
        this.ttsFlag = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    public final void setOriginalTitle(String str) {
        this.originalTitle = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final String getIconLabel() {
        return this.iconLabel;
    }

    public final void setIconLabel(String str) {
        this.iconLabel = str;
    }

    public final String getTitleKeyWord() {
        return this.titleKeyWord;
    }

    public final void setTitleKeyWord(String str) {
        this.titleKeyWord = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getFullSource() {
        return this.fullSource;
    }

    public final void setFullSource(String str) {
        this.fullSource = str;
    }

    public final String getOriginalSource() {
        return this.originalSource;
    }

    public final void setOriginalSource(String str) {
        this.originalSource = str;
    }

    public final String getPortrait() {
        return this.portrait;
    }

    public final void setPortrait(String str) {
        this.portrait = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getUserDesc() {
        return this.userDesc;
    }

    public final void setUserDesc(String str) {
        this.userDesc = str;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final String getVipIcon() {
        return this.vipIcon;
    }

    public final void setVipIcon(String str) {
        this.vipIcon = str;
    }

    public final int getImageCount() {
        return this.imageCount;
    }

    public final void setImageCount(int i2) {
        this.imageCount = i2;
    }

    public final String getVideoPlayCount() {
        return this.videoPlayCount;
    }

    public final void setVideoPlayCount(String str) {
        this.videoPlayCount = str;
    }

    public final String getVideoCoverThreeRatioFour() {
        return this.videoCoverThreeRatioFour;
    }

    public final void setVideoCoverThreeRatioFour(String str) {
        this.videoCoverThreeRatioFour = str;
    }

    public final String getVideoCoverFourRatioThree() {
        return this.videoCoverFourRatioThree;
    }

    public final void setVideoCoverFourRatioThree(String str) {
        this.videoCoverFourRatioThree = str;
    }

    public final String getVideoAuthorName() {
        return this.videoAuthorName;
    }

    public final void setVideoAuthorName(String str) {
        this.videoAuthorName = str;
    }

    public final boolean isShowGuarantee() {
        return this.isShowGuarantee;
    }

    public final void setShowGuarantee(boolean z) {
        this.isShowGuarantee = z;
    }

    public final String getBaoInfo() {
        return this.baoInfo;
    }

    public final void setBaoInfo(String str) {
        this.baoInfo = str;
    }

    public final boolean isShowFeedback() {
        return this.isShowFeedback;
    }

    public final void setShowFeedback(boolean z) {
        this.isShowFeedback = z;
    }

    public final String getFromPage() {
        return this.fromPage;
    }

    public final void setFromPage(String str) {
        this.fromPage = str;
    }

    public final boolean isShowServiceRate() {
        return this.isShowServiceRate;
    }

    public final void setShowServiceRate(boolean z) {
        this.isShowServiceRate = z;
    }

    public final String getServiceRateUrl() {
        return this.serviceRateUrl;
    }

    public final void setServiceRateUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serviceRateUrl = str;
    }

    public final String getFavorNumber() {
        return this.favorNumber;
    }

    public final void setFavorNumber(String str) {
        this.favorNumber = str;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final void setShopName(String str) {
        this.shopName = str;
    }

    public final String getShopUrl() {
        return this.shopUrl;
    }

    public final void setShopUrl(String str) {
        this.shopUrl = str;
    }

    public final String getSimilarUrl() {
        return this.similarUrl;
    }

    public final void setSimilarUrl(String str) {
        this.similarUrl = str;
    }

    public final List<String> getSaleTag() {
        return this.saleTag;
    }

    public final void setSaleTag(List<String> list) {
        this.saleTag = list;
    }

    public final List<String> getDiscountTag() {
        return this.discountTag;
    }

    public final void setDiscountTag(List<String> list) {
        this.discountTag = list;
    }

    public final String getSaleStatus() {
        return this.saleStatus;
    }

    public final void setSaleStatus(String str) {
        this.saleStatus = str;
    }

    public final SnifferNetDiskTaskModel getSnifferNetDiskTaskModel() {
        return this.snifferNetDiskTaskModel;
    }

    public final void setSnifferNetDiskTaskModel(SnifferNetDiskTaskModel snifferNetDiskTaskModel2) {
        this.snifferNetDiskTaskModel = snifferNetDiskTaskModel2;
    }

    public final String getExtra1() {
        return this.extra1;
    }

    public final void setExtra1(String str) {
        this.extra1 = str;
    }

    public final boolean isDeadLink() {
        return this.isDeadLink;
    }

    public final void setDeadLink(boolean z) {
        this.isDeadLink = z;
    }

    public final com.baidu.searchbox.history.api.data.MoviesModel getHistoryMoviesModel() {
        return this.historyMoviesModel;
    }

    public final void setHistoryMoviesModel(com.baidu.searchbox.history.api.data.MoviesModel moviesModel) {
        this.historyMoviesModel = moviesModel;
    }

    public final MoviesModel getFavorMoviesModel() {
        return this.favorMoviesModel;
    }

    public final void setFavorMoviesModel(MoviesModel moviesModel) {
        this.favorMoviesModel = moviesModel;
    }

    public final String getTotalTime() {
        return this.totalTime;
    }

    public final void setTotalTime(String str) {
        this.totalTime = str;
    }

    public final Integer getItemPosition() {
        return this.itemPosition;
    }

    public final void setItemPosition(Integer num) {
        this.itemPosition = num;
    }

    public final String getClassifyType() {
        return this.classifyType;
    }

    public final void setClassifyType(String str) {
        this.classifyType = str;
    }

    public final PlayletModel getPlayletModel() {
        return this.playletModel;
    }

    public final void setPlayletModel(PlayletModel playletModel2) {
        this.playletModel = playletModel2;
    }

    public final String getBottomDialogShowSource() {
        CharSequence charSequence = this.fullSource;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return this.fullSource;
        }
        return this.source;
    }
}
