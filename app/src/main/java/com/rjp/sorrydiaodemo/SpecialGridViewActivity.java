package com.rjp.sorrydiaodemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class SpecialGridViewActivity extends FragmentActivity {

    private List<ItemModel> titles = new ArrayList<>();
    private Context mContext;
    private int editedIndex = -1;
    private SpecialGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_grid_view);
        mContext = this;

    }

}
