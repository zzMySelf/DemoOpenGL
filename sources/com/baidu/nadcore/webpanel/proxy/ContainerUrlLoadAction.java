package com.baidu.nadcore.webpanel.proxy;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.searchbox.nadbrowser.webpanel.IContainerUrlLoadAction;
import com.baidu.searchbox.nadbrowser.webpanel.NadWrappedBrowserView;

public abstract class ContainerUrlLoadAction implements IContainerUrlLoadAction {
    public abstract boolean exHandleUrlLoading(IContainerContextHelper iContainerContextHelper, String str);

    public abstract void exNotifyPageFinished(IContainerContextHelper iContainerContextHelper, String str);

    public final void notifyPageFinished(IContainerContextHelper container, String url) {
        exNotifyPageFinished(new Proxy(container), url);
    }

    public final boolean handleUrlLoading(IContainerContextHelper container, String url) {
        return exHandleUrlLoading(new Proxy(container), url);
    }

    private static class Proxy implements IContainerContextHelper {
        private final IContainerContextHelper container;

        public Proxy(IContainerContextHelper container2) {
            this.container = container2;
        }

        public NadWrappedBrowserView browserView() {
            return this.container.browserView();
        }

        public FrameLayout rootView() {
            return this.container.rootView();
        }

        public LinearLayout containerLayout() {
            return this.container.containerLayout();
        }

        public boolean shouldOverrideUrlLoading(String url) {
            return this.container.shouldOverrideUrlLoading(url);
        }

        public void pageBack() {
            this.container.pageBack();
        }
    }
}
