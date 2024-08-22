package com.baidu.searchbox.favor.recyclebin;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.favor.IFavorList;
import com.baidu.searchbox.favor.IFavorManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/favor/IFavorList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorRecycleBinClearAllHandler.kt */
final class FavorRecycleBinClearAllHandler$mFavorListManager$2 extends Lambda implements Function0<IFavorList> {
    public static final FavorRecycleBinClearAllHandler$mFavorListManager$2 INSTANCE = new FavorRecycleBinClearAllHandler$mFavorListManager$2();

    FavorRecycleBinClearAllHandler$mFavorListManager$2() {
        super(0);
    }

    public final IFavorList invoke() {
        IFavorManager favorManager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
        if (favorManager != null) {
            return favorManager.getFavorList();
        }
        return null;
    }
}
