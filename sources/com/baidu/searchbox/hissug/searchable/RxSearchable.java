package com.baidu.searchbox.hissug.searchable;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.hissug.searchable.bean.Suggestion;
import java.util.List;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

public abstract class RxSearchable {
    private final SerializedSubject<RxQuery, RxQuery> mQueryStream = new SerializedSubject<>(PublishSubject.create());

    /* access modifiers changed from: protected */
    public abstract Observable<List<Suggestion>> createSuggestionStream(Observable<RxQuery> observable);

    public final void startQuery(String query) {
        startQuery(new RxQuery(query));
    }

    public final void startQuery(RxQuery query) {
        if (AppConfig.isDebug()) {
            Log.d(getClass().getSimpleName(), "startQuery: query=" + query + " threadName=" + Thread.currentThread().getName());
        }
        this.mQueryStream.onNext(query);
    }

    public final Observable<List<Suggestion>> getSuggestionsDataStream() {
        return createSuggestionStream(this.mQueryStream);
    }
}
