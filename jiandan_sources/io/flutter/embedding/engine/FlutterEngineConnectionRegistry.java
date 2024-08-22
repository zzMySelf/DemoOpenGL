package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.tracing.Trace;
import com.baidu.android.common.others.IStringUtil;
import io.flutter.Log;
import io.flutter.embedding.android.ExclusiveAppComponent;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FlutterEngineConnectionRegistry implements PluginRegistry, ActivityControlSurface, ServiceControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface {
    public static final String TAG = "FlutterEngineCxnRegstry";
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins = new HashMap();
    @Nullable
    public FlutterEngineActivityPluginBinding activityPluginBinding;
    @Nullable
    public BroadcastReceiver broadcastReceiver;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins = new HashMap();
    @Nullable
    public FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
    @Nullable
    public ContentProvider contentProvider;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins = new HashMap();
    @Nullable
    public FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
    @Nullable
    public ExclusiveAppComponent<Activity> exclusiveActivity;
    @NonNull
    public final FlutterEngine flutterEngine;
    public boolean isWaitingForActivityReattachment = false;
    @NonNull
    public final FlutterPlugin.FlutterPluginBinding pluginBinding;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins = new HashMap();
    @Nullable
    public Service service;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins = new HashMap();
    @Nullable
    public FlutterEngineServicePluginBinding servicePluginBinding;

    public static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {
        public final FlutterLoader flutterLoader;

        public String getAssetFilePathByName(@NonNull String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        public String getAssetFilePathBySubpath(@NonNull String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        public DefaultFlutterAssets(@NonNull FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
        }

        public String getAssetFilePathByName(@NonNull String str, @NonNull String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }

        public String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }
    }

    public static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        @NonNull
        public final Activity activity;
        @NonNull
        public final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        public final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
        @NonNull
        public final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
        @NonNull
        public final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
        @NonNull
        public final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();
        @NonNull
        public final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();

        public FlutterEngineActivityPluginBinding(@NonNull Activity activity2, @NonNull Lifecycle lifecycle) {
            this.activity = activity2;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        public void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.add(activityResultListener);
        }

        public void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.add(newIntentListener);
        }

        public void addOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.add(onSaveInstanceStateListener);
        }

        public void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.add(userLeaveHintListener);
        }

        public void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.add(requestPermissionsResultListener);
        }

        @NonNull
        public Activity getActivity() {
            return this.activity;
        }

        @NonNull
        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
            Iterator it = new HashSet(this.onActivityResultListeners).iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z;
                    }
                    if (((PluginRegistry.ActivityResultListener) it.next()).onActivityResult(i2, i3, intent) || z) {
                        z = true;
                    }
                }
            }
        }

        public void onNewIntent(@Nullable Intent intent) {
            for (PluginRegistry.NewIntentListener onNewIntent : this.onNewIntentListeners) {
                onNewIntent.onNewIntent(intent);
            }
        }

        public boolean onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            Iterator<PluginRegistry.RequestPermissionsResultListener> it = this.onRequestPermissionsResultListeners.iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z;
                    }
                    if (it.next().onRequestPermissionsResult(i2, strArr, iArr) || z) {
                        z = true;
                    }
                }
            }
        }

        public void onRestoreInstanceState(@Nullable Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onRestoreInstanceState : this.onSaveInstanceStateListeners) {
                onRestoreInstanceState.onRestoreInstanceState(bundle);
            }
        }

        public void onSaveInstanceState(@NonNull Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceState : this.onSaveInstanceStateListeners) {
                onSaveInstanceState.onSaveInstanceState(bundle);
            }
        }

        public void onUserLeaveHint() {
            for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.onUserLeaveHintListeners) {
                onUserLeaveHint.onUserLeaveHint();
            }
        }

        public void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.remove(activityResultListener);
        }

        public void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.remove(newIntentListener);
        }

        public void removeOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.remove(onSaveInstanceStateListener);
        }

        public void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.remove(userLeaveHintListener);
        }

        public void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.remove(requestPermissionsResultListener);
        }
    }

    public static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        @NonNull
        public final BroadcastReceiver broadcastReceiver;

        public FlutterEngineBroadcastReceiverPluginBinding(@NonNull BroadcastReceiver broadcastReceiver2) {
            this.broadcastReceiver = broadcastReceiver2;
        }

        @NonNull
        public BroadcastReceiver getBroadcastReceiver() {
            return this.broadcastReceiver;
        }
    }

    public static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        @NonNull
        public final ContentProvider contentProvider;

        public FlutterEngineContentProviderPluginBinding(@NonNull ContentProvider contentProvider2) {
            this.contentProvider = contentProvider2;
        }

        @NonNull
        public ContentProvider getContentProvider() {
            return this.contentProvider;
        }
    }

    public static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        @Nullable
        public final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        public final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
        @NonNull
        public final Service service;

        public FlutterEngineServicePluginBinding(@NonNull Service service2, @Nullable Lifecycle lifecycle) {
            this.service = service2;
            this.hiddenLifecycleReference = lifecycle != null ? new HiddenLifecycleReference(lifecycle) : null;
        }

        public void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.add(onModeChangeListener);
        }

        @Nullable
        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        @NonNull
        public Service getService() {
            return this.service;
        }

        public void onMoveToBackground() {
            for (ServiceAware.OnModeChangeListener onMoveToBackground : this.onModeChangeListeners) {
                onMoveToBackground.onMoveToBackground();
            }
        }

        public void onMoveToForeground() {
            for (ServiceAware.OnModeChangeListener onMoveToForeground : this.onModeChangeListeners) {
                onMoveToForeground.onMoveToForeground();
            }
        }

        public void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.remove(onModeChangeListener);
        }
    }

    public FlutterEngineConnectionRegistry(@NonNull Context context, @NonNull FlutterEngine flutterEngine2, @NonNull FlutterLoader flutterLoader) {
        this.flutterEngine = flutterEngine2;
        this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(context, flutterEngine2, flutterEngine2.getDartExecutor(), flutterEngine2.getRenderer(), flutterEngine2.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader));
    }

    private void attachToActivityInternal(@NonNull Activity activity, @NonNull Lifecycle lifecycle) {
        this.activityPluginBinding = new FlutterEngineActivityPluginBinding(activity, lifecycle);
        this.flutterEngine.getPlatformViewsController().attach(activity, this.flutterEngine.getRenderer(), this.flutterEngine.getDartExecutor());
        for (ActivityAware next : this.activityAwarePlugins.values()) {
            if (this.isWaitingForActivityReattachment) {
                next.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
            } else {
                next.onAttachedToActivity(this.activityPluginBinding);
            }
        }
        this.isWaitingForActivityReattachment = false;
    }

    private Activity attachedActivity() {
        ExclusiveAppComponent<Activity> exclusiveAppComponent = this.exclusiveActivity;
        if (exclusiveAppComponent != null) {
            return exclusiveAppComponent.getAppComponent();
        }
        return null;
    }

    private void detachFromActivityInternal() {
        this.flutterEngine.getPlatformViewsController().detach();
        this.exclusiveActivity = null;
        this.activityPluginBinding = null;
    }

    private void detachFromAppComponent() {
        if (isAttachedToActivity()) {
            detachFromActivity();
        } else if (isAttachedToService()) {
            detachFromService();
        } else if (isAttachedToBroadcastReceiver()) {
            detachFromBroadcastReceiver();
        } else if (isAttachedToContentProvider()) {
            detachFromContentProvider();
        }
    }

    private boolean isAttachedToActivity() {
        return this.exclusiveActivity != null;
    }

    private boolean isAttachedToBroadcastReceiver() {
        return this.broadcastReceiver != null;
    }

    private boolean isAttachedToContentProvider() {
        return this.contentProvider != null;
    }

    private boolean isAttachedToService() {
        return this.service != null;
    }

    public void add(@NonNull FlutterPlugin flutterPlugin) {
        Trace.beginSection("FlutterEngineConnectionRegistry#add " + flutterPlugin.getClass().getSimpleName());
        try {
            if (has(flutterPlugin.getClass())) {
                Log.w(TAG, "Attempted to register plugin (" + flutterPlugin + ") but it was already registered with this FlutterEngine (" + this.flutterEngine + ").");
                return;
            }
            Log.v(TAG, "Adding plugin: " + flutterPlugin);
            this.plugins.put(flutterPlugin.getClass(), flutterPlugin);
            flutterPlugin.onAttachedToEngine(this.pluginBinding);
            if (flutterPlugin instanceof ActivityAware) {
                ActivityAware activityAware = (ActivityAware) flutterPlugin;
                this.activityAwarePlugins.put(flutterPlugin.getClass(), activityAware);
                if (isAttachedToActivity()) {
                    activityAware.onAttachedToActivity(this.activityPluginBinding);
                }
            }
            if (flutterPlugin instanceof ServiceAware) {
                ServiceAware serviceAware = (ServiceAware) flutterPlugin;
                this.serviceAwarePlugins.put(flutterPlugin.getClass(), serviceAware);
                if (isAttachedToService()) {
                    serviceAware.onAttachedToService(this.servicePluginBinding);
                }
            }
            if (flutterPlugin instanceof BroadcastReceiverAware) {
                BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) flutterPlugin;
                this.broadcastReceiverAwarePlugins.put(flutterPlugin.getClass(), broadcastReceiverAware);
                if (isAttachedToBroadcastReceiver()) {
                    broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
                }
            }
            if (flutterPlugin instanceof ContentProviderAware) {
                ContentProviderAware contentProviderAware = (ContentProviderAware) flutterPlugin;
                this.contentProviderAwarePlugins.put(flutterPlugin.getClass(), contentProviderAware);
                if (isAttachedToContentProvider()) {
                    contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
                }
            }
            Trace.endSection();
        } finally {
            Trace.endSection();
        }
    }

    public void attachToActivity(@NonNull ExclusiveAppComponent<Activity> exclusiveAppComponent, @NonNull Lifecycle lifecycle) {
        String str;
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Attaching to an exclusive Activity: ");
            sb.append(exclusiveAppComponent.getAppComponent());
            String str2 = "";
            if (isAttachedToActivity()) {
                str = " evicting previous activity " + attachedActivity();
            } else {
                str = str2;
            }
            sb.append(str);
            sb.append(IStringUtil.CURRENT_PATH);
            if (this.isWaitingForActivityReattachment) {
                str2 = " This is after a config change.";
            }
            sb.append(str2);
            Log.v(TAG, sb.toString());
            if (this.exclusiveActivity != null) {
                this.exclusiveActivity.detachFromFlutterEngine();
            }
            detachFromAppComponent();
            this.exclusiveActivity = exclusiveAppComponent;
            attachToActivityInternal(exclusiveAppComponent.getAppComponent(), lifecycle);
        } finally {
            Trace.endSection();
        }
    }

    public void attachToBroadcastReceiver(@NonNull BroadcastReceiver broadcastReceiver2, @NonNull Lifecycle lifecycle) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToBroadcastReceiver");
        Log.v(TAG, "Attaching to BroadcastReceiver: " + broadcastReceiver2);
        try {
            detachFromAppComponent();
            this.broadcastReceiver = broadcastReceiver2;
            this.broadcastReceiverPluginBinding = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver2);
            for (BroadcastReceiverAware onAttachedToBroadcastReceiver : this.broadcastReceiverAwarePlugins.values()) {
                onAttachedToBroadcastReceiver.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void attachToContentProvider(@NonNull ContentProvider contentProvider2, @NonNull Lifecycle lifecycle) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToContentProvider");
        Log.v(TAG, "Attaching to ContentProvider: " + contentProvider2);
        try {
            detachFromAppComponent();
            this.contentProvider = contentProvider2;
            this.contentProviderPluginBinding = new FlutterEngineContentProviderPluginBinding(contentProvider2);
            for (ContentProviderAware onAttachedToContentProvider : this.contentProviderAwarePlugins.values()) {
                onAttachedToContentProvider.onAttachedToContentProvider(this.contentProviderPluginBinding);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void attachToService(@NonNull Service service2, @Nullable Lifecycle lifecycle, boolean z) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToService");
        Log.v(TAG, "Attaching to a Service: " + service2);
        try {
            detachFromAppComponent();
            this.service = service2;
            this.servicePluginBinding = new FlutterEngineServicePluginBinding(service2, lifecycle);
            for (ServiceAware onAttachedToService : this.serviceAwarePlugins.values()) {
                onAttachedToService.onAttachedToService(this.servicePluginBinding);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        detachFromAppComponent();
        removeAll();
    }

    public void detachFromActivity() {
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromActivity");
            try {
                Log.v(TAG, "Detaching from an Activity: " + attachedActivity());
                for (ActivityAware onDetachedFromActivity : this.activityAwarePlugins.values()) {
                    onDetachedFromActivity.onDetachedFromActivity();
                }
                detachFromActivityInternal();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    public void detachFromActivityForConfigChanges() {
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
            Log.v(TAG, "Detaching from an Activity for config changes: " + attachedActivity());
            try {
                this.isWaitingForActivityReattachment = true;
                for (ActivityAware onDetachedFromActivityForConfigChanges : this.activityAwarePlugins.values()) {
                    onDetachedFromActivityForConfigChanges.onDetachedFromActivityForConfigChanges();
                }
                detachFromActivityInternal();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    public void detachFromBroadcastReceiver() {
        if (isAttachedToBroadcastReceiver()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
            Log.v(TAG, "Detaching from BroadcastReceiver: " + this.broadcastReceiver);
            try {
                for (BroadcastReceiverAware onDetachedFromBroadcastReceiver : this.broadcastReceiverAwarePlugins.values()) {
                    onDetachedFromBroadcastReceiver.onDetachedFromBroadcastReceiver();
                }
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
        }
    }

    public void detachFromContentProvider() {
        if (isAttachedToContentProvider()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromContentProvider");
            Log.v(TAG, "Detaching from ContentProvider: " + this.contentProvider);
            try {
                for (ContentProviderAware onDetachedFromContentProvider : this.contentProviderAwarePlugins.values()) {
                    onDetachedFromContentProvider.onDetachedFromContentProvider();
                }
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
        }
    }

    public void detachFromService() {
        if (isAttachedToService()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromService");
            Log.v(TAG, "Detaching from a Service: " + this.service);
            try {
                for (ServiceAware onDetachedFromService : this.serviceAwarePlugins.values()) {
                    onDetachedFromService.onDetachedFromService();
                }
                this.service = null;
                this.servicePluginBinding = null;
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to detach plugins from a Service when no Service was attached.");
        }
    }

    public FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> cls) {
        return this.plugins.get(cls);
    }

    public boolean has(@NonNull Class<? extends FlutterPlugin> cls) {
        return this.plugins.containsKey(cls);
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Log.v(TAG, "Forwarding onActivityResult() to plugins.");
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                return this.activityPluginBinding.onActivityResult(i2, i3, intent);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
    }

    public void onMoveToBackground() {
        if (isAttachedToService()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onMoveToBackground");
            Log.v(TAG, "Attached Service moved to background.");
            try {
                this.servicePluginBinding.onMoveToBackground();
            } finally {
                Trace.endSection();
            }
        }
    }

    public void onMoveToForeground() {
        if (isAttachedToService()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onMoveToForeground");
            try {
                Log.v(TAG, "Attached Service moved to foreground.");
                this.servicePluginBinding.onMoveToForeground();
            } finally {
                Trace.endSection();
            }
        }
    }

    public void onNewIntent(@NonNull Intent intent) {
        Log.v(TAG, "Forwarding onNewIntent() to plugins.");
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onNewIntent");
            try {
                this.activityPluginBinding.onNewIntent(intent);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    public boolean onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Log.v(TAG, "Forwarding onRequestPermissionsResult() to plugins.");
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                return this.activityPluginBinding.onRequestPermissionsResult(i2, strArr, iArr);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
    }

    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        Log.v(TAG, "Forwarding onRestoreInstanceState() to plugins.");
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onRestoreInstanceState");
            try {
                this.activityPluginBinding.onRestoreInstanceState(bundle);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Log.v(TAG, "Forwarding onSaveInstanceState() to plugins.");
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onSaveInstanceState");
            try {
                this.activityPluginBinding.onSaveInstanceState(bundle);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    public void onUserLeaveHint() {
        Log.v(TAG, "Forwarding onUserLeaveHint() to plugins.");
        if (isAttachedToActivity()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                this.activityPluginBinding.onUserLeaveHint();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    public void remove(@NonNull Class<? extends FlutterPlugin> cls) {
        FlutterPlugin flutterPlugin = this.plugins.get(cls);
        if (flutterPlugin != null) {
            Trace.beginSection("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
            try {
                Log.v(TAG, "Removing plugin: " + flutterPlugin);
                if (flutterPlugin instanceof ActivityAware) {
                    if (isAttachedToActivity()) {
                        ((ActivityAware) flutterPlugin).onDetachedFromActivity();
                    }
                    this.activityAwarePlugins.remove(cls);
                }
                if (flutterPlugin instanceof ServiceAware) {
                    if (isAttachedToService()) {
                        ((ServiceAware) flutterPlugin).onDetachedFromService();
                    }
                    this.serviceAwarePlugins.remove(cls);
                }
                if (flutterPlugin instanceof BroadcastReceiverAware) {
                    if (isAttachedToBroadcastReceiver()) {
                        ((BroadcastReceiverAware) flutterPlugin).onDetachedFromBroadcastReceiver();
                    }
                    this.broadcastReceiverAwarePlugins.remove(cls);
                }
                if (flutterPlugin instanceof ContentProviderAware) {
                    if (isAttachedToContentProvider()) {
                        ((ContentProviderAware) flutterPlugin).onDetachedFromContentProvider();
                    }
                    this.contentProviderAwarePlugins.remove(cls);
                }
                flutterPlugin.onDetachedFromEngine(this.pluginBinding);
                this.plugins.remove(cls);
            } finally {
                Trace.endSection();
            }
        }
    }

    public void removeAll() {
        remove((Set<Class<? extends FlutterPlugin>>) new HashSet(this.plugins.keySet()));
        this.plugins.clear();
    }

    public void remove(@NonNull Set<Class<? extends FlutterPlugin>> set) {
        for (Class<? extends FlutterPlugin> remove : set) {
            remove(remove);
        }
    }

    public void add(@NonNull Set<FlutterPlugin> set) {
        for (FlutterPlugin add : set) {
            add(add);
        }
    }
}
