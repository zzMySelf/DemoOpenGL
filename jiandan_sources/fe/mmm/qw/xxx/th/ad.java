package fe.mmm.qw.xxx.th;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.FilePageInnerFragment;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ FilePageInnerFragment qw;

    public /* synthetic */ ad(FilePageInnerFragment filePageInnerFragment) {
        this.qw = filePageInnerFragment;
    }

    public final void onChanged(Object obj) {
        FilePageInnerFragment.m773initSubscribe$lambda1(this.qw, (Integer) obj);
    }
}
