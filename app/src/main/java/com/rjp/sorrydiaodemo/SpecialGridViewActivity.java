package com.rjp.sorrydiaodemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;

import com.rjp.sorrydiaodemo.qq_special_view.BeautView;

public class SpecialGridViewActivity extends FragmentActivity {

    private Context mContext;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_grid_view);
        mContext = this;

        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);
        final BeautView beautView = (BeautView) findViewById(R.id.beaut_view);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int mode = beautView.getMode();
                if (mode == BeautView.MODE_UP) {
                    int bottom = beautView.getBottom() - scrollY;
                    beautView.setBitmapBottom(bottom);
                    if(bottom < 0){
                        beautView.setMode(BeautView.MODE_DOWN);
                    }
                }
                if (mode == BeautView.MODE_DOWN) {
                    int top = beautView.getTop() - scrollY;
                    beautView.setBitmapTop(top);
                    if(top > getHeight(mContext)){
                        beautView.setMode(BeautView.MODE_UP);
                    }
                }
            }
        });
    }

    public int getHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

}
