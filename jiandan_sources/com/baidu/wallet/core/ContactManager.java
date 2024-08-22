package com.baidu.wallet.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.wallet.api.internal.IContacts;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class ContactManager implements NoProguard {
    public static IContacts sIContactsImpl;

    public static class a implements IContacts, NoProguard {
        public int countOfContacts(@NonNull Context context) {
            return 0;
        }

        public List<ContractInfo> loadAllPhone(@NonNull Context context) {
            return Collections.emptyList();
        }

        public List<String> loadPhoneContactsForChargeFragment(@NonNull Uri uri, @NonNull Context context) {
            return Collections.emptyList();
        }

        public ConcurrentHashMap<String, ContractInfo> loadPhoneContracts(@NonNull Context context) {
            return new ConcurrentHashMap<>();
        }

        public List<String> loadRawPhone(@NonNull Uri uri, @NonNull Context context) {
            return Collections.emptyList();
        }

        public ConcurrentHashMap<String, ContractInfo> loadSimContracts(@NonNull Context context) {
            return new ConcurrentHashMap<>();
        }

        public boolean pickContactsByContactsContentUri(@NonNull Activity activity, int i2) {
            return false;
        }

        public boolean pickContactsByPhoneContentType(@NonNull Activity activity, int i2) {
            return false;
        }
    }

    public static IContacts getIContactsImpl() {
        if (sIContactsImpl == null) {
            boolean z = false;
            try {
                sIContactsImpl = (IContacts) Class.forName("com.baidu.wallet.impl.ContactsImpl").newInstance();
            } catch (Exception unused) {
                z = true;
            }
            if (z) {
                sIContactsImpl = new a();
            }
        }
        return sIContactsImpl;
    }
}
