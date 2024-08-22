package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Strings;

@GwtCompatible(emulated = true)
public final class Platform {
    public static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";

    public static void checkGwtRpcEnabled() {
        if (!Boolean.parseBoolean(System.getProperty("guava.gwt.emergency_reenable_rpc", "true"))) {
            throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", "guava.gwt.emergency_reenable_rpc", "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"));
        }
    }
}
