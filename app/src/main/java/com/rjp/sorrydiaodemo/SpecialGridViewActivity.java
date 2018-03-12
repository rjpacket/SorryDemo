package com.rjp.sorrydiaodemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpecialGridViewActivity extends Activity {

    private List<ItemModel> titles = new ArrayList<>();
    private Context mContext;
    private int editedIndex = -1;
    private SpecialGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_grid_view);
        mContext = this;

        gridView = (SpecialGridView) findViewById(R.id.special_grid_view);

        titles.add(new ItemModel("竞足0"));
        titles.add(new ItemModel("竞足1"));
        titles.add(new ItemModel("竞足2"));
        titles.add(new ItemModel("竞足3"));
        titles.add(new ItemModel("竞足4"));
        titles.add(new ItemModel("竞足5"));
        titles.add(new ItemModel("竞足6"));
        titles.add(new ItemModel("竞足7"));
        titles.add(new ItemModel("竞足8"));

        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
                }
                LinearLayout llLabel = (LinearLayout) convertView.findViewById(R.id.ll_label);
                TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                ImageView ivDelete = (ImageView) convertView.findViewById(R.id.iv_add);

                ItemModel itemModel = titles.get(position);
                tvTitle.setText(itemModel.getTitle());
                ivDelete.setVisibility(editedIndex == position?View.VISIBLE:View.GONE);
                llLabel.setTag(position);
                ivDelete.setTag(position);

                llLabel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int tag = (Integer) v.getTag();
                        editedIndex = tag;
                        gridView.setEditedIndex(editedIndex);
                        notifyDataSetChanged();
                    }
                });
                return convertView;
            }
        });
    }

}
