package fe.mmm.qw.k.fe;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ Function1 qw;

    public /* synthetic */ qw(Function1 function1) {
        this.qw = function1;
    }

    public final void onChanged(Object obj) {
        ad.de(this.qw, (Boolean) obj);
    }
}
