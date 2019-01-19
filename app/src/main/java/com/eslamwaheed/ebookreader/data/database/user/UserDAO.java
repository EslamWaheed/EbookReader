package com.eslamwaheed.ebookreader.data.database.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM User")
    List<User> selectAllUsers();

    @Query("SELECT * FROM User WHERE id =:id")
    User selectUser(int id);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
