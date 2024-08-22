package fe.mmm.qw.xxx.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.main.home.HomeFragment;
import java.util.Map;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ HomeFragment qw;

    public /* synthetic */ qw(HomeFragment homeFragment) {
        this.qw = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m795initFileListView$lambda18(this.qw, (Map) obj);
    }
}
