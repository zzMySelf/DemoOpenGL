package com.baidu.searchbox.bookmark.favor.playlet;

import com.baidu.searchbox.favor.data.FavorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/favor/data/FavorModel;", "invoke", "(Lcom/baidu/searchbox/favor/data/FavorModel;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorPlayletView.kt */
final class FavorPlayletView$removeItem$1$1 extends Lambda implements Function1<FavorModel, Boolean> {
    final /* synthetic */ String $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FavorPlayletView$removeItem$1$1(String str) {
        super(1);
        this.$key = str;
    }

    public final Boolean invoke(FavorModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) it.uKey, (Object) this.$key));
    }
}
