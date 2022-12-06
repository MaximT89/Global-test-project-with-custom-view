package com.max.secondworld.globaltestprojectwithcustomview.ui.custom_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.max.secondworld.globaltestprojectwithcustomview.R
import kotlin.math.min

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr
) {

    var size = 320f
    var strokeWidth = 10f
    private var colorBlack: Int = context.resources.getColor(R.color.black)
    private var colorWhite: Int = resources.getColor(R.color.white)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = min(measuredWidth, measuredHeight).toFloat()
        setMeasuredDimension(size.toInt(), size.toInt())
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paintCircleOne = Paint(Paint.ANTI_ALIAS_FLAG).apply {

            // таким образом можно добавить градиент
            shader = LinearGradient(
                0f,
                0f,
                0f,
                height.toFloat(),
                resources.getColor(R.color.dodger_blue),
                resources.getColor(R.color.blue_violet),
                Shader.TileMode.MIRROR
            )

            // цвет кисти
            color = colorBlack

            // сглаживание
            isAntiAlias = true

            // стиль кисти FILL заполнение, STROKE черта
            style = Paint.Style.FILL

            // толщина кисти
            strokeWidth = strokeWidth
        }

        canvas?.drawCircle(size / 2, size / 2, width / 2f - strokeWidth / 2, paintCircleOne)

        val paintCircleTwo = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = colorWhite // цвет кисти
            isAntiAlias = true // сглаживание
            style = Paint.Style.FILL // стиль кисти FILL заполнение, STROKE черта
            strokeWidth = strokeWidth
        }

        canvas?.drawCircle(size, size, width / 2f - strokeWidth / 2, paintCircleTwo)


    }

}