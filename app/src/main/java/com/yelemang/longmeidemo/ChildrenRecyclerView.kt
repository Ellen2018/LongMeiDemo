package com.yelemang.longmeidemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class ChildrenRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    private var fatherRecyclerView:FatherRecyclerView? = null

    override fun dispatchTouchEvent(e: MotionEvent): Boolean {
        if(e.action == MotionEvent.ACTION_DOWN){
            //需要move
            isFatherNeedMove(true)
        }
        if(e.action == MotionEvent.ACTION_UP){
            //不需要move
            isFatherNeedMove(false)
        }
        if(e.action == MotionEvent.ACTION_CANCEL){
            //不需要move
            isFatherNeedMove(false)
        }
        return super.dispatchTouchEvent(e)
    }

    private fun isFatherNeedMove(isNeedMove: Boolean){
        if(fatherRecyclerView == null) {
            var view = parent
            while (view !is FatherRecyclerView) {
                view = view.parent
            }
            fatherRecyclerView = view
        }
        fatherRecyclerView?.isNeedMove = !isNeedMove
    }
}