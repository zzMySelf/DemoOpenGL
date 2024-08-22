package com.baidu.browser.components.commonmenu.advancefilter;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.browser.components.commonmenu.CommonMenuConstantsKt;
import com.baidu.search.basic.utils.JsNativeLogUtil;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseAction;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AdvanceFilterAction extends UnitedSchemeBaseAction {
    private static final String ACTION_MODIFY = "modify";
    private static final boolean DEBUG = AppConfig.isDebug();
    private final String KEY_GPC = CommonMenuConstantsKt.GPC;
    private final String KEY_PARAMS = "params";
    private final String KEY_SITE = "site";
    private final String KEY_SITETYPE = "siteType";
    private String gpc;
    private String site;
    private String siteType;

    public AdvanceFilterAction(UnitedSchemeAbsDispatcher Dispatcher) {
        super(Dispatcher);
    }

    public String getActionName() {
        return ACTION_MODIFY;
    }

    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JsNativeLogUtil.log(unitedSchemeEntity);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.size() == 0 || TextUtils.isEmpty(params.get("params"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject paramJson = new JSONObject(params.get("params"));
            this.site = paramJson.optString("site");
            this.gpc = paramJson.optString(CommonMenuConstantsKt.GPC);
            this.siteType = paramJson.optString("siteType");
            BdEventBus.Companion.getDefault().post(new AdvanceFilterEvent(this.site, this.siteType, this.gpc, 1));
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return true;
    }
}
