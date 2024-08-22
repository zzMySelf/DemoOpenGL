package com.baidu.helios.common.gene.a.a;

import com.baidu.helios.common.gene.interfaces.HeliosKey;
import com.baidu.searchbox.talos.modules.RNSearchBoxIMModule;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f13128a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int f13129b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13130c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13131d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13132e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f13133f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13134g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f13135h = 2;

    /* renamed from: i  reason: collision with root package name */
    private int f13136i;
    private d k;
    private byte[] m;
    private int n;
    private int o;
    private HeliosKey p;

    private void a(int i2, HeliosKey heliosKey, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
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
        if (heliosKey instanceof HeliosKey) {
            this.f13136i = z ? 1 : 4;
            this.p = heliosKey;
            int a2 = a.a(heliosKey.getModulus());
            this.o = a2;
            this.n = 0;
            int i4 = this.f13135h;
            if (i4 == 1) {
                if (algorithmParameterSpec == null) {
                    this.k = d.a(3, a2);
                    this.m = new byte[a2];
                    return;
                }
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            } else if (i4 != 2) {
                throw new InvalidKeyException("PEAO not supported");
            } else if (algorithmParameterSpec == null) {
                if (this.f13136i <= 2) {
                    i3 = 2;
                }
                d a3 = d.a(i3, a2);
                this.k = a3;
                if (z) {
                    this.m = new byte[a3.a()];
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
                switch (this.f13136i) {
                    case 1:
                        throw new UnsupportedOperationException("only verify supported");
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

    public void a(int i2) {
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                throw new NoSuchPaddingException("Padding " + i2 + " not supported");
            }
        }
        this.f13135h = i3;
    }

    public void a(int i2, HeliosKey heliosKey) {
        try {
            a(i2, heliosKey, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException e2) {
            InvalidKeyException invalidKeyException = new InvalidKeyException(RNSearchBoxIMModule.INPUT_PARAMS_TRANSFORM_ERROR);
            invalidKeyException.initCause(e2);
            throw invalidKeyException;
        }
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        b(bArr, i2, i3);
        return a();
    }
}
