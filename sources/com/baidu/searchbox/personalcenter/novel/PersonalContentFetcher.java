package com.baidu.searchbox.personalcenter.novel;

import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import java.util.List;

public class PersonalContentFetcher {
    public static final boolean DEBUG = AppConfig.isDebug();
    ListHolder<IPersonalContentProvider> mPersonalDataList;

    public void initmPersonalDataList() {
        DefaultListHolder create = DefaultListHolder.create();
        this.mPersonalDataList = create;
        create.setList(new IPersonalContentProvider_PersonalContentFetcher_ListProvider());
    }

    /* synthetic */ PersonalContentFetcher(AnonymousClass1 x0) {
        this();
        initmPersonalDataList();
    }

    private PersonalContentFetcher() {
    }

    private static class Inner {
        /* access modifiers changed from: private */
        public static final PersonalContentFetcher sInstance = new PersonalContentFetcher((AnonymousClass1) null);

        private Inner() {
        }
    }

    public static PersonalContentFetcher getInstance() {
        return Inner.sInstance;
    }

    public List<PersonalCenterTabItemModel> getOriginalData(PersonalDataType type, int count) {
        List<IPersonalContentProvider> personalDataList;
        ListHolder<IPersonalContentProvider> listHolder = this.mPersonalDataList;
        if (listHolder == null || type == null || (personalDataList = listHolder.getList()) == null || personalDataList.size() == 0) {
            return null;
        }
        for (IPersonalContentProvider item : personalDataList) {
            if (item != null && type.equals(item.getType())) {
                return item.getPersonalData(count);
            }
        }
        return null;
    }

    public void getOriginalDataUsrCallback(PersonalDataType type, int count, IPersonalContentCallback callback) {
        ListHolder<IPersonalContentProvider> listHolder = this.mPersonalDataList;
        if (!(listHolder == null || type == null)) {
            List<IPersonalContentProvider> personalDataList = listHolder.getList();
            if (personalDataList == null || personalDataList.size() == 0) {
                callback.onGetPersonalData((List<PersonalCenterTabItemModel>) null);
                return;
            }
            for (IPersonalContentProvider item : personalDataList) {
                if (item != null && type.equals(item.getType())) {
                    item.getPersonalDataUseCallback(count, callback);
                    return;
                }
            }
        }
        callback.onGetPersonalData((List<PersonalCenterTabItemModel>) null);
    }
}
