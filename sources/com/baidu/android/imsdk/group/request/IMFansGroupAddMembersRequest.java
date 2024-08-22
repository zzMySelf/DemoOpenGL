package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.CreateResultInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IMFansGroupAddMembersRequest extends FansGroupBaseHttpRequest {
    private static final String TAG = "IMFansGroupAddMembersRequest";
    /* access modifiers changed from: private */
    public final long mGroupId;
    /* access modifiers changed from: private */
    public final String mKey;
    private final ArrayList<String> mMembers;
    private String requestParameter = "";

    public IMFansGroupAddMembersRequest(Context context, String key, long groupid, ArrayList<String> members) {
        this.mKey = key;
        this.mContext = context;
        this.mMembers = members;
        this.mGroupId = groupid;
    }

    class Mytask extends TaskManager.Task {
        public Mytask(Context context, String key, String json) {
            super(key, json);
        }

        public void run() {
            String resultMsg;
            int resultCode;
            ArrayList<GroupMember> gmembers = new ArrayList<>();
            ArrayList<GroupMember> members = new ArrayList<>();
            try {
                JSONObject origin = new JSONObject(this.mJson);
                resultCode = origin.getInt("error_code");
                resultMsg = origin.optString("error_msg", "");
                if (resultCode == 0 && origin.has("response_params")) {
                    JSONArray sucmembers = origin.getJSONObject("response_params").getJSONArray("members");
                    for (int i2 = 0; i2 < sucmembers.length(); i2++) {
                        JSONObject jm = sucmembers.getJSONObject(i2);
                        LogUtils.d(IMFansGroupAddMembersRequest.TAG, "createFansGroup-add suc or fail member info: " + jm);
                        long buid = jm.optLong("bd_uid");
                        int role = jm.optInt("role");
                        long ctime = jm.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                        long uk = jm.optLong("uk");
                        int status = jm.optInt("status", -1);
                        LogUtils.d(IMFansGroupAddMembersRequest.TAG, "createFansGroup-add success member info: " + jm);
                        String avatarExt = jm.optString(DBTableDefine.GroupMemberColumns.COLUMN_AVATAR_EXT, "");
                        GroupMember m = new GroupMember(String.valueOf(IMFansGroupAddMembersRequest.this.mGroupId), uk, "", buid, role, ctime);
                        m.setAddStatus(status);
                        m.setAvatarExt(avatarExt);
                        if (status == 0) {
                            gmembers.add(m);
                        }
                        members.add(m);
                    }
                    LogUtils.d(IMFansGroupAddMembersRequest.TAG, "createFansGroup-add group member " + gmembers.size());
                    GroupInfoDAOImpl.addMemberToGroup(IMFansGroupAddMembersRequest.this.mContext, String.valueOf(IMFansGroupAddMembersRequest.this.mGroupId), gmembers);
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "createFansGroup-IMCreateGroupRequest JSONException", e2);
                resultCode = 1010;
                resultMsg = "";
            }
            if (resultCode == 0) {
                ArrayList<String> ids = new ArrayList<>();
                ids.add(String.valueOf(IMFansGroupAddMembersRequest.this.mGroupId));
                IMQueryFansGroupRequest iMQueryFansGroupRequest = new IMQueryFansGroupRequest(IMFansGroupAddMembersRequest.this.mContext, IMFansGroupAddMembersRequest.this.mKey, ids, true, members);
                HttpHelper.executor(IMFansGroupAddMembersRequest.this.mContext, iMQueryFansGroupRequest, iMQueryFansGroupRequest);
                return;
            }
            IMListener listener = ListenerManager.getInstance().removeListener(IMFansGroupAddMembersRequest.this.mKey);
            if (listener != null && (listener instanceof BIMValueCallBack)) {
                CreateResultInfo cri = new CreateResultInfo();
                cri.groupid = String.valueOf(IMFansGroupAddMembersRequest.this.mGroupId);
                ((BIMValueCallBack) listener).onResult(0, resultMsg, cri);
            }
        }
    }

    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        builder.append("method=batch_add_member");
        builder.append("&group_id=").append(this.mGroupId);
        ArrayList<String> arrayList = this.mMembers;
        if (arrayList != null && arrayList.size() > 0) {
            JSONArray jmember = new JSONArray();
            Iterator<String> it = this.mMembers.iterator();
            while (it.hasNext()) {
                jmember.put(it.next());
            }
            builder.append("&members=").append(jmember.toString());
        }
        builder.append("&channel=").append(3);
        builder.append(getCommonParams());
        this.requestParameter = builder.toString();
        LogUtils.d(TAG, "createFansGroup-response: " + this.requestParameter);
        return this.requestParameter.getBytes();
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public boolean shouldAbort() {
        return false;
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        String jsonString = new String(resultContent);
        LogUtils.d(TAG, "createFansGroup-response: " + jsonString);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mContext, this.mKey, jsonString));
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        Pair<Integer, String> tips = transErrorCode(errorCode, resultContent, tr);
        IMListener listener = ListenerManager.getInstance().removeListener(this.mKey);
        if (listener instanceof BIMValueCallBack) {
            CreateResultInfo cri = new CreateResultInfo();
            cri.groupid = String.valueOf(this.mGroupId);
            ((BIMValueCallBack) listener).onResult(0, (String) tips.second, cri);
        }
    }

    private void uploadFailRequestInfo(int code, String response) {
        CaseUbc.DebugInfo info = new CaseUbc.DebugInfo();
        info.curClassName = "IMAddGroupMemberRequest";
        info.extInfo = "IMAddGroupMemberRequest error for request error";
        info.extInfo += ",request param = " + this.requestParameter;
        info.extInfo += ",response = " + response;
        CaseUbc.debugUbc(this.mContext, "addGroupMembers", code, "", info);
    }
}
