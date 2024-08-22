package com.baidu.chatsearch.aisearch.resultpage.utils;

import com.baidu.chatsearch.aisearch.javascriptapi.ai.SSChatSearchEventKt;
import com.baidu.chatsearch.aisearch.resultpage.interfaces.IMessageEvent;
import com.baidu.chatsearch.model.message.InputSource;
import com.baidu.chatsearch.model.message.InputSubType;
import com.baidu.chatsearch.model.message.InputType;
import com.baidu.chatsearch.taskdispatcher.TaskDispatcherExtensionKt;
import com.baidu.searchbox.kmm.personalpage.shop.api.PersonalPageCoverShopApiKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/chatsearch/aisearch/resultpage/utils/SSSearchGraphManager;", "", "()V", "TAG", "", "messageEvent", "Lcom/baidu/chatsearch/aisearch/resultpage/interfaces/IMessageEvent;", "launchSearchGraph", "", "hasRect", "", "imageId", "imageUrl", "imageWidth", "", "imageHeight", "imageExtInfo", "sa", "inputType", "Lcom/baidu/chatsearch/model/message/InputType;", "from", "Lcom/baidu/chatsearch/model/message/InputSubType;", "source", "Lcom/baidu/chatsearch/model/message/InputSource;", "setMessageEventListener", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSSearchGraphManager.kt */
public final class SSSearchGraphManager {
    public static final SSSearchGraphManager INSTANCE = new SSSearchGraphManager();
    private static final String TAG = "SSSearchGraphManager";
    /* access modifiers changed from: private */
    public static IMessageEvent messageEvent;

    private SSSearchGraphManager() {
    }

    public final void setMessageEventListener(IMessageEvent messageEvent2) {
        messageEvent = messageEvent2;
    }

    public static /* synthetic */ void launchSearchGraph$default(SSSearchGraphManager sSSearchGraphManager, boolean z, String str, String str2, int i2, int i3, String str3, String str4, InputType inputType, InputSubType inputSubType, InputSource inputSource, int i4, Object obj) {
        InputType inputType2;
        InputSubType inputSubType2;
        InputSource inputSource2;
        int i5 = i4;
        if ((i5 & 128) != 0) {
            inputType2 = InputType.eInputTypeText;
        } else {
            inputType2 = inputType;
        }
        if ((i5 & 256) != 0) {
            inputSubType2 = InputSubType.eInputSubTypeInputEnd;
        } else {
            inputSubType2 = inputSubType;
        }
        if ((i5 & 512) != 0) {
            inputSource2 = InputSource.eInputSourceBrowserPage;
        } else {
            inputSource2 = inputSource;
        }
        sSSearchGraphManager.launchSearchGraph(z, str, str2, i2, i3, str3, str4, inputType2, inputSubType2, inputSource2);
    }

    public final void launchSearchGraph(boolean hasRect, String imageId, String imageUrl, int imageWidth, int imageHeight, String imageExtInfo, String sa, InputType inputType, InputSubType from, InputSource source) {
        Intrinsics.checkNotNullParameter(imageId, PersonalPageCoverShopApiKt.PERSONAL_PAGE_IMAGE_ID);
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageExtInfo, SSChatSearchEventKt.IMAGE_EXT_INFO_KEY);
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(source, "source");
        TaskDispatcherExtensionKt.runUiThread(new SSSearchGraphManager$launchSearchGraph$1(imageUrl, imageId, imageExtInfo, imageWidth, imageHeight, sa, hasRect, inputType, from, source));
    }
}
