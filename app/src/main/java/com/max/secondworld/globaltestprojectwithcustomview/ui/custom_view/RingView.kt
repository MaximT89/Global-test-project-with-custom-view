package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.max.secondworld.globaltestprojectwithcustomview.R
import kotlin.math.min

class RingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var size = 320f
    private var color : Int = resources.getColor(R.color.black)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = min(measuredWidth, measuredHeight).toFloat()
        setMeasuredDimension(size.toInt(), size.toInt())
    }

    fun setColorPath(newColor : Int) {
        color = newColor
        invalidate()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        paint.color = color
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 10f

        //test

        val path = Path()

        path.reset()

        path.moveTo(size / 2, 0f)
        path.lineTo(size / 8 * 5, size / 8 * 3)
        path.lineTo(size, size / 2)
        path.lineTo(size / 8 * 5 , size / 8 * 5)
        path.lineTo(size / 2 , size)
        path.lineTo(size / 8 * 3 , size / 8 * 5)
        path.lineTo(0f , size / 2)
        path.lineTo(size / 8 * 3 , size / 8 * 3)
        path.moveTo(size / 2, 0f)

        canvas?.drawPath(path, paint)

        super.onDraw(canvas)
    }

}