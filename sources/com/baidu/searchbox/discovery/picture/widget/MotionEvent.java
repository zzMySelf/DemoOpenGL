package com.baidu.searchbox.discovery.picture.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.u.i;
import com.baidu.searchbox.config.AppConfig;

public final class MotionEvent implements Parcelable {
    public static final int ACTION_CANCEL = 3;
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_OUTSIDE = 4;
    @Deprecated
    public static final int ACTION_POINTER_1_DOWN = 5;
    @Deprecated
    public static final int ACTION_POINTER_1_UP = 6;
    @Deprecated
    public static final int ACTION_POINTER_2_DOWN = 261;
    @Deprecated
    public static final int ACTION_POINTER_2_UP = 262;
    @Deprecated
    public static final int ACTION_POINTER_3_DOWN = 517;
    @Deprecated
    public static final int ACTION_POINTER_3_UP = 518;
    public static final int ACTION_POINTER_DOWN = 5;
    @Deprecated
    public static final int ACTION_POINTER_ID_MASK = 65280;
    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_UP = 1;
    public static final int BASE_AVAIL_POINTERS = 5;
    private static final int BASE_AVAIL_SAMPLES = 8;
    public static final Parcelable.Creator<MotionEvent> CREATOR = new Parcelable.Creator<MotionEvent>() {
        public MotionEvent createFromParcel(Parcel in) {
            MotionEvent ev = MotionEvent.obtain();
            ev.readFromParcel(in);
            return ev;
        }

        public MotionEvent[] newArray(int size) {
            return new MotionEvent[size];
        }
    };
    static final boolean DEBUG_POINTERS = false;
    public static final int EDGE_BOTTOM = 2;
    public static final int EDGE_LEFT = 4;
    public static final int EDGE_RIGHT = 8;
    public static final int EDGE_TOP = 1;
    private static final int MAX_RECYCLED = 10;
    public static final int NUM_SAMPLE_DATA = 4;
    public static final int SAMPLE_PRESSURE = 2;
    public static final int SAMPLE_SIZE = 3;
    public static final int SAMPLE_X = 0;
    public static final int SAMPLE_Y = 1;
    private static final boolean TRACK_RECYCLED_LOCATION = false;
    private static Object gRecyclerLock = new Object();
    private static MotionEvent gRecyclerTop = null;
    private static int gRecyclerUsed = 0;
    private int mAction;
    private float[] mDataSamples = new float[160];
    private int mDeviceId;
    private long mDownTime;
    private int mEdgeFlags;
    private long mEventTimeNano;
    private int mMetaState;
    private MotionEvent mNext;
    private int mNumPointers;
    private int mNumSamples;
    private int[] mPointerIdentifiers = new int[5];
    private float mRawX;
    private float mRawY;
    private boolean mRecycled;
    private RuntimeException mRecycledLocation;
    private long[] mTimeSamples = new long[8];
    private float mXPrecision;
    private float mYPrecision;

    private MotionEvent() {
    }

    /* access modifiers changed from: private */
    public static MotionEvent obtain() {
        synchronized (gRecyclerLock) {
            MotionEvent ev = gRecyclerTop;
            if (ev == null) {
                MotionEvent motionEvent = new MotionEvent();
                return motionEvent;
            }
            gRecyclerTop = ev.mNext;
            gRecyclerUsed--;
            ev.mRecycledLocation = null;
            ev.mRecycled = false;
            return ev;
        }
    }

    public static MotionEvent obtainNano(long downTime, long eventTime, long eventTimeNano, int action, int pointers, int[] inPointerIds, float[] inData, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        int i2 = pointers;
        float[] fArr = inData;
        MotionEvent ev = obtain();
        ev.mDeviceId = deviceId;
        ev.mEdgeFlags = edgeFlags;
        ev.mDownTime = downTime;
        ev.mEventTimeNano = eventTimeNano;
        ev.mAction = action;
        ev.mMetaState = metaState;
        ev.mRawX = fArr[0];
        ev.mRawY = fArr[1];
        ev.mXPrecision = xPrecision;
        ev.mYPrecision = yPrecision;
        ev.mNumPointers = i2;
        ev.mNumSamples = 1;
        int[] pointerIdentifiers = ev.mPointerIdentifiers;
        if (pointerIdentifiers.length < i2) {
            int[] iArr = new int[i2];
            pointerIdentifiers = iArr;
            ev.mPointerIdentifiers = iArr;
        }
        System.arraycopy(inPointerIds, 0, pointerIdentifiers, 0, i2);
        int ND = i2 * 4;
        float[] dataSamples = ev.mDataSamples;
        if (dataSamples.length < ND) {
            float[] fArr2 = new float[ND];
            dataSamples = fArr2;
            ev.mDataSamples = fArr2;
        }
        System.arraycopy(fArr, 0, dataSamples, 0, ND);
        float[] fArr3 = dataSamples;
        ev.mTimeSamples[0] = eventTime;
        return ev;
    }

