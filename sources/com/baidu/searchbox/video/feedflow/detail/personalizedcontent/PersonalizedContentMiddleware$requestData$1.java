package com.baidu.searchbox.video.feedflow.detail.personalizedcontent;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.video.feedflow.detail.personalizedcontent.PersonalizedContentMiddleware$requestData$1", f = "PersonalizedContentMiddleware.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PersonalizedContentMiddleware.kt */
final class PersonalizedContentMiddleware$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestParam $param;
    final /* synthetic */ Store<CommonState> $store;
    int label;
    final /* synthetic */ PersonalizedContentMiddleware this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalizedContentMiddleware$requestData$1(PersonalizedContentMiddleware personalizedContentMiddleware, RequestParam requestParam, Store<CommonState> store, Continuation<? super PersonalizedContentMiddleware$requestData$1> continuation) {
        super(2, continuation);
        this.this$0 = personalizedContentMiddleware;
        this.$param = requestParam;
        this.$store = store;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersonalizedContentMiddleware$requestData$1(this.this$0, this.$param, this.$store, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersonalizedContentMiddleware$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0019;
                case 1: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0012:
            r0 = r11
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r0
            r0 = r12
            goto L_0x0036
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            com.baidu.searchbox.video.feedflow.detail.personalizedcontent.PersonalizedContentMiddleware r3 = r1.this$0
            com.baidu.searchbox.flowvideo.personalizedcontent.repos.PersonalizedContentRepository r3 = r3.repos
            if (r3 == 0) goto L_0x0039
            com.baidu.searchbox.feed.detail.ext.common.RequestParam r4 = r1.$param
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 1
            r1.label = r6
            java.lang.Object r3 = r3.getPersonalizedContentInfo(r4, r5)
            if (r3 != r0) goto L_0x0034
            return r0
        L_0x0034:
            r0 = r12
            r12 = r3
        L_0x0036:
            com.baidu.searchbox.feed.detail.ext.common.Result r12 = (com.baidu.searchbox.feed.detail.ext.common.Result) r12
            goto L_0x003b
        L_0x0039:
            r0 = r12
            r12 = r2
        L_0x003b:
            boolean r3 = r12 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Success
            if (r3 == 0) goto L_0x0088
            r3 = r12
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r3 = (com.baidu.searchbox.feed.detail.ext.common.Result.Success) r3
            java.lang.Object r3 = r3.getData()
            boolean r12 = r3 instanceof com.baidu.searchbox.flowvideo.personalizedcontent.api.PersonalizedContentDataBean
            if (r12 == 0) goto L_0x004e
            com.baidu.searchbox.flowvideo.personalizedcontent.api.PersonalizedContentDataBean r3 = (com.baidu.searchbox.flowvideo.personalizedcontent.api.PersonalizedContentDataBean) r3
            goto L_0x004f
        L_0x004e:
            r3 = r2
        L_0x004f:
            if (r3 == 0) goto L_0x0068
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r12 = r1.$store
            r4 = 0
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success r5 = new com.baidu.searchbox.feed.detail.arch.ext.NetAction$Success
            com.baidu.searchbox.video.feedflow.detail.personalizedcontent.mapper.PersonalizedContentMapper r6 = com.baidu.searchbox.video.feedflow.detail.personalizedcontent.mapper.PersonalizedContentMapper.INSTANCE
            com.baidu.searchbox.video.feedflow.detail.personalizedcontent.mapper.PersonalizedContentDataModel r6 = r6.map((com.baidu.searchbox.flowvideo.personalizedcontent.api.PersonalizedContentDataBean) r3)
            r7 = 0
            r8 = 2
            r5.<init>(r6, r7, r8, r2)
            com.baidu.searchbox.feed.detail.frame.Action r5 = (com.baidu.searchbox.feed.detail.frame.Action) r5
            r12.dispatch(r5)
            goto L_0x00ab
        L_0x0068:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r12 = r1.$store
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure r9 = new com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure
            com.baidu.searchbox.feed.detail.ext.common.RequestParam r2 = r1.$param
            java.lang.Class r3 = r2.getClass()
            java.lang.Throwable r4 = new java.lang.Throwable
            java.lang.String r2 = "data is null"
            r4.<init>(r2)
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.baidu.searchbox.feed.detail.frame.Action r9 = (com.baidu.searchbox.feed.detail.frame.Action) r9
            r12.dispatch(r9)
            goto L_0x00ab
        L_0x0088:
            boolean r2 = r12 instanceof com.baidu.searchbox.feed.detail.ext.common.Result.Failure
            if (r2 == 0) goto L_0x00ab
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r2 = r1.$store
            com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure r10 = new com.baidu.searchbox.feed.detail.arch.ext.NetAction$Failure
            com.baidu.searchbox.feed.detail.ext.common.RequestParam r3 = r1.$param
            java.lang.Class r4 = r3.getClass()
            r3 = r12
            com.baidu.searchbox.feed.detail.ext.common.Result$Failure r3 = (com.baidu.searchbox.feed.detail.ext.common.Result.Failure) r3
            java.lang.Throwable r5 = r3.getThrowable()
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            com.baidu.searchbox.feed.detail.frame.Action r10 = (com.baidu.searchbox.feed.detail.frame.Action) r10
            r2.dispatch(r10)
        L_0x00ab:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.personalizedcontent.PersonalizedContentMiddleware$requestData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
