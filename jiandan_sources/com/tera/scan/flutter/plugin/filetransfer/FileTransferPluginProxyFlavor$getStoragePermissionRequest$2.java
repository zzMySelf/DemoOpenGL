package com.tera.scan.flutter.plugin.filetransfer;

import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.permission.util.ReadImagesPermissionHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FileTransferPluginProxyFlavor$getStoragePermissionRequest$2 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ Ref.ObjectRef<ReadImagesPermissionHelper> $helper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileTransferPluginProxyFlavor$getStoragePermissionRequest$2(Function1<? super Boolean, Unit> function1, Ref.ObjectRef<ReadImagesPermissionHelper> objectRef) {
        super(1);
        this.$callback = function1;
        this.$helper = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.$callback.invoke(Boolean.valueOf(z));
        this.$helper.element = null;
        LoggerKt.d$default("permissionRequest onRefuseClick called", (Object) null, 1, (Object) null);
    }
}
