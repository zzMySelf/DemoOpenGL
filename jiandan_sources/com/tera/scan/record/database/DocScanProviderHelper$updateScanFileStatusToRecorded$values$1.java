package com.tera.scan.record.database;

import com.mars.kotlin.extension.ContentValuesScope;
import com.tera.scan.record.model.FileUploadStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/ContentValuesScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocScanProviderHelper$updateScanFileStatusToRecorded$values$1 extends Lambda implements Function1<ContentValuesScope, Unit> {
    public static final DocScanProviderHelper$updateScanFileStatusToRecorded$values$1 INSTANCE = new DocScanProviderHelper$updateScanFileStatusToRecorded$values$1();

    public DocScanProviderHelper$updateScanFileStatusToRecorded$values$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentValuesScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentValuesScope contentValuesScope) {
        Intrinsics.checkNotNullParameter(contentValuesScope, "$this$ContentValues");
        contentValuesScope.minus("status", Integer.valueOf(FileUploadStatus.RECORDED.ordinal()));
    }
}
