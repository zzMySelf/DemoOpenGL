package fe.ggg.ad.qw.de.th;

import androidx.lifecycle.Observer;
import com.mars.united.core.os.livedata.SingleObserver;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ SingleObserver qw;

    public /* synthetic */ qw(SingleObserver singleObserver) {
        this.qw = singleObserver;
    }

    public final void onChanged(Object obj) {
        SingleObserver.qw(this.qw, obj);
    }
}
