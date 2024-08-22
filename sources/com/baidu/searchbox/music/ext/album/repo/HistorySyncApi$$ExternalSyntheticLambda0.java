package com.baidu.searchbox.music.ext.album.repo;

import java.util.List;
import rx.Single;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HistorySyncApi$$ExternalSyntheticLambda0 implements Single.OnSubscribe {
    public final /* synthetic */ HistorySyncApi f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ HistorySyncApi$$ExternalSyntheticLambda0(HistorySyncApi historySyncApi, List list) {
        this.f$0 = historySyncApi;
        this.f$1 = list;
    }

    public final void call(Object obj) {
        HistorySyncApi.m900onSongListSync$lambda4(this.f$0, this.f$1, (SingleSubscriber) obj);
    }
}
