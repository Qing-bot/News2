package com.example.news2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataHelper {

    String APIkey = "af237501305d4723bbca0d063b484046";
    @GET("country=id&apiKey=af237501305d4723bbca0d063b484046")
    Call<ArrayList<NewsModel>> getdatalist();

}
