package com.sparrow.eslam.footballfinal.network;



import com.sparrow.eslam.footballfinal.pojo.Competition;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FootballApi {
    @GET("competitions")
    Single<List<Competition>> getCompetations();


}
