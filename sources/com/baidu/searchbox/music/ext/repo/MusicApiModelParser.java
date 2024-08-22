package com.baidu.searchbox.music.ext.repo;

import org.json.JSONObject;

public interface MusicApiModelParser<T> {
    T parse(JSONObject jSONObject);
}
