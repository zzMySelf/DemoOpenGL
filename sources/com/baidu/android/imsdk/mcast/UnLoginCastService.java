package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.ParseM3u8;
import com.baidu.android.imsdk.mcast.UpMessageManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.ugc.utils.TextViewExtKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UnLoginCastService {
    static final int BACKPLAY = 1;
    static final int NOWPLAY = 0;
    /* access modifiers changed from: private */
    public static final String TAG = UnLoginCastService.class.getSimpleName();
    /* access modifiers changed from: private */
    public static Context mContext;
    private static UnLoginCastService mInstance;
    boolean isActive = false;
    boolean isSeek = false;
    Timer mAxisTimer;
    /* access modifiers changed from: private */
    public String mCastId;
    private int mInterval = 3000;
    ParseM3u8 mLastpm = null;
    private boolean mPause = false;
    /* access modifiers changed from: private */
    public int mPausePosition;
    int mPosition = 0;
    /* access modifiers changed from: private */
    public String mRoomUrl;
    Timer mTimer;
    private int mTryTimes = 0;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<ParseM3u8.TS> mTss = new ConcurrentLinkedQueue<>();
    int mType = -1;
    /* access modifiers changed from: private */
    public Object mawakeLock = new Object();
    private Thread requestTsTask = null;
    /* access modifiers changed from: private */
    public long startSeekTime = 0;
    /* access modifiers changed from: private */
    public long startSeekTsTime = 0;

    public static UnLoginCastService getInstance(Context context) {
        synchronized (UnLoginCastService.class) {
            if (mInstance == null) {
                mInstance = new UnLoginCastService(context);
            }
        }
        return mInstance;
    }

    protected UnLoginCastService(Context context) {
        mContext = context.getApplicationContext();
    }

    public void setPullInterval(int isms) {
        this.mInterval = isms;
        LogUtils.d(TAG, "setPullInterval " + this.mInterval);
    }

    public int startService(String castId, String roomfile, int type) {
        String str = TAG;
        LogUtils.d(str, "FXF startService--->");
        if (this.isActive) {
            stopService(0);
        }
        this.mPause = false;
        this.isActive = true;
        this.mType = type;
        this.mRoomUrl = roomfile;
        this.mCastId = castId;
        AnonymousClass1 r1 = new Thread() {
            public void run() {
                UnLoginCastService.this.tsWork();
            }
        };
        this.requestTsTask = r1;
        r1.start();
        getM3u8task(roomfile);
        LogUtils.d(str, "FXF startService<---");
        return 0;
    }

    /* access modifiers changed from: private */
    public void tsWork() {
        while (true) {
            if (!this.isActive) {
                break;
            }
            synchronized (this.mawakeLock) {
                try {
                    LogUtils.d(TAG, "FXF requestTsTask wait...");
                    this.mawakeLock.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                int size = this.mTss.size();
                if (this.isActive) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size || !this.isActive) {
                            break;
                        } else if (this.isSeek) {
                            break;
                        } else {
                            ParseM3u8.TS ts = this.mTss.peek();
                            if (proofreadTimeAxis(ts.relativetime)) {
                                break;
                            }
                            this.mTss.poll();
                            getTstask(ts.tsfile);
                            LogUtils.d(TAG, "FXF request ts " + i2 + " " + ts.tsfile + " " + ts.relativetime);
                            i2++;
                        }
                    }
                }
            }
        }
        LogUtils.d(TAG, "FXF requestTsTask finish");
    }

    private boolean proofreadTimeAxis(long currentTsTime) {
        if (this.mType != 1) {
            return false;
        }
        long tspast = currentTsTime - this.startSeekTsTime;
        long syspast = (System.currentTimeMillis() / 1000) - this.startSeekTime;
        if (this.mAxisTimer == null) {
            this.mAxisTimer = new Timer(true);
        }
        if (tspast - syspast <= 5) {
            return false;
        }
        String str = TAG;
        LogUtils.d(str, "startSeekTsTime = " + this.startSeekTsTime + "  currenttstime =  " + currentTsTime + " past = " + tspast);
        LogUtils.d(str, "startSeekTime = " + this.startSeekTime + " past = " + syspast);
        this.mAxisTimer.schedule(new TimerTask() {
            public void run() {
                synchronized (UnLoginCastService.this.mawakeLock) {
                    LogUtils.d(UnLoginCastService.TAG, "FXF execute 1 tiime axis");
                    if (!UnLoginCastService.this.isSeek && UnLoginCastService.this.isActive) {
                        UnLoginCastService.this.mawakeLock.notifyAll();
                    }
                }
            }
        }, 3000);
        return true;
    }

    public void stopService(int type) {
        LogUtils.d(TAG, "FXF stopService--->");
        this.isActive = false;
        if (type == 0) {
            this.mLastpm = null;
        }
        this.mTryTimes = 0;
        if (type == 1 && this.mType == 1) {
            if (this.mTss.size() > 0) {
                this.mPausePosition = (int) this.mTss.peek().relativetime;
            } else {
                this.mPausePosition = 0;
            }
        }
        this.mTss.clear();
        synchronized (this.mawakeLock) {
            this.mawakeLock.notifyAll();
        }
        Thread thread = this.requestTsTask;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.requestTsTask = null;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        Timer timer2 = this.mAxisTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.mAxisTimer = null;
        }
        UpMessageManager.getInstance(mContext).clear();
        LogUtils.d(TAG, "FXF stopService<---");
    }

    public void seek(int position) {
        String str = TAG;
        LogUtils.d(str, "FXF start seek--->");
        this.mPosition = position;
        if (this.mType == 1) {
            if (this.mPause) {
                this.mPausePosition = position;
            } else if (this.isActive) {
                this.isSeek = true;
                LogUtils.d(str, "FXF start seek...");
                new Timer(true).schedule(new TimerTask() {
                    public void run() {
                        if (UnLoginCastService.this.isActive) {
                            UnLoginCastService.this.isSeek = false;
                            UnLoginCastService.this.mTss.clear();
                            UpMessageManager.getInstance(UnLoginCastService.mContext).clear();
                            List<ParseM3u8.TS> newtslist = new ArrayList<>();
                            if (UnLoginCastService.this.mLastpm != null) {
                                newtslist = UnLoginCastService.this.mLastpm.getTslist(UnLoginCastService.this.mPosition);
                            } else {
                                LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                            }
                            if (newtslist.size() > 0) {
                                long unused = UnLoginCastService.this.startSeekTime = System.currentTimeMillis() / 1000;
                                long unused2 = UnLoginCastService.this.startSeekTsTime = newtslist.get(0).relativetime;
                                for (int i2 = 0; i2 < newtslist.size(); i2++) {
                                    UnLoginCastService.this.mTss.add(newtslist.get(i2));
                                }
                                synchronized (UnLoginCastService.this.mawakeLock) {
                                    UnLoginCastService.this.mawakeLock.notifyAll();
                                }
                            }
                            LogUtils.d(UnLoginCastService.TAG, "FXF   seek finish...");
                        }
                    }
                }, 2000);
            }
        }
    }

    public void pause() {
        this.mPause = true;
        stopService(1);
    }

    public void replay(String castId, String roomfile, int type) {
        String str = TAG;
        LogUtils.d(str, "FXF replay--->");
        this.isActive = true;
        this.mPause = false;
        this.mType = type;
        this.mRoomUrl = roomfile;
        this.mCastId = castId;
        AnonymousClass4 r2 = new Thread() {
            public void run() {
                UnLoginCastService.this.tsWork();
            }
        };
        this.requestTsTask = r2;
        r2.start();
        new Timer(true).schedule(new TimerTask() {
            public void run() {
                List<ParseM3u8.TS> newtslist = new ArrayList<>();
                if (UnLoginCastService.this.mLastpm != null) {
                    newtslist = UnLoginCastService.this.mLastpm.getTslist(UnLoginCastService.this.mPausePosition);
                } else {
                    LogUtils.e(UnLoginCastService.TAG, "FXF seek, last pm is null");
                }
                if (newtslist.size() > 0) {
                    long unused = UnLoginCastService.this.startSeekTime = System.currentTimeMillis() / 1000;
                    long unused2 = UnLoginCastService.this.startSeekTsTime = newtslist.get(0).relativetime;
                    for (int i2 = 0; i2 < newtslist.size(); i2++) {
                        UnLoginCastService.this.mTss.add(newtslist.get(i2));
                    }
                    synchronized (UnLoginCastService.this.mawakeLock) {
                        UnLoginCastService.this.mawakeLock.notifyAll();
                    }
                }
                LogUtils.d(UnLoginCastService.TAG, "FXF   replay finish...");
            }
        }, 500);
        LogUtils.d(str, "FXF replay<---");
    }

    private void getTstask(String tsurl) {
        String key = ListenerManager.getInstance().addListener(new GetM3u8CallBack() {
            public void onResult(int responseCode, byte[] msg) {
                LogUtils.d(UnLoginCastService.TAG, "FXF receive a ts file " + responseCode);
                if (responseCode == 0 || responseCode == 200) {
                    UnLoginCastService.this.onResultTs(msg);
                } else {
                    LogUtils.e(UnLoginCastService.TAG, "FXF getTstask error " + responseCode);
                }
            }
        });
        int index = this.mRoomUrl.indexOf("/", 10);
        if (index <= this.mRoomUrl.length()) {
            String urlhead = this.mRoomUrl.substring(0, index);
            if (!tsurl.contains("http://")) {
                tsurl = urlhead + tsurl;
            }
            GetTsRequest request = new GetTsRequest(mContext, key, tsurl);
            HttpHelper.executor(mContext, request, request);
        }
    }

    /* access modifiers changed from: private */
    public void getM3u8task(String fileurl) {
        String key = ListenerManager.getInstance().addListener(new GetM3u8CallBack() {
            public void onResult(int responseCode, byte[] msg) {
                UnLoginCastService.this.handleOnM3u8Callback(responseCode, msg);
            }
        });
        LogUtils.d(TAG, "   " + key + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + fileurl);
        GetM3u8Request request = new GetM3u8Request(mContext, key, fileurl);
        HttpHelper.executor(mContext, request, request);
    }

    public void handleOnM3u8Callback(int responseCode, byte[] msg) {
        String str = TAG;
        LogUtils.d(str, "FXF receive a m3u8 file " + responseCode);
        boolean isContinue = true;
        if (responseCode == 0 || responseCode == 200) {
            this.mTryTimes = 0;
            isContinue = onResultM3u8(msg);
        } else {
            LogUtils.e(str, "FXF getM3u8task error " + responseCode);
        }
        if (isContinue && this.isActive && !this.isSeek) {
            TimerTask task = new TimerTask() {
                public void run() {
                    if (UnLoginCastService.this.isActive) {
                        UnLoginCastService unLoginCastService = UnLoginCastService.this;
                        unLoginCastService.getM3u8task(unLoginCastService.mRoomUrl);
                    }
                }
            };
            if (this.mTimer == null) {
                this.mTimer = new Timer(true);
            }
            this.mTimer.schedule(task, (long) this.mInterval);
        }
    }

    private boolean onResultM3u8(byte[] m3u8content) {
        if (!this.isActive || this.isSeek) {
            LogUtils.d(TAG, "onResultM3u8 return, service is not active " + this.isActive + " " + this.isSeek);
            return false;
        }
        ParseM3u8 pm = new ParseM3u8();
        try {
            pm.readByte(m3u8content);
            List<ParseM3u8.TS> newtslist = new ArrayList<>();
            if (this.mLastpm == null) {
                this.mLastpm = pm;
                if (this.mType == 0) {
                    newtslist = pm.getLatestTS(pm.getMaxTime());
                    LogUtils.d(TAG, "FXF ts list  1 size" + newtslist.size());
                } else {
                    newtslist = pm.getTslist(this.mPosition);
                    LogUtils.d(TAG, "FXF ts list 2 size" + newtslist.size());
                    this.startSeekTime = System.currentTimeMillis() / 1000;
                    this.startSeekTsTime = newtslist.get(0).relativetime;
                }
                LogUtils.d(TAG, "FXF first get 1 m3u8");
            } else {
                String str = TAG;
                LogUtils.d(str, "FXF get one m3u8");
                if (pm.getMaxTime() > this.mLastpm.getMaxTime()) {
                    LogUtils.d(str, "FXF has new ts");
                    newtslist = pm.getNewAppendTS(this.mLastpm.getMaxTime());
                    this.mLastpm = pm;
                }
            }
            if (newtslist != null && newtslist.size() > 0) {
                for (int i2 = 0; i2 < newtslist.size(); i2++) {
                    this.mTss.add(newtslist.get(i2));
                }
                synchronized (this.mawakeLock) {
                    this.mawakeLock.notifyAll();
                }
            }
            if (!pm.isEnd() && this.mType != 1) {
                return true;
            }
            LogUtils.d(TAG, "FXF pm has end-list");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            LogUtils.d(TAG, "parse m3u8 execption");
            return false;
        }
    }

    class Uptask extends UpMessageManager.Task {
        public Uptask(String key, String jsonstr) {
            super(key, jsonstr);
        }

        public void work() {
            int num;
            int num2;
            try {
                JSONObject msgobj = new JSONObject(this.mJson);
                int version = msgobj.optInt("version");
                long duration = msgobj.optLong("duration");
                JSONArray array = msgobj.getJSONArray("list");
                int size = array.length();
                if (size == 0) {
                    LogUtils.d(UnLoginCastService.TAG, "FXF work  is null");
                    return;
                }
                LogUtils.d(UnLoginCastService.TAG, "FXF work data is " + array.toString());
                JSONArray allmsgary = new JSONArray();
                for (int i2 = 0; i2 < size; i2++) {
                    JSONArray msgary = array.getJSONObject(i2).getJSONArray("messages");
                    int k = 0;
                    while (k < msgary.length()) {
                        JSONObject msg = msgary.getJSONObject(k);
                        int size2 = size;
                        JSONObject msgobj2 = msgobj;
                        int version2 = version;
                        if (((long) msg.optInt("origin_id", -1)) != Utility.getTriggerId(UnLoginCastService.mContext)) {
                            allmsgary.put(msg);
                        }
                        k++;
                        msgobj = msgobj2;
                        size = size2;
                        version = version2;
                    }
                    JSONObject jSONObject = msgobj;
                    int i3 = version;
                }
                JSONObject jSONObject2 = msgobj;
                int i4 = version;
                int size3 = allmsgary.length();
                int ds = (int) (duration / 1000000000);
                int count = ds;
                if (ds == 0) {
                    num = 0;
                    num2 = count;
                } else if (size3 >= ds) {
                    num = size3 / ds;
                    num2 = count;
                } else {
                    num = 1;
                    num2 = size3;
                }
                LogUtils.d(UnLoginCastService.TAG, "HBBH work ts duration is " + duration + " " + ds + " num is " + num + " size is " + size3);
                if (num <= 0) {
                    ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage("", UnLoginCastService.this.mCastId, allmsgary);
                    return;
                }
                int index = 0;
                int i5 = 0;
                while (true) {
                    if (i5 < num2) {
                        if (!UnLoginCastService.this.isActive) {
                            break;
                        } else if (UnLoginCastService.this.isSeek) {
                            int i6 = ds;
                            break;
                        } else {
                            JSONArray onceary = new JSONArray();
                            int index2 = index;
                            int m = 0;
                            while (m < num) {
                                onceary.put(allmsgary.get(index2));
                                m++;
                                index2++;
                            }
                            int ds2 = ds;
                            LogUtils.d(UnLoginCastService.TAG, "FXF upload a ts message  " + onceary.toString());
                            ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage("", UnLoginCastService.this.mCastId, onceary);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            i5++;
                            index = index2;
                            ds = ds2;
                        }
                    } else {
                        break;
                    }
                }
                if (!UnLoginCastService.this.isActive) {
                    return;
                }
                if (!UnLoginCastService.this.isSeek) {
                    if (index < size3) {
                        JSONArray onceary2 = new JSONArray();
                        int i7 = index;
                        while (i7 < size3) {
                            onceary2.put(allmsgary.get(index));
                            i7++;
                            index++;
                        }
                        LogUtils.d(UnLoginCastService.TAG, "FXF upload a last ts message  " + onceary2.toString());
                        ChatMsgManagerImpl.getInstance(UnLoginCastService.mContext).deliverMcastMessage("", UnLoginCastService.this.mCastId, onceary2);
                    }
                }
            } catch (JSONException e1) {
                LogUtils.e(UnLoginCastService.TAG, "m3u8 work task execption  ");
                e1.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void onResultTs(byte[] msg) {
        if (this.isActive && !this.isSeek) {
            JSONObject obj = null;
            try {
                obj = new JSONObject(new String(msg));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (obj != null) {
                LogUtils.d(TAG, "FXF receive a ts message " + obj.toString());
                UpMessageManager.getInstance(mContext).addTaskRequest(new Uptask("parse ts and upload", obj.toString()));
            }
        }
    }
}
