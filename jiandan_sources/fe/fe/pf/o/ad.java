package fe.fe.pf.o;

import com.baidu.helios.channels.ChannelFactory;
import com.baidu.helios.channels.csc.QuantumChannel;
import fe.fe.pf.rg.qw;
import fe.fe.pf.rg.rg.de;
import java.util.ArrayList;
import java.util.List;

public class ad implements ChannelFactory.ChannelProvider {
    public List<qw> qw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new de());
        arrayList.add(new QuantumChannel());
        arrayList.add(new fe.fe.pf.rg.de.qw());
        arrayList.add(new fe.fe.pf.rg.de.ad());
        arrayList.add(new fe.fe.pf.rg.fe.qw());
        return arrayList;
    }
}
