package com.baidu.searchbox.video.feedflow.detail.summary.enriched;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryModel;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0011J\u001e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001dJ\u001c\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dJ\u001c\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u000e\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"J \u0010#\u001a\u00020\u00112\n\u0010$\u001a\u00060\u0007j\u0002`%2\f\b\u0002\u0010&\u001a\u00060\u0007j\u0002`'J\u0006\u0010(\u001a\u00020\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010*H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/summary/enriched/SummaryEnrichedState;", "", "()V", "changeVisible", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/video/feedflow/detail/summary/enriched/EnrichedSummaryVisible;", "isEnableEnrichedSummary", "", "()Z", "setEnableEnrichedSummary", "(Z)V", "<set-?>", "isLongPressing", "isSummaryShowHeight", "onSummaryDataBind", "Lcom/baidu/searchbox/video/feedflow/detail/summary/SummaryModel;", "bindSummaryData", "", "data", "getBindData", "handleCommonPrefix", "summaryModel", "handleLongPress", "isLongPress", "hideSummaryHeight", "observeSummaryDataBind", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeSummaryHeight", "observeSummaryVisible", "resetControlParam", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "setSummaryVisible", "visible", "Lcom/baidu/searchbox/video/feedflow/detail/summary/enriched/SummaryVisible;", "needAnim", "Lcom/baidu/searchbox/video/feedflow/detail/summary/enriched/SummaryNeedAnim;", "showSummaryHeight", "getSummaryModel", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SummaryEnrichedState.kt */
public final class SummaryEnrichedState {
    private final MutableLiveData<EnrichedSummaryVisible> changeVisible = new MutableLiveData<>();
    private boolean isEnableEnrichedSummary;
    private boolean isLongPressing;
    private final MutableLiveData<Boolean> isSummaryShowHeight = new MutableLiveData<>();
    private final MutableLiveData<SummaryModel> onSummaryDataBind = new MutableLiveData<>();

    public final boolean isLongPressing() {
        return this.isLongPressing;
    }

    public final boolean isEnableEnrichedSummary() {
        return this.isEnableEnrichedSummary;
    }

    public final void setEnableEnrichedSummary(boolean z) {
        this.isEnableEnrichedSummary = z;
    }

    public final SummaryModel getBindData() {
        return this.onSummaryDataBind.getValue();
    }

    public static /* synthetic */ void setSummaryVisible$default(SummaryEnrichedState summaryEnrichedState, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        summaryEnrichedState.setSummaryVisible(z, z2);
    }

    public final void setSummaryVisible(boolean visible, boolean needAnim) {
        this.changeVisible.setValue(new EnrichedSummaryVisible(visible, needAnim));
    }

    public final void hideSummaryHeight() {
        this.isSummaryShowHeight.setValue(false);
    }

    public final void showSummaryHeight() {
        this.isSummaryShowHeight.setValue(true);
    }

    public final void bindSummaryData(SummaryModel data) {
        this.onSummaryDataBind.setValue(data);
    }

    public final void observeSummaryHeight(LifecycleOwner owner, Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.isSummaryShowHeight.observe(owner, observer);
    }

    public final void observeSummaryVisible(LifecycleOwner owner, Observer<EnrichedSummaryVisible> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.changeVisible.observe(owner, observer);
    }

    public final void observeSummaryDataBind(LifecycleOwner owner, Observer<SummaryModel> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.onSummaryDataBind.observe(owner, observer);
    }

    public final void resetControlParam(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SummaryModel summaryModel = getSummaryModel((IntentData) state.select(IntentData.class));
        if (!CommonStateExtKt.isFirstJump$default(state, (ItemModel) null, 1, (Object) null) || summaryModel == null) {
            this.isEnableEnrichedSummary = false;
            bindSummaryData((SummaryModel) null);
            setSummaryVisible$default(this, false, false, 2, (Object) null);
        } else {
            this.isEnableEnrichedSummary = true;
            bindSummaryData(summaryModel);
            setSummaryVisible$default(this, true, false, 2, (Object) null);
        }
        this.isLongPressing = false;
    }

    private final SummaryModel getSummaryModel(IntentData $this$getSummaryModel) {
        if ($this$getSummaryModel != null) {
            VideoFlowUtilsKt.tryParseAndRecordEnrichSummaryData($this$getSummaryModel);
        }
        SummaryModel summaryModel = $this$getSummaryModel != null ? VideoFlowUtilsKt.getEnrichSummaryModel($this$getSummaryModel) : null;
        if (summaryModel != null) {
            handleCommonPrefix(summaryModel);
        }
        return summaryModel;
    }

    public final void handleCommonPrefix(SummaryModel summaryModel) {
        if (summaryModel != null) {
            String sPrefixText = DIFactory.INSTANCE.getAppContext().getString(R.string.video_flow_collection_summary_prefix_text);
            Intrinsics.checkNotNullExpressionValue(sPrefixText, "DIFactory.getAppContext(…tion_summary_prefix_text)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(sPrefixText, Arrays.copyOf(new Object[]{String.valueOf(summaryModel.getPositionInColl())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            summaryModel.setPrefix(format);
        }
    }

    public final void handleLongPress(boolean isLongPress) {
        this.isLongPressing = true;
        setSummaryVisible(!isLongPress, true);
    }
}
