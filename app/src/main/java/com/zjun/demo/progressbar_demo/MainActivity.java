package com.zjun.demo.progressbar_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zjun.progressbar.CircleDotProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CircleDotProgressBar bar_percent;
    private CircleDotProgressBar bar_null;
    private CircleDotProgressBar bar_all;

    private boolean isProgressGoing;
    private int max;
    private int progress;

    private Timer mTimer;
    private TimerTask mTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        max = 100;
        readyProgress();
    }


    private void initView() {
        bar_percent = $(R.id.bar_percent);
        bar_null = $(R.id.bar_null);
        bar_all = $(R.id.bar_all);

        bar_percent.setProgress(87);
        bar_null.setProgress(89);

        bar_all.setProgressMax(max);
        bar_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "进度条被点击", Toast.LENGTH_SHORT).show();
            }
        });
        bar_all.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isProgressGoing) {
                    if (progress == max) {
                        progress = 0;
                        bar_all.setProgress(progress);
                    }
                    startProgress();
                } else {
                    stopProgress();
                }

            }
        });

    }


    private void readyProgress() {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        if (mTimerTask == null) {
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    if (!isProgressGoing) {
                        return;
                    }
                    if (++progress >= max) {
                        progress = max;
                        bar_all.setProgress(progress);
                        stopProgress();
                        return;
                    }
                    bar_all.setProgress(progress);
                }
            };
        }
    }

    private void startProgress() {
        isProgressGoing = true;

        stopTimerTask();
        readyProgress();
        mTimer.schedule(mTimerTask, 1000, 100);
    }

    private void stopTimerTask() {
        if (mTimerTask != null) {
            mTimerTask.cancel();
        }
        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimerTask = null;
        mTimer = null;
    }

    private void stopProgress() {
        isProgressGoing = false;

        stopTimerTask();
    }

    public void onBtnClick(View view) {
        startActivity(new Intent(this, UnitAlignModeActivity.class));
    }

    private <V extends View> V $(int id) {
        return (V) findViewById(id);
    }
}
