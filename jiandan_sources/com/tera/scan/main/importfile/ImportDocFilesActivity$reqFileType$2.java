package com.tera.scan.main.importfile;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImportDocFilesActivity$reqFileType$2 extends Lambda implements Function0<String> {
    public final /* synthetic */ ImportDocFilesActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFilesActivity$reqFileType$2(ImportDocFilesActivity importDocFilesActivity) {
        super(0);
        this.this$0 = importDocFilesActivity;
    }

    @Nullable
    public final String invoke() {
        return this.this$0.getIntent().getStringExtra("file_type");
    }
}
