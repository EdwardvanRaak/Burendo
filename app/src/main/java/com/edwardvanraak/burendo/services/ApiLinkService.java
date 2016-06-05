package com.edwardvanraak.burendo.services;

import com.edwardvanraak.burendo.communication.BlendleAPI;
import com.edwardvanraak.burendo.domain.pojo.data.Api;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Service for fetching links from the Blendle HAL API
 * @see com.edwardvanraak.burendo.domain.pojo.data.RootLinks
 */
public class ApiLinkService {

    public static final int LINK_POPULAR_ITEMS = 1;

    /**
     * Fetch any API Url based on the given type
     */
    public Observable<String> fetchAPIUrl(final int type) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                final Observable<Api> call = BlendleAPI.Factory.getInstance().getApi();
                call.observeOn(AndroidSchedulers.mainThread())
                        .debounce(1, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Subscriber<Api>() {
                            @Override
                            public void onCompleted() { }
                            @Override
                            public void onError(Throwable error) {
                                subscriber.onError(error);
                            }
                            @Override
                            public void onNext(Api api) {
                                String link = null;
                                switch (type){
                                    case LINK_POPULAR_ITEMS:
                                        link = api.getLinks().getPopularItems().getHref();
                                        break;
                                }
                                if(link == null){
                                    subscriber.onError(new IllegalArgumentException("Invalid API Url type"));
                                }
                                subscriber.onNext(link);
                                subscriber.onCompleted();
                            }
                        });
            }
        });
    }
}
