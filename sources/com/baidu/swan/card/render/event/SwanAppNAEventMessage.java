package com.baidu.swan.card.render.event;

import com.baidu.swan.card.render.engine.event.msg.SwanCardBaseMessage;
import com.baidu.swan.card.utils.ReactObjectParser;
import com.baidu.talos.core.data.ParamArray;
import org.json.JSONArray;

public class SwanAppNAEventMessage extends SwanCardBaseMessage {
    private static final String EVENT_NAME = "na-slave-page-naview-event";
    private static final String MESSAGE_DATA_KEY = "data";
    private final String mReactEventName;
    private final ParamArray mReactParams;
    private final long mReactTagID;

    public SwanAppNAEventMessage(long tagID, String eventName, ParamArray params) {
        this.mEventName = EVENT_NAME;
        this.mReactTagID = tagID;
        this.mReactEventName = eventName;
        this.mReactParams = params;
    }

    public String genSetDataStatement(String eventVar) {
        JSONArray dataArray = new JSONArray();
        dataArray.put(this.mReactTagID);
        dataArray.put(this.mReactEventName);
        ParamArray paramArray = this.mReactParams;
        if (paramArray == null) {
            dataArray.put(new JSONArray());
        } else {
            dataArray.put(ReactObjectParser.readableArrayToJson(paramArray));
        }
        return String.format("%s.%s = %s;", new Object[]{eventVar, "data", dataArray});
    }
}
