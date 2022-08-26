package com.yelemang.longmeidemo

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class FatherRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    var isNeedMove = true

    //外部拦截法
    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
        if(isNeedMove){
            return super.onInterceptTouchEvent(e)
        }else {
            if (e.action == MotionEvent.ACTION_MOVE) {
                return false
            }
        }
        return super.onInterceptTouchEvent(e)
    }

}