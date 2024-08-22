package com.baidu.android.util.logs;

import android.os.Looper;
import android.util.Printer;
import com.baidu.android.util.concurrent.UiThreadUtils;
import java.util.ArrayList;
import java.util.List;

public class MainLooperPrinter implements Printer {
    private static volatile MainLooperPrinter sInstance;
    private List<Printer> mPrinterList = new ArrayList(3);

    private MainLooperPrinter() {
    }

    public static MainLooperPrinter getInstance() {
        if (sInstance == null) {
            synchronized (MainLooperPrinter.class) {
                if (sInstance == null) {
                    sInstance = new MainLooperPrinter();
                }
            }
        }
        return sInstance;
    }

    public void println(String x) {
        for (Printer printer : this.mPrinterList) {
            if (printer != null) {
                printer.println(x);
            }
        }
    }

    public void addPrinter(final Printer printer) {
        if (UiThreadUtils.isOnUiThread()) {
            addPrinterInternal(printer);
        } else {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    MainLooperPrinter.this.addPrinterInternal(printer);
                }
            });
        }
    }

    public void removePrinter(final Printer printer) {
        if (UiThreadUtils.isOnUiThread()) {
            removePrinterInternal(printer);
        } else {
            UiThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    MainLooperPrinter.this.removePrinterInternal(printer);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void addPrinterInternal(Printer printer) {
        if (printer != null && !this.mPrinterList.contains(printer)) {
            this.mPrinterList.add(printer);
            if (this.mPrinterList.size() == 1) {
                Looper.getMainLooper().setMessageLogging(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void removePrinterInternal(Printer printer) {
        if (printer != null) {
            this.mPrinterList.remove(printer);
            if (this.mPrinterList.size() <= 0) {
                Looper.getMainLooper().setMessageLogging((Printer) null);
            }
        }
    }
}
