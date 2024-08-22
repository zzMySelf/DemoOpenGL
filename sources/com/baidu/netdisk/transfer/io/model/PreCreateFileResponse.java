package com.baidu.netdisk.transfer.io.model;

import com.baidu.netdisk.network.response.Response;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PreCreateFileResponse extends Response {
    public static final int RETURN_TYPE_RAPIDUPLOAD = 2;
    @SerializedName("block_list")
    public List<Integer> mBlockList;
    @SerializedName("info")
    public RapidUploadInfo mInfo;
    public String mRawString;
    @SerializedName("return_type")
    public int mReturnType;
    @SerializedName("uploadid")
    public String mUploadId;
    @SerializedName("uploadsign")
    public String mUploadSign;
}
