package com.baidu.searchbox.settings.teenager.util;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006J$\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/util/TeenagerUbcHelper;", "", "()V", "triggerUbc", "", "type", "", "page", "value", "from", "id", "ubc", "ubcWithoutFrom", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeenagerUbcHelper.kt */
public final class TeenagerUbcHelper {
    public static final TeenagerUbcHelper INSTANCE = new TeenagerUbcHelper();

    private TeenagerUbcHelper() {
    }

    public final void ubc(String type, String page, String value) {
        triggerUbc$default(this, type, page, value, (String) null, (String) null, 24, (Object) null);
    }

    public final void ubcWithoutFrom(String type, String page, String value) {
        triggerUbc$default(this, type, page, value, (String) null, (String) null, 16, (Object) null);
    }

    public static /* synthetic */ void triggerUbc$default(TeenagerUbcHelper teenagerUbcHelper, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        String str6;
        String str7;
        if ((i2 & 8) != 0) {
            str6 = "tool";
        } else {
            str6 = str4;
        }
        if ((i2 & 16) != 0) {
            str7 = "3298";
        } else {
            str7 = str5;
        }
        teenagerUbcHelper.triggerUbc(str, str2, str3, str6, str7);
    }

    public final void triggerUbc(String type, String page, String value, String from, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        JSONObject data = new JSONObject();
        CharSequence charSequence = type;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            data.put("type", type);
        }
        CharSequence charSequence2 = page;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            data.put("page", page);
        }
        CharSequence charSequence3 = value;
        if (!(charSequence3 == null || charSequence3.length() == 0)) {
            data.put("value", value);
        }
        CharSequence charSequence4 = from;
        if (charSequence4 == null || charSequence4.length() == 0) {
            z = true;
        }
        if (!z) {
            data.put("from", from);
        }
        Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
        ((UBCManager) service).onEvent(id, data);
    }
}
