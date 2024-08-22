package com.baidu.searchbox.elasticthread;

import fe.fe.ddd.p000if.fe;
import org.json.JSONObject;

public class ElasticDataUploader {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile ElasticDataUploader f1022ad;
    public IUploader qw;

    public interface IUploader {
        void ad(JSONObject jSONObject);

        void qw(JSONObject jSONObject);
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1023ad;

        public ad(JSONObject jSONObject) {
            this.f1023ad = jSONObject;
        }

        public void run() {
            if (ElasticDataUploader.this.qw != null) {
                ElasticDataUploader.this.qw.ad(this.f1023ad);
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1025ad;

        public qw(JSONObject jSONObject) {
            this.f1025ad = jSONObject;
        }

        public void run() {
            if (ElasticDataUploader.this.qw != null) {
                ElasticDataUploader.this.qw.qw(this.f1025ad);
            }
        }
    }

    public static ElasticDataUploader ad() {
        if (f1022ad == null) {
            synchronized (ElasticDataUploader.class) {
                if (f1022ad == null) {
                    f1022ad = new ElasticDataUploader();
                }
            }
        }
        return f1022ad;
    }

    public void de(JSONObject jSONObject) {
        fe.de(new qw(jSONObject), "upload_statistic_data", 3);
    }

    public void fe(JSONObject jSONObject) {
        fe.de(new ad(jSONObject), "upload_warning_data", 3);
    }
}
