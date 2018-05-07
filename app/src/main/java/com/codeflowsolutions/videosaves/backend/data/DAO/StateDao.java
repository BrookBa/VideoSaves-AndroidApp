package com.codeflowsolutions.videosaves.backend.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.codeflowsolutions.videosaves.backend.api.State;
import com.codeflowsolutions.videosaves.backend.data.StateEntity;

@Dao
public interface StateDao {
    @Insert
    void insertState(StateEntity s);

    @Update
    void updateState(StateEntity s);

    @Query("SELECT * FROM state")
    StateEntity getState();
}
