package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.download.center.clearcache.view.funison.ClearCacheConstant;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheContentCardInfo;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheStatistic;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheContentCardHeaderView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheContentCard.kt */
final class ClearCacheContentCard$mHeaderView$2 extends Lambda implements Function0<ClearCacheContentCardHeaderView> {
    final /* synthetic */ ClearCacheContentCard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCacheContentCard$mHeaderView$2(ClearCacheContentCard clearCacheContentCard) {
        super(0);
        this.this$0 = clearCacheContentCard;
    }

    public final ClearCacheContentCardHeaderView invoke() {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ClearCacheContentCardHeaderView clearCacheContentCardHeaderView = new ClearCacheContentCardHeaderView(context);
        ClearCacheContentCard clearCacheContentCard = this.this$0;
        ClearCacheContentCardHeaderView $this$invoke_u24lambda_u2d1 = clearCacheContentCardHeaderView;
        $this$invoke_u24lambda_u2d1.setId(ViewCompat.generateViewId());
        $this$invoke_u24lambda_u2d1.setOnClickListener(new ClearCacheContentCard$mHeaderView$2$$ExternalSyntheticLambda0(clearCacheContentCard));
        return clearCacheContentCardHeaderView;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m17339invoke$lambda1$lambda0(ClearCacheContentCard this$02, View it) {
        String str;
        String ubcValue;
        String ubcType;
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        ClearCacheContentCardInfo clearCacheContentCardData = this$02.getClearCacheContentCardData();
        if (clearCacheContentCardData != null) {
            boolean isExpand = clearCacheContentCardData.isExpand();
            ClearCacheContentCardInfo clearCacheContentCardData2 = this$02.getClearCacheContentCardData();
            if (clearCacheContentCardData2 == null || (str = clearCacheContentCardData2.getTitle()) == null) {
                str = "";
            }
            if (Intrinsics.areEqual((Object) str, (Object) ClearCacheConstant.CONTENT_CARD_TITLE_CACHE_FILE)) {
                ubcValue = "cache_file";
            } else if (Intrinsics.areEqual((Object) str, (Object) ClearCacheConstant.CONTENT_CARD_TITLE_PRIVACY_RECORD)) {
                ubcValue = "privacy";
            } else {
                ubcValue = "";
            }
            if (isExpand) {
                ubcType = "fold";
            } else {
                ubcType = "open";
            }
            ClearCacheStatistic.doClearCacheUbc$default(ClearCacheStatistic.INSTANCE, (String) null, ubcType, (String) null, this$02.getUbcPage(), ubcValue, (JSONObject) null, (String) null, 101, (Object) null);
            ClearCacheContentCardInfo clearCacheContentCardData3 = this$02.getClearCacheContentCardData();
            if (clearCacheContentCardData3 != null) {
                clearCacheContentCardData3.setExpand(!isExpand);
            }
            this$02.updateView();
        }
    }
}
