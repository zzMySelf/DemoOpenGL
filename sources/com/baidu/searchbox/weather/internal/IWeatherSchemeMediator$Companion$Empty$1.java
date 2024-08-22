package com.baidu.searchbox.weather.internal;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/weather/internal/IWeatherSchemeMediator$Companion$Empty$1", "Lcom/baidu/searchbox/weather/internal/IWeatherSchemeMediator;", "handleScheme", "", "context", "Landroid/content/Context;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "lib-weather-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWeatherSchemeMediator.kt */
public final class IWeatherSchemeMediator$Companion$Empty$1 implements IWeatherSchemeMediator {
    IWeatherSchemeMediator$Companion$Empty$1() {
    }

    public boolean handleScheme(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), 101));
        return false;
    }
}
