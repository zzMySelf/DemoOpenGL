package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;

public class SwallowResultProducer<T> implements Producer<Void> {
    private final Producer<T> mInputProducer;

    public SwallowResultProducer(Producer<T> inputProducer) {
        this.mInputProducer = inputProducer;
    }

    public void produceResults(Consumer<Void> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new DelegatingConsumer<T, Void>(consumer) {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(@Nullable T t, int status) {
                if (isLast(status)) {
                    getConsumer().onNewResult(null, status);
                }
            }
        }, producerContext);
    }
}
