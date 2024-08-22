package com.baidu.searchbox.sport.page.olympic.schedule.filter.tab;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.model.GradationInfo;
import com.baidu.searchbox.sport.page.olympic.schedule.comp.OlympicScheduleConfig;
import com.baidu.searchbox.sport.page.olympic.schedule.filter.model.OlympicTabAd;
import com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel;
import com.baidu.searchbox.sport.statistic.SportStats;
import com.baidu.searchbox.sport.utils.SportBrowserUtils;
import com.baidu.searchbox.sport.widget.olympic.OlympicScheduleTabLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u00100\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u00101\u001a\u00020\u00162\f\u00102\u001a\b\u0012\u0004\u0012\u0002030$H\u0002J\u0018\u00104\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0002H\u0016J\u0010\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020'H\u0002J\b\u0010:\u001a\u00020\u0016H\u0003J\b\u0010;\u001a\u00020\u0016H\u0002J\b\u0010<\u001a\u00020\u0016H\u0002J\u0018\u0010=\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\rH\u0002J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\rH\u0002J\u000e\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\rJ\b\u0010B\u001a\u00020\u0016H\u0002J\u001a\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u0016\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020'R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRL\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\n \u000f*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n \u000f*\u0004\u0018\u00010)0)X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n \u000f*\u0004\u0018\u00010+0+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/tab/ScheduleFilterTabComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/tab/ScheduleFilterTabVM;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "config", "Lcom/baidu/searchbox/sport/page/olympic/schedule/comp/OlympicScheduleConfig;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/sport/page/olympic/schedule/comp/OlympicScheduleConfig;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "isSelectedByClick", "", "leftShader", "kotlin.jvm.PlatformType", "onTabReClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "getOnTabReClick", "()Lkotlin/jvm/functions/Function1;", "setOnTabReClick", "(Lkotlin/jvm/functions/Function1;)V", "onTabSelected", "Lkotlin/Function2;", "byClick", "getOnTabSelected", "()Lkotlin/jvm/functions/Function2;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function2;)V", "rightShader", "schTabGradation", "", "Lcom/baidu/searchbox/sport/model/GradationInfo;", "schTabTextColor", "", "tabAdImageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "tabLayout", "Lcom/baidu/searchbox/sport/widget/olympic/OlympicScheduleTabLayout;", "bindAnchorTab", "viewModel", "bindShowTabArrow", "bindTabAd", "bindTabData", "initTabList", "tabList", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/model/ScheduleFilterModel;", "onBindViewModel", "onCreateViewModel", "onNightModeChange", "isNightMode", "setAdImageData", "adImageUrl", "setCustomTab", "setTabClickListener", "setTabSelectedAppearance", "showArrow", "show", "showShader", "updateArrowDirection", "isDown", "updateTabLayoutStyle", "updateTabStyle", "selected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "updateTabTitle", "index", "title", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScheduleFilterTabComp.kt */
public final class ScheduleFilterTabComp extends BaseExtSlaveComponent<ScheduleFilterTabVM> {
    private final OlympicScheduleConfig config;
    /* access modifiers changed from: private */
    public boolean isSelectedByClick;
    private final View leftShader;
    private Function1<? super Integer, Unit> onTabReClick;
    private Function2<? super Integer, ? super Boolean, Unit> onTabSelected;
    private final View rightShader;
    private List<GradationInfo> schTabGradation = new ArrayList();
    private String schTabTextColor = "";
    private final SimpleDraweeView tabAdImageView;
    /* access modifiers changed from: private */
    public final OlympicScheduleTabLayout tabLayout;
    private final UniqueId token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleFilterTabComp(LifecycleOwner owner, View view2, OlympicScheduleConfig config2, UniqueId token2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.config = config2;
        this.token = token2;
        this.leftShader = view2.findViewById(R.id.tabLeftShader);
        this.rightShader = view2.findViewById(R.id.tabRightShader);
        OlympicScheduleTabLayout $this$tabLayout_u24lambda_u2d0 = (OlympicScheduleTabLayout) view2.findViewById(R.id.viewTab);
        $this$tabLayout_u24lambda_u2d0.setOnTabScrollStateChange(new ScheduleFilterTabComp$tabLayout$1$1(this));
        this.tabLayout = $this$tabLayout_u24lambda_u2d0;
        this.tabAdImageView = (SimpleDraweeView) view2.findViewById(R.id.tabAdImageView);
    }

