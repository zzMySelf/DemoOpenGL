package fe.ggg.ad.ad.qw;

import com.android.billingclient.api.ConsumeResponseListener;
import com.mars.united.international.pay.GooglePay$consume$1;
import fe.de.qw.qw.yj;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: lambda */
public final /* synthetic */ class ad implements ConsumeResponseListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ List f7566ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ String f7567de;

    /* renamed from: fe  reason: collision with root package name */
    public final /* synthetic */ Function1 f7568fe;
    public final /* synthetic */ Ref.IntRef qw;

    public /* synthetic */ ad(Ref.IntRef intRef, List list, String str, Function1 function1) {
        this.qw = intRef;
        this.f7566ad = list;
        this.f7567de = str;
        this.f7568fe = function1;
    }

    public final void th(yj yjVar, String str) {
        GooglePay$consume$1.m709invoke$lambda1$lambda0(this.qw, this.f7566ad, this.f7567de, this.f7568fe, yjVar, str);
    }
}
