package com.baidu.searchbox.sync.business.history;

import android.database.Cursor;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.bookmark.adapter.HistoryAdapter;
import com.baidu.searchbox.bookmark.history.VisitHistoryHelper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.swan.api.SwanAppApi;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class VisitHistoryManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "VisitHistoryManager";

    public static VisitHistoryManager getInstance() {
        return Holder.INSTANCE;
    }

    public List<HistoryAdapter.SectionItemInfo> querySwanHistoryByTitle(String word) {
        Cursor cursor = null;
        try {
            cursor = SwanAppApi.getHistoryRuntime().querySwanHistoryByTitle(word);
            if (cursor != null) {
                if (cursor.getCount() != 0) {
                    Pair<ArrayList<HistoryAdapter.SectionItemInfo>, ArrayList<String>> pair = VisitHistoryHelper.convertToSwanAppSectionList(cursor, false);
                    if (pair == null) {
                        if (DEBUG && cursor != null) {
                            Log.d(TAG, "querySwanHistoryByKeyword: keyword[" + word + "]  Cursor count: " + cursor.getCount());
                        }
                        Closeables.closeSafely(cursor);
                        return null;
                    }
                    List<HistoryAdapter.SectionItemInfo> list = (List) pair.first;
                    if (DEBUG && cursor != null) {
                        Log.d(TAG, "querySwanHistoryByKeyword: keyword[" + word + "]  Cursor count: " + cursor.getCount());
                    }
                    Closeables.closeSafely(cursor);
                    return list;
                }
            }
            if (DEBUG && cursor != null) {
                Log.d(TAG, "querySwanHistoryByKeyword: keyword[" + word + "]  Cursor count: " + cursor.getCount());
            }
            Closeables.closeSafely(cursor);
            return null;
        } catch (Exception e2) {
            boolean z = DEBUG;
            if (z) {
                e2.printStackTrace();
            }
            if (z && cursor != null) {
                Log.d(TAG, "querySwanHistoryByKeyword: keyword[" + word + "]  Cursor count: " + cursor.getCount());
            }
            Closeables.closeSafely(cursor);
            return null;
        } catch (Throwable th2) {
            if (DEBUG && cursor != null) {
                Log.d(TAG, "querySwanHistoryByKeyword: keyword[" + word + "]  Cursor count: " + cursor.getCount());
            }
            Closeables.closeSafely(cursor);
            throw th2;
        }
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final VisitHistoryManager INSTANCE = new VisitHistoryManager();

        private Holder() {
        }
    }
}
