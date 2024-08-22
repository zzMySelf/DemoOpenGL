package com.baidu.searchbox.favor.data;

public class QueryVisitFavorParams {
    public static final String SORT_KEY_CREATE_TIME = "createTime";
    public static final String SORT_KEY_VISIT_COUNT = "visitCount";
    public static final String SORT_KEY_VISIT_TIME = "visitTime";
    public static final int SORT_ORDER_ASC = 1;
    public static final int SORT_ORDER_DESC = 2;
    private int days;
    private boolean isContainTplArray;
    private int returnCount;
    private String sortKey;
    private int sortOrder;
    private String[] tplArray;
    private int visitCount;

    private QueryVisitFavorParams(Builder builder) {
        this.days = builder.days;
        this.visitCount = builder.visitCount;
        this.returnCount = builder.returnCount;
        this.sortKey = builder.sortKey;
        this.sortOrder = builder.sortOrder;
        this.tplArray = builder.tplArray;
        this.isContainTplArray = builder.isContainTplArray;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getDays() {
        return this.days;
    }

    public int getVisitCount() {
        return this.visitCount;
    }

    public int getReturnCount() {
        return this.returnCount;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public String[] getTplArray() {
        return this.tplArray;
    }

    public boolean isContainTplArray() {
        return this.isContainTplArray;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int days;
        /* access modifiers changed from: private */
        public boolean isContainTplArray;
        /* access modifiers changed from: private */
        public int returnCount;
        /* access modifiers changed from: private */
        public String sortKey;
        /* access modifiers changed from: private */
        public int sortOrder;
        /* access modifiers changed from: private */
        public String[] tplArray;
        /* access modifiers changed from: private */
        public int visitCount;

        private Builder() {
        }

        public QueryVisitFavorParams build() {
            return new QueryVisitFavorParams(this);
        }

        public Builder days(int days2) {
            this.days = days2;
            return this;
        }

        public Builder visitCount(int visitCount2) {
            this.visitCount = visitCount2;
            return this;
        }

        public Builder returnCount(int returnCount2) {
            this.returnCount = returnCount2;
            return this;
        }

        public Builder sortOrder(String sortKey2, int sortOrder2) {
            this.sortKey = sortKey2;
            this.sortOrder = sortOrder2;
            return this;
        }

        public Builder tplArray(boolean isContainTplArray2, String[] tplArray2) {
            this.isContainTplArray = isContainTplArray2;
            this.tplArray = tplArray2;
            return this;
        }
    }
}
