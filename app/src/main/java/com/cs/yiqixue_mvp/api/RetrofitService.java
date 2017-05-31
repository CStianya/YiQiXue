package com.cs.yiqixue_mvp.api;

import com.cs.yiqixue_mvp.api.bean.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CSLaker on 2017/5/31.
 */

public interface RetrofitService {

    @GET("/v3/weather/now.json")
    Observable<WeatherBean> getWeatherData(@Query("key")String key, @Query("location")String location);
}
