package fe.fe.vvv.ad.qw.uk;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final int f3165ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f3166de;
    public ContentProvider qw;

    public qw(int i2, int i3) {
        this.f3165ad = i2;
        this.f3166de = i3;
    }

    public void ad(ContentProvider contentProvider) {
        if (this.qw == null) {
            this.qw = contentProvider;
        }
    }

    public Cursor ddd(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return xxx(i2, uri, strArr, str, strArr2, str2);
    }

    public int de(int i2, Uri uri, ContentValues[] contentValuesArr) {
        for (ContentValues o2 : contentValuesArr) {
            o(i2, uri, o2);
        }
        return r0;
    }

    public Bundle fe(String str, String str2, Bundle bundle) {
        return null;
    }

    public AssetFileDescriptor ggg(int i2, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        ppp(i2, uri, str);
        throw null;
    }

    public abstract String i(int i2, Uri uri);

    /* renamed from: if  reason: not valid java name */
    public final int m224if() {
        return this.f3165ad;
    }

    public abstract int nn(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr);

    public abstract Uri o(int i2, Uri uri, ContentValues contentValues);

    public final int pf() {
        return this.f3166de;
    }

    public AssetFileDescriptor ppp(int i2, Uri uri, String str) throws FileNotFoundException {
        vvv(i2, uri, str);
        throw null;
    }

    public ContentProviderResult[] qw(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        for (int i2 = 0; i2 < size; i2++) {
            contentProviderResultArr[i2] = arrayList.get(i2).apply(this.qw, contentProviderResultArr, i2);
        }
        return contentProviderResultArr;
    }

    public boolean rg(String str, String str2, Bundle bundle) {
        return false;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m225switch(Configuration configuration) {
    }

    public abstract int th(int i2, Uri uri, String str, String[] strArr);

    public abstract void uk(UriMatcher uriMatcher, String str);

    public ParcelFileDescriptor vvv(int i2, Uri uri, String str) throws FileNotFoundException {
        throw new FileNotFoundException("No files supported by provider at " + uri);
    }

    public abstract boolean when();

    public abstract Cursor xxx(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public void yj(Uri uri, int i2) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }
}
