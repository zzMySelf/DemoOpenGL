package com.baidu.searchbox.usergrowth.business.guide;

import com.baidu.searchbox.kmm.rightsgranting.entities.RightsModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserGrowthRightsGuideManager.kt */
final class UserGrowthRightsGuideManager$tryShowHomeUGRightsGuideSync$3 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.ObjectRef<RightsModel> $validRights;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserGrowthRightsGuideManager$tryShowHomeUGRightsGuideSync$3(Ref.ObjectRef<RightsModel> objectRef) {
        super(0);
        this.$validRights = objectRef;
    }

    public final String invoke() {
        return "tryShowHomeUGRightsGuideSync --> validRights is =" + this.$validRights.element;
    }
}
