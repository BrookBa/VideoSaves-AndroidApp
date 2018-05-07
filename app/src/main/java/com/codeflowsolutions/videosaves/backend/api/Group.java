//MIT License Copyright 2017 PSU ASL Capstone Team

package com.codeflowsolutions.videosaves.backend.api;

import android.os.Parcelable;

import java.util.List;

/**
 * Public interface for card objects.
 */
public interface Group{

    /**
     * Get the Group's id
     */
    int getGroupId();
    void setGroupId(int id);


    /**
     * Get the Group's Label
     */
    String getLabel();

    /**
     * Change the label associated with a group.
     */
    void setLabel(String a);


    /**
     * Return a list of moments which are in this group.
     */
    List<Moment> getMoments();
}

