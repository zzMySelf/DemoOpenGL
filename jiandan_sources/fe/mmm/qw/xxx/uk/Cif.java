package fe.mmm.qw.xxx.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.ImportDocFilesActivity;

/* renamed from: fe.mmm.qw.xxx.uk.if  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class Cif implements Observer {
    public final /* synthetic */ ImportDocFilesActivity qw;

    public /* synthetic */ Cif(ImportDocFilesActivity importDocFilesActivity) {
        this.qw = importDocFilesActivity;
    }

    public final void onChanged(Object obj) {
        ImportDocFilesActivity.m811initData$lambda7(this.qw, (Boolean) obj);
    }
}
