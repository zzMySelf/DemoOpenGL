package com.baidu.searchbox.gamecore.piazza;

import com.baidu.searchbox.gamecore.GameCenterRuntime;
import com.baidu.searchbox.gamecore.base.datasource.GameDataManager;
import com.baidu.searchbox.gamecore.person.model.AiAppsHistoryData;
import com.baidu.searchbox.gamecore.router.GameConfig;
import com.baidu.searchbox.generalcommunity.injector.impl.NetRequestImpl;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GamePiazzaNetFactory extends NetRequestImpl {
    private static final int REQUEST_LIMIT = 10;

    public String provideUrl(boolean isPullToRefresh) {
        return BaiduIdentityManager.getInstance().processUrl(GameConfig.getGamePiazzaServer());
    }

    public JSONObject buildBusinessParams(boolean isPullToRefresh) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("channel", "game");
            jsonObject.put("cuid", BaiduIdentityManager.getInstance().getEnUid());
            jsonObject.put("game_cuid", BaiduIdentityManager.getInstance().getEnUid());
            JSONObject report = GameDataManager.getInstance().getPiazzaReport();
            JSONObject game = new JSONObject();
            if (report != null) {
                JSONObject next = report.getJSONObject("next_report");
                if (next != null) {
                    game.put("type", next.optInt("type"));
                    game.put("offset", next.optInt("offset"));
                    game.put("limit", 10);
                }
            }
            if (isPullToRefresh) {
                game.put("offset", 0);
            }
            game.put("product", "baidu");
            game.put("resource_keys", getAiAppGameHistory());
            game.put("swan_version", GameCenterRuntime.getGameContext().getSwanVersion());
            game.put("rfrom", "0");
            jsonObject.put("game", game);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject customWrapPostJson(JSONObject postJson) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", postJson);
        return jsonObject;
    }

    private JSONArray getAiAppGameHistory() {
        List<AiAppsHistoryData> list = GameCenterRuntime.getGameContext().getAiAppsGameHistory();
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray data = new JSONArray();
        for (AiAppsHistoryData history : list) {
            data.put(history.getAppKey());
        }
        return data;
    }
}
