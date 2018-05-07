package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.codeflowsolutions.videosaves.backend.data.DAO.GroupDao;
import com.codeflowsolutions.videosaves.backend.data.DAO.MomentDao;
import com.codeflowsolutions.videosaves.backend.data.DAO.MomentGroupJTDao;
import com.codeflowsolutions.videosaves.backend.data.DAO.StateDao;


@Database(entities = {GroupEntity.class, MomentEntity.class, MomentGroupJT.class, StateEntity.class}, version = 1, exportSchema = false)
public abstract class VideoDatabase extends RoomDatabase {
    private static VideoDatabase sInstance;
    public static final String DATABASE_NAME = "video_database";

    public abstract GroupDao groupDao();
    public abstract MomentDao momentDao();
    public abstract MomentGroupJTDao momentGroupJTDao();
    public abstract StateDao stateDao();


    public static VideoDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (VideoDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, VideoDatabase.class, DATABASE_NAME)
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }
        return sInstance;
    }


}
