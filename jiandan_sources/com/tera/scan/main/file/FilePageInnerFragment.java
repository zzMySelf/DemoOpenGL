package com.tera.scan.main.file;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.fragment.MainFragmentScrollable;
import com.tera.scan.main.fragment.ScanBaseFragment;
import com.tera.scan.main.home.MainFileListAdapter;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import fe.mmm.qw.xxx.th.ad;
import fe.mmm.qw.xxx.th.rg;
import fe.mmm.qw.xxx.th.th;
import fe.mmm.qw.xxx.yj.g.qw.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/tera/scan/main/file/FilePageInnerFragment;", "Lcom/tera/scan/main/fragment/ScanBaseFragment;", "Lcom/tera/scan/main/fragment/MainFragmentScrollable;", "()V", "adapter", "Lcom/tera/scan/main/home/MainFileListAdapter;", "listHolder", "Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "getListHolder", "()Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "listHolder$delegate", "Lkotlin/Lazy;", "mainActivityViewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "getMainActivityViewModel", "()Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "mainActivityViewModel$delegate", "enterSelectFileMode", "", "getLayoutId", "", "initSubscribe", "initView", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "scrollListTo", "scrollY", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilePageInnerFragment extends ScanBaseFragment implements MainFragmentScrollable {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public MainFileListAdapter adapter;
    @NotNull
    public final Lazy listHolder$delegate = LazyKt__LazyJVMKt.lazy(new FilePageInnerFragment$listHolder$2(this));
    @NotNull
    public final Lazy mainActivityViewModel$delegate = LazyKt__LazyJVMKt.lazy(new FilePageInnerFragment$mainActivityViewModel$2(this));

    private final qw<?> getListHolder() {
        return (qw) this.listHolder$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MainActivityViewModel getMainActivityViewModel() {
        return (MainActivityViewModel) this.mainActivityViewModel$delegate.getValue();
    }

    private final void initSubscribe() {
        getMainActivityViewModel().getSortTypeLiveData().observe(getViewLifecycleOwner(), new ad(this));
        getMainActivityViewModel().getSortOrderLiveData().observe(getViewLifecycleOwner(), new th(this));
    }

    /* renamed from: initSubscribe$lambda-1  reason: not valid java name */
    public static final void m773initSubscribe$lambda1(FilePageInnerFragment filePageInnerFragment, Integer num) {
        Intrinsics.checkNotNullParameter(filePageInnerFragment, "this$0");
        MainFileListAdapter mainFileListAdapter = filePageInnerFragment.adapter;
        if (mainFileListAdapter != null) {
            mainFileListAdapter.updateListData();
            mainFileListAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: initSubscribe$lambda-3  reason: not valid java name */
    public static final void m774initSubscribe$lambda3(FilePageInnerFragment filePageInnerFragment, Integer num) {
        Intrinsics.checkNotNullParameter(filePageInnerFragment, "this$0");
        MainFileListAdapter mainFileListAdapter = filePageInnerFragment.adapter;
        if (mainFileListAdapter != null) {
            mainFileListAdapter.updateListData();
            mainFileListAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m775initView$lambda5(FragmentActivity fragmentActivity, FilePageInnerFragment filePageInnerFragment, View view) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$activity");
        Intrinsics.checkNotNullParameter(filePageInnerFragment, "this$0");
        filePageInnerFragment.startActivity(OCRTakePhotoActivity.ad.fe(OCRTakePhotoActivity.Companion, fragmentActivity, "pdf", 0, 0, 0, 3, "", 28, (Object) null));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void enterSelectFileMode() {
        View findViewByPosition;
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = null;
        MainActivity mainActivity2 = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity2 != null) {
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) _$_findCachedViewById(R.id.rcv_file_list_inner)).getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) _$_findCachedViewById(R.id.rcv_file_list_inner)).getLayoutManager();
                LinearLayoutManager linearLayoutManager2 = layoutManager2 instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager2 : null;
                if (linearLayoutManager2 != null && (findViewByPosition = linearLayoutManager2.findViewByPosition(findFirstCompletelyVisibleItemPosition)) != null) {
                    int[] iArr = {0, 0};
                    findViewByPosition.getLocationOnScreen(iArr);
                    int i2 = iArr[1];
                    if (mainActivity2 instanceof MainActivity) {
                        mainActivity = mainActivity2;
                    }
                    if (mainActivity != null) {
                        getMainActivityViewModel().enterFileSelectMode(mainActivity, getListHolder(), findFirstCompletelyVisibleItemPosition, i2);
                    }
                }
            }
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_file_inner;
    }

    public void initView(@NotNull Context context, @NotNull View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            qw<?> listHolder = getListHolder();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            MainFileListAdapter mainFileListAdapter = new MainFileListAdapter(context, listHolder, viewLifecycleOwner, false, 8, (DefaultConstructorMarker) null);
            mainFileListAdapter.setOnItemSelect(new FilePageInnerFragment$initView$1$1(this, activity, mainFileListAdapter));
            mainFileListAdapter.setOnItemClick(new FilePageInnerFragment$initView$1$2(mainFileListAdapter, activity));
            this.adapter = mainFileListAdapter;
            ((RecyclerView) _$_findCachedViewById(R.id.rcv_file_list_inner)).setAdapter(this.adapter);
            View findViewById = view.findViewById(R.id.tv_empty_scan);
            if (findViewById != null) {
                findViewById.setOnClickListener(new rg(activity, this));
            }
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initSubscribe();
    }

    public void scrollListTo(int i2) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ((RecyclerView) _$_findCachedViewById(R.id.rcv_file_list_inner)).scrollBy(0, i2);
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r3 = Result.m1158exceptionOrNullimpl(obj);
        if (r3 != null) {
            LoggerKt.e$default(r3, (Object) null, 1, (Object) null);
        }
    }
}
