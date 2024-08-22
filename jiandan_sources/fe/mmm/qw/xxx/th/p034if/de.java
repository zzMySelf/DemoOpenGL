package fe.mmm.qw.xxx.th.p034if;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.dialog.FileSortDialog;

/* renamed from: fe.mmm.qw.xxx.th.if.de  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class de implements Observer {
    public final /* synthetic */ FileSortDialog qw;

    public /* synthetic */ de(FileSortDialog fileSortDialog) {
        this.qw = fileSortDialog;
    }

    public final void onChanged(Object obj) {
        FileSortDialog.m777initSubscribe$lambda1(this.qw, (Integer) obj);
    }
}
