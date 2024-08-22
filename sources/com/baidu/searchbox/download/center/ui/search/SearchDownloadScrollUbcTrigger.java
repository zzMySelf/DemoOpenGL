package com.baidu.searchbox.download.center.ui.search;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.ui.search.adapter.RecommendAdapter;
import com.baidu.searchbox.download.center.ui.search.adapter.SearchResultAdapter;
import com.baidu.searchbox.download.center.ui.search.viewholder.SearchBaseHolder;
import com.baidu.searchbox.ugc.utils.TextViewExtKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0016J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0011J\"\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/SearchDownloadScrollUbcTrigger;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "()V", "TAG", "", "isScrollDown", "", "mFirstTrulyVisiblePosition", "", "mLastTrulyVisiblePosition", "mRecommendUbcHistoryRecordList", "", "getMRecommendUbcHistoryRecordList", "()Ljava/util/List;", "mRecommendUbcHistoryRecordList$delegate", "Lkotlin/Lazy;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "log", "", "msg", "isError", "onScrollStateChanged", "recyclerView", "newState", "onScrolled", "dx", "dy", "refreshDataStatistic", "ubcStatistic", "fromIndex", "toIndex", "from", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchDownloadScrollUbcTrigger.kt */
public final class SearchDownloadScrollUbcTrigger extends RecyclerView.OnScrollListener {
    private final String TAG = "SearchDownloadScrollUbc";
    private boolean isScrollDown;
    private int mFirstTrulyVisiblePosition;
    private int mLastTrulyVisiblePosition;
    private final Lazy mRecommendUbcHistoryRecordList$delegate = LazyKt.lazy(SearchDownloadScrollUbcTrigger$mRecommendUbcHistoryRecordList$2.INSTANCE);
    private RecyclerView mRecyclerView;

