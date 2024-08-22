package com.baidu.ad.magic.flute.update.c.a.a;

import com.baidu.ad.magic.flute.update.b.b.a.a;
import com.baidu.searchbox.talos.modules.RNSearchBoxIMModule;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2712a = "PKCS1Padding";

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f2713b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static final int f2714c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f2715d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f2716e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static final int f2717f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final String f2718g = "NoPadding";

    /* renamed from: h  reason: collision with root package name */
    private static final String f2719h = "OAEP";

    /* renamed from: i  reason: collision with root package name */
    private int f2720i;

    /* renamed from: j  reason: collision with root package name */
    private String f2721j = "PKCS1Padding";
    private d k;
    private OAEPParameterSpec l = null;
    private byte[] m;
    private int n;
    private int o;
    private a p;
    private String q = "SHA-1";

    private void a(int i2, a aVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        int i3 = 1;
        switch (i2) {
            case 1:
            case 3:
                z = true;
                break;
            case 2:
            case 4:
                z = false;
                break;
            default:
                throw new InvalidKeyException("Unknown mode: " + i2);
        }
        if (aVar instanceof a) {
            this.f2720i = z ? 1 : 4;
            this.p = aVar;
            int a2 = a.a(aVar.a());
            this.o = a2;
            this.n = 0;
            String str = this.f2721j;
            if (str == f2718g) {
                if (algorithmParameterSpec == null) {
                    this.k = d.a(3, a2, secureRandom);
                    this.m = new byte[a2];
                    return;
                }
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            } else if (str != "PKCS1Padding") {
                int i4 = this.f2720i;
                if (i4 == 3 || i4 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.q, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                } else {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                }
                d a3 = d.a(4, a2, secureRandom, oAEPParameterSpec);
                this.k = a3;
                if (z) {
                    this.m = new byte[a3.a()];
                } else {
                    this.m = new byte[a2];
                }
            } else if (algorithmParameterSpec == null) {
                if (this.f2720i <= 2) {
                    i3 = 2;
                }
                d a4 = d.a(i3, a2, secureRandom);
                this.k = a4;
                if (z) {
                    this.m = new byte[a4.a()];
                } else {
                    this.m = new byte[a2];
                }
            } else {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
        } else {
            throw new InvalidKeyException("only support helios key");
        }
    }

    private byte[] a() {
        int i2 = this.n;
        byte[] bArr = this.m;
        if (i2 <= bArr.length) {
            try {
                switch (this.f2720i) {
                    case 1:
                        byte[] a2 = a.a(this.k.a(bArr, 0, i2), this.p);
                        this.n = 0;
                        return a2;
                    case 2:
                        throw new UnsupportedOperationException("only verify supported");
                    case 3:
                        throw new UnsupportedOperationException("only verify supported");
                    case 4:
                        return this.k.b(a.a(a.a(bArr, 0, i2), this.p));
                    default:
                        throw new AssertionError("Internal error");
                }
            } finally {
                this.n = 0;
            }
            this.n = 0;
        }
        throw new IllegalBlockSizeException("Data must not be longer than " + this.m.length + " bytes");
    }

    private void b(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 != 0 && bArr != null) {
            int i5 = this.n;
            int i6 = i5 + i3;
            byte[] bArr2 = this.m;
            if (i6 > bArr2.length) {
                i4 = bArr2.length + 1;
            } else {
                System.arraycopy(bArr, i2, bArr2, i5, i3);
                i4 = this.n + i3;
            }
            this.n = i4;
        }
    }

    public void a(int i2, a aVar, SecureRandom secureRandom) {
        try {
            a(i2, aVar, secureRandom, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException e2) {
            InvalidKeyException invalidKeyException = new InvalidKeyException(RNSearchBoxIMModule.INPUT_PARAMS_TRANSFORM_ERROR);
            invalidKeyException.initCause(e2);
            throw invalidKeyException;
        }
    }

    public void a(String str) {
        if (!str.equalsIgnoreCase("ECB")) {
            throw new NoSuchAlgorithmException("Unsupported mode " + str);
        }
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        b(bArr, i2, i3);
        return a();
    }

    public void b(String str) {
        String str2 = f2718g;
        if (!str.equalsIgnoreCase(str2)) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase(str2)) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.f2721j = f2719h;
                    return;
                } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                } else {
                    this.f2721j = f2719h;
                    this.q = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.f2721j = str2;
    }
}
