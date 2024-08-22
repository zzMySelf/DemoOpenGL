package fe.mmm.qw.xxx.th;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.FileFragment;

/* compiled from: lambda */
public final /* synthetic */ class uk implements Observer {
    public final /* synthetic */ FileFragment qw;

    public /* synthetic */ uk(FileFragment fileFragment) {
        this.qw = fileFragment;
    }

    public final void onChanged(Object obj) {
        FileFragment.m766initSubScribe$lambda1(this.qw, (Integer) obj);
    }
}
