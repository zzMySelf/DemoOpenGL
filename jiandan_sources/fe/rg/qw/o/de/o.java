package fe.rg.qw.o.de;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class o<T> implements DataFetcher<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Uri f4727ad;

    /* renamed from: th  reason: collision with root package name */
    public final ContentResolver f4728th;

    /* renamed from: yj  reason: collision with root package name */
    public T f4729yj;

    public o(ContentResolver contentResolver, Uri uri) {
        this.f4728th = contentResolver;
        this.f4727ad = uri;
    }

    public void ad() {
        T t = this.f4729yj;
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

    public abstract T rg(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public final void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T rg2 = rg(this.f4727ad, this.f4728th);
            this.f4729yj = rg2;
            dataCallback.rg(rg2);
        } catch (FileNotFoundException e) {
            boolean isLoggable = Log.isLoggable("LocalUriFetcher", 3);
            dataCallback.de(e);
        }
    }
}
