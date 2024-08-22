package com.baidu.searchbox.music.scheme;

import android.content.Context;
import com.baidu.searchbox.music.bean.Song;
import com.baidu.searchbox.music.bean.Video;
import com.baidu.searchbox.music.bean.VideoInfo;
import com.baidu.searchbox.music.data.PlaylistModel;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.utils.PlaylistUtilsKt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/music/scheme/StartMusicPlayerAction$invokePlayerWithDefault$1", "Lcom/baidu/searchbox/music/scheme/IRequestListener;", "onFailed", "", "code", "", "onSucceed", "model", "Lcom/baidu/searchbox/music/data/PlaylistModel;", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StartMusicPlayerAction.kt */
public final class StartMusicPlayerAction$invokePlayerWithDefault$1 implements IRequestListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ UnitedSchemeEntity $entity;
    final /* synthetic */ CallbackHandler $handler;
    final /* synthetic */ MusicParams $invokeParams;
    final /* synthetic */ AtomicBoolean $isSearchMusic;
    final /* synthetic */ MusicSchemeModel $schemeModel;
    final /* synthetic */ StartMusicPlayerAction this$0;

    StartMusicPlayerAction$invokePlayerWithDefault$1(StartMusicPlayerAction $receiver, Context $context2, UnitedSchemeEntity $entity2, CallbackHandler $handler2, MusicSchemeModel $schemeModel2, AtomicBoolean $isSearchMusic2, MusicParams $invokeParams2) {
        this.this$0 = $receiver;
        this.$context = $context2;
        this.$entity = $entity2;
        this.$handler = $handler2;
        this.$schemeModel = $schemeModel2;
        this.$isSearchMusic = $isSearchMusic2;
        this.$invokeParams = $invokeParams2;
    }

    public void onSucceed(PlaylistModel model) {
        Video video;
        String videoLogLoc;
        String str;
        Video video2;
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.getSongList().isEmpty()) {
            this.this$0.onInvokeFailed(this.$context, this.$entity, this.$handler, 204, this.$schemeModel, model.getCurInvokeSong());
            return;
        }
        Song it = (Song) CollectionsKt.getOrNull(model.getSongList(), model.getCurrentIndex());
        if (it != null) {
            MusicSchemeModel musicSchemeModel = this.$schemeModel;
            MusicExtParams extParams = musicSchemeModel.getExtParams();
            String str2 = "";
            if (extParams != null) {
                VideoInfo videoInfo = it.videoInfo;
                if (videoInfo == null || (video2 = videoInfo.getVideo()) == null || (str = video2.getVideoLoc()) == null) {
                    str = str2;
                }
                extParams.setVideoLoc(str);
            }
            MusicExtParams extParams2 = musicSchemeModel.getExtParams();
            if (extParams2 != null) {
                VideoInfo videoInfo2 = it.videoInfo;
                if (!(videoInfo2 == null || (video = videoInfo2.getVideo()) == null || (videoLogLoc = video.getVideoLogLoc()) == null)) {
                    str2 = videoLogLoc;
                }
                extParams2.setVideoLogLoc(str2);
            }
        }
        if (this.$isSearchMusic.get()) {
            PlaylistUtilsKt.applyInitStrategy(model).subscribe(new StartMusicPlayerAction$invokePlayerWithDefault$1$$ExternalSyntheticLambda0(this.this$0, this.$invokeParams, this.$context, this.$entity, this.$handler, this.$schemeModel), new StartMusicPlayerAction$invokePlayerWithDefault$1$$ExternalSyntheticLambda1(this.this$0, this.$context, this.$entity, this.$handler, this.$schemeModel, model));
            return;
        }
        this.this$0.dismissLoading();
        this.this$0.onInvokeSucceed(this.$context, this.$entity, this.$handler, model, this.$schemeModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSucceed$lambda-1  reason: not valid java name */
    public static final void m1324onSucceed$lambda1(StartMusicPlayerAction this$02, MusicParams $invokeParams2, Context $context2, UnitedSchemeEntity $entity2, CallbackHandler $handler2, MusicSchemeModel $schemeModel2, PlaylistModel it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($invokeParams2, "$invokeParams");
        Intrinsics.checkNotNullParameter($context2, "$context");
        Intrinsics.checkNotNullParameter($entity2, "$entity");
        Intrinsics.checkNotNullParameter($schemeModel2, "$schemeModel");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (this$02.isInvokeVideo(it)) {
            $invokeParams2.setPlayTimestamp(0);
        }
        this$02.dismissLoading();
        this$02.onInvokeSucceed($context2, $entity2, $handler2, it, $schemeModel2);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSucceed$lambda-2  reason: not valid java name */
    public static final void m1325onSucceed$lambda2(StartMusicPlayerAction this$02, Context $context2, UnitedSchemeEntity $entity2, CallbackHandler $handler2, MusicSchemeModel $schemeModel2, PlaylistModel $model, Throwable it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($context2, "$context");
        Intrinsics.checkNotNullParameter($entity2, "$entity");
        Intrinsics.checkNotNullParameter($schemeModel2, "$schemeModel");
        Intrinsics.checkNotNullParameter($model, "$model");
        this$02.onInvokeFailed($context2, $entity2, $handler2, 204, $schemeModel2, $model.getCurInvokeSong());
    }

    public void onFailed(int code) {
        StartMusicPlayerAction.onInvokeFailed$default(this.this$0, this.$context, this.$entity, this.$handler, 203, this.$schemeModel, (ISong) null, 32, (Object) null);
    }
}
