package fe.uk.qw.pf.rg.ppp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import fe.uk.qw.pf.rg.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RequiresApi(29)
public final class fe<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: ad  reason: collision with root package name */
    public final ModelLoader<File, DataT> f5916ad;

    /* renamed from: de  reason: collision with root package name */
    public final ModelLoader<Uri, DataT> f5917de;

    /* renamed from: fe  reason: collision with root package name */
    public final Class<DataT> f5918fe;
    public final Context qw;

    @RequiresApi(29)
    public static final class ad extends qw<ParcelFileDescriptor> {
        public ad(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    public static final class de extends qw<InputStream> {
        public de(Context context) {
            super(context, InputStream.class);
        }
    }

    /* renamed from: fe.uk.qw.pf.rg.ppp.fe$fe  reason: collision with other inner class name */
    public static final class C0239fe<DataT> implements DataFetcher<DataT> {
        public static final String[] ppp = {"_data"};

        /* renamed from: ad  reason: collision with root package name */
        public final Context f5919ad;

        /* renamed from: i  reason: collision with root package name */
        public final int f5920i;

        /* renamed from: if  reason: not valid java name */
        public final Class<DataT> f242if;

        /* renamed from: o  reason: collision with root package name */
        public final int f5921o;

        /* renamed from: pf  reason: collision with root package name */
        public final fe.uk.qw.pf.ad f5922pf;

        /* renamed from: switch  reason: not valid java name */
        public volatile boolean f243switch;

        /* renamed from: th  reason: collision with root package name */
        public final ModelLoader<File, DataT> f5923th;

        /* renamed from: uk  reason: collision with root package name */
        public final Uri f5924uk;
        @Nullable
        public volatile DataFetcher<DataT> when;

        /* renamed from: yj  reason: collision with root package name */
        public final ModelLoader<Uri, DataT> f5925yj;

        public C0239fe(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i2, int i3, fe.uk.qw.pf.ad adVar, Class<DataT> cls) {
            this.f5919ad = context.getApplicationContext();
            this.f5923th = modelLoader;
            this.f5925yj = modelLoader2;
            this.f5924uk = uri;
            this.f5920i = i2;
            this.f5921o = i3;
            this.f5922pf = adVar;
            this.f242if = cls;
        }

        public void ad() {
            DataFetcher<DataT> dataFetcher = this.when;
            if (dataFetcher != null) {
                dataFetcher.ad();
            }
        }

        public void cancel() {
            this.f243switch = true;
            DataFetcher<DataT> dataFetcher = this.when;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Nullable
        public final ModelLoader.qw<DataT> de() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f5923th.ad(uk(this.f5924uk), this.f5920i, this.f5921o, this.f5922pf);
            }
            return this.f5925yj.ad(yj() ? MediaStore.setRequireOriginal(this.f5924uk) : this.f5924uk, this.f5920i, this.f5921o, this.f5922pf);
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<DataT> qw() {
            return this.f242if;
        }

        @Nullable
        public final DataFetcher<DataT> rg() throws FileNotFoundException {
            ModelLoader.qw de2 = de();
            if (de2 != null) {
                return de2.f3879de;
            }
            return null;
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> rg2 = rg();
                if (rg2 == null) {
                    dataCallback.de(new IllegalArgumentException("Failed to build fetcher for: " + this.f5924uk));
                    return;
                }
                this.when = rg2;
                if (this.f243switch) {
                    cancel();
                } else {
                    rg2.th(priority, dataCallback);
                }
            } catch (FileNotFoundException e) {
                dataCallback.de(e);
            }
        }

        @NonNull
        public final File uk(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.f5919ad.getContentResolver().query(uri, ppp, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        public final boolean yj() {
            return this.f5919ad.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }
    }

    public static abstract class qw<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<DataT> f5926ad;
        public final Context qw;

        public qw(Context context, Class<DataT> cls) {
            this.qw = context;
            this.f5926ad = cls;
        }

        @NonNull
        public final ModelLoader<Uri, DataT> ad(@NonNull i iVar) {
            return new fe(this.qw, iVar.fe(File.class, this.f5926ad), iVar.fe(Uri.class, this.f5926ad), this.f5926ad);
        }
    }

    public fe(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.qw = context.getApplicationContext();
        this.f5916ad = modelLoader;
        this.f5917de = modelLoader2;
        this.f5918fe = cls;
    }

    /* renamed from: de */
    public ModelLoader.qw<DataT> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(uri), new C0239fe(this.qw, this.f5916ad, this.f5917de, uri, i2, i3, adVar, this.f5918fe));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && fe.uk.qw.pf.de.when.ad.ad(uri);
    }
}
