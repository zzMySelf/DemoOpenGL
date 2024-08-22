package com.tera.scan.app;

import com.tera.scan.network.network.CookieAccount;
import fe.mmm.qw.qw.fe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/network/network/CookieAccount;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FrameworkInitializerKt$initFramework$4 extends Lambda implements Function0<CookieAccount> {
    public static final FrameworkInitializerKt$initFramework$4 INSTANCE = new FrameworkInitializerKt$initFramework$4();

    public static final class qw implements CookieAccount {
        @NotNull
        public String ad() {
            return fe.mmm.qw.qw.qw.qw.th();
        }

        @NotNull
        public String getBduss() {
            return fe.mmm.qw.qw.qw.qw.fe();
        }

        public void qw(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "bduss");
            new fe(str, z).ad();
        }
    }

    public FrameworkInitializerKt$initFramework$4() {
        super(0);
    }

    @NotNull
    public final CookieAccount invoke() {
        return new qw();
    }
}
