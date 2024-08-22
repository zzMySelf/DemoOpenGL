package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ubc.UBCManager;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class UserScript {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    @NonNull
    public ContentWorld contentWorld;
    @Nullable
    public String groupName;
    @NonNull
    public UserScriptInjectionTime injectionTime;
    @NonNull
    public String source;

    public UserScript(@Nullable String str, @NonNull String str2, @NonNull UserScriptInjectionTime userScriptInjectionTime, @Nullable ContentWorld contentWorld2) {
        this.groupName = str;
        this.source = str2;
        this.injectionTime = userScriptInjectionTime;
        this.contentWorld = contentWorld2 == null ? ContentWorld.PAGE : contentWorld2;
    }

    @Nullable
    public static UserScript fromMap(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new UserScript((String) map.get("groupName"), (String) map.get(UBCManager.CONTENT_KEY_SOURCE), UserScriptInjectionTime.fromValue(((Integer) map.get("injectionTime")).intValue()), ContentWorld.fromMap((Map) map.get("contentWorld")));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserScript userScript = (UserScript) obj;
        String str = this.groupName;
        if (str == null ? userScript.groupName != null : !str.equals(userScript.groupName)) {
            return false;
        }
        if (this.source.equals(userScript.source) && this.injectionTime == userScript.injectionTime) {
            return this.contentWorld.equals(userScript.contentWorld);
        }
        return false;
    }

    @NonNull
    public ContentWorld getContentWorld() {
        return this.contentWorld;
    }

    @Nullable
    public String getGroupName() {
        return this.groupName;
    }

    @NonNull
    public UserScriptInjectionTime getInjectionTime() {
        return this.injectionTime;
    }

    @NonNull
    public String getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.groupName;
        return ((((((str != null ? str.hashCode() : 0) * 31) + this.source.hashCode()) * 31) + this.injectionTime.hashCode()) * 31) + this.contentWorld.hashCode();
    }

    public void setContentWorld(@Nullable ContentWorld contentWorld2) {
        if (contentWorld2 == null) {
            contentWorld2 = ContentWorld.PAGE;
        }
        this.contentWorld = contentWorld2;
    }

    public void setGroupName(@Nullable String str) {
        this.groupName = str;
    }

    public void setInjectionTime(@NonNull UserScriptInjectionTime userScriptInjectionTime) {
        this.injectionTime = userScriptInjectionTime;
    }

    public void setSource(@NonNull String str) {
        this.source = str;
    }

    public String toString() {
        return "UserScript{groupName='" + this.groupName + ExtendedMessageFormat.QUOTE + ", source='" + this.source + ExtendedMessageFormat.QUOTE + ", injectionTime=" + this.injectionTime + ", contentWorld=" + this.contentWorld + ExtendedMessageFormat.END_FE;
    }
}
