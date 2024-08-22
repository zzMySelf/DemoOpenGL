package com.tera.scan.app;

import com.tera.scan.framework.framework.FrameworkAccount;
import com.tera.scan.vip.VipInfoManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/framework/framework/FrameworkAccount;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FrameworkInitializerKt$initFramework$1 extends Lambda implements Function0<FrameworkAccount> {
    public static final FrameworkInitializerKt$initFramework$1 INSTANCE = new FrameworkInitializerKt$initFramework$1();

    public static final class qw implements FrameworkAccount {
        @NotNull
        public String getBduss() {
            return fe.mmm.qw.qw.qw.qw.fe();
        }

        @NotNull
        public String getUid() {
            return fe.mmm.qw.qw.qw.qw.yj();
        }

        public boolean isLogin() {
            return fe.mmm.qw.qw.qw.qw.pf();
        }

        public boolean qw() {
            return isLogin() && VipInfoManager.qw.yj();
        }
    }

    public FrameworkInitializerKt$initFramework$1() {
        super(0);
    }

    @NotNull
    public final FrameworkAccount invoke() {
        return new qw();
    }
}
