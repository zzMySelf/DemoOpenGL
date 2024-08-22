package com.baidu.searchbox.sport.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.AppConfig;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class TabInfo implements NoProGuard, Serializable, Parcelable {
    public static final Parcelable.Creator<TabInfo> CREATOR = new Parcelable.Creator<TabInfo>() {
        public TabInfo createFromParcel(Parcel in) {
            return new TabInfo(in);
        }

        public TabInfo[] newArray(int size) {
            return new TabInfo[size];
        }
    };
    public static final String ID_CHATROOM = "11";
    public static final String ID_DATA = "12";
    public static final String ID_GENERAL_TAB_CHATROOM = "102";
    public static final String ID_GENERAL_TAB_PIC_TEXT = "101";
    public static final String ID_LIST_MATCH = "20";
    public static final String ID_LIST_SCHEDULE_ALL = "22";
    public static final String ID_LIST_SCHEDULE_HOT = "21";
    public static final String ID_MATCH_DETAIL = "13";
    public static final String ID_MATCH_NEWS = "54";
    public static final String ID_MATCH_PLAYER_TABLE = "52";
    public static final String ID_MATCH_SCHEDULE = "50";
    public static final String ID_MATCH_TABLE = "51";
    public static final String ID_MATCH_VIDEO = "53";
    public static final String ID_NEWS = "15";
    public static final String ID_OLYMPIC_DELEGATION_CHN = "700207";
    public static final String ID_OLYMPIC_DELEGATION_INFO = "700203";
    public static final String ID_OLYMPIC_DELEGATION_MEDAL = "700202";
    public static final String ID_OLYMPIC_DELEGATION_NEWS = "700205";
    public static final String ID_OLYMPIC_DELEGATION_PLAYER = "700204";
    public static final String ID_OLYMPIC_DELEGATION_SCHEDULE = "900204";
    public static final String ID_OLYMPIC_DELEGATION_VIDEO = "700206";
    public static final String ID_OLYMPIC_MAIN_HISTORY = "700107";
    public static final String ID_OLYMPIC_MAIN_MEDAL = "700102";
    public static final String ID_OLYMPIC_MAIN_NEWS = "700104";
    public static final String ID_OLYMPIC_MAIN_SCHEDULE = "900101";
    public static final String ID_OLYMPIC_MAIN_SPORT = "700103";
    public static final String ID_OLYMPIC_MAIN_VENUE = "700106";
    public static final String ID_OLYMPIC_MAIN_VIDEO = "700105";
    public static final String ID_OLYMPIC_MATCH_CHATROOM = "900402";
    public static final String ID_OLYMPIC_MATCH_DATA = "700602";
    public static final String ID_OLYMPIC_MATCH_NEWS = "700603";
    public static final String ID_OLYMPIC_MATCH_PIC = "900401";
    public static final String ID_OLYMPIC_PLAYER_INFO = "700402";
    public static final String ID_OLYMPIC_PLAYER_NEWS = "700403";
    public static final String ID_OLYMPIC_PLAYER_SCHEDULE = "900501";
    public static final String ID_OLYMPIC_PLAYER_VIDEO = "700404";
    public static final String ID_OLYMPIC_SPORT_CHN = "700308";
    public static final String ID_OLYMPIC_SPORT_INFO = "700303";
    public static final String ID_OLYMPIC_SPORT_INTRO = "700307";
    public static final String ID_OLYMPIC_SPORT_MEDAL = "700302";
    public static final String ID_OLYMPIC_SPORT_NEWS = "700305";
    public static final String ID_OLYMPIC_SPORT_PLAYER = "700304";
    public static final String ID_OLYMPIC_SPORT_SCHEDULE = "900301";
    public static final String ID_OLYMPIC_SPORT_VIDEO = "700306";
    public static final String ID_OLYMPIC_TEAM_LINEUP = "700502";
    public static final String ID_OLYMPIC_TEAM_NEWS = "700503";
    public static final String ID_OLYMPIC_TEAM_PLAYER = "700505";
    public static final String ID_OLYMPIC_TEAM_SCHEDULE = "900501";
    public static final String ID_OLYMPIC_TEAM_VIDEO = "700504";
    public static final String ID_OLYMPIC_VENUE_INFO = "700702";
    public static final String ID_OLYMPIC_VENUE_NEWS = "700703";
    public static final String ID_OLYMPIC_VENUE_SCHEDULE = "700701";
    public static final String ID_PIC_TEXT = "10";
    public static final String ID_PLAYER_DATA = "41";
    public static final String ID_PLAYER_INFO = "40";
    public static final String ID_PLAYER_NEWS = "44";
    public static final String ID_PLAYER_SCHEDULE = "45";
    public static final String ID_PLAYER_VIDEO = "43";
    public static final String ID_STATISTICS = "16";
    public static final String ID_TEAM_DATA = "32";
    public static final String ID_TEAM_LINEUP = "31";
    public static final String ID_TEAM_NEWS = "34";
    public static final String ID_TEAM_SCHEDULE = "30";
    public static final String ID_TEAM_VIDEO = "33";
    public static final String ID_VIDEO = "14";
    public static final String ID_VS_TAB_SCHEDULE = "70";
    private static final Set<String> NA_TABS;
    String current;
    String icon;
    String iconSelect;
    String id;
    boolean isDefault;
    String loadUrl;
    String shareUrl;
    String title;

    static {
        HashSet hashSet = new HashSet();
        NA_TABS = hashSet;
        hashSet.add("10");
        hashSet.add("11");
        hashSet.add("21");
        hashSet.add("22");
        hashSet.add("30");
        hashSet.add("50");
        hashSet.add("45");
        hashSet.add(ID_OLYMPIC_DELEGATION_SCHEDULE);
        hashSet.add(ID_OLYMPIC_MAIN_SCHEDULE);
        hashSet.add("900501");
        hashSet.add("900501");
        hashSet.add(ID_OLYMPIC_SPORT_SCHEDULE);
        hashSet.add(ID_OLYMPIC_MATCH_PIC);
        hashSet.add(ID_OLYMPIC_MATCH_CHATROOM);
        hashSet.add(ID_OLYMPIC_VENUE_SCHEDULE);
    }

    public TabInfo() {
    }

    protected TabInfo(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.loadUrl = in.readString();
        this.shareUrl = in.readString();
        this.isDefault = in.readByte() != 0;
        this.current = in.readString();
        this.icon = in.readString();
        this.iconSelect = in.readString();
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLoadUrl() {
        return this.loadUrl;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean isDefault2) {
        this.isDefault = isDefault2;
    }

    public String getCurrent() {
        return this.current;
    }

    public void setCurrent(String current2) {
        this.current = current2;
    }

    public boolean isNa() {
        return NA_TABS.contains(this.id);
    }

    public boolean isChatRoom() {
        return "11".equals(this.id) || ID_OLYMPIC_MATCH_CHATROOM.equals(this.id);
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconSelect() {
        return this.iconSelect;
    }

    public String toString() {
        return "TabInfo{id='" + this.id + '\'' + ", title='" + this.title + '\'' + ", loadUrl='" + this.loadUrl + '\'' + ", shareUrl='" + this.shareUrl + '\'' + ", isDefault=" + this.isDefault + ", current='" + this.current + '\'' + ", icon='" + this.icon + '\'' + ", iconSelect='" + this.iconSelect + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("tabId", this.id);
            obj.put("title", this.title);
            obj.put("loadUrl", this.loadUrl);
            obj.put("shareUrl", this.shareUrl);
            obj.put("show", this.isDefault);
            obj.put("current", this.current);
            obj.put("icon", this.icon);
            obj.put("iconSelect", this.iconSelect);
            return obj;
        } catch (Throwable e2) {
            if (AppConfig.isDebug()) {
                Log.d("TabInfo", "--->>>TabInfo toJson err:" + e2.getMessage());
            }
            return obj;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.loadUrl);
        dest.writeString(this.shareUrl);
        dest.writeByte(this.isDefault ? (byte) 1 : 0);
        dest.writeString(this.current);
        dest.writeString(this.icon);
        dest.writeString(this.iconSelect);
    }
}
