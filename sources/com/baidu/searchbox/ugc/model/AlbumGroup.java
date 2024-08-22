package com.baidu.searchbox.ugc.model;

public class AlbumGroup implements Comparable<Object> {
    protected String mBucketID;
    protected String mBucketName = "";
    protected long mLatestAddedDate;
    protected long mSize;
    protected String mUriStr;

    public String getBucketID() {
        return this.mBucketID;
    }

    public void setBucketID(String bucketID) {
        this.mBucketID = bucketID;
    }

    public String getBucketName() {
        return this.mBucketName;
    }

    public void setBucketName(String bucketName) {
        this.mBucketName = bucketName;
    }

    public long getLatestAddedDate() {
        return this.mLatestAddedDate;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setSize(long size) {
        this.mSize = size;
    }

    public String getUriStr() {
        return this.mUriStr;
    }

    public void setUriStr(String uriStr) {
        this.mUriStr = uriStr;
    }

    public int compareTo(Object obj) {
        return Long.valueOf(((AlbumGroup) obj).getLatestAddedDate()).compareTo(Long.valueOf(this.mLatestAddedDate));
    }
}
