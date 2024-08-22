package com.baidu.searchbox.feed.list.cache;

import com.baidu.searchbox.feed.list.cache.db.IDataDBMgr;
import com.baidu.searchbox.feed.list.cache.memory.IDataMemoryMgr;
import com.baidu.searchbox.feed.list.cache.strategy.DataMgrStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsDataManager<DataT> implements IDataMemoryMgr<DataT>, IDataDBMgr<DataT> {
    private static final int INIT_SIZE = 10;
    private String mAssignId;
    private ArrayList<DataT> mDisplayCache = new ArrayList<>(10);
    private ArrayList<DataT> mEntireCache = new ArrayList<>(10);

    AbsDataManager(String assignId) {
        this.mAssignId = assignId;
    }

    /* access modifiers changed from: protected */
    public ArrayList<DataT> getDisplayCache() {
        return this.mDisplayCache;
    }

    /* access modifiers changed from: protected */
    public ArrayList<DataT> getEntireCache() {
        return this.mEntireCache;
    }

    private void saveDataToEntireCache(List<DataT> list) {
        if (!list.isEmpty()) {
            int firstPos = this.mDisplayCache.indexOf(list.get(0));
            if (firstPos > this.mEntireCache.size()) {
                this.mEntireCache.addAll(list);
            } else {
                this.mEntireCache.addAll(firstPos, list);
            }
        }
    }

    public int displayCacheSize() {
        return this.mDisplayCache.size();
    }

    public boolean equals(DataT datat, DataT datat2) {
        return false;
    }

    public void saveData(DataT data, DataMgrStrategy strategy) {
        List<DataT> tempList = new ArrayList<>(1);
        tempList.add(data);
        saveData(tempList, strategy);
    }

    public void saveData(List<DataT> list, DataMgrStrategy strategy) {
        this.mDisplayCache.addAll(list);
        if (strategy.isUseEntireCache()) {
            saveDataToEntireCache(list);
        }
        if (strategy.isActOnDB()) {
            saveDataToDB(list, this.mAssignId);
        }
    }

    public void insertData(DataT data, int index, DataMgrStrategy strategy) {
        List<DataT> tempList = new ArrayList<>(1);
        tempList.add(data);
        insertData(tempList, index, strategy);
    }

    public void insertData(List<DataT> list, int index, DataMgrStrategy strategy) {
        if (index >= 0 && index <= this.mDisplayCache.size()) {
            this.mDisplayCache.addAll(index, list);
            if (strategy.isUseEntireCache()) {
                saveDataToEntireCache(list);
            }
            if (strategy.isActOnDB()) {
                saveDataToDB(list, this.mAssignId);
            }
        }
    }

    public boolean deleteData(DataT data, DataMgrStrategy strategy) {
        List<DataT> tempList = new ArrayList<>(1);
        tempList.add(data);
        boolean modified = this.mDisplayCache.removeAll(tempList);
        if (strategy.isUseEntireCache()) {
            this.mEntireCache.removeAll(tempList);
        }
        if (strategy.isActOnDB()) {
            deleteData(data, strategy);
        }
        return modified;
    }

    public DataT deleteData(int index, DataMgrStrategy strategy) {
        if (index < 0 || index > this.mDisplayCache.size()) {
            return null;
        }
        DataT oldValue = this.mDisplayCache.remove(index);
        if (strategy.isUseEntireCache()) {
            this.mEntireCache.remove(oldValue);
        }
        if (strategy.isActOnDB()) {
            deleteData(oldValue, strategy);
        }
        return oldValue;
    }

    public boolean deleteData(List<DataT> list, DataMgrStrategy strategy) {
        boolean modified = this.mDisplayCache.removeAll(list);
        if (strategy.isUseEntireCache()) {
            this.mEntireCache.removeAll(list);
        }
        if (strategy.isActOnDB()) {
            deleteData(list, strategy);
        }
        return modified;
    }

    public void clearData(DataMgrStrategy strategy) {
        this.mDisplayCache.clear();
        if (strategy.isUseEntireCache()) {
            this.mEntireCache.clear();
        }
        if (strategy.isActOnDB()) {
            clearDB(this.mAssignId);
        }
    }

    public void updateData(DataT datat, DataMgrStrategy strategy) {
    }

    public void updateData(DataT datat, DataT datat2, DataMgrStrategy strategy) {
    }

    public void updateData(List<DataT> list, DataMgrStrategy strategy) {
    }

    public DataT getDataFromDisplayCache(int index, DataMgrStrategy strategy) {
        if (index < 0 || index > this.mDisplayCache.size()) {
            return null;
        }
        return this.mDisplayCache.get(index);
    }
}
