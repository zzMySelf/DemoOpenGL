package com.baidu.wallet.lightapp.multipage;

import androidx.core.util.TimeUtils;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;

public class LangbridgeSettings implements NoProguard, Cloneable {
    public static String MW_JSHOOK_HISTORY_NAME = "mw_history.js";
    public static String MW_JSHOOK_SESSION_NAME = "mw_session.js";
    public int MW_BHM_COLD_TIME = 259200;
    public int MW_BHM_LIMIT = 10;
    public boolean MW_BHM_ON = true;
    public int MW_BHM_RECORD_TIME = TimeUtils.SECONDS_PER_DAY;
    public ConsoleMsgBehaviour[] MW_CONSOLE_MESSAGE_BEHAVAIOUR;
    public boolean MW_HOLDLINK_ON = false;
    public boolean MW_INJECTJS_FOR_HS = false;
    public boolean MW_INJECTJS_FOR_SS = false;
    public String MW_JSCALL_ONACTIVE = "(function DXMLangbirdgeCall(){if(typeof(window.DXMLangbridge)!=\"undefined\"&&typeof(window.DXMLangbridge.onActive)===\"function\"){DXMLangbridge.onActive()}})";
    public String MW_JSCALL_ONNEGATIVE = "(function DXMLangbirdgeCall(){if(typeof(window.DXMLangbridge)!=\"undefined\"&&typeof(window.DXMLangbridge.onNegative)===\"function\"){DXMLangbridge.onNegative()}})";
    public String MW_JSHOOK_HISTORY = "window.history.go=function(a){BLightApp.invokeBdWalletNative(\"{method_name:'historyGo',index:\"+a+\"}\",null,null)};window.history.back=function(){BLightApp.invokeBdWalletNative(\"{method_name:'historyGo',index:\"+-1+\"}\",null,null)};";
    public String MW_JSHOOK_SESSION = "window.sessionStorage.getItem=function(b){var a=BLightApp.sessionCommand(\"getItem\",b,null);return a==undefined?null:a};window.sessionStorage.setItem=function(a,b){BLightApp.sessionCommand(\"setItem\",a,b)};window.sessionStorage.removeItem=function(a){BLightApp.sessionCommand(\"removeItem\",a,null)};window.sessionStorage.clear=function(){BLightApp.sessionCommand(\"clear\",null,null)};window.sessionStorage.key=function(a){ret=BLightApp.sessionCommand(\"key\",a,null);return ret==undefined?null:ret};try{Object.defineProperties(window.sessionStorage,{\"length\":{get:function(){return parseInt(BLightApp.sessionCommand(\"length\",null,null))}}})}catch(e){};";
    public int MW_LANG_CELL_LIMIT = 10;
    public double MW_LANG_RAM_LIMIT = 20.0d;
    public boolean MW_MULTI_ON = false;
    public boolean MW_ON = false;
    public int MW_PRELOAD_AUTO_TEST_INTERVAL = 60;
    public int MW_PRELOAD_CHECK_TIME = 30;
    public int MW_PRELOAD_LIFE_TIME = 180;
    public int MW_PRELOAD_POOL_SUM = 10;
    public int MW_PRELOAD_TEST_CHECK_MAX_TIMES = 3;
    public boolean MW_START_PRELOAD_AUTO_TEST_NEW = false;
    public boolean MW_USE_OLD = true;
    public int MW_WEBVIEW_POOL_SIZE = 15;

    public static class ConsoleMsgBehaviour implements NoProguard, Serializable {
        public String mConsoleString;
        public String mScore;
    }

    public boolean isValid() {
        return true;
    }

    public String toString() {
        return "\n\t" + "MW_ON: " + this.MW_ON + "\n\t" + "MW_USE_OLD: " + this.MW_USE_OLD + "\n\t" + "MW_MULTI_ON: " + this.MW_MULTI_ON + "\n\t" + "MW_HOLDLINK_ON: " + this.MW_HOLDLINK_ON + "\n\t" + "MW_BHM_ON: " + this.MW_BHM_ON + "\n\t" + "MW_BHM_LIMIT: " + this.MW_BHM_LIMIT + "\n\t" + "MW_BHM_COLD_TIME: " + this.MW_BHM_COLD_TIME + "\n\t" + "MW_BHM_RECORD_TIME: " + this.MW_BHM_RECORD_TIME + "\n\t" + "MW_WEBVIEW_POOL_SIZE: " + this.MW_WEBVIEW_POOL_SIZE + "\n\t" + "MW_PRELOAD_POOL_SUM: " + this.MW_PRELOAD_POOL_SUM + "\n\t" + "MW_PRELOAD_LIFE_TIME: " + this.MW_PRELOAD_LIFE_TIME + "\n\t" + "MW_PRELOAD_CHECK_TIME: " + this.MW_PRELOAD_CHECK_TIME + "\n\t" + "MW_LANG_CELL_LIMIT: " + this.MW_LANG_CELL_LIMIT + "\n\t" + "MW_LANG_RAM_LIMIT: " + this.MW_LANG_RAM_LIMIT + "\n\t" + "MW_JSHOOK_HISTORY: " + this.MW_JSHOOK_HISTORY + "\n\t" + "MW_JSHOOK_SESSION: " + this.MW_JSHOOK_SESSION + "\n\t" + "MW_JSCALL_ONACTIVE: " + this.MW_JSCALL_ONACTIVE + "\n\t" + "MW_JSCALL_ONNEGATIVE: " + this.MW_JSCALL_ONNEGATIVE + "\n\t" + "MW_CONSOLE_MESSAGE_BEHAVAIOUR" + this.MW_CONSOLE_MESSAGE_BEHAVAIOUR + "\n\t" + "MW_START_PRELOAD_AUTO_TEST" + this.MW_START_PRELOAD_AUTO_TEST_NEW + "\n\t" + "MW_PRELOAD_TEST_CHECK_MAX_TIMES" + this.MW_PRELOAD_TEST_CHECK_MAX_TIMES + "\n\t" + "MW_PRELOAD_AUTO_TEST_INTERVAL" + this.MW_PRELOAD_AUTO_TEST_INTERVAL;
    }

    public LangbridgeSettings clone() {
        try {
            return (LangbridgeSettings) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
