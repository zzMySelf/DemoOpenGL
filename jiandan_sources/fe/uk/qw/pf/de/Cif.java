package fe.uk.qw.pf.de;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: fe.uk.qw.pf.de.if  reason: invalid class name */
public class Cif extends ad<InputStream> {
    public Cif(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @NonNull
    public Class<InputStream> qw() {
        return InputStream.class;
    }

    /* renamed from: uk */
    public InputStream rg(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* renamed from: yj */
    public void de(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
