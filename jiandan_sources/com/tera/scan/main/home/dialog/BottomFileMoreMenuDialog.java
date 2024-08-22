package com.tera.scan.main.home.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tera.scan.business.core.ui.dialog.ScanBaseBottomDialogFragment;
import com.tera.scan.ui.view.widget.UITextView;
import fe.mmm.qw.xxx.yj.h.ad;
import fe.mmm.qw.xxx.yj.h.de;
import fe.mmm.qw.xxx.yj.h.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/main/home/dialog/BottomFileMoreMenuDialog;", "Lcom/tera/scan/business/core/ui/dialog/ScanBaseBottomDialogFragment;", "()V", "listener", "Lcom/tera/scan/main/home/dialog/BottomFileMoreMenuDialog$BottomFileMoreMenuDialogListener;", "getListener", "()Lcom/tera/scan/main/home/dialog/BottomFileMoreMenuDialog$BottomFileMoreMenuDialogListener;", "setListener", "(Lcom/tera/scan/main/home/dialog/BottomFileMoreMenuDialog$BottomFileMoreMenuDialogListener;)V", "getLayoutId", "", "initView", "", "view", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "BottomFileMoreMenuDialogListener", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BottomFileMoreMenuDialog extends ScanBaseBottomDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public BottomFileMoreMenuDialogListener listener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/tera/scan/main/home/dialog/BottomFileMoreMenuDialog$BottomFileMoreMenuDialogListener;", "", "onMoreMenuDeleteClick", "", "onMoreMenuSplitClick", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface BottomFileMoreMenuDialogListener {
        void onMoreMenuDeleteClick();

        void onMoreMenuSplitClick();
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m806initView$lambda0(BottomFileMoreMenuDialog bottomFileMoreMenuDialog, View view) {
        Intrinsics.checkNotNullParameter(bottomFileMoreMenuDialog, "this$0");
        BottomFileMoreMenuDialogListener bottomFileMoreMenuDialogListener = bottomFileMoreMenuDialog.listener;
        if (bottomFileMoreMenuDialogListener != null) {
            bottomFileMoreMenuDialogListener.onMoreMenuSplitClick();
        }
        bottomFileMoreMenuDialog.dismiss();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m807initView$lambda1(BottomFileMoreMenuDialog bottomFileMoreMenuDialog, View view) {
        Intrinsics.checkNotNullParameter(bottomFileMoreMenuDialog, "this$0");
        BottomFileMoreMenuDialogListener bottomFileMoreMenuDialogListener = bottomFileMoreMenuDialog.listener;
        if (bottomFileMoreMenuDialogListener != null) {
            bottomFileMoreMenuDialogListener.onMoreMenuDeleteClick();
        }
        bottomFileMoreMenuDialog.dismiss();
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m808initView$lambda2(BottomFileMoreMenuDialog bottomFileMoreMenuDialog, View view) {
        Intrinsics.checkNotNullParameter(bottomFileMoreMenuDialog, "this$0");
        bottomFileMoreMenuDialog.dismiss();
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
        return R.layout.dialog_bottom_file_more;
    }

    @Nullable
    public final BottomFileMoreMenuDialogListener getListener() {
        return this.listener;
    }

    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ((LinearLayout) _$_findCachedViewById(R.id.ll_menu_pdf_split)).setOnClickListener(new qw(this));
        ((LinearLayout) _$_findCachedViewById(R.id.ll_menu_delete)).setOnClickListener(new ad(this));
        ((UITextView) _$_findCachedViewById(R.id.tv_menu_cancel)).setOnClickListener(new de(this));
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

    public final void setListener(@Nullable BottomFileMoreMenuDialogListener bottomFileMoreMenuDialogListener) {
        this.listener = bottomFileMoreMenuDialogListener;
    }
}
