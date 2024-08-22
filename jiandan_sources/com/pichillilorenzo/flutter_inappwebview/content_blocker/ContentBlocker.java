package com.pichillilorenzo.flutter_inappwebview.content_blocker;

import androidx.annotation.NonNull;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ContentBlocker {
    @NonNull
    public ContentBlockerAction action;
    @NonNull
    public ContentBlockerTrigger trigger;

    public ContentBlocker(@NonNull ContentBlockerTrigger contentBlockerTrigger, @NonNull ContentBlockerAction contentBlockerAction) {
        this.trigger = contentBlockerTrigger;
        this.action = contentBlockerAction;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentBlocker.class != obj.getClass()) {
            return false;
        }
        ContentBlocker contentBlocker = (ContentBlocker) obj;
        if (!this.trigger.equals(contentBlocker.trigger)) {
            return false;
        }
        return this.action.equals(contentBlocker.action);
    }

    @NonNull
    public ContentBlockerAction getAction() {
        return this.action;
    }

    @NonNull
    public ContentBlockerTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        return (this.trigger.hashCode() * 31) + this.action.hashCode();
    }

    public void setAction(@NonNull ContentBlockerAction contentBlockerAction) {
        this.action = contentBlockerAction;
    }

    public void setTrigger(@NonNull ContentBlockerTrigger contentBlockerTrigger) {
        this.trigger = contentBlockerTrigger;
    }

    public String toString() {
        return "ContentBlocker{trigger=" + this.trigger + ", action=" + this.action + ExtendedMessageFormat.END_FE;
    }
}