    public static MotionEvent obtain(long downTime, long eventTime, int action, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        float f2 = x;
        float f3 = y;
        MotionEvent ev = obtain();
        ev.mDeviceId = deviceId;
        ev.mEdgeFlags = edgeFlags;
        ev.mDownTime = downTime;
        ev.mEventTimeNano = 1000000 * eventTime;
        ev.mAction = action;
        ev.mMetaState = metaState;
        ev.mXPrecision = xPrecision;
        ev.mYPrecision = yPrecision;
        ev.mNumPointers = 1;
        ev.mNumSamples = 1;
        ev.mPointerIdentifiers[0] = 0;
        float[] data = ev.mDataSamples;
        ev.mRawX = f2;
        data[0] = f2;
        ev.mRawY = f3;
        data[1] = f3;
        data[2] = pressure;
        data[3] = size;
        ev.mTimeSamples[0] = eventTime;
        return ev;
    }

    public static MotionEvent obtain(long downTime, long eventTime, int action, int pointers, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        float f2 = x;
        float f3 = y;
        MotionEvent ev = obtain();
        ev.mDeviceId = deviceId;
        ev.mEdgeFlags = edgeFlags;
        ev.mDownTime = downTime;
        ev.mEventTimeNano = 1000000 * eventTime;
        ev.mAction = action;
        ev.mNumPointers = pointers;
        ev.mMetaState = metaState;
        ev.mXPrecision = xPrecision;
        ev.mYPrecision = yPrecision;
        ev.mNumPointers = 1;
        ev.mNumSamples = 1;
        ev.mPointerIdentifiers[0] = 0;
        float[] data = ev.mDataSamples;
        ev.mRawX = f2;
        data[0] = f2;
        ev.mRawY = f3;
        data[1] = f3;
        data[2] = pressure;
        data[3] = size;
        ev.mTimeSamples[0] = eventTime;
        return ev;
    }

    public static MotionEvent obtain(long downTime, long eventTime, int action, float x, float y, int metaState) {
        MotionEvent ev = obtain();
        ev.mDeviceId = 0;
        ev.mEdgeFlags = 0;
        ev.mDownTime = downTime;
        ev.mEventTimeNano = 1000000 * eventTime;
        ev.mAction = action;
        ev.mNumPointers = 1;
        ev.mMetaState = metaState;
        ev.mXPrecision = 1.0f;
        ev.mYPrecision = 1.0f;
        ev.mNumPointers = 1;
        ev.mNumSamples = 1;
        ev.mPointerIdentifiers[0] = 0;
        float[] data = ev.mDataSamples;
        ev.mRawX = x;
        data[0] = x;
        ev.mRawY = y;
        data[1] = y;
        data[2] = 1.0f;
        data[3] = 1.0f;
        ev.mTimeSamples[0] = eventTime;
        return ev;
    }

    public void scale(float scale) {
        this.mRawX *= scale;
        this.mRawY *= scale;
        this.mXPrecision *= scale;
        this.mYPrecision *= scale;
        float[] history = this.mDataSamples;
        int length = this.mNumPointers * this.mNumSamples * 4;
        for (int i2 = 0; i2 < length; i2 += 4) {
            int i3 = i2 + 0;
            history[i3] = history[i3] * scale;
            int i4 = i2 + 1;
            history[i4] = history[i4] * scale;
            int i5 = i2 + 3;
            history[i5] = history[i5] * scale;
        }
    }

