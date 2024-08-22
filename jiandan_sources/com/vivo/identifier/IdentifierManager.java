package com.vivo.identifier;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class IdentifierManager {
    @Keep
    public static native String getAAID(Context context);

    @Keep
    public static native String getAAID(Context context, String str);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getOAIDStatus(Context context);

    @Keep
    public static native String getVAID(Context context);

    @Keep
    public static native String getVAID(Context context, String str);

    @Keep
    public static native boolean isSupported(Context context);

    @Keep
    public static native boolean setDebuggable(boolean z);
}
