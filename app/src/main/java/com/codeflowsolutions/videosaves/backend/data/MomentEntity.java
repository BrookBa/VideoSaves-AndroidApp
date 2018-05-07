package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.codeflowsolutions.videosaves.backend.api.Group;
import com.codeflowsolutions.videosaves.backend.api.Moment;
import com.codeflowsolutions.videosaves.backend.api.ObjectInUseException;

import java.util.List;

@Entity (tableName = "moments")
public class MomentEntity implements Moment {
    @PrimaryKey(autoGenerate = true)
    private int momentId;

    private String videoId;
    private int videoTime;
    private String label;
    private String description;

    public MomentEntity(String videoId, int videoTime, String label, String description){
        this.videoId = videoId;
        this.videoTime = videoTime;
        this.label = label;
        this.description = description;
    }

    public MomentEntity(){}

    @Override
    public int getMomentId() {
        return this.momentId;
    }

    @Override
    public void setMomentId(int id) {
        this.momentId = id;
    }

    @Override
    public String getVideoId() {
        return this.videoId;
    }

    @Override
    public void setVideoId(String id) {
        this.videoId = id;
    }

    @Override
    public int getVideoTime() {
        return this.videoTime;
    }

    @Override
    public void setVideoTime(int time) {
        this.videoTime = time;
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
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String a) {
        this.description = a;
    }

    @Override
    public List<Group> getUsers() {
        return null;
    }
}
