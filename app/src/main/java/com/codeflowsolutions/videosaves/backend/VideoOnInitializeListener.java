package com.codeflowsolutions.videosaves.backend;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class VideoOnInitializeListener implements YouTubePlayer.OnInitializedListener {


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b)
            youTubePlayer.cueVideo("Nfcja-6hr24");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
