package fe.uk.qw.pf.de;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class ad<T> implements DataFetcher<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final String f5685ad;

    /* renamed from: th  reason: collision with root package name */
    public final AssetManager f5686th;

    /* renamed from: yj  reason: collision with root package name */
    public T f5687yj;

    public ad(AssetManager assetManager, String str) {
        this.f5686th = assetManager;
        this.f5685ad = str;
    }

    public void ad() {
        T t = this.f5687yj;
        if (t != null) {
            try {
                de(t);
            } catch (IOException unused) {
            }
        }
    }

    public void cancel() {
    }

    public abstract void de(T t) throws IOException;

    @NonNull
    public DataSource fe() {
        return DataSource.LOCAL;
    }

    public abstract T rg(AssetManager assetManager, String str) throws IOException;

    public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T rg2 = rg(this.f5686th, this.f5685ad);
            this.f5687yj = rg2;
            dataCallback.rg(rg2);
        } catch (IOException e) {
            boolean isLoggable = Log.isLoggable("AssetPathFetcher", 3);
            dataCallback.de(e);
        }
    }
}
