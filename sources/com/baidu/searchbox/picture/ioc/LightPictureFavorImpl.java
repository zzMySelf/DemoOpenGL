package com.baidu.searchbox.picture.ioc;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bookmark.BookMarkLoginUtils;
import com.baidu.searchbox.discovery.picture.ioc.FavorQueryResult;
import com.baidu.searchbox.discovery.picture.ioc.ILightPictureFavor;
import com.baidu.searchbox.favor.IFavorManager;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/picture/ioc/LightPictureFavorImpl;", "Lcom/baidu/searchbox/discovery/picture/ioc/ILightPictureFavor;", "()V", "doFavor", "", "context", "Landroid/content/Context;", "content", "", "uKey", "ubcJo", "Lorg/json/JSONObject;", "callback", "Lcom/baidu/searchbox/discovery/picture/ioc/FavorQueryResult;", "isFavor", "", "lib-atlas-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LightPictureFavorImpl.kt */
public final class LightPictureFavorImpl implements ILightPictureFavor {
    public boolean isFavor(String uKey) {
        IFavorManager manager;
        CharSequence charSequence = uKey;
        if (!(charSequence == null || charSequence.length() == 0) && (manager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)) != null) {
            return manager.isFavored(uKey);
        }
        return false;
    }

    public void doFavor(Context context, String content, String uKey, JSONObject ubcJo, FavorQueryResult callback) {
        if (context != null) {
            CharSequence charSequence = content;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                CharSequence charSequence2 = uKey;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    z = true;
                }
                if (!z) {
                    BookMarkLoginUtils.addBookMark(context, 5, new LightPictureFavorImpl$doFavor$1(content, uKey, ubcJo, context, callback));
                }
            }
        }
    }
}
