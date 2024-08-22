package com.baidu.searchbox.ugc.aivideo;

import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityUploadImageDetailTask;", "", "filePath", "", "listener", "Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityUploadImageDetailTask$OnUploadResultListener;", "(Ljava/lang/String;Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityUploadImageDetailTask$OnUploadResultListener;)V", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "uploadCallback", "Lcom/baidu/searchbox/ugc/upload/UploadManager$UploadCallback;", "uploadManager", "Lcom/baidu/searchbox/ugc/upload/UploadManager;", "kotlin.jvm.PlatformType", "getUploadManager", "()Lcom/baidu/searchbox/ugc/upload/UploadManager;", "uploadManager$delegate", "Lkotlin/Lazy;", "", "release", "", "start", "Companion", "OnUploadResultListener", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiVideoActivityUploadImageDetailTask.kt */
public final class AiVideoActivityUploadImageDetailTask {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UPLOAD_STATUS_FAIL = -1;
    public static final int UPLOAD_STATUS_SUCCESS = 1;
    private final String filePath;
    /* access modifiers changed from: private */
    public volatile AtomicBoolean isRunning = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public OnUploadResultListener listener;
    private UploadManager.UploadCallback uploadCallback;
    private final Lazy uploadManager$delegate = LazyKt.lazy(AiVideoActivityUploadImageDetailTask$uploadManager$2.INSTANCE);

    public AiVideoActivityUploadImageDetailTask(String filePath2, OnUploadResultListener listener2) {
        this.filePath = filePath2;
        this.listener = listener2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityUploadImageDetailTask$Companion;", "", "()V", "UPLOAD_STATUS_FAIL", "", "UPLOAD_STATUS_SUCCESS", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiVideoActivityUploadImageDetailTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final UploadManager getUploadManager() {
        return (UploadManager) this.uploadManager$delegate.getValue();
    }

    public final void start() {
        CharSequence charSequence = this.filePath;
        if (charSequence == null || charSequence.length() == 0) {
            OnUploadResultListener onUploadResultListener = this.listener;
            if (onUploadResultListener != null) {
                OnUploadResultListener.DefaultImpls.uploadResult$default(onUploadResultListener, (String) null, -1, (String) null, 4, (Object) null);
                return;
            }
            return;
        }
        this.isRunning.set(true);
        if (this.uploadCallback == null) {
            this.uploadCallback = new AiVideoActivityUploadImageDetailTask$start$1(this);
        }
        getUploadManager().setUploadCallback(this.uploadCallback);
        List tasks = new ArrayList();
        ImageStruct imageStruct = new ImageStruct(this.filePath);
        imageStruct.imgType = 6;
        tasks.add(new UploadImageTask(imageStruct));
        getUploadManager().startAll(tasks instanceof List ? tasks : null, 0, "ugc");
    }

    public final boolean isRunning() {
        return this.isRunning.get();
    }

    public final void release() {
        this.uploadCallback = null;
        this.listener = null;
        this.isRunning.set(false);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityUploadImageDetailTask$OnUploadResultListener;", "", "uploadResult", "", "url", "", "status", "", "msg", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiVideoActivityUploadImageDetailTask.kt */
    public interface OnUploadResultListener {
        void uploadResult(String str, int i2, String str2);

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AiVideoActivityUploadImageDetailTask.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void uploadResult$default(OnUploadResultListener onUploadResultListener, String str, int i2, String str2, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 4) != 0) {
                        str2 = null;
                    }
                    onUploadResultListener.uploadResult(str, i2, str2);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadResult");
            }
        }
    }
}
