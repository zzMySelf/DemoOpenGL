package fe.fe.mmm;

import com.baidu.ubc.UBCApiCollector;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ UBCApiCollector f2088ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f2089th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ UBCApiCollector.ApiType f2090uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ int f2091yj;

    public /* synthetic */ qw(UBCApiCollector uBCApiCollector, String str, int i2, UBCApiCollector.ApiType apiType) {
        this.f2088ad = uBCApiCollector;
        this.f2089th = str;
        this.f2091yj = i2;
        this.f2090uk = apiType;
    }

    public final void run() {
        this.f2088ad.fe(this.f2089th, this.f2091yj, this.f2090uk);
    }
}
