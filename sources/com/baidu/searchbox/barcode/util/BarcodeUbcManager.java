package com.baidu.searchbox.barcode.util;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/barcode/util/BarcodeUbcManager;", "", "()V", "EXT_METHOD_INFO", "", "EXT_PARAMTER", "EXT_SIGNATURE", "EXT_SUB_TRADE", "EXT_TRADE", "EXT_TRADE_VALUE", "FROM_BARCODE_TEST", "ID_5622", "PAGE_BARCODE_TEST", "SOURCE_BARCODE_TEST", "TYPE_BARCODE_TEST", "VALUE_METHOD_CALLED_CHECK", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "onEvent", "", "signature", "parameter", "lib_barcode_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarcodeUbcManager.kt */
public final class BarcodeUbcManager {
    private static final String EXT_METHOD_INFO = "method_info";
    private static final String EXT_PARAMTER = "parameter";
    private static final String EXT_SIGNATURE = "signature";
    private static final String EXT_SUB_TRADE = "sub_trade";
    private static final String EXT_TRADE = "trade";
    private static final String EXT_TRADE_VALUE = "general";
    private static final String FROM_BARCODE_TEST = "visual";
    private static final String ID_5622 = "5622";
    public static final BarcodeUbcManager INSTANCE = new BarcodeUbcManager();
    public static final String PAGE_BARCODE_TEST = "camera_main_view";
    public static final String SOURCE_BARCODE_TEST = "home";
    private static final String TYPE_BARCODE_TEST = "info";
    private static final String VALUE_METHOD_CALLED_CHECK = "method_called_check";
    private static final UBCManager ubcManager = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE));

    private BarcodeUbcManager() {
    }

    public final void onEvent(String signature, String parameter) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        try {
            JSONObject values = new JSONObject();
            values.put("from", FROM_BARCODE_TEST);
            values.put("value", VALUE_METHOD_CALLED_CHECK);
            values.put("page", PAGE_BARCODE_TEST);
            values.put("source", "home");
            values.put("type", "info");
            JSONObject extParams = new JSONObject();
            JSONObject metohdInfo = new JSONObject();
            metohdInfo.put("signature", signature);
            metohdInfo.put("parameter", parameter);
            extParams.put(EXT_METHOD_INFO, metohdInfo);
            extParams.put(EXT_TRADE, "general");
            extParams.put(EXT_SUB_TRADE, "general");
            values.put("ext", extParams);
            UBCManager uBCManager = ubcManager;
            if (uBCManager != null) {
                uBCManager.onEvent(ID_5622, values);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
