package th.qw.qw.ad;

import android.graphics.ImageDecoder;
import io.flutter.embedding.engine.FlutterJNI;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ImageDecoder.OnHeaderDecodedListener {
    public final /* synthetic */ long qw;

    public /* synthetic */ qw(long j) {
        this.qw = j;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.qw(this.qw, imageDecoder, imageInfo, source);
    }
}
