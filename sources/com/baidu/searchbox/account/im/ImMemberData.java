package com.baidu.searchbox.account.im;

import com.baidu.searchbox.account.ImBaseMember;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImMemberData extends BaseNetData<List<ImBaseMember>> {
    public ImMemberData(String jsonString) {
        super(jsonString);
    }

    public List<ImBaseMember> parseJson(String jsonString) {
        JSONObject jsonObject = null;
        List<ImBaseMember> datalist = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jsonObject == null) {
            return null;
        }
        this.errno = jsonObject.optString("errno");
        this.timestamp = jsonObject.optString("timestamp");
        JSONArray data = jsonObject.optJSONArray("data");
        if (data != null && data.length() > 0) {
            datalist = new ArrayList<>();
            for (int i2 = 0; i2 < data.length(); i2++) {
                ImBaseMember item = ImBaseMember.parseJson(data.optString(i2));
                item.setTime(this.timestamp);
                datalist.add(item);
            }
            this.data = datalist;
        }
        return datalist;
    }
}
