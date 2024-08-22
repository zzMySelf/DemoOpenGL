package com.baidu.searchbox.video.feedflow.detail.praise;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/praise/PraiseViewStatusChangeAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "status", "", "model", "Lcom/baidu/searchbox/video/feedflow/detail/praise/PraiseModel;", "isActive", "", "(ILcom/baidu/searchbox/video/feedflow/detail/praise/PraiseModel;Z)V", "()Z", "setActive", "(Z)V", "getModel", "()Lcom/baidu/searchbox/video/feedflow/detail/praise/PraiseModel;", "setModel", "(Lcom/baidu/searchbox/video/feedflow/detail/praise/PraiseModel;)V", "getStatus", "()I", "setStatus", "(I)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: PraiseActionManifest.kt */
public final class PraiseViewStatusChangeAction implements Action {
    private boolean isActive;
    private PraiseModel model;
    private int status;

    public static /* synthetic */ PraiseViewStatusChangeAction copy$default(PraiseViewStatusChangeAction praiseViewStatusChangeAction, int i2, PraiseModel praiseModel, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = praiseViewStatusChangeAction.status;
        }
        if ((i3 & 2) != 0) {
            praiseModel = praiseViewStatusChangeAction.model;
        }
        if ((i3 & 4) != 0) {
            z = praiseViewStatusChangeAction.isActive;
        }
        return praiseViewStatusChangeAction.copy(i2, praiseModel, z);
    }

    public final int component1() {
        return this.status;
    }

    public final PraiseModel component2() {
        return this.model;
    }

    public final boolean component3() {
        return this.isActive;
    }

    public final PraiseViewStatusChangeAction copy(@PraiseViewStatus int i2, PraiseModel praiseModel, boolean z) {
        return new PraiseViewStatusChangeAction(i2, praiseModel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PraiseViewStatusChangeAction)) {
            return false;
        }
        PraiseViewStatusChangeAction praiseViewStatusChangeAction = (PraiseViewStatusChangeAction) obj;
        return this.status == praiseViewStatusChangeAction.status && Intrinsics.areEqual((Object) this.model, (Object) praiseViewStatusChangeAction.model) && this.isActive == praiseViewStatusChangeAction.isActive;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.status) * 31;
        PraiseModel praiseModel = this.model;
        int hashCode2 = (hashCode + (praiseModel == null ? 0 : praiseModel.hashCode())) * 31;
        boolean z = this.isActive;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public String toString() {
        return "PraiseViewStatusChangeAction(status=" + this.status + ", model=" + this.model + ", isActive=" + this.isActive + ')';
    }

    public PraiseViewStatusChangeAction(@PraiseViewStatus int status2, PraiseModel model2, boolean isActive2) {
        this.status = status2;
        this.model = model2;
        this.isActive = isActive2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PraiseViewStatusChangeAction(int i2, PraiseModel praiseModel, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : praiseModel, z);
    }

    public final PraiseModel getModel() {
        return this.model;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setModel(PraiseModel praiseModel) {
        this.model = praiseModel;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }
}
