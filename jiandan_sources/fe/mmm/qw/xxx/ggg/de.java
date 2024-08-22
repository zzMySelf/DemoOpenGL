package fe.mmm.qw.xxx.ggg;

import androidx.lifecycle.Observer;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import kotlin.jvm.functions.Function0;

/* compiled from: lambda */
public final /* synthetic */ class de implements Observer {
    public final /* synthetic */ Function0 qw;

    public /* synthetic */ de(Function0 function0) {
        this.qw = function0;
    }

    public final void onChanged(Object obj) {
        MainActivityViewModel.o(this.qw, (fe.mmm.qw.k.de) obj);
    }
}
