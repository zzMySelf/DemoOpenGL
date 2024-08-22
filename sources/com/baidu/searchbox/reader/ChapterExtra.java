package com.baidu.searchbox.reader;

public class ChapterExtra {
    private String mCid;
    private String mContentEndOffset;
    private String mContentStartOffset;
    private String mDataPath;
    private String mEncrypt;
    private String mModelSite;
    private String mUrl;

    public ChapterExtra(String cid, String start, String end, String dataPath, String url, String encrypt, String modelSite) {
        this.mCid = cid;
        this.mContentStartOffset = start;
        this.mContentEndOffset = end;
        this.mDataPath = dataPath;
        this.mUrl = url;
        this.mEncrypt = encrypt;
        this.mModelSite = modelSite;
    }

    public String getCid() {
        return this.mCid;
    }

    public void setCid(String mCid2) {
        this.mCid = mCid2;
    }

    public String getContentStartOffset() {
        return this.mContentStartOffset;
    }

    public void setContentStartOffset(String contentStartOffset) {
        this.mContentStartOffset = contentStartOffset;
    }

    public String getContentEndOffset() {
        return this.mContentEndOffset;
    }

    public void setContentEndOffset(String contentEndOffset) {
        this.mContentEndOffset = contentEndOffset;
    }

    public String getDataPath() {
        return this.mDataPath;
    }

    public void setDataPath(String dataPath) {
        this.mDataPath = dataPath;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getEncrypt() {
        return this.mEncrypt;
    }

    public void setEncrypt(String encrypt) {
        this.mEncrypt = encrypt;
    }

    public String getModelSite() {
        return this.mModelSite;
    }

    public void setModelSite(String modelSite) {
        this.mModelSite = modelSite;
    }
}
