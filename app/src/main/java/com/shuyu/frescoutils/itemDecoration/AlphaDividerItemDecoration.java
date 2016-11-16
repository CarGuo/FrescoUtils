package com.shuyu.frescoutils.itemDecoration;


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 实现分割线
 */
public class AlphaDividerItemDecoration extends RecyclerView.ItemDecoration {

    public final static int GRID = 0;
    public final static int LIST = 1;

    private int direct = GRID;

    private int space;

    public AlphaDividerItemDecoration(int space) {
        this.space = space;
    }

    public AlphaDividerItemDecoration(int space, int direct) {
        this.space = space;
        this.direct = direct;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (direct == GRID) {
            outRect.left = space;
            outRect.bottom = space * 2;
            outRect.right = space;
            if (parent.getChildAdapterPosition(view) == 0 || parent.getChildAdapterPosition(view) == 1) {
                outRect.top = space;
            }
        } else {
            outRect.left = space;
            outRect.bottom = space * 2;
            outRect.right = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }
}