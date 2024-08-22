package fe.fe.mmm.t;

import android.util.Base64InputStream;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;

public class qw extends Base64InputStream {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2150ad = false;

    /* renamed from: th  reason: collision with root package name */
    public boolean f2151th = false;

    public qw(InputStream inputStream, int i2) {
        super(inputStream, i2);
    }

    public int read() throws IOException {
        int read = super.read();
        if (!this.f2150ad && read == 117) {
            this.f2150ad = true;
            return 31;
        } else if (this.f2151th || read != 123) {
            return read;
        } else {
            this.f2151th = true;
            return ScriptIntrinsicBLAS.RsBlas_cher2k;
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        if (!this.f2150ad && read >= 2) {
            bArr[i2] = Ascii.US;
            bArr[i2 + 1] = -117;
            this.f2150ad = true;
        }
        return read;
    }
}
