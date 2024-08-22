package com.baidu.searchbox.feed.biserialdetail.bar;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseCallBackHandler;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/bar/ToolBarPresenter$playTriplePraiseAnim$1", "Lcom/baidu/searchbox/praise/triplepraiseinterface/TriplePraiseCallBackHandler;", "handleResponse", "", "data", "Lcom/baidu/searchbox/praise/triplepraiseinterface/TriplePraiseData;", "handleTriplePraiseAnimEnd", "handleTriplePraiseAnimReverse", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolBarPresenter.kt */
public final class ToolBarPresenter$playTriplePraiseAnim$1 implements TriplePraiseCallBackHandler {
    final /* synthetic */ ToolBarPresenter this$0;

    ToolBarPresenter$playTriplePraiseAnim$1(ToolBarPresenter $receiver) {
        this.this$0 = $receiver;
    }

    public void handleResponse(TriplePraiseData data) {
        if (data != null) {
            TriplePraiseData triplePraiseData = data;
            UiThreadUtils.getMainHandler().post(new ToolBarPresenter$playTriplePraiseAnim$1$$ExternalSyntheticLambda1(this.this$0, data));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleResponse$lambda-1$lambda-0  reason: not valid java name */
    public static final void m18490handleResponse$lambda1$lambda0(ToolBarPresenter this$02, TriplePraiseData $data) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.isFollow = Boolean.valueOf($data.isFollow());
        Function2<Boolean, TriplePraiseData, Unit> triplePraiseCallback = this$02.getTriplePraiseCallback();
        if (triplePraiseCallback != null) {
            triplePraiseCallback.invoke(true, $data);
        }
    }

    public void handleTriplePraiseAnimReverse() {
        UiThreadUtils.getMainHandler().post(new ToolBarPresenter$playTriplePraiseAnim$1$$ExternalSyntheticLambda0(this.this$0));
        ToolBarPresenter.praiseTripleStatistics$default(this.this$0, "0", (String) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleTriplePraiseAnimReverse$lambda-2  reason: not valid java name */
    public static final void m18491handleTriplePraiseAnimReverse$lambda2(ToolBarPresenter this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Function2<Boolean, TriplePraiseData, Unit> triplePraiseCallback = this$02.getTriplePraiseCallback();
        if (triplePraiseCallback != null) {
            triplePraiseCallback.invoke(false, null);
        }
    }

    public void handleTriplePraiseAnimEnd() {
        ToolBarPresenter.praiseTripleStatistics$default(this.this$0, "1", (String) null, 2, (Object) null);
    }
}
