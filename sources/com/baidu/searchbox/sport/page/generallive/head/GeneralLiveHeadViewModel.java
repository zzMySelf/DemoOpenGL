package com.baidu.searchbox.sport.page.generallive.head;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/sport/page/generallive/head/GeneralLiveHeadViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "headUrl", "Landroidx/lifecycle/MutableLiveData;", "", "getHeadUrl", "()Landroidx/lifecycle/MutableLiveData;", "setData", "", "url", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GeneralLiveHeadViewModel.kt */
public final class GeneralLiveHeadViewModel extends BaseViewModel {
    private final MutableLiveData<String> headUrl = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GeneralLiveHeadViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<String> getHeadUrl() {
        return this.headUrl;
    }

    public final void setData(String url) {
        this.headUrl.setValue(url);
    }
}
