package com.baidu.searchbox.ugc.aipackage.task;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/baidu/searchbox/ugc/aipackage/task/AiMediaFrameUploadTask;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiMediaFrameUploadManager.kt */
final class AiMediaFrameUploadManager$uploadTaskQueue$2 extends Lambda implements Function0<ConcurrentLinkedQueue<AiMediaFrameUploadTask>> {
    public static final AiMediaFrameUploadManager$uploadTaskQueue$2 INSTANCE = new AiMediaFrameUploadManager$uploadTaskQueue$2();

    AiMediaFrameUploadManager$uploadTaskQueue$2() {
        super(0);
    }

    public final ConcurrentLinkedQueue<AiMediaFrameUploadTask> invoke() {
        return new ConcurrentLinkedQueue<>();
    }
}
