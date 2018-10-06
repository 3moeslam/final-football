package com.sparrow.eslam.footballfinal.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sparrow.eslam.footballfinal.pojo.Competition;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface FootballDao {

    @Query("Select * from Competition")
    Flowable<List<Competition>> getCompitations();

    @Insert
    void insertCompitation(Competition competition);
}
