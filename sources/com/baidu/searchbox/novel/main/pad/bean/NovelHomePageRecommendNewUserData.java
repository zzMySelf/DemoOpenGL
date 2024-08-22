package com.baidu.searchbox.novel.main.pad.bean;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NovelHomePageRecommendNewUserData extends NovelHomePageRecommendBaseData {
    private List<BookData> bookDataList;
    private String buttonCmd;
    private String moduleTitle;

    public int getType() {
        return 8;
    }

    public List<BookData> getBookDataList() {
        return this.bookDataList;
    }

    public BookData getBookData(int index) {
        List<BookData> list = this.bookDataList;
        if (list == null || index < 0 || index >= list.size()) {
            return null;
        }
        return this.bookDataList.get(index);
    }

    public String getModuleTitle() {
        return this.moduleTitle;
    }

    public String getButtonCmd() {
        return this.buttonCmd;
    }

    public static NovelHomePageRecommendBaseData fromJson(JSONObject jsonObject) {
        NovelHomePageRecommendNewUserData data = null;
        if (jsonObject != null) {
            data = new NovelHomePageRecommendNewUserData();
            data.moduleTitle = jsonObject.optString("common_name");
            JSONArray array = jsonObject.optJSONArray("novelList");
            if (array != null) {
                data.bookDataList = new ArrayList();
                for (int index = 0; index < array.length(); index++) {
                    JSONObject bookJson = array.optJSONObject(index);
                    if (bookJson != null) {
                        BookData bookData = new BookData();
                        bookData.setCmd(bookJson.optString("cmd"));
                        bookData.setTitle(bookJson.optString("title"));
                        bookData.setCoverUrl(bookJson.optString("logo"));
                        data.bookDataList.add(bookData);
                    }
                }
            }
        }
        return data;
    }

    public static class BookData {
        private String cmd;
        private String coverUrl;
        private String title;

        public void setCoverUrl(String coverUrl2) {
            this.coverUrl = coverUrl2;
        }

        public void setCmd(String cmd2) {
            this.cmd = cmd2;
        }

        public void setTitle(String title2) {
            this.title = title2;
        }

        public String getCoverUrl() {
            return this.coverUrl;
        }

        public String getCmd() {
            return this.cmd;
        }

        public String getTitle() {
            return this.title;
        }
    }
}
