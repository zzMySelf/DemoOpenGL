package com.baidu.searchbox.follow.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.follow.FollowConstant;
import com.baidu.searchbox.follow.followaddrlist.FollowListRequest;
import com.baidu.searchbox.follow.followaddrlist.data.RecommendCategoryListData;
import com.baidu.searchbox.follow.util.Event;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\tR-\u0010\u0005\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R-\u0010\u000f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/follow/viewmodel/FollowCategoryListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "detail", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/follow/util/Event;", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/follow/followaddrlist/data/RecommendCategoryListData;", "getDetail", "()Landroidx/lifecycle/MutableLiveData;", "isLoadMore", "", "listData", "getListData", "fetchDetailData", "", "fetchListData", "id", "lib-follow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowCategoryListViewModel.kt */
public final class FollowCategoryListViewModel extends AndroidViewModel {
    private final MutableLiveData<Event<Pair<String, RecommendCategoryListData>>> detail = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public boolean isLoadMore;
    private final MutableLiveData<Event<Pair<String, RecommendCategoryListData>>> listData = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FollowCategoryListViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<Event<Pair<String, RecommendCategoryListData>>> getDetail() {
        return this.detail;
    }

    public final MutableLiveData<Event<Pair<String, RecommendCategoryListData>>> getListData() {
        return this.listData;
    }

    public final void fetchDetailData() {
        HashMap map = new HashMap();
        map.put("size", "10");
        FollowListRequest.getInstance().fetchCategoryList("", new FollowCategoryListViewModel$fetchDetailData$1(this), map, "");
    }

    public final void fetchListData(String id) {
        if (!this.isLoadMore) {
            this.isLoadMore = true;
            HashMap map = new HashMap();
            HashMap $this$fetchListData_u24lambda_u2d1 = map;
            $this$fetchListData_u24lambda_u2d1.put("cate_id", id == null ? "" : id);
            $this$fetchListData_u24lambda_u2d1.put("size", "10");
            $this$fetchListData_u24lambda_u2d1.put("start", "50");
            FollowListRequest.getInstance().fetchCategoryList(id, new FollowCategoryListViewModel$fetchListData$1(this), map, FollowConstant.FOLLOW_ASSETS_CLASSIFICATION_CENTER_SOURCE);
        }
    }
}
