package com.baidu.searchbox.aibot.repo.collect;

import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel;", "", "()V", "Companion", "QueryCollectModel", "UpdateCollectModel", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotCollectModel.kt */
public class AIBotCollectModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_STATUS = "status";
    private static final String KEY_URL = "url";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel$UpdateCollectModel;", "Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel;", "collectCenterUrl", "", "(Ljava/lang/String;)V", "getCollectCenterUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AIBotCollectModel.kt */
    public static final class UpdateCollectModel extends AIBotCollectModel {
        private final String collectCenterUrl;

        public static /* synthetic */ UpdateCollectModel copy$default(UpdateCollectModel updateCollectModel, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = updateCollectModel.collectCenterUrl;
            }
            return updateCollectModel.copy(str);
        }

        public final String component1() {
            return this.collectCenterUrl;
        }

        public final UpdateCollectModel copy(String str) {
            return new UpdateCollectModel(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateCollectModel) && Intrinsics.areEqual((Object) this.collectCenterUrl, (Object) ((UpdateCollectModel) obj).collectCenterUrl);
        }

        public int hashCode() {
            String str = this.collectCenterUrl;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "UpdateCollectModel(collectCenterUrl=" + this.collectCenterUrl + ')';
        }

        public final String getCollectCenterUrl() {
            return this.collectCenterUrl;
        }

        public UpdateCollectModel(String collectCenterUrl2) {
            this.collectCenterUrl = collectCenterUrl2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel$QueryCollectModel;", "Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel;", "collectStatus", "", "(I)V", "getCollectStatus", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AIBotCollectModel.kt */
    public static final class QueryCollectModel extends AIBotCollectModel {
        private final int collectStatus;

        public static /* synthetic */ QueryCollectModel copy$default(QueryCollectModel queryCollectModel, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = queryCollectModel.collectStatus;
            }
            return queryCollectModel.copy(i2);
        }

        public final int component1() {
            return this.collectStatus;
        }

        public final QueryCollectModel copy(int i2) {
            return new QueryCollectModel(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QueryCollectModel) && this.collectStatus == ((QueryCollectModel) obj).collectStatus;
        }

        public int hashCode() {
            return Integer.hashCode(this.collectStatus);
        }

        public String toString() {
            return "QueryCollectModel(collectStatus=" + this.collectStatus + ')';
        }

        public final int getCollectStatus() {
            return this.collectStatus;
        }

        public QueryCollectModel(int collectStatus2) {
            this.collectStatus = collectStatus2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel$Companion;", "", "()V", "KEY_STATUS", "", "KEY_URL", "fromJson", "Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel;", "type", "", "jsonObject", "Lorg/json/JSONObject;", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AIBotCollectModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AIBotCollectModel fromJson(int type, JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            JSONObject $this$fromJson_u24lambda_u2d0 = jsonObject;
            switch (type) {
                case 0:
                    return new UpdateCollectModel(JSONExtKt.optStringIgnoreNulls($this$fromJson_u24lambda_u2d0, "url", ""));
                case 1:
                    return new QueryCollectModel($this$fromJson_u24lambda_u2d0.optInt("status", 0));
                default:
                    return null;
            }
        }
    }
}
