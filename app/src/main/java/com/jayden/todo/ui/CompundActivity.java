package com.jayden.todo.ui;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.jayden.todo.R;
import com.jayden.todo.view.ResouroceImageGetter;
import com.jayden.todo.view.TextRoundSpan;

public class CompundActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compund);
        textView = (TextView) findViewById(R.id.textView);
        String html=getString(R.string.different_color_text);
        textView.setText(Html.fromHtml(html,new ResouroceImageGetter(this,html),null));
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation(textView);
            }
        });

    }

    private void startAnimation(TextView textView) {
        Drawable[] drawables = textView.getCompoundDrawables();
        for (Drawable drawable : drawables) {
            if (drawable != null && drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
    }
}
