package com.mars.kotlin.database.extension;

import android.database.Cursor;
import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/mars/kotlin/database/extension/CursorLoaderCallback;", "T", "androidx/loader/app/LoaderManager$LoaderCallbacks", "", "id", "Landroid/os/Bundle;", "args", "Landroidx/loader/content/Loader;", "Landroid/database/Cursor;", "onCreateLoader", "(ILandroid/os/Bundle;)Landroidx/loader/content/Loader;", "loader", "data", "", "onLoadFinished", "(Landroidx/loader/content/Loader;Landroid/database/Cursor;)V", "onLoaderReset", "(Landroidx/loader/content/Loader;)V", "Lcom/mars/kotlin/database/extension/FetchLoader;", "Lcom/mars/kotlin/database/extension/FetchLoader;", "Landroidx/loader/app/LoaderManager;", "loaderManager", "Landroidx/loader/app/LoaderManager;", "<init>", "(Landroidx/loader/app/LoaderManager;Lcom/mars/kotlin/database/extension/FetchLoader;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CursorLoaderCallback<T> implements LoaderManager.LoaderCallbacks<Cursor> {
    public final FetchLoader<T> loader;
    public final LoaderManager loaderManager;

    public CursorLoaderCallback(@Nullable LoaderManager loaderManager2, @NotNull FetchLoader<T> fetchLoader) {
        Intrinsics.checkNotNullParameter(fetchLoader, "loader");
        this.loaderManager = loaderManager2;
        this.loader = fetchLoader;
    }

    @NotNull
    public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
        return this.loader;
    }

    public void onLoaderReset(@NotNull Loader<Cursor> loader2) {
        Intrinsics.checkNotNullParameter(loader2, "loader");
    }

    public void onLoadFinished(@NotNull Loader<Cursor> loader2, @Nullable Cursor cursor) {
        Intrinsics.checkNotNullParameter(loader2, "loader");
        LoaderManager loaderManager2 = this.loaderManager;
        if (loaderManager2 != null) {
            loaderManager2.destroyLoader(loader2.getId());
        }
    }
}
