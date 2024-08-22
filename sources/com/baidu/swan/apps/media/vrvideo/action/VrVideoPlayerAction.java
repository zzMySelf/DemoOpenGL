package com.baidu.swan.apps.media.vrvideo.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;

public class VrVideoPlayerAction extends SwanAppAction {
    public static final String ACTION_OPEN = "/swanAPI/vrvideo/open";
    public static final String ACTION_REMOVE = "/swanAPI/vrvideo/remove";
    public static final String ACTION_UPDATE = "/swanAPI/vrvideo/update";
    private static final String MODULE_NAME = "/swanAPI/vrvideo";
    private static final String MODULE_PATH = "/swanAPI/vrvideo/";
    private static final String TAG = "VrVideoPlayerAction";
    private VrVideoOpenAction mVideoOpenAction;
    private VrVideoRemoveAction mVideoRemoveAction;
    private VrVideoUpdateAction mVideoUpdateAction;

    public VrVideoPlayerAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, MODULE_NAME);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        SwanAppLog.d(TAG, "handle entity: ", entity);
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        if (r11.equals(ACTION_REMOVE) != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleSubAction(android.content.Context r8, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r9, com.baidu.searchbox.unitedscheme.CallbackHandler r10, java.lang.String r11, com.baidu.swan.apps.runtime.SwanApp r12) {
        /*
            r7 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handleSubAction subAction : "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r3 = "params : "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "params"
            org.json.JSONObject r2 = getParamAsJo(r9, r2)
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "VrVideoPlayerAction"
            com.baidu.swan.apps.console.SwanAppLog.d(r2, r1)
            int r1 = r11.hashCode()
            java.lang.String r2 = "/swanAPI/vrvideo/update"
            java.lang.String r5 = "/swanAPI/vrvideo/remove"
            java.lang.String r6 = "/swanAPI/vrvideo/open"
            switch(r1) {
                case 533456719: goto L_0x004c;
                case 1626770505: goto L_0x0045;
                case 1722535054: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0054
        L_0x003d:
            boolean r0 = r11.equals(r2)
            if (r0 == 0) goto L_0x003c
            r0 = r4
            goto L_0x0055
        L_0x0045:
            boolean r1 = r11.equals(r5)
            if (r1 == 0) goto L_0x003c
            goto L_0x0055
        L_0x004c:
            boolean r0 = r11.equals(r6)
            if (r0 == 0) goto L_0x003c
            r0 = r3
            goto L_0x0055
        L_0x0054:
            r0 = -1
        L_0x0055:
            switch(r0) {
                case 0: goto L_0x007e;
                case 1: goto L_0x006c;
                case 2: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            r0 = 0
            goto L_0x0090
        L_0x005a:
            com.baidu.swan.apps.media.vrvideo.action.VrVideoRemoveAction r0 = r7.mVideoRemoveAction
            if (r0 != 0) goto L_0x0065
            com.baidu.swan.apps.media.vrvideo.action.VrVideoRemoveAction r0 = new com.baidu.swan.apps.media.vrvideo.action.VrVideoRemoveAction
            r0.<init>(r5)
            r7.mVideoRemoveAction = r0
        L_0x0065:
            com.baidu.swan.apps.media.vrvideo.action.VrVideoRemoveAction r0 = r7.mVideoRemoveAction
            boolean r0 = r0.handle(r8, r9, r10, r12)
            goto L_0x0090
        L_0x006c:
            com.baidu.swan.apps.media.vrvideo.action.VrVideoUpdateAction r0 = r7.mVideoUpdateAction
            if (r0 != 0) goto L_0x0077
            com.baidu.swan.apps.media.vrvideo.action.VrVideoUpdateAction r0 = new com.baidu.swan.apps.media.vrvideo.action.VrVideoUpdateAction
            r0.<init>(r2)
            r7.mVideoUpdateAction = r0
        L_0x0077:
            com.baidu.swan.apps.media.vrvideo.action.VrVideoUpdateAction r0 = r7.mVideoUpdateAction
            boolean r0 = r0.handle(r8, r9, r10, r12)
            goto L_0x0090
        L_0x007e:
            com.baidu.swan.apps.media.vrvideo.action.VrVideoOpenAction r0 = r7.mVideoOpenAction
            if (r0 != 0) goto L_0x0089
            com.baidu.swan.apps.media.vrvideo.action.VrVideoOpenAction r0 = new com.baidu.swan.apps.media.vrvideo.action.VrVideoOpenAction
            r0.<init>(r6)
            r7.mVideoOpenAction = r0
        L_0x0089:
            com.baidu.swan.apps.media.vrvideo.action.VrVideoOpenAction r0 = r7.mVideoOpenAction
            boolean r0 = r0.handle(r8, r9, r10, r12)
        L_0x0090:
            if (r0 != 0) goto L_0x0098
            boolean r1 = super.handleSubAction(r8, r9, r10, r11, r12)
            if (r1 == 0) goto L_0x0099
        L_0x0098:
            r3 = r4
        L_0x0099:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.media.vrvideo.action.VrVideoPlayerAction.handleSubAction(android.content.Context, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler, java.lang.String, com.baidu.swan.apps.runtime.SwanApp):boolean");
    }
}
