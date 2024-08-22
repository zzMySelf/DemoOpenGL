package com.baidu.searchbox.bddownload.core.interceptor;

import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadCache;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.exception.RetryException;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import java.io.IOException;

public class RetryInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public DownloadConnection.Connected interceptConnect(DownloadChain chain) throws IOException {
        DownloadCache cache = chain.getCache();
        while (true) {
            try {
                if (!cache.isInterrupt()) {
                    return chain.processConnect();
                }
                throw InterruptException.SIGNAL;
            } catch (IOException e2) {
                if (e2 instanceof RetryException) {
                    chain.resetConnectForRetry();
                } else {
                    chain.getCache().catchException(e2);
                    chain.getOutputStream().catchBlockConnectException(chain.getBlockIndex());
                    throw e2;
                }
            }
        }
    }

    public long interceptFetch(DownloadChain chain) throws IOException {
        try {
            return chain.processFetch();
        } catch (IOException e2) {
            chain.getCache().catchException(e2);
            throw e2;
        }
    }
}
