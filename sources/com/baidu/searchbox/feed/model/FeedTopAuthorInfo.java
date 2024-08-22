package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.searchbox.comment.BDCommentConstants;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.widget.WidgetDataStatisticUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u0015\u0016\u0017\u0018\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo;", "", "()V", "followInfo", "Lcom/baidu/searchbox/feed/model/FeedItemData$AdditionalInfo;", "followRecommend", "Lcom/baidu/searchbox/feed/model/FollowRecommendModel;", "fromTopAuthorInfoNode", "", "pendantInfo", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$PendantInfo;", "user", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarSubdataProfile;", "zeroCommentTag", "", "fromJson", "", "jsonObject", "Lorg/json/JSONObject;", "isValid", "toJson", "FeedStarBadge", "FeedStarPrivilege", "FeedStarSubdataProfile", "FeedStarUserName", "LiveData", "PendantInfo", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTopAuthorInfo.kt */
public final class FeedTopAuthorInfo {
    public FeedItemData.AdditionalInfo followInfo;
    public FollowRecommendModel followRecommend;
    public boolean fromTopAuthorInfoNode;
    public PendantInfo pendantInfo;
    public FeedStarSubdataProfile user;
    public String zeroCommentTag = "";

    public final boolean isValid() {
        FeedStarSubdataProfile feedStarSubdataProfile;
        FeedItemData.AdditionalInfo additionalInfo;
        if (this.fromTopAuthorInfoNode && (feedStarSubdataProfile = this.user) != null) {
            Intrinsics.checkNotNull(feedStarSubdataProfile);
            if (feedStarSubdataProfile.checkUserProfileValid() && (additionalInfo = this.followInfo) != null) {
                Intrinsics.checkNotNull(additionalInfo);
                if (additionalInfo.checkFollowButtonValid()) {
                    FeedItemData.AdditionalInfo additionalInfo2 = this.followInfo;
                    Intrinsics.checkNotNull(additionalInfo2);
                    String str = additionalInfo2.type;
                    Intrinsics.checkNotNullExpressionValue(str, "followInfo!!.type");
                    if (str.length() > 0) {
                        FeedItemData.AdditionalInfo additionalInfo3 = this.followInfo;
                        Intrinsics.checkNotNull(additionalInfo3);
                        String str2 = additionalInfo3.thirdId;
                        Intrinsics.checkNotNullExpressionValue(str2, "followInfo!!.thirdId");
                        if (str2.length() > 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void toJson(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        try {
            FeedItemData.AdditionalInfo additionalInfo = this.followInfo;
            if (additionalInfo != null) {
                jsonObject.put("follow", FeedItemData.AdditionalInfo.toJson(additionalInfo));
            }
            FeedStarSubdataProfile it = this.user;
            if (it != null) {
                jsonObject.put("user", FeedStarSubdataProfile.Companion.toJson(it));
            }
            PendantInfo it2 = this.pendantInfo;
            if (it2 != null) {
                jsonObject.put("pendant", PendantInfo.Companion.toJson(it2));
            }
            if (!TextUtils.isEmpty(this.zeroCommentTag)) {
                jsonObject.put("zero_comment_tag", this.zeroCommentTag);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void fromJson(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.followInfo = FeedItemData.AdditionalInfo.fromJson(jsonObject.optJSONObject("follow"));
        JSONObject it = jsonObject.optJSONObject("user");
        if (it != null) {
            this.user = FeedStarSubdataProfile.Companion.fromJson(it);
        }
        JSONObject it2 = jsonObject.optJSONObject("pendant");
        if (it2 != null) {
            this.pendantInfo = PendantInfo.Companion.fromJson(it2);
        }
        String optString = jsonObject.optString("zero_comment_tag");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"zero_comment_tag\")");
        this.zeroCommentTag = optString;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarSubdataProfile;", "", "()V", "cmd", "", "commonText", "createTime", "desc", "descSecondTag", "Lcom/baidu/searchbox/feed/model/ExtensionsTag;", "descTag", "hat", "headerOpt", "isDisableAvatarClick", "", "isHideDislike", "liveData", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$LiveData;", "photo", "privilege", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarPrivilege;", "publishTimeRange", "statement", "type", "uk", "userName", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarUserName;", "vType", "vUrl", "checkUserProfileValid", "isAttentionFloatType", "isOptHeader", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTopAuthorInfo.kt */
    public static final class FeedStarSubdataProfile {
        private static final String ALLOW_AVATAR_CLICK = "0";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String DISABLE_AVATAR_CLICK = "1";
        private static final String HIDE_DISLIKE_BTN = "1";
        private static final String SHOW_DISLIKE_BTN = "0";
        public static final String TYPE_USER_PROFILE_ATTENTION_FLOAT = "2";
        public static final String TYPE_USER_PROFILE_RECOMMEND = "1";
        public String cmd = "";
        public String commonText = "";
        public String createTime = "";
        public String desc = "";
        public ExtensionsTag descSecondTag;
        public ExtensionsTag descTag;
        public String hat = "";
        public String headerOpt = "";
        public boolean isDisableAvatarClick;
        public boolean isHideDislike;
        public LiveData liveData;
        public String photo = "";
        public FeedStarPrivilege privilege;
        public String publishTimeRange = "";
        public String statement = "";
        public String type = "";
        public String uk = "";
        public FeedStarUserName userName;
        public String vType = "";
        public String vUrl = "";

        @JvmStatic
        public static final FeedStarSubdataProfile fromJson(JSONObject jSONObject) {
            return Companion.fromJson(jSONObject);
        }

        @JvmStatic
        public static final JSONObject toJson(FeedStarSubdataProfile feedStarSubdataProfile) {
            return Companion.toJson(feedStarSubdataProfile);
        }

        public final boolean checkUserProfileValid() {
            FeedStarUserName feedStarUserName = this.userName;
            if (feedStarUserName != null) {
                Intrinsics.checkNotNull(feedStarUserName);
                if (feedStarUserName.checkUserNameVaild()) {
                    if (this.photo.length() > 0) {
                        if (this.cmd.length() > 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final boolean isAttentionFloatType() {
            return Intrinsics.areEqual((Object) this.type, (Object) "2");
        }

        public final boolean isOptHeader() {
            return Intrinsics.areEqual((Object) this.headerOpt, (Object) "1");
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarSubdataProfile$Companion;", "", "()V", "ALLOW_AVATAR_CLICK", "", "DISABLE_AVATAR_CLICK", "HIDE_DISLIKE_BTN", "SHOW_DISLIKE_BTN", "TYPE_USER_PROFILE_ATTENTION_FLOAT", "TYPE_USER_PROFILE_RECOMMEND", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarSubdataProfile;", "jsonObject", "Lorg/json/JSONObject;", "innerJson", "childKey", "childValue", "innerModel", "toJson", "user", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FeedTopAuthorInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final JSONObject toJson(FeedStarSubdataProfile user) {
                Intrinsics.checkNotNullParameter(user, "user");
                JSONObject jsonObject = new JSONObject();
                JSONObject $this$toJson_u24lambda_u2d1 = jsonObject;
                FeedStarSubdataProfile $this$toJson_u24lambda_u2d1_u24lambda_u2d0 = user;
                try {
                    $this$toJson_u24lambda_u2d1.put("photo", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.photo);
                    $this$toJson_u24lambda_u2d1.put("cmd", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.cmd);
                    $this$toJson_u24lambda_u2d1.put("vtype", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.vType);
                    $this$toJson_u24lambda_u2d1.put("v_url", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.vUrl);
                    String str = "1";
                    $this$toJson_u24lambda_u2d1.put("hide_dislike", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.isHideDislike ? str : "0");
                    if (!$this$toJson_u24lambda_u2d1_u24lambda_u2d0.isDisableAvatarClick) {
                        str = "0";
                    }
                    $this$toJson_u24lambda_u2d1.put("disableAvatarClick", str);
                    boolean z = true;
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.hat.length() > 0) {
                        $this$toJson_u24lambda_u2d1.put("hat", FeedStarSubdataProfile.Companion.innerJson("image", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.hat));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.createTime.length() > 0) {
                        JSONObject createTimeJson = FeedStarSubdataProfile.Companion.innerJson("text", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.createTime);
                        if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.publishTimeRange.length() > 0) {
                            createTimeJson.put("publish_time_range", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.publishTimeRange);
                        }
                        $this$toJson_u24lambda_u2d1.put("create_time", createTimeJson);
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.statement.length() > 0) {
                        $this$toJson_u24lambda_u2d1.put("ai_statement", FeedStarSubdataProfile.Companion.innerJson("text", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.statement));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.desc.length() > 0) {
                        $this$toJson_u24lambda_u2d1.put("desc", FeedStarSubdataProfile.Companion.innerJson("text", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.desc));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.descTag != null) {
                        ExtensionsTag extensionsTag = $this$toJson_u24lambda_u2d1_u24lambda_u2d0.descTag;
                        Intrinsics.checkNotNull(extensionsTag);
                        $this$toJson_u24lambda_u2d1.put("desc_tag", ExtensionsTag.toJson(extensionsTag));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.descSecondTag != null) {
                        ExtensionsTag extensionsTag2 = $this$toJson_u24lambda_u2d1_u24lambda_u2d0.descSecondTag;
                        Intrinsics.checkNotNull(extensionsTag2);
                        $this$toJson_u24lambda_u2d1.put("desc_tag2", ExtensionsTag.toJson(extensionsTag2));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.userName != null) {
                        FeedStarUserName.Companion companion = FeedStarUserName.Companion;
                        FeedStarUserName feedStarUserName = $this$toJson_u24lambda_u2d1_u24lambda_u2d0.userName;
                        Intrinsics.checkNotNull(feedStarUserName);
                        $this$toJson_u24lambda_u2d1.put("name", companion.toJson(feedStarUserName));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.privilege != null) {
                        FeedStarPrivilege.Companion companion2 = FeedStarPrivilege.Companion;
                        FeedStarPrivilege feedStarPrivilege = $this$toJson_u24lambda_u2d1_u24lambda_u2d0.privilege;
                        Intrinsics.checkNotNull(feedStarPrivilege);
                        $this$toJson_u24lambda_u2d1.put("privilege", companion2.toJson(feedStarPrivilege));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.liveData != null) {
                        LiveData.Companion companion3 = LiveData.Companion;
                        LiveData liveData = $this$toJson_u24lambda_u2d1_u24lambda_u2d0.liveData;
                        Intrinsics.checkNotNull(liveData);
                        $this$toJson_u24lambda_u2d1.put("live_data", companion3.toJson(liveData));
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.commonText.length() > 0) {
                        $this$toJson_u24lambda_u2d1.put("common_text", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.commonText);
                    }
                    if ($this$toJson_u24lambda_u2d1_u24lambda_u2d0.headerOpt.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        $this$toJson_u24lambda_u2d1.put("head_optimization", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.headerOpt);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }

            @JvmStatic
            public final FeedStarSubdataProfile fromJson(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                FeedStarSubdataProfile profile = new FeedStarSubdataProfile();
                FeedStarSubdataProfile $this$fromJson_u24lambda_u2d3 = profile;
                JSONObject $this$fromJson_u24lambda_u2d3_u24lambda_u2d2 = jsonObject;
                String optString = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("photo", "");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(\"photo\", \"\")");
                $this$fromJson_u24lambda_u2d3.photo = optString;
                String optString2 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("cmd", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"cmd\", \"\")");
                $this$fromJson_u24lambda_u2d3.cmd = optString2;
                String optString3 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("vtype", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"vtype\", \"\")");
                $this$fromJson_u24lambda_u2d3.vType = optString3;
                String optString4 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("v_url", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"v_url\", \"\")");
                $this$fromJson_u24lambda_u2d3.vUrl = optString4;
                String optString5 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("type", "1");
                Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"type\", TYPE_USER_PROFILE_RECOMMEND)");
                $this$fromJson_u24lambda_u2d3.type = optString5;
                $this$fromJson_u24lambda_u2d3.isHideDislike = Intrinsics.areEqual((Object) $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("hide_dislike", "0"), (Object) "1");
                $this$fromJson_u24lambda_u2d3.isDisableAvatarClick = Intrinsics.areEqual((Object) $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("disableAvatarClick", "0"), (Object) "1");
                $this$fromJson_u24lambda_u2d3.desc = FeedStarSubdataProfile.Companion.innerModel($this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("desc"), "text");
                JSONObject createTimeJson = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("create_time");
                $this$fromJson_u24lambda_u2d3.createTime = FeedStarSubdataProfile.Companion.innerModel(createTimeJson, "text");
                JSONObject optJSONObject = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("ai_statement");
                String optString6 = optJSONObject != null ? optJSONObject.optString("text") : null;
                if (optString6 == null) {
                    optString6 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(optString6, "optJSONObject(\"ai_statem…?.optString(\"text\") ?: \"\"");
                }
                $this$fromJson_u24lambda_u2d3.statement = optString6;
                $this$fromJson_u24lambda_u2d3.publishTimeRange = FeedStarSubdataProfile.Companion.innerModel(createTimeJson, "publish_time_range");
                $this$fromJson_u24lambda_u2d3.hat = FeedStarSubdataProfile.Companion.innerModel($this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("hat"), "image");
                JSONObject tagJson = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("desc_tag");
                if (tagJson != null) {
                    $this$fromJson_u24lambda_u2d3.descTag = ExtensionsTag.fromJson(tagJson);
                }
                JSONObject descSecondTagJson = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("desc_tag2");
                if (descSecondTagJson != null) {
                    $this$fromJson_u24lambda_u2d3.descSecondTag = ExtensionsTag.fromJson(descSecondTagJson);
                }
                JSONObject json = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("name");
                if (json != null) {
                    $this$fromJson_u24lambda_u2d3.userName = FeedStarUserName.Companion.fromJson(json);
                }
                JSONObject obj = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("privilege");
                if (obj != null) {
                    $this$fromJson_u24lambda_u2d3.privilege = FeedStarPrivilege.Companion.fromJson(obj);
                }
                JSONObject data = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optJSONObject("live_data");
                if (data != null) {
                    $this$fromJson_u24lambda_u2d3.liveData = LiveData.Companion.fromJson(data);
                }
                String optString7 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("uk", "");
                Intrinsics.checkNotNullExpressionValue(optString7, "optString(\"uk\", \"\")");
                $this$fromJson_u24lambda_u2d3.uk = optString7;
                String optString8 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("common_text", "");
                Intrinsics.checkNotNullExpressionValue(optString8, "optString(\"common_text\", \"\")");
                $this$fromJson_u24lambda_u2d3.commonText = optString8;
                String optString9 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("head_optimization", "0");
                Intrinsics.checkNotNullExpressionValue(optString9, "optString(\"head_optimization\", \"0\")");
                $this$fromJson_u24lambda_u2d3.headerOpt = optString9;
                return profile;
            }

            private final String innerModel(JSONObject jsonObject, String childKey) {
                if (jsonObject == null) {
                    return "";
                }
                String optString = jsonObject.optString(childKey, "");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(childKey, \"\")");
                return optString;
            }

            private final JSONObject innerJson(String childKey, String childValue) {
                JSONObject obj = new JSONObject();
                try {
                    obj.put(childKey, childValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return obj;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarPrivilege;", "", "()V", "bgColor", "", "borderColor", "color", "hasBorder", "id", "scheme", "size", "text", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTopAuthorInfo.kt */
    public static final class FeedStarPrivilege {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public String bgColor = "";
        public String borderColor = "";
        public String color = "";
        public String hasBorder = "";
        public String id = "";
        public String scheme = "";
        public String size = "";
        public String text = "";

        @JvmStatic
        public static final FeedStarPrivilege fromJson(JSONObject jSONObject) {
            return Companion.fromJson(jSONObject);
        }

        @JvmStatic
        public static final JSONObject toJson(FeedStarPrivilege feedStarPrivilege) {
            return Companion.toJson(feedStarPrivilege);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarPrivilege$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarPrivilege;", "jsonObject", "Lorg/json/JSONObject;", "toJson", "privilegeObj", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FeedTopAuthorInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final JSONObject toJson(FeedStarPrivilege privilegeObj) {
                Intrinsics.checkNotNullParameter(privilegeObj, "privilegeObj");
                JSONObject jsonObject = new JSONObject();
                JSONObject $this$toJson_u24lambda_u2d1 = jsonObject;
                FeedStarPrivilege $this$toJson_u24lambda_u2d1_u24lambda_u2d0 = privilegeObj;
                try {
                    $this$toJson_u24lambda_u2d1.put("id", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.id);
                    $this$toJson_u24lambda_u2d1.put("text", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.text);
                    $this$toJson_u24lambda_u2d1.put("scheme", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.scheme);
                    $this$toJson_u24lambda_u2d1.put("color", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.color);
                    $this$toJson_u24lambda_u2d1.put("size", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.size);
                    $this$toJson_u24lambda_u2d1.put("bgcolor", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.bgColor);
                    $this$toJson_u24lambda_u2d1.put("has_border", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.hasBorder);
                    $this$toJson_u24lambda_u2d1.put("border_color", $this$toJson_u24lambda_u2d1_u24lambda_u2d0.borderColor);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }

            @JvmStatic
            public final FeedStarPrivilege fromJson(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                FeedStarPrivilege privilege = new FeedStarPrivilege();
                FeedStarPrivilege $this$fromJson_u24lambda_u2d3 = privilege;
                JSONObject $this$fromJson_u24lambda_u2d3_u24lambda_u2d2 = jsonObject;
                String optString = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("text", "");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(\"text\", \"\")");
                $this$fromJson_u24lambda_u2d3.text = optString;
                String optString2 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("id", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"id\", \"\")");
                $this$fromJson_u24lambda_u2d3.id = optString2;
                String optString3 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("scheme", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"scheme\", \"\")");
                $this$fromJson_u24lambda_u2d3.scheme = optString3;
                String optString4 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("color", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"color\", \"\")");
                $this$fromJson_u24lambda_u2d3.color = optString4;
                String optString5 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("size", "");
                Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"size\", \"\")");
                $this$fromJson_u24lambda_u2d3.size = optString5;
                String optString6 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("bgcolor", "");
                Intrinsics.checkNotNullExpressionValue(optString6, "optString(\"bgcolor\", \"\")");
                $this$fromJson_u24lambda_u2d3.bgColor = optString6;
                String optString7 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("has_border", "");
                Intrinsics.checkNotNullExpressionValue(optString7, "optString(\"has_border\", \"\")");
                $this$fromJson_u24lambda_u2d3.hasBorder = optString7;
                String optString8 = $this$fromJson_u24lambda_u2d3_u24lambda_u2d2.optString("border_color", "");
                Intrinsics.checkNotNullExpressionValue(optString8, "optString(\"border_color\", \"\")");
                $this$fromJson_u24lambda_u2d3.borderColor = optString8;
                return privilege;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$PendantInfo;", "", "()V", "ext", "", "isGIF", "originFollowState", "pendantNightUrl", "pendantScheme", "pendantUrl", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTopAuthorInfo.kt */
    public static final class PendantInfo {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public String ext = "";
        public String isGIF = "";
        public String originFollowState = "";
        public String pendantNightUrl = "";
        public String pendantScheme = "";
        public String pendantUrl = "";

        @JvmStatic
        public static final PendantInfo fromJson(JSONObject jSONObject) {
            return Companion.fromJson(jSONObject);
        }

        @JvmStatic
        public static final boolean isVaild(PendantInfo pendantInfo) {
            return Companion.isVaild(pendantInfo);
        }

        @JvmStatic
        public static final JSONObject toJson(PendantInfo pendantInfo) {
            return Companion.toJson(pendantInfo);
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$PendantInfo$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$PendantInfo;", "jsonObject", "Lorg/json/JSONObject;", "isVaild", "", "pendantInfo", "toJson", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FeedTopAuthorInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final JSONObject toJson(PendantInfo pendantInfo) {
                Intrinsics.checkNotNullParameter(pendantInfo, "pendantInfo");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("image", pendantInfo.pendantUrl);
                    jsonObject.put("state", pendantInfo.originFollowState);
                    jsonObject.put("image_night", pendantInfo.pendantNightUrl);
                    jsonObject.put(BDCommentConstants.COMMENT_PIC_IS_GIF, pendantInfo.isGIF);
                    jsonObject.put("scheme", pendantInfo.pendantScheme);
                    jsonObject.put("ext", pendantInfo.ext);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }

            @JvmStatic
            public final PendantInfo fromJson(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                PendantInfo pendantInfo = new PendantInfo();
                String optString = jsonObject.optString("image", "");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"image\", \"\")");
                pendantInfo.pendantUrl = optString;
                String optString2 = jsonObject.optString("state", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"state\", \"\")");
                pendantInfo.originFollowState = optString2;
                String optString3 = jsonObject.optString("image_night", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"image_night\", \"\")");
                pendantInfo.pendantNightUrl = optString3;
                String optString4 = jsonObject.optString(BDCommentConstants.COMMENT_PIC_IS_GIF, "");
                Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"is_gif\", \"\")");
                pendantInfo.isGIF = optString4;
                String optString5 = jsonObject.optString("scheme", "");
                Intrinsics.checkNotNullExpressionValue(optString5, "jsonObject.optString(\"scheme\", \"\")");
                pendantInfo.pendantScheme = optString5;
                String optString6 = jsonObject.optString("ext", "");
                Intrinsics.checkNotNullExpressionValue(optString6, "jsonObject.optString(\"ext\", \"\")");
                pendantInfo.ext = optString6;
                return pendantInfo;
            }

            @JvmStatic
            public final boolean isVaild(PendantInfo pendantInfo) {
                Intrinsics.checkNotNullParameter(pendantInfo, "pendantInfo");
                return !TextUtils.isEmpty(pendantInfo.pendantUrl) && !TextUtils.isEmpty(pendantInfo.pendantNightUrl);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarUserName;", "", "()V", "badge", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarBadge;", "text", "", "checkUserNameVaild", "", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTopAuthorInfo.kt */
    public static final class FeedStarUserName {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public FeedStarBadge badge;
        public String text = "";

        @JvmStatic
        public static final FeedStarUserName fromJson(JSONObject jSONObject) {
            return Companion.fromJson(jSONObject);
        }

        @JvmStatic
        public static final JSONObject toJson(FeedStarUserName feedStarUserName) {
            return Companion.toJson(feedStarUserName);
        }

        public final boolean checkUserNameVaild() {
            return this.text.length() > 0;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarUserName$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarUserName;", "jsonObject", "Lorg/json/JSONObject;", "toJson", "name", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FeedTopAuthorInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final JSONObject toJson(FeedStarUserName name) {
                Intrinsics.checkNotNullParameter(name, "name");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("text", name.text);
                    if (name.badge != null) {
                        FeedStarBadge.Companion companion = FeedStarBadge.Companion;
                        FeedStarBadge feedStarBadge = name.badge;
                        Intrinsics.checkNotNull(feedStarBadge);
                        jsonObject.put(WidgetDataStatisticUtils.PAGE_BADGE, companion.toJson(feedStarBadge));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }

            @JvmStatic
            public final FeedStarUserName fromJson(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                FeedStarUserName userName = new FeedStarUserName();
                String optString = jsonObject.optString("text", "");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"text\", \"\")");
                userName.text = optString;
                JSONObject obj = jsonObject.optJSONObject(WidgetDataStatisticUtils.PAGE_BADGE);
                if (obj != null) {
                    userName.badge = FeedStarBadge.Companion.fromJson(obj);
                }
                return userName;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarBadge;", "", "()V", "ext", "", "imageUrls", "", "scheme", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTopAuthorInfo.kt */
    public static final class FeedStarBadge {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public String ext = "";
        public List<String> imageUrls = new ArrayList();
        public String scheme = "";

        @JvmStatic
        public static final FeedStarBadge fromJson(JSONObject jSONObject) {
            return Companion.fromJson(jSONObject);
        }

        @JvmStatic
        public static final JSONObject toJson(FeedStarBadge feedStarBadge) {
            return Companion.toJson(feedStarBadge);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarBadge$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$FeedStarBadge;", "jsonObject", "Lorg/json/JSONObject;", "toJson", "badge", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FeedTopAuthorInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final JSONObject toJson(FeedStarBadge badge) {
                Intrinsics.checkNotNullParameter(badge, WidgetDataStatisticUtils.PAGE_BADGE);
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("scheme", badge.scheme);
                    jsonObject.put("ext", badge.ext);
                    if (badge.imageUrls != null && (!badge.imageUrls.isEmpty())) {
                        JSONArray array = new JSONArray();
                        JSONObject jsObject = new JSONObject();
                        for (String image : badge.imageUrls) {
                            jsObject.put("image", image);
                            array.put(jsObject);
                        }
                        jsonObject.put(WidgetDataStatisticUtils.PAGE_BADGE, array);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }

            @JvmStatic
            public final FeedStarBadge fromJson(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                FeedStarBadge badge = new FeedStarBadge();
                String optString = jsonObject.optString("scheme", "");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"scheme\", \"\")");
                badge.scheme = optString;
                String optString2 = jsonObject.optString("ext", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"ext\", \"\")");
                badge.ext = optString2;
                if (jsonObject.has("urls")) {
                    JSONArray urls = jsonObject.optJSONArray("urls");
                    Intrinsics.checkNotNullExpressionValue(urls, "jsonObject.optJSONArray(\"urls\")");
                    if (urls.length() > 0) {
                        new JSONObject();
                        int length = urls.length();
                        for (int element = 0; element < length; element++) {
                            JSONObject imageObj = urls.optJSONObject(element);
                            Intrinsics.checkNotNullExpressionValue(imageObj, "urls.optJSONObject(element)");
                            String image = imageObj.optString("image", "");
                            Intrinsics.checkNotNullExpressionValue(image, "imageObj.optString(\"image\", \"\")");
                            badge.imageUrls = CollectionsKt.plus(badge.imageUrls, image);
                        }
                    }
                }
                return badge;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$LiveData;", "", "()V", "liveScheme", "", "liveState", "roomId", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedTopAuthorInfo.kt */
    public static final class LiveData {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public String liveScheme = "";
        public String liveState = "";
        public String roomId = "";

        @JvmStatic
        public static final boolean isVaild(FeedTopAuthorInfo feedTopAuthorInfo) {
            return Companion.isVaild(feedTopAuthorInfo);
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$LiveData$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo$LiveData;", "jsonObject", "Lorg/json/JSONObject;", "isVaild", "", "authorInfo", "Lcom/baidu/searchbox/feed/model/FeedTopAuthorInfo;", "toJson", "liveData", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FeedTopAuthorInfo.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final JSONObject toJson(LiveData liveData) {
                Intrinsics.checkNotNullParameter(liveData, "liveData");
                JSONObject jsonObject = new JSONObject();
                LiveData $this$toJson_u24lambda_u2d0 = liveData;
                try {
                    jsonObject.put("scheme", $this$toJson_u24lambda_u2d0.liveScheme);
                    jsonObject.put("room_id", $this$toJson_u24lambda_u2d0.roomId);
                    jsonObject.put("state", $this$toJson_u24lambda_u2d0.liveState);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }

            public final LiveData fromJson(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                LiveData liveData = new LiveData();
                LiveData $this$fromJson_u24lambda_u2d2 = liveData;
                JSONObject $this$fromJson_u24lambda_u2d2_u24lambda_u2d1 = jsonObject;
                String optString = $this$fromJson_u24lambda_u2d2_u24lambda_u2d1.optString("scheme", "");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(\"scheme\", \"\")");
                $this$fromJson_u24lambda_u2d2.liveScheme = optString;
                String optString2 = $this$fromJson_u24lambda_u2d2_u24lambda_u2d1.optString("room_id", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"room_id\", \"\")");
                $this$fromJson_u24lambda_u2d2.roomId = optString2;
                String optString3 = $this$fromJson_u24lambda_u2d2_u24lambda_u2d1.optString("state", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"state\", \"\")");
                $this$fromJson_u24lambda_u2d2.liveState = optString3;
                return liveData;
            }

            @JvmStatic
            public final boolean isVaild(FeedTopAuthorInfo authorInfo) {
                Intrinsics.checkNotNullParameter(authorInfo, "authorInfo");
                if (authorInfo.user != null) {
                    FeedStarSubdataProfile feedStarSubdataProfile = authorInfo.user;
                    Intrinsics.checkNotNull(feedStarSubdataProfile);
                    if (feedStarSubdataProfile.liveData != null) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
