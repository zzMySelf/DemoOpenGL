package fe.mmm.qw.tt.ad.ppp;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import fe.mmm.qw.i.qw;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public final class ad extends Handler {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<DecodeHintType, Object> f8406ad = new EnumMap(DecodeHintType.class);

    /* renamed from: de  reason: collision with root package name */
    public boolean f8407de = true;
    public final MultiFormatReader qw;

    public ad() {
        EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8508fe);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8506ad);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8507de);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8510rg);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8511th);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8513yj);
        noneOf.addAll(fe.mmm.qw.tt.th.ad.f8512uk);
        this.f8406ad.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
        this.f8406ad.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, qw.qw);
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.qw = multiFormatReader;
        multiFormatReader.setHints(this.f8406ad);
    }

    public final Result ad(byte[] bArr, int i2, int i3, Rect rect) {
        PlanarYUVLuminanceSource qw2 = qw(bArr, i2, i3, rect);
        if (qw2 != null) {
            try {
                return this.qw.decodeWithState(new BinaryBitmap(new HybridBinarizer(qw2)));
            } catch (ReaderException unused) {
            } finally {
                this.qw.reset();
            }
        }
        return null;
    }

    public void fe(Message message, Result result) {
        Message message2;
        Messenger messenger = message.replyTo;
        if (messenger != null) {
            if (result == null || result.getText() == null || result.getText().isEmpty()) {
                message2 = obtainMessage(1);
                qw.ad("qrcode_decode_msg", "sendMessage : 没有 decode 出内容");
            } else {
                message2 = obtainMessage(2);
                message2.obj = result;
                qw.ad("qrcode_decode_msg", "sendMessage : " + result.getText());
            }
            try {
                messenger.send(message2);
            } catch (RemoteException e) {
                qw.ad("DecodeHandler", e.getLocalizedMessage());
            }
        }
    }

    public void handleMessage(Message message) {
        int i2;
        int i3;
        if (message != null && this.f8407de) {
            int i4 = message.what;
            if (i4 == -1) {
                this.f8407de = false;
                Looper.myLooper().quit();
            } else if (i4 == 0) {
                de deVar = (de) message.obj;
                if (deVar == null || (i2 = deVar.f8409de) <= 0 || (i3 = deVar.f8408ad) <= 0) {
                    fe(message, (Result) null);
                } else {
                    fe(message, ad(deVar.qw, i3, i2, deVar.f8410fe));
                }
            }
        }
    }

    public PlanarYUVLuminanceSource qw(byte[] bArr, int i2, int i3, Rect rect) {
        if (rect == null) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr2[(((i5 * i3) + i3) - 1) - i4] = bArr[(i4 * i2) + i5];
                }
            }
            return new PlanarYUVLuminanceSource(bArr2, i3, i2, 0, 0, i3, i2, false);
        } catch (Exception e) {
            qw.rg("qrcode_decode_source", "sendMessage : " + e.getMessage());
            return null;
        }
    }
}
