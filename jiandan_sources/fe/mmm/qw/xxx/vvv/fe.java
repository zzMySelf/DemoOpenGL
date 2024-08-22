package fe.mmm.qw.xxx.vvv;

import androidx.lifecycle.Observer;
import com.tera.scan.main.welcome.WelcomeActivity;

/* compiled from: lambda */
public final /* synthetic */ class fe implements Observer {
    public final /* synthetic */ WelcomeActivity qw;

    public /* synthetic */ fe(WelcomeActivity welcomeActivity) {
        this.qw = welcomeActivity;
    }

    public final void onChanged(Object obj) {
        WelcomeActivity.m838enterNextPage$lambda2(this.qw, (Boolean) obj);
    }
}
