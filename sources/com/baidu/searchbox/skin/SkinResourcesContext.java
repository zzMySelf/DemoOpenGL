package com.baidu.searchbox.skin;

import android.content.res.Resources;
import com.baidu.android.common.others.java.Pair;
import com.baidu.searchbox.skin.ioc.ISkinResourcesContext;

public class SkinResourcesContext implements ISkinResourcesContext {
    public Resources getSkinResources() {
        return SkinManager.getInstance().getSkinResources();
    }

    public Pair<Resources, Integer> getResIdPair(Resources resources, int id) {
        return SkinManager.getInstance().getResIdPair(id);
    }

    public boolean checkSkinResInited() {
        return SkinManager.getInstance().checkSkinResInited();
    }
}
