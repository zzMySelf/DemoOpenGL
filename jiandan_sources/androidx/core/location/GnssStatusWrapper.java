package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class GnssStatusWrapper extends GnssStatusCompat {
    public final GnssStatus mWrapped;

    public GnssStatusWrapper(GnssStatus gnssStatus) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull(gnssStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GnssStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
    }

    public float getAzimuthDegrees(int i2) {
        return this.mWrapped.getAzimuthDegrees(i2);
    }

    public float getBasebandCn0DbHz(int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return this.mWrapped.getBasebandCn0DbHz(i2);
        }
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mWrapped.getCarrierFrequencyHz(i2);
        }
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i2) {
        return this.mWrapped.getCn0DbHz(i2);
    }

    public int getConstellationType(int i2) {
        return this.mWrapped.getConstellationType(i2);
    }

    public float getElevationDegrees(int i2) {
        return this.mWrapped.getElevationDegrees(i2);
    }

    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int getSvid(int i2) {
        return this.mWrapped.getSvid(i2);
    }

    public boolean hasAlmanacData(int i2) {
        return this.mWrapped.hasAlmanacData(i2);
    }

    public boolean hasBasebandCn0DbHz(int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return this.mWrapped.hasBasebandCn0DbHz(i2);
        }
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mWrapped.hasCarrierFrequencyHz(i2);
        }
        return false;
    }

    public boolean hasEphemerisData(int i2) {
        return this.mWrapped.hasEphemerisData(i2);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int i2) {
        return this.mWrapped.usedInFix(i2);
    }
}
