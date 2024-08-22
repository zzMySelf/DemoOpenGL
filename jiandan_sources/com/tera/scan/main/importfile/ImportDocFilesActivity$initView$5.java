package com.tera.scan.main.importfile;

import androidx.lifecycle.LiveData;
import fe.mmm.qw.xxx.uk.th;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImportDocFilesActivity$initView$5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ImportDocFilesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFilesActivity$initView$5(ImportDocFilesActivity importDocFilesActivity) {
        super(0);
        this.this$0 = importDocFilesActivity;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m818invoke$lambda0(ImportDocFilesActivity importDocFilesActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                importDocFilesActivity.showLoading();
            } else {
                importDocFilesActivity.hideLoading();
            }
        }
    }

    public final void invoke() {
        this.this$0.getDocViewModel$app_main_aiscanConfigRelease().loadAllDocFile();
        LiveData<Boolean> loadingLiveData = this.this$0.getDocViewModel$app_main_aiscanConfigRelease().getLoadingLiveData();
        ImportDocFilesActivity importDocFilesActivity = this.this$0;
        loadingLiveData.observe(importDocFilesActivity, new th(importDocFilesActivity));
    }
}
