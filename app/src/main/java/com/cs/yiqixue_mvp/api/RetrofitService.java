package com.cs.yiqixue_mvp.api;

import com.cs.yiqixue_mvp.api.bean.Question;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CSLaker on 2017/5/31.
 */

public interface RetrofitService {

    @GET("/getQuestions")
    Observable<List<Question>> getAllQuestions();
}
