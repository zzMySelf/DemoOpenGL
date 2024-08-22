package fe.de.qw.qw;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.zzbe;
import com.android.billingclient.api.zzc;

public abstract class de {

    @AnyThread
    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final Context f1231ad;

        /* renamed from: de  reason: collision with root package name */
        public volatile PurchasesUpdatedListener f1232de;
        public volatile boolean qw;

        public /* synthetic */ qw(Context context, e0 e0Var) {
            this.f1231ad = context;
        }

        @NonNull
        public qw ad() {
            this.qw = true;
            return this;
        }

        @NonNull
        public qw de(@NonNull PurchasesUpdatedListener purchasesUpdatedListener) {
            this.f1232de = purchasesUpdatedListener;
            return this;
        }

        @NonNull
        public de qw() {
            if (this.f1231ad == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            } else if (this.f1232de != null) {
                PurchasesUpdatedListener purchasesUpdatedListener = this.f1232de;
                if (this.qw) {
                    PurchasesUpdatedListener purchasesUpdatedListener2 = this.f1232de;
                    if (this.f1232de != null) {
                        return new fe((String) null, this.qw, this.f1231ad, this.f1232de, (zzc) null);
                    }
                    return new fe((String) null, this.qw, this.f1231ad, (zzbe) null);
                }
                throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
            } else {
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
        }
    }

    @NonNull
    @AnyThread
    public static qw fe(@NonNull Context context) {
        return new qw(context, (e0) null);
    }

    @AnyThread
    public abstract boolean ad();

    @UiThread
    @NonNull
    public abstract yj de(@NonNull Activity activity, @NonNull th thVar);

    @AnyThread
    public abstract void qw(@NonNull uk ukVar, @NonNull ConsumeResponseListener consumeResponseListener);

    @AnyThread
    public abstract void rg(@NonNull ppp ppp, @NonNull ProductDetailsResponseListener productDetailsResponseListener);

    @AnyThread
    public abstract void th(@NonNull ggg ggg, @NonNull PurchasesResponseListener purchasesResponseListener);

    @AnyThread
    public abstract void yj(@NonNull BillingClientStateListener billingClientStateListener);
}
