package network.retrofit;

import account.AccountManager;
import instrument.Preconditions;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.DefaultHeaderInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Url;
import timber.log.Timber;

/**
 * Created by 99165 on 2016/3/23.
 */
public class RetrofitBuilder {

    private String baseUrl;
    private Retrofit mRetrofit;

    private OkHttpClient client;

    /**
     * 构造函数私有化
     */
    private RetrofitBuilder() {
    }

    //Make this class a thread safe singleton
    private static class SingletonHolder {
        private static final RetrofitBuilder INSTANCE = new RetrofitBuilder();
    }

    public static synchronized RetrofitBuilder get() {
        return SingletonHolder.INSTANCE;
    }

    protected Retrofit.Builder newRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    public Retrofit retrofit() {
        Preconditions.checkNotNull(baseUrl, "Base URL required.");

        if (mRetrofit == null) {
            Retrofit.Builder builder = newRetrofitBuilder();
            mRetrofit = builder.baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return mRetrofit;
    }

    /**
     * 创建给定的 Api Service
     */
    public <T> T create(Class<T> clazz) {
        return get().retrofit().create(clazz);
    }

    public static class Builder {

        private String baseUrl;
        private String accept;
        private OkHttpClient mClient;

        public RetrofitBuilder build() {
            Preconditions.checkNotNull(baseUrl, "Base URL required.");
            ensureSaneDefaults();

            RetrofitBuilder retrofitBuilder = get();
            retrofitBuilder.baseUrl = baseUrl;
            retrofitBuilder.client = mClient;

            return retrofitBuilder;
        }

        private void ensureSaneDefaults() {
            if (mClient == null) {
                mClient = defaultClient();
            }
        }

        private OkHttpClient defaultClient() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Timber.d(message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
            builder.addInterceptor(new DefaultHeaderInterceptor(AccountManager.getInstance(), accept));
            return builder.build();
        }

        public Builder client(OkHttpClient client) {
            mClient = client;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            Preconditions.checkNotNull(baseUrl, "baseUrl == null");
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder accept(String accept) {
            Preconditions.checkNotNull(accept, "accept == null");
            this.accept = accept;
            return this;
        }
    }


}
