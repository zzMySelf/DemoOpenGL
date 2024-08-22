package fe.mmm.qw.th.qw;

import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.framework.framework.FrameworkAccount;
import fe.mmm.qw.th.qw.de.qw;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@JvmName(name = "NetdiskCommonConfigFlavor")
public final class ad {
    public static final void ad(Ref.ObjectRef objectRef, FrameworkAccount frameworkAccount) {
        Intrinsics.checkNotNullParameter(objectRef, "$uid");
        boolean z = false;
        if ((((CharSequence) objectRef.element).length() == 0) && frameworkAccount != null) {
            if (frameworkAccount.getUid().length() > 0) {
                LoggerKt.d$default("observerAccountInfoChange 账号切换(未登录 -> 登录): uid(" + ((String) objectRef.element) + ") -> uid(" + frameworkAccount.getUid() + ')', (Object) null, 1, (Object) null);
                objectRef.element = frameworkAccount.getUid();
                new qw().th(fe.mmm.qw.de.ad.qw.qw.ad());
                return;
            }
        }
        if (frameworkAccount != null) {
            if (!(frameworkAccount.getUid().length() == 0)) {
                return;
            }
        }
        if (((CharSequence) objectRef.element).length() > 0) {
            z = true;
        }
        if (z) {
            objectRef.element = "";
            LoggerKt.d$default("observerAccountInfoChange 账号切换(登录 -> 未登录): uid(" + ((String) objectRef.element) + ") -> uid(\"\")", (Object) null, 1, (Object) null);
            new qw().th(fe.mmm.qw.de.ad.qw.qw.ad());
        }
    }

    public static final void qw() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = fe.mmm.qw.p030switch.rg.qw.qw().getUid();
        LoggerKt.d$default("observerAccountInfoChange 当前 uid = " + ((String) objectRef.element), (Object) null, 1, (Object) null);
        fe.mmm.qw.p030switch.rg.qw.ad().observeForever(new qw(objectRef));
    }
}
