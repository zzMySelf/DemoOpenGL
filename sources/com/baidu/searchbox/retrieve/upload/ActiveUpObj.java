package com.baidu.searchbox.retrieve.upload;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ActiveUpObj {
    private String mDataId;
    private String mFileID;
    private String mFileMeta;
    private String mFileType = "1";
    private List<String> mSpace;
    private String mType;

    public ActiveUpObj(String type, String dataId, List<String> space, String fileMeta) {
        this.mType = type;
        this.mDataId = dataId;
        this.mSpace = space;
        this.mFileMeta = fileMeta;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public String getDataId() {
        return this.mDataId;
    }

    public void setDataId(String dataId) {
        this.mDataId = dataId;
    }

    public List<String> getSpace() {
        return this.mSpace;
    }

    public void setSpace(List<String> space) {
        this.mSpace = space;
    }

    public String getFileMeta() {
        return this.mFileMeta;
    }

    public void setFileMeta(String fileMeta) {
        this.mFileMeta = fileMeta;
    }

    public String getFileID() {
        return this.mFileID;
    }

    public void setFileID(String fileID) {
        this.mFileID = fileID;
    }

    public String getFileType() {
        return this.mFileType;
    }

    public void setFileType(String fileType) {
        this.mFileType = fileType;
    }

    public String toString() {
        return "ActiveUpObj{mType='" + this.mType + '\'' + ", mDataId='" + this.mDataId + '\'' + ", mSpace='" + this.mSpace.toString() + '\'' + ", mFileId'" + this.mFileID + '\'' + ", mFileType'" + this.mFileType + '\'' + ", mFileMeta='" + this.mFileMeta + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
