package com.baidu.megapp.proxy.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.baidu.megapp.ProxyEnvironment;
import com.baidu.megapp.proxy.provider.UriUtils;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ContentProviderProxy extends ContentProvider {
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.query(parsedUri.uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }

    public Cursor query(Uri uri, String[] projection, Bundle queryArgs, CancellationSignal cancellationSignal) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.query(parsedUri.uri, projection, queryArgs, cancellationSignal);
    }

    public Uri canonicalize(Uri url) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(url);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.canonicalize(parsedUri.uri);
    }

    public Uri uncanonicalize(Uri url) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(url);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.uncanonicalize(parsedUri.uri);
    }

    public boolean refresh(Uri uri, Bundle args, CancellationSignal cancellationSignal) {
        alertOnInvoke("refresh");
        return super.refresh(uri, args, cancellationSignal);
    }

    public int bulkInsert(Uri uri, ContentValues[] values) {
        alertOnInvoke("bulkInsert");
        return super.bulkInsert(uri, values);
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        alertOnInvoke("openFile");
        return super.openFile(uri, mode);
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode, CancellationSignal signal) throws FileNotFoundException {
        alertOnInvoke("openFile");
        return super.openFile(uri, mode, signal);
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        alertOnInvoke("openAssetFile");
        return super.openAssetFile(uri, mode);
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String mode, CancellationSignal signal) throws FileNotFoundException {
        alertOnInvoke("openAssetFile");
        return super.openAssetFile(uri, mode, signal);
    }

    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.getStreamTypes(parsedUri.uri, mimeTypeFilter);
    }

    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts) throws FileNotFoundException {
        alertOnInvoke("openTypedAssetFile");
        return super.openTypedAssetFile(uri, mimeTypeFilter, opts);
    }

    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts, CancellationSignal signal) throws FileNotFoundException {
        alertOnInvoke("openTypedAssetFile");
        return super.openTypedAssetFile(uri, mimeTypeFilter, opts, signal);
    }

    public <T> ParcelFileDescriptor openPipeHelper(Uri uri, String mimeType, Bundle opts, T args, ContentProvider.PipeDataWriter<T> func) throws FileNotFoundException {
        alertOnInvoke("openPipeHelper");
        return super.openPipeHelper(uri, mimeType, opts, args, func);
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        ContentProvider originalContentProvider;
        if (operations == null || operations.size() < 1) {
            return null;
        }
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(operations.get(0).getUri());
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.applyBatch(operations);
    }

    public Bundle call(String method, String arg, Bundle extras) {
        alertOnInvoke("call");
        return super.call(method, arg, extras);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.query(parsedUri.uri, projection, selection, selectionArgs, sortOrder);
    }

    public String getType(Uri uri) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.getType(parsedUri.uri);
    }

    public Uri insert(Uri uri, ContentValues values) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return null;
        }
        return originalContentProvider.insert(parsedUri.uri, values);
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return -1;
        }
        return originalContentProvider.delete(parsedUri.uri, selection, selectionArgs);
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        ContentProvider originalContentProvider;
        UriUtils.ParsedUri parsedUri = UriUtils.toOriginalUri(uri);
        if (parsedUri.uri == null || (originalContentProvider = ProxyEnvironment.resolveContentProvider(parsedUri.uri, parsedUri.packageName)) == null) {
            return -1;
        }
        return originalContentProvider.update(parsedUri.uri, values, selection, selectionArgs);
    }

    private void alertOnInvoke(String methodName) {
        throw new RuntimeException("ContentProvider: method " + methodName + "is not implemented in the proxy provider for now");
    }
}
