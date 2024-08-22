package com.baidu.searchbox.sniffer;

import android.os.HandlerThread;
import com.baidu.searchbox.sniffer.listener.SnifferNetDiskRecycleQueryListener;
import com.baidu.searchbox.sniffer.model.SnifferNetDiskBusinessType;
import com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel;
import com.baidu.searchbox.sniffer.service.ISnifferNetDiskManager;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002JH\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e26\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002JT\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142<\u0010\u0017\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0018H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/sniffer/SnifferNetDiskManager;", "Lcom/baidu/searchbox/sniffer/service/ISnifferNetDiskManager;", "businessType", "Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskBusinessType;", "(Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskBusinessType;)V", "mBusinessType", "mIsStopRecycling", "", "mRecycleHandlerThread", "Landroid/os/HandlerThread;", "mRecycleQueryListener", "Lcom/baidu/searchbox/sniffer/listener/SnifferNetDiskRecycleQueryListener;", "mRecyclingTaskModels", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskTaskModel;", "mWaitingRecycleList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addRecycleTask", "", "taskToRecycleList", "", "addSnifferNetDiskTask", "snifferNetDiskTaskModel", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "addResult", "success", "doRealRecycleQuery", "querySnifferNetDiskStatus", "snifferNetDiskTaskModelList", "taskModelListToQuery", "registerSnifferNetDiskMonitor", "snifferNetDiskRecycleQueryListener", "stopRecycleQuery", "unRegisterSnifferNetDiskMonitor", "Companion", "lib-sniffer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferNetDiskManager.kt */
public final class SnifferNetDiskManager implements ISnifferNetDiskManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final HashMap<SnifferNetDiskBusinessType, SnifferNetDiskManager> snifferNetDiskManagerMap = new HashMap<>();
    private final SnifferNetDiskBusinessType mBusinessType;
    /* access modifiers changed from: private */
    public volatile boolean mIsStopRecycling;
    /* access modifiers changed from: private */
    public HandlerThread mRecycleHandlerThread;
    /* access modifiers changed from: private */
    public SnifferNetDiskRecycleQueryListener mRecycleQueryListener;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<SnifferNetDiskTaskModel> mRecyclingTaskModels;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<SnifferNetDiskTaskModel> mWaitingRecycleList;

    public /* synthetic */ SnifferNetDiskManager(SnifferNetDiskBusinessType snifferNetDiskBusinessType, DefaultConstructorMarker defaultConstructorMarker) {
        this(snifferNetDiskBusinessType);
    }

    private SnifferNetDiskManager(SnifferNetDiskBusinessType businessType) {
        this.mRecyclingTaskModels = new CopyOnWriteArraySet<>();
        this.mWaitingRecycleList = new CopyOnWriteArrayList<>();
        this.mBusinessType = businessType;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/sniffer/SnifferNetDiskManager$Companion;", "", "()V", "snifferNetDiskManagerMap", "Ljava/util/HashMap;", "Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskBusinessType;", "Lcom/baidu/searchbox/sniffer/SnifferNetDiskManager;", "Lkotlin/collections/HashMap;", "getSnifferNetDiskManager", "businessType", "lib-sniffer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnifferNetDiskManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnifferNetDiskManager getSnifferNetDiskManager(SnifferNetDiskBusinessType businessType) {
            SnifferNetDiskManager snifferNetDiskManager;
            Intrinsics.checkNotNullParameter(businessType, "businessType");
            synchronized (SnifferNetDiskManager.snifferNetDiskManagerMap) {
                if (SnifferNetDiskManager.snifferNetDiskManagerMap.containsKey(businessType)) {
                    snifferNetDiskManager = (SnifferNetDiskManager) SnifferNetDiskManager.snifferNetDiskManagerMap.get(businessType);
                    if (snifferNetDiskManager == null) {
                        snifferNetDiskManager = new SnifferNetDiskManager(businessType, (DefaultConstructorMarker) null);
                    }
                } else {
                    snifferNetDiskManager = new SnifferNetDiskManager(businessType, (DefaultConstructorMarker) null);
                }
                Intrinsics.checkNotNullExpressionValue(snifferNetDiskManager, "if (snifferNetDiskManage…pe)\n                    }");
                SnifferNetDiskManager.snifferNetDiskManagerMap.put(businessType, snifferNetDiskManager);
            }
            return snifferNetDiskManager;
        }
    }

    public void querySnifferNetDiskStatus(List<SnifferNetDiskTaskModel> snifferNetDiskTaskModelList, Function2<? super List<SnifferNetDiskTaskModel>, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(snifferNetDiskTaskModelList, "snifferNetDiskTaskModelList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.mIsStopRecycling) {
            this.mIsStopRecycling = false;
        }
        SnifferNetDiskHelper.INSTANCE.requestNetDiskShieldService(snifferNetDiskTaskModelList, new SnifferNetDiskManager$querySnifferNetDiskStatus$1(callback, snifferNetDiskTaskModelList, this));
    }

    public void addSnifferNetDiskTask(SnifferNetDiskTaskModel snifferNetDiskTaskModel, Function2<? super SnifferNetDiskTaskModel, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(snifferNetDiskTaskModel, "snifferNetDiskTaskModel");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.mIsStopRecycling) {
            this.mIsStopRecycling = false;
        }
        CharSequence url = snifferNetDiskTaskModel.getUrl();
        if (url == null || url.length() == 0) {
            callback.invoke(snifferNetDiskTaskModel, false);
        }
        SnifferNetDiskHelper.INSTANCE.requestNetDiskStatusQueryByUrls(CollectionsKt.listOf(snifferNetDiskTaskModel), new SnifferNetDiskManager$addSnifferNetDiskTask$1(callback, this, snifferNetDiskTaskModel));
    }

    public void registerSnifferNetDiskMonitor(SnifferNetDiskRecycleQueryListener snifferNetDiskRecycleQueryListener) {
        Intrinsics.checkNotNullParameter(snifferNetDiskRecycleQueryListener, "snifferNetDiskRecycleQueryListener");
        this.mRecycleQueryListener = snifferNetDiskRecycleQueryListener;
    }

    public void unRegisterSnifferNetDiskMonitor() {
        this.mRecycleQueryListener = null;
        HashMap<SnifferNetDiskBusinessType, SnifferNetDiskManager> hashMap = snifferNetDiskManagerMap;
        if (hashMap.containsKey(this.mBusinessType)) {
            hashMap.remove(this.mBusinessType);
        }
    }

    public void stopRecycleQuery() {
        this.mIsStopRecycling = true;
        HandlerThread handlerThread = this.mRecycleHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.mRecycleHandlerThread = null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addRecycleTask(java.util.List<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r7) {
        /*
            r6 = this;
            com.baidu.searchbox.sniffer.listener.SnifferNetDiskRecycleQueryListener r0 = r6.mRecycleQueryListener
            if (r0 == 0) goto L_0x007d
            boolean r0 = r6.mIsStopRecycling
            if (r0 == 0) goto L_0x000a
            goto L_0x007d
        L_0x000a:
            monitor-enter(r6)
            r0 = 0
            java.util.concurrent.CopyOnWriteArraySet<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r1 = r6.mRecyclingTaskModels     // Catch:{ all -> 0x007a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x007a }
            java.util.Iterator r2 = r7.iterator()     // Catch:{ all -> 0x007a }
        L_0x0016:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x005a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x007a }
            com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel r3 = (com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel) r3     // Catch:{ all -> 0x007a }
            java.lang.String r4 = r3.getUrl()     // Catch:{ all -> 0x007a }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x0033
            int r4 = r4.length()     // Catch:{ all -> 0x007a }
            if (r4 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r4 = 0
            goto L_0x0034
        L_0x0033:
            r4 = 1
        L_0x0034:
            if (r4 != 0) goto L_0x0016
            java.lang.Long r4 = r3.getTaskId()     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x0016
            java.util.concurrent.CopyOnWriteArraySet<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r4 = r6.mRecyclingTaskModels     // Catch:{ all -> 0x007a }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x007a }
            if (r4 != 0) goto L_0x0016
            java.util.concurrent.CopyOnWriteArraySet<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r4 = r6.mRecyclingTaskModels     // Catch:{ all -> 0x007a }
            int r4 = r4.size()     // Catch:{ all -> 0x007a }
            r5 = 20
            if (r4 >= r5) goto L_0x0054
            java.util.concurrent.CopyOnWriteArraySet<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r4 = r6.mRecyclingTaskModels     // Catch:{ all -> 0x007a }
            r4.add(r3)     // Catch:{ all -> 0x007a }
            goto L_0x0016
        L_0x0054:
            java.util.concurrent.CopyOnWriteArrayList<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r4 = r6.mWaitingRecycleList     // Catch:{ all -> 0x007a }
            r4.add(r3)     // Catch:{ all -> 0x007a }
            goto L_0x0016
        L_0x005a:
            if (r1 == 0) goto L_0x0069
            boolean r2 = r6.mIsStopRecycling     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0061
            goto L_0x0069
        L_0x0061:
            r6.doRealRecycleQuery()     // Catch:{ all -> 0x007a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007a }
            monitor-exit(r6)
            return
        L_0x0069:
            boolean r2 = r6.mIsStopRecycling     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0077
            java.util.concurrent.CopyOnWriteArraySet<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r2 = r6.mRecyclingTaskModels     // Catch:{ all -> 0x007a }
            r2.clear()     // Catch:{ all -> 0x007a }
            java.util.concurrent.CopyOnWriteArrayList<com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel> r2 = r6.mWaitingRecycleList     // Catch:{ all -> 0x007a }
            r2.clear()     // Catch:{ all -> 0x007a }
        L_0x0077:
            monitor-exit(r6)
            return
        L_0x007a:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sniffer.SnifferNetDiskManager.addRecycleTask(java.util.List):void");
    }

    private final void doRealRecycleQuery() {
        HandlerThread snifferNetDiskManager$doRealRecycleQuery$1 = new SnifferNetDiskManager$doRealRecycleQuery$1(this, this.mBusinessType.name());
        this.mRecycleHandlerThread = snifferNetDiskManager$doRealRecycleQuery$1;
        snifferNetDiskManager$doRealRecycleQuery$1.start();
    }
}
