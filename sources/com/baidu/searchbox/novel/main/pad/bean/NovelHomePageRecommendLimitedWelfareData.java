package com.baidu.searchbox.novel.main.pad.bean;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NovelHomePageRecommendLimitedWelfareData extends NovelHomePageRecommendBaseData {
    private static final String BACKGROUND = "background";
    private static final String BTN_IMG = "btn_img";
    private static final String BUTTON_TEXT = "button_text";
    private static final String CALENDAR_CASH = "calendar_cash";
    private static final String CALENDAR_GOLD_NUM = "calendar_goldNum";
    private static final String CALENDAR_NAME = "calendar_name";
    private static final String CALENDAR_PRIZE_TYPE = "calendar_prizeType";
    private static final String CLICK_BTN = "click_btn";
    private static final String COMMON_NAME = "common_name";
    private static final String CUR_DAY_INDEX = "cur_day_index";
    private static final String DECORATION = "decoration";
    private static final String GOLDCOIN = "goldcoin";
    private static final String HEAD_LINE = "head_line";
    private static final String MATERIAL = "material";
    private static final String MODULE_RECOMMEND = "module_recommend";
    private static final String NOVEL_LIST = "novelList";
    private static final String PRIZE_VALUE = "prizeValue";
    private static final String RED_PACKAGE = "red_package";
    private static final String SCHEMA = "schema";
    private static final String STATUS = "status";
    private static final String TASK_ID = "task_id";
    private static final String TOMORROW_CORNER = "tomorrow_corner";
    private static final String UNIT = "unit";
    private static final String UP_TEXT = "up_text";
    private static final String VIDEO = "video";
    private String clickBtnImg;
    private String commonName;
    private List<WelfareContentData> contentDataList = new ArrayList();
    private int curDayIndex;
    private String decoImg;
    private String headLineImg;
    private String moduleRecommend;
    private String schemaUrl;

    public int getType() {
        return 10;
    }

    public static NovelHomePageRecommendBaseData fromJson(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        NovelHomePageRecommendLimitedWelfareData limitedWelfareData = new NovelHomePageRecommendLimitedWelfareData();
        limitedWelfareData.setCommonName(jsonObject.optString(COMMON_NAME));
        limitedWelfareData.setModuleRecommend(jsonObject.optString(MODULE_RECOMMEND));
        List<WelfareContentData> contentDataList2 = new ArrayList<>();
        JSONArray novelList = jsonObject.optJSONArray(NOVEL_LIST);
        int curDayIndex2 = jsonObject.optInt(CUR_DAY_INDEX);
        limitedWelfareData.setCurDayIndex(curDayIndex2);
        limitedWelfareData.setSchemaUrl(jsonObject.optString("schema"));
        JSONObject material = jsonObject.optJSONObject("material");
        if (material != null) {
            limitedWelfareData.setHeadLineImg(material.optString(HEAD_LINE));
            limitedWelfareData.setClickBtnImg(material.optString("click_btn"));
            limitedWelfareData.setDecoImg(material.optString(DECORATION));
        }
        if (novelList != null && novelList.length() > 0) {
            for (int i2 = 0; i2 < novelList.length(); i2++) {
                WelfareContentData welfareContentData = new WelfareContentData();
                JSONObject object = novelList.optJSONObject(i2);
                welfareContentData.setCalendarName(object.optString(CALENDAR_NAME));
                welfareContentData.setCalendarGoldNum(object.optString(CALENDAR_GOLD_NUM));
                welfareContentData.setCalendarCash(object.optString(CALENDAR_CASH));
                welfareContentData.setCalendarPrizeType(object.optString(CALENDAR_PRIZE_TYPE));
                welfareContentData.setStatus(object.optString("status"));
                welfareContentData.setTaskId(object.optString("task_id"));
                welfareContentData.setUserDayIndex(curDayIndex2);
                if (material != null) {
                    welfareContentData.setRedPackageImg(material.optString("red_package"));
                    welfareContentData.setVideoImg(material.optString("video"));
                    welfareContentData.setGoldCoinImg(material.optString(GOLDCOIN));
                    welfareContentData.setTomorrowCornerImg(material.optString(TOMORROW_CORNER));
                }
                contentDataList2.add(welfareContentData);
            }
            setShowTomorrow(contentDataList2, curDayIndex2);
        }
        limitedWelfareData.setContentDataList(contentDataList2);
        return limitedWelfareData;
    }

    private static void setShowTomorrow(List<WelfareContentData> contentDataList2, int curDayIndex2) {
        if (contentDataList2 != null && curDayIndex2 >= 0 && curDayIndex2 + 1 < contentDataList2.size()) {
            WelfareContentData curDayWelfareData = contentDataList2.get(curDayIndex2);
            WelfareContentData contentData = contentDataList2.get(curDayIndex2 + 1);
            String status = "";
            if (curDayWelfareData != null) {
                status = curDayWelfareData.getStatus();
            }
            if (TextUtils.equals(status, "8") && contentData != null) {
                contentData.setShowTomorrow(true);
            }
        }
    }

    public static WelfarePrizeData parseWelfarePrizeData(JSONObject jsonData) {
        if (jsonData == null) {
            return null;
        }
        WelfarePrizeData welfarePrizeData = new WelfarePrizeData();
        welfarePrizeData.setStatus(jsonData.optString("status"));
        welfarePrizeData.setCalendarPrizeType(jsonData.optString(CALENDAR_PRIZE_TYPE));
        welfarePrizeData.setCalendarPrizeValue(jsonData.optString(PRIZE_VALUE));
        welfarePrizeData.setScheme(jsonData.optString("schema"));
        welfarePrizeData.setUnit(jsonData.optString("unit"));
        welfarePrizeData.setButtonText(jsonData.optString("button_text"));
        welfarePrizeData.setUpText(jsonData.optString(UP_TEXT));
        welfarePrizeData.setBackgroundImage(jsonData.optString("background"));
        welfarePrizeData.setBtnImg(jsonData.optString(BTN_IMG));
        return welfarePrizeData;
    }

    public int getCurDayIndex() {
        return this.curDayIndex;
    }

    public void setCurDayIndex(int curDayIndex2) {
        this.curDayIndex = curDayIndex2;
    }

    public String getCommonName() {
        return this.commonName;
    }

    public void setCommonName(String commonName2) {
        this.commonName = commonName2;
    }

    public String getModuleRecommend() {
        return this.moduleRecommend;
    }

    public void setModuleRecommend(String moduleRecommend2) {
        this.moduleRecommend = moduleRecommend2;
    }

    public List<WelfareContentData> getContentDataList() {
        return this.contentDataList;
    }

    public void setContentDataList(List<WelfareContentData> contentDataList2) {
        this.contentDataList = contentDataList2;
    }

    public String getHeadLineImg() {
        return this.headLineImg;
    }

    public void setHeadLineImg(String headLineImg2) {
        this.headLineImg = headLineImg2;
    }

    public String getClickBtnImg() {
        return this.clickBtnImg;
    }

    public void setClickBtnImg(String clickBtnImg2) {
        this.clickBtnImg = clickBtnImg2;
    }

    public String getDecoImg() {
        return this.decoImg;
    }

    public void setDecoImg(String decoImg2) {
        this.decoImg = decoImg2;
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public void setSchemaUrl(String schemaUrl2) {
        this.schemaUrl = schemaUrl2;
    }

    public static class WelfareContentData {
        public static final String CALENDAR_PRIZE_TYPE_COINS = "2";
        public static final String CALENDAR_PRIZE_TYPE_PACKAGE = "3";
        public static final int STATUS_CAN_OPEN = 12;
        public static final int STATUS_NEED_REOPEN = 14;
        public static final int STATUS_OPENED = 13;
        public static final int STATUS_TO_BE_OPENED = 11;
        public static final String TASK_STATUS_FINISH_HAS_WELFARE = "8";
        public static final String TASK_STATUS_FINISH_NO_WELFARE = "4";
        public static final String TASK_STATUS_UN_FINISH = "3";
        private String calendarCash;
        private String calendarGoldNum;
        private String calendarName;
        private String calendarPrizeType;
        private String goldCoinImg;
        private boolean isShowTomorrow;
        private String redPackageImg;
        private String status;
        private String taskId;
        private String tomorrowCornerImg;
        private int userDayIndex;
        private String videoImg;
        private int welfareStatus;

        public String getCalendarName() {
            return this.calendarName;
        }

        public void setCalendarName(String calendarName2) {
            this.calendarName = calendarName2;
        }

        public String getCalendarGoldNum() {
            return this.calendarGoldNum;
        }

        public void setCalendarGoldNum(String calendarGoldNum2) {
            this.calendarGoldNum = calendarGoldNum2;
        }

        public String getCalendarCash() {
            return this.calendarCash;
        }

        public void setCalendarCash(String calendarCash2) {
            this.calendarCash = calendarCash2;
        }

        public String getCalendarPrizeType() {
            return this.calendarPrizeType;
        }

        public void setCalendarPrizeType(String calendarPrizeType2) {
            this.calendarPrizeType = calendarPrizeType2;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status2) {
            this.status = status2;
        }

        public String getTaskId() {
            return this.taskId;
        }

        public void setTaskId(String taskId2) {
            this.taskId = taskId2;
        }

        public int getUserDayIndex() {
            return this.userDayIndex;
        }

        public void setUserDayIndex(int userDayIndex2) {
            this.userDayIndex = userDayIndex2;
        }

        public boolean isShowTomorrow() {
            return this.isShowTomorrow;
        }

        public void setShowTomorrow(boolean showTomorrow) {
            this.isShowTomorrow = showTomorrow;
        }

        public int getWelfareStatus() {
            return this.welfareStatus;
        }

        public void setWelfareStatus(int welfareStatus2) {
            this.welfareStatus = welfareStatus2;
        }

        public String getRedPackageImg() {
            return this.redPackageImg;
        }

        public void setRedPackageImg(String redPackageImg2) {
            this.redPackageImg = redPackageImg2;
        }

        public String getVideoImg() {
            return this.videoImg;
        }

        public void setVideoImg(String videoImg2) {
            this.videoImg = videoImg2;
        }

        public String getGoldCoinImg() {
            return this.goldCoinImg;
        }

        public void setGoldCoinImg(String goldCoinImg2) {
            this.goldCoinImg = goldCoinImg2;
        }

        public String getTomorrowCornerImg() {
            return this.tomorrowCornerImg;
        }

        public void setTomorrowCornerImg(String tomorrowCornerImg2) {
            this.tomorrowCornerImg = tomorrowCornerImg2;
        }
    }

    public static class WelfarePrizeData {
        private String backgroundImage;
        private String btnImg;
        private String buttonText;
        private String calendarPrizeType;
        private String calendarPrizeValue;
        private String scheme;
        private String status;
        private String unit;
        private String upText;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status2) {
            this.status = status2;
        }

        public String getCalendarPrizeType() {
            return this.calendarPrizeType;
        }

        public void setCalendarPrizeType(String calendarPrizeType2) {
            this.calendarPrizeType = calendarPrizeType2;
        }

        public String getCalendarPrizeValue() {
            return this.calendarPrizeValue;
        }

        public void setCalendarPrizeValue(String calendarPrizeValue2) {
            this.calendarPrizeValue = calendarPrizeValue2;
        }

        public String getScheme() {
            return this.scheme;
        }

        public void setScheme(String scheme2) {
            this.scheme = scheme2;
        }

        public String getUnit() {
            return this.unit;
        }

        public void setUnit(String unit2) {
            this.unit = unit2;
        }

        public String getButtonText() {
            return this.buttonText;
        }

        public void setButtonText(String buttonText2) {
            this.buttonText = buttonText2;
        }

        public String getUpText() {
            return this.upText;
        }

        public void setUpText(String upText2) {
            this.upText = upText2;
        }

        public String getBackgroundImage() {
            return this.backgroundImage;
        }

        public void setBackgroundImage(String backgroundImage2) {
            this.backgroundImage = backgroundImage2;
        }

        public String getBtnImg() {
            return this.btnImg;
        }

        public void setBtnImg(String btnImg2) {
            this.btnImg = btnImg2;
        }
    }
}
