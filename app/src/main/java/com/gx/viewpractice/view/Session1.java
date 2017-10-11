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

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.GRAY);

        int itemW = screenWidth / 4;
        RectF originalRectF = new RectF(itemW, itemW, itemW * 3, itemW * 3);
        double offsetCenter = 20; // 新扇形偏离圆心距离

        Paint linePaint = new Paint(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(originalRectF, linePaint);

        float cx = screenWidth / 2;
        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);
        canvas.drawCircle(cx, cx, 20, circlePaint);

        RectF rectF = calcRectF(originalRectF, -180, 120, offsetCenter);
        canvas.drawArc(rectF, -180, 120, true, paint);
        linePaint.setColor(Color.RED);
        canvas.drawRect(rectF, linePaint);

        paint.setColor(Color.YELLOW);
        RectF rectF1 = calcRectF(originalRectF, -60, 55, offsetCenter);
        canvas.drawArc(rectF1, -60, 55, true, paint);
        linePaint.setColor(Color.YELLOW);
        canvas.drawRect(rectF1, linePaint);

        paint.setColor(Color.GREEN);
        RectF rectF2 = calcRectF(originalRectF, -5, 15, offsetCenter);
        canvas.drawArc(rectF2, -5, 15, true, paint);
        linePaint.setColor(Color.GREEN);
        canvas.drawRect(rectF2, linePaint);

        paint.setColor(Color.CYAN);
        RectF rectF3 = calcRectF(originalRectF, 10, 10, offsetCenter);
        canvas.drawArc(rectF3, 10, 10, true, paint);
        canvas.drawRect(rectF3, linePaint);

        paint.setColor(Color.MAGENTA);
        RectF rectF4 = calcRectF(originalRectF, 20, 45, offsetCenter);
        canvas.drawArc(rectF4, 20, 45, true, paint);
        linePaint.setColor(Color.MAGENTA);
        canvas.drawRect(rectF4, linePaint);

        paint.setColor(Color.LTGRAY);
        RectF rectF5 = calcRectF(originalRectF, 65, 115, offsetCenter);
        canvas.drawArc(rectF5, 65, 115, true, paint);
        linePaint.setColor(Color.LTGRAY);
        canvas.drawRect(rectF5, linePaint);

    }

    private RectF calcRectF(RectF originalRectF, double startAngle, double deltaAngle, double offset) {
        // actAngle = |deltaAngle| / 2 + actStartAngle

        double actAngle;
        double actStartAngle;
        if (startAngle < 0) {
            actStartAngle = -startAngle - deltaAngle;
            actAngle = actStartAngle + deltaAngle / 2;
        } else {
            actStartAngle = -startAngle;
            actAngle = actStartAngle - deltaAngle / 2;
        }

        RectF rectF = new RectF(originalRectF);
        double formatAngle = Math.toRadians(actAngle);
        float deltaX = (float) (offset * Math.cos(formatAngle));
        float deltaY = (float) (offset * Math.sin(formatAngle));

        rectF.offset(deltaX, -deltaY);

        return rectF;
    }
}
