package fe.mmm.qw.xxx.th;

import androidx.lifecycle.Observer;
import com.tera.scan.main.file.FileFragment;

/* compiled from: lambda */
public final /* synthetic */ class de implements Observer {
    public final /* synthetic */ FileFragment qw;

    public /* synthetic */ de(FileFragment fileFragment) {
        this.qw = fileFragment;
    }

    public final void onChanged(Object obj) {
        FileFragment.m768initSubScribe$lambda3(this.qw, (Boolean) obj);
    }
}
