package com.baidu.searchbox.feed.biserialdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.baidu.elinkagescroll.ChildLinkageEvent;
import com.baidu.elinkagescroll.ELinkageScrollHandler;
import com.baidu.elinkagescroll.IELinkageScroll;
import com.baidu.linkagescroll.ILinkageScroll;
import com.baidu.linkagescroll.LinkageChildrenEvent;
import com.baidu.linkagescroll.LinkageScrollHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0015J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/view/LScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/baidu/linkagescroll/ILinkageScroll;", "Lcom/baidu/elinkagescroll/IELinkageScroll;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childrenEvent", "Lcom/baidu/elinkagescroll/ChildLinkageEvent;", "linkageChildrenEvent", "Lcom/baidu/linkagescroll/LinkageChildrenEvent;", "onScrollChanged", "", "l", "t", "oldl", "oldt", "provideELinkageScrollHandler", "Lcom/baidu/elinkagescroll/ELinkageScrollHandler;", "provideScrollHandler", "Lcom/baidu/linkagescroll/LinkageScrollHandler;", "setChildELinkageEvent", "event", "setOnLinkageChildrenEvent", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LScrollView.kt */
public class LScrollView extends NestedScrollView implements ILinkageScroll, IELinkageScroll {
    private ChildLinkageEvent childrenEvent;
    private LinkageChildrenEvent linkageChildrenEvent;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LScrollView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LScrollView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        setVerticalScrollBarEnabled(false);
        if (!canScrollVertically(-1)) {
            ChildLinkageEvent childLinkageEvent = this.childrenEvent;
            if (childLinkageEvent != null) {
                childLinkageEvent.onContentScrollToTop(this);
            }
            LinkageChildrenEvent linkageChildrenEvent2 = this.linkageChildrenEvent;
            if (linkageChildrenEvent2 != null) {
                linkageChildrenEvent2.onContentScrollToTop();
            }
        }
        if (!canScrollVertically(1)) {
            ChildLinkageEvent childLinkageEvent2 = this.childrenEvent;
            if (childLinkageEvent2 != null) {
                childLinkageEvent2.onContentScrollToBottom(this);
            }
            LinkageChildrenEvent linkageChildrenEvent3 = this.linkageChildrenEvent;
            if (linkageChildrenEvent3 != null) {
                linkageChildrenEvent3.onContentScrollToBottom();
            }
        }
        ChildLinkageEvent childLinkageEvent3 = this.childrenEvent;
        if (childLinkageEvent3 != null) {
            childLinkageEvent3.onContentScroll(this);
        }
        LinkageChildrenEvent linkageChildrenEvent4 = this.linkageChildrenEvent;
        if (linkageChildrenEvent4 != null) {
            linkageChildrenEvent4.onContentScroll(computeVerticalScrollExtent(), computeVerticalScrollOffset(), computeVerticalScrollRange());
        }
    }

    public void setChildELinkageEvent(ChildLinkageEvent event) {
        this.childrenEvent = event;
        if (event != null) {
            event.onContentScroll(this);
        }
    }

    public void setOnLinkageChildrenEvent(LinkageChildrenEvent event) {
        this.linkageChildrenEvent = event;
    }

    public ELinkageScrollHandler provideELinkageScrollHandler() {
        return new LScrollView$provideELinkageScrollHandler$1(this);
    }

    public LinkageScrollHandler provideScrollHandler() {
        return new LScrollView$provideScrollHandler$1(this);
    }
}
