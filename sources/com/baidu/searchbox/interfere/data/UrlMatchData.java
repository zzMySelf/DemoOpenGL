package com.baidu.searchbox.interfere.data;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class UrlMatchData {
    private Map<String, String> exceptParamsMatchData;
    private String host;
    private Map<String, String> paramsMatchData;
    private String path;

    public void setHost(String host2) {
        this.host = host2;
    }

    public void setPath(String path2) {
        this.path = path2;
    }

    public void setParamsMatchData(Map<String, String> paramsMatchData2) {
        this.paramsMatchData = paramsMatchData2;
    }

    public void setExceptParamsMatchData(Map<String, String> exceptParamsMatchData2) {
        this.exceptParamsMatchData = exceptParamsMatchData2;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, String> getParamsMatchData() {
        return this.paramsMatchData;
    }

    public String toString() {
        return "UrlMatchData{host='" + this.host + '\'' + ", path='" + this.path + '\'' + ", paramsMatchData=" + this.paramsMatchData + ", exceptParamsMatchData=" + this.exceptParamsMatchData + AbstractJsonLexerKt.END_OBJ;
    }
}