    public static MotionEvent obtain(MotionEvent o) {
        MotionEvent ev = obtain();
        ev.mDeviceId = o.mDeviceId;
        ev.mEdgeFlags = o.mEdgeFlags;
        ev.mDownTime = o.mDownTime;
        ev.mEventTimeNano = o.mEventTimeNano;
        ev.mAction = o.mAction;
        ev.mNumPointers = o.mNumPointers;
        ev.mRawX = o.mRawX;
        ev.mRawY = o.mRawY;
        ev.mMetaState = o.mMetaState;
        ev.mXPrecision = o.mXPrecision;
        ev.mYPrecision = o.mYPrecision;
        int NS = o.mNumSamples;
        ev.mNumSamples = NS;
        long[] jArr = ev.mTimeSamples;
        if (jArr.length >= NS) {
            System.arraycopy(o.mTimeSamples, 0, jArr, 0, NS);
        } else {
            ev.mTimeSamples = (long[]) o.mTimeSamples.clone();
        }
        int NP = o.mNumPointers;
        ev.mNumPointers = NP;
        int[] iArr = ev.mPointerIdentifiers;
        if (iArr.length >= NP) {
            System.arraycopy(o.mPointerIdentifiers, 0, iArr, 0, NP);
        } else {
            ev.mPointerIdentifiers = (int[]) o.mPointerIdentifiers.clone();
        }
        int ND = NP * NS * 4;
        float[] fArr = ev.mDataSamples;
        if (fArr.length >= ND) {
            System.arraycopy(o.mDataSamples, 0, fArr, 0, ND);
        } else {
            ev.mDataSamples = (float[]) o.mDataSamples.clone();
        }
        return ev;
    }

    public static MotionEvent obtainNoHistory(MotionEvent o) {
        MotionEvent ev = obtain();
        ev.mDeviceId = o.mDeviceId;
        ev.mEdgeFlags = o.mEdgeFlags;
        ev.mDownTime = o.mDownTime;
        ev.mEventTimeNano = o.mEventTimeNano;
        ev.mAction = o.mAction;
        ev.mNumPointers = o.mNumPointers;
        ev.mRawX = o.mRawX;
        ev.mRawY = o.mRawY;
        ev.mMetaState = o.mMetaState;
        ev.mXPrecision = o.mXPrecision;
        ev.mYPrecision = o.mYPrecision;
        ev.mNumSamples = 1;
        ev.mTimeSamples[0] = o.mTimeSamples[0];
        int NP = o.mNumPointers;
        ev.mNumPointers = NP;
        int[] iArr = ev.mPointerIdentifiers;
        if (iArr.length >= NP) {
            System.arraycopy(o.mPointerIdentifiers, 0, iArr, 0, NP);
        } else {
            ev.mPointerIdentifiers = (int[]) o.mPointerIdentifiers.clone();
        }
        int ND = NP * 4;
        float[] fArr = ev.mDataSamples;
        if (fArr.length >= ND) {
            System.arraycopy(o.mDataSamples, 0, fArr, 0, ND);
        } else {
            ev.mDataSamples = (float[]) o.mDataSamples.clone();
        }
        return ev;
    }

    public void recycle() {
        if (!this.mRecycled) {
            synchronized (gRecyclerLock) {
                int i2 = gRecyclerUsed;
                if (i2 < 10) {
                    gRecyclerUsed = i2 + 1;
                    this.mNumSamples = 0;
                    this.mNext = gRecyclerTop;
                    gRecyclerTop = this;
                }
            }
        } else if (AppConfig.isDebug()) {
            throw new RuntimeException(toString() + " recycled twice!");
        }
    }

    public final int getAction() {
        return this.mAction;
    }

    public final int getActionMasked() {
        return this.mAction & 255;
    }

    public final int getActionIndex() {
        return (this.mAction & 65280) >> 8;
    }

    public final long getDownTime() {
        return this.mDownTime;
    }

    public final long getEventTime() {
        return this.mTimeSamples[0];
    }

    public final long getEventTimeNano() {
        return this.mEventTimeNano;
    }

    public final float getX() {
        return this.mDataSamples[0];
    }

    public final float getY() {
        return this.mDataSamples[1];
    }

    public final float getPressure() {
        return this.mDataSamples[2];
    }

    public final float getSize() {
        return this.mDataSamples[3];
    }

    public final int getPointerCount() {
        return this.mNumPointers;
    }

