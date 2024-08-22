package fe.mmm.qw.p024if.fe;

import android.app.Application;
import com.alipay.sdk.m.p.e;
import com.google.common.net.MediaType;
import com.idlefish.flutterboost.FlutterBoost;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("BaseBackgroundChannel")
/* renamed from: fe.mmm.qw.if.fe.ad  reason: invalid package */
public abstract class ad implements FlutterPlugin {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public MethodChannel f7866ad;

    /* renamed from: th  reason: collision with root package name */
    public boolean f7867th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final List<qw> f7868yj = new ArrayList();

    public final void ad(Application application) {
        fe.mmm.qw.p024if.ad.ad(application);
        FlutterEngine rg2 = FlutterBoost.yj().rg();
        if (rg2 != null) {
            FlutterPlugin flutterPlugin = rg2.getPlugins().get(getClass());
            if (flutterPlugin != null) {
                ad adVar = flutterPlugin instanceof ad ? (ad) flutterPlugin : null;
                MethodChannel methodChannel = adVar != null ? adVar.f7866ad : null;
                this.f7866ad = methodChannel;
                this.f7867th = methodChannel != null;
            }
            LoggerKt.d$default("插件列表获取当前插件 " + getClass() + " 结果 = " + flutterPlugin + "，backgroundChannel 实例 = " + this.f7866ad, (Object) null, 1, (Object) null);
            if (this.f7866ad == null) {
                rg2.getPlugins().add((FlutterPlugin) this);
            }
        }
    }

    public final void de(@NotNull Application application, @NotNull String str, @NotNull Object obj, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        Intrinsics.checkNotNullParameter(str, e.s);
        Intrinsics.checkNotNullParameter(obj, "arguments");
        Intrinsics.checkNotNullParameter(result, "callback");
        ad(application);
        if (this.f7867th) {
            MethodChannel methodChannel = this.f7866ad;
            if (methodChannel != null) {
                methodChannel.invokeMethod(str, obj, result);
                return;
            }
            return;
        }
        this.f7868yj.add(new qw(str, obj, result));
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f7866ad = new MethodChannel(FlutterBoost.yj().rg().getDartExecutor(), qw());
        this.f7867th = true;
        for (qw next : this.f7868yj) {
            MethodChannel methodChannel = this.f7866ad;
            if (methodChannel != null) {
                methodChannel.invokeMethod(next.qw, next.f7870ad, next.f7871de);
            }
        }
        this.f7868yj.clear();
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f7866ad = null;
        this.f7867th = false;
    }

    @NotNull
    public abstract String qw();
}