    private final List<String> getMRecommendUbcHistoryRecordList() {
        return (List) this.mRecommendUbcHistoryRecordList$delegate.getValue();
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        this.mRecyclerView = recyclerView;
        StringBuilder append = new StringBuilder().append("onScrollStateChanged: ").append(newState).append(" , recyclerView.adapter = ");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        log$default(this, append.append(adapter != null ? adapter.getClass() : null).toString(), false, 2, (Object) null);
        if (newState == 0 && recyclerView.getLayoutManager() != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int firstTrulyVisibleItemPosition = SearchUbcHelper.getFirstTrulyVisibleItemPosition(linearLayoutManager);
                int lastTrulyVisiblePosition = SearchUbcHelper.getLastTrulyVisibleItemPosition(linearLayoutManager);
                log$default(this, "onScrollStateChanged: \n firstTrulyVisibleItemPosition = " + firstTrulyVisibleItemPosition + " , lastTrulyVisiblePosition = " + lastTrulyVisiblePosition, false, 2, (Object) null);
                boolean updated = false;
                if (this.mFirstTrulyVisiblePosition != firstTrulyVisibleItemPosition) {
                    this.mFirstTrulyVisiblePosition = firstTrulyVisibleItemPosition;
                    updated = true;
                }
                if (this.mLastTrulyVisiblePosition != lastTrulyVisiblePosition) {
                    this.mLastTrulyVisiblePosition = lastTrulyVisiblePosition;
                    updated = true;
                }
                if (updated) {
                    ubcStatistic(this.mFirstTrulyVisiblePosition, this.mLastTrulyVisiblePosition, "scroll");
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public final void refreshDataStatistic(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        boolean z = false;
        if (recyclerView.getLayoutManager() == null || recyclerView.getAdapter() == null) {
            StringBuilder append = new StringBuilder().append("refreshDataStatistic: error  ").append(recyclerView.getLayoutManager() == null).append(" || ");
            if (recyclerView.getAdapter() == null) {
                z = true;
            }
            log(append.append(z).toString(), true);
            return;
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView.getLayoutManager() != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                this.mFirstTrulyVisiblePosition = SearchUbcHelper.getFirstTrulyVisibleItemPosition(linearLayoutManager);
                this.mLastTrulyVisiblePosition = SearchUbcHelper.getLastTrulyVisibleItemPosition(linearLayoutManager);
                log$default(this, "refreshDataStatistic: \n mFirstTrulyVisiblePosition = " + this.mFirstTrulyVisiblePosition + " , mLastTrulyVisiblePosition = " + this.mLastTrulyVisiblePosition, false, 2, (Object) null);
                ubcStatistic(this.mFirstTrulyVisiblePosition, this.mLastTrulyVisiblePosition, "refresh");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    static /* synthetic */ void ubcStatistic$default(SearchDownloadScrollUbcTrigger searchDownloadScrollUbcTrigger, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str = "";
        }
        searchDownloadScrollUbcTrigger.ubcStatistic(i2, i3, str);
    }

    private final void ubcStatistic(int fromIndex, int toIndex, String from) {
        boolean z;
        int i2 = fromIndex;
        int i3 = toIndex;
        String str = from;
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView.Adapter adapter = null;
        if (recyclerView != null) {
            if ((recyclerView != null ? recyclerView.getAdapter() : null) == null) {
                z = false;
            } else {
                RecyclerView recyclerView2 = this.mRecyclerView;
                if ((recyclerView2 != null ? recyclerView2.getAdapter() : null) instanceof RecommendAdapter) {
                    RecyclerView recyclerView3 = this.mRecyclerView;
                    RecyclerView.Adapter adapter2 = recyclerView3 != null ? recyclerView3.getAdapter() : null;
                    if (adapter2 != null) {
                        List data = ((RecommendAdapter) adapter2).getDataList();
                        int fromIndexSafe = SearchUbcHelper.safeIndex(i2, data.size());
                        int toIndexSafe = SearchUbcHelper.safeIndex(i3, data.size() + 1);
                        int index = fromIndexSafe;
                        if (index <= toIndexSafe) {
                            while (index < data.size()) {
                                String title = data.get(index).mFileName;
                                if (getMRecommendUbcHistoryRecordList().contains(title)) {
                                    log(str + " ubcStatistic: RecommendAdapter->  skip index = " + index + " , title = " + data.get(index).mFileName + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE, true);
                                } else {
                                    log$default(this, str + " ubcStatistic: RecommendAdapter-> index = " + index + " , title = " + data.get(index).mFileName + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE, false, 2, (Object) null);
                                    getMRecommendUbcHistoryRecordList().add(title == null ? "" : title);
                                    SearchDownloadUBCUtils.INSTANCE.sugItemUbc(data.get(index), index, false);
                                }
                                if (index != toIndexSafe) {
                                    index++;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.download.center.ui.search.adapter.RecommendAdapter");
                }
                RecyclerView recyclerView4 = this.mRecyclerView;
                if ((recyclerView4 != null ? recyclerView4.getAdapter() : null) instanceof SearchResultAdapter) {
                    log$default(this, str + " ubcStatistic: RecommendAdapter-> fromIndex = " + i2 + " , toIndex = " + i3 + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE, false, 2, (Object) null);
                    int index2 = fromIndex;
                    if (index2 <= i3) {
                        while (true) {
                            RecyclerView recyclerView5 = this.mRecyclerView;
                            RecyclerView.ViewHolder vh = recyclerView5 != null ? recyclerView5.findViewHolderForAdapterPosition(index2) : null;
                            if (vh != null && (vh instanceof SearchBaseHolder)) {
                                ((SearchBaseHolder) vh).onOutRvScrollStop();
                            }
                            if (index2 != i3) {
                                index2++;
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    StringBuilder append = new StringBuilder().append(str).append(" ubcStatistic: adapter 不支持类型  ");
                    RecyclerView recyclerView6 = this.mRecyclerView;
                    if (recyclerView6 != null) {
                        adapter = recyclerView6.getAdapter();
                    }
                    log(append.append(adapter).toString(), true);
                    return;
                }
            }
        } else {
            z = false;
        }
        StringBuilder append2 = new StringBuilder().append(str).append(" ubcStatistic: error  ").append(this.mRecyclerView == null ? true : z).append(" || ");
        RecyclerView recyclerView7 = this.mRecyclerView;
        if (recyclerView7 != null) {
            adapter = recyclerView7.getAdapter();
        }
        log(append2.append(adapter == null ? true : z).toString(), true);
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        this.isScrollDown = dy > 0;
    }

    static /* synthetic */ void log$default(SearchDownloadScrollUbcTrigger searchDownloadScrollUbcTrigger, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        searchDownloadScrollUbcTrigger.log(str, z);
    }

    private final void log(String msg, boolean isError) {
        if (AppConfig.isDebug()) {
            if (isError) {
                Log.e(this.TAG, "\n " + msg + ' ');
            } else {
                Log.d(this.TAG, "\n " + msg + ' ');
            }
        }
    }
}
