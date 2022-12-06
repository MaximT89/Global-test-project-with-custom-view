package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.max.secondworld.globaltestprojectwithcustomview.R
import kotlin.math.min

class RectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var size = 500f
    private var strokeWidth = 10f
    private var colorWhite: Int = resources.getColor(R.color.white)
    private var colorBlack: Int = resources.getColor(R.color.black)

    private var textTemperature: Int = 0
    private var intArray = intArrayOf(
        ContextCompat.getColor(context, R.color.dodger_blue),
        ContextCompat.getColor(context, R.color.blue_violet),
        ContextCompat.getColor(context, R.color.dark_magenta)
    )

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

        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = LinearGradient(
                0f,
                0f,
                0f,
                height.toFloat(),
                intArray,
                null,

                Shader.TileMode.MIRROR
            )
            isAntiAlias = true
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = strokeWidth
        }

        val rectF =
            RectF(0f + strokeWidth, 0f + strokeWidth, size / 2 - strokeWidth, size - strokeWidth)
        canvas?.drawRoundRect(rectF, 200f, 200f, paint)

        paint.apply {
            isAntiAlias = true
            shader = null
            xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
            style = Paint.Style.STROKE
            color = colorBlack
            strokeWidth = 3f
        }

        val rectF2 =
            RectF(0f + strokeWidth, 0f + strokeWidth, size / 2 - strokeWidth, size - strokeWidth)
        canvas?.drawRoundRect(rectF2, 200f, 200f, paint)


        // измеряем текст
        paint.apply {
            color = colorWhite
            textSize = 50f
            typeface = Typeface.create("Arial", Typeface.BOLD)
        }
        val textBounds = Rect()
        paint.getTextBounds("${textTemperature}°C", 0, "${textTemperature}°C".length, textBounds)

        val x: Float = rectF.left + rectF.width() / 2 - textBounds.exactCenterX()
        val y: Float = rectF.top + rectF.height() / 2 - textBounds.exactCenterY()

        // рисуем текст
        val textPaint = Paint()
        textPaint.color = colorWhite
        textPaint.textSize = 50f
        textPaint.typeface = Typeface.create("Arial", Typeface.BOLD)

        canvas!!.drawText("${textTemperature}°C", x, y, textPaint)
    }
}