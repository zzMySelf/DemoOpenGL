package com.baidu.searchbox.account.userinfo.feed.template;

import com.baidu.android.ext.widget.BdListPopupWindow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/userinfo/feed/template/VideoItemTemplate$showMenu$deleteItem$1$1", "Lcom/baidu/android/ext/widget/BdListPopupWindow$ItemClickListener;", "onClick", "", "position", "", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoItemTemplate.kt */
public final class VideoItemTemplate$showMenu$deleteItem$1$1 implements BdListPopupWindow.ItemClickListener {
    final /* synthetic */ VideoItemTemplate this$0;

    VideoItemTemplate$showMenu$deleteItem$1$1(VideoItemTemplate $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(int position) {
        Function0<Unit> onDeleteMenuClick = this.this$0.getOnDeleteMenuClick();
        if (onDeleteMenuClick != null) {
            onDeleteMenuClick.invoke();
        }
    }
}
