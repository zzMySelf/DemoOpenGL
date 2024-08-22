package com.google.zxing.pdf417.encoder;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.location.GpsStatusWrapper;
import androidx.core.widget.AutoScrollHelper;
import androidx.media.AudioAttributesCompat;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.alipay.sdk.m.u.n;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.util.devices.IDevices;
import com.baidu.apollon.a;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.WalletOuterInterfaceBean;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidubce.http.StatusCodes;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.IndicatorViewController;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code39Reader;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import okhttp3.internal.http.StatusLine;

public final class PDF417ErrorCorrection {
    public static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, StatusLine.HTTP_PERM_REDIRECT, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, DecodedBitStreamParser.MACRO_PDF417_TERMINATOR, WalletOuterInterfaceBean.BEAN_ID_GET_WALLET_INTERFACE, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, GpsStatusWrapper.QZSS_SVID_MIN, PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST, AudioAttributesCompat.FLAG_ALL_PUBLIC, 494, 263, 147, 593, 800, 571, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 803, ScriptIntrinsicBLAS.RsBlas_zsyrk, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, BankSignFactory.BEAN_ID_BIND_CARD, 453, 106, 610, 287, 107, BindVerifyActivity.Q, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, 400, 672, 762, 283, 184, 440, 35, 519, 31, n.f685i, PayBeanFactory.BEAN_ID_SCANCODE_PAY, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 535, PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST, 352, 605, IChannelPay.ID_WX_PAY, 651, 201, 488, StatusCodes.BAD_GATEWAY, 648, 733, 717, 83, 404, 97, 280, BankSignFactory.BEAN_ID_BIND_CARD, 840, 629, 4, 381, 843, 623, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, IndicatorViewController.CAPTION_TRANSLATE_Y_ANIMATION_DURATION, 208, 928, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, 583, 620, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE, Code39Reader.ASTERISK_ENCODING, 447, 631, 292, 908, 490, 704, 516, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, 457, 907, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 723, 674, 292, AuthorityState.STATE_INIT_ING, 96, 684, 432, 686, PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, 860, 569, GpsStatusWrapper.QZSS_SVID_MIN, 219, ScriptIntrinsicBLAS.RsBlas_ctrmm, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST, 834, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 550, 86, 801, 4, 108, 539}, new int[]{PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 894, 75, 766, 882, 857, 74, BindVerifyActivity.x, 82, 586, 708, 250, 905, 786, ScriptIntrinsicBLAS.RsBlas_cherk, CameraUtilsForScan.MAX_SIZE_HEIGHT, 858, 194, 311, 913, 275, ShareCallPacking.SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, BindVerifyActivity.x, 796, 605, 540, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, AuthorityState.STATE_ERROR_NETWORK, 216, 257, 284, 549, 209, 884, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, StatusLine.HTTP_TEMP_REDIRECT, 291, 803, 712, 19, 358, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 289, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, ScriptIntrinsicBLAS.RsBlas_ztrsm, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, ScriptIntrinsicBLAS.RsBlas_zsyr2k, 628, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 479, 130, 739, 71, 263, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, 177, 752, 607, 640, 455, GpsStatusWrapper.QZSS_SVID_MIN, 689, 707, 805, 641, 48, 60, 732, PayBeanFactory.BEAN_ID_GET_JOB, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, 434, 421, 726, 528, StatusCodes.SERVICE_UNAVAILABLE, 118, 49, 795, 32, 144, 500, QuickLoginDialog.HEIGHT_ONEKEY, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, ScriptIntrinsicBLAS.RsBlas_zsyr2k, 54, 834, 299, DecodedBitStreamParser.MACRO_PDF417_TERMINATOR, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, BindVerifyActivity.J, 41, 656, BindVerifyActivity.Q, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, StatusLine.HTTP_TEMP_REDIRECT, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, BindVerifyActivity.G, 88, 87, GpsStatusWrapper.QZSS_SVID_MIN, 352, 781, 846, 75, 327, 520, 435, 543, BindVerifyActivity.w, 666, 249, 346, 781, PayBeanFactory.BEAN_ID_GET_JOB, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, AuthorityState.STATE_INIT_ING, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, BindVerifyActivity.x, 681, BindVerifyActivity.O, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, AuthorityState.STATE_ERROR_NETWORK, 518, 794, 395, 768, 848, 51, 610, 384, a.e, ShareCallPacking.SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION, 826, 328, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 786, BindVerifyActivity.D, 570, 381, 415, 641, 156, 237, 151, StatusCodeException.IGNORE_429_CODE, 531, 207, 676, 710, 89, a.e, BindVerifyActivity.E, BindVerifyActivity.J, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, IChannelPay.ID_IPAY_PAY_GAME, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, BankSignFactory.BEAN_ID_BIND_CARD, 95, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 288, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, GpsStatusWrapper.QZSS_SVID_MIN, 417, IChannelPay.ID_WX_PAY, 209, 563, 564, 343, 693, 109, 608, 563, 365, 181, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, 677, 310, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, PayBeanFactory.BEAN_ID_CASHIER_PROTOCOL_PREVIEW, 586, 424, 833, 77, PayBeanFactory.BEAN_ID_CARD_ADD, 346, 269, 757, 632, 695, 751, 331, LightappBusinessClient.REQUEST_PERMISSION_UNIVERSAL_SET, 184, 45, BeanConstants.BEAN_ID_FOR_SPARE_INIT, 680, 18, 66, BindVerifyActivity.O, 369, 54, 492, 228, 613, 830, DecodedBitStreamParser.MACRO_PDF417_TERMINATOR, 437, 519, 644, 905, 789, 420, BindVerifyActivity.F, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, CameraUtilsForScan.MAX_SIZE_HEIGHT, 224, StatusLine.HTTP_TEMP_REDIRECT, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, BindVerifyActivity.D, 843, DecodedBitStreamParser.MACRO_PDF417_TERMINATOR, 281, 73, 469, 791, 660, 162, 498, StatusLine.HTTP_PERM_REDIRECT, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, AudioAttributesCompat.FLAG_ALL_PUBLIC, 610, 296, IDevices.EM_AARCH64, DecodedBitStreamParser.BEGIN_MACRO_PDF417_OPTIONAL_FIELD, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, CameraUtilsForScan.MAX_SIZE_HEIGHT, 742, 330, 5, 39, DecodedBitStreamParser.BEGIN_MACRO_PDF417_OPTIONAL_FIELD, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, ShareCallPacking.SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION, 531, 297, 321, 762, 752, 533, 175, ScriptIntrinsicBLAS.RsBlas_zsyr2k, 14, 381, 433, 717, 45, 111, 20, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 284, 736, ScriptIntrinsicBLAS.RsBlas_cherk, 646, 411, 877, 669, 141, 919, 45, 780, BindVerifyActivity.O, IChannelPay.ID_IPAY_PAY_GAME, 332, 899, IChannelPay.ID_IPAY_PAY_SMS, 726, 600, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, BindVerifyActivity.E, 282, 738, 675, 410, 389, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, 31, 121, BindVerifyActivity.D, 263}};

    public static String generateErrorCorrection(CharSequence charSequence, int i2) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i2);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i3) + cArr[i4]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i4 > 0) {
                cArr[i4] = (char) ((cArr[i4 - 1] + (929 - ((EC_COEFFICIENTS[i2][i4] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i4--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i2][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i5 = errorCorrectionCodewordCount - 1; i5 >= 0; i5--) {
            if (cArr[i5] != 0) {
                cArr[i5] = (char) (929 - cArr[i5]);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }

    public static int getErrorCorrectionCodewordCount(int i2) {
        if (i2 >= 0 && i2 <= 8) {
            return 1 << (i2 + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i2) throws WriterException {
        if (i2 <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i2 <= 40) {
            return 2;
        } else {
            if (i2 <= 160) {
                return 3;
            }
            if (i2 <= 320) {
                return 4;
            }
            if (i2 <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }
}
