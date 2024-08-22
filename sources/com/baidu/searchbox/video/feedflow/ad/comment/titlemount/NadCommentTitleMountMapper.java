package com.baidu.searchbox.video.feedflow.ad.comment.titlemount;

import com.baidu.searchbox.feed.ad.model.CommentNadTitleData;
import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/comment/titlemount/NadCommentTitleMountMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "", "Lcom/baidu/searchbox/feed/ad/model/CommentNadTitleData;", "()V", "map", "input", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCommentTitleMountMapper.kt */
public final class NadCommentTitleMountMapper implements Mapper<String, CommentNadTitleData> {
    public CommentNadTitleData map(String input) {
        return CommentNadTitleData.fromJson(input);
    }
}
