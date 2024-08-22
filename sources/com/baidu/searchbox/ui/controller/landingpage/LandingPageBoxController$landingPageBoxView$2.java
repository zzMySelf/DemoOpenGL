package com.baidu.searchbox.ui.controller.landingpage;

import com.baidu.searchbox.home.search.boxinterface.landingpage.ILandingPageBoxInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ui/controller/landingpage/LandingPageSearchBoxView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandingPageBoxController.kt */
final class LandingPageBoxController$landingPageBoxView$2 extends Lambda implements Function0<LandingPageSearchBoxView> {
    final /* synthetic */ LandingPageBoxController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LandingPageBoxController$landingPageBoxView$2(LandingPageBoxController landingPageBoxController) {
        super(0);
        this.this$0 = landingPageBoxController;
    }

    public final LandingPageSearchBoxView invoke() {
        ILandingPageBoxInterface searchbox2 = this.this$0.getSearchbox();
        if (searchbox2 instanceof LandingPageSearchBoxView) {
            return (LandingPageSearchBoxView) searchbox2;
        }
        return null;
    }
}
