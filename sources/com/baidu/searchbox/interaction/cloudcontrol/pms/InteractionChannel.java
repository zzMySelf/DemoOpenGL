package com.baidu.searchbox.interaction.cloudcontrol.pms;

import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/pms/InteractionChannel;", "Lcom/baidu/searchbox/pms/init/RequestParams$Channel;", "()V", "InteractionPackageCallback", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractionChannel.kt */
public final class InteractionChannel extends RequestParams.Channel {
    public InteractionChannel() {
        super("240", InteractionPmsProcessor.INSTANCE.getPackageNameList(), (PackageCallback) new InteractionPackageCallback());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/pms/InteractionChannel$InteractionPackageCallback;", "Lcom/baidu/searchbox/pms/callback/DefaultPackageCallback;", "()V", "onFetchError", "", "errorInfo", "Lcom/baidu/searchbox/pms/bean/ErrorInfo;", "onResultData", "resultData", "Lcom/baidu/searchbox/pms/bean/ResultData;", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InteractionChannel.kt */
    public static final class InteractionPackageCallback extends DefaultPackageCallback {
        public void onResultData(ResultData resultData) {
            super.onResultData(resultData);
            ArrayList mergeList = new ArrayList();
            if (resultData != null) {
                if (!CollectionUtils.isEmpty((Collection) resultData.addList)) {
                    mergeList.addAll(resultData.addList);
                }
                if (!CollectionUtils.isEmpty((Collection) resultData.updateList)) {
                    mergeList.addAll(resultData.updateList);
                }
            }
            InteractionPmsProcessor.INSTANCE.dispatchPackageInfo(mergeList);
        }

        public void onFetchError(ErrorInfo errorInfo) {
            super.onFetchError(errorInfo);
            InteractionPmsProcessor.INSTANCE.dispatchPackageInfo(new ArrayList());
        }
    }
}
