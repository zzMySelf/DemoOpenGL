package fe.mmm.qw.rg.de;

import android.graphics.Bitmap;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.business.textrecognition.TextRecognitionActivity$setPreview$1$1;

/* compiled from: lambda */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TextRecognitionActivity f8279ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Bitmap f8280th;

    public /* synthetic */ i(TextRecognitionActivity textRecognitionActivity, Bitmap bitmap) {
        this.f8279ad = textRecognitionActivity;
        this.f8280th = bitmap;
    }

    public final void run() {
        TextRecognitionActivity$setPreview$1$1.m735invokeSuspend$lambda3$lambda2(this.f8279ad, this.f8280th);
    }
}
