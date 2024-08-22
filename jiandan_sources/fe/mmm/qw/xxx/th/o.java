package fe.mmm.qw.xxx.th;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.FileFragment;

/* compiled from: lambda */
public final /* synthetic */ class o implements Observer {
    public final /* synthetic */ FileFragment qw;

    public /* synthetic */ o(FileFragment fileFragment) {
        this.qw = fileFragment;
    }

    public final void onChanged(Object obj) {
        FileFragment.m767initSubScribe$lambda2(this.qw, (Integer) obj);
    }
}
