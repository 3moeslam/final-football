package com.sparrow.eslam.footballfinal;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sparrow.eslam.footballfinal.database.FootballDao;
import com.sparrow.eslam.footballfinal.database.FootballDatabase;
import com.sparrow.eslam.footballfinal.network.FootballApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private FootballApi api;
    private FootballDao dao;

    @Override
    public void onCreate() {
        super.onCreate();

        api = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FootballApi.class);

        dao = Room.databaseBuilder(this, FootballDatabase.class, "database")
                .build()
                .getDao();
    }


    public FootballApi getApi() {
        return api;
    }

    public FootballDao getDao() {
        return dao;
    }

}
