package com.tera.scan.main.importfile;

import androidx.lifecycle.LifecycleOwner;
import fe.mmm.qw.qw.qw;
import fe.mmm.qw.xxx.uk.ggg.de;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\b\u0010\n\u001a\u00020\u0006H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\fH\u0000¨\u0006\r"}, d2 = {"ensureLogin", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isLogin", "shouldLoginWhenImportFiles", "onClearButtonClick", "Lcom/tera/scan/main/importfile/ImportDocFilesActivity;", "app-main_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImportDocFilesActivityKt {
    public static final void ad(@NotNull ImportDocFilesActivity importDocFilesActivity) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "<this>");
        Integer value = importDocFilesActivity.getDocViewModel$app_main_aiscanConfigRelease().getSelectedCountLiveData().getValue();
        if (value != null && value.intValue() == 0) {
            importDocFilesActivity.finish();
        } else {
            de.qw(importDocFilesActivity.getDocViewModel$app_main_aiscanConfigRelease());
        }
    }

    public static final boolean de() {
        return true;
    }

    public static final void qw(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(function1, "callback");
        if (qw.qw.pf()) {
            function1.invoke(Boolean.TRUE);
            return;
        }
        qw.xxx(qw.qw, lifecycleOwner, (String) null, true, new ImportDocFilesActivityKt$ensureLogin$1(function1), 2, (Object) null);
    }
}
