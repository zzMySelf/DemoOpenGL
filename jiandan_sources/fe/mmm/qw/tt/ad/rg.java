package fe.mmm.qw.tt.ad;

import android.view.View;
import com.tera.scan.scanner.ocr.OCRBottomAdapter;

/* compiled from: lambda */
public final /* synthetic */ class rg implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ OCRBottomAdapter f8416ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f8417th;

    public /* synthetic */ rg(OCRBottomAdapter oCRBottomAdapter, int i2) {
        this.f8416ad = oCRBottomAdapter;
        this.f8417th = i2;
    }

    public final void onClick(View view) {
        OCRBottomAdapter.qw(this.f8416ad, this.f8417th, view);
    }
}
