package com.tera.scan.business.textrecognition;

import android.widget.ImageView;
import com.baidu.aiscan.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionActivity$previewImage$2 extends Lambda implements Function0<ImageView> {
    public final /* synthetic */ TextRecognitionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionActivity$previewImage$2(TextRecognitionActivity textRecognitionActivity) {
        super(0);
        this.this$0 = textRecognitionActivity;
    }

    public final ImageView invoke() {
        return (ImageView) this.this$0.findViewById(R.id.layout_image2text_loading_preview);
    }
}
