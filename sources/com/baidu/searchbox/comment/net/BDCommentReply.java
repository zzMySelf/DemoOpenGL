package com.baidu.searchbox.comment.net;

import android.content.Context;
import com.baidu.searchbox.comment.definition.BDCommentRequestCallback;
import com.baidu.searchbox.comment.model.CommentBaseData;
import com.baidu.searchbox.comment.networklayer.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Map;

public class BDCommentReply implements IBDCommentExectorInterface<CommentBaseData> {
    public void send(Context context, boolean isAsyn, Map<String, String> params, final BDCommentRequestCallback<CommentBaseData> listener) {
        if (params == null || params.size() <= 0) {
            listener.onCompleted(-1, null, AppRuntime.getAppContext().getString(R.string.update_failure_default_toast));
        } else {
            BDCommentRequest.sendReply(context, isAsyn, params, new OnRequestCompletedListener<CommentBaseData>() {
                public void onCompleted(int status, CommentBaseData relsut, String errMsg) {
                    listener.onCompleted(status, relsut, errMsg);
                }
            });
        }
    }
}
