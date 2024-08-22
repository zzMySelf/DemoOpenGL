package com.baidu.searchbox.devicescore.dynamic;

import android.content.Context;
import com.baidu.searchbox.devicescore.ScoreMetaData;

public interface IDynamicScoreManager {
    float getScore(Context context);

    void putMetaData(Context context, ScoreMetaData scoreMetaData);

    boolean validMetaData(Context context, ScoreMetaData scoreMetaData);
}
