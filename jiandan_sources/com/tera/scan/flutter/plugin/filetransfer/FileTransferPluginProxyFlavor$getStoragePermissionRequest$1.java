package com.tera.scan.flutter.plugin.filetransfer;

import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.permission.util.ReadImagesPermissionHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FileTransferPluginProxyFlavor$getStoragePermissionRequest$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ Ref.ObjectRef<ReadImagesPermissionHelper> $helper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileTransferPluginProxyFlavor$getStoragePermissionRequest$1(Function1<? super Boolean, Unit> function1, Ref.ObjectRef<ReadImagesPermissionHelper> objectRef) {
        super(0);
        this.$callback = function1;
        this.$helper = objectRef;
    }

    public final void invoke() {
        this.$callback.invoke(Boolean.TRUE);
        this.$helper.element = null;
        LoggerKt.d$default("permissionRequest hasPermissionBlock called", (Object) null, 1, (Object) null);
    }
}
