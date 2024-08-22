package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    public static final Object lock = new Object();
    public static final GoogleApiAvailabilityLight zzjp = GoogleApiAvailabilityLight.getInstance();
    public static Method zzjq = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i2, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull(context, "Context must not be null");
        zzjp.verifyGooglePlayServicesIsAvailable(context, 11925000);
        Context zzl = zzl(context);
        if (zzl == null) {
            zzl = zzm(context);
        }
        if (zzl != null) {
            synchronized (lock) {
                try {
                    if (zzjq == null) {
                        zzjq = zzl.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
                    }
                    zzjq.invoke((Object) null, new Object[]{zzl});
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    if (Log.isLoggable("ProviderInstaller", 6)) {
                        String valueOf = String.valueOf(cause == null ? e.getMessage() : cause.getMessage());
                        if (valueOf.length() != 0) {
                            "Failed to install provider: ".concat(valueOf);
                        } else {
                            new String("Failed to install provider: ");
                        }
                    }
                    throw new GooglePlayServicesNotAvailableException(8);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    @Nullable
    public static Context zzl(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
        } catch (DynamiteModule.LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load providerinstaller module: ".concat(valueOf);
                return null;
            }
            new String("Failed to load providerinstaller module: ");
            return null;
        }
    }

    @Nullable
    public static Context zzm(Context context) {
        try {
            return GooglePlayServicesUtilLight.getRemoteContext(context);
        } catch (Resources.NotFoundException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load GMS Core context for providerinstaller: ".concat(valueOf);
            } else {
                new String("Failed to load GMS Core context for providerinstaller: ");
            }
            CrashUtils.addDynamiteErrorToDropBox(context, e);
            return null;
        }
    }
}
