package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PluginScript extends UserScript {
    public boolean requiredInAllContentWorlds;

    public PluginScript(@Nullable String str, @NonNull String str2, @NonNull UserScriptInjectionTime userScriptInjectionTime, @Nullable ContentWorld contentWorld, boolean z) {
        super(str, str2, userScriptInjectionTime, contentWorld);
        this.requiredInAllContentWorlds = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && PluginScript.class == obj.getClass() && super.equals(obj) && this.requiredInAllContentWorlds == ((PluginScript) obj).requiredInAllContentWorlds;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.requiredInAllContentWorlds ? 1 : 0);
    }

    public boolean isRequiredInAllContentWorlds() {
        return this.requiredInAllContentWorlds;
    }

    public void setRequiredInAllContentWorlds(boolean z) {
        this.requiredInAllContentWorlds = z;
    }

    public String toString() {
        return "PluginScript{requiredInContentWorld=" + this.requiredInAllContentWorlds + "} " + super.toString();
    }
}
