package com.baidu.searchbox.aisearch.comps.conversationmanager;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.aibot.statistic.AIBotStatisConst;
import com.baidu.searchbox.aisearch.statistic.AISearchStats;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0007J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/ConversationManagerUBC;", "", "aiSearchStats", "Lcom/baidu/searchbox/aisearch/statistic/AISearchStats;", "(Lcom/baidu/searchbox/aisearch/statistic/AISearchStats;)V", "clickAIBotEvent", "", "appId", "", "clickEvent", "manageIcon", "title", "clickTabEvent", "manageTab", "deleteDialogEvent", "type", "popupType", "popupIcon", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationManagerUBC.kt */
public final class ConversationManagerUBC {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXT_BOT_CONTENT = "bot_content";
    public static final String EXT_CANCEL = "cancel";
    public static final String EXT_DELETE = "delete";
    public static final String EXT_DELETE_DIALOG_CLEAR = "clear";
    private static final String EXT_DELETE_DIALOG_ICON = "delete_popup_icon";
    private static final String EXT_DELETE_DIALOG_TYPE = "delete_popup_type";
    public static final String EXT_LIST = "list";
    public static final String EXT_MANAGE_ICON = "manage_icon";
    public static final String EXT_MANAGE_TAB = "manage_tab";
    public static final String EXT_REGIN = "region";
    private static final String EXT_TITLE = "title";
    private final AISearchStats aiSearchStats;

    public ConversationManagerUBC(AISearchStats aiSearchStats2) {
        Intrinsics.checkNotNullParameter(aiSearchStats2, "aiSearchStats");
        this.aiSearchStats = aiSearchStats2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/ConversationManagerUBC$Companion;", "", "()V", "EXT_BOT_CONTENT", "", "EXT_CANCEL", "EXT_DELETE", "EXT_DELETE_DIALOG_CLEAR", "EXT_DELETE_DIALOG_ICON", "EXT_DELETE_DIALOG_TYPE", "EXT_LIST", "EXT_MANAGE_ICON", "EXT_MANAGE_TAB", "EXT_REGIN", "EXT_TITLE", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationManagerUBC.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void clickEvent$default(ConversationManagerUBC conversationManagerUBC, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        conversationManagerUBC.clickEvent(str, str2);
    }

    public final void clickEvent(String manageIcon, String title) {
        Intrinsics.checkNotNullParameter(manageIcon, "manageIcon");
        Map mapParams = new LinkedHashMap();
        mapParams.put(EXT_MANAGE_ICON, manageIcon);
        if (Intrinsics.areEqual((Object) manageIcon, (Object) "list") || Intrinsics.areEqual((Object) manageIcon, (Object) "delete")) {
            mapParams.put("title", title == null ? "" : title);
        }
        this.aiSearchStats.onModuleClick("session_manage", "session_manage", mapParams);
    }

    public final void clickTabEvent(String manageTab) {
        Intrinsics.checkNotNullParameter(manageTab, "manageTab");
        Map mapParams = new LinkedHashMap();
        mapParams.put(EXT_MANAGE_TAB, manageTab);
        this.aiSearchStats.onModuleClick("session_manage", "session_manage", mapParams);
    }

    public final void clickAIBotEvent(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Map mapParams = new LinkedHashMap();
        Map $this$clickAIBotEvent_u24lambda_u2d3 = mapParams;
        $this$clickAIBotEvent_u24lambda_u2d3.put(EXT_MANAGE_TAB, "bot");
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$clickAIBotEvent_u24lambda_u2d3_u24lambda_u2d2 = jSONObject;
        $this$clickAIBotEvent_u24lambda_u2d3_u24lambda_u2d2.put("appid", appId);
        $this$clickAIBotEvent_u24lambda_u2d3_u24lambda_u2d2.put(AIBotStatisConst.BOT_SOURCE, (Object) null);
        Unit unit = Unit.INSTANCE;
        $this$clickAIBotEvent_u24lambda_u2d3.put("bot_content", jSONObject);
        this.aiSearchStats.onModuleClick("session_manage", "session_manage", mapParams);
    }

    public static /* synthetic */ void deleteDialogEvent$default(ConversationManagerUBC conversationManagerUBC, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        conversationManagerUBC.deleteDialogEvent(str, str2, str3);
    }

    public final void deleteDialogEvent(String type, String popupType, String popupIcon) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(popupType, "popupType");
        UiThreadUtils.runOnUiThread(new ConversationManagerUBC$$ExternalSyntheticLambda0(type, this, popupType, popupIcon));
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteDialogEvent$lambda-6  reason: not valid java name */
    public static final void m15667deleteDialogEvent$lambda6(String $type, ConversationManagerUBC this$0, String $popupType, String $popupIcon) {
        Intrinsics.checkNotNullParameter($type, "$type");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($popupType, "$popupType");
        boolean z = false;
        if (Intrinsics.areEqual((Object) "show", (Object) $type)) {
            AISearchStats aISearchStats = this$0.aiSearchStats;
            HashMap hashMap = new HashMap();
            HashMap $this$deleteDialogEvent_u24lambda_u2d6_u24lambda_u2d4 = hashMap;
            $this$deleteDialogEvent_u24lambda_u2d6_u24lambda_u2d4.put(EXT_DELETE_DIALOG_TYPE, $popupType);
            CharSequence charSequence = $popupIcon;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (!z) {
                $this$deleteDialogEvent_u24lambda_u2d6_u24lambda_u2d4.put(EXT_DELETE_DIALOG_ICON, $popupIcon);
            }
            Unit unit = Unit.INSTANCE;
            aISearchStats.onModuleShow("session_manage", "delete_popup", hashMap);
        } else if (Intrinsics.areEqual((Object) "click", (Object) $type)) {
            AISearchStats aISearchStats2 = this$0.aiSearchStats;
            HashMap hashMap2 = new HashMap();
            HashMap $this$deleteDialogEvent_u24lambda_u2d6_u24lambda_u2d5 = hashMap2;
            $this$deleteDialogEvent_u24lambda_u2d6_u24lambda_u2d5.put(EXT_DELETE_DIALOG_TYPE, $popupType);
            CharSequence charSequence2 = $popupIcon;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                $this$deleteDialogEvent_u24lambda_u2d6_u24lambda_u2d5.put(EXT_DELETE_DIALOG_ICON, $popupIcon);
            }
            Unit unit2 = Unit.INSTANCE;
            aISearchStats2.onModuleClick("session_manage", "delete_popup", hashMap2);
        }
    }
}
