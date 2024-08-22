package fe.mmm.qw.xxx.p032if.de;

import androidx.lifecycle.Observer;
import com.tera.scan.main.ui.fragment.LeftDrawerFragment;

/* renamed from: fe.mmm.qw.xxx.if.de.o  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class o implements Observer {
    public final /* synthetic */ LeftDrawerFragment qw;

    public /* synthetic */ o(LeftDrawerFragment leftDrawerFragment) {
        this.qw = leftDrawerFragment;
    }

    public final void onChanged(Object obj) {
        LeftDrawerFragment.m828onResume$lambda8(this.qw, (Boolean) obj);
    }
}
