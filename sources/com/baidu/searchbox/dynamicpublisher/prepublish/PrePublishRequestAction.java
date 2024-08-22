package com.baidu.searchbox.dynamicpublisher.prepublish;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.ugc.model.PrePublishResponseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/prepublish/PrePublishRequestAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "RequestSuccess", "Lcom/baidu/searchbox/dynamicpublisher/prepublish/PrePublishRequestAction$RequestSuccess;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrePublishRequestAction.kt */
public abstract class PrePublishRequestAction implements Action {
    public /* synthetic */ PrePublishRequestAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PrePublishRequestAction() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/prepublish/PrePublishRequestAction$RequestSuccess;", "Lcom/baidu/searchbox/dynamicpublisher/prepublish/PrePublishRequestAction;", "model", "Lcom/baidu/searchbox/ugc/model/PrePublishResponseModel;", "(Lcom/baidu/searchbox/ugc/model/PrePublishResponseModel;)V", "getModel", "()Lcom/baidu/searchbox/ugc/model/PrePublishResponseModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrePublishRequestAction.kt */
    public static final class RequestSuccess extends PrePublishRequestAction {
        private final PrePublishResponseModel model;

        public static /* synthetic */ RequestSuccess copy$default(RequestSuccess requestSuccess, PrePublishResponseModel prePublishResponseModel, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                prePublishResponseModel = requestSuccess.model;
            }
            return requestSuccess.copy(prePublishResponseModel);
        }

        public final PrePublishResponseModel component1() {
            return this.model;
        }

        public final RequestSuccess copy(PrePublishResponseModel prePublishResponseModel) {
            Intrinsics.checkNotNullParameter(prePublishResponseModel, "model");
            return new RequestSuccess(prePublishResponseModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestSuccess) && Intrinsics.areEqual((Object) this.model, (Object) ((RequestSuccess) obj).model);
        }

        public int hashCode() {
            return this.model.hashCode();
        }

        public String toString() {
            return "RequestSuccess(model=" + this.model + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RequestSuccess(PrePublishResponseModel model2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(model2, "model");
            this.model = model2;
        }

        public final PrePublishResponseModel getModel() {
            return this.model;
        }
    }
}
