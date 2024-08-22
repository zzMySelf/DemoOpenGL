package fe.mmm.qw.tt.th;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.tera.scan.scanner.zxing.CaptureActivity;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class fe extends Thread {

    /* renamed from: ad  reason: collision with root package name */
    public final CaptureActivity f8517ad;

    /* renamed from: th  reason: collision with root package name */
    public final Map<DecodeHintType, Object> f8518th;

    /* renamed from: uk  reason: collision with root package name */
    public final CountDownLatch f8519uk = new CountDownLatch(1);

    /* renamed from: yj  reason: collision with root package name */
    public Handler f8520yj;

    public fe(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, ResultPointCallback resultPointCallback) {
        this.f8517ad = captureActivity;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.f8518th = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            collection = EnumSet.noneOf(BarcodeFormat.class);
            collection.addAll(ad.f8508fe);
            collection.addAll(ad.f8506ad);
            collection.addAll(ad.f8507de);
            collection.addAll(ad.f8510rg);
            collection.addAll(ad.f8511th);
            collection.addAll(ad.f8513yj);
            collection.addAll(ad.f8512uk);
        }
        this.f8518th.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f8518th.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.f8518th.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    public Handler qw() {
        try {
            this.f8519uk.await();
        } catch (InterruptedException unused) {
        }
        return this.f8520yj;
    }

    public void run() {
        Looper.prepare();
        this.f8520yj = new de(this.f8517ad, this.f8518th);
        this.f8519uk.countDown();
        Looper.loop();
    }
}
