package com.baidu.searchbox.videopublisher.aipublishergenerate.generateinfo.manager;

import com.baidu.searchbox.ugc.aipackage.task.AiMediaFrameUploadManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ugc/aipackage/task/AiMediaFrameUploadManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPublisherPackageManager.kt */
final class AiPublisherPackageManager$frameUploadManager$2 extends Lambda implements Function0<AiMediaFrameUploadManager> {
    public static final AiPublisherPackageManager$frameUploadManager$2 INSTANCE = new AiPublisherPackageManager$frameUploadManager$2();

    AiPublisherPackageManager$frameUploadManager$2() {
        super(0);
    }

    public final AiMediaFrameUploadManager invoke() {
        return new AiMediaFrameUploadManager(false);
    }
}
