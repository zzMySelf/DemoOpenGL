package com.baidu.searchbox.rewardsystem.bdptask;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.BDPTaskConfig;
import com.baidu.bdtask.TaskAppLifeCycle;
import com.baidu.bdtask.TaskHttpService;
import com.baidu.bdtask.TaskImageService;
import com.baidu.bdtask.TaskRouterService;
import com.baidu.bdtask.ui.components.common.UIPluginFactory;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.rewardsystem.operation.RewardTaskStatusManager;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;

public enum BDPTAskManager {
    INSTANCE;

    public void init() {
        if (!BDPTask.INSTANCE.hasInitialized()) {
            TaskDebugUtil.debugLog(" BDPTAskManager 【任务SDK start init】");
            BDPTask.INSTANCE.init(new BDPTaskConfig.Builder(AppRuntime.getAppContext()).setDebugAble(AppConfig.isDebug()).setDialogPlugin(UIPluginFactory.getDefaultDialogPlugin()).setToastUIPlugin(UIPluginFactory.getDefaultToastPlugin()).setHttpService(new TaskHttpService()).setSchemeService(getTaskRouterService()).setAppLifecycle(new TaskAppLifeCycle()).setImageService(new TaskImageService(AppRuntime.getAppContext())).build());
            RewardTaskStatusManager.getInstance().init();
        }
        RewardTaskStatusManager.getInstance().initAccount();
    }

    private TaskRouterService getTaskRouterService() {
        return BDPTaskRouter.INSTANCE.getTaskRouterService();
    }

    public void routerInvoke(String schema) {
        getTaskRouterService().onIntercept(schema, -1);
    }
}
