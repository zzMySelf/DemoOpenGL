package com.jrai.flutter_keyboard_visibility;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

public class FlutterKeyboardVisibilityPlugin implements FlutterPlugin, ActivityAware, EventChannel.StreamHandler, ViewTreeObserver.OnGlobalLayoutListener {
    public EventChannel.EventSink eventSink;
    public boolean isVisible;
    public View mainView;

    private void init(BinaryMessenger binaryMessenger) {
        new EventChannel(binaryMessenger, "flutter_keyboard_visibility").setStreamHandler(this);
    }

    private void listenForKeyboard(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        this.mainView = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void unregisterListener() {
        View view = this.mainView;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.mainView = null;
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        listenForKeyboard(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        init(flutterPluginBinding.getBinaryMessenger());
    }

    public void onCancel(Object obj) {
        this.eventSink = null;
    }

    public void onDetachedFromActivity() {
        unregisterListener();
    }

    public void onDetachedFromActivityForConfigChanges() {
        unregisterListener();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        unregisterListener();
    }

    public void onGlobalLayout() {
        if (this.mainView != null) {
            Rect rect = new Rect();
            this.mainView.getWindowVisibleDisplayFrame(rect);
            boolean z = ((double) rect.height()) / ((double) this.mainView.getRootView().getHeight()) < 0.85d;
            if (z != this.isVisible) {
                this.isVisible = z;
                EventChannel.EventSink eventSink2 = this.eventSink;
                if (eventSink2 != null) {
                    eventSink2.success(Integer.valueOf(z ? 1 : 0));
                }
            }
        }
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink2) {
        this.eventSink = eventSink2;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        listenForKeyboard(activityPluginBinding.getActivity());
    }
}
