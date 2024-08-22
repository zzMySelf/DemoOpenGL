package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.util.ArrayList;
import java.util.List;

public class FlutterEngineGroup {
    @VisibleForTesting
    public final List<FlutterEngine> activeEngines;

    public FlutterEngineGroup(@NonNull Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngine createAndRunDefaultEngine(@NonNull Context context) {
        return createAndRunEngine(context, (DartExecutor.DartEntrypoint) null);
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint) {
        return createAndRunEngine(context, dartEntrypoint, (String) null);
    }

    @VisibleForTesting
    public FlutterEngine createEngine(Context context) {
        return new FlutterEngine(context);
    }

    public FlutterEngineGroup(@NonNull Context context, @Nullable String[] strArr) {
        this.activeEngines = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (!flutterLoader.initialized()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context.getApplicationContext(), strArr);
        }
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint, @Nullable String str) {
        final FlutterEngine flutterEngine;
        if (dartEntrypoint == null) {
            dartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
        }
        if (this.activeEngines.size() == 0) {
            flutterEngine = createEngine(context);
            if (str != null) {
                flutterEngine.getNavigationChannel().setInitialRoute(str);
            }
            flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint);
        } else {
            flutterEngine = this.activeEngines.get(0).spawn(context, dartEntrypoint, str);
        }
        this.activeEngines.add(flutterEngine);
        flutterEngine.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() {
            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.activeEngines.remove(flutterEngine);
            }

            public void onPreEngineRestart() {
            }
        });
        return flutterEngine;
    }
}
