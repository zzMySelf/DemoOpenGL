package com.baidu.searchbox.music.ext.scheme;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseAction;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J'\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/music/ext/scheme/MusicPlayerScheme;", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseDispatcher;", "()V", "getDispatcherName", "", "getSubDispatcher", "Ljava/lang/Class;", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeAbsDispatcher;", "path", "invoke", "", "context", "Landroid/content/Context;", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "callbackHandler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicPlayerScheme.kt */
public final class MusicPlayerScheme extends UnitedSchemeBaseDispatcher {
    public MusicPlayerScheme() {
        regAction(new InvokeAlbumListAction(this));
        regAction(new GetPlayerStatusAction(this));
        regAction(new InvokeArtistDetailAction(this));
        regAction(new InvokeMyMusicAction(this));
        regAction(new InvokeAlbumDetailAction(this));
        regAction(new InvokeRelatedSongsDetailAction(this));
        regAction(new InvokeCommentAction(this));
        regAction(new AddSongToHistoryAction(this));
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String path) {
        return null;
    }

    public String getDispatcherName() {
        return MusicPlayerSchemeKt.MODULE_NAME;
    }

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler) {
        Uri uri = null;
        UnitedSchemeBaseAction schemeAction = (UnitedSchemeBaseAction) this.schemeActionMap.get(entity != null ? entity.getPath(false) : null);
        if (schemeAction != null) {
            return schemeAction.handle(context, entity, callbackHandler);
        }
        if (entity != null && !entity.isOnlyVerify()) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "unknown action");
        }
        if (MusicPlayerSchemeKt.DEBUG) {
            StringBuilder append = new StringBuilder().append("Uri: ");
            if (entity != null) {
                uri = entity.getUri();
            }
            Log.w("MusicPlayerScheme", append.append(uri).append(" is unknown").toString());
        }
        if (entity == null) {
            return false;
        }
        entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }
}
