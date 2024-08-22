package com.baidu.searchbox.follow.request;

import com.baidu.searchbox.follow.model.FollowContactModel;
import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/follow/request/ContactDataManager$fetchContactData$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/follow/model/FollowContactModel;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "followContacts", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-follow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactDataManager.kt */
public final class ContactDataManager$fetchContactData$responseCallback$1 extends ResponseCallback<FollowContactModel> {
    final /* synthetic */ ContactDataStatusListener $callback;

    ContactDataManager$fetchContactData$responseCallback$1(ContactDataStatusListener $callback2) {
        this.$callback = $callback2;
    }

    public FollowContactModel parseResponse(Response response, int statusCode) throws Exception {
        Intrinsics.checkNotNullParameter(response, "response");
        byte[] bArr = new byte[0];
        ResponseBody it = response.body();
        if (it != null) {
            byte[] bytes = it.bytes();
            Intrinsics.checkNotNullExpressionValue(bytes, "it.bytes()");
            bArr = bytes;
        }
        return ContactDataManager.INSTANCE.parseContactData(new String(bArr, Charsets.UTF_8));
    }

    public void onSuccess(FollowContactModel followContacts, int statusCode) {
        if (followContacts == null) {
            ContactDataStatusListener contactDataStatusListener = this.$callback;
            if (contactDataStatusListener != null) {
                contactDataStatusListener.onContactFail(3);
                return;
            }
            return;
        }
        followContacts.setContactItems(ContactDataManager.INSTANCE.validateNames(ContactDataManager.INSTANCE.mergeContactsAndFollows(ContactDataManager.INSTANCE.createPhoneNameMap(), followContacts)));
        ArrayList[] contactListArray = ContactDataManager.INSTANCE.splitContactList(followContacts);
        if (Intrinsics.areEqual((Object) followContacts.getHasMore(), (Object) "1")) {
            ContactDataManager.followContactStore.addAll(contactListArray[1]);
        } else {
            contactListArray[0].addAll(ContactDataManager.followContactStore);
            contactListArray[0].addAll(contactListArray[1]);
        }
        followContacts.setContactItems(contactListArray[0]);
        if (followContacts.getContactItems().size() > 0) {
            ContactDataStatusListener contactDataStatusListener2 = this.$callback;
            if (contactDataStatusListener2 != null) {
                contactDataStatusListener2.onContactSuccess(followContacts);
            }
        } else if (Intrinsics.areEqual((Object) followContacts.getHasMore(), (Object) "1")) {
            ContactDataManager.INSTANCE.fetchContactData(this.$callback, true);
        } else {
            ContactDataStatusListener contactDataStatusListener3 = this.$callback;
            if (contactDataStatusListener3 != null) {
                contactDataStatusListener3.onContactSuccess(followContacts);
            }
        }
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        ContactDataStatusListener contactDataStatusListener = this.$callback;
        if (contactDataStatusListener != null) {
            contactDataStatusListener.onContactFail(3);
        }
    }
}
