package com.baidu.searchbox.dynamicpublisher.locrecommend;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.ugc.activity.RecommendLocModel;
import com.baidu.ugc.position.model.PoiModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "NotifyRecommendResult", "TriggerRecommend", "Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction$TriggerRecommend;", "Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction$NotifyRecommendResult;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocRecommendAction.kt */
public abstract class LocRecommendAction implements Action {
    public /* synthetic */ LocRecommendAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LocRecommendAction() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction$TriggerRecommend;", "Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction;", "mode", "", "locModels", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/activity/RecommendLocModel;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getLocModels", "()Ljava/util/ArrayList;", "getMode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LocRecommendAction.kt */
    public static final class TriggerRecommend extends LocRecommendAction {
        private final ArrayList<RecommendLocModel> locModels;
        private final int mode;

        public static /* synthetic */ TriggerRecommend copy$default(TriggerRecommend triggerRecommend, int i2, ArrayList<RecommendLocModel> arrayList, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = triggerRecommend.mode;
            }
            if ((i3 & 2) != 0) {
                arrayList = triggerRecommend.locModels;
            }
            return triggerRecommend.copy(i2, arrayList);
        }

        public final int component1() {
            return this.mode;
        }

        public final ArrayList<RecommendLocModel> component2() {
            return this.locModels;
        }

        public final TriggerRecommend copy(@TriggerMode int i2, ArrayList<RecommendLocModel> arrayList) {
            return new TriggerRecommend(i2, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TriggerRecommend)) {
                return false;
            }
            TriggerRecommend triggerRecommend = (TriggerRecommend) obj;
            return this.mode == triggerRecommend.mode && Intrinsics.areEqual((Object) this.locModels, (Object) triggerRecommend.locModels);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.mode) * 31;
            ArrayList<RecommendLocModel> arrayList = this.locModels;
            return hashCode + (arrayList == null ? 0 : arrayList.hashCode());
        }

        public String toString() {
            return "TriggerRecommend(mode=" + this.mode + ", locModels=" + this.locModels + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TriggerRecommend(int i2, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i2, (i3 & 2) != 0 ? null : arrayList);
        }

        public final ArrayList<RecommendLocModel> getLocModels() {
            return this.locModels;
        }

        public final int getMode() {
            return this.mode;
        }

        public TriggerRecommend(@TriggerMode int mode2, ArrayList<RecommendLocModel> locModels2) {
            super((DefaultConstructorMarker) null);
            this.mode = mode2;
            this.locModels = locModels2;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\n\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction$NotifyRecommendResult;", "Lcom/baidu/searchbox/dynamicpublisher/locrecommend/LocRecommendAction;", "recommendLocList", "Ljava/util/ArrayList;", "Lcom/baidu/ugc/position/model/PoiModel;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getRecommendLocList", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LocRecommendAction.kt */
    public static final class NotifyRecommendResult extends LocRecommendAction {
        private final ArrayList<PoiModel> recommendLocList;

        public NotifyRecommendResult() {
            this((ArrayList) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ NotifyRecommendResult copy$default(NotifyRecommendResult notifyRecommendResult, ArrayList<PoiModel> arrayList, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                arrayList = notifyRecommendResult.recommendLocList;
            }
            return notifyRecommendResult.copy(arrayList);
        }

        public final ArrayList<PoiModel> component1() {
            return this.recommendLocList;
        }

        public final NotifyRecommendResult copy(ArrayList<PoiModel> arrayList) {
            return new NotifyRecommendResult(arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotifyRecommendResult) && Intrinsics.areEqual((Object) this.recommendLocList, (Object) ((NotifyRecommendResult) obj).recommendLocList);
        }

        public int hashCode() {
            ArrayList<PoiModel> arrayList = this.recommendLocList;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.hashCode();
        }

        public String toString() {
            return "NotifyRecommendResult(recommendLocList=" + this.recommendLocList + ')';
        }

        public NotifyRecommendResult(ArrayList<PoiModel> recommendLocList2) {
            super((DefaultConstructorMarker) null);
            this.recommendLocList = recommendLocList2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NotifyRecommendResult(ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : arrayList);
        }

        public final ArrayList<PoiModel> getRecommendLocList() {
            return this.recommendLocList;
        }
    }
}
