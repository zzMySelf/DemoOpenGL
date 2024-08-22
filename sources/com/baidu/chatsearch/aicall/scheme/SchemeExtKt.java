package com.baidu.chatsearch.aicall.scheme;

import android.webkit.URLUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000f"}, d2 = {"doCallback", "", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "code", "", "message", "", "data", "Lorg/json/JSONObject;", "validUrlParam", "", "urlStr", "lib-chatsearch-aicall-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchemeExt.kt */
public final class SchemeExtKt {
    public static /* synthetic */ void doCallback$default(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i2, String str, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str = null;
        }
        if ((i3 & 16) != 0) {
            jSONObject = null;
        }
        doCallback(callbackHandler, unitedSchemeEntity, i2, str, jSONObject);
    }

    public static final void doCallback(CallbackHandler handler, UnitedSchemeEntity entity, int code, String message, JSONObject data) {
        if (message == null) {
            UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(data == null ? new JSONObject() : data, code));
        } else {
            UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(data == null ? new JSONObject() : data, code, message));
        }
    }

    public static final boolean validUrlParam(String urlStr) {
        CharSequence charSequence = urlStr;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        return URLUtil.isValidUrl(urlStr);
    }
}
