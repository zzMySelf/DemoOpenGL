package fe.mmm.qw.o.qw.qw.qw.ad;

import android.app.Dialog;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ DocumentViewerActivity f8178ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Dialog f8179th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ List f8180yj;

    public /* synthetic */ rg(DocumentViewerActivity documentViewerActivity, Dialog dialog, List list) {
        this.f8178ad = documentViewerActivity;
        this.f8179th = dialog;
        this.f8180yj = list;
    }

    public final void run() {
        this.f8178ad.de(this.f8179th, this.f8180yj);
    }
}
