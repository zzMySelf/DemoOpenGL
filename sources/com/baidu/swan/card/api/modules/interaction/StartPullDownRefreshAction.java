package com.baidu.swan.card.api.modules.interaction;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.pullrefresh.PullToRefreshBaseWebView;
import com.baidu.swan.card.api.action.base.SwanCardAction;
import com.baidu.swan.card.api.base.ICardApiDef;
import com.baidu.swan.card.api.base.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.card.page.SwanCardPage;
import com.baidu.swan.card.utils.SwanCardLog;

public class StartPullDownRefreshAction extends SwanCardAction {
    private static final String ACTION_TYPE = "/swanAPI/startPullDownRefresh";
    private static final long DELAY_MILL_IS = 100;
    private static final String MODULE_TAG = "startPullDownRefresh";

    public StartPullDownRefreshAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanCard swanCard) {
        if (swanCard != null && swanCard.isAppInvisible()) {
            if (DEBUG) {
                Log.d("SwanCardAction", "SwanCardAction does not supported when app is invisible.");
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (swanCard == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, ICardApiDef.MSG_CARD_IS_NULL);
            return false;
        } else {
            SwanCardPage swanCardPage = SwanCardManager.get().getCurCardPage(swanCard.getCardId());
            if (swanCardPage == null) {
                SwanCardLog.e(MODULE_TAG, "top cardPage null");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (swanCardPage.getPullToRefreshWebView() == null) {
                SwanCardLog.e(MODULE_TAG, "view is null");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                PullToRefreshBaseWebView refreshWebView = swanCardPage.getPullToRefreshWebView();
                if (refreshWebView == null) {
                    SwanCardLog.e(MODULE_TAG, "view is null");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (refreshWebView.isPreventPullToRefresh()) {
                    SwanCardLog.e(MODULE_TAG, "prevent pull to refresh");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    SwanCardLog.i(MODULE_TAG, "start pull refresh");
                    refreshWebView.doPullRefreshing(true, 100);
                    UnitedSchemeUtility.callCallback(handler, entity, 0);
                    return true;
                }
            }
        }
    }
}
