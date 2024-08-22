package fe.mmm.qw.xxx.yj;

import androidx.lifecycle.Observer;
import com.tera.scan.main.home.FileSelectModeFragment;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class mmm implements Observer {
    public final /* synthetic */ FileSelectModeFragment qw;

    public /* synthetic */ mmm(FileSelectModeFragment fileSelectModeFragment) {
        this.qw = fileSelectModeFragment;
    }

    public final void onChanged(Object obj) {
        FileSelectModeFragment.m788initSubscribe$lambda15(this.qw, (List) obj);
    }
}
