package com.baidu.searchbox.bigimage.utils;

import android.content.Context;
import com.baidu.searchbox.bigimage.model.BigImageAsset;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BigImageJumpToBuyHelper$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ BigImageJumpToBuyHelper f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ BigImageAsset.CommodityInfo f$2;

    public /* synthetic */ BigImageJumpToBuyHelper$$ExternalSyntheticLambda2(BigImageJumpToBuyHelper bigImageJumpToBuyHelper, Context context, BigImageAsset.CommodityInfo commodityInfo) {
        this.f$0 = bigImageJumpToBuyHelper;
        this.f$1 = context;
        this.f$2 = commodityInfo;
    }

    public final void run() {
        BigImageJumpToBuyHelper.m16575jumpToBuyWithCps$lambda8$lambda6(this.f$0, this.f$1, this.f$2);
    }
}
