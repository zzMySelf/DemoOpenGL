package com.tera.scan.record.database;

import com.mars.kotlin.extension.ContentValuesScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/mars/kotlin/extension/ContentValuesScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocScanProviderHelper$updateScanRecordExportFile$values$1 extends Lambda implements Function1<ContentValuesScope, Unit> {
    public final /* synthetic */ String $newLocalPath;
    public final /* synthetic */ String $newName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocScanProviderHelper$updateScanRecordExportFile$values$1(String str, String str2) {
        super(1);
        this.$newName = str;
        this.$newLocalPath = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentValuesScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentValuesScope contentValuesScope) {
        Intrinsics.checkNotNullParameter(contentValuesScope, "$this$ContentValues");
        contentValuesScope.minus("filename", this.$newName);
        contentValuesScope.minus("local_path", this.$newLocalPath);
    }
}
