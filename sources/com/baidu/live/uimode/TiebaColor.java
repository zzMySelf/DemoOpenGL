package com.baidu.live.uimode;

import android.content.Context;
import android.graphics.Color;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.live.framework.utils.StringUtils;
import com.baidu.searchbox.home.tabs.BaseTabItemView;
import com.baidu.searchbox.home.tabs.constants.HomeTabIconBubbleConstants;
import com.baidu.searchbox.story.NovelConstant;
import com.baidu.searchbox.video.feedflow.tab.TabConfigManagerKt;
import java.util.HashMap;

public class TiebaColor extends BaseColor {
    private static final HashMap<String, String[]> COLOR_MAP = new HashMap<>();

    public TiebaColor() {
        HashMap<String, String[]> hashMap = COLOR_MAP;
        hashMap.put("color_1F1F1F", new String[]{"#141414", "#BFFFFFFF", TabConfigManagerKt.COLOR_INDICATOR_DEFAULT, ""});
        hashMap.put("color_white1", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        hashMap.put("color_white2", new String[]{"#F5F5F5", "#272729", "#141414", ""});
        hashMap.put("color_white3", new String[]{"#FFFFFF", "#D9FFFFFF", "#FFFFFF", ""});
        hashMap.put("color_white3_40", new String[]{NovelConstant.AD_CARD_COLOR_DAY_OTHERS, "#D9FFFFFF", NovelConstant.AD_CARD_COLOR_DAY_OTHERS, ""});
        hashMap.put("color_F5F5F51", new String[]{"#F2F2F5", "#141414", "#000000", ""});
        hashMap.put("color_F5F5F52", new String[]{"#F7F7FA", "#1E1D1F", "#1AFFFFFF", ""});
        hashMap.put("color_F5F5F53", new String[]{"#0D000000", "#0DFFFFFF", "#1AFFFFFF", ""});
        hashMap.put("color_FF33551", new String[]{"#FF3355", "#D42A46", "#FF3355", ""});
        hashMap.put("color_FF33552", new String[]{"#1AFF3355", "#1AD42A46", "#1AFF3355", ""});
        hashMap.put("color_858585", new String[]{BaseTabItemView.GRAY_BADGE_COLOR, "#59FFFFFF", HomeTabIconBubbleConstants.DEFAULT_BUBBLE_TEXT_COLOR_DARK, ""});
        hashMap.put("color_525252", new String[]{"#525252", NovelConstant.AD_RULE_DESCRIPTION_NIGHT, NovelConstant.AD_CARD_COLOR_DAY_DEFAULT, ""});
        hashMap.put("color_FF3333", new String[]{"#FF3333", "#FF3333", "#FF3333", ""});
        hashMap.put("color_768CAE", new String[]{"#768CAE", "#768CAE", "#768CAE", ""});
        hashMap.put("color_4E6EF2", new String[]{"#4E6EF2", "#4E6EF2", "#4E6EF2", ""});
        hashMap.put("color_8585852", new String[]{BaseTabItemView.GRAY_BADGE_COLOR, "#444444", HomeTabIconBubbleConstants.DEFAULT_BUBBLE_TEXT_COLOR_DARK, ""});
        hashMap.put("color_5252522", new String[]{"#525252", NovelConstant.AD_RULE_DESCRIPTION_NIGHT, NovelConstant.AD_CARD_COLOR_DAY_DEFAULT, ""});
        hashMap.put("color_btn_stroke", new String[]{"#00000000", "#00000000", "#00000000", ""});
        hashMap.put("color_btn_fill", new String[]{"#F7F7FA", "#1E1D1F", "#000000", ""});
        hashMap.put("color_sub_tab_normal", new String[]{"#141414", "#BFFFFFFF", TabConfigManagerKt.COLOR_INDICATOR_DEFAULT, ""});
        hashMap.put("color_main_bg", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        hashMap.put("color_white4", new String[]{CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR, "#666666", "", "#FFFFFF"});
        hashMap.put("color_gradient_1", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        hashMap.put("color_gradient_2", new String[]{"#00FFFFFF", "#00141414", "#00000000", ""});
        hashMap.put("color_E0E0E0", new String[]{"#E0E0E0", "", "", ""});
        hashMap.put("color_EEEEEE", new String[]{"#eeeeee", "", "", ""});
        hashMap.put("color_follow_title", new String[]{CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR, "#CCFFFFFF", "", "#CCFFFFFF", "#CCFFFFFF"});
    }

    public int getColor(Context context, String scene, String colorKey) {
        HashMap<String, String[]> hashMap = COLOR_MAP;
        if (!hashMap.containsKey(colorKey)) {
            return -16777216;
        }
        String colorValue = hashMap.get(colorKey)[0];
        if ("recommend".equals(scene)) {
            return RecMoreColor.getInstance().getColor(context, scene, colorKey);
        }
        if ("immersion".equals(scene)) {
            colorValue = hashMap.get(colorKey)[3];
        } else if ("night" == this.uiMode) {
            colorValue = hashMap.get(colorKey)[1];
        } else if ("dark" == this.uiMode) {
            colorValue = hashMap.get(colorKey)[2];
        }
        if (StringUtils.isNull(colorValue)) {
            return -16777216;
        }
        try {
            return Color.parseColor(colorValue);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -16777216;
        }
    }
}
