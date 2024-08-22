package com.baidu.swan.apps.impl.swancard.ioc.history;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.impl.swancard.ioc.pageinfo.SwanCardPageInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.card.page.SwanCardPage;
import com.baidu.swan.card.ioc.interfaces.history.ICardPageHistoryManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BdCardPageHistoryManager implements ICardPageHistoryManager {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final Lock HISTORY_PAGE_INFO_RLOCK;
    private static final ReadWriteLock HISTORY_PAGE_INFO_RWLOCK;
    private static final Lock HISTORY_PAGE_INFO_WLOCK;
    private static final String TAG = "SwanAppPageHistoryImp";
    private Map<String, SwanCardPageInfo> mHistoryPageInfos = new HashMap();

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        HISTORY_PAGE_INFO_RWLOCK = reentrantReadWriteLock;
        HISTORY_PAGE_INFO_WLOCK = reentrantReadWriteLock.writeLock();
        HISTORY_PAGE_INFO_RLOCK = reentrantReadWriteLock.readLock();
    }

    public void record(String cardId) {
        SwanCardPage cardPage;
        SwanCard swanCard = SwanCardManager.get().getCardOrNull(cardId);
        if (swanCard != null && SwanAppNetworkUtils.isNetworkConnected(swanCard.getActivity()) && (cardPage = SwanCardManager.get().getCurCardPage(swanCard.getCardId())) != null) {
            SwanCardPageInfo pageInfo = SwanCardPageInfo.buildDefaultPageInfo(cardPage.getCurSwanAppPageParams(), "history");
            Lock lock = HISTORY_PAGE_INFO_WLOCK;
            lock.lock();
            try {
                if (!this.mHistoryPageInfos.containsKey(swanCard.getCardId())) {
                    this.mHistoryPageInfos.put(swanCard.getCardId(), pageInfo);
                }
                lock.unlock();
                if (DEBUG) {
                    Log.d(TAG, "default pageInfo" + pageInfo.toString());
                }
                handleHistoryAction(swanCard);
            } catch (Throwable th2) {
                HISTORY_PAGE_INFO_WLOCK.unlock();
                throw th2;
            }
        }
    }

    private void handleHistoryAction(SwanCard swanCard) {
        Lock lock = HISTORY_PAGE_INFO_RLOCK;
        lock.lock();
        try {
            SwanCardPageHistoryAction historyAction = new SwanCardPageHistoryAction(swanCard, this.mHistoryPageInfos.get(swanCard.getCardId()));
            lock.unlock();
            historyAction.handleHistoryAction();
            Lock lock2 = HISTORY_PAGE_INFO_WLOCK;
            lock2.lock();
            try {
                this.mHistoryPageInfos.remove(swanCard.getCardId());
                lock2.unlock();
            } catch (Throwable th2) {
                HISTORY_PAGE_INFO_WLOCK.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            HISTORY_PAGE_INFO_RLOCK.unlock();
            throw th3;
        }
    }

    public void updateHistoryPageInfo(String cardId, SwanCardPageInfo pageInfo) {
        if (pageInfo != null && !TextUtils.isEmpty(cardId)) {
            Lock lock = HISTORY_PAGE_INFO_WLOCK;
            lock.lock();
            try {
                if (this.mHistoryPageInfos == null) {
                    this.mHistoryPageInfos = new LinkedHashMap();
                }
                this.mHistoryPageInfos.put(cardId, pageInfo);
                if (DEBUG) {
                    Log.d(TAG, "update history pageInfo" + pageInfo);
                }
                lock.unlock();
            } catch (Throwable th2) {
                HISTORY_PAGE_INFO_WLOCK.unlock();
                throw th2;
            }
        }
    }
}
