package fe.de.qw.qw;

import com.android.billingclient.api.ProductDetailsResponseListener;
import java.util.concurrent.Callable;

public final /* synthetic */ class f0 implements Callable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ fe f1235ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ ppp f1236th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ ProductDetailsResponseListener f1237yj;

    public /* synthetic */ f0(fe feVar, ppp ppp, ProductDetailsResponseListener productDetailsResponseListener) {
        this.f1235ad = feVar;
        this.f1236th = ppp;
        this.f1237yj = productDetailsResponseListener;
    }

    public final Object call() {
        this.f1235ad.c(this.f1236th, this.f1237yj);
        return null;
    }
}
