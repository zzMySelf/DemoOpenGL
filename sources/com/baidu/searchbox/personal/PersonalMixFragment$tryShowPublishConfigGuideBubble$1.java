package com.baidu.searchbox.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.personal.publish.PublishHelper;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "isShow", "", "title", "", "icon", "url", "id", "", "invoke", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalMixFragment.kt */
final class PersonalMixFragment$tryShowPublishConfigGuideBubble$1 extends Lambda implements Function5<Boolean, String, String, String, Integer, Unit> {
    final /* synthetic */ PersonalMixFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalMixFragment$tryShowPublishConfigGuideBubble$1(PersonalMixFragment personalMixFragment) {
        super(5);
        this.this$0 = personalMixFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        invoke(((Boolean) p1).booleanValue(), (String) p2, (String) p3, (String) p4, (Integer) p5);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isShow, String title, String icon, String url, Integer id) {
        Context mContext;
        FrameLayout frameLayout;
        ImageView imageView;
        SimpleDraweeView simpleDraweeView;
        boolean z = false;
        this.this$0.sFirstShowBubble = false;
        if (isShow && !TextUtils.isEmpty(title) && !TextUtils.isEmpty(url) && id != null && !this.this$0.isDetached() && (mContext = this.this$0.getContext()) != null) {
            this.this$0.publishBubbleTitle = title;
            View access$getMRootView$p = this.this$0.mRootView;
            View view2 = null;
            TextView textView = access$getMRootView$p != null ? (TextView) access$getMRootView$p.findViewById(R.id.publish_config_bubble_text) : null;
            if (textView != null) {
                textView.setText(title);
            }
            View access$getMRootView$p2 = this.this$0.mRootView;
            LinearLayout linearLayout = access$getMRootView$p2 != null ? (LinearLayout) access$getMRootView$p2.findViewById(R.id.publish_config_bubble_text_layout) : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            CharSequence charSequence = icon;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (!z) {
                View access$getMRootView$p3 = this.this$0.mRootView;
                if (!(access$getMRootView$p3 == null || (simpleDraweeView = (SimpleDraweeView) access$getMRootView$p3.findViewById(R.id.publish_config_image)) == null)) {
                    simpleDraweeView.setImageURI(icon);
                }
                View access$getMRootView$p4 = this.this$0.mRootView;
                SimpleDraweeView simpleDraweeView2 = access$getMRootView$p4 != null ? (SimpleDraweeView) access$getMRootView$p4.findViewById(R.id.publish_config_image) : null;
                if (simpleDraweeView2 != null) {
                    simpleDraweeView2.setVisibility(4);
                }
            }
            View access$getMRootView$p5 = this.this$0.mRootView;
            TextView textView2 = access$getMRootView$p5 != null ? (TextView) access$getMRootView$p5.findViewById(R.id.publish_config_bubble_text) : null;
            if (textView2 != null) {
                textView2.setVisibility(4);
            }
            View access$getMRootView$p6 = this.this$0.mRootView;
            FrameLayout frameLayout2 = access$getMRootView$p6 != null ? (FrameLayout) access$getMRootView$p6.findViewById(R.id.publish_config_bubble_layout) : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(4);
            }
            View access$getMRootView$p7 = this.this$0.mRootView;
            if (access$getMRootView$p7 != null) {
                view2 = access$getMRootView$p7.findViewById(R.id.publish_config_bubble);
            }
            if (view2 != null) {
                view2.setVisibility(4);
            }
            View access$getMRootView$p8 = this.this$0.mRootView;
            if (!(access$getMRootView$p8 == null || (imageView = (ImageView) access$getMRootView$p8.findViewById(R.id.publish_icon)) == null)) {
                imageView.setOnClickListener(new PersonalMixFragment$tryShowPublishConfigGuideBubble$1$$ExternalSyntheticLambda0(this.this$0));
            }
            View access$getMRootView$p9 = this.this$0.mRootView;
            if (access$getMRootView$p9 != null && (frameLayout = (FrameLayout) access$getMRootView$p9.findViewById(R.id.publish_config_bubble_layout)) != null) {
                frameLayout.postDelayed(new PersonalMixFragment$tryShowPublishConfigGuideBubble$1$$ExternalSyntheticLambda1(this.this$0, id, mContext, url), 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2003invoke$lambda0(PersonalMixFragment this$02, View it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.getPublishConfigBubbleAnimationManager().stopAnimation();
        this$02.resetPublishIcon();
        if (!this$02.isDetached() && this$02.getContext() != null) {
            PersonCenterUBCStatistic.statisticUBCWithoutSource("fabu", "click", this$02.ubcExtBubbleJSONObject(), "wode", "192", PersonalConstants.PAGE_ZHUYE);
            PublishHelper.INSTANCE.onPublishIconClick(this$02.getContext());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m2004invoke$lambda1(PersonalMixFragment this$02, Integer $id, Context $mContext, String $url) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($mContext, "$mContext");
        this$02.publishConfigBubbleInAnimation(new PersonalMixFragment$tryShowPublishConfigGuideBubble$1$2$1(this$02, $id, $mContext, $url));
    }
}
