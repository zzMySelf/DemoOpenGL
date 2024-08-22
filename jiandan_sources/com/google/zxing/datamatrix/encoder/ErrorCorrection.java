package com.google.zxing.datamatrix.encoder;

import androidx.core.location.GpsStatusWrapper;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.apollon.a;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.google.common.net.InternetDomainName;

public final class ErrorCorrection {
    public static final int[] ALOG = new int[255];
    public static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, ScriptIntrinsicBLAS.RsBlas_zsyr2k, AuthorityState.STATE_ERROR_NETWORK, 92, 254}, new int[]{28, 24, 185, IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE, 223, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 116, 255, 110, 61}, new int[]{175, ScriptIntrinsicBLAS.RsBlas_cherk, BindVerifyActivity.y, 12, 194, a.e, 39, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 60, 97, 120}, new int[]{41, 153, IChannelPay.ID_WX_PAY, 91, 61, 42, 142, 213, 97, IChannelPay.ID_BANK_CARD_PAY, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, ScriptIntrinsicBLAS.RsBlas_cherk, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, ScriptIntrinsicBLAS.RsBlas_ctrmm, 94, 254, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 48, 90, 188}, new int[]{15, 195, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, 9, 233, 71, a.e, 2, 188, 160, 153, 145, InternetDomainName.MAX_LENGTH, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, ShareCallPacking.SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION, 88, BindVerifyActivity.y, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, GpsStatusWrapper.QZSS_SVID_MIN}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, DoubleMath.MAX_FACTORIAL, 53, 75, 34, 249, 121, 17, ScriptIntrinsicBLAS.RsBlas_cherk, 110, 213, 141, ScriptIntrinsicBLAS.RsBlas_ztrsm, 120, 151, 233, a.e, 93, 255}, new int[]{LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 98, 81, 112}, new int[]{77, GpsStatusWrapper.QZSS_SVID_MIN, 137, 31, 19, 38, 22, 153, LightappBusinessClient.REQUEST_PERMISSION_UNIVERSAL_SET, 105, 122, 2, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, ScriptIntrinsicBLAS.RsBlas_zsyrk, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, InternetDomainName.MAX_LENGTH, 57, 54, 101, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, BindVerifyActivity.v, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 132, 172, 223, 96, 32, 117, 22, QuickLoginDialog.HEIGHT_ONEKEY, ScriptIntrinsicBLAS.RsBlas_zsyrk, QuickLoginDialog.HEIGHT_ONEKEY, 231, BindVerifyActivity.y, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, DoubleMath.MAX_FACTORIAL, BindVerifyActivity.y, 131, 88, 120, 100, 66, ScriptIntrinsicBLAS.RsBlas_cherk, 186, AuthorityState.STATE_ERROR_NETWORK, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, InternetDomainName.MAX_LENGTH, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 19}, new int[]{175, 9, 223, QuickLoginDialog.HEIGHT_ONEKEY, 12, 17, 220, 208, 100, 29, 175, DoubleMath.MAX_FACTORIAL, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, BindVerifyActivity.w, 29, 232, 144, QuickLoginDialog.HEIGHT_ONEKEY, 22, 150, 201, 117, 62, 207, IChannelPay.ID_IPAY_PAY_GAME, 13, 137, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 127, 67, LightappBusinessClient.REQUEST_PERMISSION_UNIVERSAL_SET, 28, 155, 43, BindVerifyActivity.w, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, BindVerifyActivity.v, 188, 201, 189, 143, 108, 196, 37, 185, 112, ScriptIntrinsicBLAS.RsBlas_zsyr2k, 230, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 63, 197, ShareCallPacking.SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD, 31, 176, DoubleMath.MAX_FACTORIAL, 4, 107, 232, 7, 94, IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE, 224, 124, 86, 47, 11, BindVerifyActivity.x}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, 154, 36, 73, 127, 213, ScriptIntrinsicBLAS.RsBlas_ztrsm, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 180, 234, 197, IChannelPay.ID_WX_PAY, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, ScriptIntrinsicBLAS.RsBlas_cher2k, 153, 185, BindVerifyActivity.v, 167, 179, 25, 220, 232, 96, 210, 231, ScriptIntrinsicBLAS.RsBlas_ztrsm, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    public static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    public static final int[] LOG = new int[256];
    public static final int MODULO_VALUE = 301;

    static {
        int i2 = 1;
        for (int i3 = 0; i3 < 255; i3++) {
            ALOG[i3] = i2;
            LOG[i2] = i3;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= 301;
            }
        }
    }

    public static String createECCBlock(CharSequence charSequence, int i2) {
        return createECCBlock(charSequence, 0, charSequence.length(), i2);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i2 = 0;
                while (i2 < interleavedBlockCount) {
                    int i3 = i2 + 1;
                    iArr[i2] = symbolInfo.getDataLengthForInterleavedBlock(i3);
                    iArr2[i2] = symbolInfo.getErrorLengthForInterleavedBlock(i3);
                    iArr3[i2] = 0;
                    if (i2 > 0) {
                        iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                    }
                    i2 = i3;
                }
                for (int i4 = 0; i4 < interleavedBlockCount; i4++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i4]);
                    for (int i5 = i4; i5 < symbolInfo.getDataCapacity(); i5 += interleavedBlockCount) {
                        sb2.append(str.charAt(i5));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i4]);
                    int i6 = i4;
                    int i7 = 0;
                    while (i6 < iArr2[i4] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.getDataCapacity() + i6, createECCBlock.charAt(i7));
                        i6 += interleavedBlockCount;
                        i7++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    public static String createECCBlock(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i5 >= iArr.length) {
                i5 = -1;
                break;
            } else if (iArr[i5] == i4) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 >= 0) {
            int[] iArr2 = FACTORS[i5];
            char[] cArr = new char[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                cArr[i6] = 0;
            }
            for (int i7 = i2; i7 < i2 + i3; i7++) {
                int i8 = i4 - 1;
                char charAt = cArr[i8] ^ charSequence.charAt(i7);
                while (i8 > 0) {
                    if (charAt == 0 || iArr2[i8] == 0) {
                        cArr[i8] = cArr[i8 - 1];
                    } else {
                        char c = cArr[i8 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i8] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i8]]) % 255]);
                    }
                    i8--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                }
            }
            char[] cArr2 = new char[i4];
            for (int i9 = 0; i9 < i4; i9++) {
                cArr2[i9] = cArr[(i4 - i9) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i4)));
    }
}
