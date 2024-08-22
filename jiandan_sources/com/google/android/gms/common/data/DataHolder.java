package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepName
@KeepForSdk
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
    public static final Builder zamb = new zab(new String[0], (String) null);
    public boolean mClosed;
    @SafeParcelable.VersionField(id = 1000)
    public final int zali;
    @SafeParcelable.Field(getter = "getColumns", id = 1)
    public final String[] zalt;
    public Bundle zalu;
    @SafeParcelable.Field(getter = "getWindows", id = 2)
    public final CursorWindow[] zalv;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    public final int zalw;
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    public final Bundle zalx;
    public int[] zaly;
    public int zalz;
    public boolean zama;

    @KeepForSdk
    public static class Builder {
        public final String[] zalt;
        public final ArrayList<HashMap<String, Object>> zamc;
        public final String zamd;
        public final HashMap<Object, Integer> zame;
        public boolean zamf;
        public String zamg;

        public Builder(String[] strArr, String str) {
            this.zalt = (String[]) Preconditions.checkNotNull(strArr);
            this.zamc = new ArrayList<>();
            this.zamd = str;
            this.zame = new HashMap<>();
            this.zamf = false;
            this.zamg = null;
        }

        @KeepForSdk
        public DataHolder build(int i2) {
            return new DataHolder(this, i2, (Bundle) null, (zab) null);
        }

        @KeepForSdk
        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zaa((HashMap<String, Object>) hashMap);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.common.data.DataHolder.Builder zaa(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                com.google.android.gms.common.internal.Asserts.checkNotNull(r5)
                java.lang.String r0 = r4.zamd
                r1 = -1
                if (r0 != 0) goto L_0x000a
            L_0x0008:
                r0 = -1
                goto L_0x002f
            L_0x000a:
                java.lang.Object r0 = r5.get(r0)
                if (r0 != 0) goto L_0x0011
                goto L_0x0008
            L_0x0011:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.zame
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 != 0) goto L_0x002b
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.zame
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r4.zamc
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
                goto L_0x0008
            L_0x002b:
                int r0 = r2.intValue()
            L_0x002f:
                if (r0 != r1) goto L_0x0037
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.zamc
                r0.add(r5)
                goto L_0x0041
            L_0x0037:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.zamc
                r1.remove(r0)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.zamc
                r1.add(r0, r5)
            L_0x0041:
                r5 = 0
                r4.zamf = r5
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.Builder.zaa(java.util.HashMap):com.google.android.gms.common.data.DataHolder$Builder");
        }

        @KeepForSdk
        public DataHolder build(int i2, Bundle bundle) {
            return new DataHolder(this, i2, bundle, -1, (zab) null);
        }

        public /* synthetic */ Builder(String[] strArr, String str, zab zab) {
            this(strArr, (String) null);
        }
    }

    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.mClosed = false;
        this.zama = true;
        this.zali = i2;
        this.zalt = strArr;
        this.zalv = cursorWindowArr;
        this.zalw = i3;
        this.zalx = bundle;
    }

    @KeepForSdk
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null, (zab) null);
    }

    @KeepForSdk
    public static DataHolder empty(int i2) {
        return new DataHolder(zamb, i2, (Bundle) null);
    }

    /* JADX INFO: finally extract failed */
    public static CursorWindow[] zaa(CursorWrapper cursorWrapper) {
        int i2;
        ArrayList arrayList = new ArrayList();
        try {
            int count = cursorWrapper.getCount();
            CursorWindow window = cursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i2 = 0;
            } else {
                window.acquireReference();
                cursorWrapper.setWindow((CursorWindow) null);
                arrayList.add(window);
                i2 = window.getNumRows();
            }
            while (i2 < count && cursorWrapper.moveToPosition(i2)) {
                CursorWindow window2 = cursorWrapper.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    cursorWrapper.setWindow((CursorWindow) null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i2);
                    cursorWrapper.fillWindow(i2, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i2 = window2.getStartPosition() + window2.getNumRows();
            }
            cursorWrapper.close();
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th2) {
            cursorWrapper.close();
            throw th2;
        }
    }

    @KeepForSdk
    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zalv) {
                    close.close();
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.zama && this.zalv.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + IChannelPay.ID_BANK_CARD_PAY);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                sb.toString();
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public final boolean getBoolean(String str, int i2, int i3) {
        zaa(str, i2);
        return Long.valueOf(this.zalv[i3].getLong(i2, this.zalu.getInt(str))).longValue() == 1;
    }

    @KeepForSdk
    public final byte[] getByteArray(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].getBlob(i2, this.zalu.getInt(str));
    }

    @KeepForSdk
    public final int getCount() {
        return this.zalz;
    }

    @KeepForSdk
    public final int getInteger(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].getInt(i2, this.zalu.getInt(str));
    }

    @KeepForSdk
    public final long getLong(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].getLong(i2, this.zalu.getInt(str));
    }

    @KeepForSdk
    public final Bundle getMetadata() {
        return this.zalx;
    }

    @KeepForSdk
    public final int getStatusCode() {
        return this.zalw;
    }

    @KeepForSdk
    public final String getString(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].getString(i2, this.zalu.getInt(str));
    }

    @KeepForSdk
    public final int getWindowIndex(int i2) {
        int i3 = 0;
        Preconditions.checkState(i2 >= 0 && i2 < this.zalz);
        while (true) {
            int[] iArr = this.zaly;
            if (i3 >= iArr.length) {
                break;
            } else if (i2 < iArr[i3]) {
                i3--;
                break;
            } else {
                i3++;
            }
        }
        return i3 == this.zaly.length ? i3 - 1 : i3;
    }

    @KeepForSdk
    public final boolean hasColumn(String str) {
        return this.zalu.containsKey(str);
    }

    @KeepForSdk
    public final boolean hasNull(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].isNull(i2, this.zalu.getInt(str));
    }

    @KeepForSdk
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zalt, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zalv, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zali);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    public final double zab(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].getDouble(i2, this.zalu.getInt(str));
    }

    public final void zaby() {
        this.zalu = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.zalt;
            if (i3 >= strArr.length) {
                break;
            }
            this.zalu.putInt(strArr[i3], i3);
            i3++;
        }
        this.zaly = new int[this.zalv.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zalv;
            if (i2 < cursorWindowArr.length) {
                this.zaly[i2] = i4;
                i4 += this.zalv[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.zalz = i4;
                return;
            }
        }
    }

    @KeepForSdk
    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zama = true;
        this.zali = 1;
        this.zalt = (String[]) Preconditions.checkNotNull(strArr);
        this.zalv = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zalw = i2;
        this.zalx = bundle;
        zaby();
    }

    public DataHolder(CursorWrapper cursorWrapper, int i2, Bundle bundle) {
        this(cursorWrapper.getColumnNames(), zaa(cursorWrapper), i2, bundle);
    }

    @KeepForSdk
    public DataHolder(Cursor cursor, int i2, Bundle bundle) {
        this(new CursorWrapper(cursor), i2, bundle);
    }

    public DataHolder(Builder builder, int i2, Bundle bundle) {
        this(builder.zalt, zaa(builder, -1), i2, (Bundle) null);
    }

    public DataHolder(Builder builder, int i2, Bundle bundle, int i3) {
        this(builder.zalt, zaa(builder, -1), i2, bundle);
    }

    public /* synthetic */ DataHolder(Builder builder, int i2, Bundle bundle, zab zab) {
        this(builder, i2, (Bundle) null);
    }

    public static CursorWindow[] zaa(Builder builder, int i2) {
        List list;
        if (builder.zalt.length == 0) {
            return new CursorWindow[0];
        }
        if (i2 < 0 || i2 >= builder.zamc.size()) {
            list = builder.zamc;
        } else {
            list = builder.zamc.subList(0, i2);
        }
        int size = list.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zalt.length);
        int i3 = 0;
        boolean z = false;
        while (i3 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i3);
                    sb.append(")");
                    sb.toString();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.zalt.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) list.get(i3);
                boolean z2 = true;
                for (int i4 = 0; i4 < builder.zalt.length && z2; i4++) {
                    String str = builder.zalt[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z2 = cursorWindow.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z2 = cursorWindow.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z2 = cursorWindow.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z2 = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z2 = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z2 = cursorWindow.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        z2 = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else if (obj instanceof Float) {
                        z2 = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i4);
                    } else {
                        String valueOf = String.valueOf(obj);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length());
                        sb2.append("Unsupported object for column ");
                        sb2.append(str);
                        sb2.append(": ");
                        sb2.append(valueOf);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                if (z2) {
                    z = false;
                } else if (!z) {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i3);
                    sb3.append(" - allocating new window.");
                    sb3.toString();
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(builder.zalt.length);
                    arrayList.add(cursorWindow);
                    i3--;
                    z = true;
                } else {
                    throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
                i3++;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public /* synthetic */ DataHolder(Builder builder, int i2, Bundle bundle, int i3, zab zab) {
        this(builder, i2, bundle, -1);
    }

    private final void zaa(String str, int i2) {
        Bundle bundle = this.zalu;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i2 < 0 || i2 >= this.zalz) {
            throw new CursorIndexOutOfBoundsException(i2, this.zalz);
        }
    }

    public final float zaa(String str, int i2, int i3) {
        zaa(str, i2);
        return this.zalv[i3].getFloat(i2, this.zalu.getInt(str));
    }

    public final void zaa(String str, int i2, int i3, CharArrayBuffer charArrayBuffer) {
        zaa(str, i2);
        this.zalv[i3].copyStringToBuffer(i2, this.zalu.getInt(str), charArrayBuffer);
    }
}
