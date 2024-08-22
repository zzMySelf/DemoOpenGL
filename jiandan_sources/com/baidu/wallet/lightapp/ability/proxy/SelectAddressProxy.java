package com.baidu.wallet.lightapp.ability.proxy;

import android.app.Activity;
import android.content.Intent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.business.presenter.b;

public class SelectAddressProxy extends BaseActivity {
    public static b a;
    public ContactInfoPresenter b;
    public boolean c = true;

    private void a() {
        this.b = new ContactInfoPresenter(getActivity(), a);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        getActivity().startActivityForResult(intent, 4);
    }

    private void b() {
        this.b = null;
        a = null;
        finish();
    }

    public static void startSelectAddress(Activity activity, b bVar) {
        a = bVar;
        activity.startActivity(new Intent(activity, SelectAddressProxy.class));
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public boolean isSlidingEnable() {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        if (i2 == 4) {
            if (i3 != -1) {
                b bVar = a;
                if (bVar != null) {
                    bVar.onContactsSelected("", 1, (String[]) null, "取消", "0");
                }
            } else if (!(intent == null || intent.getData() == null || (contactInfoPresenter = this.b) == null)) {
                contactInfoPresenter.a(intent.getData());
            }
            b();
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onResume() {
        super.onResume();
        if (this.c) {
            a();
            this.c = false;
        }
    }
}
