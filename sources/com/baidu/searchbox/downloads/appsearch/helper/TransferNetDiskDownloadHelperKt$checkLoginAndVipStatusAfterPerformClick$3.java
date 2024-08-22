package com.baidu.searchbox.downloads.appsearch.helper;

import com.baidu.searchbox.downloads.appsearch.ui.windows.DownloadMultiBtnProgressUrlCheckWindow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransferNetDiskDownloadHelper.kt */
final class TransferNetDiskDownloadHelperKt$checkLoginAndVipStatusAfterPerformClick$3 extends Lambda implements Function2<String, Integer, Unit> {
    public static final TransferNetDiskDownloadHelperKt$checkLoginAndVipStatusAfterPerformClick$3 INSTANCE = new TransferNetDiskDownloadHelperKt$checkLoginAndVipStatusAfterPerformClick$3();

    TransferNetDiskDownloadHelperKt$checkLoginAndVipStatusAfterPerformClick$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((String) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        DownloadMultiBtnProgressUrlCheckWindow access$getDownloadPanel$p = TransferNetDiskDownloadHelperKt.downloadPanel;
        if (access$getDownloadPanel$p != null) {
            access$getDownloadPanel$p.show();
        }
    }
}
