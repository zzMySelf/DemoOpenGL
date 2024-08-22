package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.RedPacketBean;
import com.baidu.searchbox.flowvideo.detail.api.ShowTimeBean;
import com.baidu.searchbox.flowvideo.detail.repos.RedPacketModel;
import com.baidu.searchbox.flowvideo.detail.repos.ShowTimeModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/RedPacketMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/api/RedPacketBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/RedPacketModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailAuthorMapper.kt */
public final class RedPacketMapper implements Mapper<RedPacketBean, RedPacketModel> {
    public static final RedPacketMapper INSTANCE = new RedPacketMapper();

    private RedPacketMapper() {
    }

    public RedPacketModel map(RedPacketBean input) {
        if (input == null) {
            return null;
        }
        RedPacketBean bean = input;
        List showTimeList = new ArrayList();
        List<ShowTimeBean> $this$map_u24lambda_u2d3_u24lambda_u2d1 = bean.getShowTime();
        if ($this$map_u24lambda_u2d3_u24lambda_u2d1 != null) {
            for (ShowTimeBean showTime : $this$map_u24lambda_u2d3_u24lambda_u2d1) {
                ShowTimeModel $this$map_u24lambda_u2d3_u24lambda_u2d1_u24lambda_u2d0 = FlowDetailRedPacketShowTimeMapper.INSTANCE.map(showTime);
                if ($this$map_u24lambda_u2d3_u24lambda_u2d1_u24lambda_u2d0 != null) {
                    showTimeList.add($this$map_u24lambda_u2d3_u24lambda_u2d1_u24lambda_u2d0);
                }
            }
        }
        String isRedPacket = bean.isRedPacket();
        String id = bean.getId();
        String ext = bean.getExt();
        String source = bean.getSource();
        int size = showTimeList.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2;
            arrayList.add(false);
        }
        return new RedPacketModel(isRedPacket, id, ext, source, showTimeList, arrayList);
    }
}
