package com.facebook.imagepipeline.producers;

import com.baidu.searchbox.home.utils.HomeUtilsKt;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/producers/DelayProducer;", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "inputProducer", "backgroundTasksExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "(Lcom/facebook/imagepipeline/producers/Producer;Ljava/util/concurrent/ScheduledExecutorService;)V", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "imagepipeline_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelayProducer.kt */
public final class DelayProducer implements Producer<CloseableReference<CloseableImage>> {
    private final ScheduledExecutorService backgroundTasksExecutor;
    private final Producer<CloseableReference<CloseableImage>> inputProducer;

    public DelayProducer(Producer<CloseableReference<CloseableImage>> inputProducer2, ScheduledExecutorService backgroundTasksExecutor2) {
        Intrinsics.checkNotNullParameter(inputProducer2, "inputProducer");
        this.inputProducer = inputProducer2;
        this.backgroundTasksExecutor = backgroundTasksExecutor2;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, HomeUtilsKt.HOME_PLUS_PUBLISHER_SP_USER_TYPE_C);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageRequest request = context.getImageRequest();
        ScheduledExecutorService scheduledExecutorService = this.backgroundTasksExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new DelayProducer$$ExternalSyntheticLambda0(this, consumer, context), (long) request.getDelayMs(), TimeUnit.MILLISECONDS);
        } else {
            this.inputProducer.produceResults(consumer, context);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: produceResults$lambda-0  reason: not valid java name */
    public static final void m8196produceResults$lambda0(DelayProducer this$0, Consumer $consumer, ProducerContext $context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($consumer, "$consumer");
        Intrinsics.checkNotNullParameter($context, "$context");
        this$0.inputProducer.produceResults($consumer, $context);
    }
}
