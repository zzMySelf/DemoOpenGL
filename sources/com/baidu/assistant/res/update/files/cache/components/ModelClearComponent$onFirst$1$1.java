package com.baidu.assistant.res.update.files.cache.components;

import com.baidu.assistant.res.update.files.cache.ClearFileManager;
import com.baidu.assistant.res.update.utils.DownloadLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModelClearComponent.kt */
final class ModelClearComponent$onFirst$1$1 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ ModelClearComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModelClearComponent$onFirst$1$1(ModelClearComponent modelClearComponent) {
        super(1);
        this.this$0 = modelClearComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((File) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ModelClearComponent modelClearComponent = this.this$0;
        final ModelClearComponent modelClearComponent2 = this.this$0;
        modelClearComponent.forEachDirectory(it, new Function1<File, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((File) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(File modelFile) {
                Intrinsics.checkNotNullParameter(modelFile, "modelFile");
                ClearFileManager.INSTANCE.updateLastAccessTime(modelFile.getAbsolutePath());
                DownloadLog.INSTANCE.i(modelClearComponent2.TAG, "onFirst updateLastAccessTime " + modelFile.getAbsolutePath());
            }
        });
    }
}
