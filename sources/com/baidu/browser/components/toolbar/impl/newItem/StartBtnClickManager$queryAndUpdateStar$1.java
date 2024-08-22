package com.baidu.browser.components.toolbar.impl.newItem;

import com.baidu.searchbox.favor.data.FavorModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "favored", "", "favorPlayModel", "Lcom/baidu/searchbox/favor/data/FavorModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StartBtnClickManager.kt */
final class StartBtnClickManager$queryAndUpdateStar$1 extends Lambda implements Function2<Boolean, FavorModel, Unit> {
    final /* synthetic */ StartBtnClickManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartBtnClickManager$queryAndUpdateStar$1(StartBtnClickManager startBtnClickManager) {
        super(2);
        this.this$0 = startBtnClickManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), (FavorModel) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean favored, FavorModel favorPlayModel) {
        this.this$0.updateToolbarStar(false, favored);
    }
}
