package com.baidu.searchbox.preview;

import com.baidu.searchbox.dynamicpublisher.R;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/spswitch/view/SPSwitchPanelLinearLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImagePreviewLayoutManager.kt */
final class ImagePreviewLayoutManager$bottomContainer$2 extends Lambda implements Function0<SPSwitchPanelLinearLayout> {
    final /* synthetic */ ImagePreviewLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagePreviewLayoutManager$bottomContainer$2(ImagePreviewLayoutManager imagePreviewLayoutManager) {
        super(0);
        this.this$0 = imagePreviewLayoutManager;
    }

    public final SPSwitchPanelLinearLayout invoke() {
        return (SPSwitchPanelLinearLayout) this.this$0.getContainer().findViewById(R.id.image_preview_bottom_bar);
    }
}
