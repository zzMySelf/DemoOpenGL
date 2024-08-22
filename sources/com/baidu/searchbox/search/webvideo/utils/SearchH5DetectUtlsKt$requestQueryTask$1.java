package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.searchbox.search.webvideo.model.QueryNetDiskTaskModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "isSuccess", "", "isSmooth", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5DetectUtls.kt */
final class SearchH5DetectUtlsKt$requestQueryTask$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ String $sourceUrl;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchH5DetectUtlsKt$requestQueryTask$1(String str, String str2, String str3) {
        super(2);
        this.$sourceUrl = str;
        this.$pageUrl = str2;
        this.$title = str3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess, boolean isSmooth) {
        if (isSmooth && isSuccess) {
            QueryNetDiskTaskModel.RAPID_ABLE_URL_LIST_NEW.add(this.$sourceUrl);
        }
        SearchH5DetectUtlsKt.rapidDownloadUbcEvent((!isSuccess || !isSmooth) ? "wangpan" : SearchH5VideoUbcUtils.WANG_PAN_SOON, this.$sourceUrl, this.$pageUrl, this.$title);
    }
}
