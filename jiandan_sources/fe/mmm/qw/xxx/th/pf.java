package fe.mmm.qw.xxx.th;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.FileFragment;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class pf implements Observer {
    public final /* synthetic */ FileFragment qw;

    public /* synthetic */ pf(FileFragment fileFragment) {
        this.qw = fileFragment;
    }

    public final void onChanged(Object obj) {
        FileFragment.m765initSubScribe$lambda0(this.qw, (List) obj);
    }
}
