package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.o.de.Cif;
import fe.rg.qw.o.de.yj;
import fe.rg.qw.o.rg.i;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: ad  reason: collision with root package name */
    public static final Set<String> f3710ad = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));
    public final LocalUriFetcherFactory<Data> qw;

    public interface LocalUriFetcherFactory<Data> {
        DataFetcher<Data> qw(Uri uri);
    }

    public static class ad implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {
        public final ContentResolver qw;

        public ad(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        @NonNull
        public ModelLoader<Uri, ParcelFileDescriptor> ad(i iVar) {
            return new UriLoader(this);
        }

        public DataFetcher<ParcelFileDescriptor> qw(Uri uri) {
            return new yj(this.qw, uri);
        }
    }

    public static class de implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {
        public final ContentResolver qw;

        public de(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new UriLoader(this);
        }

        public DataFetcher<InputStream> qw(Uri uri) {
            return new Cif(this.qw, uri);
        }
    }

    public static final class qw implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {
        public final ContentResolver qw;

        public qw(ContentResolver contentResolver) {
            this.qw = contentResolver;
        }

        public ModelLoader<Uri, AssetFileDescriptor> ad(i iVar) {
            return new UriLoader(this);
        }

        public DataFetcher<AssetFileDescriptor> qw(Uri uri) {
            return new fe.rg.qw.o.de.qw(this.qw, uri);
        }
    }

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.qw = localUriFetcherFactory;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new fe.rg.qw.ppp.de(uri), this.qw.qw(uri));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        return f3710ad.contains(uri.getScheme());
    }
}
