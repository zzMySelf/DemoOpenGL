package com.dxmbumptech.glide.request;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        public final boolean isComplete;

        /* access modifiers changed from: public */
        RequestState(boolean z) {
            this.isComplete = z;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean ad(Request request);

    boolean fe(Request request);

    RequestCoordinator getRoot();

    boolean qw();

    boolean rg(Request request);

    void th(Request request);

    void yj(Request request);
}
