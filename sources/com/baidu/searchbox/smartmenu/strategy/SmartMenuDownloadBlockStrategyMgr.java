package com.baidu.searchbox.smartmenu.strategy;

import android.util.Log;
import com.baidu.android.util.UniKV;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem;
import com.baidu.searchbox.smartmenu.cloudconfig.model.SmartMenuCardInOutRulesModel;
import com.baidu.searchbox.smartmenu.cloudconfig.model.SmartMenuCardModel;
import com.baidu.searchbox.smartmenu.model.SmartMenuExposeBlockModel;
import com.baidu.searchbox.smartmenu.model.SmartMenuResumePlayItemModel;
import com.baidu.searchbox.smartmenu.shield.SmartMenuShieldModel;
import com.baidu.searchbox.smartmenu.shield.SmartMenuShieldType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/smartmenu/strategy/SmartMenuDownloadBlockStrategyMgr;", "Lcom/baidu/searchbox/smartmenu/strategy/AbsSmartMenuShieldStrategyMgr;", "config", "Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardModel;", "(Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardModel;)V", "downloadLogKV", "Lcom/baidu/android/util/UniKV;", "blockModel", "Lcom/baidu/searchbox/smartmenu/model/SmartMenuExposeBlockModel;", "clearUserLogByUserConfig", "", "fetchDownloadItems", "", "Lcom/baidu/searchbox/downloadcenter/service/models/SmartMenuDownloadItem;", "fitSingleDownloadItemShowStrategy", "", "item", "getDownloadLog", "Lcom/baidu/searchbox/smartmenu/strategy/DownloadLogModel;", "getShieldType", "Lcom/baidu/searchbox/smartmenu/shield/SmartMenuShieldType;", "logUserClick", "downloadItem", "resumePlayItemModel", "Lcom/baidu/searchbox/smartmenu/model/SmartMenuResumePlayItemModel;", "logUserShow", "makeDownloadLogKey", "", "saveDownloadLog", "showDays", "", "Companion", "lib-smart-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuDownloadBlockStrategyMgr.kt */
public final class SmartMenuDownloadBlockStrategyMgr extends AbsSmartMenuShieldStrategyMgr {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile SmartMenuDownloadBlockStrategyMgr instance;
    private final UniKV downloadLogKV = new UniKV("SmartMenuDownloadLog");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartMenuDownloadBlockStrategyMgr(SmartMenuCardModel config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
        loadData();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/smartmenu/strategy/SmartMenuDownloadBlockStrategyMgr$Companion;", "", "()V", "instance", "Lcom/baidu/searchbox/smartmenu/strategy/SmartMenuDownloadBlockStrategyMgr;", "getInstance", "config", "Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardModel;", "lib-smart-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SmartMenuDownloadBlockStrategyMgr.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SmartMenuDownloadBlockStrategyMgr getInstance(SmartMenuCardModel config) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (SmartMenuDownloadBlockStrategyMgr.instance == null) {
                synchronized (this) {
                    if (SmartMenuDownloadBlockStrategyMgr.instance == null) {
                        Companion companion = SmartMenuDownloadBlockStrategyMgr.Companion;
                        SmartMenuDownloadBlockStrategyMgr.instance = new SmartMenuDownloadBlockStrategyMgr(config);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            SmartMenuDownloadBlockStrategyMgr access$getInstance$cp = SmartMenuDownloadBlockStrategyMgr.instance;
            Intrinsics.checkNotNull(access$getInstance$cp);
            return access$getInstance$cp;
        }
    }

    public SmartMenuExposeBlockModel blockModel() {
        if (!fitStrategy()) {
            return null;
        }
        loadShieldData();
        List downloadFileItemList = fetchDownloadItems();
        boolean z = false;
        if (downloadFileItemList != null && (!downloadFileItemList.isEmpty())) {
            z = true;
        }
        if (!z) {
            return null;
        }
        SmartMenuExposeBlockModel smartMenuExposeBlockModel = new SmartMenuExposeBlockModel();
        SmartMenuExposeBlockModel $this$blockModel_u24lambda_u2d0 = smartMenuExposeBlockModel;
        $this$blockModel_u24lambda_u2d0.setConfig(getBlockConfig());
        $this$blockModel_u24lambda_u2d0.setDownloadData(downloadFileItemList);
        return smartMenuExposeBlockModel;
    }

    public SmartMenuShieldType getShieldType() {
        return SmartMenuShieldType.DOWNLOAD;
    }

    public void logUserShow(SmartMenuDownloadItem downloadItem, SmartMenuResumePlayItemModel resumePlayItemModel) {
        if (downloadItem != null) {
            SmartMenuDownloadItem item = downloadItem;
            if (item.getId() != -1) {
                DownloadLogModel downloadLog = getDownloadLog(item);
                if (downloadLog == null) {
                    saveDownloadLog(item, 1);
                } else if (!DateTimeUtils.isSameDay(System.currentTimeMillis(), downloadLog.getLastShowTime())) {
                    saveDownloadLog(item, downloadLog.getShowDays() + 1);
                } else {
                    return;
                }
                saveData();
            }
        }
    }

    public void logUserClick(SmartMenuDownloadItem downloadItem, SmartMenuResumePlayItemModel resumePlayItemModel) {
        if (downloadItem != null) {
            SmartMenuDownloadItem item = downloadItem;
            if (item.getId() != -1) {
                this.downloadLogKV.remove(makeDownloadLogKey(item));
                saveData();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void clearUserLogByUserConfig() {
        super.clearUserLogByUserConfig();
        this.downloadLogKV.edit().clear().apply();
    }

    private final List<SmartMenuDownloadItem> fetchDownloadItems() {
        IDownloadCenterFun downloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
        if (downloadCenterFun == null) {
            return null;
        }
        SmartMenuCardInOutRulesModel inOutRestoreRules = getBlockConfig().getInOutRestoreRules();
        boolean z = false;
        int maxDay = inOutRestoreRules != null ? inOutRestoreRules.getInDownloadDays() : 0;
        if (maxDay == 0) {
            return null;
        }
        int shieldSize = getShieldNumber();
        List<SmartMenuDownloadItem> $this$sortedByDescending$iv = downloadCenterFun.getSmartMenuRecentDownloadList(maxDay, shieldSize + 12);
        if (AppConfig.isDebug()) {
            Log.d(AbsSmartMenuBlockStrategyMgrKt.STRATEGY_TAG, "type: " + getBlockConfig().getType() + " 获取到原始的下载内容数量：" + $this$sortedByDescending$iv.size());
        }
        Collection collection = $this$sortedByDescending$iv;
        if (collection == null || collection.isEmpty()) {
            z = true;
        }
        if (z) {
            return null;
        }
        List resultList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue($this$sortedByDescending$iv, "list");
        for (SmartMenuDownloadItem it : CollectionsKt.sortedWith($this$sortedByDescending$iv, new SmartMenuDownloadBlockStrategyMgr$fetchDownloadItems$$inlined$sortedByDescending$1())) {
            if (resultList.size() != shieldSize + 12) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (fitSingleDownloadItemShowStrategy(it) && !checkIsItemShield(SmartMenuShieldModel.Companion.createModelFromDownload(it), "")) {
                    resultList.add(it);
                }
            }
        }
        return resultList;
    }

    private final boolean fitSingleDownloadItemShowStrategy(SmartMenuDownloadItem item) {
        SmartMenuCardInOutRulesModel displayStrategy = getBlockConfig().getInOutRestoreRules();
        boolean isFit = false;
        if (displayStrategy == null || item.getId() == -1) {
            return false;
        }
        if ((item.getPath().length() == 0) || !new File(item.getPath()).exists()) {
            return false;
        }
        DownloadLogModel downloadLog = getDownloadLog(item);
        if (downloadLog == null) {
            return true;
        }
        if (downloadLog.getShowDays() <= displayStrategy.getOutShowDays()) {
            isFit = true;
        }
        if (AppConfig.isDebug()) {
            Log.d(AbsSmartMenuBlockStrategyMgrKt.STRATEGY_TAG, "type: " + getBlockConfig().getType() + " ID：" + item.getId() + " 触发退场");
        }
        return isFit;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        r8 = kotlin.text.StringsKt.toLongOrNull(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.smartmenu.strategy.DownloadLogModel getDownloadLog(com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem r18) {
        /*
            r17 = this;
            java.lang.String r1 = r17.makeDownloadLogKey(r18)
            r2 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00ea }
            r0 = r17
            com.baidu.searchbox.smartmenu.strategy.SmartMenuDownloadBlockStrategyMgr r0 = (com.baidu.searchbox.smartmenu.strategy.SmartMenuDownloadBlockStrategyMgr) r0     // Catch:{ all -> 0x00ea }
            r3 = 0
            com.baidu.android.util.UniKV r4 = r0.downloadLogKV     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = ""
            java.lang.String r4 = r4.getString(r1, r5)     // Catch:{ all -> 0x00ea }
            if (r4 != 0) goto L_0x0019
            r7 = r2
            goto L_0x00e5
        L_0x0019:
            java.lang.String r5 = "downloadLogKV.getString(…: return@runCatching null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x00ea }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x00ea }
            java.lang.String r6 = ","
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch:{ all -> 0x00ea }
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r5 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (java.lang.String[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ all -> 0x00ea }
            r6 = 0
            int r7 = r5.size()     // Catch:{ all -> 0x00ea }
            r8 = 3
            if (r7 == r8) goto L_0x003a
            r7 = r2
            goto L_0x00e5
        L_0x003a:
            com.baidu.searchbox.smartmenu.strategy.DownloadLogModel r7 = new com.baidu.searchbox.smartmenu.strategy.DownloadLogModel     // Catch:{ all -> 0x00ea }
            r8 = 0
            java.lang.Object r9 = kotlin.collections.CollectionsKt.getOrNull(r5, r8)     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00ea }
            if (r9 == 0) goto L_0x004f
            java.lang.Integer r9 = kotlin.text.StringsKt.toIntOrNull(r9)     // Catch:{ all -> 0x00ea }
            if (r9 == 0) goto L_0x004f
            int r8 = r9.intValue()     // Catch:{ all -> 0x00ea }
        L_0x004f:
            r10 = r8
            r8 = 1
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r5, r8)     // Catch:{ all -> 0x00ea }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00ea }
            r11 = 0
            if (r8 == 0) goto L_0x0067
            java.lang.Long r8 = kotlin.text.StringsKt.toLongOrNull(r8)     // Catch:{ all -> 0x00ea }
            if (r8 == 0) goto L_0x0067
            long r8 = r8.longValue()     // Catch:{ all -> 0x00ea }
            r13 = r8
            goto L_0x0068
        L_0x0067:
            r13 = r11
        L_0x0068:
            r8 = 2
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r5, r8)     // Catch:{ all -> 0x00ea }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00ea }
            if (r8 == 0) goto L_0x007d
            java.lang.Long r8 = kotlin.text.StringsKt.toLongOrNull(r8)     // Catch:{ all -> 0x00ea }
            if (r8 == 0) goto L_0x007d
            long r8 = r8.longValue()     // Catch:{ all -> 0x00ea }
            r15 = r8
            goto L_0x007e
        L_0x007d:
            r15 = r11
        L_0x007e:
            r9 = r7
            r11 = r13
            r13 = r15
            r9.<init>(r10, r11, r13)     // Catch:{ all -> 0x00ea }
            boolean r8 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x00ea }
            if (r8 == 0) goto L_0x00e3
            java.lang.String r8 = "SmartMenuStrategyMgr"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r9.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = "type: "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            com.baidu.searchbox.smartmenu.cloudconfig.model.SmartMenuCardModel r10 = r0.getBlockConfig()     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = r10.getType()     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = " ID："
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            long r10 = r18.getId()     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = " 展示天数："
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            int r10 = r7.getShowDays()     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = " 上次展现时间："
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            long r10 = r7.getLastShowTime()     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r10 = " 下载时间："
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            long r10 = r7.getDownloadTime()     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00ea }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r8, r9)     // Catch:{ all -> 0x00ea }
        L_0x00e3:
        L_0x00e5:
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r7)     // Catch:{ all -> 0x00ea }
            goto L_0x00f5
        L_0x00ea:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x00f5:
            boolean r3 = kotlin.Result.m8977isFailureimpl(r0)
            if (r3 == 0) goto L_0x00fc
            goto L_0x00fd
        L_0x00fc:
            r2 = r0
        L_0x00fd:
            com.baidu.searchbox.smartmenu.strategy.DownloadLogModel r2 = (com.baidu.searchbox.smartmenu.strategy.DownloadLogModel) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.smartmenu.strategy.SmartMenuDownloadBlockStrategyMgr.getDownloadLog(com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem):com.baidu.searchbox.smartmenu.strategy.DownloadLogModel");
    }

    private final void saveDownloadLog(SmartMenuDownloadItem item, int showDays) {
        this.downloadLogKV.putString(makeDownloadLogKey(item), new StringBuilder().append(showDays).append(AbstractJsonLexerKt.COMMA).append(System.currentTimeMillis()).append(AbstractJsonLexerKt.COMMA).append(item.getDownloadTime()).toString());
    }

    private final String makeDownloadLogKey(SmartMenuDownloadItem item) {
        return "file_log_" + item.getId();
    }
}
