package com.baidu.searchbox.video.feedflow.common.downgrade;

import com.baidu.searchbox.player.utils.BdPlayerUtils;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010#\u001a\u00020\u0006H\u0002J\t\u0010$\u001a\u00020%HÖ\u0001J\u0006\u0010&\u001a\u00020\u0018J\b\u0010'\u001a\u00020\u0006H\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006("}, d2 = {"Lcom/baidu/searchbox/video/feedflow/common/downgrade/DowngradeModel;", "", "x", "", "y", "poorRating", "", "moderateRating", "excellentRating", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "deviceScore", "", "getDeviceScore", "()F", "deviceScore$delegate", "Lkotlin/Lazy;", "getExcellentRating", "()Ljava/lang/String;", "getModerateRating", "getPoorRating", "getX", "()D", "getY", "canProcessExtraFeature", "", "canProcessPrimaryFeature", "canProcessSecondaryFeature", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "getRating", "hashCode", "", "isHitDowngradeFeature", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DowngradeModel.kt */
public final class DowngradeModel {
    private final Lazy deviceScore$delegate = BdPlayerUtils.lazyNone(DowngradeModel$deviceScore$2.INSTANCE);
    private final String excellentRating;
    private final String moderateRating;
    private final String poorRating;
    private final double x;
    private final double y;

    public static /* synthetic */ DowngradeModel copy$default(DowngradeModel downgradeModel, double d2, double d3, String str, String str2, String str3, int i2, Object obj) {
        DowngradeModel downgradeModel2 = downgradeModel;
        return downgradeModel.copy((i2 & 1) != 0 ? downgradeModel2.x : d2, (i2 & 2) != 0 ? downgradeModel2.y : d3, (i2 & 4) != 0 ? downgradeModel2.poorRating : str, (i2 & 8) != 0 ? downgradeModel2.moderateRating : str2, (i2 & 16) != 0 ? downgradeModel2.excellentRating : str3);
    }

    public final double component1() {
        return this.x;
    }

    public final double component2() {
        return this.y;
    }

    public final String component3() {
        return this.poorRating;
    }

    public final String component4() {
        return this.moderateRating;
    }

    public final String component5() {
        return this.excellentRating;
    }

    public final DowngradeModel copy(double d2, double d3, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "poorRating");
        Intrinsics.checkNotNullParameter(str2, "moderateRating");
        Intrinsics.checkNotNullParameter(str3, "excellentRating");
        return new DowngradeModel(d2, d3, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DowngradeModel)) {
            return false;
        }
        DowngradeModel downgradeModel = (DowngradeModel) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.x), (Object) Double.valueOf(downgradeModel.x)) && Intrinsics.areEqual((Object) Double.valueOf(this.y), (Object) Double.valueOf(downgradeModel.y)) && Intrinsics.areEqual((Object) this.poorRating, (Object) downgradeModel.poorRating) && Intrinsics.areEqual((Object) this.moderateRating, (Object) downgradeModel.moderateRating) && Intrinsics.areEqual((Object) this.excellentRating, (Object) downgradeModel.excellentRating);
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + this.poorRating.hashCode()) * 31) + this.moderateRating.hashCode()) * 31) + this.excellentRating.hashCode();
    }

    public DowngradeModel(double x2, double y2, String poorRating2, String moderateRating2, String excellentRating2) {
        Intrinsics.checkNotNullParameter(poorRating2, "poorRating");
        Intrinsics.checkNotNullParameter(moderateRating2, "moderateRating");
        Intrinsics.checkNotNullParameter(excellentRating2, "excellentRating");
        this.x = x2;
        this.y = y2;
        this.poorRating = poorRating2;
        this.moderateRating = moderateRating2;
        this.excellentRating = excellentRating2;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final String getPoorRating() {
        return this.poorRating;
    }

    public final String getModerateRating() {
        return this.moderateRating;
    }

    public final String getExcellentRating() {
        return this.excellentRating;
    }

    private final float getDeviceScore() {
        return ((Number) this.deviceScore$delegate.getValue()).floatValue();
    }

    public final boolean isHitDowngradeFeature() {
        double d2 = this.x;
        return d2 >= 0.0d && this.y > d2;
    }

    public final boolean canProcessPrimaryFeature() {
        return StringsKt.contains$default((CharSequence) getRating(), (CharSequence) "P1", false, 2, (Object) null);
    }

    public final boolean canProcessSecondaryFeature() {
        return StringsKt.contains$default((CharSequence) getRating(), (CharSequence) "P2", false, 2, (Object) null);
    }

    public final boolean canProcessExtraFeature() {
        return StringsKt.contains$default((CharSequence) getRating(), (CharSequence) "P3", false, 2, (Object) null);
    }

    private final String getRating() {
        if (((double) getDeviceScore()) < this.x) {
            return this.poorRating;
        }
        if (((double) getDeviceScore()) < this.y) {
            return this.moderateRating;
        }
        return this.excellentRating;
    }

    public String toString() {
        CharSequence rating = getRating();
        if (StringsKt.isBlank(rating)) {
            rating = "All Downgrade";
        }
        StringBuilder append = new StringBuilder().append("Separator：x, y = ").append(this.x).append(", ").append(this.y).append("，Score：");
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(getDeviceScore())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return append.append(format).append("，Fun：").append((String) rating).toString();
    }
}
