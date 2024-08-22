package com.bun.miitmdid;

import android.os.AsyncTask;
import androidx.annotation.Keep;
import com.bun.lib.MsaIdInterface;

@Keep
public class z extends AsyncTask<Void, Void, Boolean> {
    @Keep
    public b0 a;
    @Keep
    public MsaIdInterface b;

    public z(MsaIdInterface msaIdInterface, b0 b0Var) {
        this.b = msaIdInterface;
        this.a = b0Var;
    }

    @Keep
    /* renamed from: a */
    public native Boolean doInBackground(Void... voidArr);

    @Keep
    /* renamed from: a */
    public native void onPostExecute(Boolean bool);
}
