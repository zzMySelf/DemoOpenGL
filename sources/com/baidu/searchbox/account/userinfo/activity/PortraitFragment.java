package com.baidu.searchbox.account.userinfo.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.app.account.utils.AvatarBusinessUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.manager.PortraitDataManager;
import com.baidu.searchbox.account.userinfo.data.PortraitCategoryData;
import com.baidu.searchbox.appframework.fragment.BaseFragment;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.video.template.fullitem.LandscapeVideoFlowTemplateBaseViewKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002$%B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u000eH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/PortraitFragment;", "Lcom/baidu/searchbox/appframework/fragment/BaseFragment;", "()V", "tabItemInfo", "Lcom/baidu/searchbox/account/userinfo/activity/PortraitFragment$PortraitMultiTabItemInfo;", "portraitDataManager", "Lcom/baidu/searchbox/account/manager/PortraitDataManager;", "selectedPortraitUrl", "", "portraitUbcFrom", "bannerClickListener", "Landroid/view/View$OnClickListener;", "(Lcom/baidu/searchbox/account/userinfo/activity/PortraitFragment$PortraitMultiTabItemInfo;Lcom/baidu/searchbox/account/manager/PortraitDataManager;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "itemSpace", "", "getItemSpace", "()I", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "refresIndexItemView", "indexOfDataList", "PortraitAdapter", "PortraitMultiTabItemInfo", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitSettingActivity.kt */
public final class PortraitFragment extends BaseFragment {
    public Map<Integer, View> _$_findViewCache;
    private final View.OnClickListener bannerClickListener;
    private final int itemSpace;
    private final PortraitDataManager portraitDataManager;
    private String portraitUbcFrom;
    private RecyclerView recyclerView;
    private String selectedPortraitUrl;
    private final PortraitMultiTabItemInfo tabItemInfo;

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

    public PortraitFragment(PortraitMultiTabItemInfo tabItemInfo2, PortraitDataManager portraitDataManager2, String selectedPortraitUrl2, String portraitUbcFrom2, View.OnClickListener bannerClickListener2) {
        this._$_findViewCache = new LinkedHashMap();
        this.tabItemInfo = tabItemInfo2;
        this.portraitDataManager = portraitDataManager2;
        this.selectedPortraitUrl = selectedPortraitUrl2;
        this.portraitUbcFrom = portraitUbcFrom2;
        this.bannerClickListener = bannerClickListener2;
        this.itemSpace = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 12.0f);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PortraitFragment(com.baidu.searchbox.account.userinfo.activity.PortraitFragment.PortraitMultiTabItemInfo r7, com.baidu.searchbox.account.manager.PortraitDataManager r8, java.lang.String r9, java.lang.String r10, android.view.View.OnClickListener r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0008
            java.lang.String r9 = ""
            r3 = r9
            goto L_0x0009
        L_0x0008:
            r3 = r9
        L_0x0009:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0010
            r10 = 0
            r4 = r10
            goto L_0x0011
        L_0x0010:
            r4 = r10
        L_0x0011:
            r0 = r6
            r1 = r7
            r2 = r8
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.activity.PortraitFragment.<init>(com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo, com.baidu.searchbox.account.manager.PortraitDataManager, java.lang.String, java.lang.String, android.view.View$OnClickListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView2) {
        this.recyclerView = recyclerView2;
    }

    public final int getItemSpace() {
        return this.itemSpace;
    }

    public PortraitFragment() {
        this((PortraitMultiTabItemInfo) null, (PortraitDataManager) null, (String) null, (String) null, (View.OnClickListener) null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.tabItemInfo != null) {
            BdEventBus.Companion.getDefault().register(this, SelectedPortraitEvent.class, new PortraitFragment$$ExternalSyntheticLambda0(this));
            BdEventBus.Companion.getDefault().register(this, UploadedPortraitEvent.class, new PortraitFragment$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        r0 = r0.getPortraitInfo();
     */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m14502onCreate$lambda0(com.baidu.searchbox.account.userinfo.activity.PortraitFragment r2, com.baidu.searchbox.account.userinfo.activity.SelectedPortraitEvent r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.baidu.searchbox.account.manager.PortraitDataManager$HeadPortraitData r0 = r3.getUnSelected()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = ""
            r2.selectedPortraitUrl = r0
        L_0x0016:
            com.baidu.searchbox.account.manager.PortraitDataManager$HeadPortraitData r0 = r3.getUnSelected()
            if (r0 == 0) goto L_0x0025
            com.baidu.searchbox.account.dialog.SapiPortraitInfo r0 = r0.getPortraitInfo()
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.category
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r1 = r2.tabItemInfo
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r1 = r1.getData()
            java.lang.String r1 = r1.getCategory()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x004b
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r0 = r2.tabItemInfo
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r0 = r0.getData()
            java.util.List r0 = r0.getItems()
            com.baidu.searchbox.account.manager.PortraitDataManager$HeadPortraitData r1 = r3.getUnSelected()
            int r0 = r0.indexOf(r1)
            r2.refresIndexItemView(r0)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.activity.PortraitFragment.m14502onCreate$lambda0(com.baidu.searchbox.account.userinfo.activity.PortraitFragment, com.baidu.searchbox.account.userinfo.activity.SelectedPortraitEvent):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        r1 = r1.getPortraitInfo();
     */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m14503onCreate$lambda2(com.baidu.searchbox.account.userinfo.activity.PortraitFragment r8, com.baidu.searchbox.account.userinfo.activity.UploadedPortraitEvent r9) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r0 = r8.tabItemInfo
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r0 = r0.getData()
            java.util.List r0 = r0.getItems()
            java.lang.String r1 = "tabItemInfo.data.items"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L_0x0022:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003d
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.baidu.searchbox.account.manager.PortraitDataManager$HeadPortraitData r5 = (com.baidu.searchbox.account.manager.PortraitDataManager.HeadPortraitData) r5
            r6 = 0
            com.baidu.searchbox.account.dialog.SapiPortraitInfo r7 = r5.getPortraitInfo()
            boolean r5 = r7.isUploaded
            if (r5 == 0) goto L_0x0039
            goto L_0x003f
        L_0x0039:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x003d:
            r3 = -1
            r2 = r3
        L_0x003f:
            r0 = r2
            r8.refresIndexItemView(r0)
            com.baidu.searchbox.account.manager.PortraitDataManager$HeadPortraitData r1 = r9.getUploadedData()
            if (r1 == 0) goto L_0x0053
            com.baidu.searchbox.account.dialog.SapiPortraitInfo r1 = r1.getPortraitInfo()
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = r1.category
            goto L_0x0054
        L_0x0053:
            r1 = 0
        L_0x0054:
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r2 = r8.tabItemInfo
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r2 = r2.getData()
            java.lang.String r2 = r2.getCategory()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0070
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r1 = r8.tabItemInfo
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r1 = r1.getData()
            boolean r1 = r1.isHot()
            if (r1 == 0) goto L_0x0085
        L_0x0070:
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r1 = r8.tabItemInfo
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r1 = r1.getData()
            java.util.List r1 = r1.getItems()
            com.baidu.searchbox.account.manager.PortraitDataManager$HeadPortraitData r2 = r9.getUploadedData()
            int r1 = r1.indexOf(r2)
            r8.refresIndexItemView(r1)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.activity.PortraitFragment.m14503onCreate$lambda2(com.baidu.searchbox.account.userinfo.activity.PortraitFragment, com.baidu.searchbox.account.userinfo.activity.UploadedPortraitEvent):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0005: MOVE  (r1v0 'refreshIndex' int) = (r4v0 'indexOfDataList' int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private final void refresIndexItemView(int r4) {
        /*
            r3 = this;
            com.baidu.searchbox.account.userinfo.activity.PortraitFragment$PortraitMultiTabItemInfo r0 = r3.tabItemInfo
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = r4
            r2 = -1
            if (r1 == r2) goto L_0x0027
            com.baidu.searchbox.account.userinfo.data.PortraitCategoryData r0 = r0.getData()
            boolean r0 = com.baidu.searchbox.account.userinfo.activity.PortraitSettingActivityKt.showBanner(r0)
            if (r0 == 0) goto L_0x0015
            int r1 = r1 + 1
        L_0x0015:
            androidx.recyclerview.widget.RecyclerView r0 = r3.recyclerView
            if (r0 == 0) goto L_0x0027
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x0027
            r2 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.notifyItemChanged(r1, r2)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.activity.PortraitFragment.refresIndexItemView(int):void");
    }

    public void onDestroy() {
        super.onDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PortraitMultiTabItemInfo portraitMultiTabItemInfo;
        List categoryDataItems;
        RecyclerView recyclerView2;
        RecyclerView.Adapter adapter;
        LayoutInflater layoutInflater = inflater;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View view2 = layoutInflater.inflate(R.layout.account_portrait_category, container, false);
        RecyclerView recyclerView3 = (RecyclerView) view2.findViewById(R.id.recycler_view);
        RecyclerView $this$onCreateView_u24lambda_u2d3 = recyclerView3;
        $this$onCreateView_u24lambda_u2d3.setBackgroundColor($this$onCreateView_u24lambda_u2d3.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC9));
        GridLayoutManager layoutManager = new GridLayoutManager($this$onCreateView_u24lambda_u2d3.getContext(), 4, 1, false);
        layoutManager.setSpanSizeLookup(new PortraitFragment$onCreateView$1$1($this$onCreateView_u24lambda_u2d3));
        $this$onCreateView_u24lambda_u2d3.setLayoutManager(layoutManager);
        if (!(this.tabItemInfo == null || this.portraitDataManager == null || this.bannerClickListener == null)) {
            $this$onCreateView_u24lambda_u2d3.setAdapter(new PortraitAdapter(this.tabItemInfo.getData(), this.portraitDataManager, this.bannerClickListener, this.portraitUbcFrom));
        }
        $this$onCreateView_u24lambda_u2d3.addItemDecoration(new PortraitFragment$onCreateView$1$2(this));
        this.recyclerView = recyclerView3;
        CharSequence charSequence = this.selectedPortraitUrl;
        if (!((charSequence == null || charSequence.length() == 0) || (portraitMultiTabItemInfo = this.tabItemInfo) == null || (categoryDataItems = portraitMultiTabItemInfo.getData().getItems()) == null)) {
            RecyclerView recyclerView4 = this.recyclerView;
            int itemCount = (recyclerView4 == null || (adapter = recyclerView4.getAdapter()) == null) ? 0 : adapter.getItemCount();
            int index$iv = 0;
            Iterator<PortraitDataManager.HeadPortraitData> it = categoryDataItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    index$iv = -1;
                    break;
                } else if (PortraitSettingActivityKt.isPortraitHit(it.next(), this.selectedPortraitUrl)) {
                    break;
                } else {
                    index$iv++;
                }
            }
            int indexOf = index$iv;
            if (indexOf >= 0 && indexOf < itemCount) {
                PortraitDataManager.HeadPortraitData headPortraitData = categoryDataItems.get(indexOf);
                headPortraitData.setListSelected(true);
                PortraitDataManager manager = this.portraitDataManager;
                if (manager != null) {
                    manager.setSelectPortraitInfo(headPortraitData);
                    BdEventBus bdEventBus = BdEventBus.Companion.getDefault();
                    PortraitDataManager.HeadPortraitData selectPortraitInfo = manager.getSelectPortraitInfo();
                    Intrinsics.checkNotNullExpressionValue(selectPortraitInfo, "manager.selectPortraitInfo");
                    bdEventBus.post(new SelectedPortraitEvent(selectPortraitInfo, (PortraitDataManager.HeadPortraitData) null));
                }
                if (PortraitSettingActivityKt.showBanner(this.tabItemInfo.getData())) {
                    int i2 = indexOf + 1;
                    if ((i2 >= 0 && i2 < itemCount) && (recyclerView2 = this.recyclerView) != null) {
                        recyclerView2.scrollToPosition(indexOf + 1);
                    }
                } else {
                    RecyclerView recyclerView5 = this.recyclerView;
                    if (recyclerView5 != null) {
                        recyclerView5.scrollToPosition(indexOf);
                    }
                }
            }
        }
        return view2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/PortraitFragment$PortraitMultiTabItemInfo;", "Lcom/baidu/searchbox/feed/tab/update/MultiTabItemInfo;", "data", "Lcom/baidu/searchbox/account/userinfo/data/PortraitCategoryData;", "(Lcom/baidu/searchbox/account/userinfo/data/PortraitCategoryData;)V", "getData", "()Lcom/baidu/searchbox/account/userinfo/data/PortraitCategoryData;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PortraitSettingActivity.kt */
    public static final class PortraitMultiTabItemInfo extends MultiTabItemInfo {
        private final PortraitCategoryData data;

        public final PortraitCategoryData getData() {
            return this.data;
        }

        public PortraitMultiTabItemInfo(PortraitCategoryData data2) {
            int i2;
            Intrinsics.checkNotNullParameter(data2, "data");
            this.data = data2;
            this.mTitle = data2.getCategory();
            this.mId = data2.getCategory();
            this.tabNameImgModel = data2.getTabNameImgModel();
            this.indicatorColor = AppRuntime.getAppContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC7);
            Resources resources = AppRuntime.getAppContext().getResources();
            if (PortraitSettingActivityKt.isAiPortrait(data2)) {
                i2 = com.baidu.android.common.ui.style.R.color.GC7;
            } else {
                i2 = com.baidu.android.common.ui.style.R.color.GC1;
            }
            this.selectColor = resources.getColor(i2);
            this.normalColor = AppRuntime.getAppContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4);
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/PortraitFragment$PortraitAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "Lcom/baidu/searchbox/account/userinfo/data/PortraitCategoryData;", "dataManager", "Lcom/baidu/searchbox/account/manager/PortraitDataManager;", "bannerClickListener", "Landroid/view/View$OnClickListener;", "portraitUbcFrom", "", "(Lcom/baidu/searchbox/account/userinfo/data/PortraitCategoryData;Lcom/baidu/searchbox/account/manager/PortraitDataManager;Landroid/view/View$OnClickListener;Ljava/lang/String;)V", "bannerHeight", "", "showBanner", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PortraitSettingActivity.kt */
    public static final class PortraitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final View.OnClickListener bannerClickListener;
        private final int bannerHeight;
        private final PortraitCategoryData data;
        private final PortraitDataManager dataManager;
        private final String portraitUbcFrom;
        private final boolean showBanner;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PortraitAdapter(PortraitCategoryData portraitCategoryData, PortraitDataManager portraitDataManager, View.OnClickListener onClickListener, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(portraitCategoryData, portraitDataManager, onClickListener, (i2 & 8) != 0 ? null : str);
        }

        public PortraitAdapter(PortraitCategoryData data2, PortraitDataManager dataManager2, View.OnClickListener bannerClickListener2, String portraitUbcFrom2) {
            Intrinsics.checkNotNullParameter(data2, "data");
            Intrinsics.checkNotNullParameter(dataManager2, "dataManager");
            Intrinsics.checkNotNullParameter(bannerClickListener2, "bannerClickListener");
            this.data = data2;
            this.dataManager = dataManager2;
            this.bannerClickListener = bannerClickListener2;
            this.portraitUbcFrom = portraitUbcFrom2;
            this.showBanner = PortraitSettingActivityKt.showBanner(data2);
            this.bannerHeight = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 52.0f);
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
            if (viewType == 1) {
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(parent.getContext());
                SimpleDraweeView $this$onCreateViewHolder_u24lambda_u2d0 = simpleDraweeView;
                $this$onCreateViewHolder_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, this.bannerHeight));
                $this$onCreateViewHolder_u24lambda_u2d0.setScaleType(ImageView.ScaleType.FIT_XY);
                ((GenericDraweeHierarchy) $this$onCreateViewHolder_u24lambda_u2d0.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
                ((GenericDraweeHierarchy) $this$onCreateViewHolder_u24lambda_u2d0.getHierarchy()).setFailureImage((Drawable) null);
                return new BannerViewHolder(simpleDraweeView);
            } else if (viewType == 3) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                return new BottomMoreViewHolder(new BottomMoreItemView(context, this.portraitUbcFrom));
            } else {
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                return new PortraitViewHolder(new PortraitItemView(context2, this.dataManager));
            }
        }

        public int getItemViewType(int position) {
            if (this.showBanner && position == 0) {
                return 1;
            }
            if (position == this.data.getItems().size()) {
                return 3;
            }
            return 2;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int i2;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof PortraitViewHolder) {
                PortraitItemView itemview = ((PortraitViewHolder) holder).getItemview();
                List<PortraitDataManager.HeadPortraitData> items = this.data.getItems();
                if (this.showBanner) {
                    i2 = position - 1;
                } else {
                    i2 = position;
                }
                PortraitItemView.bind$default(itemview, items.get(i2), false, this.data.isHot(), this.portraitUbcFrom, 2, (Object) null);
            } else if (holder instanceof BannerViewHolder) {
                ((BannerViewHolder) holder).getItemview().setImageURI(AvatarBusinessUtils.getEditBannerUrl());
                ((BannerViewHolder) holder).getItemview().setOnClickListener(this.bannerClickListener);
            }
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
            int i2;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, LandscapeVideoFlowTemplateBaseViewKt.KEY_PAY_LOADS);
            if (holder instanceof PortraitViewHolder) {
                PortraitItemView itemview = ((PortraitViewHolder) holder).getItemview();
                List<PortraitDataManager.HeadPortraitData> items = this.data.getItems();
                if (this.showBanner) {
                    i2 = position - 1;
                } else {
                    i2 = position;
                }
                itemview.bind(items.get(i2), !payloads.isEmpty(), this.data.isHot(), this.portraitUbcFrom);
            } else if (holder instanceof BannerViewHolder) {
                ((BannerViewHolder) holder).getItemview().setImageURI(AvatarBusinessUtils.getEditBannerUrl());
                ((BannerViewHolder) holder).getItemview().setOnClickListener(this.bannerClickListener);
            }
        }

        public int getItemCount() {
            if (this.showBanner) {
                return this.data.getItems().size() + 2;
            }
            return this.data.getItems().size() + 1;
        }
    }
}
