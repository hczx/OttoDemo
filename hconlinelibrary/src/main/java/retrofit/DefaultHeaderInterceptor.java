package retrofit;

import android.text.TextUtils;

import java.io.IOException;

import account.AccountProvider;
import baserobot.BaseApplication;
import instrument.AppInfo;
import instrument.Strings;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 99165 on 2016/3/14.
 */
public class DefaultHeaderInterceptor implements HeaderInterceptor{


    AccountProvider mAccountProvider;
    /**
     * example: application/vnd.xxx.v1+json
     */
    String mApiVersionAccept;

    public DefaultHeaderInterceptor(AccountProvider accountProvider, String apiAccept) {
        mAccountProvider = accountProvider;
        mApiVersionAccept = apiAccept;
    }

    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Headers.Builder builder = new Headers.Builder();

        final AppInfo appInfo = BaseApplication.appInfo();

        builder.add("Content-Encoding", "gzip")
                .add("version-code", appInfo.versionCode)
                .add("version-name", appInfo.version)
                .add("device", appInfo.deviceId)
                .add("platform", "android");

        final String channel = appInfo.channel;
        if (! TextUtils.isEmpty(channel)) {
            builder.add("channel", channel);
        }

        if (mAccountProvider != null && !Strings.isBlank(mAccountProvider.provideToken())) {
            builder.add("Authorization", "Bearer " + mAccountProvider.provideToken());
        }

        if (!Strings.isBlank(mApiVersionAccept)) {
            builder.add("Accept", mApiVersionAccept);
        }

        Request compressedRequest = originalRequest
                .newBuilder()
                .headers(builder.build())
                .build();

        return chain.proceed(compressedRequest);
    }
}
