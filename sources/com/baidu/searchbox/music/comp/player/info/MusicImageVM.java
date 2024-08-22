package com.baidu.searchbox.music.comp.player.info;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.music.MusicConstant;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u001dR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/music/comp/player/info/MusicImageVM;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "albumSourceIconUrl", "Landroidx/lifecycle/MutableLiveData;", "", "getAlbumSourceIconUrl", "()Landroidx/lifecycle/MutableLiveData;", "setAlbumSourceIconUrl", "(Landroidx/lifecycle/MutableLiveData;)V", "curSong", "Lcom/baidu/searchbox/music/bean/Song;", "getCurSong", "()Lcom/baidu/searchbox/music/bean/Song;", "setCurSong", "(Lcom/baidu/searchbox/music/bean/Song;)V", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getSwanScheme", "setExtraInfo", "", "song", "mode", "", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicImageVM.kt */
public final class MusicImageVM extends BaseViewModel {
    private MutableLiveData<String> albumSourceIconUrl = new MutableLiveData<>();
    private Song curSong;
    private UniqueId token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicImageVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final void setToken(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public final MutableLiveData<String> getAlbumSourceIconUrl() {
        return this.albumSourceIconUrl;
    }

    public final void setAlbumSourceIconUrl(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.albumSourceIconUrl = mutableLiveData;
    }

    public final Song getCurSong() {
        return this.curSong;
    }

    public final void setCurSong(Song song) {
        this.curSong = song;
    }

    public final void setExtraInfo(Song song, int mode) {
        this.curSong = song;
        MutableLiveData<String> mutableLiveData = this.albumSourceIconUrl;
        String str = null;
        CharSequence charSequence = song != null ? song.mAppDownlaodUrl : null;
        if (!(charSequence == null || charSequence.length() == 0) && song != null) {
            str = song.mAudioIconUrl;
        }
        mutableLiveData.setValue(str);
    }

    public final String getSwanScheme() {
        Song song = this.curSong;
        String str = "";
        String extra = song != null ? song.getExtra("appid", str) : null;
        if (extra != null) {
            str = extra;
        }
        String appid = str;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(MusicConstant.SWAN_SCHEME, Arrays.copyOf(new Object[]{appid}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
