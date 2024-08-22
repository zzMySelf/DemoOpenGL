package com.baidu.netdisk.cloudfile.io.parser;

import com.baidu.netdisk.base.service.BaseServiceHelper;
import com.baidu.netdisk.cloudfile.io.model.TaskQuota;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.network.exception.RemoteException;
import com.baidu.netdisk.network.parser.IApiResultParseable;
import com.baidu.netdisk.network.response.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import org.json.JSONException;

public class QueryTaskParser implements IApiResultParseable<TaskQuota> {
    private static final String TAG = "QueryTaskParser";

    public TaskQuota parse(HttpResponse response) throws JSONException, RemoteException, IOException {
        try {
            TaskQuota queryTaskResponse = (TaskQuota) new Gson().fromJson(response.getContent(), TaskQuota.class);
            NetDiskLog.d(TAG, "TaskQuota:" + queryTaskResponse);
            if (queryTaskResponse == null) {
                throw new JSONException("QueryTaskParser JsonParser is null.");
            } else if (queryTaskResponse.errno == 0) {
                return queryTaskResponse;
            } else {
                throw BaseServiceHelper.buildRemoteException(queryTaskResponse.errno, (String) null, queryTaskResponse);
            }
        } catch (JsonSyntaxException e2) {
            throw new JSONException(e2.getMessage());
        } catch (JsonIOException e3) {
            throw new IOException(e3.getMessage());
        } catch (JsonParseException e4) {
            throw new JSONException(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw new JSONException(e5.getMessage());
        }
    }
}
