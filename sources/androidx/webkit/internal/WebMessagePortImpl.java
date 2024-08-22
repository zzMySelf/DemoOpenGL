package androidx.webkit.internal;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessagePortImpl extends WebMessagePortCompat {
    private WebMessagePortBoundaryInterface mBoundaryInterface;
    private WebMessagePort mFrameworksImpl;

    public WebMessagePortImpl(WebMessagePort frameworksImpl) {
        this.mFrameworksImpl = frameworksImpl;
    }

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler);
    }

    private WebMessagePort getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    public void postMessage(WebMessageCompat message) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_MESSAGE_PORT_POST_MESSAGE");
        if (feature.isSupportedByFramework()) {
            getFrameworksImpl().postMessage(compatToFrameworkMessage(message));
        } else if (feature.isSupportedByWebView()) {
            getBoundaryInterface().postMessage(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(message)));
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void close() {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_MESSAGE_PORT_CLOSE");
        if (feature.isSupportedByFramework()) {
            getFrameworksImpl().close();
        } else if (feature.isSupportedByWebView()) {
            getBoundaryInterface().close();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setWebMessageCallback(final WebMessagePortCompat.WebMessageCallbackCompat callback) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        if (feature.isSupportedByFramework()) {
            getFrameworksImpl().setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
                public void onMessage(WebMessagePort port, WebMessage message) {
                    callback.onMessage(new WebMessagePortImpl(port), WebMessagePortImpl.frameworkMessageToCompat(message));
                }
            });
        } else if (feature.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(callback)));
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setWebMessageCallback(Handler handler, final WebMessagePortCompat.WebMessageCallbackCompat callback) {
        WebViewFeatureInternal feature = WebViewFeatureInternal.getFeature("CREATE_WEB_MESSAGE_CHANNEL");
        if (feature.isSupportedByFramework()) {
            getFrameworksImpl().setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
                public void onMessage(WebMessagePort port, WebMessage message) {
                    callback.onMessage(new WebMessagePortImpl(port), WebMessagePortImpl.frameworkMessageToCompat(message));
                }
            }, handler);
        } else if (feature.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(callback)), handler);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public WebMessagePort getFrameworkPort() {
        return getFrameworksImpl();
    }

    public InvocationHandler getInvocationHandler() {
        return Proxy.getInvocationHandler(getBoundaryInterface());
    }

    public static WebMessagePortCompat[] portsToCompat(WebMessagePort[] ports) {
        if (ports == null) {
            return null;
        }
        WebMessagePortCompat[] compatPorts = new WebMessagePortCompat[ports.length];
        for (int n = 0; n < ports.length; n++) {
            compatPorts[n] = new WebMessagePortImpl(ports[n]);
        }
        return compatPorts;
    }

    public static WebMessagePort[] compatToPorts(WebMessagePortCompat[] compatPorts) {
        if (compatPorts == null) {
            return null;
        }
        WebMessagePort[] ports = new WebMessagePort[compatPorts.length];
        for (int n = 0; n < ports.length; n++) {
            ports[n] = compatPorts[n].getFrameworkPort();
        }
        return ports;
    }

    public static WebMessage compatToFrameworkMessage(WebMessageCompat message) {
        return new WebMessage(message.getData(), compatToPorts(message.getPorts()));
    }

    public static WebMessageCompat frameworkMessageToCompat(WebMessage message) {
        return new WebMessageCompat(message.getData(), portsToCompat(message.getPorts()));
    }
}
