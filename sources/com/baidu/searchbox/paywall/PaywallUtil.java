package com.baidu.searchbox.paywall;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.searchbox.paywall.privatemodel.PaywallItem;
import com.baidu.searchbox.push.MyMessageConstants;
import com.baidu.searchbox.story.NovelConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J'\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ \u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/paywall/PaywallUtil;", "", "()V", "COLLECTION", "", "NOT_COLLECTION", "getAvTypeTag", "data", "Lcom/baidu/searchbox/paywall/privatemodel/PaywallItem;", "context", "Landroid/content/Context;", "getDiversionDefaultIcon", "", "defaultIcon", "getDocCoverDrawableId", "item", "getDocCoverTagIconId", "getModifyTimeStr", "modifyTime", "", "getTplidImageId", "tplid", "jsonArrayToList", "", "", "jsonArray", "Lorg/json/JSONArray;", "jsonArrayToList$lib_paywall_release", "jsonObjectToMap", "jsonObject", "Lorg/json/JSONObject;", "setOwnTypeOrResourceFreeTag", "", "tagImage", "Landroid/widget/ImageView;", "itemData", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallUtil.kt */
public final class PaywallUtil {
    public static final String COLLECTION = "1";
    public static final PaywallUtil INSTANCE = new PaywallUtil();
    public static final String NOT_COLLECTION = "0";

    private PaywallUtil() {
    }

    public final int getTplidImageId(String tplid) {
        if (tplid == null) {
            return 0;
        }
        switch (tplid.hashCode()) {
            case -732377866:
                if (!tplid.equals("article")) {
                    return 0;
                }
                return R.drawable.paywall_article_type_icon;
            case 93166550:
                if (!tplid.equals("audio")) {
                    return 0;
                }
                return R.drawable.paywall_audio_type_icon;
            case 112202875:
                if (!tplid.equals("video")) {
                    return 0;
                }
                return R.drawable.paywall_video_type_icon;
            case 1418606057:
                if (!tplid.equals("liveshow")) {
                    return 0;
                }
                return R.drawable.paywall_liveshow_type_icon;
            default:
                return 0;
        }
    }

    public final int getDiversionDefaultIcon(String defaultIcon) {
        if (TextUtils.isEmpty(defaultIcon)) {
            return R.drawable.paywall_recommend_default;
        }
        if (defaultIcon != null) {
            switch (defaultIcon.hashCode()) {
                case 668014959:
                    if (defaultIcon.equals("bba_paywall_recommend_vip")) {
                        return R.drawable.paywall_recommend_haoxue;
                    }
                    break;
                case 903620860:
                    if (defaultIcon.equals("bba_paywall_recommend_xiaoshuo")) {
                        return R.drawable.paywall_recommend_novel;
                    }
                    break;
                case 1268974294:
                    if (defaultIcon.equals("bba_paywall_recommend_haoting")) {
                        return R.drawable.paywall_recommend_haoting;
                    }
                    break;
                case 2013054364:
                    if (defaultIcon.equals("bba_paywall_recommend_wenku")) {
                        return R.drawable.paywall_recommend_doc;
                    }
                    break;
            }
        }
        return R.drawable.paywall_recommend_default;
    }

    public final String getAvTypeTag(PaywallItem data, Context context) {
        if (context == null || data == null || TextUtils.isEmpty(data.isCollection)) {
            return null;
        }
        if (TextUtils.equals(data.isCollection, "0")) {
            return data.duration;
        }
        if (TextUtils.isEmpty(data.chapterNum) || TextUtils.isEmpty(data.chapterLastNum)) {
            return null;
        }
        if (TextUtils.equals(data.chapterNum, data.chapterLastNum)) {
            return data.chapterNum + context.getString(R.string.paywall_av_tag_collect_all_text);
        }
        return context.getString(R.string.paywall_av_tag_update_to_text) + data.chapterLastNum + context.getString(R.string.paywall_av_tag_collect_part_text);
    }

