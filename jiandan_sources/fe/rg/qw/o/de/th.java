package fe.rg.qw.o.de;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

public class th extends ad<ParcelFileDescriptor> {
    public th(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @NonNull
    public Class<ParcelFileDescriptor> qw() {
        return ParcelFileDescriptor.class;
    }

    /* renamed from: uk */
    public ParcelFileDescriptor rg(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    /* renamed from: yj */
    public void de(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
