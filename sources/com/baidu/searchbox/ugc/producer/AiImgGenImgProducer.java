package com.baidu.searchbox.ugc.producer;

import com.baidu.searchbox.publisher.producer.BaseUgcProducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/ugc/producer/AiImgGenImgProducer;", "Lcom/baidu/searchbox/publisher/producer/BaseUgcProducer;", "type", "", "(Ljava/lang/String;)V", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiImgGenImgProducer.kt */
public final class AiImgGenImgProducer extends BaseUgcProducer {
    public AiImgGenImgProducer(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.mProducerType = type;
    }
}
