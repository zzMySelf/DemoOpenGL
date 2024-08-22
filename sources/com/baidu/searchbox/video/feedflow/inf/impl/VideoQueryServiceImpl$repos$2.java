package com.baidu.searchbox.video.feedflow.inf.impl;

import com.baidu.searchbox.flowvideo.collection.repos.CollectionQueryRepository;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionQueryRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoQueryServiceImpl.kt */
final class VideoQueryServiceImpl$repos$2 extends Lambda implements Function0<CollectionQueryRepository> {
    public static final VideoQueryServiceImpl$repos$2 INSTANCE = new VideoQueryServiceImpl$repos$2();

    VideoQueryServiceImpl$repos$2() {
        super(0);
    }

    public final CollectionQueryRepository invoke() {
        return DIFactory.INSTANCE.makeCollectionQueryRepos();
    }
}
