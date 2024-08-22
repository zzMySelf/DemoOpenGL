package com.baidu.searchbox.unifiedtoolbar.base;

import android.text.TextUtils;
import com.baidu.searchbox.praise.PraiseEffectType;
import com.baidu.searchbox.praise.model.BottomBarPraiseInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/unifiedtoolbar/base/BottomBarPraiseInfoEvent;", "", "likeInfoStr", "", "(Ljava/lang/String;)V", "<set-?>", "Lcom/baidu/searchbox/praise/model/BottomBarPraiseInfo;", "praiseInfo", "getPraiseInfo", "()Lcom/baidu/searchbox/praise/model/BottomBarPraiseInfo;", "valueOf", "lib-unified-toolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarPraiseInfoEvent.kt */
public final class BottomBarPraiseInfoEvent {
    private BottomBarPraiseInfo praiseInfo;

    public BottomBarPraiseInfoEvent(String likeInfoStr) {
        if (!TextUtils.isEmpty(likeInfoStr)) {
            this.praiseInfo = valueOf(likeInfoStr);
        }
    }

    public final BottomBarPraiseInfo getPraiseInfo() {
        return this.praiseInfo;
    }

    private final BottomBarPraiseInfo valueOf(String likeInfoStr) {
        Object obj;
        BottomBarPraiseInfo bottomBarPraiseInfo = null;
        if (likeInfoStr == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            BottomBarPraiseInfoEvent bottomBarPraiseInfoEvent = this;
            JSONObject params = new JSONObject(likeInfoStr);
            BottomBarPraiseInfo bottomBarPraiseInfo2 = new BottomBarPraiseInfo();
            BottomBarPraiseInfo $this$valueOf_u24lambda_u2d1_u24lambda_u2d0 = bottomBarPraiseInfo2;
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.ext = params.optString("ext");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.nid = params.optString("nid");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.isPraised = Intrinsics.areEqual((Object) "1", (Object) params.optString("status"));
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.praiseCount = params.optString("count");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.likeSyncData = params.optString("syncdata");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.importantIconName = params.optString("icon_name");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.disableAnimation = params.optString("disable_anim");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.praiseTipType = params.optString("praise_tip_style");
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.animType = PraiseEffectType.Companion.map(params.optString("animation_type"));
            $this$valueOf_u24lambda_u2d1_u24lambda_u2d0.animName = params.optString("animation_name");
            obj = Result.m8971constructorimpl(bottomBarPraiseInfo2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m8977isFailureimpl(obj)) {
            bottomBarPraiseInfo = obj;
        }
        return bottomBarPraiseInfo;
    }
}
