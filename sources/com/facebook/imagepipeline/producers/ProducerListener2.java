package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;

public interface ProducerListener2 {
    void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th2, @Nullable Map<String, String> map);

    void onProducerEvent(ProducerContext producerContext, String str, String str2);

    void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map<String, String> map);

    void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th2, @Nullable Map<String, String> map);

    void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map<String, String> map);

    void onProducerStart(ProducerContext producerContext, String str);

    void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z);

    boolean requiresExtraMap(ProducerContext producerContext, String str);
}
