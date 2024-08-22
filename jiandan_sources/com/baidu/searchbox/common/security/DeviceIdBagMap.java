package com.baidu.searchbox.common.security;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "getDeviceFlag", "isSync", "", "deviceFlag", "put", "key", "value", "writeToParcel", "", "flags", "CREATOR", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceIdBagMap extends ConcurrentHashMap<Integer, DeviceIdBag> implements Parcelable {
    @NotNull
    public static final qw CREATOR = new qw((DefaultConstructorMarker) null);

    public static final class qw implements Parcelable.Creator<DeviceIdBagMap> {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: ad */
        public DeviceIdBagMap[] newArray(int i2) {
            return new DeviceIdBagMap[i2];
        }

        @NotNull
        /* renamed from: qw */
        public DeviceIdBagMap createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceIdBagMap(parcel);
        }
    }

    public DeviceIdBagMap() {
    }

    public static /* synthetic */ boolean isSync$default(DeviceIdBagMap deviceIdBagMap, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = deviceIdBagMap.getDeviceFlag();
        }
        return deviceIdBagMap.isSync(i2);
    }

    public /* bridge */ boolean containsKey(Integer num) {
        return super.containsKey(num);
    }

    public /* bridge */ boolean containsValue(DeviceIdBag deviceIdBag) {
        return super.containsValue(deviceIdBag);
    }

    public int describeContents() {
        return 0;
    }

    public final /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> entrySet() {
        return getEntries();
    }

    public /* bridge */ DeviceIdBag get(Integer num) {
        return (DeviceIdBag) super.get(num);
    }

    public final int getDeviceFlag() {
        int i2 = 0;
        for (Integer next : keySet()) {
            Intrinsics.checkNotNullExpressionValue(next, "deviceFlag");
            i2 |= next.intValue();
        }
        return i2;
    }

    public /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Integer> getKeys() {
        return super.keySet();
    }

    public /* bridge */ DeviceIdBag getOrDefault(Integer num, DeviceIdBag deviceIdBag) {
        return (DeviceIdBag) super.getOrDefault(num, deviceIdBag);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<DeviceIdBag> getValues() {
        return super.values();
    }

    public final boolean isSync(int i2) {
        if (((~getDeviceFlag()) & i2) != 0) {
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        DeviceInfoUtilKt.de(new DeviceIdBagMap$isSync$1(i2, this, booleanRef));
        return booleanRef.element;
    }

    public final /* bridge */ Set<Integer> keySet() {
        return getKeys();
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put(((Number) obj).intValue(), (DeviceIdBag) obj2);
    }

    public /* bridge */ DeviceIdBag remove(Integer num) {
        return (DeviceIdBag) super.remove(num);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<DeviceIdBag> values() {
        return getValues();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        synchronized (DeviceIdBagMap.class) {
            Set<Integer> keySet = keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, SavedStateHandle.KEYS);
            parcel.writeInt(keySet.size());
            for (Integer next : keySet) {
                Intrinsics.checkNotNullExpressionValue(next, "deviceFlag");
                parcel.writeInt(next.intValue());
                parcel.writeParcelable((Parcelable) get((Object) next), 0);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceIdBagMap(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            DeviceIdBag deviceIdBag = (DeviceIdBag) parcel.readParcelable(DeviceIdBag.class.getClassLoader());
            if (deviceIdBag != null) {
                put(readInt2, deviceIdBag);
            }
        }
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        return containsKey((Integer) obj);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof DeviceIdBag)) {
            return false;
        }
        return containsValue((DeviceIdBag) obj);
    }

    public final /* bridge */ DeviceIdBag get(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        return get((Integer) obj);
    }

    public final /* bridge */ DeviceIdBag getOrDefault(Object obj, DeviceIdBag deviceIdBag) {
        return !(obj instanceof Integer) ? deviceIdBag : getOrDefault((Integer) obj, deviceIdBag);
    }

    @Nullable
    public DeviceIdBag put(int i2, @NotNull DeviceIdBag deviceIdBag) {
        DeviceIdBag deviceIdBag2;
        Intrinsics.checkNotNullParameter(deviceIdBag, "value");
        synchronized (DeviceIdBagMap.class) {
            deviceIdBag2 = (DeviceIdBag) super.put(Integer.valueOf(i2), deviceIdBag);
        }
        return deviceIdBag2;
    }

    public final /* bridge */ DeviceIdBag remove(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        return remove((Integer) obj);
    }

    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof Integer) ? obj2 : getOrDefault((Integer) obj, (DeviceIdBag) obj2);
    }

    public /* bridge */ boolean remove(Integer num, DeviceIdBag deviceIdBag) {
        return super.remove(num, deviceIdBag);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof Integer) && (obj2 instanceof DeviceIdBag)) {
            return remove((Integer) obj, (DeviceIdBag) obj2);
        }
        return false;
    }
}
