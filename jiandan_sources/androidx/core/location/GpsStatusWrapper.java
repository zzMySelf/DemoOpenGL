package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class GpsStatusWrapper extends GnssStatusCompat {
    public static final int BEIDOU_PRN_COUNT = 35;
    public static final int BEIDOU_PRN_OFFSET = 200;
    public static final int GLONASS_PRN_COUNT = 24;
    public static final int GLONASS_PRN_OFFSET = 64;
    public static final int GPS_PRN_COUNT = 32;
    public static final int GPS_PRN_OFFSET = 0;
    public static final int QZSS_SVID_MAX = 200;
    public static final int QZSS_SVID_MIN = 193;
    public static final int SBAS_PRN_MAX = 64;
    public static final int SBAS_PRN_MIN = 33;
    public static final int SBAS_PRN_OFFSET = -87;
    @GuardedBy("mWrapped")
    public Iterator<GpsSatellite> mCachedIterator;
    @GuardedBy("mWrapped")
    public int mCachedIteratorPosition;
    @GuardedBy("mWrapped")
    public GpsSatellite mCachedSatellite;
    @GuardedBy("mWrapped")
    public int mCachedSatelliteCount = -1;
    public final GpsStatus mWrapped;

    public GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    public static int getConstellationFromPrn(int i2) {
        if (i2 > 0 && i2 <= 32) {
            return 1;
        }
        if (i2 >= 33 && i2 <= 64) {
            return 2;
        }
        if (i2 > 64 && i2 <= 88) {
            return 3;
        }
        if (i2 <= 200 || i2 > 235) {
            return (i2 < 193 || i2 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite getSatellite(int i2) {
        GpsSatellite gpsSatellite;
        synchronized (this.mWrapped) {
            if (i2 < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }
            while (true) {
                if (this.mCachedIteratorPosition >= i2) {
                    break;
                }
                this.mCachedIteratorPosition++;
                if (!this.mCachedIterator.hasNext()) {
                    this.mCachedSatellite = null;
                    break;
                }
                this.mCachedSatellite = this.mCachedIterator.next();
            }
            gpsSatellite = this.mCachedSatellite;
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    public static int getSvidFromPrn(int i2) {
        int constellationFromPrn = getConstellationFromPrn(i2);
        if (constellationFromPrn == 2) {
            return i2 + 87;
        }
        if (constellationFromPrn != 3) {
            return constellationFromPrn != 5 ? i2 : i2 - 200;
        }
        return i2 - 64;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
    }

    public float getAzimuthDegrees(int i2) {
        return getSatellite(i2).getAzimuth();
    }

    public float getBasebandCn0DbHz(int i2) {
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i2) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i2) {
        return getSatellite(i2).getSnr();
    }

    public int getConstellationType(int i2) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return getConstellationFromPrn(getSatellite(i2).getPrn());
    }

    public float getElevationDegrees(int i2) {
        return getSatellite(i2).getElevation();
    }

    public int getSatelliteCount() {
        int i2;
        synchronized (this.mWrapped) {
            if (this.mCachedSatelliteCount == -1) {
                for (GpsSatellite next : this.mWrapped.getSatellites()) {
                    this.mCachedSatelliteCount++;
                }
                this.mCachedSatelliteCount++;
            }
            i2 = this.mCachedSatelliteCount;
        }
        return i2;
    }

    public int getSvid(int i2) {
        if (Build.VERSION.SDK_INT < 24) {
            return getSatellite(i2).getPrn();
        }
        return getSvidFromPrn(getSatellite(i2).getPrn());
    }

    public boolean hasAlmanacData(int i2) {
        return getSatellite(i2).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int i2) {
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i2) {
        return false;
    }

    public boolean hasEphemerisData(int i2) {
        return getSatellite(i2).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int i2) {
        return getSatellite(i2).usedInFix();
    }
}
