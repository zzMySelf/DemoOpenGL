package com.tera.scan.business.core.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.aiscan.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import fe.mmm.qw.rg.qw.ad.qw.th;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001f\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u001a\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/tera/scan/business/core/ui/dialog/ScanBaseBottomDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "rootView", "Landroid/view/View;", "defaultExpandDialog", "", "dismiss", "", "findViewById", "T", "id", "", "(I)Landroid/view/View;", "getLayoutId", "initView", "view", "isDraggable", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "setupFullHeight", "bottomSheet", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "business-core_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ScanBaseBottomDialogFragment extends BottomSheetDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public View rootView;

    /* renamed from: onCreateDialog$lambda-2  reason: not valid java name */
    public static final void m730onCreateDialog$lambda2(ScanBaseBottomDialogFragment scanBaseBottomDialogFragment, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(scanBaseBottomDialogFragment, "this$0");
        if (dialogInterface != null) {
            View findViewById = ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
            if (findViewById != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
                Intrinsics.checkNotNullExpressionValue(from, "from(it)");
                scanBaseBottomDialogFragment.setupFullHeight(findViewById);
                from.setState(3);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    private final void setupFullHeight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
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

    public boolean defaultExpandDialog() {
        return false;
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }

    @Nullable
    public final <T extends View> T findViewById(int i2) {
        View view = this.rootView;
        if (view != null) {
            return view.findViewById(i2);
        }
        return null;
    }

    public abstract int getLayoutId();

    public abstract void initView(@NotNull View view);

    public boolean isDraggable() {
        return true;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.DuboxDialogTheme);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (defaultExpandDialog()) {
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            onCreateDialog.setOnShowListener(new th(this));
            return onCreateDialog;
        }
        Dialog onCreateDialog2 = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog2, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog2;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        this.rootView = inflate;
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r0.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r4 = this;
            super.onStart()
            android.app.Dialog r0 = r4.getDialog()     // Catch:{ Exception -> 0x003e }
            r1 = 2131362237(0x7f0a01bd, float:1.8344249E38)
            if (r0 == 0) goto L_0x0017
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003e }
            if (r0 == 0) goto L_0x0017
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x003e }
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            r2 = 0
            if (r0 != 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            android.graphics.drawable.ColorDrawable r3 = new android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x003e }
            r3.<init>(r2)     // Catch:{ Exception -> 0x003e }
            r0.setBackground(r3)     // Catch:{ Exception -> 0x003e }
        L_0x0024:
            boolean r0 = r4.isDraggable()     // Catch:{ Exception -> 0x003e }
            if (r0 != 0) goto L_0x0046
            android.app.Dialog r0 = r4.getDialog()     // Catch:{ Exception -> 0x003e }
            if (r0 == 0) goto L_0x0046
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x003e }
            if (r0 == 0) goto L_0x0046
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r0)     // Catch:{ Exception -> 0x003e }
            r0.setDraggable(r2)     // Catch:{ Exception -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r0 = move-exception
            java.lang.String r1 = "ScanBaseBottomDialogFragment"
            java.lang.String r2 = "onStart error"
            fe.mmm.qw.i.qw.th(r1, r2, r0)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.business.core.ui.dialog.ScanBaseBottomDialogFragment.onStart():void");
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView(view);
    }

    public void show(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        if (fragmentManager.findFragmentByTag(str) == null) {
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
