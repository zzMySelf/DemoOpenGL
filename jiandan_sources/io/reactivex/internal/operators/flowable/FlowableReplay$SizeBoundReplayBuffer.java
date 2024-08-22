package io.reactivex.internal.operators.flowable;

public final class FlowableReplay$SizeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    public static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public FlowableReplay$SizeBoundReplayBuffer(int i2) {
        this.limit = i2;
    }

    public void truncate() {
        if (this.size > this.limit) {
            removeFirst();
        }
    }
}
