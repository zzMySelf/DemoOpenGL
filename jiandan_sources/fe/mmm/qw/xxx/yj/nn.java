package fe.mmm.qw.xxx.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.main.home.FileSelectModeFragment;

/* compiled from: lambda */
public final /* synthetic */ class nn implements Observer {
    public final /* synthetic */ FileSelectModeFragment qw;

    public /* synthetic */ nn(FileSelectModeFragment fileSelectModeFragment) {
        this.qw = fileSelectModeFragment;
    }

    public final void onChanged(Object obj) {
        FileSelectModeFragment.m787initSubscribe$lambda14(this.qw, (Integer) obj);
    }
}
