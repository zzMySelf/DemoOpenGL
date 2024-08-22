package fe.vvv.qw.o;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
public class de extends ad<Image> {
    public de(int i2) {
        super(i2, Image.class);
    }

    /* renamed from: o */
    public void th(@NonNull Image image, boolean z) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
