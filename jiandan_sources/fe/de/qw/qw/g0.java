package fe.de.qw.qw;

import com.android.billingclient.api.ProductDetailsResponseListener;
import java.util.ArrayList;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ProductDetailsResponseListener f1248ad;

    public /* synthetic */ g0(ProductDetailsResponseListener productDetailsResponseListener) {
        this.f1248ad = productDetailsResponseListener;
    }

    public final void run() {
        this.f1248ad.qw(l.f1259i, new ArrayList());
    }
}
