package com.baidu.searchbox.aisearch.camera.gallery.cursorloader.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0007J\u0006\u0010\u0012\u001a\u00020\u000eJ \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0007J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u000eJ \u0010\u001e\u001a\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010!\u001a\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/model/AlbumPhotoCollection;", "Landroidx/loader/app/LoaderManager$LoaderCallbacks;", "Landroid/database/Cursor;", "()V", "loadFinished", "", "mCallbacks", "Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/model/AlbumPhotoCollection$AlbumPhotoCallbacks;", "mContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mLoaderManager", "Landroidx/loader/app/LoaderManager;", "load", "", "target", "Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/entity/Album;", "enableCapture", "loadAll", "onCreate", "context", "loaderManager", "callbacks", "onCreateLoader", "Landroidx/loader/content/Loader;", "id", "", "args", "Landroid/os/Bundle;", "onDestroy", "onLoadFinished", "loader", "data", "onLoaderReset", "AlbumPhotoCallbacks", "Companion", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumPhotoCollection.kt */
public final class AlbumPhotoCollection implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String ARGS_ALBUM = "args_album";
    private static final String ARGS_ENABLE_CAPTURE = "args_enable_capture";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int LOADER_ID = 2;
    private boolean loadFinished;
    private AlbumPhotoCallbacks mCallbacks;
    private WeakReference<Context> mContext;
    private LoaderManager mLoaderManager;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/model/AlbumPhotoCollection$AlbumPhotoCallbacks;", "", "onAlbumPhotoLoad", "", "cursor", "Landroid/database/Cursor;", "onAlbumPhotoReset", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumPhotoCollection.kt */
    public interface AlbumPhotoCallbacks {
        void onAlbumPhotoLoad(Cursor cursor);

        void onAlbumPhotoReset();
    }

    public final void load(Album album) {
        load$default(this, album, false, 2, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.loader.content.Loader<android.database.Cursor> onCreateLoader(int r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r9.mContext
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 != 0) goto L_0x0010
        L_0x000c:
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
        L_0x0010:
            r1 = 0
            if (r11 != 0) goto L_0x0022
            com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album r8 = new com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album
            android.net.Uri r4 = android.net.Uri.EMPTY
            r6 = 0
            java.lang.String r3 = "-1"
            java.lang.String r5 = ""
            r2 = r8
            r2.<init>(r3, r4, r5, r6)
            goto L_0x003b
        L_0x0022:
            java.lang.String r2 = "args_album"
            android.os.Parcelable r2 = r11.getParcelable(r2)
            r8 = r2
            com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album r8 = (com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album) r8
            if (r8 != 0) goto L_0x003b
            com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album r8 = new com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album
            android.net.Uri r4 = android.net.Uri.EMPTY
            r6 = 0
            java.lang.String r3 = "-1"
            java.lang.String r5 = ""
            r2 = r8
            r2.<init>(r3, r4, r5, r6)
        L_0x003b:
            r1 = r8
            com.baidu.searchbox.aisearch.camera.gallery.cursorloader.loader.AlbumImageLoader$Companion r2 = com.baidu.searchbox.aisearch.camera.gallery.cursorloader.loader.AlbumImageLoader.Companion
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r3 = 0
            androidx.loader.content.CursorLoader r2 = r2.newInstance(r0, r1, r3)
            androidx.loader.content.Loader r2 = (androidx.loader.content.Loader) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aisearch.camera.gallery.cursorloader.model.AlbumPhotoCollection.onCreateLoader(int, android.os.Bundle):androidx.loader.content.Loader");
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null && ((Context) weakReference.get()) != null && data != null && !this.loadFinished) {
            AlbumPhotoCallbacks albumPhotoCallbacks = this.mCallbacks;
            if (albumPhotoCallbacks != null) {
                albumPhotoCallbacks.onAlbumPhotoLoad(data);
            }
            this.loadFinished = true;
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        AlbumPhotoCallbacks albumPhotoCallbacks;
        Intrinsics.checkNotNullParameter(loader, "loader");
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null && ((Context) weakReference.get()) != null && (albumPhotoCallbacks = this.mCallbacks) != null) {
            albumPhotoCallbacks.onAlbumPhotoReset();
        }
    }

    public final void onCreate(Context context, LoaderManager loaderManager, AlbumPhotoCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.mContext = new WeakReference<>(context);
        this.mLoaderManager = loaderManager;
        this.mCallbacks = callbacks;
    }

    public final void onDestroy() {
        LoaderManager loaderManager = this.mLoaderManager;
        if (!(loaderManager == null || loaderManager == null)) {
            loaderManager.destroyLoader(2);
        }
        this.mCallbacks = null;
    }

    public static /* synthetic */ void load$default(AlbumPhotoCollection albumPhotoCollection, Album album, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        albumPhotoCollection.load(album, z);
    }

    public final void load(Album target, boolean enableCapture) {
        Bundle args = new Bundle();
        args.putParcelable(ARGS_ALBUM, target);
        args.putBoolean(ARGS_ENABLE_CAPTURE, enableCapture);
        LoaderManager loaderManager = this.mLoaderManager;
        if (loaderManager != null) {
            loaderManager.initLoader(2, args, this);
        }
    }

    public final void loadAll() {
        LoaderManager loaderManager = this.mLoaderManager;
        if (loaderManager != null) {
            loaderManager.initLoader(2, (Bundle) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/model/AlbumPhotoCollection$Companion;", "", "()V", "ARGS_ALBUM", "", "ARGS_ENABLE_CAPTURE", "LOADER_ID", "", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumPhotoCollection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
