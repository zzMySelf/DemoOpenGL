package com.tera.scan.main.file.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tera.scan.business.core.ui.dialog.ScanBaseBottomDialogFragment;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import fe.mmm.qw.xxx.th.p034if.ad;
import fe.mmm.qw.xxx.th.p034if.de;
import fe.mmm.qw.xxx.th.p034if.fe;
import fe.mmm.qw.xxx.th.p034if.qw;
import fe.mmm.qw.xxx.th.p034if.rg;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/tera/scan/main/file/dialog/FileSortDialog;", "Lcom/tera/scan/business/core/ui/dialog/ScanBaseBottomDialogFragment;", "viewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "(Lcom/tera/scan/main/viewmodel/MainActivityViewModel;)V", "ivClose", "Landroid/widget/ImageView;", "ivDataAddItem", "ivNameItem", "llDataAddContainer", "Landroid/view/ViewGroup;", "llNameContainer", "tvDataAddItem", "Landroid/widget/TextView;", "tvNameItem", "getViewModel", "()Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "getLayoutId", "", "getSelectItem", "()Ljava/lang/Integer;", "initSubscribe", "", "initView", "view", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "updateSelectItem", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileSortDialog extends ScanBaseBottomDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public ImageView ivClose;
    @Nullable
    public ImageView ivDataAddItem;
    @Nullable
    public ImageView ivNameItem;
    @Nullable
    public ViewGroup llDataAddContainer;
    @Nullable
    public ViewGroup llNameContainer;
    @Nullable
    public TextView tvDataAddItem;
    @Nullable
    public TextView tvNameItem;
    @NotNull
    public final MainActivityViewModel viewModel;

    public FileSortDialog(@NotNull MainActivityViewModel mainActivityViewModel) {
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "viewModel");
        this.viewModel = mainActivityViewModel;
    }

    private final Integer getSelectItem() {
        return this.viewModel.getSortTypeLiveData().getValue();
    }

    private final void initSubscribe() {
        this.viewModel.getSortTypeLiveData().observe(getViewLifecycleOwner(), new ad(this));
        this.viewModel.getSortOrderLiveData().observe(getViewLifecycleOwner(), new de(this));
    }

    /* renamed from: initSubscribe$lambda-0  reason: not valid java name */
    public static final void m776initSubscribe$lambda0(FileSortDialog fileSortDialog, Integer num) {
        Intrinsics.checkNotNullParameter(fileSortDialog, "this$0");
        fileSortDialog.updateSelectItem();
    }

    /* renamed from: initSubscribe$lambda-1  reason: not valid java name */
    public static final void m777initSubscribe$lambda1(FileSortDialog fileSortDialog, Integer num) {
        Intrinsics.checkNotNullParameter(fileSortDialog, "this$0");
        fileSortDialog.updateSelectItem();
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m778initView$lambda2(FileSortDialog fileSortDialog, View view) {
        Intrinsics.checkNotNullParameter(fileSortDialog, "this$0");
        fileSortDialog.dismiss();
        Integer selectItem = fileSortDialog.getSelectItem();
        if (selectItem != null && selectItem.intValue() == 0) {
            fileSortDialog.viewModel.reverseFileListOrder();
            return;
        }
        fileSortDialog.viewModel.updateSortType(0);
        fileSortDialog.viewModel.setFileListOrder(1);
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m779initView$lambda3(FileSortDialog fileSortDialog, View view) {
        Intrinsics.checkNotNullParameter(fileSortDialog, "this$0");
        fileSortDialog.dismiss();
        Integer selectItem = fileSortDialog.getSelectItem();
        if (selectItem != null && selectItem.intValue() == 1) {
            fileSortDialog.viewModel.reverseFileListOrder();
            return;
        }
        fileSortDialog.viewModel.updateSortType(1);
        fileSortDialog.viewModel.setFileListOrder(1);
    }

    /* renamed from: initView$lambda-4  reason: not valid java name */
    public static final void m780initView$lambda4(FileSortDialog fileSortDialog, View view) {
        Intrinsics.checkNotNullParameter(fileSortDialog, "this$0");
        fileSortDialog.dismiss();
    }

    private final void updateSelectItem() {
        Integer value = this.viewModel.getSortOrderLiveData().getValue();
        ImageView imageView = this.ivDataAddItem;
        int i2 = 4;
        boolean z = false;
        if (imageView != null) {
            Integer selectItem = getSelectItem();
            imageView.setVisibility((selectItem != null && selectItem.intValue() == 0) ? 0 : 4);
        }
        int color = getResources().getColor(R.color.sort_item_text_selected_color);
        int color2 = getResources().getColor(R.color.sort_item_text_color);
        TextView textView = this.tvDataAddItem;
        if (textView != null) {
            Integer selectItem2 = getSelectItem();
            textView.setTextColor((selectItem2 != null && selectItem2.intValue() == 0) ? color : color2);
        }
        TextView textView2 = this.tvDataAddItem;
        if (textView2 != null) {
            Integer selectItem3 = getSelectItem();
            textView2.setSelected(selectItem3 != null && selectItem3.intValue() == 0);
        }
        ImageView imageView2 = this.ivNameItem;
        if (imageView2 != null) {
            Integer selectItem4 = getSelectItem();
            if (selectItem4 != null && selectItem4.intValue() == 1) {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
        }
        TextView textView3 = this.tvNameItem;
        if (textView3 != null) {
            Integer selectItem5 = getSelectItem();
            if (selectItem5 == null || selectItem5.intValue() != 1) {
                color = color2;
            }
            textView3.setTextColor(color);
        }
        TextView textView4 = this.tvNameItem;
        if (textView4 != null) {
            Integer selectItem6 = getSelectItem();
            if (selectItem6 != null && selectItem6.intValue() == 1) {
                z = true;
            }
            textView4.setSelected(z);
        }
        ImageView imageView3 = this.ivNameItem;
        float f = 0.0f;
        if (imageView3 != null) {
            imageView3.setRotation((value != null && value.intValue() == 1) ? 0.0f : -180.0f);
        }
        ImageView imageView4 = this.ivDataAddItem;
        if (imageView4 != null) {
            if (value == null || value.intValue() != 1) {
                f = -180.0f;
            }
            imageView4.setRotation(f);
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

    public int getLayoutId() {
        return R.layout.dialog_file_sort;
    }

    @NotNull
    public final MainActivityViewModel getViewModel() {
        return this.viewModel;
    }

    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.llDataAddContainer = (ViewGroup) findViewById(R.id.ll_dialog_data_add_container);
        this.ivDataAddItem = (ImageView) findViewById(R.id.iv_dialog_data_add);
        this.tvDataAddItem = (TextView) findViewById(R.id.tv_dialog_data_add);
        this.llNameContainer = (ViewGroup) findViewById(R.id.ll_dialog_name_container);
        this.ivNameItem = (ImageView) findViewById(R.id.iv_dialog_name);
        this.tvNameItem = (TextView) findViewById(R.id.tv_dialog_name);
        this.ivClose = (ImageView) findViewById(R.id.iv_dialog_file_sort_close);
        updateSelectItem();
        ViewGroup viewGroup = this.llDataAddContainer;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new qw(this));
        }
        ViewGroup viewGroup2 = this.llNameContainer;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(new rg(this));
        }
        ImageView imageView = this.ivClose;
        if (imageView != null) {
            imageView.setOnClickListener(new fe(this));
        }
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return super.onCreateDialog(bundle);
        }
        return new BottomSheetDialog(activity);
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
}
