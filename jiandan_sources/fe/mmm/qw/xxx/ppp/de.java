package fe.mmm.qw.xxx.ppp;

import androidx.lifecycle.Observer;
import com.tera.scan.main.view.MainTabView;

/* compiled from: lambda */
public final /* synthetic */ class de implements Observer {
    public final /* synthetic */ MainTabView qw;

    public /* synthetic */ de(MainTabView mainTabView) {
        this.qw = mainTabView;
    }

    public final void onChanged(Object obj) {
        MainTabView.m835initTabData$lambda2(this.qw, (String) obj);
    }
}
