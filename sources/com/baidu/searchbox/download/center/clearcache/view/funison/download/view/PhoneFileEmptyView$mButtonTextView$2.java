package com.baidu.searchbox.download.center.clearcache.view.funison.download.view;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.clearcache.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneFileEmptyView.kt */
final class PhoneFileEmptyView$mButtonTextView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ PhoneFileEmptyView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneFileEmptyView$mButtonTextView$2(PhoneFileEmptyView phoneFileEmptyView) {
        super(0);
        this.this$0 = phoneFileEmptyView;
    }

    public final TextView invoke() {
        TextView textView = new TextView(this.this$0.getContext());
        TextView $this$invoke_u24lambda_u2d0 = textView;
        $this$invoke_u24lambda_u2d0.setId(ViewCompat.generateViewId());
        $this$invoke_u24lambda_u2d0.setIncludeFontPadding(false);
        $this$invoke_u24lambda_u2d0.setMaxLines(1);
        $this$invoke_u24lambda_u2d0.setBackground(ContextCompat.getDrawable($this$invoke_u24lambda_u2d0.getContext(), R.drawable.clear_cache_empty_view_button_background));
        $this$invoke_u24lambda_u2d0.setPadding(DeviceUtils.ScreenInfo.dp2px($this$invoke_u24lambda_u2d0.getContext(), 19.0f), DeviceUtils.ScreenInfo.dp2px($this$invoke_u24lambda_u2d0.getContext(), 10.0f), DeviceUtils.ScreenInfo.dp2px($this$invoke_u24lambda_u2d0.getContext(), 19.0f), DeviceUtils.ScreenInfo.dp2px($this$invoke_u24lambda_u2d0.getContext(), 10.0f));
        $this$invoke_u24lambda_u2d0.setTextSize(1, 14.0f);
        return textView;
    }
}
