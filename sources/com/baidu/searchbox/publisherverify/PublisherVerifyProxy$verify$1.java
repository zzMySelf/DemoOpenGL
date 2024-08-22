package com.baidu.searchbox.publisherverify;

import com.baidu.searchbox.publisher.verify.IPublisherVerifyResultCallback;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.ugc.utils.LogUtil;
import com.baidu.searchbox.ugc.utils.ToastUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/publisherverify/PublisherVerifyProxy$verify$1", "Lcom/baidu/searchbox/publisher/verify/IPublisherVerifyResultCallback;", "onError", "", "code", "", "errorMsg", "onSuccess", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublisherVerifyProxy.kt */
public final class PublisherVerifyProxy$verify$1 implements IPublisherVerifyResultCallback {
    final /* synthetic */ PublisherVerifyProxy this$0;

    PublisherVerifyProxy$verify$1(PublisherVerifyProxy $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess() {
        Function0 access$getSuccessFunc$p = this.this$0.successFunc;
        if (access$getSuccessFunc$p != null) {
            access$getSuccessFunc$p.invoke();
        }
    }

    public void onError(String code, String errorMsg) {
        Function0 access$getFailFunc$p = this.this$0.failFunc;
        if (access$getFailFunc$p != null) {
            access$getFailFunc$p.invoke();
        }
        ToastUtil.INSTANCE.showToastWithMinDur(Integer.valueOf(R.string.dynamic_publisher_verify_fail_text));
        LogUtil.e("=====> code:" + code + "  errorMsg:" + errorMsg);
    }
}
