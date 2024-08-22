package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompatJellybean;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class CustomTabsMenuItem {
    public int id;
    @NonNull
    public String label;

    public CustomTabsMenuItem(int i2, @NonNull String str) {
        this.id = i2;
        this.label = str;
    }

    @Nullable
    public static CustomTabsMenuItem fromMap(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new CustomTabsMenuItem(((Integer) map.get("id")).intValue(), (String) map.get(NotificationCompatJellybean.KEY_LABEL));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CustomTabsMenuItem.class != obj.getClass()) {
            return false;
        }
        CustomTabsMenuItem customTabsMenuItem = (CustomTabsMenuItem) obj;
        if (this.id != customTabsMenuItem.id) {
            return false;
        }
        return this.label.equals(customTabsMenuItem.label);
    }

    public int getId() {
        return this.id;
    }

    @NonNull
    public String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return (this.id * 31) + this.label.hashCode();
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setLabel(@NonNull String str) {
        this.label = str;
    }

    public String toString() {
        return "CustomTabsMenuItem{id=" + this.id + ", label='" + this.label + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
