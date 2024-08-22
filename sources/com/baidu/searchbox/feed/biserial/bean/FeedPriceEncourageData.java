package com.baidu.searchbox.feed.biserial.bean;

import com.baidu.searchbox.bean.AFDRewardInfo;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.parser.ValidationResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/bean/FeedPriceEncourageData;", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "()V", "rewardCMD", "", "getRewardCMD", "()Ljava/lang/String;", "setRewardCMD", "(Ljava/lang/String;)V", "rewardList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/biserial/bean/FeedPriceEncourageData$RewardInfo;", "getRewardList", "()Ljava/util/ArrayList;", "setRewardList", "(Ljava/util/ArrayList;)V", "rewardPrice", "getRewardPrice", "setRewardPrice", "rewardTitle", "getRewardTitle", "setRewardTitle", "isValidate", "Lcom/baidu/searchbox/feed/parser/ValidationResult;", "context", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "toJson", "Lorg/json/JSONObject;", "toModel", "jsonObject", "RewardInfo", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedPriceEncourageData.kt */
public final class FeedPriceEncourageData extends FeedItemData {
    private String rewardCMD = "";
    private ArrayList<RewardInfo> rewardList = new ArrayList<>();
    private String rewardPrice = "";
    private String rewardTitle = "";

    public final String getRewardTitle() {
        return this.rewardTitle;
    }

    public final void setRewardTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rewardTitle = str;
    }

    public final String getRewardPrice() {
        return this.rewardPrice;
    }

    public final void setRewardPrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rewardPrice = str;
    }

    public final String getRewardCMD() {
        return this.rewardCMD;
    }

    public final void setRewardCMD(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rewardCMD = str;
    }

    public final ArrayList<RewardInfo> getRewardList() {
        return this.rewardList;
    }

    public final void setRewardList(ArrayList<RewardInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.rewardList = arrayList;
    }

    public JSONObject toJson() {
        return null;
    }

    public FeedItemData toModel(JSONObject jsonObject) {
        if (jsonObject != null) {
            JSONObject it = jsonObject;
            String optString = it.optString("reward_title");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"reward_title\")");
            this.rewardTitle = optString;
            String optString2 = it.optString("total_reward");
            Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"total_reward\")");
            this.rewardPrice = optString2;
            String optString3 = it.optString("cmd");
            Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(\"cmd\")");
            this.rewardCMD = optString3;
            JSONArray array = it.optJSONArray("reward_list");
            if (array != null && array.length() > 0) {
                int length = array.length();
                for (int i2 = 0; i2 < length; i2++) {
                    RewardInfo rewardInfo = new RewardInfo();
                    String json = array.get(i2).toString();
                    if (json.length() > 0) {
                        this.rewardList.add(rewardInfo.toModel(new JSONObject(json)));
                    }
                }
            }
        }
        return this;
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.rewardList.size() > 0) {
            ValidationResult ok = ValidationResult.ok();
            Intrinsics.checkNotNullExpressionValue(ok, "{\n            ValidationResult.ok()\n        }");
            return ok;
        }
        ValidationResult error = ValidationResult.error();
        Intrinsics.checkNotNullExpressionValue(error, "{\n            ValidationResult.error()\n        }");
        return error;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/bean/FeedPriceEncourageData$RewardInfo;", "", "()V", "cmd", "", "getCmd", "()Ljava/lang/String;", "setCmd", "(Ljava/lang/String;)V", "receivedGif", "getReceivedGif", "setReceivedGif", "receivedImg", "getReceivedImg", "setReceivedImg", "rewardPrice", "getRewardPrice", "setRewardPrice", "rewardStatus", "getRewardStatus", "setRewardStatus", "rewardType", "getRewardType", "setRewardType", "unReceiveGif", "getUnReceiveGif", "setUnReceiveGif", "unReceiveImg", "getUnReceiveImg", "setUnReceiveImg", "toModel", "dataObj", "Lorg/json/JSONObject;", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedPriceEncourageData.kt */
    public static final class RewardInfo {
        private String cmd = "";
        private String receivedGif = "";
        private String receivedImg = "";
        private String rewardPrice = "";
        private String rewardStatus = "";
        private String rewardType = "";
        private String unReceiveGif = "";
        private String unReceiveImg = "";

        public final String getRewardType() {
            return this.rewardType;
        }

        public final void setRewardType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rewardType = str;
        }

        public final String getRewardStatus() {
            return this.rewardStatus;
        }

        public final void setRewardStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rewardStatus = str;
        }

        public final String getRewardPrice() {
            return this.rewardPrice;
        }

        public final void setRewardPrice(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rewardPrice = str;
        }

        public final String getUnReceiveImg() {
            return this.unReceiveImg;
        }

        public final void setUnReceiveImg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.unReceiveImg = str;
        }

        public final String getUnReceiveGif() {
            return this.unReceiveGif;
        }

        public final void setUnReceiveGif(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.unReceiveGif = str;
        }

        public final String getReceivedImg() {
            return this.receivedImg;
        }

        public final void setReceivedImg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.receivedImg = str;
        }

        public final String getReceivedGif() {
            return this.receivedGif;
        }

        public final void setReceivedGif(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.receivedGif = str;
        }

        public final String getCmd() {
            return this.cmd;
        }

        public final void setCmd(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cmd = str;
        }

        public final RewardInfo toModel(JSONObject dataObj) {
            if (dataObj != null) {
                JSONObject jSONObject = dataObj;
                String optString = dataObj.optString(AFDRewardInfo.AD_REWARD_TYPE);
                Intrinsics.checkNotNullExpressionValue(optString, "dataObj.optString(\"reward_type\")");
                this.rewardType = optString;
                String optString2 = dataObj.optString("status");
                Intrinsics.checkNotNullExpressionValue(optString2, "dataObj.optString(\"status\")");
                this.rewardStatus = optString2;
                String optString3 = dataObj.optString(AFDRewardInfo.AD_REWARD_NUM);
                Intrinsics.checkNotNullExpressionValue(optString3, "dataObj.optString(\"reward_num\")");
                this.rewardPrice = optString3;
                String optString4 = dataObj.optString("unreceive_image");
                Intrinsics.checkNotNullExpressionValue(optString4, "dataObj.optString(\"unreceive_image\")");
                this.unReceiveImg = optString4;
                String optString5 = dataObj.optString("unreceive_gif");
                Intrinsics.checkNotNullExpressionValue(optString5, "dataObj.optString(\"unreceive_gif\")");
                this.unReceiveGif = optString5;
                String optString6 = dataObj.optString("received_image");
                Intrinsics.checkNotNullExpressionValue(optString6, "dataObj.optString(\"received_image\")");
                this.receivedImg = optString6;
                String optString7 = dataObj.optString("gif");
                Intrinsics.checkNotNullExpressionValue(optString7, "dataObj.optString(\"gif\")");
                this.receivedGif = optString7;
            }
            return this;
        }
    }
}
