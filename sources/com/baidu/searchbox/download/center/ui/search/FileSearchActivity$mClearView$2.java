package com.baidu.searchbox.download.center.ui.search;

import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.ui.BdBaseImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileSearchActivity.kt */
final class FileSearchActivity$mClearView$2 extends Lambda implements Function0<BdBaseImageView> {
    final /* synthetic */ FileSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileSearchActivity$mClearView$2(FileSearchActivity fileSearchActivity) {
        super(0);
        this.this$0 = fileSearchActivity;
    }

    public final BdBaseImageView invoke() {
        return (BdBaseImageView) this.this$0.findViewById(R.id.clear);
    }
}
