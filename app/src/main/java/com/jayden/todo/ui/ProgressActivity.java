package com.jayden.todo.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jayden.todo.R;
import com.zhouyou.view.seekbar.SignSeekBar;

import java.util.Locale;

public class ProgressActivity extends AppCompatActivity {

    private SignSeekBar signSeekBar;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        signSeekBar=(SignSeekBar)findViewById(R.id.seek_bar);
        progressText=(TextView)findViewById(R.id.progress_text);
        signSeekBar.getConfigBuilder()
                .min(0)
                .max(4)
                .progress(2)
                .sectionCount(4)
                .trackColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGray))
                .secondTrackColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen))
                .thumbColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBlue))
                .sectionTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                .sectionTextSize(16)
                .thumbTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed))
                .thumbTextSize(18)
                .signColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen))
                .signTextSize(18)
                .autoAdjustSectionMark()
                .sectionTextPosition(SignSeekBar.TextPosition.BELOW_SECTION_MARK)
                .build();


        signSeekBar.setOnProgressChangedListener(new SignSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(SignSeekBar signSeekBar, int progress, float progressFloat,boolean fromUser) {
                //fromUser 表示是否是用户触发 是否是用户touch事件产生
                String s = String.format(Locale.CHINA, "onChanged int:%d, float:%.1f", progress, progressFloat);
                progressText.setText(s);
            }

            @Override
            public void getProgressOnActionUp(SignSeekBar signSeekBar, int progress, float progressFloat) {
                String s = String.format(Locale.CHINA, "onActionUp int:%d, float:%.1f", progress, progressFloat);
                progressText.setText(s);
            }

            @Override
            public void getProgressOnFinally(SignSeekBar signSeekBar, int progress, float progressFloat,boolean fromUser) {
                String s = String.format(Locale.CHINA, "onFinally int:%d, float:%.1f", progress, progressFloat);
                progressText.setText(s + getApplicationContext().getResources().getStringArray(R.array.labels)[progress]);
            }
        });
    }
}
