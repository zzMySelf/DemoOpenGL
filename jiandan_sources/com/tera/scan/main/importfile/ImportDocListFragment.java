package com.tera.scan.main.importfile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import com.tera.scan.main.importfile.adapter.ImportDocListAdapter;
import com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel;
import fe.mmm.qw.xxx.uk.o;
import fe.mmm.qw.xxx.uk.qw;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010 \u001a\u00020\u0012H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/tera/scan/main/importfile/ImportDocListFragment;", "Lcom/tera/scan/framework/kernel/architecture/ui/BaseFragment;", "()V", "docViewModel", "Lcom/tera/scan/main/importfile/viewmodel/ImportDocFileViewModel;", "getDocViewModel", "()Lcom/tera/scan/main/importfile/viewmodel/ImportDocFileViewModel;", "docViewModel$delegate", "Lkotlin/Lazy;", "emptyScan", "Landroid/view/View;", "homeListEmpty", "importDocListAdapter", "Lcom/tera/scan/main/importfile/adapter/ImportDocListAdapter;", "getImportDocListAdapter", "()Lcom/tera/scan/main/importfile/adapter/ImportDocListAdapter;", "importDocListAdapter$delegate", "initData", "", "initView", "view", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onImportDocItemClick", "position", "", "onViewCreated", "showEmptyView", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImportDocListFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy docViewModel$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocListFragment$docViewModel$2(this));
    @Nullable
    public View emptyScan;
    @Nullable
    public View homeListEmpty;
    @NotNull
    public final Lazy importDocListAdapter$delegate = LazyKt__LazyJVMKt.lazy(ImportDocListFragment$importDocListAdapter$2.INSTANCE);

    private final ImportDocFileViewModel getDocViewModel() {
        return (ImportDocFileViewModel) this.docViewModel$delegate.getValue();
    }

    private final ImportDocListAdapter getImportDocListAdapter() {
        return (ImportDocListAdapter) this.importDocListAdapter$delegate.getValue();
    }

    private final void initData() {
        getDocViewModel().getFileListLiveData().observe(getViewLifecycleOwner(), new qw(this));
    }

    /* renamed from: initData$lambda-1  reason: not valid java name */
    public static final void m819initData$lambda1(ImportDocListFragment importDocListFragment, List list) {
        Intrinsics.checkNotNullParameter(importDocListFragment, "this$0");
        if (list == null || list.isEmpty()) {
            importDocListFragment.showEmptyView();
            return;
        }
        RecyclerView recyclerView = (RecyclerView) importDocListFragment._$_findCachedViewById(R.id.rv_import_files);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rv_import_files");
        fe.mmm.qw.th.qw.rg.fe.de.qw.fe(recyclerView);
        View view = importDocListFragment.homeListEmpty;
        if (view != null) {
            fe.mmm.qw.th.qw.rg.fe.de.qw.qw(view);
        }
        ImportDocListAdapter importDocListAdapter = importDocListFragment.getImportDocListAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "importFiles");
        importDocListAdapter.updateData(list);
    }

    private final void initView(View view) {
        ((RecyclerView) _$_findCachedViewById(R.id.rv_import_files)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) _$_findCachedViewById(R.id.rv_import_files)).setAdapter(getImportDocListAdapter());
        getImportDocListAdapter().setOnItemClick(new ImportDocListFragment$initView$1(this));
        this.homeListEmpty = view.findViewById(R.id.fl_home_list_empty);
        this.emptyScan = view.findViewById(R.id.tv_empty_scan);
    }

    /* access modifiers changed from: private */
    public final void onImportDocItemClick(int i2) {
        ((RecyclerView) _$_findCachedViewById(R.id.rv_import_files)).post(new o(this, i2));
    }

    /* renamed from: onImportDocItemClick$lambda-0  reason: not valid java name */
    public static final void m820onImportDocItemClick$lambda0(ImportDocListFragment importDocListFragment, int i2) {
        Intrinsics.checkNotNullParameter(importDocListFragment, "this$0");
        importDocListFragment.getDocViewModel().changeItemSelectState(i2);
    }

    private final void showEmptyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_import_files);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rv_import_files");
        fe.mmm.qw.th.qw.rg.fe.de.qw.qw(recyclerView);
        View view = this.homeListEmpty;
        if (view != null) {
            fe.mmm.qw.th.qw.rg.fe.de.qw.fe(view);
        }
        View view2 = this.emptyScan;
        if (view2 != null) {
            fe.mmm.qw.th.qw.rg.fe.de.qw.qw(view2);
        }
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

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.fragment_import_doc, (ViewGroup) null, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView(view);
        initData();
    }
}
