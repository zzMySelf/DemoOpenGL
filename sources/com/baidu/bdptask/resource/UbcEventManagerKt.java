package com.baidu.bdptask.resource;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"ERROR_MSG_NULL_DATA", "", "ERROR_MSG_UNZIP", "EXCEPTION_ID_101", "", "EXCEPTION_ID_102", "EXCEPTION_ID_103", "EXCEPTION_ID_104", "EXCEPTION_ID_105", "EXCEPTION_ID_106", "EXCEPTION_ID_107", "FROM_TOOL", "KEY_ERRORID", "KEY_ERRORMSG", "SOURCE", "TYPE_DOWNLOAD", "TYPE_REQUEST", "UBC_ID", "downloadUbcEvent", "", "errorInfo", "Lcom/baidu/searchbox/pms/bean/ErrorInfo;", "mappingExceptionId", "reqUbcEvent", "ubcEvent", "type", "lib-bdptask-resource_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UbcEventManager.kt */
public final class UbcEventManagerKt {
    public static final String ERROR_MSG_NULL_DATA = "ResultData is null";
    public static final String ERROR_MSG_UNZIP = "unzip file failed";
    public static final int EXCEPTION_ID_101 = 101;
    private static final int EXCEPTION_ID_102 = 102;
    private static final int EXCEPTION_ID_103 = 103;
    private static final int EXCEPTION_ID_104 = 104;
    public static final int EXCEPTION_ID_105 = 105;
    private static final int EXCEPTION_ID_106 = 106;
    private static final int EXCEPTION_ID_107 = 107;
    private static final String FROM_TOOL = "tool";
    private static final String KEY_ERRORID = "errorId";
    private static final String KEY_ERRORMSG = "errorMsg";
    private static final String SOURCE = "timing";
    private static final String TYPE_DOWNLOAD = "download";
    private static final String TYPE_REQUEST = "request_update";
    private static final String UBC_ID = "1211";

    public static final void reqUbcEvent(ErrorInfo errorInfo) {
        ubcEvent("request_update", errorInfo);
    }

    public static final void downloadUbcEvent(ErrorInfo errorInfo) {
        ubcEvent("download", errorInfo);
    }

    private static final void ubcEvent(String type, ErrorInfo errorInfo) {
        try {
            String exceptionId = String.valueOf(mappingExceptionId(errorInfo));
            JSONObject data = new JSONObject();
            JSONObject $this$ubcEvent_u24lambda_u2d1 = data;
            $this$ubcEvent_u24lambda_u2d1.put("from", "tool");
            $this$ubcEvent_u24lambda_u2d1.put("type", type);
            $this$ubcEvent_u24lambda_u2d1.put("value", exceptionId);
            $this$ubcEvent_u24lambda_u2d1.put("source", "timing");
            JSONObject jSONObject = new JSONObject();
            JSONObject $this$ubcEvent_u24lambda_u2d1_u24lambda_u2d0 = jSONObject;
            $this$ubcEvent_u24lambda_u2d1_u24lambda_u2d0.put(KEY_ERRORID, exceptionId);
            $this$ubcEvent_u24lambda_u2d1_u24lambda_u2d0.put("errorMsg", errorInfo != null ? errorInfo.errorMsg : null);
            Unit unit = Unit.INSTANCE;
            $this$ubcEvent_u24lambda_u2d1.put("ext", jSONObject);
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent("1211", data);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static final int mappingExceptionId(ErrorInfo errorInfo) {
        Integer valueOf = errorInfo != null ? Integer.valueOf(errorInfo.code) : null;
        if (valueOf != null && valueOf.intValue() == 2101) {
            return 102;
        }
        if (valueOf != null && valueOf.intValue() == 2102) {
            return 102;
        }
        if (valueOf != null && valueOf.intValue() == 2103) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2105) {
            return 102;
        }
        if (valueOf != null && valueOf.intValue() == 2120) {
            return 102;
        }
        if (valueOf != null && valueOf.intValue() == 2201) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2202) {
            return 104;
        }
        if (valueOf != null && valueOf.intValue() == 2204) {
            return 107;
        }
        if (valueOf != null && valueOf.intValue() == 2205) {
            return 107;
        }
        if (valueOf != null && valueOf.intValue() == 2206) {
            return 107;
        }
        if (valueOf != null && valueOf.intValue() == 2207) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2208) {
            return 107;
        }
        if (valueOf != null && valueOf.intValue() == 2211) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2212) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2213) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2214) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2218) {
            return 103;
        }
        if (valueOf != null && valueOf.intValue() == 2407) {
            return 107;
        }
        if (errorInfo != null) {
            return errorInfo.code;
        }
        return 0;
    }
}
