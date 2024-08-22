package com.tera.scan.business.textrecognition;

import androidx.lifecycle.Observer;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivityFlavor$login$2$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ Continuation<Boolean> $continuation;

    public static final class qw<T> implements Observer {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f6821ad;
        public final /* synthetic */ Continuation<Boolean> qw;

        public qw(Continuation<? super Boolean> continuation, boolean z) {
            this.qw = continuation;
            this.f6821ad = z;
        }

        /* renamed from: qw */
        public final void onChanged(Boolean bool) {
            Continuation<Boolean> continuation = this.qw;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1155constructorimpl(Boolean.valueOf(this.f6821ad)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivityFlavor$login$2$1(Continuation<? super Boolean> continuation) {
        super(1);
        this.$continuation = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        TradeAccount.f913rg.uk(new qw(this.$continuation, z));
    }
}
