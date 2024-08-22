package com.tera.scan.app;

import android.content.Context;
import com.mars.kotlin.service.IHandlable;
import com.tera.scan.account.network.AccountService;
import com.tera.scan.app.lib.register.LibNetworkRegister;
import com.tera.scan.business.textrecognition.translate.AiTranslateTextService;
import com.tera.scan.framework.service.HandlableManager;
import com.tera.scan.main.TeraScanApplication;
import com.tera.scan.main.feedback.ScanFeedBackService;
import com.tera.scan.vip.network.VipService;
import fe.mmm.qw.a.yj.qw.de;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, d2 = {"Lcom/tera/scan/app/ShellApplication;", "Lcom/tera/scan/main/TeraScanApplication;", "()V", "onAttachContext", "", "onSyncInit", "app_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShellApplication extends TeraScanApplication {

    public static final class qw implements HandlableManager.IServiceInitializer {
        @NotNull
        public IHandlable<?>[] qw(@NotNull de deVar, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(deVar, "priorityScheduler");
            Intrinsics.checkNotNullParameter(context, "context");
            return new IHandlable[]{new ScanFeedBackService(deVar, context), new AiTranslateTextService(deVar, context), new AccountService(deVar, context), new VipService(deVar, context)};
        }
    }

    public void onAttachContext() {
        super.onAttachContext();
        FrameworkInitializerKt.qw(this);
        LibNetworkRegister.qw.th();
    }

    public void onSyncInit() {
        HandlableManager.fe(new qw());
        super.onSyncInit();
        fe.mmm.qw.fe.qw.qw(this);
        fe.mmm.qw.ggg.qw.qw.ad(this, fe.mmm.qw.i.qw.o());
    }
}
