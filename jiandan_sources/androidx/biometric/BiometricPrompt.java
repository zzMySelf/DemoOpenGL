package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"SyntheticAccessor"})
public class BiometricPrompt implements BiometricConstants {
    public static final String BIOMETRIC_FRAGMENT_TAG = "BiometricFragment";
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_FORCE_FINGERPRINT = false;
    public static final int DELAY_MILLIS = 500;
    public static final String DIALOG_FRAGMENT_TAG = "FingerprintDialogFragment";
    public static final String FINGERPRINT_HELPER_FRAGMENT_TAG = "FingerprintHelperFragment";
    public static final String KEY_ALLOW_DEVICE_CREDENTIAL = "allow_device_credential";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_HANDLING_DEVICE_CREDENTIAL_RESULT = "handling_device_credential_result";
    public static final String KEY_NEGATIVE_TEXT = "negative_text";
    public static final String KEY_REQUIRE_CONFIRMATION = "require_confirmation";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_TITLE = "title";
    public static final String TAG = "BiometricPromptCompat";
    public final AuthenticationCallback mAuthenticationCallback;
    public BiometricFragment mBiometricFragment;
    public final Executor mExecutor;
    public FingerprintDialogFragment mFingerprintDialogFragment;
    public FingerprintHelperFragment mFingerprintHelperFragment;
    public Fragment mFragment;
    public FragmentActivity mFragmentActivity;
    public boolean mIsHandlingDeviceCredential;
    public final LifecycleObserver mLifecycleObserver = new LifecycleObserver() {
        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            if (!BiometricPrompt.this.isChangingConfigurations()) {
                if (!BiometricPrompt.canUseBiometricFragment() || BiometricPrompt.this.mBiometricFragment == null) {
                    if (!(BiometricPrompt.this.mFingerprintDialogFragment == null || BiometricPrompt.this.mFingerprintHelperFragment == null)) {
                        BiometricPrompt.dismissFingerprintFragments(BiometricPrompt.this.mFingerprintDialogFragment, BiometricPrompt.this.mFingerprintHelperFragment);
                    }
                } else if (!BiometricPrompt.this.mBiometricFragment.isDeviceCredentialAllowed()) {
                    BiometricPrompt.this.mBiometricFragment.cancel();
                } else if (!BiometricPrompt.this.mPausedOnce) {
                    boolean unused = BiometricPrompt.this.mPausedOnce = true;
                } else {
                    BiometricPrompt.this.mBiometricFragment.cancel();
                }
                BiometricPrompt.this.maybeResetHandlerBridge();
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            BiometricFragment unused = BiometricPrompt.this.mBiometricFragment = BiometricPrompt.canUseBiometricFragment() ? (BiometricFragment) BiometricPrompt.this.getFragmentManager().findFragmentByTag("BiometricFragment") : null;
            if (!BiometricPrompt.canUseBiometricFragment() || BiometricPrompt.this.mBiometricFragment == null) {
                BiometricPrompt biometricPrompt = BiometricPrompt.this;
                FingerprintDialogFragment unused2 = biometricPrompt.mFingerprintDialogFragment = (FingerprintDialogFragment) biometricPrompt.getFragmentManager().findFragmentByTag(BiometricPrompt.DIALOG_FRAGMENT_TAG);
                BiometricPrompt biometricPrompt2 = BiometricPrompt.this;
                FingerprintHelperFragment unused3 = biometricPrompt2.mFingerprintHelperFragment = (FingerprintHelperFragment) biometricPrompt2.getFragmentManager().findFragmentByTag(BiometricPrompt.FINGERPRINT_HELPER_FRAGMENT_TAG);
                if (BiometricPrompt.this.mFingerprintDialogFragment != null) {
                    BiometricPrompt.this.mFingerprintDialogFragment.setNegativeButtonListener(BiometricPrompt.this.mNegativeButtonListener);
                }
                if (BiometricPrompt.this.mFingerprintHelperFragment != null) {
                    BiometricPrompt.this.mFingerprintHelperFragment.setCallback(BiometricPrompt.this.mExecutor, BiometricPrompt.this.mAuthenticationCallback);
                    if (BiometricPrompt.this.mFingerprintDialogFragment != null) {
                        BiometricPrompt.this.mFingerprintHelperFragment.setHandler(BiometricPrompt.this.mFingerprintDialogFragment.getHandler());
                    }
                }
            } else {
                BiometricPrompt.this.mBiometricFragment.setCallbacks(BiometricPrompt.this.mExecutor, BiometricPrompt.this.mNegativeButtonListener, BiometricPrompt.this.mAuthenticationCallback);
            }
            BiometricPrompt.this.maybeHandleDeviceCredentialResult();
            BiometricPrompt.this.maybeInitHandlerBridge(false);
        }
    };
    public final DialogInterface.OnClickListener mNegativeButtonListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i2) {
            BiometricPrompt.this.mExecutor.execute(new Runnable() {
                public void run() {
                    CharSequence charSequence = "";
                    if (BiometricPrompt.canUseBiometricFragment() && BiometricPrompt.this.mBiometricFragment != null) {
                        CharSequence negativeButtonText = BiometricPrompt.this.mBiometricFragment.getNegativeButtonText();
                        AuthenticationCallback access$200 = BiometricPrompt.this.mAuthenticationCallback;
                        if (negativeButtonText != null) {
                            charSequence = negativeButtonText;
                        }
                        access$200.onAuthenticationError(13, charSequence);
                        BiometricPrompt.this.mBiometricFragment.cleanup();
                    } else if (BiometricPrompt.this.mFingerprintDialogFragment != null && BiometricPrompt.this.mFingerprintHelperFragment != null) {
                        CharSequence negativeButtonText2 = BiometricPrompt.this.mFingerprintDialogFragment.getNegativeButtonText();
                        AuthenticationCallback access$2002 = BiometricPrompt.this.mAuthenticationCallback;
                        if (negativeButtonText2 != null) {
                            charSequence = negativeButtonText2;
                        }
                        access$2002.onAuthenticationError(13, charSequence);
                        BiometricPrompt.this.mFingerprintHelperFragment.cancel(2);
                    }
                }
            });
        }
    };
    public boolean mPausedOnce;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i2, @NonNull CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(@NonNull AuthenticationResult authenticationResult) {
        }
    }

    public static class AuthenticationResult {
        public final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        @Nullable
        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class PromptInfo {
        public Bundle mBundle;

        public static class Builder {
            public final Bundle mBundle = new Bundle();

            @NonNull
            public PromptInfo build() {
                CharSequence charSequence = this.mBundle.getCharSequence("title");
                CharSequence charSequence2 = this.mBundle.getCharSequence(BiometricPrompt.KEY_NEGATIVE_TEXT);
                boolean z = this.mBundle.getBoolean(BiometricPrompt.KEY_ALLOW_DEVICE_CREDENTIAL);
                boolean z2 = this.mBundle.getBoolean(BiometricPrompt.KEY_HANDLING_DEVICE_CREDENTIAL_RESULT);
                if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("Title must be set and non-empty");
                } else if (TextUtils.isEmpty(charSequence2) && !z) {
                    throw new IllegalArgumentException("Negative text must be set and non-empty");
                } else if (!TextUtils.isEmpty(charSequence2) && z) {
                    throw new IllegalArgumentException("Can't have both negative button behavior and device credential enabled");
                } else if (!z2 || z) {
                    return new PromptInfo(this.mBundle);
                } else {
                    throw new IllegalArgumentException("Can't be handling device credential result without device credential enabled");
                }
            }

            @NonNull
            public Builder setConfirmationRequired(boolean z) {
                this.mBundle.putBoolean(BiometricPrompt.KEY_REQUIRE_CONFIRMATION, z);
                return this;
            }

            @NonNull
            public Builder setDescription(@Nullable CharSequence charSequence) {
                this.mBundle.putCharSequence(BiometricPrompt.KEY_DESCRIPTION, charSequence);
                return this;
            }

            @NonNull
            public Builder setDeviceCredentialAllowed(boolean z) {
                this.mBundle.putBoolean(BiometricPrompt.KEY_ALLOW_DEVICE_CREDENTIAL, z);
                return this;
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY})
            public Builder setHandlingDeviceCredentialResult(boolean z) {
                this.mBundle.putBoolean(BiometricPrompt.KEY_HANDLING_DEVICE_CREDENTIAL_RESULT, z);
                return this;
            }

            @NonNull
            public Builder setNegativeButtonText(@NonNull CharSequence charSequence) {
                this.mBundle.putCharSequence(BiometricPrompt.KEY_NEGATIVE_TEXT, charSequence);
                return this;
            }

            @NonNull
            public Builder setSubtitle(@Nullable CharSequence charSequence) {
                this.mBundle.putCharSequence(BiometricPrompt.KEY_SUBTITLE, charSequence);
                return this;
            }

            @NonNull
            public Builder setTitle(@NonNull CharSequence charSequence) {
                this.mBundle.putCharSequence("title", charSequence);
                return this;
            }
        }

        public PromptInfo(Bundle bundle) {
            this.mBundle = bundle;
        }

        public Bundle getBundle() {
            return this.mBundle;
        }

        @Nullable
        public CharSequence getDescription() {
            return this.mBundle.getCharSequence(BiometricPrompt.KEY_DESCRIPTION);
        }

        @NonNull
        public CharSequence getNegativeButtonText() {
            return this.mBundle.getCharSequence(BiometricPrompt.KEY_NEGATIVE_TEXT);
        }

        @Nullable
        public CharSequence getSubtitle() {
            return this.mBundle.getCharSequence(BiometricPrompt.KEY_SUBTITLE);
        }

        @NonNull
        public CharSequence getTitle() {
            return this.mBundle.getCharSequence("title");
        }

        public boolean isConfirmationRequired() {
            return this.mBundle.getBoolean(BiometricPrompt.KEY_REQUIRE_CONFIRMATION);
        }

        public boolean isDeviceCredentialAllowed() {
            return this.mBundle.getBoolean(BiometricPrompt.KEY_ALLOW_DEVICE_CREDENTIAL);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean isHandlingDeviceCredentialResult() {
            return this.mBundle.getBoolean(BiometricPrompt.KEY_HANDLING_DEVICE_CREDENTIAL_RESULT);
        }
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(@NonNull FragmentActivity fragmentActivity, @NonNull Executor executor, @NonNull AuthenticationCallback authenticationCallback) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null");
        } else if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null");
        } else if (authenticationCallback != null) {
            this.mFragmentActivity = fragmentActivity;
            this.mAuthenticationCallback = authenticationCallback;
            this.mExecutor = executor;
            fragmentActivity.getLifecycle().addObserver(this.mLifecycleObserver);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null");
        }
    }

    private void authenticateInternal(@NonNull PromptInfo promptInfo, @Nullable CryptoObject cryptoObject) {
        int i2;
        DeviceCredentialHandlerBridge instanceIfNotNull;
        this.mIsHandlingDeviceCredential = promptInfo.isHandlingDeviceCredentialResult();
        FragmentActivity activity = getActivity();
        if (promptInfo.isDeviceCredentialAllowed() && (i2 = Build.VERSION.SDK_INT) <= 28) {
            if (!this.mIsHandlingDeviceCredential) {
                launchDeviceCredentialHandler(promptInfo);
                return;
            } else if (i2 >= 21) {
                if (activity != null && (instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull()) != null) {
                    if (!instanceIfNotNull.isConfirmingDeviceCredential() && BiometricManager.from(activity).canAuthenticate() != 0) {
                        Utils.launchDeviceCredentialConfirmation(TAG, activity, promptInfo.getBundle(), (Runnable) null);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        FragmentManager fragmentManager = getFragmentManager();
        if (!fragmentManager.isStateSaved()) {
            Bundle bundle = promptInfo.getBundle();
            boolean z = false;
            this.mPausedOnce = false;
            if (!(activity == null || cryptoObject == null || !Utils.shouldUseFingerprintForCrypto(activity, Build.MANUFACTURER, Build.MODEL))) {
                z = true;
            }
            if (z || !canUseBiometricFragment()) {
                FingerprintDialogFragment fingerprintDialogFragment = (FingerprintDialogFragment) fragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG);
                if (fingerprintDialogFragment != null) {
                    this.mFingerprintDialogFragment = fingerprintDialogFragment;
                } else {
                    this.mFingerprintDialogFragment = FingerprintDialogFragment.newInstance();
                }
                this.mFingerprintDialogFragment.setNegativeButtonListener(this.mNegativeButtonListener);
                this.mFingerprintDialogFragment.setBundle(bundle);
                if (activity != null && !Utils.shouldHideFingerprintDialog(activity, Build.MODEL)) {
                    if (fingerprintDialogFragment == null) {
                        this.mFingerprintDialogFragment.show(fragmentManager, DIALOG_FRAGMENT_TAG);
                    } else if (this.mFingerprintDialogFragment.isDetached()) {
                        fragmentManager.beginTransaction().attach(this.mFingerprintDialogFragment).commitAllowingStateLoss();
                    }
                }
                FingerprintHelperFragment fingerprintHelperFragment = (FingerprintHelperFragment) fragmentManager.findFragmentByTag(FINGERPRINT_HELPER_FRAGMENT_TAG);
                if (fingerprintHelperFragment != null) {
                    this.mFingerprintHelperFragment = fingerprintHelperFragment;
                } else {
                    this.mFingerprintHelperFragment = FingerprintHelperFragment.newInstance();
                }
                this.mFingerprintHelperFragment.setCallback(this.mExecutor, this.mAuthenticationCallback);
                Handler handler = this.mFingerprintDialogFragment.getHandler();
                this.mFingerprintHelperFragment.setHandler(handler);
                this.mFingerprintHelperFragment.setCryptoObject(cryptoObject);
                handler.sendMessageDelayed(handler.obtainMessage(6), 500);
                if (fingerprintHelperFragment == null) {
                    fragmentManager.beginTransaction().add((Fragment) this.mFingerprintHelperFragment, FINGERPRINT_HELPER_FRAGMENT_TAG).commitAllowingStateLoss();
                } else if (this.mFingerprintHelperFragment.isDetached()) {
                    fragmentManager.beginTransaction().attach(this.mFingerprintHelperFragment).commitAllowingStateLoss();
                }
            } else {
                BiometricFragment biometricFragment = (BiometricFragment) fragmentManager.findFragmentByTag("BiometricFragment");
                if (biometricFragment != null) {
                    this.mBiometricFragment = biometricFragment;
                } else {
                    this.mBiometricFragment = BiometricFragment.newInstance();
                }
                this.mBiometricFragment.setCallbacks(this.mExecutor, this.mNegativeButtonListener, this.mAuthenticationCallback);
                this.mBiometricFragment.setCryptoObject(cryptoObject);
                this.mBiometricFragment.setBundle(bundle);
                if (biometricFragment == null) {
                    fragmentManager.beginTransaction().add((Fragment) this.mBiometricFragment, "BiometricFragment").commitAllowingStateLoss();
                } else if (this.mBiometricFragment.isDetached()) {
                    fragmentManager.beginTransaction().attach(this.mBiometricFragment).commitAllowingStateLoss();
                }
            }
            fragmentManager.executePendingTransactions();
        }
    }

    public static boolean canUseBiometricFragment() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static void dismissFingerprintFragments(@NonNull FingerprintDialogFragment fingerprintDialogFragment, @NonNull FingerprintHelperFragment fingerprintHelperFragment) {
        fingerprintDialogFragment.dismissSafely();
        fingerprintHelperFragment.cancel(0);
    }

    @Nullable
    private FragmentActivity getActivity() {
        FragmentActivity fragmentActivity = this.mFragmentActivity;
        return fragmentActivity != null ? fragmentActivity : this.mFragment.getActivity();
    }

    /* access modifiers changed from: private */
    public FragmentManager getFragmentManager() {
        FragmentActivity fragmentActivity = this.mFragmentActivity;
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        return this.mFragment.getChildFragmentManager();
    }

    /* access modifiers changed from: private */
    public boolean isChangingConfigurations() {
        return getActivity() != null && getActivity().isChangingConfigurations();
    }

    private void launchDeviceCredentialHandler(PromptInfo promptInfo) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            maybeInitHandlerBridge(true);
            Bundle bundle = promptInfo.getBundle();
            bundle.putBoolean(KEY_HANDLING_DEVICE_CREDENTIAL_RESULT, true);
            Intent intent = new Intent(activity, DeviceCredentialHandlerActivity.class);
            intent.putExtra(DeviceCredentialHandlerActivity.EXTRA_PROMPT_INFO_BUNDLE, bundle);
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void maybeHandleDeviceCredentialResult() {
        DeviceCredentialHandlerBridge instanceIfNotNull;
        if (!this.mIsHandlingDeviceCredential && (instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull()) != null) {
            int deviceCredentialResult = instanceIfNotNull.getDeviceCredentialResult();
            if (deviceCredentialResult == 1) {
                this.mAuthenticationCallback.onAuthenticationSucceeded(new AuthenticationResult((CryptoObject) null));
                instanceIfNotNull.stopIgnoringReset();
                instanceIfNotNull.reset();
            } else if (deviceCredentialResult == 2) {
                this.mAuthenticationCallback.onAuthenticationError(10, getActivity() != null ? getActivity().getString(R.string.generic_error_user_canceled) : "");
                instanceIfNotNull.stopIgnoringReset();
                instanceIfNotNull.reset();
            }
        }
    }

    /* access modifiers changed from: private */
    public void maybeInitHandlerBridge(boolean z) {
        FingerprintHelperFragment fingerprintHelperFragment;
        BiometricFragment biometricFragment;
        if (Build.VERSION.SDK_INT < 29) {
            DeviceCredentialHandlerBridge instance = DeviceCredentialHandlerBridge.getInstance();
            if (!this.mIsHandlingDeviceCredential) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    try {
                        instance.setClientThemeResId(activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).getThemeResource());
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
            } else if (!canUseBiometricFragment() || (biometricFragment = this.mBiometricFragment) == null) {
                FingerprintDialogFragment fingerprintDialogFragment = this.mFingerprintDialogFragment;
                if (!(fingerprintDialogFragment == null || (fingerprintHelperFragment = this.mFingerprintHelperFragment) == null)) {
                    instance.setFingerprintFragments(fingerprintDialogFragment, fingerprintHelperFragment);
                }
            } else {
                instance.setBiometricFragment(biometricFragment);
            }
            instance.setCallbacks(this.mExecutor, this.mNegativeButtonListener, this.mAuthenticationCallback);
            if (z) {
                instance.startIgnoringReset();
            }
        }
    }

    /* access modifiers changed from: private */
    public void maybeResetHandlerBridge() {
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        if (instanceIfNotNull != null) {
            instanceIfNotNull.reset();
        }
    }

    public void authenticate(@NonNull PromptInfo promptInfo, @NonNull CryptoObject cryptoObject) {
        if (promptInfo == null) {
            throw new IllegalArgumentException("PromptInfo can not be null");
        } else if (cryptoObject == null) {
            throw new IllegalArgumentException("CryptoObject can not be null");
        } else if (!promptInfo.getBundle().getBoolean(KEY_ALLOW_DEVICE_CREDENTIAL)) {
            authenticateInternal(promptInfo, cryptoObject);
        } else {
            throw new IllegalArgumentException("Device credential not supported with crypto");
        }
    }

    public void cancelAuthentication() {
        DeviceCredentialHandlerBridge instanceIfNotNull;
        FingerprintDialogFragment fingerprintDialogFragment;
        BiometricFragment biometricFragment;
        DeviceCredentialHandlerBridge instanceIfNotNull2;
        if (!canUseBiometricFragment() || (biometricFragment = this.mBiometricFragment) == null) {
            FingerprintHelperFragment fingerprintHelperFragment = this.mFingerprintHelperFragment;
            if (!(fingerprintHelperFragment == null || (fingerprintDialogFragment = this.mFingerprintDialogFragment) == null)) {
                dismissFingerprintFragments(fingerprintDialogFragment, fingerprintHelperFragment);
            }
            if (!this.mIsHandlingDeviceCredential && (instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull()) != null && instanceIfNotNull.getFingerprintDialogFragment() != null && instanceIfNotNull.getFingerprintHelperFragment() != null) {
                dismissFingerprintFragments(instanceIfNotNull.getFingerprintDialogFragment(), instanceIfNotNull.getFingerprintHelperFragment());
                return;
            }
            return;
        }
        biometricFragment.cancel();
        if (!this.mIsHandlingDeviceCredential && (instanceIfNotNull2 = DeviceCredentialHandlerBridge.getInstanceIfNotNull()) != null && instanceIfNotNull2.getBiometricFragment() != null) {
            instanceIfNotNull2.getBiometricFragment().cancel();
        }
    }

    public static class CryptoObject {
        public final Cipher mCipher;
        public final Mac mMac;
        public final Signature mSignature;

        public CryptoObject(@NonNull Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.mCipher;
        }

        @Nullable
        public Mac getMac() {
            return this.mMac;
        }

        @Nullable
        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    public void authenticate(@NonNull PromptInfo promptInfo) {
        if (promptInfo != null) {
            authenticateInternal(promptInfo, (CryptoObject) null);
            return;
        }
        throw new IllegalArgumentException("PromptInfo can not be null");
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(@NonNull Fragment fragment, @NonNull Executor executor, @NonNull AuthenticationCallback authenticationCallback) {
        if (fragment == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null");
        } else if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null");
        } else if (authenticationCallback != null) {
            this.mFragment = fragment;
            this.mAuthenticationCallback = authenticationCallback;
            this.mExecutor = executor;
            fragment.getLifecycle().addObserver(this.mLifecycleObserver);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null");
        }
    }
}
