package com.tera.scan.main.viewmodel;

import com.tera.scan.framework.BaseActivity;
import com.tera.scan.main.TeraScanApplication;
import fe.mmm.qw.qw.qw;
import fe.mmm.qw.th.qw.th.rg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WelcomeViewModel$showAgreementDialog$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ BaseActivity $activity;
    public final /* synthetic */ Function0<Unit> $clickOkListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WelcomeViewModel$showAgreementDialog$1(BaseActivity baseActivity, Function0<Unit> function0) {
        super(0);
        this.$activity = baseActivity;
        this.$clickOkListener = function0;
    }

    public final void invoke() {
        TeraScanApplication teraScanApplication = TeraScanApplication.netdiskApplication;
        if (teraScanApplication != null) {
            teraScanApplication.onUserAgreePrivacyAgreement();
        }
        rg.ad(this.$activity, true);
        qw.qw.when();
        this.$clickOkListener.invoke();
    }
}
