package fe.rg.qw.o.rg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaderFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class fe implements Headers {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, List<LazyHeaderFactory>> f4924ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile Map<String, String> f4925de;

    public static final class ad implements LazyHeaderFactory {
        public final String qw;

        public ad(String str) {
            this.qw = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ad) {
                return this.qw.equals(((ad) obj).qw);
            }
            return false;
        }

        public int hashCode() {
            return this.qw.hashCode();
        }

        public String qw() {
            return this.qw;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.qw + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final String f4926ad = ad();

        /* renamed from: de  reason: collision with root package name */
        public static final Map<String, List<LazyHeaderFactory>> f4927de;
        public Map<String, List<LazyHeaderFactory>> qw = f4927de;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f4926ad)) {
                hashMap.put("User-Agent", Collections.singletonList(new ad(f4926ad)));
            }
            f4927de = Collections.unmodifiableMap(hashMap);
        }

        @VisibleForTesting
        public static String ad() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public fe qw() {
            return new fe(this.qw);
        }
    }

    public fe(Map<String, List<LazyHeaderFactory>> map) {
        this.f4924ad = Collections.unmodifiableMap(map);
    }

    @NonNull
    public final String ad(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String qw2 = list.get(i2).qw();
            if (!TextUtils.isEmpty(qw2)) {
                sb.append(qw2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final Map<String, String> de() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f4924ad.entrySet()) {
            String ad2 = ad((List) next.getValue());
            if (!TextUtils.isEmpty(ad2)) {
                hashMap.put(next.getKey(), ad2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof fe) {
            return this.f4924ad.equals(((fe) obj).f4924ad);
        }
        return false;
    }

    public int hashCode() {
        return this.f4924ad.hashCode();
    }

    public Map<String, String> qw() {
        if (this.f4925de == null) {
            synchronized (this) {
                if (this.f4925de == null) {
                    this.f4925de = Collections.unmodifiableMap(de());
                }
            }
        }
        return this.f4925de;
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f4924ad + ExtendedMessageFormat.END_FE;
    }
}
