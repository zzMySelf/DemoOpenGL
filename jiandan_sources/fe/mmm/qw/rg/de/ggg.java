package fe.mmm.qw.rg.de;

import androidx.lifecycle.Observer;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivity;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivityFlavor;
import com.tera.scan.vip.ui.view.PrivilegeBannerView;

/* compiled from: lambda */
public final /* synthetic */ class ggg implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PrivilegeBannerView f8278ad;
    public final /* synthetic */ TextRecognitionResultActivity qw;

    public /* synthetic */ ggg(TextRecognitionResultActivity textRecognitionResultActivity, PrivilegeBannerView privilegeBannerView) {
        this.qw = textRecognitionResultActivity;
        this.f8278ad = privilegeBannerView;
    }

    public final void onChanged(Object obj) {
        TextRecognitionResultActivityFlavor.m745if(this.qw, this.f8278ad, (Integer) obj);
    }
}
