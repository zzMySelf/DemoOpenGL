package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiOptions;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel {
    public static final String TAG = "RestorationChannel";
    public MethodChannel channel;
    public boolean engineHasProvidedData;
    public boolean frameworkHasRequestedData;
    public final MethodChannel.MethodCallHandler handler;
    public MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    public byte[] restorationData;
    public final boolean waitForRestorationData;

    public RestorationChannel(@NonNull DartExecutor dartExecutor, @NonNull boolean z) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z);
    }

    /* access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiOptions.KEY_CACHE_ENABLED, Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void clearData() {
        this.restorationData = null;
    }

    public byte[] getRestorationData() {
        return this.restorationData;
    }

    public void setRestorationData(final byte[] bArr) {
        this.engineHasProvidedData = true;
        MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
        if (result != null) {
            result.success(packageData(bArr));
            this.pendingFrameworkRestorationChannelRequest = null;
            this.restorationData = bArr;
        } else if (this.frameworkHasRequestedData) {
            this.channel.invokeMethod("push", packageData(bArr), new MethodChannel.Result() {
                public void error(String str, String str2, Object obj) {
                    Log.e(RestorationChannel.TAG, "Error " + str + " while sending restoration data to framework: " + str2);
                }

                public void notImplemented() {
                }

                public void success(Object obj) {
                    byte[] unused = RestorationChannel.this.restorationData = bArr;
                }
            });
        } else {
            this.restorationData = bArr;
        }
    }

    public RestorationChannel(MethodChannel methodChannel, @NonNull boolean z) {
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        AnonymousClass2 r0 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r5, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = r5.method
                    java.lang.Object r5 = r5.arguments
                    int r1 = r0.hashCode()
                    r2 = 102230(0x18f56, float:1.43255E-40)
                    r3 = 1
                    if (r1 == r2) goto L_0x001e
                    r2 = 111375(0x1b30f, float:1.5607E-40)
                    if (r1 == r2) goto L_0x0014
                    goto L_0x0028
                L_0x0014:
                    java.lang.String r1 = "put"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0028
                    r0 = 0
                    goto L_0x0029
                L_0x001e:
                    java.lang.String r1 = "get"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0028
                    r0 = 1
                    goto L_0x0029
                L_0x0028:
                    r0 = -1
                L_0x0029:
                    if (r0 == 0) goto L_0x0057
                    if (r0 == r3) goto L_0x0031
                    r6.notImplemented()
                    goto L_0x0062
                L_0x0031:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean unused = r5.frameworkHasRequestedData = r3
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r5 = r5.engineHasProvidedData
                    if (r5 != 0) goto L_0x0049
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r0 = r5.waitForRestorationData
                    if (r0 != 0) goto L_0x0045
                    goto L_0x0049
                L_0x0045:
                    io.flutter.plugin.common.MethodChannel.Result unused = r5.pendingFrameworkRestorationChannelRequest = r6
                    goto L_0x0062
                L_0x0049:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r0 = r5.restorationData
                    java.util.Map r5 = r5.packageData(r0)
                    r6.success(r5)
                    goto L_0x0062
                L_0x0057:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r0 = io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r5 = (byte[]) r5
                    byte[] unused = r0.restorationData = r5
                    r5 = 0
                    r6.success(r5)
                L_0x0062:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.RestorationChannel.AnonymousClass2.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.handler = r0;
        this.channel = methodChannel;
        this.waitForRestorationData = z;
        methodChannel.setMethodCallHandler(r0);
    }
}
