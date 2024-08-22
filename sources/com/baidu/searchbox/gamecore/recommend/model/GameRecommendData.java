package com.baidu.searchbox.gamecore.recommend.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GameRecommendData {
    @SerializedName("items")
    public ArrayList<RecommendItem> items;
    @SerializedName("version")
    public String version;
}
