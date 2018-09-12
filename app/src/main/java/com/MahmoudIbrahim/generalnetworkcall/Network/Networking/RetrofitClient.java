package com.MahmoudIbrahim.generalnetworkcall.Network.Networking;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahmoud on 2/14/18.
 */

public class RetrofitClient {

    public final static String ENDPOINT = "http://bouqaih.com/api/";

    private static retrofit2.Retrofit retrofit = null;

    private static OkHttpClient okHttpClient;

    public static retrofit2.Retrofit getClient() {
        if (okHttpClient == null) {
            initOkHttp();
        }
        if (retrofit == null) {
            retrofit = new Builder()
                    .client(okHttpClient)
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static void initOkHttp() {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept-Language", "en");
                // Adding Authorization token (API Key)
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        okHttpClient = httpClient.build();
    }

}



