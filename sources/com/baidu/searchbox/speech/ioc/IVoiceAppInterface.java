package com.baidu.searchbox.speech.ioc;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;

public interface IVoiceAppInterface {
    void addWidgetDot(Intent intent);

    void collapseStatusBar(Context context);

    void createVoiceShortcut(Context context);

    SQLiteOpenHelper getSQLiteOpenHelper(Context context);

    boolean isHissug(Context context);
}
