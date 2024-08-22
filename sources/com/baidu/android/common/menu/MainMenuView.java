package com.baidu.android.common.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.menu.CommonMenuConfig;
import com.baidu.android.common.menu.MenuContentAdapter;
import com.baidu.android.common.menu.divider.CommonMenuDefaultDivider;
import com.baidu.android.common.menu.divider.CommonMenuTitleDivider;
import com.baidu.android.common.menu.divider.ICommonMenuMode;
import com.baidu.android.common.menu.listener.OnCommonMenuItemClickListener;
import com.baidu.android.common.menu.listener.OnCommonMenuItemShowListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0012\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u0014J\u0010\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u00010\u0019J.\u00103\u001a\u00020(2\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00162\b\u0010+\u001a\u0004\u0018\u00010\r2\b\u00105\u001a\u0004\u0018\u000106J4\u00103\u001a\u00020(2\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00162\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020.2\u0006\u00107\u001a\u00020&J$\u00108\u001a\u00020(2\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00162\u0006\u00105\u001a\u000206H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/android/common/menu/MainMenuView;", "Lcom/baidu/android/common/menu/BaseMenuView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapterList", "", "Lcom/baidu/android/common/menu/MenuContentAdapter;", "dividerList", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "mFirstMenuContentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mHeaderView", "mItemClickListener", "Lcom/baidu/android/common/menu/listener/OnCommonMenuItemClickListener;", "mItemLists", "", "Lcom/baidu/android/common/menu/CommonMenuItem;", "mItemShowListener", "Lcom/baidu/android/common/menu/listener/OnCommonMenuItemShowListener;", "mMainContentView", "mSecondMenuContentRecyclerView", "mThirdMenuContentRecyclerView", "mainContentLayout", "Landroid/widget/FrameLayout;", "getMainContentLayout", "()Landroid/widget/FrameLayout;", "recyclerViewList", "createDividerByConfig", "dividerConfig", "Lcom/baidu/android/common/menu/CommonMenuConfig$DividerConfig;", "isHighMenu", "", "notifyDataChanged", "", "reset", "setMenuHeader", "headerView", "setMode", "mode", "Lcom/baidu/android/common/menu/CommonMenuMode;", "setOnItemClickListener", "itemClickListener", "setOnItemShowListener", "itemShowListener", "update", "menuItemLists", "menuConfig", "Lcom/baidu/android/common/menu/CommonMenuConfig;", "isSingleLineSlide", "updateMenuData", "itemLists", "lib-common-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainMenuView.kt */
public final class MainMenuView extends BaseMenuView {
    public Map<Integer, View> _$_findViewCache;
    private final List<MenuContentAdapter> adapterList;
    private final List<View> dividerList;
    private final LinearLayout mContentLayout;
    private final RecyclerView mFirstMenuContentRecyclerView;
    private View mHeaderView;
    private OnCommonMenuItemClickListener mItemClickListener;
    private List<? extends List<? extends CommonMenuItem>> mItemLists;
    private OnCommonMenuItemShowListener mItemShowListener;
    private final LinearLayout mMainContentView;
    private final RecyclerView mSecondMenuContentRecyclerView;
    private final RecyclerView mThirdMenuContentRecyclerView;
    private final FrameLayout mainContentLayout;
    private final List<RecyclerView> recyclerViewList;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MainMenuView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MainMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LinearLayout $this$mContentLayout_u24lambda_u2d0 = new LinearLayout(context);
        $this$mContentLayout_u24lambda_u2d0.setOrientation(1);
        this.mContentLayout = $this$mContentLayout_u24lambda_u2d0;
        FrameLayout frameLayout = new FrameLayout(context);
        this.mainContentLayout = frameLayout;
        LinearLayout $this$mMainContentView_u24lambda_u2d1 = new LinearLayout(context);
        $this$mMainContentView_u24lambda_u2d1.setOrientation(1);
        this.mMainContentView = $this$mMainContentView_u24lambda_u2d1;
        List<RecyclerView> arrayList = new ArrayList<>();
        this.recyclerViewList = arrayList;
        this.adapterList = new ArrayList();
        this.dividerList = new ArrayList();
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(-1, -2);
        setContentView($this$mContentLayout_u24lambda_u2d0, llParams);
        $this$mContentLayout_u24lambda_u2d0.addView(frameLayout, llParams);
        frameLayout.addView($this$mMainContentView_u24lambda_u2d1, llParams);
        RecyclerView recyclerView = new RecyclerView(context, attrs, defStyleAttr);
        this.mFirstMenuContentRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.addItemDecoration(new MenuContentAdapter.MenuItemDecoration());
        $this$mMainContentView_u24lambda_u2d1.addView(recyclerView, llParams);
        arrayList.add(recyclerView);
        RecyclerView recyclerView2 = new RecyclerView(context, attrs, defStyleAttr);
        this.mSecondMenuContentRecyclerView = recyclerView2;
        recyclerView2.setVisibility(8);
        recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView2.addItemDecoration(new MenuContentAdapter.MenuItemDecoration());
        $this$mMainContentView_u24lambda_u2d1.addView(recyclerView2, llParams);
        arrayList.add(recyclerView2);
        RecyclerView recyclerView3 = new RecyclerView(context, attrs, defStyleAttr);
        this.mThirdMenuContentRecyclerView = recyclerView3;
        recyclerView3.setVisibility(8);
        recyclerView3.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView3.addItemDecoration(new MenuContentAdapter.MenuItemDecoration());
        $this$mMainContentView_u24lambda_u2d1.addView(recyclerView3, llParams);
        arrayList.add(recyclerView3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MainMenuView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final FrameLayout getMainContentLayout() {
        return this.mainContentLayout;
    }

    public boolean isHighMenu() {
        List it = this.mItemLists;
        if (it == null || it.size() <= 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void setMode(CommonMenuMode mode) {
        if (mode != null) {
            CommonMenuMode it = mode;
            for (View divider : this.dividerList) {
                if (divider instanceof ICommonMenuMode) {
                    ((ICommonMenuMode) divider).setMode(it);
                }
            }
        }
        super.setMode(mode);
    }

    public final void setOnItemClickListener(OnCommonMenuItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public final void setOnItemShowListener(OnCommonMenuItemShowListener itemShowListener) {
        this.mItemShowListener = itemShowListener;
    }

    private final void setMenuHeader(View headerView) {
        View view2 = this.mHeaderView;
        if (headerView != view2) {
            if (view2 != null) {
                this.mContentLayout.removeView(view2);
            }
            this.mHeaderView = headerView;
            if (headerView != null) {
                try {
                    this.mContentLayout.addView(headerView, 0);
                } catch (Exception e2) {
                }
            }
        }
    }

    public final void reset() {
        for (RecyclerView it : this.recyclerViewList) {
            it.scrollToPosition(0);
        }
    }

    public final void notifyDataChanged() {
        for (MenuContentAdapter it : this.adapterList) {
            it.notifyDataSetChanged();
        }
    }

    public final void update(List<? extends List<? extends CommonMenuItem>> menuItemLists, View headerView, CommonMenuMode mode, boolean isSingleLineSlide) {
        Intrinsics.checkNotNullParameter(menuItemLists, "menuItemLists");
        Intrinsics.checkNotNullParameter(mode, "mode");
        CommonMenuConfig menuConfig = new CommonMenuConfig();
        CommonMenuConfig $this$update_u24lambda_u2d6 = menuConfig;
        $this$update_u24lambda_u2d6.setMenuMode(mode);
        $this$update_u24lambda_u2d6.setSingleLineSlide(isSingleLineSlide);
        setMenuHeader(headerView);
        updateMenuData(menuItemLists, menuConfig);
        setMode(mode);
    }

    public final void update(List<? extends List<? extends CommonMenuItem>> menuItemLists, View headerView, CommonMenuConfig menuConfig) {
        Intrinsics.checkNotNullParameter(menuItemLists, "menuItemLists");
        CommonMenuConfig config = menuConfig == null ? new CommonMenuConfig() : menuConfig;
        setMenuHeader(headerView);
        updateMenuData(menuItemLists, config);
        setMode(config.getMenuMode());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: com.baidu.android.common.menu.CommonMenuConfig$DividerConfig} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateMenuData(java.util.List<? extends java.util.List<? extends com.baidu.android.common.menu.CommonMenuItem>> r25, com.baidu.android.common.menu.CommonMenuConfig r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r0.mItemLists = r1
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            boolean r4 = r2 instanceof java.util.Collection
            r6 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r4 == 0) goto L_0x001e
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x001e
            r4 = 0
            goto L_0x0046
        L_0x001e:
            r4 = 0
            java.util.Iterator r8 = r2.iterator()
        L_0x0023:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0045
            java.lang.Object r9 = r8.next()
            r10 = r9
            java.util.List r10 = (java.util.List) r10
            r11 = 0
            int r12 = r10.size()
            r13 = 5
            if (r12 <= r13) goto L_0x003a
            r10 = r6
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            if (r10 == 0) goto L_0x0023
            int r4 = r4 + 1
            if (r4 >= 0) goto L_0x0023
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x0023
        L_0x0045:
        L_0x0046:
            r2 = r4
            java.util.List<android.view.View> r3 = r0.dividerList
            java.util.Iterator r3 = r3.iterator()
        L_0x004d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005f
            java.lang.Object r4 = r3.next()
            android.view.View r4 = (android.view.View) r4
            android.widget.LinearLayout r8 = r0.mMainContentView
            r8.removeView(r4)
            goto L_0x004d
        L_0x005f:
            java.util.List<android.view.View> r3 = r0.dividerList
            r3.clear()
            com.baidu.android.common.menu.CommonMenuMode r3 = r26.getMenuMode()
            java.util.Map r4 = r26.getDividerConfigMap()
            if (r4 != 0) goto L_0x0075
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Map r4 = (java.util.Map) r4
        L_0x0075:
            boolean r8 = r26.isSingleLineSlide()
            if (r8 == 0) goto L_0x008a
            java.lang.Object r8 = r4.get(r7)
            if (r8 != 0) goto L_0x008a
            com.baidu.android.common.menu.CommonMenuConfig$DividerConfig r8 = new com.baidu.android.common.menu.CommonMenuConfig$DividerConfig
            r9 = 0
            r8.<init>(r9, r6, r9)
            r4.put(r7, r8)
        L_0x008a:
            r7 = 2
            int r8 = r25.size()
            int r8 = r8 - r6
            int r7 = java.lang.Math.min(r7, r8)
            r8 = r4
            r9 = 0
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.util.Map r10 = (java.util.Map) r10
            r11 = r8
            r12 = 0
            java.util.Set r13 = r11.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x00a7:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00d5
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r15 = r14
            r16 = 0
            java.lang.Object r17 = r15.getKey()
            java.lang.Number r17 = (java.lang.Number) r17
            int r5 = r17.intValue()
            if (r6 > r5) goto L_0x00c6
            if (r5 > r7) goto L_0x00c6
            r5 = r6
            goto L_0x00c7
        L_0x00c6:
            r5 = 0
        L_0x00c7:
            if (r5 == 0) goto L_0x00a7
            java.lang.Object r5 = r14.getKey()
            java.lang.Object r15 = r14.getValue()
            r10.put(r5, r15)
            goto L_0x00a7
        L_0x00d5:
            java.util.Map r4 = kotlin.collections.MapsKt.toMutableMap(r10)
            java.util.SortedMap r5 = kotlin.collections.MapsKt.toSortedMap(r4)
            r8 = 0
            java.util.List<androidx.recyclerview.widget.RecyclerView> r9 = r0.recyclerViewList
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            r10 = 0
            r11 = 0
            java.util.Iterator r12 = r9.iterator()
        L_0x00ea:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01e7
            java.lang.Object r13 = r12.next()
            int r14 = r11 + 1
            if (r11 >= 0) goto L_0x00fb
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00fb:
            r15 = r13
            androidx.recyclerview.widget.RecyclerView r15 = (androidx.recyclerview.widget.RecyclerView) r15
            r16 = 0
            int r17 = r25.size()
            r18 = 0
            r19 = r5
            java.util.Map r19 = (java.util.Map) r19
            boolean r19 = r19.isEmpty()
            r19 = r19 ^ 1
            if (r19 == 0) goto L_0x0135
            java.lang.Object r6 = r5.firstKey()
            r20 = r4
            java.lang.String r4 = "sortedDividers.firstKey()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            java.lang.Number r6 = (java.lang.Number) r6
            int r17 = r6.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Object r4 = r5.remove(r4)
            r18 = r4
            com.baidu.android.common.menu.CommonMenuConfig$DividerConfig r18 = (com.baidu.android.common.menu.CommonMenuConfig.DividerConfig) r18
            r4 = r17
            r6 = r18
            goto L_0x013b
        L_0x0135:
            r20 = r4
            r4 = r17
            r6 = r18
        L_0x013b:
            r17 = r5
            java.util.List r5 = r1.subList(r8, r4)
            r8 = r4
            boolean r18 = r5.isEmpty()
            if (r18 == 0) goto L_0x016a
            r1 = 8
            r15.setVisibility(r1)
            java.util.List<com.baidu.android.common.menu.MenuContentAdapter> r1 = r0.adapterList
            int r1 = r1.size()
            if (r11 >= r1) goto L_0x0162
            java.util.List<com.baidu.android.common.menu.MenuContentAdapter> r1 = r0.adapterList
            r1.remove(r11)
            r22 = r2
            r23 = r3
            r21 = r4
            goto L_0x01d9
        L_0x0162:
            r22 = r2
            r23 = r3
            r21 = r4
            goto L_0x01d9
        L_0x016a:
            r1 = 0
            r15.setVisibility(r1)
            java.util.List<com.baidu.android.common.menu.MenuContentAdapter> r1 = r0.adapterList
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r1, r11)
            com.baidu.android.common.menu.MenuContentAdapter r1 = (com.baidu.android.common.menu.MenuContentAdapter) r1
            if (r1 != 0) goto L_0x0191
            r18 = r1
            com.baidu.android.common.menu.MenuContentAdapter r1 = new com.baidu.android.common.menu.MenuContentAdapter
            r21 = r4
            android.content.Context r4 = r24.getContext()
            r1.<init>(r4)
            r4 = r1
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = (androidx.recyclerview.widget.RecyclerView.Adapter) r4
            r15.setAdapter(r4)
            java.util.List<com.baidu.android.common.menu.MenuContentAdapter> r4 = r0.adapterList
            r4.add(r11, r1)
            goto L_0x0195
        L_0x0191:
            r18 = r1
            r21 = r4
        L_0x0195:
            r1.setMode(r3)
            boolean r4 = r26.getIconSupportDark()
            r1.setIconSupportDark(r4)
            com.baidu.android.common.menu.listener.OnCommonMenuItemClickListener r4 = r0.mItemClickListener
            r1.setOnItemClickListener(r4)
            com.baidu.android.common.menu.listener.OnCommonMenuItemShowListener r4 = r0.mItemShowListener
            r1.setOnItemShowListener(r4)
            if (r2 <= 0) goto L_0x01ad
            r4 = 1
            goto L_0x01ae
        L_0x01ad:
            r4 = 0
        L_0x01ae:
            r1.updateData(r5, r4)
            if (r6 == 0) goto L_0x01d3
            android.view.View r4 = r0.createDividerByConfig(r6)
            r18 = r1
            android.widget.LinearLayout r1 = r0.mMainContentView
            r22 = r2
            r2 = r15
            android.view.View r2 = (android.view.View) r2
            int r1 = r1.indexOfChild(r2)
            android.widget.LinearLayout r2 = r0.mMainContentView
            r23 = r3
            int r3 = r1 + 1
            r2.addView(r4, r3)
            java.util.List<android.view.View> r2 = r0.dividerList
            r2.add(r4)
            goto L_0x01d9
        L_0x01d3:
            r18 = r1
            r22 = r2
            r23 = r3
        L_0x01d9:
            r1 = r25
            r11 = r14
            r5 = r17
            r4 = r20
            r2 = r22
            r3 = r23
            r6 = 1
            goto L_0x00ea
        L_0x01e7:
            com.baidu.android.common.menu.CommonMenuMode r1 = r26.getMenuMode()
            r0.setMode(r1)
            r24.updateTitleSize()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.menu.MainMenuView.updateMenuData(java.util.List, com.baidu.android.common.menu.CommonMenuConfig):void");
    }

    private final View createDividerByConfig(CommonMenuConfig.DividerConfig dividerConfig) {
        if (dividerConfig.getTitle().length() == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            CommonMenuDefaultDivider commonMenuDefaultDivider = new CommonMenuDefaultDivider(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            CommonMenuDefaultDivider $this$createDividerByConfig_u24lambda_u2d11 = commonMenuDefaultDivider;
            int hMargin = $this$createDividerByConfig_u24lambda_u2d11.getResources().getDimensionPixelSize(R.dimen.main_menu_divider_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 1);
            ViewGroup.MarginLayoutParams $this$createDividerByConfig_u24lambda_u2d11_u24lambda_u2d10 = marginLayoutParams;
            $this$createDividerByConfig_u24lambda_u2d11_u24lambda_u2d10.leftMargin = hMargin;
            $this$createDividerByConfig_u24lambda_u2d11_u24lambda_u2d10.rightMargin = hMargin;
            $this$createDividerByConfig_u24lambda_u2d11.setLayoutParams(marginLayoutParams);
            return commonMenuDefaultDivider;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        CommonMenuTitleDivider $this$createDividerByConfig_u24lambda_u2d12 = new CommonMenuTitleDivider(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createDividerByConfig_u24lambda_u2d12.setTitle(dividerConfig.getTitle());
        return $this$createDividerByConfig_u24lambda_u2d12;
    }
}
