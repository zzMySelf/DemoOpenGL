package com.baidu.wallet.router;

import com.baidu.wallet.core.NoProguard;
import java.util.HashMap;

public abstract class RouterProvider implements NoProguard {
    public HashMap<String, RouterAction> mActions = new HashMap<>();
    public boolean mValid = true;

    public RouterProvider() {
        registerActions();
    }

    public RouterAction findAction(String str) {
        return this.mActions.get(str);
    }

    public boolean isValid() {
        return this.mValid;
    }

    public void registerAction(String str, RouterAction routerAction) {
        this.mActions.put(str, routerAction);
    }

    public abstract void registerActions();
}
