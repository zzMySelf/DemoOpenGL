package fe.mmm.qw.xxx.when;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.component.base.ui.manager.DialogCtrListener;
import com.tera.scan.main.MainActivity;
import fe.mmm.qw.ggg.ad.yj.ad;
import fe.mmm.qw.th.qw.rg.de.fe;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("AccountErrorHandler")
public final class qw {
    @NotNull
    public static final qw qw = new qw();

    /* renamed from: fe.mmm.qw.xxx.when.qw$qw  reason: collision with other inner class name */
    public static final class C0300qw implements DialogCtrListener {
        public void ad() {
        }

        public void qw() {
            LoggerKt.d$default("账号登录失效，退出登录态", (Object) null, 1, (Object) null);
            fe.mmm.qw.qw.qw.m1000switch(fe.mmm.qw.qw.qw.qw, (Function1) null, 1, (Object) null);
            String name = MainActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "MainActivity::class.java.name");
            ad.th(name);
        }
    }

    public final void qw(int i2) {
        if (!fe.mmm.qw.qw.qw.qw.pf()) {
            LoggerKt.d$default("账号未登录，不处理", (Object) null, 1, (Object) null);
            return;
        }
        String name = MainActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "MainActivity::class.java.name");
        if (!ad.i(name)) {
            LoggerKt.d$default("还没进入MainActivity，不处理", (Object) null, 1, (Object) null);
            return;
        }
        FragmentActivity uk2 = ad.uk();
        if (uk2 != null) {
            try {
                fe feVar = new fe();
                Dialog yj2 = feVar.yj(uk2, "", uk2.getString(R.string.dialog_account_login_invalid_title), uk2.getString(R.string.confirm_exit));
                feVar.de(new C0300qw());
                feVar.ad(false);
                yj2.show();
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                if (!Logger.INSTANCE.getEnable()) {
                    ExpectKt.failure(th2);
                    return;
                }
                throw th2;
            }
        }
    }
}
