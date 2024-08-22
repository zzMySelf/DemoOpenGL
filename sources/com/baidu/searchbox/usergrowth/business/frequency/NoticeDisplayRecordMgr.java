package com.baidu.searchbox.usergrowth.business.frequency;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.usergrowth.business.utils.NoticeFrequencySPWrapper;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/usergrowth/business/frequency/NoticeDisplayRecordMgr;", "", "()V", "RECORD_LIST_KEY", "", "displayRecordCache", "", "Lcom/baidu/searchbox/usergrowth/business/frequency/DisplayRecordModel;", "getDisplayRecordCache", "()Ljava/util/List;", "displayRecordCache$delegate", "Lkotlin/Lazy;", "lock", "Ljava/lang/Object;", "addRecordDisplayList", "", "recordList", "getDisplayRecords", "", "loadDisplayRecordCache", "recordDialogDisplay", "type", "", "subType", "saveDisplayRecordLock", "displayRecordList", "lib-usergrowth-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NoticeDisplayRecordMgr.kt */
public final class NoticeDisplayRecordMgr {
    public static final NoticeDisplayRecordMgr INSTANCE = new NoticeDisplayRecordMgr();
    private static final String RECORD_LIST_KEY = "user_notice_display_record_list";
    private static final Lazy displayRecordCache$delegate = LazyKt.lazy(NoticeDisplayRecordMgr$displayRecordCache$2.INSTANCE);
    private static final Object lock = new Object();

    private NoticeDisplayRecordMgr() {
    }

