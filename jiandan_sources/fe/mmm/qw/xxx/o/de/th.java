package fe.mmm.qw.xxx.o.de;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.p030switch.de.qw.de;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("initJobSchedulerRegister")
public final class th extends fe.mmm.qw.c.th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f8628yj;

    public static final class qw implements Function1<Intent, Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f8629ad;

        public qw(Context context) {
            this.f8629ad = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
        @org.jetbrains.annotations.NotNull
        /* renamed from: qw */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull android.content.Intent r9) {
            /*
                r8 = this;
                java.lang.String r0 = "intent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r0 = "JobSchedulerRegister invoke start"
                r1 = 0
                r2 = 1
                com.mars.kotlin.extension.LoggerKt.d$default(r0, r1, r2, r1)
                android.content.Context r0 = r8.f8629ad
                com.mars.kotlin.service.IHandlable[] r0 = com.tera.scan.framework.service.HandlableManager.ad(r0)     // Catch:{ all -> 0x004f }
                java.util.Set r3 = r9.getCategories()     // Catch:{ all -> 0x004f }
                if (r3 == 0) goto L_0x0049
                java.lang.String r4 = "categories"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x0049
                java.lang.String r4 = "serviceList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ all -> 0x004f }
                r4 = 0
                int r5 = r0.length     // Catch:{ all -> 0x004f }
            L_0x0026:
                if (r4 >= r5) goto L_0x0046
                r6 = r0[r4]     // Catch:{ all -> 0x004f }
                java.lang.Class r7 = r6.getClass()     // Catch:{ all -> 0x004f }
                java.lang.String r7 = r7.getSimpleName()     // Catch:{ all -> 0x004f }
                boolean r7 = r3.contains(r7)     // Catch:{ all -> 0x004f }
                if (r7 == 0) goto L_0x0043
                r6.onHandle(r9)     // Catch:{ all -> 0x004f }
                java.lang.String r0 = "JobSchedulerRegister HandlableManager 的Service处理 end"
                com.mars.kotlin.extension.LoggerKt.d$default(r0, r1, r2, r1)     // Catch:{ all -> 0x004f }
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x004f }
                return r9
            L_0x0043:
                int r4 = r4 + 1
                goto L_0x0026
            L_0x0046:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004f }
                goto L_0x004a
            L_0x0049:
                r0 = r1
            L_0x004a:
                com.mars.kotlin.extension.fp.Either$Right r0 = com.mars.kotlin.extension.ExpectKt.success(r0)     // Catch:{ all -> 0x004f }
                goto L_0x0057
            L_0x004f:
                r0 = move-exception
                com.mars.kotlin.extension.LoggerKt.e$default(r0, r1, r2, r1)
                com.mars.kotlin.extension.fp.Either$Left r0 = com.mars.kotlin.extension.ExpectKt.failure(r0)
            L_0x0057:
                boolean r3 = r0 instanceof com.mars.kotlin.extension.fp.Either.Left
                if (r3 == 0) goto L_0x006b
                com.mars.kotlin.extension.fp.Either$Left r0 = (com.mars.kotlin.extension.fp.Either.Left) r0
                java.lang.Object r9 = r0.getValue()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                java.lang.String r9 = "JobSchedulerRegister HandlableManager 的Service处理 failTransform end"
                com.mars.kotlin.extension.LoggerKt.d$default(r9, r1, r2, r1)
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                return r9
            L_0x006b:
                boolean r0 = r0 instanceof com.mars.kotlin.extension.fp.Either.Right
                if (r0 == 0) goto L_0x010d
                fe.mmm.qw.xxx.i.qw r0 = fe.mmm.qw.xxx.i.qw.ad()
                com.tera.scan.main.service.ServiceManager r0 = r0.de()
                if (r0 == 0) goto L_0x00ba
                android.content.Context r3 = r8.f8629ad
                com.tera.scan.framework.kernel.service.ISchedulerService r0 = r0.ad(r9)     // Catch:{ all -> 0x0093 }
                if (r0 == 0) goto L_0x008c
                r0.qw(r9, r3)     // Catch:{ all -> 0x0093 }
                java.lang.String r0 = "JobSchedulerRegister NetdiskBackgroundTaskManager Service处理 end"
                com.mars.kotlin.extension.LoggerKt.d$default(r0, r1, r2, r1)     // Catch:{ all -> 0x0093 }
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0093 }
                return r9
            L_0x008c:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0093 }
                com.mars.kotlin.extension.fp.Either$Right r0 = com.mars.kotlin.extension.ExpectKt.success(r0)     // Catch:{ all -> 0x0093 }
                goto L_0x009b
            L_0x0093:
                r0 = move-exception
                com.mars.kotlin.extension.LoggerKt.e$default(r0, r1, r2, r1)
                com.mars.kotlin.extension.fp.Either$Left r0 = com.mars.kotlin.extension.ExpectKt.failure(r0)
            L_0x009b:
                boolean r3 = r0 instanceof com.mars.kotlin.extension.fp.Either.Left
                if (r3 == 0) goto L_0x00af
                com.mars.kotlin.extension.fp.Either$Left r0 = (com.mars.kotlin.extension.fp.Either.Left) r0
                java.lang.Object r9 = r0.getValue()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                java.lang.String r9 = "JobSchedulerRegister NetdiskBackgroundTaskManager failTransform end"
                com.mars.kotlin.extension.LoggerKt.d$default(r9, r1, r2, r1)
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                return r9
            L_0x00af:
                boolean r0 = r0 instanceof com.mars.kotlin.extension.fp.Either.Right
                if (r0 == 0) goto L_0x00b4
                goto L_0x00ba
            L_0x00b4:
                kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                r9.<init>()
                throw r9
            L_0x00ba:
                fe.mmm.qw.xxx.i.qw r0 = fe.mmm.qw.xxx.i.qw.ad()
                fe.mmm.qw.switch.fe.qw.qw.ad r0 = r0.fe()
                if (r0 == 0) goto L_0x0105
                android.content.Context r3 = r8.f8629ad
                com.tera.scan.framework.kernel.service.ISchedulerService r0 = r0.qw(r9)     // Catch:{ all -> 0x00de }
                if (r0 == 0) goto L_0x00d7
                r0.qw(r9, r3)     // Catch:{ all -> 0x00de }
                java.lang.String r9 = "JobSchedulerRegister 通知组件的Service处理 invoke end"
                com.mars.kotlin.extension.LoggerKt.d$default(r9, r1, r2, r1)     // Catch:{ all -> 0x00de }
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00de }
                return r9
            L_0x00d7:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00de }
                com.mars.kotlin.extension.fp.Either$Right r9 = com.mars.kotlin.extension.ExpectKt.success(r9)     // Catch:{ all -> 0x00de }
                goto L_0x00e6
            L_0x00de:
                r9 = move-exception
                com.mars.kotlin.extension.LoggerKt.e$default(r9, r1, r2, r1)
                com.mars.kotlin.extension.fp.Either$Left r9 = com.mars.kotlin.extension.ExpectKt.failure(r9)
            L_0x00e6:
                boolean r0 = r9 instanceof com.mars.kotlin.extension.fp.Either.Left
                if (r0 == 0) goto L_0x00fa
                com.mars.kotlin.extension.fp.Either$Left r9 = (com.mars.kotlin.extension.fp.Either.Left) r9
                java.lang.Object r9 = r9.getValue()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                java.lang.String r9 = "JobSchedulerRegister 通知组件的Service处理 failTransform end"
                com.mars.kotlin.extension.LoggerKt.d$default(r9, r1, r2, r1)
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                return r9
            L_0x00fa:
                boolean r9 = r9 instanceof com.mars.kotlin.extension.fp.Either.Right
                if (r9 == 0) goto L_0x00ff
                goto L_0x0105
            L_0x00ff:
                kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                r9.<init>()
                throw r9
            L_0x0105:
                java.lang.String r9 = "JobSchedulerRegister invoke end"
                com.mars.kotlin.extension.LoggerKt.d$default(r9, r1, r2, r1)
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                return r9
            L_0x010d:
                kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                r9.<init>()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.xxx.o.de.th.qw.invoke(android.content.Intent):java.lang.Boolean");
        }
    }

    public th(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f8628yj = application;
    }

    public final void eee(Context context) {
        de.qw.yj(new qw(context));
    }

    public int i() {
        return 0;
    }

    @Nullable
    public String o() {
        return "JobSchedulerInitStartupTask";
    }

    public int uk() {
        return 0;
    }

    public void xxx() {
        eee(this.f8628yj);
    }

    @Nullable
    public List<Class<? extends fe.mmm.qw.c.th>> yj() {
        return null;
    }
}
