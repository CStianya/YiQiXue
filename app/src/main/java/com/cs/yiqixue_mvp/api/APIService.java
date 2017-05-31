package com.cs.yiqixue_mvp.api;

import com.cs.yiqixue_mvp.MyApplication;
import com.cs.yiqixue_mvp.api.bean.WeatherBean;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CSLaker on 2017/5/31.
 */

public class APIService {

    private static final String BASE_URL = "https://api.thinkpage.cn";

    private static final int TIME_OUT = 5;

    private static RetrofitService sRetrofitService;

    private APIService() {}

    /**
     * 初始化网络通信服务
     */
    public static void init() {
        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(new File(MyApplication.getContext().getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        sRetrofitService = retrofit.create(RetrofitService.class);
    }

    /**
     * 请求天气数据
     */
    public static Observable<WeatherBean> getWeatherData(String key, String location) {
        return sRetrofitService.getWeatherData(key, location)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
