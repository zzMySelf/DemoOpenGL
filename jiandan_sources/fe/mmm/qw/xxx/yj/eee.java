package fe.mmm.qw.xxx.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.main.home.HomeFragment;

/* compiled from: lambda */
public final /* synthetic */ class eee implements Observer {
    public final /* synthetic */ HomeFragment qw;

    public /* synthetic */ eee(HomeFragment homeFragment) {
        this.qw = homeFragment;
    }

    public final void onChanged(Object obj) {
        HomeFragment.m797initSubscribes$lambda9(this.qw, (Boolean) obj);
    }
}
