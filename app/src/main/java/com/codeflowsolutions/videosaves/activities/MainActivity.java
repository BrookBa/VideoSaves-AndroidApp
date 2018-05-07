package com.codeflowsolutions.videosaves.activities;

import com.codeflowsolutions.videosaves.R;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import com.codeflowsolutions.videosaves.backend.data.MomentEntity;
import com.codeflowsolutions.videosaves.backend.data.StateEntity;
import com.codeflowsolutions.videosaves.backend.data.VideoDatabase;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.newrelic.agent.android.NewRelic;

import java.util.List;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, View.OnClickListener  {
    private YouTubePlayerView mainVideo;
    private YouTubePlayer player;
    private EditText videoID;
    private EditText momentLabel;
    private EditText momentDescription;
    private Button changeVideo;
    private Button createMoment;
    private Button submitMoment;
    private Button loadMoment;
    private Button deleteMoment;
    private LinearLayout momentCreation;
    private RadioGroup moments;
    private MomentEntity activeMoment;
    private List<MomentEntity> allMoments;
    private VideoDatabase database;
    private StateEntity state;
    private static String DEVELOPER_KEY = "AIzaSyDtKCvyIvaNqYliqu1rafJz2l42_t";


    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize New Relic
        NewRelic.withApplicationToken(
                "<enter app name to generate developer key above>"//AA00442268b856642988ec086d914a78725ef94927
        ).start(this.getApplication());

        //Initialize UI Elements
        this.mainVideo = (YouTubePlayerView) this.findViewById(R.id.main_video);
        this.momentCreation = (LinearLayout) this.findViewById(R.id.moment_creation);
        this.videoID = (EditText) this.findViewById(R.id.video_id);
        this.momentLabel = (EditText) this.findViewById(R.id.edit_moment_label);
        this.momentDescription = (EditText) this.findViewById(R.id.edit_moment_description);
        this.changeVideo = (Button) this.findViewById(R.id.button_change_video);
        this.changeVideo.setOnClickListener(this);
        this.createMoment = (Button) this.findViewById(R.id.button_create_moment);
        this.createMoment.setOnClickListener(this);
        this.submitMoment = (Button) this.findViewById(R.id.button_submit_moment);
        this.submitMoment.setOnClickListener(this);
        this.loadMoment = (Button) this.findViewById(R.id.button_load_moment);
        this.loadMoment.setOnClickListener(this);
        this.moments = (RadioGroup) this.findViewById(R.id.moments_list);
        this.deleteMoment = (Button) this.findViewById(R.id.button_delete_moment);
        this.deleteMoment.setOnClickListener(this);

        this.database = VideoDatabase.getInstance(this);
        //Load State
        new Thread(new Runnable() {
            @Override
            public void run() {
                loadState();
            }
        }).start();
        while(allMoments == null); //Wait until database loads moments--must be async
        loadMoments();

        mainVideo.initialize(DEVELOPER_KEY,this);

    //yrrB_q-V8G0
        
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            this.player = youTubePlayer;
            this.player.cuePlaylist(this.state.getActivePlaylist(),
                    this.state.getActiveVideo(), this.state.getActiveVideoTime());
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        this.player = null;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_change_video:
                if(this.player != null){
                    player.cueVideo(videoID.getText().toString());
                    this.state.setActiveVideoId(videoID.getText().toString());
                }
                break;

            case R.id.button_create_moment:
                this.momentCreation.setVisibility(View.VISIBLE);
                break;

            case R.id.button_submit_moment:
                activeMoment = new MomentEntity(this.state.getActiveVideoId(),
                        this.player.getCurrentTimeMillis(),
                        this.momentLabel.getText().toString(),
                        this.momentDescription.getText().toString());
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(activeMoment.getLabel());
                moments.addView(radioButton);
                this.momentCreation.setVisibility(View.GONE);
                this.momentLabel.setText("");
                this.momentDescription.setText("");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        saveMoment();
                    }
                }).start();
                radioButton.setId(activeMoment.getMomentId());
                break;

            case R.id.button_load_moment:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadMoment();
                    }
                }).start();
                break;
            case R.id.button_delete_moment:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        deleteMoment();
                    }
                }).start();
                break;
        }
    }

    private void loadState(){
        Looper.prepare();
        this.allMoments = this.database.momentDao().allMoments();
        this.state = this.database.stateDao().getState();

        if(this.state == null){
            this.state = new StateEntity("PL7atuZxmT954bCkC062rKwXTvJtcqFB8i", 1, 1, "i-p9lWIhcLQ");
            database.stateDao().insertState(this.state);
        }

    }

    private void saveMoment(){
        this.database.momentDao().insertMoments(activeMoment);
    }

    private void loadMoments(){
        for(MomentEntity moment: allMoments){
            RadioButton curButton = new RadioButton(this);
            curButton.setId(moment.getMomentId());
            curButton.setText(moment.getLabel());
            moments.addView(curButton);
        }
    }

    private void loadMoment(){
        this.activeMoment = this.database.momentDao().getMoment(moments.getCheckedRadioButtonId());
        if(this.player != null && this.activeMoment != null){
            player.cueVideo(activeMoment.getVideoId(), activeMoment.getVideoTime());
            this.state.setActiveVideoId(activeMoment.getVideoId());
            database.stateDao().updateState(this.state);
        }
    }

    private void deleteMoment(){
        Looper.prepare();
        this.activeMoment = this.database.momentDao().getMoment(moments.getCheckedRadioButtonId());
        if(this.activeMoment != null) {
            moments.removeView(findViewById(activeMoment.getMomentId()));
            this.database.momentDao().deleteMoment(activeMoment);
            this.activeMoment = null;
        }
    }
}
