package com.baidu.searchbox.mvp.aicard;

import com.baidu.searchbox.mvp.entity.Card;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/mvp/aicard/AiCardData;", "", "sign", "", "scene", "type", "cards", "", "Lcom/baidu/searchbox/mvp/entity/Card;", "guide", "isBlindbox", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "getCards", "()Ljava/util/List;", "getGuide", "()Ljava/lang/String;", "()Z", "getScene", "getSign", "getType", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCardState.kt */
public final class AiCardData {
    private final List<Card> cards;
    private final String guide;
    private final boolean isBlindbox;
    private final String scene;
    private final String sign;
    private final String type;

    public AiCardData(String sign2, String scene2, String type2, List<Card> cards2, String guide2, boolean isBlindbox2) {
        this.sign = sign2;
        this.scene = scene2;
        this.type = type2;
        this.cards = cards2;
        this.guide = guide2;
        this.isBlindbox = isBlindbox2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AiCardData(String str, String str2, String str3, List list, String str4, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, str4, (i2 & 32) != 0 ? false : z);
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getType() {
        return this.type;
    }

    public final List<Card> getCards() {
        return this.cards;
    }

    public final String getGuide() {
        return this.guide;
    }

    public final boolean isBlindbox() {
        return this.isBlindbox;
    }
}
