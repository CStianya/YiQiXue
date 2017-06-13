package com.cs.yiqixue_mvp.api;

import com.cs.yiqixue_mvp.MyApplication;
import com.cs.yiqixue_mvp.api.bean.Question;

import java.io.File;
import java.util.List;
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

    private static final String BASE_URL = "http://10.0.2.2:80";

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
     * 获取所有问题数据
     * @return
     */
    public static Observable<List<Question>> getAllUsers() {
        return sRetrofitService.getAllQuestions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
