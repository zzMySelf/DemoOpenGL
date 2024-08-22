package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableShort extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new Parcelable.Creator<ObservableShort>() {
        public ObservableShort createFromParcel(Parcel parcel) {
            return new ObservableShort((short) parcel.readInt());
        }

        public ObservableShort[] newArray(int i2) {
            return new ObservableShort[i2];
        }
    };
    public static final long serialVersionUID = 1;
    public short mValue;

    public ObservableShort(short s) {
        this.mValue = s;
    }

    public int describeContents() {
        return 0;
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s) {
        if (s != this.mValue) {
            this.mValue = s;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mValue);
    }

    public ObservableShort() {
    }

    public ObservableShort(Observable... observableArr) {
        super(observableArr);
    }
}
