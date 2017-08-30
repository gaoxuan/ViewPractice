package com.gx.viewpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gx.viewpractice.utils.ScreenUtils;

import java.math.BigDecimal;

/**
 * Created by gaoxuan on 2017/8/14.
 */

public class Session1 extends View {
    private Context mContext;

    public Session1(Context context) {
        this(context, null);
    }

    public Session1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Session1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        initAttributes();
    }

    private void initAttributes() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int screenWidth = ScreenUtils.getScreenWidth(mContext);
        int screenHeight = ScreenUtils.getScreenHeight(mContext);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.GRAY);

        int itemW = screenWidth / 4;
        RectF originalRectF = new RectF(itemW, itemW, itemW * 3, itemW * 3);
        double offsetCenter = 20; // 新扇形偏离圆心距离
        Log.i("calcRectF", "original-left:" + originalRectF.left + ", right:" + originalRectF.right +
                ", top:" + originalRectF.top + ", bottom:" + originalRectF.bottom);


//        RectF rectF = calcRectF(originalRectF, 120, offsetCenter);
        RectF rectF = new RectF(originalRectF);
        rectF.offset(-10, -17);
        Log.i("calcRectF", "rectF-left:" + rectF.left + ", right:" + rectF.right +
                ", top:" + rectF.top + ", bottom:" + rectF.bottom);
        canvas.drawArc(rectF, -180, 120, true, paint);

        paint.setColor(Color.YELLOW);
//        RectF rectF1 = calcRectF(originalRectF, 55, offsetCenter);
        RectF rectF1 = new RectF(originalRectF);
        rectF1.offset(17, -9);
        Log.i("calcRectF", "rectF1-left:" + rectF1.left + ", right:" + rectF1.right +
                ", top:" + rectF1.top + ", bottom:" + rectF1.bottom);
        canvas.drawArc(rectF1, -60, 55, true, paint);

        paint.setColor(Color.GREEN);
//        RectF rectF2 = calcRectF(originalRectF, 15, offsetCenter);
        RectF rectF2 = new RectF(originalRectF);
        rectF2.offset(19, 2);
        Log.i("calcRectF", "rectF2-left:" + rectF2.left + ", right:" + rectF2.right +
                ", top:" + rectF2.top + ", bottom:" + rectF2.bottom);
        canvas.drawArc(rectF2, -5, 15, true, paint);

        paint.setColor(Color.CYAN);
//        RectF rectF3 = calcRectF(originalRectF, 10, offsetCenter);
        RectF rectF3 = new RectF(originalRectF);
        rectF3.offset(19, 1);
        Log.i("calcRectF", "rectF3-left:" + rectF3.left + ", right:" + rectF3.right +
                ", top:" + rectF3.top + ", bottom:" + rectF3.bottom);
        canvas.drawArc(rectF3, 10, 10, true, paint);

        paint.setColor(Color.MAGENTA);
//        RectF rectF4 = calcRectF(originalRectF, 45, offsetCenter);
        RectF rectF4 = new RectF(originalRectF);
        rectF4.offset(18, 7);
        Log.i("calcRectF", "rectF4-left:" + rectF4.left + ", right:" + rectF4.right +
                ", top:" + rectF4.top + ", bottom:" + rectF4.bottom);
        canvas.drawArc(rectF4, 20, 45, true, paint);

        paint.setColor(Color.LTGRAY);
//        RectF rectF5 = calcRectF(originalRectF, 115, offsetCenter);
        RectF rectF5 = new RectF(originalRectF);
        rectF5.offset(-10, 16);
        Log.i("calcRectF", "rectF4-left:" + rectF5.left + ", right:" + rectF5.right +
                ", top:" + rectF5.top + ", bottom:" + rectF5.bottom);
        canvas.drawArc(rectF5, 65, 115, true, paint);
    }

    private RectF calcRectF(RectF originalRectF, double angle, double offset) {
        RectF rectF = new RectF(originalRectF);
        double actAngle = Math.toRadians((360 - angle) / 2);
        float deltaX = new BigDecimal(offset).multiply(new BigDecimal(Math.cos(actAngle))).floatValue();
        float deltaY = new BigDecimal(offset).multiply(new BigDecimal(Math.sin(actAngle))).floatValue();
        rectF.offset(deltaX, deltaY);
        Log.i("calcRectF", "deltaX:" + deltaX + ", deltaY:" + deltaY);

        return rectF;
    }
}
