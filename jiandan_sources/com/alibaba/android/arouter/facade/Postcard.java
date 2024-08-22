package com.alibaba.android.arouter.facade;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.IProvider;
import fe.ad.qw.qw.ad.qw;
import java.io.Serializable;
import java.util.ArrayList;

public final class Postcard extends RouteMeta {
    public String action;
    public Context context;
    public int enterAnim;
    public int exitAnim;
    public int flags;
    public boolean greenChannel;
    public Bundle mBundle;
    public Bundle optionsCompat;
    public IProvider provider;
    public SerializationService serializationService;
    public Object tag;
    public int timeout;
    public Uri uri;

    public Postcard() {
        this((String) null, (String) null);
    }

    public Postcard addFlags(int i2) {
        this.flags = i2 | this.flags;
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public Context getContext() {
        return this.context;
    }

    public int getEnterAnim() {
        return this.enterAnim;
    }

    public int getExitAnim() {
        return this.exitAnim;
    }

    public Bundle getExtras() {
        return this.mBundle;
    }

    public int getFlags() {
        return this.flags;
    }

    public Bundle getOptionsBundle() {
        return this.optionsCompat;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Uri getUri() {
        return this.uri;
    }

    public Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    public boolean isGreenChannel() {
        return this.greenChannel;
    }

    public Object navigation() {
        return navigation((Context) null);
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public Postcard setProvider(IProvider iProvider) {
        this.provider = iProvider;
        return this;
    }

    public Postcard setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public Postcard setTimeout(int i2) {
        this.timeout = i2;
        return this;
    }

    public Postcard setUri(Uri uri2) {
        this.uri = uri2;
        return this;
    }

    public String toString() {
        return "Postcard{uri=" + this.uri + ", tag=" + this.tag + ", mBundle=" + this.mBundle + ", flags=" + this.flags + ", timeout=" + this.timeout + ", provider=" + this.provider + ", greenChannel=" + this.greenChannel + ", optionsCompat=" + this.optionsCompat + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + "}\n" + super.toString();
    }

    public Postcard with(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return this;
    }

    public Postcard withAction(String str) {
        this.action = str;
        return this;
    }

    public Postcard withBoolean(@Nullable String str, boolean z) {
        this.mBundle.putBoolean(str, z);
        return this;
    }

    public Postcard withBundle(@Nullable String str, @Nullable Bundle bundle) {
        this.mBundle.putBundle(str, bundle);
        return this;
    }

    public Postcard withByte(@Nullable String str, byte b) {
        this.mBundle.putByte(str, b);
        return this;
    }

    public Postcard withByteArray(@Nullable String str, @Nullable byte[] bArr) {
        this.mBundle.putByteArray(str, bArr);
        return this;
    }

    public Postcard withChar(@Nullable String str, char c) {
        this.mBundle.putChar(str, c);
        return this;
    }

    public Postcard withCharArray(@Nullable String str, @Nullable char[] cArr) {
        this.mBundle.putCharArray(str, cArr);
        return this;
    }

    public Postcard withCharSequence(@Nullable String str, @Nullable CharSequence charSequence) {
        this.mBundle.putCharSequence(str, charSequence);
        return this;
    }

    public Postcard withCharSequenceArray(@Nullable String str, @Nullable CharSequence[] charSequenceArr) {
        this.mBundle.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public Postcard withCharSequenceArrayList(@Nullable String str, @Nullable ArrayList<CharSequence> arrayList) {
        this.mBundle.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public Postcard withDouble(@Nullable String str, double d) {
        this.mBundle.putDouble(str, d);
        return this;
    }

    public Postcard withFlags(int i2) {
        this.flags = i2;
        return this;
    }

    public Postcard withFloat(@Nullable String str, float f) {
        this.mBundle.putFloat(str, f);
        return this;
    }

    public Postcard withFloatArray(@Nullable String str, @Nullable float[] fArr) {
        this.mBundle.putFloatArray(str, fArr);
        return this;
    }

    public Postcard withInt(@Nullable String str, int i2) {
        this.mBundle.putInt(str, i2);
        return this;
    }

    public Postcard withIntegerArrayList(@Nullable String str, @Nullable ArrayList<Integer> arrayList) {
        this.mBundle.putIntegerArrayList(str, arrayList);
        return this;
    }

    public Postcard withLong(@Nullable String str, long j) {
        this.mBundle.putLong(str, j);
        return this;
    }

    public Postcard withObject(@Nullable String str, @Nullable Object obj) {
        SerializationService serializationService2 = (SerializationService) qw.de().yj(SerializationService.class);
        this.serializationService = serializationService2;
        this.mBundle.putString(str, serializationService2.object2Json(obj));
        return this;
    }

    @RequiresApi(16)
    public Postcard withOptionsCompat(ActivityOptionsCompat activityOptionsCompat) {
        if (activityOptionsCompat != null) {
            this.optionsCompat = activityOptionsCompat.toBundle();
        }
        return this;
    }

    public Postcard withParcelable(@Nullable String str, @Nullable Parcelable parcelable) {
        this.mBundle.putParcelable(str, parcelable);
        return this;
    }

    public Postcard withParcelableArray(@Nullable String str, @Nullable Parcelable[] parcelableArr) {
        this.mBundle.putParcelableArray(str, parcelableArr);
        return this;
    }

    public Postcard withParcelableArrayList(@Nullable String str, @Nullable ArrayList<? extends Parcelable> arrayList) {
        this.mBundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    public Postcard withSerializable(@Nullable String str, @Nullable Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
        return this;
    }

    public Postcard withShort(@Nullable String str, short s) {
        this.mBundle.putShort(str, s);
        return this;
    }

    public Postcard withShortArray(@Nullable String str, @Nullable short[] sArr) {
        this.mBundle.putShortArray(str, sArr);
        return this;
    }

    public Postcard withSparseParcelableArray(@Nullable String str, @Nullable SparseArray<? extends Parcelable> sparseArray) {
        this.mBundle.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public Postcard withString(@Nullable String str, @Nullable String str2) {
        this.mBundle.putString(str, str2);
        return this;
    }

    public Postcard withStringArrayList(@Nullable String str, @Nullable ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
        return this;
    }

    public Postcard withTransition(int i2, int i3) {
        this.enterAnim = i2;
        this.exitAnim = i3;
        return this;
    }

    public Postcard(String str, String str2) {
        this(str, str2, (Uri) null, (Bundle) null);
    }

    public Object navigation(Context context2) {
        return navigation(context2, (NavigationCallback) null);
    }

    public Postcard(String str, String str2, Uri uri2, Bundle bundle) {
        this.flags = 0;
        this.timeout = 300;
        this.enterAnim = -1;
        this.exitAnim = -1;
        setPath(str);
        setGroup(str2);
        setUri(uri2);
        this.mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Object navigation(Context context2, NavigationCallback navigationCallback) {
        return qw.de().th(context2, this, -1, navigationCallback);
    }

    public void navigation(Activity activity, int i2) {
        navigation(activity, i2, (NavigationCallback) null);
    }

    public void navigation(Activity activity, int i2, NavigationCallback navigationCallback) {
        qw.de().th(activity, this, i2, navigationCallback);
    }
}
