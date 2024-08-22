package com.baidu.searchbox.music.ext.comment.comp.songcard;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.bean.Singer;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.playback.PlaybackProgress;
import com.baidu.searchbox.music.ext.album.playback.PlaybackRepo;
import com.baidu.searchbox.music.ext.album.playback.PlaybackState;
import com.baidu.searchbox.music.ext.album.playback.playlist.db.PlaylistColumns;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.model.SongExtraKt;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010'\u001a\u00020\u0012J\b\u0010(\u001a\u00020\u0013H\u0002J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000bJ\b\u0010,\u001a\u00020*H\u0014J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0013J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u0013H\u0002J\b\u00101\u001a\u00020*H\u0002J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000bH\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR+\u0010\u0018\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00130\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\t¨\u00065"}, d2 = {"Lcom/baidu/searchbox/music/ext/comment/comp/songcard/SongCardViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "artistName", "Landroidx/lifecycle/MutableLiveData;", "", "getArtistName", "()Landroidx/lifecycle/MutableLiveData;", "commentSong", "Lcom/baidu/searchbox/music/ext/model/ISong;", "getCommentSong", "()Lcom/baidu/searchbox/music/ext/model/ISong;", "setCommentSong", "(Lcom/baidu/searchbox/music/ext/model/ISong;)V", "commentSongPosition", "Lkotlin/Pair;", "", "", "getCommentSongPosition", "curSong", "isCommentSong", "isCommentSongPlaying", "lyricData", "Lkotlin/Triple;", "getLyricData", "musicTag", "getMusicTag", "musicTagBgRes", "", "getMusicTagBgRes", "playbackSubscription", "Lrx/subscriptions/CompositeSubscription;", "playingSongSubscription", "songCoverUrl", "getSongCoverUrl", "songName", "getSongName", "getCommentSongProgress", "isCurCommentSong", "loadData", "", "song", "onCleared", "onNightModeChange", "isNight", "setCommentSongPlayState", "isPlaying", "stopReceivePlayback", "subscribePlayback", "subscribePlayingSongChanged", "updateMusicTagBg", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SongCardViewModel.kt */
public final class SongCardViewModel extends BaseViewModel {
    private final MutableLiveData<String> artistName = new MutableLiveData<>();
    private ISong commentSong;
    private final MutableLiveData<Pair<Long, Boolean>> commentSongPosition = new MutableLiveData<>();
    private ISong curSong;
    private final MutableLiveData<Boolean> isCommentSong = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isCommentSongPlaying = new MutableLiveData<>();
    private final MutableLiveData<Triple<String, String, Boolean>> lyricData = new MutableLiveData<>();
    private final MutableLiveData<String> musicTag = new MutableLiveData<>();
    private final MutableLiveData<Integer> musicTagBgRes = new MutableLiveData<>();
    private final CompositeSubscription playbackSubscription = new CompositeSubscription();
    private final CompositeSubscription playingSongSubscription = new CompositeSubscription();
    private final MutableLiveData<String> songCoverUrl = new MutableLiveData<>();
    private final MutableLiveData<String> songName = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SongCardViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        subscribePlayingSongChanged();
    }

    public final MutableLiveData<String> getSongName() {
        return this.songName;
    }

    public final MutableLiveData<String> getSongCoverUrl() {
        return this.songCoverUrl;
    }

    public final MutableLiveData<String> getArtistName() {
        return this.artistName;
    }

    public final MutableLiveData<Triple<String, String, Boolean>> getLyricData() {
        return this.lyricData;
    }

    public final MutableLiveData<Boolean> isCommentSongPlaying() {
        return this.isCommentSongPlaying;
    }

    public final MutableLiveData<Boolean> isCommentSong() {
        return this.isCommentSong;
    }

    public final MutableLiveData<Pair<Long, Boolean>> getCommentSongPosition() {
        return this.commentSongPosition;
    }

    public final MutableLiveData<String> getMusicTag() {
        return this.musicTag;
    }

    public final MutableLiveData<Integer> getMusicTagBgRes() {
        return this.musicTagBgRes;
    }

    public final ISong getCommentSong() {
        return this.commentSong;
    }

    public final void setCommentSong(ISong iSong) {
        this.commentSong = iSong;
    }

    public final void loadData(ISong song) {
        Intrinsics.checkNotNullParameter(song, "song");
        ISong $this$loadData_u24lambda_u2d0 = song;
        this.songName.setValue($this$loadData_u24lambda_u2d0.getName());
        this.songCoverUrl.setValue($this$loadData_u24lambda_u2d0.getAlbumInfo().getCover());
        MutableLiveData<String> mutableLiveData = this.artistName;
        List<Singer> singers = $this$loadData_u24lambda_u2d0.getSingers();
        Intrinsics.checkNotNullExpressionValue(singers, PlaylistColumns.SINGERS);
        mutableLiveData.setValue(CollectionsKt.joinToString$default(singers, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SongCardViewModel$loadData$1$1.INSTANCE, 30, (Object) null));
        this.lyricData.setValue(new Triple(SongExtraKt.getPlayLyric($this$loadData_u24lambda_u2d0), $this$loadData_u24lambda_u2d0.getLyricCode(), Boolean.valueOf(SongExtraKt.isEnableLyricAnchor($this$loadData_u24lambda_u2d0))));
        this.commentSong = $this$loadData_u24lambda_u2d0;
        setCommentSongPlayState(PlaybackRepo.INSTANCE.isPlaying());
        boolean $this$loadData_u24lambda_u2d1 = isCurCommentSong();
        this.isCommentSong.setValue(Boolean.valueOf($this$loadData_u24lambda_u2d1));
        if ($this$loadData_u24lambda_u2d1) {
            subscribePlayback();
        }
        this.curSong = PlaybackRepo.INSTANCE.getPlayingSong();
        this.musicTag.setValue(AppRuntime.getAppContext().getString(song.canInvokePlayer() || SongExtraKt.isSupportNAPlay(song) ? R.string.search_music_tag_na : R.string.search_music_tag_net));
        updateMusicTagBg(song);
    }

    public final long getCommentSongProgress() {
        PlaybackProgress progress;
        if (!Intrinsics.areEqual((Object) PlaybackRepo.INSTANCE.getPlayingSong(), (Object) this.commentSong) || (progress = PlaybackRepo.INSTANCE.getProgress()) == null) {
            return 0;
        }
        return (long) progress.getPosition();
    }

    public final void onNightModeChange(boolean isNight) {
        ISong $this$onNightModeChange_u24lambda_u2d2 = this.commentSong;
        if ($this$onNightModeChange_u24lambda_u2d2 != null) {
            updateMusicTagBg($this$onNightModeChange_u24lambda_u2d2);
        }
    }

    private final void updateMusicTagBg(ISong song) {
        Integer num;
        boolean canPlay = song.canInvokePlayer() || SongExtraKt.isSupportNAPlay(song);
        MutableLiveData<Integer> mutableLiveData = this.musicTagBgRes;
        if (canPlay) {
            num = Integer.valueOf(R.drawable.list_music_na_tag_bg);
        } else {
            num = Integer.valueOf(R.drawable.list_music_net_tag_bg);
        }
        mutableLiveData.setValue(num);
    }

    private final boolean isCurCommentSong() {
        return Intrinsics.areEqual((Object) PlaybackRepo.INSTANCE.getPlayingSong(), (Object) this.commentSong);
    }

    private final void setCommentSongPlayState(boolean isPlaying) {
        this.isCommentSongPlaying.setValue(Boolean.valueOf(isPlaying && isCurCommentSong()));
    }

    private final void subscribePlayback() {
        this.playbackSubscription.clear();
        this.playbackSubscription.add(PlaybackRepo.INSTANCE.getProgressChange().subscribe(new SongCardViewModel$$ExternalSyntheticLambda2(this), (Action1<Throwable>) new SongCardViewModel$$ExternalSyntheticLambda3()));
        this.playbackSubscription.add(PlaybackRepo.INSTANCE.getPlayStateChange().subscribe(new SongCardViewModel$$ExternalSyntheticLambda4(this), (Action1<Throwable>) new SongCardViewModel$$ExternalSyntheticLambda5()));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayback$lambda-3  reason: not valid java name */
    public static final void m1014subscribePlayback$lambda3(SongCardViewModel this$0, PlaybackProgress curProgress) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isCurCommentSong()) {
            this$0.commentSongPosition.setValue(new Pair(Long.valueOf((long) curProgress.getPosition()), true));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayback$lambda-4  reason: not valid java name */
    public static final void m1015subscribePlayback$lambda4(Throwable it) {
        if (SongCardViewModelKt.DEBUG) {
            it.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayback$lambda-5  reason: not valid java name */
    public static final void m1016subscribePlayback$lambda5(SongCardViewModel this$0, PlaybackState curState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setCommentSongPlayState(curState == PlaybackState.PLAYING);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayback$lambda-6  reason: not valid java name */
    public static final void m1017subscribePlayback$lambda6(Throwable it) {
        if (SongCardViewModelKt.DEBUG) {
            it.printStackTrace();
        }
    }

    private final void stopReceivePlayback() {
        this.playbackSubscription.clear();
    }

    private final void subscribePlayingSongChanged() {
        this.playingSongSubscription.add(PlaybackRepo.INSTANCE.getPlayingSongChange().subscribe(new SongCardViewModel$$ExternalSyntheticLambda0(this), (Action1<Throwable>) new SongCardViewModel$$ExternalSyntheticLambda1()));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayingSongChanged$lambda-7  reason: not valid java name */
    public static final void m1018subscribePlayingSongChanged$lambda7(SongCardViewModel this$0, ISong newSong) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isCurSongComment = Intrinsics.areEqual((Object) this$0.commentSong, (Object) this$0.curSong);
        boolean isNewSongComment = Intrinsics.areEqual((Object) this$0.commentSong, (Object) newSong);
        if (isCurSongComment && !isNewSongComment) {
            this$0.stopReceivePlayback();
            this$0.isCommentSong.setValue(false);
            this$0.commentSongPosition.setValue(new Pair(0L, false));
        } else if (!isCurSongComment && isNewSongComment) {
            this$0.subscribePlayback();
            this$0.isCommentSong.setValue(true);
            this$0.commentSongPosition.setValue(new Pair(0L, false));
        }
        this$0.setCommentSongPlayState(PlaybackRepo.INSTANCE.isPlaying());
        this$0.curSong = newSong;
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribePlayingSongChanged$lambda-8  reason: not valid java name */
    public static final void m1019subscribePlayingSongChanged$lambda8(Throwable it) {
        if (SongCardViewModelKt.DEBUG) {
            it.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.playingSongSubscription.unsubscribe();
        this.playbackSubscription.unsubscribe();
    }
}
