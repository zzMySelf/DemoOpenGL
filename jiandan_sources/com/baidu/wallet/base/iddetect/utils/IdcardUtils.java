package com.baidu.wallet.base.iddetect.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.dlife.ctaccountapi.x;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class IdcardUtils {
    public static final int CHINA_ID_MAX_LENGTH = 18;
    public static final int CHINA_ID_MIN_LENGTH = 15;
    public static final String[] CITYCODE = {BindFastRequest.BIND_FROM_INITIATIVE, "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};
    public static final int MIN = 1930;
    public static final int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    public static final String[] VERIFYCODE = {"1", "0", "X", "9", "8", "7", BannerBaseItemInfo.TYPE_SCHEME, BannerBaseItemInfo.TYPE_LOGIN, "4", "3", "2"};
    public static Map<String, String> cityCodes = new HashMap();
    public static Map<String, Integer> hkFirstCode = new HashMap();
    public static Map<String, Integer> twFirstCode = new HashMap();

    static {
        cityCodes.put(BindFastRequest.BIND_FROM_INITIATIVE, "北京");
        cityCodes.put("12", "天津");
        cityCodes.put("13", "河北");
        cityCodes.put("14", "山西");
        cityCodes.put("15", "内蒙古");
        cityCodes.put("21", "辽宁");
        cityCodes.put("22", "吉林");
        cityCodes.put("23", "黑龙江");
        cityCodes.put("31", "上海");
        cityCodes.put("32", "江苏");
        cityCodes.put("33", "浙江");
        cityCodes.put("34", "安徽");
        cityCodes.put("35", "福建");
        cityCodes.put("36", "江西");
        cityCodes.put("37", "山东");
        cityCodes.put("41", "河南");
        cityCodes.put(RoomMasterTable.DEFAULT_ID, "湖北");
        cityCodes.put("43", "湖南");
        cityCodes.put("44", "广东");
        cityCodes.put("45", "广西");
        cityCodes.put("46", "海南");
        cityCodes.put("50", "重庆");
        cityCodes.put("51", "四川");
        cityCodes.put("52", "贵州");
        cityCodes.put("53", "云南");
        cityCodes.put("54", "西藏");
        cityCodes.put("61", "陕西");
        cityCodes.put("62", "甘肃");
        cityCodes.put("63", "青海");
        cityCodes.put("64", "宁夏");
        cityCodes.put("65", "新疆");
        cityCodes.put("71", "台湾");
        cityCodes.put("81", "香港");
        cityCodes.put("82", "澳门");
        cityCodes.put("91", "国外");
        twFirstCode.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 10);
        twFirstCode.put("B", 11);
        twFirstCode.put("C", 12);
        twFirstCode.put("D", 13);
        twFirstCode.put(ExifInterface.LONGITUDE_EAST, 14);
        twFirstCode.put("F", 15);
        twFirstCode.put("G", 16);
        twFirstCode.put("H", 17);
        twFirstCode.put("J", 18);
        twFirstCode.put("K", 19);
        twFirstCode.put("L", 20);
        twFirstCode.put("M", 21);
        twFirstCode.put("N", 22);
        twFirstCode.put("P", 23);
        twFirstCode.put("Q", 24);
        twFirstCode.put("R", 25);
        twFirstCode.put(ExifInterface.LATITUDE_SOUTH, 26);
        twFirstCode.put(ExifInterface.GPS_DIRECTION_TRUE, 27);
        twFirstCode.put("U", 28);
        twFirstCode.put(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 29);
        twFirstCode.put("X", 30);
        twFirstCode.put("Y", 31);
        twFirstCode.put(ExifInterface.LONGITUDE_WEST, 32);
        twFirstCode.put("Z", 33);
        twFirstCode.put("I", 34);
        twFirstCode.put("O", 35);
        hkFirstCode.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 1);
        hkFirstCode.put("B", 2);
        hkFirstCode.put("C", 3);
        hkFirstCode.put("R", 18);
        hkFirstCode.put("U", 21);
        hkFirstCode.put("Z", 26);
        hkFirstCode.put("X", 24);
        hkFirstCode.put(ExifInterface.LONGITUDE_WEST, 23);
        hkFirstCode.put("O", 15);
        hkFirstCode.put("N", 14);
    }

    public static String conver15CardTo18(String str) {
        Date date;
        if (str.length() != 15 || !isNum(str)) {
            return null;
        }
        try {
            date = new SimpleDateFormat("yyMMdd").parse(str.substring(6, 12));
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        Calendar instance = Calendar.getInstance();
        if (date != null) {
            instance.setTime(date);
        }
        String str2 = str.substring(0, 6) + String.valueOf(instance.get(1)) + str.substring(8);
        char[] charArray = str2.toCharArray();
        if (charArray == null) {
            return str2;
        }
        String checkCode18 = getCheckCode18(getPowerSum(converCharToInt(charArray)));
        if (checkCode18.length() <= 0) {
            return null;
        }
        return str2 + checkCode18;
    }

    public static int[] converCharToInt(char[] cArr) {
        int length = cArr.length;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            try {
                iArr[i2] = Integer.parseInt(String.valueOf(cArr[i2]));
                i2++;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return iArr;
    }

    public static int getAgeByIdCard(String str) {
        if (str == null || str.length() < 15) {
            return 0;
        }
        if (str.length() == 15) {
            str = conver15CardTo18(str);
        }
        if (str == null) {
            return 0;
        }
        return Calendar.getInstance().get(1) - Integer.valueOf(str.substring(6, 10)).intValue();
    }

    public static String getBirthByIdCard(String str) {
        if (str == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(str.length());
        if (valueOf.intValue() < 15) {
            return null;
        }
        if (valueOf.intValue() == 15) {
            str = conver15CardTo18(str);
        }
        if (str != null) {
            return str.substring(6, 14);
        }
        return null;
    }

    public static String getCheckCode18(int i2) {
        switch (i2 % 11) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return x.a;
            case 3:
                return "9";
            case 4:
                return "8";
            case 5:
                return "7";
            case 6:
                return BannerBaseItemInfo.TYPE_SCHEME;
            case 7:
                return BannerBaseItemInfo.TYPE_LOGIN;
            case 8:
                return "4";
            case 9:
                return "3";
            case 10:
                return "2";
            default:
                return "";
        }
    }

    public static Short getDateByIdCard(String str) {
        if (str == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(str.length());
        if (valueOf.intValue() < 15) {
            return null;
        }
        if (valueOf.intValue() == 15) {
            str = conver15CardTo18(str);
        }
        if (str != null) {
            return Short.valueOf(str.substring(12, 14));
        }
        return null;
    }

    public static String getGenderByIdCard(String str) {
        if (str == null) {
            return "N";
        }
        if (str.length() == 15) {
            str = conver15CardTo18(str);
        }
        if (str == null) {
            return "N";
        }
        return Integer.parseInt(str.substring(16, 17)) % 2 != 0 ? "M" : "F";
    }

    public static Short getMonthByIdCard(String str) {
        if (str == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(str.length());
        if (valueOf.intValue() < 15) {
            return null;
        }
        if (valueOf.intValue() == 15) {
            str = conver15CardTo18(str);
        }
        if (str != null) {
            return Short.valueOf(str.substring(10, 12));
        }
        return null;
    }

    public static int getPowerSum(int[] iArr) {
        if (POWER.length != iArr.length) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = POWER;
                if (i4 >= iArr2.length) {
                    break;
                }
                if (i3 == i4) {
                    i2 += iArr[i3] * iArr2[i4];
                }
                i4++;
            }
        }
        return i2;
    }

    public static String getProvinceByIdCard(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 15 || length == 18) {
            str2 = str.substring(0, 2);
        } else {
            str2 = "";
        }
        return cityCodes.get(str2);
    }

    public static Short getYearByIdCard(String str) {
        if (str == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(str.length());
        if (valueOf.intValue() < 15) {
            return null;
        }
        if (valueOf.intValue() == 15) {
            str = conver15CardTo18(str);
        }
        if (str != null) {
            return Short.valueOf(str.substring(6, 10));
        }
        return null;
    }

    public static boolean isNum(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return isNumeric(str);
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean valiDate(int i2, int i3, int i4) {
        int i5;
        int i6 = Calendar.getInstance().get(1);
        if (i2 < 1930 || i2 >= i6 || i3 < 1 || i3 > 12) {
            return false;
        }
        if (i3 != 2) {
            i5 = (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) ? 30 : 31;
        } else {
            i5 = ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) && i2 > 1930 && i2 < i6 ? 29 : 28;
        }
        if (i4 < 1 || i4 > i5) {
            return false;
        }
        return true;
    }

    public static boolean validateCard(String str) {
        String trim = str.trim();
        if (validateIdCard18(trim) || validateIdCard15(trim)) {
            return true;
        }
        String validateIdCard10 = validateIdCard10(trim);
        if (validateIdCard10 == null || !validateIdCard10.equals("true")) {
            return false;
        }
        return true;
    }

    public static boolean validateHKCard(String str) {
        return false;
    }

    public static String validateIdCard10(String str) {
        String replaceAll = str.replaceAll("[\\(|\\)]", "");
        if (replaceAll.length() != 8 && replaceAll.length() != 9 && str.length() != 10) {
            return null;
        }
        if (str.matches("^{9}$")) {
            System.out.println("11111");
            String substring = str.substring(1, 2);
            if (substring.equals("1")) {
                System.out.println("MMMMMMM");
            } else if (substring.equals("2")) {
                System.out.println("FFFFFFF");
            } else {
                System.out.println("NNNN");
                return "false";
            }
            if (validateTWCard(str)) {
                return "true";
            }
        } else if (str.matches("^{6}\\(?\\)?$")) {
            return "N";
        } else {
            if (!str.matches("^{1,2}{6}\\(?\\)?$")) {
                return null;
            }
            if (validateHKCard(str)) {
                return "true";
            }
        }
        return "false";
    }

    public static boolean validateIdCard15(String str) {
        if (str.length() != 15 || !isNum(str)) {
            return false;
        }
        if (cityCodes.get(str.substring(0, 2)) == null) {
            return false;
        }
        String substring = str.substring(6, 12);
        Date date = null;
        try {
            date = new SimpleDateFormat(FastLoginFeature.SSOLoginType.YY).parse(substring.substring(0, 2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar instance = Calendar.getInstance();
        if (date != null) {
            instance.setTime(date);
        }
        if (!valiDate(instance.get(1), Integer.valueOf(substring.substring(2, 4)).intValue(), Integer.valueOf(substring.substring(4, 6)).intValue())) {
            return false;
        }
        return true;
    }

    public static boolean validateIdCard18(String str) {
        char[] charArray;
        if (str.length() != 18) {
            return false;
        }
        String substring = str.substring(0, 17);
        String substring2 = str.substring(17, 18);
        if (!isNum(substring) || (charArray = substring.toCharArray()) == null) {
            return false;
        }
        String checkCode18 = getCheckCode18(getPowerSum(converCharToInt(charArray)));
        if (checkCode18.length() <= 0 || !checkCode18.equalsIgnoreCase(substring2)) {
            return false;
        }
        return true;
    }

    public static boolean validateTWCard(String str) {
        String substring = str.substring(0, 1);
        String substring2 = str.substring(1, 9);
        String substring3 = str.substring(9, 10);
        Integer num = twFirstCode.get(substring);
        Integer valueOf = Integer.valueOf((num.intValue() / 10) + ((num.intValue() % 10) * 9));
        char[] charArray = substring2.toCharArray();
        Integer num2 = 8;
        for (char c : charArray) {
            int intValue = valueOf.intValue();
            valueOf = Integer.valueOf(intValue + (Integer.valueOf(c + "").intValue() * num2.intValue()));
            num2 = Integer.valueOf(num2.intValue() - 1);
        }
        if ((valueOf.intValue() % 10 == 0 ? 0 : 10 - (valueOf.intValue() % 10)) == Integer.valueOf(substring3).intValue()) {
            return true;
        }
        return false;
    }
}
