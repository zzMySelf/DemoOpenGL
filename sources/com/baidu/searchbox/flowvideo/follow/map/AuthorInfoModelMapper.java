package com.baidu.searchbox.flowvideo.follow.map;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.follow.api.AuthorInfoModel;
import com.baidu.searchbox.flowvideo.follow.api.FansInfoBean;
import com.baidu.searchbox.flowvideo.follow.api.FollowInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/follow/map/AuthorInfoModelMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/follow/api/FansInfoBean;", "Lcom/baidu/searchbox/flowvideo/follow/api/AuthorInfoModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowOneToNItemMapper.kt */
public final class AuthorInfoModelMapper implements Mapper<FansInfoBean, AuthorInfoModel> {
    public static final AuthorInfoModelMapper INSTANCE = new AuthorInfoModelMapper();

    private AuthorInfoModelMapper() {
    }

    public AuthorInfoModel map(FansInfoBean input) {
        String str = null;
        if (input == null) {
            return null;
        }
        FansInfoBean bean = input;
        String fansNum = bean.getFansNum();
        boolean areEqual = Intrinsics.areEqual((Object) "1", (Object) bean.isFollow());
        FollowInfoBean followInfo = bean.getFollowInfo();
        String thirdId = followInfo != null ? followInfo.getThirdId() : null;
        FollowInfoBean followInfo2 = bean.getFollowInfo();
        String type = followInfo2 != null ? followInfo2.getType() : null;
        FollowInfoBean followInfo3 = bean.getFollowInfo();
        String sFrom = followInfo3 != null ? followInfo3.getSFrom() : null;
        FollowInfoBean followInfo4 = bean.getFollowInfo();
        String source = followInfo4 != null ? followInfo4.getSource() : null;
        FollowInfoBean followInfo5 = bean.getFollowInfo();
        String store = followInfo5 != null ? followInfo5.getStore() : null;
        FollowInfoBean followInfo6 = bean.getFollowInfo();
        if (followInfo6 != null) {
            str = followInfo6.getSid();
        }
        return new AuthorInfoModel(fansNum, areEqual, thirdId, type, sFrom, source, store, str, (String) null, 256, (DefaultConstructorMarker) null);
    }
}
