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
    public static final boolean DEBUG = false;
    public static final String TAG = "DispProvider";
    public String mAuthority;
    public ArrayList<fe.fe.vvv.ad.qw.uk.qw> mContentProviderDelegates;
    public final Object mInitLocker = new Object();
    public volatile boolean mIsInit = false;
    public qw mUriMatcher;

    public static class qw extends UriMatcher {

        /* renamed from: ad  reason: collision with root package name */
        public int f943ad;
        public int qw;

        public qw(int i2) {
            super(i2);
        }

        public void addURI(String str, String str2, int i2) {
            qw(i2);
            super.addURI(str, str2, i2);
        }

        public final void qw(int i2) {
            if (i2 < this.f943ad || i2 > this.qw) {
                throw new IllegalArgumentException("The minCode is : " + this.f943ad + "The maxCode is : " + this.qw + "The error code is : " + i2);
            }
        }
    }

    private fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate(int i2) {
        int size = this.mContentProviderDelegates.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) / 2;
            fe.fe.vvv.ad.qw.uk.qw qwVar = this.mContentProviderDelegates.get(i4);
            if (i2 >= qwVar.m224if() && i2 <= qwVar.pf()) {
                return qwVar;
            }
            if (i2 < qwVar.m224if()) {
                size = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return null;
    }

    private void initIfNeed() {
        if (!this.mIsInit) {
            synchronized (this.mInitLocker) {
                if (!this.mIsInit) {
                    this.mIsInit = true;
                    String authority = getAuthority();
                    this.mAuthority = authority;
                    if (authority != null) {
                        this.mUriMatcher = new qw(-1);
                        this.mContentProviderDelegates = new ArrayList<>();
                        List<fe.fe.vvv.ad.qw.uk.qw> contentProviderDelegates = getContentProviderDelegates();
                        if (contentProviderDelegates != null) {
                            for (fe.fe.vvv.ad.qw.uk.qw next : contentProviderDelegates) {
                                insertContentProviderDelegate(next);
                                this.mUriMatcher.f943ad = next.m224if();
                                this.mUriMatcher.qw = next.pf();
                                next.uk(this.mUriMatcher, this.mAuthority);
                            }
                        }
                        Iterator<fe.fe.vvv.ad.qw.uk.qw> it = this.mContentProviderDelegates.iterator();
                        while (it.hasNext()) {
                            it.next().when();
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
            }
        }
    }

    private void insertContentProviderDelegate(fe.fe.vvv.ad.qw.uk.qw qwVar) {
        if (qwVar.m224if() <= qwVar.pf()) {
            int size = this.mContentProviderDelegates.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (qwVar.m224if() > this.mContentProviderDelegates.get(i3).pf()) {
                    i2 = i3 + 1;
                }
            }
            if (i2 >= size - 1 || qwVar.pf() < this.mContentProviderDelegates.get(i2).m224if()) {
                this.mContentProviderDelegates.add(i2, qwVar);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate;
        initIfNeed();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<ContentProviderOperation> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentProviderOperation next = it.next();
            Uri uri = next.getUri();
            if (!(uri == null || (findContentProviderDelegate = findContentProviderDelegate(this.mUriMatcher.match(uri))) == null)) {
                findContentProviderDelegate.yj(uri, 0);
                ArrayList arrayList2 = (ArrayList) hashMap.get(findContentProviderDelegate);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(findContentProviderDelegate, arrayList2);
                }
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            for (ContentProviderResult add : ((fe.fe.vvv.ad.qw.uk.qw) entry.getKey()).qw((ArrayList) entry.getValue())) {
                arrayList3.add(add);
            }
        }
        if (arrayList3.size() <= 0) {
            return super.applyBatch(arrayList);
        }
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[arrayList3.size()];
        arrayList3.toArray(contentProviderResultArr);
        return contentProviderResultArr;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        initIfNeed();
        Iterator<fe.fe.vvv.ad.qw.uk.qw> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            it.next().ad(this);
        }
        super.attachInfo(context, providerInfo);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 6);
            return findContentProviderDelegate.de(match, uri, contentValuesArr);
        }
        throw new IllegalArgumentException();
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        initIfNeed();
        Iterator<fe.fe.vvv.ad.qw.uk.qw> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            fe.fe.vvv.ad.qw.uk.qw next = it.next();
            if (next.rg(str, str2, bundle)) {
                next.yj((Uri) null, 3);
                return next.fe(str, str2, bundle);
            }
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 5);
            return findContentProviderDelegate.th(match, uri, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    public abstract String getAuthority();

    public abstract List<fe.fe.vvv.ad.qw.uk.qw> getContentProviderDelegates();

    public String getType(Uri uri) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 4);
            return findContentProviderDelegate.i(match, uri);
        }
        throw new IllegalArgumentException();
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 1);
            return findContentProviderDelegate.o(match, uri, contentValues);
        }
        throw new IllegalArgumentException();
    }

    public void onConfigurationChanged(Configuration configuration) {
        initIfNeed();
        super.onConfigurationChanged(configuration);
        Iterator<fe.fe.vvv.ad.qw.uk.qw> it = this.mContentProviderDelegates.iterator();
        while (it.hasNext()) {
            it.next().m225switch(configuration);
        }
    }

    public boolean onCreate() {
        return true;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 7);
            findContentProviderDelegate.ppp(match, uri, str);
            throw null;
        }
        throw new IllegalArgumentException();
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.vvv(match, uri, str);
            throw null;
        }
        throw new IllegalArgumentException();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 0);
            return findContentProviderDelegate.xxx(match, uri, strArr, str, strArr2, str2);
        }
        throw new IllegalArgumentException();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 2);
            return findContentProviderDelegate.nn(match, uri, contentValues, str, strArr);
        }
        throw new IllegalArgumentException();
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 7);
            findContentProviderDelegate.ggg(match, uri, str, cancellationSignal);
            throw null;
        }
        throw new IllegalArgumentException();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        initIfNeed();
        int match = this.mUriMatcher.match(uri);
        fe.fe.vvv.ad.qw.uk.qw findContentProviderDelegate = findContentProviderDelegate(match);
        if (findContentProviderDelegate != null) {
            findContentProviderDelegate.yj(uri, 0);
            return findContentProviderDelegate.ddd(match, uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        throw new IllegalArgumentException();
    }
}
