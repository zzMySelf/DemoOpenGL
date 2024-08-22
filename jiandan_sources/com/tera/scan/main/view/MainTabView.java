package com.tera.scan.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import fe.mmm.qw.xxx.ppp.ad;
import fe.mmm.qw.xxx.ppp.de;
import fe.mmm.qw.xxx.ppp.rg;
import fe.mmm.qw.xxx.ppp.th;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ$\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0002J\"\u0010 \u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tera/scan/main/view/MainTabView;", "Lcom/tera/scan/ui/view/layout/UIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftTabData", "Lcom/tera/scan/main/view/TabData;", "rightTabData", "viewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "inflateTabUI", "", "data", "viewGroup", "Landroid/view/ViewGroup;", "selected", "", "initTabData", "activity", "Lcom/tera/scan/main/MainActivity;", "tag", "", "setTabData", "left", "right", "selectedTag", "updateUIData", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainTabView extends UIFrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public th leftTabData;
    @Nullable
    public th rightTabData;
    @Nullable
    public MainActivityViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.view_main_tab, this);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_bottom_center);
        if (imageView != null) {
            imageView.setOnClickListener(new rg(this));
        }
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m833_init_$lambda0(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        MainActivityViewModel mainActivityViewModel = mainTabView.viewModel;
        if (mainActivityViewModel != null) {
            mainActivityViewModel.clickBottomCenterButton();
        }
    }

    private final void inflateTabUI(th thVar, ViewGroup viewGroup, boolean z) {
        if (thVar != null) {
            viewGroup.setTag(thVar.rg());
            updateUIData(thVar, viewGroup, z);
            viewGroup.setOnClickListener(new ad(this));
        }
    }

    /* renamed from: inflateTabUI$lambda-1  reason: not valid java name */
    public static final void m834inflateTabUI$lambda1(MainTabView mainTabView, View view) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        MainActivityViewModel mainActivityViewModel = mainTabView.viewModel;
        if (mainActivityViewModel != null) {
            Object tag = view.getTag();
            MainActivityViewModel.switchToTab$default(mainActivityViewModel, tag instanceof String ? (String) tag : null, (String) null, 2, (Object) null);
        }
    }

    /* renamed from: initTabData$lambda-2  reason: not valid java name */
    public static final void m835initTabData$lambda2(MainTabView mainTabView, String str) {
        Intrinsics.checkNotNullParameter(mainTabView, "this$0");
        th thVar = mainTabView.leftTabData;
        LinearLayout linearLayout = (LinearLayout) mainTabView._$_findCachedViewById(R.id.ll_bottom_tab_left);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "ll_bottom_tab_left");
        th thVar2 = mainTabView.leftTabData;
        String str2 = null;
        mainTabView.updateUIData(thVar, linearLayout, Intrinsics.areEqual((Object) str, (Object) thVar2 != null ? thVar2.rg() : null));
        th thVar3 = mainTabView.rightTabData;
        LinearLayout linearLayout2 = (LinearLayout) mainTabView._$_findCachedViewById(R.id.ll_bottom_tab_right);
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "ll_bottom_tab_right");
        th thVar4 = mainTabView.rightTabData;
        if (thVar4 != null) {
            str2 = thVar4.rg();
        }
        mainTabView.updateUIData(thVar3, linearLayout2, Intrinsics.areEqual((Object) str, (Object) str2));
    }

    private final void setTabData(th thVar, th thVar2, String str) {
        this.leftTabData = thVar;
        this.rightTabData = thVar2;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_bottom_tab_left);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "ll_bottom_tab_left");
        inflateTabUI(thVar, linearLayout, Intrinsics.areEqual((Object) thVar.rg(), (Object) str));
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.ll_bottom_tab_right);
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "ll_bottom_tab_right");
        inflateTabUI(thVar2, linearLayout2, Intrinsics.areEqual((Object) thVar2.rg(), (Object) str));
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel != null) {
            MainActivityViewModel.switchToTab$default(mainActivityViewModel, str, (String) null, 2, (Object) null);
        }
    }

    public static /* synthetic */ void setTabData$default(MainTabView mainTabView, th thVar, th thVar2, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        mainTabView.setTabData(thVar, thVar2, str);
    }

    private final void updateUIData(th thVar, ViewGroup viewGroup, boolean z) {
        int i2;
        if (thVar != null) {
            ImageView imageView = (ImageView) viewGroup.findViewWithTag("tag_icon");
            TextView textView = (TextView) viewGroup.findViewWithTag("tag_title");
            imageView.setImageResource(z ? thVar.de() : thVar.fe());
            textView.setText(thVar.th());
            if (z) {
                i2 = -16777216;
            } else {
                i2 = getResources().getColor(R.color.dark_bababa);
            }
            textView.setTextColor(i2);
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

    public final void initTabData(@NotNull MainActivity mainActivity, @NotNull MainActivityViewModel mainActivityViewModel, @NotNull String str) {
        Intrinsics.checkNotNullParameter(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        this.viewModel = mainActivityViewModel;
        setTabData(mainActivityViewModel.getLeftTabData(), mainActivityViewModel.getRightTabData(), str);
        mainActivityViewModel.getCurrentTab().observe(mainActivity, new de(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MainTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MainTabView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
