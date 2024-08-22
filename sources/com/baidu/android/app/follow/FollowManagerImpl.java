package com.baidu.android.app.follow;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.baidu.android.app.follow.request.FollowRequest;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.follow.FollowActionRequest;
import com.baidu.searchbox.follow.FollowActionResult;
import com.baidu.searchbox.follow.FollowActionResultParser;
import com.baidu.searchbox.follow.FollowManager;
import com.baidu.searchbox.follow.R;
import com.baidu.searchbox.follow.button.FollowStatusManager;
import com.baidu.searchbox.follow.callback.FollowRequestCallback;
import com.baidu.searchbox.follow.callback.FollowResultCallBack;
import com.baidu.searchbox.follow.callback.LoginDialogVisibilityChangedCallback;
import com.baidu.searchbox.follow.helper.FollowLoginDialogHelper;
import com.baidu.searchbox.follow.net.CommonHttpRequest;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import com.baidu.searchbox.follow.util.FollowRelationCollection;
import java.util.List;
import java.util.Map;

public class FollowManagerImpl implements FollowManager {
    public void singleFollowRequest(Context context, boolean isSubscribe, String type, String thirdId, String source, String sfrom, String ext, FollowRequestCallback followRequestCallback) {
        singleFollowRequest(context, isSubscribe, type, thirdId, source, sfrom, ext, "", followRequestCallback);
    }

    public void singleFollowRequest(Context context, boolean isSubscribe, String type, String thirdId, String source, String sfrom, String ext, String strategyInfo, FollowRequestCallback followRequestCallback) {
        final FollowRequestCallback followRequestCallback2 = followRequestCallback;
        FollowRequest.singleFollowRequest(context, isSubscribe, type, thirdId, source, sfrom, ext, strategyInfo, new FollowRequest.FollowRequestCallBack() {
            public void onSuccess(String result, int statusCode) {
                FollowRequestCallback followRequestCallback = followRequestCallback2;
                if (followRequestCallback != null) {
                    followRequestCallback.onSuccess(result, statusCode);
                }
            }

            public void onFailure(String result) {
                FollowRequestCallback followRequestCallback = followRequestCallback2;
                if (followRequestCallback != null) {
                    followRequestCallback.onFailure(result);
                }
            }
        });
    }

    public void batchFollowRequest(Context context, List<String> thirdIDList, String source, String sfrom, final FollowRequestCallback followRequestCallback) {
        FollowRequest.batchFollowRequest(context, thirdIDList, source, sfrom, new FollowRequest.FollowRequestCallBack() {
            public void onSuccess(String result, int statusCode) {
                FollowRequestCallback followRequestCallback = followRequestCallback;
                if (followRequestCallback != null) {
                    followRequestCallback.onSuccess(result, statusCode);
                }
            }

            public void onFailure(String result) {
                FollowRequestCallback followRequestCallback = followRequestCallback;
                if (followRequestCallback != null) {
                    followRequestCallback.onFailure(result);
                }
            }
        });
    }

    public boolean getFollowRelation(String thirdId) {
        return FollowRelationCollection.getFollowRelation(thirdId);
    }

    public void postFollowStatus(Context context, String authorType, String thirdId, boolean isFollow) {
        FollowStatusManager.INSTANCE.postFollowStatus(context, authorType, thirdId, isFollow);
    }

    public void removeFollowStatusChangeObserver(Observer<Map<String, Boolean>> observer) {
        FollowStatusManager.INSTANCE.removeFollowStatusChangeObserver(observer);
    }

    public void observeFollowStatusChange(Observer<Map<String, Boolean>> observer) {
        FollowStatusManager.INSTANCE.observeFollowStatusChange(observer);
    }

    public String getTypeById(String thirdId) {
        return FollowStatusManager.INSTANCE.getTypeById(thirdId);
    }

    public boolean showLoginDialog(Context context, String jsonStr, LoginDialogVisibilityChangedCallback callback) {
        return FollowLoginDialogHelper.showLoginDialog(context, jsonStr, callback);
    }

    public void requestFollowGuideData(Context context, String type, String thirdId, String sfrom, String source, boolean isFollow, String ext, FollowRequestCallback callback) {
        CommonHttpRequest.requestFollowGuideData(context, type, thirdId, sfrom, source, isFollow, ext, callback);
    }

    public void doFollow(Context context, boolean isAdd, String url, String type, String thirdId, String source, String sfrom, String ext, String strategyInfo, FollowResultCallBack resultCallBack) {
        String sfrom2;
        final FollowResultCallBack followResultCallBack = resultCallBack;
        FollowActionRequest.FollowRequestCallBack actionRequest = new FollowActionRequest.FollowRequestCallBack() {
            public void onSuccess(String result, int statusCode) {
                FollowActionResult actionResult = new FollowActionResultParser().parseResponse(result);
                if (actionResult != null) {
                    switch (actionResult.getErrno()) {
                        case 0:
                            FollowResultCallBack followResultCallBack = followResultCallBack;
                            if (followResultCallBack != null) {
                                followResultCallBack.success();
                                return;
                            }
                            return;
                        case 800200:
                            String errMsg = FollowRuntime.getAppContext().getString(R.string.follow_failed);
                            if (!TextUtils.isEmpty(actionResult.getErrmsg())) {
                                errMsg = actionResult.getErrmsg();
                            }
                            UniversalToast.makeText(FollowRuntime.getAppContext(), (CharSequence) errMsg).show();
                            FollowResultCallBack followResultCallBack2 = followResultCallBack;
                            if (followResultCallBack2 != null) {
                                followResultCallBack2.failed(actionResult.getErrno());
                                return;
                            }
                            return;
                        default:
                            FollowResultCallBack followResultCallBack3 = followResultCallBack;
                            if (followResultCallBack3 != null) {
                                followResultCallBack3.failed(actionResult.getErrno());
                                return;
                            }
                            return;
                    }
                } else {
                    FollowResultCallBack followResultCallBack4 = followResultCallBack;
                    if (followResultCallBack4 != null) {
                        followResultCallBack4.failed(-1);
                    }
                }
            }

            public void onFailure(String result) {
                FollowResultCallBack followResultCallBack = followResultCallBack;
                if (followResultCallBack != null) {
                    followResultCallBack.failed(-1);
                }
            }
        };
        if (TextUtils.isEmpty(sfrom)) {
            sfrom2 = "sbox";
        } else {
            sfrom2 = sfrom;
        }
        FollowActionRequest.singleFollowRequest(context, isAdd, url, type, thirdId, source, sfrom2, ext, strategyInfo, actionRequest);
    }
}
