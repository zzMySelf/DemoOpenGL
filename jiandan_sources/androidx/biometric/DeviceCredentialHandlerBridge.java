package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceCredentialHandlerBridge {
    public static final int IGNORING_NEXT_RESET = 1;
    public static final int IGNORING_RESET = 2;
    public static final int NOT_IGNORING_RESET = 0;
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_NONE = 0;
    public static final int RESULT_SUCCESS = 1;
    @Nullable
    public static DeviceCredentialHandlerBridge sInstance;
    @Nullable
    public BiometricPrompt.AuthenticationCallback mAuthenticationCallback;
    @Nullable
    public BiometricFragment mBiometricFragment;
    public int mClientThemeResId;
    public boolean mConfirmingDeviceCredential;
    public int mDeviceCredentialResult = 0;
    @Nullable
    public Executor mExecutor;
    @Nullable
    public FingerprintDialogFragment mFingerprintDialogFragment;
    @Nullable
    public FingerprintHelperFragment mFingerprintHelperFragment;
    public int mIgnoreResetState = 0;
    @Nullable
    public DialogInterface.OnClickListener mOnClickListener;

    @NonNull
    public static DeviceCredentialHandlerBridge getInstance() {
        if (sInstance == null) {
            sInstance = new DeviceCredentialHandlerBridge();
        }
        return sInstance;
    }

    @Nullable
    public static DeviceCredentialHandlerBridge getInstanceIfNotNull() {
        return sInstance;
    }

    @Nullable
    public BiometricPrompt.AuthenticationCallback getAuthenticationCallback() {
        return this.mAuthenticationCallback;
    }

    @Nullable
    public BiometricFragment getBiometricFragment() {
        return this.mBiometricFragment;
    }

    public int getClientThemeResId() {
        return this.mClientThemeResId;
    }

    public int getDeviceCredentialResult() {
        return this.mDeviceCredentialResult;
    }

    @Nullable
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Nullable
    public FingerprintDialogFragment getFingerprintDialogFragment() {
        return this.mFingerprintDialogFragment;
    }

    @Nullable
    public FingerprintHelperFragment getFingerprintHelperFragment() {
        return this.mFingerprintHelperFragment;
    }

    @Nullable
    public DialogInterface.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public void ignoreNextReset() {
        if (this.mIgnoreResetState == 0) {
            this.mIgnoreResetState = 1;
        }
    }

    public boolean isConfirmingDeviceCredential() {
        return this.mConfirmingDeviceCredential;
    }

    public void reset() {
        int i2 = this.mIgnoreResetState;
        if (i2 != 2) {
            if (i2 == 1) {
                stopIgnoringReset();
                return;
            }
            this.mClientThemeResId = 0;
            this.mBiometricFragment = null;
            this.mFingerprintDialogFragment = null;
            this.mFingerprintHelperFragment = null;
            this.mExecutor = null;
            this.mOnClickListener = null;
            this.mAuthenticationCallback = null;
            this.mDeviceCredentialResult = 0;
            this.mConfirmingDeviceCredential = false;
            sInstance = null;
        }
    }

    public void setBiometricFragment(@Nullable BiometricFragment biometricFragment) {
        this.mBiometricFragment = biometricFragment;
    }

    @SuppressLint({"LambdaLast"})
    public void setCallbacks(@NonNull Executor executor, @NonNull DialogInterface.OnClickListener onClickListener, @NonNull BiometricPrompt.AuthenticationCallback authenticationCallback) {
        this.mExecutor = executor;
        this.mOnClickListener = onClickListener;
        this.mAuthenticationCallback = authenticationCallback;
        BiometricFragment biometricFragment = this.mBiometricFragment;
        if (biometricFragment == null || Build.VERSION.SDK_INT < 28) {
            FingerprintDialogFragment fingerprintDialogFragment = this.mFingerprintDialogFragment;
            if (fingerprintDialogFragment != null && this.mFingerprintHelperFragment != null) {
                fingerprintDialogFragment.setNegativeButtonListener(onClickListener);
                this.mFingerprintHelperFragment.setCallback(executor, authenticationCallback);
                this.mFingerprintHelperFragment.setHandler(this.mFingerprintDialogFragment.getHandler());
                return;
            }
            return;
        }
        biometricFragment.setCallbacks(executor, onClickListener, authenticationCallback);
    }

    public void setClientThemeResId(int i2) {
        this.mClientThemeResId = i2;
    }

    public void setConfirmingDeviceCredential(boolean z) {
        this.mConfirmingDeviceCredential = z;
    }

    public void setDeviceCredentialResult(int i2) {
        this.mDeviceCredentialResult = i2;
    }

    public void setFingerprintFragments(@Nullable FingerprintDialogFragment fingerprintDialogFragment, @Nullable FingerprintHelperFragment fingerprintHelperFragment) {
        this.mFingerprintDialogFragment = fingerprintDialogFragment;
        this.mFingerprintHelperFragment = fingerprintHelperFragment;
    }

    public void startIgnoringReset() {
        this.mIgnoreResetState = 2;
    }

    public void stopIgnoringReset() {
        this.mIgnoreResetState = 0;
    }
}
