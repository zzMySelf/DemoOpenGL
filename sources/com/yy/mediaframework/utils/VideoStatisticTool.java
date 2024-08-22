package com.yy.mediaframework.utils;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import java.util.ArrayList;
import java.util.List;

public class VideoStatisticTool {
    public static final int TIME = 60;
    private boolean isDebug = false;
    private boolean isStallingMode = false;
    private List<Integer> mAverageList = new ArrayList();
    private List<Integer> mCountList = new ArrayList();
    private int mCounter = 0;
    private long mCurSample = 0;
    private long mCurrentTime = 0;
    private long mLastSample = 0;
    private long mLastTime = 0;
    private List<Integer> mMaxList = new ArrayList();
    private List<Integer> mMinList = new ArrayList();
    private VideoStatisticResult mResult = new VideoStatisticResult();
    private List<Integer> mSumList = new ArrayList();
    private int max = -1;
    private int min = -1;
    private int sum = 0;

    public synchronized void triggerStatistic(int deal) {
        if (this.min == -1 && this.max == -1) {
            this.min = deal;
            this.max = deal;
        }
        this.mCounter++;
        int i2 = this.max;
        if (i2 < deal) {
            i2 = deal;
        }
        this.max = i2;
        int i3 = this.min;
        if (i3 >= deal) {
            i3 = deal;
        }
        this.min = i3;
        this.sum += deal;
    }

