package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupInviteMsg;
import com.baidu.android.imsdk.chatmessage.request.IMQueryFansUnreadRequest;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.request.IMAddFanGroupBotRequest;
import com.baidu.android.imsdk.group.request.IMAddGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMCreateFansGroupRequest;
import com.baidu.android.imsdk.group.request.IMCreateGroupRequest;
import com.baidu.android.imsdk.group.request.IMDelFansGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMDelGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMDelStarMemberRequest;
import com.baidu.android.imsdk.group.request.IMDismissFansGroupRequest;
import com.baidu.android.imsdk.group.request.IMGetFanBotListRequest;
import com.baidu.android.imsdk.group.request.IMGetFansGroupInviteMember;
import com.baidu.android.imsdk.group.request.IMGetFansJoinGroupApplyCountRequest;
import com.baidu.android.imsdk.group.request.IMGetFansJoinGroupApplyState;
import com.baidu.android.imsdk.group.request.IMGetStarOnlineRequest;
import com.baidu.android.imsdk.group.request.IMGroupSetRequest;
import com.baidu.android.imsdk.group.request.IMJoinGroupRequest;
import com.baidu.android.imsdk.group.request.IMJoinStarGroupRequest;
import com.baidu.android.imsdk.group.request.IMModifyGroupAuditStateRequest;
import com.baidu.android.imsdk.group.request.IMNoSpeakingSettingRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupListRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupQrCodeRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansMemberRequest;
import com.baidu.android.imsdk.group.request.IMQueryForwardUserList;
import com.baidu.android.imsdk.group.request.IMQueryGlobalConfRequest;
import com.baidu.android.imsdk.group.request.IMQueryGroupListRequest;
import com.baidu.android.imsdk.group.request.IMQueryGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryMemberPauidRequest;
import com.baidu.android.imsdk.group.request.IMQueryMemberRequest;
import com.baidu.android.imsdk.group.request.IMQuitGroupRequest;
import com.baidu.android.imsdk.group.request.IMQuitStarGroupRequest;
import com.baidu.android.imsdk.group.request.IMSetFansGroupWelcomeDataRequest;
import com.baidu.android.imsdk.group.request.IMSetFansGroupWelcomeDisplayScopeRequest;
import com.baidu.android.imsdk.group.request.IMSetGroupNoticeRequest;
import com.baidu.android.imsdk.group.request.IMSetNickNameRequest;
import com.baidu.android.imsdk.group.request.IMUpdateGroupCertainInfoRequest;
import com.baidu.android.imsdk.group.request.IMUpdateGroupNameRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.upload.Utils;
import com.baidu.android.imsdk.utils.DataUtil;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupManagerImpl {
    /* access modifiers changed from: private */
    public static final String TAG = GroupManagerImpl.class.getSimpleName();
    /* access modifiers changed from: private */
    public static Context mContext;
    private static volatile GroupManagerImpl mInstance;

    public static synchronized GroupManagerImpl getInstance(Context context) {
        GroupManagerImpl groupManagerImpl;
        synchronized (GroupManagerImpl.class) {
            if (mInstance == null) {
                mContext = context.getApplicationContext();
                mInstance = new GroupManagerImpl();
            }
            groupManagerImpl = mInstance;
        }
        return groupManagerImpl;
    }

    public void createGroup(int type, String name, ArrayList<String> members, BIMValueCallBack<CreateResultInfo> listener) {
        BIMValueCallBack<CreateResultInfo> bIMValueCallBack = listener;
        if (!isValidGroupName(name)) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMCreateGroupRequest creategrouprequest = new IMCreateGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), type, name, members);
            HttpHelper.executor(mContext, creategrouprequest, creategrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void createFansGroup(int groupType, int groupSubType, int groupVerify, int groupAudit, String groupName, String groupDesc, String groupImage, String masterName, ArrayList<String> members, BIMValueCallBack<CreateResultInfo> listener) {
        String str = groupName;
        BIMValueCallBack<CreateResultInfo> bIMValueCallBack = listener;
        if (!TextUtils.isEmpty(groupName) && !TextUtils.isEmpty(masterName) && members != null) {
            if (members.size() >= 2) {
                if (members.size() <= 20) {
                    if (isValidFansGroupName(str)) {
                        if (!BIMManager.isIMLogined(mContext)) {
                            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                            if (bIMValueCallBack != null) {
                                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                            }
                        }
                        if (TextUtils.isEmpty(groupImage)) {
                            final int i2 = groupType;
                            final int i3 = groupSubType;
                            final int i4 = groupVerify;
                            final int i5 = groupAudit;
                            final String str2 = groupName;
                            final String str3 = groupDesc;
                            final String str4 = masterName;
                            final ArrayList<String> arrayList = members;
                            final BIMValueCallBack<CreateResultInfo> bIMValueCallBack2 = listener;
                            Utils.generateAndUploadDefaultPortrait(mContext, str, "", new BIMValueCallBack<String>() {
                                public void onResult(int responseCode, String errMsg, String remoteUrl) {
                                    if (responseCode == 0) {
                                        GroupManagerImpl.this.requestCreateFansGroup(i2, i3, i4, i5, str2, str3, remoteUrl, str4, arrayList, bIMValueCallBack2);
                                        return;
                                    }
                                    BIMValueCallBack bIMValueCallBack = bIMValueCallBack2;
                                    if (bIMValueCallBack != null) {
                                        bIMValueCallBack.onResult(responseCode, errMsg, null);
                                    }
                                }
                            });
                            return;
                        }
                        requestCreateFansGroup(groupType, groupSubType, groupVerify, groupAudit, groupName, groupDesc, groupImage, masterName, members, listener);
                        return;
                    }
                }
            }
        }
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
    }

    /* access modifiers changed from: private */
    public void requestCreateFansGroup(int groupType, int groupSubType, int groupVerify, int groupAudit, String groupName, String groupDesc, String groupImage, String masterName, ArrayList<String> members, BIMValueCallBack<CreateResultInfo> listener) {
        BIMValueCallBack<CreateResultInfo> bIMValueCallBack = listener;
        if (BIMManager.isIMLogined(mContext)) {
            IMCreateFansGroupRequest creategrouprequest = new IMCreateFansGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), groupType, groupSubType, groupName, groupDesc, groupImage, masterName, members, groupAudit, groupVerify);
            HttpHelper.executor(mContext, creategrouprequest, creategrouprequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void addGroupMembers(String groupId, ArrayList<String> members, BIMValueCallBack<ArrayList<GroupMember>> listener) {
        BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack = listener;
        long id = Utility.getLongByString(groupId, 0);
        int memSize = 0;
        if (id <= 0 || members == null || members.size() == 0 || members.size() > 64) {
            if (members != null) {
                memSize = members.size();
            }
            uploadGroupRequestFailInfo(1005, Constants.ERROR_MSG_PARAMETER_ERROR, "addGroupMembers", groupId, "request members size = " + memSize);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMAddGroupMemberRequest addmembersrequest = new IMAddGroupMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), id, members, false);
            HttpHelper.executor(mContext, addmembersrequest, addmembersrequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (members != null) {
                memSize = members.size();
            }
            uploadGroupRequestFailInfo(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, "addGroupMembers", groupId, "request members size = " + memSize);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    private void uploadGroupRequestFailInfo(int error, String reason, String method, String groupId, String questParam) {
        CaseUbc.DebugInfo info = new CaseUbc.DebugInfo();
        info.curClassName = "GroupManagerImpl";
        info.extInfo = reason;
        info.extInfo += ",param groupId = " + groupId;
        info.extInfo += ",custom param = " + questParam;
        CaseUbc.debugUbc(mContext, method, error, "", info);
    }

    public void joinGroup(String groupId, String inviterbuid, int channel, String why, boolean isFansGroup, BIMValueCallBack<String> listener) {
        long inbuid;
        long gid;
        String str = groupId;
        BIMValueCallBack<String> bIMValueCallBack = listener;
        try {
            gid = Long.valueOf(groupId).longValue();
            inbuid = Long.valueOf(inviterbuid).longValue();
        } catch (Exception e2) {
            LogUtils.e(TAG, e2.getMessage());
            gid = -1;
            inbuid = -1;
        }
        if (gid < 0) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMJoinGroupRequest joingrouprequest = new IMJoinGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), isFansGroup, groupId, inbuid, channel, why);
            HttpHelper.executor(mContext, joingrouprequest, joingrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public void joinStarGroup(String groupId, BIMValueCallBack<String> listener) {
        long gid = -1;
        try {
            gid = Long.valueOf(groupId).longValue();
        } catch (Exception e2) {
            LogUtils.e(TAG, e2.getMessage());
        }
        if (gid < 0 && listener != null) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, groupId);
        }
        if (AccountManager.isLogin(mContext)) {
            IMJoinStarGroupRequest joingrouprequest = new IMJoinStarGroupRequest(mContext, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext), groupId);
            HttpHelper.executor(mContext, joingrouprequest, joingrouprequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (listener != null) {
            listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, groupId);
        }
    }

    public void quitGroup(String groupId, BIMValueCallBack<String> listener) {
        long groupid = -1;
        try {
            groupid = Long.valueOf(groupId).longValue();
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "groupId : " + groupId, e2);
        }
        if (0 > groupid) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, groupId);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMQuitGroupRequest quitgrouprequest = new IMQuitGroupRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, false);
            HttpHelper.executor(mContext, quitgrouprequest, quitgrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, groupId);
            }
        }
    }

    public void quitStarGroup(String groupId, BIMValueCallBack<String> listener) {
        long groupid;
        String str = groupId;
        BIMValueCallBack<String> bIMValueCallBack = listener;
        try {
            groupid = Long.valueOf(groupId).longValue();
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "groupId : " + str, e2);
            groupid = -1;
        }
        if (0 > groupid) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMQuitStarGroupRequest quitgrouprequest = new IMQuitStarGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), groupId, AccountManager.getUid(mContext));
            HttpHelper.executor(mContext, quitgrouprequest, quitgrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public void delGroupMember(String groupId, ArrayList<String> buids, BIMValueCallBack<ArrayList<String>> listener) {
        BIMValueCallBack<ArrayList<String>> bIMValueCallBack = listener;
        long groupid = -1;
        try {
            groupid = Long.valueOf(groupId).longValue();
            String str = groupId;
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "groupId : " + groupId, e2);
        }
        if (0 > groupid) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if ((buids == null || buids.size() == 0) && bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext)) {
            IMDelGroupMemberRequest creategrouprequest = new IMDelGroupMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), groupId, buids);
            HttpHelper.executor(mContext, creategrouprequest, creategrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void delStarMember(String groupId, ArrayList<String> buids, BIMValueCallBack<ArrayList<String>> listener) {
        BIMValueCallBack<ArrayList<String>> bIMValueCallBack = listener;
        long groupid = -1;
        try {
            groupid = Long.valueOf(groupId).longValue();
            String str = groupId;
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "groupId : " + groupId, e2);
        }
        if (0 > groupid) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if ((buids == null || buids.size() == 0) && bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext)) {
            IMDelStarMemberRequest creategrouprequest = new IMDelStarMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), groupId, buids);
            HttpHelper.executor(mContext, creategrouprequest, creategrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void getStarOnline(String groupId, BIMValueCallBack<Integer> listener) {
        long groupid = -1;
        try {
            groupid = Long.valueOf(groupId).longValue();
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "groupId : " + groupId, e2);
        }
        if (0 > groupid) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMGetStarOnlineRequest creategrouprequest = new IMGetStarOnlineRequest(mContext, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext), groupId);
            HttpHelper.executor(mContext, creategrouprequest, creategrouprequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void getAllGroupMember(String groupId, ArrayList<String> memberbuids, BIMValueCallBack<ArrayList<GroupMember>> listener) {
        int gnum;
        String str = groupId;
        BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack = listener;
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ArrayList<GroupInfo> ginfos = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (ginfos == null || ginfos.size() <= 0) {
                gnum = 0;
            } else {
                gnum = ginfos.get(0).getNum();
            }
            ArrayList<GroupMember> members = GroupInfoDAOImpl.getGroupMember(mContext, str, memberbuids, 0);
            if (members == null || members.size() <= 0) {
                IMQueryMemberRequest querymembersrequest = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), groupId, memberbuids, 1);
                HttpHelper.executor(mContext, querymembersrequest, querymembersrequest);
                return;
            }
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, members);
            }
            if (gnum > 0 && members.size() != gnum) {
                LogUtils.d(TAG, "to update group member");
                IMQueryMemberRequest querymembersrequest2 = new IMQueryMemberRequest(mContext, "", AccountManager.getAppid(mContext), groupId, memberbuids, 1);
                HttpHelper.executor(mContext, querymembersrequest2, querymembersrequest2);
            }
        } else if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
    }

    public void getFansGroupOwnerInfo(String groupId, boolean localFirst, final BIMValueCallBack<GroupMember> requestCallback) {
        GroupMember groupOwner;
        if (TextUtils.isEmpty(groupId)) {
            if (requestCallback != null) {
                requestCallback.onResult(1005, "groupId empty", null);
            }
        } else if (localFirst && (groupOwner = GroupMessageManagerImpl.getInstance(mContext).getGroupOwner(groupId)) != null) {
            requestCallback.onResult(0, "success", groupOwner);
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (requestCallback != null) {
                requestCallback.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            ArrayList<String> queryMemberUidList = null;
            ArrayList<String> groupIds = new ArrayList<>();
            groupIds.add(groupId);
            ArrayList<GroupInfo> groupInfos = GroupInfoDAOImpl.getGroupInfo(mContext, groupIds);
            if (groupInfos != null && groupInfos.size() > 0) {
                GroupInfo groupInfo = groupInfos.get(0);
                GroupInfo groupInfo2 = groupInfo;
                if (groupInfo != null) {
                    queryMemberUidList = new ArrayList<>();
                    queryMemberUidList.add(String.valueOf(groupInfo2.getBuid()));
                }
            }
            IMQueryFansMemberRequest request = new IMQueryFansMemberRequest(mContext, ListenerManager.getInstance().addListener(new BIMValueCallBack<ArrayList<GroupMember>>() {
                public void onResult(int responseCode, String errMsg, ArrayList<GroupMember> response) {
                    GroupMember groupOwnerInfo = null;
                    if (responseCode == 0 && !DataUtil.isListEmpty(response)) {
                        Iterator<GroupMember> it = response.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            GroupMember groupMember = it.next();
                            if (groupMember.getRole() == 1) {
                                groupOwnerInfo = groupMember;
                                break;
                            }
                        }
                    }
                    requestCallback.onResult(responseCode, errMsg, groupOwnerInfo);
                }
            }), groupId, queryMemberUidList);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void getFansGroupAdministrators(String groupId, BIMValueCallBack<List<GroupMember>> callBack) {
        if (!TextUtils.isEmpty(groupId)) {
            callBack.onResult(0, "succeed", GroupMessageManagerImpl.getInstance(mContext).getGroupAdministrators(groupId));
        } else if (callBack != null) {
            callBack.onResult(1005, "groupId empty", null);
        }
    }

    public boolean updateGroupMemberRole(String groupId, String uid, int role) {
        return GroupMessageManagerImpl.getInstance(mContext).updateGroupMemberRole(groupId, uid, role);
    }

    public boolean updateGroupMemberMutedInfo(String groupId, List<String> uids, int mutedStatus, long mutedEndTime) {
        return GroupMessageManagerImpl.getInstance(mContext).updateGroupMemberMutedInfo(groupId, uids, mutedStatus, mutedEndTime);
    }

    public boolean updateGroupMuted(String groupId, int mutedStatus) {
        return GroupMessageManagerImpl.getInstance(mContext).updateGroupMuted(groupId, mutedStatus);
    }

    public void getGroupMember(int type, String groupId, ArrayList<String> memberbuids, BIMValueCallBack<ArrayList<GroupMember>> listener) {
        String str = groupId;
        BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack = listener;
        if (str == null) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!AccountManager.isLogin(mContext)) {
            int i2 = type;
            ArrayList<String> arrayList = memberbuids;
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else if (type == 1) {
            IMQueryMemberRequest querymembersrequest = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), groupId, memberbuids, 1);
            HttpHelper.executor(mContext, querymembersrequest, querymembersrequest);
            ArrayList<String> arrayList2 = memberbuids;
        } else {
            ArrayList<GroupMember> members = GroupInfoDAOImpl.getGroupMember(mContext, str, memberbuids, 0);
            if (members == null || members.size() <= 0) {
                long appid = AccountManager.getAppid(mContext);
                IMQueryMemberRequest querymembersrequest2 = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), appid, groupId, memberbuids, 1);
                HttpHelper.executor(mContext, querymembersrequest2, querymembersrequest2);
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, members);
            }
        }
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> listener, int count, int offset) {
        if (AccountManager.isLogin(mContext)) {
            ArrayList<String> groupids = GroupInfoDAOImpl.getGroupList(mContext, true, count, offset);
            if (listener != null) {
                listener.onResult(0, Constants.ERROR_MSG_SUCCESS, groupids);
                return;
            }
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (listener != null) {
            listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getAllGroupList(BIMValueCallBack<ArrayList<String>> listener) {
        if (AccountManager.isLogin(mContext)) {
            ArrayList<String> groupids = GroupInfoDAOImpl.getAllGroupList(mContext);
            if (listener != null) {
                listener.onResult(0, "", groupids);
                return;
            }
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (listener != null) {
            listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> listener) {
        if (AccountManager.isLogin(mContext)) {
            IMQueryGroupListRequest querygrouplistrequest = new IMQueryGroupListRequest(mContext, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext));
            HttpHelper.executor(mContext, querygrouplistrequest, querygrouplistrequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (listener != null) {
            listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getGroupsInfo(int type, ArrayList<String> groupIds, BIMValueCallBack<ArrayList<GroupInfo>> listener) {
        ScreenUbc.MethodInfo info = new ScreenUbc.MethodInfo();
        info.startTime = System.currentTimeMillis();
        info.method = "getGroupsInfo";
        info.eventList = new JSONArray();
        if (groupIds == null || groupIds.size() == 0) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            if (type == 1) {
                Utility.addEventList(info.eventList, "IMQueryGroupRequest_no_save_begin");
                queryGroupRequest(listener, groupIds, info);
                return;
            }
            Utility.addEventList(info.eventList, "getGroupInfo_db_begin");
            ArrayList<GroupInfo> groupsinfo = GroupInfoDAOImpl.getGroupInfo(mContext, groupIds);
            if (groupsinfo == null || groupsinfo.size() <= 0) {
                Utility.addEventList(info.eventList, "IMQueryGroupRequest_begin");
                queryGroupRequest(listener, groupIds, info);
                return;
            }
            LogUtils.d(TAG, "getGroupsInfo 0");
            if (listener != null) {
                listener.onResult(0, Constants.ERROR_MSG_SUCCESS, groupsinfo);
                info.errCode = 0;
                info.errMsg = "getGroupInfo_db_Sucess!";
                info.endTime = System.currentTimeMillis();
                ScreenUbc.onEvent(mContext, "getGroupInfo", info);
            }
        } else if (listener != null) {
            listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    private void queryGroupRequest(BIMValueCallBack<ArrayList<GroupInfo>> listener, ArrayList<String> groupIds, ScreenUbc.MethodInfo info) {
        IMQueryGroupRequest querygrouprequest = new IMQueryGroupRequest(mContext, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext), groupIds, false, (ArrayList<GroupMember>) null);
        querygrouprequest.setScreenInfo(info);
        HttpHelper.executor(mContext, querygrouprequest, querygrouprequest);
    }

    public void updateGroupName(String groupid, String name, BIMValueCallBack<String> listener) {
        if (groupid == null || name == null || !isValidGroupName(name)) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, groupid);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMUpdateGroupNameRequest updateGroupNamerequest = new IMUpdateGroupNameRequest(mContext, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext), groupid, name);
            HttpHelper.executor(mContext, updateGroupNamerequest, updateGroupNamerequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, groupid);
            }
        }
    }

    private boolean isValidGroupName(String name) {
        if (name == null) {
            return true;
        }
        if (name.length() <= 32 && !EmojionUtils.containsEmoji(name)) {
            return true;
        }
        return false;
    }

    private boolean isValidFansGroupName(String name) {
        return !TextUtils.isEmpty(name) && name.length() <= 15 && !EmojionUtils.containsEmoji(name);
    }

    public void setGroupDisturb(String groupid, int disturb, BIMValueCallBack<String> listener) {
        IMGroupSetRequest request = new IMGroupSetRequest(mContext, ListenerManager.getInstance().addListener(listener), groupid, AccountManager.getAppid(mContext), disturb);
        HttpHelper.executor(mContext, request, request);
    }

    public void setNickName(String groupId, long buid, String nickname, boolean isFansGroup, BIMValueCallBack<String> listener) {
        IMSetNickNameRequest request = new IMSetNickNameRequest(mContext, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext), isFansGroup, groupId, nickname, buid);
        HttpHelper.executor(mContext, request, request);
    }

    public String getNickName(String groupId, String buid) {
        return GroupInfoDAOImpl.getNickName(mContext, groupId, buid);
    }

    public int getRole(String groupId, String buid) {
        return GroupInfoDAOImpl.getRole(mContext, groupId, buid);
    }

    public ArrayList<GroupMember> getNickName(String groupId) {
        return GroupInfoDAOImpl.getMemberNickname(mContext, groupId);
    }

    public void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> listener) {
        IMQueryGlobalConfRequest request = new IMQueryGlobalConfRequest(context, ListenerManager.getInstance().addListener(listener), AccountManager.getAppid(mContext));
        HttpHelper.executor(mContext, request, request);
    }

    public void getFansGroupInviteMembers(String groupid, BIMValueCallBack<GroupSortUserList> listener) {
        if (listener != null) {
            if (groupid == null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            } else {
                IMGetFansGroupInviteMember request = new IMGetFansGroupInviteMember(mContext, groupid, ListenerManager.getInstance().addListener(listener));
                HttpHelper.executor(mContext, request, request);
            }
        }
    }

    public void getFansGroupList(final boolean network, final BIMValueCallBack<List<GroupInfo>> listener) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
            public void run() {
                if (!network) {
                    listener.onResult(0, (String) null, GroupInfoDAOImpl.getAllFansGroupList(GroupManagerImpl.mContext));
                    return;
                }
                IMQueryFansGroupListRequest request = new IMQueryFansGroupListRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(listener));
                HttpHelper.executor(GroupManagerImpl.mContext, request, request);
            }
        });
    }

    public void getFansGroupUserInfo(final String groupId, final ArrayList<String> buids, final BIMValueCallBack<ArrayList<GroupMember>> listener) {
        if (groupId == null) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                public void run() {
                    ArrayList<GroupMember> groupMembers = GroupInfoDAOImpl.getGroupMember(GroupManagerImpl.mContext, groupId, buids, 0);
                    ArrayList arrayList = buids;
                    if (arrayList == null || arrayList.size() == 0 || (groupMembers != null && groupMembers.size() == buids.size())) {
                        listener.onResult(0, "", groupMembers);
                        return;
                    }
                    List<Long> memberList = new ArrayList<>();
                    if (groupMembers != null && groupMembers.size() > 0) {
                        Iterator<GroupMember> it = groupMembers.iterator();
                        while (it.hasNext()) {
                            memberList.add(Long.valueOf(it.next().getBduid()));
                        }
                    }
                    ArrayList<Long> requestUid = new ArrayList<>();
                    Iterator it2 = buids.iterator();
                    while (it2.hasNext()) {
                        long lUid = Utility.getLongByString((String) it2.next(), 0);
                        if (lUid != 0) {
                            requestUid.add(Long.valueOf(lUid));
                        }
                    }
                    requestUid.removeAll(memberList);
                    final ArrayList<GroupMember> result = new ArrayList<>();
                    if (groupMembers != null) {
                        result.addAll(groupMembers);
                    }
                    if (requestUid.size() > 0) {
                        ChatUserManager.getUsersProfileBatch(GroupManagerImpl.mContext, requestUid, new IGetUsersProfileBatchListener() {
                            public void onGetUsersProfileBatchResult(int responseCode, String strMsg, ArrayList<Long> arrayList, ArrayList<ChatUser> users) {
                                if (responseCode == 0 && users != null && users.size() > 0) {
                                    Iterator<ChatUser> it = users.iterator();
                                    while (it.hasNext()) {
                                        ChatUser user = it.next();
                                        GroupMember groupMember = new GroupMember(groupId, user.getUk(), user.getUserName(), user.getBuid(), 0, 0);
                                        groupMember.setPortrait(user.getIconUrl());
                                        result.add(groupMember);
                                    }
                                }
                                listener.onResult(0, "", result);
                            }
                        });
                    } else {
                        listener.onResult(0, "", result);
                    }
                }
            });
        }
    }

    public void getFansGroupMember(String groupId, ArrayList<String> buids, boolean network, BIMValueCallBack<ArrayList<GroupMember>> listener) {
        if (groupId == null) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            final boolean z = network;
            final String str = groupId;
            final ArrayList<String> arrayList = buids;
            final BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack = listener;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                public void run() {
                    ArrayList arrayList;
                    if (!z) {
                        ArrayList<GroupMember> groupMembers = GroupInfoDAOImpl.getGroupMember(GroupManagerImpl.mContext, str, arrayList, 0);
                        if ((arrayList == null && groupMembers != null && groupMembers.size() > 0) || !((arrayList = arrayList) == null || groupMembers == null || arrayList.size() != groupMembers.size())) {
                            bIMValueCallBack.onResult(0, (String) null, groupMembers);
                            return;
                        }
                    }
                    IMQueryFansMemberRequest request = new IMQueryFansMemberRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, arrayList);
                    HttpHelper.executor(GroupManagerImpl.mContext, request, request);
                }
            });
        }
    }

    public void getFansGroupNormalRoleMembers(String groupId, BIMValueCallBack<List<GroupMember>> listener) {
        if (TextUtils.isEmpty(groupId)) {
            LogUtils.d(TAG, "getGroupNormalRoleMembers failed, groupId empty:" + TextUtils.isEmpty(groupId));
            listener.onResult(1005, " groupId empty", null);
            return;
        }
        listener.onResult(0, "succeed", GroupInfoDAOImpl.getGroupNormalRoleMembers(mContext, groupId));
    }

    public void getFansGroupInfo(ArrayList<String> groupIds, boolean network, BIMValueCallBack<ArrayList<GroupInfo>> listener) {
        if (groupIds == null || groupIds.size() == 0) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            ScreenUbc.MethodInfo info = new ScreenUbc.MethodInfo();
            info.startTime = System.currentTimeMillis();
            info.method = "getFansGroupInfo";
            info.eventList = new JSONArray();
            final boolean z = network;
            final ScreenUbc.MethodInfo methodInfo = info;
            final ArrayList<String> arrayList = groupIds;
            final BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack = listener;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() {
                public void run() {
                    if (!z) {
                        Utility.addEventList(methodInfo.eventList, "getFansGroup_subTask");
                        ArrayList<GroupInfo> groupInfos = GroupInfoDAOImpl.getGroupInfo(GroupManagerImpl.mContext, arrayList);
                        Utility.addEventList(methodInfo.eventList, "getFansGroupInfo_db_end");
                        boolean valid = false;
                        if (groupInfos != null && groupInfos.size() == arrayList.size()) {
                            valid = true;
                            Iterator<GroupInfo> it = groupInfos.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().getType() != 3) {
                                        valid = false;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        if (valid) {
                            bIMValueCallBack.onResult(0, (String) null, groupInfos);
                            methodInfo.errCode = 0;
                            methodInfo.errMsg = "getFansGroupInfo_db_Sucess!";
                            methodInfo.endTime = System.currentTimeMillis();
                            ScreenUbc.onEvent(GroupManagerImpl.mContext, "getFansGroupInfo", methodInfo);
                            LogUtils.d(GroupManagerImpl.TAG, "check-本地群信息有效");
                            return;
                        }
                    }
                    LogUtils.d(GroupManagerImpl.TAG, "check-本地群信息无效");
                    Utility.addEventList(methodInfo.eventList, "IMQueryFansGroupRequest_begin");
                    IMQueryFansGroupRequest request = new IMQueryFansGroupRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), arrayList);
                    request.setScreenInfo(methodInfo);
                    HttpHelper.executor(GroupManagerImpl.mContext, request, request);
                }
            });
        }
    }

    public void delFansGroupMember(String groupId, ArrayList<String> buids, int delState, BIMValueCallBack<ArrayList<String>> listener) {
        if (groupId == null || buids == null || buids.size() == 0) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMDelFansGroupMemberRequest request = new IMDelFansGroupMemberRequest(mContext, groupId, buids, ListenerManager.getInstance().addListener(listener), delState);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void quitFansGroup(String groupId, BIMValueCallBack<String> listener) {
        long groupid = -1;
        try {
            groupid = Long.valueOf(groupId).longValue();
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "groupId : " + groupId, e2);
        }
        if (0 > groupid) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, groupId);
            }
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, groupId);
            }
        } else {
            IMQuitGroupRequest quitgrouprequest = new IMQuitGroupRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, true);
            HttpHelper.executor(mContext, quitgrouprequest, quitgrouprequest);
        }
    }

    public void sendFansGroupInviteMsg(final String groupId, List<Long> bduids, final ISendMessageListener listener) {
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext) && !TextUtils.isEmpty(groupId) && bduids != null && bduids.size() != 0) {
            new AtomicInteger(bduids.size());
            getPaidAndUkByBduid(bduids, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>() {
                public void onResult(int responseCode, String errMsg, List<IMQueryMemberPauidRequest.UserId> list) {
                    if (responseCode != 0 || list == null) {
                        listener.onSendMessageResult(6, (ChatMsg) null);
                        return;
                    }
                    for (IMQueryMemberPauidRequest.UserId userId : list) {
                        long paid = userId.getPauid();
                        long contacter = paid == 0 ? userId.getUk() : paid;
                        ChatMsg chatMsg = GroupManagerImpl.this.getInviteMsg(groupId, paid == 0 ? 0 : 7, userId.getBduid(), contacter);
                        BIMValueCallBack<SendMsgResponse> sendMsgCallBack = new BIMValueCallBack<SendMsgResponse>() {
                            public void onResult(int responseCode, String errMsg, SendMsgResponse response) {
                                if (listener != null) {
                                    listener.onSendMessageResult(responseCode, response == null ? null : response.responseMsg);
                                }
                            }
                        };
                        SendMsgParam.SendMsgParamConstruct sendMsgParamConstruct = new SendMsgParam.SendMsgParamConstruct() {
                            public void construct(SendMsgParam sendMsgParam) {
                                BIMManager.sendChatMsg(GroupManagerImpl.mContext, sendMsgParam);
                            }
                        };
                        if (paid == 0) {
                            SendMsgParam.newInstanceByUk(GroupManagerImpl.mContext, chatMsg, contacter, sendMsgCallBack, sendMsgParamConstruct);
                        } else {
                            SendMsgParam.newInstanceByPa(GroupManagerImpl.mContext, chatMsg, contacter, sendMsgCallBack, sendMsgParamConstruct);
                        }
                    }
                }
            });
        } else if (listener != null) {
            listener.onSendMessageResult(1005, (ChatMsg) null);
        }
    }

    /* access modifiers changed from: private */
    public ChatMsg getInviteMsg(String groupId, int chattype, long bduid, long contacter) {
        String result = "";
        try {
            JSONObject content = new JSONObject();
            content.put("group_id", Utility.getLongByString(groupId, 0));
            content.put("invitor", AccountManager.getUid(mContext));
            result = content.toString();
        } catch (JSONException e2) {
        }
        FansGroupInviteMsg msg = new FansGroupInviteMsg();
        msg.setMsgContent(result);
        msg.setFromUser(AccountManager.getUK(mContext));
        msg.setStatus(1);
        msg.setSenderUid(TextUtils.isEmpty(AccountManager.getUid(mContext)) ? "0" : AccountManager.getUid(mContext));
        msg.setCategory(0);
        msg.setChatType(chattype);
        msg.setContacterBduid(String.valueOf(bduid));
        msg.setContacter(contacter);
        msg.setMsgTime(System.currentTimeMillis() / 1000);
        return msg;
    }

    public void getPaidAndUkByBduid(List<Long> buids, BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>> listener) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        IMQueryMemberPauidRequest getPauidRequest = new IMQueryMemberPauidRequest(mContext, buids, ListenerManager.getInstance().addListener(listener));
        HttpHelper.executor(mContext, getPauidRequest, getPauidRequest);
    }

    public void getForwardUserList(BIMValueCallBack<GroupSortUserList> listener) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        IMQueryForwardUserList getPauidRequest = new IMQueryForwardUserList(mContext, ListenerManager.getInstance().addListener(listener));
        HttpHelper.executor(mContext, getPauidRequest, getPauidRequest);
    }

    public void getFansGroupUnreadStatus(BIMValueCallBack<Integer> listener) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        IMQueryFansUnreadRequest unreadRequest = new IMQueryFansUnreadRequest(mContext, ListenerManager.getInstance().addListener(listener));
        HttpHelper.executor(mContext, unreadRequest, unreadRequest);
    }

    public void getFansGroupQrCode(String groupId, BIMValueCallBack<IMQueryFansGroupQrCodeRequest.QrCode> listener) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        IMQueryFansGroupQrCodeRequest qrCodeRequest = new IMQueryFansGroupQrCodeRequest(mContext, groupId, ListenerManager.getInstance().addListener(listener));
        HttpHelper.executor(mContext, qrCodeRequest, qrCodeRequest);
    }

    public void getFansGroupApplyCountFromServer(List<String> groupIds, BIMValueCallBack<ArrayList<GroupApplyBean>> callBack) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (callBack != null) {
                callBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        IMGetFansJoinGroupApplyCountRequest request = new IMGetFansJoinGroupApplyCountRequest(mContext, groupIds, ListenerManager.getInstance().addListener(callBack));
        HttpHelper.executor(mContext, request, request);
    }

    public void getCurrentUserGroupApplyStateFromServer(String groupId, BIMValueCallBack<Integer> callBack) {
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (callBack != null) {
                callBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, 0);
                return;
            }
            return;
        }
        IMGetFansJoinGroupApplyState request = new IMGetFansJoinGroupApplyState(mContext, groupId, ListenerManager.getInstance().addListener(callBack));
        HttpHelper.executor(mContext, request, request);
    }

    public void setGroupNotice(String groupId, String notice, BIMValueCallBack<String> listener) {
        if (groupId == null) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        } else {
            IMSetGroupNoticeRequest request = new IMSetGroupNoticeRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, notice);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void setFansGroupWelcomeDisplayScope(String groupId, int welcomeDisplayScope, BIMValueCallBack listener) {
        if (TextUtils.isEmpty(groupId)) {
            if (listener != null) {
                listener.onResult(1005, "group id is null", null);
            }
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMSetFansGroupWelcomeDisplayScopeRequest request = new IMSetFansGroupWelcomeDisplayScopeRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, welcomeDisplayScope);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void setFansGroupWelcomeData(String groupId, String welcomeContent, int operationType, BIMValueCallBack listener) {
        if (groupId == null) {
            if (listener != null) {
                listener.onResult(1005, "group id is null", null);
            }
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMSetFansGroupWelcomeDataRequest request = new IMSetFansGroupWelcomeDataRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, welcomeContent, operationType);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void getBotInviteMembers(String groupId, BIMValueCallBack<List<GroupMember>> listener) {
        IMGetFanBotListRequest request = new IMGetFanBotListRequest(mContext, groupId, ListenerManager.getInstance().addListener(listener));
        HttpHelper.executor(mContext, request, request);
    }

    public void addBotMemberToGroup(long groupId, String botUid, BIMValueCallBack<Integer> listener) {
        IMAddFanGroupBotRequest request = new IMAddFanGroupBotRequest(mContext, groupId, botUid, true, ListenerManager.getInstance().addListener(listener));
        HttpHelper.executor(mContext, request, request);
    }

    public void delBotMemberToGroup(long groupId, String botUid, BIMValueCallBack<ArrayList<String>> listener) {
        String key = ListenerManager.getInstance().addListener(listener);
        ArrayList<String> members = new ArrayList<>();
        members.add(botUid);
        IMDelFansGroupMemberRequest request = new IMDelFansGroupMemberRequest(mContext, "" + groupId, members, key, 0);
        HttpHelper.executor(mContext, request, request);
    }

    public void updateFansGroupName(String groupId, String groupName, BIMValueCallBack<String> listener) {
        if (TextUtils.isEmpty(groupId) || groupName == null || !isValidGroupName(groupName)) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMUpdateGroupCertainInfoRequest request = new IMUpdateGroupCertainInfoRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, groupName, 1);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void updateFansGroupDesc(String groupId, String groupDesc, BIMValueCallBack<String> listener) {
        if (TextUtils.isEmpty(groupId) || groupDesc == null) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMUpdateGroupCertainInfoRequest request = new IMUpdateGroupCertainInfoRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, groupDesc, 2);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void updateFansGroupHead(String groupId, String groupHead, BIMValueCallBack<String> listener) {
        if (TextUtils.isEmpty(groupId) || TextUtils.isEmpty(groupHead)) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMUpdateGroupCertainInfoRequest request = new IMUpdateGroupCertainInfoRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, groupHead, 3);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void updateFansGroupAuditState(String groupId, int state, BIMValueCallBack<String> listener) {
        if (TextUtils.isEmpty(groupId)) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!BIMManager.isIMLogined(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMModifyGroupAuditStateRequest request = new IMModifyGroupAuditStateRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, state);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void dismissFansGroup(String groupId, int reason, BIMValueCallBack<String> listener) {
        if (TextUtils.isEmpty(groupId)) {
            if (listener != null) {
                listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!BIMManager.isIMLogined(mContext) || AccountManager.isCuidLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else {
            IMDismissFansGroupRequest request = new IMDismissFansGroupRequest(mContext, ListenerManager.getInstance().addListener(listener), Long.parseLong(groupId), reason);
            HttpHelper.executor(mContext, request, request);
        }
    }

    public void requestNoSpeakingSetting(String groupId, List<String> membersBduk, int muteType, int mutedTime, BIMValueCallBack listener) {
        if (!IMNoSpeakingSettingRequest.PERMITTED_MUTE_TYPES.contains(Integer.valueOf(muteType)) && listener != null) {
            listener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (BIMManager.isIMLogined(mContext)) {
            IMNoSpeakingSettingRequest request = new IMNoSpeakingSettingRequest(mContext, ListenerManager.getInstance().addListener(listener), groupId, membersBduk, muteType, mutedTime);
            HttpHelper.executor(mContext, request, request);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (listener != null) {
                listener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }
}
