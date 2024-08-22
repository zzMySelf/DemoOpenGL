package com.tera.scan.record.database;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tera/scan/record/database/ScanRecordSortRule;", "", "(Ljava/lang/String;I)V", "build", "", "OPEN_TIME_ASC", "OPEN_TIME_DESC", "CREATE_TIME_ASC", "CREATE_TIME_DESC", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ScanRecordSortRule {
    ;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/tera/scan/record/database/ScanRecordSortRule$CREATE_TIME_ASC;", "Lcom/tera/scan/record/database/ScanRecordSortRule;", "build", "", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CREATE_TIME_ASC extends ScanRecordSortRule {
        public CREATE_TIME_ASC(String str, int i2) {
            super(str, i2, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String build() {
            return "c_time ASC";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/tera/scan/record/database/ScanRecordSortRule$CREATE_TIME_DESC;", "Lcom/tera/scan/record/database/ScanRecordSortRule;", "build", "", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CREATE_TIME_DESC extends ScanRecordSortRule {
        public CREATE_TIME_DESC(String str, int i2) {
            super(str, i2, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String build() {
            return "c_time DESC";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/tera/scan/record/database/ScanRecordSortRule$OPEN_TIME_ASC;", "Lcom/tera/scan/record/database/ScanRecordSortRule;", "build", "", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OPEN_TIME_ASC extends ScanRecordSortRule {
        public OPEN_TIME_ASC(String str, int i2) {
            super(str, i2, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String build() {
            return "open_time ASC";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/tera/scan/record/database/ScanRecordSortRule$OPEN_TIME_DESC;", "Lcom/tera/scan/record/database/ScanRecordSortRule;", "build", "", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OPEN_TIME_DESC extends ScanRecordSortRule {
        public OPEN_TIME_DESC(String str, int i2) {
            super(str, i2, (DefaultConstructorMarker) null);
        }

        @NotNull
        public String build() {
            return "open_time DESC";
        }
    }

    @NotNull
    public abstract String build();
}
