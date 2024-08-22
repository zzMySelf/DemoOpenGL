package com.baidu.livesdk.api.service;

import java.util.List;

public interface LiveDataRequest {

    public interface PageDataReceiver {
        void onReceiver(PageData pageData);
    }

    void queryPageData(String str, Integer num, Integer num2, PageDataReceiver pageDataReceiver);

    void release();

    public static class PageData {
        String errno;
        List<LiveData> liveDatas;
        String message;
        PageInfo pageInfo;

        public PageData(String errno2, String message2) {
            this.errno = errno2;
            this.message = message2;
        }

        public PageData(String errno2, List<LiveData> liveDatas2, PageInfo pageInfo2) {
            this.errno = errno2;
            this.liveDatas = liveDatas2;
            this.pageInfo = pageInfo2;
        }

        public String getErrno() {
            return this.errno;
        }

        public void setErrno(String errno2) {
            this.errno = errno2;
        }

        public List<LiveData> getLiveDatas() {
            return this.liveDatas;
        }

        public void setLiveDatas(List<LiveData> liveDatas2) {
            this.liveDatas = liveDatas2;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message2) {
            this.message = message2;
        }

        public PageInfo getPageInfo() {
            return this.pageInfo;
        }

        public void setPageInfo(PageInfo pageInfo2) {
            this.pageInfo = pageInfo2;
        }
    }

    public static class LiveData {
        String content;
        String roomId;

        public LiveData(String roomId2, String content2) {
            this.roomId = roomId2;
            this.content = content2;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public void setRoomId(String roomId2) {
            this.roomId = roomId2;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content2) {
            this.content = content2;
        }
    }

    public static class PageInfo {
        int page;
        int pageSize;

        public PageInfo(int page2, int pageSize2) {
            this.page = page2;
            this.pageSize = pageSize2;
        }

        public int getPage() {
            return this.page;
        }

        public void setPage(int page2) {
            this.page = page2;
        }

        public int getPageSize() {
            return this.pageSize;
        }

        public void setPageSize(int pageSize2) {
            this.pageSize = pageSize2;
        }
    }
}
