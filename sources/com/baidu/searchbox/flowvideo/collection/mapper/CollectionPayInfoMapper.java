package com.baidu.searchbox.flowvideo.collection.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.collection.api.BrokenInfoBean;
import com.baidu.searchbox.flowvideo.collection.api.CollectionColumnPayInfoBean;
import com.baidu.searchbox.flowvideo.collection.api.CollectionPayInfoBean;
import com.baidu.searchbox.flowvideo.collection.api.CollectionSubscribeInfoBean;
import com.baidu.searchbox.flowvideo.collection.repos.BrokenInfoModel;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionColumnPayInfoModel;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionPayInfoModel;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionSubscribeInfoModel;
import com.baidu.searchbox.flowvideo.detail.api.AntiSpamBean;
import com.baidu.searchbox.flowvideo.detail.mapper.FlowDetailAntiSpamMapper;
import com.baidu.searchbox.flowvideo.detail.repos.AntiSpamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/collection/mapper/CollectionPayInfoMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/collection/api/CollectionPayInfoBean;", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionPayInfoModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPayInfoMapper.kt */
public final class CollectionPayInfoMapper implements Mapper<CollectionPayInfoBean, CollectionPayInfoModel> {
    public static final CollectionPayInfoMapper INSTANCE = new CollectionPayInfoMapper();

    private CollectionPayInfoMapper() {
    }

    public CollectionPayInfoModel map(CollectionPayInfoBean input) {
        BrokenInfoModel brokenInfoModel;
        CollectionSubscribeInfoModel collectionSubscribeInfoModel;
        CollectionColumnPayInfoModel collectionColumnPayInfoModel;
        Intrinsics.checkNotNullParameter(input, "input");
        BrokenInfoBean brokenInfo = input.getBrokenInfo();
        AntiSpamModel antiSpamModel = null;
        if (brokenInfo != null) {
            brokenInfoModel = PayBrokenInfoMapper.INSTANCE.map(brokenInfo);
        } else {
            brokenInfoModel = null;
        }
        CollectionSubscribeInfoBean subscribeInfo = input.getSubscribeInfo();
        if (subscribeInfo != null) {
            collectionSubscribeInfoModel = CollectionSubscribeInfoMapper.INSTANCE.map(subscribeInfo);
        } else {
            collectionSubscribeInfoModel = null;
        }
        CollectionColumnPayInfoBean columnPay = input.getColumnPay();
        if (columnPay != null) {
            collectionColumnPayInfoModel = CollectionColumnPayMapper.INSTANCE.map(columnPay);
        } else {
            collectionColumnPayInfoModel = null;
        }
        AntiSpamBean antiSpam = input.getAntiSpam();
        if (antiSpam != null) {
            antiSpamModel = FlowDetailAntiSpamMapper.INSTANCE.map(antiSpam);
        }
        return new CollectionPayInfoModel(brokenInfoModel, collectionSubscribeInfoModel, collectionColumnPayInfoModel, antiSpamModel);
    }
}
