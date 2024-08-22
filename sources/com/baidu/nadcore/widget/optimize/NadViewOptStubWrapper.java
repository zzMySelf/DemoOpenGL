package com.baidu.nadcore.widget.optimize;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R\u0010\u0010\t\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/nadcore/widget/optimize/NadViewOptStubWrapper;", "VIEW", "Landroid/view/View;", "Lcom/baidu/nadcore/widget/optimize/NadViewOptAbsWrapper;", "root", "stubId", "", "viewId", "(Landroid/view/View;II)V", "theRealView", "Landroid/view/View;", "viewStub", "Landroid/view/ViewStub;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getRealView", "()Landroid/view/View;", "hasInflated", "", "setVisibility", "", "visibility", "nadcore-lib-widget"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadViewOptStubWrapper.kt */
public final class NadViewOptStubWrapper<VIEW extends View> extends NadViewOptAbsWrapper<VIEW> {
    private VIEW theRealView;
    private final ViewStub viewStub;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NadViewOptStubWrapper(View root, int stubId, int viewId) {
        super(root, stubId, viewId);
        Intrinsics.checkNotNullParameter(root, "root");
        View findViewById = root.findViewById(stubId);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(stubId)");
        this.viewStub = (ViewStub) findViewById;
    }

    public VIEW getRealView() {
        VIEW view2 = this.theRealView;
        if (view2 == null) {
            VIEW inflate = this.viewStub.inflate();
            if (inflate != null) {
                this.theRealView = inflate;
                if (inflate != null) {
                    return inflate;
                }
                Intrinsics.throwUninitializedPropertyAccessException("theRealView");
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type VIEW of com.baidu.nadcore.widget.optimize.NadViewOptStubWrapper");
        } else if (view2 != null) {
            return view2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("theRealView");
            return null;
        }
    }

    public boolean hasInflated() {
        return this.theRealView != null;
    }

    public void setVisibility(int visibility) {
        VIEW view2 = this.theRealView;
        if (view2 != null) {
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("theRealView");
                view2 = null;
            }
            view2.setVisibility(visibility);
        } else if (visibility != 8) {
            getRealView().setVisibility(visibility);
        }
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        VIEW view2 = this.theRealView;
        if (view2 != null) {
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("theRealView");
                view2 = null;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "{\n            theRealView.layoutParams\n        }");
            return layoutParams;
        }
        ViewGroup.LayoutParams layoutParams2 = this.viewStub.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams2, "{\n            viewStub.layoutParams\n        }");
        return layoutParams2;
    }
}
