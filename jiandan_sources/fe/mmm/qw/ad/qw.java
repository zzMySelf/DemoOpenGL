package fe.mmm.qw.ad;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tera.scan.app.FrameworkInitializerKt$initFramework$5;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ MutableLiveData qw;

    public /* synthetic */ qw(MutableLiveData mutableLiveData) {
        this.qw = mutableLiveData;
    }

    public final void onChanged(Object obj) {
        FrameworkInitializerKt$initFramework$5.m724invoke$lambda0(this.qw, (fe.mmm.qw.qw.rg.qw) obj);
    }
}
