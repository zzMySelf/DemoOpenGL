package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class Utils {
    public static boolean isConfirmingDeviceCredential() {
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        return instanceIfNotNull != null && instanceIfNotNull.isConfirmingDeviceCredential();
    }

    public static boolean isModelInPrefixList(@NonNull Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String startsWith : context.getResources().getStringArray(i2)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnknownError(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return false;
            default:
                return true;
        }
    }

    public static boolean isVendorInList(@NonNull Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String equalsIgnoreCase : context.getResources().getStringArray(i2)) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(21)
    public static void launchDeviceCredentialConfirmation(@NonNull String str, @Nullable FragmentActivity fragmentActivity, @Nullable Bundle bundle, @Nullable Runnable runnable) {
        KeyguardManager keyguardManager;
        CharSequence charSequence;
        if (fragmentActivity instanceof DeviceCredentialHandlerActivity) {
            DeviceCredentialHandlerActivity deviceCredentialHandlerActivity = (DeviceCredentialHandlerActivity) fragmentActivity;
            if (Build.VERSION.SDK_INT >= 23) {
                keyguardManager = (KeyguardManager) deviceCredentialHandlerActivity.getSystemService(KeyguardManager.class);
            } else {
                Object systemService = deviceCredentialHandlerActivity.getSystemService("keyguard");
                if (!(systemService instanceof KeyguardManager)) {
                    deviceCredentialHandlerActivity.handleDeviceCredentialResult(0);
                    return;
                }
                keyguardManager = (KeyguardManager) systemService;
            }
            if (keyguardManager == null) {
                deviceCredentialHandlerActivity.handleDeviceCredentialResult(0);
                return;
            }
            CharSequence charSequence2 = null;
            if (bundle != null) {
                charSequence2 = bundle.getCharSequence("title");
                charSequence = bundle.getCharSequence(BiometricPrompt.KEY_SUBTITLE);
            } else {
                charSequence = null;
            }
            Intent createConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(charSequence2, charSequence);
            if (createConfirmDeviceCredentialIntent == null) {
                deviceCredentialHandlerActivity.handleDeviceCredentialResult(0);
                return;
            }
            DeviceCredentialHandlerBridge instance = DeviceCredentialHandlerBridge.getInstance();
            instance.setConfirmingDeviceCredential(true);
            instance.startIgnoringReset();
            if (runnable != null) {
                runnable.run();
            }
            createConfirmDeviceCredentialIntent.setFlags(134742016);
            deviceCredentialHandlerActivity.startActivityForResult(createConfirmDeviceCredentialIntent, 0);
        }
    }

    public static void maybeFinishHandler(@Nullable FragmentActivity fragmentActivity) {
        if ((fragmentActivity instanceof DeviceCredentialHandlerActivity) && !fragmentActivity.isFinishing()) {
            fragmentActivity.finish();
        }
    }

    public static boolean shouldHideFingerprintDialog(@NonNull Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return isModelInPrefixList(context, str, R.array.hide_fingerprint_instantly_prefixes);
    }

    public static boolean shouldUseFingerprintForCrypto(@NonNull Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        if (isVendorInList(context, str, R.array.crypto_fingerprint_fallback_vendors) || isModelInPrefixList(context, str2, R.array.crypto_fingerprint_fallback_prefixes)) {
            return true;
        }
        return false;
    }
}
