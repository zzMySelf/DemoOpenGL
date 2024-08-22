package com.baidu.nadcore.lp.reward.data;

import android.text.TextUtils;
import com.baidu.nadcore.business.R;
import com.baidu.nadcore.lp.reward.NadRewardVideoActivityKt;
import com.baidu.nadcore.model.LottieDialogRewardData;
import com.baidu.nadcore.model.NadRewardBannerData;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.searchbox.account.dialog.NickNameDialogActivity;
import com.baidu.searchbox.video.feedflow.ubc.UBC5063And5066;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b,\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010}\u001a\u00020OJ\u0006\u0010~\u001a\u00020OJ\u0006\u0010\u001a\u00020OR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0004R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\u0004R\u001a\u0010<\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\u0004R\u001c\u0010?\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\u0004R\u001c\u0010B\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\u0004R\u001c\u0010E\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\u0004R\u001c\u0010H\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\u0004R\u001c\u0010K\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\u0004R\u001a\u0010N\u001a\u00020OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010!\"\u0004\b[\u0010#R\u001c\u0010\\\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\u0004R\u001c\u0010_\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010!\"\u0004\ba\u0010#R\u001c\u0010b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0007\"\u0004\bd\u0010\u0004R\u001c\u0010e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010\u0004R\u001c\u0010h\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0007\"\u0004\bj\u0010\u0004R\u001c\u0010k\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0007\"\u0004\bm\u0010\u0004R\u001c\u0010n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0007\"\u0004\bp\u0010\u0004R\u001c\u0010q\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0007\"\u0004\bs\u0010\u0004R\u001c\u0010t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0007\"\u0004\bv\u0010\u0004R\u001a\u0010w\u001a\u00020OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010P\"\u0004\by\u0010RR\u001c\u0010z\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0007\"\u0004\b|\u0010\u0004¨\u0006\u0001"}, d2 = {"Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "", "jsonString", "", "(Ljava/lang/String;)V", "avatar", "getAvatar", "()Ljava/lang/String;", "setAvatar", "bannerData", "Lcom/baidu/nadcore/model/NadRewardBannerData;", "getBannerData", "()Lcom/baidu/nadcore/model/NadRewardBannerData;", "setBannerData", "(Lcom/baidu/nadcore/model/NadRewardBannerData;)V", "bgEndColor", "", "getBgEndColor", "()I", "setBgEndColor", "(I)V", "bgLottieUrl", "getBgLottieUrl", "setBgLottieUrl", "bgStartColor", "getBgStartColor", "setBgStartColor", "borderColor", "getBorderColor", "setBorderColor", "bottomLeftBtn", "Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;", "getBottomLeftBtn", "()Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;", "setBottomLeftBtn", "(Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;)V", "bottomRightBtn", "getBottomRightBtn", "setBottomRightBtn", "closeBtnColor", "getCloseBtnColor", "setCloseBtnColor", "closeBtnText", "getCloseBtnText", "setCloseBtnText", "closeImg", "getCloseImg", "setCloseImg", "contentTips", "getContentTips", "setContentTips", "convertBtn", "getConvertBtn", "setConvertBtn", "convertCmd", "getConvertCmd", "setConvertCmd", "countDownTips", "getCountDownTips", "setCountDownTips", "dialogAnimationSwitch", "getDialogAnimationSwitch", "setDialogAnimationSwitch", "dialogShowDuration", "getDialogShowDuration", "setDialogShowDuration", "dialogTitle", "getDialogTitle", "setDialogTitle", "dialogTopImg", "getDialogTopImg", "setDialogTopImg", "dialogType", "getDialogType", "setDialogType", "invokeCmdCoin", "getInvokeCmdCoin", "setInvokeCmdCoin", "isOldImageStyle", "", "()Z", "setOldImageStyle", "(Z)V", "lottieRewardData", "Lcom/baidu/nadcore/model/LottieDialogRewardData;", "getLottieRewardData", "()Lcom/baidu/nadcore/model/LottieDialogRewardData;", "setLottieRewardData", "(Lcom/baidu/nadcore/model/LottieDialogRewardData;)V", "mainBtn", "getMainBtn", "setMainBtn", "rightAnswerToast", "getRightAnswerToast", "setRightAnswerToast", "subBtn", "getSubBtn", "setSubBtn", "subTitle", "getSubTitle", "setSubTitle", "taskCenterPolicyStr", "getTaskCenterPolicyStr", "setTaskCenterPolicyStr", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "topImg", "getTopImg", "setTopImg", "topTitle", "getTopTitle", "setTopTitle", "type", "getType", "setType", "upperLimit", "getUpperLimit", "setUpperLimit", "wrongAnswerToast", "getWrongAnswerToast", "setWrongAnswerToast", "isDetailAd", "isDownloadAd", "isSuspendStyle", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardDialogData.kt */
public final class NadRewardDialogData {
    private String avatar;
    private NadRewardBannerData bannerData;
    private int bgEndColor;
    private String bgLottieUrl;
    private int bgStartColor;
    private int borderColor;
    private NadDialogButtonData bottomLeftBtn;
    private NadDialogButtonData bottomRightBtn;
    private String closeBtnColor;
    private String closeBtnText;
    private String closeImg;
    private String contentTips;
    private NadDialogButtonData convertBtn;
    private String convertCmd;
    private String countDownTips;
    private String dialogAnimationSwitch = "0";
    private String dialogShowDuration;
    private String dialogTitle;
    private String dialogTopImg;
    private String dialogType;
    private String invokeCmdCoin;
    private boolean isOldImageStyle;
    private LottieDialogRewardData lottieRewardData;
    private NadDialogButtonData mainBtn;
    private String rightAnswerToast;
    private NadDialogButtonData subBtn;
    private String subTitle;
    private String taskCenterPolicyStr;
    private String title;
    private String titleColor;
    private String topImg;
    private String topTitle;
    private String type;
    private boolean upperLimit;
    private String wrongAnswerToast;

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    public NadRewardDialogData(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            JSONObject $this$_init__u24lambda_u2d6 = new JSONObject(jsonString);
            this.topImg = $this$_init__u24lambda_u2d6.optString("top_image");
            this.dialogTopImg = $this$_init__u24lambda_u2d6.optString("top_mid_image");
            this.closeImg = $this$_init__u24lambda_u2d6.optString("close_image");
            this.topTitle = $this$_init__u24lambda_u2d6.optString("top_title");
            this.dialogTitle = $this$_init__u24lambda_u2d6.optString("invoke_content");
            this.titleColor = $this$_init__u24lambda_u2d6.optString("content_text_color");
            JSONObject $this$lambda_u2d6_u24lambda_u2d0 = $this$_init__u24lambda_u2d6.optJSONObject("close_btn");
            if ($this$lambda_u2d6_u24lambda_u2d0 != null) {
                Intrinsics.checkNotNullExpressionValue($this$lambda_u2d6_u24lambda_u2d0, "optJSONObject(\"close_btn\")");
                this.closeBtnText = $this$lambda_u2d6_u24lambda_u2d0.optString("button_text");
                this.closeBtnColor = $this$lambda_u2d6_u24lambda_u2d0.optString("text_color");
            }
            this.dialogType = $this$_init__u24lambda_u2d6.optString(NickNameDialogActivity.KEY_DIALOG_TYPE);
            this.type = $this$_init__u24lambda_u2d6.optString("type");
            this.avatar = $this$_init__u24lambda_u2d6.optString("avatar");
            this.title = $this$_init__u24lambda_u2d6.optString("brand_name");
            this.subTitle = $this$_init__u24lambda_u2d6.optString("title");
            this.convertCmd = $this$_init__u24lambda_u2d6.optString("convert_cmd");
            JSONObject it = $this$_init__u24lambda_u2d6.optJSONObject("convert_btn");
            String str = null;
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "optJSONObject(\"convert_btn\")");
                NadDialogButtonData fromJson = NadDialogButtonData.Companion.fromJson(it);
                this.convertBtn = fromJson;
                if (TextUtils.equals(fromJson != null ? fromJson.getBtnCmd() : null, NadRewardVideoActivityKt.KEY_BTN_SCHEME)) {
                    NadDialogButtonData nadDialogButtonData = this.convertBtn;
                    if (nadDialogButtonData != null) {
                        String str2 = this.convertCmd;
                        if (str2 != null) {
                            nadDialogButtonData.setBtnCmd(str2);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                }
            }
            JSONObject it2 = $this$_init__u24lambda_u2d6.optJSONObject("main_btn");
            if (it2 != null) {
                Intrinsics.checkNotNullExpressionValue(it2, "optJSONObject(\"main_btn\")");
                NadDialogButtonData fromJson2 = NadDialogButtonData.Companion.fromJson(it2);
                this.mainBtn = fromJson2;
                if (TextUtils.equals(fromJson2 != null ? fromJson2.getBtnCmd() : str, NadRewardVideoActivityKt.KEY_BTN_SCHEME)) {
                    NadDialogButtonData nadDialogButtonData2 = this.mainBtn;
                    if (nadDialogButtonData2 != null) {
                        String str3 = this.convertCmd;
                        if (str3 != null) {
                            nadDialogButtonData2.setBtnCmd(str3);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                }
            }
            JSONObject it3 = $this$_init__u24lambda_u2d6.optJSONObject(UBC5063And5066.Value.SUBSCRIBE_BTN);
            if (it3 != null) {
                Intrinsics.checkNotNullExpressionValue(it3, "optJSONObject(\"sub_btn\")");
                this.subBtn = NadDialogButtonData.Companion.fromJson(it3);
            }
            JSONObject it4 = $this$_init__u24lambda_u2d6.optJSONObject("bottom_left_btn");
            if (it4 != null) {
                Intrinsics.checkNotNullExpressionValue(it4, "optJSONObject(\"bottom_left_btn\")");
                this.bottomLeftBtn = NadDialogButtonData.Companion.fromJson(it4);
            }
            JSONObject it5 = $this$_init__u24lambda_u2d6.optJSONObject("bottom_right_btn");
            if (it5 != null) {
                Intrinsics.checkNotNullExpressionValue(it5, "optJSONObject(\"bottom_right_btn\")");
                this.bottomRightBtn = NadDialogButtonData.Companion.fromJson(it5);
            }
            String optString = $this$_init__u24lambda_u2d6.optString("bg_start_color");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"bg_start_color\")");
            this.bgStartColor = ExtensionsKt.toColor(optString, R.color.nad_reward_video_btn_bg_start);
            String optString2 = $this$_init__u24lambda_u2d6.optString("bg_end_color");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"bg_end_color\")");
            this.bgEndColor = ExtensionsKt.toColor(optString2, R.color.nad_reward_video_btn_bg_end);
            String optString3 = $this$_init__u24lambda_u2d6.optString("border_color");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"border_color\")");
            this.borderColor = ExtensionsKt.toColor(optString3, R.color.nad_reward_video_btn_bg_border);
            this.contentTips = $this$_init__u24lambda_u2d6.optString("content_tips");
            this.bgLottieUrl = $this$_init__u24lambda_u2d6.optString("bg_lottie_url");
            this.countDownTips = $this$_init__u24lambda_u2d6.optString("countdown_tips");
            String optString4 = $this$_init__u24lambda_u2d6.optString("dialog_animation_switch");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"dialog_animation_switch\")");
            this.dialogAnimationSwitch = optString4;
        } catch (JSONException e2) {
        }
    }

    public final String getTopImg() {
        return this.topImg;
    }

    public final void setTopImg(String str) {
        this.topImg = str;
    }

    public final String getDialogTopImg() {
        return this.dialogTopImg;
    }

    public final void setDialogTopImg(String str) {
        this.dialogTopImg = str;
    }

    public final String getCloseImg() {
        return this.closeImg;
    }

    public final void setCloseImg(String str) {
        this.closeImg = str;
    }

    public final String getTopTitle() {
        return this.topTitle;
    }

    public final void setTopTitle(String str) {
        this.topTitle = str;
    }

    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    public final void setDialogTitle(String str) {
        this.dialogTitle = str;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }

    public final void setTitleColor(String str) {
        this.titleColor = str;
    }

    public final String getCloseBtnText() {
        return this.closeBtnText;
    }

    public final void setCloseBtnText(String str) {
        this.closeBtnText = str;
    }

    public final String getCloseBtnColor() {
        return this.closeBtnColor;
    }

    public final void setCloseBtnColor(String str) {
        this.closeBtnColor = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getDialogType() {
        return this.dialogType;
    }

    public final void setDialogType(String str) {
        this.dialogType = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final String getConvertCmd() {
        return this.convertCmd;
    }

    public final void setConvertCmd(String str) {
        this.convertCmd = str;
    }

    public final NadDialogButtonData getConvertBtn() {
        return this.convertBtn;
    }

    public final void setConvertBtn(NadDialogButtonData nadDialogButtonData) {
        this.convertBtn = nadDialogButtonData;
    }

    public final NadDialogButtonData getMainBtn() {
        return this.mainBtn;
    }

    public final void setMainBtn(NadDialogButtonData nadDialogButtonData) {
        this.mainBtn = nadDialogButtonData;
    }

    public final NadDialogButtonData getSubBtn() {
        return this.subBtn;
    }

    public final void setSubBtn(NadDialogButtonData nadDialogButtonData) {
        this.subBtn = nadDialogButtonData;
    }

    public final NadDialogButtonData getBottomLeftBtn() {
        return this.bottomLeftBtn;
    }

    public final void setBottomLeftBtn(NadDialogButtonData nadDialogButtonData) {
        this.bottomLeftBtn = nadDialogButtonData;
    }

    public final NadDialogButtonData getBottomRightBtn() {
        return this.bottomRightBtn;
    }

    public final void setBottomRightBtn(NadDialogButtonData nadDialogButtonData) {
        this.bottomRightBtn = nadDialogButtonData;
    }

    public final int getBgStartColor() {
        return this.bgStartColor;
    }

    public final void setBgStartColor(int i2) {
        this.bgStartColor = i2;
    }

    public final int getBgEndColor() {
        return this.bgEndColor;
    }

    public final void setBgEndColor(int i2) {
        this.bgEndColor = i2;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i2) {
        this.borderColor = i2;
    }

    public final boolean getUpperLimit() {
        return this.upperLimit;
    }

    public final void setUpperLimit(boolean z) {
        this.upperLimit = z;
    }

    public final String getDialogShowDuration() {
        return this.dialogShowDuration;
    }

    public final void setDialogShowDuration(String str) {
        this.dialogShowDuration = str;
    }

    public final String getRightAnswerToast() {
        return this.rightAnswerToast;
    }

    public final void setRightAnswerToast(String str) {
        this.rightAnswerToast = str;
    }

    public final String getWrongAnswerToast() {
        return this.wrongAnswerToast;
    }

    public final void setWrongAnswerToast(String str) {
        this.wrongAnswerToast = str;
    }

    public final String getContentTips() {
        return this.contentTips;
    }

    public final void setContentTips(String str) {
        this.contentTips = str;
    }

    public final String getBgLottieUrl() {
        return this.bgLottieUrl;
    }

    public final void setBgLottieUrl(String str) {
        this.bgLottieUrl = str;
    }

    public final String getCountDownTips() {
        return this.countDownTips;
    }

    public final void setCountDownTips(String str) {
        this.countDownTips = str;
    }

    public final String getDialogAnimationSwitch() {
        return this.dialogAnimationSwitch;
    }

    public final void setDialogAnimationSwitch(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dialogAnimationSwitch = str;
    }

    public final LottieDialogRewardData getLottieRewardData() {
        return this.lottieRewardData;
    }

    public final void setLottieRewardData(LottieDialogRewardData lottieDialogRewardData) {
        this.lottieRewardData = lottieDialogRewardData;
    }

    public final String getTaskCenterPolicyStr() {
        return this.taskCenterPolicyStr;
    }

    public final void setTaskCenterPolicyStr(String str) {
        this.taskCenterPolicyStr = str;
    }

    public final String getInvokeCmdCoin() {
        return this.invokeCmdCoin;
    }

    public final void setInvokeCmdCoin(String str) {
        this.invokeCmdCoin = str;
    }

    public final boolean isOldImageStyle() {
        return this.isOldImageStyle;
    }

    public final void setOldImageStyle(boolean z) {
        this.isOldImageStyle = z;
    }

    public final NadRewardBannerData getBannerData() {
        return this.bannerData;
    }

    public final void setBannerData(NadRewardBannerData nadRewardBannerData) {
        this.bannerData = nadRewardBannerData;
    }

    public final boolean isDownloadAd() {
        return TextUtils.equals(this.type, "download");
    }

    public final boolean isDetailAd() {
        return TextUtils.equals(this.type, "detail");
    }

    public final boolean isSuspendStyle() {
        return TextUtils.equals(this.dialogType, "7");
    }
}
