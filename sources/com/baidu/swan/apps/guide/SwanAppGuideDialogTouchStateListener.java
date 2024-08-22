package com.baidu.swan.apps.guide;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.ioc.SwanAppRuntime;

public class SwanAppGuideDialogTouchStateListener implements View.OnTouchListener {
    public static final float PRESSED_ALPHA_IN_DAY_MODE = 0.2f;
    public static final float PRESSED_ALPHA_IN_NIGHT_MODE = 0.5f;
    private View mTargetView;

    public SwanAppGuideDialogTouchStateListener() {
    }

    public SwanAppGuideDialogTouchStateListener(View targetView) {
        this.mTargetView = targetView;
    }

    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                View view2 = this.mTargetView;
                float f2 = 0.5f;
                if (view2 == null) {
                    if (!SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState()) {
                        f2 = 0.2f;
                    }
                    v.setAlpha(f2);
                    return false;
                }
                if (!SwanAppRuntime.getNightModeRuntime().getNightModeSwitcherState()) {
                    f2 = 0.2f;
                }
                view2.setAlpha(f2);
                return false;
            case 2:
                return false;
            default:
                View view3 = this.mTargetView;
                if (view3 == null) {
                    v.setAlpha(1.0f);
                    return false;
                }
                view3.setAlpha(1.0f);
                return false;
        }
    }
}