    public final Function1<Integer, Unit> getOnTabReClick() {
        return this.onTabReClick;
    }

    public final void setOnTabReClick(Function1<? super Integer, Unit> function1) {
        this.onTabReClick = function1;
    }

    public final Function2<Integer, Boolean, Unit> getOnTabSelected() {
        return this.onTabSelected;
    }

    public final void setOnTabSelected(Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.onTabSelected = function2;
    }

    public final void updateTabTitle(int index, String title) {
        ScheduleFilterModel scheduleFilterModel;
        Object name;
        Intrinsics.checkNotNullParameter(title, "title");
        Object tabTitle = title;
        boolean z = true;
        if (((CharSequence) tabTitle).length() == 0) {
            List value = ((ScheduleFilterTabVM) getViewModel()).getTabData().getValue();
            if (value != null && (scheduleFilterModel = (ScheduleFilterModel) CollectionsKt.getOrNull(value, index)) != null && (name = scheduleFilterModel.getName()) != null) {
                tabTitle = name;
            } else {
                return;
            }
        }
        if (((CharSequence) tabTitle).length() != 0) {
            z = false;
        }
        if (!z) {
            TabLayout.Tab $this$updateTabTitle_u24lambda_u2d1 = this.tabLayout.getTabAt(index);
            if ($this$updateTabTitle_u24lambda_u2d1 != null) {
                $this$updateTabTitle_u24lambda_u2d1.setText((CharSequence) tabTitle);
                View customView = $this$updateTabTitle_u24lambda_u2d1.getCustomView();
                TextView textView = customView != null ? (TextView) customView.findViewById(R.id.tvTabTitle) : null;
                if (textView != null) {
                    textView.setText((CharSequence) tabTitle);
                }
            }
            updateTabLayoutStyle();
        }
    }

