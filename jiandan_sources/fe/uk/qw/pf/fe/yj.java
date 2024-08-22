package fe.uk.qw.pf.fe;

import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.EncodeStrategy;

public abstract class yj {

    /* renamed from: ad  reason: collision with root package name */
    public static final yj f5890ad = new ad();

    /* renamed from: de  reason: collision with root package name */
    public static final yj f5891de = new de();

    /* renamed from: fe  reason: collision with root package name */
    public static final yj f5892fe = new fe();
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
            return false;
        }

        public boolean fe(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean qw() {
            return false;
        }
    }

    public class fe extends yj {
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
