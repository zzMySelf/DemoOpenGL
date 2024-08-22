package com.baidu.searchbox.location.business.ioc;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.location.business.data.DBInfoItem;
import com.baidu.searchbox.net.ProxyHttpClient;
import org.json.JSONObject;

public interface ILocationBusinessApp {
    public static final ILocationBusinessApp EMPTY = new ILocationBusinessApp() {
        public DBInfoItem queryDBInfoItem(String hostName) {
            return null;
        }

        public boolean addDBInfoItemSync(DBInfoItem infoItem) {
            return false;
        }

        public String getNuomiCityAutoLocatedStringPrefer() {
            return null;
        }

        public String getNuomiCityChosenStringPrefer() {
            return null;
        }

        public JSONObject getCardLocationJson(LocationInfo locationInfo, boolean sUseDebugLocation) {
            return null;
        }

        public ProxyHttpClient createHttpClient(Context context) {
            return null;
        }
    };
    public static final String LOG_TAG = "ILocationBusinessApp";

    boolean addDBInfoItemSync(DBInfoItem dBInfoItem);

    ProxyHttpClient createHttpClient(Context context);

    JSONObject getCardLocationJson(LocationInfo locationInfo, boolean z);

    String getNuomiCityAutoLocatedStringPrefer();

    String getNuomiCityChosenStringPrefer();

    DBInfoItem queryDBInfoItem(String str);

    public static final class Impl {
        private static ILocationBusinessApp sILocationBusinessApp = LocationBusinessRuntime.getContext();

        private Impl() {
        }

        public static ILocationBusinessApp get() {
            if (sILocationBusinessApp == null) {
                Log.w(ILocationBusinessApp.LOG_TAG, "Fetch ILocationBusinessApp implementation failed, ILocationBusinessApp.EMPTY applied");
                sILocationBusinessApp = ILocationBusinessApp.EMPTY;
            }
            return sILocationBusinessApp;
        }
    }
}
