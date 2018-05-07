package com.codeflowsolutions.videosaves.backend.data.Managers;

import android.content.Context;
import android.os.Looper;

import com.codeflowsolutions.videosaves.backend.data.StateEntity;
import com.codeflowsolutions.videosaves.backend.data.VideoDatabase;

public class StateManager {
    private VideoDatabase database;

    public StateManager(Context context){
        database = VideoDatabase.getInstance(context);
    }

    public StateEntity loadState(){
        StateEntity ret = database.stateDao().getState();
        if(ret == null){
            ret = new StateEntity("PL7atuZxmT954bCkC062rKwXTvJtcqFB8i", 1, 1, "i-p9lWIhcLQ");
            database.stateDao().insertState(ret);
            ret = database.stateDao().getState();
        }
        return ret;
    }

    public void updateState(StateEntity state){
        database.stateDao().updateState(state);
    }
}
