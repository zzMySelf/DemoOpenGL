package fe.mmm.qw.rg.qw.ad.qw;

import android.view.View;
import com.tera.scan.business.core.ui.dialog.RenameCommonDialog;

/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnClickListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ RenameCommonDialog f8302ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f8303th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ String f8304yj;

    public /* synthetic */ qw(RenameCommonDialog renameCommonDialog, String str, String str2) {
        this.f8302ad = renameCommonDialog;
        this.f8303th = str;
        this.f8304yj = str2;
    }

    public final void onClick(View view) {
        RenameCommonDialog.m728initView$lambda3(this.f8302ad, this.f8303th, this.f8304yj, view);
    }
}
