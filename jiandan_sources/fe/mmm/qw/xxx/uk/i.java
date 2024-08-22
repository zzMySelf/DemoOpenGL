package fe.mmm.qw.xxx.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.ImportDocFilesActivity;

/* compiled from: lambda */
public final /* synthetic */ class i implements Observer {
    public final /* synthetic */ ImportDocFilesActivity qw;

    public /* synthetic */ i(ImportDocFilesActivity importDocFilesActivity) {
        this.qw = importDocFilesActivity;
    }

    public final void onChanged(Object obj) {
        ImportDocFilesActivity.m809initData$lambda5(this.qw, (Integer) obj);
    }
}
