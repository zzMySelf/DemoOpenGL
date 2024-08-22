package fe.fe.mmm;

import com.baidu.ubc.IUBCABTest;
import com.baidu.ubc.IUBCContext;
import com.baidu.ubc.IUBCUploader;
import com.baidu.ubc.inter.IAppConfigService;
import com.baidu.ubc.inter.IExternalService;
import com.baidu.ubc.inter.IIPCService;
import com.baidu.ubc.inter.IUBCLogIdSpService;
import com.baidu.ubc.inter.IUBCServiceFactory;
import com.baidu.ubc.service.IPCService;
import fe.fe.mmm.s.ad;
import fe.fe.mmm.s.de;
import fe.fe.mmm.s.qw;

public class f implements IUBCServiceFactory {

    /* renamed from: ad  reason: collision with root package name */
    public IPCService f2022ad;

    /* renamed from: de  reason: collision with root package name */
    public ad f2023de;

    /* renamed from: fe  reason: collision with root package name */
    public de f2024fe;
    public qw qw;

    public IUBCContext ad() {
        return fe.fe.mmm.q.qw.de();
    }

    public IIPCService de() {
        if (this.f2022ad == null) {
            this.f2022ad = new IPCService();
        }
        return this.f2022ad;
    }

    public IUBCABTest fe() {
        return fe.fe.mmm.q.qw.ad();
    }

    public IAppConfigService qw() {
        if (this.qw == null) {
            this.qw = new qw();
        }
        return this.qw;
    }

    public IUBCUploader rg() {
        return fe.fe.mmm.q.qw.fe();
    }

    public IExternalService th() {
        if (this.f2023de == null) {
            this.f2023de = new ad();
        }
        return this.f2023de;
    }

    public IUBCLogIdSpService yj() {
        if (this.f2024fe == null) {
            this.f2024fe = new de();
        }
        return this.f2024fe;
    }
}
