package com.baidu.searchbox.generalcommunity;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.generalcommunity.data.GCommunityRepository;
import com.baidu.searchbox.generalcommunity.injector.BusinessOwnFactory;
import com.baidu.searchbox.generalcommunity.injector.ConfigOptions;
import com.baidu.searchbox.generalcommunity.injector.GenericRegistry;
import com.baidu.searchbox.generalcommunity.injector.NetRequestFactory;
import com.baidu.searchbox.generalcommunity.injector.RespInterceptor;
import com.baidu.searchbox.generalcommunity.injector.SchemeInterceptor;
import com.baidu.searchbox.generalcommunity.injector.ServerReportFactory;
import com.baidu.searchbox.generalcommunity.injector.StatusTargetFactory;
import com.baidu.searchbox.generalcommunity.injector.TemplateDecoderFactory;
import com.baidu.searchbox.generalcommunity.injector.TemplateDecoderRegistry;
import com.baidu.searchbox.generalcommunity.injector.UbcDataFactory;
import com.baidu.searchbox.generalcommunity.injector.UiNotifyInterceptor;
import com.baidu.searchbox.generalcommunity.ui.GCommunityUI;

public class Registry {
    private final GenericRegistry<BusinessOwnFactory> mBusinessOwnRegistry = new GenericRegistry<>();
    private final GenericRegistry<ConfigOptions> mConfigOptionsRegistry = new GenericRegistry<>();
    private final RepositoryRegistry mRepositoryRegistry = new RepositoryRegistry();
    private final GenericRegistry<RespInterceptor> mRespInterceptorRegistry = new GenericRegistry<>();
    private final GenericRegistry<SchemeInterceptor> mSchemeInterceptorRegistry = new GenericRegistry<>();
    private final GenericRegistry<ServerReportFactory> mServerReportRegistry = new GenericRegistry<>();
    private final GenericRegistry<StatusTargetFactory> mStatusTargetRegistry = new GenericRegistry<>();
    private final TemplateDecoderRegistry mTemplateDecoderRegistry = new TemplateDecoderRegistry();
    private final GenericRegistry<UbcDataFactory> mUbcDataRegistry = new GenericRegistry<>();
    private final GenericRegistry<UiNotifyInterceptor> mUiNotifyRegistry = new GenericRegistry<>();
    private final GenericRegistry<GCommunityUI> mUiRegistry = new GenericRegistry<>();

    public Registry append(String business, TemplateDecoderFactory factory) {
        this.mTemplateDecoderRegistry.appendIfAbsent(business, factory);
        return this;
    }

    public Registry registerUbc(String business, UbcDataFactory factory) {
        this.mUbcDataRegistry.registerIfAbsent(business, factory);
        return this;
    }

    public Registry registerSchemeInterceptor(String business, SchemeInterceptor interceptor) {
        this.mSchemeInterceptorRegistry.registerIfAbsent(business, interceptor);
        return this;
    }

    public Registry registerRespInterceptor(String business, RespInterceptor interceptor) {
        this.mRespInterceptorRegistry.registerIfAbsent(business, interceptor);
        return this;
    }

    public Registry registerUiNotifyInterceptor(String business, UiNotifyInterceptor interceptor) {
        this.mUiNotifyRegistry.registerIfAbsent(business, interceptor);
        return this;
    }

    public Registry registerServerReport(String business, ServerReportFactory factory) {
        this.mServerReportRegistry.registerIfAbsent(business, factory);
        return this;
    }

    public Registry registerBusinessOwn(String business, BusinessOwnFactory factory) {
        this.mBusinessOwnRegistry.registerIfAbsent(business, factory);
        return this;
    }

    public Registry registerViewFactory(String business, StatusTargetFactory factory) {
        this.mStatusTargetRegistry.registerIfAbsent(business, factory);
        return this;
    }

    public StatusTargetFactory getViewFactory(String business) {
        return this.mStatusTargetRegistry.get(business);
    }

