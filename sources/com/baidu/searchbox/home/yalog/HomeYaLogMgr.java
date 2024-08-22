package com.baidu.searchbox.home.yalog;

import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.log.core.dao.IntentExtra;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/home/yalog/HomeYaLogMgr;", "", "()V", "mYaLogs", "Ljava/util/HashMap;", "", "Lcom/baidu/searchbox/home/yalog/HomeBaseYaLog;", "Lkotlin/collections/HashMap;", "onForegroundToBackground", "", "setYaLog", "name", "logger", "lib-home-tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeYaLogMgr.kt */
public final class HomeYaLogMgr {
    public static final HomeYaLogMgr INSTANCE = new HomeYaLogMgr();
    private static final HashMap<String, HomeBaseYaLog> mYaLogs = new HashMap<>();

    private HomeYaLogMgr() {
    }

    static {
        BdBoxActivityManager.registerLifeCycle(new HomeYaLogLifecycle());
    }

    public final synchronized void setYaLog(String name, HomeBaseYaLog logger) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(logger, IntentExtra.SAVE_DIR);
        try {
            Result.Companion companion = Result.Companion;
            HomeYaLogMgr homeYaLogMgr = this;
            mYaLogs.put(name, logger);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        return;
    }

    /* access modifiers changed from: private */
    /* renamed from: onForegroundToBackground$lambda-3  reason: not valid java name */
    public static final void m20313onForegroundToBackground$lambda3() {
        HomeYaLogMgr homeYaLogMgr = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            for (Map.Entry element$iv : mYaLogs.entrySet()) {
                ((HomeBaseYaLog) element$iv.getValue()).flush();
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final synchronized void onForegroundToBackground() {
        ExecutorUtilsExt.postOnElastic(new HomeYaLogMgr$$ExternalSyntheticLambda0(), "HomeYaLogThread", 2);
    }
}
