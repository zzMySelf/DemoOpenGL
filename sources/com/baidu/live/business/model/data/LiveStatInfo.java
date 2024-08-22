package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.minivideo.util.MiniVideoStaisticUtils;
import com.baidu.searchbox.qrcode.Res;
import org.json.JSONObject;

public class LiveStatInfo implements Parcelable {
    public static final Parcelable.Creator<LiveStatInfo> CREATOR = new Parcelable.Creator<LiveStatInfo>() {
        public LiveStatInfo createFromParcel(Parcel in) {
            return new LiveStatInfo(in);
        }

        public LiveStatInfo[] newArray(int size) {
            return new LiveStatInfo[size];
        }
    };
    public boolean isYY;
    public String sid;
    public String ssid;
    public int templateId;
    public String tpl;
    public String yyuid;

    public LiveStatInfo() {
    }

    public LiveStatInfo(Parcel in) {
        this.isYY = in.readByte() == 3;
        this.yyuid = in.readString();
        this.sid = in.readString();
        this.ssid = in.readString();
        this.tpl = in.readString();
        this.templateId = in.readInt();
    }

    public void parserJson(JSONObject jsonObject) {
        if (jsonObject != null) {
            this.isYY = jsonObject.optInt(MiniVideoStaisticUtils.UBC_LIVE_TYPE) == 3;
            this.yyuid = jsonObject.optString("yyuid", "");
            this.sid = jsonObject.optString("sid", "");
            this.ssid = jsonObject.optString(Res.id.ssid, "");
            this.tpl = jsonObject.optString("tpl", "");
            this.templateId = jsonObject.optInt("template_id", 0);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (this.isYY ? 3 : 0));
        dest.writeString(this.yyuid);
        dest.writeString(this.sid);
        dest.writeString(this.ssid);
        dest.writeString(this.tpl);
        dest.writeInt(this.templateId);
    }
}
