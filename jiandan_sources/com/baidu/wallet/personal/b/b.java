package com.baidu.wallet.personal.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.HashMap;

public class b {
    public static HashMap<String, NinePatchDrawable> a = new HashMap<>();
    public static final String b = "b";

    public static int a(Context context, int i2) {
        String str;
        if (i2 != 8) {
            if (!(i2 == 11 || i2 == 22 || i2 == 33 || i2 == 44)) {
                if (i2 != 55) {
                    if (i2 != 66) {
                        switch (i2) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 6:
                                str = "coupon_base_red_f73f31";
                                break;
                            case 5:
                                break;
                            default:
                                str = "coupon_base_red_f75348";
                                break;
                        }
                    }
                }
                str = "coupon_base_orage_f7d1af";
            }
            str = "coupon_base_orage_bf5f0d";
        } else {
            str = "coupon_base_orage_f3d1b1";
        }
        return ResUtils.getColor(context, str);
    }

    public static int a(Context context, String str, String str2) {
        int color = ResUtils.getColor(context, str2);
        if (TextUtils.isEmpty(str)) {
            return color;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            LogUtil.d(b, e.getMessage());
            return color;
        }
    }

    public static GradientDrawable a(Context context, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setShape(i3);
        gradientDrawable.setCornerRadii(new float[]{(float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f), (float) DisplayUtils.dip2px(context, 1.5f)});
        return gradientDrawable;
    }

    public static GradientDrawable a(Context context, int i2, int i3, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setShape(i3);
        gradientDrawable.setCornerRadii(new float[]{(float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f), (float) DisplayUtils.dip2px(context, f)});
        return gradientDrawable;
    }

    public static NinePatchDrawable a(Context context, String str) {
        NinePatchDrawable ninePatchDrawable;
        HashMap<String, NinePatchDrawable> hashMap;
        String str2 = str.contains(",") ? str.split(",")[0] : str;
        HashMap<String, NinePatchDrawable> hashMap2 = a;
        if (hashMap2 == null) {
            ninePatchDrawable = b(context, str2);
            hashMap = new HashMap<>();
            a = hashMap;
        } else if (hashMap2.containsKey(str) && a.get(str) != null) {
            return a.get(str);
        } else {
            ninePatchDrawable = b(context, str2);
            hashMap = a;
        }
        hashMap.put(str, ninePatchDrawable);
        return ninePatchDrawable;
    }

    public static NinePatchDrawable a(Context context, String str, int i2) {
        return a(context, str + "," + i2);
    }

    public static int b(Context context, int i2) {
        String str;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    str = "coupon_base_yellow_f1ac00";
                } else if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 8) {
                            return -1;
                        }
                        if (!(i2 == 11 || i2 == 22 || i2 == 33 || i2 == 44)) {
                            if (i2 != 55) {
                                if (i2 != 66) {
                                    str = "coupon_base_red_f75348";
                                }
                            }
                        }
                        str = "coupon_base_yellow_c77228";
                    }
                }
                return ResUtils.getColor(context, str);
            }
            str = "coupon_base_red_fc6a60";
            return ResUtils.getColor(context, str);
        }
        str = "coupon_base_blue_5077e8";
        return ResUtils.getColor(context, str);
    }

    public static NinePatchDrawable b(Context context, String str) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        if (!TextUtils.isEmpty(str)) {
            try {
                bitmapDrawable = (BitmapDrawable) ResUtils.getDrawable(context, str);
            } catch (OutOfMemoryError unused) {
                Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
                createBitmap.eraseColor(Color.parseColor("#f5f5f5"));
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            if (!(bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null)) {
                LogUtil.d("coupon", "bitmap res height = " + bitmap.getHeight() + " ; width = " + bitmap.getWidth() + " ; density = " + bitmap.getDensity());
                a aVar = new a(context.getResources(), bitmap);
                aVar.a(1);
                return aVar.c();
            }
        }
        return null;
    }
}
