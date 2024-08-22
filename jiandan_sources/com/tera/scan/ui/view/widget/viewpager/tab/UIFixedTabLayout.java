package com.tera.scan.ui.view.widget.viewpager.tab;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.view.helper.UIBaseHelper;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import com.tera.scan.ui.view.widget.UIView;
import fe.mmm.qw.f.de.de.fe.rg.ad;
import fe.mmm.qw.f.de.de.fe.rg.de;
import fe.mmm.qw.f.de.de.fe.rg.fe;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\n\u000f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J\u000e\u00109\u001a\u0002052\u0006\u00106\u001a\u00020\u0007J\u0012\u0010:\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\b\u0010=\u001a\u000205H\u0002J(\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\u000e\u0010E\u001a\u0002052\u0006\u00106\u001a\u00020\u0007R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u000e\u0010\"\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&XD¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR$\u0010*\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0015\u001a\u0004\u0018\u00010.@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006F"}, d2 = {"Lcom/tera/scan/ui/view/widget/viewpager/tab/UIFixedTabLayout;", "Lcom/tera/scan/ui/view/layout/UIFrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataObserver", "com/tera/scan/ui/view/widget/viewpager/tab/UIFixedTabLayout$dataObserver$1", "Lcom/tera/scan/ui/view/widget/viewpager/tab/UIFixedTabLayout$dataObserver$1;", "onAdapterChangeListener", "Landroidx/viewpager/widget/ViewPager$OnAdapterChangeListener;", "onPageChangeListener", "com/tera/scan/ui/view/widget/viewpager/tab/UIFixedTabLayout$onPageChangeListener$1", "Lcom/tera/scan/ui/view/widget/viewpager/tab/UIFixedTabLayout$onPageChangeListener$1;", "rootView", "scrollOffset", "", "scrollPos", "value", "selectBgColor", "getSelectBgColor", "()I", "setSelectBgColor", "(I)V", "selectBgOffsetView", "Landroid/widget/Space;", "selectBgView", "Lcom/tera/scan/ui/view/widget/UIView;", "selectTextColor", "getSelectTextColor", "setSelectTextColor", "selectTextSize", "tabContainer", "Landroid/widget/LinearLayout;", "tag", "", "unselectBgColor", "getUnselectBgColor", "setUnselectBgColor", "unselectTextColor", "getUnselectTextColor", "setUnselectTextColor", "unselectTextSize", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "addTab", "", "position", "title", "", "hideBadge", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDataChanged", "onSizeChanged", "w", "h", "oldw", "oldh", "refreshSelectBg", "refreshTab", "showRedPointBadge", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFixedTabLayout extends UIFrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    public final qw dataObserver;
    @NotNull
    public final ViewPager.OnAdapterChangeListener onAdapterChangeListener;
    @NotNull
    public final UIFixedTabLayout$onPageChangeListener$1 onPageChangeListener;
    @Nullable
    public UIFrameLayout rootView;
    public float scrollOffset;
    public int scrollPos;
    public int selectBgColor;
    @Nullable
    public Space selectBgOffsetView;
    @Nullable
    public UIView selectBgView;
    public int selectTextColor;
    public int selectTextSize;
    @Nullable
    public LinearLayout tabContainer;
    @NotNull
    public final String tag;
    public int unselectBgColor;
    public int unselectTextColor;
    public int unselectTextSize;
    @Nullable
    public ViewPager viewPager;

    public static final class qw extends DataSetObserver {
        public final /* synthetic */ UIFixedTabLayout qw;

        public qw(UIFixedTabLayout uIFixedTabLayout) {
            this.qw = uIFixedTabLayout;
        }

        public void onChanged() {
            this.qw.onDataChanged();
        }

        public void onInvalidated() {
            this.qw.onDataChanged();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIFixedTabLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIFixedTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIFixedTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.tag = "UIFixedTabLayout";
        this.selectTextColor = fe.mmm.qw.f.ad.fe.qw.qw.qw(context, R.color.ui_color_gc1);
        this.unselectTextColor = fe.mmm.qw.f.ad.fe.qw.qw.qw(context, R.color.ui_color_gc2);
        this.selectBgColor = fe.mmm.qw.f.ad.fe.qw.qw.qw(context, R.color.ui_color_gc9);
        this.unselectBgColor = fe.mmm.qw.f.ad.fe.qw.qw.qw(context, R.color.ui_color_gc8);
        this.selectTextSize = getResources().getDimensionPixelOffset(R.dimen.ui_text_dimen_f7);
        this.unselectTextSize = getResources().getDimensionPixelOffset(R.dimen.ui_text_dimen_f8);
        this.onPageChangeListener = new UIFixedTabLayout$onPageChangeListener$1(this);
        this.onAdapterChangeListener = new ad(this);
        this.dataObserver = new qw(this);
        setClipChildren(false);
        setClipToPadding(false);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ui_fixed_tab_layout, this, true);
        this.rootView = (UIFrameLayout) inflate.findViewById(R.id.ui_id_fixed_tab);
        this.selectBgOffsetView = (Space) inflate.findViewById(R.id.ui_id_select_offset);
        this.selectBgView = (UIView) inflate.findViewById(R.id.ui_id_select_bg);
        this.tabContainer = (LinearLayout) inflate.findViewById(R.id.ui_id_tab_container);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UIFixedTabLayout, i2, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…bLayout, defStyleAttr, 0)");
        setSelectTextColor(obtainStyledAttributes.getColor(1, this.selectTextColor));
        setUnselectTextColor(obtainStyledAttributes.getColor(3, this.unselectTextColor));
        setSelectBgColor(obtainStyledAttributes.getColor(0, this.selectBgColor));
        setUnselectBgColor(obtainStyledAttributes.getColor(2, this.unselectBgColor));
        obtainStyledAttributes.recycle();
    }

    private final void addTab(int i2, CharSequence charSequence) {
        fe.mmm.qw.f.ad.de.qw qwVar = fe.mmm.qw.f.ad.de.qw.qw;
        String str = this.tag;
        qwVar.qw(str, "addTab " + charSequence);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ui_fixed_tab_item, this, false);
        ((TextView) inflate.findViewById(R.id.ui_id_tab_text)).setText(charSequence);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        LinearLayout linearLayout = this.tabContainer;
        if (linearLayout != null) {
            linearLayout.addView(inflate, layoutParams);
        }
        inflate.setOnClickListener(new de(this, i2));
    }

    /* renamed from: addTab$lambda-3  reason: not valid java name */
    public static final void m928addTab$lambda3(UIFixedTabLayout uIFixedTabLayout, int i2, View view) {
        Intrinsics.checkNotNullParameter(uIFixedTabLayout, "this$0");
        ViewPager viewPager2 = uIFixedTabLayout.viewPager;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i2);
        }
    }

    /* renamed from: onAdapterChangeListener$lambda-2  reason: not valid java name */
    public static final void m929onAdapterChangeListener$lambda2(UIFixedTabLayout uIFixedTabLayout, ViewPager viewPager2, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        Object obj;
        Unit unit;
        Intrinsics.checkNotNullParameter(uIFixedTabLayout, "this$0");
        Intrinsics.checkNotNullParameter(viewPager2, "<anonymous parameter 0>");
        try {
            Result.Companion companion = Result.Companion;
            if (pagerAdapter != null) {
                pagerAdapter.unregisterDataSetObserver(uIFixedTabLayout.dataObserver);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = Result.m1155constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1158exceptionOrNullimpl(obj) != null) {
            fe.mmm.qw.f.ad.de.qw.qw.qw(uIFixedTabLayout.tag, "unregister data observer fail");
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(uIFixedTabLayout.dataObserver);
        }
        uIFixedTabLayout.onDataChanged();
    }

    /* renamed from: onConfigurationChanged$lambda-7  reason: not valid java name */
    public static final void m930onConfigurationChanged$lambda7(UIFixedTabLayout uIFixedTabLayout) {
        Intrinsics.checkNotNullParameter(uIFixedTabLayout, "this$0");
        uIFixedTabLayout.refreshSelectBg();
        uIFixedTabLayout.refreshTab();
    }

    /* access modifiers changed from: private */
    public final void onDataChanged() {
        CharSequence charSequence;
        ViewPager viewPager2 = this.viewPager;
        PagerAdapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
        int count = adapter != null ? adapter.getCount() : 0;
        LinearLayout linearLayout = this.tabContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        for (int i2 = 0; i2 < count; i2++) {
            if (adapter == null || (charSequence = adapter.getPageTitle(i2)) == null) {
                charSequence = "";
            }
            addTab(i2, charSequence);
        }
        refreshSelectBg();
        refreshTab();
    }

    /* renamed from: onSizeChanged$lambda-8  reason: not valid java name */
    public static final void m931onSizeChanged$lambda8(UIFixedTabLayout uIFixedTabLayout) {
        Intrinsics.checkNotNullParameter(uIFixedTabLayout, "this$0");
        uIFixedTabLayout.refreshSelectBg();
        uIFixedTabLayout.refreshTab();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1 = r1.getAdapter();
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refreshSelectBg() {
        /*
            r7 = this;
            int r0 = r7.getMeasuredWidth()
            androidx.viewpager.widget.ViewPager r1 = r7.viewPager
            r2 = 0
            if (r1 == 0) goto L_0x0014
            androidx.viewpager.widget.PagerAdapter r1 = r1.getAdapter()
            if (r1 == 0) goto L_0x0014
            int r1 = r1.getCount()
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r0 <= 0) goto L_0x0080
            if (r1 <= 0) goto L_0x0080
            int r0 = r0 / r1
            android.widget.Space r1 = r7.selectBgOffsetView
            r3 = 0
            if (r1 == 0) goto L_0x0024
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            goto L_0x0025
        L_0x0024:
            r1 = r3
        L_0x0025:
            if (r1 != 0) goto L_0x0028
            goto L_0x0036
        L_0x0028:
            int r4 = r7.scrollPos
            int r4 = r4 * r0
            float r4 = (float) r4
            float r5 = r7.scrollOffset
            float r6 = (float) r0
            float r5 = r5 * r6
            float r4 = r4 + r5
            int r4 = (int) r4
            r1.width = r4
        L_0x0036:
            android.widget.Space r4 = r7.selectBgOffsetView
            if (r4 != 0) goto L_0x003b
            goto L_0x003e
        L_0x003b:
            r4.setLayoutParams(r1)
        L_0x003e:
            com.tera.scan.ui.view.widget.UIView r1 = r7.selectBgView
            if (r1 == 0) goto L_0x0047
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            goto L_0x0048
        L_0x0047:
            r1 = r3
        L_0x0048:
            if (r1 != 0) goto L_0x004b
            goto L_0x0078
        L_0x004b:
            com.tera.scan.ui.view.widget.UIView r4 = r7.selectBgView
            if (r4 == 0) goto L_0x005f
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            boolean r5 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r5 != 0) goto L_0x0058
            r4 = r3
        L_0x0058:
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            if (r4 == 0) goto L_0x005f
            int r4 = r4.leftMargin
            goto L_0x0060
        L_0x005f:
            r4 = 0
        L_0x0060:
            int r0 = r0 - r4
            com.tera.scan.ui.view.widget.UIView r4 = r7.selectBgView
            if (r4 == 0) goto L_0x0075
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            boolean r5 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r5 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r3 = r4
        L_0x006f:
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
            if (r3 == 0) goto L_0x0075
            int r2 = r3.rightMargin
        L_0x0075:
            int r0 = r0 - r2
            r1.width = r0
        L_0x0078:
            com.tera.scan.ui.view.widget.UIView r0 = r7.selectBgView
            if (r0 != 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r0.setLayoutParams(r1)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.widget.viewpager.tab.UIFixedTabLayout.refreshSelectBg():void");
    }

    /* access modifiers changed from: private */
    public final void refreshTab() {
        Sequence<View> children;
        List<View> list;
        ViewPager viewPager2 = this.viewPager;
        int currentItem = viewPager2 != null ? viewPager2.getCurrentItem() : 0;
        LinearLayout linearLayout = this.tabContainer;
        if (linearLayout != null && (children = ViewGroupKt.getChildren(linearLayout)) != null && (list = SequencesKt___SequencesKt.toList(children)) != null) {
            int i2 = 0;
            for (T next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TextView textView = (TextView) ((View) next).findViewById(R.id.ui_id_tab_text);
                if (i2 == currentItem) {
                    if (textView != null) {
                        textView.setTextColor(this.selectTextColor);
                        textView.setTextSize(0, (float) this.selectTextSize);
                    }
                } else if (textView != null) {
                    textView.setTextColor(this.unselectTextColor);
                    textView.setTextSize(0, (float) this.unselectTextSize);
                }
                i2 = i3;
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getSelectBgColor() {
        return this.selectBgColor;
    }

    public final int getSelectTextColor() {
        return this.selectTextColor;
    }

    public final int getUnselectBgColor() {
        return this.unselectBgColor;
    }

    public final int getUnselectTextColor() {
        return this.unselectTextColor;
    }

    @Nullable
    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.getChildAt(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hideBadge(int r2) {
        /*
            r1 = this;
            android.widget.LinearLayout r0 = r1.tabContainer
            if (r0 == 0) goto L_0x0012
            android.view.View r2 = r0.getChildAt(r2)
            if (r2 == 0) goto L_0x0012
            r0 = 2131363796(0x7f0a07d4, float:1.834741E38)
            android.view.View r2 = r2.findViewById(r0)
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 != 0) goto L_0x0016
            goto L_0x001b
        L_0x0016:
            r0 = 8
            r2.setVisibility(r0)
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.widget.viewpager.tab.UIFixedTabLayout.hideBadge(int):void");
    }

    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        post(new fe(this));
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new fe.mmm.qw.f.de.de.fe.rg.qw(this));
    }

    public final void setSelectBgColor(int i2) {
        UIBaseHelper<UIView> helper;
        this.selectBgColor = i2;
        UIView uIView = this.selectBgView;
        if (uIView != null && (helper = uIView.getHelper()) != null) {
            helper.b(this.selectBgColor);
        }
    }

    public final void setSelectTextColor(int i2) {
        this.selectTextColor = i2;
        refreshTab();
    }

    public final void setUnselectBgColor(int i2) {
        this.unselectBgColor = i2;
        UIFrameLayout uIFrameLayout = this.rootView;
        if (uIFrameLayout != null) {
            uIFrameLayout.setBackgroundColor(i2);
        }
    }

    public final void setUnselectTextColor(int i2) {
        this.unselectTextColor = i2;
        refreshTab();
    }

    public final void setViewPager(@Nullable ViewPager viewPager2) {
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.removeOnAdapterChangeListener(this.onAdapterChangeListener);
        }
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 != null) {
            viewPager4.removeOnPageChangeListener(this.onPageChangeListener);
        }
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            viewPager2.addOnAdapterChangeListener(this.onAdapterChangeListener);
        }
        ViewPager viewPager5 = this.viewPager;
        if (viewPager5 != null) {
            viewPager5.addOnPageChangeListener(this.onPageChangeListener);
        }
        onDataChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.getChildAt(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showRedPointBadge(int r2) {
        /*
            r1 = this;
            android.widget.LinearLayout r0 = r1.tabContainer
            if (r0 == 0) goto L_0x0012
            android.view.View r2 = r0.getChildAt(r2)
            if (r2 == 0) goto L_0x0012
            r0 = 2131363796(0x7f0a07d4, float:1.834741E38)
            android.view.View r2 = r2.findViewById(r0)
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 != 0) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r0 = 0
            r2.setVisibility(r0)
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.widget.viewpager.tab.UIFixedTabLayout.showRedPointBadge(int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UIFixedTabLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
