package com.baidu.swan.card.storage;

public class FileInfo {
    private String mDigest;
    private long mFileSavedTime;
    private String mPath;
    private long mSize;

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setSize(long size) {
        this.mSize = size;
    }

    public String getDigest() {
        return this.mDigest;
    }

    public void setDigest(String digest) {
        this.mDigest = digest;
    }

    public long getCreatedTime() {
        return this.mFileSavedTime;
    }

    public void setCreatedTime(long fileSavedTime) {
        this.mFileSavedTime = fileSavedTime;
    }
}
