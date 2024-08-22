package fe.mmm.qw.xxx.th;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.FilePageInnerFragment;

/* compiled from: lambda */
public final /* synthetic */ class th implements Observer {
    public final /* synthetic */ FilePageInnerFragment qw;

    public /* synthetic */ th(FilePageInnerFragment filePageInnerFragment) {
        this.qw = filePageInnerFragment;
    }

    public final void onChanged(Object obj) {
        FilePageInnerFragment.m774initSubscribe$lambda3(this.qw, (Integer) obj);
    }
}
