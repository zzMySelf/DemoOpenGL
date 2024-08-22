package fe.mmm.qw.xxx.yj;

import com.tera.scan.main.home.HomeFragment;
import com.tera.scan.widget.swiperefresh.CustomSwipeRefreshLayout;

/* compiled from: lambda */
public final /* synthetic */ class de implements CustomSwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ HomeFragment qw;

    public /* synthetic */ de(HomeFragment homeFragment) {
        this.qw = homeFragment;
    }

    public final void onRefresh() {
        HomeFragment.m800initView$lambda3(this.qw);
    }
}
