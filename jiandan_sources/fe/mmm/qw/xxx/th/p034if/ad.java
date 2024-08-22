package fe.mmm.qw.xxx.th.p034if;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.dialog.FileSortDialog;

/* renamed from: fe.mmm.qw.xxx.th.if.ad  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ FileSortDialog qw;

    public /* synthetic */ ad(FileSortDialog fileSortDialog) {
        this.qw = fileSortDialog;
    }

    public final void onChanged(Object obj) {
        FileSortDialog.m776initSubscribe$lambda0(this.qw, (Integer) obj);
    }
}
