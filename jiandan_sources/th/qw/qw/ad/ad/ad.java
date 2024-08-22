package th.qw.qw.ad.ad;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.nio.ByteBuffer;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ DartMessenger f11063ad;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11064i;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f11065o;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f11066th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f11067uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.HandlerInfo f11068yj;

    public /* synthetic */ ad(DartMessenger dartMessenger, String str, DartMessenger.HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i2, long j) {
        this.f11063ad = dartMessenger;
        this.f11066th = str;
        this.f11068yj = handlerInfo;
        this.f11067uk = byteBuffer;
        this.f11064i = i2;
        this.f11065o = j;
    }

    public final void run() {
        this.f11063ad.qw(this.f11066th, this.f11068yj, this.f11067uk, this.f11064i, this.f11065o);
    }
}
