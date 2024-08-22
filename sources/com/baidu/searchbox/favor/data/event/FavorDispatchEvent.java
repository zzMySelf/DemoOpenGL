package com.baidu.searchbox.favor.data.event;

import com.baidu.searchbox.favor.data.FavorModel;
import java.util.List;

public class FavorDispatchEvent {
    public int action;
    public String event;
    public FavorModel extra;
    public List<FavorModel> extraList;

    public interface Action {
        public static final int ADD_FAVOR_BEFORE = 1;
        public static final int ADD_FAVOR_SUCCESS = 2;
        public static final int BATCH_DEL_FAVOR_BEFORE = 4;
        public static final int BATCH_DEL_FAVOR_SUCCESS = 6;
        public static final int DEL_FAVOR_BEFORE = 3;
        public static final int DEL_FAVOR_SUCCESS = 5;
        public static final int FAVOR_SYNC_EVENT_FINISH = 7;
    }

    public interface Event {
        public static final String ADD_FAVOR = "addFavor";
        public static final String BATCH_DEL_FAVOR = "batchDelFavor";
        public static final String DEL_FAVOR = "delFavor";
        public static final String FAVOR_SYNC_EVENT = "favorSyncEvent";
    }

    public FavorDispatchEvent(String event2, int action2) {
        this.event = event2;
        this.action = action2;
    }

    public FavorDispatchEvent(String event2, int action2, FavorModel extra2) {
        this.event = event2;
        this.action = action2;
        this.extra = extra2;
    }

    public FavorDispatchEvent(String event2, int action2, List<FavorModel> extra2) {
        this.event = event2;
        this.action = action2;
        this.extraList = extra2;
    }
}
