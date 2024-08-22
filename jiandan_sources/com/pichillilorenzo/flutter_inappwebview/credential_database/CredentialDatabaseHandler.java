package com.pichillilorenzo.flutter_inappwebview.credential_database;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import io.flutter.plugin.common.MethodChannel;

@RequiresApi(api = 26)
public class CredentialDatabaseHandler implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "CredentialDatabaseHandler";
    public static CredentialDatabase credentialDatabase;
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public CredentialDatabaseHandler(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_credential_database");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        credentialDatabase = CredentialDatabase.getInstance(inAppWebViewFlutterPlugin.applicationContext);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r21, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r22) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = r0.method
            int r3 = r2.hashCode()
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r3) {
                case -1851697792: goto L_0x0045;
                case -410271914: goto L_0x003b;
                case 589173355: goto L_0x0031;
                case 998955721: goto L_0x0027;
                case 1084504936: goto L_0x001d;
                case 1930845769: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x004f
        L_0x0013:
            java.lang.String r3 = "getAllAuthCredentials"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 0
            goto L_0x0050
        L_0x001d:
            java.lang.String r3 = "removeHttpAuthCredentials"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 4
            goto L_0x0050
        L_0x0027:
            java.lang.String r3 = "setHttpAuthCredential"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 2
            goto L_0x0050
        L_0x0031:
            java.lang.String r3 = "removeHttpAuthCredential"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 3
            goto L_0x0050
        L_0x003b:
            java.lang.String r3 = "getHttpAuthCredentials"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 1
            goto L_0x0050
        L_0x0045:
            java.lang.String r3 = "clearAllAuthCredentials"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 5
            goto L_0x0050
        L_0x004f:
            r2 = -1
        L_0x0050:
            if (r2 == 0) goto L_0x015a
            java.lang.String r3 = "port"
            java.lang.String r9 = "realm"
            java.lang.String r10 = "protocol"
            java.lang.String r11 = "host"
            if (r2 == r8) goto L_0x0119
            java.lang.String r8 = "password"
            java.lang.String r12 = "username"
            if (r2 == r7) goto L_0x00dd
            if (r2 == r6) goto L_0x00a7
            if (r2 == r5) goto L_0x0087
            if (r2 == r4) goto L_0x006f
            r22.notImplemented()
            r2 = r20
            goto L_0x01b9
        L_0x006f:
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r0 = credentialDatabase
            r0.clearAllAuthCredentials()
            r2 = r20
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r0 = r2.plugin
            if (r0 == 0) goto L_0x0112
            android.content.Context r0 = r0.applicationContext
            if (r0 == 0) goto L_0x0112
            android.webkit.WebViewDatabase r0 = android.webkit.WebViewDatabase.getInstance(r0)
            r0.clearHttpAuthUsernamePassword()
            goto L_0x0112
        L_0x0087:
            r2 = r20
            java.lang.Object r4 = r0.argument(r11)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.argument(r10)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.argument(r9)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r3 = credentialDatabase
            r3.removeHttpAuthCredentials(r4, r5, r6, r0)
            goto L_0x0112
        L_0x00a7:
            r2 = r20
            java.lang.Object r4 = r0.argument(r11)
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r4 = r0.argument(r10)
            r15 = r4
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r4 = r0.argument(r9)
            r16 = r4
            java.lang.String r16 = (java.lang.String) r16
            java.lang.Object r3 = r0.argument(r3)
            r17 = r3
            java.lang.Integer r17 = (java.lang.Integer) r17
            java.lang.Object r3 = r0.argument(r12)
            r18 = r3
            java.lang.String r18 = (java.lang.String) r18
            java.lang.Object r0 = r0.argument(r8)
            r19 = r0
            java.lang.String r19 = (java.lang.String) r19
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r13 = credentialDatabase
            r13.removeHttpAuthCredential(r14, r15, r16, r17, r18, r19)
            goto L_0x0112
        L_0x00dd:
            r2 = r20
            java.lang.Object r4 = r0.argument(r11)
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r4 = r0.argument(r10)
            r15 = r4
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r4 = r0.argument(r9)
            r16 = r4
            java.lang.String r16 = (java.lang.String) r16
            java.lang.Object r3 = r0.argument(r3)
            r17 = r3
            java.lang.Integer r17 = (java.lang.Integer) r17
            java.lang.Object r3 = r0.argument(r12)
            r18 = r3
            java.lang.String r18 = (java.lang.String) r18
            java.lang.Object r0 = r0.argument(r8)
            r19 = r0
            java.lang.String r19 = (java.lang.String) r19
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r13 = credentialDatabase
            r13.setHttpAuthCredential(r14, r15, r16, r17, r18, r19)
        L_0x0112:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L_0x0114:
            r1.success(r0)
            goto L_0x01b9
        L_0x0119:
            r2 = r20
            java.lang.Object r4 = r0.argument(r11)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.argument(r10)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.argument(r9)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r7 = credentialDatabase
            java.util.List r0 = r7.getHttpAuthCredentials(r4, r5, r6, r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0142:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0156
            java.lang.Object r4 = r0.next()
            com.pichillilorenzo.flutter_inappwebview.types.URLCredential r4 = (com.pichillilorenzo.flutter_inappwebview.types.URLCredential) r4
            java.util.Map r4 = r4.toMap()
            r3.add(r4)
            goto L_0x0142
        L_0x0156:
            r1.success(r3)
            goto L_0x01b9
        L_0x015a:
            r2 = r20
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r3 = credentialDatabase
            com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceDao r3 = r3.protectionSpaceDao
            java.util.List r3 = r3.getAll()
            java.util.Iterator r3 = r3.iterator()
        L_0x016d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0114
            java.lang.Object r4 = r3.next()
            com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace r4 = (com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r6 = credentialDatabase
            com.pichillilorenzo.flutter_inappwebview.credential_database.URLCredentialDao r6 = r6.credentialDao
            java.lang.Long r7 = r4.getId()
            java.util.List r6 = r6.getAllByProtectionSpaceId(r7)
            java.util.Iterator r6 = r6.iterator()
        L_0x018e:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01a2
            java.lang.Object r7 = r6.next()
            com.pichillilorenzo.flutter_inappwebview.types.URLCredential r7 = (com.pichillilorenzo.flutter_inappwebview.types.URLCredential) r7
            java.util.Map r7 = r7.toMap()
            r5.add(r7)
            goto L_0x018e
        L_0x01a2:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Map r4 = r4.toMap()
            java.lang.String r7 = "protectionSpace"
            r6.put(r7, r4)
            java.lang.String r4 = "credentials"
            r6.put(r4, r5)
            r0.add(r6)
            goto L_0x016d
        L_0x01b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabaseHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
