//MIT License Copyright 2017 PSU ASL Capstone Team

package com.codeflowsolutions.videosaves.backend.api;

import android.os.Parcelable;

import java.util.List;

/**
 * Public interface for card objects.
 */
public interface Moment {

    /**
     * Get the Moment's id
     */
    int getMomentId();
    void setMomentId(int id);

    /**
     * Get the video ID associated with this Moment
     */
    String getVideoId();
    void setVideoId(String id);

    /**
     * Get the Time to start playing the video at
     */
    int getVideoTime();
    void setVideoTime(int time);

    /**
     * Get the moment's label
     */
    String getLabel();

    /**
     * Change the label associated with a moment.
     */
    void setLabel(String a);

    /**
     * Get the moment's description
     */
    String getDescription();

    /**
     * Change the description associated with a moment.
     */
    void setDescription(String a);

    /**
     * Return a list of groups which currently use this moment.
     */
    List<Group> getUsers();
}

