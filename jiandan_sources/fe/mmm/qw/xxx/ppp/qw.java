package fe.mmm.qw.xxx.ppp;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tera.scan.main.view.UserCenterCardScene;
import com.tera.scan.vip.network.model.UserCardInfoResponse;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ View f8634ad;
    public final /* synthetic */ UserCenterCardScene qw;

    public /* synthetic */ qw(UserCenterCardScene userCenterCardScene, View view) {
        this.qw = userCenterCardScene;
        this.f8634ad = view;
    }

    public final void onChanged(Object obj) {
        UserCenterCardScene.o(this.qw, this.f8634ad, (UserCardInfoResponse) obj);
    }
}
