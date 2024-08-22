package com.baidu.pyramid.runtime.multiprocess.components;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class DispatchableContentProvider extends ContentProvider {
    private static final boolean DEBUG = false;
    private static final String TAG = "DispProvider";
    private String mAuthority;
    private ArrayList<ContentProviderDelegate> mContentProviderDelegates;
    private final Object mInitLocker = new Object();
    private volatile boolean mIsInit = false;
    private CheckableUriMatcher mUriMatcher;

    /* access modifiers changed from: protected */
    public abstract String getAuthority();

    /* access modifiers changed from: protected */
    public abstract List<ContentProviderDelegate> getContentProviderDelegates();

    private ContentProviderDelegate findContentProviderDelegate(int code) {
        int low = 0;
        int high = this.mContentProviderDelegates.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            ContentProviderDelegate delegate = this.mContentProviderDelegates.get(middle);
            if (code >= delegate.minCode() && code <= delegate.maxCode()) {
                return delegate;
            }
            if (code < delegate.minCode()) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return null;
    }

    private void insertContentProviderDelegate(ContentProviderDelegate newEntry) {
        if (newEntry.minCode() <= newEntry.maxCode()) {
            int len = this.mContentProviderDelegates.size();
            int insertIdx = 0;
            for (int i2 = 0; i2 < len; i2++) {
                if (newEntry.minCode() > this.mContentProviderDelegates.get(i2).maxCode()) {
                    insertIdx = i2 + 1;
                }
            }
            if (insertIdx >= len - 1 || newEntry.maxCode() < this.mContentProviderDelegates.get(insertIdx).minCode()) {
                this.mContentProviderDelegates.add(insertIdx, newEntry);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    static class CheckableUriMatcher extends UriMatcher {
        int maxCode;
        int minCode;

        public CheckableUriMatcher(int code) {
            super(code);
        }

        public void addURI(String authority, String path, int code) {
            checkRange(code);
            super.addURI(authority, path, code);
        }

        private void checkRange(int code) {
            if (code < this.minCode || code > this.maxCode) {
                throw new IllegalArgumentException("The minCode is : " + this.minCode + "The maxCode is : " + this.maxCode + "The error code is : " + code);
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    private void initIfNeed() {
        if (!this.mIsInit) {
            synchronized (this.mInitLocker) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    String authority = getAuthority();
                    this.mAuthority = authority;
                    if (authority != null) {
                        this.mUriMatcher = new CheckableUriMatcher(-1);
                        this.mContentProviderDelegates = new ArrayList<>();
                        List<ContentProviderDelegate> delegates = getContentProviderDelegates();
                        if (delegates != null) {
                            for (ContentProviderDelegate delegate : delegates) {
                                insertContentProviderDelegate(delegate);
                                this.mUriMatcher.minCode = delegate.minCode();
                                this.mUriMatcher.maxCode = delegate.maxCode();
                                delegate.fillUriMatcher(this.mUriMatcher, this.mAuthority);
                            }
                        }
                        Iterator<ContentProviderDelegate> it = this.mContentProviderDelegates.iterator();
                        while (it.hasNext()) {
                            it.next().onCreate();
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
            }
        }
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 0);
            return delegate.query(code, uri, projection, selection, selectionArgs, sortOrder);
        }
        throw new IllegalArgumentException();
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        Uri uri2 = uri;
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 0);
            return delegate.query(code, uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }

    public String getType(Uri uri) {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 4);
            return delegate.getType(code, uri);
        }
        throw new IllegalArgumentException();
    }

    public Uri insert(Uri uri, ContentValues values) {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 1);
            return delegate.insert(code, uri, values);
        }
        throw new IllegalArgumentException();
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 5);
            return delegate.delete(code, uri, selection, selectionArgs);
        }
        throw new IllegalArgumentException();
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 2);
            return delegate.update(code, uri, values, selection, selectionArgs);
        }
        throw new IllegalArgumentException();
    }

    public int bulkInsert(Uri uri, ContentValues[] values) {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 6);
            return delegate.bulkInsert(code, uri, values);
        }
        throw new IllegalArgumentException();
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        ContentProviderDelegate delegate;
        initIfNeed();
        if (operations == null) {
            return null;
        }
        HashMap<ContentProviderDelegate, ArrayList<ContentProviderOperation>> map = new HashMap<>();
        Iterator<ContentProviderOperation> it = operations.iterator();
        while (it.hasNext()) {
            ContentProviderOperation contentProviderOperation = it.next();
            Uri uri = contentProviderOperation.getUri();
            if (!(uri == null || (delegate = findContentProviderDelegate(this.mUriMatcher.match(uri))) == null)) {
                delegate.ensureCallingPermission(uri, 0);
                ArrayList<ContentProviderOperation> ops = map.get(delegate);
                if (ops == null) {
                    ops = new ArrayList<>();
                    map.put(delegate, ops);
                }
                ops.add(contentProviderOperation);
            }
        }
        ArrayList<ContentProviderResult> results = new ArrayList<>();
        for (Map.Entry<ContentProviderDelegate, ArrayList<ContentProviderOperation>> entry : map.entrySet()) {
            for (ContentProviderResult contentProviderResult : entry.getKey().applyBatch(entry.getValue())) {
                results.add(contentProviderResult);
            }
        }
        if (results.size() <= 0) {
            return super.applyBatch(operations);
        }
        ContentProviderResult[] crs = new ContentProviderResult[results.size()];
        results.toArray(crs);
        return crs;
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            return delegate.openFile(code, uri, mode);
        }
        throw new IllegalArgumentException();
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 7);
            return delegate.openAssetFile(code, uri, mode);
        }
        throw new IllegalArgumentException();
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String mode, CancellationSignal signal) throws FileNotFoundException {
        initIfNeed();
        int code = this.mUriMatcher.match(uri);
        ContentProviderDelegate delegate = findContentProviderDelegate(code);
        if (delegate != null) {
            delegate.ensureCallingPermission(uri, 7);
            return delegate.openAssetFile(code, uri, mode, signal);
        }
        throw new IllegalArgumentException();
    }

    public void attachInfo(Context context, ProviderInfo info) {
        initIfNeed();
        Iterator<ContentProviderDelegate> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            it.next().attach(this);
        }
        super.attachInfo(context, info);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        initIfNeed();
        super.onConfigurationChanged(newConfig);
        Iterator<ContentProviderDelegate> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(newConfig);
        }
    }

    public Bundle call(String method, String arg, Bundle extras) {
        initIfNeed();
        Iterator<ContentProviderDelegate> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            ContentProviderDelegate contentProviderDelegate = it.next();
            if (contentProviderDelegate.callable(method, arg, extras)) {
                contentProviderDelegate.ensureCallingPermission((Uri) null, 3);
                return contentProviderDelegate.call(method, arg, extras);
            }
        }
        return null;
    }
}
