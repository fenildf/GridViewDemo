package yinlei.mygridview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

import yinlei.mygridview.R;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MyGridView extends GridView {
    /**
     * 自定义属性三种方法
     *
     * @param context
     */
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private Bitmap background;

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        background = BitmapFactory.decodeResource(getResources(),
                R.mipmap.img_book_shelf_background_test);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        // 行高
        int height = getChildAt(0) != null ? getChildAt(0).getHeight() : 0;
        int width = getWidth();
        int rowNum = (int) Math.ceil(getChildCount() / (double) 3);
        // 源绘制矩形
        Rect src = new Rect(0, 0, background.getWidth(), background.getHeight());
        for (int i = 0, y = 0; i < rowNum; i++, y += height) {
            // 目的绘制矩形
            Rect dst = new Rect(0, y, width, y + height);
            canvas.drawBitmap(background, src, dst, null);
        }
        super.dispatchDraw(canvas);
    }

    // 禁止Gridview进行滑动
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 重新测量绘制
     */
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}