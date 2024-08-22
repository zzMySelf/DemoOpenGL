package com.baidu.searchbox.video.detail.utils.rxview;

import android.view.View;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class ViewClickObservable extends Observable<Object> {
    protected ViewClickObservable(Observable.OnSubscribe<Object> onSubscribe) {
        super(onSubscribe);
    }

    public static ViewClickObservable clicks(final View view2) {
        return new ViewClickObservable(new Observable.OnSubscribe<Object>() {
            public void call(Subscriber<? super Object> t1) {
                Listener listener = new Listener(view2, t1);
                t1.add(listener);
                view2.setOnClickListener(listener);
            }
        });
    }

    static final class Listener extends MainThreadSubscription implements View.OnClickListener {
        private final Observer<? super Object> observer;

        /* renamed from: view  reason: collision with root package name */
        private final View f2919view;

        Listener(View view2, Observer<? super Object> observer2) {
            this.f2919view = view2;
            this.observer = observer2;
        }

        public void onClick(View v) {
            if (!isUnsubscribed()) {
                this.observer.onNext(v);
            }
        }

        /* access modifiers changed from: protected */
        public void onUnsubscribe() {
            this.f2919view.setOnClickListener((View.OnClickListener) null);
        }
    }
}
