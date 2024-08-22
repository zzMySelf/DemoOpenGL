package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    public static int beginObjectHeader(Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i2) {
        zzb(parcel, i2);
    }

    public static void writeBigDecimal(Parcel parcel, int i2, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal != null) {
            int zza = zza(parcel, i2);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i2, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr != null) {
            int zza = zza(parcel, i2);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i3 = 0; i3 < length; i3++) {
                parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i3].scale());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBigInteger(Parcel parcel, int i2, BigInteger bigInteger, boolean z) {
        if (bigInteger != null) {
            int zza = zza(parcel, i2);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i2, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBoolean(Parcel parcel, int i2, boolean z) {
        zzb(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int i2, boolean[] zArr, boolean z) {
        if (zArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i2, List<Boolean> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i2, Boolean bool, boolean z) {
        if (bool != null) {
            zzb(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle != null) {
            int zza = zza(parcel, i2);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i2, byte b) {
        zzb(parcel, i2, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(Parcel parcel, int i2, byte[] bArr, boolean z) {
        if (bArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i2, byte[][] bArr, boolean z) {
        if (bArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i2, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeByteArray(sparseArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeChar(Parcel parcel, int i2, char c) {
        zzb(parcel, i2, 4);
        parcel.writeInt(c);
    }

    public static void writeCharArray(Parcel parcel, int i2, char[] cArr, boolean z) {
        if (cArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i2, double d) {
        zzb(parcel, i2, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(Parcel parcel, int i2, double[] dArr, boolean z) {
        if (dArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i2, List<Double> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeDouble(list.get(i3).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i2, Double d, boolean z) {
        if (d != null) {
            zzb(parcel, i2, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i2, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i2, float f) {
        zzb(parcel, i2, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(Parcel parcel, int i2, float[] fArr, boolean z) {
        if (fArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i2, List<Float> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeFloat(list.get(i3).floatValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeFloatObject(Parcel parcel, int i2, Float f, boolean z) {
        if (f != null) {
            zzb(parcel, i2, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i2, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int zza = zza(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i2, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i2, List<IBinder> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i2, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeStrongBinder(sparseArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeInt(Parcel parcel, int i2, int i3) {
        zzb(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void writeIntArray(Parcel parcel, int i2, int[] iArr, boolean z) {
        if (iArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i2, List<Integer> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).intValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i2, Integer num, boolean z) {
        if (num != null) {
            zzb(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeList(Parcel parcel, int i2, List list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            parcel.writeList(list);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i2, long j) {
        zzb(parcel, i2, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(Parcel parcel, int i2, long[] jArr, boolean z) {
        if (jArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i2, List<Long> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeLong(list.get(i3).longValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeLongObject(Parcel parcel, int i2, Long l, boolean z) {
        if (l != null) {
            zzb(parcel, i2, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i2, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int zza = zza(parcel, i2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i2, Parcel[] parcelArr, boolean z) {
        if (parcelArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeParcelList(Parcel parcel, int i2, List<Parcel> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcel parcel2 = list.get(i3);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i2, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                Parcel valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable != null) {
            int zza = zza(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i2, short s) {
        zzb(parcel, i2, 4);
        parcel.writeInt(s);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i2, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray != null) {
            int zza = zza(parcel, i2);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i2, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseIntArray.keyAt(i3));
                parcel.writeInt(sparseIntArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i2, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseLongArray.keyAt(i3));
                parcel.writeLong(sparseLongArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeString(Parcel parcel, int i2, String str, boolean z) {
        if (str != null) {
            int zza = zza(parcel, i2);
            parcel.writeString(str);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i2, String[] strArr, boolean z) {
        if (strArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i2, List<String> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i2, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeString(sparseArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, t, i3);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list.get(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i2, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zzb(parcel, i2, 0);
        }
    }

    public static int zza(Parcel parcel, int i2) {
        parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void zzb(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static <T extends Parcelable> void zza(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void zzb(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }
}
