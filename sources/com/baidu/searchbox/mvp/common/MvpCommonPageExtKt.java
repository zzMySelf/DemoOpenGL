package com.baidu.searchbox.mvp.common;

import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.mvp.common.MvpCommonPageChangeAction;
import com.baidu.searchbox.mvp.entity.FallbackHint;
import com.baidu.searchbox.mvp.entity.MvpPublishConfigModel;
import com.baidu.searchbox.mvp.entity.SuccessGuide;
import com.baidu.searchbox.mvp.entity.TransitionState;
import com.baidu.searchbox.mvp.loading.MvpLoadingModel;
import com.baidu.searchbox.mvp.prepublish.AiPublisherDynamicPublishModel;
import com.baidu.searchbox.mvp.publishresult.MvpPublishResultModel;
import com.baidu.searchbox.ugc.model.UgcConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0006\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t\u001a&\u0010\f\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a&\u0010\r\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a,\u0010\u000e\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0001\u001a\"\u0010\u0011\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001a\u0010\u0012\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t\u001a\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t\u001a&\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a&\u0010\u0018\u001a\u00020\u0015\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0019\u001a&\u0010\u001a\u001a\u00020\u0015\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u001b\u001a&\u0010\u001c\u001a\u00020\u0015\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"DEFAULT_TEXT_DISCONNECTED", "", "DEFAULT_TEXT_IMG2TXT", "DEFAULT_TEXT_INVALID_ACCOUNT", "DEFAULT_TEXT_LOADING_GENERAL", "DEFAULT_TEXT_TXT2IMG", "getDisconnected", "T", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "actText", "getImg2TxtLoadingTitle", "getInvalidAccount", "getLoadingGeneral", "getPublishSuccessGuide", "cardType", "default", "getPublishingGuide", "getSourceFrom", "getTxt2imgLoadingTitle", "startAiPublishPublishResultPage", "", "pageData", "Lcom/baidu/searchbox/mvp/publishresult/MvpPublishResultModel;", "startAiPublisherDynamicPublishPage", "Lcom/baidu/searchbox/mvp/prepublish/AiPublisherDynamicPublishModel;", "startAiPublisherLoadingPage", "Lcom/baidu/searchbox/mvp/loading/MvpLoadingModel;", "startAiPublisherPublishingPage", "lib-publisher-component_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpCommonPageExt.kt */
public final class MvpCommonPageExtKt {
    private static final String DEFAULT_TEXT_DISCONNECTED = "糟糕，网络似乎中断了。检查网络后试试看~";
    private static final String DEFAULT_TEXT_IMG2TXT = "正在为你的内容【添加丰富的文案】";
    private static final String DEFAULT_TEXT_INVALID_ACCOUNT = "啊哦！前方发布出现了一些错误，要不要去反馈看看？";
    private static final String DEFAULT_TEXT_LOADING_GENERAL = "欢迎回来！请让我继续帮你进行创作~";
    private static final String DEFAULT_TEXT_TXT2IMG = "正在为你的内容【添加有趣的图片】";

