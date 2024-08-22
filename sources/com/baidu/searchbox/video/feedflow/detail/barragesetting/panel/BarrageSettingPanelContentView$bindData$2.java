package com.baidu.searchbox.video.feedflow.detail.barragesetting.panel;

import android.widget.TextView;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.seekbar.OnSliderSeekBarChangeListener;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.seekbar.SliderSeekBar;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.switcher.BarrageSettingConfigData;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.switcher.DanmuSpeedGearItemData;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.utils.BarrageSettingSPDataUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/barragesetting/panel/BarrageSettingPanelContentView$bindData$2", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/OnSliderSeekBarChangeListener;", "onIndexChanged", "", "rangeBar", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/seekbar/SliderSeekBar;", "index", "", "isReset", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageSettingPanelContentView.kt */
public final class BarrageSettingPanelContentView$bindData$2 implements OnSliderSeekBarChangeListener {
    final /* synthetic */ BarrageSettingConfigData $model;
    final /* synthetic */ BarrageSettingPanelContentView this$0;

    BarrageSettingPanelContentView$bindData$2(BarrageSettingConfigData $model2, BarrageSettingPanelContentView $receiver) {
        this.$model = $model2;
        this.this$0 = $receiver;
    }

    public void onIndexChanged(SliderSeekBar rangeBar, int index, boolean isReset) {
        int actionType;
        CharSequence charSequence;
        String text;
        if (isReset) {
            actionType = 1;
        } else {
            actionType = 0;
        }
        if (this.$model.getType() == 1) {
            DanmuSpeedGearItemData $this$onIndexChanged_u24lambda_u2d0 = (DanmuSpeedGearItemData) CollectionsKt.getOrNull(this.$model.getDanmuSpeed().getSettings(), index);
            if ($this$onIndexChanged_u24lambda_u2d0 != null) {
                BarrageSettingPanelContentView barrageSettingPanelContentView = this.this$0;
                barrageSettingPanelContentView.speedValueTextView.setText($this$onIndexChanged_u24lambda_u2d0.getText());
                OnBarrageSettingPanelItemChangeListener itemChangeListener = barrageSettingPanelContentView.getItemChangeListener();
                if (itemChangeListener != null) {
                    itemChangeListener.onSpeedValueChange(index, $this$onIndexChanged_u24lambda_u2d0.getSpeed(), actionType);
                }
            }
        } else if (index == 0) {
            DanmuSpeedGearItemData $this$onIndexChanged_u24lambda_u2d1 = (DanmuSpeedGearItemData) CollectionsKt.getOrNull(this.$model.getDanmuSpeed().getSettings(), index);
            if ($this$onIndexChanged_u24lambda_u2d1 != null) {
                BarrageSettingPanelContentView barrageSettingPanelContentView2 = this.this$0;
                barrageSettingPanelContentView2.speedValueTextView.setText($this$onIndexChanged_u24lambda_u2d1.getText());
                OnBarrageSettingPanelItemChangeListener itemChangeListener2 = barrageSettingPanelContentView2.getItemChangeListener();
                if (itemChangeListener2 != null) {
                    itemChangeListener2.onSpeedValueChange(index, $this$onIndexChanged_u24lambda_u2d1.getSpeed(), actionType);
                }
            }
        } else {
            float factor = BarrageSettingSPDataUtils.INSTANCE.getSysSpeedFactor(index - 1);
            OnBarrageSettingPanelItemChangeListener itemChangeListener3 = this.this$0.getItemChangeListener();
            if (itemChangeListener3 != null) {
                itemChangeListener3.onSpeedValueChange(index, factor, actionType);
            }
            TextView access$getSpeedValueTextView$p = this.this$0.speedValueTextView;
            DanmuSpeedGearItemData danmuSpeedGearItemData = (DanmuSpeedGearItemData) CollectionsKt.getOrNull(this.$model.getDanmuSpeed().getSettings(), index);
            if (danmuSpeedGearItemData == null || (text = danmuSpeedGearItemData.getText()) == null) {
                charSequence = this.this$0.speedTags[Math.min(index, this.this$0.speedTags.length - 1)];
            } else {
                charSequence = text;
            }
            access$getSpeedValueTextView$p.setText(charSequence);
        }
        BarrageSettingPanelContentView.refreshResumeDefaultTextViewState$default(this.this$0, this.$model, false, 2, (Object) null);
    }
}
