package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i2) {
        return new zad(intent, activity, i2);
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            redirect();
        } catch (ActivityNotFoundException unused) {
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void redirect();

    public static DialogRedirect getInstance(@NonNull Fragment fragment, Intent intent, int i2) {
        return new zac(intent, fragment, i2);
    }

    public static DialogRedirect getInstance(@NonNull LifecycleFragment lifecycleFragment, Intent intent, int i2) {
        return new zae(intent, lifecycleFragment, i2);
    }
}
