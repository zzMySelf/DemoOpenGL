package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceCredentialHandlerActivity extends AppCompatActivity {
    public static final String EXTRA_PROMPT_INFO_BUNDLE = "prompt_info_bundle";
    public static final String KEY_DID_CHANGE_CONFIGURATION = "did_change_configuration";
    public static final String TAG = "DeviceCredentialHandler";
    public boolean mDidChangeConfiguration;

    public void handleDeviceCredentialResult(int i2) {
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        if (instanceIfNotNull != null) {
            if (i2 == -1) {
                instanceIfNotNull.setDeviceCredentialResult(1);
                instanceIfNotNull.setConfirmingDeviceCredential(false);
                instanceIfNotNull.startIgnoringReset();
            } else {
                instanceIfNotNull.setDeviceCredentialResult(2);
                instanceIfNotNull.setConfirmingDeviceCredential(false);
                instanceIfNotNull.startIgnoringReset();
            }
        }
        finish();
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        handleDeviceCredentialResult(i3);
    }

    public void onCreate(@Nullable Bundle bundle) {
        DeviceCredentialHandlerBridge instance = DeviceCredentialHandlerBridge.getInstance();
        boolean z = true;
        if (instance.getClientThemeResId() != 0) {
            setTheme(instance.getClientThemeResId());
            getTheme().applyStyle(R.style.TransparentStyle, true);
        }
        super.onCreate(bundle);
        if (bundle == null || !bundle.getBoolean(KEY_DID_CHANGE_CONFIGURATION, false)) {
            z = false;
        }
        this.mDidChangeConfiguration = z;
        if (!z) {
            instance.stopIgnoringReset();
        } else {
            this.mDidChangeConfiguration = false;
        }
        setTitle((CharSequence) null);
        setContentView(R.layout.device_credential_handler_activity);
        if (instance.getExecutor() == null || instance.getAuthenticationCallback() == null) {
            finish();
        } else {
            new BiometricPrompt((FragmentActivity) this, instance.getExecutor(), instance.getAuthenticationCallback()).authenticate(new BiometricPrompt.PromptInfo(getIntent().getBundleExtra(EXTRA_PROMPT_INFO_BUNDLE)));
        }
    }

    public void onPause() {
        super.onPause();
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        if (isChangingConfigurations() && instanceIfNotNull != null) {
            instanceIfNotNull.ignoreNextReset();
            this.mDidChangeConfiguration = true;
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_DID_CHANGE_CONFIGURATION, this.mDidChangeConfiguration);
    }
}
