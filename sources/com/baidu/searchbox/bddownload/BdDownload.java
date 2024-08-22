package com.baidu.searchbox.bddownload;

import android.content.Context;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher;
import com.baidu.searchbox.bddownload.core.dispatcher.DownloadDispatcher;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.bddownload.core.file.DownloadOutputStream;
import com.baidu.searchbox.bddownload.core.file.DownloadUriOutputStream;
import com.baidu.searchbox.bddownload.core.file.ProcessFileStrategy;
import com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class BdDownload {
    static volatile BdDownload singleton;
    private final BreakpointStore breakpointStore;
    private final CallbackDispatcher callbackDispatcher;
    private final DownloadConnection.Factory connectionFactory;
    private final Context context;
    private final DownloadDispatcher downloadDispatcher;
    private final DownloadStrategy downloadStrategy;
    DownloadMonitor monitor;
    private final DownloadOutputStream.Factory outputStreamFactory;
    private final ProcessFileStrategy processFileStrategy;
    IBDDownloadStatistic statistic;

    BdDownload(Context context2, DownloadDispatcher downloadDispatcher2, CallbackDispatcher callbackDispatcher2, DownloadStore store, DownloadConnection.Factory connectionFactory2, DownloadOutputStream.Factory outputStreamFactory2, ProcessFileStrategy processFileStrategy2, DownloadStrategy downloadStrategy2) {
        this.context = context2;
        this.downloadDispatcher = downloadDispatcher2;
        this.callbackDispatcher = callbackDispatcher2;
        this.breakpointStore = store;
        this.connectionFactory = connectionFactory2;
        this.outputStreamFactory = outputStreamFactory2;
        this.processFileStrategy = processFileStrategy2;
        this.downloadStrategy = downloadStrategy2;
        downloadDispatcher2.setDownloadStore(Util.createRemitDatabase(store));
    }

    public DownloadDispatcher downloadDispatcher() {
        return this.downloadDispatcher;
    }

    public CallbackDispatcher callbackDispatcher() {
        return this.callbackDispatcher;
    }

    public BreakpointStore breakpointStore() {
        return this.breakpointStore;
    }

    public DownloadConnection.Factory connectionFactory() {
        return this.connectionFactory;
    }

    public DownloadOutputStream.Factory outputStreamFactory() {
        return this.outputStreamFactory;
    }

    public ProcessFileStrategy processFileStrategy() {
        return this.processFileStrategy;
    }

    public DownloadStrategy downloadStrategy() {
        return this.downloadStrategy;
    }

    public Context context() {
        return this.context;
    }

    public void setMonitor(DownloadMonitor monitor2) {
        this.monitor = monitor2;
    }

    public void setBDDownloadStatistic(IBDDownloadStatistic statistic2) {
        this.statistic = statistic2;
    }

    public DownloadMonitor getMonitor() {
        return this.monitor;
    }

    public IBDDownloadStatistic getStatistic() {
        return this.statistic;
    }

    public static BdDownload with() {
        if (singleton == null) {
            synchronized (BdDownload.class) {
                if (singleton == null) {
                    Context context2 = AppRuntime.getAppContext();
                    if (context2 != null) {
                        singleton = new Builder(context2).build();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return singleton;
    }

    public static void setSingletonInstance(BdDownload bdDownload) {
        if (singleton == null) {
            synchronized (BdDownload.class) {
                if (singleton == null) {
                    singleton = bdDownload;
                } else {
                    throw new IllegalArgumentException("BdDownload must be null.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("BdDownload must be null.");
    }

    public static class Builder {
        private IBDDownloadStatistic bdDownloadStatistic;
        private CallbackDispatcher callbackDispatcher;
        private DownloadConnection.Factory connectionFactory;
        private final Context context;
        private DownloadDispatcher downloadDispatcher;
        private DownloadStore downloadStore;
        private DownloadStrategy downloadStrategy;
        private DownloadMonitor monitor;
        private DownloadOutputStream.Factory outputStreamFactory;
        private ProcessFileStrategy processFileStrategy;

        public Builder(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Builder downloadDispatcher(DownloadDispatcher downloadDispatcher2) {
            this.downloadDispatcher = downloadDispatcher2;
            return this;
        }

        public Builder callbackDispatcher(CallbackDispatcher callbackDispatcher2) {
            this.callbackDispatcher = callbackDispatcher2;
            return this;
        }

        public Builder downloadStore(DownloadStore downloadStore2) {
            this.downloadStore = downloadStore2;
            return this;
        }

        public Builder connectionFactory(DownloadConnection.Factory connectionFactory2) {
            this.connectionFactory = connectionFactory2;
            return this;
        }

        public Builder outputStreamFactory(DownloadOutputStream.Factory outputStreamFactory2) {
            this.outputStreamFactory = outputStreamFactory2;
            return this;
        }

        public Builder processFileStrategy(ProcessFileStrategy processFileStrategy2) {
            this.processFileStrategy = processFileStrategy2;
            return this;
        }

        public Builder downloadStrategy(DownloadStrategy downloadStrategy2) {
            this.downloadStrategy = downloadStrategy2;
            return this;
        }

        public Builder monitor(DownloadMonitor monitor2) {
            this.monitor = monitor2;
            return this;
        }

        public Builder bdDownloadStatistic(IBDDownloadStatistic statistic) {
            this.bdDownloadStatistic = statistic;
            return this;
        }

        public BdDownload build() {
            if (this.downloadDispatcher == null) {
                this.downloadDispatcher = new DownloadDispatcher();
            }
            if (this.callbackDispatcher == null) {
                this.callbackDispatcher = new CallbackDispatcher();
            }
            if (this.downloadStore == null) {
                this.downloadStore = Util.createDefaultDatabase(this.context);
            }
            if (this.connectionFactory == null) {
                this.connectionFactory = Util.createHttpManagerConnectionFactory();
            }
            if (this.outputStreamFactory == null) {
                this.outputStreamFactory = new DownloadUriOutputStream.Factory();
            }
            if (this.processFileStrategy == null) {
                this.processFileStrategy = new ProcessFileStrategy();
            }
            if (this.downloadStrategy == null) {
                this.downloadStrategy = new DownloadStrategy();
            }
            BdDownload bdDownload = new BdDownload(this.context, this.downloadDispatcher, this.callbackDispatcher, this.downloadStore, this.connectionFactory, this.outputStreamFactory, this.processFileStrategy, this.downloadStrategy);
            bdDownload.setMonitor(this.monitor);
            bdDownload.setBDDownloadStatistic(this.bdDownloadStatistic);
            Util.d("BdDownload", "downloadStore[" + this.downloadStore + "] connectionFactory[" + this.connectionFactory);
            return bdDownload;
        }
    }
}
