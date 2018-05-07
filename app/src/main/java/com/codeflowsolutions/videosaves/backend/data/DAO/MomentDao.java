package com.codeflowsolutions.videosaves.backend.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.codeflowsolutions.videosaves.backend.api.Moment;
import com.codeflowsolutions.videosaves.backend.data.MomentEntity;

import java.util.List;

@Dao
public interface MomentDao {
    @Insert
    public void insertMoments(MomentEntity...moments);

    @Update
    public void updateMoments(MomentEntity...moments);

    @Delete
    public void deleteMoment(MomentEntity moment);

    @Query("SELECT momentId FROM moments WHERE videoId = :videoId and videoTime = :videoTime " +
            "and label = :label and description=:description")
    public int getId(String videoId, int videoTime, String label, String description);

    @Query("SELECT * FROM moments")
    public List<MomentEntity> allMoments();

    @Query("SELECT * FROM moments WHERE momentId = :momentId")
    public MomentEntity getMoment(int momentId);

}
