package com.baidu.searchbox.follow.followaddrlist.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.follow.followaddrlist.adapter.FollowRecommendAdapter;
import com.baidu.searchbox.follow.followaddrlist.data.RecommendCategoryListData;
import com.baidu.searchbox.follow.viewmodel.FollowCategoryListViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/follow/followaddrlist/fragment/FollowCategoryFragment$initRightList$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-follow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowCategoryFragment.kt */
public final class FollowCategoryFragment$initRightList$3 extends RecyclerView.OnScrollListener {
    final /* synthetic */ LinearLayoutManager $linearLayoutManager;
    final /* synthetic */ FollowCategoryFragment this$0;

    FollowCategoryFragment$initRightList$3(LinearLayoutManager $linearLayoutManager2, FollowCategoryFragment $receiver) {
        this.$linearLayoutManager = $linearLayoutManager2;
        this.this$0 = $receiver;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        RecommendCategoryListData access$getCategoryListData$p;
        ArrayList it;
        FollowCategoryListViewModel access$getListViewModel$p;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        int lastVisiblePosition = this.$linearLayoutManager.findLastVisibleItemPosition();
        if (lastVisiblePosition >= 0) {
            FollowRecommendAdapter access$getRightAdapter$p = this.this$0.rightAdapter;
            boolean z = true;
            if ((access$getRightAdapter$p != null && access$getRightAdapter$p.getItemViewType(lastVisiblePosition) == 1) && this.this$0.categoryListData != null && (access$getCategoryListData$p = this.this$0.categoryListData) != null && (it = access$getCategoryListData$p.getRecommendItems()) != null) {
                FollowCategoryFragment followCategoryFragment = this.this$0;
                if (it.size() > followCategoryFragment.selectIndex) {
                    RecommendCategoryListData.RecommendCategoryModel recommendCategoryModel = it.get(followCategoryFragment.selectIndex);
                    if (recommendCategoryModel == null || !recommendCategoryModel.isHasMore()) {
                        z = false;
                    }
                    if (z && (access$getListViewModel$p = followCategoryFragment.listViewModel) != null) {
                        RecommendCategoryListData.RecommendCategoryModel recommendCategoryModel2 = it.get(followCategoryFragment.selectIndex);
                        access$getListViewModel$p.fetchListData(recommendCategoryModel2 != null ? recommendCategoryModel2.getId() : null);
                    }
                }
            }
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
    }
}
