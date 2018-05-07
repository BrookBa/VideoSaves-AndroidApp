package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

@Dao
public interface GroupDao {
    @Insert
    public void insertGroups(GroupEntity...groups);

    @Update
    public void updateGroups(GroupEntity...groups);

}
