package fe.fe.o.rg.de;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.TooltipCompatHandler;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public class when extends BroadcastReceiver {
    public final /* synthetic */ qw qw;

    public when(qw qwVar) {
        this.qw = qwVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION) && this.qw.f83if != null) {
            this.qw.f83if.removeMessages(2);
            this.qw.f83if.sendMessageDelayed(this.qw.f83if.obtainMessage(2), TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        }
    }
}
