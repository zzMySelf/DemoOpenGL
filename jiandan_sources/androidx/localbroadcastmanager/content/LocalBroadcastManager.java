package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    public static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    public static final String TAG = "LocalBroadcastManager";
    public static LocalBroadcastManager mInstance;
    public static final Object mLock = new Object();
    public final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    public final Context mAppContext;
    public final Handler mHandler;
    public final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();
    public final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap<>();

    public static final class BroadcastRecord {
        public final Intent intent;
        public final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent intent2, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent2;
            this.receivers = arrayList;
        }
    }

    public static final class ReceiverRecord {
        public boolean broadcasting;
        public boolean dead;
        public final IntentFilter filter;
        public final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = r4.receivers.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r6 >= r5) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r7 = r4.receivers.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r7.dead != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r7.receiver.onReceive(r10.mAppContext, r4.intent);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executePendingBroadcasts() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r0 = r10.mReceivers
            monitor-enter(r0)
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r1 = r10.mPendingBroadcasts     // Catch:{ all -> 0x0044 }
            int r1 = r1.size()     // Catch:{ all -> 0x0044 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x000d:
            androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord[] r2 = new androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord[r1]     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x0044 }
            r3.toArray(r2)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            r0 = 0
            r3 = 0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord> r5 = r4.receivers
            int r5 = r5.size()
            r6 = 0
        L_0x0027:
            if (r6 >= r5) goto L_0x0041
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord> r7 = r4.receivers
            java.lang.Object r7 = r7.get(r6)
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r7 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r7
            boolean r8 = r7.dead
            if (r8 != 0) goto L_0x003e
            android.content.BroadcastReceiver r7 = r7.receiver
            android.content.Context r8 = r10.mAppContext
            android.content.Intent r9 = r4.intent
            r7.onReceive(r8, r9)
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x0027
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.localbroadcastmanager.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(@androidx.annotation.NonNull android.content.Intent r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r2 = r1.mReceivers
            monitor-enter(r2)
            java.lang.String r10 = r23.getAction()     // Catch:{ all -> 0x0152 }
            android.content.Context r3 = r1.mAppContext     // Catch:{ all -> 0x0152 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0152 }
            android.net.Uri r12 = r23.getData()     // Catch:{ all -> 0x0152 }
            java.lang.String r13 = r23.getScheme()     // Catch:{ all -> 0x0152 }
            java.util.Set r14 = r23.getCategories()     // Catch:{ all -> 0x0152 }
            int r3 = r23.getFlags()     // Catch:{ all -> 0x0152 }
            r3 = r3 & 8
            r9 = 1
            if (r3 == 0) goto L_0x002d
            r16 = 1
            goto L_0x002f
        L_0x002d:
            r16 = 0
        L_0x002f:
            if (r16 == 0) goto L_0x0051
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r3.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "Resolving type "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r11)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = " scheme "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r13)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = " of intent "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r0)     // Catch:{ all -> 0x0152 }
            r3.toString()     // Catch:{ all -> 0x0152 }
        L_0x0051:
            java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r3 = r1.mActions     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r23.getAction()     // Catch:{ all -> 0x0152 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0152 }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x0152 }
            if (r8 == 0) goto L_0x014f
            if (r16 == 0) goto L_0x0072
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r3.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "Action list: "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.append(r8)     // Catch:{ all -> 0x0152 }
            r3.toString()     // Catch:{ all -> 0x0152 }
        L_0x0072:
            r3 = 0
            r7 = r3
            r6 = 0
        L_0x0075:
            int r3 = r8.size()     // Catch:{ all -> 0x0152 }
            if (r6 >= r3) goto L_0x011f
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x0152 }
            r5 = r3
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r5 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r5     // Catch:{ all -> 0x0152 }
            if (r16 == 0) goto L_0x0096
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r3.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "Matching against filter "
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            android.content.IntentFilter r4 = r5.filter     // Catch:{ all -> 0x0152 }
            r3.append(r4)     // Catch:{ all -> 0x0152 }
            r3.toString()     // Catch:{ all -> 0x0152 }
        L_0x0096:
            boolean r3 = r5.broadcasting     // Catch:{ all -> 0x0152 }
            if (r3 == 0) goto L_0x00a6
            r18 = r6
            r20 = r8
            r19 = r10
            r21 = r11
            r11 = 1
            r10 = r7
            goto L_0x0113
        L_0x00a6:
            android.content.IntentFilter r3 = r5.filter     // Catch:{ all -> 0x0152 }
            java.lang.String r17 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r18 = r6
            r6 = r13
            r19 = r10
            r10 = r7
            r7 = r12
            r20 = r8
            r8 = r14
            r21 = r11
            r11 = 1
            r9 = r17
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0152 }
            if (r3 < 0) goto L_0x00e7
            if (r16 == 0) goto L_0x00d8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r4.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = "  Filter matched!  match=0x"
            r4.append(r5)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0152 }
            r4.append(r3)     // Catch:{ all -> 0x0152 }
            r4.toString()     // Catch:{ all -> 0x0152 }
        L_0x00d8:
            if (r10 != 0) goto L_0x00e0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0152 }
            r7.<init>()     // Catch:{ all -> 0x0152 }
            goto L_0x00e1
        L_0x00e0:
            r7 = r10
        L_0x00e1:
            r7.add(r15)     // Catch:{ all -> 0x0152 }
            r15.broadcasting = r11     // Catch:{ all -> 0x0152 }
            goto L_0x0114
        L_0x00e7:
            if (r16 == 0) goto L_0x0113
            r4 = -4
            if (r3 == r4) goto L_0x0101
            r4 = -3
            if (r3 == r4) goto L_0x00fe
            r4 = -2
            if (r3 == r4) goto L_0x00fb
            r4 = -1
            if (r3 == r4) goto L_0x00f8
            java.lang.String r3 = "unknown reason"
            goto L_0x0103
        L_0x00f8:
            java.lang.String r3 = "type"
            goto L_0x0103
        L_0x00fb:
            java.lang.String r3 = "data"
            goto L_0x0103
        L_0x00fe:
            java.lang.String r3 = "action"
            goto L_0x0103
        L_0x0101:
            java.lang.String r3 = "category"
        L_0x0103:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r4.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = "  Filter did not match: "
            r4.append(r5)     // Catch:{ all -> 0x0152 }
            r4.append(r3)     // Catch:{ all -> 0x0152 }
            r4.toString()     // Catch:{ all -> 0x0152 }
        L_0x0113:
            r7 = r10
        L_0x0114:
            int r6 = r18 + 1
            r10 = r19
            r8 = r20
            r11 = r21
            r9 = 1
            goto L_0x0075
        L_0x011f:
            r10 = r7
            r11 = 1
            if (r10 == 0) goto L_0x014f
            r3 = 0
        L_0x0124:
            int r4 = r10.size()     // Catch:{ all -> 0x0152 }
            if (r3 >= r4) goto L_0x0136
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0152 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r4 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r4     // Catch:{ all -> 0x0152 }
            r5 = 0
            r4.broadcasting = r5     // Catch:{ all -> 0x0152 }
            int r3 = r3 + 1
            goto L_0x0124
        L_0x0136:
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r1.mPendingBroadcasts     // Catch:{ all -> 0x0152 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord r4 = new androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord     // Catch:{ all -> 0x0152 }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x0152 }
            r3.add(r4)     // Catch:{ all -> 0x0152 }
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x0152 }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x0152 }
            if (r0 != 0) goto L_0x014d
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x0152 }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x0152 }
        L_0x014d:
            monitor-exit(r2)     // Catch:{ all -> 0x0152 }
            return r11
        L_0x014f:
            monitor-exit(r2)     // Catch:{ all -> 0x0152 }
            r0 = 0
            return r0
        L_0x0152:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0152 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.localbroadcastmanager.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(@NonNull Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList remove = this.mReceivers.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) remove.get(size);
                    receiverRecord.dead = true;
                    for (int i2 = 0; i2 < receiverRecord.filter.countActions(); i2++) {
                        String action = receiverRecord.filter.getAction(i2);
                        ArrayList arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList.get(size2);
                                if (receiverRecord2.receiver == broadcastReceiver) {
                                    receiverRecord2.dead = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
