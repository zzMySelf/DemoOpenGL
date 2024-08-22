package com.baidu.searchbox.imagesearch.host.entry.ai.edit;

import com.baidu.searchbox.imagesearch.host.entry.ai.edit.ImageAIEditRepository;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageAIEditRepository$Companion$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ImageAIEditResult f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ IImageAIEditCallback f$2;

    public /* synthetic */ ImageAIEditRepository$Companion$$ExternalSyntheticLambda0(ImageAIEditResult imageAIEditResult, String str, IImageAIEditCallback iImageAIEditCallback) {
        this.f$0 = imageAIEditResult;
        this.f$1 = str;
        this.f$2 = iImageAIEditCallback;
    }

    public final void run() {
        ImageAIEditRepository.Companion.m20385editCallbackOnUIThread$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
