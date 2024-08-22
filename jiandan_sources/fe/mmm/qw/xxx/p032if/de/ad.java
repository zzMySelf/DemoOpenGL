package fe.mmm.qw.xxx.p032if.de;

import androidx.lifecycle.Observer;
import com.tera.scan.main.ui.fragment.ScanAllToolFragment;
import java.util.List;

/* renamed from: fe.mmm.qw.xxx.if.de.ad  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ ScanAllToolFragment qw;

    public /* synthetic */ ad(ScanAllToolFragment scanAllToolFragment) {
        this.qw = scanAllToolFragment;
    }

    public final void onChanged(Object obj) {
        ScanAllToolFragment.m829initObserve$lambda3(this.qw, (List) obj);
    }
}
