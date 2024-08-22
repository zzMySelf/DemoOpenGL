package com.baidu.searchbox.feed.payment.account;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel$upload$1", f = "SpColumnAccountViewModel.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SpColumnAccountViewModel.kt */
final class SpColumnAccountViewModel$upload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpColumnAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpColumnAccountViewModel$upload$1(SpColumnAccountViewModel spColumnAccountViewModel, Continuation<? super SpColumnAccountViewModel$upload$1> continuation) {
        super(2, continuation);
        this.this$0 = spColumnAccountViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpColumnAccountViewModel$upload$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpColumnAccountViewModel$upload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            switch(r1) {
                case 0: goto L_0x0019;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0011:
            r0 = r11
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r0
            r0 = r12
            goto L_0x0089
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            java.lang.String r2 = r2.getToken()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r2 = r3
            goto L_0x0033
        L_0x0032:
            r2 = r4
        L_0x0033:
            if (r2 == 0) goto L_0x0096
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            java.lang.String r2 = r2.getPhoneNum()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0048
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r2 = r3
            goto L_0x0049
        L_0x0048:
            r2 = r4
        L_0x0049:
            if (r2 == 0) goto L_0x0096
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            com.baidu.searchbox.feed.payment.model.PayStats1076 r2 = r2.getPayStats1076()
            if (r2 == 0) goto L_0x0056
            r2.recordDefaultAccount()
        L_0x0056:
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.getLoadingStatus()
            com.baidu.searchbox.feed.payment.account.LoadingStatus r3 = com.baidu.searchbox.feed.payment.account.LoadingStatus.LOADING
            r2.postValue(r3)
            com.baidu.searchbox.feed.payment.account.SpColumnAccountDataManager r5 = com.baidu.searchbox.feed.payment.account.SpColumnAccountDataManager.INSTANCE
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            java.lang.String r6 = r2.getNid()
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            boolean r7 = r2.isCombineBuy()
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            java.util.List r8 = r2.getSelectedIds()
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            java.lang.String r9 = r2.getRecommendBuyId()
            r10 = r1
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r1.label = r4
            java.lang.Object r2 = r5.uploadDefault(r6, r7, r8, r9, r10)
            if (r2 != r0) goto L_0x0087
            return r0
        L_0x0087:
            r0 = r12
            r12 = r2
        L_0x0089:
            com.baidu.searchbox.feed.payment.account.LoadingStatus r12 = (com.baidu.searchbox.feed.payment.account.LoadingStatus) r12
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r2 = r1.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.getLoadingStatus()
            r2.postValue(r12)
            r12 = r0
            goto L_0x00e4
        L_0x0096:
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r0 = r1.this$0
            java.lang.String r0 = r0.getToken()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00a9
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x00a7
            goto L_0x00a9
        L_0x00a7:
            r0 = r3
            goto L_0x00aa
        L_0x00a9:
            r0 = r4
        L_0x00aa:
            if (r0 == 0) goto L_0x00c1
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r0 = r1.this$0
            com.baidu.searchbox.feed.payment.model.PayStats1076 r0 = r0.getPayStats1076()
            if (r0 == 0) goto L_0x00b7
            r0.recordInputAccount()
        L_0x00b7:
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r0 = r1.this$0
            java.lang.String r2 = r0.getPhoneNum()
            r0.uploadEncryptedPhoneNum(r2)
            goto L_0x00e4
        L_0x00c1:
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r0 = r1.this$0
            java.lang.String r0 = r0.getPhoneNum()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00d1
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x00d2
        L_0x00d1:
            r3 = r4
        L_0x00d2:
            if (r3 == 0) goto L_0x00e4
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r0 = r1.this$0
            com.baidu.searchbox.feed.payment.model.PayStats1076 r0 = r0.getPayStats1076()
            if (r0 == 0) goto L_0x00df
            r0.recordUseOwnAccount()
        L_0x00df:
            com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel r0 = r1.this$0
            r0.uploadToken()
        L_0x00e4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.account.SpColumnAccountViewModel$upload$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
