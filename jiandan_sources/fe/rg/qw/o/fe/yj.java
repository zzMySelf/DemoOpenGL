package fe.rg.qw.o.fe;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class yj {

    /* renamed from: ad  reason: collision with root package name */
    public static final yj f4914ad = new ad();

    /* renamed from: de  reason: collision with root package name */
    public static final yj f4915de = new de();
    public static final yj qw = new qw();

    public class ad extends yj {
        public boolean ad() {
            return false;
        }

        public boolean de(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean fe(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        public boolean qw() {
            return true;
        }
    }

    public class de extends yj {
        public boolean ad() {
            return true;
        }

        public boolean de(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean fe(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }

        public boolean qw() {
            return true;
        }
    }

    public class qw extends yj {
        public boolean ad() {
            return false;
        }

        public boolean de(DataSource dataSource) {
            return false;
        }

        public boolean fe(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        public boolean qw() {
            return false;
        }
    }

    public abstract boolean ad();

    public abstract boolean de(DataSource dataSource);

    public abstract boolean fe(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean qw();
}
