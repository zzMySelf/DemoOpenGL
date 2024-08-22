package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;

public abstract class BoxAction<DispatcherT extends UnitedSchemeAbsDispatcher> {
    public final DispatcherT dispatcher;
    public final String name;

    public abstract boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public BoxAction(DispatcherT dispatcher2, String name2) {
        this.dispatcher = dispatcher2;
        this.name = name2;
    }
}
