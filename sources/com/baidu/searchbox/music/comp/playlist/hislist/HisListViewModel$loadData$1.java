package com.baidu.searchbox.music.comp.playlist.hislist;

import android.util.Log;
import com.baidu.searchbox.music.ext.album.recommendcollect.status.ReqStatus;
import com.baidu.searchbox.music.scheme.StartMusicPlayerActionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lcom/baidu/searchbox/music/comp/playlist/hislist/HisResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HisListViewModel.kt */
final class HisListViewModel$loadData$1 extends Lambda implements Function1<HisResult, Unit> {
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ HisListViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HisListViewModel$loadData$1(HisListViewModel hisListViewModel, boolean z) {
        super(1);
        this.this$0 = hisListViewModel;
        this.$isLoadMore = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((HisResult) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(HisResult result) {
        if (result != null) {
            this.this$0.updateDataList(result.getList(), result.getCanPlayNum(), this.$isLoadMore);
            if (!this.$isLoadMore) {
                this.this$0.getReqStatus().setValue(ReqStatus.SUCCEED);
            }
            this.this$0.getHasMore().setValue(Boolean.valueOf(result.getHasMore()));
            if (StartMusicPlayerActionKt.getDEBUG()) {
                Log.d("HisListVM", "loadData Succeed");
                return;
            }
            return;
        }
        if (this.$isLoadMore) {
            this.this$0.getLoadMoreErr().setValue(true);
        } else {
            this.this$0.getReqStatus().setValue(ReqStatus.ERROR);
        }
        if (StartMusicPlayerActionKt.getDEBUG()) {
            Log.d("HisListVM", "loadData Failed");
        }
    }
}
