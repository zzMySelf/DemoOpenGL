package com.baidu.browser.menu.longpress;

import android.content.Context;
import com.baidu.browser.menu.longpress.login.ItemModeHelper;
import com.baidu.search.abtest.SearchRecognizeImgABTestUtils;
import com.baidu.search.basic.utils.SearchABTestUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/browser/menu/longpress/ImageLongPressMenuBuilder$queryImageSearch$1", "Lcom/baidu/browser/menu/longpress/ImageRecognizeCallBack;", "doneImageRecognize", "", "imageResult", "Lcom/baidu/browser/menu/longpress/ImageRecognizeResult;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressMenuBuilder.kt */
public final class ImageLongPressMenuBuilder$queryImageSearch$1 implements ImageRecognizeCallBack {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $from;
    final /* synthetic */ ILongPressMenuHelper $helper;
    final /* synthetic */ LongPressMenuContext $menuContext;
    final /* synthetic */ ItemModeHelper $modeHelper;
    final /* synthetic */ String $pd;
    final /* synthetic */ ImageLongPressMenuBuilder this$0;

    ImageLongPressMenuBuilder$queryImageSearch$1(ILongPressMenuHelper $helper2, LongPressMenuContext $menuContext2, ImageLongPressMenuBuilder $receiver, Context $context2, ItemModeHelper $modeHelper2, String $pd2, String $from2) {
        this.$helper = $helper2;
        this.$menuContext = $menuContext2;
        this.this$0 = $receiver;
        this.$context = $context2;
        this.$modeHelper = $modeHelper2;
        this.$pd = $pd2;
        this.$from = $from2;
    }

    public void doneImageRecognize(ImageRecognizeResult imageResult) {
        Intrinsics.checkNotNullParameter(imageResult, "imageResult");
        if (!SearchABTestUtils.enableNewLongPressMenu() || !SearchABTestUtils.isLongPressLogin() || this.$helper.isMenuShowing()) {
            this.$menuContext.setImageRecognizeResult(imageResult);
            CharSequence mCodeType = imageResult.getMCodeType();
            boolean isImageTypeAndShowing = false;
            if (!(mCodeType == null || mCodeType.length() == 0)) {
                CharSequence mCodeText = imageResult.getMCodeText();
                if (!(mCodeText == null || mCodeText.length() == 0)) {
                    if (this.this$0.updateMenuItemForAddBarcode(this.$context, this.$menuContext, this.$helper.getCommonMenuList())) {
                        this.$helper.reloadMenuList(this.$modeHelper);
                    }
                    LongPressMenuBuilderKt.doStatisticsShowUBCForImagePopMenu$default(this.$menuContext, this.$helper.getCommonMenuList(), false, this.$pd, false, 16, (Object) null);
                }
            }
            if (imageResult.getNeedShowLog()) {
                if (this.$helper.isMenuShowing() && this.$menuContext.isImageMenu()) {
                    isImageTypeAndShowing = true;
                }
                LongPressMenuBuilderKt.handleImageSearchShowApiLog(this.$from, isImageTypeAndShowing);
            }
            if (SearchRecognizeImgABTestUtils.isExp()) {
                if (this.this$0.updateMenuItemForRecognizeImg(this.$context, imageResult, this.$helper.getCommonMenuList(), this.$helper.getCustomCommonMenuList(), this.$helper)) {
                    this.$helper.reloadMenuList(this.$modeHelper);
                }
            }
        }
    }
}
