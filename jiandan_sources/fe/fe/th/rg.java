package fe.fe.th;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import fe.fe.aaa.qw;

public class rg extends BroadcastReceiver {
    public final /* synthetic */ qw qw;

    public rg(qw qwVar) {
        this.qw = qwVar;
    }

    public void onReceive(Context context, Intent intent) {
        qw.ad("ClientUpdater", "receive:android.net.conn.CONNECTIVITY_CHANGE");
        this.qw.ad();
    }
}
