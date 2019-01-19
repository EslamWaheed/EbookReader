package com.eslamwaheed.ebookreader.data.database;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.eslamwaheed.ebookreader.data.database.readpages.ReadPages;
import com.eslamwaheed.ebookreader.data.database.user.User;

import java.util.List;

public class ReaderRepository {
    private final static String DB_NAME = "db_reader";
    private ReaderDatabase readerDatabase;

    public ReaderRepository(Context context) {
        readerDatabase = Room.databaseBuilder(context,
                ReaderDatabase.class,
                DB_NAME)
                .build();
    }

    //user
    public void insertUser(final User user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                readerDatabase.userDAO().insertUser(user);
                return null;
            }
        }.execute();
    }

    public void updateUser(final User user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                readerDatabase.userDAO().updateUser(user);
                return null;
            }
        }.execute();
    }

    public void deleteUser(final User user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                readerDatabase.userDAO().deleteUser(user);
                return null;
            }
        }.execute();
    }

    public List<User> selectAllUsers() {
        return readerDatabase.userDAO().selectAllUsers();
    }

    public User selectUser(int id) {
        return readerDatabase.userDAO().selectUser(id);
    }

    //readPages
    public void insertReadPages(final ReadPages readPages) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                readerDatabase.readPagesDAO().insertReadPages(readPages);
                return null;
            }
        }.execute();
    }

    public void updateReadPages(final ReadPages readPages) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                readerDatabase.readPagesDAO().updateReadPages(readPages);
                return null;
            }
        }.execute();
    }

    public void deleteReadPages(final ReadPages readPages) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                readerDatabase.readPagesDAO().deleteReadPages(readPages);
                return null;
            }
        }.execute();
    }

    public List<ReadPages> selectAllReadPages() {
        return readerDatabase.readPagesDAO().selectAllReadPages();
    }

    public ReadPages selectReadPages(int id) {
        return readerDatabase.readPagesDAO().selectReadPages(id);
    }

    public List<ReadPages> selectReadPagesUser(int user_id) {
        return readerDatabase.readPagesDAO().selectReadPagesUser(user_id);
    }
}
