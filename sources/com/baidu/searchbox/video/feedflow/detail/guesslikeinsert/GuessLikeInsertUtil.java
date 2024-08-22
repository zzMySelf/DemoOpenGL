package com.baidu.searchbox.video.feedflow.detail.guesslikeinsert;

import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import com.baidu.searchbox.video.detail.utils.DateUtilsKt;
import com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactory;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J)\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/guesslikeinsert/GuessLikeInsertUtil;", "", "()V", "<set-?>", "", "showRecord", "getShowRecord", "()Ljava/lang/String;", "setShowRecord", "(Ljava/lang/String;)V", "showRecord$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "getGuessLikeInsertUtilModel", "Lcom/baidu/searchbox/video/feedflow/detail/guesslikeinsert/GuessLikeInsertRecordModel;", "isGuessLikeCanShowFixedPN", "", "from", "type", "fixedPN", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Z", "isGuessLikeCanShowFreq", "day", "limits", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Z", "setGuessLikeDate", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "setGuessLikeVisitInfo", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuessLikeInsertUtil.kt */
public final class GuessLikeInsertUtil {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuessLikeInsertUtil.class, "showRecord", "getShowRecord()Ljava/lang/String;", 0))};
    public static final GuessLikeInsertUtil INSTANCE = new GuessLikeInsertUtil();
    private static final VideoSPData showRecord$delegate = new VideoSPData("video_flow_guess_like_show_record", "", false, (String) null, 12, (DefaultConstructorMarker) null);

    private GuessLikeInsertUtil() {
    }

    private final String getShowRecord() {
        return (String) showRecord$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void setShowRecord(String str) {
        showRecord$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final boolean isGuessLikeCanShowFreq(String from, Integer day, Integer limits) {
        if (from == null || day == null || limits == null) {
            return false;
        }
        Date currentDate = new Date();
        Map<String, List<String>> showDateRecord = getGuessLikeInsertUtilModel().getShowDateRecord();
        List<String> list = showDateRecord != null ? showDateRecord.get(from) : null;
        int sum = 0;
        if (list != null) {
            for (String item : list) {
                Date date = DateUtilsKt.toDate(item);
                if (date != null && DateUtilsKt.differentDays(date, currentDate) < day.intValue()) {
                    sum++;
                }
            }
        }
        if (sum < limits.intValue()) {
            return true;
        }
        return false;
    }

    public final void setGuessLikeDate(String from, Integer limits) {
        List list;
        if (from != null && limits != null) {
            String currentDate = DateUtilsKt.toStringFormatDate(new Date());
            GuessLikeInsertRecordModel model = getGuessLikeInsertUtilModel();
            Map<String, List<String>> showDateRecord = model.getShowDateRecord();
            if (showDateRecord == null || (list = showDateRecord.get(from)) == null) {
                list = new ArrayList();
            }
            list.add(currentDate);
            if (list.size() > limits.intValue()) {
                list.remove(0);
            }
            Map<String, List<String>> showDateRecord2 = model.getShowDateRecord();
            if (showDateRecord2 != null) {
                showDateRecord2.put(from, list);
            }
            setShowRecord(VideoGsonFactory.INSTANCE.safeToJson(model));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r2 = r2.get(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isGuessLikeCanShowFixedPN(java.lang.String r5, java.lang.String r6, java.lang.Integer r7) {
        /*
            r4 = this;
            java.lang.String r0 = "fixed"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            r1 = 1
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r0 = 0
            if (r5 == 0) goto L_0x0031
            if (r7 != 0) goto L_0x0010
            goto L_0x0031
        L_0x0010:
            com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeInsertRecordModel r2 = r4.getGuessLikeInsertUtilModel()
            java.util.Map r2 = r2.getVisitTimes()
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = r2.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x0027
            int r2 = r2.intValue()
            goto L_0x0028
        L_0x0027:
            r2 = r0
        L_0x0028:
            int r3 = r7.intValue()
            if (r2 < r3) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r0
        L_0x0030:
            return r1
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeInsertUtil.isGuessLikeCanShowFixedPN(java.lang.String, java.lang.String, java.lang.Integer):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        r3 = r3.get(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setGuessLikeVisitInfo(java.lang.String r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.lang.String r0 = com.baidu.searchbox.video.detail.utils.DateUtilsKt.toStringFormatDate(r0)
            com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeInsertRecordModel r1 = r6.getGuessLikeInsertUtilModel()
            java.util.Map r2 = r1.getVisitDate()
            if (r2 == 0) goto L_0x001e
            java.lang.Object r2 = r2.get(r7)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x001f
        L_0x001e:
            r2 = r0
        L_0x001f:
            java.util.Map r3 = r1.getVisitTimes()
            if (r3 == 0) goto L_0x0032
            java.lang.Object r3 = r3.get(r7)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0032
            int r3 = r3.intValue()
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r4 != 0) goto L_0x003b
            r2 = r0
            r3 = 0
        L_0x003b:
            int r3 = r3 + 1
            java.util.Map r4 = r1.getVisitDate()
            if (r4 == 0) goto L_0x0046
            r4.put(r7, r2)
        L_0x0046:
            java.util.Map r4 = r1.getVisitTimes()
            if (r4 == 0) goto L_0x0053
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r4.put(r7, r5)
        L_0x0053:
            com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactory r4 = com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactory.INSTANCE
            java.lang.String r4 = r4.safeToJson(r1)
            r6.setShowRecord(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.guesslikeinsert.GuessLikeInsertUtil.setGuessLikeVisitInfo(java.lang.String):void");
    }

    private final GuessLikeInsertRecordModel getGuessLikeInsertUtilModel() {
        String showRecord = getShowRecord();
        Type type = new GuessLikeInsertUtil$getGuessLikeInsertUtilModel$model$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<Guess…ertRecordModel>() {}.type");
        GuessLikeInsertRecordModel model = (GuessLikeInsertRecordModel) VideoGsonFactory.safeFromJson(showRecord, type);
        if ((model != null ? model.getShowDateRecord() : null) == null || model.getVisitDate() == null || model.getVisitTimes() == null) {
            return new GuessLikeInsertRecordModel(new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap());
        }
        return model;
    }
}
