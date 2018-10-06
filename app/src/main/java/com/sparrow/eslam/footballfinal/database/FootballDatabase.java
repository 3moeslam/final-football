package com.sparrow.eslam.footballfinal.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sparrow.eslam.footballfinal.pojo.Competition;

@Database(version = 1 , entities = {Competition.class})
public abstract class FootballDatabase extends RoomDatabase {
    public abstract FootballDao getDao();
}
