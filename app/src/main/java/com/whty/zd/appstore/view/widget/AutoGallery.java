package com.whty.zd.appstore.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: wangwei
 * @date: 2017/8/26 17:05
 * @desciption:
 */

public class AutoGallery extends Gallery implements View.OnTouchListener {

    //画廊图片数量
    private int length;
    //自动切换图片的时间
    private long delayMillis = 5000;
    //定时器
    private Timer mTimer = null;

    public AutoGallery(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public AutoGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public AutoGallery(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDelayMillis(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    /**
     * 重写gallery中手指滑动的手势方法
     *
     * @param e1
     * @param e2
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int kEvent;
        if (isScrollingLeft(e1, e2)) {
            kEvent = KeyEvent.KEYCODE_DPAD_LEFT;//设置手势滑动的方法--向左
        } else {
            kEvent = KeyEvent.KEYCODE_DPAD_RIGHT; //设置手势滑动的方法--向右
        }
        onKeyDown(kEvent, null);
        if (this.getSelectedItemPosition() == 0) {
            this.setSelection(length);
        }
        return false;
    }

    /**
     * 判断滑动方向
     *
     * @param e1
     * @param e2
     * @return
     */
    private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) {
        return e2.getX() > e1.getX();
    }

    /**
     * 重写手指触摸事件，当手指按下的时候，需要关闭gallery自动切换
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                stop();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:
                start();
                break;
        }
        return false;
    }

    /**
     * 关闭定时器
     */
    public void stop() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    /**
     * 开启定时器
     */
    public void start() {
        if (length > 0 && mTimer == null) {
            mTimer = new Timer();
            //进行每个delayMills时间gallery切换一张图片
            mTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (length > 0) {
                        //按向右键
                        onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
                    }
                }
            }, delayMillis, delayMillis);
        }
    }
}
