package fe.mmm.qw.m.when.qw.qw;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

public class qw {
    @SerializedName("is_hide_account_center_third_party")

    /* renamed from: ad  reason: collision with root package name */
    public boolean f8064ad = true;
    @SerializedName("is_hybrid_vip_buy_url")

    /* renamed from: de  reason: collision with root package name */
    public boolean f8065de = true;
    @SerializedName("add_params_url")
    public String qw = "eopa.baidu.com";

    public qw(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            qw(str);
        }
    }

    public final void qw(String str) {
        qw qwVar;
        try {
            if (!TextUtils.isEmpty(str) && (qwVar = (qw) new Gson().fromJson(str, getClass())) != null) {
                if (!TextUtils.isEmpty(qwVar.qw)) {
                    this.qw = qwVar.qw;
                }
                this.f8064ad = qwVar.f8064ad;
                this.f8065de = qwVar.f8065de;
            }
        } catch (JsonSyntaxException e) {
            fe.mmm.qw.i.qw.ad("ConfigWebView", "init.JsonSyntaxException.e:" + e.getMessage());
        } catch (JsonIOException e2) {
            fe.mmm.qw.i.qw.ad("ConfigWebView", "init.IOException.e:" + e2.getMessage());
        } catch (JsonParseException e3) {
            fe.mmm.qw.i.qw.ad("ConfigWebView", "init.JsonParseException.e:" + e3.getMessage());
        } catch (IllegalArgumentException e4) {
            fe.mmm.qw.i.qw.ad("ConfigWebView", "init.IllegalArgumentException.e:" + e4.getMessage());
        } catch (Exception e5) {
            fe.mmm.qw.i.qw.ggg("ConfigWebView", "配置项初始化错误", e5);
            if (fe.mmm.qw.i.qw.o()) {
                throw e5;
            }
        }
    }
}
