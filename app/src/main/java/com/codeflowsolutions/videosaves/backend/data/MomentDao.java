package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.codeflowsolutions.videosaves.backend.api.Moment;

import java.util.List;

@Dao
public interface MomentDao {
    @Insert
    public void insertMoments(MomentEntity...moments);

    @Update
    public void updateMoments(MomentEntity...moments);

    @Delete
    public void deleteMoment(MomentEntity moment);

    @Query("SELECT * FROM moments")
    public List<MomentEntity> allMoments();

    @Query("SELECT * FROM moments WHERE momentId = :momentId")
    public MomentEntity getMoment(int momentId);

}
