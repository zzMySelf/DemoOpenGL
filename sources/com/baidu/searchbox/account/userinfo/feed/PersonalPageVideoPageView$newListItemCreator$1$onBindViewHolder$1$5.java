package com.baidu.searchbox.account.userinfo.feed;

import com.baidu.searchbox.account.userinfo.activity.PersonalPageNaFragment;
import com.baidu.searchbox.account.userinfo.data.PPVideoEntity;
import com.baidu.searchbox.account.userinfo.feed.template.VideoItemTemplate;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageNaUbcUtils;
import com.baidu.searchbox.push.NotifyInAppStatistic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageVideoPageView.kt */
final class PersonalPageVideoPageView$newListItemCreator$1$onBindViewHolder$1$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PPVideoEntity $data;
    final /* synthetic */ VideoItemTemplate $it;
    final /* synthetic */ PersonalPageVideoPageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageVideoPageView$newListItemCreator$1$onBindViewHolder$1$5(PersonalPageVideoPageView personalPageVideoPageView, PPVideoEntity pPVideoEntity, VideoItemTemplate videoItemTemplate) {
        super(0);
        this.this$0 = personalPageVideoPageView;
        this.$data = pPVideoEntity;
        this.$it = videoItemTemplate;
    }

    public final void invoke() {
        PersonalPageNaFragment access$getPersonalPageFragment$p = this.this$0.personalPageFragment;
        boolean z = false;
        if (access$getPersonalPageFragment$p != null ? Intrinsics.areEqual((Object) access$getPersonalPageFragment$p.isJustWatchedAttached(), (Object) true) : false) {
            this.this$0.personalPageFragment.dismissJustWatchTip(true);
            this.this$0.personalPageFragment.setHasClickedJustWatchTip(true);
        }
        PersonalPageNaFragment access$getPersonalPageFragment$p2 = this.this$0.personalPageFragment;
        if (access$getPersonalPageFragment$p2 != null) {
            String itemType = this.$data.getItemType();
            JSONObject jSONObject = new JSONObject();
            PPVideoEntity pPVideoEntity = this.$data;
            PersonalPageVideoPageView personalPageVideoPageView = this.this$0;
            VideoItemTemplate videoItemTemplate = this.$it;
            JSONObject $this$invoke_u24lambda_u2d0 = jSONObject;
            $this$invoke_u24lambda_u2d0.put("nid", pPVideoEntity.getNid());
            $this$invoke_u24lambda_u2d0.put("position", "shipin_tab");
            if (personalPageVideoPageView.justWatchId.length() > 0) {
                z = true;
            }
            if (z) {
                $this$invoke_u24lambda_u2d0.put(PersonalPageNaUbcUtils.EXT_LASTVIEW_NID, personalPageVideoPageView.justWatchId);
            }
            if (videoItemTemplate.isUnwatchedViewShowed()) {
                $this$invoke_u24lambda_u2d0.put(PersonalPageNaUbcUtils.EXT_CONTENT_STATUS, NotifyInAppStatistic.PAGE_UNREAD_ASYNC_REMIND);
            }
            $this$invoke_u24lambda_u2d0.put("ext", personalPageVideoPageView.buildRdcInnerExt(pPVideoEntity, true));
            Unit unit = Unit.INSTANCE;
            access$getPersonalPageFragment$p2.doUbc(itemType, "content_click", jSONObject);
        }
    }
}
