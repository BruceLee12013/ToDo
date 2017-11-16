package com.jayden.todo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;

import com.jayden.todo.BuildConfig;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ResouroceImageGetter implements Html.ImageGetter {
    private Context context;
    private String source;

    public ResouroceImageGetter(Context context, String source) {
        this.context = context;
        this.source = source;
    }

    @Override
    public Drawable getDrawable(String s) {
        int path = context.getResources()
                .getIdentifier(source, "drawable", BuildConfig.APPLICATION_ID);
        Drawable drawable = context.getResources().getDrawable(path);
        drawable.setBounds(0, 0,
                drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

        return drawable;
    }
}
