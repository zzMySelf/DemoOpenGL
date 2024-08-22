package com.baidu.searchbox.mvp.aicard;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.mvp.common.MvpCommonPageExtKt;
import com.baidu.searchbox.mvp.entity.Card;
import com.baidu.searchbox.mvp.imggentxt.AiPublisherImgGenTxtAction;
import com.baidu.searchbox.mvp.imggentxt.AiPublisherImgGenTxtModel;
import com.baidu.searchbox.mvp.loading.MvpLoadingModel;
import com.baidu.searchbox.ugc.model.ImageStruct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "card", "Lcom/baidu/searchbox/mvp/entity/Card;", "images", "", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCardComponent.kt */
final class AiCardComponent$aiCardHelper$2$1$2 extends Lambda implements Function2<Card, List<? extends ImageStruct>, Unit> {
    final /* synthetic */ AiCardComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiCardComponent$aiCardHelper$2$1$2(AiCardComponent aiCardComponent) {
        super(2);
        this.this$0 = aiCardComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Card) p1, (List<? extends ImageStruct>) (List) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(Card card, List<? extends ImageStruct> images) {
        Intrinsics.checkNotNullParameter(images, "images");
        AiPublisherImgGenTxtModel genTxtModel = new AiPublisherImgGenTxtModel(images, card);
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new AiPublisherImgGenTxtAction.StartGenTxt(genTxtModel));
        }
        String str = null;
        MvpLoadingModel $this$invoke_u24lambda_u2d0 = new MvpLoadingModel((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        AiCardComponent aiCardComponent = this.this$0;
        $this$invoke_u24lambda_u2d0.setMark(card != null ? card.getMark() : null);
        Store access$getStore2 = aiCardComponent.getStore();
        if (access$getStore2 != null) {
            str = MvpCommonPageExtKt.getImg2TxtLoadingTitle(access$getStore2);
        }
        $this$invoke_u24lambda_u2d0.setTitle(str);
        Store access$getStore3 = this.this$0.getStore();
        if (access$getStore3 != null) {
            MvpCommonPageExtKt.startAiPublisherLoadingPage(access$getStore3, $this$invoke_u24lambda_u2d0);
        }
    }
}
