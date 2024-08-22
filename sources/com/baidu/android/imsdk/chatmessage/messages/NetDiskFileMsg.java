package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.sniffer.ubc.SnifferContants;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetDiskFileMsg extends NormalMsg {
    public static final Parcelable.Creator<NetDiskFileMsg> CREATOR = new Parcelable.Creator<NetDiskFileMsg>() {
        public NetDiskFileMsg createFromParcel(Parcel in) {
            return new NetDiskFileMsg(in);
        }

        public NetDiskFileMsg[] newArray(int size) {
            return new NetDiskFileMsg[size];
        }
    };
    private static final String JSON_KEY_EXT = "ext";
    private static final String JSON_KEY_FILES = "files";
    private static final String JSON_KEY_FILES_COUNT = "files_count";
    private static final String JSON_KEY_SCHEMA = "schema";
    private static final String JSON_KEY_SHARE_URL = "share_url";
    private static final String JSON_KEY_TPL_TYPE = "tpl_type";
    private static final int MAX_DISPLAY_FILE_COUNT = 3;
    private static final String TAG = "NetDiskFileMsg";
    private String ext;
    private NetDiskFile[] files;
    private int filesCount;
    private String schema;
    private String shareUrl;
    private int tplType;

    public static class TplType {
        public static final int MULTIPLE_FILE = 2;
        public static final int SINGLE_FILE = 1;
    }

    public NetDiskFileMsg() {
        setMsgType(55);
    }

    public NetDiskFileMsg(Parcel in) {
        super(in);
        setTplType(in.readInt());
        setShareUrl(in.readString());
        setSchema(in.readString());
        setFilesCount(in.readInt());
        Parcelable[] parcelables = in.readParcelableArray(NetDiskFile.class.getClassLoader());
        if (parcelables != null) {
            setFiles((NetDiskFile[]) Arrays.copyOf(parcelables, parcelables.length, NetDiskFile[].class));
        }
        setExt(in.readString());
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(getTplType());
        dest.writeString(getShareUrl());
        dest.writeString(getSchema());
        dest.writeInt(getFilesCount());
        NetDiskFile[] netDiskFileArr = this.files;
        if (netDiskFileArr != null) {
            dest.writeParcelableArray((Parcelable[]) netDiskFileArr, flags);
        }
        dest.writeString(getExt());
    }

    public int getTplType() {
        return this.tplType;
    }

    public void setTplType(int tplType2) {
        this.tplType = tplType2;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(String schema2) {
        this.schema = schema2;
    }

    public NetDiskFile[] getFiles() {
        return this.files;
    }

    public void setFiles(NetDiskFile[] files2) {
        this.files = files2;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public void setShareUrl(String shareUrl2) {
        this.shareUrl = shareUrl2;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String ext2) {
        this.ext = ext2;
    }

    public int getFilesCount() {
        return this.filesCount;
    }

    public void setFilesCount(int filesCount2) {
        this.filesCount = filesCount2;
    }

    /* access modifiers changed from: protected */
    public boolean parseJsonString() {
        try {
            JSONObject object = new JSONObject(getMsgContent());
            parseAndSetFiles(object);
            if (!isFilesValid()) {
                return false;
            }
            setTplType(object.getInt(JSON_KEY_TPL_TYPE));
            setShareUrl(object.optString("share_url"));
            setSchema(object.getString("schema"));
            setExt(object.optString("ext"));
            return true;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "parseJsonString", e2);
            return false;
        }
    }

    private void parseAndSetFiles(JSONObject dataJsonObject) {
        try {
            setFilesCount(dataJsonObject.optInt(JSON_KEY_FILES_COUNT));
            JSONArray fileArray = new JSONArray(dataJsonObject.getString("files"));
            if (fileArray.length() != 0) {
                ArrayList<NetDiskFile> fileArrayList = new ArrayList<>();
                for (int i2 = 0; i2 < fileArray.length() && fileArrayList.size() <= 3; i2++) {
                    JSONObject fileJsonObject = fileArray.getJSONObject(i2);
                    if (fileJsonObject != null) {
                        NetDiskFile netDiskFile = new NetDiskFile();
                        netDiskFile.setName(fileJsonObject.getString("file_title"));
                        netDiskFile.setCategory(fileJsonObject.getInt("file_category"));
                        netDiskFile.setTimestamp((long) fileJsonObject.getInt("timestamp"));
                        netDiskFile.setSize(fileJsonObject.optString("size"));
                        netDiskFile.setCoverUrl(fileJsonObject.optString("cover_url"));
                        netDiskFile.setFileType(fileJsonObject.optInt(SnifferContants.KEY_FILE_TYPE));
                        fileArrayList.add(netDiskFile);
                    }
                }
                this.files = (NetDiskFile[]) fileArrayList.toArray(new NetDiskFile[fileArrayList.size()]);
            }
        } catch (JSONException e2) {
            LogUtils.e(TAG, "parse json failed:" + e2.getMessage());
        }
    }

    public void onMsgSetComplete() {
        JSONObject object = new JSONObject();
        if (isFilesValid()) {
            try {
                object.put(JSON_KEY_TPL_TYPE, getTplType());
                object.put("schema", getSchema());
                object.put("share_url", getShareUrl());
                object.put(JSON_KEY_FILES_COUNT, getFilesCount());
                if (!TextUtils.isEmpty(getExt())) {
                    object.put("ext", getExt());
                }
                NetDiskFile[] files2 = getFiles();
                JSONArray jsonArray = new JSONArray();
                if (files2 != null) {
                    if (files2.length > 0) {
                        for (NetDiskFile file : files2) {
                            JSONObject fileJsonObject = new JSONObject();
                            fileJsonObject.put("file_title", file.getName());
                            fileJsonObject.put("file_category", file.getCategory());
                            fileJsonObject.put(SnifferContants.KEY_FILE_TYPE, file.getFileType());
                            fileJsonObject.put("size", file.getSize());
                            fileJsonObject.put("timestamp", file.getTimestamp());
                            fileJsonObject.put("cover_url", file.getCoverUrl());
                            jsonArray.put(fileJsonObject);
                        }
                        object.put("files", jsonArray);
                    }
                }
                object.put("files", jsonArray);
            } catch (JSONException e2) {
                LogUtils.e(TAG, "set data failed:" + e2.getMessage());
            }
        } else {
            LogUtils.e(TAG, "NetDiskMsg invalid");
        }
        setMsgContent(object.toString());
    }

    public boolean isFilesValid() {
        NetDiskFile[] netDiskFileArr = this.files;
        return netDiskFileArr != null && netDiskFileArr.length > 0 && this.filesCount >= 0;
    }

    public String getRecommendDescription() {
        NetDiskFile[] netDiskFileArr = this.files;
        if (netDiskFileArr == null || netDiskFileArr.length <= 0 || netDiskFileArr[0] == null) {
            return "";
        }
        return "[网盘文件]" + this.files[0].name;
    }

    public static Parcelable.Creator<NetDiskFileMsg> getCREATOR() {
        return CREATOR;
    }

    public static class NetDiskFile implements Parcelable {
        public static final Parcelable.Creator<NetDiskFile> CREATOR = new Parcelable.Creator<NetDiskFile>() {
            public NetDiskFile createFromParcel(Parcel in) {
                return new NetDiskFile(in);
            }

            public NetDiskFile[] newArray(int size) {
                return new NetDiskFile[size];
            }
        };
        private static final String JSON_KEY_CATEGORY = "file_category";
        private static final String JSON_KEY_COVER_URL = "cover_url";
        private static final String JSON_KEY_FILE_TYPE = "file_type";
        private static final String JSON_KEY_NAME = "file_title";
        private static final String JSON_KEY_SIZE = "size";
        private static final String JSON_KEY_TIMESTAMP = "timestamp";
        int category;
        String coverUrl;
        int fileType;
        String name;
        String size;
        long timestamp;

        public NetDiskFile() {
        }

        public NetDiskFile(Parcel in) {
            setName(in.readString());
            setSize(in.readString());
            setCategory(in.readInt());
            setFileType(in.readInt());
            setTimestamp((long) in.readInt());
            setCoverUrl(in.readString());
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getSize() {
            return this.size;
        }

        public void setSize(String size2) {
            this.size = size2;
        }

        public int getCategory() {
            int i2 = this.category;
            if (i2 >= 0 && i2 <= 11) {
                return i2;
            }
            LogUtils.e("NetDiskFile", "category 类型异常，当前为: " + this.category + " 修改为默认值 1");
            return 1;
        }

        public void setCategory(int category2) {
            this.category = category2;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long timestamp2) {
            this.timestamp = timestamp2;
        }

        public String getCoverUrl() {
            return this.coverUrl;
        }

        public void setCoverUrl(String coverUrl2) {
            this.coverUrl = coverUrl2;
        }

        public int getFileType() {
            return this.fileType;
        }

        public void setFileType(int fileType2) {
            this.fileType = fileType2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(getName());
            dest.writeString(getSize());
            dest.writeInt(getCategory());
            dest.writeInt(getFileType());
            dest.writeInt((int) getTimestamp());
            dest.writeString(getCoverUrl());
        }

        public static Parcelable.Creator<NetDiskFile> getCREATOR() {
            return CREATOR;
        }
    }
}
