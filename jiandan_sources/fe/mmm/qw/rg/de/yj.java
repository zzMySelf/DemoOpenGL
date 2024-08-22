package fe.mmm.qw.rg.de;

import android.net.Uri;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.business.textrecognition.TextRecognitionActivity$setPreview$1$1;

/* compiled from: lambda */
public final /* synthetic */ class yj implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TextRecognitionActivity f8297ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Uri f8298th;

    public /* synthetic */ yj(TextRecognitionActivity textRecognitionActivity, Uri uri) {
        this.f8297ad = textRecognitionActivity;
        this.f8298th = uri;
    }

    public final void run() {
        TextRecognitionActivity$setPreview$1$1.m734invokeSuspend$lambda1(this.f8297ad, this.f8298th);
    }
}
