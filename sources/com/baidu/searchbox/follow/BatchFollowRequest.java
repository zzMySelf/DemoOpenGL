package com.baidu.searchbox.follow;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.follow.callback.FollowRequestCallback;
import com.baidu.searchbox.follow.net.Callback;
import java.util.List;

public class BatchFollowRequest {
    public void batchFollow(final Context context, List<String> ids, String source, final Callback<BaseJsonData> callback) {
        AnonymousClass1 r0 = new FollowRequestCallback() {
            public void onSuccess(String result, int statusCode) {
                if (callback != null) {
                    BaseJsonData baseJsonData = BatchFollowRequest.this.parseResponse(result);
                    if (baseJsonData == null || baseJsonData.getErrorCode() != 0) {
                        callback.onFailure();
                        if (baseJsonData != null) {
                            BatchFollowRequest.this.showErrorToast(context, baseJsonData.getErrorMessage());
                            return;
                        }
                        return;
                    }
                    callback.onSuccess(baseJsonData);
                }
            }

            public void onFailure(String result) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure();
                }
            }
        };
        FollowManager followManager = (FollowManager) ServiceManager.getService(FollowManager.SERVICE_REFERENCE);
        if (followManager != null) {
            followManager.batchFollowRequest(context, ids, source, "sbox", r0);
        } else {
            r0.onFailure((String) null);
        }
    }

    /* access modifiers changed from: private */
    public BaseJsonData parseResponse(String result) {
        BaseJsonData baseJsonData = BaseJsonData.fromJson(result);
        if (baseJsonData == null) {
            return null;
        }
        return baseJsonData;
    }

    /* access modifiers changed from: private */
    public void showErrorToast(Context context, String errmsg) {
        if (!TextUtils.isEmpty(errmsg)) {
            UniversalToast.makeText(context, (CharSequence) errmsg).showToast();
        } else {
            UniversalToast.makeText(context, R.string.follow_add_failure).showToast();
        }
    }
}
