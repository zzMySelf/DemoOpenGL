package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge;
import java.util.HashMap;

public class AccessibilityChannel {
    public static final String TAG = "AccessibilityChannel";
    @NonNull
    public final BasicMessageChannel<Object> channel;
    @NonNull
    public final FlutterJNI flutterJNI;
    @Nullable
    public AccessibilityMessageHandler handler;
    public final BasicMessageChannel.MessageHandler<Object> parsingMessageHandler = new BasicMessageChannel.MessageHandler<Object>() {
        public void onMessage(@Nullable Object obj, @NonNull BasicMessageChannel.Reply<Object> reply) {
            String str;
            if (AccessibilityChannel.this.handler != null) {
                HashMap hashMap = (HashMap) obj;
                String str2 = (String) hashMap.get("type");
                HashMap hashMap2 = (HashMap) hashMap.get("data");
                Log.v(AccessibilityChannel.TAG, "Received " + str2 + " message.");
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1140076541:
                        if (str2.equals("tooltip")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -649620375:
                        if (str2.equals("announce")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 114595:
                        if (str2.equals("tap")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 114203431:
                        if (str2.equals("longPress")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        AccessibilityChannel.this.handler.announce(str3);
                    }
                } else if (c == 1) {
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        AccessibilityChannel.this.handler.onTap(num.intValue());
                    }
                } else if (c == 2) {
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        AccessibilityChannel.this.handler.onLongPress(num2.intValue());
                    }
                } else if (c == 3 && (str = (String) hashMap2.get("message")) != null) {
                    AccessibilityChannel.this.handler.onTooltip(str);
                }
                reply.reply(null);
            }
        }
    };

    public interface AccessibilityMessageHandler extends FlutterJNI.AccessibilityDelegate {
        void announce(@NonNull String str);

        void onLongPress(int i2);

        void onTap(int i2);

        void onTooltip(@NonNull String str);
    }

    public AccessibilityChannel(@NonNull DartExecutor dartExecutor, @NonNull FlutterJNI flutterJNI2) {
        BasicMessageChannel<Object> basicMessageChannel = new BasicMessageChannel<>(dartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
        this.channel = basicMessageChannel;
        basicMessageChannel.setMessageHandler(this.parsingMessageHandler);
        this.flutterJNI = flutterJNI2;
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action) {
        this.flutterJNI.dispatchSemanticsAction(i2, action);
    }

    public void onAndroidAccessibilityDisabled() {
        this.flutterJNI.setSemanticsEnabled(false);
    }

    public void onAndroidAccessibilityEnabled() {
        this.flutterJNI.setSemanticsEnabled(true);
    }

    public void setAccessibilityFeatures(int i2) {
        this.flutterJNI.setAccessibilityFeatures(i2);
    }

    public void setAccessibilityMessageHandler(@Nullable AccessibilityMessageHandler accessibilityMessageHandler) {
        this.handler = accessibilityMessageHandler;
        this.flutterJNI.setAccessibilityDelegate(accessibilityMessageHandler);
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        this.flutterJNI.dispatchSemanticsAction(i2, action, obj);
    }
}
