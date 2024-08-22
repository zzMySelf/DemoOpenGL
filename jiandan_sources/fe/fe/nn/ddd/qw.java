package fe.fe.nn.ddd;

import android.database.ContentObserver;
import android.os.Handler;

public class qw extends ContentObserver {
    public de qw;

    public qw(de deVar) {
        super((Handler) null);
        this.qw = deVar;
    }

    public void onChange(boolean z) {
        de deVar = this.qw;
        if (deVar != null) {
            deVar.f2234ad = deVar.qw.qw(0, (String) null);
        }
    }
}
