package com.baidu.searchbox.comment.template.userInfo;

import com.baidu.searchbox.comment.definition.Mapper;
import com.baidu.searchbox.comment.model.CommentHeaderPostData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/comment/template/userInfo/CommentUserInfoFromPostDataMapper;", "Lcom/baidu/searchbox/comment/definition/Mapper;", "Lcom/baidu/searchbox/comment/model/CommentHeaderPostData;", "Lcom/baidu/searchbox/comment/template/userInfo/CommentUserIconModel;", "()V", "map", "input", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentUserInfoModel.kt */
public final class CommentUserInfoFromPostDataMapper implements Mapper<CommentHeaderPostData, CommentUserIconModel> {
    public CommentUserIconModel map(CommentHeaderPostData input) {
        if (input != null) {
            CommentHeaderPostData data = input;
            return new CommentUserIconModel((String) null, data.getAvatar(), data.getCommentorPendant(), data.getVType(), (String) null, (String) null, false, 112, (DefaultConstructorMarker) null);
        }
        CommentUserIconModel commentUserIconModel = null;
        return null;
    }
}
