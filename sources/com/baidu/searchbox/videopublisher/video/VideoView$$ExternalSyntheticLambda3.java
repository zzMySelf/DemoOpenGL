package com.baidu.searchbox.videopublisher.video;

import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoView$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ VideoView f$0;
    public final /* synthetic */ Ref.IntRef f$1;
    public final /* synthetic */ Ref.IntRef f$2;
    public final /* synthetic */ VideoBaseModel f$3;

    public /* synthetic */ VideoView$$ExternalSyntheticLambda3(VideoView videoView, Ref.IntRef intRef, Ref.IntRef intRef2, VideoBaseModel videoBaseModel) {
        this.f$0 = videoView;
        this.f$1 = intRef;
        this.f$2 = intRef2;
        this.f$3 = videoBaseModel;
    }

    public final void run() {
        VideoView.m7347updateVideoCoverRatio$lambda13(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
