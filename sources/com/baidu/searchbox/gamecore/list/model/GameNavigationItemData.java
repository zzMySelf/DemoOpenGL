package com.baidu.searchbox.gamecore.list.model;

import com.google.gson.annotations.SerializedName;

public class GameNavigationItemData extends GameItemBaseData {
    @SerializedName("suspframe")
    public NavigationBubbleData bubbleData;
    @SerializedName("suspension_frame_switch")
    public int bubbleSwitch;
    @SerializedName("icon")
    public String icon;
    @SerializedName("name")
    public String name;
    @SerializedName("new_game_number")
    public int newGameNumber;
    @SerializedName("new_game_version")
    public String newGameVersion;
    @SerializedName("redpoint_conf")
    public NavigationRedPointData redPointData;
    @SerializedName("redpoint_switch")
    public int redPointSwitch;
    @SerializedName("scheme")
    public String scheme;
    @SerializedName("type")
    public String type;
}
