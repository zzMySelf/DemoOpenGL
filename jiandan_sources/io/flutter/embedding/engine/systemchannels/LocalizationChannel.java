package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.sapi2.utils.SapiUtils;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalizationChannel {
    public static final String TAG = "LocalizationChannel";
    @NonNull
    public final MethodChannel channel;
    @VisibleForTesting
    @NonNull
    public final MethodChannel.MethodCallHandler handler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (LocalizationChannel.this.localizationMessageHandler != null) {
                String str = methodCall.method;
                char c = 65535;
                if (str.hashCode() == -259484608 && str.equals("Localization.getStringResource")) {
                    c = 0;
                }
                if (c != 0) {
                    result.notImplemented();
                    return;
                }
                JSONObject jSONObject = (JSONObject) methodCall.arguments();
                try {
                    result.success(LocalizationChannel.this.localizationMessageHandler.getStringResource(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
                } catch (JSONException e) {
                    result.error(SapiUtils.KEY_QR_LOGIN_ERROR, e.getMessage(), (Object) null);
                }
            }
        }
    };
    @Nullable
    public LocalizationMessageHandler localizationMessageHandler;

    public interface LocalizationMessageHandler {
        String getStringResource(@NonNull String str, String str2);
    }

    public LocalizationChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.handler);
    }

    public void sendLocales(@NonNull List<Locale> list) {
        Log.v(TAG, "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale next : list) {
            Log.v(TAG, "Locale (Language: " + next.getLanguage() + ", Country: " + next.getCountry() + ", Variant: " + next.getVariant() + ")");
            arrayList.add(next.getLanguage());
            arrayList.add(next.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? next.getScript() : "");
            arrayList.add(next.getVariant());
        }
        this.channel.invokeMethod("setLocale", arrayList);
    }

    public void setLocalizationMessageHandler(@Nullable LocalizationMessageHandler localizationMessageHandler2) {
        this.localizationMessageHandler = localizationMessageHandler2;
    }
}
