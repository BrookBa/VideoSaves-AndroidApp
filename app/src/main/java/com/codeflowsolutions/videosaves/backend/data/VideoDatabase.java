package com.codeflowsolutions.videosaves.backend.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import com.codeflowsolutions.videosaves.backend.data.GroupEntity;
import com.codeflowsolutions.videosaves.backend.data.MomentEntity;
import com.codeflowsolutions.videosaves.backend.data.GroupDao;


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
