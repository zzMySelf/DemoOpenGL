package fe.mmm.qw.rg.de;

import android.view.View;
import com.tera.scan.business.textrecognition.PreViewActivity;
import java.io.File;

/* compiled from: lambda */
public final /* synthetic */ class fe implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ File f8276ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ PreViewActivity f8277th;

    public /* synthetic */ fe(File file, PreViewActivity preViewActivity) {
        this.f8276ad = file;
        this.f8277th = preViewActivity;
    }

    public final void onClick(View view) {
        PreViewActivity.m731initView$lambda2(this.f8276ad, this.f8277th, view);
    }
}
