package com.baidu.searchbox.flowvideo.livebanner.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.livebanner.api.LiveBannerExtInfoBean;
import com.baidu.searchbox.flowvideo.livebanner.repos.LiveBannerExtInfoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/livebanner/mapper/LiveBannerExtInfoMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/livebanner/api/LiveBannerExtInfoBean;", "Lcom/baidu/searchbox/flowvideo/livebanner/repos/LiveBannerExtInfoModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBannerModelMapper.kt */
public final class LiveBannerExtInfoMapper implements Mapper<LiveBannerExtInfoBean, LiveBannerExtInfoModel> {
    public static final LiveBannerExtInfoMapper INSTANCE = new LiveBannerExtInfoMapper();

    private LiveBannerExtInfoMapper() {
    }

    public LiveBannerExtInfoModel map(LiveBannerExtInfoBean input) {
        if (input == null) {
            return null;
        }
        LiveBannerExtInfoBean bean = input;
        List list = null;
        List<List> $this$map_u24lambda_u2d3_u24lambda_u2d2 = bean.getTags();
        if ($this$map_u24lambda_u2d3_u24lambda_u2d2 != null) {
            list = (List) new ArrayList();
            for (List<String> tagBean : $this$map_u24lambda_u2d3_u24lambda_u2d2) {
                List subTag = new ArrayList();
                for (String subTagBean : tagBean) {
                    subTag.add(subTagBean);
                    bean = bean;
                }
                list.add(subTag);
            }
        }
        return new LiveBannerExtInfoModel(list, LiveBannerLeftIconMapper.INSTANCE.map(input.getLeftIcon()), input.getTitleNew(), input.getSubTitleNew(), input.getBarTextNew(), input.getBtnTextNew());
    }
}
