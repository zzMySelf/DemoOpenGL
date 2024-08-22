package com.baidu.searchbox.permission;

import java.util.HashMap;

public class DangerousPermissionGroupFinder {
    private HashMap<String, String> mPermissionMap;

    public DangerousPermissionGroupFinder() {
        loadPermissionGroupInfo();
    }

    private void loadPermissionGroupInfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.mPermissionMap = hashMap;
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE");
        this.mPermissionMap.put("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE");
        this.mPermissionMap.put("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.CALL_PHONE", "android.permission-group.PHONE");
        this.mPermissionMap.put("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.USE_SIP", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS");
        this.mPermissionMap.put("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS");
        this.mPermissionMap.put("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS");
        this.mPermissionMap.put("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION");
        this.mPermissionMap.put("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION");
        this.mPermissionMap.put("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE");
        this.mPermissionMap.put("android.permission.SEND_SMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.RECEIVE_SMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.READ_SMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.RECEIVE_MMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.CAMERA", "android.permission-group.CAMERA");
        this.mPermissionMap.put("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR");
        this.mPermissionMap.put("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR");
        this.mPermissionMap.put("android.permission.BODY_SENSORS", "android.permission-group.SENSORS");
        this.mPermissionMap.put("android.permission.READ_CALL_LOG", DangerousPermissionManager.CALL_LOG_PERMISIION_GROUP);
        this.mPermissionMap.put("android.permission.WRITE_CALL_LOG", DangerousPermissionManager.CALL_LOG_PERMISIION_GROUP);
        this.mPermissionMap.put("android.permission.PROCESS_OUTGOING_CALLS", DangerousPermissionManager.CALL_LOG_PERMISIION_GROUP);
        this.mPermissionMap.put("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS");
        this.mPermissionMap.put("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL");
        this.mPermissionMap.put("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL");
        this.mPermissionMap.put("android.permission.READ_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL");
    }

    public String getPermssionGroupInfo(String permission) {
        if (this.mPermissionMap.containsKey(permission)) {
            return this.mPermissionMap.get(permission);
        }
        return null;
    }

    public void release() {
        this.mPermissionMap = null;
    }
}
