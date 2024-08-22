package com.baidu.common.operation;

import android.graphics.drawable.Drawable;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/baidu/common/operation/NewHomeSkinDrawableModel;", "", "mKey", "", "mDrawable", "Landroid/graphics/drawable/Drawable;", "mPath", "mIsSrcNit", "", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Z)V", "getMDrawable", "()Landroid/graphics/drawable/Drawable;", "setMDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getMIsSrcNit", "()Z", "setMIsSrcNit", "(Z)V", "getMKey", "()Ljava/lang/String;", "setMKey", "(Ljava/lang/String;)V", "getMPath", "setMPath", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "lib-common-operation-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeSkinDrawableModel.kt */
public final class NewHomeSkinDrawableModel {
    private Drawable mDrawable;
    private boolean mIsSrcNit;
    private String mKey;
    private String mPath;

    public static /* synthetic */ NewHomeSkinDrawableModel copy$default(NewHomeSkinDrawableModel newHomeSkinDrawableModel, String str, Drawable drawable, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = newHomeSkinDrawableModel.mKey;
        }
        if ((i2 & 2) != 0) {
            drawable = newHomeSkinDrawableModel.mDrawable;
        }
        if ((i2 & 4) != 0) {
            str2 = newHomeSkinDrawableModel.mPath;
        }
        if ((i2 & 8) != 0) {
            z = newHomeSkinDrawableModel.mIsSrcNit;
        }
        return newHomeSkinDrawableModel.copy(str, drawable, str2, z);
    }

    public final String component1() {
        return this.mKey;
    }

    public final Drawable component2() {
        return this.mDrawable;
    }

    public final String component3() {
        return this.mPath;
    }

    public final boolean component4() {
        return this.mIsSrcNit;
    }

    public final NewHomeSkinDrawableModel copy(String str, Drawable drawable, String str2, boolean z) {
        return new NewHomeSkinDrawableModel(str, drawable, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewHomeSkinDrawableModel)) {
            return false;
        }
        NewHomeSkinDrawableModel newHomeSkinDrawableModel = (NewHomeSkinDrawableModel) obj;
        return Intrinsics.areEqual((Object) this.mKey, (Object) newHomeSkinDrawableModel.mKey) && Intrinsics.areEqual((Object) this.mDrawable, (Object) newHomeSkinDrawableModel.mDrawable) && Intrinsics.areEqual((Object) this.mPath, (Object) newHomeSkinDrawableModel.mPath) && this.mIsSrcNit == newHomeSkinDrawableModel.mIsSrcNit;
    }

    public int hashCode() {
        String str = this.mKey;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Drawable drawable = this.mDrawable;
        int hashCode2 = (hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
        String str2 = this.mPath;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.mIsSrcNit;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public String toString() {
        return "NewHomeSkinDrawableModel(mKey=" + this.mKey + ", mDrawable=" + this.mDrawable + ", mPath=" + this.mPath + ", mIsSrcNit=" + this.mIsSrcNit + ')';
    }

    public NewHomeSkinDrawableModel(String mKey2, Drawable mDrawable2, String mPath2, boolean mIsSrcNit2) {
        this.mKey = mKey2;
        this.mDrawable = mDrawable2;
        this.mPath = mPath2;
        this.mIsSrcNit = mIsSrcNit2;
    }

    public final String getMKey() {
        return this.mKey;
    }

    public final void setMKey(String str) {
        this.mKey = str;
    }

    public final Drawable getMDrawable() {
        return this.mDrawable;
    }

    public final void setMDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public final String getMPath() {
        return this.mPath;
    }

    public final void setMPath(String str) {
        this.mPath = str;
    }

    public final boolean getMIsSrcNit() {
        return this.mIsSrcNit;
    }

    public final void setMIsSrcNit(boolean z) {
        this.mIsSrcNit = z;
    }
}
