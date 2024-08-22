package com.baidu.wallet.paysdk.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.storage.PayPreferenceManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

@TargetApi(23)
public class a extends FingerprintManager.AuthenticationCallback {
    public FingerprintManager a;
    public com.baidu.wallet.paysdk.fingerprint.a b;
    public b c;
    public CancellationSignal d;
    public int e = 1;
    public String f;
    public Context g;
    public int h = 0;

    public a(Context context) throws KeyStoreException {
        this.g = context;
        this.a = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        this.b = com.baidu.wallet.paysdk.fingerprint.a.a(context);
    }

    private void e() {
        this.e = 1;
        if (this.c != null && !TextUtils.isEmpty(this.f)) {
            try {
                FingerprintManager.CryptoObject a2 = this.b.a(1, (byte[]) null);
                if (a2 != null) {
                    CancellationSignal cancellationSignal = new CancellationSignal();
                    this.d = cancellationSignal;
                    this.a.authenticate(a2, cancellationSignal, 0, this, (Handler) null);
                } else if (this.c != null) {
                    this.c.a(-1, "");
                }
            } catch (SecurityException e2) {
                LogUtil.e("FingerprintPresenter", e2.getMessage(), e2);
                StatisticManager.onEvent("fprd_security_exception_occued_on_encrypt");
                b bVar = this.c;
                if (bVar != null) {
                    bVar.a(-1, "");
                }
            } catch (InvalidKeyException unused) {
                b bVar2 = this.c;
                if (bVar2 != null) {
                    bVar2.a(-3, ResUtils.getString(this.g, "wallet_fp_fingerprint_changed"));
                }
            }
        }
    }

