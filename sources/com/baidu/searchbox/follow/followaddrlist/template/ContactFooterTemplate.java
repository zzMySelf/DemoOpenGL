package com.baidu.searchbox.follow.followaddrlist.template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.follow.R;
import com.baidu.searchbox.follow.followaddrlist.template.ITemplate;
import com.baidu.searchbox.follow.followaddrlist.view.LoadingFooterView;
import com.baidu.searchbox.follow.model.FollowContactModel;
import com.baidu.searchbox.follow.runtime.FollowRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/follow/followaddrlist/template/ContactFooterTemplate;", "Lcom/baidu/searchbox/follow/followaddrlist/template/ITemplate;", "Lcom/baidu/searchbox/follow/model/FollowContactModel$ContactItem;", "()V", "footerView", "Lcom/baidu/searchbox/follow/followaddrlist/view/LoadingFooterView;", "listener", "Lcom/baidu/searchbox/follow/followaddrlist/template/ITemplate$OnChildListener;", "bindView", "", "model", "createView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "setOnChildClickListener", "lib-follow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactFooterTemplate.kt */
public final class ContactFooterTemplate implements ITemplate<FollowContactModel.ContactItem> {
    private LoadingFooterView footerView;
    private ITemplate.OnChildListener listener;

    public View createView(ViewGroup parent) {
        View view2 = LayoutInflater.from(FollowRuntime.getAppContext()).inflate(R.layout.follow_recyclerview_foot_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "from(FollowRuntime.getAp…ot_layout, parent, false)");
        this.footerView = (LoadingFooterView) view2.findViewById(R.id.foot);
        return view2;
    }

    public void bindView(FollowContactModel.ContactItem model) {
        if (model != null && model.getConfig() != null) {
            FollowContactModel.ContactItem.Config config = model.getConfig();
            boolean z = true;
            if (config != null && config.getFootStatus() == 1) {
                LoadingFooterView loadingFooterView = this.footerView;
                if (loadingFooterView != null) {
                    loadingFooterView.setState(LoadingFooterView.State.Loading, FollowRuntime.getAppContext().getResources().getString(R.string.follow_footer_loading));
                    return;
                }
                return;
            }
            if (config == null || config.getFootStatus() != 2) {
                z = false;
            }
            if (z) {
                LoadingFooterView loadingFooterView2 = this.footerView;
                if (loadingFooterView2 != null) {
                    loadingFooterView2.setState(LoadingFooterView.State.DataLoadError, FollowRuntime.getAppContext().getResources().getString(R.string.follow_footer_network_error_refresh_clickable));
                }
                LoadingFooterView loadingFooterView3 = this.footerView;
                if (loadingFooterView3 != null) {
                    loadingFooterView3.setClickListener(new ContactFooterTemplate$$ExternalSyntheticLambda0(this));
                    return;
                }
                return;
            }
            LoadingFooterView loadingFooterView4 = this.footerView;
            if (loadingFooterView4 != null) {
                loadingFooterView4.setState(LoadingFooterView.State.BOTTOM, FollowRuntime.getAppContext().getResources().getString(R.string.follow_footer_no_more_text));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m18904bindView$lambda0(ContactFooterTemplate this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITemplate.OnChildListener onChildListener = this$0.listener;
        if (onChildListener != null) {
            onChildListener.onFooterClick(this$0.footerView);
        }
    }

    public void setOnChildClickListener(ITemplate.OnChildListener listener2) {
        this.listener = listener2;
    }
}
