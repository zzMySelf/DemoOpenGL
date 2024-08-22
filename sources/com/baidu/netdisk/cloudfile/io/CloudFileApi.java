package com.baidu.netdisk.cloudfile.io;

import android.text.TextUtils;
import com.baidu.nadcore.cmd.utils.SchemeConstants;
import com.baidu.netdisk.base.network.FallbackManager;
import com.baidu.netdisk.base.network.NetworkTaskWrapper;
import com.baidu.netdisk.base.network.ServerURL;
import com.baidu.netdisk.cloudfile.io.model.FileManagerTaskResponse;
import com.baidu.netdisk.cloudfile.io.model.GetMetaResponse;
import com.baidu.netdisk.cloudfile.io.model.MoveCopyFile;
import com.baidu.netdisk.cloudfile.io.model.Quota;
import com.baidu.netdisk.cloudfile.io.parser.CreateTaskParser;
import com.baidu.netdisk.cloudfile.io.parser.FileManagerTaskParser;
import com.baidu.netdisk.cloudfile.io.parser.GetFileMetaParser;
import com.baidu.netdisk.cloudfile.io.parser.GetQuotaParser;
import com.baidu.netdisk.kernel.architecture.AppCommon;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.kernel.encode.MD5Util;
import com.baidu.netdisk.kernel.encode.SHA1Util;
import com.baidu.netdisk.network.BaseApi;
import com.baidu.netdisk.network.exception.RemoteException;
import com.baidu.netdisk.network.request.HttpParams;
import com.baidu.netdisk.network.request.RequestCommonParams;
import com.baidu.netdisk.util.CookieUtils;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudFileApi extends BaseApi {
    private static final String TAG = "CloudFileApi";

    public CloudFileApi(String token, String uid) {
        super(token, uid, new FallbackManager());
        setCookie(CookieUtils.getCookieByBduss(token));
    }

    public Quota getQuota() throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        return (Quota) new NetworkTaskWrapper().send(buildGetRequest(ServerURL.getDefaultHostName() + "quota"), new GetQuotaParser());
    }

    public Quota getSafeBoxQuota(int safeBox, int calQuota) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        String url = ServerURL.getDefaultHostName() + "quota";
        HttpParams params = new HttpParams();
        params.add(GetQuotaJob.SAFE_BOX, new Integer(safeBox).toString());
        params.add(GetQuotaJob.CAL_QUOTA, new Integer(calQuota).toString());
        return (Quota) new NetworkTaskWrapper().send(buildGetRequest(url, params), new GetQuotaParser());
    }

    public FileManagerTaskResponse queryFileManagerTask(long taskid, List<MoveCopyFile> moveFiles, String dest, ArrayList<String> paths, String path, String name) throws KeyManagementException, UnrecoverableKeyException, UnsupportedOperationException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        List<MoveCopyFile> list = moveFiles;
        String str = dest;
        ArrayList<String> arrayList = paths;
        String url = ServerURL.getDefaultHostName() + "taskquery?taskid=" + taskid;
        HttpParams params = new HttpParams();
        JSONArray filesJson = new JSONArray();
        if (list != null && str != null) {
            int i2 = 0;
            int len = moveFiles.size();
            while (i2 < len) {
                JSONObject fileJson = new JSONObject();
                MoveCopyFile file = list.get(i2);
                fileJson.put("path", file.path);
                fileJson.put("newname", file.name);
                fileJson.put("dest", str);
                if (!TextUtils.isEmpty(file.ondup)) {
                    fileJson.put("ondup", file.ondup);
                }
                filesJson.put(fileJson);
                i2++;
                list = moveFiles;
            }
            params.add("filelist", filesJson.toString());
            String str2 = path;
            String str3 = name;
        } else if (arrayList != null) {
            params.add("filelist", new JSONArray(arrayList).toString());
            String str4 = path;
            String str5 = name;
        } else {
            JSONObject fileJson2 = new JSONObject();
            fileJson2.put("path", path);
            fileJson2.put("newname", name);
            filesJson.put(fileJson2);
            params.add("filelist", filesJson.toString());
        }
        return (FileManagerTaskResponse) new NetworkTaskWrapper().send(buildPostRequest(url, params), new FileManagerTaskParser());
    }

    public void createTask(long timestamp, int type, String uid) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        HttpParams params = new HttpParams();
        params.add("sign", SHA1Util.hmacSha1(makeContent(timestamp, uid)));
        params.add("timestamp", String.valueOf(timestamp));
        params.add("type", String.valueOf(type));
        new NetworkTaskWrapper().send(buildGetRequest(ServerURL.getDefaultHostName() + "task/create", params), new CreateTaskParser());
    }

    private String makeContent(long currentTime, String uid) {
        StringBuffer content = new StringBuffer();
        String temp = MD5Util.createMD5WithHex(uid, true);
        if (TextUtils.isEmpty(temp)) {
            temp = "NUHC";
        }
        content.append(temp.toLowerCase(Locale.getDefault())).append(RequestCommonParams.getClientType()).append(RequestCommonParams.getChannel()).append(AppCommon.DEVUID).append(currentTime);
        String contentStr = content.toString();
        NetDiskLog.d(TAG, "contentStr:" + contentStr);
        return contentStr;
    }

    public GetMetaResponse getFileMetaByIds(List<String> fsids, boolean isGetDlink) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, JSONException, RemoteException {
        String url = ServerURL.getDefaultHostName() + "filemetas";
        HttpParams params = new HttpParams();
        params.add("fsids", new JSONArray(fsids).toString());
        if (isGetDlink) {
            params.add(SchemeConstants.ACTION_DLINK, "1");
        }
        NetDiskLog.d(TAG, "url=" + url);
        return (GetMetaResponse) new NetworkTaskWrapper().send(buildPostRequest(url, params), new GetFileMetaParser());
    }
}
