package com.yy.mediaframework.utils;

import com.yy.mediaframework.base.VideoEncoderType;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CommonUtil {
    public static int calcListMean(List<Integer> list) {
        int sum = 0;
        if (list != null && list.size() > 0) {
            for (Integer intValue : list) {
                sum += intValue.intValue();
            }
        }
        return sum / list.size();
    }

    public static int calcListMax(List<Integer> list) {
        int max = 0;
        if (list != null && list.size() > 0) {
            max = list.get(0).intValue();
            for (Integer intValue : list) {
                int captureTime = intValue.intValue();
                if (max <= captureTime) {
                    max = captureTime;
                }
            }
        }
        return max;
    }

    public static int calcListMin(List<Integer> list) {
        int min = 0;
        if (list != null && list.size() > 0) {
            min = list.get(0).intValue();
            for (Integer intValue : list) {
                int captureTime = intValue.intValue();
                if (min >= captureTime) {
                    min = captureTime;
                }
            }
        }
        return min;
    }

    public static int calcListSum(List<Integer> list) {
        int sum = 0;
        if (list != null && list.size() > 0) {
            for (Integer intValue : list) {
                sum += intValue.intValue();
            }
        }
        return sum;
    }

    public static String getParamsOrderByKey(Map<String, Object> paramValues) {
        String params = "";
        List<String> paramNames = new ArrayList<>(paramValues.size());
        paramNames.addAll(paramValues.keySet());
        Collections.sort(paramNames);
        for (String paramName : paramNames) {
            params = params + "&" + paramName + "=" + (paramValues.get(paramName) == null ? 0 : paramValues.get(paramName));
        }
        return params;
    }

    public static String toURLEncoded(String paramString) {
        if (paramString == null || paramString.equals("")) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
        } catch (Exception e2) {
            YMFLog.error((Object) null, "[Encoder ]", "toURLEncoded exception:" + e2.toString());
            return "";
        }
    }

    /* renamed from: com.yy.mediaframework.utils.CommonUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yy$mediaframework$base$VideoEncoderType;

        static {
            int[] iArr = new int[VideoEncoderType.values().length];
            $SwitchMap$com$yy$mediaframework$base$VideoEncoderType = iArr;
            try {
                iArr[VideoEncoderType.SOFT_ENCODER_X264.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$yy$mediaframework$base$VideoEncoderType[VideoEncoderType.HARD_ENCODER_H264.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$yy$mediaframework$base$VideoEncoderType[VideoEncoderType.SOFT_ENCODER_H265.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$yy$mediaframework$base$VideoEncoderType[VideoEncoderType.HARD_ENCODER_H265.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static int wrapperHiidoEncodeId(VideoEncoderType type) {
        switch (AnonymousClass1.$SwitchMap$com$yy$mediaframework$base$VideoEncoderType[type.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 4;
            default:
                return 0;
        }
    }
}
