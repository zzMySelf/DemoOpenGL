package fe.rg.qw.o.de;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class ad<T> implements DataFetcher<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final String f4718ad;

    /* renamed from: th  reason: collision with root package name */
    public final AssetManager f4719th;

    /* renamed from: yj  reason: collision with root package name */
    public T f4720yj;

    public ad(AssetManager assetManager, String str) {
        this.f4719th = assetManager;
        this.f4718ad = str;
    }

    public void ad() {
        T t = this.f4720yj;
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
            T rg2 = rg(this.f4719th, this.f4718ad);
            this.f4720yj = rg2;
            dataCallback.rg(rg2);
        } catch (IOException e) {
            boolean isLoggable = Log.isLoggable("AssetPathFetcher", 3);
            dataCallback.de(e);
        }
    }
}