    public final void updateArrowDirection(boolean isDown) {
        int tabCount = this.tabLayout.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.Tab $this$updateArrowDirection_u24lambda_u2d2 = this.tabLayout.getTabAt(i2);
            if ($this$updateArrowDirection_u24lambda_u2d2 != null) {
                View customView = $this$updateArrowDirection_u24lambda_u2d2.getCustomView();
                ImageView imageView = customView != null ? (ImageView) customView.findViewById(R.id.imgTabArrow) : null;
                if (imageView != null) {
                    imageView.setRotation(isDown ? 0.0f : 180.0f);
                }
            }
        }
    }

    private final void showArrow(int pos, boolean show) {
        TabLayout.Tab $this$showArrow_u24lambda_u2d3 = this.tabLayout.getTabAt(pos);
        if ($this$showArrow_u24lambda_u2d3 != null) {
            View customView = $this$showArrow_u24lambda_u2d3.getCustomView();
            ImageView imageView = customView != null ? (ImageView) customView.findViewById(R.id.imgTabArrow) : null;
            if (imageView != null) {
                imageView.setVisibility(show ? 0 : 8);
            }
        }
        updateTabLayoutStyle();
    }

    /* access modifiers changed from: private */
    public final void showShader(boolean show) {
        int visibility = show ? 0 : 8;
        this.leftShader.setVisibility(visibility);
        this.rightShader.setVisibility(visibility);
    }

    private final void setCustomTab() {
        int tabCount = this.tabLayout.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.Tab tab = this.tabLayout.getTabAt(i2);
            if (tab != null) {
                View $this$setCustomTab_u24lambda_u2d5_u24lambda_u2d4 = LayoutInflater.from(getContext()).inflate(R.layout.olymp_sch_filter_tab_item, (ViewGroup) null);
                tab.setCustomView($this$setCustomTab_u24lambda_u2d5_u24lambda_u2d4);
                ((TextView) $this$setCustomTab_u24lambda_u2d5_u24lambda_u2d4.findViewById(R.id.tvTabTitle)).setText(tab.getText());
                updateTabStyle(false, tab);
            }
        }
    }

    private final void setTabClickListener() {
        View childAt = this.tabLayout.getChildAt(0);
        ViewGroup $this$setTabClickListener_u24lambda_u2d7 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if ($this$setTabClickListener_u24lambda_u2d7 != null) {
            int count = $this$setTabClickListener_u24lambda_u2d7.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View childAt2 = $this$setTabClickListener_u24lambda_u2d7.getChildAt(i2);
                if (childAt2 != null) {
                    childAt2.setOnClickListener(new ScheduleFilterTabComp$$ExternalSyntheticLambda2(this, i2));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setTabClickListener$lambda-7$lambda-6  reason: not valid java name */
    public static final void m4008setTabClickListener$lambda7$lambda6(ScheduleFilterTabComp this$0, int $i, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.tabLayout.getSelectedTabPosition() == $i) {
            Function1<? super Integer, Unit> function1 = this$0.onTabReClick;
            if (function1 != null) {
                function1.invoke(Integer.valueOf($i));
                return;
            }
            return;
        }
        this$0.isSelectedByClick = true;
        TabLayout.Tab tabAt = this$0.tabLayout.getTabAt($i);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    private final void setTabSelectedAppearance() {
        this.tabLayout.addOnTabSelectedListener(new ScheduleFilterTabComp$setTabSelectedAppearance$1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
        r0 = r7.getCustomView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateTabStyle(boolean r6, com.google.android.material.tabs.TabLayout.Tab r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x004f
            android.view.View r0 = r7.getCustomView()
            if (r0 == 0) goto L_0x004f
            int r1 = com.baidu.searchbox.sport.R.id.tvTabTitle
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x004f
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L_0x003b
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT_BOLD
            r0.setTypeface(r3)
            java.lang.String r3 = r5.schTabTextColor
            int r2 = com.baidu.searchbox.sport.utils.SportValueUtil.parseColor(r3, r2)
            r0.setTextColor(r2)
            android.view.View r2 = r7.getCustomView()
            if (r2 != 0) goto L_0x002d
            goto L_0x004e
        L_0x002d:
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            int r4 = com.baidu.searchbox.sport.R.drawable.olympic_sch_tab_bg
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r2.setBackground(r3)
            goto L_0x004e
        L_0x003b:
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            r0.setTypeface(r3)
            int r3 = com.baidu.searchbox.sport.R.color.GC1
            com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper.setTextColor(r0, r3)
            android.view.View r3 = r7.getCustomView()
            if (r3 == 0) goto L_0x004e
            r3.setBackgroundResource(r2)
        L_0x004e:
        L_0x004f:
            if (r7 == 0) goto L_0x0061
            android.view.View r0 = r7.getCustomView()
            if (r0 == 0) goto L_0x0061
            int r1 = com.baidu.searchbox.sport.R.id.imgTabArrow
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            int r1 = com.baidu.searchbox.sport.R.drawable.olympic_sch_subtab_arrow
            com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper.setImageDrawable(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.page.olympic.schedule.filter.tab.ScheduleFilterTabComp.updateTabStyle(boolean, com.google.android.material.tabs.TabLayout$Tab):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        r1 = r1.getSchTabBgModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initTabList(java.util.List<com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel> r10) {
        /*
            r9 = this;
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x0010
            android.view.View r0 = r9.getView()
            r1 = 8
            r0.setVisibility(r1)
            return
        L_0x0010:
            r0 = 0
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r10, r0)
            com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r1 = (com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel) r1
            r2 = 0
            if (r1 == 0) goto L_0x0025
            com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicSchTabBgModel r1 = r1.getSchTabBgModel()
            if (r1 == 0) goto L_0x0025
            java.util.List r1 = r1.getGradation()
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            r9.schTabGradation = r1
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r10, r0)
            com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r0 = (com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel) r0
            if (r0 == 0) goto L_0x003a
            com.baidu.searchbox.sport.page.olympic.schedule.model.OlympicSchTabBgModel r0 = r0.getSchTabBgModel()
            if (r0 == 0) goto L_0x003a
            java.lang.String r2 = r0.getTextColor()
        L_0x003a:
            r9.schTabTextColor = r2
            com.baidu.searchbox.sport.widget.olympic.OlympicScheduleTabLayout r0 = r9.tabLayout
            r0.removeAllTabs()
            r0 = r10
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0049:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0070
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel r4 = (com.baidu.searchbox.sport.page.olympic.schedule.filter.model.ScheduleFilterModel) r4
            r5 = 0
            com.baidu.searchbox.sport.widget.olympic.OlympicScheduleTabLayout r6 = r9.tabLayout
            com.google.android.material.tabs.TabLayout$Tab r7 = r6.newTab()
            java.lang.String r8 = r4.getName()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            com.google.android.material.tabs.TabLayout$Tab r7 = r7.setText((java.lang.CharSequence) r8)
            boolean r8 = r4.getSelect()
            r6.addTab((com.google.android.material.tabs.TabLayout.Tab) r7, (boolean) r8)
            goto L_0x0049
        L_0x0070:
            r9.setCustomTab()
            r9.setTabSelectedAppearance()
            r9.updateTabLayoutStyle()
            r9.setTabClickListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.page.olympic.schedule.filter.tab.ScheduleFilterTabComp.initTabList(java.util.List):void");
    }

    public ScheduleFilterTabVM onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(ScheduleFilterTabVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(ScheduleFilterTabVM::class.java)");
        return (ScheduleFilterTabVM) viewModel;
    }

    public void onBindViewModel(ScheduleFilterTabVM viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        bindTabData(viewModel, owner);
        bindAnchorTab(viewModel, owner);
        bindShowTabArrow(viewModel, owner);
        bindTabAd(viewModel, owner);
    }

    private final void bindShowTabArrow(ScheduleFilterTabVM viewModel, LifecycleOwner owner) {
        viewModel.getShowSubTabArrow().observe(owner, new ScheduleFilterTabComp$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindShowTabArrow$lambda-11  reason: not valid java name */
    public static final void m4004bindShowTabArrow$lambda11(ScheduleFilterTabComp this$0, Pair it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            Pair $this$bindShowTabArrow_u24lambda_u2d11_u24lambda_u2d10 = it;
            this$0.showArrow(((Number) $this$bindShowTabArrow_u24lambda_u2d11_u24lambda_u2d10.getFirst()).intValue(), ((Boolean) $this$bindShowTabArrow_u24lambda_u2d11_u24lambda_u2d10.getSecond()).booleanValue());
        }
    }

    private final void bindTabData(ScheduleFilterTabVM viewModel, LifecycleOwner owner) {
        viewModel.getTabData().observe(owner, new ScheduleFilterTabComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTabData$lambda-12  reason: not valid java name */
    public static final void m4007bindTabData$lambda12(ScheduleFilterTabComp this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Collection collection = it;
        if (collection == null || collection.isEmpty()) {
            this$0.getView().setVisibility(8);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.initTabList(it);
        this$0.getView().setVisibility(0);
    }

    private final void bindAnchorTab(ScheduleFilterTabVM viewModel, LifecycleOwner owner) {
        viewModel.getAnchorTabPos().observe(owner, new ScheduleFilterTabComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindAnchorTab$lambda-14  reason: not valid java name */
    public static final void m4003bindAnchorTab$lambda14(ScheduleFilterTabComp this$0, Pair it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            Pair $this$bindAnchorTab_u24lambda_u2d14_u24lambda_u2d13 = it;
            TabLayout.Tab tabAt = this$0.tabLayout.getTabAt(((Number) $this$bindAnchorTab_u24lambda_u2d14_u24lambda_u2d13.getFirst()).intValue());
            if (tabAt != null) {
                tabAt.select();
            }
            this$0.showArrow(((Number) $this$bindAnchorTab_u24lambda_u2d14_u24lambda_u2d13.getFirst()).intValue(), ((Boolean) $this$bindAnchorTab_u24lambda_u2d14_u24lambda_u2d13.getSecond()).booleanValue());
        }
    }

    private final void bindTabAd(ScheduleFilterTabVM viewModel, LifecycleOwner owner) {
        viewModel.getTabAdData().observe(owner, new ScheduleFilterTabComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTabAd$lambda-16  reason: not valid java name */
    public static final void m4005bindTabAd$lambda16(ScheduleFilterTabComp this$0, OlympicTabAd it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NightModeHelper.isNightMode()) {
            this$0.setAdImageData(it.getNightLogo());
        } else {
            this$0.setAdImageData(it.getAdLogo());
        }
        this$0.tabAdImageView.setOnClickListener(new ScheduleFilterTabComp$$ExternalSyntheticLambda4(it, this$0));
        if (it.getAdLogo().length() > 0) {
            SportStats.of(this$0.token).onShowEventDeduplication(this$0.config.getPage(), "showAd", (String) null, SportStats.getStatsExt(this$0.config.getParams().getMatch()), this$0.tabAdImageView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindTabAd$lambda-16$lambda-15  reason: not valid java name */
    public static final void m4006bindTabAd$lambda16$lambda15(OlympicTabAd $it, ScheduleFilterTabComp this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SportBrowserUtils.INSTANCE.openUrl($it.getAdUrl());
        SportStats.of(this$0.token).onClickEvent(this$0.config.getPage(), "clickAd", (String) null, SportStats.getStatsExt(this$0.config.getParams().getMatch()));
    }

    private final void setAdImageData(String adImageUrl) {
        if (adImageUrl.length() == 0) {
            this.tabAdImageView.setVisibility(8);
            this.tabLayout.updateTabLayoutStyle(true);
            return;
        }
        this.tabAdImageView.setVisibility(0);
        this.tabAdImageView.setImageURI(adImageUrl);
        this.tabLayout.updateTabLayoutStyle(false);
    }

    private final void updateTabLayoutStyle() {
        String adImageUrl = null;
        if (NightModeHelper.isNightMode()) {
            OlympicTabAd value = ((ScheduleFilterTabVM) getViewModel()).getTabAdData().getValue();
            if (value != null) {
                adImageUrl = value.getNightLogo();
            }
        } else {
            OlympicTabAd value2 = ((ScheduleFilterTabVM) getViewModel()).getTabAdData().getValue();
            if (value2 != null) {
                adImageUrl = value2.getAdLogo();
            }
        }
        CharSequence charSequence = adImageUrl;
        this.tabLayout.updateTabLayoutStyle(charSequence == null || charSequence.length() == 0);
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        ResWrapper.setBackgroundColor(getView(), R.color.GC85);
        int i2 = 0;
        int tabCount = this.tabLayout.getTabCount();
        while (true) {
            boolean z = true;
            if (i2 < tabCount) {
                TabLayout.Tab tab = this.tabLayout.getTabAt(i2);
                if (tab != null) {
                    if (this.tabLayout.getSelectedTabPosition() != i2) {
                        z = false;
                    }
                    updateTabStyle(z, tab);
                }
                i2++;
            } else {
                int shaderColor = getContext().getResources().getColor(R.color.GC85);
                this.leftShader.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{shaderColor, 0}));
                this.rightShader.setBackground(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{shaderColor, 0}));
                return;
            }
        }
    }
}
