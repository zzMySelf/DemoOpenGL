package fe.mmm.qw.k;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.vip.VipInfoManager;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ MediatorLiveData qw;

    public /* synthetic */ qw(MediatorLiveData mediatorLiveData) {
        this.qw = mediatorLiveData;
    }

    public final void onChanged(Object obj) {
        VipInfoManager.de(this.qw, (List) obj);
    }
}
