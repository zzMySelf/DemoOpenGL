package com.tera.scan.pdfedit.data;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddPdfItemData$fileSize$2 extends Lambda implements Function0<Long> {
    public final /* synthetic */ AddPdfItemData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddPdfItemData$fileSize$2(AddPdfItemData addPdfItemData) {
        super(0);
        this.this$0 = addPdfItemData;
    }

    @NotNull
    public final Long invoke() {
        Object obj;
        AddPdfItemData addPdfItemData = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            String localPath = addPdfItemData.getScanRecordExportFile().getLocalPath();
            if (localPath == null) {
                localPath = "";
            }
            obj = Result.m1155constructorimpl(Long.valueOf(new File(localPath).length()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        Long l = (Long) obj;
        return Long.valueOf(l != null ? l.longValue() : 0);
    }
}
