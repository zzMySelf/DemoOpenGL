package com.tera.scan.file.selector.ui.viewmodel;

import fe.mmm.qw.h.de.qw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "index", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocalImageSelectViewModel$onReqGalleryOkBusiness$outPutPathList$1 extends Lambda implements Function2<Integer, String, String> {
    public final /* synthetic */ String $imgCompressDir;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectViewModel$onReqGalleryOkBusiness$outPutPathList$1(String str) {
        super(2);
        this.$imgCompressDir = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (String) obj2);
    }

    @NotNull
    public final String invoke(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        return new qw().th(this.$imgCompressDir, i2);
    }
}
