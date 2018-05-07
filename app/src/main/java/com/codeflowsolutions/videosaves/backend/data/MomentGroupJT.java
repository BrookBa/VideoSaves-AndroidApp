package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "moment_group_jt",
        foreignKeys = {
                @ForeignKey(entity = GroupEntity.class,
                        parentColumns = "groupId",
                        childColumns = "groupId"),
                @ForeignKey(entity = MomentEntity.class,
                        parentColumns = "momentId",
                        childColumns = "momentId")}
)
class MomentGroupJT {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int groupId;
    private int momentId;


    public MomentGroupJT(int id, int momentId, int groupId) {
        this.id = id;
        this.momentId = momentId;
        this.groupId = groupId;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
