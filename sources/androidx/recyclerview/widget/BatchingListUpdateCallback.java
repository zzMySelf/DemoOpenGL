package androidx.recyclerview.widget;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;
    int mLastEventPosition = -1;
    int mLastEventType = 0;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(ListUpdateCallback callback) {
        this.mWrapped = callback;
    }

    public void dispatchLastEvent() {
        int i2 = this.mLastEventType;
        if (i2 != 0) {
            switch (i2) {
                case 1:
                    this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
                    break;
                case 2:
                    this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
                    break;
                case 3:
                    this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
                    break;
            }
            this.mLastEventPayload = null;
            this.mLastEventType = 0;
        }
    }

    public void onInserted(int position, int count) {
        int i2;
        if (this.mLastEventType == 1 && position >= (i2 = this.mLastEventPosition)) {
            int i3 = this.mLastEventCount;
            if (position <= i2 + i3) {
                this.mLastEventCount = i3 + count;
                this.mLastEventPosition = Math.min(position, i2);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = position;
        this.mLastEventCount = count;
        this.mLastEventType = 1;
    }

    public void onRemoved(int position, int count) {
        int i2;
        if (this.mLastEventType != 2 || (i2 = this.mLastEventPosition) < position || i2 > position + count) {
            dispatchLastEvent();
            this.mLastEventPosition = position;
            this.mLastEventCount = count;
            this.mLastEventType = 2;
            return;
        }
        this.mLastEventCount += count;
        this.mLastEventPosition = position;
    }

    public void onMoved(int fromPosition, int toPosition) {
        dispatchLastEvent();
        this.mWrapped.onMoved(fromPosition, toPosition);
    }

    public void onChanged(int position, int count, Object payload) {
        if (this.mLastEventType == 3) {
            int i2 = this.mLastEventPosition;
            int i3 = this.mLastEventCount;
            if (position <= i2 + i3 && position + count >= i2 && this.mLastEventPayload == payload) {
                this.mLastEventPosition = Math.min(position, i2);
                this.mLastEventCount = Math.max(i3 + i2, position + count) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = position;
        this.mLastEventCount = count;
        this.mLastEventPayload = payload;
        this.mLastEventType = 3;
    }
}
