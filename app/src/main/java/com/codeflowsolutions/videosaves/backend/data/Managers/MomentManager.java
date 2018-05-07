package com.codeflowsolutions.videosaves.backend.data.Managers;

import android.content.Context;
import android.os.Looper;

import com.codeflowsolutions.videosaves.backend.data.MomentEntity;
import com.codeflowsolutions.videosaves.backend.data.VideoDatabase;

import java.util.List;

public class MomentManager {
    private VideoDatabase database;

    public MomentManager(Context context){
        database = VideoDatabase.getInstance(context);
    }
    public List<MomentEntity> getMoments(){
        return getMoments(-1);
    }

    public List<MomentEntity> getMoments(int groupId){
        if(groupId == -1){
            return database.momentDao().allMoments();
        }
        return database.momentGroupJTDao().getMoments(groupId);
    }

    public MomentEntity createMoment(String videoId, int videoTime, String label, String description){
        MomentEntity temp = new MomentEntity(videoId, videoTime, label, description);
        database.momentDao().insertMoments(temp);
        temp = database.momentDao().getMoment(
                database.momentDao().getId(videoId, videoTime, label, description));
        return temp;
    }
    public void saveMoment(MomentEntity moment){
        database.momentDao().updateMoments(moment);
    }

    public MomentEntity getMoment(int id){
        return database.momentDao().getMoment(id);
    }

    public void deleteMoment(MomentEntity moment){
        database.momentDao().deleteMoment(moment);
    }
}
