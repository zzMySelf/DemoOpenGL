package fe.de.qw.qw;

import androidx.annotation.RecentlyNonNull;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import i.qw.eee;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

public final class rg {

    public static final class ad implements PurchasesResponseListener {
        public final /* synthetic */ CompletableDeferred<when> qw;

        public ad(CompletableDeferred<when> completableDeferred) {
            this.qw = completableDeferred;
        }

        public final void qw(yj yjVar, List<Cif> list) {
            Intrinsics.checkNotNullExpressionValue(yjVar, "billingResult");
            Intrinsics.checkNotNullExpressionValue(list, "purchases");
            this.qw.ggg(new when(yjVar, list));
        }
    }

    public static final class qw implements ProductDetailsResponseListener {
        public final /* synthetic */ CompletableDeferred<pf> qw;

        public qw(CompletableDeferred<pf> completableDeferred) {
            this.qw = completableDeferred;
        }

        public final void qw(yj yjVar, List<o> list) {
            Intrinsics.checkNotNullExpressionValue(yjVar, "billingResult");
            this.qw.ggg(new pf(yjVar, list));
        }
    }

    @RecentlyNonNull
    @Nullable
    public static final Object ad(@RecentlyNonNull de deVar, @RecentlyNonNull ggg ggg, @RecentlyNonNull Continuation<? super when> continuation) {
        CompletableDeferred ad2 = eee.ad((Job) null, 1, (Object) null);
        deVar.th(ggg, new ad(ad2));
        return ad2.th(continuation);
    }

    @RecentlyNonNull
    @Nullable
    public static final Object qw(@RecentlyNonNull de deVar, @RecentlyNonNull ppp ppp, @RecentlyNonNull Continuation<? super pf> continuation) {
        CompletableDeferred ad2 = eee.ad((Job) null, 1, (Object) null);
        deVar.rg(ppp, new qw(ad2));
        return ad2.th(continuation);
    }
}
