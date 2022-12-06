package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
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
    private var intArray = GradientCreator.getStandart(context)

    private var path = Path()
    private val roundCorner = 50f
    private val offset = 50f

    private var paintRootPath = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        pathEffect = CornerPathEffect(roundCorner)
        setShadowLayer(25f, 15f, 15f, colorBlack)
    }

    private var paintTextTemperature = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = colorWhite
        textSize = 120f
        typeface = Typeface.create("Arial", Typeface.BOLD)
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

        paintRootPath.shader = LinearGradient(0f, 0f, 0f, height.toFloat(), intArray, null,
            Shader.TileMode.MIRROR
        )

        canvas?.drawPath(path, paintRootPath)
        canvas?.drawText("15°C", offset * 2, offset * 5, paintTextTemperature)
    }
}