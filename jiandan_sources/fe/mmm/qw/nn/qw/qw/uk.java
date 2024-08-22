package fe.mmm.qw.nn.qw.qw;

import androidx.annotation.Nullable;
import com.tera.scan.network.base.network.NetworkTaskFactory;
import com.tera.scan.network.network.exception.RemoteException;
import fe.mmm.qw.nn.de.yj;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import org.json.JSONException;

public class uk<T> {
    public yj qw;

    public uk(int i2, NetworkTaskFactory networkTaskFactory) {
        this.qw = (networkTaskFactory == null ? new ad() : networkTaskFactory).qw(i2);
    }

    @Nullable
    public T qw(Object... objArr) throws UnsupportedOperationException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        return this.qw.when(objArr);
    }

    public uk(int i2) {
        this(i2, new ad());
    }

    public uk() {
        this(20000);
    }
}
