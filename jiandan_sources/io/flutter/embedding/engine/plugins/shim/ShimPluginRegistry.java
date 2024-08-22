package io.flutter.embedding.engine.plugins.shim;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShimPluginRegistry implements PluginRegistry {
    public static final String TAG = "ShimPluginRegistry";
    public final FlutterEngine flutterEngine;
    public final Map<String, Object> pluginMap = new HashMap();
    public final ShimRegistrarAggregate shimRegistrarAggregate;

    public static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        public ActivityPluginBinding activityPluginBinding;
        public FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        public final Set<ShimRegistrar> shimRegistrars;

        public ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(@NonNull ShimRegistrar shimRegistrar) {
            this.shimRegistrars.add(shimRegistrar);
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.flutterPluginBinding;
            if (flutterPluginBinding2 != null) {
                shimRegistrar.onAttachedToEngine(flutterPluginBinding2);
            }
            ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
            if (activityPluginBinding2 != null) {
                shimRegistrar.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (ShimRegistrar onAttachedToActivity : this.shimRegistrars) {
                onAttachedToActivity.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            this.flutterPluginBinding = flutterPluginBinding2;
            for (ShimRegistrar onAttachedToEngine : this.shimRegistrars) {
                onAttachedToEngine.onAttachedToEngine(flutterPluginBinding2);
            }
        }

        public void onDetachedFromActivity() {
            for (ShimRegistrar onDetachedFromActivity : this.shimRegistrars) {
                onDetachedFromActivity.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        public void onDetachedFromActivityForConfigChanges() {
            for (ShimRegistrar onDetachedFromActivity : this.shimRegistrars) {
                onDetachedFromActivity.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            for (ShimRegistrar onDetachedFromEngine : this.shimRegistrars) {
                onDetachedFromEngine.onDetachedFromEngine(flutterPluginBinding2);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (ShimRegistrar onReattachedToActivityForConfigChanges : this.shimRegistrars) {
                onReattachedToActivityForConfigChanges.onReattachedToActivityForConfigChanges(activityPluginBinding2);
            }
        }
    }

    public ShimPluginRegistry(@NonNull FlutterEngine flutterEngine2) {
        this.flutterEngine = flutterEngine2;
        this.shimRegistrarAggregate = new ShimRegistrarAggregate();
        this.flutterEngine.getPlugins().add((FlutterPlugin) this.shimRegistrarAggregate);
    }

    public boolean hasPlugin(String str) {
        return this.pluginMap.containsKey(str);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        Log.v(TAG, "Creating plugin Registrar for '" + str + "'");
        if (!this.pluginMap.containsKey(str)) {
            this.pluginMap.put(str, (Object) null);
            ShimRegistrar shimRegistrar = new ShimRegistrar(str, this.pluginMap);
            this.shimRegistrarAggregate.addPlugin(shimRegistrar);
            return shimRegistrar;
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.pluginMap.get(str);
    }
}
