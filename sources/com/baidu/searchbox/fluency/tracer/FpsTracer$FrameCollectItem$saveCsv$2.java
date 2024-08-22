package com.baidu.searchbox.fluency.tracer;

import android.text.TextUtils;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.Logcat;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.fluency.tracer.FpsTracer$FrameCollectItem$saveCsv$2", f = "FpsTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FpsTracer.kt */
final class FpsTracer$FrameCollectItem$saveCsv$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FpsTracer.FrameCollectItem this$0;
    final /* synthetic */ FpsTracer this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FpsTracer$FrameCollectItem$saveCsv$2(FpsTracer.FrameCollectItem frameCollectItem, FpsTracer fpsTracer, Continuation<? super FpsTracer$FrameCollectItem$saveCsv$2> continuation) {
        super(2, continuation);
        this.this$0 = frameCollectItem;
        this.this$1 = fpsTracer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FpsTracer$FrameCollectItem$saveCsv$2(this.this$0, this.this$1, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FpsTracer$FrameCollectItem$saveCsv$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Object obj2 = obj;
                try {
                    if (!TextUtils.equals(this.this$0.from, "feed")) {
                        return Unit.INSTANCE;
                    }
                    int fps = MathKt.roundToInt(Math.min(60.0f, (((float) this.this$0.sumFrames) * 1000.0f) / this.this$0.getSumFrameCost()));
                    Logcat.INSTANCE.d(FpsTracer.TAG, "[saveCsv] fps: " + fps + ", " + this.this$0);
                    int dropFrozen = this.this$0.dropLevel[DropLevel.DROPPED_FROZEN.getIndex()];
                    int dropHigh = this.this$0.dropLevel[DropLevel.DROPPED_HIGH.getIndex()];
                    int dropMiddle = this.this$0.dropLevel[DropLevel.DROPPED_MIDDLE.getIndex()];
                    int dropNormal = this.this$0.dropLevel[DropLevel.DROPPED_NORMAL.getIndex()];
                    int dropBest = this.this$0.dropLevel[DropLevel.DROPPED_BEST.getIndex()];
                    File file = this.this$1.getCsvFile();
                    if (!file.exists()) {
                        Logcat.INSTANCE.d(FpsTracer.TAG, "create file: " + file.getAbsolutePath());
                        FileOutputStream os = new FileOutputStream(file);
                        byte[] bytes = "fps,dropFrozen,dropHigh,dropMiddle,dropNormal,dropBest".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        os.write(bytes);
                        byte[] bytes2 = "\r\n".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                        os.write(bytes2);
                        byte[] bytes3 = new StringBuilder().append(fps).append(AbstractJsonLexerKt.COMMA).append(dropFrozen).append(AbstractJsonLexerKt.COMMA).append(dropHigh).append(AbstractJsonLexerKt.COMMA).append(dropMiddle).append(AbstractJsonLexerKt.COMMA).append(dropNormal).append(AbstractJsonLexerKt.COMMA).append(dropBest).toString().getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                        os.write(bytes3);
                        os.close();
                    } else {
                        Logcat.INSTANCE.d(FpsTracer.TAG, "file exist: " + file.getAbsolutePath());
                        FileOutputStream os2 = new FileOutputStream(file, true);
                        byte[] bytes4 = "\r\n".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
                        os2.write(bytes4);
                        byte[] bytes5 = new StringBuilder().append(fps).append(AbstractJsonLexerKt.COMMA).append(dropFrozen).append(AbstractJsonLexerKt.COMMA).append(dropHigh).append(AbstractJsonLexerKt.COMMA).append(dropMiddle).append(AbstractJsonLexerKt.COMMA).append(dropNormal).append(AbstractJsonLexerKt.COMMA).append(dropBest).toString().getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes5, "this as java.lang.String).getBytes(charset)");
                        os2.write(bytes5);
                        os2.close();
                    }
                    return Unit.INSTANCE;
                } catch (Exception e2) {
                    Logcat.INSTANCE.e(FpsTracer.TAG, "saveCsv, exception: " + e2);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
