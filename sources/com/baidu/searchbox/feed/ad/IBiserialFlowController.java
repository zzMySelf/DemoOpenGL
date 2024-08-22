package com.baidu.searchbox.feed.ad;

public interface IBiserialFlowController {
    public static final IBiserialFlowController EMPTY = new Impl();

    void onScrollIdle(Object obj, Object obj2);

    void onViewScroll(Object obj, Object obj2);

    public static class Impl implements IBiserialFlowController {
        private static IBiserialFlowController sController = AdRuntimeHolder.getBiserialFlowController();

        public static IBiserialFlowController get() {
            return sController;
        }

        public void onViewScroll(Object asScrolledAction, Object asRecyclerRefreshablePage) {
        }

        public void onScrollIdle(Object asScrollIdleAction, Object asRecyclerRefreshablePage) {
        }
    }
}
