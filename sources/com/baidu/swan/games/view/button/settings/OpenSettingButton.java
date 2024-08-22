package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.games.view.button.base.ApiButton;

public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    public OpenSettingButton(Context context, EventTargetImpl eventTarget) {
        super(context, eventTarget);
    }

    public void onClick(View v) {
        startSettingFragment();
    }

    public void startSettingFragment() {
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager == null) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.aiapps_open_fragment_failed_toast).showToast();
        } else {
            manager.createTransaction("navigateTo").setCustomAnimations(ISwanPageManager.ANIM_ENTER, ISwanPageManager.ANIM_HOLD).pushFragment("authority", (SwanAppPageParam) null).commit();
        }
    }
}
