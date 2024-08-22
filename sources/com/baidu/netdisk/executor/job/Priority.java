package com.baidu.netdisk.executor.job;

public class Priority {
    public static final int CONCURRENT = 4;
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final int MIDDLE = 2;
    static final String NoName = "anonymity";
    private static final String TAG = "Priority";
    private boolean allowAdjust;
    private String name;
    private int priorityValue;

    Priority(String name2, int priorityValue2, boolean allowAdjust2) {
        this.priorityValue = 2;
        this.name = name2;
        this.priorityValue = priorityValue2;
        this.allowAdjust = allowAdjust2;
    }

    Priority(int priorityValue2, boolean allowAdjust2) {
        this(NoName, priorityValue2, allowAdjust2);
    }

    Priority(int priorityValue2) {
        this(NoName, priorityValue2, false);
    }

    public String toString() {
        return "Priority name=" + this.name + ", value=" + this.priorityValue;
    }

    /* access modifiers changed from: package-private */
    public int getPriorityValue() {
        return this.priorityValue;
    }

    /* access modifiers changed from: package-private */
    public boolean isAllowAdjust() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void down() {
        if (this.allowAdjust) {
            switch (this.priorityValue) {
                case 2:
                    this.priorityValue = 1;
                    return;
                case 3:
                    this.priorityValue = 2;
                    return;
                case 4:
                    this.priorityValue = 3;
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void up() {
        if (this.allowAdjust) {
            switch (this.priorityValue) {
                case 1:
                    this.priorityValue = 2;
                    return;
                case 2:
                    this.priorityValue = 3;
                    return;
                case 3:
                    this.priorityValue = 4;
                    return;
                default:
                    return;
            }
        }
    }
}
