package com.mars.kotlin.extension;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/mars/kotlin/extension/IntentScope;", "", "", "value", "", "minus", "(Ljava/lang/String;Ljava/lang/Object;)V", "Landroid/content/Intent;", "values", "Landroid/content/Intent;", "<init>", "(Landroid/content/Intent;)V", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class IntentScope {
    public final Intent values;

    public IntentScope(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SavedStateHandle.VALUES);
        this.values = intent;
    }

    public final void minus(@Nullable String str, @Nullable Object obj) {
        if (obj != null) {
            if (obj instanceof Boolean) {
                this.values.putExtra(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Character) {
                this.values.putExtra(str, ((Character) obj).charValue());
            } else if (obj instanceof Integer) {
                this.values.putExtra(str, ((Number) obj).intValue());
            } else if (obj instanceof Byte) {
                this.values.putExtra(str, ((Number) obj).byteValue());
            } else if (obj instanceof Short) {
                this.values.putExtra(str, ((Number) obj).shortValue());
            } else if (obj instanceof Long) {
                this.values.putExtra(str, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                this.values.putExtra(str, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                this.values.putExtra(str, ((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                this.values.putExtra(str, (String) obj);
            } else if (obj instanceof CharSequence) {
                this.values.putExtra(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                this.values.putExtra(str, (Parcelable) obj);
            } else if (obj instanceof Bundle) {
                this.values.putExtra(str, (Bundle) obj);
            } else if (obj instanceof boolean[]) {
                this.values.putExtra(str, (boolean[]) obj);
            } else if (obj instanceof char[]) {
                this.values.putExtra(str, (char[]) obj);
            } else if (obj instanceof int[]) {
                this.values.putExtra(str, (int[]) obj);
            } else if (obj instanceof byte[]) {
                this.values.putExtra(str, (byte[]) obj);
            } else if (obj instanceof short[]) {
                this.values.putExtra(str, (short[]) obj);
            } else if (obj instanceof long[]) {
                this.values.putExtra(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                this.values.putExtra(str, (float[]) obj);
            } else if (obj instanceof double[]) {
                this.values.putExtra(str, (double[]) obj);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr instanceof String[]) {
                    Intent intent = this.values;
                    if (!(obj instanceof String[])) {
                        obj = null;
                    }
                    intent.putExtra(str, (String[]) obj);
                } else if (objArr instanceof CharSequence[]) {
                    Intent intent2 = this.values;
                    if (!(obj instanceof CharSequence[])) {
                        obj = null;
                    }
                    intent2.putExtra(str, (CharSequence[]) obj);
                } else if (objArr instanceof Parcelable[]) {
                    Intent intent3 = this.values;
                    if (!(obj instanceof Parcelable[])) {
                        obj = null;
                    }
                    intent3.putExtra(str, (Parcelable[]) obj);
                }
            } else {
                boolean z = obj instanceof ArrayList;
                if (z) {
                    if (!((Collection) obj).isEmpty()) {
                        Object obj2 = ((ArrayList) obj).get(0);
                        if (obj2 instanceof Integer) {
                            Intent intent4 = this.values;
                            if (!z) {
                                obj = null;
                            }
                            intent4.putIntegerArrayListExtra(str, (ArrayList) obj);
                        } else if (obj2 instanceof String) {
                            Intent intent5 = this.values;
                            if (!z) {
                                obj = null;
                            }
                            intent5.putStringArrayListExtra(str, (ArrayList) obj);
                        } else if (obj2 instanceof CharSequence) {
                            Intent intent6 = this.values;
                            if (!z) {
                                obj = null;
                            }
                            intent6.putCharSequenceArrayListExtra(str, (ArrayList) obj);
                        } else if (obj2 instanceof Parcelable) {
                            Intent intent7 = this.values;
                            if (!z) {
                                obj = null;
                            }
                            intent7.putParcelableArrayListExtra(str, (ArrayList) obj);
                        } else {
                            LoggerKt.e$default("Intent cannot put " + obj, (Object) null, 1, (Object) null);
                        }
                    } else {
                        Intent intent8 = this.values;
                        if (!z) {
                            obj = null;
                        }
                        intent8.putIntegerArrayListExtra(str, (ArrayList) obj);
                    }
                } else if (obj instanceof Serializable) {
                    this.values.putExtra(str, (Serializable) obj);
                } else {
                    LoggerKt.e$default("Intent cannot put " + obj, (Object) null, 1, (Object) null);
                }
            }
        }
    }
}
