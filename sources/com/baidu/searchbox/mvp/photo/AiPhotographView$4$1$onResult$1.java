package com.baidu.searchbox.mvp.photo;

import com.baidu.searchbox.mvp.common.MvpUbcUtil;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.provider.listener.OnAlbumSelectListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/mvp/photo/AiPhotographView$4$1$onResult$1", "Lcom/baidu/searchbox/ugc/provider/listener/OnAlbumSelectListener;", "onCanceled", "", "onSelectPhoto", "paths", "", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPhotographView.kt */
public final class AiPhotographView$4$1$onResult$1 implements OnAlbumSelectListener {
    final /* synthetic */ AiPhotographView this$0;

    AiPhotographView$4$1$onResult$1(AiPhotographView $receiver) {
        this.this$0 = $receiver;
    }

    public void onSelectPhoto(List<? extends ImageStruct> paths) {
        Function2<String, List<? extends ImageStruct>, Unit> onClickImageUploadListener;
        Intrinsics.checkNotNull(paths);
        if ((!paths.isEmpty()) && (onClickImageUploadListener = this.this$0.getOnClickImageUploadListener()) != null) {
            onClickImageUploadListener.invoke(this.this$0.getMMark(), paths);
        }
        this.this$0.onUbcOpenAlbum(paths.isEmpty() ? 0 : paths.size(), MvpUbcUtil.ALBUMS_CLK_STATUS_PIC_ALBUM_CHOSEN);
    }

    public void onCanceled() {
        this.this$0.onUbcOpenAlbum(0, MvpUbcUtil.ALBUMS_CLK_STATUS_PIC_ALBUM_CANCEL);
    }
}
