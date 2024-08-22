package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.biometric.BiometricPrompt;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class CustomTabsActionButton {
    @NonNull
    public String description;
    @NonNull
    public byte[] icon;
    public int id;
    public boolean shouldTint;

    public CustomTabsActionButton(int i2, @NonNull byte[] bArr, @NonNull String str, boolean z) {
        this.id = i2;
        this.icon = bArr;
        this.description = str;
        this.shouldTint = z;
    }

    @Nullable
    public static CustomTabsActionButton fromMap(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new CustomTabsActionButton(((Integer) map.get("id")).intValue(), (byte[]) map.get("icon"), (String) map.get(BiometricPrompt.KEY_DESCRIPTION), ((Boolean) map.get("shouldTint")).booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CustomTabsActionButton.class != obj.getClass()) {
            return false;
        }
        CustomTabsActionButton customTabsActionButton = (CustomTabsActionButton) obj;
        if (this.id == customTabsActionButton.id && this.shouldTint == customTabsActionButton.shouldTint && Arrays.equals(this.icon, customTabsActionButton.icon)) {
            return this.description.equals(customTabsActionButton.description);
        }
        return false;
    }

    @NonNull
    public String getDescription() {
        return this.description;
    }

    @NonNull
    public byte[] getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public int hashCode() {
        return (((((this.id * 31) + Arrays.hashCode(this.icon)) * 31) + this.description.hashCode()) * 31) + (this.shouldTint ? 1 : 0);
    }

    public boolean isShouldTint() {
        return this.shouldTint;
    }

    public void setDescription(@NonNull String str) {
        this.description = str;
    }

    public void setIcon(@NonNull byte[] bArr) {
        this.icon = bArr;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setShouldTint(boolean z) {
        this.shouldTint = z;
    }

    public String toString() {
        return "CustomTabsActionButton{id=" + this.id + ", icon=" + Arrays.toString(this.icon) + ", description='" + this.description + ExtendedMessageFormat.QUOTE + ", shouldTint=" + this.shouldTint + ExtendedMessageFormat.END_FE;
    }
}
