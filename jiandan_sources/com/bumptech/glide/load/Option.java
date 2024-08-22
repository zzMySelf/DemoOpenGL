package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.rg.qw.ggg.uk;
import java.security.MessageDigest;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class Option<T> {

    /* renamed from: rg  reason: collision with root package name */
    public static final CacheKeyUpdater<Object> f3668rg = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final CacheKeyUpdater<T> f3669ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f3670de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile byte[] f3671fe;
    public final T qw;

    public interface CacheKeyUpdater<T> {
        void qw(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public class qw implements CacheKeyUpdater<Object> {
        public void qw(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    public Option(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        uk.ad(str);
        this.f3670de = str;
        this.qw = t;
        uk.fe(cacheKeyUpdater);
        this.f3669ad = cacheKeyUpdater;
    }

    @NonNull
    public static <T> CacheKeyUpdater<T> ad() {
        return f3668rg;
    }

    @NonNull
    public static <T> Option<T> qw(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> rg(@NonNull String str) {
        return new Option<>(str, (Object) null, ad());
    }

    @NonNull
    public static <T> Option<T> th(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, ad());
    }

    @Nullable
    public T de() {
        return this.qw;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f3670de.equals(((Option) obj).f3670de);
        }
        return false;
    }

    @NonNull
    public final byte[] fe() {
        if (this.f3671fe == null) {
            this.f3671fe = this.f3670de.getBytes(Key.qw);
        }
        return this.f3671fe;
    }

    public int hashCode() {
        return this.f3670de.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f3670de + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    public void yj(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f3669ad.qw(fe(), t, messageDigest);
    }
}
