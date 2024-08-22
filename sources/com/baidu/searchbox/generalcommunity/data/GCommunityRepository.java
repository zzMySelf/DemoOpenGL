package com.baidu.searchbox.generalcommunity.data;

import android.util.Log;
import androidx.lifecycle.LiveData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.generalcommunity.AppExecutors;
import com.baidu.searchbox.generalcommunity.context.GCommunityRuntime;
import com.baidu.searchbox.generalcommunity.data.db.GCommunityDao;
import com.baidu.searchbox.generalcommunity.data.network.GCommunityNetworkSource;
import com.baidu.searchbox.generalcommunity.injector.ConfigOptions;
import com.baidu.searchbox.generalcommunity.model.GCommunityPolicyModel;
import com.baidu.searchbox.generalcommunity.policy.duplicate.DuplicateProcessor;
import java.util.List;
import org.json.JSONObject;

public class GCommunityRepository {
    public static final boolean DEBUG = GCommunityRuntime.GLOBAL_DEBUG;
    public static final String TAG = GCommunityRepository.class.getSimpleName();
    private DuplicateProcessor mDupProcessor;
    private final AppExecutors mExecutors;
    /* access modifiers changed from: private */
    public final GCommunityDao mGCommunityDao;
    private final GCommunityNetworkSource mGCommunityNetworkSource;
    /* access modifiers changed from: private */
    public boolean mHasLoadAllDbData = false;
    /* access modifiers changed from: private */
    public int mLoadedCountFromDB = 0;

    static /* synthetic */ int access$112(GCommunityRepository x0, int x1) {
        int i2 = x0.mLoadedCountFromDB + x1;
        x0.mLoadedCountFromDB = i2;
        return i2;
    }

    public GCommunityRepository(AppExecutors executors, GCommunityDao GCommunityDao, GCommunityNetworkSource GCommunityNetworkSource, DuplicateProcessor dupProcessor) {
        this.mExecutors = executors;
        this.mGCommunityDao = GCommunityDao;
        this.mGCommunityNetworkSource = GCommunityNetworkSource;
        this.mDupProcessor = dupProcessor;
    }

    public void loadMoreDataFromNet() {
        this.mGCommunityNetworkSource.loadMoreData(this.mDupProcessor);
    }

    public void refreshDataFromNet(String refreshType) {
        this.mGCommunityNetworkSource.fetchListData(this.mDupProcessor, refreshType);
    }

    public LiveData<List<FeedBaseModel>> getNetMoreDataList() {
        return this.mGCommunityNetworkSource.getLoadMoreData();
    }

    public LiveData<List<FeedBaseModel>> getRefreshDataList() {
        return this.mGCommunityNetworkSource.getRefreshData();
    }

    public LiveData<List<FeedBaseModel>> loadNextPageFromDb(boolean isFirstPage, int pageSize) {
        GCommunityDao gCommunityDao = this.mGCommunityDao;
        if (gCommunityDao == null) {
            return null;
        }
        if (isFirstPage) {
            this.mLoadedCountFromDB = 0;
        }
        return gCommunityDao.selectItemsLimit(this.mLoadedCountFromDB, pageSize);
    }

    public LiveData<List<FeedBaseModel>> loadAllDataFromDb() {
        GCommunityDao gCommunityDao = this.mGCommunityDao;
        if (gCommunityDao == null) {
            return null;
        }
        return gCommunityDao.selectItemsLimit(0, -1);
    }

    public void updatePageStartPosOfDb(int lastCount) {
        if (this.mGCommunityDao != null) {
            this.mLoadedCountFromDB += lastCount;
            this.mExecutors.diskIO().execute(new Runnable() {
                public void run() {
                    if (GCommunityRepository.this.mLoadedCountFromDB >= GCommunityRepository.this.mGCommunityDao.getItemCount()) {
                        boolean unused = GCommunityRepository.this.mHasLoadAllDbData = true;
                    } else {
                        boolean unused2 = GCommunityRepository.this.mHasLoadAllDbData = false;
                    }
                }
            });
        }
    }

    public void insertDataToDb(final List<FeedBaseModel> list, final int maxSize, final ConfigOptions.DBCSLoadPolicy policy) {
        if (this.mGCommunityDao != null) {
            this.mExecutors.diskIO().execute(new Runnable() {
                public void run() {
                    if (policy == ConfigOptions.DBCSLoadPolicy.PAGE) {
                        GCommunityRepository.this.mGCommunityDao.bulkInsert(list);
                        GCommunityRepository.this.mGCommunityDao.deleteOverflowData(maxSize);
                    }
                    if (policy == ConfigOptions.DBCSLoadPolicy.ALL) {
                        GCommunityRepository.this.mGCommunityDao.bulkInsertClearFirst(list);
                    }
                }
            });
        }
    }

