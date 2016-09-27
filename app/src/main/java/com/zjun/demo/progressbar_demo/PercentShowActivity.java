package com.zjun.demo.progressbar_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.zjun.progressbar.CircleDotProgressBar;

/**
 * 百分比显示对比展示
 */
public class PercentShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent_show);

        initView();
    }

    private void initView() {
        GridLayout gl = (GridLayout) findViewById(R.id.gl);
        if (gl != null) {
            int childCount = gl.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = gl.getChildAt(i);
                if (view instanceof CircleDotProgressBar) {
                    ((CircleDotProgressBar) view).setProgress(65);
                }
            }
        }

    }
}
