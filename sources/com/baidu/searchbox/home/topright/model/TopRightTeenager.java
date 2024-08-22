package com.baidu.searchbox.home.topright.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;

public class TopRightTeenager implements NoProGuard {
    @SerializedName("icon")
    public String icon;
    @SerializedName("item_id")
    public String itemId;
    @SerializedName("dark_icon")
    public String nightIcon;
    @SerializedName("scheme")
    public String scheme;
    @SerializedName("text")
    public String text;

    public void merge(TopRightTeenager data) {
        if (data != null) {
            if (this.itemId == null) {
                this.itemId = data.itemId;
            }
            if (this.icon == null) {
                this.icon = data.icon;
            }
            if (this.nightIcon == null) {
                this.nightIcon = data.nightIcon;
            }
            if (this.text == null) {
                this.text = data.text;
            }
            if (this.scheme == null) {
                this.scheme = data.scheme;
            }
        }
    }
}
