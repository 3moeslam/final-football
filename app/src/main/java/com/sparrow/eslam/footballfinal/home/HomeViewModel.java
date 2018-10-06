package com.sparrow.eslam.footballfinal.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.sparrow.eslam.footballfinal.App;
import com.sparrow.eslam.footballfinal.database.FootballDao;
import com.sparrow.eslam.footballfinal.network.FootballApi;
import com.sparrow.eslam.footballfinal.pojo.Competition;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    final LiveData<List<Competition>> competations;

    public HomeViewModel(@NonNull Application application) {
        super(application);

        FootballDao dao = ((App) application).getDao();
        FootballApi api = ((App) application).getApi();

        HomeRepository repository = new HomeRepository(api,dao);
        competations = repository.competitionList;
    }



}
