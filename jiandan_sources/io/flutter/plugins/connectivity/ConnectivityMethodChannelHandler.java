package io.flutter.plugins.connectivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class ConnectivityMethodChannelHandler implements MethodChannel.MethodCallHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public Connectivity connectivity;

    public ConnectivityMethodChannelHandler(Connectivity connectivity2) {
        this.connectivity = connectivity2;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        if (((str.hashCode() == 94627080 && str.equals("check")) ? (char) 0 : 65535) != 0) {
            result.notImplemented();
        } else {
            result.success(this.connectivity.getNetworkType());
        }
    }
}
