package com.baidu.searchbox.hotdiscussion;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.search.rsseview.ISearchRsseViewModel;
import com.baidu.searchbox.search.rsseview.SearchRsseDataParser;
import com.baidu.searchbox.search.rsseview.SearchRsseModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006J\b\u0010\"\u001a\u00020\u000bH\u0014J\u0017\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010%RP\u0010\u0004\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/hotdiscussion/HotDiscussionRsseViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/baidu/searchbox/search/rsseview/ISearchRsseViewModel;", "()V", "fetchDataListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "url", "query", "", "getFetchDataListener", "()Lkotlin/jvm/functions/Function2;", "setFetchDataListener", "(Lkotlin/jvm/functions/Function2;)V", "isShow", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setShow", "(Landroidx/lifecycle/MutableLiveData;)V", "rsseData", "Lcom/baidu/searchbox/search/rsseview/SearchRsseModel;", "getRsseData", "setRsseData", "bindData", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "fetchRsseData", "handleRsseData", "responseStr", "onCleared", "showRsseView", "showView", "(Ljava/lang/Boolean;)V", "lib_search_hotdiscussion_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotDiscussionRsseViewModel.kt */
public final class HotDiscussionRsseViewModel extends ViewModel implements ISearchRsseViewModel {
    private Function2<? super String, ? super String, Unit> fetchDataListener;
    private MutableLiveData<Boolean> isShow = new MutableLiveData<>();
    private MutableLiveData<SearchRsseModel> rsseData = new MutableLiveData<>();

    public final MutableLiveData<SearchRsseModel> getRsseData() {
        return this.rsseData;
    }

    public final void setRsseData(MutableLiveData<SearchRsseModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rsseData = mutableLiveData;
    }

    public final MutableLiveData<Boolean> isShow() {
        return this.isShow;
    }

    public final void setShow(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isShow = mutableLiveData;
    }

    public final Function2<String, String, Unit> getFetchDataListener() {
        return this.fetchDataListener;
    }

    public final void setFetchDataListener(Function2<? super String, ? super String, Unit> function2) {
        this.fetchDataListener = function2;
    }

    public final void handleRsseData(String responseStr) {
        Intrinsics.checkNotNullParameter(responseStr, "responseStr");
        this.rsseData.postValue(SearchRsseDataParser.parseRsseData(responseStr));
    }

    public void showRsseView(Boolean showView) {
        this.isShow.postValue(showView);
    }

    public void fetchRsseData(String url, String query) {
        Function2<? super String, ? super String, Unit> function2 = this.fetchDataListener;
        if (function2 != null) {
            function2.invoke(url, query);
        }
    }

    public void bindData(LifecycleOwner lifecycleOwner, Observer<SearchRsseModel> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (lifecycleOwner != null) {
            this.rsseData.observe(lifecycleOwner, observer);
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.fetchDataListener = null;
    }
}
