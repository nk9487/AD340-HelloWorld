package com.example.helloworld;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SettingsDao {
    @Query("SELECT * FROM setting WHERE id = :settingsId LIMIT 1")
    LiveData<Setting> findBySettingsId(String settingsId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSettings(Setting settings);
}