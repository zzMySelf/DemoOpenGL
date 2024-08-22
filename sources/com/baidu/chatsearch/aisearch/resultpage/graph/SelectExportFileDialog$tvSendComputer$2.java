package com.baidu.chatsearch.aisearch.resultpage.graph;

import android.widget.TextView;
import com.baidu.chatsearch.resultpage.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectExportFileDialog.kt */
final class SelectExportFileDialog$tvSendComputer$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ SelectExportFileDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectExportFileDialog$tvSendComputer$2(SelectExportFileDialog selectExportFileDialog) {
        super(0);
        this.this$0 = selectExportFileDialog;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.tv_send_computer);
    }
}
