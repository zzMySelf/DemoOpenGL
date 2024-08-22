package com.facebook.imagepipeline.core;

import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImagePipelineExperiments.kt */
final class ImagePipelineExperiments$Builder$setPlatformDecoderOptions$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PlatformDecoderOptions $platformDecoderOptions;
    final /* synthetic */ ImagePipelineExperiments.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagePipelineExperiments$Builder$setPlatformDecoderOptions$1(ImagePipelineExperiments.Builder builder, PlatformDecoderOptions platformDecoderOptions) {
        super(0);
        this.this$0 = builder;
        this.$platformDecoderOptions = platformDecoderOptions;
    }

    public final void invoke() {
        this.this$0.platformDecoderOptions = this.$platformDecoderOptions;
    }
}
