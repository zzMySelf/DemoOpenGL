package com.baidu.swan.apps.inlinewidget.video.pictureinpicture;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/baidu/swan/apps/inlinewidget/video/pictureinpicture/PictureInPictureInitPositionData;", "", "isDefaultPosition", "", "direction", "", "marginTop", "", "showProcess", "(ZLjava/lang/String;FZ)V", "getDirection", "()Ljava/lang/String;", "()Z", "getMarginTop", "()F", "getShowProcess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PictureInPictureInitPostionData.kt */
public final class PictureInPictureInitPositionData {
    private final String direction;
    private final boolean isDefaultPosition;
    private final float marginTop;
    private final boolean showProcess;

    public static /* synthetic */ PictureInPictureInitPositionData copy$default(PictureInPictureInitPositionData pictureInPictureInitPositionData, boolean z, String str, float f2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pictureInPictureInitPositionData.isDefaultPosition;
        }
        if ((i2 & 2) != 0) {
            str = pictureInPictureInitPositionData.direction;
        }
        if ((i2 & 4) != 0) {
            f2 = pictureInPictureInitPositionData.marginTop;
        }
        if ((i2 & 8) != 0) {
            z2 = pictureInPictureInitPositionData.showProcess;
        }
        return pictureInPictureInitPositionData.copy(z, str, f2, z2);
    }

    public final boolean component1() {
        return this.isDefaultPosition;
    }

    public final String component2() {
        return this.direction;
    }

    public final float component3() {
        return this.marginTop;
    }

    public final boolean component4() {
        return this.showProcess;
    }

    public final PictureInPictureInitPositionData copy(boolean z, String str, float f2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "direction");
        return new PictureInPictureInitPositionData(z, str, f2, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PictureInPictureInitPositionData)) {
            return false;
        }
        PictureInPictureInitPositionData pictureInPictureInitPositionData = (PictureInPictureInitPositionData) obj;
        return this.isDefaultPosition == pictureInPictureInitPositionData.isDefaultPosition && Intrinsics.areEqual((Object) this.direction, (Object) pictureInPictureInitPositionData.direction) && Intrinsics.areEqual((Object) Float.valueOf(this.marginTop), (Object) Float.valueOf(pictureInPictureInitPositionData.marginTop)) && this.showProcess == pictureInPictureInitPositionData.showProcess;
    }

    public int hashCode() {
        boolean z = this.isDefaultPosition;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode = (((((z ? 1 : 0) * true) + this.direction.hashCode()) * 31) + Float.hashCode(this.marginTop)) * 31;
        boolean z3 = this.showProcess;
        if (!z3) {
            z2 = z3;
        }
        return hashCode + (z2 ? 1 : 0);
    }

    public String toString() {
        return "PictureInPictureInitPositionData(isDefaultPosition=" + this.isDefaultPosition + ", direction=" + this.direction + ", marginTop=" + this.marginTop + ", showProcess=" + this.showProcess + ')';
    }

    public PictureInPictureInitPositionData(boolean isDefaultPosition2, String direction2, float marginTop2, boolean showProcess2) {
        Intrinsics.checkNotNullParameter(direction2, "direction");
        this.isDefaultPosition = isDefaultPosition2;
        this.direction = direction2;
        this.marginTop = marginTop2;
        this.showProcess = showProcess2;
    }

    public final boolean isDefaultPosition() {
        return this.isDefaultPosition;
    }

    public final String getDirection() {
        return this.direction;
    }

    public final float getMarginTop() {
        return this.marginTop;
    }

    public final boolean getShowProcess() {
        return this.showProcess;
    }
}
