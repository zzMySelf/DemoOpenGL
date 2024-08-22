package fe.mmm.qw.th.qw;

import androidx.lifecycle.Observer;
import com.tera.scan.framework.framework.FrameworkAccount;
import kotlin.jvm.internal.Ref;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ Ref.ObjectRef qw;

    public /* synthetic */ qw(Ref.ObjectRef objectRef) {
        this.qw = objectRef;
    }

    public final void onChanged(Object obj) {
        ad.ad(this.qw, (FrameworkAccount) obj);
    }
}
