package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.VideoPkOptionBean;
import com.baidu.searchbox.flowvideo.detail.repos.VideoPkOptionModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/FlowDetailVideoPkOptionMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "", "Lcom/baidu/searchbox/flowvideo/detail/api/VideoPkOptionBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/VideoPkOptionModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailVideoPkOptionMapper.kt */
public final class FlowDetailVideoPkOptionMapper implements Mapper<List<? extends VideoPkOptionBean>, List<? extends VideoPkOptionModel>> {
    public static final FlowDetailVideoPkOptionMapper INSTANCE = new FlowDetailVideoPkOptionMapper();

    private FlowDetailVideoPkOptionMapper() {
    }

    public List<VideoPkOptionModel> map(List<VideoPkOptionBean> input) {
        if (input == null) {
            return null;
        }
        List<VideoPkOptionBean> list = input.isEmpty() ^ true ? input : null;
        if (list == null) {
            return null;
        }
        List result = new ArrayList();
        for (VideoPkOptionBean bean : list) {
            result.add(new VideoPkOptionModel(bean.getOptionId(), bean.getValue(), bean.getNum(), bean.getChecked()));
        }
        return result;
    }
}
