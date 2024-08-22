package com.baidu.mms.voicesearch.voice.bean;

import java.util.List;
import org.json.JSONObject;

public class SearchCompletedParam {
    public static final int MODE_CALL_XIAO_DU = 1;
    public static final int MODE_INVOKE_HOST = 0;
    public static final int MODE_ITEM_DIRECT = 3;
    public static final int MODE_ITEM_SEARCH = 2;
    public String corpusNo;
    public JSONObject jsonCommand;
    public int mode;
    public List<String> result;
    public List<String> voiceItems;

    public SearchCompletedParam(int mode2) {
        this.mode = mode2;
    }

    public SearchCompletedParam(int mode2, List<String> voiceItems2, List<String> result2, String corpusNo2) {
        this.mode = mode2;
        this.voiceItems = voiceItems2;
        this.result = result2;
        this.corpusNo = corpusNo2;
    }
}
