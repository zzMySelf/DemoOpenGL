package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;

@RequiresApi(28)
@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BiometricFragment extends Fragment {
    public static final String TAG = "BiometricFragment";
    @VisibleForTesting
    public final BiometricPrompt.AuthenticationCallback mAuthenticationCallback = new BiometricPrompt.AuthenticationCallback() {
        public void onAuthenticationError(final int i2, final CharSequence charSequence) {
            if (!Utils.isConfirmingDeviceCredential()) {
                BiometricFragment.this.mClientExecutor.execute(new Runnable() {
                    public void run() {
                        CharSequence charSequence = charSequence;
                        if (charSequence == null) {
                            charSequence = BiometricFragment.this.mContext.getString(R.string.default_error_msg) + " " + i2;
                        }
                        BiometricFragment.this.mClientAuthenticationCallback.onAuthenticationError(Utils.isUnknownError(i2) ? 8 : i2, charSequence);
                    }
                });
                BiometricFragment.this.cleanup();
            }
        }

        public void onAuthenticationFailed() {
            BiometricFragment.this.mClientExecutor.execute(new Runnable() {
                public void run() {
                    BiometricFragment.this.mClientAuthenticationCallback.onAuthenticationFailed();
                }
            });
        }

        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            final BiometricPrompt.AuthenticationResult authenticationResult2 = authenticationResult != null ? new BiometricPrompt.AuthenticationResult(BiometricFragment.unwrapCryptoObject(authenticationResult.getCryptoObject())) : new BiometricPrompt.AuthenticationResult((BiometricPrompt.CryptoObject) null);
            BiometricFragment.this.mClientExecutor.execute(new Runnable() {
                public void run() {
                    BiometricFragment.this.mClientAuthenticationCallback.onAuthenticationSucceeded(authenticationResult2);
                }
            });
            BiometricFragment.this.cleanup();
        }
    };
    public android.hardware.biometrics.BiometricPrompt mBiometricPrompt;
    public Bundle mBundle;
    public CancellationSignal mCancellationSignal;
    @VisibleForTesting
    public BiometricPrompt.AuthenticationCallback mClientAuthenticationCallback;
    @VisibleForTesting
    public Executor mClientExecutor;
    @VisibleForTesting
    public DialogInterface.OnClickListener mClientNegativeButtonListener;
    public Context mContext;
    public BiometricPrompt.CryptoObject mCryptoObject;
    public final DialogInterface.OnClickListener mDeviceCredentialButtonListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                Utils.launchDeviceCredentialConfirmation("BiometricFragment", BiometricFragment.this.getActivity(), BiometricFragment.this.mBundle, (Runnable) null);
            }
        }
    };
    public final Executor mExecutor = new Executor() {
        public void execute(@NonNull Runnable runnable) {
            BiometricFragment.this.mHandler.post(runnable);
        }
    };
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public final DialogInterface.OnClickListener mNegativeButtonListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i2) {
            BiometricFragment.this.mClientNegativeButtonListener.onClick(dialogInterface, i2);
        }
    };
    public CharSequence mNegativeButtonText;
    public boolean mShowing;
    public boolean mStartRespectingCancel;

    public static BiometricFragment newInstance() {
        return new BiometricFragment();
    }

    public static BiometricPrompt.CryptoObject unwrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
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

    public static BiometricPrompt.CryptoObject wrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
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

    public void cancel() {
        if (Build.VERSION.SDK_INT < 29 || !isDeviceCredentialAllowed() || this.mStartRespectingCancel) {
            CancellationSignal cancellationSignal = this.mCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
            cleanup();
        }
    }

    public void cleanup() {
        this.mShowing = false;
        FragmentActivity activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().detach(this).commitAllowingStateLoss();
        }
        Utils.maybeFinishHandler(activity);
    }

    @Nullable
    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public boolean isDeviceCredentialAllowed() {
        Bundle bundle = this.mBundle;
        if (bundle == null || !bundle.getBoolean(BiometricPrompt.KEY_ALLOW_DEVICE_CREDENTIAL, false)) {
            return false;
        }
        return true;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle bundle2;
        if (!this.mShowing && (bundle2 = this.mBundle) != null) {
            this.mNegativeButtonText = bundle2.getCharSequence(BiometricPrompt.KEY_NEGATIVE_TEXT);
            BiometricPrompt.Builder builder = new BiometricPrompt.Builder(getContext());
            builder.setTitle(this.mBundle.getCharSequence("title")).setSubtitle(this.mBundle.getCharSequence(BiometricPrompt.KEY_SUBTITLE)).setDescription(this.mBundle.getCharSequence(BiometricPrompt.KEY_DESCRIPTION));
            boolean z = this.mBundle.getBoolean(BiometricPrompt.KEY_ALLOW_DEVICE_CREDENTIAL);
            if (z && Build.VERSION.SDK_INT <= 28) {
                String string = getString(R.string.confirm_device_credential_password);
                this.mNegativeButtonText = string;
                builder.setNegativeButton(string, this.mClientExecutor, this.mDeviceCredentialButtonListener);
            } else if (!TextUtils.isEmpty(this.mNegativeButtonText)) {
                builder.setNegativeButton(this.mNegativeButtonText, this.mClientExecutor, this.mNegativeButtonListener);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setConfirmationRequired(this.mBundle.getBoolean(BiometricPrompt.KEY_REQUIRE_CONFIRMATION, true));
                builder.setDeviceCredentialAllowed(z);
            }
            if (z) {
                this.mStartRespectingCancel = false;
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        boolean unused = BiometricFragment.this.mStartRespectingCancel = true;
                    }
                }, 250);
            }
            this.mBiometricPrompt = builder.build();
            CancellationSignal cancellationSignal = new CancellationSignal();
            this.mCancellationSignal = cancellationSignal;
            BiometricPrompt.CryptoObject cryptoObject = this.mCryptoObject;
            if (cryptoObject == null) {
                this.mBiometricPrompt.authenticate(cancellationSignal, this.mExecutor, this.mAuthenticationCallback);
            } else {
                this.mBiometricPrompt.authenticate(wrapCryptoObject(cryptoObject), this.mCancellationSignal, this.mExecutor, this.mAuthenticationCallback);
            }
        }
        this.mShowing = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void setBundle(@Nullable Bundle bundle) {
        this.mBundle = bundle;
    }

    public void setCallbacks(Executor executor, DialogInterface.OnClickListener onClickListener, BiometricPrompt.AuthenticationCallback authenticationCallback) {
        this.mClientExecutor = executor;
        this.mClientNegativeButtonListener = onClickListener;
        this.mClientAuthenticationCallback = authenticationCallback;
    }

    public void setCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        this.mCryptoObject = cryptoObject;
    }
}
