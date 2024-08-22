package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.sapi2.utils.SapiUtils;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.editing.TextEditingDelta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel {
    public static final String TAG = "TextInputChannel";
    @NonNull
    public final MethodChannel channel;
    @VisibleForTesting
    @NonNull
    public final MethodChannel.MethodCallHandler parsingMethodHandler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Bundle bundle;
            MethodCall methodCall2 = methodCall;
            MethodChannel.Result result2 = result;
            if (TextInputChannel.this.textInputMethodHandler != null) {
                String str = methodCall2.method;
                Object obj = methodCall2.arguments;
                Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                char c = 65535;
                switch (str.hashCode()) {
                    case -1779068172:
                        if (str.equals("TextInput.setPlatformViewClient")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1015421462:
                        if (str.equals("TextInput.setEditingState")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -37561188:
                        if (str.equals("TextInput.setClient")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 270476819:
                        if (str.equals("TextInput.hide")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 270803918:
                        if (str.equals("TextInput.show")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 649192816:
                        if (str.equals("TextInput.sendAppPrivateCommand")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1204752139:
                        if (str.equals("TextInput.setEditableSizeAndTransform")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1727570905:
                        if (str.equals("TextInput.finishAutofillContext")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 1904427655:
                        if (str.equals("TextInput.clearClient")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 2113369584:
                        if (str.equals("TextInput.requestAutofill")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        TextInputChannel.this.textInputMethodHandler.show();
                        result2.success((Object) null);
                        return;
                    case 1:
                        TextInputChannel.this.textInputMethodHandler.hide();
                        result2.success((Object) null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                            result2.success((Object) null);
                            return;
                        } catch (NoSuchFieldException | JSONException e) {
                            result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, e.getMessage(), (Object) null);
                            return;
                        }
                    case 3:
                        TextInputChannel.this.textInputMethodHandler.requestAutofill();
                        result2.success((Object) null);
                        return;
                    case 4:
                        try {
                            JSONObject jSONObject = (JSONObject) obj;
                            TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e2) {
                            result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, e2.getMessage(), (Object) null);
                            return;
                        }
                    case 5:
                        try {
                            TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e3) {
                            result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, e3.getMessage(), (Object) null);
                            return;
                        }
                    case 6:
                        try {
                            JSONObject jSONObject2 = (JSONObject) obj;
                            double d = jSONObject2.getDouble("width");
                            double d2 = jSONObject2.getDouble("height");
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("transform");
                            double[] dArr = new double[16];
                            for (int i2 = 0; i2 < 16; i2++) {
                                dArr[i2] = jSONArray2.getDouble(i2);
                            }
                            TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d, d2, dArr);
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e4) {
                            result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, e4.getMessage(), (Object) null);
                            return;
                        }
                    case 7:
                        TextInputChannel.this.textInputMethodHandler.clearClient();
                        result2.success((Object) null);
                        return;
                    case 8:
                        try {
                            JSONObject jSONObject3 = (JSONObject) obj;
                            String string = jSONObject3.getString("action");
                            String string2 = jSONObject3.getString("data");
                            if (string2 == null || string2.isEmpty()) {
                                bundle = null;
                            } else {
                                bundle = new Bundle();
                                bundle.putString("data", string2);
                            }
                            TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                            result2.success((Object) null);
                            return;
                        } catch (JSONException e5) {
                            result2.error(SapiUtils.KEY_QR_LOGIN_ERROR, e5.getMessage(), (Object) null);
                            return;
                        }
                    case 9:
                        TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                        result2.success((Object) null);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }
    };
    @Nullable
    public TextInputMethodHandler textInputMethodHandler;

    public static class Configuration {
        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;
        @Nullable
        public final Autofill autofill;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        @Nullable
        public final Configuration[] fields;
        @Nullable
        public final Integer inputAction;
        @NonNull
        public final InputType inputType;
        public final boolean obscureText;
        @NonNull
        public final TextCapitalization textCapitalization;

        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(@NonNull String str, @NonNull String[] strArr, @Nullable String str2, @NonNull TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }

            public static Autofill fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    strArr[i2] = translateAutofillHint(jSONArray.getString(i2));
                }
                return new Autofill(string, strArr, string2, TextEditState.fromJson(jSONObject2));
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
                if (r0.equals("password") != false) goto L_0x01af;
             */
            @androidx.annotation.NonNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static java.lang.String translateAutofillHint(@androidx.annotation.NonNull java.lang.String r16) {
                /*
                    r0 = r16
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 26
                    if (r1 >= r2) goto L_0x0009
                    return r0
                L_0x0009:
                    int r3 = r16.hashCode()
                    java.lang.String r4 = "postalCode"
                    java.lang.String r5 = "postalAddress"
                    java.lang.String r6 = "password"
                    java.lang.String r7 = "newUsername"
                    java.lang.String r8 = "username"
                    java.lang.String r9 = "creditCardExpirationYear"
                    java.lang.String r10 = "creditCardExpirationDate"
                    java.lang.String r11 = "creditCardNumber"
                    java.lang.String r12 = "gender"
                    java.lang.String r13 = "creditCardExpirationDay"
                    java.lang.String r14 = "creditCardSecurityCode"
                    java.lang.String r15 = "newPassword"
                    java.lang.String r1 = "creditCardExpirationMonth"
                    switch(r3) {
                        case -2058889126: goto L_0x01a4;
                        case -1917283616: goto L_0x0199;
                        case -1844815832: goto L_0x0190;
                        case -1825589953: goto L_0x0185;
                        case -1821235109: goto L_0x017c;
                        case -1757573738: goto L_0x0173;
                        case -1682373820: goto L_0x016a;
                        case -1658955742: goto L_0x015f;
                        case -1567118045: goto L_0x0154;
                        case -1476752575: goto L_0x014a;
                        case -1413737489: goto L_0x013e;
                        case -1377792129: goto L_0x0133;
                        case -1249512767: goto L_0x0129;
                        case -1186060294: goto L_0x011d;
                        case -1151034798: goto L_0x0113;
                        case -835992323: goto L_0x0107;
                        case -818219584: goto L_0x00fb;
                        case -747304516: goto L_0x00ef;
                        case -613980922: goto L_0x00e6;
                        case -613352043: goto L_0x00dc;
                        case -549230602: goto L_0x00d0;
                        case -265713450: goto L_0x00c6;
                        case 3373707: goto L_0x00ba;
                        case 96619420: goto L_0x00ae;
                        case 253202685: goto L_0x00a3;
                        case 588174851: goto L_0x0098;
                        case 798554127: goto L_0x008c;
                        case 892233837: goto L_0x0080;
                        case 991032982: goto L_0x0076;
                        case 1069376125: goto L_0x006b;
                        case 1216985755: goto L_0x0063;
                        case 1469046696: goto L_0x0057;
                        case 1662667945: goto L_0x004d;
                        case 1921869058: goto L_0x0041;
                        case 2011152728: goto L_0x0037;
                        case 2011773919: goto L_0x002c;
                        default: goto L_0x002a;
                    }
                L_0x002a:
                    goto L_0x01ae
                L_0x002c:
                    java.lang.String r2 = "birthdayDay"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 3
                    goto L_0x01af
                L_0x0037:
                    boolean r2 = r0.equals(r4)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 30
                    goto L_0x01af
                L_0x0041:
                    java.lang.String r2 = "postalAddressExtended"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 28
                    goto L_0x01af
                L_0x004d:
                    boolean r2 = r0.equals(r5)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 27
                    goto L_0x01af
                L_0x0057:
                    java.lang.String r2 = "givenName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 17
                    goto L_0x01af
                L_0x0063:
                    boolean r3 = r0.equals(r6)
                    if (r3 == 0) goto L_0x01ae
                    goto L_0x01af
                L_0x006b:
                    java.lang.String r2 = "birthday"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 2
                    goto L_0x01af
                L_0x0076:
                    boolean r2 = r0.equals(r7)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 24
                    goto L_0x01af
                L_0x0080:
                    java.lang.String r2 = "telephoneNumber"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 31
                    goto L_0x01af
                L_0x008c:
                    java.lang.String r2 = "familyName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 14
                    goto L_0x01af
                L_0x0098:
                    java.lang.String r2 = "birthdayMonth"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 4
                    goto L_0x01af
                L_0x00a3:
                    java.lang.String r2 = "addressState"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 1
                    goto L_0x01af
                L_0x00ae:
                    java.lang.String r2 = "email"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 13
                    goto L_0x01af
                L_0x00ba:
                    java.lang.String r2 = "name"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 20
                    goto L_0x01af
                L_0x00c6:
                    boolean r2 = r0.equals(r8)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 35
                    goto L_0x01af
                L_0x00d0:
                    java.lang.String r2 = "telephoneNumberCountryCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 32
                    goto L_0x01af
                L_0x00dc:
                    boolean r2 = r0.equals(r9)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 10
                    goto L_0x01af
                L_0x00e6:
                    boolean r2 = r0.equals(r10)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 7
                    goto L_0x01af
                L_0x00ef:
                    java.lang.String r2 = "nameSuffix"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 22
                    goto L_0x01af
                L_0x00fb:
                    java.lang.String r2 = "middleName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 19
                    goto L_0x01af
                L_0x0107:
                    java.lang.String r2 = "namePrefix"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 21
                    goto L_0x01af
                L_0x0113:
                    boolean r2 = r0.equals(r11)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 11
                    goto L_0x01af
                L_0x011d:
                    java.lang.String r2 = "postalAddressExtendedPostalCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 29
                    goto L_0x01af
                L_0x0129:
                    boolean r2 = r0.equals(r12)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 16
                    goto L_0x01af
                L_0x0133:
                    java.lang.String r2 = "addressCity"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 0
                    goto L_0x01af
                L_0x013e:
                    java.lang.String r2 = "middleInitial"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 18
                    goto L_0x01af
                L_0x014a:
                    java.lang.String r2 = "countryName"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 6
                    goto L_0x01af
                L_0x0154:
                    java.lang.String r2 = "telephoneNumberDevice"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 33
                    goto L_0x01af
                L_0x015f:
                    java.lang.String r2 = "fullStreetAddress"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 15
                    goto L_0x01af
                L_0x016a:
                    boolean r2 = r0.equals(r13)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 8
                    goto L_0x01af
                L_0x0173:
                    boolean r2 = r0.equals(r14)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 12
                    goto L_0x01af
                L_0x017c:
                    boolean r2 = r0.equals(r15)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 23
                    goto L_0x01af
                L_0x0185:
                    java.lang.String r2 = "telephoneNumberNational"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 34
                    goto L_0x01af
                L_0x0190:
                    boolean r2 = r0.equals(r1)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 9
                    goto L_0x01af
                L_0x0199:
                    java.lang.String r2 = "oneTimeCode"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 25
                    goto L_0x01af
                L_0x01a4:
                    java.lang.String r2 = "birthdayYear"
                    boolean r2 = r0.equals(r2)
                    if (r2 == 0) goto L_0x01ae
                    r2 = 5
                    goto L_0x01af
                L_0x01ae:
                    r2 = -1
                L_0x01af:
                    switch(r2) {
                        case 0: goto L_0x0202;
                        case 1: goto L_0x01ff;
                        case 2: goto L_0x01fc;
                        case 3: goto L_0x01f9;
                        case 4: goto L_0x01f6;
                        case 5: goto L_0x01f3;
                        case 6: goto L_0x01f0;
                        case 7: goto L_0x01ef;
                        case 8: goto L_0x01ee;
                        case 9: goto L_0x01ed;
                        case 10: goto L_0x01ec;
                        case 11: goto L_0x01eb;
                        case 12: goto L_0x01ea;
                        case 13: goto L_0x01e7;
                        case 14: goto L_0x01e4;
                        case 15: goto L_0x01e1;
                        case 16: goto L_0x01e0;
                        case 17: goto L_0x01dd;
                        case 18: goto L_0x01da;
                        case 19: goto L_0x01d7;
                        case 20: goto L_0x01d4;
                        case 21: goto L_0x01d1;
                        case 22: goto L_0x01ce;
                        case 23: goto L_0x01cd;
                        case 24: goto L_0x01cc;
                        case 25: goto L_0x01c9;
                        case 26: goto L_0x01c8;
                        case 27: goto L_0x01c7;
                        case 28: goto L_0x01c4;
                        case 29: goto L_0x01c1;
                        case 30: goto L_0x01c0;
                        case 31: goto L_0x01bd;
                        case 32: goto L_0x01ba;
                        case 33: goto L_0x01b7;
                        case 34: goto L_0x01b4;
                        case 35: goto L_0x01b3;
                        default: goto L_0x01b2;
                    }
                L_0x01b2:
                    return r0
                L_0x01b3:
                    return r8
                L_0x01b4:
                    java.lang.String r0 = "phoneNational"
                    return r0
                L_0x01b7:
                    java.lang.String r0 = "phoneNumberDevice"
                    return r0
                L_0x01ba:
                    java.lang.String r0 = "phoneCountryCode"
                    return r0
                L_0x01bd:
                    java.lang.String r0 = "phoneNumber"
                    return r0
                L_0x01c0:
                    return r4
                L_0x01c1:
                    java.lang.String r0 = "extendedPostalCode"
                    return r0
                L_0x01c4:
                    java.lang.String r0 = "extendedAddress"
                    return r0
                L_0x01c7:
                    return r5
                L_0x01c8:
                    return r6
                L_0x01c9:
                    java.lang.String r0 = "smsOTPCode"
                    return r0
                L_0x01cc:
                    return r7
                L_0x01cd:
                    return r15
                L_0x01ce:
                    java.lang.String r0 = "personNameSuffix"
                    return r0
                L_0x01d1:
                    java.lang.String r0 = "personNamePrefix"
                    return r0
                L_0x01d4:
                    java.lang.String r0 = "personName"
                    return r0
                L_0x01d7:
                    java.lang.String r0 = "personMiddleName"
                    return r0
                L_0x01da:
                    java.lang.String r0 = "personMiddleInitial"
                    return r0
                L_0x01dd:
                    java.lang.String r0 = "personGivenName"
                    return r0
                L_0x01e0:
                    return r12
                L_0x01e1:
                    java.lang.String r0 = "streetAddress"
                    return r0
                L_0x01e4:
                    java.lang.String r0 = "personFamilyName"
                    return r0
                L_0x01e7:
                    java.lang.String r0 = "emailAddress"
                    return r0
                L_0x01ea:
                    return r14
                L_0x01eb:
                    return r11
                L_0x01ec:
                    return r9
                L_0x01ed:
                    return r1
                L_0x01ee:
                    return r13
                L_0x01ef:
                    return r10
                L_0x01f0:
                    java.lang.String r0 = "addressCountry"
                    return r0
                L_0x01f3:
                    java.lang.String r0 = "birthDateYear"
                    return r0
                L_0x01f6:
                    java.lang.String r0 = "birthDateMonth"
                    return r0
                L_0x01f9:
                    java.lang.String r0 = "birthDateDay"
                    return r0
                L_0x01fc:
                    java.lang.String r0 = "birthDateFull"
                    return r0
                L_0x01ff:
                    java.lang.String r0 = "addressRegion"
                    return r0
                L_0x0202:
                    java.lang.String r0 = "addressLocality"
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill.translateAutofillHint(java.lang.String):java.lang.String");
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @NonNull TextCapitalization textCapitalization2, @NonNull InputType inputType2, @Nullable Integer num, @Nullable String str, @Nullable Autofill autofill2, @Nullable Configuration[] configurationArr) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.enableIMEPersonalizedLearning = z4;
            this.enableDeltaModel = z5;
            this.textCapitalization = textCapitalization2;
            this.inputType = inputType2;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill2;
            this.fields = configurationArr;
        }

        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            Configuration[] configurationArr;
            JSONObject jSONObject2 = jSONObject;
            String string = jSONObject2.getString("inputAction");
            if (string != null) {
                Autofill autofill2 = null;
                if (!jSONObject2.isNull(GetUserAttrInfoResult.KEY_DATA_FIELDS)) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(GetUserAttrInfoResult.KEY_DATA_FIELDS);
                    int length = jSONArray.length();
                    Configuration[] configurationArr2 = new Configuration[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        configurationArr2[i2] = fromJson(jSONArray.getJSONObject(i2));
                    }
                    configurationArr = configurationArr2;
                } else {
                    configurationArr = null;
                }
                Integer inputActionFromTextInputAction = inputActionFromTextInputAction(string);
                boolean optBoolean = jSONObject2.optBoolean("obscureText");
                boolean optBoolean2 = jSONObject2.optBoolean("autocorrect", true);
                boolean optBoolean3 = jSONObject2.optBoolean("enableSuggestions");
                boolean optBoolean4 = jSONObject2.optBoolean("enableIMEPersonalizedLearning");
                boolean optBoolean5 = jSONObject2.optBoolean("enableDeltaModel");
                TextCapitalization fromValue = TextCapitalization.fromValue(jSONObject2.getString("textCapitalization"));
                InputType fromJson = InputType.fromJson(jSONObject2.getJSONObject("inputType"));
                String string2 = jSONObject2.isNull("actionLabel") ? null : jSONObject2.getString("actionLabel");
                if (!jSONObject2.isNull("autofill")) {
                    autofill2 = Autofill.fromJson(jSONObject2.getJSONObject("autofill"));
                }
                return new Configuration(optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5, fromValue, fromJson, inputActionFromTextInputAction, string2, autofill2, configurationArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
            if (r11.equals("TextInputAction.newline") != false) goto L_0x0073;
         */
        @androidx.annotation.NonNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Integer inputActionFromTextInputAction(@androidx.annotation.NonNull java.lang.String r11) {
            /*
                int r0 = r11.hashCode()
                r1 = 7
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 6
                r7 = 0
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 1
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                switch(r0) {
                    case -810971940: goto L_0x0068;
                    case -737377923: goto L_0x005e;
                    case -737089298: goto L_0x0054;
                    case -737080013: goto L_0x004a;
                    case -736940669: goto L_0x0040;
                    case 469250275: goto L_0x0036;
                    case 1241689507: goto L_0x002c;
                    case 1539450297: goto L_0x0023;
                    case 2110497650: goto L_0x0018;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x0072
            L_0x0018:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 8
                goto L_0x0073
            L_0x0023:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                goto L_0x0073
            L_0x002c:
                java.lang.String r0 = "TextInputAction.go"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 4
                goto L_0x0073
            L_0x0036:
                java.lang.String r0 = "TextInputAction.search"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 5
                goto L_0x0073
            L_0x0040:
                java.lang.String r0 = "TextInputAction.send"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 6
                goto L_0x0073
            L_0x004a:
                java.lang.String r0 = "TextInputAction.none"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 1
                goto L_0x0073
            L_0x0054:
                java.lang.String r0 = "TextInputAction.next"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 7
                goto L_0x0073
            L_0x005e:
                java.lang.String r0 = "TextInputAction.done"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 3
                goto L_0x0073
            L_0x0068:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L_0x0072
                r7 = 2
                goto L_0x0073
            L_0x0072:
                r7 = -1
            L_0x0073:
                switch(r7) {
                    case 0: goto L_0x0096;
                    case 1: goto L_0x0096;
                    case 2: goto L_0x0095;
                    case 3: goto L_0x0090;
                    case 4: goto L_0x008b;
                    case 5: goto L_0x0086;
                    case 6: goto L_0x0081;
                    case 7: goto L_0x007c;
                    case 8: goto L_0x0077;
                    default: goto L_0x0076;
                }
            L_0x0076:
                return r8
            L_0x0077:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
                return r11
            L_0x007c:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
                return r11
            L_0x0081:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
                return r11
            L_0x0086:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
                return r11
            L_0x008b:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
                return r11
            L_0x0090:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
                return r11
            L_0x0095:
                return r8
            L_0x0096:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.inputActionFromTextInputAction(java.lang.String):java.lang.Integer");
        }
    }

    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        @NonNull
        public final String encodedName;

        /* access modifiers changed from: public */
        TextCapitalization(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i2, int i3, int i4, int i5) throws IndexOutOfBoundsException {
            if (!(i2 == -1 && i3 == -1) && (i2 < 0 || i3 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i2) + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(i3) + ")");
            } else if (!(i4 == -1 && i5 == -1) && (i4 < 0 || i4 > i5)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i4) + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(i5) + ")");
            } else if (i5 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i4));
            } else if (i2 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i2));
            } else if (i3 <= str.length()) {
                this.text = str;
                this.selectionStart = i2;
                this.selectionEnd = i3;
                this.composingStart = i4;
                this.composingEnd = i5;
            } else {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i3));
            }
        }

        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i2 = this.composingStart;
            return i2 >= 0 && this.composingEnd > i2;
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }
    }

    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i2, @NonNull Configuration configuration);

        void setEditableSizeAndTransform(double d, double d2, double[] dArr);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i2, boolean z);

        void show();
    }

    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        
        @NonNull
        public final String encodedName;

        /* access modifiers changed from: public */
        TextInputType(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodHandler);
    }

    public static HashMap<Object, Object> createEditingDeltaJSON(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<TextEditingDelta> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    public static HashMap<Object, Object> createEditingStateJSON(String str, int i2, int i3, int i4, int i5) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i2));
        hashMap.put("selectionExtent", Integer.valueOf(i3));
        hashMap.put("composingBase", Integer.valueOf(i4));
        hashMap.put("composingExtent", Integer.valueOf(i5));
        return hashMap;
    }

    public void done(int i2) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.done"}));
    }

    public void go(int i2) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.go"}));
    }

    public void newline(int i2) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.newline"}));
    }

    public void next(int i2) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.next"}));
    }

    public void performPrivateCommand(int i2, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[]{Integer.valueOf(i2), hashMap}));
    }

    public void previous(int i2) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.previous"}));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", (Object) null);
    }

    public void search(int i2) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.search"}));
    }

    public void send(int i2) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.send"}));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler2) {
        this.textInputMethodHandler = textInputMethodHandler2;
    }

    public void unspecifiedAction(int i2) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i2), "TextInputAction.unspecified"}));
    }

    public void updateEditingState(int i2, String str, int i3, int i4, int i5, int i6) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i3 + "\nSelection end: " + i4 + "\nComposing start: " + i5 + "\nComposing end: " + i6);
        HashMap<Object, Object> createEditingStateJSON = createEditingStateJSON(str, i3, i4, i5, i6);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[]{Integer.valueOf(i2), createEditingStateJSON}));
    }

    public void updateEditingStateWithDeltas(int i2, ArrayList<TextEditingDelta> arrayList) {
        Log.v(TAG, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        HashMap<Object, Object> createEditingDeltaJSON = createEditingDeltaJSON(arrayList);
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(new Serializable[]{Integer.valueOf(i2), createEditingDeltaJSON}));
    }

    public void updateEditingStateWithTag(int i2, HashMap<String, TextEditState> hashMap) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : hashMap.entrySet()) {
            TextEditState textEditState = (TextEditState) next.getValue();
            hashMap2.put((String) next.getKey(), createEditingStateJSON(textEditState.text, textEditState.selectionStart, textEditState.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[]{Integer.valueOf(i2), hashMap2}));
    }
}
