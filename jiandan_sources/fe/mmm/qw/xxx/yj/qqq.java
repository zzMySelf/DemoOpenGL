package fe.mmm.qw.xxx.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.main.home.MainFileListAdapter;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class qqq implements Observer {
    public final /* synthetic */ MainFileListAdapter qw;

    public /* synthetic */ qqq(MainFileListAdapter mainFileListAdapter) {
        this.qw = mainFileListAdapter;
    }

    public final void onChanged(Object obj) {
        MainFileListAdapter.qw(this.qw, (List) obj);
    }
}
