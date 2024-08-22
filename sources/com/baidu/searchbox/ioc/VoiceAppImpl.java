package com.baidu.searchbox.ioc;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.browser.search.LightSearchActivity;
import com.baidu.searchbox.database.DBControl;
import com.baidu.searchbox.database.OEMConfiguartion;
import com.baidu.searchbox.shortcut.CloudShortcutSpUtil;
import com.baidu.searchbox.speech.ioc.IVoiceAppInterface;
import com.baidu.searchbox.util.Utility;
import com.baidu.searchbox.widget.WidgetDataStatisticUtils;

public class VoiceAppImpl implements IVoiceAppInterface {
    public SQLiteOpenHelper getSQLiteOpenHelper(Context context) {
        return DBControl.DbOpenHelper.getInstance(context, "SearchBox.db", DBControl.DB_VERSION);
    }

    public void createVoiceShortcut(Context context) {
        if (OEMConfiguartion.getInstance(context).isCreateSpeechShortcut()) {
            CloudShortcutSpUtil.parseDeskIconProtocol(context, CloudShortcutSpUtil.ShortCutType.SPEECH, CloudShortcutSpUtil.ShortCutStrategy.FUNCTION_USE);
        }
    }

    public boolean isHissug(Context context) {
        if (context instanceof LightSearchActivity) {
            return ((LightSearchActivity) context).isSug();
        }
        return false;
    }

    public void collapseStatusBar(Context context) {
        Utility.collapseStatusBar(context);
    }

    public void addWidgetDot(Intent intent) {
        String statisticFrom = intent.getStringExtra("search_from");
        if (TextUtils.isEmpty(statisticFrom)) {
            return;
        }
        if (TextUtils.equals(statisticFrom, "trans_search_widget")) {
            WidgetDataStatisticUtils.addWidgetClickStatistic(2, 4);
        } else if (TextUtils.equals(statisticFrom, "search_widget")) {
            WidgetDataStatisticUtils.addWidgetClickStatistic(1, 4);
        } else if (TextUtils.equals(statisticFrom, "com.baidu.searchbox.category.DIGITAL")) {
            WidgetDataStatisticUtils.addWidgetClickStatistic(3, 4);
        } else if (TextUtils.equals(statisticFrom, "com.baidu.searchbox.category.ANALOG")) {
            WidgetDataStatisticUtils.addWidgetClickStatistic(4, 4);
        } else if (TextUtils.equals(statisticFrom, "quickox_search_widget")) {
            WidgetDataStatisticUtils.addWidgetClickStatistic(9, 4);
        } else if (TextUtils.equals(statisticFrom, "simple_search_widget")) {
            WidgetDataStatisticUtils.addWidgetClickStatistic(16, 4);
        }
    }
}
