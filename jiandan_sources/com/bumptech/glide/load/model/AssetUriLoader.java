package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.o.de.pf;
import fe.rg.qw.o.de.th;
import fe.rg.qw.o.rg.i;
import fe.rg.qw.ppp.de;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: de  reason: collision with root package name */
    public static final int f3698de = 22;

    /* renamed from: ad  reason: collision with root package name */
    public final AssetFetcherFactory<Data> f3699ad;
    public final AssetManager qw;

    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> qw(AssetManager assetManager, String str);
    }

    public static class ad implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {
        public final AssetManager qw;

        public ad(AssetManager assetManager) {
            this.qw = assetManager;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> ad(i iVar) {
            return new AssetUriLoader(this.qw, this);
        }

        public DataFetcher<InputStream> qw(AssetManager assetManager, String str) {
            return new pf(assetManager, str);
        }
    }

    public static class qw implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {
        public final AssetManager qw;

        public qw(AssetManager assetManager) {
            this.qw = assetManager;
        }

        @NonNull
        public ModelLoader<Uri, ParcelFileDescriptor> ad(i iVar) {
            return new AssetUriLoader(this.qw, this);
        }

        public DataFetcher<ParcelFileDescriptor> qw(AssetManager assetManager, String str) {
            return new th(assetManager, str);
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.qw = assetManager;
        this.f3699ad = assetFetcherFactory;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull Uri uri, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new de(uri), this.f3699ad.qw(this.qw, uri.toString().substring(f3698de)));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
