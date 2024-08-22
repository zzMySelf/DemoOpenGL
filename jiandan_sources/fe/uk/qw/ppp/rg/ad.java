package fe.uk.qw.ppp.rg;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ad extends rg<Bitmap> {
    public ad(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: ggg */
    public void when(Bitmap bitmap) {
        ((ImageView) this.f6029ad).setImageBitmap(bitmap);
    }
}
