package com.itextpdf.text.html;

import androidx.core.location.GpsStatusWrapper;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.util.devices.IDevices;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.google.common.net.InternetDomainName;
import com.google.zxing.oned.Code39Reader;
import fe.when.ad.c.qw;
import fe.when.ad.de;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WebColors extends HashMap<String, int[]> {
    public static final WebColors NAMES;
    public static final long serialVersionUID = 3542523100813372896L;

    static {
        WebColors webColors = new WebColors();
        NAMES = webColors;
        webColors.put("aliceblue", new int[]{AuthorityState.STATE_ERROR_NETWORK, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 255, 255});
        NAMES.put("antiquewhite", new int[]{250, 235, 215, 255});
        NAMES.put("aqua", new int[]{0, 255, 255, 255});
        NAMES.put("aquamarine", new int[]{127, 255, 212, 255});
        NAMES.put("azure", new int[]{AuthorityState.STATE_ERROR_NETWORK, 255, 255, 255});
        NAMES.put("beige", new int[]{LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 220, 255});
        NAMES.put("bisque", new int[]{255, 228, 196, 255});
        NAMES.put("black", new int[]{0, 0, 0, 255});
        NAMES.put("blanchedalmond", new int[]{255, 235, BindVerifyActivity.y, 255});
        NAMES.put("blue", new int[]{0, 0, 255, 255});
        NAMES.put("blueviolet", new int[]{ScriptIntrinsicBLAS.RsBlas_cherk, 43, 226, 255});
        NAMES.put("brown", new int[]{IChannelPay.ID_IPAY_PAY_SMS, 42, 42, 255});
        NAMES.put("burlywood", new int[]{222, 184, ScriptIntrinsicBLAS.RsBlas_ztrmm, 255});
        NAMES.put("cadetblue", new int[]{95, IChannelPay.ID_WX_PAY, 160, 255});
        NAMES.put("chartreuse", new int[]{127, 255, 0, 255});
        NAMES.put("chocolate", new int[]{210, 105, 30, 255});
        NAMES.put("coral", new int[]{255, 127, 80, 255});
        NAMES.put("cornflowerblue", new int[]{100, 149, 237, 255});
        NAMES.put("cornsilk", new int[]{255, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 220, 255});
        NAMES.put("crimson", new int[]{220, 20, 60, 255});
        NAMES.put("cyan", new int[]{0, 255, 255, 255});
        NAMES.put("darkblue", new int[]{0, 0, ScriptIntrinsicBLAS.RsBlas_cher2k, 255});
        NAMES.put("darkcyan", new int[]{0, ScriptIntrinsicBLAS.RsBlas_cher2k, ScriptIntrinsicBLAS.RsBlas_cher2k, 255});
        NAMES.put("darkgoldenrod", new int[]{184, ScriptIntrinsicBLAS.RsBlas_zsyr2k, 11, 255});
        NAMES.put("darkgray", new int[]{169, 169, 169, 255});
        NAMES.put("darkgreen", new int[]{0, 100, 0, 255});
        NAMES.put("darkkhaki", new int[]{189, IDevices.EM_AARCH64, 107, 255});
        NAMES.put("darkmagenta", new int[]{ScriptIntrinsicBLAS.RsBlas_cher2k, 0, ScriptIntrinsicBLAS.RsBlas_cher2k, 255});
        NAMES.put("darkolivegreen", new int[]{85, 107, 47, 255});
        NAMES.put("darkorange", new int[]{255, ScriptIntrinsicBLAS.RsBlas_zhemm, 0, 255});
        NAMES.put("darkorchid", new int[]{153, 50, BindVerifyActivity.x, 255});
        NAMES.put("darkred", new int[]{ScriptIntrinsicBLAS.RsBlas_cher2k, 0, 0, 255});
        NAMES.put("darksalmon", new int[]{233, 150, 122, 255});
        NAMES.put("darkseagreen", new int[]{143, 188, 143, 255});
        NAMES.put("darkslateblue", new int[]{72, 61, ScriptIntrinsicBLAS.RsBlas_cher2k, 255});
        NAMES.put("darkslategray", new int[]{47, 79, 79, 255});
        NAMES.put("darkturquoise", new int[]{0, BindVerifyActivity.z, 209, 255});
        NAMES.put("darkviolet", new int[]{Code39Reader.ASTERISK_ENCODING, 0, 211, 255});
        NAMES.put("deeppink", new int[]{255, 20, 147, 255});
        NAMES.put("deepskyblue", new int[]{0, 191, 255, 255});
        NAMES.put("dimgray", new int[]{105, 105, 105, 255});
        NAMES.put("dodgerblue", new int[]{30, 144, 255, 255});
        NAMES.put("firebrick", new int[]{IChannelPay.ID_BANK_CARD_PAY, 34, 34, 255});
        NAMES.put("floralwhite", new int[]{255, 250, AuthorityState.STATE_ERROR_NETWORK, 255});
        NAMES.put("forestgreen", new int[]{34, ScriptIntrinsicBLAS.RsBlas_cher2k, 34, 255});
        NAMES.put("fuchsia", new int[]{255, 0, 255, 255});
        NAMES.put("gainsboro", new int[]{220, 220, 220, 255});
        NAMES.put("ghostwhite", new int[]{LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, 255, 255});
        NAMES.put("gold", new int[]{255, 215, 0, 255});
        NAMES.put("goldenrod", new int[]{218, IChannelPay.ID_IPAY_PAY_SMS, 32, 255});
        NAMES.put("gray", new int[]{128, 128, 128, 255});
        NAMES.put("green", new int[]{0, 128, 0, 255});
        NAMES.put("greenyellow", new int[]{173, 255, 47, 255});
        NAMES.put("honeydew", new int[]{AuthorityState.STATE_ERROR_NETWORK, 255, AuthorityState.STATE_ERROR_NETWORK, 255});
        NAMES.put("hotpink", new int[]{255, 105, 180, 255});
        NAMES.put("indianred", new int[]{BindVerifyActivity.y, 92, 92, 255});
        NAMES.put("indigo", new int[]{75, 0, 130, 255});
        NAMES.put("ivory", new int[]{255, 255, AuthorityState.STATE_ERROR_NETWORK, 255});
        NAMES.put("khaki", new int[]{AuthorityState.STATE_ERROR_NETWORK, 230, ScriptIntrinsicBLAS.RsBlas_zhemm, 255});
        NAMES.put("lavender", new int[]{230, 230, 250, 255});
        NAMES.put("lavenderblush", new int[]{255, AuthorityState.STATE_ERROR_NETWORK, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 255});
        NAMES.put("lawngreen", new int[]{124, 252, 0, 255});
        NAMES.put("lemonchiffon", new int[]{255, 250, BindVerifyActivity.y, 255});
        NAMES.put("lightblue", new int[]{173, 216, 230, 255});
        NAMES.put("lightcoral", new int[]{AuthorityState.STATE_ERROR_NETWORK, 128, 128, 255});
        NAMES.put("lightcyan", new int[]{224, 255, 255, 255});
        NAMES.put("lightgoldenrodyellow", new int[]{250, 250, 210, 255});
        NAMES.put("lightgreen", new int[]{144, QuickLoginDialog.HEIGHT_ONEKEY, 144, 255});
        NAMES.put("lightgrey", new int[]{211, 211, 211, 255});
        NAMES.put("lightpink", new int[]{255, 182, GpsStatusWrapper.QZSS_SVID_MIN, 255});
        NAMES.put("lightsalmon", new int[]{255, 160, 122, 255});
        NAMES.put("lightseagreen", new int[]{32, IChannelPay.ID_BANK_CARD_PAY, DoubleMath.MAX_FACTORIAL, 255});
        NAMES.put("lightskyblue", new int[]{ScriptIntrinsicBLAS.RsBlas_ztrmm, BindVerifyActivity.z, 250, 255});
        NAMES.put("lightslategray", new int[]{119, ScriptIntrinsicBLAS.RsBlas_ztrsm, 153, 255});
        NAMES.put("lightsteelblue", new int[]{176, 196, 222, 255});
        NAMES.put("lightyellow", new int[]{255, 255, 224, 255});
        NAMES.put("lime", new int[]{0, 255, 0, 255});
        NAMES.put("limegreen", new int[]{50, BindVerifyActivity.y, 50, 255});
        NAMES.put("linen", new int[]{250, AuthorityState.STATE_ERROR_NETWORK, 230, 255});
        NAMES.put("magenta", new int[]{255, 0, 255, 255});
        NAMES.put("maroon", new int[]{128, 0, 0, 255});
        NAMES.put("mediumaquamarine", new int[]{102, BindVerifyActivity.y, DoubleMath.MAX_FACTORIAL, 255});
        NAMES.put("mediumblue", new int[]{0, 0, BindVerifyActivity.y, 255});
        NAMES.put("mediumorchid", new int[]{186, 85, 211, 255});
        NAMES.put("mediumpurple", new int[]{147, 112, 219, 255});
        NAMES.put("mediumseagreen", new int[]{60, 179, 113, 255});
        NAMES.put("mediumslateblue", new int[]{123, 104, QuickLoginDialog.HEIGHT_ONEKEY, 255});
        NAMES.put("mediumspringgreen", new int[]{0, 250, 154, 255});
        NAMES.put("mediumturquoise", new int[]{72, 209, BindVerifyActivity.x, 255});
        NAMES.put("mediumvioletred", new int[]{199, 21, ScriptIntrinsicBLAS.RsBlas_zsyrk, 255});
        NAMES.put("midnightblue", new int[]{25, 25, 112, 255});
        NAMES.put("mintcream", new int[]{LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 255, 250, 255});
        NAMES.put("mistyrose", new int[]{255, 228, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 255});
        NAMES.put("moccasin", new int[]{255, 228, 181, 255});
        NAMES.put("navajowhite", new int[]{255, 222, 173, 255});
        NAMES.put("navy", new int[]{0, 0, 128, 255});
        NAMES.put("oldlace", new int[]{InternetDomainName.MAX_LENGTH, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 230, 255});
        NAMES.put("olive", new int[]{128, 128, 0, 255});
        NAMES.put("olivedrab", new int[]{107, 142, 35, 255});
        NAMES.put("orange", new int[]{255, IChannelPay.ID_IPAY_PAY_SMS, 0, 255});
        NAMES.put("orangered", new int[]{255, 69, 0, 255});
        NAMES.put("orchid", new int[]{218, 112, 214, 255});
        NAMES.put("palegoldenrod", new int[]{QuickLoginDialog.HEIGHT_ONEKEY, 232, DoubleMath.MAX_FACTORIAL, 255});
        NAMES.put("palegreen", new int[]{152, 251, 152, 255});
        NAMES.put("paleturquoise", new int[]{175, QuickLoginDialog.HEIGHT_ONEKEY, QuickLoginDialog.HEIGHT_ONEKEY, 255});
        NAMES.put("palevioletred", new int[]{219, 112, 147, 255});
        NAMES.put("papayawhip", new int[]{255, 239, 213, 255});
        NAMES.put("peachpuff", new int[]{255, 218, 185, 255});
        NAMES.put("peru", new int[]{BindVerifyActivity.y, ScriptIntrinsicBLAS.RsBlas_zsyrk, 63, 255});
        NAMES.put("pink", new int[]{255, 192, BindVerifyActivity.w, 255});
        NAMES.put("plum", new int[]{221, 160, 221, 255});
        NAMES.put("powderblue", new int[]{176, 224, 230, 255});
        NAMES.put("purple", new int[]{128, 0, 128, 255});
        NAMES.put("red", new int[]{255, 0, 0, 255});
        NAMES.put("rosybrown", new int[]{188, 143, 143, 255});
        NAMES.put("royalblue", new int[]{65, 105, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 255});
        NAMES.put("saddlebrown", new int[]{ScriptIntrinsicBLAS.RsBlas_cher2k, 69, 19, 255});
        NAMES.put("salmon", new int[]{250, 128, 114, 255});
        NAMES.put("sandybrown", new int[]{LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO, IChannelPay.ID_IPAY_PAY_GAME, 96, 255});
        NAMES.put("seagreen", new int[]{46, ScriptIntrinsicBLAS.RsBlas_cher2k, 87, 255});
        NAMES.put("seashell", new int[]{255, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, QuickLoginDialog.HEIGHT_ONEKEY, 255});
        NAMES.put("sienna", new int[]{160, 82, 45, 255});
        NAMES.put("silver", new int[]{192, 192, 192, 255});
        NAMES.put("skyblue", new int[]{ScriptIntrinsicBLAS.RsBlas_ztrmm, BindVerifyActivity.z, 235, 255});
        NAMES.put("slateblue", new int[]{106, 90, BindVerifyActivity.y, 255});
        NAMES.put("slategray", new int[]{112, 128, 144, 255});
        NAMES.put("snow", new int[]{255, 250, 250, 255});
        NAMES.put("springgreen", new int[]{0, 255, 127, 255});
        NAMES.put("steelblue", new int[]{70, 130, 180, 255});
        NAMES.put("tan", new int[]{210, 180, ScriptIntrinsicBLAS.RsBlas_zhemm, 255});
        NAMES.put("teal", new int[]{0, 128, 128, 255});
        NAMES.put("thistle", new int[]{216, 191, 216, 255});
        NAMES.put("tomato", new int[]{255, 99, 71, 255});
        NAMES.put("transparent", new int[]{0, 0, 0, 0});
        NAMES.put("turquoise", new int[]{64, 224, 208, 255});
        NAMES.put("violet", new int[]{QuickLoginDialog.HEIGHT_ONEKEY, 130, QuickLoginDialog.HEIGHT_ONEKEY, 255});
        NAMES.put("wheat", new int[]{LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 222, 179, 255});
        NAMES.put("white", new int[]{255, 255, 255, 255});
        NAMES.put("whitesmoke", new int[]{LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE, 255});
        NAMES.put("yellow", new int[]{255, 255, 0, 255});
        NAMES.put("yellowgreen", new int[]{154, BindVerifyActivity.y, 50, 255});
    }

    public static de getRGBColor(String str) throws IllegalArgumentException {
        int[] iArr = {0, 0, 0, 255};
        String lowerCase = str.toLowerCase();
        boolean missingHashColorFormat = missingHashColorFormat(lowerCase);
        if (lowerCase.startsWith(Bank.HOT_BANK_LETTER) || missingHashColorFormat) {
            if (!missingHashColorFormat) {
                lowerCase = lowerCase.substring(1);
            }
            if (lowerCase.length() == 3) {
                String substring = lowerCase.substring(0, 1);
                iArr[0] = Integer.parseInt(substring + substring, 16);
                String substring2 = lowerCase.substring(1, 2);
                iArr[1] = Integer.parseInt(substring2 + substring2, 16);
                String substring3 = lowerCase.substring(2);
                iArr[2] = Integer.parseInt(substring3 + substring3, 16);
                return new de(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else if (lowerCase.length() == 6) {
                iArr[0] = Integer.parseInt(lowerCase.substring(0, 2), 16);
                iArr[1] = Integer.parseInt(lowerCase.substring(2, 4), 16);
                iArr[2] = Integer.parseInt(lowerCase.substring(4), 16);
                return new de(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else {
                throw new IllegalArgumentException(qw.ad("unknown.color.format.must.be.rgb.or.rrggbb", new Object[0]));
            }
        } else if (lowerCase.startsWith("rgb(")) {
            StringTokenizer stringTokenizer = new StringTokenizer(lowerCase, "rgb(), \t\r\n\f");
            for (int i2 = 0; i2 < 3; i2++) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.endsWith("%")) {
                    iArr[i2] = (Integer.parseInt(nextToken.substring(0, nextToken.length() - 1)) * 255) / 100;
                } else {
                    iArr[i2] = Integer.parseInt(nextToken);
                }
                if (iArr[i2] < 0) {
                    iArr[i2] = 0;
                } else if (iArr[i2] > 255) {
                    iArr[i2] = 255;
                }
            }
            return new de(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else if (NAMES.containsKey(lowerCase)) {
            int[] iArr2 = (int[]) NAMES.get(lowerCase);
            return new de(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        } else {
            throw new IllegalArgumentException(qw.ad("color.not.found", lowerCase));
        }
    }

    public static boolean missingHashColorFormat(String str) {
        int length = str.length();
        if (length != 3 && length != 6) {
            return false;
        }
        return str.matches("[0-9a-f]{" + length + "}");
    }
}
