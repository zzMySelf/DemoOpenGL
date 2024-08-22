package com.baidu.searchbox.sport.page.vs.header;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/sport/page/vs/header/VSPageHeadViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bgDrawable", "Landroidx/lifecycle/MutableLiveData;", "Landroid/graphics/drawable/Drawable;", "getBgDrawable", "()Landroidx/lifecycle/MutableLiveData;", "title", "", "getTitle", "buildBgDrawable", "headModel", "Lcom/baidu/searchbox/sport/page/vs/header/VSPageHeadModel;", "buildTitle", "setModel", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VSPageHeadComp.kt */
public final class VSPageHeadViewModel extends BaseViewModel {
    private final MutableLiveData<Drawable> bgDrawable = new MutableLiveData<>();
    private final MutableLiveData<String> title = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VSPageHeadViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<String> getTitle() {
        return this.title;
    }

    public final MutableLiveData<Drawable> getBgDrawable() {
        return this.bgDrawable;
    }

    public final void setModel(VSPageHeadModel headModel) {
        Intrinsics.checkNotNullParameter(headModel, "headModel");
        this.title.setValue(buildTitle(headModel));
        this.bgDrawable.setValue(buildBgDrawable(headModel));
    }

    private final String buildTitle(VSPageHeadModel headModel) {
        return headModel.getVsInfo().getTitle() + " - " + headModel.getTabName();
    }

    private final Drawable buildBgDrawable(VSPageHeadModel headModel) {
        return new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{headModel.getBgStartColor(), headModel.getBgEndColor()});
    }
}
