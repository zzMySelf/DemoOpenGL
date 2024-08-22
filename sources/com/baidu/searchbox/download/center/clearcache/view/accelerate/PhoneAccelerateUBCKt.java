package com.baidu.searchbox.download.center.clearcache.view.accelerate;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a$\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\u00012\b\b\u0001\u0010\u000f\u001a\u00020\u00012\b\b\u0003\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"KEY_UBC_FROM", "", "KEY_UBC_TYPE", "KEY_UBC_VALUE", "PHONE_ACCELERATE_UBC_ID", "VALUE_ADD_WIDGET_FAILURE", "VALUE_ADD_WIDGET_SUCCESS", "VALUE_OPEN_FROM_CLEAN", "VALUE_PHONE_ACCELERATE_CLICK_ADD_WIDGET", "VALUE_PHONE_ACCELERATE_CLICK_CLEAN", "VALUE_PHONE_ACCELERATE_SHOW", "VALUE_PHONE_WIDGET_DIALOG_SHOW", "phoneAccelerateUBC", "", "type", "from", "value", "lib-clearcache-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneAccelerateUBC.kt */
public final class PhoneAccelerateUBCKt {
    private static final String KEY_UBC_FROM = "from";
    private static final String KEY_UBC_TYPE = "type";
    private static final String KEY_UBC_VALUE = "value";
    private static final String PHONE_ACCELERATE_UBC_ID = "5866";
    public static final String VALUE_ADD_WIDGET_FAILURE = "0";
    public static final String VALUE_ADD_WIDGET_SUCCESS = "1";
    public static final String VALUE_OPEN_FROM_CLEAN = "clean";
    public static final String VALUE_PHONE_ACCELERATE_CLICK_ADD_WIDGET = "click_add_widget";
    public static final String VALUE_PHONE_ACCELERATE_CLICK_CLEAN = "click_clean";
    public static final String VALUE_PHONE_ACCELERATE_SHOW = "show";
    public static final String VALUE_PHONE_WIDGET_DIALOG_SHOW = "widget_dialog_show";

    public static /* synthetic */ void phoneAccelerateUBC$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        phoneAccelerateUBC(str, str2, str3);
    }

    public static final void phoneAccelerateUBC(String type, String from, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject obj = new JSONObject();
            boolean z = true;
            if (type.length() > 0) {
                obj.put("type", type);
            }
            if (from.length() > 0) {
                obj.put("from", from);
            }
            if (value.length() <= 0) {
                z = false;
            }
            if (z) {
                obj.put("value", value);
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(PHONE_ACCELERATE_UBC_ID, obj.toString());
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
