package com.baidu.searchbox.feed.payment.model;

import com.baidu.searchbox.feed.payment.widget.couponguidebar.GuideBarModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010D\u001a\u00020ER\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010*8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010,8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0002018\u0006XD¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0002078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020:0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u0004\u0018\u00010@8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020B8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/SpColumnDetailData;", "", "()V", "addTabCmd", "", "author", "authorDescription", "authorIcon", "buttonInfo", "", "Lcom/baidu/searchbox/feed/payment/model/SpDetailButtonInfo;", "category", "chatInfo", "Lcom/baidu/searchbox/feed/payment/model/SpChatInfo;", "columnType", "comment", "Lcom/baidu/searchbox/feed/payment/model/CommentInfo;", "couponInfo", "Lcom/baidu/searchbox/feed/payment/model/SpDetailCouponInfo;", "dataSign", "description", "guideBar", "Lcom/baidu/searchbox/feed/payment/widget/couponguidebar/GuideBarModel;", "iconicTags", "Lcom/baidu/searchbox/feed/payment/model/IconicTag;", "image", "imageLarge", "imageScheme", "isLogin", "isPay", "layout", "listIds", "listItemCount", "pageState", "payButtonInfo", "Lcom/baidu/searchbox/feed/payment/model/SpPayButtonInfo;", "payInfo", "Lcom/baidu/searchbox/feed/payment/model/SpDetailPayInfo;", "playCount", "present", "Lcom/baidu/searchbox/feed/payment/model/Present;", "receive", "Lcom/baidu/searchbox/feed/payment/model/Receive;", "reorder", "Lcom/baidu/searchbox/feed/payment/model/Reorder;", "resourceType", "secKillInfo", "Lcom/baidu/searchbox/feed/payment/model/SpSecKillInfo;", "selectTabIndex", "", "shareInfo", "Lcom/baidu/searchbox/feed/payment/model/SpDetailShareInfo;", "state", "styleOptSwitch", "subscribeInfo", "Lcom/baidu/searchbox/feed/payment/model/SpDetailSubscribeInfo;", "subscribeShowLimit", "tabInfos", "Lcom/baidu/searchbox/feed/payment/model/SpDetailTabInfo;", "tags", "title", "topCardTags", "Lcom/baidu/searchbox/feed/payment/model/RankingTag;", "training", "Lcom/baidu/searchbox/feed/payment/model/Training;", "trial", "Lcom/baidu/searchbox/feed/payment/model/Trial;", "ukAuthor", "isTraining", "", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnDetailData.kt */
public final class SpColumnDetailData {
    @SerializedName("add_tab_cmd")
    public String addTabCmd = "";
    @SerializedName("author")
    public String author = "";
    @SerializedName("author_desc")
    public String authorDescription = "";
    @SerializedName("author_icon")
    public String authorIcon = "";
    @SerializedName("button_info")
    public final List<SpDetailButtonInfo> buttonInfo = new ArrayList();
    @SerializedName("category")
    public String category = "";
    @SerializedName("chat_info")
    public final SpChatInfo chatInfo = new SpChatInfo();
    @SerializedName("column_type")
    public String columnType = "";
    @SerializedName("comment")
    public final CommentInfo comment = new CommentInfo();
    @SerializedName("coupon_info")
    public SpDetailCouponInfo couponInfo;
    @SerializedName("datasign")
    public String dataSign = "";
    @SerializedName("description")
    public String description = "";
    @SerializedName("guide_bar")
    public GuideBarModel guideBar;
    @SerializedName("side_information")
    public final List<IconicTag> iconicTags = new ArrayList();
    @SerializedName("image")
    public String image = "";
    @SerializedName("image_large")
    public String imageLarge = "";
    @SerializedName("image_click")
    public String imageScheme = "";
    @SerializedName("is_login")
    public String isLogin = "";
    @SerializedName("is_pay")
    public String isPay = "";
    @SerializedName("layout")
    public String layout = "";
    @SerializedName("list_info")
    public final List<String> listIds = new ArrayList();
    @SerializedName("list_num")
    public String listItemCount = "";
    @SerializedName("page_state")
    public String pageState = "";
    @SerializedName("pay_button_info")
    public final SpPayButtonInfo payButtonInfo = new SpPayButtonInfo();
    @SerializedName("pay_info")
    public final SpDetailPayInfo payInfo = new SpDetailPayInfo();
    @SerializedName("play_num")
    public String playCount = "";
    @SerializedName("present")
    public final Present present;
    @SerializedName("receive")
    public final Receive receive;
    @SerializedName("reorder")
    public final Reorder reorder;
    @SerializedName("resource_type")
    public final String resourceType = "";
    @SerializedName("live_seckill")
    public SpSecKillInfo secKillInfo;
    @SerializedName("tab_index")
    public final int selectTabIndex;
    @SerializedName("share_info")
    public SpDetailShareInfo shareInfo;
    @SerializedName("state")
    public String state = "1";
    @SerializedName("hit_guide_bar")
    public String styleOptSwitch = "";
    @SerializedName("subscribe_info")
    public final SpDetailSubscribeInfo subscribeInfo = new SpDetailSubscribeInfo();
    @SerializedName("subscribe_show_limit")
    public final String subscribeShowLimit;
    @SerializedName("tab_info")
    public final List<SpDetailTabInfo> tabInfos = new ArrayList();
    @SerializedName("tags")
    public final List<String> tags;
    @SerializedName("title")
    public String title = "";
    @SerializedName("top_card_tags")
    public final List<RankingTag> topCardTags = new ArrayList();
    @SerializedName("training")
    public final Training training;
    @SerializedName("try_ext")
    public final Trial trial = new Trial();
    @SerializedName("uk_author")
    public String ukAuthor = "";

    public final boolean isTraining() {
        return Intrinsics.areEqual((Object) this.resourceType, (Object) "training");
    }
}
