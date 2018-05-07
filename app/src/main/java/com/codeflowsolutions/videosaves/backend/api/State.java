//MIT License Copyright 2017 PSU ASL Capstone Team

package com.codeflowsolutions.videosaves.backend.api;

/**
 * Public interface for the Stored State of the App.
 */
public interface State{

    /**
     * Get the Current Active Playlist ID
     */
    String getActivePlaylist();

    /**
     * Set the Current Active Playlist
     */
    void setActivePlaylist(String playlistID);

    /**
     * Get the Current Active Video ID
     */
    int getActiveVideo();

    /**
     * Set the Current Active Video
     */
    void setActiveVideo(int videoID);

    /**
     * Get the Current Active Video ID
     */
    int getActiveVideoTime();

    /**
     * Set the Current Active Video
     */
    void setActiveVideoTime(int videoTime);

    String getActiveVideoId();

    void setActiveVideoId(String activeVideoId);
}
