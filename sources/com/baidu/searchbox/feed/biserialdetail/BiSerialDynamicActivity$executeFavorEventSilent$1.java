package com.baidu.searchbox.feed.biserialdetail;

import com.baidu.searchbox.bookmark.BookMarkLoginUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.biserialdetail.BiSerialDynamicActivity;
import com.baidu.searchbox.feed.biserialdetail.model.DynamicDetailFlow;
import com.baidu.searchbox.feed.biserialdetail.net.DynamicDetailDataParse;
import com.baidu.searchbox.sync.FavorUIOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/BiSerialDynamicActivity$executeFavorEventSilent$1", "Lcom/baidu/searchbox/bookmark/BookMarkLoginUtils$OnAllowBookMarkListener;", "allowUseBookMark", "", "loginFail", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialDynamicActivity.kt */
public final class BiSerialDynamicActivity$executeFavorEventSilent$1 implements BookMarkLoginUtils.OnAllowBookMarkListener {
    final /* synthetic */ Function1<BiSerialDynamicActivity.FavorState, Unit> $cb;
    final /* synthetic */ DynamicDetailFlow.FavouriteInfo $model;
    final /* synthetic */ BiSerialDynamicActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialDynamicActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FavorUIOperator.OperatorStatus.values().length];
            iArr[FavorUIOperator.OperatorStatus.ADD_SUCCESS.ordinal()] = 1;
            iArr[FavorUIOperator.OperatorStatus.REMOVE_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BiSerialDynamicActivity$executeFavorEventSilent$1(DynamicDetailFlow.FavouriteInfo $model2, Function1<? super BiSerialDynamicActivity.FavorState, Unit> $cb2, BiSerialDynamicActivity $receiver) {
        this.$model = $model2;
        this.$cb = $cb2;
        this.this$0 = $receiver;
    }

    public void allowUseBookMark() {
        FavorModel favor = DynamicDetailDataParse.INSTANCE.toFavorModel(this.$model);
        if (favor == null || favor.shouldFilterUrl()) {
            Function1<BiSerialDynamicActivity.FavorState, Unit> function1 = this.$cb;
            if (function1 != null) {
                function1.invoke(BiSerialDynamicActivity.FavorState.ILLEGAL_UKEY);
                return;
            }
            return;
        }
        ExecutorUtilsExt.postOnSerial(new BiSerialDynamicActivity$executeFavorEventSilent$1$$ExternalSyntheticLambda0(this.this$0, favor, this.$cb), "addOrRemoveFavorAsyncInner");
    }

    /* access modifiers changed from: private */
    /* renamed from: allowUseBookMark$lambda-0  reason: not valid java name */
    public static final void m18465allowUseBookMark$lambda0(BiSerialDynamicActivity this$02, FavorModel $favor, Function1 $cb2) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        FavorUIOperator.OperatorStatus addOrRemoveFavor = FavorUIOperator.addOrRemoveFavor(this$02, $favor, (FavorUIOperator.FavorToast) null, false);
        switch (addOrRemoveFavor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[addOrRemoveFavor.ordinal()]) {
            case 1:
                if ($cb2 != null) {
                    $cb2.invoke(BiSerialDynamicActivity.FavorState.ADD_SUCCESS);
                    return;
                }
                return;
            case 2:
                if ($cb2 != null) {
                    $cb2.invoke(BiSerialDynamicActivity.FavorState.REMOVE_SUCCESS);
                    return;
                }
                return;
            default:
                if ($cb2 != null) {
                    $cb2.invoke(BiSerialDynamicActivity.FavorState.UNKNOWN_FAILED);
                    return;
                }
                return;
        }
    }

    public void loginFail() {
    }
}
