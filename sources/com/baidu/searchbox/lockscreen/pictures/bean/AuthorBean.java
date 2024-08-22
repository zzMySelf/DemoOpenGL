package com.baidu.searchbox.lockscreen.pictures.bean;

public class AuthorBean {
    private String mCmd;
    private String mIcon;
    private String mName;
    private String mSource;

    public String getIcon() {
        return this.mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setSource(String source) {
        this.mSource = source;
    }

    public String getCmd() {
        return this.mCmd;
    }

    public void setCmd(String cmd) {
        this.mCmd = cmd;
    }
}
