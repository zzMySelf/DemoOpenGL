package fe.rg.qw.o.de;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public class pf extends ad<InputStream> {
    public pf(AssetManager assetManager, String str) {
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