    private void f() {
        String str;
        String[] split = new String(Base64.decode(WalletFingerprint.getInstance(this.g).getEncryptFingerprintData(), 0)).split("\\|");
        if (split.length == 3) {
            this.f = split[0];
            str = split[1];
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f)) {
            StatisticManager.onEventWithValue("fprd_start_fp_failed", "impossible case: decrypttoken & reason : encrypt_base64_IV or operateData is null");
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(-1, "");
                return;
            }
            return;
        }
        this.e = 2;
        try {
            FingerprintManager.CryptoObject a2 = this.b.a(2, Base64.decode(str, 0));
            if (a2 == null) {
                StatisticManager.onEventWithValue("fprd_start_fp_failed", "case: decrypttoken & reason : cryptObject is null");
                if (this.c != null) {
                    this.c.a(-1, "");
                    return;
                }
                return;
            }
            CancellationSignal cancellationSignal = new CancellationSignal();
            this.d = cancellationSignal;
            this.a.authenticate(a2, cancellationSignal, 0, this, (Handler) null);
        } catch (SecurityException e2) {
            LogUtil.e("FingerprintPresenter", e2.getMessage(), e2);
            StatisticManager.onEventWithValue("fprd_start_fp_failed", "case: decrypttoken & reason : SecurityException happends");
            b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a(-1, "");
            }
        } catch (InvalidKeyException e3) {
            LogUtil.e("FingerprintPresenter", e3.getMessage(), e3);
            WalletFingerprint.getInstance(this.g).clearOTPToken();
            b bVar3 = this.c;
            if (bVar3 != null) {
                bVar3.a(-3, ResUtils.getString(this.g, "wallet_fp_changed_usepwd"));
            }
        } catch (Exception e4) {
            LogUtil.e("FingerprintPresenter", e4.getMessage(), e4);
            StatisticManager.onEventWithValue("fprd_start_fp_failed", "case: decrypttoken & reason : exception is" + e4.getLocalizedMessage());
            b bVar4 = this.c;
            if (bVar4 != null) {
                bVar4.a(-1, "");
            }
        }
    }

    public void a(String str) {
        this.f = str;
    }

    public void b() {
        e();
    }

    public void c() {
        f();
    }

    public void d() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = null;
    }

    public void onAuthenticationError(int i2, CharSequence charSequence) {
        String str;
        b bVar;
        super.onAuthenticationError(i2, charSequence);
        "onAuthenticationError code=" + i2 + " # " + charSequence;
        if (i2 == 7 || i2 == 9) {
            if (this.e == 1) {
                str = ResUtils.getString(this.g, "wallet_fp_try_too_many_times_try_later");
            } else {
                str = ResUtils.getString(this.g, "wallet_fp_error_fp_many_times_usepwd");
            }
            b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a(-6, str);
            }
        } else if ((i2 == 5 || i2 == 10) && (bVar = this.c) != null) {
            bVar.a(-8, ResUtils.getString(this.g, "wallet_fp_user_canceled"));
        }
    }

    public void onAuthenticationFailed() {
        String str;
        super.onAuthenticationFailed();
        this.h++;
        "onAuthenticationFailed  reTryCount=" + this.h;
        if (this.h >= 3) {
            if (this.e == 1) {
                str = ResUtils.getString(this.g, "wallet_fp_try_too_many_times_try_later");
            } else {
                str = ResUtils.getString(this.g, "wallet_fp_error_fp_many_times_usepwd");
            }
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(-4, str);
            }
            this.h = 0;
            return;
        }
        b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.a(-5, ResUtils.getString(this.g, "wallet_fp_error_fp"));
        }
    }

    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        "onAuthenticationHelp!  helpCode=" + i2 + " & helpString=" + charSequence;
        super.onAuthenticationHelp(i2, charSequence);
    }

    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        if (this.c != null) {
            Cipher cipher = authenticationResult.getCryptoObject().getCipher();
            if (this.e != 2) {
                String str = null;
                try {
                    String[] split = this.f.split("\\|");
                    if (split.length == 2) {
                        str = split[0];
                        this.f = split[1];
                    }
                    byte[] doFinal = cipher.doFinal(this.f.getBytes());
                    byte[] iv = cipher.getIV();
                    if (doFinal != null) {
                        if (iv != null) {
                            String encodeToString = Base64.encodeToString(doFinal, 0);
                            String encodeToString2 = Base64.encodeToString(iv, 0);
                            String encodeToString3 = Base64.encodeToString((encodeToString + "|" + encodeToString2 + "|" + str).getBytes(), 0);
                            String newPpKey = PayPreferenceManager.getNewPpKey(this.g);
                            if (!TextUtils.isEmpty(newPpKey)) {
                                SharedPreferencesUtils.setParam(this.g, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, newPpKey, encodeToString3);
                            }
                            this.c.a(0, encodeToString);
                            return;
                        }
                    }
                    this.c.a(-2, "");
                } catch (BadPaddingException | IllegalBlockSizeException e2) {
                    LogUtil.e("FingerprintPresenter", e2.getMessage(), e2);
                    this.c.a(-2, "");
                }
            } else if (!TextUtils.isEmpty(this.f)) {
                try {
                    String str2 = new String(cipher.doFinal(Base64.decode(this.f, 0)));
                    String generateOTPKey = WalletFingerprint.getInstance(this.g).generateOTPKey(str2);
                    String sn = WalletFingerprint.getInstance(this.g).getSN();
                    if (TextUtils.isEmpty(generateOTPKey) || TextUtils.isEmpty(sn)) {
                        IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(this.g).getFingerprintPay();
                        if (fingerprintPay != null) {
                            fingerprintPay.closeFingerprint(this.g);
                        }
                        this.c.a(-7, ResUtils.getString(this.g, "wallet_fp_token_null"));
                        return;
                    }
                    this.c.a(0, str2);
                } catch (BadPaddingException | IllegalBlockSizeException e3) {
                    LogUtil.e("FingerprintPresenter", e3.getMessage(), e3);
                    WalletFingerprint.getInstance(this.g).clearOTPToken();
                    this.c.a(-3, ResUtils.getString(this.g, "wallet_fp_changed_usepwd"));
                    StatisticManager.onEvent("fprd_BadPaddingException_IllegalBlockSizeException");
                }
            } else {
                throw new IllegalArgumentException(" #the data to encrypt/decrypt is null! ");
            }
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a() {
        CancellationSignal cancellationSignal = this.d;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
            this.d = null;
        }
    }

    public void a(int i2) {
        if (i2 == 1) {
            b();
        } else if (i2 == 2) {
            c();
        }
    }
}
