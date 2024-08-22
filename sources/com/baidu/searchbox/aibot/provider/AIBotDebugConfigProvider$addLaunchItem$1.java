package com.baidu.searchbox.aibot.provider;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.searchbox.debug.data.ViewFetcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/aibot/provider/AIBotDebugConfigProvider$addLaunchItem$1", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "fetchView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lib-aibot-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotDebugConfigProvider.kt */
public final class AIBotDebugConfigProvider$addLaunchItem$1 implements ViewFetcher {
    AIBotDebugConfigProvider$addLaunchItem$1() {
    }

    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout $this$fetchView_u24lambda_u2d2 = linearLayout;
        $this$fetchView_u24lambda_u2d2.setOrientation(1);
        $this$fetchView_u24lambda_u2d2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(context);
        EditText $this$fetchView_u24lambda_u2d2_u24lambda_u2d0 = editText;
        $this$fetchView_u24lambda_u2d2_u24lambda_u2d0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        $this$fetchView_u24lambda_u2d2_u24lambda_u2d0.setHint("input appid");
        EditText editText2 = new EditText(context);
        EditText $this$fetchView_u24lambda_u2d2_u24lambda_u2d1 = editText2;
        $this$fetchView_u24lambda_u2d2_u24lambda_u2d1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        $this$fetchView_u24lambda_u2d2_u24lambda_u2d1.setHint("input aibot 自定义 url");
        EditText editUrlText = editText2;
        $this$fetchView_u24lambda_u2d2.addView(editText);
        Function2 makeBtn = new AIBotDebugConfigProvider$addLaunchItem$1$fetchView$1$makeBtn$1(context, editText);
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("加载主bot线上地址", "https://chat.baidu.com?from=home&page_type=na&source=home_ic"));
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("加载主bot线下地址", "http://pcheng13.bcc-szth.baidu.com:8084/from=home&page_type=na&source=home_ic"));
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("加载子bot线上地址", "http://chat.baidu.com/bot?page_type=na"));
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("加载子bot线下地址", "http://pcheng13.bcc-szth.baidu.com:8084/bot?page_type=na"));
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("预加载联调地址", "http://voice-proxy.bcc-bdbl.baidu.com:8111/bot?appId=b730178a5bc045daa0105dc9d2dd9f3e&service=hoth_hl&page_type=na"));
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("点我，加载FE线下地址", "http://voice-proxy.bcc-bdbl.baidu.com:8111/bot?page_type=na&service=hoth_ch"));
        $this$fetchView_u24lambda_u2d2.addView((View) makeBtn.invoke("加载8111默认线下地址", "http://voice-proxy.bcc-bdbl.baidu.com:8111/bot?page_type=na"));
        $this$fetchView_u24lambda_u2d2.addView(editUrlText);
        $this$fetchView_u24lambda_u2d2.addView((View) new AIBotDebugConfigProvider$addLaunchItem$1$fetchView$1$makeBotUrlBtn$1(context, editUrlText).invoke("点我，加载子bot自定义url", ""));
        return linearLayout;
    }
}
