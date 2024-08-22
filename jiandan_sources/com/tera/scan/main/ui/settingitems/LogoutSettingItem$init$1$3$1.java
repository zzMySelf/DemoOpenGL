package com.tera.scan.main.ui.settingitems;

import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import fe.mmm.qw.qw.qw;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LogoutSettingItem$init$1$3$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FragmentActivity $ac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogoutSettingItem$init$1$3$1(FragmentActivity fragmentActivity) {
        super(0);
        this.$ac = fragmentActivity;
    }

    public final void invoke() {
        de.ad("PCntrExSuc", "PCntr", (String) null, (Map) null, 12, (Object) null);
        qw qwVar = qw.qw;
        final FragmentActivity fragmentActivity = this.$ac;
        qwVar.m1001if(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    fragmentActivity.finish();
                } else {
                    o.rg(R.string.logout_failed);
                }
            }
        });
    }
}
