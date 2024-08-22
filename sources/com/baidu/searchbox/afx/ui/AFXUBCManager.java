package com.baidu.searchbox.afx.ui;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/afx/ui/AFXUBCManager;", "", "()V", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AFXUBCManager.kt */
public final class AFXUBCManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXT_KEY_MSG = "msg";
    public static final String EXT_KEY_ST = "st";
    public static final String ID_AFX_PLAY = "1209";
    public static final String TYPE_PLAY_FAIL = "1";
    public static final String TYPE_PLAY_SUCCESS = "0";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/afx/ui/AFXUBCManager$Companion;", "", "()V", "EXT_KEY_MSG", "", "EXT_KEY_ST", "ID_AFX_PLAY", "TYPE_PLAY_FAIL", "TYPE_PLAY_SUCCESS", "ubcVideoError", "", "st", "", "message", "(Ljava/lang/Integer;Ljava/lang/String;)V", "ubcVideoSuccess", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AFXUBCManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void ubcVideoSuccess() {
            UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            try {
                JSONObject ubcValue = new JSONObject();
                ubcValue.put("type", "0");
                ubcManager.onEvent(AFXUBCManager.ID_AFX_PLAY, ubcValue);
            } catch (Exception e2) {
            }
        }

        public final void ubcVideoError(Integer st, String message) {
            UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            try {
                JSONObject ubcValue = new JSONObject();
                ubcValue.put("type", "1");
                if (!(st == null && message == null)) {
                    JSONObject ext = new JSONObject();
                    Integer num = st;
                    ext.put("st", st);
                    String str = message;
                    ext.put("msg", message);
                    ubcValue.put("ext", ext);
                }
                ubcManager.onEvent(AFXUBCManager.ID_AFX_PLAY, ubcValue);
            } catch (Exception e2) {
            }
        }
    }
}
