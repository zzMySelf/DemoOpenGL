package fe.uk.qw.pf.de;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.dxmbumptech.glide.load.data.DataRewinder;
import java.io.IOException;

public final class pf implements DataRewinder<ParcelFileDescriptor> {
    public final ad qw;

    @RequiresApi(21)
    public static final class ad {
        public final ParcelFileDescriptor qw;

        public ad(ParcelFileDescriptor parcelFileDescriptor) {
            this.qw = parcelFileDescriptor;
        }

        public ParcelFileDescriptor qw() throws IOException {
            try {
                Os.lseek(this.qw.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.qw;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    @RequiresApi(21)
    public static final class qw implements DataRewinder.Factory<ParcelFileDescriptor> {
        @NonNull
        /* renamed from: de */
        public DataRewinder<ParcelFileDescriptor> ad(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new pf(parcelFileDescriptor);
        }

        @NonNull
        public Class<ParcelFileDescriptor> qw() {
            return ParcelFileDescriptor.class;
        }
    }

    @RequiresApi(21)
    public pf(ParcelFileDescriptor parcelFileDescriptor) {
        this.qw = new ad(parcelFileDescriptor);
    }

    public static boolean de() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void ad() {
    }

    @RequiresApi(21)
    @NonNull
    /* renamed from: fe */
    public ParcelFileDescriptor qw() throws IOException {
        return this.qw.qw();
    }
}
