package fe.fe.o.de;

import java.util.List;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f2486ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public String f2487de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2488fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f2489rg;

    /* renamed from: th  reason: collision with root package name */
    public int f2490th = 0;

    /* renamed from: yj  reason: collision with root package name */
    public List f2491yj;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[retryType=");
        stringBuffer.append(this.f2486ad);
        stringBuffer.append("]");
        stringBuffer.append("[retryException=");
        stringBuffer.append(this.f2487de);
        stringBuffer.append("]");
        stringBuffer.append("[retryStrategyInfo=");
        stringBuffer.append(this.f2488fe);
        stringBuffer.append("]");
        stringBuffer.append("[extendType=");
        stringBuffer.append(this.f2490th);
        stringBuffer.append("]");
        stringBuffer.append("[extendInfo=");
        stringBuffer.append(this.f2489rg);
        stringBuffer.append("[allInfo=");
        stringBuffer.append(this.qw);
        stringBuffer.append("]");
        List list = this.f2491yj;
        if (list != null && !list.isEmpty()) {
            for (yj yjVar : this.f2491yj) {
                stringBuffer.append("host:" + yjVar.f2507ad + "ip:" + yjVar.f2508th + "t:" + yjVar.f2509yj);
            }
        }
        return stringBuffer.toString();
    }
}
