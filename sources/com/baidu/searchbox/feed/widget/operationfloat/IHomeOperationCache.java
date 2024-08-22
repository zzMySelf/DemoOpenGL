package com.baidu.searchbox.feed.widget.operationfloat;

public interface IHomeOperationCache {
    int getBackShowCount();

    long getFirstShowTime();

    long getGuideBannerLastTime();

    boolean getIsNewUser();

    long getLastCloseTime();

    long getLastShowTime();

    long getNextShowTime();

    int getNoClickShowDays();

    String getOperationType();

    int getTodayCloseCount();

    int getTotalCloseCount();

    boolean hasBannerShown();

    boolean isExistForever();

    void reset();

    void saveBackShowCount(int i2);

    void saveFirstShowTime(long j2);

    void saveGuideBannerLastTime(long j2);

    void saveHasBannerShown(boolean z);

    void saveIsExistForever(boolean z);

    void saveLastCloseTime(long j2);

    void saveLastShowTime(long j2);

    void saveNextShowTime(long j2);

    void saveNoClickShowDays(int i2);

    void saveOperationType(String str);

    void saveTodayCloseCount(int i2);

    void saveTotalCloseCount(int i2);

    void saveUserInfo(boolean z);

    public static class HomeOptEmpty implements IHomeOperationCache {
        public String getOperationType() {
            return null;
        }

        public void saveOperationType(String type) {
        }

        public void saveFirstShowTime(long time) {
        }

        public long getFirstShowTime() {
            return 0;
        }

        public void saveTotalCloseCount(int count) {
        }

        public int getTotalCloseCount() {
            return 0;
        }

        public void saveTodayCloseCount(int count) {
        }

        public int getTodayCloseCount() {
            return 0;
        }

        public void saveUserInfo(boolean isNewUser) {
        }

        public boolean getIsNewUser() {
            return false;
        }

        public void saveLastShowTime(long lastShowTime) {
        }

        public long getLastShowTime() {
            return 0;
        }

        public void saveNoClickShowDays(int days) {
        }

        public int getNoClickShowDays() {
            return 0;
        }

        public void saveNextShowTime(long time) {
        }

        public long getNextShowTime() {
            return 0;
        }

        public void saveIsExistForever(boolean exist) {
        }

        public boolean isExistForever() {
            return false;
        }

        public int getBackShowCount() {
            return 0;
        }

        public void saveBackShowCount(int count) {
        }

        public void saveLastCloseTime(long time) {
        }

        public long getLastCloseTime() {
            return 0;
        }

        public void saveHasBannerShown(boolean hasShown) {
        }

        public boolean hasBannerShown() {
            return false;
        }

        public void saveGuideBannerLastTime(long time) {
        }

        public long getGuideBannerLastTime() {
            return 0;
        }

        public void reset() {
        }
    }
}