    public Registry apply(String business, ConfigOptions configOptions) {
        this.mConfigOptionsRegistry.registerIfAbsent(business, configOptions);
        return this;
    }

    public View createView(String business, FragmentActivity activity) {
        GCommunityUI ui = this.mUiRegistry.get(business);
        if (ui == null) {
            ui = new GCommunityUI(activity, business);
            this.mUiRegistry.registerIfAbsent(business, ui);
        } else {
            ui.updateUiController(activity);
        }
        return ui.createView(activity);
    }

    public View createView(String business, Fragment fragment) {
        GCommunityUI ui = this.mUiRegistry.get(business);
        if (ui == null) {
            ui = new GCommunityUI(fragment, business);
            this.mUiRegistry.registerIfAbsent(business, ui);
        } else {
            ui.updateUiController(fragment);
        }
        return ui.createView(fragment.getContext());
    }

    public View createView(String business, ViewModelStore store, Context context, LifecycleOwner owner) {
        GCommunityUI ui = this.mUiRegistry.get(business);
        if (ui == null) {
            ui = new GCommunityUI(store, business, owner);
            this.mUiRegistry.registerIfAbsent(business, ui);
        } else {
            ui.updateUiController(store, owner);
        }
        return ui.createView(context);
    }

    public GCommunityUI getGCommunityUi(String business) {
        return this.mUiRegistry.get(business);
    }

    public FeedItemData getGCommunityBean(String business, FeedBaseModel baseModel) {
        return this.mTemplateDecoderRegistry.getTempDecoderFactory(business, baseModel.layout).buildModel(baseModel);
    }

    public FeedTemplate getFeedTemplate(Context context, String business, String type) {
        return this.mTemplateDecoderRegistry.getTempDecoderFactory(business, type).buildTemplate(context);
    }

    public int getIndexByType(String business, String type) {
        return this.mTemplateDecoderRegistry.indexOfInBucket(business, type);
    }

    public String getTypeByIndex(String business, int index) {
        return this.mTemplateDecoderRegistry.getTypeByIndex(business, index);
    }

    public RespInterceptor getRespInterceptor(String business) {
        return this.mRespInterceptorRegistry.get(business);
    }

    public SchemeInterceptor getSchemeInterceptor(String business) {
        return this.mSchemeInterceptorRegistry.get(business);
    }

    public UiNotifyInterceptor getUiNotifyInterceptor(String business) {
        return this.mUiNotifyRegistry.get(business);
    }

    public Registry registerRepository(String business, NetRequestFactory netRequestFactory) {
        this.mRepositoryRegistry.registerIfAbsent(business, netRequestFactory);
        return this;
    }

    public GCommunityRepository getRepository(String business) {
        return this.mRepositoryRegistry.get(business);
    }

    public Registry clear(String business) {
        this.mTemplateDecoderRegistry.clear(business);
        this.mRepositoryRegistry.remove(business);
        this.mUbcDataRegistry.remove(business);
        this.mUiRegistry.remove(business);
        this.mServerReportRegistry.remove(business);
        this.mBusinessOwnRegistry.remove(business);
        this.mConfigOptionsRegistry.remove(business);
        this.mRespInterceptorRegistry.remove(business);
        this.mStatusTargetRegistry.remove(business);
        this.mUiNotifyRegistry.remove(business);
        return this;
    }

    public boolean isTypeRegistered(String business, String type) {
        return this.mTemplateDecoderRegistry.isTypeExist(business, type);
    }

    public UbcDataFactory getUbcDataFactory(String business) {
        return this.mUbcDataRegistry.get(business);
    }

    public ServerReportFactory getServerReportFactory(String business) {
        return this.mServerReportRegistry.get(business);
    }

    public BusinessOwnFactory getBusinessOwnFactory(String business) {
        return this.mBusinessOwnRegistry.get(business);
    }

    public ConfigOptions getConfigOptions(String business) {
        return this.mConfigOptionsRegistry.get(business);
    }
}
