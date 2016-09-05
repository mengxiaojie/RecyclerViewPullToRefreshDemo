package com.jingchen.pulltorefresh;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 适用于LinearLayoutManager
 */
public class PullAbleRecyclerView extends RecyclerView implements Pullable {
    private boolean isConsuption = false;

    public PullAbleRecyclerView(Context context) {
        super(context);
    }

    public PullAbleRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullAbleRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    private boolean isTOP() {
        LinearLayoutManager lm = (LinearLayoutManager) getLayoutManager();
        if(lm.getItemCount()==0){
            return  true;
        }
        if (lm.findViewByPosition(lm.findFirstVisibleItemPosition()).getTop()>=0&&lm.findFirstVisibleItemPosition() == 0) {
            return true;
        }
        return false;
    }

    private boolean isDown() {

        LinearLayoutManager lm = (LinearLayoutManager) getLayoutManager();
        if(lm.getItemCount()==0){
            return  false;
        }
        if (lm.findViewByPosition(lm.findLastVisibleItemPosition()).getBottom()<=getHeight()&&(lm.findFirstVisibleItemPosition() + getChildCount())>= getLayoutManager().getItemCount()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canPullDown() {
        if (isTOP()) {

            return true;
        }
        return false;
    }

    @Override
    public boolean canPullUp() {
        if (isDown()) {

            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (isConsuption) {
            return true;
        }
        return super.onTouchEvent(e);

    }
    public void setIsShield(boolean isShield){
        isConsuption=isShield;
    }
}