    public static /* synthetic */ void startAiPublisherDynamicPublishPage$default(Store store, AiPublisherDynamicPublishModel aiPublisherDynamicPublishModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aiPublisherDynamicPublishModel = null;
        }
        startAiPublisherDynamicPublishPage(store, aiPublisherDynamicPublishModel);
    }

    public static final <T extends AbsState> void startAiPublisherDynamicPublishPage(Store<T> $this$startAiPublisherDynamicPublishPage, AiPublisherDynamicPublishModel pageData) {
        Intrinsics.checkNotNullParameter($this$startAiPublisherDynamicPublishPage, "<this>");
        $this$startAiPublisherDynamicPublishPage.dispatch(new MvpCommonPageChangeAction.ChangeCommonPageAction(new MvpCommonPageModel(MvpCommonPageId.DYNAMIC_PUBLISH, pageData, false, 4, (DefaultConstructorMarker) null)));
    }

    public static /* synthetic */ void startAiPublisherLoadingPage$default(Store store, MvpLoadingModel mvpLoadingModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mvpLoadingModel = null;
        }
        startAiPublisherLoadingPage(store, mvpLoadingModel);
    }

    public static final <T extends AbsState> void startAiPublisherLoadingPage(Store<T> $this$startAiPublisherLoadingPage, MvpLoadingModel pageData) {
        Intrinsics.checkNotNullParameter($this$startAiPublisherLoadingPage, "<this>");
        $this$startAiPublisherLoadingPage.dispatch(new MvpCommonPageChangeAction.ChangeCommonPageAction(new MvpCommonPageModel(MvpCommonPageId.LOADING_VIEW, pageData, false, 4, (DefaultConstructorMarker) null)));
    }

    public static /* synthetic */ void startAiPublisherPublishingPage$default(Store store, MvpLoadingModel mvpLoadingModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mvpLoadingModel = null;
        }
        startAiPublisherPublishingPage(store, mvpLoadingModel);
    }

    public static final <T extends AbsState> void startAiPublisherPublishingPage(Store<T> $this$startAiPublisherPublishingPage, MvpLoadingModel pageData) {
        Intrinsics.checkNotNullParameter($this$startAiPublisherPublishingPage, "<this>");
        $this$startAiPublisherPublishingPage.dispatch(new MvpCommonPageChangeAction.ChangeCommonPageAction(new MvpCommonPageModel(MvpCommonPageId.PUBLISHING_VIEW, pageData, false, 4, (DefaultConstructorMarker) null)));
    }

    public static /* synthetic */ void startAiPublishPublishResultPage$default(Store store, MvpPublishResultModel mvpPublishResultModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mvpPublishResultModel = null;
        }
        startAiPublishPublishResultPage(store, mvpPublishResultModel);
    }

    public static final <T extends AbsState> void startAiPublishPublishResultPage(Store<T> $this$startAiPublishPublishResultPage, MvpPublishResultModel pageData) {
        Intrinsics.checkNotNullParameter($this$startAiPublishPublishResultPage, "<this>");
        $this$startAiPublishPublishResultPage.dispatch(new MvpCommonPageChangeAction.ChangeCommonPageAction(new MvpCommonPageModel(MvpCommonPageId.PUBLISH_RESULT, pageData, false, 4, (DefaultConstructorMarker) null)));
    }

    public static final <T extends AbsState> String getImg2TxtLoadingTitle(Store<T> $this$getImg2TxtLoadingTitle) {
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        FallbackHint fallbackHint;
        TransitionState transitionState;
        String img2txt;
        Intrinsics.checkNotNullParameter($this$getImg2TxtLoadingTitle, "<this>");
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getImg2TxtLoadingTitle.getState()).select(MvpCommonState.class);
        if (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null || (fallbackHint = configModel.getFallbackHint()) == null || (transitionState = fallbackHint.getTransitionState()) == null || (img2txt = transitionState.getImg2txt()) == null) {
            return DEFAULT_TEXT_IMG2TXT;
        }
        return img2txt;
    }

    public static final <T extends AbsState> String getTxt2imgLoadingTitle(Store<T> $this$getTxt2imgLoadingTitle) {
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        FallbackHint fallbackHint;
        TransitionState transitionState;
        String txt2img;
        Intrinsics.checkNotNullParameter($this$getTxt2imgLoadingTitle, "<this>");
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getTxt2imgLoadingTitle.getState()).select(MvpCommonState.class);
        if (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null || (fallbackHint = configModel.getFallbackHint()) == null || (transitionState = fallbackHint.getTransitionState()) == null || (txt2img = transitionState.getTxt2img()) == null) {
            return DEFAULT_TEXT_TXT2IMG;
        }
        return txt2img;
    }

    public static /* synthetic */ String getInvalidAccount$default(Store store, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return getInvalidAccount(store, str);
    }

    public static final <T extends AbsState> String getInvalidAccount(Store<T> $this$getInvalidAccount, String actText) {
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        FallbackHint fallbackHint;
        String invalidAccount;
        Intrinsics.checkNotNullParameter($this$getInvalidAccount, "<this>");
        CharSequence charSequence = actText;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return actText;
        }
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getInvalidAccount.getState()).select(MvpCommonState.class);
        if (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null || (fallbackHint = configModel.getFallbackHint()) == null || (invalidAccount = fallbackHint.getInvalidAccount()) == null) {
            return DEFAULT_TEXT_INVALID_ACCOUNT;
        }
        return invalidAccount;
    }

    public static /* synthetic */ String getLoadingGeneral$default(Store store, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return getLoadingGeneral(store, str);
    }

    public static final <T extends AbsState> String getLoadingGeneral(Store<T> $this$getLoadingGeneral, String actText) {
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        FallbackHint fallbackHint;
        TransitionState transitionState;
        String general;
        Intrinsics.checkNotNullParameter($this$getLoadingGeneral, "<this>");
        CharSequence charSequence = actText;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return actText;
        }
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getLoadingGeneral.getState()).select(MvpCommonState.class);
        if (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null || (fallbackHint = configModel.getFallbackHint()) == null || (transitionState = fallbackHint.getTransitionState()) == null || (general = transitionState.getGeneral()) == null) {
            return DEFAULT_TEXT_LOADING_GENERAL;
        }
        return general;
    }

    public static final <T extends AbsState> String getPublishSuccessGuide(Store<T> $this$getPublishSuccessGuide, String cardType, String str) {
        String albums;
        String camera;
        String ai;
        String news;
        String tags;
        String chengpian;
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        Intrinsics.checkNotNullParameter($this$getPublishSuccessGuide, "<this>");
        Intrinsics.checkNotNullParameter(str, "default");
        CharSequence charSequence = cardType;
        if (charSequence == null || charSequence.length() == 0) {
            return str;
        }
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getPublishSuccessGuide.getState()).select(MvpCommonState.class);
        SuccessGuide config = (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null) ? null : configModel.getSuccessGuide();
        switch (cardType.hashCode()) {
            case -1415163932:
                if (!(!cardType.equals(UgcConstant.UGC_ALBUMS_CARD) || config == null || (albums = config.getAlbums()) == null)) {
                    return albums;
                }
            case -1367751899:
                if (!(!cardType.equals("camera") || config == null || (camera = config.getCamera()) == null)) {
                    return camera;
                }
            case SpeedStatsStampTable.POP_INIT_END_STAMP_KEY /*3112*/:
                if (!(!cardType.equals("ai") || config == null || (ai = config.getAi()) == null)) {
                    return ai;
                }
            case 3377875:
                if (!(!cardType.equals("news") || config == null || (news = config.getNews()) == null)) {
                    return news;
                }
            case 3552281:
                if (!(!cardType.equals("tags") || config == null || (tags = config.getTags()) == null)) {
                    return tags;
                }
            case 710644159:
                if (!(!cardType.equals(UgcConstant.UGC_CHENGPIAN_CARD) || config == null || (chengpian = config.getChengpian()) == null)) {
                    return chengpian;
                }
        }
        return str;
    }

    public static final <T extends AbsState> String getPublishingGuide(Store<T> $this$getPublishingGuide, String str) {
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        FallbackHint fallbackHint;
        TransitionState transitionState;
        String publishing;
        Intrinsics.checkNotNullParameter($this$getPublishingGuide, "<this>");
        Intrinsics.checkNotNullParameter(str, "default");
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getPublishingGuide.getState()).select(MvpCommonState.class);
        if (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null || (fallbackHint = configModel.getFallbackHint()) == null || (transitionState = fallbackHint.getTransitionState()) == null || (publishing = transitionState.getPublishing()) == null) {
            return str;
        }
        return publishing;
    }

    public static /* synthetic */ String getDisconnected$default(Store store, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return getDisconnected(store, str);
    }

    public static final <T extends AbsState> String getDisconnected(Store<T> $this$getDisconnected, String actText) {
        MvpInitModel initModel;
        MvpPublishConfigModel configModel;
        FallbackHint fallbackHint;
        String disconnected;
        Intrinsics.checkNotNullParameter($this$getDisconnected, "<this>");
        CharSequence charSequence = actText;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return actText;
        }
        MvpCommonState mvpCommonState = (MvpCommonState) ((AbsState) $this$getDisconnected.getState()).select(MvpCommonState.class);
        if (mvpCommonState == null || (initModel = mvpCommonState.getInitModel()) == null || (configModel = initModel.getConfigModel()) == null || (fallbackHint = configModel.getFallbackHint()) == null || (disconnected = fallbackHint.getDisconnected()) == null) {
            return DEFAULT_TEXT_DISCONNECTED;
        }
        return disconnected;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        r0 = (r0 = r0.getInitModel()).getUgcSchemeModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends com.baidu.searchbox.feed.detail.frame.AbsState> java.lang.String getSourceFrom(com.baidu.searchbox.feed.detail.frame.Store<T> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.baidu.searchbox.feed.detail.frame.State r0 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            java.lang.Class<com.baidu.searchbox.mvp.common.MvpCommonState> r1 = com.baidu.searchbox.mvp.common.MvpCommonState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.mvp.common.MvpCommonState r0 = (com.baidu.searchbox.mvp.common.MvpCommonState) r0
            if (r0 == 0) goto L_0x0024
            com.baidu.searchbox.mvp.common.MvpInitModel r0 = r0.getInitModel()
            if (r0 == 0) goto L_0x0024
            com.baidu.searchbox.ugc.webjs.UgcSchemeModel r0 = r0.getUgcSchemeModel()
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = r0.sourceFrom
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = ""
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mvp.common.MvpCommonPageExtKt.getSourceFrom(com.baidu.searchbox.feed.detail.frame.Store):java.lang.String");
    }
}
