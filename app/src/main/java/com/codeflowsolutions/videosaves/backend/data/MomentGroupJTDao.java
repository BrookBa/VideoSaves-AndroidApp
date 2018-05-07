package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface MomentGroupJTDao {
    @Query("SELECT * from moments where momentId in " +
            "(SELECT momentId from moment_group_jt where groupId = :groupID)")
    List<MomentEntity> getMoments(int groupID);

    @Query("SELECT * FROM groups WHERE groupId in " +
            "(SELECT groupId FROM moment_group_jt WHERE momentId = :momentId)")
    List<GroupEntity> getGroups(int momentId);

}
