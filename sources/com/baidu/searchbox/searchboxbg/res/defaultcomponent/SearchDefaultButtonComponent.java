package com.baidu.searchbox.searchboxbg.res.defaultcomponent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.bg.res.R;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.home.search.boxinterface.VerticalSearchBoxComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00140\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/baidu/searchbox/searchboxbg/res/defaultcomponent/SearchDefaultButtonComponent;", "Lcom/baidu/searchbox/home/search/boxinterface/VerticalSearchBoxComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "driverView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getDriverView", "()Landroid/view/View;", "driverView$delegate", "Lkotlin/Lazy;", "rootView", "Landroid/widget/LinearLayout;", "getRootView", "()Landroid/widget/LinearLayout;", "rootView$delegate", "searchButton", "Landroid/widget/TextView;", "getSearchButton", "()Landroid/widget/TextView;", "searchButton$delegate", "value", "", "stayStandardFontSize", "getStayStandardFontSize", "()Z", "setStayStandardFontSize", "(Z)V", "getClickableView", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getView", "onFontSizeChanged", "", "onNightModeChanged", "onThemeChanged", "isTheme", "lib-searchboxbg-res_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchDefaultButtonComponent.kt */
public final class SearchDefaultButtonComponent implements VerticalSearchBoxComponent {
    private final Context context;
    private final Lazy driverView$delegate = LazyKt.lazy(new SearchDefaultButtonComponent$driverView$2(this));
    private final Lazy rootView$delegate = LazyKt.lazy(new SearchDefaultButtonComponent$rootView$2(this));
    private final Lazy searchButton$delegate = LazyKt.lazy(new SearchDefaultButtonComponent$searchButton$2(this));
    private boolean stayStandardFontSize;

    public SearchDefaultButtonComponent(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LinearLayout getRootView() {
        return (LinearLayout) this.rootView$delegate.getValue();
    }

    public final View getDriverView() {
        return (View) this.driverView$delegate.getValue();
    }

    public final TextView getSearchButton() {
        return (TextView) this.searchButton$delegate.getValue();
    }

    public boolean getStayStandardFontSize() {
        return this.stayStandardFontSize;
    }

    public void setStayStandardFontSize(boolean value) {
        this.stayStandardFontSize = value;
        onFontSizeChanged();
    }

    public LinearLayout getView() {
        return getRootView();
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -1);
    }

    public void onNightModeChanged() {
    }

    public void onFontSizeChanged() {
        FontSizeViewExtKt.setScaledSizeRes$default(getDriverView(), getStayStandardFontSize() ? -1 : 0, R.dimen.vertical_search_box_btn_divider_width, R.dimen.vertical_search_box_btn_divider_hight, 0, 8, (Object) null);
    }

    public void onThemeChanged(boolean isTheme) {
    }

    public View getClickableView() {
        return getSearchButton();
    }
}
