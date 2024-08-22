package com.baidu.searchbox.account.userinfo.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.account.userinfo.activity.UserCoverActivity;
import com.baidu.searchbox.appframework.fragment.BaseFragment;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryCategoryEntity;
import com.baidu.searchbox.kmm.personalpage.shop.entities.PersonalPageGalleryImageEntity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020 J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/UserCoverFragment;", "Lcom/baidu/searchbox/appframework/fragment/BaseFragment;", "Lcom/baidu/searchbox/account/userinfo/activity/UserCoverItemListener;", "()V", "tabItemInfo", "Lcom/baidu/searchbox/account/userinfo/activity/UserCoverActivity$UserCoverMultiTabItemInfo;", "tabItemClick", "Lcom/baidu/searchbox/account/userinfo/activity/UserCoverTabItemListener;", "(Lcom/baidu/searchbox/account/userinfo/activity/UserCoverActivity$UserCoverMultiTabItemInfo;Lcom/baidu/searchbox/account/userinfo/activity/UserCoverTabItemListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "userCoverAdapter", "Lcom/baidu/searchbox/account/userinfo/activity/UserCoverAdapter;", "getUserCoverAdapter", "()Lcom/baidu/searchbox/account/userinfo/activity/UserCoverAdapter;", "setUserCoverAdapter", "(Lcom/baidu/searchbox/account/userinfo/activity/UserCoverAdapter;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onUserCoverItemClick", "", "entity", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryImageEntity;", "pos", "", "onUserCoverItemShow", "scrollToNeedPosItem", "scrollToTargetItem", "target", "updateItemUIByPos", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserCoverFragment.kt */
public final class UserCoverFragment extends BaseFragment implements UserCoverItemListener {
    public Map<Integer, View> _$_findViewCache;
    private RecyclerView recyclerView;
    private final UserCoverTabItemListener tabItemClick;
    private final UserCoverActivity.UserCoverMultiTabItemInfo tabItemInfo;
    private UserCoverAdapter userCoverAdapter;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View view3 = getView();
        if (view3 == null || (findViewById = view3.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public UserCoverFragment(UserCoverActivity.UserCoverMultiTabItemInfo tabItemInfo2, UserCoverTabItemListener tabItemClick2) {
        this._$_findViewCache = new LinkedHashMap();
        this.tabItemInfo = tabItemInfo2;
        this.tabItemClick = tabItemClick2;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView2) {
        this.recyclerView = recyclerView2;
    }

    public final UserCoverAdapter getUserCoverAdapter() {
        return this.userCoverAdapter;
    }

    public final void setUserCoverAdapter(UserCoverAdapter userCoverAdapter2) {
        this.userCoverAdapter = userCoverAdapter2;
    }

    public UserCoverFragment() {
        this((UserCoverActivity.UserCoverMultiTabItemInfo) null, (UserCoverTabItemListener) null);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = inflater.inflate(R.layout.fragment_user_cover, container, false);
        RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.user_cover_recycler_view);
        RecyclerView $this$onCreateView_u24lambda_u2d1 = recyclerView2;
        $this$onCreateView_u24lambda_u2d1.setBackgroundColor($this$onCreateView_u24lambda_u2d1.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC9));
        GridLayoutManager layoutManager = new GridLayoutManager($this$onCreateView_u24lambda_u2d1.getContext(), 3, 1, false);
        layoutManager.setSpanSizeLookup(new UserCoverFragment$onCreateView$1$1($this$onCreateView_u24lambda_u2d1));
        $this$onCreateView_u24lambda_u2d1.setLayoutManager(layoutManager);
        UserCoverActivity.UserCoverMultiTabItemInfo userCoverMultiTabItemInfo = this.tabItemInfo;
        if (userCoverMultiTabItemInfo != null) {
            List it = userCoverMultiTabItemInfo.getData().getImages();
            UserCoverAdapter userCoverAdapter2 = it != null ? new UserCoverAdapter(it) : null;
            this.userCoverAdapter = userCoverAdapter2;
            if (userCoverAdapter2 != null) {
                userCoverAdapter2.setAlbumItemClickListener(this);
            }
            $this$onCreateView_u24lambda_u2d1.setAdapter(this.userCoverAdapter);
        }
        this.recyclerView = recyclerView2;
        return view2;
    }

    public void onUserCoverItemClick(PersonalPageGalleryImageEntity entity, int pos) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        UserCoverActivity.UserCoverMultiTabItemInfo userCoverMultiTabItemInfo = this.tabItemInfo;
        if (userCoverMultiTabItemInfo != null) {
            UserCoverActivity.UserCoverMultiTabItemInfo userCoverMultiTabItemInfo2 = userCoverMultiTabItemInfo;
            UserCoverTabItemListener userCoverTabItemListener = this.tabItemClick;
            if (userCoverTabItemListener != null) {
                userCoverTabItemListener.onUserCoverTabItemClick(userCoverMultiTabItemInfo.getData(), entity, pos);
            }
        }
    }

    public void onUserCoverItemShow(PersonalPageGalleryImageEntity entity, int pos) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        UserCoverActivity.UserCoverMultiTabItemInfo userCoverMultiTabItemInfo = this.tabItemInfo;
        if (userCoverMultiTabItemInfo != null) {
            UserCoverActivity.UserCoverMultiTabItemInfo userCoverMultiTabItemInfo2 = userCoverMultiTabItemInfo;
            UserCoverTabItemListener userCoverTabItemListener = this.tabItemClick;
            if (userCoverTabItemListener != null) {
                userCoverTabItemListener.onUserCoverTabItemShow(userCoverMultiTabItemInfo.getData(), entity, pos);
            }
        }
    }

    public final void updateItemUIByPos(int pos) {
        UserCoverAdapter it = this.userCoverAdapter;
        if (it != null && pos >= 0 && pos < it.getItemCount()) {
            it.refreshItem(pos);
        }
    }

    public final void scrollToNeedPosItem(int pos) {
        RecyclerView recyclerView2 = this.recyclerView;
        GridLayoutManager gridLayoutManager = null;
        RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) layoutManager;
        }
        GridLayoutManager layoutManager2 = gridLayoutManager;
        if (layoutManager2 != null) {
            GridLayoutManager it = layoutManager2;
            if (pos >= 0 && pos < it.getItemCount()) {
                it.scrollToPositionWithOffset(pos, 0);
            }
        }
    }

    public final void scrollToTargetItem(PersonalPageGalleryImageEntity target) {
        PersonalPageGalleryCategoryEntity data;
        Iterable $this$forEachIndexed$iv;
        Intrinsics.checkNotNullParameter(target, "target");
        int pos = -1;
        UserCoverActivity.UserCoverMultiTabItemInfo userCoverMultiTabItemInfo = this.tabItemInfo;
        if (!(userCoverMultiTabItemInfo == null || (data = userCoverMultiTabItemInfo.getData()) == null || ($this$forEachIndexed$iv = data.getImages()) == null)) {
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual((Object) target.getImageId(), (Object) ((PersonalPageGalleryImageEntity) item$iv).getImageId())) {
                    pos = index;
                    index = index$iv;
                } else {
                    index = index$iv;
                }
            }
        }
        if (pos != -1) {
            RecyclerView recyclerView2 = this.recyclerView;
            GridLayoutManager gridLayoutManager = null;
            RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
            if (layoutManager instanceof GridLayoutManager) {
                gridLayoutManager = (GridLayoutManager) layoutManager;
            }
            GridLayoutManager layoutManager2 = gridLayoutManager;
            if (layoutManager2 != null) {
                GridLayoutManager it = layoutManager2;
                if (pos >= 0 && pos < it.getItemCount()) {
                    it.scrollToPositionWithOffset(pos, 0);
                }
            }
        }
    }
}
