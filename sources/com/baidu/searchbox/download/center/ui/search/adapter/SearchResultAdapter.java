package com.baidu.searchbox.download.center.ui.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder;
import com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultViewHolder;
import com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\rJ\u001a\u0010\u001f\u001a\u00020\u00172\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/adapter/SearchResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mEntityList", "", "", "Lcom/baidu/searchbox/download/model/CategoryInfoData;", "mSearchWord", "", "allResultContentIsEmpty", "", "getDataList", "getItemCount", "", "getItemViewType", "position", "getSumText", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSearchWord", "searchWord", "update", "videoFileList", "Companion", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchResultAdapter.kt */
public final class SearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HEAD_COUNT = 1;
    public static final int TAIL_COUNT = 1;
    private final Context context;
    private final List<List<CategoryInfoData>> mEntityList = new ArrayList();
    private String mSearchWord = "";

    public final Context getContext() {
        return this.context;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/search/adapter/SearchResultAdapter$Companion;", "", "()V", "HEAD_COUNT", "", "TAIL_COUNT", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchResultAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SearchResultAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void setSearchWord(String searchWord) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        this.mSearchWord = searchWord;
    }

    public final void update(List<? extends List<? extends CategoryInfoData>> videoFileList) {
        Intrinsics.checkNotNullParameter(videoFileList, "videoFileList");
        this.mEntityList.clear();
        this.mEntityList.addAll(videoFileList);
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        if (viewType == 10000) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_center_search_result_sum, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new SearchResultSumViewHolder(view2);
        } else if (viewType == 10001) {
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_center_whole_network_search, parent, false);
            Intrinsics.checkNotNullExpressionValue(view3, "view");
            return new WholeNetworkSearchViewHolder(view3);
        } else {
            View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.downloadcenter_search_result_list_container, parent, false);
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(view4, "view");
            return new SearchResultViewHolder(context2, view4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.baidu.searchbox.download.center.ui.search.viewholder.SearchBaseHolder
            if (r0 == 0) goto L_0x0014
            r0 = r4
            com.baidu.searchbox.download.center.ui.search.viewholder.SearchBaseHolder r0 = (com.baidu.searchbox.download.center.ui.search.viewholder.SearchBaseHolder) r0
            boolean r1 = r3.allResultContentIsEmpty()
            r0.setAllContentIsEmpty(r1)
        L_0x0014:
            int r0 = r3.getItemViewType(r5)
            r1 = 10000(0x2710, float:1.4013E-41)
            r2 = 0
            if (r0 != r1) goto L_0x0035
            boolean r0 = r4 instanceof com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder
            if (r0 == 0) goto L_0x0024
            r2 = r4
            com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder r2 = (com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder) r2
        L_0x0024:
            if (r2 == 0) goto L_0x006b
            java.lang.String r0 = r3.getSumText()
            r1 = r4
            com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder r1 = (com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultSumViewHolder) r1
            int r1 = r1.getAdapterPosition()
            r2.update((java.lang.String) r0, (int) r1)
            goto L_0x006b
        L_0x0035:
            int r0 = r3.getItemViewType(r5)
            r1 = 10001(0x2711, float:1.4014E-41)
            if (r0 != r1) goto L_0x0053
            boolean r0 = r4 instanceof com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder
            if (r0 == 0) goto L_0x0044
            r2 = r4
            com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder r2 = (com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder) r2
        L_0x0044:
            if (r2 == 0) goto L_0x006b
            java.lang.String r0 = r3.mSearchWord
            r1 = r4
            com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder r1 = (com.baidu.searchbox.download.center.ui.search.viewholder.WholeNetworkSearchViewHolder) r1
            int r1 = r1.getAdapterPosition()
            r2.update((java.lang.String) r0, (int) r1)
            goto L_0x006b
        L_0x0053:
            boolean r0 = r4 instanceof com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultViewHolder
            if (r0 == 0) goto L_0x005a
            r2 = r4
            com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultViewHolder r2 = (com.baidu.searchbox.download.center.ui.search.viewholder.SearchResultViewHolder) r2
        L_0x005a:
            if (r2 == 0) goto L_0x006b
            java.util.List<java.util.List<com.baidu.searchbox.download.model.CategoryInfoData>> r0 = r3.mEntityList
            int r1 = r5 + -1
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = r5 + -1
            r2.update((java.util.List<? extends com.baidu.searchbox.download.model.CategoryInfoData>) r0, (int) r1)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.search.adapter.SearchResultAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    private final String getSumText() {
        StringBuilder append = new StringBuilder().append(20849);
        int i2 = 0;
        for (List it : this.mEntityList) {
            i2 += it.size();
        }
        return append.append(i2).append("条结果").toString();
    }

    private final boolean allResultContentIsEmpty() {
        int i2 = 0;
        for (List it : this.mEntityList) {
            i2 += it.size();
        }
        if (i2 <= 0) {
            return true;
        }
        return false;
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return 10000;
        }
        if (getItemCount() - 1 == position) {
            return 10001;
        }
        return 3;
    }

    public int getItemCount() {
        return this.mEntityList.size() + 1 + 1;
    }

    public final List<List<CategoryInfoData>> getDataList() {
        return this.mEntityList;
    }
}
