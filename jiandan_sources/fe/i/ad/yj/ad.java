package fe.i.ad.yj;

import android.os.Handler;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ad implements InvocationHandler {

    /* renamed from: ad  reason: collision with root package name */
    public Object f4455ad;

    public static ad qw() {
        return new ad();
    }

    public final void ad(WindowManager.LayoutParams layoutParams) {
        de(layoutParams, 8192, 8192);
    }

    public final void de(WindowManager.LayoutParams layoutParams, int i2, int i3) {
        if (layoutParams != null) {
            try {
                layoutParams.flags = (i2 & i3) | (layoutParams.flags & (~i3));
            } catch (Exception e) {
                LogUtil.e("PopupWindowRecordProxy", e.getMessage(), e);
            }
        }
    }

    public void fe(PopupWindow popupWindow) {
        if (popupWindow != null) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(popupWindow);
                this.f4455ad = obj;
                if (obj != null) {
                    declaredField.set(popupWindow, Proxy.newProxyInstance(Handler.class.getClassLoader(), new Class[]{WindowManager.class}, this));
                }
            } catch (IllegalAccessException e) {
                LogUtil.e("PopupWindowRecordProxy", e.getMessage(), e);
            } catch (NoSuchFieldException e2) {
                LogUtil.e("PopupWindowRecordProxy", e2.getMessage(), e2);
            }
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method != null) {
            try {
                if (method.getName() != null && method.getName().equals("addView") && objArr != null && objArr.length == 2) {
                    ad(objArr[1]);
                }
            } catch (Exception e) {
                LogUtil.e("PopupWindowRecordProxy", e.getMessage(), e);
            }
        }
        return method.invoke(this.f4455ad, objArr);
    }
}
