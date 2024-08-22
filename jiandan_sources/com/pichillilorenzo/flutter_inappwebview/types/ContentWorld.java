package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ubc.UBCManager;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ContentWorld {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ContentWorld DEFAULT_CLIENT = new ContentWorld("defaultClient");
    public static final ContentWorld PAGE = new ContentWorld(UBCManager.CONTENT_KEY_PAGE);
    @NonNull
    public String name;

    public ContentWorld(@NonNull String str) {
        this.name = str;
    }

    @Nullable
    public static ContentWorld fromMap(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new ContentWorld((String) map.get("name"));
    }

    public static ContentWorld world(@NonNull String str) {
        return new ContentWorld(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentWorld.class != obj.getClass()) {
            return false;
        }
        return this.name.equals(((ContentWorld) obj).name);
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    public String toString() {
        return "ContentWorld{name='" + this.name + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
