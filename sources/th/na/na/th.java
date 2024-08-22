package th.na.na;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.etn.EtnConfig;

/* compiled from: EtnConfig */
class th implements Parcelable.Creator<EtnConfig> {
    public Object createFromParcel(Parcel parcel) {
        return new EtnConfig(parcel);
    }

    public Object[] newArray(int i2) {
        return new EtnConfig[i2];
    }
}
