package com.baidu.searchbox.text;

import android.content.Context;
import android.content.Intent;

public interface IPrivacyLinkContext {
    public static final IPrivacyLinkContext EMPTY = new IPrivacyLinkContext() {
        public Intent buildPrivacyPolicyIntent(Context context) {
            return null;
        }

        public Intent buildServiceProtocolIntent(Context context) {
            return null;
        }

        public Intent buildPrivacyPolicyIntentWithBdWebview(Context context) {
            return null;
        }

        public Intent buildServiceProtocolIntentWithBdWebview(Context context) {
            return null;
        }
    };

    Intent buildPrivacyPolicyIntent(Context context);

    Intent buildPrivacyPolicyIntentWithBdWebview(Context context);

    Intent buildServiceProtocolIntent(Context context);

    Intent buildServiceProtocolIntentWithBdWebview(Context context);

    public static final class Impl {
        private static IPrivacyLinkContext sPrivacyLinkContext = PrivacyLinkRuntime.getPrivactModeContext();

        public static IPrivacyLinkContext get() {
            if (sPrivacyLinkContext == null) {
                sPrivacyLinkContext = IPrivacyLinkContext.EMPTY;
            }
            return sPrivacyLinkContext;
        }
    }
}
