package com.fr4gus.android.sample.progresscircular;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

import com.fr4gus.android.widget.ProgressCircular;


public class SampleActivity extends Activity {
    ProgressCircular mProgressCircular1;
    ProgressCircular mProgressCircular2;
    ProgressCircular mProgressCircular3;
    SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mProgressCircular1 = (ProgressCircular) findViewById(R.id.progress_1);
        mProgressCircular2 = (ProgressCircular) findViewById(R.id.progress_2);
        mProgressCircular3 = (ProgressCircular) findViewById(R.id.progress_3);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mProgressCircular1.setProgress(progress);
                mProgressCircular2.setCurrent(progress);
                mProgressCircular3.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
