package com.baidu.searchbox.favor.ioc;

import com.baidu.searchbox.favor.data.FavorModel;

public class DefaultFavorDBImpl implements IFavorDBIOC {
    public String getDBSuffixName() {
        return "_favorite.db";
    }

    public void modifyDataAfterSyncGetIfNeed(FavorModel model) {
    }
}
