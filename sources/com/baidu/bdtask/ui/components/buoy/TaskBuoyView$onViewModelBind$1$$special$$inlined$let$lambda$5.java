package com.baidu.bdtask.ui.components.buoy;

import android.widget.ProgressBar;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TaskBuoyViewData $it;
    final /* synthetic */ TaskStatus $status;
    final /* synthetic */ TaskBuoyView$onViewModelBind$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$5(TaskBuoyViewData taskBuoyViewData, TaskStatus taskStatus, TaskBuoyView$onViewModelBind$1 taskBuoyView$onViewModelBind$1) {
        super(0);
        this.$it = taskBuoyViewData;
        this.$status = taskStatus;
        this.this$0 = taskBuoyView$onViewModelBind$1;
    }

    public final void invoke() {
        if (this.this$0.this$0.isUpdateEnable()) {
            if (Float.compare(this.$it.getCurProcessRate(), 0.0f) > 0 || this.$it.isForceSeek()) {
                if (!this.this$0.this$0.isIncluded(8)) {
                    this.this$0.this$0.buoyHide = false;
                    this.this$0.this$0.setVisibility(true);
                }
                if (this.this$0.this$0.buoyHide) {
                    this.this$0.this$0.setVisibility(false);
                } else {
                    this.this$0.this$0.setVisibility(true);
                }
                ProgressBar access$getProgressBar$p = this.this$0.this$0.progressBar;
                if (access$getProgressBar$p != null) {
                    access$getProgressBar$p.setVisibility(0);
                }
                this.this$0.this$0.updateMsgUI(this.$it.getTxtColor());
                TaskBuoyView.updateBg$default(this.this$0.this$0, this.$it.getBgUrl(), (Function0) null, 2, (Object) null);
                this.this$0.this$0.updateProcessUI(this.$it.getPBackColor(), this.$it.getPForeColor());
                this.this$0.this$0.updateProcessValue(this.$it.getCurProcessRate(), this.$it.getTotal(), this.$it.getMessage(), this.$it.isForceSeek());
                if (this.this$0.this$0.curBuoyShowStatus != this.$status.getCurStatus()) {
                    DebugTrace.INSTANCE.debug("force show buoy dialog , preBuoy:" + this.this$0.this$0.curBuoyShowStatus + " curBuoy:" + this.$status.getCurStatus());
                    this.this$0.this$0.showBuoyView();
                }
                this.this$0.this$0.curBuoyShowStatus = this.$status.getCurStatus();
                return;
            }
            DebugTrace.INSTANCE.debug("curProcessRate:" + this.$it.getCurProcessRate());
        }
    }
}
