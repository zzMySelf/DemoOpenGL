package com.baidu.searchbox.ugc.dialog;

import com.baidu.searchbox.ugc.model.ImageGroup;
import com.baidu.searchbox.ugc.utils.OnTaskResultListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/ugc/dialog/SimpleLocalAlbumDialog$executeImageLoadTask$1", "Lcom/baidu/searchbox/ugc/utils/OnTaskResultListener;", "onPageResult", "", "resultType", "", "page", "result", "", "Lcom/baidu/searchbox/ugc/model/ImageGroup;", "onResult", "error", "", "", "lib-ugc-album_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleLocalAlbumDialog.kt */
public final class SimpleLocalAlbumDialog$executeImageLoadTask$1 implements OnTaskResultListener {
    final /* synthetic */ SimpleLocalAlbumDialog this$0;

    SimpleLocalAlbumDialog$executeImageLoadTask$1(SimpleLocalAlbumDialog $receiver) {
        this.this$0 = $receiver;
    }

    public void onResult(int resultType, String error, Object result) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.this$0.isShowing() && this.this$0.getActivity() != null && !this.this$0.getActivity().isFinishing()) {
            this.this$0.initAlbumAdapter();
        }
    }

    public void onPageResult(int resultType, int page, List<ImageGroup> result) {
        super.onPageResult(resultType, page, result);
        if (this.this$0.isShowing() && this.this$0.getActivity() != null && !this.this$0.getActivity().isFinishing()) {
            if (result != null) {
                this.this$0.groupImages = result;
            }
            if (page == 0) {
                this.this$0.notifyUi();
            } else {
                this.this$0.updateAlbumAdapter(result);
            }
        }
    }
}
