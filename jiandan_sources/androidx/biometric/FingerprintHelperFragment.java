package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;

@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class FingerprintHelperFragment extends Fragment {
    public static final String TAG = "FingerprintHelperFrag";
    public static final int USER_CANCELED_FROM_NEGATIVE_BUTTON = 2;
    public static final int USER_CANCELED_FROM_NONE = 0;
    public static final int USER_CANCELED_FROM_USER = 1;
    @VisibleForTesting
    public final FingerprintManagerCompat.AuthenticationCallback mAuthenticationCallback = new FingerprintManagerCompat.AuthenticationCallback() {
        /* access modifiers changed from: private */
        public void dismissAndForwardResult(final int i2, final CharSequence charSequence) {
            FingerprintHelperFragment.this.mMessageRouter.sendMessage(3);
            if (!Utils.isConfirmingDeviceCredential()) {
                FingerprintHelperFragment.this.mExecutor.execute(new Runnable() {
                    public void run() {
                        FingerprintHelperFragment.this.mClientAuthenticationCallback.onAuthenticationError(i2, charSequence);
                    }
                });
            }
        }

        public void onAuthenticationError(final int i2, final CharSequence charSequence) {
            if (i2 == 5) {
                if (FingerprintHelperFragment.this.mCanceledFrom == 0) {
                    dismissAndForwardResult(i2, charSequence);
                }
                FingerprintHelperFragment.this.cleanup();
            } else if (i2 == 7 || i2 == 9) {
                dismissAndForwardResult(i2, charSequence);
                FingerprintHelperFragment.this.cleanup();
            } else {
                if (charSequence == null) {
                    "Got null string for error message: " + i2;
                    charSequence = FingerprintHelperFragment.this.mContext.getResources().getString(R.string.default_error_msg);
                }
                if (Utils.isUnknownError(i2)) {
                    i2 = 8;
                }
                FingerprintHelperFragment.this.mMessageRouter.sendMessage(2, i2, 0, charSequence);
                FingerprintHelperFragment.this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        AnonymousClass1.this.dismissAndForwardResult(i2, charSequence);
                        FingerprintHelperFragment.this.cleanup();
                    }
                }, (long) FingerprintDialogFragment.getHideDialogDelay(FingerprintHelperFragment.this.getContext()));
            }
        }

        public void onAuthenticationFailed() {
            FingerprintHelperFragment.this.mMessageRouter.sendMessage(1, FingerprintHelperFragment.this.mContext.getResources().getString(R.string.fingerprint_not_recognized));
            FingerprintHelperFragment.this.mExecutor.execute(new Runnable() {
                public void run() {
                    FingerprintHelperFragment.this.mClientAuthenticationCallback.onAuthenticationFailed();
                }
            });
        }

        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
            FingerprintHelperFragment.this.mMessageRouter.sendMessage(1, charSequence);
        }

        public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
            FingerprintHelperFragment.this.mMessageRouter.sendMessage(5);
            final BiometricPrompt.AuthenticationResult authenticationResult2 = authenticationResult != null ? new BiometricPrompt.AuthenticationResult(FingerprintHelperFragment.unwrapCryptoObject(authenticationResult.getCryptoObject())) : new BiometricPrompt.AuthenticationResult((BiometricPrompt.CryptoObject) null);
            FingerprintHelperFragment.this.mExecutor.execute(new Runnable() {
                public void run() {
                    FingerprintHelperFragment.this.mClientAuthenticationCallback.onAuthenticationSucceeded(authenticationResult2);
                }
            });
            FingerprintHelperFragment.this.cleanup();
        }
    };
    public int mCanceledFrom;
    public CancellationSignal mCancellationSignal;
    @VisibleForTesting
    public BiometricPrompt.AuthenticationCallback mClientAuthenticationCallback;
    public Context mContext;
    public BiometricPrompt.CryptoObject mCryptoObject;
    @VisibleForTesting
    public Executor mExecutor;
    public Handler mHandler;
    public MessageRouter mMessageRouter;
    public boolean mShowing;

    @VisibleForTesting
    public static class MessageRouter {
        public final Handler mHandler;

        @VisibleForTesting
        public MessageRouter(Handler handler) {
            this.mHandler = handler;
        }

        @VisibleForTesting
        public void sendMessage(int i2) {
            this.mHandler.obtainMessage(i2).sendToTarget();
        }

        @VisibleForTesting
        public void sendMessage(int i2, Object obj) {
            this.mHandler.obtainMessage(i2, obj).sendToTarget();
        }

        @VisibleForTesting
        public void sendMessage(int i2, int i3, int i4, Object obj) {
            this.mHandler.obtainMessage(i2, i3, i4, obj).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public void cleanup() {
        this.mShowing = false;
        FragmentActivity activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().detach(this).commitAllowingStateLoss();
        }
        if (!Utils.isConfirmingDeviceCredential()) {
            Utils.maybeFinishHandler(activity);
        }
    }

    private String getErrorString(Context context, int i2) {
        if (i2 == 1) {
            return context.getString(R.string.fingerprint_error_hw_not_available);
        }
        switch (i2) {
            case 10:
                return context.getString(R.string.fingerprint_error_user_canceled);
            case 11:
                return context.getString(R.string.fingerprint_error_no_fingerprints);
            case 12:
                return context.getString(R.string.fingerprint_error_hw_not_present);
            default:
                "Unknown error code: " + i2;
                return context.getString(R.string.default_error_msg);
        }
    }

    private boolean handlePreAuthenticationErrors(FingerprintManagerCompat fingerprintManagerCompat) {
        if (!fingerprintManagerCompat.isHardwareDetected()) {
            sendErrorToClient(12);
            return true;
        } else if (fingerprintManagerCompat.hasEnrolledFingerprints()) {
            return false;
        } else {
            sendErrorToClient(11);
            return true;
        }
    }

    public static FingerprintHelperFragment newInstance() {
        return new FingerprintHelperFragment();
    }

    private void sendErrorToClient(int i2) {
        if (!Utils.isConfirmingDeviceCredential()) {
            this.mClientAuthenticationCallback.onAuthenticationError(i2, getErrorString(this.mContext, i2));
        }
    }

    public static BiometricPrompt.CryptoObject unwrapCryptoObject(FingerprintManagerCompat.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new BiometricPrompt.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new BiometricPrompt.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new BiometricPrompt.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    public static FingerprintManagerCompat.CryptoObject wrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManagerCompat.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManagerCompat.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new FingerprintManagerCompat.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    public void cancel(int i2) {
        this.mCanceledFrom = i2;
        if (i2 == 1) {
            sendErrorToClient(10);
        }
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        cleanup();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.mContext = getContext();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (!this.mShowing) {
            this.mCancellationSignal = new CancellationSignal();
            this.mCanceledFrom = 0;
            FingerprintManagerCompat from = FingerprintManagerCompat.from(this.mContext);
            if (handlePreAuthenticationErrors(from)) {
                this.mMessageRouter.sendMessage(3);
                cleanup();
            } else {
                from.authenticate(wrapCryptoObject(this.mCryptoObject), 0, this.mCancellationSignal, this.mAuthenticationCallback, (Handler) null);
                this.mShowing = true;
            }
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void setCallback(Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
        this.mExecutor = executor;
        this.mClientAuthenticationCallback = authenticationCallback;
    }

    public void setCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        this.mCryptoObject = cryptoObject;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
        this.mMessageRouter = new MessageRouter(handler);
    }

    @VisibleForTesting
    public void setMessageRouter(MessageRouter messageRouter) {
        this.mMessageRouter = messageRouter;
    }
}
