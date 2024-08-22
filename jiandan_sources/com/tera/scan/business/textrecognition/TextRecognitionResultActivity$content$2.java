package com.tera.scan.business.textrecognition;

import com.baidu.aiscan.R;
import com.tera.scan.widget.NoCopyEditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tera/scan/widget/NoCopyEditText;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity$content$2 extends Lambda implements Function0<NoCopyEditText> {
    public final /* synthetic */ TextRecognitionResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivity$content$2(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.this$0 = textRecognitionResultActivity;
    }

    public final NoCopyEditText invoke() {
        return (NoCopyEditText) this.this$0.findViewById(R.id.layout_image2text_result_dialogContent);
    }
}
