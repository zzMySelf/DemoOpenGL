package com.baidu.searchbox.search.service;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.search.component.VideoTabBackResultComponent;
import com.baidu.searchbox.search.tab.implement.model.main.RecAfterPlayModel;
import com.baidu.searchbox.search.tab.implement.player.PlayerAttachInfo;
import com.baidu.searchbox.search.tab.implement.player.helper.ListPlayerHelper;
import com.baidu.searchbox.search.tab.implement.service.IBackResultService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/search/service/VideoTabBackResultService;", "Lcom/baidu/searchbox/search/tab/implement/service/IBackResultService;", "component", "Lcom/baidu/searchbox/search/component/VideoTabBackResultComponent;", "(Lcom/baidu/searchbox/search/component/VideoTabBackResultComponent;)V", "backScroll", "", "v", "Landroid/view/View;", "clearTag", "attachInfo", "Lcom/baidu/searchbox/search/tab/implement/player/PlayerAttachInfo;", "createBackSlideHelper", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "slideUp", "", "hasFocus", "totalPlayTimeInSecond", "", "playerHelper", "Lcom/baidu/searchbox/search/tab/implement/player/helper/ListPlayerHelper;", "recModel", "Lcom/baidu/searchbox/search/tab/implement/model/main/RecAfterPlayModel;", "lib_search_video_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabBackResultService.kt */
public final class VideoTabBackResultService implements IBackResultService {
    private VideoTabBackResultComponent component;

    public VideoTabBackResultService(VideoTabBackResultComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public void createBackSlideHelper(RecyclerView recyclerView) {
        this.component.createBackSlideHelper(recyclerView);
    }

    public void backScroll(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.component.backScroll(v);
    }

    public boolean slideUp(boolean hasFocus, double totalPlayTimeInSecond, ListPlayerHelper playerHelper, RecAfterPlayModel recModel) {
        return this.component.slideUp(hasFocus, totalPlayTimeInSecond, playerHelper, recModel);
    }

    public void clearTag(PlayerAttachInfo attachInfo) {
        this.component.clearTag(attachInfo);
    }
}
