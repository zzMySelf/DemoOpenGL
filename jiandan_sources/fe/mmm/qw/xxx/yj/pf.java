package fe.mmm.qw.xxx.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.main.home.HomeFragment;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class pf implements Observer {
    public final /* synthetic */ HomeFragment qw;

    public /* synthetic */ pf(HomeFragment homeFragment) {
        this.qw = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m796initSubscribes$lambda8(this.qw, (List) obj);
    }
}
