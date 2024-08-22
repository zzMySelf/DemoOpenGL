package com.baidu.searchbox.feed.parser;

import androidx.collection.ArrayMap;
import com.baidu.searchbox.feed.base.FeedTemplateManager;
import com.baidu.searchbox.feed.model.FeedBaseModelHelper;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.IFeedFlowModel;
import com.baidu.searchbox.feed.model.IFeedItemModel;
import com.baidu.searchbox.feed.model.list.AbsPageConfig;
import com.baidu.searchbox.feed.model.utils.IReportInfoAssist;
import com.baidu.searchbox.feed.tts.model.IFeedTTSModel;
import com.baidu.searchbox.feed.util.Creator;
import java.util.Map;
import org.json.JSONObject;

public interface IFeedDataParser<D, P> {
    public static final String UN_SET_NO_COVER = "!*#&%!%%($Ak1837515594==";

    <T extends D> T parse(P p);

    public static class ItemDataParseEnv {
        final JSONObject jsonObj;
        final String layout;
        final String string;

        public ItemDataParseEnv(String layout2, String string2, JSONObject jsonObj2) {
            this.layout = layout2;
            this.string = string2;
            this.jsonObj = jsonObj2;
        }
    }

    public static class FlowModelParseBuilder<P> {
        private final Map<Class<?>, ItemModelBuilder<?>> mBaseModelConfigs = new ArrayMap();
        final Map<Class<?>, IFeedDataParser<IFeedItemModel, ?>> mBaseModelParsers = new ArrayMap();
        String mBusiness;
        String mChannelId;
        String mCmd;
        private final Creator<IFeedDataParser<IFeedFlowModel, P>, FlowModelParseBuilder<P>> mFactory;
        boolean mIsRestful;
        AbsPageConfig mPageConfig;
        String mRefreshState;
        String mStatFrom;

        public FlowModelParseBuilder(Creator<IFeedDataParser<IFeedFlowModel, P>, FlowModelParseBuilder<P>> factory) {
            this.mFactory = factory;
        }

        public <T> FlowModelParseBuilder<P> baseModelParser(Class<T> type, IFeedDataParser<IFeedItemModel, T> parser) {
            this.mBaseModelParsers.put(type, parser);
            return this;
        }

        public <T> FlowModelParseBuilder<P> baseModelConfig(Class<T> type, ItemModelBuilder<T> builder) {
            this.mBaseModelConfigs.put(type, builder);
            return this;
        }

        public FlowModelParseBuilder<P> cmd(String cmd) {
            this.mCmd = cmd;
            return this;
        }

        public FlowModelParseBuilder<P> channelId(String channelId) {
            this.mChannelId = channelId;
            for (ItemModelBuilder<?> builder : this.mBaseModelConfigs.values()) {
                builder.channelId(channelId);
            }
            return this;
        }

        public FlowModelParseBuilder<P> refreshState(String refreshState) {
            this.mRefreshState = refreshState;
            for (ItemModelBuilder<?> builder : this.mBaseModelConfigs.values()) {
                builder.refreshState(refreshState);
            }
            return this;
        }

        public FlowModelParseBuilder<P> business(String business) {
            this.mBusiness = business;
            for (ItemModelBuilder<?> builder : this.mBaseModelConfigs.values()) {
                builder.business(business);
            }
            return this;
        }

        public FlowModelParseBuilder<P> statFrom(String statFrom) {
            this.mStatFrom = statFrom;
            return this;
        }

        public FlowModelParseBuilder<P> isRestful(boolean isRestful) {
            this.mIsRestful = isRestful;
            return this;
        }

        public FlowModelParseBuilder<P> pageConfig(AbsPageConfig pageConfig) {
            this.mPageConfig = pageConfig;
            return this;
        }

        public IFeedDataParser<IFeedFlowModel, P> build() {
            for (Map.Entry<Class<?>, ItemModelBuilder<?>> entry : this.mBaseModelConfigs.entrySet()) {
                Class<?> key = entry.getKey();
                if (!this.mBaseModelParsers.containsKey(key)) {
                    this.mBaseModelParsers.put(key, entry.getValue().build());
                }
            }
            return this.mFactory.create(this);
        }
    }

    public static class ItemModelBuilder<P> {
        Creator<FeedBaseModelHelper, IFeedItemModel> mBaseModelHelper;
        String mBusiness;
        String mChannelId;
        private final Creator<IFeedDataParser<IFeedItemModel, P>, ItemModelBuilder<P>> mFactory;
        Creator<IFeedTTSModel, IFeedItemModel> mFeedTTSModel;
        private final Map<Class<?>, ItemDataBuilder<?>> mItemDataConfigs = new ArrayMap();
        final Map<Class<?>, IFeedDataParser<FeedItemData, ?>> mItemDataParsers = new ArrayMap();
        String mRefreshState;
        Creator<IReportInfoAssist, IFeedItemModel> mReportInfoAssist;

        public ItemModelBuilder(Creator<IFeedDataParser<IFeedItemModel, P>, ItemModelBuilder<P>> factory) {
            this.mFactory = factory;
        }

        public <T> ItemModelBuilder<P> itemDataParser(Class<T> type, IFeedDataParser<FeedItemData, T> parser) {
            this.mItemDataParsers.put(type, parser);
            return this;
        }

        public <T> ItemModelBuilder<P> itemDataConfig(Class<T> type, ItemDataBuilder<T> builder) {
            this.mItemDataConfigs.put(type, builder);
            return this;
        }

        public ItemModelBuilder<P> channelId(String channelId) {
            this.mChannelId = channelId;
            return this;
        }

        public ItemModelBuilder<P> refreshState(String refreshState) {
            this.mRefreshState = refreshState;
            return this;
        }

        public ItemModelBuilder<P> business(String business) {
            this.mBusiness = business;
            return this;
        }

        public ItemModelBuilder<P> ttsModel(Creator<IFeedTTSModel, IFeedItemModel> ttsModel) {
            this.mFeedTTSModel = ttsModel;
            return this;
        }

        public ItemModelBuilder<P> modelHelper(Creator<FeedBaseModelHelper, IFeedItemModel> modelHelper) {
            this.mBaseModelHelper = modelHelper;
            return this;
        }

        public ItemModelBuilder<P> reportAssist(Creator<IReportInfoAssist, IFeedItemModel> reportAssist) {
            this.mReportInfoAssist = reportAssist;
            return this;
        }

        public IFeedDataParser<IFeedItemModel, P> build() {
            for (Map.Entry<Class<?>, ItemDataBuilder<?>> entry : this.mItemDataConfigs.entrySet()) {
                Class<?> key = entry.getKey();
                if (!this.mItemDataParsers.containsKey(key)) {
                    this.mItemDataParsers.put(key, entry.getValue().build());
                }
            }
            return this.mFactory.create(this);
        }
    }

    public static class ItemDataBuilder<P> {
        String mContextName;
        private final Creator<IFeedDataParser<FeedItemData, P>, ItemDataBuilder<P>> mFactory;
        FeedTemplateManager mFeedTemplateManager;

        public ItemDataBuilder(Creator<IFeedDataParser<FeedItemData, P>, ItemDataBuilder<P>> factory) {
            this.mFactory = factory;
        }

        public ItemDataBuilder<P> templateManager(FeedTemplateManager feedTemplateManager) {
            this.mFeedTemplateManager = feedTemplateManager;
            return this;
        }

        public ItemDataBuilder<P> contextName(String contextName) {
            this.mContextName = contextName;
            return this;
        }

        public IFeedDataParser<FeedItemData, P> build() {
            return this.mFactory.create(this);
        }
    }
}
