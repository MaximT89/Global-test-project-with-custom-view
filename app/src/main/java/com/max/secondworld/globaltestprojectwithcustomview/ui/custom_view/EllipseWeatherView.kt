package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.max.secondworld.globaltestprojectwithcustomview.R
import kotlin.math.min

class EllipseWeatherView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var size = 400f
    private var strokeWidth = 10f
    private var colorWhite: Int = resources.getColor(R.color.white)
    private var colorBlack: Int = resources.getColor(R.color.black)

    private var textTemperature: Int = 0
    private var intArray = GradientCreator.getNormal(context)

    // paint для основного овала
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isAntiAlias = true
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = strokeWidth
    }

    // rect основного овала который будет залит градиентом
    private val rectF = RectF(0f + strokeWidth, 0f + strokeWidth, size / 2 - strokeWidth, size - strokeWidth)

    // paint для обводки овала
    private val paintBorderEllipse = Paint().apply {
        isAntiAlias = true
        shader = null
        xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        style = Paint.Style.STROKE
        color = colorBlack
        strokeWidth = 3f
    }

    // rect для овала который является обводкой
    private val rectF2 =
        RectF(0f + strokeWidth, 0f + strokeWidth, size / 2 - strokeWidth, size - strokeWidth)

    // измеряем текст
    private val textPaintBounds = Paint().apply {
        color = colorWhite
        textSize = 50f
        typeface = Typeface.create("Arial", Typeface.BOLD)
    }

    private val textBounds = Rect()

    // рисуем текст
    private val textPaint = Paint().apply{
        color = colorWhite
        textSize = 50f
        typeface = Typeface.create("Arial", Typeface.BOLD)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = min(measuredWidth, measuredHeight).toFloat()
        setMeasuredDimension(size.toInt() / 2, size.toInt())
    }

    fun textTemperature(temperature: Int) {
        textTemperature = temperature

        intArray = when(temperature) {
            in -1000..-30 -> GradientCreator.getColdMax(context)
            in -29..-10 -> GradientCreator.getCold(context)
            in -9..2 -> GradientCreator.getZero(context)
            in 3..10 -> GradientCreator.getNormal(context)
            in 11..25 -> GradientCreator.getWarm(context)
            in 26..1000 -> GradientCreator.getHot(context)
            else -> GradientCreator.getNormal(context)
        }

        invalidate()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = LinearGradient(0f, 0f, 0f, height.toFloat(), intArray, null,
            Shader.TileMode.MIRROR)

        canvas?.drawRoundRect(rectF, 200f, 200f, paint)
        canvas?.drawRoundRect(rectF2, 200f, 200f, paintBorderEllipse)

        textPaintBounds.getTextBounds("${textTemperature}°C", 0, "${textTemperature}°C".length, textBounds)

        val x: Float = rectF.left + rectF.width() / 2 - textBounds.exactCenterX()
        val y: Float = rectF.top + rectF.height() / 2 - textBounds.exactCenterY()

        canvas?.drawText("${textTemperature}°C", x, y, textPaint)
    }
}