    public final int getPointerId(int pointerIndex) {
        return this.mPointerIdentifiers[pointerIndex];
    }

    public final int findPointerIndex(int pointerId) {
        int i2 = this.mNumPointers;
        while (i2 > 0) {
            i2--;
            if (this.mPointerIdentifiers[i2] == pointerId) {
                return i2;
            }
        }
        return -1;
    }

    public final float getX(int pointerIndex) {
        return this.mDataSamples[(pointerIndex * 4) + 0];
    }

    public final float getY(int pointerIndex) {
        return this.mDataSamples[(pointerIndex * 4) + 1];
    }

    public final float getPressure(int pointerIndex) {
        return this.mDataSamples[(pointerIndex * 4) + 2];
    }

    public final float getSize(int pointerIndex) {
        return this.mDataSamples[(pointerIndex * 4) + 3];
    }

    public final int getMetaState() {
        return this.mMetaState;
    }

    public final float getRawX() {
        return this.mRawX;
    }

    public final float getRawY() {
        return this.mRawY;
    }

    public final float getXPrecision() {
        return this.mXPrecision;
    }

    public final float getYPrecision() {
        return this.mYPrecision;
    }

    public final int getHistorySize() {
        return this.mNumSamples - 1;
    }

    public final long getHistoricalEventTime(int pos) {
        return this.mTimeSamples[pos + 1];
    }

