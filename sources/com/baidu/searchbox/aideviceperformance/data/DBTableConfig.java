package com.baidu.searchbox.aideviceperformance.data;

import java.util.List;

public class DBTableConfig {

    public static class LaunchTimeDBTable {
        public static final String APP_LUNCH_TIME_COLUMN = "app_launch_time";
        public static final String CREATE_TABLE_SQL = "create table app_launch_time (event_time long default 0,app_launch_time long default 0);";
        public static final String DB_NAME = "device_info.db";
        public static final boolean ENABLE_COUNT_RESTRICTION_FLAG = true;
        public static final String EVENT_TIME_COLUMN = "event_time";
        public static final int ONE_TIME_DELETE_NUM = 50;
        public static final int RESTRICT_NUM = 150;
        public static final String TABLE_NAME = "app_launch_time";
        public static final int VERSION = 1;
    }

    public static class UserStickinessDBTable {
        public static final String DB_NAME = "behavior_info.db";
        public static final boolean ENABLE_COUNT_RESTRICTION_FLAG = true;
        public static final String EVENT_TIME_COLUMN = "event_time";
        public static final int ONE_TIME_DELETE_NUM = 50;
        public static final int RESTRICT_NUM = 150;
        public static final String TABLE_NAME = "user_stickiness";
        public static final int VERSION = 3;
        private static List<String> sRegisterIds;

        private static String getRegisteredIdSql() {
            String sqlStr = "";
            if (sRegisterIds == null) {
                return null;
            }
            for (int i2 = 0; i2 < sRegisterIds.size(); i2++) {
                String id = sRegisterIds.get(i2);
                if (i2 == sRegisterIds.size() - 1) {
                    sqlStr = sqlStr + "count_" + id + " long default 0,first_time_" + id + " long default 0";
                } else {
                    sqlStr = sqlStr + "count_" + id + " long default 0,first_time_" + id + " long default 0,";
                }
            }
            return sqlStr;
        }

        public static String getCreateTableSql() {
            return "create table user_stickiness (event_time long default 0," + getRegisteredIdSql() + ");";
        }

        public static void setRegisterIds(List<String> list) {
            sRegisterIds = list;
        }
    }
}
