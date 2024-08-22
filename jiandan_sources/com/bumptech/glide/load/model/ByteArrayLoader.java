package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.o.rg.i;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    public final Converter<Data> qw;

    public interface Converter<Data> {
        Data ad(byte[] bArr);

        Class<Data> qw();
    }

    public static class ad<Data> implements DataFetcher<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final byte[] f3700ad;

        /* renamed from: th  reason: collision with root package name */
        public final Converter<Data> f3701th;

        public ad(byte[] bArr, Converter<Data> converter) {
            this.f3700ad = bArr;
            this.f3701th = converter;
        }

        public void ad() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<Data> qw() {
            return this.f3701th.qw();
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.rg(this.f3701th.ad(this.f3700ad));
        }
    }

    public static class de implements ModelLoaderFactory<byte[], InputStream> {

        public class qw implements Converter<InputStream> {
            public qw(de deVar) {
            }

            /* renamed from: de */
            public InputStream ad(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            public Class<InputStream> qw() {
                return InputStream.class;
            }
        }

        @NonNull
        public ModelLoader<byte[], InputStream> ad(@NonNull i iVar) {
            return new ByteArrayLoader(new qw(this));
        }
    }

    public static class qw implements ModelLoaderFactory<byte[], ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$qw$qw  reason: collision with other inner class name */
        public class C0176qw implements Converter<ByteBuffer> {
            public C0176qw(qw qwVar) {
            }

            /* renamed from: de */
            public ByteBuffer ad(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            public Class<ByteBuffer> qw() {
                return ByteBuffer.class;
            }
        }

        @NonNull
        public ModelLoader<byte[], ByteBuffer> ad(@NonNull i iVar) {
            return new ByteArrayLoader(new C0176qw(this));
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.qw = converter;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull byte[] bArr, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new fe.rg.qw.ppp.de(bArr), new ad(bArr, this.qw));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull byte[] bArr) {
        return true;
    }
}
