package rx.observers;

import rx.Observer;
import rx.Subscription;

public interface AssertableSubscriber<T> extends Observer<T>, Subscription {
}
