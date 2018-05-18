package com.rjp.sorrydiaodemo.six_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * author : Gimpo create on 2018/5/16 11:10
 * email  : jimbo922@163.com
 */
public class SixView extends View {
    public static final String DATA = "[\n" +
            "  {\n" +
            "    \"name\": \"击杀\",\n" +
            "    \"value\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"生存\",\n" +
            "    \"value\": 2\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"助攻\",\n" +
            "    \"value\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"物理\",\n" +
            "    \"value\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"魔法\",\n" +
            "    \"value\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"防御\",\n" +
            "    \"value\": 2\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"金钱\",\n" +
            "    \"value\": 1\n" +
            "  }\n" +
            "]";

    private List<SixModel> sixModels;
    private int lineHeight = 75;
    private int LINE_COUNT = 4;
    private int width;
    private int height;
    private Paint mPaint;
    private Paint pathPaint;
    private Path path;

    public SixView(Context context) {
        this(context, null);
    }

    public SixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        sixModels = JSONArray.parseArray(DATA, SixModel.class);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(40);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(Color.parseColor("#333333"));

        path = new Path();
        pathPaint = new Paint();
        pathPaint.setAntiAlias(true);
        pathPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        pathPaint.setColor(Color.parseColor("#333333"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = lineHeight * 7 * 2;
        height = lineHeight * 7 * 2;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(width / 2, height / 2);

        int size = sixModels.size();
        double c = Math.toRadians(360 * 1.0 / size / 2);
        double tan = Math.tan(c);
        int sc = canvas.saveLayer(-width / 2, -height / 2, width / 2, height / 2, null, Canvas.ALL_SAVE_FLAG);
        for (int i = 0; i < size; i++) {
            SixModel sixModel = sixModels.get(i);

            for (int j = LINE_COUNT; j > 0; j--) {
                if (j == LINE_COUNT) {
                    canvas.drawLine((float) (-tan * j * lineHeight + 0.5), -j * lineHeight, 0, 0, mPaint);
                }
                canvas.drawLine((float) (-tan * j * lineHeight + 0.5), -j * lineHeight, (float) (tan * j * lineHeight + 0.5), -j * lineHeight, mPaint);

                path.reset();
                path.moveTo((float) (-tan * j * lineHeight + 0.5), -j * lineHeight);
                path.lineTo((float) (tan * j * lineHeight + 0.5), -j * lineHeight);
                path.lineTo((float) (tan * (j - 1) * lineHeight + 0.5), -(j - 1) * lineHeight);
                path.lineTo((float) (-tan * (j - 1) * lineHeight + 0.5), -(j - 1) * lineHeight);
                path.close();
                pathPaint.setColor(getColor(j));
                canvas.drawPath(path, pathPaint);
            }

            canvas.save();
            canvas.translate((float) (-tan * (LINE_COUNT + 1) * lineHeight + 0.5), -(LINE_COUNT + 1) * lineHeight);
            canvas.rotate(360 / size * i);
            canvas.drawText(sixModel.getName(), 0, 0, mPaint);
            canvas.restore();

            canvas.rotate((float) (-360 * 1.0 / size));
        }
        canvas.restoreToCount(sc);
    }

    private int getColor(int j) {
        switch (j){
            case 4:
                return Color.parseColor("#22999999");
            case 3:
                return Color.parseColor("#44999999");
            case 2:
                return Color.parseColor("#66999999");
            case 1:
                return Color.parseColor("#88999999");

        }
        return 0;
    }
}
