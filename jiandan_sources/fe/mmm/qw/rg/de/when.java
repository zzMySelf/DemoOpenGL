package fe.mmm.qw.rg.de;

import android.view.View;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivity;

/* compiled from: lambda */
public final /* synthetic */ class when implements View.OnLongClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TextRecognitionResultActivity f8296ad;

    public /* synthetic */ when(TextRecognitionResultActivity textRecognitionResultActivity) {
        this.f8296ad = textRecognitionResultActivity;
    }

    public final boolean onLongClick(View view) {
        return TextRecognitionResultActivity.m742onEditClick$lambda18(this.f8296ad, view);
    }
}
