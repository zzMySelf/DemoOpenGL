package fe.mmm.qw.rg.de;

import android.view.View;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivity;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ View f8288ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ TextRecognitionResultActivity f8289th;

    public /* synthetic */ qw(View view, TextRecognitionResultActivity textRecognitionResultActivity) {
        this.f8288ad = view;
        this.f8289th = textRecognitionResultActivity;
    }

    public final void run() {
        TextRecognitionResultActivity.m744showTranslateVipStatusView$lambda12(this.f8288ad, this.f8289th);
    }
}
