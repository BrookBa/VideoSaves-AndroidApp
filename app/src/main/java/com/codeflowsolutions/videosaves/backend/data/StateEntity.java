package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.codeflowsolutions.videosaves.backend.api.State;

@Entity(tableName = "state")
public class StateEntity implements State {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String activePlaylist;
    private int activeVideo;
    private int activeVideoTime;
    private String activeVideoId;

    public StateEntity(String activePlaylist, int activeVideo, int activeVideoTime, String activeVideoId){
        this.activePlaylist = activePlaylist;
        this.activeVideo = activeVideo;
        this.activeVideoTime = activeVideoTime;
        this.activeVideoId = activeVideoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getActivePlaylist() {
        return this.activePlaylist;
    }

    @Override
    public void setActivePlaylist(String playlistID) {
        this.activePlaylist= playlistID;
    }

    @Override
    public int getActiveVideo() {
        return this.activeVideo;
    }

    @Override
    public void setActiveVideo(int videoID) {
        this.activeVideo = videoID;
    }

    @Override
    public int getActiveVideoTime() {
        return this.activeVideoTime;
    }

    @Override
    public void setActiveVideoTime(int videoTime) {
        this.activeVideoTime = videoTime;
    }

    public String getActiveVideoId() {
        return activeVideoId;
    }

    public void setActiveVideoId(String activeVideoId) {
        this.activeVideoId = activeVideoId;
    }
}
