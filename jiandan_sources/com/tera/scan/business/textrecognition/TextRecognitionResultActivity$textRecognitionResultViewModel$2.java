package com.tera.scan.business.textrecognition;

import androidx.lifecycle.ViewModelProvider;
import com.tera.scan.business.textrecognition.viewmodel.TextRecognitionResultViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/business/textrecognition/viewmodel/TextRecognitionResultViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity$textRecognitionResultViewModel$2 extends Lambda implements Function0<TextRecognitionResultViewModel> {
    public final /* synthetic */ TextRecognitionResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivity$textRecognitionResultViewModel$2(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.this$0 = textRecognitionResultActivity;
    }

    @NotNull
    public final TextRecognitionResultViewModel invoke() {
        return (TextRecognitionResultViewModel) new ViewModelProvider(this.this$0).get(TextRecognitionResultViewModel.class);
    }
}
