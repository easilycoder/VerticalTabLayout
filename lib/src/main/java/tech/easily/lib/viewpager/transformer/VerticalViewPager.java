package tech.easily.lib.viewpager.transformer;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 基于{@link ViewPager.PageTransformer}实现的垂直切换的viewpager
 * <p>
 * 值得注意的是：这种实现方案会与recyclerview等垂直滑动的控件产生滑动冲突。
 * 尝试过自定义recyclerview，并判断当recyclerview处于边缘的时候把触摸事件交给Viewpager，但是效果不理想
 * <p>
 * Created by lemon on 07/01/2018.
 */

public class VerticalViewPager extends ViewPager {


    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new VerticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class VerticalPageTransformer implements ViewPager.PageTransformer {

        private float yPosition;

        @Override
        public void transformPage(View view, float position) {
            view.setTranslationX(view.getWidth() * -position);
            yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);
        }
    }


    private MotionEvent swapXY(MotionEvent ev) {
        // 这里更换xy坐标值，并没有使用原来的事件对象，避免事件回传给外部的时候出错
        MotionEvent newEvent = MotionEvent.obtain(ev);
        float width = getWidth();
        float height = getHeight();
        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;
        newEvent.setLocation(newX, newY);
        return newEvent;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }

}
