package com.baidu.android.imsdk.group;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupCancelAdminMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansSetAdminMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansSetOwnerMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupDisbandMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupInfoChangeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberAddMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberJoinMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberNameChangeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupReplyUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarAlertMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarJoinMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarMasterUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.MsgRepliedData;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MultiplePair;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.ugc.utils.TextViewExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupMessageManagerImpl {
    private static final String TAG = GroupMessageManagerImpl.class.getSimpleName();
    /* access modifiers changed from: private */
    public static Context mContext;
    private static GroupMessageManagerImpl mInstance;
    protected static Object mSyncLock = new Object();
    private Map<String, List<GroupMember>> mGroupMemberMap = new HashMap();

    public static GroupMessageManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mSyncLock) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new GroupMessageManagerImpl();
                }
            }
        }
        return mInstance;
    }

    private GroupMessageManagerImpl() {
    }

    public ArrayList<ChatMsg> getAllChatMsg(String groupid, ChatMsg msg, int count, boolean isAsc) {
        if (TextUtils.isEmpty(groupid)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, groupid, msg, (long) count, isAsc);
    }

    public ArrayList<ChatMsg> getAllSystemMsg(String groupid, ChatMsg msg, int count, boolean isAsc) {
        if (TextUtils.isEmpty(groupid)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, groupid, msg, (long) count, isAsc);
    }

    public ArrayList<ChatMsg> getAllChatAndSystemMsg(String groupid, ChatMsg msg, int count, boolean isAsc) {
        if (TextUtils.isEmpty(groupid)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchAllChatMsg(mContext, groupid, msg, (long) count, isAsc);
    }

    private boolean isExistChatMsg(ArrayList<ChatMsg> msgs) {
        for (int i2 = 0; i2 < msgs.size(); i2++) {
            int type = msgs.get(i2).getMsgType();
            int gType = msgs.get(i2).getGroupType();
            if ((type >= 0 && type <= 100) || type == 2001) {
                return true;
            }
            if ((type >= 1010 && type <= 1011) || type == 1007) {
                return true;
            }
            if ((type == 1005 && gType == 3) || type == 1019 || type == 1020) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ChatMsg> addMsgsOnFetch(ArrayList<ChatMsg> msgs, boolean asNew, boolean isFromCChannel) {
        int createret;
        boolean isExistChatMsg;
        long sendUid;
        long msgid;
        String roleDisplayName;
        int type;
        ArrayList<ChatMsg> arrayList = msgs;
        if (arrayList != null && msgs.size() > 0) {
            ChatMsg lastmsg = arrayList.get(msgs.size() - 1);
            if (lastmsg.getMsgType() == 1003) {
                GroupMemberQuitMsg quitmsg = (GroupMemberQuitMsg) lastmsg;
                String quitbuid = quitmsg.getQuitBuid();
                if (quitbuid != null && quitbuid.equals(AccountManager.getUid(mContext))) {
                    try {
                        quitGroupByGroupId(quitmsg.getContacter());
                    } catch (Exception e2) {
                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                    }
                    return arrayList;
                }
            } else if (lastmsg.getMsgType() == 1013) {
                handleDisbandMsg(lastmsg);
                updateAndNotifyApplyCount(lastmsg.getContacter(), 0);
            }
            String str = TAG;
            LogUtils.d(str, "STAR receive group message ");
            ChatMsg msg = arrayList.get(0);
            boolean isStar = msg.isStarMessage();
            String groupid = String.valueOf(msg.getContacter());
            if (!GroupInfoDAOImpl.isExistGroup(mContext, groupid)) {
                LogUtils.d(str, "STAR table " + groupid + " is not exist");
                int createret2 = GroupInfoDAOImpl.createGroup(mContext, groupid);
                if (isStar) {
                    GroupInfoDAOImpl.setGroupType(mContext, groupid, 2);
                    GroupInfoDAOImpl.setGroupDisturb(mContext, groupid, 1);
                }
                GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, groupid, msg.getGroupType());
                createret = createret2;
            } else {
                LogUtils.d(str, "STAR group table " + groupid + " has exist");
                createret = 0;
            }
            if (createret < 0) {
                LogUtils.e(str, "STAR create group table error " + createret);
                return null;
            } else if (msg.getContacter() == 0) {
                LogUtils.e(str, "STAR group id is 0, return null");
                return null;
            } else {
                int chattype = msg.getGroupType() == 3 ? 57 : 3;
                ChatObject chatObject = new ChatObject(mContext, msg.getCategory(), msg.getContacter(), msg.getPaid(), chattype);
                LogUtils.d(str, "STAR receive group message, size is " + msgs.size());
                if (msgs.size() > 0) {
                    if (chattype != 57) {
                        for (int i2 = 0; i2 < msgs.size(); i2++) {
                            ChatMsg tmp = arrayList.get(i2);
                            handleGroupSystemMessage(tmp);
                            tmp.setChatType(3);
                        }
                    } else {
                        handleFansGroupSystemMessage(msgs);
                    }
                    GroupInfoSyncManagerImpl.activeSyncGroup(mContext, groupid);
                    ArrayList<Long> ret = GroupMessageDAOImpl.addChatMsg(mContext, groupid, arrayList);
                    String str2 = TAG;
                    LogUtils.d(str2, "msgs : ret " + ret + ",groupid: " + groupid);
                    LogUtils.d(str2, "msgs : msgs.size() " + msgs.size() + ",groupid: " + groupid);
                    if (ret == null) {
                        LogUtils.d(str2, "STAR add chat msg error. ret " + ret + ",groupid: " + groupid);
                        return null;
                    } else if (ret.size() != 1 || ret.get(0).longValue() >= 0) {
                        if (ret.size() != msgs.size()) {
                            LogUtils.e(str2, ret.size() + " ret.size() -- msgs.size()" + msgs.size() + ",groupid: " + groupid);
                        }
                        boolean isActive = GroupMessageDAOImpl.isActiveGroup(mContext, groupid);
                        if (!isActive) {
                            isExistChatMsg = isExistChatMsg(msgs);
                        } else {
                            isExistChatMsg = false;
                        }
                        LogUtils.d(str2, "isActive : " + isActive + ",isExistChatMsg : " + isExistChatMsg + ",groupid: " + groupid);
                        if (isActive || isExistChatMsg) {
                            MultiplePair<Integer, Long, Long, String> pair = getImportantReminderMsg(msgs);
                            if (pair != null) {
                                ArrayList<Long> arrayList2 = ret;
                                type = ((Integer) pair.first).intValue();
                                msgid = ((Long) pair.second).longValue();
                                sendUid = ((Long) pair.third).longValue();
                                roleDisplayName = pair.fourth;
                            } else {
                                type = 0;
                                msgid = 0;
                                sendUid = 0;
                                roleDisplayName = "";
                            }
                            boolean z = isExistChatMsg;
                            MultiplePair<Integer, Long, Long, String> multiplePair = pair;
                            boolean isActive2 = isActive;
                            int i3 = chattype;
                            int i4 = createret;
                            int i5 = type;
                            String groupid2 = groupid;
                            recordLastMsgOnFetch(groupid, chatObject, isStar, type, msgid, sendUid, roleDisplayName, isFromCChannel);
                            if (!isActive2) {
                                GroupInfoDAOImpl.activeGroupState(mContext, groupid2);
                            }
                        }
                    } else {
                        LogUtils.d(str2, "STAR add chat msg error. return.  ret = " + ret + ",groupid: " + groupid);
                        return arrayList;
                    }
                } else {
                    int i6 = createret;
                    String str3 = groupid;
                }
            }
        }
        return arrayList;
    }

    private void recordLastMsgOnFetch(String groupid, ChatObject chatObject, boolean isStar, int remindType, long remindMsgid, long remindUid, String remindRoleDisplayName, boolean isFromCChannel) {
        ArrayList<ChatMsg> lastmsgs;
        String str = groupid;
        int newMsgNum = GroupMessageDAOImpl.getUnReadCount(mContext, str);
        String str2 = TAG;
        LogUtils.e(str2, str + "   newmsgnum : " + newMsgNum);
        if (isStar) {
            lastmsgs = GroupMessageDAOImpl.fetchLastChatMsg(mContext, groupid, (ChatMsg) null, 1, true);
        } else {
            lastmsgs = GroupMessageDAOImpl.fetchAllChatMsg(mContext, groupid, (ChatMsg) null, 1, true);
        }
        if (lastmsgs == null || lastmsgs.size() <= 0) {
            return;
        }
        ChatMsg lastMsg = lastmsgs.get(0);
        String content = lastMsg.getRecommendDescription();
        if ((lastMsg instanceof HtmlMsg) && !TextUtils.isEmpty(lastMsg.getLocalUrl())) {
            content = lastMsg.getLocalUrl();
        }
        int clickState = Utility.getClickState(lastMsg);
        LogUtils.e(str2, str + "   lastMsg : " + lastMsg);
        String extJsonStr = "";
        if (lastMsg.getMsgType() == 24) {
            extJsonStr = ChatMessageDBManager.getInteractiveSessionExt(lastMsg);
        }
        int i2 = newMsgNum;
        ChatMessageDBManager.getInstance(mContext).recordLastMsgOnFetch(chatObject, content, lastMsg.getMsgTime(), newMsgNum, 0, clickState, lastMsg.isStarMessage(), (String) null, lastMsg.getSenderUid(), remindType, remindMsgid, remindUid, remindRoleDisplayName, "", 0, 0, 0, extJsonStr, lastMsg.getMsgType(), lastMsg.isFullPushMsg(), isFromCChannel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x05a4, code lost:
        r10 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x052a, code lost:
        r6 = r4;
        r10 = r17;
        r1 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleFansGroupSystemMessage(java.util.ArrayList<com.baidu.android.imsdk.chatmessage.messages.ChatMsg> r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            if (r1 == 0) goto L_0x063e
            int r2 = r31.size()
            if (r2 != 0) goto L_0x000e
            goto L_0x063e
        L_0x000e:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            java.lang.Object r14 = r1.get(r13)
            com.baidu.android.imsdk.chatmessage.messages.ChatMsg r14 = (com.baidu.android.imsdk.chatmessage.messages.ChatMsg) r14
            long r14 = r14.getContacter()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r15.add(r14)
            android.content.Context r13 = mContext
            java.util.ArrayList r13 = com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.getGroupInfo(r13, r15)
            if (r13 == 0) goto L_0x0055
            int r16 = r13.size()
            if (r16 <= 0) goto L_0x0055
            r1 = 0
            java.lang.Object r16 = r13.get(r1)
            r1 = r16
            com.baidu.android.imsdk.group.GroupInfo r1 = (com.baidu.android.imsdk.group.GroupInfo) r1
            long r2 = r1.getMembersVersion()
            long r4 = r1.getInfoVersion()
        L_0x0055:
            r1 = 0
            java.util.Iterator r16 = r31.iterator()
        L_0x005a:
            boolean r17 = r16.hasNext()
            r18 = r1
            if (r17 == 0) goto L_0x05b3
            java.lang.Object r17 = r16.next()
            r1 = r17
            com.baidu.android.imsdk.chatmessage.messages.ChatMsg r1 = (com.baidu.android.imsdk.chatmessage.messages.ChatMsg) r1
            r17 = r10
            r10 = 57
            r1.setChatType(r10)
            int r10 = r1.getMsgType()
            r20 = r11
            r21 = r12
            switch(r10) {
                case 1001: goto L_0x059a;
                case 1002: goto L_0x0532;
                case 1003: goto L_0x04a5;
                case 1004: goto L_0x040c;
                case 1005: goto L_0x03d2;
                case 1012: goto L_0x034c;
                case 1013: goto L_0x033e;
                case 1014: goto L_0x0323;
                case 1015: goto L_0x02c6;
                case 1016: goto L_0x02b8;
                case 1017: goto L_0x0215;
                case 1018: goto L_0x01d4;
                case 1019: goto L_0x01ae;
                case 1020: goto L_0x0194;
                case 1021: goto L_0x0176;
                case 1022: goto L_0x0176;
                case 1023: goto L_0x0176;
                case 1024: goto L_0x0176;
                case 1025: goto L_0x014c;
                case 1026: goto L_0x0128;
                case 1027: goto L_0x0104;
                case 1028: goto L_0x00ea;
                case 1029: goto L_0x00d0;
                case 1031: goto L_0x00b1;
                case 1032: goto L_0x0092;
                case 5001: goto L_0x0084;
                default: goto L_0x007c;
            }
        L_0x007c:
            r25 = r2
            r28 = r4
            r11 = r13
            r12 = 0
            goto L_0x05a4
        L_0x0084:
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupReplyUpdateMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupReplyUpdateMsg) r11
            r0.handleGroupReplyMsgUpdate(r11)
            r25 = r2
            r28 = r4
            r11 = r13
            r12 = 0
            goto L_0x05a4
        L_0x0092:
            android.content.Context r11 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.activeGroupState(r11, r14)
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupMuteMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupMuteMsg) r11
            r22 = r13
            long r12 = r11.getGroupVersion()
            long r8 = java.lang.Math.max(r12, r8)
            r25 = r2
            r28 = r4
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x00b1:
            r22 = r13
            android.content.Context r11 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.activeGroupState(r11, r14)
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.PartialMuteMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.PartialMuteMsg) r11
            long r12 = r11.getMemberVersion()
            long r6 = java.lang.Math.max(r12, r6)
            r25 = r2
            r28 = r4
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x00d0:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.SetGroupWelcomeDisplayScopeMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.SetGroupWelcomeDisplayScopeMsg) r11
            long r12 = r11.getGroupVersion()
            long r8 = java.lang.Math.max(r12, r8)
            r25 = r2
            r28 = r4
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x00ea:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.SetGroupWelcomeMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.SetGroupWelcomeMsg) r11
            long r12 = r11.getGroupVersion()
            long r8 = java.lang.Math.max(r12, r8)
            r25 = r2
            r28 = r4
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x0104:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupClearNoticeMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupClearNoticeMsg) r11
            r11.setGroupId(r14)
            long r12 = r11.getInfoVersion()
            long r8 = java.lang.Math.max(r12, r8)
            com.baidu.android.imsdk.group.GroupMessageManagerImpl$5 r12 = new com.baidu.android.imsdk.group.GroupMessageManagerImpl$5
            r12.<init>(r11)
            r25 = r2
            r28 = r4
            r21 = r12
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x0128:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupSettingNoticeMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupSettingNoticeMsg) r11
            r11.setGroupId(r14)
            long r12 = r11.getInfoVersion()
            long r8 = java.lang.Math.max(r12, r8)
            com.baidu.android.imsdk.group.GroupMessageManagerImpl$4 r12 = new com.baidu.android.imsdk.group.GroupMessageManagerImpl$4
            r12.<init>(r11)
            r25 = r2
            r28 = r4
            r21 = r12
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x014c:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupJoinAuditCloseMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupJoinAuditCloseMsg) r11
            long r11 = r11.getGroupVersion()
            long r8 = java.lang.Math.max(r11, r8)
            r11 = 0
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            long r12 = r12.longValue()
            r23 = r8
            r8 = 0
            r0.updateAndNotifyApplyCount(r12, r8)
            r25 = r2
            r28 = r4
            r1 = r11
            r10 = r17
            r11 = r22
            r8 = r23
            r12 = 0
            goto L_0x05a8
        L_0x0176:
            r22 = r13
            r11 = 1024(0x400, float:1.435E-42)
            if (r10 != r11) goto L_0x0187
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupJoinAuditOpenMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupJoinAuditOpenMsg) r11
            long r11 = r11.getGroupVersion()
            long r8 = java.lang.Math.max(r11, r8)
        L_0x0187:
            r11 = 1
            r25 = r2
            r28 = r4
            r1 = r11
            r10 = r17
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x0194:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupUnbannedMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupUnbannedMsg) r11
            long r12 = r11.getInfoVersion()
            long r8 = java.lang.Math.max(r12, r8)
            r12 = 1
            r25 = r2
            r28 = r4
            r1 = r12
            r10 = r17
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x01ae:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupBannedMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.GroupBannedMsg) r11
            long r12 = r11.getInfoVersion()
            long r8 = java.lang.Math.max(r12, r8)
            r12 = 0
            r23 = r8
            long r8 = java.lang.Long.parseLong(r14)
            r13 = 0
            r0.updateAndNotifyApplyCount(r8, r13)
            r25 = r2
            r28 = r4
            r1 = r12
            r10 = r17
            r11 = r22
            r8 = r23
            r12 = 0
            goto L_0x05a8
        L_0x01d4:
            r22 = r13
            r11 = r1
            com.baidu.android.imsdk.chatmessage.messages.FansGroupCancelAdminMsg r11 = (com.baidu.android.imsdk.chatmessage.messages.FansGroupCancelAdminMsg) r11
            long r12 = r11.getMemberVersion()
            long r6 = java.lang.Math.max(r12, r6)
            long r12 = r11.getGroupVersion()
            long r8 = java.lang.Math.max(r12, r8)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            long r23 = r11.getMember()
            java.lang.String r13 = java.lang.String.valueOf(r23)
            r12.add(r13)
            com.baidu.android.imsdk.group.GroupMessageManagerImpl$1 r13 = new com.baidu.android.imsdk.group.GroupMessageManagerImpl$1
            r13.<init>(r11)
            r23 = r6
            r6 = 1018(0x3fa, float:1.427E-42)
            r0.handleGroupRoleChanged(r6, r1)
            r25 = r2
            r28 = r4
            r10 = r12
            r20 = r13
            r1 = r18
            r11 = r22
            r6 = r23
            r12 = 0
            goto L_0x05a8
        L_0x0215:
            r22 = r13
            r13 = r1
            com.baidu.android.imsdk.chatmessage.messages.FansSetOwnerMsg r13 = (com.baidu.android.imsdk.chatmessage.messages.FansSetOwnerMsg) r13
            java.lang.String r11 = r13.getOldOwner()
            java.lang.String r12 = r13.getNewOwner()
            boolean r25 = android.text.TextUtils.isEmpty(r11)
            if (r25 != 0) goto L_0x02b3
            boolean r25 = android.text.TextUtils.isEmpty(r12)
            if (r25 == 0) goto L_0x0234
            r25 = r2
            r28 = r4
            goto L_0x02b7
        L_0x0234:
            java.util.ArrayList r25 = new java.util.ArrayList
            r25.<init>()
            r26 = r25
            java.util.ArrayList r25 = new java.util.ArrayList
            r25.<init>()
            r27 = r25
            r28 = r4
            r4 = 0
            long r23 = com.baidu.android.imsdk.utils.Utility.getLongByString(r11, r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r23)
            r5 = r26
            r5.add(r4)
            r25 = r2
            r2 = 0
            long r2 = com.baidu.android.imsdk.utils.Utility.getLongByString(r12, r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = r27
            r3.add(r2)
            android.content.Context r2 = mContext
            r4 = 0
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.updateGroupMembersRole(r2, r14, r5, r4)
            android.content.Context r2 = mContext
            r4 = 1
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.updateGroupMembersRole(r2, r14, r3, r4)
            android.content.Context r2 = mContext
            java.lang.String r2 = com.baidu.android.imsdk.account.AccountManager.getUid(r2)
            boolean r4 = android.text.TextUtils.equals(r11, r2)
            if (r4 != 0) goto L_0x0282
            boolean r4 = android.text.TextUtils.equals(r12, r2)
            if (r4 == 0) goto L_0x0287
        L_0x0282:
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0287:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r11)
            r4.add(r12)
            r23 = r2
            r19 = r3
            long r2 = r13.getGroupMemberVersion()
            long r2 = java.lang.Math.max(r2, r6)
            com.baidu.android.imsdk.group.GroupMessageManagerImpl$3 r6 = new com.baidu.android.imsdk.group.GroupMessageManagerImpl$3
            r6.<init>(r13)
            r7 = 1017(0x3f9, float:1.425E-42)
            r0.handleGroupRoleChanged(r7, r1)
            r10 = r4
            r20 = r6
            r1 = r18
            r11 = r22
            r12 = 0
            r6 = r2
            goto L_0x05a8
        L_0x02b3:
            r25 = r2
            r28 = r4
        L_0x02b7:
            return
        L_0x02b8:
            r25 = r2
            r28 = r4
            r22 = r13
            r0.handleDeleteMsg(r1)
            r11 = r22
            r12 = 0
            goto L_0x05a4
        L_0x02c6:
            r25 = r2
            r28 = r4
            r22 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.FansSetAdminMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.FansSetAdminMsg) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r4 = r2.getBduids()
            if (r4 == 0) goto L_0x02fc
            java.util.List r4 = r2.getBduids()
            java.util.Iterator r4 = r4.iterator()
        L_0x02e2:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02fc
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            r11 = 0
            long r23 = com.baidu.android.imsdk.utils.Utility.getLongByString(r5, r11)
            java.lang.Long r13 = java.lang.Long.valueOf(r23)
            r3.add(r13)
            goto L_0x02e2
        L_0x02fc:
            long r4 = r2.getMemberVersion()
            long r4 = java.lang.Math.max(r4, r6)
            long r6 = r2.getGroupVersion()
            long r6 = java.lang.Math.max(r6, r8)
            com.baidu.android.imsdk.group.GroupMessageManagerImpl$2 r8 = new com.baidu.android.imsdk.group.GroupMessageManagerImpl$2
            r8.<init>(r2)
            r9 = 1015(0x3f7, float:1.422E-42)
            r0.handleGroupRoleChanged(r9, r2)
            r20 = r8
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            r8 = r6
            r6 = r4
            goto L_0x05a8
        L_0x0323:
            r25 = r2
            r28 = r4
            r22 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.FansInfoUpdateMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.FansInfoUpdateMsg) r2
            long r3 = r2.getInfoVersion()
            long r3 = java.lang.Math.max(r3, r8)
            r8 = r3
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x033e:
            r25 = r2
            r28 = r4
            r22 = r13
            r0.handleDisbandMsg(r1)
            r11 = r22
            r12 = 0
            goto L_0x05a4
        L_0x034c:
            r25 = r2
            r28 = r4
            r22 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupMemberNameChangeMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.GroupMemberNameChangeMsg) r2
            long r3 = r2.getMemberVersion()
            int r3 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x03c0
            java.lang.String r3 = r2.memberChangedid()
            android.content.Context r4 = mContext
            java.lang.String r5 = r2.getNickname()
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.updateMemberNickName(r4, r14, r3, r5)
            android.content.Context r4 = mContext
            long r11 = r1.getContacter()
            r5 = 1
            com.baidu.android.imsdk.chatmessage.ChatSession r4 = com.baidu.android.imsdk.chatmessage.ChatMsgManager.getChatSession(r4, r5, r11)
            if (r4 == 0) goto L_0x03c0
            long r11 = r4.getLastMsgUid()
            java.lang.String r5 = java.lang.String.valueOf(r11)
            boolean r5 = android.text.TextUtils.equals(r3, r5)
            if (r5 == 0) goto L_0x03c0
            java.lang.String r5 = r2.getNickname()
            r4.setLastMsgSenderName(r5)
            java.lang.String r5 = TAG
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "handleFansGroupSystemMessage-certDebug-session: "
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = r4.getName()
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = ", chatType: "
            java.lang.StringBuilder r11 = r11.append(r12)
            int r12 = r4.getChatType()
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r5, r11)
            android.content.Context r5 = mContext
            com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager r5 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.getInstance(r5)
            r11 = 4
            r5.updateChatSession(r11, r4)
        L_0x03c0:
            long r3 = r2.getMemberVersion()
            long r3 = java.lang.Math.max(r3, r6)
            r6 = r3
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x03d2:
            r25 = r2
            r28 = r4
            r22 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupInfoChangeMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.GroupInfoChangeMsg) r2
            long r3 = r2.getInfoVersion()
            int r3 = (r3 > r28 ? 1 : (r3 == r28 ? 0 : -1))
            if (r3 <= 0) goto L_0x03fa
            android.content.Context r3 = mContext
            java.lang.String r4 = r2.getGroupname()
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.modifyGroupName(r3, r14, r4)
            android.content.Context r3 = mContext
            com.baidu.android.imsdk.conversation.ConversationManagerImpl r3 = com.baidu.android.imsdk.conversation.ConversationManagerImpl.getInstance(r3)
            java.lang.String r4 = r2.getGroupname()
            r5 = 1
            r3.updateConversationName(r4, r5, r14)
        L_0x03fa:
            long r3 = r2.getInfoVersion()
            long r3 = java.lang.Math.max(r3, r8)
            r8 = r3
            r10 = r17
            r1 = r18
            r11 = r22
            r12 = 0
            goto L_0x05a8
        L_0x040c:
            r25 = r2
            r28 = r4
            r22 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg) r2
            java.util.ArrayList r3 = r2.getMemberBuids()
            android.content.Context r4 = mContext
            java.lang.String r4 = com.baidu.android.imsdk.account.AccountManager.getUid(r4)
            boolean r4 = r3.contains(r4)
            if (r4 == 0) goto L_0x045b
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            long r4 = r4.longValue()
            r11 = 0
            r0.updateAndNotifyApplyCount(r4, r11)
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            long r4 = r4.longValue()
            r0.updateSessionLastMsgOnCurrentUserOut(r10, r4)
            long r4 = r2.getContacter()
            r0.quitGroupByGroupIdAndRetainSession(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r1)
            android.content.Context r5 = mContext
            com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl r5 = com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.getInstance(r5)
            android.content.Context r11 = mContext
            r5.broadDeleteGroupMsg(r11, r4)
            r11 = r22
            r12 = 0
            goto L_0x05a4
        L_0x045b:
            long r4 = r2.getMemberVersion()
            int r4 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r4 <= 0) goto L_0x0471
            android.content.Context r4 = mContext
            int r5 = r2.getGroupnum()
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.modifyGroupMemberNumber(r4, r14, r5)
            android.content.Context r4 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.delGroupMember(r4, r14, r3)
        L_0x0471:
            long r4 = r2.getMemberVersion()
            long r4 = java.lang.Math.max(r4, r6)
            android.content.Context r6 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.activeGroupState(r6, r14)
            if (r22 == 0) goto L_0x04a1
            int r6 = r22.size()
            if (r6 <= 0) goto L_0x04a1
            r11 = r22
            r6 = 0
            java.lang.Object r7 = r11.get(r6)
            com.baidu.android.imsdk.group.GroupInfo r7 = (com.baidu.android.imsdk.group.GroupInfo) r7
            int r6 = r7.getGroupCapacity()
            int r7 = r2.getGroupnum()
            if (r6 <= r7) goto L_0x052a
            r6 = 1
            r1 = r6
            r10 = r17
            r12 = 0
            r6 = r4
            goto L_0x05a8
        L_0x04a1:
            r11 = r22
            goto L_0x052a
        L_0x04a5:
            r25 = r2
            r28 = r4
            r11 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg) r2
            java.lang.String r3 = r2.getQuitBuid()
            android.content.Context r4 = mContext
            java.lang.String r4 = com.baidu.android.imsdk.account.AccountManager.getUid(r4)
            boolean r4 = android.text.TextUtils.equals(r3, r4)
            if (r4 == 0) goto L_0x04d2
            long r4 = r2.getContacter()
            r0.quitGroupByGroupId(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            long r4 = r4.longValue()
            r12 = 0
            r0.updateAndNotifyApplyCount(r4, r12)
            goto L_0x05a4
        L_0x04d2:
            long r4 = r2.getMemberVersion()
            long r4 = java.lang.Math.max(r4, r6)
            long r6 = r2.getMemberVersion()
            int r6 = (r6 > r25 ? 1 : (r6 == r25 ? 0 : -1))
            if (r6 <= 0) goto L_0x04f8
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r3)
            android.content.Context r7 = mContext
            int r12 = r2.getGroupnum()
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.modifyGroupMemberNumber(r7, r14, r12)
            android.content.Context r7 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.delGroupMember(r7, r14, r6)
        L_0x04f8:
            long r6 = r2.getContacter()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r7 = 0
            r0.removeMemberFromMap(r6, r7)
            android.content.Context r6 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.activeGroupState(r6, r14)
            if (r11 == 0) goto L_0x052a
            int r6 = r11.size()
            if (r6 <= 0) goto L_0x052a
            r6 = 0
            java.lang.Object r7 = r11.get(r6)
            com.baidu.android.imsdk.group.GroupInfo r7 = (com.baidu.android.imsdk.group.GroupInfo) r7
            int r6 = r7.getGroupCapacity()
            int r7 = r2.getGroupnum()
            if (r6 <= r7) goto L_0x052a
            r6 = 1
            r1 = r6
            r10 = r17
            r12 = 0
            r6 = r4
            goto L_0x05a8
        L_0x052a:
            r6 = r4
            r10 = r17
            r1 = r18
            r12 = 0
            goto L_0x05a8
        L_0x0532:
            r25 = r2
            r28 = r4
            r11 = r13
            r2 = r1
            com.baidu.android.imsdk.chatmessage.messages.GroupMemberJoinMsg r2 = (com.baidu.android.imsdk.chatmessage.messages.GroupMemberJoinMsg) r2
            java.lang.String r3 = r2.getMemberBuid()
            android.content.Context r4 = mContext
            java.lang.String r4 = com.baidu.android.imsdk.account.AccountManager.getUid(r4)
            boolean r4 = android.text.TextUtils.equals(r3, r4)
            if (r4 == 0) goto L_0x0550
            android.content.Context r4 = mContext
            r5 = 0
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.setGroupState(r4, r14, r5)
        L_0x0550:
            long r4 = r2.getMemberVersion()
            int r4 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r4 <= 0) goto L_0x0561
            android.content.Context r4 = mContext
            int r5 = r2.getGroupnum()
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.modifyGroupMemberNumber(r4, r14, r5)
        L_0x0561:
            android.content.Context r4 = mContext
            com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.activeGroupState(r4, r14)
            long r4 = r2.getMemberVersion()
            long r4 = java.lang.Math.max(r4, r6)
            if (r11 == 0) goto L_0x0593
            int r6 = r11.size()
            if (r6 <= 0) goto L_0x0593
            r12 = 0
            java.lang.Object r6 = r11.get(r12)
            com.baidu.android.imsdk.group.GroupInfo r6 = (com.baidu.android.imsdk.group.GroupInfo) r6
            int r6 = r6.getGroupCapacity()
            int r7 = r2.getGroupnum()
            if (r6 > r7) goto L_0x0594
            java.lang.Long r6 = java.lang.Long.valueOf(r14)
            long r6 = r6.longValue()
            r0.updateAndNotifyApplyCount(r6, r12)
            goto L_0x0594
        L_0x0593:
            r12 = 0
        L_0x0594:
            r6 = r4
            r10 = r17
            r1 = r18
            goto L_0x05a8
        L_0x059a:
            r25 = r2
            r28 = r4
            r11 = r13
            r12 = 0
            r0.handleFansAddMemberMsg(r1, r14)
        L_0x05a4:
            r10 = r17
            r1 = r18
        L_0x05a8:
            r13 = r11
            r11 = r20
            r12 = r21
            r2 = r25
            r4 = r28
            goto L_0x005a
        L_0x05b3:
            r25 = r2
            r28 = r4
            r17 = r10
            r20 = r11
            r21 = r12
            r11 = r13
            int r1 = (r28 > r8 ? 1 : (r28 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x05f3
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getFansGroupInfo sInfoVersion = "
            java.lang.StringBuilder r2 = r2.append(r3)
            r4 = r28
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r3 = " maxInfoVersion = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)
            android.content.Context r1 = mContext
            com.baidu.android.imsdk.group.GroupManagerImpl r1 = com.baidu.android.imsdk.group.GroupManagerImpl.getInstance(r1)
            r12 = r21
            r2 = 1
            r1.getFansGroupInfo(r15, r2, r12)
            goto L_0x05f7
        L_0x05f3:
            r12 = r21
            r4 = r28
        L_0x05f7:
            int r1 = (r25 > r6 ? 1 : (r25 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x0630
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getFansGroupMember sMemberVersion = "
            java.lang.StringBuilder r2 = r2.append(r3)
            r28 = r4
            r3 = r25
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r5 = " maxMemberVersion = "
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)
            android.content.Context r1 = mContext
            com.baidu.android.imsdk.group.GroupManagerImpl r1 = com.baidu.android.imsdk.group.GroupManagerImpl.getInstance(r1)
            r10 = r17
            r2 = r20
            r5 = 1
            r1.getFansGroupMember(r14, r10, r5, r2)
            goto L_0x0638
        L_0x0630:
            r28 = r4
            r10 = r17
            r2 = r20
            r3 = r25
        L_0x0638:
            if (r18 == 0) goto L_0x063d
            r0.fetchAndNotifyGroupJoinApplyCountIfNeed(r14)
        L_0x063d:
            return
        L_0x063e:
            java.lang.String r1 = TAG
            java.lang.String r2 = "handleGroupSystemMessage msg is null"
            com.baidu.android.imsdk.utils.LogUtils.d(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.group.GroupMessageManagerImpl.handleFansGroupSystemMessage(java.util.ArrayList):void");
    }

    private void handleGroupReplyMsgUpdate(GroupReplyUpdateMsg replyMsgUpdateSystemMsg) {
        long groupId = replyMsgUpdateSystemMsg.getGroupId();
        long replyMsgId = replyMsgUpdateSystemMsg.getMsgId();
        if (groupId > 0 && replyMsgId > 0) {
            int msgRepliedStatus = replyMsgUpdateSystemMsg.getMsgRepliedStatus();
            String msgRepliedStatusText = replyMsgUpdateSystemMsg.getMsgRepliedStatusDisplayText();
            ChatMsg chatMsg = GroupMessageDAOImpl.fetchChatMsgByMsgId(mContext, String.valueOf(groupId), replyMsgId);
            if (chatMsg == null || TextUtils.isEmpty(chatMsg.getMsgContent()) || chatMsg.getMsgType() == 1030) {
                LogUtils.d(TAG, "handleGroupReplyMsgUpdate chat msg invalid:" + (chatMsg == null));
                return;
            }
            String updatedMsgContentJson = MsgRepliedData.getUpdatedMsgContent(chatMsg.getMsgContent(), msgRepliedStatus, msgRepliedStatusText);
            if (!TextUtils.isEmpty(updatedMsgContentJson) && GroupMessageDAOImpl.updateMsgContent(mContext, String.valueOf(groupId), replyMsgId, updatedMsgContentJson) > 0) {
                chatMsg.setMsgContent(updatedMsgContentJson);
                ChatMsgManagerImpl.getInstance(mContext).sendMsgUpdatedBroadcast(mContext, chatMsg);
            }
        }
    }

    private void fetchAndNotifyGroupJoinApplyCountIfNeed(String groupId) {
        if (!TextUtils.isEmpty(groupId)) {
            new ArrayList<>().add(groupId);
            GroupJoinApplyBiz.fetchJoinGroupApplyCountIfNeed(mContext, groupId, new BIMValuesCallBack<Long, Integer>() {
                public void onResult(int responseCode, String errMsg, Long groupId, Integer applyCount) {
                    if (responseCode == 0 && groupId.longValue() > 0) {
                        GroupMessageManagerImpl.this.updateAndNotifyApplyCount(groupId.longValue(), applyCount.intValue());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateAndNotifyApplyCount(long groupId, int count) {
        if (groupId > 0) {
            GroupUpdateManager.getInstance(mContext).onApplyCountChanged(groupId, count);
            updateAndNotifyChatSession(groupId, count);
        }
    }

    private void updateSessionLastMsgOnCurrentUserOut(int systemMsgType, long groupId) {
        String lastMsg = "";
        if (systemMsgType == 1004) {
            lastMsg = "你被群主移出群聊";
        } else if (systemMsgType == 1013) {
            lastMsg = "群主已解散群聊";
        }
        if (!TextUtils.isEmpty(lastMsg)) {
            LogUtils.d(TAG, "updateSessionLastMsgOnCurrentUserOut lastMsg = " + lastMsg);
            ContentValues values = new ContentValues();
            values.put("last_msg", lastMsg);
            values.put("last_msg_name", "");
            values.put("last_msg_bduid", 0L);
            ChatMessageDBManager.getInstance(mContext).updateChatRecordInternalAndNotify(values, "category =? AND contacter = ?", new String[]{String.valueOf(1), String.valueOf(groupId)}, 4);
        }
    }

    public void updateAndNotifyChatSession(long groupId, int joinApplyCount) {
        ChatSession chatSession = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(1, groupId);
        if (chatSession != null) {
            chatSession.addExt(GroupSessionManager.KEY_GROUP_APPLY_COUNT, String.valueOf(joinApplyCount));
            ChatSessionManagerImpl.getInstance(mContext).updateUserSessionExtAndNotify(1, groupId, chatSession.getExt());
        }
    }

    /* access modifiers changed from: package-private */
    public void handleGroupRoleChanged(int type, ChatMsg msg) {
        handleRemindMsgByChangeRole(type, msg);
        handleGroupApplyCountRemind(type, msg);
    }

    private void handleGroupApplyCountRemind(int type, ChatMsg msg) {
        long groupId = msg.getContacter();
        if (groupId > 0) {
            String currentLoginUserId = AccountManager.getUid(mContext);
            if (type == 1017) {
                FansSetOwnerMsg setOwnerMsg = (FansSetOwnerMsg) msg;
                long oldOwner = Utility.getLongByString(setOwnerMsg.getOldOwner(), 0);
                long newOwner = Utility.getLongByString(setOwnerMsg.getNewOwner(), 0);
                if (oldOwner != 0 && newOwner != 0 && setOwnerMsg.getContacter() > 0) {
                    if (TextUtils.equals(String.valueOf(newOwner), currentLoginUserId)) {
                        fetchAndNotifyGroupJoinApplyCountIfNeed(String.valueOf(groupId));
                    } else if (TextUtils.equals(String.valueOf(oldOwner), currentLoginUserId)) {
                        updateAndNotifyApplyCount(groupId, 0);
                    }
                }
            } else if (type == 1018) {
                long cancelAdminUid = ((FansGroupCancelAdminMsg) msg).getMember();
                if (cancelAdminUid > 0 && TextUtils.equals(currentLoginUserId, String.valueOf(cancelAdminUid))) {
                    updateAndNotifyApplyCount(groupId, 0);
                }
            } else if (type == 1015 && ((FansSetAdminMsg) msg).getBduids().contains(currentLoginUserId)) {
                fetchAndNotifyGroupJoinApplyCountIfNeed(String.valueOf(groupId));
            }
        }
    }

    private void handleRemindMsgByChangeRole(int type, ChatMsg msg) {
        int i2 = type;
        ChatSession chatSession = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(1, msg.getContacter());
        if (chatSession != null) {
            if (i2 == 1017) {
                FansSetOwnerMsg setOwnerMsg = (FansSetOwnerMsg) msg;
                long oldOwner = Utility.getLongByString(setOwnerMsg.getOldOwner(), 0);
                long newOwner = Utility.getLongByString(setOwnerMsg.getNewOwner(), 0);
                if (oldOwner != 0 && newOwner != 0) {
                    if (oldOwner == chatSession.getRemindUid()) {
                        if (chatSession.getRemindType() == 2) {
                            chatSession.setRemindType(1);
                            chatSession.setRemindRoleDisplayName("");
                        } else if (chatSession.getRemindType() == 4) {
                            chatSession.setRemindMsgId(0);
                            chatSession.setRemindRoleDisplayName("");
                            chatSession.setRemindUid(0);
                            chatSession.setRemindType(0);
                        }
                    }
                    if (newOwner == chatSession.getRemindUid()) {
                        GroupMember creator = getGroupOwner(String.valueOf(chatSession.getContacter()));
                        String ownerDisplayName = creator == null ? "群主" : creator.getRoleDisplayName();
                        if (chatSession.getRemindType() == 1) {
                            chatSession.setRemindType(2);
                            chatSession.setRemindRoleDisplayName(ownerDisplayName);
                        } else if (chatSession.getRemindType() == 5) {
                            chatSession.setRemindRoleDisplayName(ownerDisplayName);
                            chatSession.setRemindType(4);
                        }
                    }
                    chatSession.setHandlerChangeRole(true);
                    ChatMessageDBManager.getInstance(mContext).updateChatSession(4, chatSession);
                } else {
                    return;
                }
            } else if (i2 == 1018 && chatSession.getRemindUid() == ((FansGroupCancelAdminMsg) msg).getMember()) {
                chatSession.setRemindMsgId(0);
                chatSession.setRemindRoleDisplayName("");
                chatSession.setRemindUid(0);
                chatSession.setRemindType(0);
                chatSession.setHandlerChangeRole(true);
                ChatMessageDBManager.getInstance(mContext).updateChatSession(4, chatSession);
            }
            removeMemberFromMap(String.valueOf(chatSession.getContacter()), (GroupMember) null);
        }
    }

    private void handleFansAddMemberMsg(ChatMsg msg, String groupId) {
        String groupid = String.valueOf(msg.getContacter());
        GroupMemberAddMsg joinmsg = (GroupMemberAddMsg) msg;
        ArrayList<String> addedbuids = joinmsg.getMemberBuids();
        String str = TAG;
        LogUtils.d(str, "handleAddMemberMsg " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + addedbuids.toString());
        String operator = joinmsg.getOperator();
        LogUtils.d(str, "operator : (" + operator + ") and uid : (" + AccountManager.getUid(mContext) + ")");
        if ((addedbuids != null && addedbuids.size() > 0 && addedbuids.contains(AccountManager.getUid(mContext))) || AccountManager.getUid(mContext).equals(operator)) {
            GroupInfoDAOImpl.activeGroupState(mContext, groupid);
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, joinmsg.getGroupnum());
        GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, groupid, msg.getGroupType());
        ArrayList<ChatMsg> msgs = new ArrayList<>();
        msgs.add(msg);
        ChatMsgManagerImpl.getInstance(mContext).sendMessageBroadcast(mContext, msgs);
    }

    private void handleGroupSystemMessage(ChatMsg msg) {
        if (msg == null) {
            LogUtils.d(TAG, "handleGroupSystemMessage msg is null");
            return;
        }
        LogUtils.d(TAG, "handleGroupSystemMessage msg type is " + msg.getMsgType());
        switch (msg.getMsgType()) {
            case 1001:
                handleAddMemberMsg(msg);
                return;
            case 1002:
                handleJoinGroupMsg(msg);
                return;
            case 1003:
                handleQuitGroupMsg(msg);
                return;
            case 1004:
                handleDeleteMemberMsg(msg);
                return;
            case 1005:
                handleChangeGroupInfoMsg(msg);
                return;
            case 1007:
                handleStartJoin(msg);
                return;
            case 1008:
                handleMasterChange(msg);
                return;
            case 1009:
                handleDeleteGroup(msg);
                return;
            case 1010:
                handlePermitGroup(msg);
                return;
            case 1011:
                handleAllowGroup(msg);
                return;
            case 1012:
                handleMemberNameChange(msg);
                return;
            case 1016:
                handleDeleteMsg(msg);
                return;
            case 1019:
            case 1020:
                handleGroupBandStateChangeMsg(msg);
                return;
            case 5001:
                handleGroupReplyMsgUpdate((GroupReplyUpdateMsg) msg);
                return;
            default:
                return;
        }
    }

    private void handleDisbandMsg(ChatMsg msg) {
        GroupDisbandMsg disbandMsg = (GroupDisbandMsg) msg;
        try {
            LogUtils.d(TAG, "GroupMessageManager GroupDisbandMsg");
            long groupId = disbandMsg.getContacter();
            quitGroupByGroupIdAndRetainSession(groupId);
            ArrayList<ChatMsg> msgs = new ArrayList<>();
            msgs.add(msg);
            ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, msgs);
            updateSessionLastMsgOnCurrentUserOut(1013, groupId);
        } catch (Exception e2) {
            LogUtils.d(TAG, "handleDisbandMsg exception, this is normal for device sync logic");
        }
    }

    private void handleStartJoin(ChatMsg msg) {
        String str = TAG;
        LogUtils.d(str, "STAR handleStartJoin " + msg.toString());
        GroupStarJoinMsg joinmsg = (GroupStarJoinMsg) msg;
        String groupid = String.valueOf(joinmsg.getContacter());
        ArrayList<String> addedbuids = joinmsg.getMemberBuid();
        LogUtils.d(str, "handlestarJoinGroupMsg " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + addedbuids);
        if (addedbuids.contains(AccountManager.getUid(mContext))) {
            GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, groupid, msg.getGroupType());
            GroupInfoDAOImpl.activeGroupState(mContext, groupid);
            if (msg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, groupid, 1);
            }
        } else {
            GroupInfoSyncManagerImpl.addSyncGroupMemeber(groupid, addedbuids);
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, joinmsg.getGroupnum());
        ArrayList<String> delmembers = joinmsg.getPushoutBuid();
        if (delmembers != null && delmembers.size() > 0) {
            GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(groupid, delmembers);
            LogUtils.d(str, "handlestarJoinGroupMsg " + delmembers);
            if (delmembers.contains(AccountManager.getUid(mContext))) {
                LogUtils.d(str, "handleDeleteMemberMsg " + groupid + " loginuser was kicked out");
                GroupInfoDAOImpl.deletedGroupMember(mContext, groupid);
                GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, 0);
                return;
            }
            GroupInfoDAOImpl.delGroupMember(mContext, groupid, delmembers);
        }
    }

    private void handleMasterChange(ChatMsg msg) {
        String str = TAG;
        LogUtils.d(str, "STAR handleMasterChange " + msg.toString());
        GroupStarMasterUpdateMsg joinmsg = (GroupStarMasterUpdateMsg) msg;
        String groupid = String.valueOf(joinmsg.getContacter());
        ArrayList<String> addedbuids = joinmsg.getAddedMemberBuids();
        LogUtils.d(str, "handleMasterChange " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + addedbuids);
        if (addedbuids.contains(AccountManager.getUid(mContext))) {
            GroupInfoDAOImpl.activeGroupState(mContext, groupid);
            if (msg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, groupid, 1);
            }
        }
        LogUtils.d(str, "STAR updateMasterAsCommon " + GroupInfoDAOImpl.updateMasterAsCommon(mContext, groupid, 0));
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, joinmsg.getGroupnum());
        GroupInfoSyncManagerImpl.addSyncGroupMemeber(groupid, addedbuids);
        ArrayList<String> delmembers = joinmsg.getPushoutBuid();
        if (delmembers != null && delmembers.size() > 0) {
            GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(groupid, delmembers);
            LogUtils.d(str, "handleMasterChange " + delmembers);
            if (delmembers.contains(AccountManager.getUid(mContext))) {
                LogUtils.d(str, "handleMasterChange " + groupid + " loginuser was kicked out");
                GroupInfoDAOImpl.deletedGroupMember(mContext, groupid);
                GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, 0);
                return;
            }
            GroupInfoDAOImpl.delGroupMember(mContext, groupid, delmembers);
        }
    }

    private void handleDeleteGroup(ChatMsg msg) {
        long id = ((GroupStarAlertMsg) msg).getGroupid();
        String groupid = String.valueOf(id);
        String str = TAG;
        LogUtils.d(str, "STAR handleDeleteGroup " + id);
        try {
            GroupInfoDAOImpl.deletedGroupMember(mContext, groupid);
            LogUtils.d(str, "handleDeleteGroup quitgroup");
            quitGroupByGroupIdAndRetainSession(id);
            ArrayList<ChatMsg> msgs = new ArrayList<>();
            msgs.add(msg);
            ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, msgs);
        } catch (Exception e2) {
            LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
        }
    }

    private void handlePermitGroup(ChatMsg msg) {
        String groupid = String.valueOf(((GroupStarAlertMsg) msg).getGroupid());
        LogUtils.d(TAG, "STAR handlePermitGroup " + groupid + "  ret=" + GroupInfoDAOImpl.setGroupPermit(mContext, groupid, 1));
    }

    private void handleAllowGroup(ChatMsg msg) {
        String groupid = String.valueOf(((GroupStarAlertMsg) msg).getGroupid());
        LogUtils.d(TAG, "STAR handlePermitGroup " + groupid + "  ret=" + GroupInfoDAOImpl.setGroupPermit(mContext, groupid, 0));
    }

    private void handleAddMemberMsg(ChatMsg msg) {
        String groupid = String.valueOf(msg.getContacter());
        GroupMemberAddMsg joinmsg = (GroupMemberAddMsg) msg;
        ArrayList<String> addedbuids = joinmsg.getMemberBuids();
        String str = TAG;
        LogUtils.d(str, "handleAddMemberMsg " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + addedbuids.toString());
        String operator = joinmsg.getOperator();
        LogUtils.d(str, "operator : (" + operator + ") and uid : (" + AccountManager.getUid(mContext) + ")");
        if (AccountManager.getUid(mContext).equals(operator)) {
            GroupInfoDAOImpl.activeGroupState(mContext, groupid);
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, joinmsg.getGroupnum());
        if (addedbuids.contains(AccountManager.getUid(mContext))) {
            GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, groupid, msg.getGroupType());
        } else {
            GroupInfoSyncManagerImpl.addSyncGroupMemeber(groupid, addedbuids);
        }
    }

    private void handleJoinGroupMsg(ChatMsg msg) {
        GroupMemberJoinMsg joinmsg = (GroupMemberJoinMsg) msg;
        String groupid = String.valueOf(joinmsg.getContacter());
        String addedbuid = joinmsg.getMemberBuid();
        LogUtils.d(TAG, "handleJoinGroupMsg " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + addedbuid);
        if (addedbuid.contains(AccountManager.getUid(mContext))) {
            GroupInfoDAOImpl.activeGroupState(mContext, groupid);
            if (msg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, groupid, 1);
            }
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, joinmsg.getGroupnum());
        ArrayList<String> addedbuids = new ArrayList<>();
        addedbuids.add(addedbuid);
        GroupInfoSyncManagerImpl.addSyncGroupMemeber(groupid, addedbuids);
    }

    private void handleDeleteMemberMsg(ChatMsg msg) {
        GroupMemberDelMsg delmsg = (GroupMemberDelMsg) msg;
        String groupid = String.valueOf(delmsg.getContacter());
        ArrayList<String> members = delmsg.getMemberBuids();
        String str = TAG;
        LogUtils.d(str, "handleDeleteMemberMsg " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + members.toString());
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, delmsg.getGroupnum());
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(groupid, members);
        GroupInfoDAOImpl.delGroupMember(mContext, groupid, members);
        if (!members.contains(AccountManager.getUid(mContext))) {
            return;
        }
        if (msg.isStarMessage()) {
            try {
                quitGroupByGroupIdAndRetainSession(delmsg.getContacter());
            } catch (Exception e2) {
                LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
            }
            ArrayList<ChatMsg> msgs = new ArrayList<>();
            msgs.add(msg);
            ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, msgs);
            return;
        }
        LogUtils.d(str, "handleDeleteMemberMsg " + groupid + " loginuser was kicked out");
        GroupInfoDAOImpl.deletedGroupMember(mContext, groupid);
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, 0);
    }

    private void handleQuitGroupMsg(ChatMsg msg) {
        String str = TAG;
        LogUtils.d(str, "STAR handleQuitGroupMsg");
        GroupMemberQuitMsg quitmsg = (GroupMemberQuitMsg) msg;
        String groupid = String.valueOf(quitmsg.getContacter());
        String quitbuid = quitmsg.getQuitBuid();
        String newmaster = quitmsg.getNewMaster();
        if (quitbuid == null || !quitbuid.equals(AccountManager.getUid(mContext))) {
            ArrayList<String> quitbuids = new ArrayList<>();
            quitbuids.add(quitbuid);
            GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, groupid, quitmsg.getGroupnum());
            GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(groupid, quitbuids);
            LogUtils.d(str, "handleQuitGroupMsg " + groupid + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + quitbuids.toString());
            GroupInfoDAOImpl.delGroupMember(mContext, groupid, quitbuids);
            if (newmaster != null && !"".equals(newmaster.trim())) {
                GroupInfoDAOImpl.updateGroupMemberRole(mContext, groupid, newmaster, 1);
                return;
            }
            return;
        }
        try {
            quitGroupByGroupId(quitmsg.getContacter());
        } catch (Exception e2) {
            LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
        }
    }

    private void handleChangeGroupInfoMsg(ChatMsg msg) {
        GroupInfoChangeMsg groupinfomsg = (GroupInfoChangeMsg) msg;
        String groupid = String.valueOf(msg.getContacter());
        if (groupinfomsg.getGroupname() != null) {
            GroupInfoDAOImpl.modifyGroupName(mContext, groupid, groupinfomsg.getGroupname());
            ConversationManagerImpl.getInstance(mContext).updateConversationName(groupinfomsg.getGroupname(), 1, groupid);
        }
    }

    private void handleMemberNameChange(ChatMsg msg) {
        GroupMemberNameChangeMsg namechangemsg = (GroupMemberNameChangeMsg) msg;
        String groupid = String.valueOf(msg.getContacter());
        String buid = namechangemsg.memberChangedid();
        int ret = GroupInfoDAOImpl.updateMemberNickName(mContext, groupid, buid, namechangemsg.getNickname());
        if (ret == 0) {
            LogUtils.d(TAG, "HHHandleMemberNameChange to --- update member nickname " + groupid + " " + buid);
            GroupInfoSyncManagerImpl.syncAllMembers(mContext, groupid);
        }
        LogUtils.d(TAG, "HHHandleMemberNameChange update member nickname " + ret);
    }

    private void handleDeleteMsg(ChatMsg msg) {
        ChatMsgManagerImpl.getInstance(mContext).broadDeleteMsg(mContext, msg);
    }

    private void handleGroupBandStateChangeMsg(ChatMsg msg) {
        String groupid = String.valueOf(msg.getContacter());
        GroupInfoSyncManagerImpl.addSyncGroupInfo(groupid);
        GroupInfoDAOImpl.activeGroupState(mContext, groupid);
    }

    public boolean isGroupNeedRetain(ChatMsg sessionLastMsg, int sessionDeleteStatus, long groupId) {
        String str = TAG;
        LogUtils.d(str, "isValidGroup sessionDeleteStatus:" + sessionDeleteStatus + ";groupId:" + groupId);
        if (sessionDeleteStatus <= -1) {
            return isValidGroup(sessionLastMsg);
        }
        if (sessionDeleteStatus != 1) {
            return true;
        }
        if (sessionLastMsg == null) {
            ArrayList<ChatMsg> msgs = GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(groupId), (ChatMsg) null, 1, true);
            ChatMsg groupLastMsg = null;
            if (msgs != null && msgs.size() > 0) {
                groupLastMsg = msgs.get(0);
            }
            if (groupLastMsg == null) {
                LogUtils.d(str, "isGroupNeedRetain local last msg is null");
                return true;
            } else if (groupLastMsg.getMsgType() == 1003) {
                return false;
            } else {
                return true;
            }
        } else if (sessionLastMsg.getMsgType() == 1003) {
            quitGroupByGroupId(groupId);
            return false;
        } else {
            quitGroupByGroupIdAndRetainSession(groupId);
            return true;
        }
    }

    public boolean isValidGroup(ChatMsg msg) {
        LogUtils.d(TAG, "isValidGroup");
        if (msg == null) {
            return true;
        }
        int msgType = msg.getMsgType();
        if (msgType != 1003 && msgType != 1013 && msgType != 1004) {
            return true;
        }
        long groupId = msg.getContacter();
        ArrayList<String> ids = new ArrayList<>();
        ids.add(String.valueOf(groupId));
        ArrayList<GroupInfo> infos = GroupInfoDAOImpl.getGroupInfo(mContext, ids);
        boolean hasDel = false;
        if (infos == null || infos.size() == 0) {
            hasDel = true;
        }
        if (msgType == 1003) {
            if (TextUtils.equals(((GroupMemberQuitMsg) msg).getQuitBuid(), AccountManager.getUid(mContext))) {
                if (hasDel) {
                    return false;
                }
                quitGroupByGroupId(groupId);
                return false;
            }
        } else if (msgType == 1013) {
            if (!hasDel) {
                quitGroupByGroupIdAndRetainSession(groupId);
            }
            return true;
        } else {
            if (msgType == 1004 && ((GroupMemberDelMsg) msg).getMemberBuids().contains(AccountManager.getUid(mContext)) && !hasDel) {
                quitGroupByGroupIdAndRetainSession(groupId);
            }
            return true;
        }
        return true;
    }

    private void quitGroupByGroupIdAndRetainSession(long groupId) {
        quitGroupByGroupId(groupId, true);
    }

    private void quitGroupByGroupId(long groupId) {
        quitGroupByGroupId(groupId, false);
    }

    private void quitGroupByGroupId(long groupId, boolean isRetainSession) {
        String str = TAG;
        LogUtils.d(str, "quitGroupByGroupId groupID = " + groupId + ";isRetainSession:" + isRetainSession);
        String sGroupId = String.valueOf(groupId);
        GroupInfoDAOImpl.quitGroup(mContext, sGroupId, isRetainSession);
        LogUtils.d(str, "quitGroupByGroupId groupID = " + groupId);
        if (!isRetainSession) {
            DialogRecordDBManager.getInstance(mContext).delete(1, groupId);
            ConversationManagerImpl.getInstance(mContext).deleteConversation(1, sGroupId);
        }
        this.mGroupMemberMap.remove(String.valueOf(groupId));
    }

    private List<GroupMember> getGroupCreatorAndAdmin(String groupId) {
        Map<String, List<GroupMember>> map = this.mGroupMemberMap;
        if (map == null) {
            return null;
        }
        List<GroupMember> members = map.get(groupId);
        if ((members == null || members.isEmpty()) && (members = GroupInfoDAOImpl.getGroupOwnerAndAdmins(mContext, groupId)) != null) {
            this.mGroupMemberMap.put(groupId, members);
        }
        return members;
    }

    private void removeMemberFromMap(String groupId, GroupMember member) {
        Map<String, List<GroupMember>> map = this.mGroupMemberMap;
        if (map != null) {
            if (member == null) {
                map.remove(groupId);
                return;
            }
            List<GroupMember> members = map.get(groupId);
            if (members != null && members.size() != 0) {
                LogUtils.d(TAG, "admin setting, removeMemberFromMap, groupid: " + groupId + ", member: " + member);
                members.remove(member);
            }
        }
    }

    public MultiplePair<Integer, Long, Long, String> getImportantReminderMsg(List<ChatMsg> msgs) {
        int type;
        List<ChatMsg> list = msgs;
        if (list == null || msgs.size() == 0) {
            return null;
        }
        for (int i2 = msgs.size() - 1; i2 >= 0; i2--) {
            ChatMsg msg = list.get(i2);
            if (msg != null) {
                if (msg.isMsgRead()) {
                    break;
                }
                boolean isFromCreator = isSendFromGroupCreator(msg);
                boolean isFromAdmin = isSendFromGroupAdmin(msg);
                boolean isAtCurrentUser = isAtCurrentUser(msg);
                boolean isGroupCoupon = isGroupCoupon(msg);
                if (isAtCurrentUser || isFromCreator || isFromAdmin || isGroupCoupon) {
                    long msgid = msg.getMsgId();
                    long senderUid = Utility.getLongByString(msg.getSenderUid(), 0);
                    String roleDisplayName = "";
                    if (isFromCreator || !isAtCurrentUser) {
                        roleDisplayName = getMemberRoleDisplayName(senderUid, String.valueOf(msg.getContacterId()));
                        if (isAtCurrentUser) {
                            type = 2;
                        } else if (isFromAdmin) {
                            type = 5;
                        } else {
                            type = 4;
                            if (isGroupCoupon) {
                                type = 3;
                            }
                        }
                    } else {
                        type = 1;
                    }
                    return new MultiplePair<>(Integer.valueOf(type), Long.valueOf(msgid), Long.valueOf(senderUid), roleDisplayName);
                }
            }
        }
        return null;
    }

    private boolean isSendFromGroupCreator(ChatMsg msg) {
        long uid = Utility.getLongByString(msg.getSenderUid(), 0);
        if (uid <= 0) {
            return false;
        }
        return checkMemberType(uid, String.valueOf(msg.getContacter()), 1);
    }

    public GroupMember getGroupOwner(String groupId) {
        List<GroupMember> members = getGroupCreatorAndAdmin(groupId);
        if (members == null || members.size() == 0) {
            return null;
        }
        for (GroupMember member : members) {
            if (member.getRole() == 1) {
                return member;
            }
        }
        return null;
    }

    public List<GroupMember> getGroupAdministrators(String groupId) {
        List<GroupMember> members = getGroupCreatorAndAdmin(groupId);
        if (members == null) {
            return null;
        }
        Iterator<GroupMember> iterator = members.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getRole() == 1) {
                iterator.remove();
            }
        }
        return members;
    }

    public boolean updateGroupMemberRole(String groupId, String uid, int role) {
        return GroupInfoDAOImpl.updateGroupMemberRole(mContext, groupId, uid, role) > 0;
    }

    public boolean updateGroupMemberMutedInfo(String groupId, List<String> uids, int mutedStatus, long mutedEndTime) {
        return GroupInfoDAOImpl.updateGroupMemberMutedInfo(mContext, groupId, uids, mutedStatus, mutedEndTime) > 0;
    }

    public boolean updateGroupMuted(String groupId, int mutedStatus) {
        return GroupInfoDAOImpl.updateGroupMuted(mContext, groupId, mutedStatus) > 0;
    }

    private boolean isSendFromGroupAdmin(ChatMsg msg) {
        long uid = Utility.getLongByString(msg.getSenderUid(), 0);
        if (uid <= 0) {
            return false;
        }
        String currentId = AccountManager.getUid(mContext);
        if (TextUtils.isEmpty(currentId) || TextUtils.equals(String.valueOf(uid), currentId)) {
            return false;
        }
        return checkMemberType(uid, String.valueOf(msg.getContacter()), 2);
    }

    private boolean isAtCurrentUser(ChatMsg msg) {
        String userId = AccountManager.getUid(mContext);
        if (msg.getMsgType() == 40 && ((FansGroupAtMsg) msg).isGroupAtUserById(userId)) {
            return true;
        }
        return false;
    }

    private boolean isGroupCoupon(ChatMsg msg) {
        if (msg == null) {
            return false;
        }
        long uid = Utility.getLongByString(msg.getSenderUid(), 0);
        if (uid <= 0) {
            return false;
        }
        String currentId = AccountManager.getUid(mContext);
        if (TextUtils.isEmpty(currentId) || TextUtils.equals(String.valueOf(uid), currentId) || msg.getMsgType() != 60) {
            return false;
        }
        return true;
    }

    private boolean checkMemberType(long fromUid, String groupId, int memberType) {
        List<GroupMember> members = getGroupCreatorAndAdmin(groupId);
        if (members == null || members.size() == 0) {
            return false;
        }
        for (GroupMember member : members) {
            if (member.getBduid() == fromUid && member.getRole() == memberType) {
                return true;
            }
        }
        return false;
    }

    private String getMemberRoleDisplayName(long fromUid, String groupId) {
        List<GroupMember> members = getGroupCreatorAndAdmin(groupId);
        if (members == null || members.size() == 0) {
            return "";
        }
        for (GroupMember member : members) {
            if (member.getBduid() == fromUid) {
                return member.getRoleDisplayName();
            }
        }
        return "";
    }
}
