package com.baidu.talos.business;

public interface IFollowDialogBiz {
    public static final IFollowDialogBiz EMPTY = new IFollowDialogBiz() {
        public void sendMsg() {
        }
    };

    void sendMsg();
}
