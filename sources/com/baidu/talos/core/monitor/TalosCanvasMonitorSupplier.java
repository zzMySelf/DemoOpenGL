package com.baidu.talos.core.monitor;

import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.adaptee.EmptyDataMonitorFactory;
import com.baidu.talos.adapter.IDataMonitorFactory;
import com.baidu.talos.monitor.ICanvasDataHandler;

public class TalosCanvasMonitorSupplier {
    private static final String TAG = "TLS_TalosCanvasMonitorSupplier";
    private static volatile TalosCanvasMonitorSupplier mInstance;
    private ICanvasDataHandler mTLSCanvasMonitorDataHandler;

    private TalosCanvasMonitorSupplier() {
        IDataMonitorFactory monitorDataHandlerFactory = TalosAdapterManager.getMonitorDataHandlerFactory();
        if (monitorDataHandlerFactory == null || (monitorDataHandlerFactory instanceof EmptyDataMonitorFactory)) {
            this.mTLSCanvasMonitorDataHandler = null;
        } else {
            this.mTLSCanvasMonitorDataHandler = monitorDataHandlerFactory.createCanvasDataHandler();
        }
    }

    public static TalosCanvasMonitorSupplier getInstance() {
        if (mInstance == null) {
            synchronized (TalosCanvasMonitorSupplier.class) {
                if (mInstance == null) {
                    mInstance = new TalosCanvasMonitorSupplier();
                }
            }
        }
        return mInstance;
    }

    public ICanvasDataHandler getDataHandler() {
        return this.mTLSCanvasMonitorDataHandler;
    }
}
