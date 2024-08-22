package com.baidu.searchbox.feed.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.template.FeedAgilityInvestViewKt;
import com.baidu.searchbox.video.feedflow.ubc.UBC2736;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentStatistics {
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    public static final String PAGE_COUPON = "coupon";
    private static final String PAYMENT_EXT_NID = "nid";
    private static final String PAYMENT_LANDING_PAGE_EVENT_ID = "1077";
    public static final String PAYMENT_PAGE_AUDIO = "audio";
    public static final String PAYMENT_PART_TYPE_GET = "getcoupon";
    public static final String PAYMENT_PART_TYPE_USE = "usecoupon";
    private static final String PAYMENT_PAY_ID = "1078";
    private static final String PAYMENT_SPECIAL_COLUMN_EVENT_ID = "1076";
    public static final String PAYMENT_TYPE_CLICK = "click";
    public static final String PAYMENT_TYPE_CLICK_FREE = "click_free";
    private static final String TAG = "PaymentStatistics";

    @Deprecated
    public static void recordSubscribeEvent(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "subscribe", albumID, source);
    }

    @Deprecated
    public static void recordToSubscribeEvent(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, UBC2736.VALUE.VALUE_COLLECTION_GO_BOOK_SHELF, albumID, source);
    }

    @Deprecated
    public static void recordPlayAllEvent(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "playtest_top", albumID, source);
    }

    @Deprecated
    public static void recordOrderEvent(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "row", albumID, source);
    }

    @Deprecated
    public static void recordPickEvent(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "chapter", albumID, source);
    }

    @Deprecated
    public static void recordSlidingTabSelected(String page, String type, String albumID, String source) {
        if (!TextUtils.isEmpty(type)) {
            String resultType = "";
            char c2 = 65535;
            switch (type.hashCode()) {
                case 3507:
                    if (type.equals("na")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 950398559:
                    if (type.equals("comment")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 951530617:
                    if (type.equals("content")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1224424441:
                    if (type.equals("webview")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    resultType = "menu";
                    break;
                case 1:
                case 2:
                    resultType = "introduction";
                    break;
                case 3:
                    resultType = "comment";
                    break;
            }
            if (!TextUtils.isEmpty(resultType)) {
                albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, resultType, albumID, source);
            }
        }
    }

    @Deprecated
    public static void recordClickCatalogue(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "menu", albumID, source);
    }

    @Deprecated
    public static void recordClickBriefIntro(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "introduction", albumID, source);
    }

    @Deprecated
    public static void recordClickPlaytest(String page, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "playtest_bottom", albumID, source);
    }

    @Deprecated
    public static void recordClickPaymentAudio(String page, String audioId, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "click", audioId, source);
    }

    @Deprecated
    public static void recordClickPaymentNews(String page, String feedId, String type, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, type, feedId, source);
    }

    @Deprecated
    public static void recordClickPaymentAlbum(String page, String type, String albumID, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, type, albumID, source);
    }

    public static void recordPopupPaymentDialog(String page, String audioId, String source) {
        albumDetailUBC("1077", page, "playtest_success", audioId, source);
    }

    public static void recordPaymentDialogBuy(String page, String audioId, String source) {
        albumDetailUBC("1077", page, "playtest_success_buy", audioId, source);
    }

    public static void recordClosePaymentDialog(String page, String audioId, String source) {
        albumDetailUBC("1077", page, "playtest_success_cancel", audioId, source);
    }

    public static void recordClickLandingPagePaymentButton(String page, String audioId, String source) {
        albumDetailUBC("1077", page, "buy", audioId, source);
    }

    public static void recordClickLandingPageBriefIntro(String page, String audioId, String source) {
        albumDetailUBC("1077", page, "column", audioId, source);
    }

    @Deprecated
    public static void recordClickCouponEnter(String page, String resId, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "coupon", resId, source);
    }

    public static void recordClickLandingCouponEnter(String page, String resId, String source) {
        albumDetailUBC("1077", page, "coupon", resId, source);
    }

    public static void recordCouponPanelShow(String partType, String sourceId, String source, String from) {
        albumDetailUBC("1078", "coupon", "pickup_" + partType, sourceId, source, from);
    }

    public static void recordCouponApplyEnter(String sourceId, String source, String from) {
        albumDetailUBC("1078", "buy", "changecoupon", sourceId, source, from);
    }

    public static void recordCouponShow(String partType, String takeId, String source, String from) {
        recordPayEvent("coupon", "show_" + partType, source, from, takeId, "");
    }

    public static void recordCouponClick(String partType, String takeId, String source, String from) {
        recordPayEvent("coupon", partType, source, from, takeId, "");
    }

    public static void recordCouponReceiveSuccess(String takeId, String source, String from) {
        recordPayEvent("coupon", "getcoupon_success", source, from, takeId, "");
    }

    public static void recordCouponAutoReceived(String takeId, String source, String from) {
        recordPayEvent("coupon", "auto_getcoupon_success", source, from, takeId, "");
    }

    public static void recordCouponRulesClick(String source, String from) {
        recordPayEvent("coupon", "rule", source, from, "", "");
    }

    @Deprecated
    public static void recordClickShareButton(String page, String type, String nid, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, type, nid, source);
    }

    @Deprecated
    public static void recordCommentButtonDisplay(String page, String nid, String source, String commentMode) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, isAddComment(commentMode) ? "twicecomment_show" : "writecomment_show", nid, source);
    }

    public static void recordCommentButtonClick(String page, String nid, String source, String commentMode) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, isAddComment(commentMode) ? "twicecomment_click" : "writecomment_click", nid, source);
    }

    public static void recordCommentTabClick(String page, String nid, String source) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, "comment", nid, source);
    }

    public static void recordStarRatingClick(String page, String nid, String source, float star, String commentMode) {
        JSONObject ext = new JSONObject();
        try {
            ext.put("nid", nid);
            ext.put("star", (double) star);
        } catch (JSONException e2) {
        }
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, isAddComment(commentMode) ? "twicestar_click" : FeedAgilityInvestViewKt.STAR_CLICK, source, ext);
    }

    public static void recordSendCommentClick(String page, String nid, String source, String commentMode) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, isAddComment(commentMode) ? "twice_sendcomment_click" : "sendcomment_click", nid, source);
    }

    public static void recordCommentSuccess(String page, String nid, String source, String commentMode) {
        albumDetailUBC(PAYMENT_SPECIAL_COLUMN_EVENT_ID, page, isAddComment(commentMode) ? "twice_sendcomment_success" : "sendcomment_success", nid, source);
    }

    private static boolean isAddComment(String commentMode) {
        return TextUtils.equals(commentMode, "1");
    }

    private static void albumDetailUBC(String eventId, String page, String type, String nid, String source) {
        albumDetailUBC(eventId, page, type, nid, source, (String) null);
    }

    private static void albumDetailUBC(String eventId, String page, String type, String nid, String source, String from) {
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        JSONObject ubcJson = new JSONObject();
        try {
            ubcJson.put("page", page);
            ubcJson.put("type", type);
            ubcJson.put("source", source);
            if (!TextUtils.isEmpty(from)) {
                ubcJson.put("from", from);
            }
            JSONObject extJson = new JSONObject();
            extJson.put("nid", nid);
            ubcJson.put("ext", extJson);
            ubc.onEvent(eventId, ubcJson);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static void albumDetailUBC(String eventId, String page, String type, String source, JSONObject extJson) {
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        JSONObject ubcJson = new JSONObject();
        try {
            ubcJson.put("page", page);
            ubcJson.put("type", type);
            ubcJson.put("source", source);
            ubcJson.put("ext", extJson);
            ubc.onEvent(eventId, ubcJson);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void recordPayEvent(String page, String type, String source, String from, String resId, String ext) {
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        JSONObject ubcJson = new JSONObject();
        try {
            ubcJson.put("page", page);
            ubcJson.put("type", type);
            ubcJson.put("source", source);
            ubcJson.put("from", from);
            ubcJson.put("value", resId);
            ubcJson.put("ext", ext);
            ubc.onEvent("1078", ubcJson);
        } catch (JSONException e2) {
            Log.w(TAG, e2);
        }
    }
}
