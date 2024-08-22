package com.tera.scan.flutter.plugin.filetransfer;

import i.qw.Cif;
import i.qw.i0;
import i.qw.u;
import i.qw.z0;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "granted", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FileTransferPluginProxy$onMethodCall$1$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ MethodChannel.Result $result;
    public final /* synthetic */ FileTransferPluginProxy this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.tera.scan.flutter.plugin.filetransfer.FileTransferPluginProxy$onMethodCall$1$1$1", f = "FileTransferPluginProxy.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tera.scan.flutter.plugin.filetransfer.FileTransferPluginProxy$onMethodCall$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(fileTransferPluginProxy, result, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                fileTransferPluginProxy.m762if();
                z0 de2 = u.de();
                final MethodChannel.Result result = result;
                AnonymousClass1 r1 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    public int label;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public FileTransferPluginProxy$onMethodCall$1$1(MethodChannel.Result result, FileTransferPluginProxy fileTransferPluginProxy) {
                            super(1);
                            this.$result = result;
                            this.this$0 = fileTransferPluginProxy;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            if (!z) {
                                this.$result.success(Boolean.FALSE);
                                this.this$0.f6939pf.clear();
                                return;
                            }
                            i0 i0Var = i0.f6136ad;
                            final FileTransferPluginProxy fileTransferPluginProxy = this.this$0;
                            final MethodChannel.Result result = this.$result;
                            Job unused = Cif.fe(i0Var, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                        }
                    }
