package com.baidu.searchbox.sport.common.bim.adapter;

import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.util.concurrent.UiThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/sport/common/bim/adapter/ConnectAdapter;", "Lcom/baidu/android/imsdk/account/IConnectListener;", "onConnected", "", "onDisconnected", "onResult", "errorCode", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectAdapter.kt */
public interface ConnectAdapter extends IConnectListener {
    void onConnected();

    void onDisconnected();

    void onResult(int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectAdapter.kt */
    public static final class DefaultImpls {
        public static void onResult(ConnectAdapter connectAdapter, int errorCode) {
            if (errorCode == 0) {
                UiThreadUtils.runOnUiThread(new ConnectAdapter$DefaultImpls$$ExternalSyntheticLambda0(connectAdapter));
            } else {
                UiThreadUtils.runOnUiThread(new ConnectAdapter$DefaultImpls$$ExternalSyntheticLambda1(connectAdapter));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onResult$lambda-0  reason: not valid java name */
        public static void m3361onResult$lambda0(ConnectAdapter this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onConnected();
        }

        /* access modifiers changed from: private */
        /* renamed from: onResult$lambda-1  reason: not valid java name */
        public static void m3362onResult$lambda1(ConnectAdapter this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onDisconnected();
        }
    }
}
