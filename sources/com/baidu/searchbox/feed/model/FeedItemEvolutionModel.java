package com.baidu.searchbox.feed.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0012\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010%H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006("}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedItemEvolutionModel;", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "Lcom/baidu/searchbox/feed/model/IFeedHScrollModel;", "()V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "detail", "Lcom/baidu/searchbox/feed/model/FeedEvolutionDetailModel;", "getDetail", "()Lcom/baidu/searchbox/feed/model/FeedEvolutionDetailModel;", "setDetail", "(Lcom/baidu/searchbox/feed/model/FeedEvolutionDetailModel;)V", "duration", "getDuration", "setDuration", "labelUrl", "getLabelUrl", "setLabelUrl", "getChildren", "", "Lcom/baidu/searchbox/feed/model/FeedHScrollChildModel;", "getHideChildren", "isValidate", "Lcom/baidu/searchbox/feed/parser/ValidationResult;", "context", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "isValidateMode", "", "mode", "needChildDup", "needRecordDisplay", "needUploadCmd100", "toJson", "Lorg/json/JSONObject;", "toModel", "jsonObject", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedItemEvolutionModel.kt */
public final class FeedItemEvolutionModel extends FeedItemData implements IFeedHScrollModel {
    private String coverUrl;
    private FeedEvolutionDetailModel detail;
    private String duration;
    private String labelUrl;

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final String getLabelUrl() {
        return this.labelUrl;
    }

    public final void setLabelUrl(String str) {
        this.labelUrl = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final FeedEvolutionDetailModel getDetail() {
        return this.detail;
    }

    public final void setDetail(FeedEvolutionDetailModel feedEvolutionDetailModel) {
        this.detail = feedEvolutionDetailModel;
    }

    public JSONObject toJson() {
        Object obj;
        JSONObject jSONObject;
        JSONObject parse2Json = super.parse2Json();
        JSONObject $this$toJson_u24lambda_u2d7 = parse2Json;
        int i2 = false;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject $this$toJson_u24lambda_u2d7_u24lambda_u2d5 = $this$toJson_u24lambda_u2d7;
            int i3 = false;
            $this$toJson_u24lambda_u2d7_u24lambda_u2d5.put("image", this.coverUrl);
            $this$toJson_u24lambda_u2d7_u24lambda_u2d5.put("label", this.labelUrl);
            $this$toJson_u24lambda_u2d7_u24lambda_u2d5.put("duration", this.duration);
            FeedEvolutionDetailModel $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4 = this.detail;
            if ($this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4 != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3 = jSONObject2;
                $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.put("cmd", $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4.getCmd());
                $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.put("auto_play", $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4.getAutoScrollDelay());
                $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.put("interval", $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4.getInterval());
                $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.put("day_interval", $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4.getDayInterval());
                JSONArray jSONArray = new JSONArray();
                JSONArray $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2 = jSONArray;
                ArrayList<FeedEvolutionDetailItemModel> $this$forEach$iv = $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4.getList();
                if ($this$forEach$iv != null) {
                    for (FeedEvolutionDetailItemModel item : $this$forEach$iv) {
                        JSONObject $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = new JSONObject();
                        JSONObject $this$toJson_u24lambda_u2d72 = $this$toJson_u24lambda_u2d7;
                        int i4 = i2;
                        FeedEvolutionDetailItemModel item2 = item;
                        int i5 = i3;
                        try {
                            FeedEvolutionDetailModel $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d42 = $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4;
                            JSONObject $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02 = $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0;
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02.put("id", item2.id);
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02.put("icon", item2.getIconUrl());
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02.put("sort_time", item2.getTime());
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02.put("title", item2.getTitle());
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02.put("cmd", item2.getCmd());
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d02.put("ext", item2.ext);
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.put($this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0);
                            i3 = i5;
                            $this$toJson_u24lambda_u2d7 = $this$toJson_u24lambda_u2d72;
                            i2 = i4;
                            $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4 = $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d42;
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.m8971constructorimpl(ResultKt.createFailure(th));
                            Throwable r0 = Result.m8974exceptionOrNullimpl(obj);
                            Intrinsics.checkNotNullExpressionValue(parse2Json, "super.parse2Json().apply…)\n            }\n        }");
                            return parse2Json;
                        }
                    }
                    int i6 = i2;
                    int i7 = i3;
                    FeedEvolutionDetailModel feedEvolutionDetailModel = $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4;
                } else {
                    FeedEvolutionDetailModel feedEvolutionDetailModel2 = $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4;
                }
                Unit unit = Unit.INSTANCE;
                $this$toJson_u24lambda_u2d7_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.put("list", jSONArray);
                Unit unit2 = Unit.INSTANCE;
                jSONObject = $this$toJson_u24lambda_u2d7_u24lambda_u2d5.put("news_list", jSONObject2);
            } else {
                jSONObject = null;
            }
            obj = Result.m8971constructorimpl(jSONObject);
        } catch (Throwable th3) {
            th = th3;
            JSONObject jSONObject3 = $this$toJson_u24lambda_u2d7;
            Result.Companion companion22 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th));
            Throwable r02 = Result.m8974exceptionOrNullimpl(obj);
            Intrinsics.checkNotNullExpressionValue(parse2Json, "super.parse2Json().apply…)\n            }\n        }");
            return parse2Json;
        }
        Throwable r022 = Result.m8974exceptionOrNullimpl(obj);
        Intrinsics.checkNotNullExpressionValue(parse2Json, "super.parse2Json().apply…)\n            }\n        }");
        return parse2Json;
    }

    /* Debug info: failed to restart local var, previous not found, register: 27 */
    public FeedItemData toModel(JSONObject jsonObject) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        Object obj4;
        int i3;
        Object obj5;
        int dayInterval;
        JSONObject jSONObject = jsonObject;
        super.parse2Model(jSONObject, this);
        if (jSONObject != null) {
            try {
                Result.Companion companion = Result.Companion;
                JSONObject $this$toModel_u24lambda_u2d15 = jsonObject;
                this.coverUrl = $this$toModel_u24lambda_u2d15.optString("image");
                this.labelUrl = $this$toModel_u24lambda_u2d15.optString("label");
                this.duration = $this$toModel_u24lambda_u2d15.optString("duration");
                JSONObject optJSONObject = $this$toModel_u24lambda_u2d15.optJSONObject("news_list");
                obj2 = null;
                if (optJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(KEY_DETAIL_LIST)");
                    JSONObject $this$toModel_u24lambda_u2d15_u24lambda_u2d14 = optJSONObject;
                    String cmd = $this$toModel_u24lambda_u2d15_u24lambda_u2d14.optString("cmd");
                    Result.Companion companion2 = Result.Companion;
                    String optString = $this$toModel_u24lambda_u2d15_u24lambda_u2d14.optString("auto_play");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(KEY_DETAIL_LIST_AUTO_PLAY)");
                    obj3 = Result.m8971constructorimpl(Integer.valueOf(Integer.parseInt(optString)));
                    if (Result.m8977isFailureimpl(obj3)) {
                        obj3 = null;
                    }
                    Integer num = (Integer) obj3;
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        i2 = 2;
                    }
                    int autoScrollDelay = i2;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        String optString2 = $this$toModel_u24lambda_u2d15_u24lambda_u2d14.optString("interval");
                        Intrinsics.checkNotNullExpressionValue(optString2, "optString(KEY_DETAIL_LIST_INTERVAL)");
                        obj4 = Result.m8971constructorimpl(Integer.valueOf(Integer.parseInt(optString2)));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj4 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (Result.m8977isFailureimpl(obj4)) {
                        obj4 = null;
                    }
                    Integer num2 = (Integer) obj4;
                    if (num2 != null) {
                        i3 = num2.intValue();
                    } else {
                        i3 = 2;
                    }
                    int interval = i3;
                    try {
                        Result.Companion companion5 = Result.Companion;
                        String optString3 = $this$toModel_u24lambda_u2d15_u24lambda_u2d14.optString("day_interval");
                        Intrinsics.checkNotNullExpressionValue(optString3, "optString(KEY_DETAIL_LIST_DAY_INTERVAL)");
                        obj5 = Result.m8971constructorimpl(Integer.valueOf(Integer.parseInt(optString3)));
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.Companion;
                        obj5 = Result.m8971constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (!Result.m8977isFailureimpl(obj5)) {
                        obj2 = obj5;
                    }
                    Integer num3 = (Integer) obj2;
                    if (num3 != null) {
                        dayInterval = num3.intValue();
                    } else {
                        dayInterval = 1;
                    }
                    ArrayList list = new ArrayList();
                    JSONArray $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13 = $this$toModel_u24lambda_u2d15_u24lambda_u2d14.optJSONArray("list");
                    if ($this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13 != null) {
                        Intrinsics.checkNotNullExpressionValue($this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13, "optJSONArray(KEY_DETAIL_ITEM_LIST)");
                        int index = 0;
                        int length = $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13.length();
                        while (index < length) {
                            Object obj6 = $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13.get(index);
                            if (obj6 != null) {
                                int i4 = length;
                                JSONObject $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12 = (JSONObject) obj6;
                                FeedEvolutionDetailItemModel feedEvolutionDetailItemModel = new FeedEvolutionDetailItemModel($this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.optString("id"), $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.optString("icon"), $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.optString("sort_time"), $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.optString("title"), $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.optString("cmd"), $this$toModel_u24lambda_u2d15_u24lambda_u2d14_u24lambda_u2d13_u24lambda_u2d12.optString("ext"));
                                if (FeedItemEvolutionModelKt.isValidate(feedEvolutionDetailItemModel)) {
                                    list.add(feedEvolutionDetailItemModel);
                                }
                                index++;
                                length = i4;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                        }
                    }
                    ArrayList arrayList = list;
                    this.detail = new FeedEvolutionDetailModel(cmd, autoScrollDelay <= 0 ? 2 : autoScrollDelay, interval <= 0 ? 2 : interval, dayInterval == 0 ? 1 : dayInterval, list);
                    obj2 = Unit.INSTANCE;
                }
            } catch (Throwable th4) {
                Result.Companion companion7 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th4));
            }
            obj = Result.m8971constructorimpl(obj2);
            Throwable r3 = Result.m8974exceptionOrNullimpl(obj);
            Result.m8970boximpl(obj);
        }
        return this;
    }

    public List<? extends FeedHScrollChildModel> getChildren() {
        FeedEvolutionDetailModel feedEvolutionDetailModel = this.detail;
        return feedEvolutionDetailModel != null ? feedEvolutionDetailModel.getList() : null;
    }

    public List<? extends FeedHScrollChildModel> getHideChildren() {
        return null;
    }

    public boolean needUploadCmd100() {
        return true;
    }

    public boolean needChildDup() {
        return false;
    }

    public boolean needRecordDisplay() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (com.baidu.searchbox.feed.model.FeedItemEvolutionModelKt.isValidate(r3.detail) != false) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.parser.ValidationResult isValidate(com.baidu.searchbox.feed.model.FeedBaseModel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r3.mMode
            boolean r0 = r3.isValidateMode(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = r3.title
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x001e
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r0 = r2
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            if (r0 != 0) goto L_0x0052
            com.baidu.searchbox.feed.model.CString r0 = r3.cmd
            java.lang.String r0 = r0.get()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0034
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r0 = r2
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            if (r0 != 0) goto L_0x0052
            java.lang.String r0 = r3.coverUrl
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0046
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r0 = r2
            goto L_0x0047
        L_0x0046:
            r0 = r1
        L_0x0047:
            if (r0 != 0) goto L_0x0052
            com.baidu.searchbox.feed.model.FeedEvolutionDetailModel r0 = r3.detail
            boolean r0 = com.baidu.searchbox.feed.model.FeedItemEvolutionModelKt.isValidate((com.baidu.searchbox.feed.model.FeedEvolutionDetailModel) r0)
            if (r0 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = r2
        L_0x0053:
            com.baidu.searchbox.feed.parser.ValidationResult r0 = com.baidu.searchbox.feed.parser.ValidationResult.from(r1)
            java.lang.String r1 = "from(isValidateMode(mMod…) && detail.isValidate())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.model.FeedItemEvolutionModel.isValidate(com.baidu.searchbox.feed.model.FeedBaseModel):com.baidu.searchbox.feed.parser.ValidationResult");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isValidateMode(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0034
            int r0 = r2.hashCode()
            switch(r0) {
                case -1867885268: goto L_0x0028;
                case 3322092: goto L_0x001e;
                case 3556653: goto L_0x0014;
                case 112202875: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0034
        L_0x000a:
            java.lang.String r0 = "video"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0014:
            java.lang.String r0 = "text"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0032
            goto L_0x0034
        L_0x001e:
            java.lang.String r0 = "live"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0034
            goto L_0x0032
        L_0x0028:
            java.lang.String r0 = "subject"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.model.FeedItemEvolutionModel.isValidateMode(java.lang.String):boolean");
    }
}
