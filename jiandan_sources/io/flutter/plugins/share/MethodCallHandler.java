package io.flutter.plugins.share;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

public class MethodCallHandler implements MethodChannel.MethodCallHandler {
    public Share share;

    public MethodCallHandler(Share share2) {
        this.share = share2;
    }

    private void expectMapArguments(MethodCall methodCall) throws IllegalArgumentException {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map argument expected");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = -1811378728(0xffffffff94088dd8, float:-6.894219E-27)
            r3 = 1
            if (r1 == r2) goto L_0x001c
            r2 = 109400031(0x6854fdf, float:5.01464E-35)
            if (r1 == r2) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r1 = "share"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x001c:
            java.lang.String r1 = "shareFiles"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = -1
        L_0x0027:
            java.lang.String r1 = "subject"
            java.lang.String r2 = "text"
            r4 = 0
            if (r0 == 0) goto L_0x0065
            if (r0 == r3) goto L_0x0034
            r7.notImplemented()
            goto L_0x007c
        L_0x0034:
            r5.expectMapArguments(r6)
            java.lang.String r0 = "paths"
            java.lang.Object r0 = r6.argument(r0)
            java.util.List r0 = (java.util.List) r0
            java.lang.String r3 = "mimeTypes"
            java.lang.Object r3 = r6.argument(r3)
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r2 = r6.argument(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r6.argument(r1)
            java.lang.String r6 = (java.lang.String) r6
            io.flutter.plugins.share.Share r1 = r5.share     // Catch:{ IOException -> 0x005c }
            r1.shareFiles(r0, r3, r2, r6)     // Catch:{ IOException -> 0x005c }
            r7.success(r4)     // Catch:{ IOException -> 0x005c }
            goto L_0x007c
        L_0x005c:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            r7.error(r6, r4, r4)
            goto L_0x007c
        L_0x0065:
            r5.expectMapArguments(r6)
            java.lang.Object r0 = r6.argument(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r6 = r6.argument(r1)
            java.lang.String r6 = (java.lang.String) r6
            io.flutter.plugins.share.Share r1 = r5.share
            r1.share(r0, r6)
            r7.success(r4)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.share.MethodCallHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
