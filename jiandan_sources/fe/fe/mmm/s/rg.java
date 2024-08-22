package fe.fe.mmm.s;

import com.baidu.ubc.IUBCABTest;
import com.baidu.ubc.IUBCContext;
import com.baidu.ubc.IUBCUploader;
import com.baidu.ubc.inter.IAppConfigService;
import com.baidu.ubc.inter.IExternalService;
import com.baidu.ubc.inter.IIPCService;
import com.baidu.ubc.inter.IUBCLogIdSpService;
import com.baidu.ubc.inter.IUBCServiceFactory;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static IAppConfigService f2115ad;

    /* renamed from: de  reason: collision with root package name */
    public static IIPCService f2116de;

    /* renamed from: fe  reason: collision with root package name */
    public static IExternalService f2117fe;
    public static volatile IUBCServiceFactory qw;

    /* renamed from: rg  reason: collision with root package name */
    public static IUBCContext f2118rg;

    /* renamed from: th  reason: collision with root package name */
    public static IUBCUploader f2119th;

    /* renamed from: uk  reason: collision with root package name */
    public static IUBCLogIdSpService f2120uk;

    /* renamed from: yj  reason: collision with root package name */
    public static IUBCABTest f2121yj;

    public static IExternalService ad() {
        IExternalService iExternalService = f2117fe;
        if (iExternalService != null) {
            return iExternalService;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2117fe = qw.th();
        }
        return f2117fe;
    }

    public static IIPCService de() {
        IIPCService iIPCService = f2116de;
        if (iIPCService != null) {
            return iIPCService;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2116de = qw.de();
        }
        return f2116de;
    }

    public static IUBCServiceFactory fe() {
        synchronized (rg.class) {
            if (qw == null) {
                qw = fe.qw();
            }
        }
        return qw;
    }

    public static IAppConfigService qw() {
        IAppConfigService iAppConfigService = f2115ad;
        if (iAppConfigService != null) {
            return iAppConfigService;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2115ad = qw.qw();
        }
        return f2115ad;
    }

    public static IUBCABTest rg() {
        IUBCABTest iUBCABTest = f2121yj;
        if (iUBCABTest != null) {
            return iUBCABTest;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2121yj = qw.fe();
        }
        return f2121yj;
    }

    public static IUBCContext th() {
        IUBCContext iUBCContext = f2118rg;
        if (iUBCContext != null) {
            return iUBCContext;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2118rg = qw.ad();
        }
        return f2118rg;
    }

    public static IUBCUploader uk() {
        IUBCUploader iUBCUploader = f2119th;
        if (iUBCUploader != null) {
            return iUBCUploader;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2119th = qw.rg();
        }
        return f2119th;
    }

    public static IUBCLogIdSpService yj() {
        IUBCLogIdSpService iUBCLogIdSpService = f2120uk;
        if (iUBCLogIdSpService != null) {
            return iUBCLogIdSpService;
        }
        if (qw == null) {
            qw = fe();
        }
        if (qw != null) {
            f2120uk = qw.yj();
        }
        return f2120uk;
    }
}