    public boolean hasMoreNetData() {
        return this.mGCommunityNetworkSource.hasMoreData();
    }

    public int getShieldStatus() {
        return this.mGCommunityNetworkSource.getShieldStatus();
    }

    public boolean hasLoadAllDBData() {
        return this.mHasLoadAllDbData;
    }

    public GCommunityPolicyModel getPolicy() {
        if (this.mGCommunityNetworkSource.getGCommunityModel() != null) {
            return this.mGCommunityNetworkSource.getGCommunityModel().policy;
        }
        return null;
    }

    public void loadDbAllLeftData(final List<FeedBaseModel> list) {
        if (this.mGCommunityDao != null) {
            if (!this.mHasLoadAllDbData) {
                this.mExecutors.diskIO().execute(new Runnable() {
                    public void run() {
                        boolean unused = GCommunityRepository.this.mHasLoadAllDbData = true;
                        List<FeedBaseModel> dbAllDataList = GCommunityRepository.this.mGCommunityDao.selectAllItems(GCommunityRepository.this.mLoadedCountFromDB);
                        if (dbAllDataList != null && dbAllDataList.size() > 0) {
                            list.addAll(dbAllDataList);
                            GCommunityRepository.access$112(GCommunityRepository.this, dbAllDataList.size());
                            if (GCommunityRepository.DEBUG) {
                                Log.d(GCommunityRepository.TAG, "#loadDbAllLeftData#, fill db left data to HistoryCache, size: " + dbAllDataList.size() + ", history size: " + list.size());
                            }
                        }
                    }
                });
            } else if (DEBUG) {
                Log.d(TAG, "#loadDbAllLeftData#, Has Load all Db data, do nothing");
            }
        }
    }

    public void deleteItemByFeedIdInDb(final String feedId) {
        if (this.mGCommunityDao != null) {
            this.mExecutors.diskIO().execute(new Runnable() {
                public void run() {
                    GCommunityRepository.this.mGCommunityDao.deleteItemByFeedId(feedId);
                }
            });
        }
    }

    public void clear() {
        this.mGCommunityNetworkSource.clear();
    }

    public boolean isLoadingMoreFromNet() {
        return this.mGCommunityNetworkSource.isLoadingMore();
    }

    public boolean isRefreshingFromNet() {
        return this.mGCommunityNetworkSource.isRefreshing();
    }

    public void updateItemByFeedIdInDb(final String feedId, final FeedBaseModel baseModel) {
        if (this.mGCommunityDao != null) {
            this.mExecutors.diskIO().execute(new Runnable() {
                public void run() {
                    GCommunityRepository.this.mGCommunityDao.updateItemByFeedId(feedId, baseModel);
                }
            });
        }
    }

    public void updateItemByTypeInDb(final String type, final FeedBaseModel baseModel) {
        if (this.mGCommunityDao != null) {
            this.mExecutors.diskIO().execute(new Runnable() {
                public void run() {
                    GCommunityRepository.this.mGCommunityDao.updateItemByType(type, baseModel);
                }
            });
        }
    }

    public String getShieldUrl() {
        return this.mGCommunityNetworkSource.getShieldUrl();
    }

    public void processDuplicateBoth(List<FeedBaseModel> newDataList, List<FeedBaseModel> oldDataList) {
        this.mDupProcessor.processDuplicateBoth(this, newDataList, oldDataList);
    }

    public void updateDupInfo(FeedBaseModel baseModel) {
        this.mDupProcessor.updateDupInfo(baseModel);
    }

    public void updateItemDupInfo(String id) {
        this.mDupProcessor.updateItemDupInfo(id);
    }

    public void updateItemClickStatis(String id) {
        this.mDupProcessor.updateItemClickStatus(id);
    }

    public void storageDupInfo() {
        this.mDupProcessor.storage();
    }

    public void recoverDupInfo() {
        this.mDupProcessor.recovery();
    }

    public void handleSuccessResponseString(int requestType, String responseString) {
        this.mGCommunityNetworkSource.handleSuccessResponseString(requestType, responseString, this.mDupProcessor);
    }

    public FeedBaseModel parseCommunityBaseModel(JSONObject itemObj) {
        return this.mGCommunityNetworkSource.parseCommunityBaseModel(itemObj);
    }
}
