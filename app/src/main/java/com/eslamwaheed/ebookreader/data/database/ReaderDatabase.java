package com.eslamwaheed.ebookreader.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.eslamwaheed.ebookreader.data.database.readpages.ReadPages;
import com.eslamwaheed.ebookreader.data.database.readpages.ReadPagesDAO;
import com.eslamwaheed.ebookreader.data.database.user.User;
import com.eslamwaheed.ebookreader.data.database.user.UserDAO;

@Database(entities = {User.class, ReadPages.class}, version = 1, exportSchema = false)
abstract class ReaderDatabase extends RoomDatabase {
    abstract UserDAO userDAO();

    abstract ReadPagesDAO readPagesDAO();
}
