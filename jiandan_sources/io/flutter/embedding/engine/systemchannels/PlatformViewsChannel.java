package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.utils.SapiUtils;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class PlatformViewsChannel {
    public static final String TAG = "PlatformViewsChannel";
    public final MethodChannel channel;
    public PlatformViewsHandler handler;
    public final MethodChannel.MethodCallHandler parsingHandler = new MethodChannel.MethodCallHandler() {
        private void clearFocus(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success((Object) null);
            } catch (IllegalStateException e) {
                result.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
            }
        }

        private void create(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            double d;
            MethodChannel.Result result2 = result;
            Map map = (Map) methodCall.arguments();
            boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            double d2 = 0.0d;
            if (z) {
                d = 0.0d;
            } else {
                d = ((Double) map.get("width")).doubleValue();
            }
            if (!z) {
                d2 = ((Double) map.get("height")).doubleValue();
            }
            PlatformViewCreationRequest platformViewCreationRequest = new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), d, d2, ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null);
            if (z) {
                try {
                    PlatformViewsChannel.this.handler.createAndroidViewForPlatformView(platformViewCreationRequest);
                    result2.success((Object) null);
                } catch (IllegalStateException e) {
                    result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
                }
            } else {
                result2.success(Long.valueOf(PlatformViewsChannel.this.handler.createVirtualDisplayForPlatformView(platformViewCreationRequest)));
            }
        }

        private void dispose(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            int intValue = ((Integer) map.get("id")).intValue();
            if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                try {
                    PlatformViewsChannel.this.handler.disposeAndroidViewForPlatformView(intValue);
                } catch (IllegalStateException e) {
                    result.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
                    return;
                }
            } else {
                PlatformViewsChannel.this.handler.disposeVirtualDisplayForPlatformView(intValue);
            }
            result.success((Object) null);
        }

        private void resize(@NonNull MethodCall methodCall, @NonNull final MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.resizePlatformView(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new Runnable() {
                    public void run() {
                        result.success((Object) null);
                    }
                });
            } catch (IllegalStateException e) {
                result.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
            }
        }

        private void setDirection(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                result.success((Object) null);
            } catch (IllegalStateException e) {
                result.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
            }
        }

        private void synchronizeToNativeViewHierarchy(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                result.success((Object) null);
            } catch (IllegalStateException e) {
                result.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
            }
        }

        private void touch(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            MethodChannel.Result result2;
            MethodChannel.Result result3 = result;
            List list = (List) methodCall.arguments();
            PlatformViewTouch platformViewTouch = r2;
            PlatformViewTouch platformViewTouch2 = platformViewTouch;
            PlatformViewTouch platformViewTouch3 = new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue());
            try {
                PlatformViewsChannel.this.handler.onTouch(platformViewTouch);
                result2 = result;
                try {
                    result2.success((Object) null);
                } catch (IllegalStateException e) {
                    e = e;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                result2 = result;
                result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, PlatformViewsChannel.detailedExceptionString(e), (Object) null);
            }
        }

        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler != null) {
                Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
                String str = methodCall.method;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1352294148:
                        if (str.equals("create")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -934437708:
                        if (str.equals("resize")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -756050293:
                        if (str.equals("clearFocus")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -308988850:
                        if (str.equals("synchronizeToNativeViewHierarchy")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 110550847:
                        if (str.equals("touch")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 576796989:
                        if (str.equals("setDirection")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1671767583:
                        if (str.equals("dispose")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        create(methodCall, result);
                        return;
                    case 1:
                        dispose(methodCall, result);
                        return;
                    case 2:
                        resize(methodCall, result);
                        return;
                    case 3:
                        touch(methodCall, result);
                        return;
                    case 4:
                        setDirection(methodCall, result);
                        return;
                    case 5:
                        clearFocus(methodCall, result);
                        return;
                    case 6:
                        synchronizeToNativeViewHierarchy(methodCall, result);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }
    };

    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        @Nullable
        public final ByteBuffer params;
        public final int viewId;
        @NonNull
        public final String viewType;

        public PlatformViewCreationRequest(int i2, @NonNull String str, double d, double d2, int i3, @Nullable ByteBuffer byteBuffer) {
            this.viewId = i2;
            this.viewType = str;
            this.logicalWidth = d;
            this.logicalHeight = d2;
            this.direction = i3;
            this.params = byteBuffer;
        }
    }

    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i2, double d, double d2) {
            this.viewId = i2;
            this.newLogicalWidth = d;
            this.newLogicalHeight = d2;
        }
    }

    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        @NonNull
        public final Number downTime;
        public final int edgeFlags;
        @NonNull
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        @NonNull
        public final Object rawPointerCoords;
        @NonNull
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i2, @NonNull Number number, @NonNull Number number2, int i3, int i4, @NonNull Object obj, @NonNull Object obj2, int i5, int i6, float f, float f2, int i7, int i8, int i9, int i10, long j) {
            this.viewId = i2;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i3;
            this.pointerCount = i4;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i5;
            this.buttonState = i6;
            this.xPrecision = f;
            this.yPrecision = f2;
            this.deviceId = i7;
            this.edgeFlags = i8;
            this.source = i9;
            this.flags = i10;
            this.motionEventId = j;
        }
    }

    public interface PlatformViewsHandler {
        void clearFocus(int i2);

        void createAndroidViewForPlatformView(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        long createVirtualDisplayForPlatformView(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        void disposeAndroidViewForPlatformView(int i2);

        void disposeVirtualDisplayForPlatformView(int i2);

        void onTouch(@NonNull PlatformViewTouch platformViewTouch);

        void resizePlatformView(@NonNull PlatformViewResizeRequest platformViewResizeRequest, @NonNull Runnable runnable);

        void setDirection(int i2, int i3);

        void synchronizeToNativeViewHierarchy(boolean z);
    }

    public PlatformViewsChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingHandler);
    }

    public static String detailedExceptionString(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void invokeViewFocused(int i2) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("viewFocused", Integer.valueOf(i2));
        }
    }

    public void setPlatformViewsHandler(@Nullable PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
