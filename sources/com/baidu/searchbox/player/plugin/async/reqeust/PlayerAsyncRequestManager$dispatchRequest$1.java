package com.baidu.searchbox.player.plugin.async.reqeust;

import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.plugin.async.callback.IAsyncRequestCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerAsyncRequestManager.kt */
final class PlayerAsyncRequestManager$dispatchRequest$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $hasResponse;
    final /* synthetic */ String $key;
    final /* synthetic */ IAsyncRequestCallback $requestCallback;
    final /* synthetic */ BasicVideoSeries $series;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerAsyncRequestManager$dispatchRequest$1(Ref.BooleanRef booleanRef, String str, IAsyncRequestCallback iAsyncRequestCallback, BasicVideoSeries basicVideoSeries) {
        super(0);
        this.$hasResponse = booleanRef;
        this.$key = str;
        this.$requestCallback = iAsyncRequestCallback;
        this.$series = basicVideoSeries;
    }

    public final void invoke() {
        if (PlayerAsyncRequestManager.delayHandler == null) {
            PlayerAsyncRequestManager playerAsyncRequestManager = PlayerAsyncRequestManager.INSTANCE;
            PlayerAsyncRequestManager.delayHandler = new Handler(Looper.getMainLooper());
        }
        Handler access$getDelayHandler$p = PlayerAsyncRequestManager.delayHandler;
        if (access$getDelayHandler$p != null) {
            access$getDelayHandler$p.postDelayed(new PlayerAsyncRequestManager$dispatchRequest$1$$ExternalSyntheticLambda0(this.$hasResponse, this.$key, this.$requestCallback, this.$series), PlayerAsyncRequestManager.getVideoMPDTimeout());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2365invoke$lambda0(Ref.BooleanRef $hasResponse2, String $key2, IAsyncRequestCallback $requestCallback2, BasicVideoSeries $series2) {
        Intrinsics.checkNotNullParameter($hasResponse2, "$hasResponse");
        Intrinsics.checkNotNullParameter($key2, "$key");
        Intrinsics.checkNotNullParameter($series2, "$series");
        if (!$hasResponse2.element) {
            PlayerAsyncRequestManager.INSTANCE.removeRequesting($key2);
            PlayerAsyncRequest.INSTANCE.cancelRequest($key2);
            if ($requestCallback2 != null) {
                $requestCallback2.invoke($series2, 4);
            }
        }
    }
}
