package com.codeflowsolutions.videosaves.backend.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.codeflowsolutions.videosaves.backend.data.GroupEntity;

@Dao
public interface GroupDao {
    @Insert
    public void insertGroups(GroupEntity...groups);

    @Update
    public void updateGroups(GroupEntity...groups);

}
