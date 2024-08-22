package androidx.biometric;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

public class BiometricManager {
    public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1;
    public static final int BIOMETRIC_ERROR_NONE_ENROLLED = 11;
    public static final int BIOMETRIC_ERROR_NO_HARDWARE = 12;
    public static final int BIOMETRIC_SUCCESS = 0;
    public final android.hardware.biometrics.BiometricManager mBiometricManager;
    public final FingerprintManagerCompat mFingerprintManager;

    @RequiresApi(29)
    public static class Api29Impl {
        public static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        @NonNull
        public static android.hardware.biometrics.BiometricManager create(Context context) {
            return (android.hardware.biometrics.BiometricManager) context.getSystemService(android.hardware.biometrics.BiometricManager.class);
        }
    }

    public BiometricManager(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mBiometricManager = Api29Impl.create(context);
            this.mFingerprintManager = null;
            return;
        }
        this.mBiometricManager = null;
        this.mFingerprintManager = FingerprintManagerCompat.from(context);
    }

    @NonNull
    public static BiometricManager from(@NonNull Context context) {
        return new BiometricManager(context);
    }

    public int canAuthenticate() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.canAuthenticate(this.mBiometricManager);
        }
        if (!this.mFingerprintManager.isHardwareDetected()) {
            return 12;
        }
        return !this.mFingerprintManager.hasEnrolledFingerprints() ? 11 : 0;
    }

    @RequiresApi(29)
    @VisibleForTesting
    public BiometricManager(android.hardware.biometrics.BiometricManager biometricManager) {
        this.mBiometricManager = biometricManager;
        this.mFingerprintManager = null;
    }
}
