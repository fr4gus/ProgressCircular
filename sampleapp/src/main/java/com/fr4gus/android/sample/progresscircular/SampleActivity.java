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

    private int mProgressStatus = 0;
    Handler mHandler = new Handler();

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
