package com.tera.scan.main.file;

import com.tera.scan.main.home.bean.listholder.AllFileListHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/main/home/bean/listholder/AllFileListHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FilePageInnerFragment$listHolder$2 extends Lambda implements Function0<AllFileListHolder> {
    public final /* synthetic */ FilePageInnerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilePageInnerFragment$listHolder$2(FilePageInnerFragment filePageInnerFragment) {
        super(0);
        this.this$0 = filePageInnerFragment;
    }

    @NotNull
    public final AllFileListHolder invoke() {
        return new AllFileListHolder(this.this$0.getMainActivityViewModel());
    }
}
