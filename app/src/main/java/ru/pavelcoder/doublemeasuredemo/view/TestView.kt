package ru.pavelcoder.doublemeasuredemo.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import java.lang.Exception

class TestView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var logger: ViewLogger? = null

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        logger?.log(CallType.LAYOUT)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        logger?.log(CallType.MEASURE)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        logger?.log(CallType.DRAW)
    }
}