package fe.mmm.qw.xxx.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.ImportDocFilesActivity;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class yj implements Observer {
    public final /* synthetic */ ImportDocFilesActivity qw;

    public /* synthetic */ yj(ImportDocFilesActivity importDocFilesActivity) {
        this.qw = importDocFilesActivity;
    }

    public final void onChanged(Object obj) {
        ImportDocFilesActivity.m817initView$lambda4(this.qw, (List) obj);
    }
}
