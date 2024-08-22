package com.baidu.searchbox.smartmenu.cloudconfig.model;

import com.baidu.searchbox.smartmenu.SmartMenuCardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0015\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\b¨\u00067"}, d2 = {"Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardModel;", "", "()V", "ban", "", "getBan", "()Ljava/lang/String;", "setBan", "(Ljava/lang/String;)V", "channels", "", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "clearVersion", "getClearVersion", "setClearVersion", "inOutRestoreRules", "Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardInOutRulesModel;", "getInOutRestoreRules", "()Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardInOutRulesModel;", "setInOutRestoreRules", "(Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardInOutRulesModel;)V", "isClear", "", "()Z", "setClear", "(Z)V", "items", "Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardItemModel;", "getItems", "setItems", "ranking", "", "getRanking", "()D", "setRanking", "(D)V", "subtitle", "getSubtitle", "setSubtitle", "subtitleDark", "getSubtitleDark", "setSubtitleDark", "title", "getTitle", "setTitle", "titleDark", "getTitleDark", "setTitleDark", "type", "getType", "setType", "Companion", "lib-smart-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuModel.kt */
public final class SmartMenuCardModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CARD_BAN = "ban";
    public static final String KEY_CARD_CHANNELS = "channels";
    public static final String KEY_CARD_CLEARVERSION = "clearVersion";
    public static final String KEY_CARD_ID = "groupId";
    public static final String KEY_CARD_INRULES = "inRules";
    public static final String KEY_CARD_ISCLEAR = "isClear";
    public static final String KEY_CARD_ITEMS = "items";
    public static final String KEY_CARD_OUTRULES = "outRules";
    public static final String KEY_CARD_RANKING = "ranking";
    public static final String KEY_CARD_RESTORE_RULES = "restoreRules";
    public static final String KEY_CARD_SUBTITLE = "subtitle";
    public static final String KEY_CARD_SUBTITLEDARK = "subtitleDark";
    public static final String KEY_CARD_TITLE = "title";
    public static final String KEY_CARD_TITLEDARK = "titleDark";
    private String ban;
    private List<String> channels;
    private String clearVersion;
    private SmartMenuCardInOutRulesModel inOutRestoreRules;
    private boolean isClear;
    private List<SmartMenuCardItemModel> items;
    private double ranking = -1.0d;
    private String subtitle;
    private String subtitleDark;
    private String title;
    private String titleDark;
    private String type = "";

    @JvmStatic
    private static final boolean dataCheck(SmartMenuCardModel smartMenuCardModel) {
        return Companion.dataCheck(smartMenuCardModel);
    }

    @JvmStatic
    private static final List<String> parseChannels(JSONArray jSONArray) {
        return Companion.parseChannels(jSONArray);
    }

    @JvmStatic
    public static final List<SmartMenuCardModel> parseFromJsonArray(JSONArray jSONArray, String str) {
        return Companion.parseFromJsonArray(jSONArray, str);
    }

    @JvmStatic
    public static final JSONArray parseToJSON(List<SmartMenuCardModel> list) {
        return Companion.parseToJSON(list);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0003J\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardModel$Companion;", "", "()V", "KEY_CARD_BAN", "", "KEY_CARD_CHANNELS", "KEY_CARD_CLEARVERSION", "KEY_CARD_ID", "KEY_CARD_INRULES", "KEY_CARD_ISCLEAR", "KEY_CARD_ITEMS", "KEY_CARD_OUTRULES", "KEY_CARD_RANKING", "KEY_CARD_RESTORE_RULES", "KEY_CARD_SUBTITLE", "KEY_CARD_SUBTITLEDARK", "KEY_CARD_TITLE", "KEY_CARD_TITLEDARK", "dataCheck", "", "cardModel", "Lcom/baidu/searchbox/smartmenu/cloudconfig/model/SmartMenuCardModel;", "parseChannels", "", "jsonArray", "Lorg/json/JSONArray;", "parseFromJsonArray", "sceneStr", "parseToJSON", "cardList", "lib-smart-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SmartMenuModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<SmartMenuCardModel> parseFromJsonArray(JSONArray jsonArray, String sceneStr) {
            Intrinsics.checkNotNullParameter(sceneStr, "sceneStr");
            if (jsonArray == null || jsonArray.length() == 0) {
                return null;
            }
            List cardList = new ArrayList();
            int length = jsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                SmartMenuCardModel card = new SmartMenuCardModel();
                JSONObject obj = jsonArray.optJSONObject(i2);
                String optString = obj.optString("groupId");
                Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(KEY_CARD_ID)");
                card.setType(optString);
                if (!(card.getType().length() == 0)) {
                    card.setBan(obj.optString(SmartMenuCardModel.KEY_CARD_BAN));
                    if (!Intrinsics.areEqual((Object) card.getBan(), (Object) "1")) {
                        card.setTitle(obj.optString("title"));
                        card.setSubtitle(obj.optString("subtitle"));
                        card.setTitleDark(obj.optString(SmartMenuCardModel.KEY_CARD_TITLEDARK));
                        card.setSubtitleDark(obj.optString(SmartMenuCardModel.KEY_CARD_SUBTITLEDARK));
                        card.setClear(Intrinsics.areEqual((Object) obj.optString(SmartMenuCardModel.KEY_CARD_ISCLEAR), (Object) "1"));
                        card.setClearVersion(obj.optString(SmartMenuCardModel.KEY_CARD_CLEARVERSION));
                        String optString2 = obj.optString(SmartMenuCardModel.KEY_CARD_RANKING);
                        Intrinsics.checkNotNullExpressionValue(optString2, "obj.optString(KEY_CARD_RANKING)");
                        Double doubleOrNull = StringsKt.toDoubleOrNull(optString2);
                        card.setRanking(doubleOrNull != null ? doubleOrNull.doubleValue() : -1.0d);
                        card.setInOutRestoreRules(SmartMenuCardInOutRulesModel.Companion.parseFromJson(obj.optJSONObject(SmartMenuCardModel.KEY_CARD_INRULES), obj.optJSONObject(SmartMenuCardModel.KEY_CARD_OUTRULES), obj.optJSONObject(SmartMenuCardModel.KEY_CARD_RESTORE_RULES)));
                        card.setItems(SmartMenuCardItemModel.Companion.parseFromJsonArray(obj.optJSONArray("items"), sceneStr));
                        card.setChannels(parseChannels(obj.optJSONArray(SmartMenuCardModel.KEY_CARD_CHANNELS)));
                        if (dataCheck(card)) {
                            cardList.add(card);
                        }
                    }
                }
            }
            return cardList;
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final List<String> parseChannels(JSONArray jsonArray) {
            if (jsonArray == null) {
                return CollectionsKt.emptyList();
            }
            List list = new ArrayList();
            int length = jsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject obj = jsonArray.optJSONObject(i2);
                if (obj != null) {
                    String id = obj.optString("id");
                    CharSequence charSequence = id;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        Intrinsics.checkNotNullExpressionValue(id, "id");
                        list.add(id);
                    }
                }
            }
            return list;
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final boolean dataCheck(SmartMenuCardModel cardModel) {
            SmartMenuCardType type = SmartMenuCardType.Companion.fromString(cardModel.getType());
            if (type == SmartMenuCardType.DEFAULT) {
                return false;
            }
            if (type == SmartMenuCardType.COMMON_FUNCTION) {
                Collection items = cardModel.getItems();
                if (items == null || items.isEmpty()) {
                    return false;
                }
            }
            if (type == SmartMenuCardType.SHARE) {
                Collection channels = cardModel.getChannels();
                if (channels == null || channels.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @JvmStatic
        public final JSONArray parseToJSON(List<SmartMenuCardModel> cardList) {
            Collection collection = cardList;
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            JSONArray jsonArray = new JSONArray();
            for (SmartMenuCardModel card : cardList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groupId", card.getType());
                jsonObject.put("title", card.getTitle());
                jsonObject.put("subtitle", card.getSubtitle());
                jsonObject.put(SmartMenuCardModel.KEY_CARD_TITLEDARK, card.getTitleDark());
                jsonObject.put(SmartMenuCardModel.KEY_CARD_SUBTITLEDARK, card.getSubtitleDark());
                jsonObject.put(SmartMenuCardModel.KEY_CARD_ISCLEAR, card.isClear() ? "1" : "0");
                jsonObject.put(SmartMenuCardModel.KEY_CARD_CLEARVERSION, card.getClearVersion());
                jsonObject.put(SmartMenuCardModel.KEY_CARD_RANKING, card.getRanking());
                jsonObject.put(SmartMenuCardModel.KEY_CARD_BAN, card.getBan());
                jsonObject.put(SmartMenuCardModel.KEY_CARD_INRULES, SmartMenuCardInOutRulesModel.Companion.parseToInJSON(card.getInOutRestoreRules()));
                jsonObject.put(SmartMenuCardModel.KEY_CARD_OUTRULES, SmartMenuCardInOutRulesModel.Companion.parseToOutJSON(card.getInOutRestoreRules()));
                jsonObject.put(SmartMenuCardModel.KEY_CARD_RESTORE_RULES, SmartMenuCardInOutRulesModel.Companion.parseToRestoreJSON(card.getInOutRestoreRules()));
                jsonObject.put("items", SmartMenuCardItemModel.Companion.parseToJSONArray(card.getItems()));
                JSONArray channelsJson = new JSONArray();
                List<String> $this$forEach$iv = card.getChannels();
                if ($this$forEach$iv != null) {
                    for (String it : $this$forEach$iv) {
                        channelsJson.put(new JSONObject().put("id", it));
                    }
                }
                jsonObject.put(SmartMenuCardModel.KEY_CARD_CHANNELS, channelsJson);
                jsonArray.put(jsonObject);
            }
            return jsonArray;
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    public final String getTitleDark() {
        return this.titleDark;
    }

    public final void setTitleDark(String str) {
        this.titleDark = str;
    }

    public final String getSubtitleDark() {
        return this.subtitleDark;
    }

    public final void setSubtitleDark(String str) {
        this.subtitleDark = str;
    }

    public final boolean isClear() {
        return this.isClear;
    }

    public final void setClear(boolean z) {
        this.isClear = z;
    }

    public final String getClearVersion() {
        return this.clearVersion;
    }

    public final void setClearVersion(String str) {
        this.clearVersion = str;
    }

    public final double getRanking() {
        return this.ranking;
    }

    public final void setRanking(double d2) {
        this.ranking = d2;
    }

    public final String getBan() {
        return this.ban;
    }

    public final void setBan(String str) {
        this.ban = str;
    }

    public final SmartMenuCardInOutRulesModel getInOutRestoreRules() {
        return this.inOutRestoreRules;
    }

    public final void setInOutRestoreRules(SmartMenuCardInOutRulesModel smartMenuCardInOutRulesModel) {
        this.inOutRestoreRules = smartMenuCardInOutRulesModel;
    }

    public final List<SmartMenuCardItemModel> getItems() {
        return this.items;
    }

    public final void setItems(List<SmartMenuCardItemModel> list) {
        this.items = list;
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final void setChannels(List<String> list) {
        this.channels = list;
    }
}