    public synchronized void triggerStatistic() {
        this.mCurrentTime = System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        this.mCurSample = currentTimeMillis;
        long j2 = this.mLastTime;
        if (j2 != 0) {
            long j3 = this.mLastSample;
            if (j3 != 0) {
                int deal = (int) (currentTimeMillis - j3);
                if (this.min == -1 && this.max == -1) {
                    this.min = deal;
                    this.max = deal;
                }
                int i2 = this.mCounter + 1;
                this.mCounter = i2;
                int i3 = this.max;
                if (i3 < deal) {
                    i3 = deal;
                }
                this.max = i3;
                int i4 = this.min;
                if (i4 >= deal) {
                    i4 = deal;
                }
                this.min = i4;
                this.sum += deal;
                if (this.mCurrentTime - j2 >= 1000) {
                    this.mCountList.add(Integer.valueOf(i2));
                    this.mAverageList.add(Integer.valueOf(this.sum / this.mCounter));
                    this.mMaxList.add(Integer.valueOf(this.max));
                    this.mMinList.add(Integer.valueOf(this.min));
                    this.mSumList.add(Integer.valueOf(this.sum));
                    this.mLastTime = this.mCurrentTime;
                    this.mLastSample = this.mCurSample;
                    this.mCounter = 0;
                    this.max = -1;
                    this.sum = 0;
                    this.min = -1;
                    return;
                }
                this.mLastSample = currentTimeMillis;
                return;
            }
        }
        this.mLastSample = System.currentTimeMillis();
        this.mLastTime = System.currentTimeMillis();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void triggerStatisticCalcBySecond(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008c }
            r7.mCurrentTime = r0     // Catch:{ all -> 0x008c }
            long r2 = r7.mLastTime     // Catch:{ all -> 0x008c }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0017
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008c }
            r7.mLastTime = r0     // Catch:{ all -> 0x008c }
            monitor-exit(r7)
            return
        L_0x0017:
            int r4 = r7.min     // Catch:{ all -> 0x008c }
            r5 = -1
            if (r4 != r5) goto L_0x0024
            int r4 = r7.max     // Catch:{ all -> 0x008c }
            if (r4 != r5) goto L_0x0024
            r7.min = r8     // Catch:{ all -> 0x008c }
            r7.max = r8     // Catch:{ all -> 0x008c }
        L_0x0024:
            int r4 = r7.mCounter     // Catch:{ all -> 0x008c }
            int r4 = r4 + 1
            r7.mCounter = r4     // Catch:{ all -> 0x008c }
            int r6 = r7.max     // Catch:{ all -> 0x008c }
            if (r6 >= r8) goto L_0x002f
            r6 = r8
        L_0x002f:
            r7.max = r6     // Catch:{ all -> 0x008c }
            int r6 = r7.min     // Catch:{ all -> 0x008c }
            if (r6 >= r8) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r6 = r8
        L_0x0037:
            r7.min = r6     // Catch:{ all -> 0x008c }
            int r6 = r7.sum     // Catch:{ all -> 0x008c }
            int r6 = r6 + r8
            r7.sum = r6     // Catch:{ all -> 0x008c }
            long r0 = r0 - r2
            r2 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x008a
            java.util.List<java.lang.Integer> r0 = r7.mCountList     // Catch:{ all -> 0x008c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x008c }
            r0.add(r1)     // Catch:{ all -> 0x008c }
            java.util.List<java.lang.Integer> r0 = r7.mAverageList     // Catch:{ all -> 0x008c }
            int r1 = r7.sum     // Catch:{ all -> 0x008c }
            int r2 = r7.mCounter     // Catch:{ all -> 0x008c }
            int r1 = r1 / r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008c }
            r0.add(r1)     // Catch:{ all -> 0x008c }
            java.util.List<java.lang.Integer> r0 = r7.mMaxList     // Catch:{ all -> 0x008c }
            int r1 = r7.max     // Catch:{ all -> 0x008c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008c }
            r0.add(r1)     // Catch:{ all -> 0x008c }
            java.util.List<java.lang.Integer> r0 = r7.mMinList     // Catch:{ all -> 0x008c }
            int r1 = r7.min     // Catch:{ all -> 0x008c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008c }
            r0.add(r1)     // Catch:{ all -> 0x008c }
            java.util.List<java.lang.Integer> r0 = r7.mSumList     // Catch:{ all -> 0x008c }
            int r1 = r7.sum     // Catch:{ all -> 0x008c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008c }
            r0.add(r1)     // Catch:{ all -> 0x008c }
            r0 = 0
            r7.mCounter = r0     // Catch:{ all -> 0x008c }
            long r1 = r7.mCurrentTime     // Catch:{ all -> 0x008c }
            r7.mLastTime = r1     // Catch:{ all -> 0x008c }
            r7.max = r5     // Catch:{ all -> 0x008c }
            r7.sum = r0     // Catch:{ all -> 0x008c }
            r7.min = r5     // Catch:{ all -> 0x008c }
        L_0x008a:
            monitor-exit(r7)
            return
        L_0x008c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mediaframework.utils.VideoStatisticTool.triggerStatisticCalcBySecond(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void triggerStatisticCalcStalling(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 1
            r7.isStallingMode = r0     // Catch:{ all -> 0x008e }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008e }
            r7.mCurrentTime = r1     // Catch:{ all -> 0x008e }
            long r3 = r7.mLastTime     // Catch:{ all -> 0x008e }
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x001a
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008e }
            r7.mLastTime = r0     // Catch:{ all -> 0x008e }
            monitor-exit(r7)
            return
        L_0x001a:
            int r5 = r7.min     // Catch:{ all -> 0x008e }
            r6 = -1
            if (r5 != r6) goto L_0x0027
            int r5 = r7.max     // Catch:{ all -> 0x008e }
            if (r5 != r6) goto L_0x0027
            r7.min = r8     // Catch:{ all -> 0x008e }
            r7.max = r8     // Catch:{ all -> 0x008e }
        L_0x0027:
            int r5 = r7.mCounter     // Catch:{ all -> 0x008e }
            int r5 = r5 + r0
            r7.mCounter = r5     // Catch:{ all -> 0x008e }
            int r0 = r7.max     // Catch:{ all -> 0x008e }
            if (r0 >= r8) goto L_0x0031
            r0 = r8
        L_0x0031:
            r7.max = r0     // Catch:{ all -> 0x008e }
            int r0 = r7.min     // Catch:{ all -> 0x008e }
            if (r0 >= r8) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r0 = r8
        L_0x0039:
            r7.min = r0     // Catch:{ all -> 0x008e }
            int r0 = r7.sum     // Catch:{ all -> 0x008e }
            int r0 = r0 + r8
            r7.sum = r0     // Catch:{ all -> 0x008e }
            long r1 = r1 - r3
            r3 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x008c
            java.util.List<java.lang.Integer> r0 = r7.mCountList     // Catch:{ all -> 0x008e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x008e }
            r0.add(r1)     // Catch:{ all -> 0x008e }
            java.util.List<java.lang.Integer> r0 = r7.mAverageList     // Catch:{ all -> 0x008e }
            int r1 = r7.sum     // Catch:{ all -> 0x008e }
            int r2 = r7.mCounter     // Catch:{ all -> 0x008e }
            int r1 = r1 / r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008e }
            r0.add(r1)     // Catch:{ all -> 0x008e }
            java.util.List<java.lang.Integer> r0 = r7.mMaxList     // Catch:{ all -> 0x008e }
            int r1 = r7.max     // Catch:{ all -> 0x008e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008e }
            r0.add(r1)     // Catch:{ all -> 0x008e }
            java.util.List<java.lang.Integer> r0 = r7.mMinList     // Catch:{ all -> 0x008e }
            int r1 = r7.min     // Catch:{ all -> 0x008e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008e }
            r0.add(r1)     // Catch:{ all -> 0x008e }
            java.util.List<java.lang.Integer> r0 = r7.mSumList     // Catch:{ all -> 0x008e }
            int r1 = r7.sum     // Catch:{ all -> 0x008e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008e }
            r0.add(r1)     // Catch:{ all -> 0x008e }
            r0 = 0
            r7.mCounter = r0     // Catch:{ all -> 0x008e }
            long r1 = r7.mCurrentTime     // Catch:{ all -> 0x008e }
            r7.mLastTime = r1     // Catch:{ all -> 0x008e }
            r7.max = r6     // Catch:{ all -> 0x008e }
            r7.sum = r0     // Catch:{ all -> 0x008e }
            r7.min = r6     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r7)
            return
        L_0x008e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mediaframework.utils.VideoStatisticTool.triggerStatisticCalcStalling(int):void");
    }

    public class VideoStatisticResult {
        public boolean isValid = false;
        public int maxDeal = -1;
        public int meanCount = 0;
        public int meanDeal = -1;
        public int minDeal = -1;
        public int other = -1;
        public int sumDeal = 0;

        public VideoStatisticResult() {
        }
    }

    public synchronized VideoStatisticResult getStatisticResult() {
        return this.mResult;
    }

    private void printListInfo(List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        if (list != null) {
            String str = " ";
            for (int i2 = 0; i2 < list.size(); i2++) {
                str = str + list.get(i2) + ":" + list2.get(i2) + ":" + list3.get(i2) + ":" + list4.get(i2) + ", ";
            }
            YMFLog.info(this, "[CCapture]", "listInfo:[" + str + RhetoricalTagUtilKt.TAG_END_SYMBOL);
        }
    }

    public static class StallingModel {
        private static final float alpha = 0.999f;
        private static final float k = 3.5E-4f;
        private static final int threshold = 500;

        public static int maxOut(int data, int threshold2) {
            if (data >= threshold2) {
                return data;
            }
            return 0;
        }

        public static int sum(List<Integer> list) {
            int sum = 0;
            for (Integer intValue : list) {
                sum += intValue.intValue();
            }
            return sum;
        }

        public static void filterGte1sData(List<Integer> in, List<Integer> out) {
            for (Integer intValue : in) {
                int i2 = intValue.intValue();
                if (maxOut(i2, 1000) > 0) {
                    out.add(Integer.valueOf(i2));
                }
            }
        }

        public static void filterStallingData(List<Integer> in, List<Integer> out) {
            for (Integer intValue : in) {
                int i2 = intValue.intValue();
                if (maxOut(i2, 500) > 0) {
                    out.add(Integer.valueOf(i2));
                }
            }
        }

        public static int calcStallingRate(List<Integer> inList) {
            List<Integer> list = inList;
            if (list == null || inList.size() <= 0) {
                return 0;
            }
            List<Integer> stallingList = new ArrayList<>();
            List<Integer> gte1sStallingList = new ArrayList<>();
            double stallingLength = (double) inList.size();
            filterStallingData(list, stallingList);
            filterGte1sData(list, gte1sStallingList);
            double stallingDuration = (double) sum(stallingList);
            double stallingCount = (double) stallingList.size();
            return (int) ((1.0d - Math.exp(((-3.499999875202775E-4d * stallingCount) * stallingDuration) * (((0.9990000128746033d * stallingDuration) / (((stallingLength - ((double) gte1sStallingList.size())) * 1000.0d) + ((double) sum(gte1sStallingList)))) + ((9.999871253967285E-4d * stallingCount) / stallingLength)))) * 100.0d);
        }
    }

    public synchronized void flush() {
        this.mResult.meanDeal = -1;
        this.mResult.maxDeal = this.max;
        this.mResult.minDeal = this.min;
        this.mResult.meanCount = this.mCounter;
        int i2 = this.mCounter;
        if (i2 > 0) {
            this.mResult.meanDeal = this.sum / i2;
        }
        this.max = -1;
        this.min = -1;
        this.sum = 0;
        this.mCounter = 0;
        List<Integer> list = this.mAverageList;
        if (list != null && list.size() > 0) {
            this.mResult.meanDeal = CommonUtil.calcListMean(this.mAverageList);
            this.mAverageList.clear();
        }
        List<Integer> list2 = this.mMaxList;
        if (list2 != null && list2.size() > 0) {
            this.mResult.maxDeal = CommonUtil.calcListMax(this.mMaxList);
            if (this.isStallingMode) {
                this.mResult.other = StallingModel.calcStallingRate(this.mMaxList);
                if (this.mResult.other > 0) {
                    YMFLog.info(this, "[CCapture]", "mResult.other:" + this.mResult.other + "MaxListInfo:" + this.mMaxList);
                }
            }
            this.mMaxList.clear();
        }
        List<Integer> list3 = this.mMinList;
        if (list3 != null && list3.size() > 0) {
            this.mResult.minDeal = CommonUtil.calcListMin(this.mMinList);
            this.mMinList.clear();
        }
        List<Integer> list4 = this.mCountList;
        if (list4 != null && list4.size() > 0) {
            this.mResult.meanCount = CommonUtil.calcListMean(this.mCountList);
            this.mCountList.clear();
        }
        List<Integer> list5 = this.mSumList;
        if (list5 != null && list5.size() > 0) {
            this.mResult.sumDeal = CommonUtil.calcListSum(this.mSumList);
            this.mSumList.clear();
        }
    }
}
