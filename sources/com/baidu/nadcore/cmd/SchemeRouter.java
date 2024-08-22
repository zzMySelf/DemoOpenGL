package com.baidu.nadcore.cmd;

import android.content.Context;
import com.baidu.nadcore.cmd.model.SchemeModel;
import com.baidu.nadcore.cmd.runtime.IHandleCallback;
import com.baidu.nadcore.cmd.utils.SchemeUtility;
import com.baidu.nadcore.core.AdRuntime;
import com.baidu.nadcore.tool.NadTool;
import com.baidu.nadcore.tool.NadToolConfig;
import com.baidu.nadcore.tool.builtin.ICmdValidate;
import java.util.ArrayList;
import java.util.Map;

public class SchemeRouter {
    public static final String ACTION_KEY = "action";
    private static final String TAG = "SchemeRouter";
    private static final SchemeDispatcher sSchemeDispatcher = new SchemeDispatcher();

    public static boolean invoke(String command) {
        return invoke(command, (Context) null);
    }

    public static boolean invoke(String command, Context context) {
        return invoke(command, context, (Map<String, Object>) null);
    }

    public static boolean invoke(String command, Context context, Map<String, Object> msgMap) {
        return invoke(command, context, msgMap, (IHandleCallback) null);
    }

    public static boolean invoke(String command, Context context, Map<String, Object> msgMap, IHandleCallback handleCallback) {
        ICmdValidate cmdValidateTool;
        if (NadToolConfig.GLOBAL_DEBUG && (cmdValidateTool = (ICmdValidate) NadTool.get().select(ICmdValidate.class)) != null) {
            cmdValidateTool.validate(command);
        }
        if (!SchemeUtility.isValidScheme(command)) {
            SchemeUtility.callCallback(handleCallback, command, 201, false);
            return false;
        }
        if (context == null) {
            context = AdRuntime.applicationContext();
        }
        return dispatch(context, new SchemeModel(command), msgMap, handleCallback);
    }

    public static boolean dispatch(Context context, SchemeModel schemeModel, Map<String, Object> msgMap, IHandleCallback handleCallback) {
        return sSchemeDispatcher.dispatch(context, schemeModel, msgMap, handleCallback);
    }

    public static ArrayList<String> getActionNameList() {
        return sSchemeDispatcher.getActionNameList();
    }
}
