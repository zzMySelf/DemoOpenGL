package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeferredComponentChannel {
    public static final String TAG = "DeferredComponentChannel";
    @NonNull
    public final MethodChannel channel;
    @NonNull
    public Map<String, List<MethodChannel.Result>> componentNameToResults;
    @Nullable
    public DeferredComponentManager deferredComponentManager;
    @VisibleForTesting
    @NonNull
    public final MethodChannel.MethodCallHandler parsingMethodHandler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (DeferredComponentChannel.this.deferredComponentManager != null) {
                String str = methodCall.method;
                Map map = (Map) methodCall.arguments();
                Log.v(DeferredComponentChannel.TAG, "Received '" + str + "' message.");
                int intValue = ((Integer) map.get("loadingUnitId")).intValue();
                String str2 = (String) map.get("componentName");
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1004447972) {
                    if (hashCode != 399701758) {
                        if (hashCode == 520962947 && str.equals("installDeferredComponent")) {
                            c = 0;
                        }
                    } else if (str.equals("getDeferredComponentInstallState")) {
                        c = 1;
                    }
                } else if (str.equals("uninstallDeferredComponent")) {
                    c = 2;
                }
                if (c == 0) {
                    DeferredComponentChannel.this.deferredComponentManager.installDeferredComponent(intValue, str2);
                    if (!DeferredComponentChannel.this.componentNameToResults.containsKey(str2)) {
                        DeferredComponentChannel.this.componentNameToResults.put(str2, new ArrayList());
                    }
                    ((List) DeferredComponentChannel.this.componentNameToResults.get(str2)).add(result);
                } else if (c == 1) {
                    result.success(DeferredComponentChannel.this.deferredComponentManager.getDeferredComponentInstallState(intValue, str2));
                } else if (c != 2) {
                    result.notImplemented();
                } else {
                    DeferredComponentChannel.this.deferredComponentManager.uninstallDeferredComponent(intValue, str2);
                    result.success((Object) null);
                }
            }
        }
    };

    public DeferredComponentChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodHandler);
        this.deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.componentNameToResults = new HashMap();
    }

    public void completeInstallError(String str, String str2) {
        if (this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result error : this.componentNameToResults.get(str)) {
                error.error("DeferredComponent Install failure", str2, (Object) null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    public void completeInstallSuccess(String str) {
        if (this.componentNameToResults.containsKey(str)) {
            for (MethodChannel.Result success : this.componentNameToResults.get(str)) {
                success.success((Object) null);
            }
            this.componentNameToResults.get(str).clear();
        }
    }

    @VisibleForTesting
    public void setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager2) {
        this.deferredComponentManager = deferredComponentManager2;
    }
}
