package com.tera.scan.vip.pay.aliapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import fe.fe.when.qw.qw.de;

public class AliPayEntryActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new de().qw(this, getIntent());
        finish();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        new de().qw(this, getIntent());
        finish();
    }
}
