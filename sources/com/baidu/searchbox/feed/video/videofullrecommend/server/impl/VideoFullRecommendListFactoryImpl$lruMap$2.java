package com.baidu.searchbox.feed.video.videofullrecommend.server.impl;

import android.util.LruCache;
import com.baidu.searchbox.video.template.fullrecommend.VideoFullRecommendModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/util/LruCache;", "", "Lcom/baidu/searchbox/video/template/fullrecommend/VideoFullRecommendModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFullRecommendListFactoryImpl.kt */
final class VideoFullRecommendListFactoryImpl$lruMap$2 extends Lambda implements Function0<LruCache<String, VideoFullRecommendModel>> {
    public static final VideoFullRecommendListFactoryImpl$lruMap$2 INSTANCE = new VideoFullRecommendListFactoryImpl$lruMap$2();

    VideoFullRecommendListFactoryImpl$lruMap$2() {
        super(0);
    }

    public final LruCache<String, VideoFullRecommendModel> invoke() {
        return new LruCache<>(10);
    }
}
