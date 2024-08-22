package com.baidu.searchbox.newtips.data;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.newtips.NewTipsDataManager;
import com.baidu.searchbox.newtips.NewTipsSourceProvider;
import com.baidu.searchbox.newtips.type.NewTipsNodeID;
import com.baidu.searchbox.newtips.type.NewTipsSourceID;
import java.util.ArrayList;
import java.util.List;

public class NewTipsSource {
    public static final int CHANGE_NEW = 1;
    public static final int CHANGE_NOT_NEW = -1;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int NO_CHANGE = 0;
    private static final String TAG = "NewTipsSrc";
    private NewTipsSourceID mID;
    private int mLastNewTipsCount;
    private String mLastNewTipsTxt;
    private List<NewTipsNodeID> mNodeList;

    public NewTipsSource(NewTipsSourceID id) {
        this.mID = id;
        NewTipsSourceProvider newTipsSrcProvider = NewTipsDataManager.getNewTipsSrcProvider(id);
        if (newTipsSrcProvider != null) {
            this.mLastNewTipsCount = newTipsSrcProvider.queryNewTipsCount();
            this.mLastNewTipsTxt = newTipsSrcProvider.queryNewTipsTxt();
        }
    }

    public void addNode(NewTipsNodeID nodeID) {
        if (this.mNodeList == null) {
            this.mNodeList = new ArrayList();
        }
        this.mNodeList.add(nodeID);
    }

    public int getResetFlag() {
        int i2;
        int result = 0;
        NewTipsSourceProvider newTipsSrcProvider = NewTipsDataManager.getNewTipsSrcProvider(this.mID);
        String newTipsTxt = newTipsSrcProvider.queryNewTipsTxt();
        if (!TextUtils.equals(this.mLastNewTipsTxt, newTipsTxt)) {
            if (TextUtils.isEmpty(this.mLastNewTipsTxt)) {
                result = -1;
            } else {
                result = 1;
            }
        }
        this.mLastNewTipsTxt = newTipsTxt;
        int curNewTipsCount = newTipsSrcProvider.queryNewTipsCount();
        if (result == 0 && curNewTipsCount != (i2 = this.mLastNewTipsCount)) {
            if (curNewTipsCount > i2) {
                result = 1;
            } else if (curNewTipsCount <= 0) {
                result = -1;
            }
        }
        this.mLastNewTipsCount = curNewTipsCount;
        return result;
    }

    public boolean isNew() {
        NewTipsSourceProvider newTipsSrcProvider = NewTipsDataManager.getNewTipsSrcProvider(this.mID);
        return newTipsSrcProvider.queryNewTipsCount() > 0 || !TextUtils.isEmpty(newTipsSrcProvider.queryNewTipsTxt());
    }

    public boolean isNodeListEmpty() {
        List<NewTipsNodeID> list = this.mNodeList;
        return list == null || list.isEmpty();
    }

    public List<NewTipsNodeID> getNodeList() {
        return this.mNodeList;
    }

    public NewTipsSourceID getID() {
        return this.mID;
    }

    public String toString() {
        StringBuilder strBuilder = new StringBuilder(TAG);
        strBuilder.append("#mID=").append(this.mID).append(", mNodeList=").append(this.mNodeList);
        return strBuilder.toString();
    }
}
