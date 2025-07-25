// utils/GridSpacingItemDecoration.java
package com.example.pawtner.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int spanCount;
    private final int spacing;

    public GridSpacingItemDecoration(int spanCount, int spacing) {
        this.spanCount = spanCount;
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;
        int row = position / spanCount;
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) return;

        int totalRows = (int) Math.ceil((double) adapter.getItemCount() / spanCount);

        if (column > 0) outRect.left = spacing / 2;
        if (column < spanCount - 1) outRect.right = spacing / 2;
        if (row > 0) outRect.top = spacing / 2;
        if (row < totalRows - 1) outRect.bottom = spacing / 2;
    }
}
