package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;

public class SwanTaskDeadEvent implements Parcelable {
    public static final Parcelable.Creator<SwanTaskDeadEvent> CREATOR = new Parcelable.Creator<SwanTaskDeadEvent>() {
        public SwanTaskDeadEvent createFromParcel(Parcel source) {
            return new SwanTaskDeadEvent(source);
        }

        public SwanTaskDeadEvent[] newArray(int size) {
            return new SwanTaskDeadEvent[size];
        }
    };
    private static final char SEPARATOR = '#';
    private String appId;
    private SparseArray<String[]> historyCache;
    private String pageScheme;
    private ArrayList<Integer> stackList;
    private int taskId;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.appId);
        dest.writeInt(this.taskId);
        dest.writeString(this.pageScheme);
        dest.writeList(this.stackList);
        dest.writeSparseArray(this.historyCache);
    }

    public SwanTaskDeadEvent(String appId2, int taskId2, String pageScheme2, ArrayList<Integer> stackList2) {
        this.appId = appId2;
        this.taskId = taskId2;
        this.pageScheme = pageScheme2;
        this.stackList = stackList2;
    }

    protected SwanTaskDeadEvent(Parcel in) {
        this.appId = in.readString();
        this.taskId = in.readInt();
        this.pageScheme = in.readString();
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.stackList = arrayList;
        in.readList(arrayList, Integer.class.getClassLoader());
        this.historyCache = in.readSparseArray(String[].class.getClassLoader());
    }

    public String getAppId() {
        return this.appId;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String getPageScheme() {
        return this.pageScheme;
    }

    public ArrayList<Integer> getStackList() {
        return this.stackList;
    }

    public SparseArray<SwanTaskDeadEvent> getHistoryCache() {
        if (this.historyCache == null) {
            return null;
        }
        SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
        for (int i2 = 0; i2 < this.historyCache.size(); i2++) {
            sparseArray.put(this.historyCache.keyAt(i2), restoreObject(this.historyCache.valueAt(i2)));
        }
        return sparseArray;
    }

    public void setHistoryCache(SparseArray<SwanTaskDeadEvent> historyCache2) {
        SparseArray<String[]> sparseArray = new SparseArray<>();
        if (historyCache2 != null) {
            for (int i2 = 0; i2 < historyCache2.size(); i2++) {
                if (historyCache2.valueAt(i2) != null) {
                    sparseArray.put(historyCache2.keyAt(i2), historyCache2.valueAt(i2).transformToArray());
                }
            }
        }
        this.historyCache = sparseArray;
    }

    private String[] transformToArray() {
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> arrayList = this.stackList;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                builder.append(this.stackList.get(i2));
                if (i2 < size - 1) {
                    builder.append('#');
                }
            }
        }
        return new String[]{getAppId(), getPageScheme(), builder.toString()};
    }

    private static SwanTaskDeadEvent restoreObject(String[] array) {
        if (array == null || array.length != 3) {
            return null;
        }
        ArrayList<Integer> taskList = new ArrayList<>();
        if (array[2] != null) {
            for (String taskString : array[2].split(String.valueOf('#'))) {
                if (!TextUtils.isEmpty(taskString) && TextUtils.isDigitsOnly(taskString)) {
                    taskList.add(Integer.valueOf(Integer.parseInt(taskString)));
                }
            }
        }
        return new SwanTaskDeadEvent(array[0], -1, array[1], taskList);
    }
}
