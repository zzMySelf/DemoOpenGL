package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.dto.loginhistory.AccountLoginAction;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import fe.fe.ppp.ad.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class LoginHistoryLoginModel {
    public static final long SECONDS_OF_ONE_DAY = 86400;

    public static void delBdussLoginHistoryInfo(String str) {
        List<AccountLoginAction> loadHistoryAccounts;
        if (!TextUtils.isEmpty(str) && (loadHistoryAccounts = loadHistoryAccounts()) != null) {
            Iterator<AccountLoginAction> it = loadHistoryAccounts.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(str, ad.rg(it.next().sapiAccount.bduss.getBytes(), false))) {
                    it.remove();
                }
            }
            SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
        }
    }

    public static List<LoginHistoryItem> getAvailableLoginHistoryItems() {
        boolean z;
        List<AccountLoginAction> loadHistoryAccounts = loadHistoryAccounts();
        if (loadHistoryAccounts == null || loadHistoryAccounts.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = loadHistoryAccounts.size();
        for (int i2 = 0; i2 < size; i2++) {
            AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    z = false;
                    break;
                }
                LoginHistoryItem loginHistoryItem = (LoginHistoryItem) arrayList.get(i3);
                if (TextUtils.equals(loginHistoryItem.bduss, accountLoginAction.sapiAccount.bduss)) {
                    loginHistoryItem.actionTimes.add(String.valueOf(accountLoginAction.loginTimeSecond));
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                LoginHistoryItem loginHistoryItem2 = new LoginHistoryItem();
                loginHistoryItem2.bduss = accountLoginAction.sapiAccount.bduss;
                loginHistoryItem2.actionTimes.add(String.valueOf(accountLoginAction.loginTimeSecond));
                arrayList.add(loginHistoryItem2);
            }
        }
        return arrayList;
    }

    public static List<AccountLoginAction> loadHistoryAccounts() {
        String loginHistoryUserInfoJson = SapiContext.getInstance().getLoginHistoryUserInfoJson();
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(loginHistoryUserInfoJson)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(loginHistoryUserInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AccountLoginAction.convertJson2ActionList(jSONArray);
    }

    public static void updateLoginHistoryInfo() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            updateLoginHistoryInfo(currentAccount);
        }
    }

    public static void updateLoginHistoryInfo(SapiAccount sapiAccount) {
        boolean z;
        SapiAccount sapiAccount2 = sapiAccount;
        List loadHistoryAccounts = loadHistoryAccounts();
        if (loadHistoryAccounts == null) {
            loadHistoryAccounts = new ArrayList();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = currentTimeMillis / 86400;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= loadHistoryAccounts.size()) {
                break;
            }
            AccountLoginAction accountLoginAction = (AccountLoginAction) loadHistoryAccounts.get(i3);
            long j2 = accountLoginAction.loginTimeSecond;
            if (currentTimeMillis - j2 > 5) {
                long j3 = j2 / 86400;
                if (TextUtils.equals(sapiAccount2.bduss, accountLoginAction.sapiAccount.bduss) && j == j3) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                z = true;
                break;
            }
        }
        z = false;
        if (!z) {
            if (i2 >= 0) {
                loadHistoryAccounts.remove(i2);
            }
            loadHistoryAccounts.add(0, new AccountLoginAction(currentTimeMillis, sapiAccount2));
            if (loadHistoryAccounts.size() > 30) {
                loadHistoryAccounts.remove(loadHistoryAccounts.size() - 1);
            }
            SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
        }
    }
}
