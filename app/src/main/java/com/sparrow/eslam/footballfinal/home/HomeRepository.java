package com.sparrow.eslam.footballfinal.home;

import android.arch.lifecycle.MutableLiveData;

import com.sparrow.eslam.footballfinal.database.FootballDao;
import com.sparrow.eslam.footballfinal.network.FootballApi;
import com.sparrow.eslam.footballfinal.pojo.Competition;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

class HomeRepository {

    final MutableLiveData<List<Competition>> competitionList = new MutableLiveData<>();
    private final FootballApi api;
    private final FootballDao dao;

    HomeRepository(FootballApi api, FootballDao dao) {
        this.api = api;
        this.dao = dao;
        dao.getCompitations()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(list -> {
                    if (list.size() == 0) {
                        loadFromApi();
                    } else {
                        competitionList.postValue(list);
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }

    private void loadFromApi() {
        api.getCompetations()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(list -> {
                    for (Competition item :
                            list) {
                        dao.insertCompitation(item);
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }
}
