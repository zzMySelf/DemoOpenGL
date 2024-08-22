package com.baidu.searchbox.feed.model;

import androidx.recyclerview.widget.SimpleItemAnimator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedInsertPolicy;", "", "()V", "anchorPosition", "", "getAnchorPosition", "()I", "setAnchorPosition", "(I)V", "delayInsert", "", "getDelayInsert", "()J", "setDelayInsert", "(J)V", "insertAnimator", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "getInsertAnimator", "()Landroidx/recyclerview/widget/SimpleItemAnimator;", "setInsertAnimator", "(Landroidx/recyclerview/widget/SimpleItemAnimator;)V", "insertPosition", "getInsertPosition", "setInsertPosition", "needAnchorAnim", "", "getNeedAnchorAnim", "()Z", "setNeedAnchorAnim", "(Z)V", "needInsertAnim", "getNeedInsertAnim", "setNeedInsertAnim", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedInsertPolicy.kt */
public final class FeedInsertPolicy {
    private int anchorPosition = -1;
    private long delayInsert;
    private SimpleItemAnimator insertAnimator;
    private int insertPosition = -1;
    private boolean needAnchorAnim;
    private boolean needInsertAnim;

    public final int getInsertPosition() {
        return this.insertPosition;
    }

    public final void setInsertPosition(int i2) {
        this.insertPosition = i2;
    }

    public final int getAnchorPosition() {
        return this.anchorPosition;
    }

    public final void setAnchorPosition(int i2) {
        this.anchorPosition = i2;
    }

    public final long getDelayInsert() {
        return this.delayInsert;
    }

    public final void setDelayInsert(long j2) {
        this.delayInsert = j2;
    }

    public final boolean getNeedInsertAnim() {
        return this.needInsertAnim;
    }

    public final void setNeedInsertAnim(boolean z) {
        this.needInsertAnim = z;
    }

    public final boolean getNeedAnchorAnim() {
        return this.needAnchorAnim;
    }

    public final void setNeedAnchorAnim(boolean z) {
        this.needAnchorAnim = z;
    }

    public final SimpleItemAnimator getInsertAnimator() {
        return this.insertAnimator;
    }

    public final void setInsertAnimator(SimpleItemAnimator simpleItemAnimator) {
        this.insertAnimator = simpleItemAnimator;
    }
}
