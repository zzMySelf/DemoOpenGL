package com.baidu.searchbox.search.mix.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.assistant.model.impl.log.ModelUbcManager;
import com.baidu.browser.tabna.utils.NaTabStatistics;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import com.baidu.searchbox.search.tab.core.message.EventMessage;
import com.baidu.searchbox.search.tab.core.model.SearchVideoBaseViewModel;
import com.baidu.searchbox.search.tab.implement.model.main.SearchVideoFlowModel;
import com.baidu.searchbox.search.tab.implement.request.RequestType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/search/mix/model/SearchNaMixViewModel;", "Lcom/baidu/searchbox/search/tab/core/model/SearchVideoBaseViewModel;", "Lcom/baidu/searchbox/search/tab/implement/model/main/SearchVideoFlowModel;", "manager", "Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "(Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;)V", "cardIndex", "", "dispatchRequestFail", "", "requestType", "dispatchRequestSuccess", "responseString", "", "release", "Companion", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchNaMixViewModel.kt */
public final class SearchNaMixViewModel extends SearchVideoBaseViewModel<SearchVideoFlowModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<ViewModelStore> viewModelStore$delegate = LazyKt.lazy(SearchNaMixViewModel$Companion$viewModelStore$2.INSTANCE);
    private int cardIndex;
    private IComponentManager manager;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/search/mix/model/SearchNaMixViewModel$Companion;", "", "()V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "viewModelStore$delegate", "Lkotlin/Lazy;", "getInstance", "Lcom/baidu/searchbox/search/mix/model/SearchNaMixViewModel;", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchNaMixViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final ViewModelStore getViewModelStore() {
            return (ViewModelStore) SearchNaMixViewModel.viewModelStore$delegate.getValue();
        }

        public final SearchNaMixViewModel getInstance() {
            ViewModel viewModel = new ViewModelProvider(getViewModelStore(), (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(SearchNaMixViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…MixViewModel::class.java)");
            return (SearchNaMixViewModel) viewModel;
        }
    }

    public SearchNaMixViewModel(IComponentManager manager2) {
        Intrinsics.checkNotNullParameter(manager2, FeedStatisticConstants.UBC_TYPE_PLUS);
        this.manager = manager2;
    }

    public void dispatchRequestSuccess(int requestType, String responseString) {
        switch (requestType) {
            case 20:
            case 21:
                NaTabStatistics.getInstance().updateStatistics(ModelUbcManager.UBC_EXT_KEY_START_LOAD);
                SearchNaMixCardsModel videoFlowModel = new SearchNaMixCardsModel(new RequestType(requestType, false), responseString, this.cardIndex);
                NaTabStatistics.getInstance().updateStatistics("endLoad");
                UiThreadUtils.runOnUiThread(new SearchNaMixViewModel$$ExternalSyntheticLambda0(this, videoFlowModel));
                if (videoFlowModel.isDataInvalid()) {
                    Map map = new LinkedHashMap();
                    map.put("cardIndex", Integer.valueOf(videoFlowModel.getCardIndex()));
                    map.put("reason", "dataInvalid");
                    EventMessage message = new EventMessage(18, (Object) null, map);
                    IComponentManager iComponentManager = this.manager;
                    if (iComponentManager != null) {
                        iComponentManager.sendMessage(message);
                    }
                }
                this.cardIndex++;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchRequestSuccess$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2770dispatchRequestSuccess$lambda1$lambda0(SearchNaMixViewModel this$0, SearchNaMixCardsModel $videoFlowModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($videoFlowModel, "$videoFlowModel");
        this$0.getLiveData().setValue($videoFlowModel);
    }

    public void release() {
        Companion.getViewModelStore().clear();
    }

    public void dispatchRequestFail(int requestType) {
        getLiveData().postValue(new SearchNaMixCardsModel(new RequestType(requestType, true), (String) null, 0));
    }
}
