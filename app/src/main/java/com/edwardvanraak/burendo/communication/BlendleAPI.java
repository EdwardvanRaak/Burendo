package com.edwardvanraak.burendo.communication;

import com.edwardvanraak.burendo.BuildConfig;
import com.edwardvanraak.burendo.domain.pojo.data.Api;
import com.edwardvanraak.burendo.domain.pojo.data.popular_items.PopularItems;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface BlendleAPI {

    @GET
    Call<PopularItems> getPopularItems(@Url String url);
    @GET("/api.json")
    Call<Api> getApi();

    class Factory {

        private static BlendleAPI service;
        /**
         * Returns the instance of the BlendleAPI Singleton
         */
        public static BlendleAPI getInstance() {
            if (service == null) {
                OkHttpClient.Builder builder = createClientBuilder();
                Retrofit retrofit = createClient(builder);
                service = retrofit.create(BlendleAPI.class);
                return service;
            }else{
                return service;
            }
        }
        private static Retrofit createClient(OkHttpClient.Builder builder) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .baseUrl(ApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }

        private static OkHttpClient.Builder createClientBuilder() {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(ApiConstants.HTTP_READ_TIMEOUT, TimeUnit.SECONDS);
            builder.connectTimeout(ApiConstants.HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS);
            builder.writeTimeout(ApiConstants.HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS);
            createLoggingInterceptor(builder);
            return builder;
        }

        private static void createLoggingInterceptor(OkHttpClient.Builder builder) {
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(interceptor);
            }
        }
    }
}
