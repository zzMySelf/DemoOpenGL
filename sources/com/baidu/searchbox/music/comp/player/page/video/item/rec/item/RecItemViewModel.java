package com.baidu.searchbox.music.comp.player.page.video.item.rec.item;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.music.MusicPlayState;
import com.baidu.searchbox.music.bean.Video;
import com.baidu.searchbox.music.bean.VideoInfo;
import com.baidu.searchbox.music.ext.model.SongFactory;
import com.baidu.searchbox.music.utils.TimeUtils;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/music/comp/player/page/video/item/rec/item/RecItemViewModel;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemViewModel;", "Lcom/baidu/searchbox/music/comp/player/page/video/item/rec/item/RecItemModel;", "()V", "cover", "Landroidx/lifecycle/MutableLiveData;", "", "getCover", "()Landroidx/lifecycle/MutableLiveData;", "durationDesc", "getDurationDesc", "isSameVideoInPlay", "", "isShowPlayIcon", "isStartWaving", "playCountDesc", "getPlayCountDesc", "titleDesc", "getTitleDesc", "isSameVideoInPlaying", "model", "setModel", "", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecItemViewModel.kt */
public final class RecItemViewModel extends BaseExtItemViewModel<RecItemModel> {
    private final MutableLiveData<String> cover = new MutableLiveData<>();
    private final MutableLiveData<String> durationDesc = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isSameVideoInPlay = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isShowPlayIcon = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isStartWaving = new MutableLiveData<>();
    private final MutableLiveData<String> playCountDesc = new MutableLiveData<>();
    private final MutableLiveData<String> titleDesc = new MutableLiveData<>();

    public final MutableLiveData<String> getCover() {
        return this.cover;
    }

    public final MutableLiveData<String> getPlayCountDesc() {
        return this.playCountDesc;
    }

    public final MutableLiveData<String> getDurationDesc() {
        return this.durationDesc;
    }

    public final MutableLiveData<String> getTitleDesc() {
        return this.titleDesc;
    }

    public final MutableLiveData<Boolean> isShowPlayIcon() {
        return this.isShowPlayIcon;
    }

    public final MutableLiveData<Boolean> isSameVideoInPlay() {
        return this.isSameVideoInPlay;
    }

    public final MutableLiveData<Boolean> isStartWaving() {
        return this.isStartWaving;
    }

    public void setModel(RecItemModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        Video $this$setModel_u24lambda_u2d0 = model.getVideo();
        this.cover.setValue($this$setModel_u24lambda_u2d0.getPosterUrl());
        this.playCountDesc.setValue($this$setModel_u24lambda_u2d0.getPlayCount());
        this.durationDesc.setValue(TimeUtils.formatTime(((long) $this$setModel_u24lambda_u2d0.getDuration()) * 1000));
        this.titleDesc.setValue($this$setModel_u24lambda_u2d0.getTitle());
        boolean z = true;
        if (isSameVideoInPlaying(model)) {
            this.isShowPlayIcon.setValue(false);
            this.isSameVideoInPlay.setValue(true);
            MutableLiveData<Boolean> mutableLiveData = this.isStartWaving;
            if (MusicManager.Companion.get().getPlayStatus() != MusicPlayState.PLAY) {
                z = false;
            }
            mutableLiveData.setValue(Boolean.valueOf(z));
            return;
        }
        this.isShowPlayIcon.setValue(true);
        this.isSameVideoInPlay.setValue(false);
        this.isStartWaving.setValue(false);
    }

    private final boolean isSameVideoInPlaying(RecItemModel model) {
        if (Intrinsics.areEqual((Object) SongFactory.unwrap(model.getOriSong()), (Object) MusicManager.Companion.get().getPlayingSong())) {
            VideoInfo videoInfo = model.getOriSong().getVideoInfo();
            if (Intrinsics.areEqual((Object) videoInfo != null ? videoInfo.getVideo() : null, (Object) model.getVideo())) {
                return true;
            }
        }
        return false;
    }
}
