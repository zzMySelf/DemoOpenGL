package com.baidu.searchbox.feedback.log.upload;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LogTypeRegister {
    ListHolder<IFeedbackRetrieveLogRegister> mLogTypeRegistrarList;
    private final Set<String> spacesAlwaysUpload = new HashSet();
    private HashMap<String, ArrayList<String>> typeSpaceMapper = null;

    public void initmLogTypeRegistrarList() {
        DefaultListHolder create = DefaultListHolder.create();
        this.mLogTypeRegistrarList = create;
        create.setList(new IFeedbackRetrieveLogRegister_LogTypeRegister_ListProvider());
    }

    public LogTypeRegister() {
        initmLogTypeRegistrarList();
    }

    public static LogTypeRegister getInstance() {
        return Inner.INNER_INSTANCE;
    }

    public List<String> getSpacesByType(String type) {
        LinkedHashSet<String> spacesSet;
        if (TextUtils.isEmpty(type)) {
            return null;
        }
        if (this.typeSpaceMapper == null) {
            initTypeSpaceMapper();
        }
        if (this.spacesAlwaysUpload.isEmpty()) {
            return this.typeSpaceMapper.get(type);
        }
        ArrayList<String> spaces = this.typeSpaceMapper.get(type);
        if (spaces == null) {
            spacesSet = new LinkedHashSet<>();
        } else {
            spacesSet = new LinkedHashSet<>(spaces);
        }
        spacesSet.addAll(this.spacesAlwaysUpload);
        return new ArrayList(spacesSet);
    }

    private void initTypeSpaceMapper() {
        List<IFeedbackRetrieveLogRegister> logTypeRegisterList;
        try {
            this.typeSpaceMapper = new HashMap<>();
            ListHolder<IFeedbackRetrieveLogRegister> listHolder = this.mLogTypeRegistrarList;
            if (listHolder != null && (logTypeRegisterList = listHolder.getList()) != null) {
                if (!logTypeRegisterList.isEmpty()) {
                    for (IFeedbackRetrieveLogRegister logTypeRegister : logTypeRegisterList) {
                        for (FeedbackRetrieveLogEntity logTypeEntity : logTypeRegister.getLogTypeEntityList()) {
                            String space = logTypeEntity.getLogSpace();
                            if (logTypeEntity.isRegisterAllFeedType()) {
                                this.spacesAlwaysUpload.add(space);
                            } else {
                                Set<String> feedbackTypeSet = logTypeEntity.getFeedbackTypeSet();
                                if (!TextUtils.isEmpty(space) && feedbackTypeSet != null && !feedbackTypeSet.isEmpty()) {
                                    for (String feedbackType : feedbackTypeSet) {
                                        if (!this.typeSpaceMapper.containsKey(feedbackType)) {
                                            this.typeSpaceMapper.put(feedbackType, new ArrayList());
                                        }
                                        ArrayList<String> spaces = this.typeSpaceMapper.get(feedbackType);
                                        if (spaces != null) {
                                            spaces.add(space);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
        }
    }

    private static class Inner {
        /* access modifiers changed from: private */
        public static final LogTypeRegister INNER_INSTANCE = new LogTypeRegister();

        private Inner() {
        }
    }
}
