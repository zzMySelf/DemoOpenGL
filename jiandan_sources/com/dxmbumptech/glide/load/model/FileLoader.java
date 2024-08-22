package com.dxmbumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.model.ModelLoader;
import fe.uk.qw.pf.rg.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {
    public final FileOpener<Data> qw;

    public interface FileOpener<Data> {
        void ad(Data data) throws IOException;

        Data de(File file) throws FileNotFoundException;

        Class<Data> qw();
    }

    public static class ad extends qw<ParcelFileDescriptor> {

        public class qw implements FileOpener<ParcelFileDescriptor> {
            /* renamed from: fe */
            public void ad(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            public Class<ParcelFileDescriptor> qw() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: rg */
            public ParcelFileDescriptor de(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public ad() {
            super(new qw());
        }
    }

    public static final class de<Data> implements DataFetcher<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final File f3875ad;

        /* renamed from: th  reason: collision with root package name */
        public final FileOpener<Data> f3876th;

        /* renamed from: yj  reason: collision with root package name */
        public Data f3877yj;

        public de(File file, FileOpener<Data> fileOpener) {
            this.f3875ad = file;
            this.f3876th = fileOpener;
        }

        public void ad() {
            Data data = this.f3877yj;
            if (data != null) {
                try {
                    this.f3876th.ad(data);
                } catch (IOException unused) {
                }
            }
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<Data> qw() {
            return this.f3876th.qw();
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data de2 = this.f3876th.de(this.f3875ad);
                this.f3877yj = de2;
                dataCallback.rg(de2);
            } catch (FileNotFoundException e) {
                boolean isLoggable = Log.isLoggable("FileLoader", 3);
                dataCallback.de(e);
            }
        }
    }

    public static class fe extends qw<InputStream> {

        public class qw implements FileOpener<InputStream> {
            /* renamed from: fe */
            public void ad(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            public Class<InputStream> qw() {
                return InputStream.class;
            }

            /* renamed from: rg */
            public InputStream de(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public fe() {
            super(new qw());
        }
    }

    public static class qw<Data> implements ModelLoaderFactory<File, Data> {
        public final FileOpener<Data> qw;

        public qw(FileOpener<Data> fileOpener) {
            this.qw = fileOpener;
        }

        @NonNull
        public final ModelLoader<File, Data> ad(@NonNull i iVar) {
            return new FileLoader(this.qw);
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.qw = fileOpener;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull File file, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(file), new de(file, this.qw));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull File file) {
        return true;
    }
}
