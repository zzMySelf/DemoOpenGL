package fe.mmm.qw.xxx.ggg;

import androidx.lifecycle.Observer;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import kotlin.jvm.functions.Function0;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Observer {
    public final /* synthetic */ Function0 qw;

    public /* synthetic */ qw(Function0 function0) {
        this.qw = function0;
    }

    public final void onChanged(Object obj) {
        MainActivityViewModel.i(this.qw, (Integer) obj);
    }
}