    private final List<DisplayRecordModel> getDisplayRecordCache() {
        return (List) displayRecordCache$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.baidu.searchbox.usergrowth.business.frequency.DisplayRecordModel> loadDisplayRecordCache() {
        /*
            r21 = this;
            com.baidu.searchbox.usergrowth.business.utils.NoticeFrequencySPWrapper r0 = com.baidu.searchbox.usergrowth.business.utils.NoticeFrequencySPWrapper.INSTANCE
            java.lang.String r1 = "user_notice_display_record_list"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L_0x0097
            com.baidu.searchbox.kmm.foundation.kelson.JsonArray r0 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.toJsonArray(r0)
            if (r0 == 0) goto L_0x0097
            r1 = r0
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r1 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r1
            java.lang.String r2 = "list"
            r3 = 0
            r0 = r1
            com.baidu.searchbox.kmm.foundation.kelson.JsonArray r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonArray) r0
            r4 = r0
            if (r4 != 0) goto L_0x0027
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r2 = r0
            goto L_0x0097
        L_0x0027:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = r0
            java.util.List r5 = (java.util.List) r5
            r6 = r5
            r7 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x007d }
            r0 = r6
            r8 = 0
            r9 = r4
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x007d }
            r10 = 0
            java.util.Iterator r11 = r9.iterator()     // Catch:{ all -> 0x007d }
        L_0x003e:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x007d }
            if (r12 == 0) goto L_0x006f
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x007d }
            r13 = r12
            com.baidu.searchbox.kmm.foundation.kelson.JsonElement r13 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r13     // Catch:{ all -> 0x007d }
            r14 = 0
            r15 = r13
            r16 = 0
            r17 = r1
            com.baidu.searchbox.usergrowth.business.frequency.DisplayRecordModel r1 = new com.baidu.searchbox.usergrowth.business.frequency.DisplayRecordModel     // Catch:{ all -> 0x006b }
            r1.<init>()     // Catch:{ all -> 0x006b }
            r18 = r1
            r19 = 0
            r20 = r2
            r2 = r18
            r2.decode(r15)     // Catch:{ all -> 0x007b }
            r0.add(r1)     // Catch:{ all -> 0x007b }
            r1 = r17
            r2 = r20
            goto L_0x003e
        L_0x006b:
            r0 = move-exception
            r20 = r2
            goto L_0x0082
        L_0x006f:
            r17 = r1
            r20 = r2
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007b }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x007b }
            goto L_0x008c
        L_0x007b:
            r0 = move-exception
            goto L_0x0082
        L_0x007d:
            r0 = move-exception
            r17 = r1
            r20 = r2
        L_0x0082:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x008c:
            java.lang.Throwable r0 = kotlin.Result.m8974exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x0095
            r0.printStackTrace()
        L_0x0095:
            r2 = r5
        L_0x0097:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.usergrowth.business.frequency.NoticeDisplayRecordMgr.loadDisplayRecordCache():java.util.List");
    }

    public final List<DisplayRecordModel> getDisplayRecords() {
        List<DisplayRecordModel> displayRecordCache;
        synchronized (lock) {
            displayRecordCache = INSTANCE.getDisplayRecordCache();
        }
        return displayRecordCache;
    }

    private final void saveDisplayRecordLock(List<DisplayRecordModel> displayRecordList) {
        if (displayRecordList.isEmpty()) {
            NoticeFrequencySPWrapper.INSTANCE.putString(RECORD_LIST_KEY, "");
            return;
        }
        NoticeFrequencySPWrapper noticeFrequencySPWrapper = NoticeFrequencySPWrapper.INSTANCE;
        JsonArray jsonArray = new JsonArray();
        JsonArray $this$saveDisplayRecordLock_u24lambda_u2d4 = jsonArray;
        for (DisplayRecordModel it : displayRecordList) {
            $this$saveDisplayRecordLock_u24lambda_u2d4.add(JsonUtilKt.toJsonElement(it.encode()));
        }
        Unit unit = Unit.INSTANCE;
        noticeFrequencySPWrapper.putString(RECORD_LIST_KEY, jsonArray.toString());
    }

    public final void recordDialogDisplay(long type, long subType) {
        ExecutorUtilsExt.postOnElastic(new NoticeDisplayRecordMgr$$ExternalSyntheticLambda0(type, subType), "recordDialogDisplay", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: recordDialogDisplay$lambda-7  reason: not valid java name */
    public static final void m4709recordDialogDisplay$lambda7(long $type, long $subType) {
        DisplayRecordModel record = new DisplayRecordModel();
        DisplayRecordModel $this$recordDialogDisplay_u24lambda_u2d7_u24lambda_u2d5 = record;
        $this$recordDialogDisplay_u24lambda_u2d7_u24lambda_u2d5.setType($type);
        $this$recordDialogDisplay_u24lambda_u2d7_u24lambda_u2d5.setSubType($subType);
        $this$recordDialogDisplay_u24lambda_u2d7_u24lambda_u2d5.setTime(System.currentTimeMillis());
        synchronized (lock) {
            NoticeDisplayRecordMgr noticeDisplayRecordMgr = INSTANCE;
            noticeDisplayRecordMgr.getDisplayRecordCache().add(record);
            noticeDisplayRecordMgr.saveDisplayRecordLock(noticeDisplayRecordMgr.getDisplayRecordCache());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addRecordDisplayList(List<DisplayRecordModel> recordList) {
        Intrinsics.checkNotNullParameter(recordList, "recordList");
        ExecutorUtilsExt.postOnElastic(new NoticeDisplayRecordMgr$$ExternalSyntheticLambda1(recordList), "recordDialogDisplay", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: addRecordDisplayList$lambda-10  reason: not valid java name */
    public static final void m4708addRecordDisplayList$lambda10(List $recordList) {
        Intrinsics.checkNotNullParameter($recordList, "$recordList");
        synchronized (lock) {
            Iterator it = $recordList.iterator();
            while (it.hasNext()) {
                DisplayRecordModel record = (DisplayRecordModel) it.next();
                NoticeDisplayRecordMgr noticeDisplayRecordMgr = INSTANCE;
                if (!noticeDisplayRecordMgr.getDisplayRecordCache().contains(record)) {
                    noticeDisplayRecordMgr.getDisplayRecordCache().add(record);
                }
            }
            NoticeDisplayRecordMgr noticeDisplayRecordMgr2 = INSTANCE;
            noticeDisplayRecordMgr2.saveDisplayRecordLock(noticeDisplayRecordMgr2.getDisplayRecordCache());
            Unit unit = Unit.INSTANCE;
        }
    }
}
