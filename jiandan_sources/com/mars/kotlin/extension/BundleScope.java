package com.mars.kotlin.extension;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/mars/kotlin/extension/BundleScope;", "", "", "value", "", "minus", "(Ljava/lang/String;Ljava/lang/Object;)V", "Landroid/os/Bundle;", "values", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class BundleScope {
    public final Bundle values;

    public BundleScope(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, SavedStateHandle.VALUES);
        this.values = bundle;
    }

    public final void minus(@Nullable String str, @Nullable Object obj) {
        Object obj2;
        if (obj == null) {
            this.values.putString(str, (String) null);
        } else if (obj instanceof Boolean) {
            this.values.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Character) {
            this.values.putChar(str, ((Character) obj).charValue());
        } else if (obj instanceof Integer) {
            this.values.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Byte) {
            this.values.putByte(str, ((Number) obj).byteValue());
        } else if (obj instanceof Short) {
            this.values.putShort(str, ((Number) obj).shortValue());
        } else if (obj instanceof Long) {
            this.values.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof Float) {
            this.values.putFloat(str, ((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            this.values.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            this.values.putString(str, (String) obj);
        } else if (obj instanceof CharSequence) {
            this.values.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            this.values.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Bundle) {
            this.values.putBundle(str, (Bundle) obj);
        } else if (obj instanceof boolean[]) {
            this.values.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof char[]) {
            this.values.putCharArray(str, (char[]) obj);
        } else if (obj instanceof int[]) {
            this.values.putIntArray(str, (int[]) obj);
        } else if (obj instanceof byte[]) {
            this.values.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof short[]) {
            this.values.putShortArray(str, (short[]) obj);
        } else if (obj instanceof long[]) {
            this.values.putLongArray(str, (long[]) obj);
        } else if (obj instanceof float[]) {
            this.values.putFloatArray(str, (float[]) obj);
        } else if (obj instanceof double[]) {
            this.values.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof String[]) {
                Bundle bundle = this.values;
                if (!(obj instanceof String[])) {
                    obj = null;
                }
                bundle.putStringArray(str, (String[]) obj);
            } else if (objArr instanceof CharSequence[]) {
                Bundle bundle2 = this.values;
                if (!(obj instanceof CharSequence[])) {
                    obj = null;
                }
                bundle2.putCharSequenceArray(str, (CharSequence[]) obj);
            } else if (objArr instanceof Parcelable[]) {
                Bundle bundle3 = this.values;
                if (!(obj instanceof Parcelable[])) {
                    obj = null;
                }
                bundle3.putParcelableArray(str, (Parcelable[]) obj);
            } else if (objArr instanceof Serializable[]) {
                this.values.putSerializable(str, (Serializable) obj);
            } else {
                LoggerKt.e$default("unsupported type " + obj.getClass().getComponentType() + " to bundle", (Object) null, 1, (Object) null);
            }
        } else {
            boolean z = obj instanceof SparseArray;
            if (z) {
                Bundle bundle4 = this.values;
                if (!z) {
                    obj = null;
                }
                bundle4.putSparseParcelableArray(str, (SparseArray) obj);
                return;
            }
            boolean z2 = obj instanceof ArrayList;
            if (z2) {
                if (!((Collection) obj).isEmpty()) {
                    Object obj3 = ((ArrayList) obj).get(0);
                    if (obj3 instanceof Integer) {
                        Bundle bundle5 = this.values;
                        if (!z2) {
                            obj = null;
                        }
                        bundle5.putIntegerArrayList(str, (ArrayList) obj);
                        obj2 = Unit.INSTANCE;
                    } else if (obj3 instanceof String) {
                        Bundle bundle6 = this.values;
                        if (!z2) {
                            obj = null;
                        }
                        bundle6.putStringArrayList(str, (ArrayList) obj);
                        obj2 = Unit.INSTANCE;
                    } else if (obj3 instanceof CharSequence) {
                        Bundle bundle7 = this.values;
                        if (!z2) {
                            obj = null;
                        }
                        bundle7.putCharSequenceArrayList(str, (ArrayList) obj);
                        obj2 = Unit.INSTANCE;
                    } else if (obj3 instanceof Parcelable) {
                        Bundle bundle8 = this.values;
                        if (!z2) {
                            obj = null;
                        }
                        bundle8.putParcelableArrayList(str, (ArrayList) obj);
                        obj2 = Unit.INSTANCE;
                    } else {
                        obj2 = LoggerKt.e$default("Bundle cannot put " + obj, (Object) null, 1, (Object) null);
                    }
                    Unit unit = (Unit) obj2;
                }
            } else if (obj instanceof Serializable) {
                this.values.putSerializable(str, (Serializable) obj);
            } else if (Build.VERSION.SDK_INT >= 18 && (obj instanceof Binder)) {
                this.values.putBinder(str, (IBinder) obj);
            } else if (Build.VERSION.SDK_INT >= 21 && (obj instanceof Size)) {
                this.values.putSize(str, (Size) obj);
            } else if (Build.VERSION.SDK_INT < 21 || !(obj instanceof SizeF)) {
                LoggerKt.e$default("Bundle cannot put " + obj, (Object) null, 1, (Object) null);
            } else {
                this.values.putSizeF(str, (SizeF) obj);
            }
        }
    }
}
