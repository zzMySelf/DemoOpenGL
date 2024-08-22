package com.facebook.imagepipeline.core;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/facebook/imagepipeline/producers/SwallowResultProducer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProducerSequenceFactory.kt */
final class ProducerSequenceFactory$localFileFetchToEncodedMemoryPrefetchSequence$2 extends Lambda implements Function0<SwallowResultProducer<EncodedImage>> {
    final /* synthetic */ ProducerSequenceFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProducerSequenceFactory$localFileFetchToEncodedMemoryPrefetchSequence$2(ProducerSequenceFactory producerSequenceFactory) {
        super(0);
        this.this$0 = producerSequenceFactory;
    }

    public final SwallowResultProducer<EncodedImage> invoke() {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        ProducerSequenceFactory producerSequenceFactory = this.this$0;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.producerFactory.newSwallowResultProducer(producerSequenceFactory.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
        try {
            return producerSequenceFactory.producerFactory.newSwallowResultProducer(producerSequenceFactory.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }
}
