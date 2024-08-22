package com.baidu.searchbox.noveladapter.huodong;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.usergrowth.business.IRightsPopupWindowListener;
import com.baidu.searchbox.usergrowth.business.IUserGrowthRights;
import com.baidu.searchbox.usergrowth.business.UserGrowthRightsModel;

public class NovelHuodongWrapper implements NoProGuard {
    private static final String USER_GROWTH_RIGHTS_SCENE = "novel";

    public static void checkUserGrowthRights(String rightsInvoke, String rightsId, String rightsPage, final NovelRightsInvokeCallback callback) {
        IUserGrowthRights userGrowthRightsService = (IUserGrowthRights) ServiceManager.getService(IUserGrowthRights.Companion.getSERVICE_REFERENCE());
        String rightsFrom = "default";
        if ("1".equals(rightsInvoke)) {
            rightsFrom = "wise";
        } else if ("2".equals(rightsInvoke)) {
            rightsFrom = "push";
        }
        if (userGrowthRightsService != null) {
            UserGrowthRightsModel rightsModel = new UserGrowthRightsModel();
            rightsModel.setScene("novel");
            rightsModel.setRightsId(rightsId);
            rightsModel.setFrom(rightsFrom);
            rightsModel.setPage(rightsPage);
            userGrowthRightsService.tryShowRightsPopupWindow(rightsModel, new IRightsPopupWindowListener() {
                public void onShowResult(boolean success) {
                }

                public void onDismiss() {
                }

                public void onRightsReceiveResult(boolean success, String errCode, String errMsg) {
                    NovelRightsInvokeCallback novelRightsInvokeCallback = NovelRightsInvokeCallback.this;
                    if (novelRightsInvokeCallback != null) {
                        novelRightsInvokeCallback.onRightsReceiveResult(success);
                    }
                }
            });
        }
    }
}
