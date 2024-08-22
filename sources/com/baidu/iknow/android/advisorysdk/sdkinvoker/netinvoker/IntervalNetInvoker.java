package com.baidu.iknow.android.advisorysdk.sdkinvoker.netinvoker;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.iknow.advisory.plugin.invoke.IAdvisorySdkInvoker;
import com.baidu.iknow.android.advisorysdk.base.rxjava.RxTransformerHelper;
import com.baidu.iknow.android.net.exception.RequestError;
import com.baidu.iknow.android.net.request.base.AdRequest;
import com.baidu.iknow.android.net.response.ADBaseResponse;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;

public class IntervalNetInvoker implements LifecycleObserver {
    public static final String TAG = "IntervalNetInvoker";
    /* access modifiers changed from: private */
    public Subscription mSubscription;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Subscription subscription = this.mSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public IntervalNetInvoker(Lifecycle lifecycle) {
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    public <Q extends AdRequest<B>, B extends ADBaseResponse, C extends IAdvisorySdkInvoker.RequestCallBack<B>> IAdvisorySdkInvoker.Interruptible request(final Q request, long interval, final boolean ignoreError, final C callback) {
        final Observable<B> o = Observable.create(new Observable.OnSubscribe<B>() {
            public void call(Subscriber<? super B> emitter) {
                try {
                    emitter.onNext(request.sendSync());
                } catch (RequestError requestError) {
                    requestError.printStackTrace();
                    emitter.onError(requestError);
                }
            }
        });
        this.mSubscription = Observable.interval(0, interval, TimeUnit.MILLISECONDS).flatMap(new Func1<Long, Observable<B>>() {
            public Observable<B> call(Long aLong) {
                return o;
            }
        }).retry((Func2<Integer, Throwable, Boolean>) new Func2<Integer, Throwable, Boolean>() {
            public Boolean call(Integer integer, Throwable throwable) {
                return Boolean.valueOf(ignoreError && integer.intValue() < 10);
            }
        }).compose(RxTransformerHelper.schedulerTransf()).subscribe(new Observer<B>() {
            public void onCompleted() {
            }

            public void onError(Throwable throwable) {
                IAdvisorySdkInvoker.RequestCallBack requestCallBack = callback;
                if (requestCallBack != null) {
                    requestCallBack.onError(throwable);
                }
            }

            public void onNext(B response) {
                IAdvisorySdkInvoker.RequestCallBack requestCallBack = callback;
                if (requestCallBack != null) {
                    requestCallBack.onResult(response);
                }
            }
        });
        return new IAdvisorySdkInvoker.Interruptible() {
            public void interrupt() {
                if (IntervalNetInvoker.this.mSubscription != null) {
                    IntervalNetInvoker.this.mSubscription.unsubscribe();
                }
            }
        };
    }
}
