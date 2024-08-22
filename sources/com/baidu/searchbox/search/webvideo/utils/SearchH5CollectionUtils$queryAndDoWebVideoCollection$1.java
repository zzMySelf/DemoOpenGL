package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.SearchUtils;
import com.baidu.searchbox.bookmark.BookMarkLoginUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.search.webvideo.model.NetDiskParamsInfo;
import com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/search/webvideo/utils/SearchH5CollectionUtils$queryAndDoWebVideoCollection$1", "Lcom/baidu/searchbox/bookmark/BookMarkLoginUtils$OnAllowBookMarkListener;", "allowUseBookMark", "", "loginFail", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5CollectionUtils.kt */
public final class SearchH5CollectionUtils$queryAndDoWebVideoCollection$1 implements BookMarkLoginUtils.OnAllowBookMarkListener {
    final /* synthetic */ boolean $isEventCollected;
    final /* synthetic */ Function1<Boolean, Unit> $onSelectedUiUpdate;
    final /* synthetic */ BaseVideoPlayer $videoPlayer;

    SearchH5CollectionUtils$queryAndDoWebVideoCollection$1(BaseVideoPlayer $videoPlayer2, boolean $isEventCollected2, Function1<? super Boolean, Unit> $onSelectedUiUpdate2) {
        this.$videoPlayer = $videoPlayer2;
        this.$isEventCollected = $isEventCollected2;
        this.$onSelectedUiUpdate = $onSelectedUiUpdate2;
    }

    public void allowUseBookMark() {
        ExecutorUtilsExt.postOnElastic(new SearchH5CollectionUtils$queryAndDoWebVideoCollection$1$$ExternalSyntheticLambda2(this.$videoPlayer, this.$isEventCollected, this.$onSelectedUiUpdate), "find url is Favored", 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: allowUseBookMark$lambda-2  reason: not valid java name */
    public static final void m2968allowUseBookMark$lambda2(BaseVideoPlayer $videoPlayer2, boolean $isEventCollected2, Function1 $onSelectedUiUpdate2) {
        NetDiskParamsInfo netDiskParamsInfo;
        boolean result;
        BaseVideoPlayer baseVideoPlayer = $videoPlayer2;
        boolean z = $isEventCollected2;
        Function1 function1 = $onSelectedUiUpdate2;
        Intrinsics.checkNotNullParameter(baseVideoPlayer, "$videoPlayer");
        Intrinsics.checkNotNullParameter(function1, "$onSelectedUiUpdate");
        BdVideoSeries videoSeries = $videoPlayer2.getVideoSeries();
        BdVideo video = videoSeries != null ? videoSeries.getSelectedVideo() : null;
        if (video != null) {
            String pageUrl = video.getSourceUrl();
            IFavorManager manager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(pageUrl, "pageUrl");
            boolean isStar = manager.isFavored(SearchH5CollectionUtils.getWebVideoUkey(pageUrl));
            if ((!z || !isStar) && (z || isStar)) {
                String title = video.getTitle();
                String source = SearchUtils.getDomainUrl(pageUrl);
                if (baseVideoPlayer instanceof SearchH5VideoPlayer) {
                    netDiskParamsInfo = ((SearchH5VideoPlayer) baseVideoPlayer).mNetDiskParamsInfo;
                } else {
                    netDiskParamsInfo = null;
                }
                FavorModel favor = SearchH5CollectionUtils.createVideoFavorModel(pageUrl, title, source, netDiskParamsInfo, $videoPlayer2.getVideoUrl(), String.valueOf($videoPlayer2.getDuration()));
                if (favor != null && !favor.shouldFilterUrl()) {
                    if (z) {
                        result = manager.addOrUpdateFavor(favor);
                    } else {
                        result = manager.deleteFavor(favor);
                    }
                    Ref.BooleanRef isFavored = new Ref.BooleanRef();
                    isFavored.element = z;
                    if (!result) {
                        isFavored.element = manager.isFavored(SearchH5CollectionUtils.getWebVideoUkey(pageUrl));
                    }
                    UiThreadUtils.getMainHandler().post(new SearchH5CollectionUtils$queryAndDoWebVideoCollection$1$$ExternalSyntheticLambda1(function1, isFavored));
                    return;
                }
                return;
            }
            UiThreadUtils.getMainHandler().post(new SearchH5CollectionUtils$queryAndDoWebVideoCollection$1$$ExternalSyntheticLambda0(function1, isStar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: allowUseBookMark$lambda-2$lambda-0  reason: not valid java name */
    public static final void m2969allowUseBookMark$lambda2$lambda0(Function1 $onSelectedUiUpdate2, boolean $isStar) {
        Intrinsics.checkNotNullParameter($onSelectedUiUpdate2, "$onSelectedUiUpdate");
        $onSelectedUiUpdate2.invoke(Boolean.valueOf($isStar));
    }

    /* access modifiers changed from: private */
    /* renamed from: allowUseBookMark$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2970allowUseBookMark$lambda2$lambda1(Function1 $onSelectedUiUpdate2, Ref.BooleanRef $isFavored) {
        Intrinsics.checkNotNullParameter($onSelectedUiUpdate2, "$onSelectedUiUpdate");
        Intrinsics.checkNotNullParameter($isFavored, "$isFavored");
        $onSelectedUiUpdate2.invoke(Boolean.valueOf($isFavored.element));
    }

    public void loginFail() {
    }
}
