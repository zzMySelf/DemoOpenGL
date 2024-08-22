package com.pichillilorenzo.flutter_inappwebview;

import com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface;
import io.flutter.plugin.common.MethodChannel;

public class InAppWebViewMethodHandler implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "IAWMethodHandler";
    public InAppWebViewInterface webView;

    public InAppWebViewMethodHandler(InAppWebViewInterface inAppWebViewInterface) {
        this.webView = inAppWebViewInterface;
    }

    public void dispose() {
        this.webView = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05ef, code lost:
        r0 = java.lang.Boolean.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0661, code lost:
        r0 = java.lang.Integer.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0735, code lost:
        r0 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:444:0x0838, code lost:
        if (r0.isLoading() != false) goto L_0x088d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x0857, code lost:
        if (r3.canGoBackOrForward(((java.lang.Integer) r0.argument("steps")).intValue()) != false) goto L_0x088d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:458:0x0876, code lost:
        if (r0.canGoForward() != false) goto L_0x088d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:465:0x088b, code lost:
        if (r0.canGoBack() != false) goto L_0x088d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x088d, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:467:0x088f, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:468:0x0890, code lost:
        r0 = java.lang.Boolean.valueOf(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x090b, code lost:
        r2.success(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0992, code lost:
        r0 = java.lang.Boolean.TRUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x0994, code lost:
        r2.success(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:516:0x09ba, code lost:
        r18.notImplemented();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:533:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:534:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r17, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.String r3 = r0.method
            int r4 = r3.hashCode()
            switch(r4) {
                case -2022488786: goto L_0x033d;
                case -1787354268: goto L_0x0332;
                case -1773179062: goto L_0x0327;
                case -1683397606: goto L_0x031c;
                case -1624396757: goto L_0x0311;
                case -1331417355: goto L_0x0306;
                case -1331417354: goto L_0x02fb;
                case -1309347773: goto L_0x02f0;
                case -1249348039: goto L_0x02e6;
                case -1241591313: goto L_0x02da;
                case -1067273523: goto L_0x02ce;
                case -995752566: goto L_0x02c2;
                case -957712370: goto L_0x02b6;
                case -948122918: goto L_0x02aa;
                case -934641255: goto L_0x029e;
                case -934426579: goto L_0x0292;
                case -759238347: goto L_0x0286;
                case -756050293: goto L_0x027a;
                case -696286326: goto L_0x026e;
                case -696286120: goto L_0x0262;
                case -694273432: goto L_0x0256;
                case -679382964: goto L_0x024a;
                case -678975813: goto L_0x023e;
                case -402165756: goto L_0x0232;
                case -402165208: goto L_0x0226;
                case -391221073: goto L_0x021b;
                case -318289731: goto L_0x020f;
                case -317054497: goto L_0x0203;
                case -243128142: goto L_0x01f7;
                case -212614552: goto L_0x01eb;
                case -127960866: goto L_0x01df;
                case -110027141: goto L_0x01d3;
                case -53272641: goto L_0x01c7;
                case -32598479: goto L_0x01bb;
                case -17750794: goto L_0x01af;
                case 3202370: goto L_0x01a3;
                case 3529469: goto L_0x0197;
                case 94756344: goto L_0x018b;
                case 97958356: goto L_0x017f;
                case 106440182: goto L_0x0173;
                case 194959693: goto L_0x0167;
                case 210916051: goto L_0x015b;
                case 336631465: goto L_0x0150;
                case 492688268: goto L_0x0144;
                case 559938080: goto L_0x0138;
                case 740366903: goto L_0x012c;
                case 817048102: goto L_0x0120;
                case 858987473: goto L_0x0114;
                case 903120263: goto L_0x0108;
                case 998674874: goto L_0x00fc;
                case 1042858233: goto L_0x00f0;
                case 1076821923: goto L_0x00e5;
                case 1091267752: goto L_0x00d9;
                case 1246613238: goto L_0x00cd;
                case 1312131169: goto L_0x00c1;
                case 1520566363: goto L_0x00b5;
                case 1587824640: goto L_0x00a9;
                case 1596466167: goto L_0x009d;
                case 1631638145: goto L_0x0091;
                case 1724190684: goto L_0x0085;
                case 1726230251: goto L_0x0079;
                case 1729408231: goto L_0x006d;
                case 1779894764: goto L_0x0061;
                case 1810715187: goto L_0x0055;
                case 1845118384: goto L_0x004a;
                case 1845185410: goto L_0x003f;
                case 1916929588: goto L_0x0033;
                case 1925083019: goto L_0x0027;
                case 1937913574: goto L_0x001c;
                case 1966196898: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0348
        L_0x0011:
            java.lang.String r4 = "getTitle"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 1
            goto L_0x0349
        L_0x001c:
            java.lang.String r4 = "evaluateJavascript"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 7
            goto L_0x0349
        L_0x0027:
            java.lang.String r4 = "injectJavascriptFileFromUrl"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 8
            goto L_0x0349
        L_0x0033:
            java.lang.String r4 = "findAllAsync"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 30
            goto L_0x0349
        L_0x003f:
            java.lang.String r4 = "loadFile"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 6
            goto L_0x0349
        L_0x004a:
            java.lang.String r4 = "loadData"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 5
            goto L_0x0349
        L_0x0055:
            java.lang.String r4 = "goBackOrForward"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 16
            goto L_0x0349
        L_0x0061:
            java.lang.String r4 = "setContextMenu"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 52
            goto L_0x0349
        L_0x006d:
            java.lang.String r4 = "requestImageRef"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 54
            goto L_0x0349
        L_0x0079:
            java.lang.String r4 = "callAsyncJavaScript"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 63
            goto L_0x0349
        L_0x0085:
            java.lang.String r4 = "setOptions"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 21
            goto L_0x0349
        L_0x0091:
            java.lang.String r4 = "getZoomScale"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 43
            goto L_0x0349
        L_0x009d:
            java.lang.String r4 = "addUserScript"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 59
            goto L_0x0349
        L_0x00a9:
            java.lang.String r4 = "removeAllUserScripts"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 62
            goto L_0x0349
        L_0x00b5:
            java.lang.String r4 = "resumeTimers"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 38
            goto L_0x0349
        L_0x00c1:
            java.lang.String r4 = "getCertificate"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 57
            goto L_0x0349
        L_0x00cd:
            java.lang.String r4 = "requestFocusNodeHref"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 53
            goto L_0x0349
        L_0x00d9:
            java.lang.String r4 = "getOriginalUrl"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 42
            goto L_0x0349
        L_0x00e5:
            java.lang.String r4 = "getProgress"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 2
            goto L_0x0349
        L_0x00f0:
            java.lang.String r4 = "clearSslPreferences"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 29
            goto L_0x0349
        L_0x00fc:
            java.lang.String r4 = "removeUserScriptsByGroupName"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 61
            goto L_0x0349
        L_0x0108:
            java.lang.String r4 = "clearHistory"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 58
            goto L_0x0349
        L_0x0114:
            java.lang.String r4 = "pageDown"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 46
            goto L_0x0349
        L_0x0120:
            java.lang.String r4 = "clearMatches"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 32
            goto L_0x0349
        L_0x012c:
            java.lang.String r4 = "injectCSSFileFromUrl"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 10
            goto L_0x0349
        L_0x0138:
            java.lang.String r4 = "canScrollVertically"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 68
            goto L_0x0349
        L_0x0144:
            java.lang.String r4 = "getHitTestResult"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 45
            goto L_0x0349
        L_0x0150:
            java.lang.String r4 = "loadUrl"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 3
            goto L_0x0349
        L_0x015b:
            java.lang.String r4 = "postWebMessage"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 66
            goto L_0x0349
        L_0x0167:
            java.lang.String r4 = "takeScreenshot"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 20
            goto L_0x0349
        L_0x0173:
            java.lang.String r4 = "pause"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 35
            goto L_0x0349
        L_0x017f:
            java.lang.String r4 = "createWebMessageChannel"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 65
            goto L_0x0349
        L_0x018b:
            java.lang.String r4 = "close"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 23
            goto L_0x0349
        L_0x0197:
            java.lang.String r4 = "show"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 24
            goto L_0x0349
        L_0x01a3:
            java.lang.String r4 = "hide"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 25
            goto L_0x0349
        L_0x01af:
            java.lang.String r4 = "startSafeBrowsing"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 27
            goto L_0x0349
        L_0x01bb:
            java.lang.String r4 = "getCopyBackForwardList"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 26
            goto L_0x0349
        L_0x01c7:
            java.lang.String r4 = "injectCSSCode"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 9
            goto L_0x0349
        L_0x01d3:
            java.lang.String r4 = "zoomOut"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 50
            goto L_0x0349
        L_0x01df:
            java.lang.String r4 = "getSelectedText"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 44
            goto L_0x0349
        L_0x01eb:
            java.lang.String r4 = "getOptions"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 22
            goto L_0x0349
        L_0x01f7:
            java.lang.String r4 = "isLoading"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 19
            goto L_0x0349
        L_0x0203:
            java.lang.String r4 = "canGoBack"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 13
            goto L_0x0349
        L_0x020f:
            java.lang.String r4 = "goForward"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 14
            goto L_0x0349
        L_0x021b:
            java.lang.String r4 = "postUrl"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 4
            goto L_0x0349
        L_0x0226:
            java.lang.String r4 = "scrollTo"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 33
            goto L_0x0349
        L_0x0232:
            java.lang.String r4 = "scrollBy"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 34
            goto L_0x0349
        L_0x023e:
            java.lang.String r4 = "printCurrentPage"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 39
            goto L_0x0349
        L_0x024a:
            java.lang.String r4 = "findNext"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 31
            goto L_0x0349
        L_0x0256:
            java.lang.String r4 = "addWebMessageListener"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 67
            goto L_0x0349
        L_0x0262:
            java.lang.String r4 = "zoomIn"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 49
            goto L_0x0349
        L_0x026e:
            java.lang.String r4 = "zoomBy"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 41
            goto L_0x0349
        L_0x027a:
            java.lang.String r4 = "clearFocus"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 51
            goto L_0x0349
        L_0x0286:
            java.lang.String r4 = "clearCache"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 28
            goto L_0x0349
        L_0x0292:
            java.lang.String r4 = "resume"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 36
            goto L_0x0349
        L_0x029e:
            java.lang.String r4 = "reload"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 11
            goto L_0x0349
        L_0x02aa:
            java.lang.String r4 = "stopLoading"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 18
            goto L_0x0349
        L_0x02b6:
            java.lang.String r4 = "canScrollHorizontally"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 69
            goto L_0x0349
        L_0x02c2:
            java.lang.String r4 = "pageUp"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 47
            goto L_0x0349
        L_0x02ce:
            java.lang.String r4 = "canGoForward"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 15
            goto L_0x0349
        L_0x02da:
            java.lang.String r4 = "goBack"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 12
            goto L_0x0349
        L_0x02e6:
            java.lang.String r4 = "getUrl"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 0
            goto L_0x0349
        L_0x02f0:
            java.lang.String r4 = "canGoBackOrForward"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 17
            goto L_0x0349
        L_0x02fb:
            java.lang.String r4 = "getScrollY"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 56
            goto L_0x0349
        L_0x0306:
            java.lang.String r4 = "getScrollX"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 55
            goto L_0x0349
        L_0x0311:
            java.lang.String r4 = "saveWebArchive"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 48
            goto L_0x0349
        L_0x031c:
            java.lang.String r4 = "removeUserScript"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 60
            goto L_0x0349
        L_0x0327:
            java.lang.String r4 = "getContentHeight"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 40
            goto L_0x0349
        L_0x0332:
            java.lang.String r4 = "pauseTimers"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 37
            goto L_0x0349
        L_0x033d:
            java.lang.String r4 = "isSecureContext"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0348
            r3 = 64
            goto L_0x0349
        L_0x0348:
            r3 = -1
        L_0x0349:
            java.lang.String r4 = "index"
            java.lang.String r9 = "userScript"
            java.lang.String r10 = "animated"
            java.lang.String r11 = "y"
            java.lang.String r12 = "x"
            java.lang.String r13 = "steps"
            java.lang.String r14 = "urlFile"
            java.lang.String r15 = "contentWorld"
            java.lang.String r6 = "source"
            java.lang.String r5 = "data"
            java.lang.String r7 = "IAWMethodHandler"
            r8 = 0
            switch(r3) {
                case 0: goto L_0x09b0;
                case 1: goto L_0x09a6;
                case 2: goto L_0x0998;
                case 3: goto L_0x097d;
                case 4: goto L_0x0963;
                case 5: goto L_0x092e;
                case 6: goto L_0x0910;
                case 7: goto L_0x08eb;
                case 8: goto L_0x08d2;
                case 9: goto L_0x08c1;
                case 10: goto L_0x08a8;
                case 11: goto L_0x089f;
                case 12: goto L_0x0896;
                case 13: goto L_0x0882;
                case 14: goto L_0x0879;
                case 15: goto L_0x086d;
                case 16: goto L_0x085a;
                case 17: goto L_0x0844;
                case 18: goto L_0x083b;
                case 19: goto L_0x082f;
                case 20: goto L_0x081c;
                case 21: goto L_0x07d2;
                case 22: goto L_0x07a6;
                case 23: goto L_0x0785;
                case 24: goto L_0x0764;
                case 25: goto L_0x0743;
                case 26: goto L_0x0739;
                case 27: goto L_0x0719;
                case 28: goto L_0x0710;
                case 29: goto L_0x0707;
                case 30: goto L_0x06f4;
                case 31: goto L_0x06dd;
                case 32: goto L_0x06d4;
                case 33: goto L_0x06b7;
                case 34: goto L_0x069a;
                case 35: goto L_0x0691;
                case 36: goto L_0x0688;
                case 37: goto L_0x067f;
                case 38: goto L_0x0676;
                case 39: goto L_0x0667;
                case 40: goto L_0x0657;
                case 41: goto L_0x0639;
                case 42: goto L_0x062f;
                case 43: goto L_0x061f;
                case 44: goto L_0x0609;
                case 45: goto L_0x05f5;
                case 46: goto L_0x05d9;
                case 47: goto L_0x05c2;
                case 48: goto L_0x059e;
                case 49: goto L_0x0595;
                case 50: goto L_0x058c;
                case 51: goto L_0x0583;
                case 52: goto L_0x0570;
                case 53: goto L_0x0566;
                case 54: goto L_0x055c;
                case 55: goto L_0x0552;
                case 56: goto L_0x0548;
                case 57: goto L_0x053a;
                case 58: goto L_0x0531;
                case 59: goto L_0x0511;
                case 60: goto L_0x04e3;
                case 61: goto L_0x04c6;
                case 62: goto L_0x04b1;
                case 63: goto L_0x0481;
                case 64: goto L_0x046d;
                case 65: goto L_0x0451;
                case 66: goto L_0x03b5;
                case 67: goto L_0x0379;
                case 68: goto L_0x036f;
                case 69: goto L_0x0365;
                default: goto L_0x0363;
            }
        L_0x0363:
            goto L_0x09ba
        L_0x0365:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0735
            boolean r0 = r0.canScrollHorizontally()
            goto L_0x05ef
        L_0x036f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0735
            boolean r0 = r0.canScrollVertically()
            goto L_0x05ef
        L_0x0379:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "webMessageListener"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r4 = r3.getPlugin()
            io.flutter.plugin.common.BinaryMessenger r4 = r4.messenger
            com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener r0 = com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener.fromMap(r3, r4, r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r3 = r3 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "WEB_MESSAGE_LISTENER"
            boolean r3 = androidx.webkit.WebViewFeature.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x0992
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView     // Catch:{ Exception -> 0x03ab }
            r3.addWebMessageListener(r0)     // Catch:{ Exception -> 0x03ab }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03ab }
            r2.success(r0)     // Catch:{ Exception -> 0x03ab }
            goto L_0x09bd
        L_0x03ab:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r2.error(r7, r0, r8)
            goto L_0x09bd
        L_0x03b5:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "POST_WEB_MESSAGE"
            boolean r3 = androidx.webkit.WebViewFeature.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "message"
            java.lang.Object r3 = r0.argument(r3)
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r6 = "targetOrigin"
            java.lang.Object r0 = r0.argument(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r9 = "ports"
            java.lang.Object r9 = r3.get(r9)
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x0425
            java.util.Iterator r9 = r9.iterator()
        L_0x03e9:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0425
            java.lang.Object r10 = r9.next()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r11 = "webMessageChannelId"
            java.lang.Object r11 = r10.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r10.get(r4)
            java.lang.Integer r10 = (java.lang.Integer) r10
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r12 = r1.webView
            java.util.Map r12 = r12.getWebMessageChannels()
            java.lang.Object r11 = r12.get(r11)
            com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel r11 = (com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel) r11
            if (r11 == 0) goto L_0x03e9
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r12 = r1.webView
            boolean r12 = r12 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r12 == 0) goto L_0x03e9
            java.util.List<androidx.webkit.WebMessagePortCompat> r11 = r11.compatPorts
            int r10 = r10.intValue()
            java.lang.Object r10 = r11.get(r10)
            r6.add(r10)
            goto L_0x03e9
        L_0x0425:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            boolean r4 = r4 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r4 == 0) goto L_0x09bd
            androidx.webkit.WebMessageCompat r4 = new androidx.webkit.WebMessageCompat
            java.lang.Object r3 = r3.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            r5 = 0
            androidx.webkit.WebMessagePortCompat[] r5 = new androidx.webkit.WebMessagePortCompat[r5]
            java.lang.Object[] r5 = r6.toArray(r5)
            androidx.webkit.WebMessagePortCompat[] r5 = (androidx.webkit.WebMessagePortCompat[]) r5
            r4.<init>(r3, r5)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView     // Catch:{ Exception -> 0x03ab }
            android.webkit.WebView r3 = (android.webkit.WebView) r3     // Catch:{ Exception -> 0x03ab }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x03ab }
            androidx.webkit.WebViewCompat.postWebMessage(r3, r4, r0)     // Catch:{ Exception -> 0x03ab }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03ab }
            r2.success(r0)     // Catch:{ Exception -> 0x03ab }
            goto L_0x09bd
        L_0x0451:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r0 == 0) goto L_0x090b
            java.lang.String r0 = "CREATE_WEB_MESSAGE_CHANNEL"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x090b
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel r0 = r0.createCompatWebMessageChannel()
            java.util.Map r0 = r0.toMap()
            goto L_0x0994
        L_0x046d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0735
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x0735
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$6 r3 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$6
            r3.<init>(r2)
            r0.isSecureContext(r3)
            goto L_0x09bd
        L_0x0481:
            r4 = 21
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x090b
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r4) goto L_0x090b
            java.lang.String r3 = "functionBody"
            java.lang.Object r3 = r0.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "arguments"
            java.lang.Object r4 = r0.argument(r4)
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r0 = r0.argument(r15)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.ContentWorld r0 = com.pichillilorenzo.flutter_inappwebview.types.ContentWorld.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$5 r6 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$5
            r6.<init>(r2)
            r5.callAsyncJavaScript(r3, r4, r0, r6)
            goto L_0x09bd
        L_0x04b1:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r0.getUserContentController()
            if (r0 == 0) goto L_0x0992
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r0.getUserContentController()
            r0.removeAllUserOnlyScripts()
            goto L_0x0992
        L_0x04c6:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "groupName"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            r3.removeUserOnlyScriptsByGroupName(r0)
            goto L_0x0992
        L_0x04e3:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0735
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            if (r3 == 0) goto L_0x0735
            java.lang.Object r3 = r0.argument(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r0 = r0.argument(r9)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.UserScript r0 = com.pichillilorenzo.flutter_inappwebview.types.UserScript.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r4 = r4.getUserContentController()
            int r3 = r3.intValue()
            com.pichillilorenzo.flutter_inappwebview.types.UserScriptInjectionTime r0 = r0.getInjectionTime()
            boolean r0 = r4.removeUserOnlyScriptAt(r3, r0)
            goto L_0x05ef
        L_0x0511:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0735
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            if (r3 == 0) goto L_0x0735
            java.lang.Object r0 = r0.argument(r9)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.UserScript r0 = com.pichillilorenzo.flutter_inappwebview.types.UserScript.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r3 = r3.getUserContentController()
            boolean r0 = r3.addUserOnlyScript(r0)
            goto L_0x05ef
        L_0x0531:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.clearHistory()
            goto L_0x0992
        L_0x053a:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            android.net.http.SslCertificate r0 = r0.getCertificate()
            java.util.Map r0 = com.pichillilorenzo.flutter_inappwebview.types.SslCertificateExt.toMap(r0)
            goto L_0x0994
        L_0x0548:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            int r0 = r0.getScrollY()
            goto L_0x0661
        L_0x0552:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            int r0 = r0.getScrollX()
            goto L_0x0661
        L_0x055c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.util.Map r0 = r0.requestImageRef()
            goto L_0x0994
        L_0x0566:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.util.Map r0 = r0.requestFocusNodeHref()
            goto L_0x0994
        L_0x0570:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "contextMenu"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.setContextMenu(r0)
            goto L_0x0992
        L_0x0583:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.clearFocus()
            goto L_0x0992
        L_0x058c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0735
            boolean r0 = r0.zoomOut()
            goto L_0x05ef
        L_0x0595:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0735
            boolean r0 = r0.zoomIn()
            goto L_0x05ef
        L_0x059e:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x090b
            java.lang.String r3 = "filePath"
            java.lang.Object r3 = r0.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "autoname"
            java.lang.Object r0 = r0.argument(r4)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$4 r5 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$4
            r5.<init>(r2)
            r4.saveWebArchive(r3, r0, r5)
            goto L_0x09bd
        L_0x05c2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0735
            java.lang.String r3 = "top"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r0 = r3.pageUp(r0)
            goto L_0x05ef
        L_0x05d9:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0735
            java.lang.String r3 = "bottom"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r0 = r3.pageDown(r0)
        L_0x05ef:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0994
        L_0x05f5:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x090b
            android.webkit.WebView$HitTestResult r0 = r0.getHitTestResult()
            com.pichillilorenzo.flutter_inappwebview.types.HitTestResult r0 = com.pichillilorenzo.flutter_inappwebview.types.HitTestResult.fromWebViewHitTestResult(r0)
            java.util.Map r0 = r0.toMap()
            goto L_0x0994
        L_0x0609:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x090b
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 19
            if (r3 < r4) goto L_0x090b
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$3 r3 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$3
            r3.<init>(r2)
            r0.getSelectedText(r3)
            goto L_0x09bd
        L_0x061f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x090b
            float r0 = r0.getZoomScale()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x0994
        L_0x062f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.lang.String r8 = r0.getOriginalUrl()
            goto L_0x090b
        L_0x0639:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x0992
            java.lang.String r3 = "zoomFactor"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Double r0 = (java.lang.Double) r0
            double r3 = r0.doubleValue()
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            float r3 = (float) r3
            r0.zoomBy(r3)
            goto L_0x0992
        L_0x0657:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            boolean r3 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r3 == 0) goto L_0x090b
            int r0 = r0.getContentHeight()
        L_0x0661:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0994
        L_0x0667:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x0992
            r0.printCurrentPage()
            goto L_0x0992
        L_0x0676:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.resumeTimers()
            goto L_0x0992
        L_0x067f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.pauseTimers()
            goto L_0x0992
        L_0x0688:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.onResume()
            goto L_0x0992
        L_0x0691:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.onPause()
            goto L_0x0992
        L_0x069a:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r3 = r0.argument(r12)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r4 = r0.argument(r11)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r0 = r0.argument(r10)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            r5.scrollBy(r3, r4, r0)
            goto L_0x0992
        L_0x06b7:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r3 = r0.argument(r12)
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r4 = r0.argument(r11)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r0 = r0.argument(r10)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r5 = r1.webView
            r5.scrollTo(r3, r4, r0)
            goto L_0x0992
        L_0x06d4:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.clearMatches()
            goto L_0x0992
        L_0x06dd:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "forward"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            boolean r0 = r0.booleanValue()
            r3.findNext(r0)
            goto L_0x0992
        L_0x06f4:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "find"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.findAllAsync(r0)
            goto L_0x0992
        L_0x0707:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.clearSslPreferences()
            goto L_0x0992
        L_0x0710:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.clearAllCache()
            goto L_0x0992
        L_0x0719:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0735
            java.lang.String r0 = "START_SAFE_BROWSING"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x0735
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            android.content.Context r0 = r0.getContext()
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$2 r3 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$2
            r3.<init>(r2)
            androidx.webkit.WebViewCompat.startSafeBrowsing(r0, r3)
            goto L_0x09bd
        L_0x0735:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0994
        L_0x0739:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.util.HashMap r8 = r0.getCopyBackForwardList()
            goto L_0x090b
        L_0x0743:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            r0.hide()
            goto L_0x0992
        L_0x0764:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            r0.show()
            goto L_0x0992
        L_0x0785:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x09ba
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            r0.close(r2)
            goto L_0x09bd
        L_0x07a6:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x07c8
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            if (r0 == 0) goto L_0x07c8
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r0 == 0) goto L_0x07c8
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r0 = r0.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r0 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r0
            java.util.Map r0 = r0.getOptions()
            goto L_0x0994
        L_0x07c8:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.util.Map r8 = r0.getOptions()
            goto L_0x090b
        L_0x07d2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            java.lang.String r4 = "options"
            if (r3 == 0) goto L_0x0803
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r3.getInAppBrowserDelegate()
            if (r3 == 0) goto L_0x0803
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r3.getInAppBrowserDelegate()
            boolean r3 = r3 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity
            if (r3 == 0) goto L_0x0803
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r3.getInAppBrowserDelegate()
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity r3 = (com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserActivity) r3
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserOptions r5 = new com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserOptions
            r5.<init>()
            java.lang.Object r0 = r0.argument(r4)
            java.util.HashMap r0 = (java.util.HashMap) r0
            r5.parse((java.util.Map) r0)
            r3.setOptions(r5, r0)
            goto L_0x0992
        L_0x0803:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r3 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions
            r3.<init>()
            java.lang.Object r0 = r0.argument(r4)
            java.util.HashMap r0 = (java.util.HashMap) r0
            r3.parse((java.util.Map) r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.setOptions(r3, r0)
            goto L_0x0992
        L_0x081c:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x090b
            java.lang.String r3 = "screenshotConfiguration"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.takeScreenshot(r0, r2)
            goto L_0x09bd
        L_0x082f:
            r5 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x088f
            boolean r0 = r0.isLoading()
            if (r0 == 0) goto L_0x088f
            goto L_0x088d
        L_0x083b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.stopLoading()
            goto L_0x0992
        L_0x0844:
            r5 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x088f
            java.lang.Object r0 = r0.argument(r13)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            boolean r0 = r3.canGoBackOrForward(r0)
            if (r0 == 0) goto L_0x088f
            goto L_0x088d
        L_0x085a:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r0 = r0.argument(r13)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r3.goBackOrForward(r0)
            goto L_0x0992
        L_0x086d:
            r5 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x088f
            boolean r0 = r0.canGoForward()
            if (r0 == 0) goto L_0x088f
            goto L_0x088d
        L_0x0879:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.goForward()
            goto L_0x0992
        L_0x0882:
            r5 = 0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x088f
            boolean r0 = r0.canGoBack()
            if (r0 == 0) goto L_0x088f
        L_0x088d:
            r6 = 1
            goto L_0x0890
        L_0x088f:
            r6 = 0
        L_0x0890:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            goto L_0x0994
        L_0x0896:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.goBack()
            goto L_0x0992
        L_0x089f:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x0992
            r0.reload()
            goto L_0x0992
        L_0x08a8:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r3 = r0.argument(r14)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "cssLinkHtmlTagAttributes"
            java.lang.Object r0 = r0.argument(r4)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.injectCSSFileFromUrl(r3, r0)
            goto L_0x0992
        L_0x08c1:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r0 = r0.argument(r6)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            r3.injectCSSCode(r0)
            goto L_0x0992
        L_0x08d2:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r3 = r0.argument(r14)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "scriptHtmlTagAttributes"
            java.lang.Object r0 = r0.argument(r4)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.injectJavascriptFileFromUrl(r3, r0)
            goto L_0x0992
        L_0x08eb:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x090b
            java.lang.Object r3 = r0.argument(r6)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r0.argument(r15)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.ContentWorld r0 = com.pichillilorenzo.flutter_inappwebview.types.ContentWorld.fromMap(r0)
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$1 r5 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler$1
            r5.<init>(r2)
            r4.evaluateJavascript(r3, r0, r5)
            goto L_0x09bd
        L_0x090b:
            r2.success(r8)
            goto L_0x09bd
        L_0x0910:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "assetFilePath"
            java.lang.Object r0 = r0.argument(r3)
            java.lang.String r0 = (java.lang.String) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView     // Catch:{ IOException -> 0x0922 }
            r3.loadFile(r0)     // Catch:{ IOException -> 0x0922 }
            goto L_0x0992
        L_0x0922:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = r0.getMessage()
            r2.error(r7, r0, r8)
            return
        L_0x092e:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.Object r3 = r0.argument(r5)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r3 = "mimeType"
            java.lang.Object r3 = r0.argument(r3)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r3 = "encoding"
            java.lang.Object r3 = r0.argument(r3)
            r8 = r3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r3 = "baseUrl"
            java.lang.Object r3 = r0.argument(r3)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r3 = "historyUrl"
            java.lang.Object r0 = r0.argument(r3)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.loadDataWithBaseURL(r5, r6, r7, r8, r9)
            goto L_0x0992
        L_0x0963:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "url"
            java.lang.Object r3 = r0.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "postData"
            java.lang.Object r0 = r0.argument(r4)
            byte[] r0 = (byte[]) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r4 = r1.webView
            r4.postUrl(r3, r0)
            goto L_0x0992
        L_0x097d:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            if (r3 == 0) goto L_0x0992
            java.lang.String r3 = "urlRequest"
            java.lang.Object r0 = r0.argument(r3)
            java.util.Map r0 = (java.util.Map) r0
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r3 = r1.webView
            com.pichillilorenzo.flutter_inappwebview.types.URLRequest r0 = com.pichillilorenzo.flutter_inappwebview.types.URLRequest.fromMap(r0)
            r3.loadUrl(r0)
        L_0x0992:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L_0x0994:
            r2.success(r0)
            goto L_0x09bd
        L_0x0998:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            int r0 = r0.getProgress()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            goto L_0x090b
        L_0x09a6:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.lang.String r8 = r0.getTitle()
            goto L_0x090b
        L_0x09b0:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r1.webView
            if (r0 == 0) goto L_0x090b
            java.lang.String r8 = r0.getUrl()
            goto L_0x090b
        L_0x09ba:
            r18.notImplemented()
        L_0x09bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
