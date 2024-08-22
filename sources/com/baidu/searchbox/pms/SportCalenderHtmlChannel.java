package com.baidu.searchbox.pms;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/pms/SportCalenderHtmlChannel;", "Lcom/baidu/searchbox/pms/AbsSearchChannel;", "()V", "getPackageName", "", "notifyUpdate", "", "Companion", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportCalenderHtmlChannel.kt */
public final class SportCalenderHtmlChannel extends AbsSearchChannel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FILE_NAME = "olympic_calendar.html";
    public static final String PKG_NAME = "com.baidu.search.sport.calendar";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/pms/SportCalenderHtmlChannel$Companion;", "", "()V", "FILE_NAME", "", "PKG_NAME", "getFilePath", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SportCalenderHtmlChannel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getFilePath() {
            try {
                Result.Companion companion = Result.Companion;
                File file = new File(new File(AbsSearchChannel.mBaseDirPath, SportCalenderHtmlChannel.PKG_NAME), SportCalenderHtmlChannel.FILE_NAME);
                if (file.exists()) {
                    return file.getAbsolutePath();
                }
                Result.m8971constructorimpl(Unit.INSTANCE);
                return null;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getPackageName() {
        return PKG_NAME;
    }

    /* access modifiers changed from: protected */
    public void notifyUpdate() {
    }
}
