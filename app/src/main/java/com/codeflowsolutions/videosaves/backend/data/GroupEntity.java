package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;

import com.codeflowsolutions.videosaves.backend.api.Group;
import com.codeflowsolutions.videosaves.backend.api.Moment;

import java.util.List;

@Entity(tableName = "groups")
public class GroupEntity implements Group {
    @PrimaryKey(autoGenerate = true)
    private int groupId;

    private String label;


    public GroupEntity(int groupId, String label){
        this.groupId = groupId;
        this.label = label;
    }

    @Override
    public int getGroupId() {
        return this.groupId;
    }

    @Override
    public void setGroupId(int id) {
        this.groupId = id;
    }


    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(String a) {
        this.label = a;
    }

    @Override
    public List<Moment> getMoments() {
        return null;
    }

}
