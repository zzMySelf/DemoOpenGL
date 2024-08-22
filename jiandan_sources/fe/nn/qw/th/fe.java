package fe.nn.qw.th;

import io.flutter.plugin.common.MethodChannel;

public class fe extends ad {

    /* renamed from: ad  reason: collision with root package name */
    public final MethodChannel.Result f8792ad;

    /* renamed from: de  reason: collision with root package name */
    public final Boolean f8793de;
    public final fe.nn.qw.fe qw;

    public fe(MethodChannel.Result result, fe.nn.qw.fe feVar, Boolean bool) {
        this.f8792ad = result;
        this.qw = feVar;
        this.f8793de = bool;
    }

    public Boolean ad() {
        return this.f8793de;
    }

    public fe.nn.qw.fe de() {
        return this.qw;
    }

    public void error(String str, String str2, Object obj) {
        this.f8792ad.error(str, str2, obj);
    }

    public <T> T qw(String str) {
        return null;
    }

    public void success(Object obj) {
        this.f8792ad.success(obj);
    }
}
