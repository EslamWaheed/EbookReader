package com.eslamwaheed.ebookreader.data.database.readpages;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ReadPagesDAO {
    @Insert
    void insertReadPages(ReadPages readPages);

    @Query("SELECT * FROM ReadPages")
    List<ReadPages> selectAllReadPages();

    @Query("SELECT * FROM ReadPages WHERE id =:id")
    ReadPages selectReadPages(int id);

    @Query("SELECT * FROM ReadPages WHERE user_id =:user_id")
    List<ReadPages> selectReadPagesUser(int user_id);

    @Update
    void updateReadPages(ReadPages readPages);

    @Delete
    void deleteReadPages(ReadPages readPages);
}
