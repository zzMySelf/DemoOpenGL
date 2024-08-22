package com.baidu.searchbox.ugc.grouppanel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.grouppanel.model.GroupListContentModel;
import com.baidu.searchbox.ugc.grouppanel.model.GroupListModel;
import com.baidu.searchbox.ugc.grouppanel.state.GroupListItemState;
import com.baidu.searchbox.ugc.grouppanel.state.GroupPanelState;
import com.baidu.searchbox.ugc.grouppanel.view.GroupPanelView;
import com.baidu.searchbox.ugc.grouppanel.viewmodel.GroupPanelViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020\rH\u0016J\u001a\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00061"}, d2 = {"Lcom/baidu/searchbox/ugc/grouppanel/GroupPanelDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "groupPanelVM", "Lcom/baidu/searchbox/ugc/grouppanel/viewmodel/GroupPanelViewModel;", "getGroupPanelVM", "()Lcom/baidu/searchbox/ugc/grouppanel/viewmodel/GroupPanelViewModel;", "groupPanelVM$delegate", "Lkotlin/Lazy;", "groupPanelView", "Lcom/baidu/searchbox/ugc/grouppanel/view/GroupPanelView;", "onDismissListener", "Lkotlin/Function0;", "", "getOnDismissListener", "()Lkotlin/jvm/functions/Function0;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "onSelectedComplete", "Lkotlin/Function1;", "Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "getOnSelectedComplete", "()Lkotlin/jvm/functions/Function1;", "setOnSelectedComplete", "(Lkotlin/jvm/functions/Function1;)V", "placeModel", "getPlaceModel", "()Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;", "setPlaceModel", "(Lcom/baidu/searchbox/ugc/grouppanel/model/GroupListContentModel;)V", "bindVM", "loadData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupPanelDialogFragment.kt */
public final class GroupPanelDialogFragment extends DialogFragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy groupPanelVM$delegate = LazyKt.lazy(new GroupPanelDialogFragment$groupPanelVM$2(this));
    private GroupPanelView groupPanelView;
    private Function0<Unit> onDismissListener;
    private Function1<? super GroupListContentModel, Unit> onSelectedComplete;
    private GroupListContentModel placeModel;

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

    /* access modifiers changed from: private */
    public final GroupPanelViewModel getGroupPanelVM() {
        return (GroupPanelViewModel) this.groupPanelVM$delegate.getValue();
    }

    public final Function1<GroupListContentModel, Unit> getOnSelectedComplete() {
        return this.onSelectedComplete;
    }

    public final void setOnSelectedComplete(Function1<? super GroupListContentModel, Unit> function1) {
        this.onSelectedComplete = function1;
    }

    public final Function0<Unit> getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(Function0<Unit> function0) {
        this.onDismissListener = function0;
    }

    public final GroupListContentModel getPlaceModel() {
        return this.placeModel;
    }

    public final void setPlaceModel(GroupListContentModel groupListContentModel) {
        this.placeModel = groupListContentModel;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Dialog $this$onCreateDialog_u24lambda_u2d2 = onCreateDialog;
        $this$onCreateDialog_u24lambda_u2d2.setCanceledOnTouchOutside(true);
        $this$onCreateDialog_u24lambda_u2d2.requestWindowFeature(1);
        Window $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1 = $this$onCreateDialog_u24lambda_u2d2.getWindow();
        if ($this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1 != null) {
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.setBackgroundDrawableResource(17170445);
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.setGravity(80);
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.getDecorView().setPadding(0, 0, 0, 0);
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.setWindowAnimations(R.style.ugc_album_dialog_in_out);
            WindowManager.LayoutParams attributes = $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.getAttributes();
            WindowManager.LayoutParams $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = attributes;
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.width = -1;
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.height = DeviceUtils.ScreenInfo.getDisplayHeight($this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.getContext()) / 2;
            $this$onCreateDialog_u24lambda_u2d2_u24lambda_u2d1.setAttributes(attributes);
        }
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context $this$onCreateView_u24lambda_u2d4 = getContext();
        if ($this$onCreateView_u24lambda_u2d4 == null) {
            return null;
        }
        GroupPanelView $this$onCreateView_u24lambda_u2d4_u24lambda_u2d3 = new GroupPanelView($this$onCreateView_u24lambda_u2d4, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$onCreateView_u24lambda_u2d4_u24lambda_u2d3.setOnClickGroupContentListener(new GroupPanelDialogFragment$onCreateView$1$1$1(this));
        $this$onCreateView_u24lambda_u2d4_u24lambda_u2d3.setOnCloseListener(new GroupPanelDialogFragment$onCreateView$1$1$2(this));
        $this$onCreateView_u24lambda_u2d4_u24lambda_u2d3.setOnRetryListener(new GroupPanelDialogFragment$onCreateView$1$1$3(this));
        this.groupPanelView = $this$onCreateView_u24lambda_u2d4_u24lambda_u2d3;
        return $this$onCreateView_u24lambda_u2d4_u24lambda_u2d3;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindVM();
        loadData();
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        if (!manager.isStateSaved()) {
            super.show(manager, tag);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.onDismissListener = null;
        this.onSelectedComplete = null;
    }

    private final void bindVM() {
        getGroupPanelVM().getPanelState().observe(this, new GroupPanelDialogFragment$$ExternalSyntheticLambda0(this));
        getGroupPanelVM().getSelectedState().observe(this, new GroupPanelDialogFragment$$ExternalSyntheticLambda1(this));
        getGroupPanelVM().getCompletedState().observe(this, new GroupPanelDialogFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindVM$lambda-5  reason: not valid java name */
    public static final void m4431bindVM$lambda5(GroupPanelDialogFragment this$0, GroupPanelState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (state.getUiState()) {
            case 0:
                GroupPanelView groupPanelView2 = this$0.groupPanelView;
                if (groupPanelView2 != null) {
                    groupPanelView2.showLoadingStatus();
                    return;
                }
                return;
            case 1:
                GroupPanelView groupPanelView3 = this$0.groupPanelView;
                if (groupPanelView3 != null) {
                    groupPanelView3.showErrorStatus();
                    return;
                }
                return;
            case 2:
                GroupPanelView groupPanelView4 = this$0.groupPanelView;
                if (groupPanelView4 != null) {
                    groupPanelView4.showEmptyStatus();
                    return;
                }
                return;
            case 3:
                GroupPanelView groupPanelView5 = this$0.groupPanelView;
                if (groupPanelView5 != null) {
                    GroupListModel listModel = state.getListModel();
                    Intrinsics.checkNotNull(listModel);
                    groupPanelView5.showPanelListStatus(listModel);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindVM$lambda-6  reason: not valid java name */
    public static final void m4432bindVM$lambda6(GroupPanelDialogFragment this$0, GroupListItemState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GroupPanelView groupPanelView2 = this$0.groupPanelView;
        if (groupPanelView2 != null) {
            groupPanelView2.updateSelectedState();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindVM$lambda-7  reason: not valid java name */
    public static final void m4433bindVM$lambda7(GroupPanelDialogFragment this$0, Boolean isCompleted) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isCompleted, "isCompleted");
        if (isCompleted.booleanValue()) {
            GroupListItemState value = this$0.getGroupPanelVM().getSelectedState().getValue();
            GroupListContentModel selectedModel = value != null ? value.getItemModel() : null;
            Function1<? super GroupListContentModel, Unit> function1 = this$0.onSelectedComplete;
            if (function1 != null) {
                function1.invoke(selectedModel);
            }
            this$0.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void loadData() {
        Context it = getContext();
        if (it != null) {
            GroupPanelViewModel groupPanelVM = getGroupPanelVM();
            Context applicationContext = it.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
            groupPanelVM.loadData(applicationContext, this.placeModel);
        }
    }
}
