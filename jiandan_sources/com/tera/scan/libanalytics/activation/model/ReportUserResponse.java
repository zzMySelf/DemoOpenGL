package com.tera.scan.libanalytics.activation.model;

import android.annotation.SuppressLint;
import com.google.gson.annotations.SerializedName;
import com.tera.scan.utils.NoProguard;
import fe.mmm.qw.nn.de.pf.de;

@SuppressLint({"ParcelCreator"})
public class ReportUserResponse extends de implements NoProguard {
    @SerializedName("isnew")
    public int isnew = -1;
    @SerializedName("mediainfo")
    public NewUserMediaInfo mediainfo;
    @SerializedName("uinfo")
    public String uinfo;

    public class NewUserMediaInfo implements NoProguard {
        @SerializedName("picurl")
        public String picurl;
        @SerializedName("videoname")
        public String videoname;
        @SerializedName("videourl")
        public String videourl;

        public NewUserMediaInfo() {
        }
    }
}
