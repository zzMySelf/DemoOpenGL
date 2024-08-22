package androidx.biometric;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.ItemTouchHelper;

@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class FingerprintDialogFragment extends DialogFragment {
    public static final int DISPLAYED_FOR_500_MS = 6;
    public static final String KEY_DIALOG_BUNDLE = "SavedBundle";
    public static final int MESSAGE_DISPLAY_TIME_MS = 2000;
    public static final int MSG_DISMISS_DIALOG_AUTHENTICATED = 5;
    public static final int MSG_DISMISS_DIALOG_ERROR = 3;
    public static final int MSG_RESET_MESSAGE = 4;
    public static final int MSG_SHOW_ERROR = 2;
    public static final int MSG_SHOW_HELP = 1;
    public static final int STATE_FINGERPRINT = 1;
    public static final int STATE_FINGERPRINT_AUTHENTICATED = 3;
    public static final int STATE_FINGERPRINT_ERROR = 2;
    public static final int STATE_NONE = 0;
    public static final String TAG = "FingerprintDialogFrag";
    public Bundle mBundle;
    public Context mContext;
    public final DialogInterface.OnClickListener mDeviceCredentialButtonListener = new DialogInterface.OnClickListener() {
        public void onClick(final DialogInterface dialogInterface, int i2) {
            if (i2 == -2 && Build.VERSION.SDK_INT >= 21) {
                Utils.launchDeviceCredentialConfirmation(FingerprintDialogFragment.TAG, FingerprintDialogFragment.this.getActivity(), FingerprintDialogFragment.this.mBundle, new Runnable() {
                    public void run() {
                        FingerprintDialogFragment.this.onCancel(dialogInterface);
                    }
                });
            }
        }
    };
    public boolean mDismissInstantly = true;
    public int mErrorColor;
    public TextView mErrorText;
    public ImageView mFingerprintIcon;
    public H mHandler = new H();
    public int mLastState;
    @VisibleForTesting
    public DialogInterface.OnClickListener mNegativeButtonListener;
    public int mTextColor;

    public final class H extends Handler {
        public H() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    FingerprintDialogFragment.this.handleShowHelp((CharSequence) message.obj);
                    return;
                case 2:
                    FingerprintDialogFragment.this.handleShowError((CharSequence) message.obj);
                    return;
                case 3:
                    FingerprintDialogFragment.this.handleDismissDialogError((CharSequence) message.obj);
                    return;
                case 4:
                    FingerprintDialogFragment.this.handleResetMessage();
                    return;
                case 5:
                    FingerprintDialogFragment.this.dismissSafely();
                    return;
                case 6:
                    Context context = FingerprintDialogFragment.this.getContext();
                    boolean unused = FingerprintDialogFragment.this.mDismissInstantly = context != null && Utils.shouldHideFingerprintDialog(context, Build.MODEL);
                    return;
                default:
                    return;
            }
        }
    }

    private void dismissAfterDelay(CharSequence charSequence) {
        TextView textView = this.mErrorText;
        if (textView != null) {
            textView.setTextColor(this.mErrorColor);
            if (charSequence != null) {
                this.mErrorText.setText(charSequence);
            } else {
                this.mErrorText.setText(R.string.fingerprint_error_lockout);
            }
        }
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                FingerprintDialogFragment.this.dismissSafely();
            }
        }, (long) getHideDialogDelay(this.mContext));
    }

    @RequiresApi(21)
    private Drawable getAnimationForTransition(int i2, int i3) {
        int i4;
        if (i2 == 0 && i3 == 1) {
            i4 = R.drawable.fingerprint_dialog_fp_to_error;
        } else if (i2 == 1 && i3 == 2) {
            i4 = R.drawable.fingerprint_dialog_fp_to_error;
        } else if (i2 == 2 && i3 == 1) {
            i4 = R.drawable.fingerprint_dialog_error_to_fp;
        } else if (i2 != 1 || i3 != 3) {
            return null;
        } else {
            i4 = R.drawable.fingerprint_dialog_error_to_fp;
        }
        return this.mContext.getDrawable(i4);
    }

    public static int getHideDialogDelay(Context context) {
        return (context == null || !Utils.shouldHideFingerprintDialog(context, Build.MODEL)) ? 2000 : 0;
    }

    private int getThemedColorFor(int i2) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i2, typedValue, true);
        TypedArray obtainStyledAttributes = getActivity().obtainStyledAttributes(typedValue.data, new int[]{i2});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    /* access modifiers changed from: private */
    public void handleDismissDialogError(CharSequence charSequence) {
        if (this.mDismissInstantly) {
            dismissSafely();
        } else {
            dismissAfterDelay(charSequence);
        }
        this.mDismissInstantly = true;
    }

    /* access modifiers changed from: private */
    public void handleResetMessage() {
        updateFingerprintIcon(1);
        TextView textView = this.mErrorText;
        if (textView != null) {
            textView.setTextColor(this.mTextColor);
            this.mErrorText.setText(this.mContext.getString(R.string.fingerprint_dialog_touch_sensor));
        }
    }

    /* access modifiers changed from: private */
    public void handleShowError(CharSequence charSequence) {
        updateFingerprintIcon(2);
        this.mHandler.removeMessages(4);
        TextView textView = this.mErrorText;
        if (textView != null) {
            textView.setTextColor(this.mErrorColor);
            this.mErrorText.setText(charSequence);
        }
        H h = this.mHandler;
        h.sendMessageDelayed(h.obtainMessage(3), (long) getHideDialogDelay(this.mContext));
    }

    /* access modifiers changed from: private */
    public void handleShowHelp(CharSequence charSequence) {
        updateFingerprintIcon(2);
        this.mHandler.removeMessages(4);
        TextView textView = this.mErrorText;
        if (textView != null) {
            textView.setTextColor(this.mErrorColor);
            this.mErrorText.setText(charSequence);
        }
        H h = this.mHandler;
        h.sendMessageDelayed(h.obtainMessage(4), ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
    }

    /* access modifiers changed from: private */
    public boolean isDeviceCredentialAllowed() {
        return this.mBundle.getBoolean(BiometricPrompt.KEY_ALLOW_DEVICE_CREDENTIAL);
    }

    public static FingerprintDialogFragment newInstance() {
        return new FingerprintDialogFragment();
    }

    private boolean shouldAnimateForTransition(int i2, int i3) {
        if (i2 == 0 && i3 == 1) {
            return false;
        }
        if (i2 == 1 && i3 == 2) {
            return true;
        }
        if (i2 == 2 && i3 == 1) {
            return true;
        }
        if (i2 != 1 || i3 == 3) {
        }
        return false;
    }

    private void updateFingerprintIcon(int i2) {
        Drawable animationForTransition;
        if (this.mFingerprintIcon != null && Build.VERSION.SDK_INT >= 23 && (animationForTransition = getAnimationForTransition(this.mLastState, i2)) != null) {
            AnimatedVectorDrawable animatedVectorDrawable = animationForTransition instanceof AnimatedVectorDrawable ? (AnimatedVectorDrawable) animationForTransition : null;
            this.mFingerprintIcon.setImageDrawable(animationForTransition);
            if (animatedVectorDrawable != null && shouldAnimateForTransition(this.mLastState, i2)) {
                animatedVectorDrawable.start();
            }
            this.mLastState = i2;
        }
    }

    public void dismissSafely() {
        if (getFragmentManager() != null) {
            dismissAllowingStateLoss();
        }
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Nullable
    public CharSequence getNegativeButtonText() {
        return this.mBundle.getCharSequence(BiometricPrompt.KEY_NEGATIVE_TEXT);
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        FingerprintHelperFragment fingerprintHelperFragment = (FingerprintHelperFragment) getFragmentManager().findFragmentByTag(BiometricPrompt.FINGERPRINT_HELPER_FRAGMENT_TAG);
        if (fingerprintHelperFragment != null) {
            fingerprintHelperFragment.cancel(1);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mErrorColor = getThemedColorFor(16844099);
        } else {
            this.mErrorColor = ContextCompat.getColor(context, R.color.biometric_error_color);
        }
        this.mTextColor = getThemedColorFor(16842808);
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        CharSequence charSequence;
        if (bundle != null && this.mBundle == null) {
            this.mBundle = bundle.getBundle(KEY_DIALOG_BUNDLE);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(this.mBundle.getCharSequence("title"));
        View inflate = LayoutInflater.from(builder.getContext()).inflate(R.layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fingerprint_subtitle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fingerprint_description);
        CharSequence charSequence2 = this.mBundle.getCharSequence(BiometricPrompt.KEY_SUBTITLE);
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence2);
        }
        CharSequence charSequence3 = this.mBundle.getCharSequence(BiometricPrompt.KEY_DESCRIPTION);
        if (TextUtils.isEmpty(charSequence3)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence3);
        }
        this.mFingerprintIcon = (ImageView) inflate.findViewById(R.id.fingerprint_icon);
        this.mErrorText = (TextView) inflate.findViewById(R.id.fingerprint_error);
        if (isDeviceCredentialAllowed()) {
            charSequence = getString(R.string.confirm_device_credential_password);
        } else {
            charSequence = this.mBundle.getCharSequence(BiometricPrompt.KEY_NEGATIVE_TEXT);
        }
        builder.setNegativeButton(charSequence, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (FingerprintDialogFragment.this.isDeviceCredentialAllowed()) {
                    FingerprintDialogFragment.this.mDeviceCredentialButtonListener.onClick(dialogInterface, i2);
                    return;
                }
                DialogInterface.OnClickListener onClickListener = FingerprintDialogFragment.this.mNegativeButtonListener;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i2);
                }
            }
        });
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        this.mLastState = 0;
        updateFingerprintIcon(1);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle(KEY_DIALOG_BUNDLE, this.mBundle);
    }

    public void setBundle(@NonNull Bundle bundle) {
        this.mBundle = bundle;
    }

    public void setNegativeButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.mNegativeButtonListener = onClickListener;
    }
}
