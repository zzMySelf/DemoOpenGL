package com.baidu.searchbox.account.userinfo.menu;

import android.text.TextUtils;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt;
import com.baidu.searchbox.follow.FollowConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MenuItemDesc {
    public JSONObject currentJsonObj;
    public boolean fromNetRequest = false;
    public boolean hasSecondaryMenu;
    public String iconSubUrl;
    public String iconSubUrlNight;
    public String iconUrl;
    public String iconUrlNight;
    public String menuId;
    public String scheme;
    public List<SubMenuItemDesc> subMenuItemDescList;
    public String title;
    public String type;

    public static MenuItemDesc parse(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        MenuItemDesc menuItemDesc = new MenuItemDesc();
        menuItemDesc.menuId = jsonObject.optString("menu_id", "");
        menuItemDesc.title = jsonObject.optString("title", "");
        menuItemDesc.type = jsonObject.optString("type", "");
        String optStringExNull = PersonalPageExtensionsKt.optStringExNull(jsonObject, "iconUrl", "");
        menuItemDesc.iconUrl = optStringExNull;
        menuItemDesc.iconSubUrl = PersonalPageExtensionsKt.optStringExNull(jsonObject, "iconSubUrl", optStringExNull);
        menuItemDesc.iconUrlNight = PersonalPageExtensionsKt.optStringExNull(jsonObject, "iconUrlNight", menuItemDesc.iconUrl);
        menuItemDesc.iconSubUrlNight = PersonalPageExtensionsKt.optStringExNull(jsonObject, "iconSubUrlNight", menuItemDesc.iconSubUrl);
        if (TextUtils.isEmpty(menuItemDesc.type)) {
            menuItemDesc.type = "default";
        }
        menuItemDesc.scheme = jsonObject.optString("scheme", "");
        boolean equals = "1".equals(jsonObject.optString("has_secondary_menu", "0"));
        menuItemDesc.hasSecondaryMenu = equals;
        if (equals) {
            JSONArray jsonArray = jsonObject.optJSONArray(FollowConstant.REQUEST_SOURCE_SUB_LIST);
            int i2 = 0;
            while (jsonArray != null && i2 < jsonArray.length()) {
                if (menuItemDesc.subMenuItemDescList == null) {
                    menuItemDesc.subMenuItemDescList = new ArrayList();
                }
                try {
                    SubMenuItemDesc subMenuItemDesc = SubMenuItemDesc.parse(jsonArray.getJSONObject(i2));
                    if (subMenuItemDesc != null) {
                        menuItemDesc.subMenuItemDescList.add(subMenuItemDesc);
                    }
                } catch (JSONException e2) {
                }
                i2++;
            }
        }
        menuItemDesc.currentJsonObj = jsonObject;
        return menuItemDesc;
    }

    public static String toJson(Map<String, List<MenuItemDesc>> menuMap) {
        if (menuMap == null || menuMap.isEmpty()) {
            return "";
        }
        JSONArray arrObj = new JSONArray();
        Set<Map.Entry<String, List<MenuItemDesc>>> entrySet = menuMap.entrySet();
        if (entrySet != null) {
            for (Map.Entry<String, List<MenuItemDesc>> entry : entrySet) {
                String id = entry.getKey();
                List<MenuItemDesc> menuItemDescList = entry.getValue();
                if (!TextUtils.isEmpty(id) && menuItemDescList != null && !menuItemDescList.isEmpty()) {
                    try {
                        JSONObject object = new JSONObject();
                        object.put("id", id);
                        object.put("list", toJsonArray(menuItemDescList));
                        arrObj.put(object);
                    } catch (Exception e2) {
                    }
                }
            }
        }
        if (arrObj.length() > 0) {
            return arrObj.toString();
        }
        return "";
    }

    public static Map<String, List<MenuItemDesc>> valueOf(String jsonString) {
        if (TextUtils.isEmpty(jsonString)) {
            return null;
        }
        Map<String, List<MenuItemDesc>> menuMap = new HashMap<>();
        try {
            JSONArray arrObj = new JSONArray(jsonString);
            for (int i2 = 0; i2 < arrObj.length(); i2++) {
                JSONObject object = arrObj.optJSONObject(i2);
                if (object != null) {
                    String id = object.optString("id", "");
                    List<MenuItemDesc> menuItemDescList = valueOf(object.optJSONArray("list"));
                    if (!TextUtils.isEmpty(id) && menuItemDescList != null && !menuItemDescList.isEmpty()) {
                        menuMap.put(id, menuItemDescList);
                    }
                }
            }
            if (menuMap.isEmpty()) {
                return null;
            }
            return menuMap;
        } catch (Exception e2) {
            return null;
        }
    }

    private static List<MenuItemDesc> valueOf(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        List<MenuItemDesc> menuItemDescList = null;
        int i2 = 0;
        while (jsonArray != null && i2 < jsonArray.length()) {
            if (menuItemDescList == null) {
                menuItemDescList = new ArrayList<>();
            }
            try {
                MenuItemDesc menuItemDesc = parse(jsonArray.getJSONObject(i2));
                if (menuItemDesc != null) {
                    menuItemDesc.fromNetRequest = true;
                    menuItemDescList.add(menuItemDesc);
                }
            } catch (JSONException e2) {
            }
            i2++;
        }
        return menuItemDescList;
    }

    private static JSONArray toJsonArray(List<MenuItemDesc> menuItemDescList) {
        JSONObject jSONObject;
        if (menuItemDescList == null || menuItemDescList.isEmpty()) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        for (MenuItemDesc menuItemDesc : menuItemDescList) {
            if (!(menuItemDesc == null || (jSONObject = menuItemDesc.currentJsonObj) == null)) {
                jsonArray.put(jSONObject);
            }
        }
        return jsonArray;
    }
}
