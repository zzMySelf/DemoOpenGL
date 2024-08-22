package fe.mmm.qw.xxx.ggg;

import androidx.lifecycle.Observer;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Observer {
    public final /* synthetic */ Function0 qw;

    public /* synthetic */ ad(Function0 function0) {
        this.qw = function0;
    }

    public final void onChanged(Object obj) {
        MainActivityViewModel.qw(this.qw, (List) obj);
    }
}