    public final String getModifyTimeStr(long modifyTime) {
        String str;
        if (modifyTime <= 0) {
            return "暂无更新时间";
        }
        Calendar currentCalendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(currentCalendar, "getInstance()");
        long j2 = (long) 1000;
        long passedSeconds = (currentCalendar.getTimeInMillis() / j2) - modifyTime;
        StringBuilder sb = new StringBuilder();
        if (passedSeconds < 60) {
            str = "刚刚";
        } else if (passedSeconds < NovelConstant.HOUR_SECONDS) {
            str = (passedSeconds / ((long) 60)) + "分钟前";
        } else if (passedSeconds < 86400) {
            str = (passedSeconds / ((long) 3600)) + "小时前";
        } else if (passedSeconds < MyMessageConstants.LEADING_DIALOG_ADJUST_INTERVAL_TIME) {
            str = ((passedSeconds / ((long) 3600)) / ((long) 24)) + "天前";
        } else {
            Calendar modifyCalendar = Calendar.getInstance();
            modifyCalendar.setTimeInMillis(j2 * modifyTime);
            str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(modifyCalendar.getTime());
        }
        return sb.append(str).append("更新").toString();
    }

    public final void setOwnTypeOrResourceFreeTag(ImageView tagImage, PaywallItem itemData) {
        Intrinsics.checkNotNullParameter(tagImage, "tagImage");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        String str = itemData.status;
        if (Intrinsics.areEqual((Object) str, (Object) "2")) {
            tagImage.setVisibility(0);
            tagImage.setImageResource(R.drawable.paywall_item_off_shelf_tag);
        } else if (Intrinsics.areEqual((Object) str, (Object) "1")) {
            tagImage.setVisibility(0);
            if (TextUtils.equals(itemData.ownType, "1")) {
                tagImage.setImageResource(R.drawable.paywall_item_update_bought_tag);
            } else {
                tagImage.setImageResource(R.drawable.paywall_item_update_tag);
            }
        } else if (TextUtils.equals(itemData.ownType, "1")) {
            tagImage.setVisibility(0);
            tagImage.setImageResource(R.drawable.paywall_item_bought_tag);
        } else {
            tagImage.setVisibility(8);
        }
    }

    public final int getDocCoverDrawableId(PaywallItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.resourceType) {
            case 21:
                return R.drawable.paywall_doc_cover_doc;
            case 22:
                return R.drawable.paywall_doc_cover_xls;
            case 23:
                return R.drawable.paywall_doc_cover_ppt;
            case 24:
                return R.drawable.paywall_doc_cover_pdf;
            case 25:
                return R.drawable.paywall_doc_cover_txt;
            case 26:
                return R.drawable.paywall_doc_cover_vsd;
            case 27:
                return R.drawable.paywall_doc_cover_epub;
            case 28:
                return R.drawable.paywall_doc_cover_epub;
            case 29:
                return R.drawable.paywall_doc_cover_cad;
            default:
                return R.drawable.paywall_doc_cover_unknow;
        }
    }

    public final int getDocCoverTagIconId(PaywallItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.resourceType) {
            case 21:
                return R.drawable.paywall_doc_type_tag_doc;
            case 22:
                return R.drawable.paywall_doc_type_tag_xls;
            case 23:
                return R.drawable.paywall_doc_type_tag_ppt;
            case 24:
                return R.drawable.paywall_doc_type_tag_pdf;
            case 25:
                return R.drawable.paywall_doc_type_tag_txt;
            case 26:
                return R.drawable.paywall_doc_type_tag_vsd;
            case 27:
                return R.drawable.paywall_doc_type_tag_epub;
            case 28:
                return R.drawable.paywall_doc_type_tag_epub;
            case 29:
                return R.drawable.paywall_doc_type_tag_cad;
            default:
                return R.drawable.paywall_doc_type_tag_unknow;
        }
    }

    public final List<Map<String, Object>> jsonArrayToList$lib_paywall_release(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        int len = jsonArray.length();
        ArrayList list = new ArrayList();
        for (int i2 = 0; i2 < len; i2++) {
            Map map = jsonObjectToMap(jsonArray.optJSONObject(i2));
            if (map != null) {
                list.add(map);
            }
        }
        return list;
    }

    private final Map<String, Object> jsonObjectToMap(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        Iterator keyIterator = jsonObject.keys();
        Intrinsics.checkNotNullExpressionValue(keyIterator, "jsonObject.keys()");
        Object valueMap = new HashMap();
        while (keyIterator.hasNext()) {
            String next = keyIterator.next();
            Object value = jsonObject.opt(next);
            if (value instanceof JSONObject) {
                Map it = jsonObjectToMap((JSONObject) value);
                if (it != null) {
                    valueMap.put(next, it);
                }
            } else if (value != null) {
                valueMap.put(next, value);
            }
        }
        return (Map) valueMap;
    }
}
