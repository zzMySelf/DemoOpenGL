package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;

public class WebMessageAdapter implements WebMessageBoundaryInterface {
    private WebMessageCompat mWebMessageCompat;

    WebMessageAdapter(WebMessageCompat webMessage) {
        this.mWebMessageCompat = webMessage;
    }

    public String getData() {
        return this.mWebMessageCompat.getData();
    }

    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
        if (ports == null) {
            return null;
        }
        InvocationHandler[] invocationHandlers = new InvocationHandler[ports.length];
        for (int n = 0; n < ports.length; n++) {
            invocationHandlers[n] = ports[n].getInvocationHandler();
        }
        return invocationHandlers;
    }

    public String[] getSupportedFeatures() {
        return new String[0];
    }

    public static WebMessageCompat webMessageCompatFromBoundaryInterface(WebMessageBoundaryInterface boundaryInterface) {
        return new WebMessageCompat(boundaryInterface.getData(), toWebMessagePortCompats(boundaryInterface.getPorts()));
    }

    private static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] ports) {
        WebMessagePortCompat[] compatPorts = new WebMessagePortCompat[ports.length];
        for (int n = 0; n < ports.length; n++) {
            compatPorts[n] = new WebMessagePortImpl(ports[n]);
        }
        return compatPorts;
    }
}
