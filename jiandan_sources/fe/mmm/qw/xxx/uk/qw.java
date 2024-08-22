package fe.mmm.qw.xxx.uk;

import androidx.lifecycle.Observer;
import com.tera.scan.main.importfile.ImportDocListFragment;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ ImportDocListFragment qw;

    public /* synthetic */ qw(ImportDocListFragment importDocListFragment) {
        this.qw = importDocListFragment;
    }

    public final void onChanged(Object obj) {
        ImportDocListFragment.m819initData$lambda1(this.qw, (List) obj);
    }
}
