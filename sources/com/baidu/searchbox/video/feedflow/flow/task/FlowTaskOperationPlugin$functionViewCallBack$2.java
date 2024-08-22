package com.baidu.searchbox.video.feedflow.flow.task;

import android.view.View;
import com.baidu.searchbox.taskapi.ITaskComponent;
import com.baidu.searchbox.taskapi.core.config.TaskInfo;
import com.baidu.searchbox.video.feedflow.flow.operation.FunctionPositionXYModel;
import com.baidu.searchbox.video.feedflow.flow.operation.IFlowFunctionViewCallBack;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/flow/task/FlowTaskOperationPlugin$functionViewCallBack$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/flow/task/FlowTaskOperationPlugin$functionViewCallBack$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowTaskOperationPlugin.kt */
final class FlowTaskOperationPlugin$functionViewCallBack$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ FlowTaskOperationPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowTaskOperationPlugin$functionViewCallBack$2(FlowTaskOperationPlugin flowTaskOperationPlugin) {
        super(0);
        this.this$0 = flowTaskOperationPlugin;
    }

    public final AnonymousClass1 invoke() {
        final FlowTaskOperationPlugin flowTaskOperationPlugin = this.this$0;
        return new IFlowFunctionViewCallBack() {
            private FunctionPositionXYModel leftTopPoint = new FunctionPositionXYModel(0, 0, (String) null, 7, (DefaultConstructorMarker) null);

            public FunctionPositionXYModel getLeftTopPoint() {
                return this.leftTopPoint;
            }

            public void setLeftTopPoint(FunctionPositionXYModel functionPositionXYModel) {
                Intrinsics.checkNotNullParameter(functionPositionXYModel, "<set-?>");
                this.leftTopPoint = functionPositionXYModel;
            }

            public View getFunctionView() {
                TaskInfo taskInfo;
                ITaskComponent access$getTaskComponent$p = flowTaskOperationPlugin.taskComponent;
                if (access$getTaskComponent$p == null || (taskInfo = access$getTaskComponent$p.getTaskInfo()) == null) {
                    return null;
                }
                return taskInfo.getContentView();
            }

            public boolean isFunctionViewVisible() {
                return flowTaskOperationPlugin.taskVisible$lib_flow_component_release();
            }

            public void setFunctionViewPosition(int x, int y, String edge) {
                Intrinsics.checkNotNullParameter(edge, "edge");
                if (flowTaskOperationPlugin.taskVisible$lib_flow_component_release()) {
                    flowTaskOperationPlugin.taskMoveTo(x, y, edge);
                }
            }

            public void setFunctionViewPositionWithAnim(int x, int y, String edge) {
                Intrinsics.checkNotNullParameter(edge, "edge");
                if (flowTaskOperationPlugin.taskVisible$lib_flow_component_release()) {
                    flowTaskOperationPlugin.taskMoveTo(x, y, edge);
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
                r0 = (r0 = r0.getTaskInfo()).getContentView();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int getViewHeight() {
                /*
                    r2 = this;
                    com.baidu.searchbox.video.feedflow.flow.task.FlowTaskOperationPlugin r0 = r1
                    com.baidu.searchbox.taskapi.ITaskComponent r0 = r0.taskComponent
                    if (r0 == 0) goto L_0x001d
                    com.baidu.searchbox.taskapi.core.config.TaskInfo r0 = r0.getTaskInfo()
                    if (r0 == 0) goto L_0x001d
                    android.view.View r0 = r0.getContentView()
                    if (r0 == 0) goto L_0x001d
                    int r0 = r0.getHeight()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    goto L_0x001e
                L_0x001d:
                    r0 = 0
                L_0x001e:
                    int r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r0)
                    if (r0 > 0) goto L_0x002a
                    r1 = 1120927744(0x42d00000, float:104.0)
                    int r0 = com.baidu.searchbox.player.utils.ViewUtil.dp2px(r1)
                L_0x002a:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.task.FlowTaskOperationPlugin$functionViewCallBack$2.AnonymousClass1.getViewHeight():int");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
                r0 = (r0 = r0.getTaskInfo()).getContentView();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int getViewWidth() {
                /*
                    r2 = this;
                    com.baidu.searchbox.video.feedflow.flow.task.FlowTaskOperationPlugin r0 = r1
                    com.baidu.searchbox.taskapi.ITaskComponent r0 = r0.taskComponent
                    if (r0 == 0) goto L_0x001d
                    com.baidu.searchbox.taskapi.core.config.TaskInfo r0 = r0.getTaskInfo()
                    if (r0 == 0) goto L_0x001d
                    android.view.View r0 = r0.getContentView()
                    if (r0 == 0) goto L_0x001d
                    int r0 = r0.getWidth()
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    goto L_0x001e
                L_0x001d:
                    r0 = 0
                L_0x001e:
                    int r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r0)
                    if (r0 > 0) goto L_0x002a
                    r1 = 1117782016(0x42a00000, float:80.0)
                    int r0 = com.baidu.searchbox.player.utils.ViewUtil.dp2px(r1)
                L_0x002a:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.task.FlowTaskOperationPlugin$functionViewCallBack$2.AnonymousClass1.getViewWidth():int");
            }
        };
    }
}
