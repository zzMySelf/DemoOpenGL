package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.Address;
import com.baidu.location.e.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator<BDLocation>() {
        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        public BDLocation[] newArray(int i2) {
            return new BDLocation[i2];
        }
    };
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    private int A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private List<Poi> L;
    private String M;
    private String N;
    private String O;
    private Bundle P;
    private int Q;
    private int R;
    private long S;
    private String T;
    private double U;
    private double V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private int f13582a;

    /* renamed from: b  reason: collision with root package name */
    private String f13583b;

    /* renamed from: c  reason: collision with root package name */
    private double f13584c;

    /* renamed from: d  reason: collision with root package name */
    private double f13585d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13586e;

    /* renamed from: f  reason: collision with root package name */
    private double f13587f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13588g;

    /* renamed from: h  reason: collision with root package name */
    private float f13589h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13590i;

    /* renamed from: j  reason: collision with root package name */
    private float f13591j;
    private boolean k;
    private int l;
    private float m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private Address u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;

    public BDLocation() {
        this.f13582a = 0;
        this.f13583b = null;
        this.f13584c = Double.MIN_VALUE;
        this.f13585d = Double.MIN_VALUE;
        this.f13586e = false;
        this.f13587f = Double.MIN_VALUE;
        this.f13588g = false;
        this.f13589h = 0.0f;
        this.f13590i = false;
        this.f13591j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
    }

    private BDLocation(Parcel parcel) {
        this.f13582a = 0;
        this.f13583b = null;
        this.f13584c = Double.MIN_VALUE;
        this.f13585d = Double.MIN_VALUE;
        this.f13586e = false;
        this.f13587f = Double.MIN_VALUE;
        this.f13588g = false;
        this.f13589h = 0.0f;
        this.f13590i = false;
        this.f13591j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.f13582a = parcel.readInt();
        this.f13583b = parcel.readString();
        this.f13584c = parcel.readDouble();
        this.f13585d = parcel.readDouble();
        this.f13587f = parcel.readDouble();
        this.f13589h = parcel.readFloat();
        this.f13591j = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.B = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        this.u = new Address.Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.A = parcel.readInt();
        this.M = parcel.readString();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.Q = parcel.readInt();
        this.N = parcel.readString();
        this.R = parcel.readInt();
        this.O = parcel.readString();
        this.T = parcel.readString();
        this.S = parcel.readLong();
        this.U = parcel.readDouble();
        this.V = parcel.readDouble();
        try {
            parcel.readBooleanArray(zArr);
            this.f13586e = zArr[0];
            this.f13588g = zArr[1];
            this.f13590i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
            this.W = zArr[7];
        } catch (Exception e2) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.L = null;
        } else {
            this.L = arrayList;
        }
        try {
            this.P = parcel.readBundle();
        } catch (Exception e3) {
            e3.printStackTrace();
            this.P = new Bundle();
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.f13582a = 0;
        ArrayList arrayList = null;
        this.f13583b = null;
        this.f13584c = Double.MIN_VALUE;
        this.f13585d = Double.MIN_VALUE;
        this.f13586e = false;
        this.f13587f = Double.MIN_VALUE;
        this.f13588g = false;
        this.f13589h = 0.0f;
        this.f13590i = false;
        this.f13591j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.f13582a = bDLocation.f13582a;
        this.f13583b = bDLocation.f13583b;
        this.f13584c = bDLocation.f13584c;
        this.f13585d = bDLocation.f13585d;
        this.f13586e = bDLocation.f13586e;
        this.f13587f = bDLocation.f13587f;
        this.f13588g = bDLocation.f13588g;
        this.f13589h = bDLocation.f13589h;
        this.f13590i = bDLocation.f13590i;
        this.f13591j = bDLocation.f13591j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.t = bDLocation.t;
        this.u = new Address.Builder().country(bDLocation.u.country).countryCode(bDLocation.u.countryCode).province(bDLocation.u.province).city(bDLocation.u.city).cityCode(bDLocation.u.cityCode).district(bDLocation.u.district).street(bDLocation.u.street).streetNumber(bDLocation.u.streetNumber).adcode(bDLocation.u.adcode).build();
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.A = bDLocation.A;
        this.z = bDLocation.z;
        this.y = bDLocation.y;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.E = bDLocation.E;
        this.F = bDLocation.F;
        this.G = bDLocation.F;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.J = bDLocation.J;
        this.K = bDLocation.K;
        this.Q = bDLocation.Q;
        this.O = bDLocation.O;
        this.U = bDLocation.U;
        this.V = bDLocation.V;
        this.S = bDLocation.S;
        this.N = bDLocation.N;
        if (bDLocation.L != null) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < bDLocation.L.size(); i2++) {
                Poi poi = bDLocation.L.get(i2);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            }
        }
        this.L = arrayList;
        this.M = bDLocation.M;
        this.P = bDLocation.P;
        this.R = bDLocation.R;
        this.W = bDLocation.W;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0323, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0324, code lost:
        r4 = r0;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x032f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0330, code lost:
        r4 = r0;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0349, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x034a, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0355, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0356, code lost:
        r4 = r0;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0363, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0364, code lost:
        r4 = r0;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0373, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0374, code lost:
        r4 = r0;
        r9 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0383, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0384, code lost:
        r4 = r0;
        r9 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0397, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0398, code lost:
        r4 = r0;
        r9 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x039b, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x039c, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x039d, code lost:
        r13 = null;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x039f, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03a0, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:?, code lost:
        r4.printStackTrace();
        r19 = "y";
        r4 = r11;
        r6 = r12;
        r11 = r20;
        r5 = null;
        r12 = r10;
        r10 = r13;
        r13 = false;
        r22 = r15;
        r15 = r9;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0489, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x048a, code lost:
        r3 = r0;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0550, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0556, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x016a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x016b, code lost:
        r3 = r0;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x061b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x061c, code lost:
        r3 = r0;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x066f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x0670, code lost:
        r3 = r0;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0673, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0674, code lost:
        r0.printStackTrace();
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x067a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x067b, code lost:
        r2 = false;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x024e, code lost:
        r6 = null;
        r13 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03b6 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03fa A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0411 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x042e A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0447 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0460 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0479 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x04a9  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0563 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0577 A[Catch:{ Exception -> 0x0588, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0583 A[Catch:{ Exception -> 0x0588, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x058d A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0594 A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x059f A[Catch:{ Exception -> 0x016a, Error -> 0x0673 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x05bd A[Catch:{ all -> 0x05db }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0673 A[ExcHandler: Error (r0v1 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:4:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:348:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0141=Splitter:B:17:0x0141, B:281:0x0571=Splitter:B:281:0x0571, B:185:0x03a2=Splitter:B:185:0x03a2, B:23:0x0159=Splitter:B:23:0x0159, B:287:0x0589=Splitter:B:287:0x0589} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:185:0x03a2=Splitter:B:185:0x03a2, B:23:0x0159=Splitter:B:23:0x0159, B:287:0x0589=Splitter:B:287:0x0589} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BDLocation(java.lang.String r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "indoor"
            java.lang.String r4 = "aptagd"
            java.lang.String r5 = "floor"
            java.lang.String r6 = "aptag"
            java.lang.String r7 = "sema"
            java.lang.String r8 = "addr"
            r23.<init>()
            r9 = 0
            r1.f13582a = r9
            r10 = 0
            r1.f13583b = r10
            r11 = 1
            r1.f13584c = r11
            r1.f13585d = r11
            r1.f13586e = r9
            r1.f13587f = r11
            r1.f13588g = r9
            r13 = 0
            r1.f13589h = r13
            r1.f13590i = r9
            r1.f13591j = r13
            r1.k = r9
            r13 = -1
            r1.l = r13
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.m = r14
            r1.n = r10
            r1.o = r9
            r1.p = r10
            r1.q = r10
            r1.r = r10
            r1.s = r10
            r1.t = r9
            com.baidu.location.Address$Builder r14 = new com.baidu.location.Address$Builder
            r14.<init>()
            com.baidu.location.Address r14 = r14.build()
            r1.u = r14
            r1.v = r10
            r1.w = r10
            r1.x = r10
            r1.y = r9
            r1.z = r9
            r14 = 1
            r1.A = r14
            r1.B = r10
            java.lang.String r15 = ""
            r1.D = r15
            r1.E = r13
            r1.F = r9
            r13 = 2
            r1.G = r13
            r1.H = r9
            r1.I = r10
            r1.J = r10
            r1.K = r10
            r1.L = r10
            r1.M = r10
            r1.N = r10
            r1.O = r10
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r1.P = r13
            r1.Q = r9
            r1.R = r9
            r16 = r15
            r14 = 0
            r1.S = r14
            r1.T = r10
            r1.U = r11
            r1.V = r11
            r1.W = r9
            if (r2 == 0) goto L_0x0684
            r14 = r16
            boolean r15 = r2.equals(r14)
            if (r15 == 0) goto L_0x009e
            goto L_0x0684
        L_0x009e:
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x067a, Error -> 0x0673 }
            r15.<init>(r2)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            java.lang.String r2 = "result"
            org.json.JSONObject r2 = r15.getJSONObject(r2)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            java.lang.String r13 = "error"
            java.lang.String r13 = r2.getString(r13)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            r1.setLocType(r13)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            java.lang.String r11 = "time"
            java.lang.String r2 = r2.getString(r11)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            r1.setTime(r2)     // Catch:{ Exception -> 0x066f, Error -> 0x0673 }
            java.lang.String r11 = "gcj02"
            java.lang.String r12 = "radius"
            java.lang.String r10 = "point"
            java.lang.String r9 = "content"
            java.lang.String r2 = "in_cn"
            r17 = r3
            java.lang.String r3 = "x"
            r18 = r5
            java.lang.String r5 = "y"
            r19 = r8
            r8 = 61
            if (r13 != r8) goto L_0x016f
            org.json.JSONObject r4 = r15.getJSONObject(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            org.json.JSONObject r6 = r4.getJSONObject(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            double r7 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setLatitude(r7)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = r6.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            double r5 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setLongitude(r5)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = r4.getString(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setRadius(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = "s"
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setSpeed(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = "d"
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setDirection(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = "n"
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setSatelliteNumber(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = "h"
            boolean r3 = r4.has(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r3 == 0) goto L_0x0141
            java.lang.String r3 = "h"
            double r5 = r4.getDouble(r3)     // Catch:{ Exception -> 0x0140, Error -> 0x0673 }
            r1.setAltitude(r5)     // Catch:{ Exception -> 0x0140, Error -> 0x0673 }
            goto L_0x0141
        L_0x0140:
            r0 = move-exception
        L_0x0141:
            boolean r3 = r4.has(r2)     // Catch:{ Exception -> 0x0158, Error -> 0x0673 }
            if (r3 == 0) goto L_0x0153
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0158, Error -> 0x0673 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0158, Error -> 0x0673 }
            r1.setLocationWhere(r2)     // Catch:{ Exception -> 0x0158, Error -> 0x0673 }
            goto L_0x0159
        L_0x0153:
            r2 = 1
            r1.setLocationWhere(r2)     // Catch:{ Exception -> 0x0158, Error -> 0x0673 }
            goto L_0x0159
        L_0x0158:
            r0 = move-exception
        L_0x0159:
            int r2 = r1.A     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r2 != 0) goto L_0x0165
            java.lang.String r2 = "wgs84"
        L_0x0160:
            r1.setCoorType(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0684
        L_0x0165:
            r1.setCoorType(r11)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0684
        L_0x016a:
            r0 = move-exception
            r3 = r0
            r2 = 0
            goto L_0x067d
        L_0x016f:
            r8 = r13
            r13 = 161(0xa1, float:2.26E-43)
            if (r8 != r13) goto L_0x061f
            org.json.JSONObject r8 = r15.getJSONObject(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            org.json.JSONObject r9 = r8.getJSONObject(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r10 = r9.getString(r5)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r24 = r11
            double r10 = java.lang.Double.parseDouble(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setLatitude(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r9 = r9.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            double r9 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setLongitude(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r9 = r8.getString(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setRadius(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r9 = r8.has(r7)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r9 == 0) goto L_0x023b
            org.json.JSONObject r7 = r8.getJSONObject(r7)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r9 = r7.has(r6)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r9 == 0) goto L_0x01be
            java.lang.String r6 = r7.getString(r6)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r9 != 0) goto L_0x01bc
            r1.q = r6     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x01be
        L_0x01bc:
            r1.q = r14     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x01be:
            boolean r6 = r7.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r6 == 0) goto L_0x0208
            org.json.JSONObject r4 = r7.getJSONObject(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r6 = "pois"
            org.json.JSONArray r4 = r4.getJSONArray(r6)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r6.<init>()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r9 = 0
        L_0x01d5:
            int r10 = r4.length()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r9 >= r10) goto L_0x0203
            org.json.JSONObject r10 = r4.getJSONObject(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r11 = "pname"
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r12 = "pid"
            java.lang.String r12 = r10.getString(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r13 = "pr"
            r20 = r14
            double r13 = r10.getDouble(r13)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Poi r10 = new com.baidu.location.Poi     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r10.<init>(r12, r11, r13)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r6.add(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            int r9 = r9 + 1
            r14 = r20
            goto L_0x01d5
        L_0x0203:
            r20 = r14
            r1.L = r6     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x020a
        L_0x0208:
            r20 = r14
        L_0x020a:
            java.lang.String r4 = "poiregion"
            boolean r4 = r7.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0222
            java.lang.String r4 = "poiregion"
            java.lang.String r4 = r7.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r6 != 0) goto L_0x0222
            r1.r = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x0222:
            java.lang.String r4 = "regular"
            boolean r4 = r7.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x023d
            java.lang.String r4 = "regular"
            java.lang.String r4 = r7.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r6 != 0) goto L_0x023d
            r1.s = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x023d
        L_0x023b:
            r20 = r14
        L_0x023d:
            r4 = r19
            boolean r6 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r7 = ","
            if (r6 == 0) goto L_0x03e9
            org.json.JSONObject r6 = r8.getJSONObject(r4)     // Catch:{ Exception -> 0x024d, Error -> 0x0673 }
            r13 = 1
            goto L_0x0250
        L_0x024d:
            r0 = move-exception
            r6 = 0
            r13 = 0
        L_0x0250:
            if (r6 == 0) goto L_0x030b
            java.lang.String r4 = "city"
            boolean r4 = r6.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0261
            java.lang.String r4 = "city"
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0263
        L_0x0261:
            r4 = r20
        L_0x0263:
            java.lang.String r9 = "city_code"
            boolean r9 = r6.has(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r9 == 0) goto L_0x0272
            java.lang.String r9 = "city_code"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0274
        L_0x0272:
            r9 = r20
        L_0x0274:
            java.lang.String r10 = "country"
            boolean r10 = r6.has(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r10 == 0) goto L_0x0283
            java.lang.String r10 = "country"
            java.lang.String r10 = r6.getString(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0285
        L_0x0283:
            r10 = r20
        L_0x0285:
            java.lang.String r11 = "country_code"
            boolean r11 = r6.has(r11)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r11 == 0) goto L_0x0294
            java.lang.String r11 = "country_code"
            java.lang.String r11 = r6.getString(r11)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0296
        L_0x0294:
            r11 = r20
        L_0x0296:
            java.lang.String r12 = "province"
            boolean r12 = r6.has(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r12 == 0) goto L_0x02a7
            java.lang.String r12 = "province"
            java.lang.String r12 = r6.getString(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x02a9
        L_0x02a7:
            r12 = r20
        L_0x02a9:
            java.lang.String r14 = "district"
            boolean r14 = r6.has(r14)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r14 == 0) goto L_0x02b8
            java.lang.String r14 = "district"
            java.lang.String r14 = r6.getString(r14)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x02ba
        L_0x02b8:
            r14 = r20
        L_0x02ba:
            java.lang.String r15 = "street"
            boolean r15 = r6.has(r15)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r15 == 0) goto L_0x02cd
            java.lang.String r15 = "street"
            java.lang.String r15 = r6.getString(r15)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r19 = r4
            goto L_0x02d1
        L_0x02cd:
            r19 = r4
            r15 = r20
        L_0x02d1:
            java.lang.String r4 = "street_number"
            boolean r4 = r6.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x02e4
            java.lang.String r4 = "street_number"
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r21 = r4
            goto L_0x02e6
        L_0x02e4:
            r21 = r20
        L_0x02e6:
            java.lang.String r4 = "adcode"
            boolean r4 = r6.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0300
            java.lang.String r4 = "adcode"
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r6 = r14
            r14 = r21
            r22 = r5
            r5 = r4
            r4 = r19
            r19 = r22
            goto L_0x03b4
        L_0x0300:
            r6 = r14
            r4 = r19
            r14 = r21
            r19 = r5
            r5 = r20
            goto L_0x03b4
        L_0x030b:
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x0397, Error -> 0x0673 }
            java.lang.String[] r4 = r4.split(r7)     // Catch:{ Exception -> 0x0397, Error -> 0x0673 }
            int r6 = r4.length     // Catch:{ Exception -> 0x0397, Error -> 0x0673 }
            if (r6 <= 0) goto L_0x031b
            r9 = 0
            r10 = r4[r9]     // Catch:{ Exception -> 0x0397, Error -> 0x0673 }
            r9 = 1
            goto L_0x031d
        L_0x031b:
            r9 = 1
            r10 = 0
        L_0x031d:
            if (r6 <= r9) goto L_0x0328
            r11 = r4[r9]     // Catch:{ Exception -> 0x0323, Error -> 0x0673 }
            r9 = 2
            goto L_0x032a
        L_0x0323:
            r0 = move-exception
            r4 = r0
            r9 = 0
            goto L_0x039b
        L_0x0328:
            r9 = 2
            r11 = 0
        L_0x032a:
            if (r6 <= r9) goto L_0x0334
            r12 = r4[r9]     // Catch:{ Exception -> 0x032f, Error -> 0x0673 }
            goto L_0x0335
        L_0x032f:
            r0 = move-exception
            r4 = r0
            r9 = 0
            goto L_0x039c
        L_0x0334:
            r12 = 0
        L_0x0335:
            r9 = 3
            if (r6 <= r9) goto L_0x0341
            r9 = 3
            r9 = r4[r9]     // Catch:{ Exception -> 0x033c, Error -> 0x0673 }
            goto L_0x0342
        L_0x033c:
            r0 = move-exception
            r4 = r0
            r9 = 0
            goto L_0x039d
        L_0x0341:
            r9 = 0
        L_0x0342:
            r14 = 4
            if (r6 <= r14) goto L_0x034d
            r14 = 4
            r14 = r4[r14]     // Catch:{ Exception -> 0x0349, Error -> 0x0673 }
            goto L_0x034e
        L_0x0349:
            r0 = move-exception
            r4 = r0
            goto L_0x039d
        L_0x034d:
            r14 = 0
        L_0x034e:
            r15 = 5
            if (r6 <= r15) goto L_0x0359
            r15 = 5
            r15 = r4[r15]     // Catch:{ Exception -> 0x0355, Error -> 0x0673 }
            goto L_0x035a
        L_0x0355:
            r0 = move-exception
            r4 = r0
            r13 = 0
            goto L_0x039f
        L_0x0359:
            r15 = 0
        L_0x035a:
            r13 = 6
            if (r6 <= r13) goto L_0x0367
            r13 = 6
            r13 = r4[r13]     // Catch:{ Exception -> 0x0363, Error -> 0x0673 }
            r19 = r9
            goto L_0x036a
        L_0x0363:
            r0 = move-exception
            r4 = r0
            r13 = 0
            goto L_0x03a0
        L_0x0367:
            r19 = r9
            r13 = 0
        L_0x036a:
            r9 = 7
            if (r6 <= r9) goto L_0x0378
            r9 = 7
            r9 = r4[r9]     // Catch:{ Exception -> 0x0373, Error -> 0x0673 }
            r20 = r9
            goto L_0x037a
        L_0x0373:
            r0 = move-exception
            r4 = r0
            r9 = r19
            goto L_0x03a0
        L_0x0378:
            r20 = 0
        L_0x037a:
            r9 = 8
            if (r6 <= r9) goto L_0x0388
            r6 = 8
            r4 = r4[r6]     // Catch:{ Exception -> 0x0383, Error -> 0x0673 }
            goto L_0x0389
        L_0x0383:
            r0 = move-exception
            r4 = r0
            r9 = r19
            goto L_0x03a2
        L_0x0388:
            r4 = 0
        L_0x0389:
            r6 = r12
            r9 = r15
            r15 = r19
            r19 = r5
            r12 = r10
            r10 = r13
            r13 = 1
            r5 = r4
            r4 = r11
            r11 = r20
            goto L_0x03b4
        L_0x0397:
            r0 = move-exception
            r4 = r0
            r9 = 0
            r10 = 0
        L_0x039b:
            r11 = 0
        L_0x039c:
            r12 = 0
        L_0x039d:
            r13 = 0
            r14 = 0
        L_0x039f:
            r15 = 0
        L_0x03a0:
            r20 = 0
        L_0x03a2:
            r4.printStackTrace()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r19 = r5
            r4 = r11
            r6 = r12
            r11 = r20
            r5 = 0
            r12 = r10
            r10 = r13
            r13 = 0
            r22 = r15
            r15 = r9
            r9 = r22
        L_0x03b4:
            if (r13 == 0) goto L_0x03f2
            com.baidu.location.Address$Builder r13 = new com.baidu.location.Address$Builder     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r13.<init>()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r10 = r13.country(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r10 = r10.countryCode(r11)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r10 = r10.province(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r4 = r10.city(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r4 = r4.cityCode(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r4 = r4.district(r6)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r4 = r4.street(r15)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r4 = r4.streetNumber(r14)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address$Builder r4 = r4.adcode(r5)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            com.baidu.location.Address r4 = r4.build()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.u = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r4 = 1
            r1.o = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x03f2
        L_0x03e9:
            r19 = r5
            r4 = 0
            r1.o = r4     // Catch:{ Exception -> 0x061b, Error -> 0x0673 }
            r4 = 0
            r1.setAddrStr(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x03f2:
            r4 = r18
            boolean r5 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r5 == 0) goto L_0x0409
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.v = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0409
            r4 = 0
            r1.v = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x0409:
            r4 = r17
            boolean r5 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r5 == 0) goto L_0x0426
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r5 != 0) goto L_0x0426
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setUserIndoorState(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x0426:
            java.lang.String r4 = "loctp"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x043f
            java.lang.String r4 = "loctp"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.B = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x043f
            r4 = 0
            r1.B = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x043f:
            java.lang.String r4 = "bldgid"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0458
            java.lang.String r4 = "bldgid"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.w = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0458
            r4 = 0
            r1.w = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x0458:
            java.lang.String r4 = "bldg"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0471
            java.lang.String r4 = "bldg"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.x = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0471
            r4 = 0
            r1.x = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x0471:
            java.lang.String r4 = "ibav"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x04a1
            java.lang.String r4 = "ibav"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r5 == 0) goto L_0x048e
        L_0x0485:
            r5 = 0
            r1.z = r5     // Catch:{ Exception -> 0x0489, Error -> 0x0673 }
            goto L_0x04a1
        L_0x0489:
            r0 = move-exception
            r3 = r0
            r2 = r5
            goto L_0x067d
        L_0x048e:
            java.lang.String r5 = "0"
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r5 == 0) goto L_0x0497
            goto L_0x0485
        L_0x0497:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.z = r4     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x04a1:
            java.lang.String r4 = "indoorflags"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x055b
            java.lang.String r4 = "indoorflags"
            org.json.JSONObject r4 = r8.getJSONObject(r4)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            java.lang.String r5 = "area"
            boolean r5 = r4.has(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 == 0) goto L_0x04d2
            java.lang.String r5 = "area"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 != 0) goto L_0x04cc
            r6 = 2
            r1.setIndoorLocationSurpport(r6)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            goto L_0x04d2
        L_0x04cc:
            r6 = 1
            if (r5 != r6) goto L_0x04d2
            r1.setIndoorLocationSurpport(r6)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
        L_0x04d2:
            java.lang.String r5 = "support"
            boolean r5 = r4.has(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 == 0) goto L_0x04ed
            java.lang.String r5 = "support"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            r1.setIndoorLocationSource(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
        L_0x04ed:
            java.lang.String r5 = "inbldg"
            boolean r5 = r4.has(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 == 0) goto L_0x04fd
            java.lang.String r5 = "inbldg"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            r1.I = r5     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
        L_0x04fd:
            java.lang.String r5 = "inbldgid"
            boolean r5 = r4.has(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 == 0) goto L_0x050d
            java.lang.String r5 = "inbldgid"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            r1.J = r5     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
        L_0x050d:
            java.lang.String r5 = "polygon"
            boolean r5 = r4.has(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 == 0) goto L_0x0520
            java.lang.String r5 = "polygon"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            r1.setIndoorSurpportPolygon(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
        L_0x0520:
            java.lang.String r5 = "ret_fields"
            boolean r5 = r4.has(r5)     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            if (r5 == 0) goto L_0x055b
            java.lang.String r5 = "ret_fields"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            java.lang.String r5 = "\\|"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            int r5 = r4.length     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            r6 = 0
        L_0x0538:
            if (r6 >= r5) goto L_0x055b
            r9 = r4[r6]     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            java.lang.String r10 = "="
            java.lang.String[] r9 = r9.split(r10)     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            r10 = 0
            r11 = r9[r10]     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            r10 = 1
            r9 = r9[r10]     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            android.os.Bundle r10 = r1.P     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            r10.putString(r11, r9)     // Catch:{ Exception -> 0x0550, Error -> 0x0673 }
            int r6 = r6 + 1
            goto L_0x0538
        L_0x0550:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()     // Catch:{ Exception -> 0x0556, Error -> 0x0673 }
            goto L_0x055b
        L_0x0556:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x055b:
            java.lang.String r4 = "gpscs"
            boolean r4 = r8.has(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r4 == 0) goto L_0x056d
            java.lang.String r4 = "gpscs"
            int r4 = r8.getInt(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setGpsCheckStatus(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0571
        L_0x056d:
            r4 = 0
            r1.setGpsCheckStatus(r4)     // Catch:{ Exception -> 0x061b, Error -> 0x0673 }
        L_0x0571:
            boolean r4 = r8.has(r2)     // Catch:{ Exception -> 0x0588, Error -> 0x0673 }
            if (r4 == 0) goto L_0x0583
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x0588, Error -> 0x0673 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0588, Error -> 0x0673 }
            r1.setLocationWhere(r2)     // Catch:{ Exception -> 0x0588, Error -> 0x0673 }
            goto L_0x0589
        L_0x0583:
            r2 = 1
            r1.setLocationWhere(r2)     // Catch:{ Exception -> 0x0588, Error -> 0x0673 }
            goto L_0x0589
        L_0x0588:
            r0 = move-exception
        L_0x0589:
            int r2 = r1.A     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r2 != 0) goto L_0x0594
            java.lang.String r2 = "wgs84"
        L_0x0590:
            r1.setCoorType(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0597
        L_0x0594:
            r2 = r24
            goto L_0x0590
        L_0x0597:
            java.lang.String r2 = "navi"
            boolean r2 = r8.has(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r2 == 0) goto L_0x05a7
            java.lang.String r2 = "navi"
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.T = r2     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x05a7:
            java.lang.String r2 = "navi_client"
            boolean r2 = r8.has(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r2 == 0) goto L_0x05e0
            java.lang.String r2 = "navi_client"
            java.lang.String r2 = r8.getString(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r2 == 0) goto L_0x05e0
            boolean r4 = r2.contains(r7)     // Catch:{ all -> 0x05db }
            if (r4 == 0) goto L_0x05e0
            java.lang.String[] r2 = r2.split(r7)     // Catch:{ all -> 0x05db }
            r4 = 0
            r5 = r2[r4]     // Catch:{ all -> 0x05db }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x05db }
            int r4 = r4.intValue()     // Catch:{ all -> 0x05db }
            r5 = 1
            r2 = r2[r5]     // Catch:{ all -> 0x05db }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x05db }
            r2.intValue()     // Catch:{ all -> 0x05db }
            if (r4 <= 0) goto L_0x05e0
            r1.W = r5     // Catch:{ all -> 0x05db }
            goto L_0x05e0
        L_0x05db:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
        L_0x05e0:
            java.lang.String r2 = "nrl_point"
            boolean r2 = r8.has(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            if (r2 == 0) goto L_0x0684
            java.lang.String r2 = "nrl_point"
            org.json.JSONObject r2 = r8.getJSONObject(r2)     // Catch:{ all -> 0x0612 }
            boolean r4 = r2.has(r3)     // Catch:{ all -> 0x0612 }
            if (r4 == 0) goto L_0x0684
            r4 = r19
            boolean r5 = r2.has(r4)     // Catch:{ all -> 0x0612 }
            if (r5 == 0) goto L_0x0684
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x0612 }
            double r4 = java.lang.Double.parseDouble(r4)     // Catch:{ all -> 0x0612 }
            r1.U = r4     // Catch:{ all -> 0x0612 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x0612 }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ all -> 0x0612 }
            r1.V = r2     // Catch:{ all -> 0x0612 }
            goto L_0x0684
        L_0x0612:
            r0 = move-exception
            r2 = 1
            r1.U = r2     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.V = r2     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0684
        L_0x061b:
            r0 = move-exception
            r3 = r0
            r2 = r4
            goto L_0x067d
        L_0x061f:
            r4 = r5
            r2 = r11
            r5 = 66
            if (r8 == r5) goto L_0x0633
            r5 = 68
            if (r8 != r5) goto L_0x062a
            goto L_0x0633
        L_0x062a:
            r2 = 167(0xa7, float:2.34E-43)
            if (r8 != r2) goto L_0x0684
            r2 = 2
            r1.setLocationWhere(r2)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0684
        L_0x0633:
            org.json.JSONObject r5 = r15.getJSONObject(r9)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            org.json.JSONObject r6 = r5.getJSONObject(r10)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            double r7 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setLatitude(r7)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = r6.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            double r3 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setLongitude(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = r5.getString(r12)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.setRadius(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.String r3 = "isCellChanged"
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            r1.a(r3)     // Catch:{ Exception -> 0x016a, Error -> 0x0673 }
            goto L_0x0160
        L_0x066f:
            r0 = move-exception
            r3 = r0
            r2 = r9
            goto L_0x067d
        L_0x0673:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            r2 = 0
            goto L_0x0680
        L_0x067a:
            r0 = move-exception
            r2 = r9
            r3 = r0
        L_0x067d:
            r3.printStackTrace()
        L_0x0680:
            r1.f13582a = r2
            r1.o = r2
        L_0x0684:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.BDLocation.<init>(java.lang.String):void");
    }

    private void a(Boolean bool) {
        this.t = bool.booleanValue();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.u.adcode;
    }

    public String getAddrStr() {
        return this.u.address;
    }

    public Address getAddress() {
        return this.u;
    }

    public double getAltitude() {
        return this.f13587f;
    }

    public String getBuildingID() {
        return this.w;
    }

    public String getBuildingName() {
        return this.x;
    }

    public String getCity() {
        return this.u.city;
    }

    public String getCityCode() {
        return this.u.cityCode;
    }

    public String getCoorType() {
        return this.n;
    }

    public String getCountry() {
        return this.u.country;
    }

    public String getCountryCode() {
        return this.u.countryCode;
    }

    public long getDelayTime() {
        return this.S;
    }

    @Deprecated
    public float getDerect() {
        return this.m;
    }

    public float getDirection() {
        return this.m;
    }

    public String getDistrict() {
        return this.u.district;
    }

    public Location getExtraLocation(String str) {
        Bundle bundle = this.P;
        if (bundle == null) {
            return null;
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable instanceof Location) {
            return (Location) parcelable;
        }
        return null;
    }

    public String getFloor() {
        return this.v;
    }

    public double[] getFusionLocInfo(String str) {
        return this.P.getDoubleArray(str);
    }

    public int getGpsAccuracyStatus() {
        return this.Q;
    }

    public int getGpsCheckStatus() {
        return this.R;
    }

    public int getIndoorLocationSource() {
        return this.H;
    }

    public int getIndoorLocationSurpport() {
        return this.F;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.J;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.I;
    }

    public int getIndoorNetworkState() {
        return this.G;
    }

    public String getIndoorSurpportPolygon() {
        return this.K;
    }

    public double getLatitude() {
        return this.f13584c;
    }

    public int getLocType() {
        return this.f13582a;
    }

    public String getLocTypeDescription() {
        return this.M;
    }

    public String getLocationDescribe() {
        return this.q;
    }

    public String getLocationID() {
        return this.N;
    }

    public int getLocationWhere() {
        return this.A;
    }

    public double getLongitude() {
        return this.f13585d;
    }

    public String getNetworkLocationType() {
        return this.B;
    }

    public double getNrlLat() {
        return this.U;
    }

    public double getNrlLon() {
        return this.V;
    }

    public String getNrlResult() {
        return this.T;
    }

    public int getOperators() {
        return this.C;
    }

    public List<Poi> getPoiList() {
        return this.L;
    }

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.f13591j;
    }

    public String getRetFields(String str) {
        return this.P.getString(str);
    }

    public String getRoadLocString() {
        return this.O;
    }

    public int getSatelliteNumber() {
        this.k = true;
        return this.l;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.q;
    }

    public float getSpeed() {
        return this.f13589h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.f13583b;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public String getVdrJsonString() {
        Bundle bundle = this.P;
        if (bundle == null || !bundle.containsKey("vdr")) {
            return null;
        }
        return this.P.getString("vdr");
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.f13586e;
    }

    public boolean hasRadius() {
        return this.f13590i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.f13588g;
    }

    public boolean isCellChangeFlag() {
        return this.t;
    }

    public boolean isInIndoorPark() {
        return this.W;
    }

    public boolean isIndoorLocMode() {
        return this.y;
    }

    public boolean isNrlAvailable() {
        return (this.V == Double.MIN_VALUE || this.U == Double.MIN_VALUE) ? false : true;
    }

    public int isParkAvailable() {
        return this.z;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.u = address;
            this.o = true;
        }
    }

    public void setAddrStr(String str) {
        this.p = str;
        this.o = str != null;
    }

    public void setAltitude(double d2) {
        if (d2 < 9999.0d) {
            this.f13587f = d2;
            this.f13586e = true;
        }
    }

    public void setBuildingID(String str) {
        this.w = str;
    }

    public void setBuildingName(String str) {
        this.x = str;
    }

    public void setCoorType(String str) {
        this.n = str;
    }

    public void setDelayTime(long j2) {
        this.S = j2;
    }

    public void setDirection(float f2) {
        this.m = f2;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putParcelable(str, location);
    }

    public void setFloor(String str) {
        this.v = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putDoubleArray(str, dArr);
    }

    public void setGpsAccuracyStatus(int i2) {
        this.Q = i2;
    }

    public void setGpsCheckStatus(int i2) {
        this.R = i2;
    }

    public void setIndoorLocMode(boolean z2) {
        this.y = z2;
    }

    public void setIndoorLocationSource(int i2) {
        this.H = i2;
    }

    public void setIndoorLocationSurpport(int i2) {
        this.F = i2;
    }

    public void setIndoorNetworkState(int i2) {
        this.G = i2;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.K = str;
    }

    public void setLatitude(double d2) {
        this.f13584c = d2;
    }

    public void setLocType(int i2) {
        String str;
        this.f13582a = i2;
        switch (i2) {
            case 61:
                setLocTypeDescription("GPS location successful!");
                setUserIndoorState(0);
                return;
            case 62:
                str = "Location failed beacuse we can not get any loc information!";
                break;
            case 63:
            case 67:
                str = "Offline location failed, please check the net (wifi/cell)!";
                break;
            case 66:
                str = "Offline location successful!";
                break;
            case 161:
                str = "NetWork location successful!";
                break;
            case 162:
                str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                break;
            case TypeServerError /*167*/:
                str = "NetWork location failed because baidu location service can not caculate the location!";
                break;
            case 505:
                str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                break;
            default:
                str = "UnKnown!";
                break;
        }
        setLocTypeDescription(str);
    }

    public void setLocTypeDescription(String str) {
        this.M = str;
    }

    public void setLocationDescribe(String str) {
        this.q = str;
    }

    public void setLocationID(String str) {
        this.N = str;
    }

    public void setLocationWhere(int i2) {
        this.A = i2;
    }

    public void setLongitude(double d2) {
        this.f13585d = d2;
    }

    public void setNetworkLocationType(String str) {
        this.B = str;
    }

    public void setNrlData(String str) {
        this.T = str;
    }

    public void setOperators(int i2) {
        this.C = i2;
    }

    public void setParkAvailable(int i2) {
        this.z = i2;
    }

    public void setPoiList(List<Poi> list) {
        this.L = list;
    }

    public void setRadius(float f2) {
        this.f13591j = f2;
        this.f13590i = true;
    }

    public void setRetFields(String str, String str2) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putString(str, str2);
    }

    public void setRoadLocString(float f2, float f3) {
        String str;
        String str2 = "";
        if (((double) f2) > 0.001d) {
            str = String.format("%.2f", new Object[]{Float.valueOf(f2)});
        } else {
            str = str2;
        }
        if (((double) f3) > 0.001d) {
            str2 = String.format("%.2f", new Object[]{Float.valueOf(f3)});
        }
        if (this.T != null) {
            this.O = String.format(Locale.US, "%s|%s,%s", new Object[]{this.T, str, str2});
        }
    }

    public void setSatelliteNumber(int i2) {
        this.l = i2;
    }

    public void setSpeed(float f2) {
        this.f13589h = f2;
        this.f13588g = true;
    }

    public void setTime(String str) {
        this.f13583b = str;
        setLocationID(h.a(str));
    }

    public void setUserIndoorState(int i2) {
        this.E = i2;
    }

    public void setVdrJsonValue(String str) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putString("vdr", str);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f13582a);
        parcel.writeString(this.f13583b);
        parcel.writeDouble(this.f13584c);
        parcel.writeDouble(this.f13585d);
        parcel.writeDouble(this.f13587f);
        parcel.writeFloat(this.f13589h);
        parcel.writeFloat(this.f13591j);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeString(this.v);
        parcel.writeInt(this.z);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.B);
        parcel.writeString(this.u.province);
        parcel.writeString(this.u.city);
        parcel.writeString(this.u.district);
        parcel.writeString(this.u.street);
        parcel.writeString(this.u.streetNumber);
        parcel.writeString(this.u.cityCode);
        parcel.writeString(this.u.address);
        parcel.writeString(this.u.country);
        parcel.writeString(this.u.countryCode);
        parcel.writeString(this.u.adcode);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.A);
        parcel.writeString(this.M);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeInt(this.Q);
        parcel.writeString(this.N);
        parcel.writeInt(this.R);
        parcel.writeString(this.O);
        parcel.writeString(this.T);
        parcel.writeLong(this.S);
        parcel.writeDouble(this.U);
        parcel.writeDouble(this.V);
        parcel.writeBooleanArray(new boolean[]{this.f13586e, this.f13588g, this.f13590i, this.k, this.o, this.t, this.y, this.W});
        parcel.writeList(this.L);
        parcel.writeBundle(this.P);
    }
}
