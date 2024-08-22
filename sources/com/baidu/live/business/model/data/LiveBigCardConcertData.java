package com.baidu.live.business.model.data;

import com.baidu.live.LiveFeedPageSdk;
import com.baidu.searchbox.feed.model.FeedPrefixTagDataKt;
import com.baidu.searchbox.story.NovelBookInfo;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.talos.core.render.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u001f2\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00064"}, d2 = {"Lcom/baidu/live/business/model/data/LiveBigCardConcertData;", "", "()V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "backgroundImage", "getBackgroundImage", "setBackgroundImage", "bannerInfo", "", "Lcom/baidu/live/business/model/data/LiveBigCardBannerInfo;", "getBannerInfo", "()Ljava/util/List;", "setBannerInfo", "(Ljava/util/List;)V", "isBannerSwitch", "", "()Z", "setBannerSwitch", "(Z)V", "isBigCardSwitch", "setBigCardSwitch", "isOpenBigCard", "setOpenBigCard", "isReverseSwitch", "setReverseSwitch", "playerInfo", "Lcom/baidu/live/business/model/data/LiveBigCardPlayerInfo;", "getPlayerInfo", "()Lcom/baidu/live/business/model/data/LiveBigCardPlayerInfo;", "setPlayerInfo", "(Lcom/baidu/live/business/model/data/LiveBigCardPlayerInfo;)V", "reserveInfo", "Lcom/baidu/live/business/model/data/LiveBigCardReserveInfo;", "getReserveInfo", "()Lcom/baidu/live/business/model/data/LiveBigCardReserveInfo;", "setReserveInfo", "(Lcom/baidu/live/business/model/data/LiveBigCardReserveInfo;)V", "parseBannerInfo", "bannerJson", "parseCardInfo", "cardInfoString", "parseReserveInfo", "reverseJson", "parserJson", "", "bigCardObj", "Lorg/json/JSONObject;", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBigCardConcertData.kt */
public final class LiveBigCardConcertData {
    private String backgroundColor;
    private String backgroundImage;
    private List<LiveBigCardBannerInfo> bannerInfo;
    private boolean isBannerSwitch;
    private boolean isBigCardSwitch;
    private boolean isOpenBigCard;
    private boolean isReverseSwitch;
    private LiveBigCardPlayerInfo playerInfo;
    private LiveBigCardReserveInfo reserveInfo;

    public final boolean isOpenBigCard() {
        return this.isOpenBigCard;
    }

    public final void setOpenBigCard(boolean z) {
        this.isOpenBigCard = z;
    }

    public final boolean isBigCardSwitch() {
        return this.isBigCardSwitch;
    }

    public final void setBigCardSwitch(boolean z) {
        this.isBigCardSwitch = z;
    }

    public final boolean isReverseSwitch() {
        return this.isReverseSwitch;
    }

    public final void setReverseSwitch(boolean z) {
        this.isReverseSwitch = z;
    }

    public final boolean isBannerSwitch() {
        return this.isBannerSwitch;
    }

