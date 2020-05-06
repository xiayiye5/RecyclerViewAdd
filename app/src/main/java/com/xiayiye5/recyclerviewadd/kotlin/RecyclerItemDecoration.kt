package com.xiayiye5.recyclerviewadd.kotlin

import android.graphics.Rect
import android.view.View

import androidx.recyclerview.widget.RecyclerView

/**
 * @author DELL
 */
class RecyclerItemDecoration
/**
 * @param itemSpace item间隔
 * @param itemNum   每行item的个数
 */
    (private val itemSpace: Int, private val itemNum: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = itemSpace
        //parent.getChildLayoutPosition(view) 获取view的下标
        if (parent.getChildLayoutPosition(view) % itemNum == 0) {
            outRect.left = 0
        } else {
            outRect.left = itemSpace
        }

    }
}

