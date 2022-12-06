package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.max.secondworld.globaltestprojectwithcustomview.R
import kotlin.math.min

class WeatherView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var size = 500f
    private var strokeWidth = 10f
    private var colorWhite: Int = resources.getColor(R.color.white)
    private var colorBlack: Int = resources.getColor(R.color.black)
    private var intArray = intArrayOf(
        ContextCompat.getColor(context, R.color.dodger_blue),
        ContextCompat.getColor(context, R.color.blue_violet),
        ContextCompat.getColor(context, R.color.dark_magenta)
    )

    private var path = Path()
    private val roundCorner = 50f
    private val offset = 50f

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isAntiAlias = true
        style = Paint.Style.FILL
        pathEffect = CornerPathEffect(roundCorner)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = min(measuredWidth, measuredHeight).toFloat()
        setMeasuredDimension((size * 1.2f).toInt(), size.toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        path = Path().apply {
            moveTo(offset, offset)
            lineTo(w.toFloat() - offset, h.toFloat() / 8 * 3)
            lineTo(w.toFloat() - offset, h.toFloat() - offset)
            lineTo(offset, h.toFloat() - offset)
        }
        path.close()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = LinearGradient(0f, 0f, 0f, height.toFloat(), intArray, null,
            Shader.TileMode.MIRROR
        )

        canvas?.drawPath(path, paint)
    }
}