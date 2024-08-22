package com.baidu.searchbox.barcode.impl;

public class QRCodeConstants {

    public static class Statistic {

        public static final class DREAM {
            public static final int NO = 0;
            public static final int YES = 1;

            private DREAM() {
            }
        }

        public static final class CALLTYPE {
            @Deprecated
            public static final int BDS = 0;
            public static final int JS = 3;
            public static final int MOPLUS = 1;
            public static final int SCAN = 2;

            private CALLTYPE() {
            }
        }

        public static final class QRCodeType {

            public static final class UriType {
                public static final int FILE = 0;

                private UriType() {
                }
            }
        }
    }
}