    public final float getHistoricalX(int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + 0];
    }

    public final float getHistoricalY(int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + 1];
    }

    public final float getHistoricalPressure(int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + 2];
    }

    public final float getHistoricalSize(int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + 3];
    }

    public final float getHistoricalX(int pointerIndex, int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + (pointerIndex * 4) + 0];
    }

    public final float getHistoricalY(int pointerIndex, int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + (pointerIndex * 4) + 1];
    }

    public final float getHistoricalPressure(int pointerIndex, int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + (pointerIndex * 4) + 2];
    }

    public final float getHistoricalSize(int pointerIndex, int pos) {
        return this.mDataSamples[((pos + 1) * 4 * this.mNumPointers) + (pointerIndex * 4) + 3];
    }

    public final int getDeviceId() {
        return this.mDeviceId;
    }

    public final int getEdgeFlags() {
        return this.mEdgeFlags;
    }

    public final void setEdgeFlags(int flags) {
        this.mEdgeFlags = flags;
    }

    public final void setAction(int action) {
        this.mAction = action;
    }

    public final void offsetLocation(float deltaX, float deltaY) {
        int N = this.mNumPointers * this.mNumSamples * 4;
        float[] pos = this.mDataSamples;
        for (int i2 = 0; i2 < N; i2 += 4) {
            int i3 = i2 + 0;
            pos[i3] = pos[i3] + deltaX;
            int i4 = i2 + 1;
            pos[i4] = pos[i4] + deltaY;
        }
    }

    public final void setLocation(float x, float y) {
        float[] fArr = this.mDataSamples;
        float deltaX = x - fArr[0];
        float deltaY = y - fArr[1];
        if (deltaX != 0.0f || deltaY != 0.0f) {
            offsetLocation(deltaX, deltaY);
        }
    }

    public final void addBatch(long eventTime, float x, float y, float pressure, float size, int metaState) {
        float f2 = x;
        float f3 = y;
        float[] data = this.mDataSamples;
        long[] times = this.mTimeSamples;
        int NP = this.mNumPointers;
        int NS = this.mNumSamples;
        int ND = NP * NS * 4;
        if (data.length <= ND) {
            float[] newData = new float[((NP * 32) + ND)];
            System.arraycopy(data, 0, newData, 0, ND);
            data = newData;
            this.mDataSamples = newData;
        }
        if (times.length <= NS) {
            long[] newHistoryTimes = new long[(NS + 8)];
            System.arraycopy(times, 0, newHistoryTimes, 0, NS);
            times = newHistoryTimes;
            this.mTimeSamples = newHistoryTimes;
        }
        times[NS] = times[0];
        times[0] = eventTime;
        int pos = NS * 4;
        data[pos + 0] = data[0];
        data[pos + 1] = data[1];
        data[pos + 2] = data[2];
        data[pos + 3] = data[3];
        data[0] = f2;
        data[1] = f3;
        data[2] = pressure;
        data[3] = size;
        this.mNumSamples = NS + 1;
        this.mRawX = f2;
        this.mRawY = f3;
        this.mMetaState |= metaState;
    }

    public final void addBatch(long eventTime, float[] inData, int metaState) {
        float[] data = this.mDataSamples;
        long[] times = this.mTimeSamples;
        int NP = this.mNumPointers;
        int NS = this.mNumSamples;
        int ND = NP * NS * 4;
        if (data.length < (NP * 4) + ND) {
            float[] newData = new float[((NP * 32) + ND)];
            System.arraycopy(data, 0, newData, 0, ND);
            data = newData;
            this.mDataSamples = newData;
        }
        if (times.length < NS + 1) {
            long[] newHistoryTimes = new long[(NS + 8)];
            System.arraycopy(times, 0, newHistoryTimes, 0, NS);
            times = newHistoryTimes;
            this.mTimeSamples = newHistoryTimes;
        }
        times[NS] = times[0];
        times[0] = eventTime;
        System.arraycopy(data, 0, data, ND, this.mNumPointers * 4);
        System.arraycopy(inData, 0, data, 0, this.mNumPointers * 4);
        this.mNumSamples = NS + 1;
        this.mRawX = inData[0];
        this.mRawY = inData[1];
        this.mMetaState |= metaState;
    }

    public String toString() {
        return "MotionEvent{" + Integer.toHexString(System.identityHashCode(this)) + " action=" + this.mAction + " x=" + getX() + " y=" + getY() + " pressure=" + getPressure() + " size=" + getSize() + i.f2534d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(this.mDownTime);
        out.writeLong(this.mEventTimeNano);
        out.writeInt(this.mAction);
        out.writeInt(this.mMetaState);
        out.writeFloat(this.mRawX);
        out.writeFloat(this.mRawY);
        int NP = this.mNumPointers;
        out.writeInt(NP);
        int NS = this.mNumSamples;
        out.writeInt(NS);
        int NI = NP * NS;
        if (NI > 0) {
            int[] state = this.mPointerIdentifiers;
            for (int i2 = 0; i2 < NP; i2++) {
                out.writeInt(state[i2]);
            }
            int ND = NI * 4;
            float[] history = this.mDataSamples;
            for (int i3 = 0; i3 < ND; i3++) {
                out.writeFloat(history[i3]);
            }
            long[] times = this.mTimeSamples;
            for (int i4 = 0; i4 < NS; i4++) {
                out.writeLong(times[i4]);
            }
        }
        out.writeFloat(this.mXPrecision);
        out.writeFloat(this.mYPrecision);
        out.writeInt(this.mDeviceId);
        out.writeInt(this.mEdgeFlags);
    }

    /* access modifiers changed from: private */
    public void readFromParcel(Parcel in) {
        this.mDownTime = in.readLong();
        this.mEventTimeNano = in.readLong();
        this.mAction = in.readInt();
        this.mMetaState = in.readInt();
        this.mRawX = in.readFloat();
        this.mRawY = in.readFloat();
        int NP = in.readInt();
        this.mNumPointers = NP;
        int NS = in.readInt();
        this.mNumSamples = NS;
        int NI = NP * NS;
        if (NI > 0) {
            int[] ids = this.mPointerIdentifiers;
            if (ids.length < NP) {
                int[] iArr = new int[NP];
                ids = iArr;
                this.mPointerIdentifiers = iArr;
            }
            for (int i2 = 0; i2 < NP; i2++) {
                ids[i2] = in.readInt();
            }
            float[] history = this.mDataSamples;
            int ND = NI * 4;
            if (history.length < ND) {
                float[] fArr = new float[ND];
                history = fArr;
                this.mDataSamples = fArr;
            }
            for (int i3 = 0; i3 < ND; i3++) {
                history[i3] = in.readFloat();
            }
            long[] times = this.mTimeSamples;
            if (times == null || times.length < NS) {
                long[] jArr = new long[NS];
                times = jArr;
                this.mTimeSamples = jArr;
            }
            for (int i4 = 0; i4 < NS; i4++) {
                times[i4] = in.readLong();
            }
        }
        this.mXPrecision = in.readFloat();
        this.mYPrecision = in.readFloat();
        this.mDeviceId = in.readInt();
        this.mEdgeFlags = in.readInt();
    }
}
