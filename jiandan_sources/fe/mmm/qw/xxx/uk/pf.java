package fe.mmm.qw.xxx.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.ImportDocFilesActivity;

/* compiled from: lambda */
public final /* synthetic */ class pf implements Observer {
    public final /* synthetic */ ImportDocFilesActivity qw;

    public /* synthetic */ pf(ImportDocFilesActivity importDocFilesActivity) {
        this.qw = importDocFilesActivity;
    }

    public final void onChanged(Object obj) {
        ImportDocFilesActivity.m810initData$lambda6(this.qw, (Boolean) obj);
    }
}
