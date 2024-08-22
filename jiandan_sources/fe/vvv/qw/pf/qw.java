package fe.vvv.qw.pf;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.gesture.GestureAction;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f9067ad;

    /* renamed from: de  reason: collision with root package name */
    public int f9068de;

    /* renamed from: fe  reason: collision with root package name */
    public int f9069fe;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f9070rg;

    public qw(@NonNull TypedArray typedArray) {
        this.qw = typedArray.getInteger(19, GestureAction.DEFAULT_TAP.value());
        this.f9067ad = typedArray.getInteger(15, GestureAction.DEFAULT_LONG_TAP.value());
        this.f9068de = typedArray.getInteger(16, GestureAction.DEFAULT_PINCH.value());
        this.f9069fe = typedArray.getInteger(17, GestureAction.DEFAULT_SCROLL_HORIZONTAL.value());
        this.f9070rg = typedArray.getInteger(18, GestureAction.DEFAULT_SCROLL_VERTICAL.value());
    }

    public GestureAction ad() {
        return qw(this.f9069fe);
    }

    public GestureAction de() {
        return qw(this.f9067ad);
    }

    public GestureAction fe() {
        return qw(this.f9068de);
    }

    public final GestureAction qw(int i2) {
        return GestureAction.fromValue(i2);
    }

    public GestureAction rg() {
        return qw(this.qw);
    }

    public GestureAction th() {
        return qw(this.f9070rg);
    }
}
