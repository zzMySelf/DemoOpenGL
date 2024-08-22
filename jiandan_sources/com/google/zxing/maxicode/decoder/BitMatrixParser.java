package com.google.zxing.maxicode.decoder;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.location.GpsStatusWrapper;
import androidx.core.widget.AutoScrollHelper;
import androidx.media.AudioAttributesCompat;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.alipay.sdk.m.u.n;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
import com.google.common.math.DoubleMath;
import com.google.common.net.InternetDomainName;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Reader;
import com.tera.scan.ui.widget.RotateProgress;
import okhttp3.internal.http.StatusLine;

public final class BitMatrixParser {
    public static final int[][] BITNR = {new int[]{121, 120, 127, 126, ScriptIntrinsicBLAS.RsBlas_zsyrk, 132, ScriptIntrinsicBLAS.RsBlas_cher2k, ScriptIntrinsicBLAS.RsBlas_cherk, 145, 144, 151, 150, 157, 156, IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD, 162, 169, a.e, 175, 174, 181, 180, 187, 186, GpsStatusWrapper.QZSS_SVID_MIN, 192, 199, 198, -2, -2}, new int[]{123, 122, ScriptIntrinsicBLAS.RsBlas_ctrmm, 128, ScriptIntrinsicBLAS.RsBlas_ztrmm, ScriptIntrinsicBLAS.RsBlas_zsyr2k, 141, ScriptIntrinsicBLAS.RsBlas_zhemm, 147, 146, 153, 152, 159, IChannelPay.ID_WX_PAY, IChannelPay.ID_IPAY_PAY_SMS, IChannelPay.ID_IPAY_PAY_GAME, 171, DoubleMath.MAX_FACTORIAL, 177, 176, IDevices.EM_AARCH64, 182, 189, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, ScriptIntrinsicBLAS.RsBlas_ztrsm, 143, 142, 149, Code39Reader.ASTERISK_ENCODING, 155, 154, 161, 160, 167, IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE, 173, 172, 179, IChannelPay.ID_BANK_CARD_PAY, 185, 184, 191, ShareCallPacking.SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION, 197, 196, BindVerifyActivity.w, BindVerifyActivity.v, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, InternetDomainName.MAX_LENGTH, 252, LightappBusinessClient.REQUEST_PERMISSION_UNIVERSAL_SET, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE, 241, AuthorityState.STATE_ERROR_NETWORK, 235, 234, 229, 228, 223, 222, IndicatorViewController.CAPTION_TRANSLATE_Y_ANIMATION_DURATION, 216, 211, 210, BindVerifyActivity.y, BindVerifyActivity.x, 819, -3}, new int[]{285, 284, 279, 278, AudioAttributesCompat.FLAG_ALL_PUBLIC, AuthorityState.STATE_INIT_ING, 267, 266, 261, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD, 255, 254, 249, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 242, 237, 236, 231, 230, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 224, 219, 218, 213, 212, 207, BindVerifyActivity.z, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, 250, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, 239, QuickLoginDialog.HEIGHT_ONEKEY, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, StatusLine.HTTP_TEMP_REDIRECT, BindVerifyActivity.G, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, RotateProgress.FULL_DEGREE, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, BindVerifyActivity.D, 302, 309, StatusLine.HTTP_PERM_REDIRECT, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 314, 321, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, BindVerifyActivity.F, BindVerifyActivity.E, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, BindVerifyActivity.J, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, BindVerifyActivity.M, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, BindVerifyActivity.O, BindVerifyActivity.N, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, StatusCodeException.IGNORE_429_CODE, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, n.f685i, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, BindVerifyActivity.Q, 504, FrameMetricsAggregator.EVERY_DURATION, 510, PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST, 516, 842, 841}, new int[]{489, 488, 495, 494, IMPushPb.ActionType.REQUEST_VALUE, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, StatusCodes.SERVICE_UNAVAILABLE, StatusCodes.BAD_GATEWAY, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, PayBeanFactory.BEAN_ID_CHECK_PWD, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, WalletOuterInterfaceBean.BEAN_ID_GET_WALLET_INTERFACE, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, PayBeanFactory.BEAN_ID_WIDTHDRAW, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, PayBeanFactory.BEAN_ID_SCANCODE_SEND_SMS_TO_PAY, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 601, 600, 607, PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, 613, 612, PayBeanFactory.BEAN_ID_QUERY_OFFLINE_PAY, PayBeanFactory.BEAN_ID_CASHIER_PROTOCOL_PREVIEW, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, PayBeanFactory.BEAN_ID_CARD_ADD, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 603, 602, 609, 608, 615, 614, PayBeanFactory.BEAN_ID_GET_JOB, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, 605, 604, 611, 610, 617, 616, 623, PayBeanFactory.BEAN_ID_LICAI_BALANCE_PAY, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, CameraUtilsForScan.MAX_SIZE_HEIGHT, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, IMPushPb.ActionType.MSG_VALUE, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, BankSignFactory.BEAN_ID_POLLING, 768, 775, 774, 781, 780, BeanConstants.BEAN_ID_FOR_SPARE_INIT, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, BankSignFactory.BEAN_ID_BIND_CARD, BankSignFactory.BEAN_ID_QUERY, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    public final BitMatrix bitMatrix;

    public BitMatrixParser(BitMatrix bitMatrix2) {
        this.bitMatrix = bitMatrix2;
    }

    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i2 = 0; i2 < height; i2++) {
            int[] iArr = BITNR[i2];
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[i3];
                if (i4 >= 0 && this.bitMatrix.get(i3, i2)) {
                    int i5 = i4 / 6;
                    bArr[i5] = (byte) (((byte) (1 << (5 - (i4 % 6)))) | bArr[i5]);
                }
            }
        }
        return bArr;
    }
}
