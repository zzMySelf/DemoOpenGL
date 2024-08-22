package com.mars.kotlin.service.extension;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Intent;
import com.mars.kotlin.extension.BundleScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/BundleScope;", "invoke", "com/mars/kotlin/service/extension/ContextKt$startService$result$1$jobInfo$1"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
public final class ContextKt$startService$$inlined$catch$lambda$1 extends Lambda implements Function1<BundleScope, Unit> {
    public final /* synthetic */ JobInfo.Builder $builder$inlined;
    public final /* synthetic */ Intent $intent$inlined;
    public final /* synthetic */ JobScheduler $jobScheduler$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextKt$startService$$inlined$catch$lambda$1(JobInfo.Builder builder, Intent intent, JobScheduler jobScheduler) {
        super(1);
        this.$builder$inlined = builder;
        this.$intent$inlined = intent;
        this.$jobScheduler$inlined = jobScheduler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BundleScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BundleScope bundleScope) {
        bundleScope.minus("", this.$intent$inlined);
    }
}
