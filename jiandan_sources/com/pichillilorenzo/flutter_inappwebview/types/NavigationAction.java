package com.pichillilorenzo.flutter_inappwebview.types;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class NavigationAction {
    public boolean hasGesture;
    public boolean isForMainFrame;
    public boolean isRedirect;
    public URLRequest request;

    public NavigationAction(URLRequest uRLRequest, boolean z, boolean z2, boolean z3) {
        this.request = uRLRequest;
        this.isForMainFrame = z;
        this.hasGesture = z2;
        this.isRedirect = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NavigationAction navigationAction = (NavigationAction) obj;
        if (this.isForMainFrame == navigationAction.isForMainFrame && this.hasGesture == navigationAction.hasGesture && this.isRedirect == navigationAction.isRedirect) {
            return this.request.equals(navigationAction.request);
        }
        return false;
    }

    public URLRequest getRequest() {
        return this.request;
    }

    public int hashCode() {
        return (((((this.request.hashCode() * 31) + (this.isForMainFrame ? 1 : 0)) * 31) + (this.hasGesture ? 1 : 0)) * 31) + (this.isRedirect ? 1 : 0);
    }

    public boolean isForMainFrame() {
        return this.isForMainFrame;
    }

    public boolean isHasGesture() {
        return this.hasGesture;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public void setForMainFrame(boolean z) {
        this.isForMainFrame = z;
    }

    public void setHasGesture(boolean z) {
        this.hasGesture = z;
    }

    public void setRedirect(boolean z) {
        this.isRedirect = z;
    }

    public void setRequest(URLRequest uRLRequest) {
        this.request = uRLRequest;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("request", this.request.toMap());
        hashMap.put("isForMainFrame", Boolean.valueOf(this.isForMainFrame));
        hashMap.put("androidHasGesture", Boolean.valueOf(this.hasGesture));
        hashMap.put("androidIsRedirect", Boolean.valueOf(this.isRedirect));
        return hashMap;
    }

    public String toString() {
        return "NavigationAction{request=" + this.request + ", isForMainFrame=" + this.isForMainFrame + ", hasGesture=" + this.hasGesture + ", isRedirect=" + this.isRedirect + ExtendedMessageFormat.END_FE;
    }
}