    public final void setBannerSwitch(boolean z) {
        this.isBannerSwitch = z;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final void setBackgroundImage(String str) {
        this.backgroundImage = str;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public final LiveBigCardPlayerInfo getPlayerInfo() {
        return this.playerInfo;
    }

    public final void setPlayerInfo(LiveBigCardPlayerInfo liveBigCardPlayerInfo) {
        this.playerInfo = liveBigCardPlayerInfo;
    }

    public final LiveBigCardReserveInfo getReserveInfo() {
        return this.reserveInfo;
    }

    public final void setReserveInfo(LiveBigCardReserveInfo liveBigCardReserveInfo) {
        this.reserveInfo = liveBigCardReserveInfo;
    }

    public final List<LiveBigCardBannerInfo> getBannerInfo() {
        return this.bannerInfo;
    }

    public final void setBannerInfo(List<LiveBigCardBannerInfo> list) {
        this.bannerInfo = list;
    }

    public final void parserJson(JSONObject bigCardObj) {
        if (bigCardObj == null) {
            this.isOpenBigCard = false;
            return;
        }
        try {
            String backgroundImage2 = bigCardObj.optString("background_image");
            String backgroundColor2 = bigCardObj.optString(FeedPrefixTagDataKt.KEY_BG_COLOR);
            boolean isBigCardSwitch2 = bigCardObj.has(NovelBookInfo.BOOK_INFO_CARD_INFO);
            boolean isReverseSwitch2 = bigCardObj.has("reserve_info");
            boolean isBannerSwitch2 = bigCardObj.has("banner_info");
            String optString = bigCardObj.optString(NovelBookInfo.BOOK_INFO_CARD_INFO);
            String str = "";
            if (optString == null) {
                optString = str;
            }
            LiveBigCardPlayerInfo bigCardInfo = parseCardInfo(optString);
            String optString2 = bigCardObj.optString("reserve_info");
            if (optString2 == null) {
                optString2 = str;
            }
            LiveBigCardReserveInfo reserveInfo2 = parseReserveInfo(optString2);
            String optString3 = bigCardObj.optString("banner_info");
            if (optString3 != null) {
                str = optString3;
            }
            List bannerInfo2 = parseBannerInfo(str);
            this.isBigCardSwitch = isBigCardSwitch2;
            this.isReverseSwitch = isReverseSwitch2;
            this.isBannerSwitch = isBannerSwitch2;
            this.backgroundImage = backgroundImage2;
            this.backgroundColor = backgroundColor2;
            this.playerInfo = bigCardInfo;
            this.reserveInfo = reserveInfo2;
            this.bannerInfo = bannerInfo2;
        } catch (JSONException e2) {
            LiveFeedPageSdk.liveLog(e2.getMessage());
        }
    }

    private final List<LiveBigCardBannerInfo> parseBannerInfo(String bannerJson) {
        boolean z = false;
        if (bannerJson != null && StringsKt.isBlank(bannerJson)) {
            z = true;
        }
        if (z) {
            return null;
        }
        try {
            JSONArray jsonObject = new JSONArray(bannerJson);
            List bannerInfoList = new ArrayList();
            int length = jsonObject.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject bannerItem = jsonObject.optJSONObject(i2);
                String showImg = bannerItem.optString("show_img");
                int typeValue = bannerItem.optInt("type_value");
                String skipUrl = bannerItem.optString("skip_url");
                Intrinsics.checkNotNullExpressionValue(showImg, "showImg");
                Intrinsics.checkNotNullExpressionValue(skipUrl, "skipUrl");
                bannerInfoList.add(new LiveBigCardBannerInfo(showImg, typeValue, skipUrl));
            }
            return bannerInfoList;
        } catch (JSONException e2) {
            LiveFeedPageSdk.liveLog(e2.getMessage());
            return null;
        }
    }

    private final LiveBigCardReserveInfo parseReserveInfo(String reverseJson) {
        String str = reverseJson;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(str);
            String icon = jsonObject.optString("icon");
            String title = jsonObject.optString("title");
            String subTitle = jsonObject.optString("sub_title");
            String reserveRoomids = jsonObject.optString("reserve_room_ids");
            int reserveStatus = jsonObject.optInt("reserve_status");
            String backgroundImage2 = jsonObject.optString("background_image");
            String operatorLeftColor = jsonObject.optString("operator_left_color");
            String operatorRightColor = jsonObject.optString("operator_right_color");
            Intrinsics.checkNotNullExpressionValue(icon, "icon");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(subTitle, "subTitle");
            Intrinsics.checkNotNullExpressionValue(reserveRoomids, "reserveRoomids");
            Intrinsics.checkNotNullExpressionValue(backgroundImage2, ViewProps.BACKGROUND_IMG);
            Intrinsics.checkNotNullExpressionValue(operatorLeftColor, "operatorLeftColor");
            Intrinsics.checkNotNullExpressionValue(operatorRightColor, "operatorRightColor");
            String str2 = backgroundImage2;
            String str3 = reserveRoomids;
            String str4 = subTitle;
            return new LiveBigCardReserveInfo(icon, title, subTitle, reserveRoomids, reserveStatus, backgroundImage2, operatorLeftColor, operatorRightColor);
        } catch (JSONException e2) {
            LiveFeedPageSdk.liveLog(e2.getMessage());
            return null;
        }
    }

    private final LiveBigCardPlayerInfo parseCardInfo(String cardInfoString) {
        String str = cardInfoString;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(str);
            String nid = jsonObject.optString("nid");
            String feedId = jsonObject.optString("feed_id");
            String roomId = String.valueOf(jsonObject.optLong("room_id"));
            String cover = jsonObject.optString("cover");
            int liveStatus = jsonObject.optInt("live_status");
            String cmd = jsonObject.optString("cmd");
            String playUrl = jsonObject.optString(PluginInvokerConstants.PLAY_URL);
            String operatorIcon = jsonObject.optString("operator_icon");
            String operatorTitle = jsonObject.optString("operator_title");
            String operatorColor = jsonObject.optString("operator_color");
            String operatorLot = jsonObject.optString("operator_lot");
            LiveBigCardPlayerInfo liveBigCardConcertData = new LiveBigCardPlayerInfo();
            liveBigCardConcertData.setNid(nid);
            liveBigCardConcertData.setFeedId(feedId);
            liveBigCardConcertData.setRoomId(roomId);
            liveBigCardConcertData.setCover(cover);
            liveBigCardConcertData.setLiveStatus(Integer.valueOf(liveStatus));
            liveBigCardConcertData.setCmd(cmd);
            liveBigCardConcertData.setPlayUrl(playUrl);
            liveBigCardConcertData.setBeginTime("");
            liveBigCardConcertData.setEndTime("");
            liveBigCardConcertData.setOperatorIcon(operatorIcon);
            liveBigCardConcertData.setOperatorTitle(operatorTitle);
            liveBigCardConcertData.setOperatorColor(operatorColor);
            liveBigCardConcertData.setOperatorLot(operatorLot);
            return liveBigCardConcertData;
        } catch (JSONException e2) {
            LiveFeedPageSdk.liveLog(e2.getMessage());
            return null;
        }
    }
}
