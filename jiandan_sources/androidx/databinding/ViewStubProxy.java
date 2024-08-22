package androidx.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewStubProxy {
    public ViewDataBinding mContainingBinding;
    public ViewStub.OnInflateListener mOnInflateListener;
    public ViewStub.OnInflateListener mProxyListener;
    public View mRoot;
    public ViewDataBinding mViewDataBinding;
    public ViewStub mViewStub;

    public ViewStubProxy(@NonNull ViewStub viewStub) {
        AnonymousClass1 r0 = new ViewStub.OnInflateListener() {
            public void onInflate(ViewStub viewStub, View view) {
                View unused = ViewStubProxy.this.mRoot = view;
                ViewStubProxy viewStubProxy = ViewStubProxy.this;
                ViewDataBinding unused2 = viewStubProxy.mViewDataBinding = DataBindingUtil.bind(viewStubProxy.mContainingBinding.mBindingComponent, view, viewStub.getLayoutResource());
                ViewStub unused3 = ViewStubProxy.this.mViewStub = null;
                if (ViewStubProxy.this.mOnInflateListener != null) {
                    ViewStubProxy.this.mOnInflateListener.onInflate(viewStub, view);
                    ViewStub.OnInflateListener unused4 = ViewStubProxy.this.mOnInflateListener = null;
                }
                ViewStubProxy.this.mContainingBinding.invalidateAll();
                ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
            }
        };
        this.mProxyListener = r0;
        this.mViewStub = viewStub;
        viewStub.setOnInflateListener(r0);
    }

    @Nullable
    public ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    public View getRoot() {
        return this.mRoot;
    }

    @Nullable
    public ViewStub getViewStub() {
        return this.mViewStub;
    }

    public boolean isInflated() {
        return this.mRoot != null;
    }

    public void setContainingBinding(@NonNull ViewDataBinding viewDataBinding) {
        this.mContainingBinding = viewDataBinding;
    }

    public void setOnInflateListener(@Nullable ViewStub.OnInflateListener onInflateListener) {
        if (this.mViewStub != null) {
            this.mOnInflateListener = onInflateListener;
        }
    }
}
