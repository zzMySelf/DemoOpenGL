package com.baidu.searchbox.video.feedflow.flow.operation;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/operation/IFlowFunctionViewCallBack;", "", "leftTopPoint", "Lcom/baidu/searchbox/video/feedflow/flow/operation/FunctionPositionXYModel;", "getLeftTopPoint", "()Lcom/baidu/searchbox/video/feedflow/flow/operation/FunctionPositionXYModel;", "setLeftTopPoint", "(Lcom/baidu/searchbox/video/feedflow/flow/operation/FunctionPositionXYModel;)V", "getFunctionView", "Landroid/view/View;", "getViewHeight", "", "getViewWidth", "isFunctionViewVisible", "", "setFunctionViewPosition", "", "x", "y", "edge", "", "setFunctionViewPositionWithAnim", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IFlowFunctionViewCallBack.kt */
public interface IFlowFunctionViewCallBack {
    View getFunctionView();

    FunctionPositionXYModel getLeftTopPoint();

    int getViewHeight();

    int getViewWidth();

    boolean isFunctionViewVisible();

    void setFunctionViewPosition(int i2, int i3, String str);

    void setFunctionViewPositionWithAnim(int i2, int i3, String str);

    void setLeftTopPoint(FunctionPositionXYModel functionPositionXYModel);
}
