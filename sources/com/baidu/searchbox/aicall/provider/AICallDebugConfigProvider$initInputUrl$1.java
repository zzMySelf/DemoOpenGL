package com.baidu.searchbox.aicall.provider;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.searchbox.debug.data.ViewFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/aicall/provider/AICallDebugConfigProvider$initInputUrl$1", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "fetchView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lib-chatsearch-aicall-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallDebugConfigProvider.kt */
public final class AICallDebugConfigProvider$initInputUrl$1 implements ViewFetcher {
    final /* synthetic */ AICallDebugConfigProvider this$0;

    AICallDebugConfigProvider$initInputUrl$1(AICallDebugConfigProvider $receiver) {
        this.this$0 = $receiver;
    }

    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        EditText editText = new EditText(context);
        AICallDebugConfigProvider aICallDebugConfigProvider = this.this$0;
        EditText $this$fetchView_u24lambda_u2d0 = editText;
        $this$fetchView_u24lambda_u2d0.setHint("输入调起时传的URL");
        $this$fetchView_u24lambda_u2d0.setMaxLines(5);
        $this$fetchView_u24lambda_u2d0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        aICallDebugConfigProvider.edtUrlInput = $this$fetchView_u24lambda_u2d0;
        return editText;
    }
}
