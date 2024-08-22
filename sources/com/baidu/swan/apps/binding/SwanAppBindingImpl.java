package com.baidu.swan.apps.binding;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.apps.jsbridge.utils.SwanAppBindingDelegate;
import com.baidu.swan.apps.scheme.SwanAppActionBinding;

public final class SwanAppBindingImpl implements V8BindingProtocol {
    private SwanAppBindingDelegate mBindingDelegate = new SwanAppBindingDelegate();

    public void doBinding(AiBaseV8Engine engine, Context context) {
        UnitedSchemeMainDispatcher mainDispatcher = new UnitedSchemeMainDispatcher();
        this.mBindingDelegate.doBinding(engine, context, engine, mainDispatcher);
        SwanAppActionBinding.regActions(mainDispatcher);
    }

    public void attachActivityContext(Activity activity) {
        this.mBindingDelegate.attachContextToBridge(activity);
    }
}
