package fe.mmm.qw.xxx.when;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import org.jetbrains.annotations.NotNull;

public final class rg {
    @NotNull
    public static final LiveData<Boolean> qw = new MutableLiveData(Boolean.TRUE);

    @NotNull
    public static final LiveData<Boolean> qw() {
        return qw;
    }
}
