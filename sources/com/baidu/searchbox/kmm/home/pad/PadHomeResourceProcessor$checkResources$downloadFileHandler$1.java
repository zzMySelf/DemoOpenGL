package com.baidu.searchbox.kmm.home.pad;

import com.baidu.searchbox.kmm.crypto.HashUtilsKt;
import com.baidu.searchbox.kmm.foundation.concurrent.CancelableTask;
import com.baidu.searchbox.kmm.services.download.DownloadTaskInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/kmm/foundation/concurrent/CancelableTask;", "isSucceed", "", "taskInfo", "Lcom/baidu/searchbox/kmm/services/download/DownloadTaskInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadHomeResourceProcessor.kt */
final class PadHomeResourceProcessor$checkResources$downloadFileHandler$1 extends Lambda implements Function2<Boolean, DownloadTaskInfo, CancelableTask> {
    final /* synthetic */ PadHomeResModel $downloadInfo;
    final /* synthetic */ List<String> $fileNameList;
    final /* synthetic */ Function1<Boolean, Unit> $finishCallback;
    final /* synthetic */ Ref.ObjectRef<Map<String, String>> $pathMap;
    final /* synthetic */ PadHomeResourceProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PadHomeResourceProcessor$checkResources$downloadFileHandler$1(PadHomeResModel padHomeResModel, Ref.ObjectRef<Map<String, String>> objectRef, PadHomeResourceProcessor padHomeResourceProcessor, List<String> list, Function1<? super Boolean, Unit> function1) {
        super(2);
        this.$downloadInfo = padHomeResModel;
        this.$pathMap = objectRef;
        this.this$0 = padHomeResourceProcessor;
        this.$fileNameList = list;
        this.$finishCallback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke(((Boolean) p1).booleanValue(), (DownloadTaskInfo) p2);
    }

    public final CancelableTask invoke(boolean isSucceed, DownloadTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        final PadHomeResModel padHomeResModel = this.$downloadInfo;
        final Ref.ObjectRef<Map<String, String>> objectRef = this.$pathMap;
        final PadHomeResourceProcessor padHomeResourceProcessor = this.this$0;
        final List<String> list = this.$fileNameList;
        final Function1<Boolean, Unit> function1 = this.$finishCallback;
        final boolean z = isSucceed;
        final DownloadTaskInfo downloadTaskInfo = taskInfo;
        return PadHomeCommonKt.padHomeAsyncWork(new Function0<Unit>() {
            public final void invoke() {
                if (z) {
                    String md5 = padHomeResModel.getMd5();
                    String downloadedPath = downloadTaskInfo.getStoragePath();
                    if (Intrinsics.areEqual((Object) HashUtilsKt.getFileMD5(downloadedPath), (Object) md5)) {
                        objectRef.element = padHomeResourceProcessor.handleResZip(padHomeResModel, list, downloadedPath);
                    }
                }
                Function1<Boolean, Unit> function1 = function1;
                Map map = (Map) objectRef.element;
                boolean z = false;
                if (map != null && (!map.isEmpty())) {
                    z = true;
                }
                function1.invoke(Boolean.valueOf(z));
            }
        });
    }
}
