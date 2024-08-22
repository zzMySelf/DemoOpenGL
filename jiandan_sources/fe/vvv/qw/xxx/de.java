package fe.vvv.qw.xxx;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.size.SizeSelectors;
import java.util.ArrayList;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public SizeSelector f9130ad;
    public SizeSelector qw;

    public de(@NonNull TypedArray typedArray) {
        SizeSelector sizeSelector;
        SizeSelector sizeSelector2;
        ArrayList arrayList = new ArrayList(3);
        if (typedArray.hasValue(33)) {
            arrayList.add(SizeSelectors.i(typedArray.getInteger(33, 0)));
        }
        if (typedArray.hasValue(30)) {
            arrayList.add(SizeSelectors.th(typedArray.getInteger(30, 0)));
        }
        if (typedArray.hasValue(32)) {
            arrayList.add(SizeSelectors.uk(typedArray.getInteger(32, 0)));
        }
        if (typedArray.hasValue(29)) {
            arrayList.add(SizeSelectors.rg(typedArray.getInteger(29, 0)));
        }
        if (typedArray.hasValue(31)) {
            arrayList.add(SizeSelectors.yj(typedArray.getInteger(31, 0)));
        }
        if (typedArray.hasValue(28)) {
            arrayList.add(SizeSelectors.fe(typedArray.getInteger(28, 0)));
        }
        if (typedArray.hasValue(26)) {
            arrayList.add(SizeSelectors.ad(qw.i(typedArray.getString(26)), 0.0f));
        }
        if (typedArray.getBoolean(34, false)) {
            arrayList.add(SizeSelectors.pf());
        }
        if (typedArray.getBoolean(27, false)) {
            arrayList.add(SizeSelectors.de());
        }
        if (!arrayList.isEmpty()) {
            sizeSelector = SizeSelectors.qw((SizeSelector[]) arrayList.toArray(new SizeSelector[0]));
        } else {
            sizeSelector = SizeSelectors.de();
        }
        this.qw = sizeSelector;
        ArrayList arrayList2 = new ArrayList(3);
        if (typedArray.hasValue(55)) {
            arrayList2.add(SizeSelectors.i(typedArray.getInteger(55, 0)));
        }
        if (typedArray.hasValue(52)) {
            arrayList2.add(SizeSelectors.th(typedArray.getInteger(52, 0)));
        }
        if (typedArray.hasValue(54)) {
            arrayList2.add(SizeSelectors.uk(typedArray.getInteger(54, 0)));
        }
        if (typedArray.hasValue(51)) {
            arrayList2.add(SizeSelectors.rg(typedArray.getInteger(51, 0)));
        }
        if (typedArray.hasValue(53)) {
            arrayList2.add(SizeSelectors.yj(typedArray.getInteger(53, 0)));
        }
        if (typedArray.hasValue(50)) {
            arrayList2.add(SizeSelectors.fe(typedArray.getInteger(50, 0)));
        }
        if (typedArray.hasValue(48)) {
            arrayList2.add(SizeSelectors.ad(qw.i(typedArray.getString(48)), 0.0f));
        }
        if (typedArray.getBoolean(56, false)) {
            arrayList2.add(SizeSelectors.pf());
        }
        if (typedArray.getBoolean(49, false)) {
            arrayList2.add(SizeSelectors.de());
        }
        if (!arrayList2.isEmpty()) {
            sizeSelector2 = SizeSelectors.qw((SizeSelector[]) arrayList2.toArray(new SizeSelector[0]));
        } else {
            sizeSelector2 = SizeSelectors.de();
        }
        this.f9130ad = sizeSelector2;
    }

    @NonNull
    public SizeSelector ad() {
        return this.f9130ad;
    }

    @NonNull
    public SizeSelector qw() {
        return this.qw;
    }
}
