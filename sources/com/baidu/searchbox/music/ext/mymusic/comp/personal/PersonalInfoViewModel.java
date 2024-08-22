package com.baidu.searchbox.music.ext.mymusic.comp.personal;

import androidx.lifecycle.MutableLiveData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.music.ext.tpls.comps.base.TplBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/personal/PersonalInfoViewModel;", "Lcom/baidu/searchbox/music/ext/tpls/comps/base/TplBaseViewModel;", "Lcom/baidu/searchbox/music/ext/mymusic/comp/personal/PersonalInfoModel;", "()V", "avatarUrl", "Landroidx/lifecycle/MutableLiveData;", "", "getAvatarUrl", "()Landroidx/lifecycle/MutableLiveData;", "subTitle", "getSubTitle", "title", "getTitle", "defaultAvatar", "userName", "setModel", "", "model", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoViewModel.kt */
public final class PersonalInfoViewModel extends TplBaseViewModel<PersonalInfoModel> {
    private final MutableLiveData<String> avatarUrl = new MutableLiveData<>();
    private final MutableLiveData<String> subTitle = new MutableLiveData<>();
    private final MutableLiveData<String> title = new MutableLiveData<>();

    public final MutableLiveData<String> getAvatarUrl() {
        return this.avatarUrl;
    }

    public final MutableLiveData<String> getTitle() {
        return this.title;
    }

    public final MutableLiveData<String> getSubTitle() {
        return this.subTitle;
    }

    public void setModel(PersonalInfoModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        this.avatarUrl.setValue(getAvatarUrl(model.getImage()));
        this.title.setValue(getTitle(model.getTitle()));
        this.subTitle.setValue(model.getSubtitle());
    }

    private final String getTitle(String userName) {
        BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        String nickname = null;
        BoxAccount ba = boxAccountManager != null ? boxAccountManager.getBoxAccount() : null;
        if (ba != null) {
            nickname = ba.getNickname();
        }
        CharSequence charSequence = nickname;
        return charSequence == null || charSequence.length() == 0 ? userName : nickname;
    }

    private final String getAvatarUrl(String defaultAvatar) {
        String str;
        BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        String avatar = null;
        BoxAccount ba = boxAccountManager != null ? boxAccountManager.getBoxAccount() : null;
        if (ba != null) {
            BoxAccount it = ba;
            if (Intrinsics.areEqual((Object) "1", (Object) it.getMemberVip())) {
                str = it.getDynamicPortrait();
            } else {
                str = it.getPortrait();
            }
            avatar = str;
        }
        CharSequence charSequence = avatar;
        if (charSequence == null || charSequence.length() == 0) {
            return defaultAvatar;
        }
        return avatar;
    }
}
